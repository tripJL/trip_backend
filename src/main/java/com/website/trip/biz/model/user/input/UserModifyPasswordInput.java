package com.website.trip.biz.model.user.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModifyPasswordInput {

    private String loginId;
    private String email;
    private String password;
    private String grade;
    private String loginType;

}
