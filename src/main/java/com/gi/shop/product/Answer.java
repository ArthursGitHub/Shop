/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.product;

import java.util.Date;

/**
 *
 * @author garadagly
 */
public class Answer {

    private String UserInfo;
    private String Text;
    private Date date;
    private Integer rating;

    public Answer(String UserInfo, String Text, Date date, Integer rating) {
        this.UserInfo = UserInfo;
        this.Text = Text;
        this.date = date;
        this.rating = rating;
    }

    public String getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(String UserInfo) {
        this.UserInfo = UserInfo;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
