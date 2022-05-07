package com.website.trip.biz.code;

import com.website.trip.common.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum UserCode {

    USER("user", "일반사용자"),
    ADMIN("admin", "관리자");

    private final String code;
    private final String value;

    public static Map<String, UserCode> USER_CODE_MAP = new HashMap<>();


    public static String getValueOfCode(String code) {
        if (StringUtil.isEmpty(code)) {
            return StringUtil.EMPTY;
        }

        try {
            return USER_CODE_MAP.get(code).getValue();
        } catch (NullPointerException e) {
            return code;
        }
    }

    public static String getCodeOfValue(String value) {
        if (value == null) {
            return StringUtil.NULL;
        }

        for (String key : USER_CODE_MAP.keySet()) {
            UserCode userCode = USER_CODE_MAP.get(key);

            if (value.equals(userCode.getValue())) {
                return key;
            }
        }
        return value;
    }

}
