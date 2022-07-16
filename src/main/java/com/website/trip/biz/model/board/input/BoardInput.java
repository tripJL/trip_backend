package com.website.trip.biz.model.board.input;

import com.website.trip.biz.dto.Board;
import com.website.trip.biz.model.fileUpload.FileUploadAddModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardInput {

    private long loginUserId;

    private String boardType;
    private String category;

    private String title;
    private String contents;

    private int thumbnailFileId;

    private List<FileUploadAddModel> fileContentsList;

    public static Board toDto(BoardInput input) {
        Board output = new Board();
        BeanUtils.copyProperties(input, output);
        return output;
    }
}
