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
<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

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

<script>
	$(document).ready(function() {/*文档初始化加载*/
	});
</script>

</head>
<body>
	<!-- TOP BAR -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Brand</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Link <span class="sr-only">(current)</span>
					</a></li>
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span> </a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">One more separated link</a></li>
						</ul>
					</li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Link</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Dropdown <span class="caret"></span> </a>
						<ul class="dropdown-menu">
							<li><a href="#">Action</a></li>
							<li><a href="#">Another action</a></li>
							<li><a href="#">Something else here</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#">Separated link</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- MAIN CONTENT -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12 col-sm-6 col-md-2 table-bordered">
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					<li><a href="#" class="table-bordered"> <i
							class="glyphicon glyphicon-th-large"></i> 首页 </a></li>
					<li><a href="#systemSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-cog"></i>
							系统管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="systemSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a>
							</li>
							<li><a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;菜单管理</a>
							</li>
							<li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;角色管理</a>
							</li>
							<li><a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a>
							</li>
							<li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a>
							</li>
						</ul>
					</li>
					<li><a href="javascript:void(0)" onclick="show();"> <i
							class="glyphicon glyphicon-credit-card"></i> 更新管理 </a>
					</li>
					<li><a href="./grid.html"> <i
							class="glyphicon glyphicon-globe"></i> 分发配置 <span
							class="label label-warning pull-right">5</span> </a></li>
					<li><a href="./charts.html"> <i
							class="glyphicon glyphicon-calendar"></i> 图表统计 </a>
					</li>
					<li><a href="#"> <i class="glyphicon glyphicon-fire"></i>关于系统
					</a>
					</li>
				</ul>
			</div>
			<div class="col-xs-12 col-sm-6 col-md-10">
				<!-- DIV Table 样式 -->
				<!-- <h4 class="text-center">h4. Bootstrap heading <small>Secondary text</small></h4>
				<br />
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-4">.col-xs-12 .col-sm-6
						.col-md-4</div>
					<div class="col-xs-12 col-sm-6 col-md-4">.col-xs-12 .col-sm-6
						.col-md-4</div>
					<div class="col-xs-12 col-sm-6 col-md-4">.col-xs-12 .col-sm-6
						.col-md-4</div>
				</div> -->
				<!-- 普通 Table ps:内容太长可加text-overflow-->
				<div class="table-responsive">
					<table
						class="table table-bordered .table-condensed table-hover text-center">
						<thead>
							<tr>
								<th class="text-center">#</th>
								<th class="text-center">First Name</th>
								<th class="text-center">Last Name</th>
								<th class="text-center">Username</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<th scope="row" class="text-center">1</th>
								<td>Mark</td>
								<td>Otto</td>
								<td>@mdo</td>
							</tr>
							<tr>
								<th scope="row" class="text-center">2</th>
								<td>Jacob</td>
								<td>Thornton</td>
								<td>@fat</td>
							</tr>
							<tr>
								<th scope="row" class="text-center">3</th>
								<td>Larry</td>
								<td>the Bird</td>
								<td>@twitter</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- FOOT BAR -->
	<nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">...</div>
	</nav>
	
	<!-- 模态框 -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">New message</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="recipient-name" class="control-label">Recipient:</label>
							<input type="text" class="form-control" id="recipient-name">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">Message:</label>
							<textarea class="form-control" id="message-text"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary">Send message</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function show() {
			/*也可以不写，然后href="#exampleModal"*/
			$('#exampleModal').modal('show');
		};
		$('#exampleModal').on('show.bs.modal', function(event) {
			var button = $(event.relatedTarget); // Button that triggered the modal
			var recipient = button.data('whatever'); // Extract info from data-* attributes
			// If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			// Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			var modal = $(this);
			modal.find('.modal-title').text('New message to ' + recipient);
			modal.find('.modal-body input').val(recipient);
		});
	</script>
</body>
</html>
