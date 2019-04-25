package com.example.urlparser.service.helper;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortHelperTest {

    @Test
    public void sort() {
    }

    @Test
    public void sortNumber() {
        String number = "9876";
        String result = SortHelper.sort(number, ComparatorHelper.NUMBER);
        assertThat(result, is("6789"));
    }

    /**
     * 영문 정렬 테스트 ( AaBb...Zz)
     */
    @Test
    public void sortEnglish() {
        String english = "cCbBaA";
        String result = SortHelper.sort(english, ComparatorHelper.ENGLISH);
        assertThat(result, is("AaBbCc"));
    }
}