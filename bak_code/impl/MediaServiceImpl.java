package com.wandoujia.baobab.service.common.impl;

import com.wandoujia.baobab.bean.VideoBean;
import com.wandoujia.baobab.model.*;
import com.wandoujia.baobab.service.common.MediaService;
import com.wandoujia.baobab.service.common.PlayInfoService;
import com.wandoujia.baobab.service.common.Upload2CdnService;
import com.wandoujia.baobab.service.common.VideoService;
import com.wandoujia.baobab.service.utils.FileDownloadUtils;
import com.wandoujia.baobab.service.utils.ShellUtil;
import com.wandoujia.baobab.service.utils.VideoUtils;
import com.wandoujia.commons.lang.SerializationUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author haoli <lihao@wandoujia.com>
 */
@Service
public class MediaServiceImpl implements MediaService {

    private static final Logger LOG = LoggerFactory.getLogger(MediaServiceImpl.class);

    private static final String INFO_COMMAND = "%s -print_format json -show_format -show_streams \"%s\"";
    private static final String CONVERT_COMMAND = "%s -i \"%s\" -s %sx%s -strict -2 \"%s\"";

    private static final String FORMAT = "format";
    private static final String STREAMS = "streams";
    private static final String SIZE = "size";
    private static final String BIT_RATE = "bit_rate";
    private static final String DURATION = "duration";
    private static final String FORMAT_NAME = "format_name";
    private static final String CODEC_NAME = "codec_name";
    private static final String CODEC_TYPE = "codec_type";
    public static final String HEIGHT = "height";
    public static final String WIDTH = "width";

    private static final int TIMEOUT = 30 * 60 * 1000;

    @Resource
    private String ffmpegCommand;

    @Resource
    private String ffprobeCommand;

    @Autowired
    private Upload2CdnService upload2CdnService;

    @Autowired
    private PlayInfoService playInfoService;

    @Autowired
    private VideoService videoService;

    @Override
    public MediaInfo getInfo(String filePath) {
        String command = String.format(INFO_COMMAND, ffprobeCommand, filePath);
        String output;
        try {
            output = ShellUtil.executeShell(command, ShellUtil.NO_TIMEOUT);
        } catch (IOException e) {
            LOG.error("", e);
            return null;
        }
        LOG.info("output={}", output);

        Map<String, Object> info = null;
        try {
            info = SerializationUtils.fromJson(output, Map.class);
        } catch (IOException e) {
            LOG.error("serialize json failed", e);
        }
        if (info == null) {
            return null;
        }

        MediaInfo mediaInfo = new MediaInfo();
        Map<String, Object> format = MapUtils.getMap(info, FORMAT);
        List<Map<String, Object>> streams = (List<Map<String, Object>>) info.get(STREAMS);
        if (format == null || streams == null) {
            return null;
        }
        mediaInfo.setSize(MapUtils.getLong(format, SIZE, 0L));
        mediaInfo.setBitRate(MapUtils.getLong(format, BIT_RATE, 0L));
        mediaInfo.setDuration(MapUtils.getDouble(format, DURATION, 0.0));
        mediaInfo.setFormat(MapUtils.getString(format, FORMAT_NAME, StringUtils.EMPTY));

        List<MediaInfo.StreamInfo> streamInfoList = new ArrayList<>();
        for (Map<String, Object> stream : streams) {
            MediaInfo.StreamInfo streamInfo = new MediaInfo.StreamInfo();

            streamInfo.setName(MapUtils.getString(stream, CODEC_NAME, StringUtils.EMPTY));
            streamInfo.setType(MediaInfo.CodecType.valueOf(MapUtils.getString(stream, CODEC_TYPE).toUpperCase()));
            if (streamInfo.getType() == MediaInfo.CodecType.VIDEO) {
                streamInfo.setHeight(MapUtils.getInteger(stream, HEIGHT, 0));
                streamInfo.setWidth(MapUtils.getInteger(stream, WIDTH, 0));
            }
            streamInfo.setBitRate(MapUtils.getLong(stream, BIT_RATE, 0L));
            streamInfo.setDuration(MapUtils.getDouble(format, DURATION, 0.0));

            streamInfoList.add(streamInfo);
        }
        mediaInfo.setStreams(streamInfoList);
        return mediaInfo;
    }

    @Override
    public VideoInfo getVideoInfo(String filePath) {
        MediaInfo mediaInfo = getInfo(filePath);
        if (mediaInfo == null) {
            return null;
        }
        List<MediaInfo.StreamInfo> streams = mediaInfo.getStreams();
        if (CollectionUtils.isEmpty(streams)) {
            return null;
        }

        for (MediaInfo.StreamInfo stream : streams) {
            if (stream.getType() == MediaInfo.CodecType.VIDEO) {
                VideoInfo videoInfo = new VideoInfo();
                videoInfo.setHeight((int) stream.getHeight());
                videoInfo.setWidth((int) stream.getWidth());
                videoInfo.setDuration((int) stream.getDuration());

                videoInfo.setBitRate(mediaInfo.getBitRate());

                return videoInfo;
            }
        }
        return null;
    }

