<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/public/link.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<script type="text/javascript" src="${ctx}/js/echarts.common.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/pangeindex.js"></script>
		<link type="text/css" rel="stylesheet" href="${ctx}/css/pageIndex.css"/>
	</head>
	<body>
		<nav aria-lable="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item active ">首页</li>
			</ol>
		</nav>
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-4">
					<div class="card bg-success text-light">
						<div class="card-body">
							<h5 class="card-title">当前用户总数</h5>
							<p class="card-text display-3">
								<%--<%=application.getAttribute("counter")%>--%>
							</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card bg-primary text-light">
						<div class="card-body">
							<h5 class="card-title">每日平均活跃用户数</h5>
							<p class="card-text display-3">
							<%--<%=application.getAttribute("counter")%>--%>
							</p>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="card bg-warning text-light">
						<div class="card-body">
							<h5 class="card-title">每日平均访问数</h5>
							<p class="card-text display-3">
							<%--<%=application.getAttribute("counter")%>--%>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>


		<h6 class="pI-title">最近七天访问数据</h6>
		<div class="container">
			<div class="row">
				<div class="col-lg-6">
					<div id="main" class="pI-chrt">

					</div>
				</div>
			</div>
		</div>




	</body>
</html>
