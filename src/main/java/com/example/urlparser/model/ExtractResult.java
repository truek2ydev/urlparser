package com.example.urlparser.model;

import com.example.urlparser.model.type.ExtractType;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 추출 결과 저장 및 전달 클래스
 */
@Data
public class ExtractResult {
    private Map<ExtractType, String> extractMap;

    public ExtractResult() {
        extractMap = new HashMap<>();
    }

    public void add(ExtractType type, String data) {
        extractMap.put(type, data);
    }

    public String get(ExtractType type) {
        return extractMap.get(type);
    }


}
