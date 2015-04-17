<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String contextPath = request.getContextPath();
            response.sendRedirect(response.encodeRedirectURL(contextPath + "/products"));
        %>
        <h1>Hello World 123!</h1>
    </body>
</html>
