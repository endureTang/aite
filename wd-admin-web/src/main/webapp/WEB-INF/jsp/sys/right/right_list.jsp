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
		<li class="active">系统管理</li>
		<li><a href="right" data-target="navTab">菜单信息</a></li>
	</ol>
</section>

<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<shiro:hasPermission name="right/addMenu">
						<button type="button" data-url="right/addMenu" data-model="dialog"
							class="btn btn-sm btn-primary menu-add">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					</shiro:hasPermission>
					<shiro:hasPermission name="right/batchDeleteMenu">
						<button type="button" data-url="right/batchDeleteMenu"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn btn-save btn-sm btn-danger menu-del"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
					</shiro:hasPermission>
					
					<div class="dropdown clearfix">
						<!-- <span class="input-group-addon">菜单分类</span> -->
					    <button type="button" class="btn dropdown-toggle menu-dropdown" id="dropdownMenu1" data-toggle="dropdown">系统后台菜单
					        <span class="caret"></span>
					    </button>
					    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" id="menuDropdown">
					        <li role="presentation">
					            <a role="menuitem" id="sysMenu" tabindex="-1">系统后台菜单</a>
					        </li>
					        <li role="presentation">
					            <a role="menuitem" id="bussMenu" tabindex="-1">业务后台菜单</a>
					        </li>
					        <li role="presentation">
					            <a role="menuitem" id="bussRes" tabindex="-1">业务后台资源</a>
					        </li>
					    </ul>
					</div>
					
					
<!-- 					<div class="input-group input-group-sm">
						<span class="input-group-addon">订单操作</span>
							<select id="orderOper" class="form-control">
								<option value="all">全部</option>
								<option value="canHandle">可处理</option>
								<option value="handled">处理过</option>
							</select>
					</div> -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-bordered table-primary table-hover table-striped table-custom">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th>名称</th>
								<th>路径</th>
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
		defTable = $('#default_table').DataTable({
			"ordering": false,
			"pagingType": "simple_numbers",
			"autoWidth": false,
			"processing": true,
            "serverSide": true,
            "ajax": {
            	"url" : "right/listSysMenu",
            	"type" : "post",
            	"data": function (data) {
                    data.isShow = "1";
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
				        { "data": "name" },
				        { "data": "href" },
				        { "data": "sort" },
				        { "data": "remarks" },
				        { "data": null }
			 ],
			 "columnDefs": [{
				 "targets": 5,
		          "render": function(data, type, row) {
		        	  var html = htmlTpl.dropdown.prefix
			           	<shiro:hasPermission name="right/editMenu">
			            	  + '  <li><a href="right/editMenu?id='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="right/deleteMenu">
			            	  + '  <li><a href="right/deleteMenu?id='+row.id+'" data-msg="将删除该菜单下的所有子菜单和权限，确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
			            </shiro:hasPermission>
			            	  + htmlTpl.dropdown.suffix;
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
	
	
	  $("#sysMenu").bind("click", function () {  
		  var table = $('#default_table').DataTable();
 		  table.ajax.url('right/listSysMenu').load();
      });
	  
	  
	  $("#bussMenu").bind("click", function () {  
		  var table = $('#default_table').DataTable();
 		  table.ajax.url('right/listBussMenu').load();
      });
	
	  $("#bussRes").bind("click", function () {  
		  var table = $('#default_table').DataTable();
 		  table.ajax.url('right/listBussRes').load();
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