package com.website.trip.biz.model.boardFIleMapping.ouput;

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
public class BoardFileMappingOutput {

    private long id;
    private String uploadFullUrl;

    public static BoardFileMappingOutput of(FileUpload dto){
        BoardFileMappingOutput model = new BoardFileMappingOutput();
        BeanUtils.copyProperties(dto, model);
        return model;
    }

    public static List<BoardFileMappingOutput> of(List<FileUpload> dtoList) {
        return dtoList.stream().map(BoardFileMappingOutput::of).collect(Collectors.toList());
    }

}
