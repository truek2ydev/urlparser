package com.example.urlparser.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import com.example.urlparser.model.type.TagIncludeType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FilterServiceTest {

    @InjectMocks
    private FilterService filterService;

    @Test
    public void characterFilterTest(){

        // given
        String source = "ABCDabcd!@#$1234한글日本の中國";

        // when
        String filtered = filterService.charterFilter(source);

        assertThat(filtered, is("ABCDabcd1234"));

        // TODO regx match assert
//        assertTrue(filtered.matches("[A-Za-z0-9]"));
    }

    @Test
    public void numberFilterTest(){

        // given
        String source = "ABCDabcd!@#$1234한글日本の中國";

        // when
        String filtered = filterService.numberFilter(source);

        assertThat(filtered, is("1234"));

        // TODO regx match assert
//        assertTrue(filtered.matches("[A-Za-z0-9]"));
    }

    @Test
    public void englishFilterTest(){

        // given
        String source = "ABCDabcd!@#$1234한글日本の中國";

        // when
        String filtered = filterService.englishFilter(source);

        assertThat(filtered, is("ABCDabcd"));

        // TODO regx match assert
//        assertTrue(filtered.matches("[A-Za-z0-9]"));
    }


    @Test
    public void tagFilterTest_exclude(){

        // given
        String source = "<a>ABCDabcd!@#$1234한글日本の中國</a>";

        // when
        String filtered = filterService.tagFilter(source, TagIncludeType.EXCLUDE);

        assertThat(filtered, is("ABCDabcd!@#$1234한글日本の中國"));

        // TODO regx match assert
//        assertTrue(filtered.matches("[A-Za-z0-9]"));
    }

    @Test
    public void tagFilterTest_include(){

        // given
        String source = "<a>ABCDabcd!@#$1234한글日本の中國</a>";

        // when
        String filtered = filterService.tagFilter(source, TagIncludeType.INCLUDE);

        assertThat(filtered, is("<a>ABCDabcd!@#$1234한글日本の中國</a>"));

        // TODO regx match assert
//        assertTrue(filtered.matches("[A-Za-z0-9]"));
    }



}