<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- Content Header (Page header) -->
<!--<section class="content-header">-->
	<!--<cycon:navigater path="role"></cycon:navigater>-->
<!--</section>-->
<!-- Content Header (Page header) -->
<body>
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">系统设置</li>
		<li><a href="/role/page" data-target="navTab">角色管理</a></li>
	</ol>
</section>
<shiro:hasPermission name="file/upload">
	<button type="button" onclick="easyUpload()" id="import"class="btn btn-sm btn-primary">
		<i class="fa fa-fw fa-plus"></i>导入
	</button>
</shiro:hasPermission>

</body>
<script>
	function easyUpload(){
		onloading();
		var input = document.createElement("input");
		input.type = "file";
		input.click();
		input.onchange = function(){
			var file = input.files[0];
			var form = new FormData();
			form.append("file", file); //第一个参数是后台读取的请求key值
			form.append("fileName", file.name);
			form.append("other", "666666"); //实际业务的其他请求参数
			var xhr = new XMLHttpRequest();
			var action = "file/upload"; //上传服务的接口地址
			xhr.open("POST", action);
			xhr.send(form); //发送表单数据
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					var resultObj = JSON.parse(xhr.responseText);
					console.log(resultObj);
					removeload();
				}
			}
		}
	}

	function onloading(){
		$("<div class=\"datagrid-mask\"></div>").css({display:"block",width:"100%",height:$(window).height()}).appendTo("body");
		$("<div class=\"datagrid-mask-msg\"></div>").html("执行中，请稍候。。。").appendTo("body").css({display:"block",left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2});
	}
	function removeload(){
		$(".datagrid-mask").remove();
		$(".datagrid-mask-msg").remove();
	}
</script>



