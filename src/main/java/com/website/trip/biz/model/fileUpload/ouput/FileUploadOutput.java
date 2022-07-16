package com.website.trip.biz.model.fileUpload.ouput;

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
public class FileUploadOutput {

    private long id;
    private String uploadFullUrl;

    public static FileUploadOutput of(FileUpload dto){
        FileUploadOutput model = new FileUploadOutput();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public static List<FileUploadOutput> of(List<FileUpload> dtoList) {
        return dtoList.stream().map(FileUploadOutput::of).collect(Collectors.toList());
    }

}
