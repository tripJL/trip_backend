package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileMapping extends BaseDto {

    private final String TYPE_USER = "user";

    private long id;
    private String tableName;
    private long tableId;
    private long fileUploadId;

    // JOIN
    private String originalFileName;
    private String relativeUrl;
    private String fileExtension;
    private String fileSize;

}
