<%@page import="java.util.ResourceBundle"%>
<%@page import="com.gi.shop.beans.PropertiesBean"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.LinkedList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.gi.languages.Language"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/jsp/common.jsp"/>
        <jsp:useBean id="productBean" class="com.gi.shop.beans.ProductBean" scope="session"/>
        <jsp:useBean id="filterBean" class="com.gi.shop.beans.FilterBean" scope="session"/>
        <jsp:useBean id="propertiesBean" class="com.gi.shop.beans.PropertiesBean" scope="session"/>
        <%
            request.setCharacterEncoding("UTF-8");
            String language = Language.getLanguage(request.getCookies());
            request.setAttribute("language", language);
            if (filterBean.getLanguage() == null || !filterBean.getLanguage().equals(language)) {
                filterBean.setLanguage(language);
                filterBean.setActiveFilter(new HashMap<String, Set<String>>());
                filterBean.setCanChangeFilter(new HashMap<String, Set<String>>());
            }
            ResourceBundle resources = propertiesBean.asd(Language.valueOf(language.toUpperCase()));
            request.setAttribute("resources", resources);
        %>
        <jsp:setProperty name="productBean" property="language" value="${language}"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/Shop/css/productList/productShort.css" type="text/css" rel="stylesheet">
        <link href="/Shop/css/productList/productList.css" type="text/css" rel="stylesheet">
        <script src="/Shop/javascript/productList/filter.js" type="text/javascript"></script>
        <title><%
            request.setAttribute("title", resources.getString("productListTitle"));
            %>
            ${title}
        </title>
    </head>
    <body>
        <div class="parent">
            <jsp:include page="/jsp/header.jsp"/>

            <div class="ListOfProductsElement">
                <%
                    for (int i = 0; i < 5; i++) {
                        String beanIdent = "" + i;
                        request.setAttribute("beanIdent", beanIdent);
                %>

                <jsp:setProperty name="productBean" property="beanId" value="${beanIdent}"/>

                <%
                    for (Map.Entry<String, String> entry : productBean.getProperties().entrySet()) {
                        if (!filterBean.getCanChangeFilter().containsKey(entry.getKey())) {
                            Set<String> list = new TreeSet<String>();
                            list.add(entry.getValue());
                            filterBean.getCanChangeFilter().put(entry.getKey(), list);
                        } else {
                            filterBean.getCanChangeFilter().get(entry.getKey()).add(entry.getValue());
                        }
                    }

                %>
                <%                    Map<String, String[]> filterParametersMap = request.getParameterMap();
                    if (filterParametersMap != null && !filterParametersMap.isEmpty()) {
                        filterBean.setActiveFilter(filterParametersMap);
                    } else {
                        filterBean.setActiveFilter(request.getCookies());
                    }
                    if (filterBean.isValid(productBean)) {
                %>  
                <jsp:include page="/jsp/productShort/productShort.jsp"/>
                <%
                        }
                    }
                %>
            </div>
            <div class="rightPanel">
                <div class="activeFilter">
                    <%
                        HashMap<String, Set<String>> activeFilter = filterBean.getActiveFilter();
                        for (Map.Entry<String, Set<String>> entry : activeFilter.entrySet()) {
                            request.setAttribute("activeFilterKey", entry.getKey());
                    %>
                    <div class="activeFilterElement">
                        <div class="activeFilterKey">
                            ${activeFilterKey}
                        </div>
                        <div class="activeFilterValues">
                            <%
                                for (String filterValue : entry.getValue()) {
                                    request.setAttribute("activeFilterValue", filterValue);
                            %>
                            <input type="checkbox" name="${activeFilterKey}" value="${activeFilterValue}" onchange="handleFilterChange(this, '${activeFilterKey}', '${activeFilterValue}');" checked>
                            ${activeFilterValue}
                            <br>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
                <div class="canChangeFilter">
                    <%
                        HashMap<String, Set<String>> canChangeFilter = filterBean.getCanChangeFilter();
                        for (Map.Entry<String, Set<String>> entry : canChangeFilter.entrySet()) {
                            request.setAttribute("filterKey", entry.getKey());
                    %>
                    <div class="filterElement">
                        <div class="filterKey">
                            ${filterKey}
                        </div>
                        <div class="filterValues">
                            <%
                                for (String filterValue : entry.getValue()) {
                                    request.setAttribute("filterValue", filterValue);
                            %>
                            <input type="checkbox" name="${filterKey}" value="${filterValue}" onchange="handleFilterChange(this, '${filterKey}', '${filterValue}');">
                            ${filterValue}
                            <br>
                            <%
                                }
                            %>
                        </div>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
    </body>
</html>
