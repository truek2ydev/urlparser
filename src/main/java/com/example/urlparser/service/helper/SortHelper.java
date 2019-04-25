package com.example.urlparser.service.helper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Comparator 기반 스트링 정렬 Helper
 */
public class SortHelper {
    public static String sort(String source, Comparator comparator) {
        List<Character> list = source.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        Collections.sort(list, comparator);
        String sortedResult = list.stream().map(String::valueOf).collect(Collectors.joining(""));
        return sortedResult;
    }
}
