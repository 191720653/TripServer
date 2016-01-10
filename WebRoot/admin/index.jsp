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
	<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

</head>

<frameset rows="52,*" cols="*" id="parentFrame" name="parentFrame" frameborder="0" framespacing="0">
	<frame src="./admin/top.jsp" id="topFrame" name="topFrame" scrolling="NO" noresize >
	<frameset cols="200,*" id="bottomFrames" frameborder="0"  framespacing="0">
		<frame src="./admin/menu.jsp" id="leftFrame" name="leftFrame" scrolling="yes" noresize>
		<frame src="./admin/main.jsp" id="mainFrame" name="mainFrame">
	</frameset>
</frameset>
<noframes>
<body>
	亲，您的浏览器太out了，不支持本系统！<br/>
	请换个新版的浏览器来吧！
</body>
</noframes>

</html>
