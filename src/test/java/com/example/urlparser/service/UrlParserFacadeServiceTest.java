package com.example.urlparser.service;

import com.example.urlparser.model.ParserResult;
import com.example.urlparser.model.type.TagIncludeType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UrlParserFacadeServiceTest {

//    @InjectMocks
//    private UrlCollectorService urlCollectorService;
//
//    @InjectMocks
//    private ParserService parserService;
//
//    @InjectMocks
//    private SortService sortService;
//
//    @InjectMocks
//    private FilterService filterService;

    // @InjectMocks
    private UrlParserFacadeService urlParserFacadeService;

    @Before
    public void setup(){
        UrlCollectorService urlCollectorService = new UrlCollectorService();
        ParserService parserService = new ParserService();
        SortService sortService = new SortService();
        FilterService filterService = new FilterService();
        MergeService mergeService = new MergeService();

        urlParserFacadeService =
            new UrlParserFacadeService(urlCollectorService, parserService, sortService, filterService, mergeService);
    }

    @Test
    public void urlParserFacadeService() {

        String url = "http://www.google.com";

        ParserResult parserResult = urlParserFacadeService.execute(url, TagIncludeType.EXCLUDE, 100);

        System.out.println(parserResult);
    }
}