<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- Content Header (Page header) -->
<!--<section class="content-header">-->
<!--<cycon:navigater path="role"></cycon:navigater>-->
<!--</section>-->
<!-- Content Header (Page header) -->
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">业务管理</li>
		<li><a href="stockBase/page" data-target="navTab">库存档案</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<div class="col-sm-2">
					<select name="type" id="type" class="form-control required">
						<option value="1">模板一</option>
						<option value="2">模板二</option>
						<option value="3">模板三</option>
					</select>
					</div>
					<a type="button" onclick="easyUpload()" id="import"class="btn btn-sm btn-primary" >
						<i class="fa fa-fw fa-plus"></i>导入库存汇总zip
					</a>

					<a onclick="clearData()"
					   class="btn btn-sm btn-custom role-del">
						<i class="fa fa-fw fa-plus"></i>清空数据
					</a>

					<button type="button" onclick="downLoadZip()"
							class="btn btn-sm btn-primary role-add">
						<i class="fa fa-fw fa-plus"></i>下载库存汇总
					</button>
					<button type="button" onclick="exportZip()"
							class="btn btn-sm btn-primary role-add">
						<i class="fa fa-fw fa-plus"></i>下载zip
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
							<th>折扣</th>
							<th>吊牌价</th>
							<th>渠道价</th>
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
				"url" : "stockBase/list",
				"type" : "post",
				"data": function (data) {
					data.type = $("#type").val();
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
				{ "data": "discount" },
				{ "data": "channelPrice" },
				{ "data": "basePrice" },
				{ "data": null }
			],
			"columnDefs": [{
				"targets": 7,
				"render": function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
							<shiro:hasPermission name="strategy/edit">
							+ '  <li><a href="stockBase/edit?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
							</shiro:hasPermission>
							<shiro:hasPermission name="stockBase/delete">
							+ '  <li><a href="stockBase/delete?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
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

	function easyUpload(){
		var type = $("#type").val();
		var input = document.createElement("input");
		input.type = "file";
		input.click();
		input.onchange = function(){
			onloading();
			var file = input.files[0];
			var form = new FormData();
			form.append("file", file); //第一个参数是后台读取的请求key值
			form.append("fileName", file.name);
			form.append("type", type);
			var xhr = new XMLHttpRequest();
			var action = "stockCollect/updateZipFile"; //上传服务的接口地址
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
							message: "库存档案上传完毕",
						});
					}else{
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_WARNING,
							title: '操作结果提示',
							message: "库存档案上传出错，"+resultObj.msg,
						});
					}
					removeload();
				}
			}
		}
	}

	function exportZip(){
		$.ajax({
			url:'stockCollect/exportZip',
			dataType:'json',
			type:'POST',
			async: false,
			processData : false, // 使数据不做处理
			contentType : false, // 不要设置Content-Type请求头
			success: function(data){
				console.log(data);
				if (data.status == '1') {
					$(obj).attr("disabled","disabled");
					$(obj).parent().parent().find("#strategyId").attr("disabled","disabled");
					$(obj).parent().parent().find(".file").attr("disabled","disabled");
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_SUCCESS,
						title: '操作结果提示',
						message: "上传成功",
					});
				}else{
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_WARNING,
						title: '操作结果提示',
						message: "上传失败，"+data.msg,
					});
				}
			},
			error:function(response){
				console.log(response);
			}
		});
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