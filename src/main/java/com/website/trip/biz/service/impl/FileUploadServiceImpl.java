package com.website.trip.biz.service.impl;

import com.google.common.io.Files;
import com.website.trip.biz.dao.FileUploadDao;
import com.website.trip.biz.dto.FileUpload;
import com.website.trip.biz.service.FileUploadService;
import com.website.trip.common.properties.FileUploadProperties;
import com.website.trip.common.util.DateUtil;
import com.website.trip.common.util.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    private final FileUploadDao fileUploadDao;

    private final FileUploadProperties fileUploadProperties;

    public boolean checkType(String contentType, String fileExtension) {
        if (contentType.contains("image") && fileUploadProperties.getImgExtension().contains(fileExtension)) {
            return true;
        }
        return false;
    }

    @Override
    public FileUpload uploadFile(MultipartFile file) {
        if (file == null) {
            return FileUpload.builder().result(false).build();
        }

        final FileUpload result = this.upload(file);
        if (result != null && !result.getSaveFileName().isEmpty()) {
            // TODO :확인 필요
            fileUploadDao.insert(result);
            result.setResult(true);
            return result;
        } else {
            return FileUpload.builder().result(false).build();
        }
    }

    private FileUpload upload(MultipartFile multipartFile) {

        final FileUpload fileUpload = new FileUpload();

        FileOutputStream fileOutputStream = null;

        try {
            final int fileSize = (int) multipartFile.getSize();
            final String originalFileName = multipartFile.getOriginalFilename();
            final String fileExtension = Files.getFileExtension(originalFileName).toLowerCase();

            if (!this.checkType(multipartFile.getContentType(), fileExtension)) {
                return null;
            }

            final String nowYear = DateUtil.getNowYear();
            final String nowMonth = DateUtil.getNowMonth();

            this.createDirectory(fileUploadProperties.getBaseFileUploadUrl(), nowYear, nowMonth);

            final String saveFileName = String.format("%s.%s", StringUtil.getUuid(), fileExtension);
            final String saveLocalPath = String.format("%s/%s/%s/%s", fileUploadProperties.getBaseFileUploadUrl(), nowYear, nowMonth, saveFileName);
            final String saveUploadPath = String.format("%s/%s/%s/%s", fileUploadProperties.getUploadPath(), nowYear, nowMonth, saveFileName);

            final File file = new File(saveLocalPath);
            FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));

            fileUpload.setSaveFileName(saveFileName);
            fileUpload.setOriginalFileName(originalFileName);
            fileUpload.setFileSize(fileSize);
            fileUpload.setFileExtension(fileExtension);
            fileUpload.setLocalPath(saveLocalPath);
            fileUpload.setUploadUrl(saveUploadPath);

        } catch (Exception e) {
            log.error("Exception error : {}", e.getMessage());
        } finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                log.info(e.getMessage());
            }
        }
        return fileUpload;
    }

    private void createDirectory(String baseUploadFileUrl, String year, String month) {

        String[] dirs = {
                baseUploadFileUrl,
                String.format("%s/%s/", baseUploadFileUrl, year),
                String.format("%s/%s/%s/", baseUploadFileUrl, year, month)
        };

        for (String dir : dirs) {
            File file = new File(dir);
            if (!file.exists()) {
                file.mkdir();       // 폴더 생성
            }
        }
    }

}
