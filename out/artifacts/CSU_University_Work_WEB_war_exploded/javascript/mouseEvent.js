var httpRequest = null;
function createXMLHttpRequest(){
    if(window.XMLHttpRequest) {
        httpRequest = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
    }
}
function showInform(categoryId) {
    console.log(categoryId);
    sendRequest("categoryShowJsServlet?categoryId=" + categoryId);
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
            //显示悬浮层
            var inform = document.getElementById("inform");
            inform.innerText = resp;
            inform.style.display = "block";
        }
    }
}

//隐藏悬浮层
function hiddenInform(event){
    var informDiv = document.getElementById('inform');
    var x=event.clientX;
    var y=event.clientY;
    var divx1 = informDiv.offsetLeft;
    var divy1 = informDiv.offsetTop;
    var divx2 = informDiv.offsetLeft + informDiv.offsetWidth;
    var divy2 = informDiv.offsetTop + informDiv.offsetHeight;
    if( x < divx1 || x > divx2 || y < divy1 || y > divy2){
        document.getElementById('inform').style.display='none';
    }
}