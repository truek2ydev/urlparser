package com.example.urlparser.service;

import com.example.urlparser.model.ExtractResult;
import com.example.urlparser.model.type.ExtractType;
import com.example.urlparser.service.helper.ComparatorHelper;
import com.example.urlparser.service.helper.RegxHelper;
import com.example.urlparser.service.helper.SortHelper;
import org.springframework.stereotype.Service;

/**
 * Regx 기반 추출 정렬 서비스
 */
@Service(value = "regx")
public class ExtractServiceRegx implements ExtractService {

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
     * 숫자, 영어 타입 별 추출 정렬
     */
    public String extractAndSort(String source, ExtractType type) {
        switch (type) {
            case NUMBER:
                String number = source .replaceAll(RegxHelper.REGX_NUMBER_FILTER, "");
                return SortHelper.sort(number, ComparatorHelper.NUMBER);
            case ENGLISH:
                String english = source .replaceAll(RegxHelper.REGX_ENGLISH_FILTER, "");
                return SortHelper.sort(english, ComparatorHelper.ENGLISH);
            default:
                return "";
        }
    }

//    private String sort(String source, Comparator comparator) {
//        List<Character> list = source.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
//        Collections.sort(list, comparator);
//        String sortedResult = list.stream().map(String::valueOf).collect(Collectors.joining(""));
//        return sortedResult;
//    }
}
