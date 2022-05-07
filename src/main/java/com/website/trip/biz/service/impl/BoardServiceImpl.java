package com.website.trip.biz.service.impl;

import com.website.trip.biz.dao.BoardDao;
import com.website.trip.biz.dao.UserDao;
import com.website.trip.biz.dto.BoardDto;
import com.website.trip.biz.dto.UserDto;
import com.website.trip.biz.helper.UserHelper;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.model.input.board.SearchModule;
import com.website.trip.biz.model.input.user.ModifyPasswordModule;
import com.website.trip.biz.model.input.user.RegisterModule;
import com.website.trip.biz.service.BoardService;
import com.website.trip.biz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao;

    @Override
    public ServiceResult set(BoardDto parameter) {

        if(parameter == null) {
            return ServiceResult.fail("잘못된 데이터 타입입니다.");
        }

        int affected;

        if(parameter.getId() < 1) {
            affected = boardDao.insert(parameter);
        } else {
            affected = boardDao.update(parameter);
        }

        if(affected < 1) {
            return ServiceResult.fail("데이터 처리 중 문제 발생하였습니다.");
        }

        return ServiceResult.success();
    }

    @Override
    public List<BoardDto> gets(SearchModule module) {

        return boardDao.selectList(module);
    }

    @Override
    public int totalCount(SearchModule module) {

        return boardDao.selectListCount(module);
    }

}
