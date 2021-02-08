var httpRequest=null;
function createXMLHttpRequest(){
    if(window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function updateCart() {
    var quantity = document.getElementById("quantity").value;
    sendRequest("updateCartJSServlet?quantity="+ quantity);
}
function sendRequest(url) {
    createXMLHttpRequest();
    httpRequest.open("GET",url,true);
    httpRequest.onreadystatechange=processResponse;
    httpRequest.send(null);
}

function processResponse() {
    if (httpRequest.readyState == 4) {
        if (httpRequest.status == 200) {
            var resp = httpRequest.responseText;
            var array = resp.split(",");
            var quantity = document.getElementById("quantity");
            var total = document.getElementById("total");
            var subtotal = document.getElementById("subtotal");

            quantity.innerText = array[0];
            total.innerText = array[1];
            subtotal.innerText = array[2];
        }
    }
}