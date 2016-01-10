<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>">
<title>Menu Page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<!-- 新 Bootstrap 核心 CSS 文件 -->
<!-- <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<link rel="stylesheet" type="text/css"
	href="./bootstrap/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<!-- <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script> -->
<script src="./jquery/jquery-2.1.4.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<!-- <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<script src="./bootstrap/js/bootstrap.min.js"></script>

<script src="./admin/js/table_title.js"></script>

<style type="text/css">
/*控制菜单箭头*/
.nav-header.collapsed>span.glyphicon-chevron-toggle:before {
	content: "\e114";
}

.nav-header>span.glyphicon-chevron-toggle:before {
	content: "\e113";
}
/*二级菜单选中样式*/
.secondmenu a {
	font-size: 12px;
	color: #4A515B;
	text-align: center;
}

.secondmenu li.active {
	background-color: #eee;
	border-color: #428bca;
}
</style>

</head>
<body>
	<BR />
	<!-- MAIN CONTENT -->
	<div class="container-fluid">
		<div class="row">
			<!-- memu -->
			<div class="col-xs-12 col-sm-6 col-md-2 table-bordered">
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					<li><a href="/TripServer/admin/index.jsp" target="_top" class="table-bordered"> <i
							class="glyphicon glyphicon-th-large"></i> 首页 </a></li>
					<li><a href="#systemSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-asterisk"></i>
							用户信息管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="systemSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="/TripServer/ZZHP/User_findAction.action" target="mainFrame">
								<i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a>
							</li>
							<li><a href="/TripServer/ZZHP/Comment_findAction.action" target="mainFrame">
								<i class="glyphicon glyphicon-thumbs-up"></i>&nbsp;评论管理</a>
							</li>
						</ul>
					</li>
					<li><a href="#VVSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-asterisk"></i>
							村庄景点管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="VVSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="/TripServer/ZZHP/Village_findAction.action" target="mainFrame"><i class="glyphicon glyphicon-home"></i>&nbsp;村庄管理</a>
							</li>
							<li><a href="/TripServer/ZZHP/Views_findAction.action" target="mainFrame"><i class="glyphicon glyphicon-tree-conifer"></i>&nbsp;景点管理</a>
							</li>
						</ul>
					</li>
					<li><a href="#ResSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-asterisk"></i>
							资源管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
							</a>
						<ul id="ResSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="/TripServer/ZZHP/ViewImage_findAction.action" target="mainFrame"><i class="glyphicon glyphicon-picture"></i>&nbsp;相册管理</a>
							</li>
						</ul>
					</li>
					<li><a href="#SSSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-asterisk"></i>
							特产名店管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="SSSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="/TripServer/ZZHP/Specialty_findAction.action" target="mainFrame"><i class="glyphicon glyphicon-cutlery"></i>&nbsp;特产管理</a>
							</li>
							<li><a href="/TripServer/ZZHP/Store_findAction.action" target="mainFrame"><i class="glyphicon glyphicon-inbox"></i>&nbsp;名店管理</a>
							</li>
						</ul>
					</li>
					<li><a href="/TripServer/admin/index.jsp" target="mainFrame"> <i class="glyphicon glyphicon-info-sign"></i>&nbsp;关于系统</a></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- FOOT BAR -->
	<!-- <nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">...</div>
	</nav> -->
</body>
</html>
