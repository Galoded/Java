<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>首页</title>
	
	<!-- 引入外部CSS文件 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/icon.css" type="text/css"></link>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/themes/default/easyui.css" type="text/css"></link>
	
	<!-- 引入外部JS文件 -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>

</head>
<body class="easyui-layout">
	  
	    <div data-options="region:'north',split:false" style="height:50px;"></div>  
	     
	    <div data-options="region:'south',split:false" style="height:50px;"></div>  
	     
	    <div data-options="region:'west',title:'所有菜单',split:true" style="width:200px;">
	    	<div id="accordion" class="easyui-accordion" style="width:200px;height:200px;" data-options="fit:true,selected:false">   
			    <div title="机构人员" style="overflow:auto;padding:10px;"> 
			    	<ul id="personTree" class="easyui-tree" data-options="iconCls:'icon-blank'">	
			    	</ul>  
			    </div>   
			    <div title="机构产品" style="padding:10px;">   
			    </div>   
			    <div title="机构事迹">   
			    </div>   
			    <div title="机构简介">   
			    </div>   
			</div>  	    
	    </div>
	       
	    <div data-options="region:'center'," style="padding:5px;background:#eee;">
			<div id="centerTabs" class="easyui-tabs" style="width: 500px; height: 250px;" data-options="fit:true,border:false,plain:true">
			</div>
		</div>   

	<script type="text/javascript">
		$(function(){
			$("#personTree").tree({
				//数据源
				data:[
				      {
				    	"id": "acctradeNode",    
				    	"text": "账户交易组",    
				      	"state": "closed"
				      },
				      {
				    	"id": "clearNode",    
				    	"text": "日终交易组",    
				      	"state": "closed",
				      	"children":[{   
				      		"id": "clearNode",
				            "text":"日终交易",    
					      	"state": "closed"
				        }]   
				      }]
			});
		})
		
		$(function(){
			$("#personTree").tree({
				onClick:function(node){
					var title = node.text;
					var flag = $("#centerTabs").tabs("exists",title);
					if(!flag){
				    	$("#centerTabs").tabs('add',{
				    		id:title,
				    	    title:title,  
				    	    closable:true,
				    	    href:"${pageContext.request.contextPath}/user/user.do"
				    	});
					}
				}
			});
		})
	
	</script>
</body>
</html>