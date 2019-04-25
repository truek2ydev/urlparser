package com.example.urlparser.service;

import com.example.urlparser.model.UrlParserResponse;
import com.example.urlparser.model.UrlParserRequest;
import com.example.urlparser.model.type.ExtractType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UrlParser API 요청 처리 서비스
 */
@Service
public class UrlParserService {

    private final UrlCollectorService urlCollectorService;
    private final FilterService filterService;
    private final MergeService mergeService;
    private final ExtractService extractService;

    @Autowired
    public UrlParserService(UrlCollectorService urlCollectorService,
                            FilterService filterService,
                            ExtractServiceStream extractServiceStream,
                            MergeService mergeService) {
        this.urlCollectorService = urlCollectorService;
        this.filterService = filterService;
        this.extractService = extractServiceStream;
        this.mergeService = mergeService;
    }

    /**
     * URL 연결, 필터, 문자추출, 정렬, 병합, 그룹 조건 순차 처리
     * @param urlParserRequest
     * @return
     */
    public UrlParserResponse execute(UrlParserRequest urlParserRequest) {
        String contents = urlCollectorService.getContent(urlParserRequest.getUrl());
        String tagFilteredContents = filterService.tagFilter(contents, urlParserRequest.getTagIncludeType());

        String extractNumber = extractService.extractAndSort(tagFilteredContents, ExtractType.NUMBER);
        String extractEnglish = extractService.extractAndSort(tagFilteredContents, ExtractType.ENGLISH);
        String mergeContents = mergeService.merge(extractNumber, extractEnglish);

        UrlParserResponse urlParserResponse = mergeService.groupResult(mergeContents, urlParserRequest.getGroupSize());

        return urlParserResponse;
    }
}
