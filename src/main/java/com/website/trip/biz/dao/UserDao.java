package com.website.trip.biz.dao;

import com.website.trip.biz.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserDao {

    int insert(UserDto parameter);
    int update(UserDto parameter);

    UserDto selectOne(String loginId);

}
