package com.website.trip.biz.service;

import com.website.trip.biz.dto.BoardDto;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.model.input.board.SearchModule;

import java.util.List;

public interface BoardService {

    ServiceResult set(BoardDto parameter);

    List<BoardDto> gets(SearchModule module);
    int totalCount(SearchModule module);
}
