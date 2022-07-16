package com.website.trip.web.controller.common;

import com.website.trip.biz.dto.FileUpload;
import com.website.trip.biz.helper.FileUploadHelper;
import com.website.trip.common.model.JsonResult;
import com.website.trip.biz.service.FileUploadService;
import com.website.trip.common.properties.SiteInfoProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    private final SiteInfoProperties siteInfoProperties;

    @PostMapping(value = {"/api/upload.api","/cms/api/upload.api"})
    public JsonResult upload(final MultipartFile attachFile) {

        final FileUpload uploadFile = fileUploadService.uploadFile(attachFile);
        if(uploadFile.isFail()) {
            return JsonResult.fail(" 올바른 파일 형식이 아닙니다. ");
        }

        return JsonResult.success(FileUploadHelper.toModel(uploadFile, siteInfoProperties.getBaseServerUrl()));
    }

}
