package com.website.trip.biz.dao;

import com.website.trip.biz.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    int insert(User parameter);
    int update(User parameter);

    User selectOne(String loginId);

}
