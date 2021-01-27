<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">业务管理</li>
		<li><a href="stockCollect/goEventUpload" data-target="navTab">活动上传</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<a class="btn btn-sm btn-primary" href="static/upload/活动.xlsx">
						<i class="fa fa-fw fa-plus"></i>下载活动模板
					</a>
					<a type="button" onclick="easyUpload()" id="import"class="btn btn-sm btn-primary">
						<i class="fa fa-fw fa-plus"></i>导入活动文件
					</a>
					<a onclick="clearData()"
					   class="btn btn-sm btn-custom role-del">
						<i class="fa fa-fw fa-plus"></i>清空数据
					</a>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						   class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
						<tr>
							<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
							<th>活动名称</th>
							<th>参与货号</th>
<%--							<th>操作</th>--%>
						</tr>
						</thead>
					</table>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>

<script type="text/javascript">


	function easyUpload(){
		var input = document.createElement("input");
		input.type = "file";
		input.click();
		input.onchange = function(){
			onloading();
			var file = input.files[0];
			var form = new FormData();
			form.append("file", file); //第一个参数是后台读取的请求key值
			form.append("fileName", file.name);
			var xhr = new XMLHttpRequest();
			var action = "stockCollect/uploadActivityFile"; //上传服务的接口地址
			xhr.open("POST", action);
			xhr.send(form); //发送表单数据
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					var resultObj = JSON.parse(xhr.responseText);
					if(resultObj.status== 1){
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_SUCCESS,
							title: '操作结果提示',
							message: "上传完毕",
						});
					}else{
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_WARNING,
							title: '操作结果提示',
							message: "上传出错，"+resultObj.msg,
						});
					}
					removeload();
				}
			}
		}
	}

	function clearData() {
		if(confirm("确认清空数据？")){
			$.ajax({
				url:'stockCollect/clearData',
				dataType:'json',
				type:'POST',
				async: false,
				processData : false, // 使数据不做处理
				contentType : false, // 不要设置Content-Type请求头
				success: function(data){
					console.log(data);
					if (data.status == '1') {
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_SUCCESS,
							title: '操作结果提示',
							message: "数据已清空",
						});
					}else{
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_WARNING,
							title: '操作结果提示',
							message: "数据清空失败，"+data.msg,
						});
					}
				},
				error:function(response){
					console.log(response);
				}
			});
		}

	}

	function onloading(){
		loading.baosight.showPageLoadingMsg(false);
	}
	function removeload(){
		loading.baosight.hidePageLoadingMsg();
	}


	var loading = {
		baosight : {
			showPageLoadingMsg : function(showMessage){
				if($("#_loading_div").length == 0){
					$(".row").append('<div id="_loading_div"><span class="item-1"></span><span class="item-2"></span><span class="item-3"></span><span class="item-4"></span><span class="item-5"></span><span class="item-6"></span><span class="item-7"></span></div>');
				}
				if($("#_loadMsg").length == 0){
					$(".row").append('<div id="_loadMsg">正在加载,请稍候... ...</div>');
				}
				if(showMessage == true || showMessage == "true" ){
					$("#_loadMsg").show();
				}
				$("#_loading_div").show();
			},
			hidePageLoadingMsg :function() {
				$("#_loading_div").hide();
				$("#_loadMsg").hide();
			}
		}
	}
