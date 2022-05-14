package com.website.trip.common.util;

import java.util.Calendar;

public class DateUtil {

    public static String getNowYear() {
        final Calendar now = Calendar.getInstance();
        return String.format("%d",now.get(Calendar.YEAR));
    }

    public static String getNowMonth() {
        final Calendar now = Calendar.getInstance();
        return String.format("%02d",now.get(Calendar.MONTH + 1));
    }
}
