package com.website.trip.common.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtil {

    public static Map<String, Object> setMap(String key1, Object value1, String key2, Object value2, String key3, Object value3) {

        Map<String, Object> maps = new HashMap<>();

        maps.put(key1, value1);
        maps.put(key2, value2);
        maps.put(key3, value3);

        return maps;
    }


    public static Map<String, Object> setMap(String key1, Object value1, String key2, Object value2) {

        Map<String, Object> maps = new HashMap<>();

        maps.put(key1, value1);
        maps.put(key2, value2);

        return maps;
    }

    public static Map<String, Object> setMapList(Object value1, Object value2) {
        Map<String, Object> maps = new HashMap<>();

        maps.put("list", value1);
        maps.put("totalCount", value2);

        return maps;
    }

}
