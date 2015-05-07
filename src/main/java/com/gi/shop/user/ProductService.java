/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.user;

import com.gi.shop.beans.ProductBean;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Ильяс
 */
@Stateless
@Path("/products")
public class ProductService {

    @GET
    @Path("{id}/{le}")
    @Produces({"application/xml", "application/json"})
    public ProductBean getProduct(@PathParam("id") String id, @PathParam("le") String locale) {
        ProductBean bean = new ProductBean();
        bean.setLanguage(locale);
        bean.setBeanId(id);
        return bean;
    }
}
