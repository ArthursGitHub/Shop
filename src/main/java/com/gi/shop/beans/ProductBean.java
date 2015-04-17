/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.beans;

import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "beanId",
    "imgUrl",
    "name",
    "properties",
    "price"
})
/**
 *
 * @author Ильяс
 */
public class ProductBean implements Serializable {

    @JsonProperty("beanId")
    private String beanId;

    @JsonProperty("imgUrl")
    private String imgUrl;

    @JsonProperty("name")
    private String name;

    @JsonProperty("language")
    private String language;

    private HashMap<String, String> properties;

    @JsonProperty("price")
    private Integer price;

    @JsonProperty("description")
    private String description;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @JsonProperty("beanId")
    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
        ObjectMapper mapper = new ObjectMapper();
        ProductBean ds;
        try {
            ds = mapper.readValue(new File("products/" + language + "/" + beanId + ".json"), ProductBean.class);
            this.description = ds.description;
            this.imgUrl = ds.imgUrl;
            this.name = ds.name;
            this.price = ds.price;
            this.properties = ds.properties;
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @JsonProperty("imgUrl")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, String> properties) {
        this.properties = properties;
    }

}
