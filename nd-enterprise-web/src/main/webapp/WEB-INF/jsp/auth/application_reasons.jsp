<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html style="background: #f5f6f8">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <title>申请理由</title>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <link rel="stylesheet" href="../static/css/auth/header.css">
    <link rel="stylesheet" href="../static/css/auth/join.css">
    <script type="text/javascript" src="${ctx}/static/js/custom.modernizr.js"></script>
</head>
<body style="background: #f5f6f8">
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

    <div class="join-page">
        <div class="join-box reason">
            <h2>申请理由</h2>
            <p>向公司管理员说明真实情况，获取通过机会。</p>
            <form action="<%=basePath%>apply/applyResult" method="post">
            	<input name ="coporateId" type = "hidden" value="${coporateId}">
                <fieldset>
                    <textarea class="remarks" name="applyReason" cols="80" rows="10"></textarea>
                </fieldset>
                <fieldset>
                    <div class="btns">
                        <div class="submit">
                            <button type="submit">提交</button>
                        </div>
                        <div class="return">
                            <button type="button" onclick="history.go(-1)">返回</button>
                        </div>
                    </div>    
                </fieldset>
            </form>
        </div>
    </div>

    <footer>
        <p>©2014-2017四川金融财富信息技术有限公司版权所有</p>
        <p>备案号：蜀ICP备15004186号-4</p>
    </footer>
</body>
</html>