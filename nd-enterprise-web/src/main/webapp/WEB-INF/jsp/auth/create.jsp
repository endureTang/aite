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
    <title>创建公司</title>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <link rel="stylesheet" href="${ctx}/static/css/auth/header.css">
    <link rel="stylesheet" href="${ctx}/static/css/auth/create.css">
    <script type="text/javascript" src="${ctx}/static/js/jQuery-1.9.1.min.js"></script>
    <script type="text/javascript" src="${ctx}/static/js/jquery.cityselect.js"></script>
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

    <section class="creat-page">
    <c:choose>
    	<c:when test="${isJoin == 1}">
	    	<div class="center-box" id="bind-company">
		        <div class="center-txt">
		        	<h2>创建成功</h2>
		       		<p>请绑定天府财富企业账号，完成创建</p>
		        </div>
		        <div class="form-box">
		        	<div>${error}</div>
			        <form action="<%=basePath%>enterprise/bind" method="POST" name="addFormBind">
			            <fieldset>
			                <legend>天府财富企业账号<i class="mast-select">(必填)</i></legend>
			                <input class="input-company-name" name="username" id="username" type="text" onkeypress="pointBind()" onmousemove="pointBind()">
			                <input name="coporateId" id="coporateId" type="hidden" value="${coporateID}">
			                
			                <legend class="input-point bind-user-point"></legend>
			            </fieldset>
			            <fieldset>
			                <legend>验证码<i class="mast-select">(必填)</i></legend>
			                <div class="yzm-box">
								<input class="input-company-yzm" name="code" id="code" type="text" onkeypress="pointBind()" onmousemove="pointBind()">
								<input class="input-yzm" onclick="getSmsCode();" type="button" name="" value="获取验证码">
			                </div>
			                <legend class="yzm-desc">请输入您在天府财富注册时使用的手机号接收到的验证码</legend>
			                <legend class="input-point bind-point"></legend>
			            </fieldset>
			            <div class="create-btns last-btn">
							<div class="submit sub-btns-width">
				                <button type="button" onclick="SendFormBind()" >绑定财富账号</button>
				            </div>
			                <div class="return ret-btns-width">
				                <a href="https://www.52tfd.com/site/registerCompany.html" class="ret-btns-width" target="_blank">没有财富账号，立即注册</a>
				            </div>
			            </div>
			        </form>
		        </div>
	    	</div>
	    </c:when>
	  	<c:otherwise>
	  		<div class="center-box" id="create-company">
		        <div class="center-txt">
		        	<h2>创建公司</h2>
		       		<p>创建一个属于自己的公司吧</p>
		        </div>
		        <div class="form-box">
			        <form action="<%=basePath%>enterprise/create"  method="POST" name="addForm">
			            <fieldset>
			                <legend>公司名称<i class="mast-select">(必填)</i></legend>
			                <input class="input-company-name" name="companName" type="text" onkeypress="pointCreat()" onmousemove="pointCreat()">
			                <legend class="input-point compan-name">公司名称不能为空</legend>
			                <legend class="input-point compan-name-exist"></legend>
			            </fieldset>
			            <fieldset>
			                <legend>公司地址</legend>
							<div id="city">
						  		<select class="prov"></select> 
						    	<select class="city" disabled="disabled"></select>
						        <select class="dist last" disabled="disabled"></select>
						    </div>
			            </fieldset>
			            <fieldset>
			           		<input class="input-address" type="text" name="address" placeholder="详细地址（例如：天府大道888号XX大厦）">
			           	</fieldset>	
			            <div class="create-btns">
							<div class="submit">
				                <button type="button" onclick="SendFormCreate();">创建</button>
				            </div>
			                <div class="return">
				                <button type="button" onclick="history.go(-1)">返回</button>
				            </div>
			            </div>
			        </form>
		        </div>
	    	</div>
    	</c:otherwise>
    </c:choose>
    </section> 
	
    <footer>
	    <p>©2014-2017四川金融财富信息技术有限公司版权所有</p>
		<p>备案号：蜀ICP备15004186号-4</p>
    </footer>

    <!--提示框-->
	<div class="faid-box">
		<div class="fdid-txt">
			<span class="point-msg">获取验证码成功</span>
		</div>
	</div>
