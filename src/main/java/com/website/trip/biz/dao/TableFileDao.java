package com.website.trip.biz.dao;

import com.website.trip.biz.dto.TableFile;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TableFileDao {

    @Delete(" DELETE FROM TABLE_FILE WHERE TABLE_NAME = #{tableName} AND TABLE_ID = #{tableId} ")
    int deleteFileByTableId(TableFile parameter);

    @Insert(" INSERT INTO TABLE_FILE (TABLE_NAME, TABLE_ID, UPLOAD_FILE_ID) VALUES (#{tableName}, #{tableId}, #{uploadFileId}) ")
    int insertFile(TableFile boardFile);

    @Select(" SELECT TF.ID, UF.ID AS UPLOAD_FILE_ID, UF.ORIGINAL_FILE_NAME, UF.UPLOAD_URL, UF.FILE_EXTENSION, UF.LENGTH " +
            " FROM TABLE_FILE TF " +
            "   JOIN UPLOAD_FILE UF ON UF.ID = TF.UPLOAD_FILE_ID " +
            " WHERE TF.TABLE_NAME = #{tableName} AND TF.TABLE_ID = #{tableId} ")
    List<TableFile> selectFileByTableId(TableFile parameter);

}