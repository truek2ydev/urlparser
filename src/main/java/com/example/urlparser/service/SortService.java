package com.example.urlparser.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * TODO sort strategy refactory
 * TODO sort template
 */

@Service
public class SortService {
    public String sortNumber(String target){
        Comparator numberComparator =new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(Integer.valueOf(o1), Integer.valueOf(o2));
            }
        };

        return makeSortedString(target, numberComparator);
    }

    private String makeSortedString(String target, Comparator comparator) {
        List<Character> list = target.chars().mapToObj( c -> (char)c) .collect(Collectors.toList());
        Collections.sort(list, comparator);
        String sortedResult = list.stream().map(String::valueOf).collect(Collectors.joining(""));
        return sortedResult;
    }


    public String sortEnglish(String target){
        Comparator englishComparator =new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                return Integer.compare(sortPriority(o1), sortPriority(o2));
            }

            private int sortPriority( Character c ) {
                // validate
                // not [a-z A-Z] return 0;
                int diff = 'a' - 'A' ;
                if( c >= 'a' && c <= 'z'){
                    return (int)c * 2;
                }else{
                    return (( (int)c + diff) * 2 -1 );
                }
            }
        };

        return makeSortedString(target, englishComparator);
//        List<Character> list = target.chars().mapToObj( c -> (char)c) .collect(Collectors.toList());
//
//        Collections.sort(list, new Comparator<Character>(){
//            @Override
//            public int compare(Character o1, Character o2) {
//                return Integer.compare(sortPriority(o1), sortPriority(o2));
//            }
//
//            private int sortPriority( Character c ) {
//                // validate
//                // not [a-z A-Z] return 0;
//                int diff = 'a' - 'A' ;
//                if( c >= 'a' && c <= 'z'){
//                    return (int)c * 2;
//                }else{
//                    return (( (int)c + diff) * 2 -1 );
//                }
//            }
//        });
//
//        String sortedResult = list.stream().map(String::valueOf).collect(Collectors.joining(""));
//        return sortedResult;
    }
}
