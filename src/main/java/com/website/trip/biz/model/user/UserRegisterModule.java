package com.website.trip.biz.model.user;

import com.website.trip.biz.dto.User;
import com.website.trip.common.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterModule {

    private String loginId;
    private String email;
    private String password;
    private String grade;
    private String loginType;

    public boolean isValidationCreate() {

        if (StringUtil.isEmpty(loginId)) {
            return false;
        }

        if (StringUtil.isEmpty(email)) {
            return false;
        }

        if (StringUtil.isEmpty(password)) {
            return false;
        }

        return true;
    }

    public static User toDto(UserRegisterModule model) {
        User dto = new User();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }
}