</body>
<script type="text/javascript">
	//省市县下拉选择
	$("#city").citySelect({  
	    url:"${ctx}/static/js/city.min.js",  
	    prov:"四川", //省份 
	    city:"成都", //城市 
	    dist:"锦江区", //区县 
	    nodata:"none" //当子集无数据时，隐藏select 
	});  
	//创建公司验证
	function pointCreat(){
		if($('.input-company-name').val() != ''){
			$('.input-point').hide();
		}
	}

	function SendFormCreate () {
		if(CheckPostCreate()) {
			var companyName = $('.input-company-name').val();
			$.ajax({
				url : "<%=basePath%>enterprise/validate",
	   			data : "companyName="+companyName,
	   			dataType : 'json',
	   		 	async : false,  
	   			type: 'POST',
	   			success : function(data) {
	   				if(data.status != 0){
						$('.compan-name-exist').text(data.errorMsg);
						$('.compan-name-exist').show();
	   				}else{
	   					document.addForm.submit();			
	   				}
	   			}
			});
		}
	}

	function CheckPostCreate () {
		if($('.input-company-name').val() == ''){
			$('.compan-name').show();
			$('.input-company-name').focus();
			return false;
		}
		return true;
	}

	//绑定财富账号验证
	function pointBind(){
		if($('#username').val() != ''){
			$('.bind-user-point').hide();
		}
		if($('input-company-yzm').val() != ''){
			$('.bind-point').hide();
			$('.yzm-box').removeClass('error');
		}
	}

	function SendFormBind(){
		if($('#username').val() == ''){
			$('.bind-user-point').show();
			$('.bind-user-point').text('天府财富企业账号不能为空');
			$('#username').focus();
			return false;
		}
		if($('.input-company-yzm').val() == ''){
			$('.bind-point').show();
			$('.bind-point').text('验证码不能为空');
			$('.input-company-yzm').focus();
			return false;
		}

		if(mark == false){
			$('.bind-point').show();
			$('.bind-point').text('您还没有获取验证码');
			return false;
		}

		var username = $("#username").val();
		var code = $("#code").val();
		var coporateId = $("#coporateId").val();
		

		$.ajax({
   			url : "<%=basePath%>enterprise/bind",
   			data : "username="+username+"&code="+code+"&coporateId="+coporateId,
   			dataType : 'json',
   			type: 'POST',
   			success : function(data) {
   				if(data.status == 1){
   					faidInBox();
					$('.point-msg').text("公司创建成功");
   					window.location.href='<%=basePath%>home';
   				} else {
   					//绑定失败提示
					$('.bind-point').show();
					$('.bind-point').text('验证码错误');
					$('.yzm-box').addClass('error');
					$('.input-company-yzm').focus();
				}	
   			}
   		});
	}

	//弹出提示框
	$('.icon-save-f').hide();
	function faidInBox(){
		$('.faid-box').fadeIn(300).delay(2000).fadeOut(300);
	}	

	//获取验证码
	var mark = false;
	function getSmsCode(){
		mark = true;
		//ajax请求
		var url = "<%=basePath%>company/getOpenSmsCode";
    	 $.ajax({
   			url : url,
   			data : "username=" + $("#username").val(),
   			dataType : 'json',
   			type: 'POST',
   			success : function(data) {
   				if(data.status == 1){
   					//获取成功提示
					faidInBox();
					$('.point-msg').text("获取验证码成功");
   					// alert(JSON.stringify(data));
   				} else {
   					//获取成功提示
					faidInBox();
					$('.point-msg').text("获取验证码失败");
				}	
   			}
   		});
	}
</script>

</html>