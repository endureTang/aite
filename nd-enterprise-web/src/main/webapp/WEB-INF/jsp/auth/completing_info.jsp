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
    <title>Title</title>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <link rel="stylesheet" href="../static/css/welcome.css">
    <script type="text/javascript" src="${ctx}/static/js/custom.modernizr.js"></script>
</head>
<body>
<div class="main">
    <div class="header">
        <img src="../static/images/icon_logo.png" alt="">
        <span>微贷管理系统</span>
    </div>

    <div class="content">
        <h4 class="bold">创建个人信息</h4>
        <form action="">
            <p class="none">用户名(必填)</p>
            <input type="text" placeholder="推荐您添加实姓名" required="required">
            <p class="none">备注(选填)</p>
            <textarea name="" id=""></textarea>
            <button type="submit" class="btn">确认</button>
        </form>
    </div>

    <div class="footer">
        <p>©2014-2017四川金融财富信息技术有限公司版权所有</p>
        <p>备案号：蜀ICP备15004186号-4</p>
    </div>
</div>
</body>
</html>