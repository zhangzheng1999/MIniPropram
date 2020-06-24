<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/public/link.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8",content="width=device-width,
                                     initial-scale=1.0,
                                     maximum-scale=1.0,
                                     user-scalable=no">
		<title>淄职易购管理系统</title>
		<link rel="stylesheet" type="text/css" href="${ctx}/css/index.css" />
        <link rel="stylesheet" type="text/css" href="${ctx}/css/pageIndex.css"/>
        <link rel="stylesheet" type="text/css" href="${ctx}/css/reset.css"/>
		<script type="text/javascript" src="${ctx}/js/index.js"></script>
		<script>
			$(document).ready(function () {
                $('.left-box li').on('click',function() {
                    var $this = $(this);
                    var $iframe = $('iframe');
                    $this.addClass('active').siblings().removeClass('active');
                    $iframe.attr("src",$this.data("url"));
                })
            })
		</script>
	</head>
	<body>
	<%--<% request.setCharacterEncoding("utf-8"); %>--%>
		<!-- 顶部栏 -->
		<nav class="navbar navbar-expand navbar-inverse  fixed-top">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">管理系统</a>
				<i class="iconfont index-control">&#xe63d;</i>
				<div class="collapse navbar-collapse navbar-right"  id="navbarSupportedContent">
					<ul class="nav navbar-nav navbar-right">
						<font color="#FFF">欢迎您，</font><font color="#F00"><%=request.getParameter("userName") %></font>
                        <li class="nav-item">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">用户操作</a>
							<ul class="dropdown-menu">
								<li><a href="#">退出</a></li>
							</ul>
                        </li>
					</ul>
				</div>
			</div>
		</nav>
		
<!-- 左侧栏 -->
		<ul class="left-box">
			<li id="data" class="active" data-url="${ctx}/jframe/toData.action">
				<i  class="iconfont">&#xe613;</i>数据概况
			</li>
			<li id="user" data-url="${ctx}/jframe/toUser.action">
				<i  class="iconfont">&#xe64d;</i>用户中心
			</li>
			<li id="item" data-url="${ctx}/jframe/toItem.action">
				<i  class="iconfont">&#xe74f;</i>信息查询
			</li>
			<li id="tip" data-url="${ctx}/jframe/toTip.action">
				<i class="iconfont">&#xe611;</i>提醒事项<span class="ml-3 badge badge-danger badge-pill">1</span>
			</li>

		</ul>
		
		
		<!-- 右侧栏 -->
		<div class="right-box">
			<iframe id="frame-data" src="${ctx}/toData.jsp"></iframe>
			<iframe id="frame-user" src=""></iframe>
			<iframe id="frame-item" src=""></iframe>
			<iframe id="frame-tip"  src=""></iframe>
		</div>
	</body>
</html>
