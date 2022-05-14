package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TableFile {

    private final String TYPE_USER = "user";
    private final String TYPE_BOARD = "board";

    private long id;
    private String tableName;
    private long tableId;
    private long uploadFileId;

}
