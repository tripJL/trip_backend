package com.website.trip.biz.code;

import com.website.trip.common.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum UserLoginCode {

    LOCAL("local", "사이트"),
    GOOGLE("google", "구글"),
    NAVER("naver", "네이버"),
    FACEBOOK("facebook", "페이스북"),
    KAKAO("kakao", "카카오");

    private final String code;
    private final String value;

    public static Map<String, UserLoginCode> USER_CODE_MAP = new HashMap<>();


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
            UserLoginCode userCode = USER_CODE_MAP.get(key);

            if (value.equals(userCode.getValue())) {
                return key;
            }
        }
        return value;
    }

}
