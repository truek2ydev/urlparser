package com.example.urlparser.model;

import com.example.urlparser.model.type.TagIncludeType;
import lombok.Data;

@Data
public class UrlParserRequest {
    private String url;
    private TagIncludeType TagIncludeType;
    private int groupSize;
}
