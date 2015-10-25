package com.qunar.coach.machine.service.utils;

/**
 * Created by zhangyunfan on 15-3-24.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SystemUtils {

    private static final Logger LOG = LoggerFactory
        .getLogger(SystemUtils.class);

    private static String host = null;

    public static String getHostName() {
        if (host != null) {
            return host;
        }

        try {
            InetAddress ia = InetAddress.getLocalHost();
            host = ia.getHostName();
        } catch (UnknownHostException e) {
            LOG.warn("Cannot get hostname from InetAddress.getLocalHost()", e);
        }

        return host;
    }
}
