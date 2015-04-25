<%-- 
    Document   : productShortInfo
    Created on : 18.04.2015, 15:58:35
    Author     : Ильяс
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div id="element_${productBean.beanId}" class="element">
    <div class="elem">
        <div class="elementProductImgUrl"> 
            <a>
                <img class="productImg" src="${productBean.imgUrl}">
            </a>
        </div>
        <div class="elementProductName">

            <a class="elementLink" href='${pageContext.request.contextPath}/product?id=${productBean.beanId}'>
                ${productBean.name}
            </a>
        </div>
        <div class="elementProductProperties">
            ${productBean.properties}
        </div>
        <div class="productPriceAndButton">
            <div class="productPrice">
                ${productBean.price}
                <div class='rub'>P</div>
            </div>
        </div>
    </div>
    <div class="quantityDiv">
        ${resources.amount}: 
        <a class="countControl" onclick="put('putLess','${productBean.beanId}');"> 
            - 
        </a> 
            <p class="quantityNumber">
            ${count}
        </p>
        <a class="countControl" onclick="put('putMore', '${productBean.beanId}');"> 
            + 
        </a>
    </div>
</div>
