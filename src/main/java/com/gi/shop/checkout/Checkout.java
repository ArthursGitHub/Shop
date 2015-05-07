/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.checkout;

import com.gi.shop.card.CardBean;
import com.gi.shop.hebirnate.Buy;
import com.gi.shop.hebirnate.BuyManager;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ильяс
 */
public class Checkout extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String marketId = request.getParameter("market");
        String userId = request.getUserPrincipal().getName();
        if (marketId == null || marketId.isEmpty()) {
            System.out.println("buy parameter is empty");
        } else {
            CardBean card = (CardBean) request.getSession().getAttribute("cardBean");
            for (Map.Entry<Integer, Integer> entry : card.getProducts().entrySet()) {
                Buy buy = new Buy();
                buy.setAmount(entry.getValue());
                buy.setBuyDate(new Date());
                buy.setIsDelivery(Boolean.FALSE);
                buy.setMarketId(Integer.parseInt(marketId));
                buy.setProductid(entry.getKey());
                buy.setUserid(userId);
                BuyManager.putBuy(buy);
            }
        }
        request.getSession().setAttribute("cardBean", null);
        response.setStatus(200);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
