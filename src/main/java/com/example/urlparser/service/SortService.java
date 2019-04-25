package com.example.urlparser.service;

import com.example.urlparser.service.helper.ComparatorHelper;
import com.example.urlparser.service.helper.SortHelper;
import org.springframework.stereotype.Service;

@Service
public class SortService {
    public String sortNumber(String target) {
        return SortHelper.sort(target, ComparatorHelper.NUMBER);
    }

    public String sortEnglish(String target) {
        return SortHelper.sort(target, ComparatorHelper.ENGLISH);
    }
}
