package com.example.urlparser.model;

import lombok.Value;

/**
 * 최종 결과 전달 클래스
 */
@Value
public class UrlParserResponse {
    public static final UrlParserResponse EMPTY = new UrlParserResponse("", "");
    String group;
    String remainder;
}
