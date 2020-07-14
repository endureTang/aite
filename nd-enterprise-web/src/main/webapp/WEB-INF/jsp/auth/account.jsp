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
    <title>完善信息</title>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <link rel="stylesheet" href="static/css/auth/person_info.css" />
    <script type="text/javascript" src="${ctx}/static/js/custom.modernizr.js"></script>
</head>
<body>
    <header>
        <div class="pull-left">
            <img src="static/img/logo_wd.png" alt="">
        </div>
    </header>
    <div class="info-page">
        <div class="info-box">
        	<h2>完善个人信息</h2>
    		<form action="enterprise/addAcct" method="POST">
    			<input type="hidden" name="id" value="${user.id}">
    			<div>
    	            <p>姓名（用户名必填）</p>
    	            <input class="input-name" name="userName" value="${user.userName}" type="text" placeholder="推荐您添加实名">
    	        </div>
    			<div>
    	            <p>备注（选填）</p>
    	            <textarea rows="3" cols="20" class="remarks" type="text" name="remarks" >${user.remarks}</textarea>
    	        </div>
    	        <div class="submit">
                    <button type="submit">确认</button>
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