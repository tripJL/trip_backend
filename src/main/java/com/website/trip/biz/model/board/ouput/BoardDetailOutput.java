package com.website.trip.biz.model.board.ouput;

import com.website.trip.biz.dto.Board;
import com.website.trip.biz.model.fileUpload.input.FileUploadInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDetailOutput {

    private long loginUserId;

    private String boardType;
    private String category;

    private String title;
    private String contents;

    private int thumbnailFileId;

    private List<FileUploadInput> fileContentsList;

    public static BoardDetailOutput toOutput(Board input) {
        BoardDetailOutput output = new BoardDetailOutput();
        BeanUtils.copyProperties(input, output);
        return output;
    }
}
