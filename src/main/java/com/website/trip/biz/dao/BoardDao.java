package com.website.trip.biz.dao;

import com.website.trip.biz.dto.Board;
import com.website.trip.biz.model.board.BoardSearchModule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardDao {

    int insert(Board parameter);
    int update(Board parameter);
    int delete(Board parameter);

    Board selectOne(Board parameter);
    List<Board> selectList(BoardSearchModule module);
    int selectListCount(BoardSearchModule module);

}
