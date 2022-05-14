package com.website.trip.biz.dao;

import com.website.trip.biz.dto.Board;
import com.website.trip.biz.model.input.board.SearchModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    int insert(Board parameter);
    int update(Board parameter);

    Board selectOne(long id);
    List<Board> selectList(SearchModule module);
    int selectListCount(SearchModule module);

}
