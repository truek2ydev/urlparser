package com.example.urlparser.service;

import com.example.urlparser.model.ParserResult;
import com.example.urlparser.model.UrlParserRequest;
import com.example.urlparser.model.type.TagIncludeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlParserFacadeService {
//    @Autowired
    private  final UrlCollectorService urlCollectorService;

//    @Autowired
    private final ParserService parserService;

//    @Autowired
    private  final SortService sortService;

    private  final FilterService filterService;

    private  final MergeService mergeService;

    @Autowired
    public UrlParserFacadeService(UrlCollectorService urlCollectorService, ParserService parserService, SortService sortService, FilterService filterService,
        MergeService mergeService) {
        this.urlCollectorService = urlCollectorService;
        this.parserService = parserService;
        this.sortService = sortService;
        this.filterService = filterService;
        this.mergeService = mergeService;
    }

    public ParserResult execute(String url, TagIncludeType tagIncludeType, int groupSize) {
        // TODO validate
        String contents = urlCollectorService.getContent(url);

        String tagFilteredContents = filterService.tagFilter(contents, tagIncludeType);

        String numberContents = filterService.numberFilter(tagFilteredContents);
        String englishContents = filterService.englishFilter(tagFilteredContents);

        String sortedNumberContents = sortService.sortNumber(numberContents);
        String sortedEnglishContents = sortService.sortEnglish(englishContents);

        String mergeContents = mergeService.merge(sortedNumberContents, sortedEnglishContents);

        ParserResult parserResult = mergeService.groupResult(mergeContents, groupSize);


        return parserResult;

    }

    public ParserResult execute(UrlParserRequest urlParserRequest) {
        return execute(urlParserRequest.getUrl(), urlParserRequest.getTagIncludeType(), urlParserRequest.getGroupSize());
    }
}
