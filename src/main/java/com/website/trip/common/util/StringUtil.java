package com.website.trip.common.util;

public class StringUtil {

    public static final String NULL = null;
    public static final String EMPTY = "";

    public static boolean isEmpty(Object obj) {
        return org.springframework.util.StringUtils.isEmpty(obj);
    }

    public static boolean isEmpty(String obj) {
        return org.springframework.util.StringUtils.isEmpty(obj);
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static boolean isNotEmpty(String obj) {
        return !isEmpty(obj);
    }

}
