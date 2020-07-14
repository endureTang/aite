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
		<li class="active">系统设置</li>
		<li><a href="/dist/page" data-target="navTab">字典管理</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<shiro:hasPermission name="dict/add">
						<button type="button" data-url="dict/add" data-model="dialog"
							class="btn btn-sm btn-primary dist-add">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					</shiro:hasPermission>
					<shiro:hasPermission name="dict/batchDelete">
						<button type="button" data-url="dict/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-sm btn-danger dist-del btn-save"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
					</shiro:hasPermission>
					<!-- <button type="button" data-url="dict/addCustom" data-model="dialog"
						class="btn btn-sm btn-primary">
						<i class="fa fa-fw fa-plus"></i>自定义新增
					</button>
					<button type="button" data-url="dict/addCustom1" data-model="dialog"
						class="btn btn-sm btn-primary">
						<i class="fa fa-fw fa-plus"></i>自定义新增1
					</button> -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th>代码</th>
								<th>名称</th>
								<th>值</th>
								<th>排序</th>
								<th>描述</th>
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
            	"url" : "dict/list",
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
			            { "data": "type" },
			            { "data": "labelText" },
			            { "data": "value" },
			            { "data": "sort" },
				        { "data": "description" },
				        { "data": null }
			 ],
			 "columnDefs": [{
				 "targets": 6,
		          "render": function(data, type, row) {
		        	  var html = htmlTpl.dropdown.prefix
			           	<shiro:hasPermission name="dict/edit">
			            	  + '  <li><a href="dict/edit?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="dict/delete">
			            	  + '  <li><a href="dict/delete?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
			            </shiro:hasPermission>
			            	  + htmlTpl.dropdown.suffix;
		        	  return html;
		          }
		      }],
		      "drawCallback": function (settings) {
		    	drawICheck('defaultCheck', 'chx_default');
		      },
		      "initComplete": function () {
		    	  initSearchForm(null, "搜索类型");
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