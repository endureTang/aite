<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
	<title>${title}用户登录</title>
	<%--<link id="favicon" type="image/png" href="${ctx}${logo}"--%>
		  rel="shortcut icon">
	<!-- Bootstrap 3.3.4 -->
	<link href="${ctx}/static/AdminLTE/bootstrap/css/bootstrap.min.css"
		  rel="stylesheet" type="text/css"/>
	<link rel="stylesheet" href="${ctx}/static/css/auth/person_info.css"/>
	<!-- jQuery 2.1.4 -->
	<script src="${ctx}/static/AdminLTE/plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script src="${ctx}/static/js/jquery.cookie.js"></script>
	<script src="${ctx}/static/js/jquery.tips.js"></script>
</head>
<body class="nd-body">
<!--<header class="nd-header">-->
	<!--<div class="pull-left">-->
		<!--<img id="logo" src="${ctx}${logo}" alt="">-->
		<!--<span>${title}后台系统欢迎你</span>-->
	<!--</div>-->
<!--</header>-->
<div class="info-page nd-info-page">
    <div class="title">
        <img src="${ctx}${indexLogo}" alt="">
        <h2>${title}</h2>
        <p>${title}后台系统欢迎你</p>
        <span>Welcome to our system</span>
    </div>
	<div class="info-box nd-info-box">
		<h1>
			用户登录
            <c:if test="${appName != ''}">
                <span id="appDown">APP下载></span>
            </c:if>
		</h1>
		<form role="form" method="post" action="" name="loginForm"
			  id="loginForm">
			<div class="flagBox">
				<!--<i class="desc-name">账号:</i>-->
                <s class="flag-phone"></s>
				<input class="input-name pl40" placeholder="用户名" id="loginName"
					   name="loginName" type="text"/>
			</div>
			<span class="error-msg phoneNum">手机号错误</span>
			<div class="flagBox">
				<!--<i class="desc-name">密码:</i>-->
                <s class="flag-passwd"></s>
				<input class="input-name pl40" placeholder="密码" name="password"
					   id="password" type="password"/>
			</div>
			<span class="error-msg pwd">密码错误</span>
			<div>
				<!--<i class="desc-name msg-code">验证码:</i>-->
				<input class="input-name" placeholder="验证码" type="text" id="code"
					   name="code"> <img id="codeImg" alt="点击更换"
										 title="点击更换" class="custom-input"
										 style="width: 40%;height:45px;vertical-align: top " src="">
			</div>
			<span class="error-msg detectiveCode">验证码错误</span>
			<div class="saveCode">
				<i class="checked" id="saveid"></i>记住密码
			</div>
			<div class="submit">
				<button type="button" onclick="severCheck();">登 录</button>
			</div>
			<p>忘记了密码请联系平台管理员</p>
		</form>

	</div>
</div>
<footer align="center" class="login-footer">
	<p>©2014-2017四川金鼎财富信息技术有限公司版权所有</p>
	<p>备案号：蜀ICP备15004186号-4</p>
</footer>
<!--模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="myModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body text-center">
                <h2>${appName}APP下载</h2>
                <img src="${ctx}${appPic}" alt="">
                <p>扫一扫下载APP</p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- Bootstrap 3.3.2 JS -->
<script src="${ctx}/static/AdminLTE/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
<!--<script>-->
    <!--// 根据url展示logo-->
    <!--var title = $('title'),-->
        <!--favicon = $('#favicon'),-->
        <!--logo = $('#logo');-->
    <!--if(window.location.href.indexOf('admin.52jdjf.com') != -1){ // 微鼎金融-->
        <!--title.text('微鼎金融用户登录');-->
        <!--favicon.attr('href','${ctx}/static/img/great_vision.png');-->
        <!--logo.attr('src','${ctx}/static/img/logo_wd.png');-->
    <!--}else { // 金鼎能贷-->
        <!--title.text('金鼎能贷用户登录');-->
        <!--favicon.attr('href','${ctx}/static/img/jdnd_favicon.ico');-->
        <!--logo.attr('src','${ctx}/static/img/nd_logo_wd.png');-->
    <!--}-->
