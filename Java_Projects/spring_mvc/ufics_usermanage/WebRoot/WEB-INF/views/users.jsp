<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UFMEN</title>

	<!-- 引入外部CSS文件 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/icon.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/easyui.css" type="text/css"></link>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	
	function addUsers() {
		location.href("${pageContext.request.contextPath}/user/usersToAdd.do");
	}
		
	function addUsers_click(){
		$('#win').window('open');
	}
	
	function winCancel_click(){
		$('#win').window('close');
	}
	
	function winOk_click(){
		$('#member_form').form('submit',{
			url:'${pageContext.request.contextPath}/user/usersInsert.do',
			onSubmit: function(){    
				var validate = $(this).form('validate');
				return validate;
			},    
		    success:function(data){    
		        if(data == "success"){
		        	$('#win').window('close');
		        }    
		    }
		});
	}	
	
	function editUsers_click(){
		var row = $('#personDatagrid').datagrid('getSelected');
		if(row == null){
			alert("请选择一行");
			return;
		}else{
			var userId = row.user_id;
			
			$.ajax({
				type : "GET",
				url : "${pageContext.request.contextPath}/user/findUsers.do",
				data : {
					"value" : userId
				},
				dataType:"json",
				success : function(data) {
					$('#win').window('open');
					$('#userid_in').attr("value", data[0].user_id);
					
				},
				error : function(e) {
					alert(e.message);
				}
			})
		}
	}
	
	function deteleUsers_click(){
		var row = $('#personDatagrid').datagrid('getSelected');
		if(row == null){
			alert("请选择一行");
			return;
		}else{
			var userId = row.user_id;
			
			$.ajax({
				type : 'GET',
				url : '${pageContext.request.contextPath}/user/findUsers.do',
				data : {
					user_id : userId
				},
				dataType : 'json',
				success : function(data) {
					getUsers(data);
				},
				error : function(e) {
					alert(e.message);
				}
			})
		}
	}
	
	function search(value, name) {

		$.ajax({
			type : 'GET',
			url : '${pageContext.request.contextPath}/user/findUsers.do',
			data : {
				"value" : value
			},
			dataType : 'json',
			success : function(data) {
				getUsers(data);
			},
			error : function(e) {
				alert(e.message);
			}
		})
	}
	
	function getUsers(data) {

		var jsonUsers = [];

		for (var i = 0; i < data.length; i++) {
			var user = {
				'user_id' : data[i].user_id,
				'user_name' : data[i].user_name,
				'nick_name' : data[i].nick_name,
				'sex' : data[i].sex,
				'birthday' : data[i].birthday,
				'telephone' : data[i].telephone,
				'address' : data[i].address
			};
			jsonUsers.push(user);
		}
		$('#personDatagrid').datagrid('loadData', jsonUsers);
	}
	
	function tooltips(){
		alert("hello");
	}
	
</script>

</head>
<body >
	 <script type="text/javascript">
		 $(function(){
			$('#personDatagrid').datagrid({
				rownumbers:true,
				checkOnSelect:false,
				singleSelect:true,
				loadMsg:"正在加载中...",
				columns:[[    
				          {field:'user_id',title:'工号',width:50},    
				          {field:'user_name',title:'姓名',width:100},    
				          {field:'nick_name',title:'江湖外号',width:100},    
				          {field:'sex',title:'性别',width:50},    
				          {field:'birthday',title:'生日',width:100},    
				          {field:'telephone',title:'电话',width:100},    
				          {field:'address',title:'联系地址',width:150}   
				      ]],
				toolbar: '#tbar'
			});	
			
		})
		
		$(function(){
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/user/list.do",
				dataType:"json",
				success : function(data) {
					var jsonUsers = [];
	
					for (var i = 0; i < data.length; i++) {
						var user = {
							'user_id' : data[i].user_id,
							'user_name' : data[i].user_name,
							'nick_name' : data[i].nick_name,
							'sex' : data[i].sex,
							'birthday' : data[i].birthday,
							'telephone' : data[i].telephone,
							'address' : data[i].address
						};
						jsonUsers.push(user);
					}
					$('#personDatagrid').datagrid('loadData', jsonUsers);
				},
				error : function(e) {
					alert(e.message);
				}
			})
		})
		 
	</script>
	
	<table id="personDatagrid" class="easyui-datagrid" style="width:400px;height:250px" data-options="fit:true,fitColumns:true,singleSelect:true"></table>
	<div id="tbar">
		<input class="easyui-searchbox" style="width:180px"  data-options="searcher:search,menu:'#mm'"/>
		<div id="mm" style="width:150px">
			<div data-options="name:'user_id',selected:true">工号</div>
			<div data-options="name:'user_name'">姓名</div>
		</div>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="addUsers_click();">新增</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="editUsers_click();">编辑</a>
		<a class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="deleteUsers_click();">删除</a>
	</div>
	
	<div id="win" class="easyui-window" title="My Dialog" style="width:400px;height:200px;"   
       		data-options="iconCls:'icon-save',resizable:true,modal:true;">   
		<p align="center"><span style="color:red">*</span>为必填项</p>
		<form id="member_form" method="post">   
		   <table border="1">
				<tr >
					<td align="right">工号：</td>
					<td><input id="userid_in" name="user_id" class="easyui-validatebox" data-options="required:true">（<span style="color:red">*</span>）</td>
					<td align="right">姓名：</td>
					<td><input id="username_in" name="user_name" class="easyui-validatebox" data-options="required:true">（<span style="color:red">*</span>）</td>
					<td align="right">江湖外号：</td>
					<td><input id="usernickname_in" name="nick_name" class="easyui-validatebox"></td>
					<td align="right">性别：</td>
					<td>
						<input id="man" name="sex" type="radio" checked="checked" value="男">男
						<input id="woman" name="sex" type="radio" value="女">女
					</td>
					<td align="right">生日：</td>
					<td><input id="birthday" name="birthday" type="text" class="easyui-datebox" required="required">（<span style="color:red">*</span>）</td>
				</tr>
				<tr>
					<td align="right">电话：</td>
					<td><input type="text" name="telephone" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]',invalidMessage:'请输入11位手机号码'">（<span style="color:red">*</span>）</td>
					<td align="right">联系地址：</td>
					<td><textarea name="address" id="address" maxlength="500" cols="27" rows="2"></textarea></td>
				</tr>
			</table>
		</form> 
		<a href="#" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-save'" onClick="winOk_click();">确定</a>
	    <a href="#" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-cancel'" onClick="winCancel_click();">取消</a>
	</div> 
	      
</body>
</html>