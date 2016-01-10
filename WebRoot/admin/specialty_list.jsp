<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
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
<title>Specialtys List Page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<!-- 新 Bootstrap 核心 CSS 文件 -->
<!-- <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
<link rel="stylesheet" type="text/css" href="./bootstrap/css/bootstrap.min.css">

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<!-- <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script> -->
<script src="./jquery/jquery-2.1.4.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<!-- <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script> -->
<script src="./bootstrap/js/bootstrap.min.js"></script>

<script src="./admin/js/table_title.js"></script>
<script type="text/javascript">
	var url_update = "/TripServer/ZZHP/Specialty_updateAction.action";
	var url_delete = "/TripServer/ZZHP/Specialty_deleteAction.action";
	var url_find = "/TripServer/ZZHP/Specialty_findAction.action";
	var url_add = "/TripServer/ZZHP/Specialty_addAction.action";
</script>
</head>
<body>
	<BR />
	<!-- MAIN CONTENT -->
	<div class="container-fluid">
		<div class="row">
			<!-- main -->
			<div class="col-xs-12 col-sm-6 col-md-12">
				<h4 class="text-center">特产列表 <small>管理</small></h4>
				<br />
				<!-- 普通 Table ps:内容太长可加text-overflow-->
				<div class="table-responsive" id="table">
					<table class="table table-bordered .table-condensed table-hover text-center">
						<thead>
							<tr>
								<s:iterator value="#request.TitleList">
									<th class="text-center"><s:property /></th>
								</s:iterator>
								<th class="text-center">修改</th>
								<th class="text-center">删除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.pager.resultList">
								<tr id='<s:property value="specialId" />'>
									<td><s:property value="specialId" /></td>
									<td><s:property value="specialName" /></td>
									<td><s:property value="specialInfo" /></td>
									<td><s:property value="specialAddress" /></td>
									<td><s:property value="createDate" /></td>
									<td><s:property value="remark" /></td>
									<td><a href="javascript:update('<s:property value="specialId" />');">修改</a></td>
									<td><a href="javascript:deleteFunction(url_delete,'<s:property value="specialId" />','<s:property value="#request.pager.getCurrentPage()" />');">刪除</a></td>
								</tr>
							</s:iterator>
							<tr>
								<th class="text-center" colspan="8" onclick="add();"><i class="glyphicon glyphicon-plus"></i></th>
							</tr>
						</tbody>
					</table>
				</div>
				<a href="javascript:void(0)" onclick="show();" target="_top">模态框示例</a>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-12 text-center">
						<!-- 分页器 -->
						当前第<s:property value="#request.pager.getCurrentPage()" />页
						（共 <s:property value="#request.pager.getRecordSUM()" />条，
						<s:property value="#request.pager.getPageSUM()" />页）
						<s:if test="#request.pager.isFirstPage()">
							<a href="javascript:gopage(url_find,1,'<s:property value="#request.pram" />');">首页</a>
						</s:if> 
						<s:if test="#request.pager.isHasPreviousPage()">
							<a href="javascript:gopage(url_find,'<s:property value="#request.pager.previousPage()" />','<s:property value="#request.pram" />');">上一页</a>
						</s:if> 
						<s:if test="#request.pager.isHasNextPage()">
							<a href="javascript:gopage(url_find,'<s:property value="#request.pager.nextPage()" />','<s:property value="#request.pram" />');">下一页</a>
						</s:if> 
						<s:if test="#request.pager.isLastPage()">
							<a href="javascript:gopage(url_find,'<s:property value="#request.pager.getPageSUM()" />','<s:property value="#request.pram" />');">末页</a>
						</s:if> 
						到第<select name="page" onChange="javascript:gopage(url_find,this.value,'<s:property value="#request.pram" />');">
						<s:bean name="org.apache.struts2.util.Counter" id="counter">
						<s:param name="first" value="0" />
						<s:param name="last" value="#request.pager.getPageSUM()-1" />
						<s:iterator>
						<s:if test="current==#request.pager.getCurrentPage()">
							<option value="<s:property value="current" />"
								selected="selected">
								<s:property value="current" />
							</option>
						</s:if>
						<s:else>
							<option value="<s:property value="current" />">
								<s:property value="current" />
							</option>
						</s:else>
						</s:iterator>
						</s:bean>
						</select>页
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- FOOT BAR -->
	<!-- <nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">...</div>
	</nav> -->
	
	<!-- 模态框 -->
	<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="modalLabel">Add Or Update Specialty</h4>
				</div>
				<div class="modal-body">
					<form id="form" method="post" class="form-horizontal">
						<input type="hidden" id="specialId" name="specialty.specialId">
						<input type="hidden" id="createDate" name="specialty.createDate">
						<input type="hidden" id="pages" name="pages" value="<s:property value="#request.pager.getCurrentPage()" />">
						<div class="form-group">
							<label for="specialName" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(1)" />:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="specialName" name="specialty.specialName">
							</div>
						</div>
						<div class="form-group">
							<label for="specialInfo" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(2)" />:</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="specialInfo" name="specialty.specialInfo"></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="specialAddress" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(3)" />:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="specialAddress" name="specialty.specialAddress">
							</div>
						</div>
						<div class="form-group">
							<label for="remark" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(5)" />:</label>
							<div class="col-sm-10">
								<textarea class="form-control" id="remark" name="specialty.remark"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" onclick="check();">Send</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function update(target) {
			var tds=$('#'+target).find('td');
			$('#specialId').val(tds.eq(0).text());
			$('#specialName').val(tds.eq(1).text());
			$('#specialInfo').val(tds.eq(2).text());
			$('#specialAddress').val(tds.eq(3).text());
			$('#createDate').val(tds.eq(4).text());
			$('#remark').val(tds.eq(5).text());
			$('#modal .modal-body > form').attr('action', url_update);
			/*也可以不写，然后href="#exampleModal"*/
			$('#modal').modal('show');
		};
		function add() {
			$('#createDate').val("");
			$('#specialId').val("");
			$('#modal .modal-body > form').attr('action', url_add);
			/*也可以不写，然后href="#exampleModal"*/
			$('#modal').modal('show');
		};
		function check(){
			// 非空判断 
			if($('#specialName').val()==""||$('#specialInfo').val()==""||$('#specialAddress').val()==""
			||$('#remark').val()==""){ 
				alert("亲，请不要留空哦！");
				return false; 
			}
			// 提交表单
			$('#form').submit();
		}
	</script>
</body>
</html>
