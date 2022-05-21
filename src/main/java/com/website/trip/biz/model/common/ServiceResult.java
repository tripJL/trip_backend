package com.website.trip.biz.model.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@SuperBuilder
@Data
public class ServiceResult<T> {

    private boolean result;
    private String message;
    private T detail;
    private List<T> list;

    public ServiceResult() {
        this.result = true;
        this.message = "";
    }
    
    public ServiceResult(boolean result, String message) {
        this.result = result;
        this.message = message;
    }
    
    public ServiceResult(T detail) {
        this.result = true;
        this.message = "";
        this.detail = detail;
        this.list = null;
    }
    
    public ServiceResult(List<T> list) {
        this.result = true;
        this.message = "";
        this.detail = null;
        this.list = list;
    }
    
    public boolean isFail() {
        return !result;
    }

    public boolean isSuccess() {
        return result;
    }
    
    public static <T> ServiceResult<T> success() {
        return new ServiceResult<>();
    }
    
    public static <T> ServiceResult<T> success(T obj) {
        return new ServiceResult<>(obj);
    }
    
    public static <T> ServiceResult<T> success(List<T> objList) {
        return new ServiceResult<>(objList);
    }
    
    public static <T> ServiceResult<T> fail(String message) {
        return new ServiceResult<>(false, message);
    }

    public static <T> ServiceResult<T> dbFail() {
        return new ServiceResult<>(false, " 데이터 처리 중 문제 발생하였습니다. ");
    }
    
}
