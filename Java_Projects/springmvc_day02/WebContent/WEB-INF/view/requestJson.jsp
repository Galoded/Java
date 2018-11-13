<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script type="text/javascript">
	function requestJson(){
		var jsonUser= JSON.stringify({"name":"donghao","age":"28","birthday":"1990-09-04"});
		$.ajax({
			
			type:'post',
			url:'${pageContext.request.contextPath }/user/receiveUserJson.do',
			contentType:'application/json;charset=utf-8',
			data:jsonUser,
			success:function(data){
				alert(data);
			}
		})
	}
	function requestPojo(){
		var jsonUser= 'name=donghao&age=28';
		$.ajax({
			
			type:'post',
			url:'${pageContext.request.contextPath }/user/requestPojo.do',
			data:jsonUser,
			success:function(data){
				alert(data);
			}
		})
	}
</script>
</head>
<body>

<input type="button" value="json" onclick="requestJson();"></input>
<input type="button" value="pojo" onclick="requestPojo();"></input>

</body>
</html>