package com.example.urlparser.controller.api;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.example.urlparser.model.UrlParserResponse;
import com.example.urlparser.model.type.TagIncludeType;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UrlParserApiControllerIntegrationTest {

    private static final ParameterizedTypeReference<UrlParserResponse>
            TYPE_PARSER_RESULT = new ParameterizedTypeReference<UrlParserResponse>() {
    };

    private static final ParameterizedTypeReference<List<String>>
            TYPE_VALIDATE_ERROR = new ParameterizedTypeReference<List<String>>() {
    };

    private static final ParameterizedTypeReference<String>
            TYPE_URL_ERROR = new ParameterizedTypeReference<String>() {
    };

    @Autowired
    TestRestTemplate testRestTemplate;

    /**
     * url parser 성공 테스트
     */
    @Test
    public void urlParser() throws UnsupportedEncodingException {

        String uri = "/api/url/parser?url=%s&tagIncludeType=%s&groupSize=%d";
        String targetUrl = URLEncoder.encode("http://www.google.com", "utf-8");
        TagIncludeType tagIncludeType = TagIncludeType.EXCLUDE;
        int groupSize = 100;

        RequestEntity requestEntity = RequestEntity.get(
                URI.create(String.format(uri, targetUrl, tagIncludeType, groupSize))).build();
        ResponseEntity<UrlParserResponse> responseEntity = testRestTemplate.exchange(requestEntity, TYPE_PARSER_RESULT);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody().getGroup(), not(isEmptyString()));

    }

    /**
     * 전달 파라미터 확인 테스트
     */
    @Test
    public void urlParser_requiredArgument() throws UnsupportedEncodingException {
        String uri = "/api/url/parser?url=%s&tagIncludeType=%s&groupSize=%d";
        String targetUrl = URLEncoder.encode("", "utf-8");
        TagIncludeType tagIncludeType = TagIncludeType.EXCLUDE;
        int groupSize = 100;

        RequestEntity requestEntity = RequestEntity.get(
                URI.create(String.format(uri, targetUrl, tagIncludeType, groupSize))).build();
        ResponseEntity<List<String>> responseEntity = testRestTemplate.exchange(requestEntity, TYPE_VALIDATE_ERROR);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.BAD_REQUEST));
    }

    /**
     * 전달 url 오류 테스트
     */
    @Test
    public void urlParser_invalidUrl() throws UnsupportedEncodingException {
        String uri = "/api/url/parser?url=%s&tagIncludeType=%s&groupSize=%d";
        String targetUrl = URLEncoder.encode("aaa", "utf-8");
        TagIncludeType tagIncludeType = TagIncludeType.EXCLUDE;
        int groupSize = 100;

        RequestEntity requestEntity = RequestEntity.get(
                URI.create(String.format(uri, targetUrl, tagIncludeType, groupSize))).build();
        ResponseEntity<String> responseEntity = testRestTemplate.exchange(requestEntity, TYPE_URL_ERROR);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.INTERNAL_SERVER_ERROR));
    }
}