</script>
<style>

	#_loadMsg{
		display: inline-block;
		width: 100%;
		text-align: center;
		line-height: 45;
		padding-left: 20px;
		display : none;
	}

	#_loading_div {
		vertical-align: middle;
		display: inline-block;
		width: 100%;
		height: 100%;
		margin: 0 auto;
		text-align: center;
		position: absolute;
		z-index: 3;
		line-height: 40;
		opacity: 0.5;
		display : none;
		background: #CCCCCC;
	}

	#_loading_div span {
		display: inline-block;
		width: 10px;
		height: 40px;
		animation-name: scale;
		-webkit-animation-name: scale;
		-moz-animation-name: scale;
		-ms-animation-name: scale;
		-o-animation-name: scale;
		animation-duration: 1.2s;
		-webkit-animation-duration: 1.2s;
		-moz-animation-duration: 1.2s;
		-ms-animation-duration: 1.2s;
		-o-animation-duration: 1.2s;
		animation-iteration-count: infinite;
		-webkit-animation-iteration-count: infinite;
		-moz-animation-iteration-count: infinite;
		-ms-animation-iteration-count: infinite;
		-o-animation-iteration-count: infinite;
	}
	span.item-1 {
		background: #2ecc71;
	}
	span.item-2 {
		background: #3498db;
	}
	span.item-3 {
		background: #9b59b6;
	}
	span.item-4 {
		background: #e67e22;
	}
	span.item-5 {
		background: #c0392b;
	}
	span.item-6 {
		background: #e74c3c;
	}
	span.item-7 {
		background: #e74c8c;
	}

	.item-1 {
		animation-delay: -1s;
		-webkit-animation-delay: -1s;
		-moz-animation-delay: -1s;
		-ms-animation-delay: -1s;
		-o-animation-delay: -1s;
	}

	.item-2 {
		animation-delay: -0.9s;
		-webkit-animation-delay: -0.9s;
		-moz-animation-delay: -0.9s;
		-ms-animation-delay: -0.9s;
		-o-animation-delay: -0.9s;
	}

	.item-3 {
		animation-delay: -0.8s;
		-webkit-animation-delay: -0.8s;
		-moz-animation-delay: -0.8s;
		-ms-animation-delay: -0.8s;
		-o-animation-delay: -0.8s;
	}

	.item-4 {
		animation-delay: -0.7s;
		-webkit-animation-delay: -0.7s;
		-moz-animation-delay: -0.7s;
		-ms-animation-delay: -0.7s;
		-o-animation-delay: -0.7s;
	}

	.item-5 {
		animation-delay: -0.6s;
		-webkit-animation-delay: -0.6s;
		-moz-animation-delay: -0.6s;
		-ms-animation-delay: -0.6s;
		-o-animation-delay: -0.6s;
	}

	.item-6 {
		animation-delay: -0.5s;
		-webkit-animation-delay: -0.5s;
		-moz-animation-delay: -0.5s;
		-ms-animation-delay: -0.5s;
		-o-animation-delay: -0.5s;
	}

	.item-7 {
		animation-delay: -0.4s;
		-webkit-animation-delay: -0.4s;
		-moz-animation-delay: -0.4s;
		-ms-animation-delay: -0.4s;
		-o-animation-delay: -0.4s;
	}

	@-webkit-keyframes scale {
		0%, 40%, 100% {
			-moz-transform: scaleY(0.2);
			-ms-transform: scaleY(0.2);
			-o-transform: scaleY(0.2);
			-webkit-transform: scaleY(0.2);
			transform: scaleY(0.2);
		}

		20%, 60% {
			-moz-transform: scaleY(1);
			-ms-transform: scaleY(1);
			-o-transform: scaleY(1);
			-webkit-transform: scaleY(1);
			transform: scaleY(1);
		}
	}
	@-moz-keyframes scale {
		0%, 40%, 100% {
			-moz-transform: scaleY(0.2);
			-ms-transform: scaleY(0.2);
			-o-transform: scaleY(0.2);
			-webkit-transform: scaleY(0.2);
			transform: scaleY(0.2);
		}

		20%, 60% {
			-moz-transform: scaleY(1);
			-ms-transform: scaleY(1);
			-o-transform: scaleY(1);
			-webkit-transform: scaleY(1);
			transform: scaleY(1);
		}
	}
	@-ms-keyframes scale {
		0%, 40%, 100% {
			-moz-transform: scaleY(0.2);
			-ms-transform: scaleY(0.2);
			-o-transform: scaleY(0.2);
			-webkit-transform: scaleY(0.2);
			transform: scaleY(0.2);
		}

		20%, 60% {
			-moz-transform: scaleY(1);
			-ms-transform: scaleY(1);
			-o-transform: scaleY(1);
			-webkit-transform: scaleY(1);
			transform: scaleY(1);
		}
	}
	@keyframes scale {
		0%, 40%, 100% {
			-moz-transform: scaleY(0.2);
			-ms-transform: scaleY(0.2);
			-o-transform: scaleY(0.2);
			-webkit-transform: scaleY(0.2);
			transform: scaleY(0.2);
		}

		20%, 60% {
			-moz-transform: scaleY(1);
			-ms-transform: scaleY(1);
			-o-transform: scaleY(1);
			-webkit-transform: scaleY(1);
			transform: scaleY(1);
		}
	}
</style>