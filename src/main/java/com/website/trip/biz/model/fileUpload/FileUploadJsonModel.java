package com.website.trip.biz.model.fileUpload;

import com.website.trip.biz.dto.FileUpload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadJsonModel {

    private long id;
    private String uploadFullUrl;

    public static FileUploadJsonModel of(FileUpload dto){
        FileUploadJsonModel model = new FileUploadJsonModel();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

}
