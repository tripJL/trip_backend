package com.website.trip.web.controller.api;

import com.website.trip.biz.model.board.BoardDeleteModule;
import com.website.trip.biz.model.board.BoardInsertModule;
import com.website.trip.biz.model.board.BoardUpdateModule;
import com.website.trip.biz.model.common.JsonResult;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.model.board.BoardSearchModule;
import com.website.trip.biz.service.BoardService;
import com.website.trip.common.util.MapUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/board/insert.api")
    public JsonResult insert(@RequestBody BoardInsertModule module) {

        ServiceResult result = boardService.insert(module);

        if (result.isFail()) {
            return JsonResult.fail(result.getMessage());
        }

        return JsonResult.success();
    }

    @PostMapping("/api/board/update.api")
    public JsonResult update(@RequestBody BoardUpdateModule module) {

        ServiceResult result = boardService.update(module);

        if (result.isFail()) {
            return JsonResult.fail(result.getMessage());
        }

        return JsonResult.success();
    }

    @GetMapping("/api/board/list.api")
    public JsonResult list(BoardSearchModule model) {

        model.initPage();

        return JsonResult.success(
                MapUtil.setMapList(
                        boardService.list(model),
                        boardService.totalCount(model)
                )
        );
    }

    @GetMapping("/api/board/detail.api")
    public JsonResult detail(BoardSearchModule model) {

        model.initPage();

        return JsonResult.success(boardService.detail(model));
    }

    @PostMapping("/api/board/delete.api")
    public JsonResult delete(@RequestBody BoardDeleteModule module) {

        boardService.delete(module);

        return JsonResult.success();
    }

}
