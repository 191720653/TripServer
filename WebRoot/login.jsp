<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>Login Page</title>
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> -->
<!--<link rel="stylesheet" href="bootstrap.min.css">-->
<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css">
<script src="./jquery/jquery-2.1.4.js"></script>
<script src="./bootstrap/js/bootstrap.min.js"></script>
<style>
.horizontal {
	position: absolute;
	top: 50%;
	-webkit-transform: translateY(-50%);
	-moz-transform: translateY(-50%);
	-ms-transform: translateY(-50%);
	-o-transform: translateY(-50%);
	transform: translateY(-50%);
}
body {
	background: url("./photoes/login.jpg") top center no-repeat;
	background-size: cover;
}
.container {
	padding-top: 15%;
}
.content_head {
	padding-top: 5px;;
	background: rgba(255, 255, 255, 0.5) !important;
	filter: Alpha(opacity = 90);
	background: #fff; /*　使用IE专属滤镜实现IE背景透明*/
}
.content_form {
	padding: 30px 30px;
	background: rgba(255, 255, 255, 0.4) !important;
	filter: Alpha(opacity = 80);
	background: #fff; /*　使用IE专属滤镜实现IE背景透明*/
}
</style>
<script type="text/javascript">
	function check() {
		//document.forms.form1.username.value取得form1中Username的值 并判断是否为空
		if (document.forms.LoginForm.user_account.value == "") {
			//如果 为""则弹出提示
			alert("请输入用户名！");
			//将输入焦点定位到没有输入的地方
			document.forms.LoginForm.user_account.focus();
			//返回错误
			return false;
		} else if (document.forms.LoginForm.user_password.value == "") {
			//如果 为""则弹出提示
			alert("请输入密码！");
			//将输入焦点定位到没有输入的地方
			document.forms.LoginForm.user_password.focus();
			//返回错误
			return false;
		}else {
			document.forms.LoginForm.submit();
		}
	}
</script>
</head>
<body>
	<!-- <div class="navbar-fixed-top">
		<h1>
			<em>&nbsp;&nbsp;By ZeHao</em>
		</h1>
	</div> -->
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3 content_head">
				<p>
					<strong>中山市南区后台管理系统</strong>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-6 col-sm-offset-3 content_form">
				<form class="form-horizontal" name="LoginForm" method="POST" action="/TripServer/ZZHP/Login_loginAction.action">
					<div class="form-group has-success has-feedback">
						<label for="account" class="col-sm-2 control-label">账号:</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="account" name="user_account"
								placeholder="账号" aria-describedby="inputSuccessAStatus">
							<span
								class="glyphicon glyphicon-warning-sign form-control-feedback"
								aria-hidden="true"></span> <span id="inputSuccessAStatus"
								class="sr-only">(success)</span>
						</div>
					</div>
					<div class="form-group has-success has-feedback">
						<label for="password" class="col-sm-2 control-label">密码:</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password" name="user_password"
								placeholder="密码" aria-describedby="inputSuccessPStatus">
							<span
								class="glyphicon glyphicon-warning-sign form-control-feedback"
								aria-hidden="true"></span> <span id="inputSuccessPStatus"
								class="sr-only">(success)</span>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-8">
							<button class="btn btn-info" onclick="return check();">登录</button>
							<button type="reset" class="btn btn-default">重置</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="navbar-fixed-bottom">
		<div class="row" style="background: rgba(0, 0, 0, 0.4) !important;">
			<br />
			<p align="center"><s:property value="#request.message"></s:property></p>
			<br />
		</div>
		<div class="row" style="background: #31b0d5; margin-bottom: 0">
			<br />
			<br />
		</div>
	</div>
</body>
</html>