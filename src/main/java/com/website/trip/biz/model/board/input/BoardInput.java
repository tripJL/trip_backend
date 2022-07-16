package com.website.trip.biz.model.board.input;

import com.website.trip.biz.dto.Board;
import com.website.trip.biz.model.boardFIleMapping.input.BoardFileMappingInput;
import com.website.trip.biz.model.fileUpload.input.FileUploadInput;
import com.website.trip.common.model.Verification;
import com.website.trip.common.util.StringUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardInput {

    private long loginUserId;

    private long id;
    private String boardType;
    private String category;

    private String title;
    private String contents;

    private int thumbnailFileId;

    private List<BoardFileMappingInput> fileContentsList;

    public static Board toDto(BoardInput input) {
        Board output = new Board();
        BeanUtils.copyProperties(input, output);
        if (input.getFileContentsList() != null && !input.getFileContentsList().isEmpty()) {
            output.setFileContentsList(BoardFileMappingInput.toDto(input.getFileContentsList()));
        }
        return output;
    }

    public Verification isVerificationCreate() {

        return commonVerificationModify();
    }

    public Verification isVerificationModify() {

         if (id < 1) {
             return Verification.fail(" 존재하지 않는 게시판입니다. ");
         }

        return commonVerificationModify();
    }

    public Verification commonVerificationModify() {

        if (StringUtil.isEmpty(boardType)) {
            return Verification.fail(" 게시판 타입이 옳바르지 않습니다.");
        }

        if (StringUtil.isEmpty(category)) {
            return Verification.fail(" 카테고리를 선택해주세요.");
        }

        if (StringUtil.isEmpty(title)) {
            return Verification.fail(" 제목을 입력해주세요. ");
        }

        if (StringUtil.isEmpty(contents)) {
            return Verification.fail(" 내용을 입력해주세요. ");
        }

        return Verification.success();
    }
}
