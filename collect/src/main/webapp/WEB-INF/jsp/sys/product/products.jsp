<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- Content Header (Page header) -->
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<div class="checkbox-all"><!-- <input id="defaultCheck"  type="checkbox"><span>全选</span> --></div>
					<div class="btns">
						<button type="button" data-url="product/pass" data-model="ajaxToDo" class="btn btn-sm btn-padd-spel"
							data-msg="确定审批通过吗？" data-checkbox-name="chx_default" data-callback="refreshTable">
							审批通过
						</button>
						<button type="button" data-url="product/notPass" data-model="ajaxToDo" class="btn btn-sm btn-padd-spel"
							data-msg="确定驳回吗？" data-checkbox-name="chx_default" data-callback="refreshTable">
							审批驳回
						</button>
					</div>	
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table" class="table table-primary table-hover table-striped">
						<thead>
							<tr>
								<th width="50px" style="padding-right: 12px;">选择</th>
								<th>产品名称</th>
								<th>提交时间</th>
								<th>提交公司</th>
								<th>产品编码</th>
								<th>状态</th>
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
		defTable = $('#default_table').DataTable({
			"ordering" : false,
			"pagingType" : "simple_numbers",
			"autoWidth": false,
			"processing" : true,
			"serverSide" : true,
			"ajax" : {
				"url" : "product/list",
				"type" : "post",
				"data" : function(data) {
					data.keyword = $("#keyword").val();
				}
			},
			"language" : {
				"url" : "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
			},
			"createdRow" : function(row, data, index) {
				if(data.state == 0){
					$('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.id + "'/>");
				}else{
					/* $('td:eq(0)', row).html("<input type='checkbox' name='chx_default' disabled='true' value='" + data.id + "'/>"); */
					$('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.id + "'/>");
				}
			},
			"lengthMenu": [[12, 24, 36], [12, 24, 36]],
			"columns" : [ 
			              {"data" : "id"},
			              {"data" : "productName"},
			              {"data" : "createDate"},
			              {"data" : "companName"}, 
			              {"data" : "openProductId"},
			              {"data" : "state"}
			              
			            ],
			 "columnDefs" : [ {
							"targets" : 5,
							"render" : function(data, type, row) {
								var html;
								switch(row.state)
								{
									case 0: html = "未提交"; break;
									case 1: html = "待发布"; break;
									case 2: html = "待审核"; break;
									case 3: html = "审核通过"; break;
									case 4: html = "审核未通过"; break;
									case 5: html = "产品已上线"; break;
									case 6: html = "产品已下线"; break;
									default: html = "未提交";
								}
								return html;
							}
				},
				{
					"targets" : 6,
					"render" : function(data, type, row) {
						var html ='<a href="product/edit?productId='+row.id+'" data-model="dialog">编辑</a>';
						return html;
					}
				},
				{
					"targets" : 5,
					"render" : function(data, type, row) {
						if(undefined == row.openProductId){
							return "";
						}else{
							return row.openProductId;
						}
					}
				},
				 {
					"targets" : 2,
					"render" : function(data, type, row) {
						var date = new Date(row.createDate);  
					    var y = date.getFullYear();    
					    var m = date.getMonth() + 1;    
					    m = m < 10 ? ('0' + m) : m;    
					    var d = date.getDate();    
					    d = d < 10 ? ('0' + d) : d;    
					    var h = date.getHours();  
					    h = h < 10 ? ('0' + h) : h;  
					    var minute = date.getMinutes();  
					    var second = date.getSeconds();  
					    minute = minute < 10 ? ('0' + minute) : minute;    
					    second = second < 10 ? ('0' + second) : second;   
					    return y + '-' + m + '-' + d+' '+h+':'+minute+':'+second;    
					}
				}],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
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
</script>