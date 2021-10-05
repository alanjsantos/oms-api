package com.omsapi.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class HasUtil {

    public static String getSecureHash(String text) {
        String hash = DigestUtils.sha256Hex(text);

        return hash;
    }
}
