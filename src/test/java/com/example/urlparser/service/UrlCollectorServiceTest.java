package com.example.urlparser.service;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.ResourceAccessException;


@RunWith(MockitoJUnitRunner.class)

public class UrlCollectorServiceTest {

    @InjectMocks
    UrlCollectorService urlCollectorService;

    @Test
    public void getContent() {
        String url = "http://www.google.com";
//        String url = "http://ww.go.com/";
        String response = urlCollectorService.getContent(url);
        System.out.println(response);
        assertThat(response, not(isEmptyString()));
        // TODO assert html
    }

    @Test(expected = ResourceAccessException.class)
    public void getContent_resourceAccessException() {
        String url = "http://ww.go.com/";
        String response = urlCollectorService.getContent(url);
    }

    @Test
    public void getContent_japan() {
        String url = "https://matome.naver.jp/";
        String response = urlCollectorService.getContent(url);
        System.out.println(response);
    }
}