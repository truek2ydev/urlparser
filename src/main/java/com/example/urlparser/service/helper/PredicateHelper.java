package com.example.urlparser.service.helper;

import java.util.function.Predicate;

/**
 * 필터링 조건 제공 Helper
 */
public class PredicateHelper {
    public static final Predicate<Character> NUMBER_PREDICATE = c -> ('0' <= c & c <= '9');
    public static final Predicate<Character> ENGLISH_PREDICATE = c -> ('a' <= c & c <= 'z' || 'A' <= c & c <= 'Z');
    public static final Predicate<Character> CHARACTER_PREDICATE = c -> (NUMBER_PREDICATE.test(c) || ENGLISH_PREDICATE.test(c));
}