package com.website.trip.biz.service.impl;

import com.website.trip.biz.dao.BoardDao;
import com.website.trip.biz.dao.BoardFileMappingDao;
import com.website.trip.biz.dto.Board;
import com.website.trip.biz.dto.BoardFileMapping;
import com.website.trip.biz.dto.FileUpload;
import com.website.trip.biz.helper.FileUploadHelper;
import com.website.trip.biz.service.BoardService;
import com.website.trip.common.model.PageResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDao boardDao;
    private final BoardFileMappingDao boardFileMappingDao;

    private void insertFile(long id, List<BoardFileMapping> fileContentsList) {

        if(id < 1 && fileContentsList != null && fileContentsList.size() > 0) {
            List<FileUpload> fileUploadList = FileUploadHelper.of(fileContentsList);
            for (FileUpload fileUpload : fileUploadList) {
                if(fileUpload.getId() > 0) {
                    BoardFileMapping boardFileMapping = BoardFileMapping.builder().boardId(id).fileUploadId(fileUpload.getId()).build();
                    boardFileMappingDao.insert(boardFileMapping);
                }
            }
        }

    }

    @Override
    @Transactional
    public void create(Board parameter) {
        boardDao.insert(parameter);
        this.insertFile(parameter.getId(), parameter.getFileContentsList());
    }

    @Override
    @Transactional
    public void modify(Board parameter) {
        boardFileMappingDao.deleteFileByBoardId(BoardFileMapping.builder().boardId(parameter.getId()).build());
        boardDao.update(parameter);
        this.insertFile(parameter.getId(), parameter.getFileContentsList());
    }

    @Override
    @Transactional
    public void remove(Board parameter) {
        boardDao.delete(parameter);
        boardFileMappingDao.updateDelYnFileByBoardId(BoardFileMapping.builder().boardId(parameter.getId()).build());
    }

    @Override
    public PageResult<Board> list(Board parameter) {

        long totalCount = boardDao.selectListCount(parameter);
        List<Board> list = Collections.emptyList();
        if (totalCount > 0) {
            list = boardDao.selectList(parameter);
        }

        return PageResult.success(totalCount, list);
    }


    @Override
    @Transactional
    public Board detail(Board parameter) {
        Board result = boardDao.selectOne(parameter);

        result.setFileContentsList(boardFileMappingDao.selectFileByBoardId(BoardFileMapping.builder().build()));

        return result;
    }

}
