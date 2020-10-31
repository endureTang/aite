<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- Content Header (Page header) -->
<!--<section class="content-header">-->
<!--</section>-->
<!-- Content Header (Page header) -->
<base href="<%=basePath%>">
<%--<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.5.1.min.js"></script>--%>
<script type="text/javascript" src="<%=basePath%>plugins/zTree/jquery.ztree-2.6.min.js"></script>
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">当前页面：改价表格</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<body>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<label class="col-sm-3 control-label">选择配件：
						<select id="strategyId" name="strategyId"style="height:25px;font-size: 16px">
							<option value="1">男鞋</option>
							<option value="2">女鞋</option>
							<option value="3">中性鞋</option>
							<option value="4">男装</option>
							<option value="5">女装</option>
							<option value="6">三叶草女装（数字尺码）</option>
						</select>
					</label>
					<label class="col-sm-3 control-label">
						货品编号：<input class="formVal" type="text" id="stockNo" name="stockNo"style="height:25px;font-size: 16px">
					</label>
					<label class="col-sm-3 control-label">
						成本价：<input id="price" name="price" class="formVal" type="text"style="height:25px;font-size: 16px">
					</label>

				</div>
				<div class="box-header">
					<a class="btn btn-sm btn-primary" href="addPrice" data-model="dialog"><i class="fa fa-pencil"></i>新增</a>
					<input type="button" class="btn btn-sm btn-primary" value="写入" onclick="doSubmit()">
					<input type="button" class="btn btn-sm btn-custom role-del" onclick="clearData()" value="清除数据">
					<a class="btn btn-sm btn-primary" href="<%=basePath%>/exportPriceData">导出</a>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						   class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
						<tr>
							<th>货品编号</th>
							<th>规格</th>
							<th>成本价</th>
							<th>编辑</th>
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
	</body>
	<!-- /.row -->
</section>

<script type="text/javascript">
	var defTable;
	$(document).ready(function() {
		defTable = $('#default_table').DataTable( {
			"ordering": false,
			"paging": false, // 禁止分页
			"pagingType": "simple_numbers",
			"processing": true,
			"autoWidth": false,
			"serverSide": true,
			"ajax": {
				"url" : "getPriceData",
				"type" : "post",
				"data": function (data) {
					data.type = 1;
					data.keyword = $("#keyword").val();
				}
			},
			"language": {
				"url": "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
			},

			"columns": [
				{ "data": "stockNo" },
				{ "data": "spec" },
				{ "data": "price" }
			],
			"columnDefs": [{
				"targets": 3,
				"render": function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
							+ '  <li><a href="editPrice?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>修改</a></li>'
							+ '  <li><a href="deletePrice?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
							+ htmlTpl.dropdown.suffix;
					return html;
				}
			}],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
			},
			"initComplete": function () {
				/*initSearchForm(null, "搜索 原始单号/姓名/快递单号");*/
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

	function doSubmit() {
		var strategyId = $("#strategyId").val();
		var stockNo = $("#stockNo").val();
		var price = $("#price").val();
		if(stockNo == null || stockNo == ''){
			BootstrapDialog.show({
				type: BootstrapDialog.TYPE_WARNING,
				title: '提示',
				message: "货品编号不能为空",
			});
			return ;
		}
		if(price == null || price == ''){
			BootstrapDialog.show({
				type: BootstrapDialog.TYPE_WARNING,
				title: '提示',
				message: "价格不能为空",
			});
			return ;
		}
		$.ajax({
			type: "POST",
			url: 'savePrice',
			data: {
				type: strategyId,
				stockNo: stockNo,
				price:price
			},
			dataType: 'json',
			cache: false,
			success: function (data) {
				refreshTable(true);
				BootstrapDialog.show({
					type: BootstrapDialog.TYPE_SUCCESS,
					title: '操作结果提示',
					message: "写入成功"
				});
			}
		});
	}


	function clearData() {
		if(confirm("确认清空数据？")){
			$.ajax({
				url:'clearData',
				dataType:'json',
				type:'POST',
				async: false,
				processData : false, // 使数据不做处理
				contentType : false, // 不要设置Content-Type请求头
				success: function(data){
					console.log(data);
                    refreshTable(true);
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_SUCCESS,
						title: '操作结果提示',
						message: "数据已清空",
					});
				},
				error:function(response){
					console.log(response);
				}
			});
		}

	}


</script>

