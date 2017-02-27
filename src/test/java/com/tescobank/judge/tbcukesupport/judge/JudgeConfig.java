package com.tescobank.judge.tbcukesupport.judge;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by pabloarroyo on 02/12/2016.
 */
public class JudgeConfig {
    public static boolean testBackEnd() {
        return getSystemProperty("TEST_BACKEND", false);
    }

    private static Boolean getSystemProperty(String property, boolean defaultValue) {
        String value = getSystemProperty(property, null);
        return value == null ? defaultValue : Boolean.parseBoolean(value);
    }

    private static String getSystemProperty(String property, String defaultValue) {
        String value = System.getProperty(property);
        return StringUtils.isBlank(value) ? defaultValue : value;
    }

}
