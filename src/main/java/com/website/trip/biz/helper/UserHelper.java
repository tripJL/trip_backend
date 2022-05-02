package com.website.trip.biz.helper;

import com.website.trip.biz.dto.UserDto;
import com.website.trip.biz.model.input.user.ModifyPasswordModule;
import com.website.trip.biz.model.input.user.RegisterModule;

public class UserHelper {

    public static UserDto toDto(RegisterModule model) {

        return UserDto.builder()
                .loginId(model.getLoginId())
                .email(model.getEmail())
                .password(model.getPassword())
                .grade(model.getGrade())
                .loginType(model.getLoginType())
                .build();
    }

    public static UserDto toDto(ModifyPasswordModule model) {

        return UserDto.builder()
                .loginId(model.getLoginId())
                .email(model.getEmail())
                .password(model.getPassword())
                .grade(model.getGrade())
                .loginType(model.getLoginType())
                .build();
    }
}
