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
		<c:forEach items="${menuList}" var="menu" varStatus="status">
			<li class="treeview"><a href="javascript:;"><i class="fa fa-th-list" style="font-size :16px;"></i> <span>${menu.name}</span><i class="fa fa-angle-left pull-right"></i></a>
				<ul class="treeview-menu" style="display: block;">
					<c:forEach items="${menu.subList}" var="sub">
						<c:choose>
							<c:when test="${not empty sub.href}">
								<li><a href="${ctx}${sub.href}" data-target="navTab" selected-css="true"><i class="fa fa-caret-right"></i>${sub.name}</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="javascript:;" data-target="navTab"><i class="fa fa-caret-right"></i>${sub.name}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			
			</li>
		</c:forEach>
		</ul>
		<!-- /.sidebar-menu -->
	</section>
	<!-- /.sidebar -->
</aside>
