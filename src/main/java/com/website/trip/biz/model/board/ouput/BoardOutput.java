package com.website.trip.biz.model.board.ouput;

import com.website.trip.biz.dto.Board;
import com.website.trip.biz.model.fileUpload.input.FileUploadInput;
import com.website.trip.common.model.PageResult;
import com.website.trip.common.util.MapUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardOutput {

    private long loginUserId;

    private String boardType;
    private String category;

    private String title;
    private String contents;

    private int thumbnailFileId;

    public static BoardOutput toOutput(Board input) {
        BoardOutput output = new BoardOutput();
        BeanUtils.copyProperties(input, output);
        return output;
    }

    public static List<BoardOutput> toOutput(List<Board> inputList) {
        return inputList.stream().map(BoardOutput::toOutput).collect(Collectors.toList());
    }

    public static Map<String, Object> toOutput(PageResult<Board> pageResult) {
        long totalCount = 0;
        List<BoardOutput> list = Collections.emptyList();
        if (pageResult != null) {
            totalCount = pageResult.getTotalCount();;
            list = toOutput(pageResult.getList());
        }

        return MapUtil.setMapList(totalCount, list);

    }
}
