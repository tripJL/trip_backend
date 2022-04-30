package com.website.trip.biz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDto {

    protected String loginUserId;

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

}
