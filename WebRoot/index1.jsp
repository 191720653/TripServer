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

<script src="./js/table_title.js"></script>

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
	
	// 全局标志，管理哪个模块--Action跳转路径标志
	var model = "";
	// 各模块统一增删改查方法名，访问路径为：model+_+(统一的方法名)+Action.action?+参数
	// example：model=User,则提交路径User_addAction.action?name=zehao&age=20
	// 统一调用一个更新方法
	function super_update(){
		// 可传人参数也可通过Id获取值
		// 拼凑更新地址
		var update_url = model+"_updateAction.action?";
		// for循环加上参数，条件i<(获取到的列标题)titles.size()
	}
	function super_delete(target){
		alert("coming to super_delete");
		// 可传人参数也可通过Id获取值
		// 拼凑删除地址
		var delete_url = model+"_deleteAction.action?";
		// for循环加上参数，条件i<(获取到的列标题)titles.size()
	}
	function super_add(){
		// 可传人参数也可通过Id获取值
		// 拼凑增加地址
		var add_url = model+"_addAction.action?";
		// for循环加上参数，条件i<(获取到的列标题)titles.size()
	}
	function super_query(){
		// 可传人参数也可通过Id获取值
		// 拼凑查询地址
		var query_url = model+"_queryAction.action?";
		// for循环加上参数，条件i<(获取到的列标题)titles.size()
	}
	// 用户管理模块
	function user(){
		// 更改模块标志
		model = "User";
		// 更改表头数据
		getTitles(model);
		// Ajax分页获取数据，携带每列标题titles，可以在本地js中先写好
		// 显示数据
		alert("进入用户模块管理！");
	}
	// 评论管理模块
	function comment(){
		// 更改模块标志
		model = "Comment";
		// Ajax分页获取数据
		// 显示数据
		alert("进入评论模块管理！");
	}
	// 其他模块 ... ...
	
	// 生成表格数据 <a href='Delete_delete?id=?' onclick='return confirm()'>删除</a>
	function bornTable(resultList){
		var table = "<table class='table table-bordered .table-condensed table-hover text-center'><thread><tr>";
		for(var i=0;i<table_title.length;i++){
			table = table + "<th>" + table_title[i] + "</th>";		
		}
		table = table + "</tr></thread>";
		var tbody = "<tbody>";
		for(var i=0;i<resultList.length;i++){
			var tr = "<tr>";
			var delete_sign=true;
			for(var j=0;j<table_title.length;j++){
				if(j==0){
					if(delete_sign){
						tr = tr + "<th scope='row' class='text-center'><a href='javascript:void(0)' onclick='super_delete(this);'>" 
						+ resultList[i][data_sign[j]] + "</a></th>";
						delete_sign=false;
					}else{
						tr = tr + "<th scope='row' class='text-center'>" + resultList[i][data_sign[j]] + "</th>";
					}
				}else{
					tr = tr + "<td>" + resultList[i][data_sign[j]] + "</td>";
				}
			}
			tbody = tbody + tr + "</tr>";
		}
		tbody = tbody + "</tbody>";
		table = table + tbody + "</table>";
		$("#table").append(table);
	}
	
	// 分页获取数据
	$(document).ready(function() {
		/*文档初始化加载*/
		
		user();
		
		var datas;
		function ajaxForData() {
			$.ajax({
				method : "Post",
				url : "/TripServer/ZZHP/User_getListAction.action?sign=false",
				async : true,
				data : "",
				dataType : 'json',
				success : function(data) {
					alert("Data Getted: " + data.resultList[0][data_sign[1]]);
					datas = data;
					bornTable(datas.resultList);
			        var sign = false;
			        var pages = datas.pageSUM;
					var options = {
						bootstrapMajorVersion:3,
						size:"normal",
						alignment:"center",
						currentPage: 1,
						totalPages: pages,
						numberOfPages:5,
						itemTexts: function (type, page, current) {
						    switch (type) {
						       case "first":
						           return "首页";
						       case "prev":
						           return "上一页";
						       case "next":
						           return "下一页";
						       case "last":
						           return "末页";
						       case "page":
						            return page;
						      }
						 },
						 itemContainerClass: function (type, page, current) {
						     return (page === current) ? "active" : "pointer-cursor";
						  },
						  useBootstrapTooltip:true,
						  bootstrapTooltipOptions: {
						  html: true,
						  placement: 'bottom'
						  },
						  onPageClicked: function(e,originalEvent,type,page){
						       $("#table").empty();
						       var tr = '';
						       var temp = page*10;
						       if(sign&&page==pages){
						           temp = temp + num;
						       }
						       for(var index=(page-1)*10;index<temp;index++){
						           tr = "<tr><td height='80px' width='80px'>" + "<a href='Delete_delete?id="+datas[index].customerId+"' onclick='return confirm()'>删除</a>" 
						           +" || <a href='javascript:void(0)' onclick='update(this);'>编辑</a>"
						           + "</td><td>"
						           + datas[index].customerId + "</td><td>"
						           + datas[index].firstName + "</td><td>"
						           + datas[index].lastName + "</td><td>"
						           + datas[index].address + "</td><td>"
						           + datas[index].email + "</td><td>"
						           + datas[index].lastUpdate.toString().substring(0,9) + "</td></tr>";
						           $("#table").append(tr);
						        }
						    }
					};
					$('#page').bootstrapPaginator(options);
				},
				timeout : 800,
				error : function(info, status, error) {
					alert('Error: ' + info.status + ' - ' + error);
				}
			});
		};
		ajaxForData();
	});
