package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardFileMapping {

    private long id;
    private long boardId;
    private long fileUploadId;

    private String originalFileName;
    private String uploadUrl;
    private String fileExtension;
    private int fileSize;

}
