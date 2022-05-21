package com.website.trip.biz.dao;

import com.website.trip.biz.dto.FileUpload;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileUploadDao {

    int insert(FileUpload parameter);
    int update(FileUpload parameter);
    int delete(FileUpload uploadFile);

}
