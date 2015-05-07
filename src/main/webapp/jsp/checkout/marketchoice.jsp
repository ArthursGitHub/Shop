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
        <jsp:include page="/jsp/common.jsp"/> 
        <link href="/Shop/css/card/card.css" type="text/css" rel="stylesheet">
        <link href="/Shop/css/login/login.css" type="text/css" rel="stylesheet">
        <link href="/Shop/css/checkout/marketchoice.css" type="text/css" rel="stylesheet">
        <jsp:useBean id="cardBean" class="com.gi.shop.card.CardBean" scope="session"/>
        <jsp:useBean id="productBean" class="com.gi.shop.beans.ProductBean" scope="request"/>
        <jsp:useBean id="propertiesBean" class="com.gi.shop.beans.PropertiesBean" scope="request"/>
        <c:set  var="resources" scope="session" value  = "${propertiesBean.setLocale(cookie.language.value)}"/>
        <script> contextPath = "${pageContext.request.contextPath}"</script>
        <script src='javascript/card/card.js' type="text/javascript"></script>
        <script src='javascript/common/languageSwitcher.js' type="text/javascript"></script>
        <script src='javascript/checkout/checkout.js' type="text/javascript"></script>
        <script> title = "${resources.nameOfShop}"</script>
        <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false"></script>
        <title>${resources.cartTitle}</title>

    </head>
    <body>
        <div class="parent">


            <jsp:include page="/jsp/header.jsp"/>
            <div class="content">
                <div class="map-container">
                    <div id="map_canvas"></div>
                </div>
                <div class="selectContainer">
                    <select id="markets">

                    </select>   
                    <button id="checkedButton">${resources.purchase}</button>
                </div>
            </div>
        </div>
    </body>
</html>