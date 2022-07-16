package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUpload extends BaseDto {

    private long id;
    private int fileSize;
    private String originalFileName;
    private String fileExtension;
    private String saveFileName;
    private String relativeUrl;
    private String absoluteUrl;

    private boolean result;
    private String message;

    public boolean isFail() {
        return !result;
    }

}
