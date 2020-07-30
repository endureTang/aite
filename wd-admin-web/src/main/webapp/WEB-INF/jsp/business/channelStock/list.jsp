<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">业务管理</li>
		<li><a href="channelStock/page" data-target="navTab">渠道基础库存</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<shiro:hasPermission name="channelStock/add">
						<button type="button" onclick="easyUpload2()"
								class="btn -sm btn-default role-del">
							<i class="fa fa-fw fa-plus"></i>导入增补库存
						</button>
						<button type="button" onclick="easyUpload()"
								class="btn btn-sm btn-primary role-add">
							<i class="fa fa-fw fa-plus"></i>导入ERP库存
						</button>
						<a class="btn btn-sm btn-primary" href="static/upload/ERP库存模板.xlsx">
							<i class="fa fa-fw fa-plus"></i>下载ERP库存模板
						</a>
						<a class="btn btn-sm btn-primary" href="static/upload/库存档案.xlsx">
							<i class="fa fa-fw fa-plus"></i>下载增补库存模板
						</a>



					</shiro:hasPermission>
					<div class="dropdown clearfix">
						<!-- <span class="input-group-addon">菜单分类</span> -->
						<button type="button" class="btn dropdown-toggle menu-dropdown" id="dropdownMenu1" data-toggle="dropdown">渠道基础数据列表
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" id="menuDropdown">
							<li role="presentation">
								<a role="menuitem" id="channelBaseList" tabindex="-1">渠道基础数据列表</a>
							</li>
							<li role="presentation">
								<a role="menuitem" id="errorList" tabindex="-1">问题数据列表</a>
							</li>
							<li role="presentation">
								<a role="menuitem" id="newDataList" tabindex="-1">疑似新品列表</a>
							</li>
						</ul>

					</div>
				</div>
				<div class="box-header">
					<div class="dropdown clearfix">
						渠道基础数据${baseCount}条，问题数据${errorCount}条，疑似新品${newCount}条
					</div>

					<button type="button" onclick="clearData()"
							class="btn btn-sm btn-custom role-del">
						<i class="fa fa-fw fa-plus"></i>清空数据
					</button>
					<button type="button" onclick="exportNewData()"
							class="btn btn-sm btn-primary role-add">
						<i class="fa fa-fw fa-plus"></i>导出疑似新品数据
					</button>
					<button type="button" onclick="exportErrorData()"
							class="btn btn-sm btn-primary role-add">
						<i class="fa fa-fw fa-plus"></i>导出问题数据
					</button>
					<button type="button" data-url="channelStock/goExportChannel" data-model="dialog"
							class="btn btn-sm btn-primary role-add">
						<i class="fa fa-fw fa-plus"></i>导出渠道基础数据
					</button>


				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						   class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
						<tr>
							<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
							<th>货号</th>
							<th>尺码</th>
							<th>数量</th>
							<th>渠道价</th>
							<th>吊牌价</th>
							<th>折扣</th>
							<th>品牌</th>
							<th>操作</th>
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
	var defTable;
	$(document).ready(function() {
		defTable = $('#default_table').DataTable( {
			"ordering": false,
			"pagingType": "simple_numbers",
			"processing": true,
			"autoWidth": false,
			"serverSide": true,
			"ajax": {
				"url" : "channelStock/list?type=1",
				"type" : "post",
				"data": function (data) {
					data.keyword = $("#keyword").val();
				}
			},
			"language": {
				"url": "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
			},
			"createdRow": function (row, data, index ) {
				$('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.id + "'/>");
			},
			"columns": [
				{ "data": "id" },
				{ "data": "stockNo" },
				{ "data": "specification" },
				{ "data": "amount" },
				{ "data": "channelPrice" },
				{ "data": "basePrice" },
				{ "data": "discount" },
				{ "data": "brand" },
				{ "data": null }
			],
			"columnDefs": [{
				"targets": 8,
				"render": function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
							<shiro:hasPermission name="strategy/edit">
							+ '  <li><a href="channelStock/edit?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
							</shiro:hasPermission>
							<shiro:hasPermission name="channelStock/delete">
							+ '  <li><a href="channelStock/delete?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
							</shiro:hasPermission>
							+ htmlTpl.dropdown.suffix;
					return html;
				}
			}],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
			},
			"initComplete": function () {
				initSearchForm(null, "搜索货号");
			}
		});
	});

	function refreshTable(toFirst) {
		//defaultTable.ajax.reload();
		if(toFirst){//表格重绘，并跳转到第一页
			defTable.draw();
		}else{//表格重绘，保持在当前页
			defTable.draw(false);
		}
	}

	var dropDwonBtn = $('#dropdownMenu1');
	$("#channelBaseList").on("click", function () {
		dropDwonBtn.html('渠道基础数据列表 <span class="caret">');
		var table = $('#default_table').DataTable();
		table.ajax.url('channelStock/list?type=1').load();
	});


	$("#errorList").on("click", function () {
		dropDwonBtn.html('问题数据列表 <span class="caret">');
		var table = $('#default_table').DataTable();
		table.ajax.url('channelStock/list?type=2').load();
	});

	$("#newDataList").on("click", function () {
		dropDwonBtn.html('疑似新品列表 <span class="caret">');
		var table = $('#default_table').DataTable();
		table.ajax.url('channelStock/list?type=3').load();
	});

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
			var action = "channelStock/uploadChannelStock"; //上传服务的接口地址
			xhr.open("POST", action);
			xhr.send(form); //发送表单数据
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					var resultObj = JSON.parse(xhr.responseText);
					if(resultObj.status== 1){
						refreshTable(true);
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_SUCCESS,
							title: '操作结果提示',
							message: "ERP库存上传完毕",
						});
					}else{
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_WARNING,
							title: '操作结果提示',
							message: "ERP库存上传出错，"+resultObj.msg,
						});
					}
					removeload();
				}
			}
		}
	}


	function easyUpload2(){
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
			var action = "channelStock/uploadChannelStockAndBaseStock"; //上传服务的接口地址
			xhr.open("POST", action);
			xhr.send(form); //发送表单数据
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					var resultObj = JSON.parse(xhr.responseText);
					if(resultObj.status== 1){
						refreshTable(true);
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_SUCCESS,
							title: '操作结果提示',
							message: "ERP库存上传完毕",
						});
					}else{
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_WARNING,
							title: '操作结果提示',
							message: "ERP库存上传出错，"+resultObj.msg,
						});
					}
					removeload();
				}
			}
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
	
	function clearData() {
		if(confirm("确认清空数据？")){
			$.ajax({
				url:'channelStock/clearData',
				dataType:'json',
				type:'POST',
				async: false,
				processData : false, // 使数据不做处理
				contentType : false, // 不要设置Content-Type请求头
				success: function(data){
					console.log(data);
					if (data.status == '1') {
						refreshTable(true);
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
	
	function exportNewData() {
		window.open("channelStock/exportNewData");
	}
	function exportErrorData() {
		window.open("channelStock/exportErrorData");
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