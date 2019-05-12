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
	<form action="${pageContext.request.contextPath}/rest/user/deleteByIds.do" method="post">
		<input type="text" name="txt" align="right"> 
		<input type="submit" value="查询" align="right"> 
		<input type="submit" value="批量删除" align="right">
		<table width="100%" border="1" title="人员列表">
			<tr bgcolor="gray" align="center">
				<td></td>
				<td>工号</td>
				<td>姓名</td>
				<td>江湖外号</td>
				<td>性别</td>
				<td>生日</td>
				<td>电话</td>
				<td>联系地址</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${usersList}" var="user">
				<tr>
					<td><input type="checkbox" name="user_ids" value="${user.user_id}">
					</td>
					<td>${user.user_id}</td>
					<td>${user.user_name}</td>
					<td>${user.nick_name}</td>
					<td>${user.sex}</td>
					<td><fmt:formatDate value="${user.birthday}"
							pattern="yyyy-MM-dd" /></td>
					<td>${user.telephone}</td>
					<td>${user.address}</td>
					<td><a
						href="${pageContext.request.contextPath}/rest/user/usersUpdateById/${user.user_id}">修改</a>
						<a
						href="${pageContext.request.contextPath}/user/usersDeleteById.do?user_id=${user.user_id}">删除</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>