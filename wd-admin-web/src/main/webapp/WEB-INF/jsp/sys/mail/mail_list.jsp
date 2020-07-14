<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">邮件管理</li>
		<li><a href="right" data-target="navTab">邮件列表</a></li>
	</ol>
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
					<shiro:hasPermission name="mail/newMail">
						<button type="button" data-url="mail/newMail" data-model="dialog"
							class="btn btn-sm btn-primary">
							<i class="fa fa-fw fa-plus"></i>新邮件
						</button>
					</shiro:hasPermission>
					<%-- <shiro:hasPermission name="right/batchDeleteMenu">
						<button type="button" data-url="right/batchDeleteMenu"
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
								<th width="20px" style="padding-right: 12px;"></th>
								<th>发件人</th>
								<th>内容</th>
								<th>to</th>
								<th>发送状态</th>
								<th>日志</th>
								<th>详情</th>
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
			"ordering": false,
			"pagingType": "simple_numbers",
			"autoWidth": false,
			"processing": true,
            "serverSide": true,
            "ajax": {
            	"url" : "mail/list",
            	"type" : "post",
            	"data": function (data) {
                    data.menuType = "1";
                    data.keyword = $("#keyword").val();
                }
            },
            "language": {
                "url": "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
            },
			"createdRow": function (row, data, index ) {
				$('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.menuId + "'/>");
	        },
			"columns": [
			            { "data": "id" },
			            { "data": null },
				        { "data": "fromAdd" },
				        { "data": "content" },
				        { "data": "tos" },
				        { "data": "sendStatus" },
				        { "data": "msg" }
			 ],
			 "columnDefs": [{
				 "targets": 1,
		          "render": function(data, type, row) {
		        	  var html = htmlTpl.dropdown.prefix
			           	/* <shiro:hasPermission name="right/editMenu">
			            	  + '  <li><a href="right/editMenu?menuId='+row.menuId+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="right/deleteMenu">
			            	  + '  <li><a href="right/deleteMenu?menuId='+row.menuId+'" data-msg="将删除该菜单下的所有子菜单和权限，确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="right/subMenu">
			            	  + '  <li class="divider"></li>'
			            	  + '  <li><a href="right/subMenu?parentId='+row.menuId+'" data-target="navTab">查看子菜单</a></li>'
			            </shiro:hasPermission> */
			            	  + htmlTpl.dropdown.suffix;
		        	  return html;
		          }
		      },
		      {
					 "targets": 7,
			          "render": function(data, type, row) {
			        	  var html = ''
				            <shiro:hasPermission name="right/subMenu">

				            	  +'  <li><a href="mail/readList?id='+row.id+'" data-target="navTab">查看已读状态</a></li>'
				            </shiro:hasPermission>
			        	  return html;
			          }
			      }],
		      "drawCallback": function (settings) {
		    	  drawICheck('defaultCheck', 'chx_default');
		      },
		      "initComplete": function () {
		    	  initSearchForm(null, "搜索菜单名称和路径");
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