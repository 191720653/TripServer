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
<title>Main Page</title>
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

<script src="./admin/js/table_title.js"></script>

</head>
<body>
	<BR />
	<!-- MAIN CONTENT -->
	<div class="container-fluid">
		<div class="row">
			<!-- main -->
			<div class="col-xs-12 col-sm-6 col-md-10">
				<h4 class="text-center">h4. Bootstrap heading <small>Secondary text</small></h4>
				<br />
				<!-- 普通 Table ps:内容太长可加text-overflow-->
				<div class="table-responsive" id="table">
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
								<td class="text-center">1</td>
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
								<td>@twitter<a href="javascript:void(0)" onclick="update(this);">模态框示例</a></td>
							</tr>
							<tr>
								<th class="text-center" colspan="4" onclick="check();"><i class="glyphicon glyphicon-plus"></i></th>
							</tr>
						</tbody>
					</table>
				</div>
				<a href="javascript:void(0)" onclick="show();" target="_top">模态框示例</a>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-10 text-center">
						<ul id="page" class="pagination"></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- FOOT BAR -->
	<nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">...</div>
	</nav>
	
	<!-- 模态框 -->
	<div class="modal fade" id="modal" tabindex="-1" role="dialog"
		aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">New message</h4>
				</div>
				<div class="modal-body">
					<form id="form" method="post" action="user_login_submit.action">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Recipient:</label>
							<input type="text" class="form-control" id="recipient-name">
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">Message:</label>
							<textarea class="form-control" id="message-text"></textarea>
						</div>
						<div class="form-group">
							<label for="specialName" class="control-label">"#request.TitleList.get(1)" :</label>
							<input type="text" class="form-control" id="specialName" name="special.specialName">
						</div>
						<div class="form-group">
							<label for="specialInfo" class="control-label">property value="#request.TitleList.get(2)" />:</label>
							<input type="text" class="form-control" id="specialInfo" name="specialInfo">
						</div>
						<div class="form-group">
							<label for="specialAddress" class="control-label">:property value="#request.TitleList.get(3)" />:</label>
							<input type="text" class="form-control" id="specialAddress" name="special.specialAddress">
						</div>
						<div class="form-group">
							<label for="createDate" class="control-label">property value="#request.TitleList.get(4)" />:</label>
							<input type="text" class="form-control" id="createDate" name="special.createDate">
						</div>
						<div class="form-group">
							<label for="remark" class="control-label">property value="#request.TitleList.get(5)" />:</label>
							<textarea class="form-control" id="remark" name="special.remark"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" onclick="check();">Send message</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function check(){
			// 非空判断
			if($('#recipient-name').value==""){
				alert("亲，请不要留空哦！");
				return false;
			}
			// 提交表单
			$('#form').submit();
		}
		function update(target) {
			var tds=$(target).parent().parent().find('td');
			$('#recipient-name').val(tds.eq(0).text());
			$('#message-text').val(tds.eq(1).text());
			/*也可以不写，然后href="#exampleModal"*/
			$('#modal').modal('show');
		};
	</script>
</body>
</html>
