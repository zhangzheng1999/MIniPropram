<%@ page  contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../../public/link.jsp" %>
<!DOCTYPE html >
<html>
<head>
    <meta charset="utf-8">
    <title>登录</title>
    <script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
    <style type="text/css">
body {
	background-image: url(../../img/loginBg.jpg);
	background-size: cover;
	-webkit-background-size: cover;
	-o-background-size: cover;
}
img {
	width: 100%;
}
</style>
</head>
<body>
<% request.setCharacterEncoding("utf-8"); %>
<nav class="navbar navbar-inverse navbar-fixed-top " > 
    <div class="container-fluid "> 
        <div class="navbar-header"> 
          <a class="navbar-brand " href="#"></a>
        </div> 
        
       <div class="text-right">
            <button class="btn btn-primary btn-lg " data-toggle="modal" data-target="#register" role="button">注册</button>
       		<button class="btn btn-primary btn-lg " data-toggle="modal" data-target="#login" role="button">登录</button>
       </div>
    </div>
  
</nav>

    <!-- 注册窗口 -->
    <div id="register" class="modal fade" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-body">
                    <button class="close" data-dismiss="modal">
                        <span>&times;</span>
                    </button>
                </div>
                <div class="modal-title">
                    <h1 class="text-center">注册</h1>
                </div>

                <div class="modal-body">
                    <form class="form-group" action="LoginDAO" method="post">
                            <div class="form-group">
                                <label>用户名</label>
                                <input class="form-control" name="username" type="text" placeholder="6-15位字母或数字">
                            </div>
                            <div class="form-group">
                                <label>密码</label>
                                <input class="form-control"  type="password" placeholder="至少6位字母或数字">
                            </div>
                            <div class="form-group">
                                <label>再次输入密码</label>
                                <input class="form-control"  name="password" type="password" placeholder="至少6位字母或数字">
                            </div>
                            <div class="form-group">
                                <label>邮箱</label>
                                <input class="form-control" name="email" type="email" placeholder="例如:123@123.com">
                            </div>
                            <div class="text-right">
                                <button class="btn btn-primary" type="submit">提交</button>

                                <button class="btn btn-danger" data-dismiss="modal">取消</button>
                            </div>
                            <a href="" data-toggle="modal" data-dismiss="modal" data-target="#login">已有账号？点我登录</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    
    
	<!-- 登录窗口 -->
	<div id="login" class="modal fade" title="Popover title"
            data-container="body" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<button class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
				</div>
				<div class="modal-title">
					<h1 class="text-center">登录</h1>
				</div>
	
				<div class="modal-body">
                    <form  action="${ctx}/index.action" class="form-group" method="post">
                                    <div class="form-group">
                                        <label>用户名</label> <input class="form-control" type="text" name="userName"
                                            placeholder="请输入用户名">
                                    </div>
                                    <div class="form-group">
                                        <label>密码</label> <input class="form-control"
                                            type="password" name="password" placeholder="请输入密码">
                                    </div>
                                    <div class="text-right">
                                        <input type="submit"  class="btn btn-primary"  value="登录"/>
                                        <button class="btn btn-danger" data-dismiss="modal">取消</button>
                                    </div>
                    </form>
						<a href="" data-toggle="modal" data-dismiss="modal"
							data-target="#register">还没有账号？点我注册</a>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>
