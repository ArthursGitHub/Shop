/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.user;

import com.gi.shop.beans.ProductBean;
import com.gi.shop.hebirnate.Buy;
import com.gi.shop.hebirnate.BuyManager;
import com.gi.shop.hebirnate.Markets;
import com.gi.shop.hebirnate.service.BuyService;
import com.gi.shop.hebirnate.service.MarketsFacadeREST;
import java.text.DateFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ильяс
 */

public class HistoryBean {

    private String locale;
    private String userId;
    private List<Map<String, Object>> objects;


    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
        if (userId != null && locale != null) {
            Collection<Buy> buys = new  BuyService().findByUser(userId);
            DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT, Locale.forLanguageTag(locale));
            ProductBean pb = new ProductBean();
            pb.setLanguage(locale);
            for (Buy buy : buys) {
                HashMap<String, Object> object = new HashMap<>();
                MarketsFacadeREST marketsFacadeREST = new MarketsFacadeREST();
                Markets m = marketsFacadeREST.find(buy.getMarketId());
                object.put("buyDate", dateFormat.format(buy.getBuyDate()));
                pb.setBeanId(buy.getProductid().toString());
                object.put("productName", pb.getName());
                object.put("count", buy.getAmount());
                object.put("address", m.getAddress());
            }
        }
    }

    public List<Map<String, Object>> getObjects() {
        return objects;
    }

    public void setObjects(List<Map<String, Object>> objects) {
        this.objects = objects;
    }

}
