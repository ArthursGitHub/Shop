<%-- 
    Document   : header
    Created on : 15.04.2015, 12:18:39
    Author     : garadagly
--%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="com.gi.languages.Language"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="header">
    <div class="leftBlockHeader">
        <div class="loginDiv">
            <a class="toLogin" href="card">
                ${resources.enter}
            </a>
        </div>
        <div class="toCard">
            <a class="toCardLink" href="card">
                ${resources.toCart}
            </a>
        </div>
        <div class="languageDiv">
            <%            for (Language changedLanguage : Language.values()) {
                    out.println(
                            "<a class=\"languageButton\" onclick=switchLanguage('" + changedLanguage.getCode() + "')>"
                            + changedLanguage.getCode() + "/</a>");
                }%>
        </div>
    </div>
    <div class="nameOfShop">
        <a class = "mainLink" href="${pageContext.request.contextPath}">
            ${resources.nameOfShop}
        </a>
    </div>
</div>
