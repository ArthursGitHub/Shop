<%-- 
    Document   : errorlogin
    Created on : 02.05.2015, 13:29:20
    Author     : garadagly
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">            
        <link href="/Shop/css/login/login.css" type="text/css" rel="stylesheet">
        <jsp:useBean id="propertiesBean" class="com.gi.shop.beans.PropertiesBean" scope="session"/>
        <c:set  var="resources" scope="session" value  = "${propertiesBean.setLocale(cookie.language.value)}"/>
        <title>${resources.enter}</title>
    </head>
    <body>

        <div class="parent">
            <jsp:include page="/jsp/common.jsp"/> 
            <jsp:include page="/jsp/header.jsp"/>
            <div class="content">
                <label>${resources.loginError}</label><br/>
                <form action="j_security_check" method="post" name="loginForm">
                    <label>${resources.name}</label><br><input class="inputLabel" type="text" name="j_username" placeholder="${resources.name}" size="15"/><br>
                    <label>${resources.password}</label><br><input class="inputLabel" type="password" name="j_password" size="15" placeholder="${resources.password}"/><br>
                    <input class="inputLabel" type="submit" value="${resources.logIn}"/>
                </form>
            </div>
        </div>
    </body>
</body>
</html>
