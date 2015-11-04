package com.qunar.coach.machine.core.utils;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by niuli on 15-11-3.
 */
public class Md5Util {
    public static String md5(String params) {
        byte[] md5bytes;
        try {
            md5bytes = MessageDigest.getInstance("MD5").digest(
                    params.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Huh, MD5 should be supported?", e);
        } catch (UnsupportedEncodingException e1) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e1);
        }
        StringBuilder builder = new StringBuilder(2 * md5bytes.length);
        int j = 0;
        while (true) {
            int k = md5bytes[j];
            if ((k & 0xFF) < 16)
                builder.append("0");
            builder.append(Integer.toHexString(k & 0xFF));
            j++;
            if (j >= md5bytes.length)
                return builder.toString();
        }
    }
}