package com.website.trip.biz.service;

import com.website.trip.biz.dto.UploadFile;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

    UploadFile uploadFile(final MultipartFile file);
}
