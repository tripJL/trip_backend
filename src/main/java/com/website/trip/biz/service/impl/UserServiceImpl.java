package com.website.trip.biz.service.impl;

import com.website.trip.biz.dao.UserDao;
import com.website.trip.biz.dto.UserDto;
import com.website.trip.biz.helper.UserHelper;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.model.input.user.ModifyPasswordModule;
import com.website.trip.biz.model.input.user.RegisterModule;
import com.website.trip.biz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private UserDto toUserDto(Object module) {

        if(module instanceof RegisterModule) {
            return UserHelper.toDto((RegisterModule) module);
        } else if(module instanceof ModifyPasswordModule) {
            UserDto parameter = UserHelper.toDto((ModifyPasswordModule) module);
            parameter.setSqlUpdateType("MODIFY_PASSWORD");
            return parameter;
        } else {
            return null;
        }
    }

    @Override
    public ServiceResult set(Object module) {

        UserDto parameter = this.toUserDto(module);

        if(parameter == null) {
            return ServiceResult.fail("잘못된 데이터 타입입니다.");
        }

        UserDto userDto = userDao.selectOne(parameter.getLoginId());

        int affected;

        if(userDto == null) {
            affected = userDao.insert(parameter);
        } else {
            affected = userDao.update(parameter);
        }

        if(affected < 1) {
            return ServiceResult.fail("데이터 처리 중 문제 발생하였습니다.");
        }

        return ServiceResult.success();
    }
}
