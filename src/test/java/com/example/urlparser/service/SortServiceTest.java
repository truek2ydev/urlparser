package com.example.urlparser.service;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SortServiceTest {

    @InjectMocks
    private SortService sortService;

    /**
     * 숫자 정렬 테스트 (오름차순)
     */
    @Test
    public void sortNumber() {
        String number = "9876";

        String result = sortService.sortNumber(number);
        assertThat(result, is("6789"));
    }

    /**
     * 영문 정렬 테스트 ( AaBb...Zz)
     */
    @Test
    public void sortEnglish() {
        String english = "cCbBaA";

        String result = sortService.sortEnglish(english);

        assertThat(result, is("AaBbCc"));
    }
}