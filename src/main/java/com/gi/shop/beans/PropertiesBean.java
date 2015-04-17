/*
 * To change this license header, choose License Headers in Project PropertiesBean.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.beans;

import com.gi.languages.Language;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 *
 * @author garadagly
 */
public class PropertiesBean {

    String currentLanguage = Language.getDefaultLanguage().getCode();

    public ResourceBundle asd(Language language) {
        currentLanguage = language.getCode();
        try {
            ResourceBundle resources;
            switch (currentLanguage) {
                case "ru":
                    InputStreamReader fis = new InputStreamReader(new FileInputStream("myres_ru_RU.properies"), "UTF-8");
                    try {
                        resources = new PropertyResourceBundle(fis);
                    } finally {
                        fis.close();
                    }
                    break;
                case "en":
                    fis = new InputStreamReader(new FileInputStream("myres_en_US.properies"), "UTF-8");
                    try {
                        resources = new PropertyResourceBundle(fis);
                    } finally {
                        fis.close();
                    }
                    break;
                case "de":
                    fis = new InputStreamReader(new FileInputStream("myres_de.properies"), "UTF-8");
                    try {
                        resources = new PropertyResourceBundle(fis);
                    } finally {
                        fis.close();
                    }
                    break;
                default:
                    fis = new InputStreamReader(new FileInputStream("myres_ru_RU.properies"), "UTF-8");
                    try {
                        resources = new PropertyResourceBundle(fis);
                    } finally {
                        fis.close();
                    }
                    break;
            }
            return resources;
        } catch (Exception e) {
        }
        return null;
    }
}
