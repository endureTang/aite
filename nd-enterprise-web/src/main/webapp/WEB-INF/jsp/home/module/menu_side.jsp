<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="static/css/iconfont.css" />
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar" id="scrollspy">
		<ul class="sidebar-menu">
			<!-- Optionally, you can add icons to the links -->
			<c:forEach items="${allMenuList}" var="menu" varStatus="status">
				<li class="treeview">
					<a data-target="navTab" selected-css="true">
					 	<i class="iconfont ${menu.icon}"></i>
						<span>${menu.name}</span>
					</a>
					<ul class="treeview-menu">
						<c:forEach items="${menu.subList}" var="sub">
							<c:choose>
								<c:when test="${not empty sub.href}">
									<li>
										<a href="${ctx}${sub.href}" data-target="navTab" selected-css="true">
											<i class="fa fa-caret-right"></i>
											<span>${sub.name}</span>
										</a>
									</li>
								</c:when>
								<c:otherwise>
									<li>
										<a href="javascript:;" data-target="navTab">
											<i class="fa fa-caret-right"></i>${sub.name}
										</a>
									</li>
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

 