package com.example.urlparser.service;

import com.example.urlparser.model.type.TagIncludeType;
import com.example.urlparser.service.helper.RegxHelper;
import org.springframework.stereotype.Service;

/**
 * Regx 기반 문자열 제거 서비스
 */
@Service
public class FilterService {

    /**
     * 숫자, 영어 문자 추출
     *
     * @param target
     * @return
     */
    public String charterFilter(String target) {
        return target.replaceAll(RegxHelper.REGX_CHARACTER_FILTER, "");
    }

    /**
     * 숫자문자 추출
     *
     * @param target
     * @return
     */
    public String numberFilter(String target) {
        return target.replaceAll(RegxHelper.REGX_NUMBER_FILTER, "");
    }

    /**
     * 영어문자 추출
     *
     * @param target
     * @return
     */
    public String englishFilter(String target) {
        return target.replaceAll(RegxHelper.REGX_ENGLISH_FILTER, "");
    }

    /**
     * 태그 포함, 제거 적용 필터
     *
     * @param target
     * @param tagIncludeType
     * @return
     */
    public String tagFilter(String target, TagIncludeType tagIncludeType) {
        switch (tagIncludeType) {
            case EXCLUDE:
                return target.replaceAll(RegxHelper.REGX_TAG_FILTER, "");
            default:
                return target;
        }
    }
}
