
var httpRequest=null;
function createXMLHttpRequest(){
    if(window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function usernameIsExist() {
    var username = document.getElementById('username').value;
    sendRequest("usernameIsExistServlet?username=" + username);
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
            var responseInfo = httpRequest.responseXML.getElementsByTagName("msg")[0].firstChild.data;
            var div1 = document.getElementById('usernameMsg');
            if (responseInfo == "Exist") {
                div1.innerHTML = "<font color='red'>用户名已存在</font>";
            } else {
                div1.innerHTML = "<font color='green'>用户名可用</font>";
            }
        }
    }
}