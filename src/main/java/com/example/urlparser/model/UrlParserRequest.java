package com.example.urlparser.model;

import com.example.urlparser.model.type.TagIncludeType;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UrlParser API 요청 클래스
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlParserRequest {
    @NotEmpty(message = "{url.notEmpty}")
    private String url;
    private TagIncludeType TagIncludeType;
    @NotNull(message = "{groupSize.notEmpty}")
    private Integer groupSize;
}
