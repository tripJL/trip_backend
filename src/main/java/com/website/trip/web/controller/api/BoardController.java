package com.website.trip.web.controller.api;

import com.website.trip.biz.model.board.input.BoardInput;
import com.website.trip.biz.model.board.input.BoardSearchInput;
import com.website.trip.biz.model.common.JsonResult;
import com.website.trip.biz.service.BoardService;
import com.website.trip.common.util.MapUtil;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    @ApiOperation(value = "게시판 등록 API", notes = "게시판 등록 API입니다.")
    public JsonResult create(@RequestBody BoardInput module) {

        boardService.create(BoardInput.toDto(module));

        return JsonResult.success();
    }

    @PutMapping("/api/board")
    @ApiOperation(value = "게시판 수정 API", notes = "게시판 수정 API입니다.")
    public JsonResult modify(@RequestBody BoardInput module) {

        boardService.modify(BoardInput.toDto(module));

        return JsonResult.success();
    }

    @DeleteMapping("/api/board")
    @ApiOperation(value = "게시판 삭제 API", notes = "게시판 삭제 API입니다.")
    public JsonResult remove(@RequestBody BoardInput module) {

        boardService.remove(BoardInput.toDto(module));

        return JsonResult.success();
    }


    @GetMapping("/api/board")
    @ApiOperation(value = "게시판 목록 API", notes = "게시판 목록 API입니다.")
    public JsonResult list(BoardSearchInput model) {

        model.initPage();

        return JsonResult.success(
                MapUtil.setMapList(
                        boardService.list(BoardSearchInput.toDto(model)),
                        boardService.totalCount(BoardSearchInput.toDto(model))
                )
        );
    }

    @GetMapping("/api/board/{id}")
    @ApiOperation(value = "게시판 상세 API", notes = "게시판 상세 API입니다.")
    public JsonResult detail(BoardSearchInput model) {

        return JsonResult.success(boardService.detail(BoardSearchInput.toDto(model)));
    }


}
