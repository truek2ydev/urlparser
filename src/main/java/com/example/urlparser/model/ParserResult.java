package com.example.urlparser.model;

import lombok.Value;

@Value
public class ParserResult {
    public static final ParserResult EMPTY = new ParserResult("", "");
    String group ;
    String remainder;
}
