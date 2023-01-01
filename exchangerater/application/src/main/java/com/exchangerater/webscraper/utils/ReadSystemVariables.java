package com.exchangerater.webscraper.utils;

public class ReadSystemVariables {

    private static final String GOOGLE_SRCH_CX = "GOOGLE_SRCH_CX";
    private static final String GOOGLE_SRCH_API_KEY = "GOOGLE_SRCH_API_KEY";

    private ReadSystemVariables() {}

    public static String getGoogleSrchCxKey() {
        return System.getenv(GOOGLE_SRCH_CX);
    }

    public static String getGoogleSrchApiKey() {
        return System.getenv(GOOGLE_SRCH_API_KEY);
    }
}
