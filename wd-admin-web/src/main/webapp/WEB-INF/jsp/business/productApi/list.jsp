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
		<li><a href="/product/listApi" data-target="navTab">产品接口</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">

                    <button style="padding: 5px 16px !important;" type="button" class="btn btn-primary btn-flat btn-custom" id="mybtn" onclick="javacript:refreshTable(1);">搜索</button>
                    <select style="margin-top: 0;" name="coporateId" id="coporateId" class="form-control coporate-name"></select>
					<!--<shiro:hasPermission name="role/add">-->
						<!--<button type="button" data-url="role/add" data-model="dialog"-->
							<!--class="btn btn-sm btn-primary role-add">-->
							<!--<i class="fa fa-fw fa-plus"></i>新增-->
						<!--</button>-->
					<!--</shiro:hasPermission>-->
					<!--<shiro:hasPermission name="role/batchDelete">-->
						<!--<button type="button" data-url="role/batchDelete"-->
							<!--data-msg="确定批量删除吗？" data-model="ajaxToDo" class="btn role-del btn-save btn-sm btn-danger"-->
							<!--data-checkbox-name="chx_default" data-callback="refreshTable">-->
							<!--<i class="fa fa-fw fa-remove"></i>批量删除-->
						<!--</button>-->
					<!--</shiro:hasPermission>-->
				</div>
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-bordered table-hover table-striped table-custom table-product-port">
						<thead>
							<tr>
								<!--<th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>-->
								<th>产品</th>
								<th>说明</th>
								<th>企业名称</th>
								<th>接口配置</th>
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
            	"url" : "product/listApi",
            	"type" : "post",
            	"data": function (data) {
                    data.coporateId = $("#coporateId").val();
                }
            },
            "language": {
                "url": "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
            },
            // "createdRow": function (row, data, index ) {
				// $('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.id + "'/>");
	        // },
			"columns": [
			            // { "data": "id" },
				        { "data": "productName" },
				        { "data": "productDescription" },
				        { "data": "companName" },
				        { "data": null }
			 ],
			 "columnDefs": [{
				 "targets": 3,
		          "render": function(data, type, row) {
				     return '<a style="cursor: pointer;" data-target="navTab" class="fa fa-lg fa-cog" href="<%=basePath%>product/outApiList?productId='+row.id+'"></a>';
		          }
		      }],
		      "drawCallback": function (settings) {
		    	// drawICheck('defaultCheck', 'chx_default');
		      },
		      "initComplete": function () {
		    	  // initSearchForm(null, "搜索产品");
                  $.ajax({
                      url : '<%=basePath%>coporate/list',
                      method:'POST',
                      success : function (res) {
                          if(res.status==0){
                              renderSelect(res.data);
                          }else{
                              alert('企业列表获取失败');
                          }
                      },
                      error : function (error) {
                          alert(error);
                      }
                  })
		      }
	  	});
	});
    function renderSelect(data) {
        var str='<option value="">-请选择企业名称-</option>';
        $.each(data,function (k, v) {
            str += '<option value="'+v.id+'">'+v.companName+'</option>';
        })
        $('#coporateId').html(str);
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