package com.gi.shop.hebirnate.service;

import com.gi.shop.hebirnate.Buy;
import com.gi.shop.hebirnate.BuyManager;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Класс предназначен для
 *
 * @author garadagly
 */
@Stateless
@Path("/buys")
public class BuyService {

    @PersistenceContext(unitName = "com.gi_Shop_war_0.0.1-snapshot")
    private EntityManager em;

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Collection<Buy> findByUser(@PathParam("id") String id) {
        return BuyManager.getBuyByUserId(id,em);
    }
}
