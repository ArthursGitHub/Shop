/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.hebirnate;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ильяс
 */
public class BuyManager {

    public static Collection<Buy> getBuyByUserId(String userId, EntityManager em) {
        Query createNamedQuery = em.createNamedQuery("Buy.findByUserid");
        createNamedQuery.setParameter("userid", userId);
        Collection<Buy> buys = createNamedQuery.setMaxResults(10).getResultList();
        return buys;
    }

    public static void putBuy(Buy buy) {
        Session session = null;
        Transaction tx = null;
        try {
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            session.save(buy);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
