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

    //判断是添加窗体（1）还是编辑窗体（0）
    var flag = -1; 
    
	function addUsers() {
		location.href("${pageContext.request.contextPath}/user/usersToAdd.do");
	}

	function winOk_click(){
		var url_str = "";
		if(flag == 1){
			url_str = "${pageContext.request.contextPath}/user/usersInsert.do";
		}else if(flag == 0){
			url_str = "${pageContext.request.contextPath}/user/usersUpdate.do";
		}
		$('#member_form').form('submit',{
			url: url_str,
			onSubmit: function(){    
				var validate = $(this).form('validate');
				return validate;
			},    
		    success:function(data){    
		        if(data == "success"){
		        	$('#win').window('close');
		        	getAllUsers();		        	
		        } else{
		        	alert(data);
		        }   
		    }
		});	
	}
	
	function winCancel_click(){
		$('#win').window('close');
	}
	
	function addUsers_click(){
		$('#win').window('open');
		$('#win').window('setTitle',"添加成员信息");
		//添加
		flag = 1;
	}

	function editUsers_click(){
		var row = $('#personDatagrid').datagrid('getSelected');
		if(row == null){
			alert("请选择一行编辑");
			return;
		}else{
			var userId = row.user_id;
			//第一次发送ajax会查询后台，不刷新url,传参不变情况下第二次发送不会查询后台
			$.ajax({
				type : "GET",
				url : "${pageContext.request.contextPath}/user/findUsersById.do?time="+new Date().getTime(),
				data:{"value" : userId},
				dataType:"json",
				success : function(data) {
					$('#win').window('open');
					$('#win').window('setTitle',"编辑成员信息");
					document.getElementById("userid_in").value = data.user_id;
					document.getElementById("username_in").value = data.user_name;
					document.getElementById("usernickname_in").value = data.nick_name;
					if(data.sex == "男"){
						document.getElementById("man").checked = true;
					}else if(data.sex == "女"){
						document.getElementById("woman").checked = true;
					}
					$('#birthday_in').datebox('setValue',data.birthday);
					document.getElementById("telephone_in").value = data.telephone;
					document.getElementById("address_in").value = data.address;
					
					
				/* 	$('#userid_in').attr("value", data.user_id);
					$('#username_in').attr("value", data.user_name);
					$('#usernickname_in').attr("value", data.nick_name);
					if(data.sex == "男"){
						document.getElementById("man").checked = true;
					}else if(data.sex == "女"){
						document.getElementById("woman").checked = true;
					}
					$('#birthday_in').datebox('setValue',data.birthday);
					$('#telephone_in').attr("value", data.telephone);
					document.getElementById("address_in").value = data.address; */
					
					//编辑
					flag = 0;
				},
				error : function(e) {
					alert(e.message);
				}
			})
		}
	}
	
	function deleteUsers_click(){
		var row = $('#personDatagrid').datagrid('getSelected');
		if(row == null){
			alert("请选择一行删除");
			return;
		}else{
			var userId = row.user_id;
			
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/user/usersDeleteById.do",
				data:{"user_id":userId},
				dataType:"text",
				success : function(data) {
					if(data == "success"){
						getAllUsers();
					}
				},
				error : function(e) {
					alert(e.message);
				}
			})
		}
	}
	
	function deleteUsersList() {
		var eles = document.getElementsByName("user_ids");
		var user_ids = "";
		for(i = 0; i < eles.length; i++){
			if(eles[i].checked == true){
				user_ids += (eles[i].value + ",");
			}
		}
		if(user_ids == "" || user_ids.length == 0){
			alert("请选择要删除的项！");
			return;
		}else{
			user_ids = user_ids.substring(0, user_ids.length - 1);
		}
		$.ajax({

			type : "POST",
			url : "${pageContext.request.contextPath}/user/usersDeleteByIds.do",
			contentType : "application/json;charset=utf-8",
			data : {
				"user_ids" : user_ids
			},
			dataType : "text",
			success : function(data) {
				if (data == "success") {
					alert("删除成功");
					getAllUsers();
				} else {
					alert("删除失败");
				}
			},
			error : function(e) {
				alert(e.message);
			}

		})
	}	
	
	function search(value, name) {
		
		$.ajax({
			type : 'GET',
			url : '${pageContext.request.contextPath}/user/searchUsers.do',
			data : {
				value : value
			},
			dataType : 'json',
			success : function(data) {
				loadGridData(data);
			},
			error : function(e) {
				alert(e.message);
			}
		})
	}
	
	function getAllUsers() {

		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/user/list.do",
			dataType:"json",
			success : function(data) {
				loadGridData(data);
			},
			error : function(e) {
				alert(e.message);
			}
		})
	}
	
	//装载表格信息数据
	function loadGridData(data) {

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
	
	//清除window面板的信息
	function onBeforeClose(){
		document.getElementById("userid_in").value = "";
		document.getElementById("username_in").value = "";
		document.getElementById("usernickname_in").value = "";
		document.getElementById("man").checked = true;
		//document.getElementById("birthday_in").value = "";
		$('#birthday_in').datebox('setValue', "");
		document.getElementById("telephone_in").value = "";
		document.getElementById("address_in").value = "";
		
		flag = -1;
		return true;
	}
	
</script>

</head>
<body>
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
			getAllUsers();
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

	<div id="win" class="easyui-window" title="My Dialog" style="width:397px;height:482px"   
        data-options="resizable:false,collapsible:false,minimizable:false,maximizable:false,modal:true,closed:true,onBeforeClose:onBeforeClose">   
		<p align="center"><span style="color:red">*</span>为必填项</p>
		<!-- 人员信息表单 -->
		<form id="member_form" method="post">   
		   <table width="100%" cellspacing="13">
				<tr >
					<td align="right">工号：</td>
					<td><input id="userid_in" name="user_id" class="easyui-validatebox" data-options="required:true">（<span style="color:red">*</span>）</td>
				</tr>
				<tr>
					<td align="right">姓名：</td>
					<td><input id="username_in" name="user_name" class="easyui-validatebox" data-options="required:true">（<span style="color:red">*</span>）</td>
				</tr>
				<tr>
					<td align="right">江湖外号：</td>
					<td><input id="usernickname_in" name="nick_name" class="easyui-validatebox"></td>
				</tr>
				<tr>
					<td align="right">性别：</td>
					<td>
						<input id="man" name="sex" type="radio" checked="checked" value="男">男
						<input id="woman" name="sex" type="radio" value="女">女
					</td>
				</tr>
				<tr>
					<td align="right">生日：</td>
					<td><input id="birthday_in" name="birthday" type="text" class="easyui-datebox" required="required">（<span style="color:red">*</span>）</td>
				</tr>
				<tr>
					<td align="right">电话：</td>
					<td><input id="telephone_in" type="text" name="telephone" class="easyui-validatebox" data-options="required:true,validType:'length[11,11]',invalidMessage:'请输入11位手机号码'">（<span style="color:red">*</span>）</td>
				</tr>
				<tr>
					<td align="right">联系地址：</td>
					<td><textarea name="address" id="address_in" maxlength="500" cols="31" rows="4"></textarea></td>
				</tr>
			</table>
		</form> 
		<div id="btn_panel" class="easyui-panel" style="background-color: #F8F8FF">
			<table width="100%" cellpadding="33">
				<tr >
					<td align="center">
						<a href="#" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-save'" onClick="winOk_click();">确定</a>
					</td>
					<td align="center">
					    <a href="#" class="easyui-linkbutton" data-options="plain:false,iconCls:'icon-cancel'" onClick="winCancel_click();">取消</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
   	
</body>
</html>