<!--</script>-->
<script type="text/javascript">
    //服务器校验
    function severCheck() {
        if (check()) {

            var loginName = $("#loginName").val();
            var password = $("#password").val();
            var code = "ksbadmtn1f2izwqy" + loginName + ",00," + password
                + "ipvb5cxat0zn9eg7" + ",00," + $("#code").val();
            $.ajax({
                type: "POST",
                url: '${ctx}/user/login',
                data: {
                    keyData: code,
                    tm: new Date().getTime()
                },
                dataType: 'json',
                cache: false,
                success: function (data) {
                    changeCode();
                    if ("0" == data.status) {
                        //saveCookie();
                        //savePaw();
                        window.location.href = "${ctx}/home";
                    } else {
                        $("#loginName").tips({
                            side: 1,
                            msg: data.msg,
                            bg: '#FF5080',
                            time: 15
                        });
                        //$("#loginName").focus();
                    }
                }
            });
        }
    }

    $(document).ready(function () {
        changeCode();
        $("#codeImg").bind("click", changeCode);
        // 点击app下载
        $('#appDown').click(function () {
            $('#myModal').modal('show');
        })
    });

    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            $("button[type=button]").trigger("click");
        }
    });

    function genTimestamp() {
        var time = new Date();
        return time.getTime();
    }

    function changeCode() {
        $("#codeImg").attr("src", "${ctx}/code?t=" + genTimestamp());
    }

    // 失去焦点验证
    checkBlur("#loginName");
    checkBlur("#password");
    checkBlur("#code");

    function checkBlur(id) {
        $(id).blur(function () {
            if ($(this).val() == "") {
                $(this).parent().next().css('visibility', 'visible');
                /*$(this).focus();*/

            } else {
                $(this).parent().next().css('visibility', 'hidden');
            }
        });
    }

    //客户端校验
    function check() {

        if ($("#loginName").val() == "") {

            $('.phoneNum').css('visibility', 'visible');

            /* $("#loginName").focus(); */
            return false;
        } else {
            $("#loginName").val(jQuery.trim($('#loginName').val()));
        }

        if ($("#password").val() == "") {

            $('.pwd').css('visibility', 'visible');


            /* $("#password").focus(); */
            return false;
        }
        if ($("#code").val() == "") {

            $('.detectiveCode').css('visibility', 'visible');
            /* $("#code").focus(); */
            return false;
        }
        /* $("#loginbox").tips({
            side : 1,
            msg : '正在登录 , 请稍后 ...',
            bg : '#A9A4A4',
            time : 10
        }); */

        return true;
    }

    // 记住密码切换
    $("#saveid").click(function () {
        $(this).toggleClass('checked');
    })

    function savePaw() {
        if (!$("#saveid").hasClass("checked")) {
            $.cookie('loginName', $("#loginName").val(), {
                expires: -1
            });
            $.cookie('password', $("#password").val(), {
                expires: -1
            });
            //$("#loginName").val('');
            //$("#password").val('');
        }
    }

    function saveCookie() {
        if ($("#saveid").hasClass("checked")) {
            $.cookie('loginName', $("#loginName").val(), {
                expires: 7
            });
            $.cookie('password', $("#password").val(), {
                expires: 7
            });
        }
    }


    jQuery(function () {
        var loginName = $.cookie('loginName');
        var password = $.cookie('password');
        if (typeof (loginName) != "undefined"
            && typeof (password) != "undefined") {
            $("#loginName").val(loginName);
            $("#password").val(password);
            $("#saveid").attr("checked", true);
            $("#code").focus();
        }
    });
</script>
<script>
    //TOCMAT重启之后 点击左侧列表跳转登录首页
    if (window != top) {
        top.location.href = location.href;
    }
</script>
</html>