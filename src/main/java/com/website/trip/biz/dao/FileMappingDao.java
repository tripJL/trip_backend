package com.website.trip.biz.dao;

import com.website.trip.biz.dto.FileMapping;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMappingDao extends BaseDao<FileMapping> {

    // 물리적 삭제
    void deleteByTableNameAndTableId(FileMapping parameter);

    // 논리적 삭제
    void updateDelYnByTableNameAndTableId(FileMapping parameter);

    List<FileMapping> selectListByTableNameAndTableId(FileMapping parameter);

}