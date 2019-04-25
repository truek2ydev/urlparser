package com.example.urlparser.service.helper;

import java.util.Comparator;

public class ComparatorHelper {

    /**
     * 숫자 정렬 비교 Comparator
     */
    public final static Comparator<Character> NUMBER = new Comparator<Character>() {
        @Override
        public int compare(Character o1, Character o2) {
            return Integer.compare(Integer.valueOf(o1), Integer.valueOf(o2));
        }
    };

    /**
     * 영어 정렬 비교 Comparator
     */
    public final static Comparator<Character> ENGLISH = new Comparator<Character>() {
        @Override
        public int compare(Character o1, Character o2) {
            return Integer.compare(sortPriority(o1), sortPriority(o2));
        }

        private int sortPriority(Character c) {
            int diff = 'a' - 'A';
            if (c >= 'a' && c <= 'z') {
                return (int) c * 2;
            } else {
                return (((int) c + diff) * 2 - 1);
            }
        }
    };
}
