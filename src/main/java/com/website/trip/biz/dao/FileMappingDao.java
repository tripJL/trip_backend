package com.website.trip.biz.dao;

import com.website.trip.biz.dto.FileMapping;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMappingDao {

    // 물리적 삭제
    @Delete(" DELETE FROM file_mapping WHERE TABLE_NAME = #{tableName} AND TABLE_ID = #{tableId} ")
    int deleteFileByTableId(FileMapping parameter);

    // 논리적 삭제
    @Update(" UPDATE SET DEL_YN = 1 FROM file_mapping WHERE TABLE_NAME = #{tableName} AND TABLE_ID = #{tableId} ")
    int updateDelYnFileByTableId(FileMapping parameter);

    @Insert(" INSERT INTO file_mapping (TABLE_NAME, TABLE_ID, FILE_UPLOAD_ID) VALUES (#{tableName}, #{tableId}, #{fileUploadId}) ")
    int insertFile(FileMapping boardFile);

    @Select(" SELECT FM.ID, FU.ID AS FILE_UPLOAD_ID, FU.ORIGINAL_FILE_NAME, FU.UPLOAD_URL, FU.FILE_EXTENSION, FU.FILE_SIZE " +
            " FROM file_mapping FM " +
            "   JOIN file_upload FU ON FU.ID = FM.FILE_UPLOAD_ID " +
            " WHERE FM.TABLE_NAME = #{tableName} AND FM.TABLE_ID = #{tableId} ")
    List<FileMapping> selectFileByTableId(FileMapping parameter);

}