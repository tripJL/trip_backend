package com.website.trip.web.controller.api;

import com.website.trip.biz.code.UserCode;
import com.website.trip.biz.code.UserLoginCode;
import com.website.trip.common.model.JsonResult;
import com.website.trip.biz.model.user.UserRegisterModule;
import com.website.trip.biz.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user")
    @ApiOperation(value = "유저 등록 API", notes = "유저 등록 API입니다.")
    public JsonResult create(@RequestBody UserRegisterModule model) {

        if (model.isValidationCreate()) {

        }
        model.setGrade(UserCode.USER01.getCode());
        model.setLoginType(UserLoginCode.LOCAL.getCode());
        userService.create(UserRegisterModule.toDto(model));

        return JsonResult.success();
    }

    @GetMapping("/api/user")
    public JsonResult detail() {

        return JsonResult.success();
    }

//    @PostMapping("/api/user/modify.api")
//    public JsonResult modify(@RequestBody ModifyPasswordModule model) {
//
//        ServiceResult result = userService.set(model);
//
//        if (result.isFail()) {
//            return JsonResult.fail(result.getMessage());
//        }
//
//        return JsonResult.success();
//    }
//
//    @PutMapping("/api/put.api")
//    public JsonResult put(@RequestBody ModifyPasswordModule module) {
//        System.out.println(module);
//
//        return JsonResult.success();
//    }
}
