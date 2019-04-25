package com.example.urlparser.controller.api;

import com.example.urlparser.model.UrlParserResponse;
import com.example.urlparser.model.UrlParserRequest;
import com.example.urlparser.service.UrlParserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/url/parser")
public class UrlParserApiController {

    private final UrlParserService urlParserService;

    @Autowired
    public UrlParserApiController(UrlParserService urlParserService) {
        this.urlParserService = urlParserService;
    }

    /**
     * url parser 요청 처리 API
     *
     * @param urlParserRequest
     * @return
     */
    @ApiOperation(value = "URL 결과 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "url", value = "URL", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "TagIncludeType", value = "TYPE", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "groupSize", value = "출력묶음단위", required = true, dataType = "int", paramType = "query")
    })
    @GetMapping
    public UrlParserResponse urlParser(@ApiParam(hidden = true) @Valid UrlParserRequest urlParserRequest) {
        return urlParserService.execute(urlParserRequest);
    }

    /**
     * api validate exception handler
     *
     * @param request
     * @param e
     * @param bindingResult
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<String>> handleBindException(HttpServletRequest request, Exception e, BindingResult bindingResult) {
        List<String> errorMessages = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            errorMessages = bindingResult.getAllErrors().stream().map(p -> p.getDefaultMessage()).collect(Collectors.toList());
        }
        log.error(String.format("Request : %s ", request.getRequestURL()) + errorMessages.toString(), e);
        ResponseEntity<List<String>> responseEntity = new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    /**
     * api controller exception handler
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<String> handleException(HttpServletRequest request, Exception e) {
        log.error(String.format("Request : %s ", request.getRequestURL()), e);
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), resHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