    @Override
    public VideoInfo getVideoInfo(int videoId) {
        VideoBean videoBean = videoService.getVideoBean(videoId);
        File video = downloadVideo(videoId, videoBean.getPlayUrl());
        if (video == null) {
            LOG.warn("download video failed");
            return null;
        }

        VideoInfo videoInfo = getVideoInfo(video.getAbsolutePath());

        FileUtils.deleteQuietly(video);

        return videoInfo;
    }

    @Override
    public boolean compress(VideoEdition rawEdition, EditionType compressTo) {
        LOG.info("[compress] rawEdition={}, compressTo={}", rawEdition, compressTo);

        if (rawEdition == null) {
            LOG.warn("rawEdition is null");
            return false;
        }
        if (StringUtils.isEmpty(rawEdition.getPlayUrl())) {
            LOG.warn("play url is empty");
            return false;
        }

        // download raw video
        File rawVideo = downloadVideo(rawEdition.getVideoId(), rawEdition.getPlayUrl());
        if (rawEdition == null) {
            LOG.warn("download video failed");
            return false;
        }

        // compress and upload new video to cdn
        VideoInfo newVideo = convertAndUpload2Cdn(rawVideo, compressTo);
        if (newVideo == null) {
            return false;
        }
        LOG.info("newVideo={}", newVideo);

        VideoEdition newEdition = generateVideoEdition(rawEdition, newVideo, compressTo);
        return playInfoService.upsert(newEdition);
    }

    @Override
    public boolean compress(int videoId, boolean force) {
        LOG.info("[compress] videoId={}, force={}", videoId, force);

        VideoEdition highEdition = playInfoService.get(videoId, EditionType.HIGH);
        if (highEdition == null) {
            LOG.warn("no high edition, do not need to compress");
            return true;
        }

        VideoEdition normalEdition = playInfoService.get(videoId, EditionType.NORMAL);
        if (normalEdition != null && !force) {
            LOG.info("normal edition exists, do not need to compress");
            return true;
        }

        boolean success = compress(highEdition, EditionType.NORMAL);
        if (!success) {
            LOG.warn("compress failed");
            return false;
        }

        return true;
    }

    // compress to width * height, bitRate is not used
    private File convert(String videoFilePath, long bitRate, int height, int width) throws IOException {
        String outputFilePath = generateOutputFilePath(videoFilePath, height, width);
        String command = String.format(CONVERT_COMMAND, ffmpegCommand, videoFilePath, width, height, outputFilePath);

        ShellUtil.executeShell(command, TIMEOUT);

        return new File(outputFilePath);
    }

    private VideoInfo convertAndUpload2Cdn(File rawVideo, EditionType compressTo) {
        File newVideo = null;
        try {
            // compress video
            VideoInfo target = VideoUtils.map(compressTo);
            newVideo = convert(rawVideo.getAbsolutePath(), target.getBitRate(), target.getHeight(), target.getWidth());

            // extract info of new video
            VideoInfo videoInfo = getVideoInfo(newVideo.getAbsolutePath());

            // upload new video to cdn
            VideoDataInfo videoDataInfo = upload2CdnService.uploadLocalFile2Cdn(newVideo.getAbsolutePath());
            if (videoDataInfo == null || StringUtils.isEmpty(videoDataInfo.getVideoUrl())) {
                LOG.warn("upload to cdn failed");
            }
            videoInfo.setPlayUrl(videoDataInfo.getVideoUrl());

            return videoInfo;
        } catch (IOException e) {
            LOG.warn("compress video failed", e);
            return null;
        } finally {
            FileUtils.deleteQuietly(rawVideo);
            FileUtils.deleteQuietly(newVideo);
        }
    }

    private VideoEdition generateVideoEdition(VideoEdition edition, VideoInfo newVideo, EditionType compressTo) {
        VideoEdition newEdition = new VideoEdition();
        newEdition.setVideoId(edition.getVideoId());
        newEdition.setPlayUrl(newVideo.getPlayUrl());
        newEdition.setType(compressTo);
        newEdition.setDuration(newVideo.getDuration());
        newEdition.setBitRate((int) newVideo.getBitRate());
        newEdition.setDimension(VideoUtils.generateDimension(newVideo.getHeight(), newVideo.getWidth()));

        return newEdition;
    }

    private File downloadVideo(int videoId, String url) {
        LOG.info("[downloadVideo] videoId={}, url={}", videoId, url);

        File file = new File(generatePath(videoId));
        DownloadStatus status = FileDownloadUtils.downloadFile(url, file);

        if (status != DownloadStatus.SUCCESS) {
            return null;
        }

        return file;
    }

    private String generatePath(int videoId) {
        return String.format("%s%s_%s.mp4", upload2CdnService.getTmpDir(), System.currentTimeMillis(), videoId);
    }

    private String generateOutputFilePath(String filePath, int height, int width) {
        return String.format("%s_%s.%s",
                FilenameUtils.removeExtension(filePath),
                VideoUtils.generateDimension(height, width),
                FilenameUtils.getExtension(filePath));
    }
}
