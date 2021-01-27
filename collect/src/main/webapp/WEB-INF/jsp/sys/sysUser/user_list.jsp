<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<link rel="stylesheet" href="static/css/verify.css">

<!-- Content Header (Page header) -->
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">用户管理</li>
		<li><a href="/sysUser/list" data-target="navTab">企业用户</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">

			<div class="box">
				<div class="box-header" id="boxHeader">
					<shiro:hasPermission name="user/add">
						<button type="button" data-url="sysUser/add" data-model="dialog"
							class="btn btn-sm btn-primary add btn-custom">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					</shiro:hasPermission>
				</div>
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
							<tr>
								<th>姓名</th>
								<th>用户名</th>
								<th>电话</th>
								<th>角色</th>
								<th>备注</th>
								<th>操作</th>
							</tr>
						</thead>
					</table>
				</div>
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
			"searching": true,
			"serverSide" : true,
			"ajax" : {
				"url" : "sysUser/list",
				"type" : "post",
				"data" : function(data) {
					data.keyword = $("#keyword").val();
				}
			},
			"language" : {
				"url" : "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
			},
			"lengthMenu": [[12, 24, 36], [12, 24, 36]],
			"columns" : [ 
			              {"data" : "name"},
			              {"data" : "login_name"},
			              {"data" : "phone"},
			              {"data" : "roleNames"},
			              {"data" : "remarks"},
			              {"data" : null},
			            ],
			"columnDefs" : [ {
				"targets" : 5,
				"render" : function(data, type, row) {
		        	  var html = htmlTpl.dropdown.prefix
			           	<shiro:hasPermission name="user/njEdit">
			            	  + '  <li><a href="sysUser/edit?userId='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="user/njDelete">
			            	  + '  <li><a href="sysUser/delete?userId='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
			            </shiro:hasPermission>
			            	  + htmlTpl.dropdown.suffix;
		        	  return html;
				}
			} ],
			"drawCallback": function (settings) {
				drawICheck('defaultCheck', 'chx_default');
	      	},
		    "initComplete": function () {
		    	initSearchForm(null, "搜索 账号/用户/角色");
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