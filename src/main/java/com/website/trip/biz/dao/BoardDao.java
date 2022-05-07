package com.website.trip.biz.dao;

import com.website.trip.biz.dto.BoardDto;
import com.website.trip.biz.model.input.board.SearchModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    int insert(BoardDto parameter);
    int update(BoardDto parameter);

    BoardDto selectOne(long id);
    List<BoardDto> selectList(SearchModule module);
    int selectListCount(SearchModule module);

}
