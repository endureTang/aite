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

<%--<script type="text/javascript" src="<%=basePath%>static/js/jquery-1.5.1.min.js"></script>--%>
<%--<script type="text/javascript" src="<%=basePath%>plugins/zTree/jquery.ztree-2.6.min.js"></script>--%>

<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">当前页面：入库表格</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<body>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">

				<div class="box-header">
					<label class="col-sm-3 control-label">尺码规则：
						<select id="sizeType" name="strategyId" style="height:25px;font-size: 16px;width: 200px;">
							<option value="1">系统自动生成</option>
							<option value="2">用户自定义</option>
						</select>
					</label>
					<label class="col-sm-3 control-label" id="sizeRang" style="display: none">
						尺码区间：<input class="" type="text" id="sizeStart" name="sizeStart" style="height:25px;font-size: 16px;width: 120px;">-<input class="" type="text" id="sizeEnd" name="sizeEnd" style="height:25px;font-size: 16px;width: 120px;">
					</label>
				</div>
				<div class="box-header">
					<label class="col-sm-3 control-label">选择配件：
						<select id="strategyId" name="strategyId" style="height:25px;font-size: 16px">
							<option value="1">男鞋</option>
							<option value="2">女鞋</option>
							<option value="3">中性鞋</option>
							<option value="4">男装</option>
							<option value="5">女装</option>
							<option value="6">三叶草女装（数字尺码）</option>
						</select>
					</label>
					<label class="col-sm-3 control-label">
						货品编号：<input class="formVal" type="text" id="stockNo" name="stockNo" style="height:25px;font-size: 16px">
					</label>
					<label class="col-sm-3 control-label">
						品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：<input class="formVal" id="brandName" type="text" name="brandName" style="height:25px;font-size: 16px">
					</label>
				</div>
				<div class="box-header">
					<label class="col-sm-3 control-label">
						单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;位：<input class="formVal" type="text" name="unit" id="unit" style="height:25px;font-size: 16px">
					</label>
					<label class="col-sm-3 control-label">
						数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：<input class="formVal" type="text" id="amount" name="amount" style="height:25px;font-size: 16px">
					</label>
					<label class="col-sm-3 control-label">
						单&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;价：<input name="price" id= "price" class="formVal" type="text" style="height:25px;font-size: 16px">
					</label>
				</div>
				<div class="box-header">
					<label class="col-sm-3 control-label">
						优&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;惠：<input name="discountPrice" class="formVal" type="text" id="discountPrice" style="height:25px;font-size: 16px">
					</label>
					<label class="col-sm-3 control-label">
						分摊成本：<input name="basePrice" class="formVal" type="text" id="basePrice" style="height:25px;font-size: 16px">
					</label>
					<label class="col-sm-3 control-label">
						备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：<input name="remark" class="formVal" type="text" id="remark" style="height:25px;font-size: 16px">
					</label>
				</div>
				<div class="box-header">
					<a class="btn btn-sm btn-primary" href="addStock" data-model="dialog"><i class="fa fa-pencil"></i>新增</a>
					<input type="button" class="btn btn-sm btn-primary" value="写入" onclick="doSubmit()">
					<input type="button" class="btn btn-sm btn-custom role-del" onclick="clearData()" value="清除数据">
					<a class="btn btn-sm btn-primary" href="<%=basePath%>/exportStockData">导出</a>
					<button type="button" data-url="batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn role-del btn-save btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
						<i class="fa fa-fw fa-remove"></i>批量删除
					</button>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						   class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
						<tr>
							<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
							<th>货品编号</th>
							<th>品名</th>
							<th>规格</th>
							<th>单位</th>
							<th>数量</th>
							<th>单价</th>
							<th>优惠（折扣前加*）</th>
							<th>分摊成本</th>
							<th>备注</th>
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
	</body>
	<!-- /.row -->
</section>

<script type="text/javascript">
	var defTable;
	$(document).ready(function() {

		$('#sizeType').change(function(){
			var sizeType = $("#sizeType").val();
			if(sizeType=="2"){
				$("#sizeRang").show();
			}else{
				$("#sizeRang").hide();
			}
		})

		defTable = $('#default_table').DataTable( {
			"ordering": false,
			"paging": false, // 禁止分页
			"pagingType": "simple_numbers",
			"processing": true,
			"autoWidth": false,
			"serverSide": true,
			"ajax": {
				"url" : "getStockData",
				"type" : "post",
				"data": function (data) {
					data.type = 1;
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
				{ "data": "stockNo" },
				{ "data": "brandName" },
				{ "data": "spec" },
				{ "data": "unit" },
				{ "data": "amount" },
				{ "data": "price" },
				{ "data": "discountPrice" },
				{ "data": "basePrice" },
				{ "data": "remark" }
			],
			"columnDefs": [{
				"targets": 10,
				"render": function(data, type, row) {
					var html = htmlTpl.dropdown.prefix
							+ '  <li><a href="editStock?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>修改</a></li>'
							+ '  <li><a href="deleteStock?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
							+ htmlTpl.dropdown.suffix;
					return html;
				}
			},{
				"targets": 4,
				createdCell: function (cell, cellData, rowData, rowIndex, colIndex) {
					$(cell).click(function () {
						$(this).html('<input type="text" size="1" style="width: 100%"/>');
						var aInput = $(this).find(":input");
						aInput.focus().val(cellData);
					});
					$(cell).on("blur", ":input", function () {
						var amount = $(this).val();
						$(cell).html(amount);
						if(cellData != amount){
							$.ajax({
								type: "POST",
								url: 'editAmount',
								data: {
									id:rowData.id,
									amount: amount
								},
								dataType: 'json',
								cache: false,
								success: function (data) {
									refreshTable(true);
									BootstrapDialog.show({
										type: BootstrapDialog.TYPE_SUCCESS,
										title: '操作结果提示',
										message: "更新数量成功"
									});
								}
							});
						}

					})
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
		var amount = $("#amount").val();
		var price = $("#price").val();
		var brandName = $("#brandName").val();
		var unit = $("#unit").val();
		var discountPrice = $("#discountPrice").val();
		var basePrice = $("#basePrice").val();
		var remark = $("#remark").val();
		var sizeType = $("#sizeType").val();
		var sizeStart = $("#sizeStart").val();
		var sizeEnd = $("#sizeEnd").val();
		if(sizeType == 2 && (sizeStart == null || sizeStart == ''||sizeEnd == null || sizeEnd == '')){
			BootstrapDialog.show({
				type: BootstrapDialog.TYPE_WARNING,
				title: '提示',
				message: "自定义尺码不能为空",
			});
			return ;
		}
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
				message: "单价不能为空",
			});
			return ;
		}
		if(amount == null || amount == ''){
			BootstrapDialog.show({
				type: BootstrapDialog.TYPE_WARNING,
				title: '提示',
				message: "数量不能为空",
			});
			return ;
		}
		$.ajax({
			type: "POST",
			url: 'saveStock',
			data: {
				type: strategyId,
				stockNo: stockNo,
				brandName: brandName,
				amount: amount,
				unit: unit,
				discountPrice: discountPrice,
				basePrice: basePrice,
				remark: remark,
				sizeType: sizeType,
				sizeStart: sizeStart,
				sizeEnd: sizeEnd,
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
				url:'clearStockData',
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

