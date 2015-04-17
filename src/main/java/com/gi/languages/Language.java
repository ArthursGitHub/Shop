/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.languages;

import javax.servlet.http.Cookie;

/**
 *
 * @author garadagly
 */
public enum Language {

    RU("ru", "русский"), EN("en", "english"), DE("de", "deutsch");

    private final String code;
    private static Language defaultLanguage = RU;

    public static Language getDefaultLanguage() {
        return defaultLanguage;
    }

    public static void setDefaultLanguage(Language defaultLanguage) {
        Language.defaultLanguage = defaultLanguage;
    }
    private final String language;

    private Language(String code, String language) {
        this.code = code;
        this.language = language;
    }

    public String getCode() {
        return code;
    }

    public String getLanguage() {
        return language;
    }

    public static String getLanguage(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("language")) {
                    return cookie.getValue();
                }
            }
        }
        return defaultLanguage.code;
    }
}
