package com.website.trip.common.model;

import com.website.trip.biz.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> {

    private long totalCount;
    private List<T> list;

    public static <E extends BaseDto> PageResult<E> success(long totalCount, List<E> list) {
        PageResult<E> pageResult = new PageResult<>();
        pageResult.setList(list);
        pageResult.setTotalCount(totalCount);
        return pageResult;
    }

}
