package com.website.trip.biz.service.impl;

import com.google.common.io.Files;
import com.website.trip.biz.dao.UploadFileDao;
import com.website.trip.biz.dto.UploadFile;
import com.website.trip.biz.service.UploadFileService;
import com.website.trip.common.properties.UploadFileProperties;
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
public class UploadFileServiceImpl implements UploadFileService {

    private final UploadFileDao uploadFileDao;

    private final UploadFileProperties uploadFileProperties;

    public boolean checkType(String contentType, String fileExtension) {
        if (contentType.contains("image") && uploadFileProperties.getImgExtension().contains(fileExtension)) {
            return true;
        }
        return false;
    }

    @Override
    public UploadFile uploadFile(MultipartFile file) {
        if (file == null) {
            return UploadFile.builder().result(false).build();
        }

        final UploadFile result = this.upload(file);
        if (result != null && !result.getSaveFileName().isEmpty()) {
            result.setResult(uploadFileDao.insert(result) > 0);
            return result;
        } else {
            return UploadFile.builder().result(false).build();
        }
    }

    private UploadFile upload(MultipartFile multipartFile) {

        final UploadFile uploadFile = new UploadFile();

        FileOutputStream fileOutputStream = null;

        try {
            final int length = (int) multipartFile.getSize();
            final String originalFileName = multipartFile.getOriginalFilename();
            final String fileExtension = Files.getFileExtension(originalFileName).toLowerCase();

            if (!this.checkType(multipartFile.getContentType(), fileExtension)) {
                return null;
            }

            final String nowYear = DateUtil.getNowYear();
            final String nowMonth = DateUtil.getNowMonth();

            this.createDirectory(uploadFileProperties.getBaseUploadFileUrl(), nowYear, nowMonth);

            final String saveFileName = String.format("%s.%s", StringUtil.getUuid(), fileExtension);
            final String saveLocalPath = String.format("%s/%s/%s/%s", uploadFileProperties.getBaseUploadFileUrl(), nowYear, nowMonth, saveFileName);
            final String saveUploadPath = String.format("%s/%s/%s/%s", uploadFileProperties.getUploadPath(), nowYear, nowMonth, saveFileName);

            final File file = new File(saveLocalPath);
            FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));

            uploadFile.setSaveFileName(saveFileName);
            uploadFile.setOriginalFileName(originalFileName);
            uploadFile.setLength(length);
            uploadFile.setFileExtension(fileExtension);
            uploadFile.setLocalPath(saveLocalPath);
            uploadFile.setUploadUrl(saveUploadPath);

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
        return uploadFile;
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
