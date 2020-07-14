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
    <title>首次进入公司</title>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <link rel="stylesheet" href="${ctx}/static/css/auth/header.css">
    <link rel="stylesheet" href="${ctx}/static/css/auth/first_join.css">
    <link rel="stylesheet" href="${ctx}/static/css/iconfont.css">
    <script src="${ctx}/static/js/jQuery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/custom.modernizr.js"></script>
</head>
<body>
    <header>
         <div class="pull-left">
            <img src="${ctx}/static/img/logo_wd.png" alt="">
        </div>
        <div class="header-right">
        	<ul>
        		<li>
        			<a href="javascript:void(0)" data-target="navTab" class="menu">
						<i class="iconfont icon-user"></i>
						<span>个人中心</span>
					</a>
					<a href="javascript:void(0)" data-target="navTab" class="menu menu-active">
						<i class="iconfont icon-home"></i>
						<span>首页</span>
					</a>
				</li>
        	</ul>
        	<div class="header-right-txt"><i class="txt-color">您好！</i><i>${sessionScope.userName}</i></div>
        	<div class="pull-right">
				<a href="<%=basePath%>logout" class="btn btn-default btn-flat">退出</a>
			</div>
        </div>
    </header>

    <section class="content">
	  	<div class="index-pic">
	  		<img alt="" src="${ctx}/static/img/index_defa.png">
	  		<p>申请中：四川金鼎财富有限公司</p>
	  		<div class="btns">
				<button>加入公司</button>
				<button>创建公司</button>
	  		</div>
	  	</div>
    </section>

    <footer>
	    <p>©2014-2017四川金融财富信息技术有限公司版权所有</p>
		<p>备案号：蜀ICP备15004186号-4</p>
    </footer>
</body>
<script type="text/javascript">
	$('.menu').click(function(){
		$(this).addClass('menu-active').siblings().removeClass('menu-active');
	})
</script>
</html>