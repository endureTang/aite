<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- Content Header (Page header) -->
<%-- <section class="content-header">
	<cycon:navigater path="njTemplate"></cycon:navigater>
</section> --%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<shiro:hasPermission name="processTemplate/add">
						<button type="button" data-url="processTemplate/add" data-model="dialog"
							class="btn btn-sm btn-primary">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					</shiro:hasPermission>
					<%-- <shiro:hasPermission name="template/batchDelete">
						<button type="button" data-url="template/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
					</shiro:hasPermission> --%>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-hover table-striped">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th>模板名称</th>
								<th>bpmn文件名称</th>
								<th>png文件名称</th>
								<th>创建时间</th>
								<th>修改时间</th>
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
            	"url" : "processTemplate/list",
            	"type" : "post",
            	"data": function (data) {
                    data.templateName = $("#templateName").val();
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
				        { "data": "processName" },
				        { "data": "bmpnName" },
				        { "data": "pngName" },
				        { "data": "createTime" },
				        { "data": "updateTime" },
				        { "data": null}
				        
			 ],
			 "columnDefs": [
				 /* {
					"targets" : 6,
					"render" : function(data, type, row) {
						var html = "否";
						switch(data)
						{
							case 0: html = "否"; break;
							case 1: html = "是"; break;
						}
						return html;
					}
				}, */{
				 "targets": 6,
		          "render": function(data, type, row) {
		        	 var html = htmlTpl.dropdown.prefix
			           	<shiro:hasPermission name="processTemplate/edit">
			            	  + '  <li><a href="processTemplate/edit?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="processTemplate/toConfig">
			            	  + '  <li><a href="processTemplate/toConfig?id='+row.id+'&bmpnName='+row.bmpnName+'" data-model="dialog"><i class="fa fa-pencil"></i>配置</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="processTemplate/delete">
			            	  + '  <li><a href="processTemplate/delete?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
			            </shiro:hasPermission>
			            	  + htmlTpl.dropdown.suffix;
		        	  return html;
		          }
		      }],
		      "drawCallback": function (settings) {
		    	drawICheck('defaultCheck', 'chx_default');
		      },
		      "initComplete": function () {
		    	  initSearchForm(null, "搜索模板名称");
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