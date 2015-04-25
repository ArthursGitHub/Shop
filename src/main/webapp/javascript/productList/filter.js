function handleFilterChange(cb, key, value) {
    if (cb.checked === true) {
        filter(key, value);
    } else {
        unfilter(key, value);
    }
}
function filter(key, value) {
    var filter = $.cookie("filter");
    var date = new Date();
    date.setTime(date.getTime() + (10*1000));
    if (filter === null) {
        $.cookie("filter", key, {expires:date});
    } else {
        if (filter.indexOf(key) === -1) {
            $.cookie("filter", filter + "," + key, {expires:date});
        }
    }
    key = encodeURI(key);
    var oldValue = $.cookie(key);
    if (oldValue === null) {
        $.cookie(key, value,{expires:date});
    } else {
        $.cookie(key, oldValue + "," + value, {expires:date});
    }
    redirectFilter();
}
function unfilter(key, value) {
    key = encodeURI(key);
    var values = $.cookie(key);
    if (values !== null) {
        values = values.replace(value + ",", "");
        values = values.replace("," + value, "");
        values = values.replace(value, "");
        if (values.length === 0) {
            $.cookie(key, null);
            var values = $.cookie("filter");
            values = values.replace(decodeURI(key) + ",", "");
            values = values.replace("," + decodeURI(key), "");
            values = values.replace(decodeURI(key), "");
            if (values !== null && values.length > 0) {
                $.cookie("filter", values);
            } else {
                $.cookie("filter", null);
            }
        } else {
            $.cookie(key, values);
        }
    }

    redirectFilter();
}
function redirectFilter() {
    var filterkeys = $.cookie("filter");
    var urlparams = "";
    if (filterkeys !== null) {
        var keys = filterkeys.split(",");
        keys.forEach(function (element, index, array) {
            var values = $.cookie(encodeURI(element));
            if (values !== null && values.length > 0) {
                var valuesSplitted = values.split(",");
                for (var i = 0; i < valuesSplitted.length; i++) {
                    urlparams += element + "=" + valuesSplitted[i] + "&";
                }
            }
        });
    }
    if (urlparams.length > 0) {
        var url = "http://" + window.location.host + window.location.pathname;
        window.location.href = (url + "?" + urlparams);
    } else {
        var url = "http://" + window.location.host + window.location.pathname;
        window.location.href = url;
    }
}
function switchLanguage(language) {
    deleteAllCookies();
    $.cookie("language", language);
    var url = "http://" + window.location.host + window.location.pathname;
    window.location.href = url;
}
function deleteAllCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
    	var cookie = cookies[i];
    	var eqPos = cookie.indexOf("=");
    	var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
    	document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}