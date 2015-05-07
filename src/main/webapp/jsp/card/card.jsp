<%-- 
    Document   : card
    Created on : 18.04.2015, 15:58:14
    Author     : Ильяс
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">            
        <link href="/Shop/css/card/card.css" type="text/css" rel="stylesheet">
        <link href="/Shop/css/card/productShort.css" type="text/css" rel="stylesheet">
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
                <c:choose>
                    <c:when test="${!cardBean.products.isEmpty()}">
                        <c:set var="sum" value="0"/>
                        <c:forEach var="product" items="${cardBean.products.keySet()}">
                            <c:set target="${productBean}" property="language" value="${cookie['language'].value}"/>
                            <c:set target="${productBean}" property="beanId" value="${product}"/>
                            <c:set var="count" value="${cardBean.products[product]}" scope="request"/>
                            <jsp:include page="/jsp/card/productShortInfo.jsp"/>
                            <c:set var="sum" value="${sum+productBean.price*count}"/>
                        </c:forEach>
                        <div class="empty">
                            ${resources.purchasePrice}
                        </div>
                        <div class="quantityDiv">
                            ${sum} 
                            <div class='rub'>P</div>
                            <a class="buy" href="market">${resources.marketchoice}</a>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="cardIsEmpty">
                            ${resources.cartIsEmpty}
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </body>
</html>
