package com.website.trip.biz.service.impl;

import com.website.trip.biz.dao.BoardDao;
import com.website.trip.biz.dao.BoardFileMappingDao;
import com.website.trip.biz.dto.Board;
import com.website.trip.biz.dto.BoardFileMapping;
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
    public void create(Board parameter) {

        boardDao.insert(parameter);

//        if(parameter.getFileContentsList() != null && parameter.getFileContentsList().size() > 0) {
//            List<FileUpload> fileUploadList = FileUploadHelper.of(parameter.getFileContentsList());
//            for (FileUpload fileUpload : fileUploadList) {
//                if(fileUpload.getId() > 0) {
//                    BoardFileMapping boardFileMapping = BoardFileMapping.builder().boardId(parameter.getId()).fileUploadId(fileUpload.getId()).build();
//                    boardFileMappingDao.insertBoardFile(boardFileMapping);
//                }
//            }
//        }
    }

    @Override
    @Transactional
    public void modify(Board parameter) {

        boardFileMappingDao.deleteFileByBoardId(BoardFileMapping.builder().boardId(parameter.getId()).build());

        boardDao.update(parameter);

//        if(module.getFileContentsList() != null && module.getFileContentsList().size() > 0) {
//            List<FileUpload> fileUploadList = FileUploadHelper.of(module.getFileContentsList());
//            for (FileUpload fileUpload : fileUploadList) {
//                if(fileUpload.getId() > 0) {
//                    BoardFileMapping boardFileMapping = BoardFileMapping.builder().boardId(parameter.getId()).fileUploadId(fileUpload.getId()).build();
//                    boardFileMappingDao.insertBoardFile(boardFileMapping);
//                }
//            }
//        }
    }

    @Override
    @Transactional
    public void remove(Board parameter) {

        boardDao.delete(parameter);

        boardFileMappingDao.updateDelYnFileByBoardId(BoardFileMapping.builder().boardId(parameter.getId()).build());

    }

    @Override
    public List<Board> list(Board parameter) {

        return boardDao.selectList(parameter);
    }

    @Override
    public long totalCount(Board parameter) {

        return boardDao.selectListCount(parameter);
    }

    @Override
    @Transactional
    public Board detail(Board parameter) {

        Board result = boardDao.selectOne(parameter);

        result.setFileContentsList(boardFileMappingDao.selectFileByBoardId(BoardFileMapping.builder().build()));

        return result;
    }

}
