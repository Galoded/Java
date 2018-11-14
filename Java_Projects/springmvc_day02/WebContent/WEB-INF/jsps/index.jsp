<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/user/receiveUser.do" method="post">
姓名：<input type="text" name="name" id="username"> 
年龄：<input type="text" name="age" id="age"> 
生日：<input type="text" name="birthday" id="bithday"> 
<input type="submit" value="提交" >
</form>

<hr color="blue" size="12">

<form action="${pageContext.request.contextPath}/user/receiveInt.do" method="post">
数量：<input type="text" name="userId" id="userId"> 
<input type="submit" value="提交" >
</form>

<hr color="blue" size="12">

<form action="${pageContext.request.contextPath}/user/receiveUserCustom.do" method="post">
姓名：<input type="text" name="user.name" id="username"> 
年龄：<input type="text" name="user.age" id="age"> 
生日：<input type="text" name="user.birthday" id="bithday"> 
<input type="submit" value="提交" >
</form>

</body>
</html>