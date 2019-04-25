package com.example.urlparser.controller.api;

import com.example.urlparser.model.ParserResult;
import com.example.urlparser.model.UrlParserRequest;
import com.example.urlparser.service.UrlParserFacadeService;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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

    private final UrlParserFacadeService urlParserFacadeService;

    @Autowired
    public UrlParserApiController(UrlParserFacadeService urlParserFacadeService) {
        this.urlParserFacadeService = urlParserFacadeService;
    }

    @ApiOperation(value = "URL 결과 요청")
    @GetMapping
    public ParserResult urlParser(@Valid UrlParserRequest urlParserRequest) {
        return urlParserFacadeService.execute(urlParserRequest);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List<String>> handleBindException(HttpServletRequest request, Exception e, BindingResult bindingResult) {
        List<String> errorMessages = new ArrayList<>();
        if (bindingResult.hasErrors()) {
            errorMessages = bindingResult.getAllErrors().stream().map(p-> p.getDefaultMessage()).collect(Collectors.toList());
        }
        log.error(String.format("Request : %s ", request.getRequestURL()) + errorMessages.toString(), e);
        ResponseEntity<List<String>> responseEntity = new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @ExceptionHandler
    public ResponseEntity<String> handleException(HttpServletRequest request, Exception e) {
        log.error(String.format("Request : %s ", request.getRequestURL()), e);
        HttpHeaders resHeaders = new HttpHeaders();
        resHeaders.add("Content-Type", "application/json;charset=UTF-8");
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), resHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}
