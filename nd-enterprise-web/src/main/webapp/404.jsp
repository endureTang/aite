<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/static/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="${pageContext.request.contextPath}/">
		<meta charset="utf-8" />
		<title></title>
		 
		<meta name="description" content="404 Error Page" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- basic styles -->
		<link href="css/bootstrap.min.css" rel="stylesheet" />
		<link href="css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<!-- page specific plugin styles -->
		<!-- ace styles -->
		<link rel="stylesheet" href="css/ace.min.css" />
		<link rel="stylesheet" href="css/ace-responsive.min.css" />
		<link rel="stylesheet" href="css/ace-skins.min.css" />
		<link rel="stylesheet" href="static/css/error.css"> 
<body>
	<section class="content">
		<div class="error-page">
			<h2 class="headline text-red">
				<img src="static/img/404.png">
			</h2>
			<div class="error-content" style="padding-top: 30px;">
				<h3>
					<i class="fa fa-warning text-red"></i> 对不起! 页面找不到了.
				</h3>
				<p>
					我们会尽快解决这个问题. 请先浏览其它页面, 你可以<a href="" onclick="history.go(-1)">返回</a>
				</p>
			</div>
		</div>
	</section>
	<!-- <div class="navbar navbar-inverse">

	</div>
	<div class="container-fluid" id="main-container">
		<div id="main-content" class="clearfix">
			<div id="page-content" class="clearfix">
				<div class="row-fluid">
					<div class="error-container">
						<div class="well">
							<h1 class="grey lighter smaller">
								<span class="blue bigger-125"><i class="icon-sitemap"></i> 404</span> 没有找到此页面23232323
							</h1>
							<hr />
							<h3 class="lighter smaller">We looked everywhere but we couldn't find it!</h3>
							
							<div>
								
								<div class="space"></div>
								
								<h4 class="smaller">Try one of the following:</h4>
								<ul class="unstyled spaced inline bigger-110">
									<li><i class="icon-hand-right blue"></i> 检查路径是不是有误</li>
									<li><i class="icon-hand-right blue"></i> 检查代码是不是有误</li>
									<li><i class="icon-hand-right blue"></i> 检查环境配置是不是有误</li>
								</ul>
							</div>
							
							<hr />
							<div class="space"></div>
							
							<div class="row-fluid">
								<div id="zhongxin">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> -->

	<script src="1.9.1/jquery.min.js"></script>
	<script type="text/javascript">
		window.jQuery || document.write("<script src='js/jquery-1.9.1.min.js'>\x3C/script>");
	</script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/ace-elements.min.js"></script>
	<script src="js/ace.min.js"></script>
	<script type="text/javascript">
		$(top.hangge());
	</script>
</body>
</html>