<%-- 
    Document   : checkout
    Created on : 02.05.2015, 14:41:26
    Author     : garadagly
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">            
        <link href="/Shop/css/card/card.css" type="text/css" rel="stylesheet">
        <link href="/Shop/css/login/login.css" type="text/css" rel="stylesheet">
        <script src='javascript/card/card.js' type="text/javascript"></script>
        <script src='javascript/common/languageSwitcher.js' type="text/javascript"></script>
        <jsp:useBean id="cardBean" class="com.gi.shop.card.CardBean" scope="session"/>
        <jsp:useBean id="productBean" class="com.gi.shop.beans.ProductBean" scope="request"/>
        <jsp:useBean id="propertiesBean" class="com.gi.shop.beans.PropertiesBean" scope="request"/>
        <c:set  var="resources" scope="session" value  = "${propertiesBean.setLocale(cookie.language.value)}"/>
        <title>${resources.cartTitle}</title>

    </head>
    <body>
        <div class="parent">

            <jsp:include page="/jsp/common.jsp"/> 
            <jsp:include page="/jsp/header.jsp"/>
            <div class="content">
                <label>${resources.checkoutSucces}</label></br>
                <a class="PrfileUrl" href="profile">
                    ${resources.goToProfile}
                </a>
            </div>
        </div>
    </body>
</html>