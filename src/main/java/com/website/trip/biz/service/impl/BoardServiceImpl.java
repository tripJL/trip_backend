package com.website.trip.biz.service.impl;

import com.website.trip.biz.dao.BoardDao;
import com.website.trip.biz.dao.BoardFileMappingDao;
import com.website.trip.biz.dto.Board;
import com.website.trip.biz.dto.BoardFileMapping;
import com.website.trip.biz.dto.FileUpload;
import com.website.trip.biz.helper.FileUploadHelper;
import com.website.trip.biz.model.board.BoardDeleteModule;
import com.website.trip.biz.model.board.BoardInsertModule;
import com.website.trip.biz.model.board.BoardSearchModule;
import com.website.trip.biz.model.board.BoardUpdateModule;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao;
    private final BoardFileMappingDao boardFileMappingDao;

    @Override
    @Transactional
    public ServiceResult insert(BoardInsertModule module) {

        Board parameter = Board.builder()
                .boardType(module.getBoardType())
                .category(module.getCategory())
                .title(module.getTitle())
                .contents(module.getContents())
                .thumbnailFileId(module.getThumbnailFileId())
                .build();

        int affected = boardDao.insert(parameter);

        if(module.getFileContentsList() != null && module.getFileContentsList().size() > 0) {
            List<FileUpload> fileUploadList = FileUploadHelper.of(module.getFileContentsList());
            for (FileUpload fileUpload : fileUploadList) {
                if(fileUpload.getId() > 0) {
                    BoardFileMapping boardFileMapping = BoardFileMapping.builder().boardId(parameter.getId()).fileUploadId(fileUpload.getId()).build();
                    boardFileMappingDao.insertBoardFile(boardFileMapping);
                }
            }
        }

        if (affected < 1) {
            return ServiceResult.dbFail();
        }

        return ServiceResult.success();
    }

    @Override
    @Transactional
    public ServiceResult update(BoardUpdateModule module) {

        Board parameter = Board.builder()
                .id(module.getId())
                .boardType(module.getBoardType())
                .category(module.getCategory())
                .title(module.getTitle())
                .contents(module.getContents())
                .thumbnailFileId(module.getThumbnailFileId())
                .build();

        boardFileMappingDao.deleteFileByBoardId(BoardFileMapping.builder().boardId(parameter.getId()).build());

        int affected = boardDao.update(parameter);

        if(module.getFileContentsList() != null && module.getFileContentsList().size() > 0) {
            List<FileUpload> fileUploadList = FileUploadHelper.of(module.getFileContentsList());
            for (FileUpload fileUpload : fileUploadList) {
                if(fileUpload.getId() > 0) {
                    BoardFileMapping boardFileMapping = BoardFileMapping.builder().boardId(parameter.getId()).fileUploadId(fileUpload.getId()).build();
                    boardFileMappingDao.insertBoardFile(boardFileMapping);
                }
            }
        }

        if (affected < 1) {
            return ServiceResult.dbFail();
        }

        return ServiceResult.success();
    }

    @Override
    @Transactional
    public ServiceResult delete(BoardDeleteModule module) {

        Board parameter = Board.builder().id(module.getId()).build();

        int affected = boardDao.delete(parameter);

        boardFileMappingDao.updateDelYnFileByBoardId(BoardFileMapping.builder().boardId(parameter.getId()).build());

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

        return boardDao.selectList(parameter);
    }

    @Override
    public int totalCount(BoardSearchModule module) {

        Board parameter = Board.builder()
                .searchType(module.getSearchType())
                .searchValue(module.getSearchValue())
                .build();

        return boardDao.selectListCount(parameter);
    }

    @Override
    @Transactional
    public Board detail(BoardSearchModule module) {

        Board parameter = Board.builder().id(module.getId()).build();

        Board result = boardDao.selectOne(parameter);

        result.setFileContentsList(boardFileMappingDao.selectFileByBoardId(BoardFileMapping.builder().build()));

        return result;
    }

}
