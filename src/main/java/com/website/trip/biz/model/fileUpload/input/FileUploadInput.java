package com.website.trip.biz.model.fileUpload.input;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadInput {

    private long id;
    private String uploadUrl;

}
