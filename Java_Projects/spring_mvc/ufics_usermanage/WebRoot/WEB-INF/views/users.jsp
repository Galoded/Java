<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UFMEN</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div id="AddUser">
		<table width="100%" border="0" cellspacing="0">
			<tr>
				<td style="text-align: right"><input type="text" id="userName"
					name="userName" onclick="searchName();" /><input type="button"
					value="搜索" border="0"><input type="button" value="新增"
					border="0"> <input type="button" value="批量删除" border="0"></td>
			</tr>
		</table>
	</div>
	<div>
		<table cellspacing="0" width="100%" border="1">
			<tr>
				<td width="5%"></td>
				<td width="10%">工号</td>
				<td width="10%">姓名</td>
				<td width="10%">江湖外号</td>
				<td width="10%">性别</td>
				<td width="10%">生日</td>
				<td width="10%">电话</td>
				<td width="15%">联系地址</td>
				<td width="20%">操作</td>
			</tr>
		</table>
		<c:forEach items="${usersList}" var="user">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td width="5%"><input type="checkbox" name="user_ids"
						value="${user.user_id}"></td>
					<td width="10%">${user.user_id}</td>
					<td width="10%">${user.user_name}</td>
					<td width="10%">${user.nick_name}</td>
					<td width="10%">${user.sex}</td>
					<td width="10%"><fmt:formatDate value="${user.birthday}"
							pattern="yyyy-MM-dd" /></td>
					<td width="10%">${user.telephone}</td>
					<td width="15%">${user.address}</td>
					<td width="20%"><a
						href="${pageContext.request.contextPath}/rest/user/usersUpdateById/${user.user_id}">修改</a>
						<a
						href="${pageContext.request.contextPath}/user/usersDeleteById.do?user_id=${user.user_id}">删除</a>
					</td>
				</tr>
			</table>
		</c:forEach>

	</div>
</body>
</html>