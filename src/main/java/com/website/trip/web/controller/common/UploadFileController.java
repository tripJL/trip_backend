package com.website.trip.web.controller.common;

import com.website.trip.biz.dto.UploadFile;
import com.website.trip.biz.helper.UploadFileHelper;
import com.website.trip.biz.model.common.JsonResult;
import com.website.trip.biz.service.UploadFileService;
import com.website.trip.common.properties.SiteInfoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class UploadFileController {

    private final UploadFileService uploadFileService;

    private final SiteInfoProperties siteInfoProperties;

    @PostMapping(value = {"/api/upload.api","/cms/api/upload.api"})
    public JsonResult upload(final MultipartFile attachFile) {

        final UploadFile uploadFile = uploadFileService.uploadFile(attachFile);
        if(uploadFile.isFail()) {
            return JsonResult.fail(" 올바른 파일 형식이 아닙니다. ");
        }

        return JsonResult.success(UploadFileHelper.toModel(uploadFile, siteInfoProperties.getBaseServerUrl()));
    }

}
