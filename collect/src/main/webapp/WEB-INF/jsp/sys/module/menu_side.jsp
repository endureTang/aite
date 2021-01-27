<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar" id="scrollspy">
		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<!--<li class="header">功能导航</li>-->
			<!-- Optionally, you can add icons to the links -->
			<li><a href="${ctx}/stockCollect/goEventUpload" data-target="navTab" selected-css="true"><i class="fa fa-caret-right"></i>活动库存上传</a></li>
			<li><a href="${ctx}/stockCollect/goCollect" data-target="navTab" selected-css="true"><i class="fa fa-caret-right"></i>库存汇总</a></li>
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>
