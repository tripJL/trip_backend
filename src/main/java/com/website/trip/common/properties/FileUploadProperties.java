package com.website.trip.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("file-upload")
public class FileUploadProperties {

    private String baseFileUploadUrl;
    private String uploadPath;

    private String imgExtension;
}
