package com.example.urlparser.service;

import com.example.urlparser.model.ExtractResult;
import com.example.urlparser.model.type.ExtractType;
import com.example.urlparser.service.helper.ComparatorHelper;
import com.example.urlparser.service.helper.PredicateHelper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 스트림 기반 추출 정렬 서비스
 */
@Service(value = "stream")
public class ExtractServiceStream implements ExtractService {

    /**
     * 숫자, 영어 일괄 추출 정렬
     * @param source
     * @return
     */
    public ExtractResult extractAndSort(String source) {
        ExtractResult extractResult = new ExtractResult();
        extractResult.add(ExtractType.NUMBER, extractAndSort(source, ExtractType.NUMBER));
        extractResult.add(ExtractType.ENGLISH, extractAndSort(source, ExtractType.ENGLISH));
        return extractResult;
    }

    /**
     * 숫자, 영어 타입멸 추출 정렬
     * @param source
     * @param type
     * @return
     */
    public String extractAndSort(String source, ExtractType type) {
        switch (type) {
            case NUMBER:
                return extractAndSort(source, PredicateHelper.NUMBER_PREDICATE, ComparatorHelper.NUMBER);
            case ENGLISH:
                return extractAndSort(source, PredicateHelper.ENGLISH_PREDICATE, ComparatorHelper.ENGLISH);
            default:
                return "";
        }
    }

    private String extractAndSort(String source, Predicate<Character> predicate, Comparator<Character> comparator) {
        String result = source.chars().mapToObj(e -> (char) e)
                .filter(predicate)
                .sorted(comparator)
                .map(String::valueOf)
                .collect(Collectors.joining());
        return result;
    }
}
