package com.example.urlparser.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

import com.example.urlparser.model.ParserResult;
import com.example.urlparser.model.type.TagIncludeType;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UrlParserFacadeServiceTest {

    @InjectMocks
    private UrlCollectorService urlCollectorService;

    @InjectMocks
    private ParserService parserService;

    @InjectMocks
    private SortService sortService;

    @InjectMocks
    private FilterService filterService;

    @InjectMocks
    private MergeService mergeService ;

    @InjectMocks
    private UrlParserFacadeService urlParserFacadeService;

    @Before
    public void setup(){
        urlParserFacadeService =
            new UrlParserFacadeService(urlCollectorService, parserService, sortService, filterService, mergeService);
    }

    /**
     * urlparser facade service 테스트
     */
    @Test
    public void urlParserFacadeService() {
        String url = "http://www.google.com";

        ParserResult parserResult = urlParserFacadeService.execute(url, TagIncludeType.EXCLUDE, 100);

        assertThat(parserResult.getGroup(), not(StringUtils.EMPTY));

        System.out.println(parserResult);
    }
}