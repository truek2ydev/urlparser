package com.example.urlparser.service;

import com.example.urlparser.model.type.ExtractServiceType;
import com.example.urlparser.model.type.ExtractType;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ExtractServiceTest {
    public static final String TEST_STRING = "ABCDabcd!@#$9876한글日本の中國54321ZYXzyx";

    @InjectMocks
    private ExtractServiceStream extractServiceStream;

    @InjectMocks
    private ExtractServiceRegx extractServiceRegx;

    /**
     * 숫자 추출 및 정렬 테스트(stream)
     */
    @Test
    public void extractNumber_stream() {
        String source  = TEST_STRING;
        String extracted = extractServiceStream.extractAndSort(source, ExtractType.NUMBER);
        assertThat(extracted, is("123456789") );
    }

    /**
     * 숫자 추출 및 정렬 테스트(regx)
     */
    @Test
    public void extractNumber_regx() {
        String source  = TEST_STRING;
        String extracted = extractServiceRegx.extractAndSort(source, ExtractType.NUMBER);
        assertThat(extracted, is("123456789") );
    }

    /**
     * 영어문자 추출 및 정렬 테스트 (stream)
     */
    @Test
    public void extractEnglish_stream() {
        String source  = TEST_STRING;
        String extracted = extractServiceStream.extractAndSort(source, ExtractType.ENGLISH);
        assertThat(extracted, is("AaBbCcDdXxYyZz") );
    }

    /**
     * 영어문자 추출 및 정렬 테스트 (regx)
     */
    @Test
    public void extractEnglish_regx() {
        String source  = TEST_STRING;
        String extracted = extractServiceRegx.extractAndSort(source, ExtractType.ENGLISH);
        assertThat(extracted, is("AaBbCcDdXxYyZz") );
    }
}