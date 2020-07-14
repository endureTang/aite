<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <title>进入公司</title>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <link rel="stylesheet" href="../static/css/auth/header.css">
    <link rel="stylesheet" href="../static/css/welcome.css">
    <script type="text/javascript" src="${ctx}/static/js/custom.modernizr.js"></script>
</head>
<body>
    <header>
         <div class="pull-left">
            <img src="../static/img/logo_wd.png" alt="">
        </div>
        <div class="header-right">
            <div class="header-right-txt"><i class="txt-color">您好！</i><i>${sessionScope.userName}</i></div>
            <div class="pull-right">
                <a href="<%=basePath%>logout" class="btn btn-default btn-flat">退出</a>
            </div>
        </div>
    </header>
    <div class="main">
        <div class="content">
        	<c:if test="${isAdmin}">
            <div>
                <a href="toCreate" class="entrance">
                    <h4>创建公司</h4>
                    <p class="none">创建属于自己的公司，开始吧！</p>
                </a>
            </div>
            </c:if>
            <div>
                <a href="toJoin" class="entrance">
                    <h4>加入公司</h4>
                    <p class="none">我还没有加入公司，但我可以选择一个加入！</p>
                </a>
            </div>
        </div>
        <div class="footer">
            <p>©2014-2017四川金融财富信息技术有限公司版权所有</p>
            <p>备案号：蜀ICP备15004186号-4</p>
        </div>
    </div>
</body>
</html>