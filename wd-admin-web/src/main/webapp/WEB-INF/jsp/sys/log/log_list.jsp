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
		<li><a href="/log/page" data-target="navTab">日志管理</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<shiro:hasPermission name="role/batchDelete">
						<button type="button" data-url="log/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn log-del btn-save btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
					</shiro:hasPermission>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-bordered table-primary table-hover table-striped table-custom">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th>用户</th>
								<th>功能</th>
								<th>内容</th>
	 							<th>日期</th>
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
            	"url" : "log/list",
            	"type" : "post",
            	"data": function (data) {
                    data.userName = $("#userName").val();
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
				        { "data": "userName" },
				        { "data": "operateFunction" },
				        { "data": "operateContent" },
				        { "data": "createTime" },
				        { "data": null }
			 ],
			 "columnDefs": [{
				 "targets": 5,
		          "render": function(data, type, row) {
		        	  var html = htmlTpl.dropdown.prefix
			           	<shiro:hasPermission name="log/view">
			            	  + '  <li><a href="log/view?logId='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>查看</a></li>'
			            </shiro:hasPermission>
			            <shiro:hasPermission name="log/delete">
			            	  + '  <li><a href="log/delete?logId='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
			            </shiro:hasPermission>
			            	  + htmlTpl.dropdown.suffix;
		        	  return html;
		          }
		      }],
		      "drawCallback": function (settings) {
		    	drawICheck('defaultCheck', 'chx_default');
		      },
		      "initComplete": function () {
		    	  initSearchForm(null, "搜索 用户/功能/内容");
		      }
	  	});
		
/* 	    $('#default_table tbody tr').live('click', function() {
	        var data = defTable.row( this ).data();
	        alert( 'You clicked on '+data[0]+'\'s row' );
	    } ); */
	    
/* 	    $('#default_table tbody').on('click', 'tr', function () {
 	        var content = $(this).data();
	        alert( 'You clicked on ' + content[1] + '\'s row' );
	    } ); */
		
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