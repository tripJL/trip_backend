package com.website.trip.biz.dto;

import com.website.trip.biz.model.input.board.SearchModule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto extends BaseDto {

    private long id;

    private String boardType;
    private String category;

    private String title;
    private String contents;
    private int hits;

    private int thumbnailFileId;

    // join
    private String thumbnailPath;
    private String thumbnailOriginalName;

}
