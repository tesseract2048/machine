package com.qunar.coach.machine.core.utils;

import java.util.Date;

/**
 * Created by niuli on 11/4/15.
 */
public class DeviceIdProducer {
    public static String produceDeviceId(String station, String city, String province, int sequenceNumber){
        try {
            String key = station + city + province + sequenceNumber;
            return Md5Util.md5(key);
        }
        catch (RuntimeException e) {
            return null;
        }
    }

    public static String produceDeviceId(String station, String city, String provice, Date dateT){
        return null;
    }

}
