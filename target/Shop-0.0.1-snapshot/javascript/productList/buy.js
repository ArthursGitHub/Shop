function buy(id) {
    var e = window.event;
    $('#productAdded').hide();
    $('#productAdded').css( 'position', 'absolute' );
    $('#productAdded').css( 'top', e.pageY+30 );
    $('#productAdded').css( 'left', e.pageX+30 );
    $('#productAdded').slideUp( 300 ).fadeIn( 400 );
    $('#productAdded').delay( 500 ).fadeOut( 200 );
    xhr = new XMLHttpRequest();
    method = "putMore"
    xhr.open('POST',
            encodeURI( '/Shop/cardServlet?'+'method='+method));
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.onload = function () {
         if (xhr.status !== 200) {
            alert('Request failed.  Returned status of ' + xhr.status);
        }
    };
    xhr.send(encodeURI('id=' + id));
}