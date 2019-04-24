package com.example.urlparser.service;

import com.example.urlparser.model.ParserResult;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MergeService {

    public String merge(String number, String english){

        List<Character> mergeResult = new ArrayList<>();

        int numberIndex = 0 ;
        int englishIndex = 0 ;
        boolean order = true ;

        while (numberIndex < number.length() || englishIndex < english.length()) {
            if(order && englishIndex < english.length()) {
                mergeResult.add(english.charAt(englishIndex));
                englishIndex++;
                order = ( numberIndex < number.length()) ? false: true;
            }else if( !order && numberIndex < number.length()){
                mergeResult.add(number.charAt(numberIndex));
                numberIndex++;
                order = ( englishIndex < english.length()) ? true: false;
            }
        }

        String result = mergeResult.stream().map(String::valueOf).collect(Collectors.joining(""));

        return result;
    }

    public ParserResult groupResult(String source, int groupSize) {

        int resultIndex = source.length() / groupSize;
        int remainderIndex = source.length() % groupSize;

        String grouped = ( resultIndex > 0 ) ? source.substring(0, resultIndex * groupSize ): "";
        String remainded = ( resultIndex == 0 ) ? source : source.substring(resultIndex * groupSize );

        ParserResult parserResult = new ParserResult(grouped, remainded);
        return parserResult;
//        return ParserResult.EMPTY;
    }
}
