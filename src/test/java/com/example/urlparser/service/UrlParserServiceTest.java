package com.example.urlparser.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import com.example.urlparser.model.UrlParserResponse;
import com.example.urlparser.model.UrlParserRequest;
import com.example.urlparser.model.type.TagIncludeType;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UrlParserServiceTest {

    @InjectMocks
    private UrlCollectorService urlCollectorService;

    @InjectMocks
    private FilterService filterService;

    @InjectMocks
    private MergeService mergeService ;

    @InjectMocks
    private UrlParserService urlParserService;

    @InjectMocks
    private ExtractServiceStream extractServiceStream;

    @Before
    public void setup(){
        urlParserService =
            new UrlParserService(urlCollectorService, filterService, extractServiceStream, mergeService);
    }

    /**
     * urlparser facade service 테스트 - 테그제외
     */
    @Test
    public void urlParserFacadeService_exclude() {
        String url = "http://www.google.com";
        UrlParserRequest urlParserRequest = new UrlParserRequest(url, TagIncludeType.EXCLUDE, 100 );
        UrlParserResponse urlParserResponse = urlParserService.execute(urlParserRequest);
        assertThat(urlParserResponse.getGroup(), not(StringUtils.EMPTY));
    }


    /**
     * urlparser facade service 테스트 - 테그포함
     */
    @Test
    public void urlParserFacadeService_include() {
        String url = "http://www.google.com";
        UrlParserRequest urlParserRequest = new UrlParserRequest(url, TagIncludeType.INCLUDE, 100 );
        UrlParserResponse urlParserResponse = urlParserService.execute(urlParserRequest);
        assertThat(urlParserResponse.getGroup(), not(StringUtils.EMPTY));
    }
}