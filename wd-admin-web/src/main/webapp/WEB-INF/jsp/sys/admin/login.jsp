<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <link type="image/png" href="${ctx}/static/img/great_vision.png" rel="shortcut icon">
    <title>管理后台登录</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="${ctx}/static/css/adjust.css" rel="stylesheet"
          type="text/css">
    <!-- Bootstrap 3.3.4 -->
    <link href="${ctx}/static/AdminLTE/bootstrap/css/bootstrap.min.css"
          rel="stylesheet" type="text/css"/>
    <!--自定义css-->
    <link href="${ctx}/static/css/login.css" rel="stylesheet"
          type="text/css">
    <!-- jQuery 2.1.4 -->
    <script src="${ctx}/static/AdminLTE/plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <script src="${ctx}/static/js/jquery.cookie.js"></script>
    <script src="${ctx}/static/js/jquery.tips.js"></script>
</head>
<body id="loginBody" style="background-color: #EDEFF5;">
<div class="container" id="loginContainer">
    <div class="row">
        <div class="col-md-4 col-lg-4 col-sm-1 col-xs-0">
        </div>
        <div class="col-md-4 col-lg-4 col-sm-10 col-xs-12">
            <div id="testmsg" class="login-panel panel panel-default">
                <%--
                <div class="panel-heading" id="test1">
                    <h3 class="panel-title">
                        <fmt:message key="sys.user.plogin"/>
                    </h3>
                </div>
                --%>

                <div style="margin-top:-15%" class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                    <div class="col-md-2 col-lg-2 col-sm-4 col-xs-3"></div>
                    <img class="col-md-8 col-lg-8 col-sm-4 col-xs-6" src="${ctx}/static/img/logo.jpg" alt=""/>
                </div>
                <h2 style="text-align:center">用户登录</h2>
                <div class="panel-body" id="loginbox">
                    <form role="form" method="post" action="" name="loginForm"
                          id="loginForm">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control custom-input" placeholder="用户名" id="loginName"
                                       name="loginName" type="text"/>

                            </div>
                            <div class="form-group">
                                <input class="form-control custom-input" placeholder="密码" name="password"
                                       id="password" type="password"/>

                            </div>
                            <div class="form-group">
                                <input class="form-control custom-input" placeholder="验证码" type="text"
                                       id="code" name="code" style="width: 50%; float: left;">
                                <img id="codeImg" alt="点击更换" title="点击更换" class="custom-input"
                                     style="width: 40%; margin-left: 12px;" src="">
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <button id="login" type="button" onclick="severCheck();"
                                            class="btn btn-block btn-flat custom-input custom-btn-color">登 录
                                    </button>
                                </div>
                                <!-- /.col -->
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap 3.3.2 JS -->
<script src="${ctx}/static/AdminLTE/bootstrap/js/bootstrap.min.js"
        type="text/javascript"></script>
</body>
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
                url: 'auth',
                data: {
                    keyData: code,
                    tm: new Date().getTime()
                },
                dataType: 'json',
                cache: false,
                success: function (data) {
                    console.log(data);
                    changeCode();
                    if ("success" == data.result) {
                        saveCookie();
                        window.location.href = "sys/index";
                    } else if ("usererror" == data.result) {
                        $("#loginName").tips({
                            side: 1,
                            msg: "用户名或密码有误",
                            bg: '#FF5080',
                            time: 15
                        });
                        $("#loginName").focus();
                    } else if ("codeerror" == data.result) {
                        $("#code").tips({
                            side: 1,
                            msg: "验证码输入有误",
                            bg: '#FF5080',
                            time: 15
                        });
                        changeCode();
                        $("#code").focus();
                    } else if ("passworderror" == data.result){
                    	
                        $("#password").tips({
                            side: 1,
                            msg: "密码必须为8到16位的数字字母组成",
                            bg: '#FF5080',
                            time: 15
                        });
                        
                        $("#password").focus();
                    }else {
                        $("#loginName").tips({
                            side: 1,
                            msg: "缺少参数",
                            bg: '#FF5080',
                            time: 15
                        });
                        $("#loginName").focus();
                    }
                }
            });
        }
    }

    $(document).ready(function () {
        changeCode();
        $("#codeImg").bind("click", changeCode);
    });

    $(document).keyup(function (event) {
        if (event.keyCode == 13) {
            $("#login").trigger("click");
        }
    });

    function genTimestamp() {
        var time = new Date();
        return time.getTime();
    }

    function changeCode() {
        $("#codeImg").attr("src", "code?t=" + genTimestamp());
    }

    //客户端校验
    function check() {

        if ($("#loginName").val() == "") {

            $("#loginName").tips({
                side: 2,
                msg: '用户名不得为空',
                bg: '#AE81FF',
                time: 3
            });

            $("#loginName").focus();
            return false;
        } else {
            $("#loginName").val(jQuery.trim($('#loginName').val()));
        }

        if ($("#password").val() == "") {

            $("#password").tips({
                side: 2,
                msg: '密码不得为空',
                bg: '#AE81FF',
                time: 3
            });

            $("#password").focus();
            return false;
        }
        if ($("#code").val() == "") {

            $("#code").tips({
                side: 1,
                msg: '验证码不得为空',
                bg: '#AE81FF',
                time: 3
            });

            $("#code").focus();
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

    function savePaw() {
        if (!$("#saveid").attr("checked")) {
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
        if ($("#saveid").attr("checked")) {
            $.cookie('loginName', $("#loginName").val(), {
                expires: 7
            });
            $.cookie('password', $("#password").val(), {
                expires: 7
            });
        }
    }

    function quxiao() {
        $("#loginName").val('');
        $("#password").val('');
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