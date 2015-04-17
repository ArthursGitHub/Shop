/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gi.shop.product;

import com.gi.languages.Language;
import com.gi.shop.beans.ProductBean;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author garadagly
 */
public class Product extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String currentLanguage = getLanguage(request.getCookies());
            if (currentLanguage.isEmpty()) {
                currentLanguage = getInitParameter("language");
            }
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
            String id = request.getParameter("id");
            if (id==null || id.isEmpty()){
                String contextPath = request.getContextPath();
                response.sendRedirect(response.encodeRedirectURL(contextPath+"/products"));
                return;
            }
            ProductBean product = new ProductBean();
            product.setLanguage(currentLanguage);
            product.setBeanId(id);
            Language[] languages = Language.values();
            String checkedTab = getInitParameter("tab");
            String buy = resources.getString("buy");
            String descrName = resources.getString("descrName");
            String charactersName = resources.getString("charactersName");
            String answersName = resources.getString("answersName");
            String nameOfShop = resources.getString("nameOfShop");
            List<Answer> answers = new LinkedList<>();
            answers.add(new Answer("МилыйДобряк", "Наверное хотелось бы уже механику. Все часы у меня были кварц. Очень много друзей давно убеждают на механику\n"
                    + "\n"
                    + "Меня вот сейчас как не убеждай - не пересяду с автомата на механику (я про коробку передач). :-))\n"
                    + "Если хотите механику... в ней я не очень силен... Но смотрел бы в этом бюджете Лонжин. Хотя и некоторые Таг Каррера примерно в бюджете. Впрочем, и Raymond Weil серия Freelancer неплохой вариант. Выбирайте то, что Вам внешне больше нравится и что кажется достойным вариантом за данную сумму.",
                    new Date(), 5));
            answers.add(new Answer("ЖесткийЧел", "Какое убожество", new Date(), 5));
            answers.add(new Answer("Я ТУТ ГЛАВНЫЙ", "ПРЕВОСХОДСТВО", new Date(), 5));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"/Shop/css/product/product.css\" type=\"text/css\" rel=\"stylesheet\">");
            out.println("<link href=\"/Shop/css/common/common.css\" type=\"text/css\" rel=\"stylesheet\">");
            out.println("<title>" + product.getName() + "</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"header\">");
            out.println("<div class=\"nameOfShop\">");
            out.println(nameOfShop);
            out.println("</div>");
            out.println("<div class=\"languageDiv\">");
            for (Language language : languages) {
                out.println("<a class=\"languageButton\" onclick=switchLanguage('" + language.getCode() + "')>" + language.getCode() + "/</a>");
            }
            out.println("</div>");
            out.println("</div>");
            out.println("<div class=\"content\">");
            out.println("<div class=\"productImages\">");
            out.println("<table><tr><td colspan=3 >");
            out.println("<img class='productMainImage' src='/Shop/images/products/"+product.getBeanId()+"/big.JPG'");
            out.println("</a>");
            out.println("</td></tr>");
            out.println("<tr>");
            out.println("<td class=\"tdImage\">");
            out.println("<img class='productSecondaryImage' src='/Shop/images/products/"+product.getBeanId()+"/big.JPG'");
            out.println("</td>");
            out.println("<td class=\"tdImage\">");
            out.println("<img class='productSecondaryImage' src='/Shop/images/products/"+product.getBeanId()+"/big2.JPG'");
            out.println("</td>");
            out.println("<td class=\"tdImage\">");
            out.println("<img class='productSecondaryImage' src='/Shop/images/products/"+product.getBeanId()+"/big3.JPG'");
            out.println("</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</div>");
            out.println("<div class=\"productTitle\">");
            out.println(product.getName());
            out.println("</div>");
            out.println("<div class=\"productPriceAndButton\">");
            out.println("<div class=\"productPrice\">");
            out.println(product.getPrice());
            out.println("<div class='rub'>P</div>");
            out.println("</div>");
            out.println("<div class=\"buttonsDiv\">");
            out.println("<a href='buy' class='button buy'>");
            out.println(buy);
            out.println("</a>");
            out.println("</div>");
            out.println("</div>");
            out.print("<div class=\"tabs\">\n"
                    + "    <input id=\"tab1\" type=\"radio\" name=\"tabs\"");
            if (checkedTab.equals("description")) {
                out.print("checked");
            }
            out.println(">");
            out.println("<label for=\"tab1\" title=\"Вкладка 1\">" + descrName + "</label>\n");
            out.print("   <input id=\"tab2\" type=\"radio\" name=\"tabs\"");
            if (checkedTab.equals("characteristics")) {
                out.print("checked");
            }
            out.println(">");
            out.println("    <label for=\"tab2\" title=\"Вкладка 2\">" + charactersName + "</label>\n");
            out.print("    <input id=\"tab3\" type=\"radio\" name=\"tabs\"");
            if (checkedTab.equals("answers")) {
                out.print("checked");
            }
            out.println(">");
            out.println("    <label for=\"tab3\" title=\"Вкладка 3\">" + answersName + "</label>\n"
                    + " \n"
                    + "    <section id=\"content1\">");
            out.println("<div class=\"productDescription\">");
            out.println(product.getDescription());
            out.println("</div>");
            out.println("    </section>");
            out.println("    <section id=\"content2\">");
            out.println("<div class=\"charactersiticsDiv\">");
            out.println("<table class=\"tableCharacteristics\">");
            for (Entry<String, String> characteristic : product.getProperties().entrySet()) {
                out.println("<tr class=\"trCharacteristics\">");
                out.println("<td class=\"tdCharacteristics\">" + characteristic.getKey() + "</td>");
                out.println("<td class=\"tdCharacteristics\">" + characteristic.getValue() + "</td>");
                out.println("</tr>");
                out.println("<tr><td colspan=2><hr class=\"hrCharacteristics\"></td></tr>");
            }
            out.println("</table>");
            out.println("</div>");
            out.println("    </section> ");
            out.println("    <section id=\"content3\">");
            out.println("<table class=\"tableAnswer\">");
            out.println("<tr class=\"trAnswer\">");
            String user = resources.getString("user");
            String comment = resources.getString("comment");
            String dateOfComment = resources.getString("dateOfComment");
            String rating = resources.getString("rating");
            out.println("<th class=\"tdAnswer\"> " + user + "</td>");
            out.println("<th class=\"tdAnswer\">" + comment + "</td>");
            out.println("<th class=\"tdAnswer\">" + dateOfComment + "</td>");
            out.println("<th class=\"tdAnswer\">" + rating + "</td>");
            out.println("</tr>");
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyy", Locale.UK);

            for (Answer answer : answers) {
                out.println("<tr class=\"trAnswer\">");
                out.println("<td class=\"tdAnswerUserInfo\">" + answer.getUserInfo() + ": </td>");
                out.println("<td class=\"tdAnswerText\">" + answer.getText() + "</td>");
                String date = dateFormat.format(answer.getDate());
                out.println("<td class=\"tdAnswer\">" + date + "</td>");
                out.println("<td class=\"tdAnswer\">" + answer.getRating() + "</td>");
                out.println("</tr>");
                out.println("<tr><td colspan=4><hr class=\"hrCharacteristics\"></td></tr>");
            }
            out.println("</table>");
            out.println("    </section>");
            out.println("</div>");
            out.println("</div>");
            out.println("</body>");
            out.println("<script src=\"/Shop/javascript/libs/jquery-1.11.2.min.js\"></script>");
            out.println("<script src=\"/Shop/javascript/libs/jquery.cookie.js\"></script>");
            out.println("<script src=\"/Shop/javascript/product/swapimages.js\"></script>");
            out.println("<script src=\"/Shop/javascript/common/languageSwitcher.js\"></script>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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

    private String getLanguage(Cookie[] cookies) {
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("language")) {
                    return cookie.getValue();
                }
            }
        }
        return "ru";
    }

}
