package com.example.urlparser.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "app.regx")
public class AppRegxProperties {
    private String target;
    private String english;
    private String number;
    private String tag;
}
