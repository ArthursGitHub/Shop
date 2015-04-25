<%-- 
    Document   : productShort
    Created on : 13.04.2015, 19:16:01
    Author     : Ильяс
--%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="com.gi.shop.beans.PropertiesBean"%>
<%@page import="com.gi.languages.Language"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<div class="element">
    <div class="elementProductImgUrl"> 
        <a>
            <img class="productImg" src="<jsp:getProperty name="productBean" property="imgUrl"/>">
        </a>
    </div>
    <div class="elementProductName">

        <a class="elementLink" href='${pageContext.request.contextPath}/product?id=<jsp:getProperty name="productBean" property="beanId"/>'>
            <jsp:getProperty name="productBean" property ="name"/>
        </a>
    </div>
    <div class="elementProductProperties">
        <jsp:getProperty name="productBean" property ="properties"/>
    </div>
    <div class="productPriceAndButton">
        <div class="productPrice">
            <jsp:getProperty name="productBean" property="price"/>
            <div class='rub'>P</div>
        </div>
        <div class="buttonsDiv">
            <a  class='button buy' onclick="buy('<jsp:getProperty name="productBean" property="beanId"/>')">
                <%
                    String language = Language.getLanguage(request.getCookies());
                    PropertiesBean props = new PropertiesBean();
                    ResourceBundle resources = props.setLocale(Language.valueOf(language.toUpperCase()));
                    String buy = resources.getString("buy");
                    session.setAttribute("buy", buy);
                %>
                ${buy}
            </a>
        </div>
    </div>
</div>
