<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
    <title>设置公司</title>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <link rel="stylesheet" href="static/css/auth/header.css">
    <link rel="stylesheet" href="static/css/auth/set_company.css">
    <link rel="stylesheet" href="static/css/iconfont.css">
    <script src="${ctx}/static/js/jQuery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/custom.modernizr.js"></script>
</head>
<body>
	<header>
        <div class="pull-left">
            <img src="static/img/logo_wd.png" alt="">
        </div>
        <div class="header-right">
        	<div class="header-right-txt">
	        	<a href="enterprise/toEntrance" class="txt-color txt-hover"><i class="iconfont icon-establish"></i>创建或加入公司</a>
	        	<i class="txt-color">您好！</i>
	        	<i>${sessionScope.userName}</i>
        	</div>
        	<div class="pull-right">
				<a href="<%=basePath%>logout" class="btn btn-default btn-flat">退出</a>
			</div>
        </div>
    </header>
    <div class="creat-page">
		<ul class="info-box">
			<c:forEach items="${companys}" var="company"> 
				<!-- <p>您已加入${fn:length(companys)}家公司</p> -->
	    		<li class="set-box" <c:if test="${company.stateLabel eq '审核通过'}">onclick = "gotoCompany('${company.coporateId}');"</c:if>> 
	        		<div  class="entrance selected set-txt">
		        		<input type = "hidden" value = "${company.coporateId}">
		       			<h2 class="title"><c:out value="${company.companName}"></c:out></h2>
		       			<%-- <p><fmt:formatDate value="${company.applyDate}" type="both" pattern="yyyy-MM-dd HH:mm:ss"/> 加入公司</p>   --%>
		       			<p>${company.relation}</p>
		       			<p><c:if test="${company.stateLabel == '待审核'}"> 待审核 </c:if></p>
	       			</div>
	       			<!-- <div class="create-mark">我创建的</div> -->
	       		</li>
       		</c:forEach> 
	    </ul> 
	    <footer>
		    <p>©2014-2017四川金融财富信息技术有限公司版权所有</p>
			<p>备案号：蜀ICP备15004186号-4</p>
	    </footer>  		
    </div>
</body>
<script type="text/javascript">
	//样式
	$(function(){
		$('.set-box').hover(function() {
			$(this).css({
				'background-color':'#ff5e16',
				'color':'#fff',
				'cursor':'pointer'
			});
		},function(){
			$(this).css('background-color','#D2D2DA').css('color','#7a7b8d');
		});
	});

	function gotoCompany(coporateId){
		//获取选中的公司
		
		//获取当前选中的公司信息
		var selectedDiv = $("div.selected");
		var url = "user/deftCompany";
		var userId,coporateId;
		var checked = 0;
		if($('#isDefaultLogin').is(':checked')) {
		    checked = 1;
		}
		
		var postData = {"coporateId":coporateId,"isDefaultLogin":checked};
		
		$.post(url,postData,function(data){
			if(data.status == 1){
				window.location.href = "home?coporateId=" + coporateId;
			}else{
				alert(data.msg);
			}
		});
	}

</script>
</html>