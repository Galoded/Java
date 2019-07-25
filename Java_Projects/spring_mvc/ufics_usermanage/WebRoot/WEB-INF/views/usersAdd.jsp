<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UFMEN</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/usersInsert.do"
		method="post">
		<table width="100%" border="1">
			<tr>
				<td>工号</td>
				<td><input type="text" name="user_id" value="${user_id}"></td>
			</tr>
			<tr>
				<td>姓名</td>
				<td><input type="text" name="user_name"
					value="${user_name}"></td>
			</tr>
			<tr>
				<td>江湖外号</td>
				<td><input type="text" name="nick_name"
					value="${nick_name}"></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="text" name="sex" value="${sex}"></td>
			</tr>
			<tr>
				<td>生日</td>

				<td><input type="text" name="birthday"
					value="<fmt:formatDate value="${birthday}" pattern="yyyy-MM-dd" />">
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="telephone"
					value="${telephone}"></td>
			</tr>
			<tr>
				<td>联系地址</td>
				<td><input type="text" name="address" value="${address}">
				</td>
			</tr>
			<%-- <tr>
				<td>照片</td>
				<td><input type="text" name="address" value="${address}">
				</td>
			</tr> --%>
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>