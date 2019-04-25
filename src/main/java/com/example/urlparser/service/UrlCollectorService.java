package com.example.urlparser.service;

import com.example.urlparser.exception.UrlHandleException;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

/**
 * URL로 연결하여 BODY 문자열을 제공 클래스
 */
@Service
public class UrlCollectorService {

    @Autowired
    MessageSource messageSource;

    /**
     * URL로 연결하여 BODY 문자열 리턴
     *
     * @param url
     * @return
     */
    public String getContent(String url) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            return response.getBody();
        } catch (IllegalArgumentException iae) {
            throw new UrlHandleException(messageSource.getMessage("url.illegalArgument", null, Locale.KOREA));
        } catch (ResourceAccessException rae) {
            throw new UrlHandleException(messageSource.getMessage("url.resourceNotAccess", null, Locale.KOREA));
        }
    }
}
