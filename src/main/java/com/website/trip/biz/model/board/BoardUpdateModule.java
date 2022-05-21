package com.website.trip.biz.model.board;

import com.website.trip.biz.model.fileUpload.FileUploadAddModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardUpdateModule {

    private long loginUserId;

    private long id;
    private String boardType;
    private String category;

    private String title;
    private String contents;

    private int thumbnailFileId;

    private List<FileUploadAddModel> fileContentsList;
}
