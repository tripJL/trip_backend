package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseDto {

    private String loginId;
    private String email;
    private String password;
    private String grade;
    private String loginType;

}
