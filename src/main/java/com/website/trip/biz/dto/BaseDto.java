package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDto {

    private final static int DEFAULT_PAGE_SIZE = 10;

    protected String loginUserId;

    protected String searchType;
    protected String searchValue;

    protected Date regDt;
    protected String regId;
    protected Date udtDT;
    protected String udtId;
    protected Date delDt;
    protected String delId;
    protected boolean delYn;

    protected String sqlInsertType;
    protected String sqlSelectType;
    protected String sqlUpdateType;
    protected String sqlDeleteType;

    protected int startIndex;
    protected int sizeIndex;

}
