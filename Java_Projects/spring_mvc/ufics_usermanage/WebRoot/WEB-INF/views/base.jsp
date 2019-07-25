<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 把公用变量、资源放到公用的jsp里面，其他页面引入该公用jsp即可 -->
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<%-- <link rel="stylesheet" rev="stylesheet" type="text/css" href="${ctx}/skin/default/css/default.css" media="all"/>
<script language="javascript" src="${ctx}/js/common.js"></script> --%>