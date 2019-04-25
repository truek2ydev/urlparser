package com.example.urlparser.exception;

/**
 * url 요청시 발생하는 커스텀 메시지 전달 위한 Custom Exception
 */
public class UrlHandleException extends RuntimeException {
    public UrlHandleException(String message) {
        super(message);
    }
}
