package com.website.trip.web.apiController;

import com.website.trip.biz.dto.BoardDto;
import com.website.trip.biz.model.common.JsonResult;
import com.website.trip.biz.model.common.ServiceResult;
import com.website.trip.biz.model.input.board.SearchModule;
import com.website.trip.biz.service.BoardService;
import com.website.trip.common.util.MapUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/board/set.api")
    public JsonResult set(@RequestParam BoardDto parameter) {

        ServiceResult result = boardService.set(parameter);

        if(result.isFail()) {
            return JsonResult.fail(result.getMessage());
        }

        return JsonResult.success();
    }

    @GetMapping("/api/board/gets.api")
    public JsonResult gets(@RequestParam SearchModule model) {

        model.initPage();

        return JsonResult.success(
                MapUtil.setMapList(
                boardService.gets(model),
                boardService.totalCount(model)
                ));
    }
}
