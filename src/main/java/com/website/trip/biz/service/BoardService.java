package com.website.trip.biz.service;

import com.website.trip.biz.dto.Board;

import java.util.List;

public interface BoardService {

    void create(Board parameter);
    void modify(Board parameter);
    void remove(Board parameter);

    List<Board> list(Board parameter);
    long totalCount(Board parameter);
    Board detail(Board parameter);

}
