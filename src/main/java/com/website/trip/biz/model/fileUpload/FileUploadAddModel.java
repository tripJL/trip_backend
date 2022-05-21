package com.website.trip.biz.model.fileUpload;

import com.website.trip.biz.dto.FileUpload;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadAddModel {

    private long id;
    private String uploadUrl;
    private String uploadFullUrl;

    public static FileUploadAddModel of(FileUpload dto){
        FileUploadAddModel model = new FileUploadAddModel();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public static List<FileUploadAddModel> of(List<FileUpload> dtoList) {
        return dtoList.stream().map(FileUploadAddModel::of).collect(Collectors.toList());
    }

}
