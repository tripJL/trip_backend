package com.website.trip.biz.helper;

import com.website.trip.biz.dto.UploadFile;
import com.website.trip.biz.model.output.UploadFileOutputModel;
import com.website.trip.common.util.StringUtil;

public class UploadFileHelper {

    public static UploadFileOutputModel toModel(UploadFile parameter, String baseUrl) {

        return UploadFileOutputModel.builder()
                .id(parameter.getId())
                .uploadFullUrl(StringUtil.isNotEmpty(parameter.getUploadUrl()) ? baseUrl + parameter.getUploadUrl() : "")
                .build();
    }
}
