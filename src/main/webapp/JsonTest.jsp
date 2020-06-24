<%--
  Created by IntelliJ IDEA.
  User: pos
  Date: 2020/4/21
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Json</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript">

     $(document).ready(function (){
         var itemsName = encodeURI("超薄笔记本");
         $.ajax({
             type:"post",
             url:"${pageContext.request.contextPath }/requestJson.action",
             //dataType: 'json',
             //contentType: 'text/json,charset=utf-8',
             //contentType:"application/json;charset=utf-8",
             //数据格式是json串
             //data:"{'itemName':'笔记本电脑','itemPrice':6000,'itemDetail':'这是一个联想笔记本'}",
             data:'itemName=笔记本电脑&itemPrice=6000&itemDetail=这是一个联想笔记本',
             //data:{itemName:itemsName},
             success:function (data) {
                 //返回json结果
                 $("#show").html(data.itemName);
             }
         });
     });


</script>
<body>
<div id="show"></div>
</body>
</html>
