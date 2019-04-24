package com.example.urlparser.service;

import com.example.urlparser.model.type.TagIncludeType;
import org.springframework.stereotype.Service;

@Service
public class FilterService {

    // TODO using config
    public static final String REGX_CHARACTER_FILTER = "[^A-Za-z0-9]";
    public static final String REGX_ENGLISH_FILTER = "[^A-Za-z]";
    public static final String REGX_NUMBER_FILTER = "[^0-9]";
//    public static final String REGX_TAG_FILTER = "<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>";
    public static final String REGX_TAG_FILTER = "<[^>]*>";

    public String charterFilter(String target){
        return target.replaceAll(REGX_CHARACTER_FILTER, "");
    }

    public String numberFilter(String target){
        return target.replaceAll(REGX_NUMBER_FILTER, "");
    }

    public String englishFilter(String target){
        return target.replaceAll(REGX_ENGLISH_FILTER, "");
    }

    public String tagFilter(String target, TagIncludeType tagIncludeType){
        switch (tagIncludeType){
            case EXCLUDE:
                return target.replaceAll(REGX_TAG_FILTER, "");
            default:
                return target;
        }
    }

}
