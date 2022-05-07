package com.website.trip.biz.dao;

import com.website.trip.biz.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    int insert(UserDto parameter);
    int update(UserDto parameter);

    UserDto selectOne(String loginId);

}
