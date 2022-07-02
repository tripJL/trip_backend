package com.website.trip.biz.helper;

import com.website.trip.biz.dto.User;
import com.website.trip.biz.model.user.ModifyPasswordModule;
import com.website.trip.biz.model.user.UserRegisterModule;

public class UserHelper {

    public static User toDto(UserRegisterModule model) {

        return User.builder()
                .loginId(model.getLoginId())
                .email(model.getEmail())
                .password(model.getPassword())
                .grade(model.getGrade())
                .loginType(model.getLoginType())
                .build();
    }

    public static User toDto(ModifyPasswordModule model) {

        return User.builder()
                .loginId(model.getLoginId())
                .email(model.getEmail())
                .password(model.getPassword())
                .grade(model.getGrade())
                .loginType(model.getLoginType())
                .build();
    }
}