</script>

</head>
<body>
	<!-- TOP BAR -->
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><i class="glyphicon glyphicon-th"></i>导览后台管理</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Link</a></li>
					<li><a href="#">Link</a></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"></a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
						<i class="glyphicon glyphicon-user"></i>
						<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="#"><i class="glyphicon glyphicon-off"></i>&nbsp;注销退出</a></li>
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
			<!-- memu -->
			<div class="col-xs-12 col-sm-6 col-md-2 table-bordered">
				<ul id="main-nav" class="nav nav-tabs nav-stacked">
					<li><a href="#" class="table-bordered"> <i
							class="glyphicon glyphicon-th-large"></i> 首页 </a></li>
					<li><a href="#systemSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-asterisk"></i>
							用户信息管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="systemSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="javascript:void(0)" onclick="user();">
								<i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a>
							</li>
							<li><a href="javascript:void(0)" onclick="comment();">
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
							<li><a href="#"><i class="glyphicon glyphicon-home"></i>&nbsp;村庄管理</a>
							</li>
							<li><a href="#"><i class="glyphicon glyphicon-tree-conifer"></i>&nbsp;景点管理</a>
							</li>
						</ul>
					</li>
					<li><a href="#ResSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-asterisk"></i>
							资源管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="ResSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="#"><i class="glyphicon glyphicon-picture"></i>&nbsp;相册管理</a>
							</li>
						</ul>
					</li>
					<li><a href="#SSSetting" class="nav-header collapsed"
						data-toggle="collapse"> <i class="glyphicon glyphicon-asterisk"></i>
							特产名店管理 <span class="pull-right glyphicon glyphicon-chevron-toggle"></span>
					</a>
						<ul id="SSSetting" class="nav nav-list collapse secondmenu"
							style="height: 0px;">
							<li><a href="#"><i class="glyphicon glyphicon-cutlery"></i>&nbsp;特产管理</a>
							</li>
							<li><a href="#"><i class="glyphicon glyphicon-inbox"></i>&nbsp;名店管理</a>
							</li>
						</ul>
					</li>
					<li><a href="javascript:void(0)" onclick="show();"> <i
							class="glyphicon glyphicon-asterisk"></i> 模态框示例
							<span class="label label-warning pull-right">5</span> </a>
					</li>
					<li><a href="#"> <i class="glyphicon glyphicon-info-sign"></i>关于系统
					</a>
					</li>
				</ul>
			</div>
			<!-- main -->
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
