package com.qunar.coach.machine.service.utils;
/*
 * (C) 2007-2012 Alibaba Group Holding Limited. Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

/* Copyright 2010-2011 Twitter, Inc. */

/**
 * @see https://github.com/twitter/snowflake
 * @author boyan
 * @Date 2011-4-27
 */
public class IdWorker {
    private final long workerId;

    private final static long twepoch = 1288834974657L;

    private long sequence = 0L;

    private final static long workerIdBits = 3L;

    private final static long maxWorkerId = -1L ^ (-1L << workerIdBits);

    private final static long sequenceBits = 12L;

    private final static long workerIdShift = sequenceBits;

    private final static long timestampLeftShift = sequenceBits + workerIdBits;

    private final static long sequenceMask = -1L ^ (-1L << sequenceBits);

    private final static String WANDOUJIA_COM_SUFFIX = ".wandoujia.com";

    private long lastTimestamp = -1L;

    public static long timestampFromId(long id) {
        return (id >> timestampLeftShift) + twepoch;
    }

    public static long idOfTimeMillis(long timeMillis) {
        return timeMillis - twepoch << timestampLeftShift;
    }

    private Long getWorkerId(String hostname, String workerIdsConfig) {
        Long workerId = null;
        for (String kv: workerIdsConfig.split(",")) {
            String[] kvarr = kv.split("=", 2);
            if (kvarr.length != 2) {
                continue;
            }
            String key = kvarr[0];
            String value = kvarr[1];
            if (key.equals(hostname)) {
                workerId = Long.parseLong(value);
                break;
            }
        }
        return workerId;
    }

    public IdWorker(String workerIdsConfig) {
        String hostname = SystemUtils.getHostName();
        if (hostname == null) {
            throw new RuntimeException("Cannot get the hostname.");
        }

        if (hostname.endsWith(WANDOUJIA_COM_SUFFIX)) {
            hostname = hostname.substring(0, hostname.length()- WANDOUJIA_COM_SUFFIX.length());
        }

        Long workerId = getWorkerId(hostname, workerIdsConfig);

        if (workerId == null) {
            throw new RuntimeException("snowflake worker id not found for hostname " + hostname);
        }

        if (workerId > IdWorker.maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format(
                "worker Id can't be greater than %d or less than 0",
                IdWorker.maxWorkerId));
        }
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        while (timestamp < this.lastTimestamp) {
            try {
                Thread.sleep(this.lastTimestamp - timestamp);
            } catch (InterruptedException e) {
                // again
            }
            timestamp = this.timeGen();
        }
        if (this.lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1 & IdWorker.sequenceMask;
            if (this.sequence == 0) {
                timestamp = this.tilNextMillis(this.lastTimestamp);
            }
        } else {
            this.sequence = 0;
        }

        this.lastTimestamp = timestamp;
        return IdWorker.idOfTimeMillis(timestamp)
            | this.workerId << IdWorker.workerIdShift | this.sequence;
    }

    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

}
