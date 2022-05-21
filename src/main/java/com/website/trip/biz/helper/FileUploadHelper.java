package com.website.trip.biz.helper;

import com.website.trip.biz.dto.FileUpload;
import com.website.trip.biz.model.fileUpload.FileUploadAddModel;
import com.website.trip.biz.model.fileUpload.FileUploadJsonModel;
import com.website.trip.common.util.StringUtil;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class FileUploadHelper {

    public static FileUploadJsonModel toModel(FileUpload parameter, String baseUrl) {
        return FileUploadJsonModel.builder()
                .id(parameter.getId())
                .uploadFullUrl(StringUtil.isNotEmpty(parameter.getUploadUrl()) ? baseUrl + parameter.getUploadUrl() : "")
                .build();
    }

    public static FileUpload of(FileUploadAddModel model){
        FileUpload dto = new FileUpload();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public static List<FileUpload> of(List<FileUploadAddModel> modelList) {
        return modelList.stream().map(FileUploadHelper::of).collect(Collectors.toList());
    }
}
