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


    @Test
    public void merge() {
        String number = "0011";
        String english = "AAaaBBbb";
        String result = mergeService.merge(number, english);
        assertThat(result, is("A0A0a1a1BBbb"));
    }

    @Test
    public void result() {
        String source = "A0A0a1a1BBbb";
        int groupSize = 5;

        ParserResult parserResult = mergeService.groupResult(source, groupSize);

        assertThat(parserResult.getGroup(), is("A0A0a1a1BB"));
        assertThat(parserResult.getRemainder(), is("bb"));
    }

    @Test
    public void result_oversize() {
        String source = "A0A0a1a1BBbb";
        int groupSize = 100;

        ParserResult parserResult = mergeService.groupResult(source, groupSize);

        assertThat(parserResult.getGroup(), is(""));
        assertThat(parserResult.getRemainder(), is("A0A0a1a1BBbb"));
    }

}
