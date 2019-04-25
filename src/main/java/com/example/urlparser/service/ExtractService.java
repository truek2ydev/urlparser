package com.example.urlparser.service;

import com.example.urlparser.model.ExtractResult;
import com.example.urlparser.model.type.ExtractType;

/**
 * 추출 서비스 Interface
 */
public interface ExtractService {
    ExtractResult extractAndSort(String source);
    String extractAndSort(String source, ExtractType type);
}
