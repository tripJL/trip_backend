package com.website.trip.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("site-info")
public class SiteInfoProperties {

    private String baseServerUrl;

}
