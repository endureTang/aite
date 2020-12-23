<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">当前页面：库存查询</li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<body>
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<label class="col-sm-3 control-label">
						输入货号：<input class="formVal" type="text" id="stockNo" name="stockNo" style="height:25px;font-size: 16px">
					</label>
					<button type="button" data-callback="refreshTable" class="btn btn-sm btn-primary" onclick="queryStock()">
						<i class="fa"></i>查询
					</button>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						   class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
						<tr>
							<th>货品名称</th>
							<th>条码+附加码</th>
							<th>规格</th>
							<th>仓库名称</th>
							<th>实际库存</th>
							<th>待发货数</th>
							<th>订购量</th>
							<th>可订购</th>
							<th>调入在途</th>
							<th>调出在途</th>
							<th>采购在途</th>
							<th>采购计划数</th>
							<th>成本价</th>

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
			"scrollX": true,
			"autoWidth":true,
			"ajax": {
				"url" : "stockQueryApi/getStockInfoFromApi",
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
				{ "data": "goodsname" },
				{ "data": "barcode" },
				{ "data": "specname" },
				{ "data": "warehousename" },
				{ "data": "stock" },
				{ "data": "sndcount" },
				{ "data": "ordercount" },
				{ "data": "stock3" },
				{ "data": "dbincount" },
				{ "data": "dboutcount" },
				{ "data": "purchasecount" },
				{ "data": "purchaseplan" },
				{ "data": "pricecost" }
			],
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

	function queryStock(){
		var stockNo = $("#stockNo").val();
		if(stockNo == null || stockNo == ''){
			BootstrapDialog.show({
				type: BootstrapDialog.TYPE_WARNING,
				title: '提示',
				message: "货品编号不能为空",
			});
			return ;
		}
		$.ajax({
			type: "POST",
			url: 'stockQueryApi/getStockByCode',
			data: {
				code: stockNo
			},
			dataType: 'json',
			cache: false,
			success: function (data) {
				if(data == 200){
					refreshTable(true);
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_SUCCESS,
						title: '操作结果提示',
						message: "写入成功"
					});
				}else{
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_SUCCESS,
						title: '操作结果提示',
						message: ""
					});
				}

			}
		});
	}

</script>

