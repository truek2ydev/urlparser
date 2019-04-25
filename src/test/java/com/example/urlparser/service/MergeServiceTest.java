package com.example.urlparser.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.example.urlparser.model.UrlParserResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MergeServiceTest {

    @InjectMocks
    MergeService mergeService;

    /**
     * 병합 테스트
     */
    @Test
    public void mergeTest() {
        String number = "0011";
        String english = "AAaaBBbb";
        String result = mergeService.merge(number, english);
        assertThat(result, is("A0A0a1a1BBbb"));
    }

    /**
     * 출력묶음 결과 테스트
     */
    @Test
    public void groupResultTest() {
        String source = "A0A0a1a1BBbb";
        int groupSize = 5;

        UrlParserResponse urlParserResponse = mergeService.groupResult(source, groupSize);

        assertThat(urlParserResponse.getGroup(), is("A0A0a1a1BB"));
        assertThat(urlParserResponse.getRemainder(), is("bb"));
    }

    /**
     * 출력묶음 결과 미달 조건 테스트
     */
    @Test
    public void result_oversize() {
        String source = "A0A0a1a1BBbb";
        int groupSize = 100;

        UrlParserResponse urlParserResponse = mergeService.groupResult(source, groupSize);

        assertThat(urlParserResponse.getGroup(), is(""));
        assertThat(urlParserResponse.getRemainder(), is("A0A0a1a1BBbb"));
    }

}
