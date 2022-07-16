package com.website.trip.web.controller.api;

import com.website.trip.biz.dto.Board;
import com.website.trip.biz.model.board.input.BoardInput;
import com.website.trip.biz.model.board.input.BoardSearchInput;
import com.website.trip.biz.model.board.ouput.BoardDetailOutput;
import com.website.trip.biz.model.board.ouput.BoardOutput;
import com.website.trip.biz.service.BoardService;
import com.website.trip.common.model.JsonResult;
import com.website.trip.common.model.Verification;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping(value = {"/api/board"})
    @ApiOperation(value = "게시판 등록 API", notes = "게시판 등록 API입니다.")
    public JsonResult create(@RequestBody BoardInput model) {

        Verification verificationModify = model.isVerificationCreate();

        // 입력값 유효성 체크
        if (verificationModify.isFail()) {
            return JsonResult.fail(verificationModify.getMessage());
        }

        boardService.create(BoardInput.toDto(model));

        return JsonResult.success();
    }

    @PutMapping(value = {"/api/board"})
    @ApiOperation(value = "게시판 수정 API", notes = "게시판 수정 API입니다.")
    public JsonResult modify(@RequestBody BoardInput model) {

        Verification verificationModify = model.isVerificationModify();

        // 입력값 유효성 체크
        if (verificationModify.isFail()) {
            return JsonResult.fail(verificationModify.getMessage());
        }

        Board board = boardService.detail(BoardInput.toDto(model));
        // 존재 유무 유효성 체크
        if (board == null) {
            return JsonResult.fail(" 존재하지 않는 게시판입니다. ");
        }

        boardService.modify(BoardInput.toDto(model));

        return JsonResult.success();
    }

    @DeleteMapping(value = {"/api/board"})
    @ApiOperation(value = "게시판 삭제 API", notes = "게시판 삭제 API입니다.")
    public JsonResult remove(@RequestBody BoardInput model) {

        if (model.getId() < 1) {
            return JsonResult.fail(" 존재하지 않는 게시판입니다. ");
        }

        Board board = boardService.detail(BoardInput.toDto(model));
        // 존재 유무 유효성 체크
        if (board == null) {
            return JsonResult.fail(" 존재하지 않는 게시판입니다. ");
        }

        boardService.remove(BoardInput.toDto(model));

        return JsonResult.success();
    }


    @GetMapping(value = {"/api/board"})
    @ApiOperation(value = "게시판 목록 API", notes = "게시판 목록 API입니다.")
    public JsonResult list(BoardSearchInput model) {

        model.initPage();

        return JsonResult.success(BoardOutput.toOutput(boardService.list(BoardSearchInput.toDto(model))));
    }

    @GetMapping(value = {"/api/board/{id}"})
    @ApiOperation(value = "게시판 상세 API", notes = "게시판 상세 API입니다.")
    public JsonResult detail(BoardSearchInput model) {

        return JsonResult.success(
                BoardDetailOutput.toOutput(
                        boardService.detail(BoardSearchInput.toDto(model))
                )
        );
    }


}
