package com.example.urlparser.service;

import com.sun.org.apache.xml.internal.utils.StringComparable;
import org.springframework.stereotype.Service;

import java.text.CollationKey;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

/**
 * TODO sort strategy refactory
 * TODO sort template
 */

@Service
public class SortService {
    public String sortNumber(String target){
        char[] targetChars = target.toCharArray();
        List<Character> list = new ArrayList<Character>();

        for (char c : targetChars) {
            list.add(c);
        }

        Collections.sort(list, new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                return -Integer.compare(Integer.valueOf(o1), Integer.valueOf(02));
            }
        });
        String sortedResult = list.toString();
        return sortedResult;
    }


    public String sortEnglish(String target){
        char[] targetChars = target.toCharArray();
        List<Character> list = new ArrayList<Character>();
        for (char c : targetChars) {
            list.add(c);
        }

        Collections.sort(list, new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(sortIndex(o1), sortIndex(o2));
            }

            private int sortIndex( Character c ) {
                // validate
                // not [a-z A-Z] return 0;
                int diff = 'A' -  'a';
                if( c >= 'a' && c <= 'z'){
                    return (int)c * 2;
                }else{
                    return (( (int)c + 32) * 2 -1 );
                }
            }
        });

        String sortedResult = list.toString();
        return sortedResult;
    }
}
