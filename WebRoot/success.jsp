<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="GBK"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>成功</title>
</head>
<body>
	<h1>Success!</h1>
	<br />
	<s:iterator value="#request.list" var="info">
		<s:property value="#info.toString()" />
		<br />
	</s:iterator>
</body>
</html>