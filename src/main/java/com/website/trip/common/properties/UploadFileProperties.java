package com.website.trip.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("upload-file")
public class UploadFileProperties {

    private String baseUploadFileUrl;
    private String uploadPath;

    private String imgExtension;
}
