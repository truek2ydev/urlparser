package com.example.urlparser.service;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.urlparser.exception.UrlHandleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.MessageSource;


@RunWith(MockitoJUnitRunner.class)

public class UrlCollectorServiceTest {

    @InjectMocks
    UrlCollectorService urlCollectorService;

    @Mock
    MessageSource messageSource;

    /**
     * 정상 url 확인
     */
    @Test
    public void getContent() {
        String url = "http://www.google.com";
        String response = urlCollectorService.getContent(url);
        System.out.println(response);
        assertThat(response, not(isEmptyString()));
    }

    /**
     * url형식 예외 확인
     */
    @Test(expected = UrlHandleException.class)
    public void getContent_urlNotAbsolute() {
        // given
        when(messageSource.getMessage(any(String.class),any(), any())).thenReturn("exception message");

        // when
        String url = "aaa";
        String response = urlCollectorService.getContent(url);

        // then - expect exception
    }

    /**
     * 접속 불가 url 예외 확인
     */

    @Test(expected = UrlHandleException.class)
    public void getContent_resourceAccessException() {
        // given
        when(messageSource.getMessage(any(String.class),any(), any())).thenReturn("exception message");

        // when
        String url = "http://ww.go.com/";
        String response = urlCollectorService.getContent(url);

        // then - expect exception
    }

    /**
     * 일본어 사이트 확인
     */
    @Test
    public void getContent_japan() {
        String url = "https://matome.naver.jp/";
        String response = urlCollectorService.getContent(url);
        System.out.println(response);
    }
}