package com.website.trip.biz.service.impl;

import com.website.trip.biz.dao.BoardDao;
import com.website.trip.biz.dto.Board;
import com.website.trip.biz.helper.FileUploadHelper;
import com.website.trip.biz.model.board.BoardDeleteModule;
import com.website.trip.biz.model.board.BoardInsertModule;
import com.website.trip.biz.model.board.BoardUpdateModule;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.model.board.BoardSearchModule;
import com.website.trip.biz.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao;

    @Override
    public ServiceResult insert(BoardInsertModule module) {

        Board parameter = Board.builder()
                .boardType(module.getBoardType())
                .category(module.getCategory())
                .title(module.getTitle())
                .contents(module.getContents())
                .thumbnailFileId(module.getThumbnailFileId())
                .fileContentsList(FileUploadHelper.of(module.getFileContentsList()))
                .build();

        int affected = boardDao.insert(parameter);

        if (affected < 1) {
            return ServiceResult.dbFail();
        }

        return ServiceResult.success();
    }

    @Override
    public ServiceResult update(BoardUpdateModule module) {

        Board parameter = Board.builder()
                .id(module.getId())
                .boardType(module.getBoardType())
                .category(module.getCategory())
                .title(module.getTitle())
                .contents(module.getContents())
                .thumbnailFileId(module.getThumbnailFileId())
                .fileContentsList(FileUploadHelper.of(module.getFileContentsList()))
                .build();

        int affected = boardDao.update(parameter);

        if (affected < 1) {
            return ServiceResult.dbFail();
        }

        return ServiceResult.success();
    }

    @Override
    public ServiceResult delete(BoardDeleteModule module) {

        Board parameter = Board.builder().id(module.getId()).build();

        int affected = boardDao.delete(parameter);

        if (affected < 1) {
            return ServiceResult.dbFail();
        }

        return ServiceResult.success();
    }

    @Override
    public List<Board> list(BoardSearchModule module) {

        Board parameter = Board.builder()
                .searchType(module.getSearchType())
                .searchValue(module.getSearchValue())
                .startIndex(module.getStartIndex())
                .pageSize(module.getPageSize())
                .build();

        return boardDao.selectList(module);
    }

    @Override
    public int totalCount(BoardSearchModule module) {

        return boardDao.selectListCount(module);
    }

    @Override
    public Board detail(BoardSearchModule module) {

        Board parameter = Board.builder().id(module.getId()).build();

        return boardDao.selectOne(parameter);
    }

}
