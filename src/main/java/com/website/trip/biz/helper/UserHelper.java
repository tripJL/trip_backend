package com.website.trip.biz.helper;

import com.website.trip.biz.dto.User;
import com.website.trip.biz.model.user.input.UserModifyPasswordInput;
import com.website.trip.biz.model.user.input.UserInput;

public class UserHelper {

    public static User toDto(UserInput model) {

        return User.builder()
                .loginId(model.getLoginId())
                .email(model.getEmail())
                .password(model.getPassword())
                .grade(model.getGrade())
                .loginType(model.getLoginType())
                .build();
    }

    public static User toDto(UserModifyPasswordInput model) {

        return User.builder()
                .loginId(model.getLoginId())
                .email(model.getEmail())
                .password(model.getPassword())
                .grade(model.getGrade())
                .loginType(model.getLoginType())
                .build();
    }
}
