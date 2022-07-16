package com.website.trip.biz.model.boardFIleMapping.input;

import com.website.trip.biz.dto.BoardFileMapping;
import com.website.trip.biz.dto.FileMapping;
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
public class BoardFileMappingInput {

    private long id;
    private String uploadUrl;

    public static BoardFileMapping toDto(BoardFileMappingInput input) {
        BoardFileMapping output = new BoardFileMapping();
        BeanUtils.copyProperties(input, output);
        return output;
    }

    public static List<BoardFileMapping> toDto(List<BoardFileMappingInput> dtoList) {
        return dtoList.stream().map(BoardFileMappingInput::toDto).collect(Collectors.toList());
    }
}
