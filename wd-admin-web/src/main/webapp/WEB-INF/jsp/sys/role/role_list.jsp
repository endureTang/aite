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
		<li><a href="/role/page" data-target="navTab">角色管理</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<shiro:hasPermission name="role/add">
						<button type="button" data-url="role/add" data-model="dialog"
							class="btn btn-sm btn-primary role-add">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					</shiro:hasPermission>
					<shiro:hasPermission name="role/batchDelete">
						<button type="button" data-url="role/batchDelete"
							data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn role-del btn-save btn-sm btn-danger"
							data-checkbox-name="chx_default" data-callback="refreshTable">
							<i class="fa fa-fw fa-remove"></i>批量删除
						</button>
					</shiro:hasPermission>


				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
							<tr>
								<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
								<th>角色名称</th>
								<th>角色类型</th>
								<th>类型</th>
								<th>描述</th>
								<th>企业名称</th>
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
        $.ajax({
            url : '<%=basePath%>coporate/list',
            method:'POST',
            success : function (res) {
                if(res.status==0){
                    defTable = $('#default_table').DataTable( {
                        "ordering": false,
                        "pagingType": "simple_numbers",
                        "processing": true,
                        "autoWidth": false,
                        "serverSide": true,
                        "ajax": {
                            "url" : "role/list?type=1",
                            "type" : "post",
                            "data": function (data) {
                                data.roleName = $("#roleName").val();
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
                            { "data": "roleType" },
                            { // 类型
                                "data": null,
                                "render" : function (data, type, row) {
                                    return switchType(row.type);
                                }
                            },
                            { "data": "remarks" },
                            {
                                "data": 'companName'
                            },
                            { "data": null }
                        ],
                        "columnDefs": [{
                            "targets": 6,
                            "render": function(data, type, row) {
                                var html = htmlTpl.dropdown.prefix
                                    <shiro:hasPermission name="role/edit">
                                    + '  <li><a href="role/edit?roleId='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="role/delete">
                                    + '  <li><a href="role/delete?id='+row.id+'" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="role/editRight">
                                    + '  <li class="divider"></li>'
                                    + '  <li><a href="role/editRight?roleId='+row.id+'" data-model="dialog">分配权限</a></li>'
                                    </shiro:hasPermission>
                                    + htmlTpl.dropdown.suffix;
                                return html;
                            }
                        }],
                        "drawCallback": function (settings) {
                            drawICheck('defaultCheck', 'chx_default');
                        },
                        "initComplete": function () {
                            initSearchForm(null, "搜索角色名、角色类型");

                        }
                    });
                }else{
                    alert('企业列表获取失败');
                }
            },
            error : function (error) {
                alert(error);
            }
        })
	});
    var dropDwonBtn = $('#dropdownMenu1');
    $("#management").on("click", function () {
        dropDwonBtn.html('管理后台 <span class="caret">');
        var table = $('#default_table').DataTable();
        table.ajax.url('role/list?type=1').load();
    });


    $("#business").on("click", function () {
        dropDwonBtn.html('业务后台 <span class="caret">');
        var table = $('#default_table').DataTable();
        table.ajax.url('role/list?type=2').load();
    });


	function switchType(num) {
		switch (num) {
			case 1 :
			    return '管理后台';
			    break;
			case 2:
			    return '业务后台';
			    break;
			default:
			    return '';
			break
		}
    }
	
	function refreshTable(toFirst) {
		//defaultTable.ajax.reload();
		if(toFirst){//表格重绘，并跳转到第一页
			defTable.draw();
		}else{//表格重绘，保持在当前页
			defTable.draw(false);
		}
	}
</script>