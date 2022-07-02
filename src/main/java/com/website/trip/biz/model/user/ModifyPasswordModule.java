package com.website.trip.biz.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModifyPasswordModule {

    private String loginId;
    private String email;
    private String password;
    private String grade;
    private String loginType;

}
