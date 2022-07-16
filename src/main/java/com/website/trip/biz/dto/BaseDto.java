package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto {

    private final static int DEFAULT_PAGE_SIZE = 10;

    protected int loginUserId;

    protected String searchType;
    protected String searchValue;

    protected LocalDateTime regDt;
    protected String regId;
    protected LocalDateTime udtDT;
    protected String udtId;
    protected LocalDateTime delDt;
    protected String delId;
    protected boolean delYn;

    protected String sqlInsertType;
    protected String sqlSelectType;
    protected String sqlUpdateType;
    protected String sqlDeleteType;

    protected int startIndex;
    protected int pageSize;

}
