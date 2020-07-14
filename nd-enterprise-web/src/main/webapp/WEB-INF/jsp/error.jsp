<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- Content Header (Page header) -->
<link rel="stylesheet" href="<%=basePath%>static/css/error.css">
<section class="content-header">
<!-- 	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">500 错误</li>
	</ol> -->
</section>
<!-- Main content -->
<section class="content">
	<div class="error-page">
		<h2 class="headline text-red">
			<img src="<%=basePath%>static/img/500.png">
		</h2>
		<div class="error-content" style="padding-top: 30px;">
			<h3>
				<i class="fa fa-warning text-red"></i> 对不起! 你没有访问权限.
			</h3>
			<p>
				请和管理员联系. 请先浏览其它页面, 你可以<a href='' onclick="history.go(-1)">返回</a>
			</p>
		</div>
	</div>
</section>
