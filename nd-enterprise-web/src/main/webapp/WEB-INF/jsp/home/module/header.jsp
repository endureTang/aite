<%@ page language="java"  import="java.util.Map" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="static/css/module.css" />	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- Main Header -->
<%
   Map user = (Map)session.getAttribute("userCoporate");
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<style>
    .main-header .logo{width: 210px;height:63px;text-align: left;padding: 0;background-color:#008bff!important;
        padding-left: 20px;
    }
    .main-header .logo img {
        width: 40px;
        /*margin-right: 5px;*/
        margin-top: -2px;
    }
    .skin-blue .main-header .logo:hover{background-color:#008bff!important; }
</style>
<header class="main-header">
	<!-- Logo -->
	<div class="logo">
        <img src="${ctx}${indexLogo}" alt="">
        <span>${title}后台</span>
	</div>

	<!-- Header Navbar -->
	<nav class="navbar navbar-static-top" role="navigation">
		<!-- Sidebar toggle button-->
		<%-- <div href="javascript:;" class="name-hover" role="button">
			<span class="logo-lg">
				<b>${companName}</b>
				<i class="iconfont icon-pull-down pull-right icons"></i> 
			</span>
			<ul class="select-list">
				<c:forEach items="${companys}" var="company">
					<li><a href="home?coporateId=${company.coporateId}">${company.companName}</a></li>
				</c:forEach>
			</ul>
		</div> --%>
		

		<!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				<!-- <li>
					<a href="coporate/getMyCoporates" data-target="navTab" selected-css="true">
						<i class="iconfont icon-company-select"></i>我的公司
					</a>
				</li> -->
				<li>
					<a href="welcomePage?welcome=${welcome }&title=${title}" id="index-btn" data-target="navTab" selected-css="true">
						<i class="iconfont icon-home"></i>首页
					</a>
				</li>
				<li id="modifyPasswd" style="position: relative;">
					<a href="javascript:;" selected-css="true">
						<i class="icon-password"></i>修改密码
					</a>
				</li>
				<li>　<span style="float: left;">您好 !</span>
					<a href="javascript:;" data-target="navTab" class="username-link" selected-css="true">
						<i class="fa logo-lg-r"><%=user.get("userName") %></i>
					</a>
				</li>
				<li class="user-footer">
					<div class="pull-right">
						<a href="javascript:void(0)" onclick ="logout()" class="btn btn-default btn-flat btn-out">退出</a>
					</div>
				</li>
			</ul>
		</div>
	</nav>
</header>
<jsp:include page="./password-modal.jsp"></jsp:include>