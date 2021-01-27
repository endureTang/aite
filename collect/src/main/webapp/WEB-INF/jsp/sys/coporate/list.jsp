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
		<li class="active">业务设置</li>
		<li><a href="/coporate/list" data-target="navTab">企业列表</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">

			<div class="box">
				<div class="box-header" id="boxHeader">
					<!--<shiro:hasPermission name="user/add">-->
						<button type="button" data-url="coporate/corAdd" data-model="dialog"
							class="btn btn-sm btn-primary add btn-custom">
							<i class="fa fa-fw fa-plus"></i>新增
						</button>
					<!--</shiro:hasPermission>-->
				</div>
				<div class="box-body">
					<table id="default_table"
						class="table table-primary table-bordered table-hover table-striped table-custom">
						<thead>
							<tr>
								<th>企业编号</th>
								<th>企业名称</th>
								<th>公司地址</th>
								<th>创建日期</th>
								<th>最大授信额度(万元)</th>
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
            "ajax" : function (data, callback, settings) {
                //封装请求参数
                var param = {};
                param.length = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                param.start = (data.start / data.length)+1;//当前页码
                param.draw = data.draw;
                data.companName = $("#keyword").val();
                $.ajax({
                    type: "POST",
                    url: 'coporate/list',
                    data: param,  //传入组装的参数
                    dataType: "json",
                    success : function (result) {
                        //封装返回数据
                        var returnData = {};
                        returnData.draw = result.draw; //返回了draw计数器
                        returnData.recordsTotal = result.recordsTotal;//返回数据全部记录
                        returnData.recordsFiltered = result.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
                        returnData.data = result.data;//返回的数据列表
                        callback(returnData);
                    }
                })
            },
			"language" : {
				"url" : "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
			},
			"lengthMenu": [[12, 24, 36], [12, 24, 36]],
			"columns" : [ 
			              {"data" : "companCode"},
			              {"data" : "companName"},
			              {"data" : "address"},
			              {
			                  "data" : null,
                              "render" : function(data, type, row){
			                      return formatTime(row.createDate);
							  }
						  },
			              {"data" : "maxCreditLimit"},
			            ],
			"columnDefs" : [ {
				"targets" : 5,
				"render" : function(data, type, row) {
		        	  var html = htmlTpl.dropdown.prefix
			           	// <shiro:hasPermission name="user/njEdit">
			            	  + '  <li><a href="coporate/corEdit?coporateId='+row.id+'" data-model="dialog"><i class="fa fa-pencil"></i>修改</a></li>'
			            // </shiro:hasPermission>
			            // <shiro:hasPermission name="user/njDelete">
			            	  + '  <li><a href="coporate/copyRights?companyName='+row.companName+'&coporateId='+row.id+'"data-model="dialog"><i class="fa fa-copy"></i>角色复制</a></li>'
			            // </shiro:hasPermission>
			            	  + htmlTpl.dropdown.suffix;
		        	  return html;
				}
			} ],
			"drawCallback": function (settings) {
				// drawICheck('defaultCheck', 'chx_default');
	      	},
		    "initComplete": function () {
		    	initSearchForm(null, "搜索 企业名称");
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
    // 格式化时间
    function formatTime(time) {
        if (time) {
            var date = new Date(time);
            return date.getFullYear() + '-' + (preZero(date.getMonth() + 1)) + '-' + preZero(date.getDate()) + ' ' + preZero(date.getHours()) + ':' + preZero(date.getMinutes()) + ':' + preZero(date.getSeconds());
        }

        function preZero(num) {
            num = '' + num;
            return num.length == 1 ? '0' + num : num;
        }
    }
</script>