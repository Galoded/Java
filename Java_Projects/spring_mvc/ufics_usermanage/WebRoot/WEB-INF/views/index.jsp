<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎页</title>
<script type="text/javascript">
	
	function toUsers(){
		location.href("${ctx}/user/user2.do");
	}
</script>
</head>
<body>
<h1>Hello, Superme</h1>
<input type="button" value="goto" border="0" onclick="toUsers();">
</body>
</html>