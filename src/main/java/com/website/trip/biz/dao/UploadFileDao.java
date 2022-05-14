package com.website.trip.biz.dao;

import com.website.trip.biz.dto.UploadFile;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UploadFileDao {

    int insert(UploadFile parameter);
    int update(UploadFile parameter);
    int delete(UploadFile uploadFile);

}
