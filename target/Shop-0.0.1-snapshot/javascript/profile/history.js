$(document).ready(function () {
    $.getJSON(contextPath + "/webresources/buys/" + userId, function (data) {
        var items = [];
        options = {
            year: 'numeric', month: 'numeric', day: 'numeric',
            hour: 'numeric', minute: 'numeric', second: 'numeric'
        };
        var language = $.cookie("language");
        $.each(data, function (index, buy) {
            var productName = product(buy.productid, language).name;
            var marketAddress = market(buy.marketId).address;
            var buyDate = buy.buyDate;
            var date = new Date(buy.buyDate);
            buyDate = new Intl.DateTimeFormat(language,options).format(date);
            items.push("<tr><td>" + productName + "</td><td>" + buyDate + "</td><td>" + marketAddress + "</td><td>" + buy.amount + "</td>");
            $("#buys").append(items[index]);
        });

    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ", " + error;
        console.log("Request Failed: " + err);
    });
});
function product(productId, locale) {
    var product;
    $.ajax({
        url: contextPath + "/webresources/products/" + productId + "/" + locale,
        dataType: 'json',
        async: false,
        success: function (data) {
            product = data;
        }}).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ", " + error;
        console.log("Request Failed: " + err);
    });
    return product;
}
function market(marketId) {
    var market;
    $.ajax({
        url: contextPath + "/webresources/markets/" + marketId,
        dataType: 'json',
        async: false,
        success: function (data) {
            market = data;
        }}).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ", " + error;
        console.log("Request Failed: " + err);
    });
    return market;
}