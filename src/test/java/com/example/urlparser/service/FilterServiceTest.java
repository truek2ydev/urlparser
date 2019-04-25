package com.example.urlparser.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import com.example.urlparser.model.type.TagIncludeType;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class FilterServiceTest {

    public static final String TAGED_TEST_STRING = "<a>ABCDabcd!@#$1234한글日本の中國</a>";
    public static final String TEST_STRING = "ABCDabcd!@#$1234한글日本の中國";

    @InjectMocks
    private FilterService filterService;

    /**
     * 대상 문자열 필터 테스트
     */
    @Test
    public void characterFilterTest() {
        String source = TEST_STRING;
        String filtered = filterService.charterFilter(source);
        assertThat(filtered, is("ABCDabcd1234"));
        assertTrue(filtered.matches("[A-Za-z0-9]*"));
    }

    /**
     * 숫자 필터링 테스트
     */
    @Test
    public void numberFilterTest() {
        String source = TEST_STRING;
        String filtered = filterService.numberFilter(source);
        assertThat(filtered, is("1234"));
        assertTrue(filtered.matches("[0-9]*"));
    }

    /**
     * 숫자 미확인 테스트
     */
    @Test
    public void numberFilterTest_nonNumber() {
        String source = "ABCDabcd!@#$한글日本の中國";
        String filtered = filterService.numberFilter(source);
        assertThat(filtered, is(StringUtils.EMPTY));
    }

    /**
     * 영어 필터 테스트
     */
    @Test
    public void englishFilterTest() {
        String source = TEST_STRING;
        String filtered = filterService.englishFilter(source);
        assertThat(filtered, is("ABCDabcd"));
        assertTrue(filtered.matches("[A-Za-z]*"));
    }

    /**
     * 영어 미확인 테스트
     */
    @Test
    public void englishFilterTest_nonEnglish() {
        String source = "!@#$1234한글日本の中國";
        String filtered = filterService.englishFilter(source);
        assertThat(filtered, is(StringUtils.EMPTY));
    }

    /**
     * 태그 제외 테스트
     */
    @Test
    public void tagFilterTest_exclude() {
        String source = TAGED_TEST_STRING;
        String filtered = filterService.tagFilter(source, TagIncludeType.EXCLUDE);
        assertThat(filtered, is("ABCDabcd!@#$1234한글日本の中國"));
    }

    /**
     * 중간 태그 제외 테스트
     */
    @Test
    public void tagFilterTest_excludeMiddle() {
        String source = "ABCDabcd<a>!@#$1234</a>한글日本の中國";
        String filtered = filterService.tagFilter(source, TagIncludeType.EXCLUDE);
        assertThat(filtered, is("ABCDabcd!@#$1234한글日本の中國"));
    }

    /**
     * 태그 포함 테스트 (유지 상태)
     */
    @Test
    public void tagFilterTest_include() {
        String source = TAGED_TEST_STRING;
        String filtered = filterService.tagFilter(source, TagIncludeType.INCLUDE);
        assertThat(filtered, is("<a>ABCDabcd!@#$1234한글日本の中國</a>"));
    }
}