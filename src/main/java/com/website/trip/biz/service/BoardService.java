package com.website.trip.biz.service;

import com.website.trip.biz.dto.Board;
import com.website.trip.biz.model.board.BoardDeleteModule;
import com.website.trip.biz.model.board.BoardInsertModule;
import com.website.trip.biz.model.board.BoardUpdateModule;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.model.board.BoardSearchModule;

import java.util.List;

public interface BoardService {

    ServiceResult insert(BoardInsertModule model);
    ServiceResult update(BoardUpdateModule model);
    ServiceResult delete(BoardDeleteModule module);

    List<Board> list(BoardSearchModule module);
    int totalCount(BoardSearchModule module);
    Board detail(BoardSearchModule module);

}
