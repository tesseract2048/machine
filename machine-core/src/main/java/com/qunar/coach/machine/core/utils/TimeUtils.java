package com.qunar.coach.machine.core.utils;

import java.util.Date;
import org.slf4j.Logger;

/**
 * Created by niuli on 11/5/15.
 */
public class TimeUtils {
    public static final long SECONDE = 1000;

    public static final long MINUTE = 60 * SECONDE;

    public static final long HOUR = 60 * MINUTE;

    public static final long DAY = 24 * HOUR;

    public static final long WEEK = 7 * DAY;

    public static final long MOUNTH = 30 * DAY;

    public static final long YEAR = 365 * DAY;

    public static final int MINUTE_IN_SECONDS = 60;

    public static final int FIVE_MINUTE_IN_SECONDS = 300;

    public static final int TEN_MINUTE_IN_SECONDS = 600;

    public static final int HALF_HOUR_IN_SECONDS = 1800;

    public static final int HOUR_IN_SECONDS = 3600;

    public static final int DAY_IN_SECONDS = HOUR_IN_SECONDS * 24;

    public static final int YEAR_IN_SECONDS = DAY_IN_SECONDS * 365;

    public static final long getTimeStampBeforeNDays(int days) {
        long now = System.currentTimeMillis();
        return now - days * DAY;
    }

    public static final int getDaysFromNow(Date date) {
        long now = System.currentTimeMillis();
        if (date == null) {
            return 0;
        }
        return (int) ((now - date.getTime()) / DAY);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {}
    }

    public static long reportTime(long begin, String msg, Logger LOG) {
        long end = System.currentTimeMillis();
        LOG.info(String.format("[Thread=%d] : %s used %dms", Thread
                .currentThread().getId(), msg, (end - begin)));
        return end;
    }

    public static long reportTime(long begin, String msg, Logger LOG,
                                  String extra) {
        long end = System.currentTimeMillis();
        LOG.info(String.format("[Thread=%d] : %s used %dms, [%s]", Thread
                .currentThread().getId(), msg, (end - begin), extra));
        return end;
    }

    public static long currentTimeMinutes() {
        long now = System.currentTimeMillis();
        return now / (1000 * 60);
    }


}