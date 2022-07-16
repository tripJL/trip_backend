package com.website.trip.biz.model.user.input;

import com.website.trip.biz.dto.User;
import com.website.trip.common.model.Verification;
import com.website.trip.common.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInput {

    private long id;
    private String loginId;
    private String email;
    private String nickName;
    private String password;
    private String grade;
    private String loginType;

    public Verification isValidationCreate() {

        if (StringUtil.isEmpty(loginId)) {
            return Verification.fail(" 로그인 아이디를 입력해주세요. ");
        }

        if (StringUtil.isEmpty(email)) {
            return Verification.fail(" 이메일을 입력해주세요. ");
        }

        if (StringUtil.isEmpty(nickName)) {
            return Verification.fail(" 닉네임을 입력해주세요. ");
        }

        if (StringUtil.isEmpty(password)) {
            return Verification.fail(" 비밀번호를 입력해주세요. ");
        }

        return Verification.success();
    }

    public Verification isVerificationModify() {

        if (StringUtil.isEmpty(nickName)) {
            return Verification.fail(" 닉네임을 입력해주세요. ");
        }

        return Verification.success();
    }

    public Verification isVerificationModifyPassword() {

        if (StringUtil.isEmpty(password)) {
            return Verification.fail(" 비밀번호를 입력해주세요. ");
        }

        return Verification.success();
    }

    public static User toDto(UserInput input) {
        User dto = new User();
        BeanUtils.copyProperties(input, dto);
        return dto;
    }


}
