<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/public/link.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>查询</title>
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
                    console.log(event.currentTarget.defaultValue,"-----",state);
                    if(state==false){
                         $(this).val("1"); //正常
                        console.log("正常");

                    }else{
                         $(this).val("0"); //审核
                        console.log("审核");
                    }
                }
            }).bootstrapSwitch('state',false);
        });

        //删除商品
        function deleteItem(itemId){
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
        //首页
        function firstPage(){
            var pageNum=document.getElementById("pageNum").value;
            if(pageNum==1){
               swal({
                   title:"已经是首页了",
                   type:"info",
                   confirmButtonText:"确定",
                   showCancelButton: true
               })
            }else{
                window.location.href="<%=request.getContextPath()%>/jframe/toItem.action?pageNum="+1;
            }
        }
        //尾页
        function lastPage(){
            var pageNum=document.getElementById("pageNum").value;
            var totalPage=document.getElementById("totalPage").value;
            if(pageNum==totalPage){
                swal({
                    title:"已经是尾页了",
                    type:"info",
                    confirmButtonText:"确定",
                    showCancelButton: true,
                })
            }else{
                window.location.href="<%=request.getContextPath()%>/jframe/toItem.action?pageNum="+totalPage;
            }
        }
        //上一页
        function prePage(){
            var pageNum=document.getElementById("pageNum").value;
            pageNum--;
            window.location.href="<%=request.getContextPath()%>/jframe/toItem.action?pageNum="+pageNum;
        }
        //下一页
        function nextPage(){
            var pageNum=document.getElementById("pageNum").value;
            pageNum++;
            window.location.href="<%=request.getContextPath()%>/jframe/toItem.action?pageNum="+pageNum;
        }
    </script>
    <link href="${ctx}/css/bootstrap-switch.min.css" rel="stylesheet">
    <%--<style type="text/css">.table {width:100%; table-layout: fixed;word-break:break-all;}</style>--%>
    <script src="${ctx}/js/bootstrap-switch.min.js"></script>
</head>
<body>
<%--action="${ctx}/web/selectItemsByName.action" method="get"--%>
<form action="${ctx}/web/selectItemsByName.action" method="POST">
    <nav aria-lable="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active " aria-current="page">信息查询</li>
        </ol>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <form action="${ctx}/web/selectItemsByName.action" method="post">
                    <div class="input-group">
                        <input type="text" id="input-name" name="searchName" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn">
                            <button type="submit" id="searchBtn" class="btn btn-primary" name="search">搜索</button>
                        </span>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12   stretch-card">
                <div class="table-responsive pt-lg-5">
                    <h1 class="text-center text-primary">${mesg}</h1>
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
                                <td>${item.itemId}</td>
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
                                <td><button class="btn btn-sm btn-primary" onclick="deleteItem(${item.itemId})">删除</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div>
                    <input type="hidden" id="pageNum" value="${pageNum}">
                    <input type="hidden" id="totalPage" value="${pages}">
                    <%--<span onclick="firstPage()">首页</span><span onclick="prePage()">上一页</span>--%>
                    <%--<span onclick="nextPage()">下一页</span><span onclick="lastPage()">尾页</span>--%>
                    <nav aria-label="Page navigation" class="navbar-right">
                        <ul class="pagination">
                            <li  onclick="firstPage()">
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">首页</span>
                                </a>
                            </li>
                            <li onclick="prePage()">
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true" >&laquo;</span>
                                </a>
                            </li>
                            <li onclick="nextPage()">
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                            <li onclick="lastPage()">
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">尾页</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</form>


</body>
</html>
