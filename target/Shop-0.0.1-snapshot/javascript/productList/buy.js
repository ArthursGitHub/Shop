function buy(id) {
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