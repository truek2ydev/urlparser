package com.example.urlparser.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortServiceTest {

    @Test
    public void sortNumber() {
        SortService sortService = new SortService();
        String result = sortService.sortNumber("9876");
        assertThat(result, is("6789"));
    }

    @Test
    public void sortEnglish() {
        SortService sortService = new SortService();
        String result = sortService.sortEnglish("cCbBaA");
        assertThat(result, is("AaBbCc"));
    }

    @Test
    public void charInt(){
        String lower = "az"; //97 ~ 122
        String upper = lower.toUpperCase();

        for (char c : lower.toCharArray()) {
            System.out.println((int)c);
        }

        for (char c : upper.toCharArray()) {
            System.out.println(( (int)c));
        }

        for (char c : lower.toCharArray()) {
            System.out.println((int)c * 2);
        }

        for (char c : upper.toCharArray()) {
            System.out.println(( (int)c + 32) * 2 -1 );
        }
    }

    @Test
    public void sortTest(){
//        List<Character> Listlist = Arrays.asList('b','B', 'a','A');
        List<String> list = Arrays.asList("b","B", "a","A");

        Collections.sort(list, Collator.getInstance(Locale.ENGLISH));

        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

    }
}