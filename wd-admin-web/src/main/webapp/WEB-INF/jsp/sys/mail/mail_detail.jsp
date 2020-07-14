<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">邮件管理</li>
		<li><a href="mail" data-target="navTab">邮件信息</a></li>
		<%-- <li><a href="right/subMenu?parentId=${pd.menuId}" data-target="navTab">子菜单信息</a></li> --%>
	</ol>
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<%-- <div class="box-header">
					<shiro:hasPermission name="right/addMenu">
						<button type="button" data-url="right/addMenu?parentId=${pd.menuId}" data-model="dialog"
							class="btn btn-sm btn-primary">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					</shiro:hasPermission>
					<shiro:hasPermission name="right/batchDeleteMenu">
						<button type="button" data-url="right/batchDeleteMenu"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
					</shiro:hasPermission>
				</div> --%>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-hover table-striped">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th width="20px" style="padding-right: 12px;"></th>
								<th>发件人</th>
								<th>收件人</th>
								<th>读取状态</th>
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
            	"url" : "mail/readListDetail?id=${pd.uuid}" ,
            	"type" : "post",
            	"data": function (data) {
                  
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
				        { "data": "to" }
			 ],
			 "columnDefs": [{
				 "targets": 1,
		          "render": function(data, type, row) {
		        	  var html = htmlTpl.dropdown.prefix
			          /* 	<shiro:hasPermission name="right/editMenu">
			            	  + '  <li><a href="right/editMenu?menuId='+row.menuId+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="right/deleteMenu">
			            	  + '  <li><a href="right/deleteMenu?menuId='+row.menuId+'" data-msg="将删除该菜单下的所有权限，确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="right/button">
			            	  + '  <li class="divider"></li>'
			            	  + '  <li><a href="right/button?menuId='+row.menuId+'" data-target="navTab">查看权限</a></li>'
			            </shiro:hasPermission> */
			            	  + htmlTpl.dropdown.suffix; 
						return html;
		          }
		      },{
					 "targets": 4,
			          "render": function(data, type, row) {
			        	  var html = htmlTpl.dropdown.prefix;
				          /*  	<shiro:hasPermission name="right/editMenu">
				            	  + '  <li><a href="right/editMenu?menuId='+row.menuId+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
				            </shiro:hasPermission>
				            <shiro:hasPermission name="right/deleteMenu">
				            	  + '  <li><a href="right/deleteMenu?menuId='+row.menuId+'" data-msg="将删除该菜单下的所有权限，确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
				            </shiro:hasPermission>
				            <shiro:hasPermission name="right/button">
				            	  + '  <li class="divider"></li>'
				            	  + '  <li><a href="right/button?menuId='+row.menuId+'" data-target="navTab">查看权限</a></li>'
				            </shiro:hasPermission>
				            	  + htmlTpl.dropdown.suffix; */
							return '已读';
			          }
			      }],
		      "drawCallback": function (settings) {
		    	  drawICheck('defaultCheck', 'chx_default');
		      },
		      "initComplete": function () {
		    	  initSearchForm(null, "搜索子菜单名称和路径");
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