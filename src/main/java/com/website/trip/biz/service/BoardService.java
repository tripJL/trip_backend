package com.website.trip.biz.service;

import com.website.trip.biz.dto.Board;
import com.website.trip.common.model.PageResult;

public interface BoardService {

    void create(Board parameter);
    void modify(Board parameter);
    void remove(Board parameter);

    PageResult<Board> list(Board parameter);
    Board detail(Board parameter);

}
