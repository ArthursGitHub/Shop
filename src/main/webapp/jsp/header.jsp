<%-- 
    Document   : header
    Created on : 15.04.2015, 12:18:39
    Author     : garadagly
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ResourceBundle"%>
<%@page import="com.gi.languages.Language"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="header">
    <div class="leftBlockHeader">

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
        <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name==null}">
                <div class="profileLink">
                    <a class="toLogin" href="login">
                        ${resources.enter}
                    </a>
                </div>
            </c:when>
            <c:otherwise>
                <div class="profileLink">
                    <a class="toLogin" href="logout">
                        ${resources.logout}
                    </a>
                </div>
                <div class="profileLink">
                    <a class="toLogin" href="profile">
                        ${pageContext.request.userPrincipal.name}
                    </a>
                </div>

            </c:otherwise>
        </c:choose>

    <div class="nameOfShop">
        <a class = "mainLink" href="${pageContext.request.contextPath}">
            ${resources.nameOfShop}
        </a>
    </div>
</div>
