package com.website.trip.biz.service;

import com.website.trip.biz.dto.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    FileUpload uploadFile(final MultipartFile file);
}
