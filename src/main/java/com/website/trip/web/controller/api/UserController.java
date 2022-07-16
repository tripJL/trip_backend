package com.website.trip.web.controller.api;

import com.website.trip.biz.code.UserCode;
import com.website.trip.biz.code.UserLoginCode;
import com.website.trip.biz.dto.Board;
import com.website.trip.biz.dto.User;
import com.website.trip.biz.model.board.input.BoardInput;
import com.website.trip.common.model.JsonResult;
import com.website.trip.biz.model.user.input.UserInput;
import com.website.trip.biz.service.UserService;
import com.website.trip.common.model.Verification;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = {"/api/user"})
    @ApiOperation(value = "유저 등록 API", notes = "유저 등록 API입니다.")
    public JsonResult create(@RequestBody UserInput model) {

        Verification verificationModify = model.isValidationCreate();

        // 입력값 유효성 체크
        if (verificationModify.isFail()) {
            return JsonResult.fail(verificationModify.getMessage());
        }
        model.setGrade(UserCode.USER01.getCode());
        model.setLoginType(UserLoginCode.LOCAL.getCode());
        userService.create(UserInput.toDto(model));

        return JsonResult.success();
    }

    @PutMapping(value = {"/api/user"})
    @ApiOperation(value = "유저 수정 API", notes = "유저 수정 API입니다.")
    public JsonResult modify(@RequestBody UserInput model) {

        Verification verificationModify = model.isVerificationModify();

        // 입력값 유효성 체크
        if (verificationModify.isFail()) {
            return JsonResult.fail(verificationModify.getMessage());
        }

        User user = userService.detail(UserInput.toDto(model));
        // 존재 유무 유효성 체크
        if (user == null) {
            return JsonResult.fail(" 존재하지 않는 유저입니다. ");
        }
        userService.modify(UserInput.toDto(model));

        return JsonResult.success();
    }

    @PutMapping(value = {"/api/user/password"})
    @ApiOperation(value = "유저 비밀번호 수정 API", notes = "유저 비밀번호 수정 API입니다.")
    public JsonResult modifyPassword(@RequestBody UserInput model) {

        Verification verificationModify = model.isVerificationModifyPassword();

        // 입력값 유효성 체크
        if (verificationModify.isFail()) {
            return JsonResult.fail(verificationModify.getMessage());
        }

        User user = userService.detail(UserInput.toDto(model));
        // 존재 유무 유효성 체크
        if (user == null) {
            return JsonResult.fail(" 존재하지 않는 유저입니다. ");
        }
        userService.modifyPassword(UserInput.toDto(model));

        return JsonResult.success();
    }

    @GetMapping(value = {"/api/user/{id}"})
    @ApiOperation(value = "유저 한명 정보 API", notes = "유저 한명 정보 API입니다.")
    public JsonResult detail(UserInput model) {

        return JsonResult.success();
    }


}
