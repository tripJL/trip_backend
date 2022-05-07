package com.website.trip.web.apiController;

import com.website.trip.biz.model.common.JsonResult;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.model.input.user.ModifyPasswordModule;
import com.website.trip.biz.model.input.user.RegisterModule;
import com.website.trip.biz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user/add.api")
    public JsonResult add(@RequestBody RegisterModule model) {

        ServiceResult result = userService.set(model);

        if(result.isFail()) {
            return JsonResult.fail(result.getMessage());
        }

        return JsonResult.success();
    }

    @PostMapping("/api/user/modify.api")
    public JsonResult modify(@RequestBody ModifyPasswordModule model) {

        ServiceResult result = userService.set(model);

        if(result.isFail()) {
            return JsonResult.fail(result.getMessage());
        }

        return JsonResult.success();
    }

    @PutMapping("/api/put.api")
    public JsonResult put(@RequestBody ModifyPasswordModule module) {
        System.out.println(module);

        return JsonResult.success();
    }
}
