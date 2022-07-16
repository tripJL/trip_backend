package com.website.trip.biz.dao;

import com.website.trip.biz.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseDao<User> {

    void updateByPassword(User parameter);

}
