$(document).ready(function () {
    var myLatlng = new google.maps.LatLng(59.9762625,30.2991661);
    var myOptions = {
        zoom: 11,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var markets = {};
    var map = new google.maps.Map(document.getElementById("map_canvas"), myOptions); 
    $.getJSON(contextPath + "/webresources/markets", function (data) {
        var items = [];
        $.each(data, function (index, market) {
            markets[market.id] = {x: market.x, y: market.y}; 
            var marker = new google.maps.Marker({
                position  : new google.maps.LatLng(market.x, market.y),
                    map: map,
                    title: title,
                });
            var contentString = '<div id="content">'+market.address+'</div>';
            var infowindow = new google.maps.InfoWindow({
                content: contentString
            });

            google.maps.event.addListener(marker, 'click', function() {
                infowindow.open(map,marker);
                $("#markets").val(market.id);
                curMarket = markets[market.id];
                map.setZoom(13);      // This will trigger a zoom_changed on the map
                map.setCenter(new google.maps.LatLng(curMarket.x, curMarket.y));
                
            });
            items.push("<option value='" + market.id + "'>" + market.address + "</option>");
            $("#markets").append(items[index]);
        });

    }).fail(function (jqxhr, textStatus, error) {
        var err = textStatus + ", " + error;
        console.log("Request Failed: " + err);
    });
    
   $( "select" ).change(function() { $("#markets option:selected" ).each(function() {
        curMarket = markets[this.value];
        map.setZoom(13);      // This will trigger a zoom_changed on the map
        map.setCenter(new google.maps.LatLng(curMarket.x, curMarket.y));
    });
  });
    $("#checkedButton").click(function () {
        var url = contextPath + "/checkout";
        var data = {market: $("#markets option:selected").val()};
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            dataType: "text"
        }).done(function () {
            var url = "http://" + window.location.host + contextPath;
            window.location.href = (url + "/" + "success");
        }).fail(function (jqxhr, textStatus, error) {
            var err = textStatus + ", " + error;
            console.log("Request Failed: " + err);
        });
    });
});
