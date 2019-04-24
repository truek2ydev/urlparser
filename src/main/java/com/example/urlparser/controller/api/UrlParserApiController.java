package com.example.urlparser.controller.api;

import com.example.urlparser.model.ParserResult;
import com.example.urlparser.model.UrlParserRequest;
import com.example.urlparser.service.UrlParserFacadeService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/url/parser")
public class UrlParserApiController {


    private final UrlParserFacadeService urlParserFacadeService;

    @Autowired
    public UrlParserApiController(UrlParserFacadeService urlParserFacadeService) {
        this.urlParserFacadeService = urlParserFacadeService;
    }

    @GetMapping
    public ParserResult urlParser(@Valid UrlParserRequest urlParserRequest) {
        return urlParserFacadeService.execute(urlParserRequest);
    }

}
