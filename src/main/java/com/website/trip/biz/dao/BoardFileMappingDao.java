package com.website.trip.biz.dao;

import com.website.trip.biz.dto.BoardFileMapping;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardFileMappingDao {

    // 물리적 삭제
    @Delete(" DELETE FROM board_file_mapping WHERE BOARD_ID = #{boardId} ")
    int deleteFileByBoardId(BoardFileMapping parameter);

    // 논리적 삭제
    @Update(" UPDATE SET DEL_YN = 1 FROM board_file_mapping WHERE BOARD_ID = #{boardId} ")
    int updateDelYnFileByBoardId(BoardFileMapping parameter);

    @Insert(" INSERT INTO board_file_mapping (BOARD_ID, FILE_UPLOAD_ID, DEL_YN) VALUES (#{boardId}, #{fileUploadId}, 0) ")
    int insertBoardFile(BoardFileMapping boardFile);

    @Select(" SELECT BFM.ID, FU.ID AS FILE_UPLOAD_ID, FU.ORIGINAL_FILE_NAME, FU.UPLOAD_URL, FU.FILE_EXTENSION, FU.FILE_SIZE " +
            " FROM board_file_mapping BFM " +
            "   JOIN file_upload FU ON FU.ID = BFM.FILE_UPLOAD_ID " +
            " WHERE BFM.BOARD_ID = #{boardId} BFM.DEL_YN = 0")
    List<BoardFileMapping> selectFileByBoardId(BoardFileMapping parameter);

}