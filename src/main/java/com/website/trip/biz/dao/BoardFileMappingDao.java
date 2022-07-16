package com.website.trip.biz.dao;

import com.website.trip.biz.dto.BoardFileMapping;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardFileMappingDao extends BaseDao<BoardFileMapping> {

    // 물리적 삭제
    int deleteFileByBoardId(BoardFileMapping parameter);

    // 논리적 삭제
    int updateDelYnFileByBoardId(BoardFileMapping parameter);

    List<BoardFileMapping> selectFileByBoardId(BoardFileMapping parameter);

}