<%-- 
    Document   : profile
    Created on : 02.05.2015, 15:04:58
    Author     : garadagly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     
        <jsp:include page="/jsp/common.jsp"/> 
        <link href="/Shop/css/login/login.css" type="text/css" rel="stylesheet">
        <link href="/Shop/css/profile/profile.css" type="text/css" rel="stylesheet">
        <jsp:useBean id="propertiesBean" class="com.gi.shop.beans.PropertiesBean" scope="session"/>
        <c:set  var="resources" scope="session" value  = "${propertiesBean.setLocale(cookie.language.value)}"/>
        <script src='javascript/common/languageSwitcher.js' type="text/javascript"></script>
        <script src='javascript/profile/history.js' type="text/javascript"></script>
        <script> contextPath = "${pageContext.request.contextPath}"</script>
        <script> userId = "${pageContext.request.userPrincipal.name}"</script>

        <title>${resources.enter}</title>
    </head>
    <body>
        <div class="parent">
            <jsp:include page="/jsp/header.jsp"/>
            <div class="content">
                <label> ${resources.name}: </label>  ${pageContext.request.userPrincipal.name}<br/><br/>
                <label> ${resources.defaultTab}: </label>  ${resources[pageContext.servletContext.getInitParameter('tab')]}
                <div id="history">
                    <label>${resources.history}</label><br/><br/><br/>
                    <table id="buys">
                        <th>${resources.productName}</th>
                        <th>${resources.timeOfPurchase}</th>
                        <th>${resources.marketAddress}</th>
                        <th>${resources.amount}</th> 
                    </table>
                </div> 
                <br/>
                <br/>
            </div>
        </div>
    </body>
</html>
