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
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
<link type="image/png" href="${ctx}${logo}" rel="shortcut icon">
<script type="text/javascript" src="https://api.map.baidu.com/api?v=2.0&ak=fhvGGMZaSVhEwmvIAaPkQ6Y1RW5Czpx1&s=1"></script>
<script type="text/javascript" src="https://developer.baidu.com/map/jsdemo/data/points-sample-data.js"></script>
<!-- 兼容ie8及以下h5标签 -->
<script type="text/javascript" src="${ctx}/static/js/custom.modernizr.js"></script>
<title>${title}后台</title>
<meta
	content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no'
	name='viewport'>
<!-- Bootstrap 3.3.4 -->
<link href="${ctx}/static/AdminLTE/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${ctx}/static/AdminLTE/plugins/bootstrapDialog/bootstrap-dialog.min.css"
	rel="stylesheet" type="text/css" />
<link
	href="${ctx}/static/AdminLTE/plugins/datetimepicker/bootstrap-datetimepicker.min.css"
	rel="stylesheet" type="text/css">
<link
	href="${ctx}/static/AdminLTE/plugins/datatables/dataTables.bootstrap.css"
	rel="stylesheet" type="text/css">
	<!-- treeview -->
	<link rel="stylesheet" href="${ctx}/static/plugins/treeview/bootstrap-treeview.min.css">
<!-- Font Awesome Icons -->
<link href="${ctx}/static/AdminLTE/dist/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<!-- Pikaday.css -->
<link href="${ctx}/static/plugins/pikaday/pikaday.css" rel="stylesheet" type="text/css">
<%-- <!-- Ionicons -->
<link
	href="${ctx}/static/AdminLTE/dist/css/ionicons.min.css"
	rel="stylesheet" type="text/css" /> --%>
<!-- Theme style -->
<link href="${ctx}/static/AdminLTE/dist/css/AdminLTE.min.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/static/AdminLTE/dist/css/skins/skin-blue.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/static/AdminLTE/plugins/iCheck/flat/blue.css"
	rel="stylesheet" type="text/css">
<link href="${ctx}/static/AdminLTE/plugins/iCheck/minimal/blue.css"
	rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="${ctx}/static/AdminLTE/plugins/iCheck/square/blue.css">
<link href="${ctx}/static/css/adjust.css" rel="stylesheet"
	type="text/css">
<%-- <link href="${ctx}/static/css/style.css" rel="stylesheet"
	type="text/css"> --%>

	
	<!-- jQuery 2.1.4 -->
	<script src="${ctx}/static/js/jQuery-1.9.1.min.js"></script>
	<script src="${ctx}/static/AdminLTE/plugins/jQuery/jQuery-2.1.4.min.js"></script>

		<script type="text/javascript">
		// 让出jQuery-1.11.1对变量$和变量jQuery的控制权 这个时候 $j  代表jquery-1.11.1.js 而$则是1.4.2
		var $j = jQuery.noConflict( true );	
	</script>
	<script type="text/javascript" src="${ctx}/static/js/jquery.range.js"></script>
		<!-- Bootstrap 3.3.2 JS -->
	<script src="${ctx}/static/AdminLTE/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<!-- AdminLTE App -->
	<script src="${ctx}/static/AdminLTE/dist/js/app.js"
		type="text/javascript"></script>
	<!-- SlimScroll 1.3.0 -->
	<script
		src="${ctx}/static/AdminLTE/plugins/slimScroll/jquery.slimscroll.min.js"
		type="text/javascript"></script>
	<!-- jquery form 3.51.0 -->
	<script src="${ctx}/static/js/jquery.form.min.js"
		type="text/javascript"></script>
	<!-- jquery valid 1.13.1 -->
	<script src="${ctx}/static/js/jquery.validate.min.js"
		type="text/javascript"></script>
	<script src="${ctx}/static/js/jquery-gv-validate.js"
		type="text/javascript"></script>
	<script
		src="${ctx}/static/AdminLTE/plugins/datetimepicker/bootstrap-datetimepicker.min.js"></script>
