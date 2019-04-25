package com.example.urlparser.service.helper;

/**
 * Regx Expression 제공 Helper
 */
public class RegxHelper {
    public static final String REGX_CHARACTER_FILTER = "[^A-Za-z0-9]";
    public static final String REGX_ENGLISH_FILTER = "[^A-Za-z]";
    public static final String REGX_NUMBER_FILTER = "[^0-9]";
    public static final String REGX_TAG_FILTER = "<[^>]*>";
}