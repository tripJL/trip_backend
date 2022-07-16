package com.website.trip.biz.model.board.input;

import com.website.trip.biz.dto.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardSearchInput {

    private long id;

    private String searchType;
    private String searchValue;

    private int pageIndex;
    private int pageSize;

    private int startIndex;

    public void initPage() {

        if (this.pageIndex < 1) {
            this.pageIndex = 1;
        }
        if (this.pageSize < 1) {
            this.pageSize = 10;
        }

        this.startIndex = (this.pageIndex - 1) * this.pageSize;
    }

    public static Board toDto(BoardSearchInput input) {
        Board output = new Board();
        BeanUtils.copyProperties(input, output);
        return output;
    }
}
