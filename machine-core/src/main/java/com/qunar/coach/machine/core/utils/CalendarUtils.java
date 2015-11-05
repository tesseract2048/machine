package com.qunar.coach.machine.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CalendarUtils {
    public static final String FORMAT_STD_DATETIME = "yyyy-MM-dd HH:mm:ss";
    private final static Logger logger = LoggerFactory
            .getLogger(CalendarUtils.class);
    public static SimpleDateFormat sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat dateFormat = new SimpleDateFormat(
            "yyyy-MM-dd");

    /**
     * @param startDate
     *            , if null would use today default
     * @param addDays
     *            , add days to the start date
     * @param outFormat
     *            , format for output
     * @return String
     */
    public static String getDate(String startDate, int addDays, String outFormat) {
        String time = null;
        Calendar calendar = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat(outFormat);
        Date date = null;

        if (!StringUtils.isBlank(startDate)) {
            try {
                date = df.parse(startDate);
                calendar.setTime(date);
            } catch (ParseException e) {
                logger.error("ParseException##getDate", e);
            }
        }

        // Subtract add days
        calendar.add(Calendar.DATE, addDays);
        date = calendar.getTime();
        time = df.format(date);
        return time;
    }

    /**
     * get standard datetime string
     *
     * @param seconds long
     * @return String
     */
    public static String getDate(long seconds) {
        return getDate(seconds, FORMAT_STD_DATETIME);
    }

    /**
     * get date string by outFormat
     *
     * @param seconds long
     * @param outFormat String
     * @return String
     */
    public static String getDate(long seconds, String outFormat) {
        Date date = new Date(seconds * 1000);
        DateFormat df = new SimpleDateFormat(outFormat);
        return df.format(date);
    }

    public static Date getDate(Date startDate, int addDays) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        // Subtract add days
        calendar.add(Calendar.DATE, addDays);
        return calendar.getTime();
    }

    public static Date getYesterday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return DateUtils.truncate(calendar.getTime(), Calendar.DATE);
    }

    public static int getThisYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * @param days int
     * @return Date
     */
    public static Date getNDaysAgo(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, days);
        return DateUtils.truncate(calendar.getTime(), Calendar.DATE);
    }

    public static Date getTomorrow() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return DateUtils.truncate(calendar.getTime(), Calendar.DATE);
    }

    public static String getTodayDate(String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        Date date = new Date();
        return sf.format(date);
    }

    public static String getYesterdayDate(String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        Date date = new Date();
        date.setTime(date.getTime() - 86400 * 1000);
        return sf.format(date);
    }

    public static String getTomorrowDate(String format) {
        SimpleDateFormat sf = new SimpleDateFormat(format);
        Date date = new Date();
        date.setTime(date.getTime() + 86400 * 1000);
        return sf.format(date);
    }
}