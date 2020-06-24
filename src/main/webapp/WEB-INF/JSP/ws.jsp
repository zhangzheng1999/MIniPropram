<%--
  Created by IntelliJ IDEA.
  User: pos
  Date: 2020/5/7
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
</head>
<body>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript" src="http://cdn.bootcss.com/sockjs-client/1.1.1/sockjs.js"></script>
<script type="text/javascript">
    var websocket = null;
    if ('WebSocket' in window) {//判断浏览器是否支持WebSocket
        websocket = new WebSocket("ws://localhost:8080/websocket/socketServer.action");
    }
    else if ('MozWebSocket' in window) {
        websocket = new MozWebSocket("ws://localhost:8080/websocket/socketServer.action");
    }
    else {
        websocket = new SockJS("http://localhost:8080/sockjs/socketServer.action");
    }
    websocket.onopen = onOpen;
    websocket.onmessage = onMessage;
    websocket.onerror = onError;
    websocket.onclose = onClose;

    function onOpen(result) {
        alert("连接建立时触发:"+result.data);
    }

    function onMessage(result) {
        alert("客户端接收服务端数据时触发:"+result.data);
    }
    function onError(result) {
        alert("通信发生错误时触发:"+result.data);
    }
    function onClose(result) {
        alert("连接关闭时触发:"+result.data);
    }
    //使用连接发送数据
    function doSend() {
        if (websocket.readyState == websocket.OPEN) {
            var msg = document.getElementById("inputMsg").value;
            websocket.send(msg);//调用后台handleTextMessage方法
            alert("发送成功!");
        } else {
            alert("连接失败!");
        }
    }
    //窗口关闭时,将websocket连接关闭
    window.close=function()
    {
        websocket.onclose();
    }
</script>
请输入：<textarea rows="5" cols="10" id="inputMsg" name="inputMsg"></textarea>
<button onclick="doSend();">发送</button>
</body>

</html>
