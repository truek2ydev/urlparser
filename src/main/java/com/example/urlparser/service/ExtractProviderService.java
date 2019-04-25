package com.example.urlparser.service;

import com.example.urlparser.model.type.ExtractServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 구현 방식별 추출 서비스 제공 Provider
 * 구현 방식 (String, Regx)
 */
@Service
public class ExtractProviderService {

    @Autowired
    ExtractServiceStream extractServiceStream;

    @Autowired
    ExtractServiceRegx extractServiceRegx;

    public ExtractService get(ExtractServiceType extractServiceType) {
        switch (extractServiceType) {
            case REGX:
                return extractServiceRegx;
            default:
                return extractServiceStream;
        }
    }
}
