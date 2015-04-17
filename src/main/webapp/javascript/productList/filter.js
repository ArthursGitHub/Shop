function handleFilterChange(cb, key, value) {
    if (cb.checked === true) {
        filter(key, value);
    } else {
        unfilter(key, value);
    }
}
function filter(key, value) {
    var filter = $.cookie("filter");
    if (filter === null) {
        $.cookie("filter", key);
    } else {
        if (filter.indexOf(key) === -1) {
            $.cookie("filter", filter + "," + key);
        }
    }
    key = encodeURI(key);
    var oldValue = $.cookie(key);
    if (oldValue === null) {
        $.cookie(key, value);
    } else {
        $.cookie(key, oldValue + "," + value);
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
            urlparams += element;
            var values = $.cookie(encodeURI(element));
            if (values !== null && values.length > 0) {
                urlparams += "=" + values + "&";
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