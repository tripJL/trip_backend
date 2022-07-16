package com.website.trip.biz.helper;

import com.website.trip.biz.dto.BoardFileMapping;
import com.website.trip.biz.dto.FileUpload;
import com.website.trip.biz.model.fileUpload.ouput.FileUploadOutput;
import com.website.trip.common.util.StringUtil;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class FileUploadHelper {

    public static FileUploadOutput toModel(FileUpload parameter, String baseUrl) {
        return FileUploadOutput.builder()
                .id(parameter.getId())
                .uploadFullUrl(StringUtil.isNotEmpty(parameter.getRelativeUrl()) ? baseUrl + parameter.getRelativeUrl() : "")
                .build();
    }

    public static FileUpload of(BoardFileMapping model){
        FileUpload dto = new FileUpload();
        BeanUtils.copyProperties(model, dto);
        return dto;
    }

    public static List<FileUpload> of(List<BoardFileMapping> modelList) {
        return modelList.stream().map(FileUploadHelper::of).collect(Collectors.toList());
    }
}
