package com.gi.shop.beans;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.Cookie;

/**
 *
 * @author garadagly
 */
public class FilterBean {

    public HashMap<String, Set<String>> activeFilter;
    public HashMap<String, Set<String>> canChangeFilter;
    public String language;

    public FilterBean() {
        activeFilter = new HashMap<>();
        canChangeFilter = new HashMap<>();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public HashMap<String, Set<String>> getActiveFilter() {
        return activeFilter;
    }

    public void setActiveFilter(HashMap<String, Set<String>> activeFilter) {
        this.activeFilter = activeFilter;
    }

    public void setActiveFilter(Map<String, String[]> filterParametersMap) {
        activeFilter.clear();
        for (Map.Entry<String, String[]> entry : filterParametersMap.entrySet()) {
            try {
                Set<String> values = new TreeSet<>();
                for (String value : entry.getValue()) {
                    String decodedValue = URLDecoder.decode(value, "UTF-8");
                    values.add(decodedValue);
                }
                String decodedKey = URLDecoder.decode(entry.getKey(), "UTF-8");
                activeFilter.put(decodedKey, values);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(FilterBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        clearCanChangeFilter();
    }

    public void setActiveFilter(Cookie[] cookies) {
        activeFilter.clear();
        String filter = null;
        if (cookies == null) {
            return;
        }
        for (Cookie cookie : cookies) {
            try {
                String name = URLDecoder.decode(cookie.getName(), "UTF-8");
                if (name.equals("filter")) {
                    filter = URLDecoder.decode(cookie.getValue(), "UTF-8");
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(FilterBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String[] keys = null;
        if (filter != null && !filter.isEmpty()) {
            keys = filter.split(",");
        }
        if (keys != null) {
            for (String key : keys) {
                for (Cookie cookie : cookies) {
                    try {
                        String name = URLDecoder.decode(cookie.getName(), "UTF-8");
                        if (name.equals(key)) {
                            String values = URLDecoder.decode(cookie.getValue(), "UTF-8");
                            if (values != null) {
                                String[] valuesplit = values.split(",");
                                List<String> listOfValues = Arrays.asList(valuesplit);
                                Set<String> setOfValues = new TreeSet<>();
                                setOfValues.addAll(listOfValues);
                                activeFilter.put(key, setOfValues);
                                break;
                            }
                        }
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(FilterBean.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        clearCanChangeFilter();
    }

    public HashMap<String, Set<String>> getCanChangeFilter() {
        return canChangeFilter;
    }

    public void setCanChangeFilter(HashMap<String, Set<String>> canChangeFilter) {
        this.canChangeFilter = canChangeFilter;
    }

    private void clearCanChangeFilter() {
        for (Map.Entry<String, Set<String>> entry : activeFilter.entrySet()) {
            Set<String> values = canChangeFilter.get(entry.getKey());
            Set<String> activeValues = entry.getValue();
            for (String value : activeValues) {
                values.remove(value);
            }
        }
    }

    public boolean isValid(ProductBean product) {
        if (activeFilter.isEmpty()) {
            return true;
        }
        HashMap<String, String> productProperties = product.getProperties();
        for (Map.Entry<String, String> prop : productProperties.entrySet()) {
            if (activeFilter.containsKey(prop.getKey())) {
                Set<String> activeValues = activeFilter.get(prop.getKey());
                if (!activeValues.contains(prop.getValue())) {
                    return false;
                }
            }
        }
        return true;
    }
}
