package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Board extends BaseDto {

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
