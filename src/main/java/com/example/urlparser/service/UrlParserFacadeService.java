package com.example.urlparser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Parser;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UrlParserFacadeService {
    @Autowired
    UrlCollectorService urlCollectorService;

    @Autowired
    ParserService parserService;

    @Autowired
    SortService sortService;

    public List<String> UrlParserFacadeService(String url) {
        // TODO validate


        String contents = urlCollectorService.getContent(url);


        //return Arrays

        return Collections.EMPTY_LIST;

    }
}
