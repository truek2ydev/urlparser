package com.example.urlparser.service;

import com.example.urlparser.model.ExtractResult;
import com.example.urlparser.model.UrlParserResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.urlparser.model.type.ExtractType;
import org.springframework.stereotype.Service;

/**
 * 숫자문자열과 영문문자열을 병합
 * 수차적으로 병합하며, 잔여 문자는 순자적으로 병함
 */
@Service
public class MergeService {

    public String merge(ExtractResult extractResult) {
        return merge(extractResult.get(ExtractType.NUMBER), extractResult.get(ExtractType.ENGLISH));
    }

    public String merge(String number, String english) {

        List<Character> mergeResult = new ArrayList<>();

        int numberIndex = 0;
        int englishIndex = 0;
        boolean order = true;

        while (numberIndex < number.length() || englishIndex < english.length()) {
            if (order && englishIndex < english.length()) {
                mergeResult.add(english.charAt(englishIndex));
                englishIndex++;
                order = (numberIndex < number.length()) ? false : true;
            } else if (!order && numberIndex < number.length()) {
                mergeResult.add(number.charAt(numberIndex));
                numberIndex++;
                order = (englishIndex < english.length()) ? true : false;
            }
        }

        String result = mergeResult.stream().map(String::valueOf).collect(Collectors.joining(""));

        return result;
    }

    public UrlParserResponse groupResult(String source, int groupSize) {
        int resultIndex = source.length() / groupSize;

        String grouped = (resultIndex > 0) ? source.substring(0, resultIndex * groupSize) : "";
        String remainder = (resultIndex == 0) ? source : source.substring(resultIndex * groupSize);

        UrlParserResponse urlParserResponse = new UrlParserResponse(grouped, remainder);
        return urlParserResponse;
    }
}
