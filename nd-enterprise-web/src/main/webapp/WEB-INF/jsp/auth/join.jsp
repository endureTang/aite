<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>加入公司</title>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <link rel="stylesheet" href="${ctx}/static/css/auth/header.css">
    <link rel="stylesheet" href="${ctx}/static/css/auth/join.css">
    <script type="text/javascript" src="${ctx}/static/js/custom.modernizr.js"></script>
</head>
<body>
    <header>
         <div class="pull-left">
            <img src="${ctx}/static/img/logo_wd.png" alt="">
        </div>
        <div class="header-right">
        	<div class="header-right-txt"><i class="txt-color">您好！</i><i>${sessionScope.userName}</i></div>
        	<div class="pull-right">
				<a href="<%=basePath%>logout" class="btn btn-default btn-flat">退出</a>
			</div>
        </div>
    </header>

    <div class="join-page">
    	<div class="join-box">
	        <h2>加入公司</h2>
	        <p>我还没有加入公司，但我可以选择一个加入！</p>
			<form action="<%=basePath%>coporate/getCoporateList" method="POST">
		        <div class="search">
		            <input class="input-company-name" type="text" name="companName" placeholder="输入公司关键字查询">
		            <button class="search-btn">搜索</button>
		        </div>
			</form>
		</div>	
			<form action="<%=basePath%>join" method="POST">
		        <div class="search-box">
		            
		            <c:if test="${fn:length(companyList) != 0}">
		            	<p class="search-txt">搜索结果, 总共查询到  ${fn:length(companyList)} 条结果</p>
			            	<!-- <c:if test="${company.label == '审核中'}">
			            		<div  class="entrance selected search-result">
						        	<span class="company-name">${company.companName}</span>
				                	<a class="join-btn" >审核中</a>
						       	</div>
			            	</c:if>
			            	<c:if test="${company.label == '进入'}">
			            		<div  class="entrance selected search-result">
						        	<span class="company-name">${company.companName}</span>
				                	<a class="join-btn" href="<%=basePath%>home?coporateId=${company.id}">进入</a>
						       	</div>
			            	</c:if>
			            	<c:if test="${company.label == '加入'}">
			            		<div  class="entrance selected search-result">
						        	<span class="company-name">${company.companName}</span>
				                	<a class="join-btn" href="<%=basePath%>enterprise/join?coporateId=${company.id}">加入</a>
						       	</div>
			            	</c:if> -->
							<div class="table-box">
							<table class="">
								<thead>
									<tr>
										<th width="80%">公司名称</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${companyList}" var="company">  
									<c:if test="${company.label == '审核中'}">
										<tr>
											<td>${company.companName}</td>
											<td>
												<a class="join-btn">审核中</a>
											</td>
										</tr>
									</c:if>
									<c:if test="${company.label == '进入'}">
										<tr>
											<td>${company.companName}</td>
											<td>
												<a class="join-btn" href="<%=basePath%>home?coporateId=${company.id}">进入</a>
											</td>
										</tr>
									</c:if>
									<c:if test="${company.label == '加入'}">
										<tr>
											<td>${company.companName}</td>
											<td>
												<a class="btn-danger" href="<%=basePath%>enterprise/join?coporateId=${company.id}">申请加入</a> 
											</td>
										</tr>
									</c:if>
									</c:forEach>
								</tbody>
							</table>
							</div>
			    	</c:if> 
			    	<c:if test="${fn:length(companyList) == 0}">
						<div class="search-img"><img src="../static/img/search.png"></div>
						<p class="search-txt">暂无搜索结果</p>
			    	</c:if>
		            <div class="return join-return">
		                <button type="button" onclick="history.go(-1)">返回</button>
		            </div>
		        </div>
		    </form>
		</div>     
    </div>

    <footer>
	    <p>©2014-2017四川金融财富信息技术有限公司版权所有</p>
		<p>备案号：蜀ICP备15004186号-4</p>
    </footer>
</body>
</html>