<!-- pikaday plugin -->
<script src="${ctx}/static/plugins/pikaday/moment.min.js"></script>
<script src="${ctx}/static/plugins/pikaday/pikaday.js"></script>
	<!-- DataTables plugin -->
	<script
		src="${ctx}/static/AdminLTE/plugins/datatables/jquery.dataTables.js"></script>
	<script
		src="${ctx}/static/AdminLTE/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script src="${ctx}/static/AdminLTE/plugins/iCheck/icheck.min.js"></script>
	<script
		src="${ctx}/static/AdminLTE/plugins/bootstrapDialog/bootstrap-dialog.min.js"></script>
		
	<script src="${ctx}/static/js/SimpleAjaxUploader.js"></script>
	<!-- treeview -->
	<script src="${ctx}/static/plugins/treeview/bootstrap-treeview.min.js"></script>

	<!-- template.js -->
<script src="${ctx}/static/js/template.js"></script>

<!-- today_data -->
<script src="${ctx}/static/plugins/echarts/echarts.min.js"></script>

	<!-- custom js -->
	<script src="${ctx}/static/js/admin.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/gv.common.js"></script>
	<script type="text/javascript" src="${ctx}/static/laydate/laydate.js"></script>
	<script type="text/javascript" src="${ctx}/static/js/util.js" ></script>
	<script> <!-- 判断是否为ie浏览器 如果是 则在根元素添加ie类  后续可以根据需要写针对ie样式 -->
	var ms_ie = false;
	var ua = window.navigator.userAgent;
	var old_ie = ua.indexOf('MSIE ');
	var new_ie = ua.indexOf('Trident/');
	    
	if ((old_ie > -1) || (new_ie > -1)) {
	    ms_ie = true;
	}
	    
	if ( ms_ie ) {
	   document.documentElement.className += " ie";
	}
	</script>

	
</head>
<body class="skin-blue" data-spy="scroll" data-target="#scrollspy" onload="index()">
	<div class="wrapper">
		<jsp:include page="../module/header.jsp"></jsp:include>
		<jsp:include page="../module/menu_side.jsp"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" id="navTab"></div>
		<!-- /.content-wrapper -->

		<%-- <jsp:include page="../module/footer.jsp"></jsp:include> --%>
		<jsp:include page="../module/control-sidebar.jsp"></jsp:include>
	</div>
	<!-- ./wrapper -->
	
	<script type="text/javascript">
		/*模拟点击首页*/
		function  index(){
			$("#index-btn").click();
			$("#index-btn").addClass("menu-active");
		}
		$('.nav li,.sidebar-menu').click(function() {
			$("#index-btn").removeClass('menu-active');
		});

		/*header下拉菜单*/
        var demo = true;
        $('.logo-lg').click(function(e){
        	e.stopPropagation();//阻止冒泡
    		if(demo === true){
    			$('.select-list').show();
    			$('.name-hover').addClass('name-hover-bg');
    			$('.icons').removeClass('icon-pull-down').addClass('icon-pack-up');
    			demo = false;
    		}else{
    			$('.icons').addClass('icon-pull-down').removeClass('icon-pack-up');
    			$('.select-list').hide();
    			$('.name-hover').removeClass('name-hover-bg');
    			demo = true;
    		}
    	});
    	$('.select-list li').click(function(){
    		$(this).parent().hide();
    		$('.name-hover').removeClass('name-hover-bg');
    		$('.icons').addClass('icon-pull-down').removeClass('icon-pack-up');
    		demo = true;
    	})
    	document.addEventListener('click', function(){
		    $('.icons').addClass('icon-pull-down').removeClass('icon-pack-up');
			$('.select-list').hide();
			$('.name-hover').removeClass('name-hover-bg');
			demo = true;
			
		}, false);
    	/*左边菜单点击事件*/
		$('.treeview').click(function(){
			$(this).addClass('active').siblings().removeClass('active');
			$(this).addClass('active').siblings().find('.treeview-menu>li').removeClass('active');
		});
		$('.navbar-nav>li').click(function(){
			$('.treeview').removeClass('active');
			$('.treeview-menu>li').removeClass('active');
		})
	</script>
	<script src="<%=path %>/static/js/jquery.cookie.js"></script>
	<script type ="text/javascript">
		
	function logout(){
		//deleteCookie("login_token");
		
		$.cookie('login_token', "", {
            expires: -1,
            path:"/"
        });
		
		//$.cookie('login_token', null); 
		window.location = "<%=path%>/logout";
	}
	</script>
</body>
</html>