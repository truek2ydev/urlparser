package com.example.urlparser.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.example.urlparser.model.ParserResult;
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

        ParserResult parserResult = mergeService.groupResult(source, groupSize);

        assertThat(parserResult.getGroup(), is("A0A0a1a1BB"));
        assertThat(parserResult.getRemainder(), is("bb"));
    }

    /**
     * 출력묶음 결과 미달 조건 테스트
     */
    @Test
    public void result_oversize() {
        String source = "A0A0a1a1BBbb";
        int groupSize = 100;

        ParserResult parserResult = mergeService.groupResult(source, groupSize);

        assertThat(parserResult.getGroup(), is(""));
        assertThat(parserResult.getRemainder(), is("A0A0a1a1BBbb"));
    }

}
