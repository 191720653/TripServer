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
<title>Other List Page</title>
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
<script type="text/javascript">
	var url_update = "/TripServer/ZZHP/Other_updateAction.action";
	var url_delete = "/TripServer/ZZHP/Other_deleteAction.action";
	var url_find = "/TripServer/ZZHP/Other_findAction.action";
	var url_add = "/TripServer/ZZHP/Other_addAction.action";
</script>
</head>
<body>
	<BR />
	<!-- MAIN CONTENT -->
	<div class="container-fluid">
		<div class="row">
			<!-- main -->
			<div class="col-xs-12 col-sm-6 col-md-12">
				<h4 class="text-center">其它列表 <small>管理</small></h4>
				<br />
				<!-- 普通 Table ps:内容太长可加text-overflow-->
				<div class="table-responsive" id="table">
					<table class="table table-bordered .table-condensed table-hover text-center">
						<thead>
							<tr>
								<s:iterator value="#request.TitleList" status="status">
									<th class="text-center"><s:property /></th>
								</s:iterator>
								<th class="text-center">修改</th>
								<th class="text-center">删除</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="#request.pager.resultList">
								<tr id='<s:property value="id" />'>
									<td style="width: 10%;vertical-align:middle;"><s:property value="id" /></td>
									<td style="width: 10%;vertical-align:middle;"><s:property value="name" /></td>
									<td style="width: 10%;vertical-align:middle;"><a tabindex="0" class="btn" role="button" data-toggle="popover" data-trigger="focus" title="简介" data-content="<s:property value="info" />">点击查看</a></td>
									<td style="width: 30%;vertical-align:middle;"><img onmouseover="this.style.transform='scale(2)';" onmouseout="this.style.transform='scale(1)';" class="thumbnail" width="20%" src="<s:property value="logo" />" data-content="<s:property value="logo" />"></td>
									<td style="width: 10%;vertical-align:middle;"><s:property value="likeNum" /></td>
									<td hidden="hidden"><s:property value="urls" /></td>
									<td style="width: 10%;vertical-align:middle;"><s:property value="type" /></td>
									<td hidden="hidden"><s:property value="createData" /></td>
									<td style="width: 10%;vertical-align:middle;"><s:property value="remark" /></td>
									<td style="width: 5%;vertical-align:middle;"><a href="javascript:update('<s:property value="id" />');">修改</a></td>
									<td style="width: 5%;vertical-align:middle;"><a href="javascript:deleteFunction(url_delete,'<s:property value="id" />','<s:property value="#request.pager.getCurrentPage()" />');">刪除</a></td>
								</tr>
							</s:iterator>
							<tr>
								<th class="text-center" colspan="10" onclick="add();"><i class="glyphicon glyphicon-plus"></i></th>
							</tr>
						</tbody>
					</table>
				</div>
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
			<script>
			function onchanges(page){
				$.ajax({
     				type: 'POST',
     				dataType: 'json',
     				url: '/TripServer/ZZHP/Other_getUrlsAction.action?id='+$("#select_id").val() ,
    				data: "" ,
    				success: function(data) {
    					if(data==0){
    						$('#urls').html("暂时还没有图片哦... ... ");
    					}else{
    						$('#urls').html("");
    						for(var i=0;i<data.length;i++){
    							var img = "<td><img class='thumbnail' onclick='deleteUrl(" + i + "," + page + ")' id='image" + i + "' width='100%' src='" + data[i] + "' data-content='" + $("#select_id").val() + "'></td>";
    							$('#urls').append(img);
    						}
    					}
    				}
				});
			}
			function updateUrl(){
				if($('#select_id').val()==""||$('#images').val()==""){
					alert("请选择名称或图片！");
					return false;
				}
				$('#forms').submit();
			}
			function deleteUrl(index,page){
				if(confirm("确定删除这张图片吗？")){
					window.location.href = "/TripServer/ZZHP/Other_deleteUrlAction.action?id="+$('#image'+index).attr('data-content')+"&index="+index+"&pages="+page;
				}
			}
			</script>
			<div class="col-xs-12 col-sm-6 col-md-12">
				<table class="table table-bordered .table-condensed table-hover text-center">
						<thead>
							<tr><form id="forms" method="post" enctype="multipart/form-data" action="/TripServer/ZZHP/Other_updateUrlsAction.action">
								<th style="width: 33%;">
								图片管理           名称：<select id="select_id" name="id" onchange="onchanges('<s:property value="#request.pager.getCurrentPage()" />')">
									<option value="">请选择... ... </option>
									<s:iterator value="#request.pager.resultList" status="status">
										<option value="<s:property value="id"/>"><s:property value="name"/></option>
									</s:iterator>
  								</select>
  								</th>
  								<th style="width: 33%;"><input type="file" id="images" name="image"></th>
  								<th style="width: 33%;"><input type="button" onclick="updateUrl();" value="提交"></th></form>
							</tr>
						</thead>
						<tbody>
							<tr id='urls'></tr>
							<!-- <tr><td style='width: 33%;'></td><td style='width: 33%;'></td><td style='width: 33%;'></td></tr> -->
						</tbody>
				</table>
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
					<h4 class="modal-title" id="modalLabel">Add Or Update Other</h4>
				</div>
				<div class="modal-body">
					<form id="form" method="post" class="form-horizontal" enctype="multipart/form-data">
						<input type="hidden" id="id" name="other.id">
						<input type="hidden" id="_urls" name="other.urls">
						<input type="hidden" id="createData" name="other.createData">
						<input type="hidden" id="logo" name="other.logo">
						<input type="hidden" id="pages" name="pages" value="<s:property value="#request.pager.getCurrentPage()" />">
						<div class="form-group">
							<label for="name" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(1)" />:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="name" name="other.name">
							</div>
						</div>
						<div class="form-group">
							<label for="info" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(2)" />:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="info" name="other.info">
							</div>
						</div>
						<div class="form-group">
							<label for="image" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(3)" />:</label>
							<div class="col-sm-10">
								<input type="file" class="form-control" id="image" name="image">
							</div>
						</div>
						<div class="form-group">
							<label for="likeNum" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(4)" />:</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="likeNum" name="other.likeNum">
							</div>
						</div>
						<div class="form-group">
							<label for="type" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(5)" />:</label>
							<div class="col-sm-10">
								<select class="form-control" id="type" name="other.type">
  									<option value="1">名人典故</option>
  									<option value="2">名点美食</option>
  									<option value="3">民品民俗</option>
  								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="remark" class="col-sm-2 control-label"><s:property value="#request.TitleList.get(6)" />:</label>
								<div class="col-sm-10">
								<textarea class="form-control" id="remark" name="other.remark"></textarea>
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
		$(function () {
  			$('[data-toggle="popover"]').popover();
		});
		function update(target) {
			var tds=$('#'+target).find('td');
			$('#id').val(tds.eq(0).text());
			$('#name').val(tds.eq(1).text());
			$('#info').val(tds.eq(2).children('a').attr('data-content'));
			$('#logo').val(tds.eq(3).children('img').attr('data-content'));
			$('#likeNum').val(tds.eq(4).text());
			$('#_urls').val(tds.eq(5).text());
			$('#type').val(tds.eq(6).text());
			$('#createData').val(tds.eq(7).text());
			$('#remark').val(tds.eq(8).text());
			$('#modal .modal-body > form').attr('action', url_update);
			/*也可以不写，然后href="#exampleModal"*/
			$('#modal').modal('show');
		};
		function add() {
			$('#createData').val("");
			$('#id').val("");
			$('#logo').val("");
			$('#urls').val("");
			$('#modal .modal-body > form').attr('action', url_add);
			/*也可以不写，然后href="#exampleModal"*/
			$('#modal').modal('show');
		};
		function check(){
			// 非空判断
			if($('#name').val()==""||$('#info').val()==""||$('#type').val()==""
			||$('#image').val()==""||$('#remark').val()==""){ 
				alert("亲，请不要留空哦！");
				return false; 
			}
			// 提交表单
			$('#form').submit();
		}
	</script>
</body>
</html>
