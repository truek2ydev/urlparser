package com.example.urlparser.controller.api;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.example.urlparser.model.ParserResult;
import com.example.urlparser.model.type.TagIncludeType;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
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

    private static final ParameterizedTypeReference<ParserResult>
        TYPE_PARSER_RESULT = new ParameterizedTypeReference<ParserResult>() {
    };

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void urlParser() throws UnsupportedEncodingException {

        String uri = "/api/url/parser?url=%s&tagIncludeType=%s&groupSize=%d";
        String targetUrl = URLEncoder.encode("http://www.google.com", "utf-8");
        TagIncludeType tagIncludeType = TagIncludeType.EXCLUDE;
        int groupSize = 100;

        RequestEntity requestEntity = RequestEntity.get(
            URI.create(String.format(uri, targetUrl, tagIncludeType, groupSize ))).build();
        ResponseEntity<ParserResult> responseEntity = testRestTemplate.exchange(requestEntity, TYPE_PARSER_RESULT);

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody().getGroup(), not(isEmptyString()));

    }
}