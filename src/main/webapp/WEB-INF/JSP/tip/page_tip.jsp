<%--
  Created by IntelliJ IDEA.
  User: pos
  Date: 2020/5/30
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/public/link.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <title>提醒事项</title>
    <link href="${ctx}/css/bootstrap-switch.min.css" rel="stylesheet">
    <script src="${ctx}/js/bootstrap-switch.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".switch-input").bootstrapSwitch({
                size:"small",
                onText:"审核",
                offText:"正常",
                onColor:"warning",
                offColor:"success",
                //开关状态改变事件
                onSwitchChange:function(event,state){
                    //获取当前行的商品id
                    var itemId = $(".switch-input").parents("tr").find(".itemId").html();
                    if(state==true){
                        $(this).val("1"); //正常
                        console.log("审核");


                    }else{
                        $(this).val("0"); //审核
                        console.log("正常");
                        $.ajax({
                            url:"${ctx}/web/updateItem.action?itemId="+itemId,
                            method:"post",
                            data:{
                                itemState:1
                            }

                        })
                    }
                }
            }).bootstrapSwitch('state',true);

            //删除商品
            function deleteItems(itemId) {
                swal({
                    title:"确定删除吗",
                    type:"warning",
                    confirmButtonText:"确定",
                    cancelButtonText:"取消",
                    showCancelButton: true
                },function(isConfirm){
                    if (isConfirm){
                        $.ajax({
                            url:"${ctx}/web/deleteItem.action?itemId="+itemId
                        })
                        swal({
                            title:"删除成功！",
                            type:"success",
                            confirmButtonText:"确定",
                            showCancelButton: true
                        })
                    }
                })
            }
        });
    </script>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12   stretch-card">
            <div class="table-responsive pt-lg-5">
                <table id="table" class="table table-striped table-bordered table-hover ">
                    <tr>
                        <th >序号</th>
                        <th>用户</th>
                        <th >商品名</th>
                        <th >图片</th>
                        <th >描述</th>
                        <th >价格</th>
                        <th >购买日期</th>
                        <th >创建时间</th>
                        <th >校区</th>
                        <th >状态</th>
                        <th >编辑</th>
                    </tr>

                    <c:forEach items="${itemList}" var="item">
                        <tr id="data">
                            <td class="itemId">${item.itemId}</td>
                            <td>${item.userName}</td>
                            <td>${item.itemName}</td>
                            <td>
                                <image style="height: 80px;width: 100px;"
                                       src="${ctx}/itemPic/${item.itemPic}"></image>
                            </td>
                            <td>${item.itemDetail}</td>
                            <td>${item.itemPrice}</td>
                            <td><fmt:formatDate value="${item.itemBuyTime}" pattern="yyyy-MM-dd" var="buyTime" />
                                    ${buyTime}</td>
                            <td><fmt:formatDate value="${item.itemCreateTime}" pattern="yyyy-MM-dd  HH:mm:ss" var="createTime" />
                                    ${createTime}</td>
                            <td>${item.itemSchool}</td>
                            <td>
                                <label class="bootstrap-switch  bootstrap-switch-primary">
                                    <input type="checkbox" value="${item.itemState}" checked="${item.itemState}" class="switch-input"/>
                                </label>
                            </td>
                            <td><button class="btn btn-sm btn-primary" onclick="deleteItems(${item.itemId})">删除</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div>
                <nav aria-label="Page navigation" class="navbar-right">
                    <ul class="pagination">
                        <li onclick="firstPage()">
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true" >首页</span>
                            </a>
                        </li>
                        <li  onclick="prePage()">
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <li onclick="nextPage()">
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true" >&raquo;</span>
                            </a>
                        </li>
                        <li onclick="lastPage()">
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true" >尾页</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    </div>
</div>
</body>
</html>
