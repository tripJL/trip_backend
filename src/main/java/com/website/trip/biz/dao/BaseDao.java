package com.website.trip.biz.dao;

import com.website.trip.biz.dto.BaseDto;

import java.util.List;

public interface BaseDao<T extends BaseDto> {

    void insert(T parameter);
    void update(T parameter);
    void delete(T parameter);

    T selectOne(T parameter);
    List<T> selectList(T module);
    long selectListCount(T module);

}
