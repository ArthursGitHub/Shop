/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.card;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Ильяс
 */
public class CardBean {

    private Map<Integer, Integer> products = new HashMap<>();

    public Map<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Integer, Integer> products) {
        this.products = products;
    }

    public void putProduct(Integer id, Integer count) {
        if (products.containsKey(id)) {
            Integer oldCount = products.get(id);
            oldCount += count;
            if (oldCount == 0) {
                products.remove(id);
            } else {
                products.put(id, oldCount);
            }
        } else {
            if (count > 0) {
                products.put(id, count);
            }
        }
    }

}
