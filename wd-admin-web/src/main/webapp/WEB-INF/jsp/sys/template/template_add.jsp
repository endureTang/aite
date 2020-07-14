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
        <li><a href="/template/add" data-target="navTab">用户列表</a></li>
    </ol>
</section>
<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-xs-12">

            <div class="box">
                <div class="box-header" id="boxHeader">
                    <select class="form-control coporate-name" name="coporateId" id="coporateId"></select>
                    <shiro:hasPermission name="user/add">
                        <button type="button" data-url="user/njAdd" data-model="dialog"
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
                            <th>编号</th>
                            <th>账号名</th>
                            <th>用户名</th>
                            <th>角色</th>
                             <th>企业名称</th>
                            <th>备注</th>
                            <!--<th>申请原因</th>-->
                            <!--<th>状态</th>-->
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
    $(document).ready(function () {
        defTable = $('#default_table').DataTable({
            "ordering": false,
            "pagingType": "simple_numbers",
            "autoWidth": false,
            "processing": true,
            "searching": true,
            "serverSide": true,
            "ajax": {
                "url": "user/team",
                "type": "post",
                "data": function (data) {
                    data.keyword = $("#keyword").val();
                    data.coporateId = $('#coporateId').val();
                }
            },
            "language": {
                "url": "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
            },
            "createdRow": function (row, data, index) {
                $('td:eq(0)', row).html("<th class='normal-th'>" + (parseInt(index) + 1) + "</th>");
            },
            "lengthMenu": [[12, 24, 36], [12, 24, 36]],
            "columns": [
                {"data": "id"},
                {"data": "userMobile"},
                {"data": "userName"},
                {"data": "roleNames"},
                {"data": "companName"},
                {"data": "remarks"},
                // {"data" : "applyReason"},
                // {"data" : "stateLabel"},
            ],
            "columnDefs": [{
                "targets": 6,
                "render": function (data, type, row) {
                    var html = htmlTpl.dropdown.prefix
                        +'  <li><a href="user/njEdit?coporateId='+row.coporateId+'&userId=' + row.id + '" data-model="dialog"><i class="fa fa-pencil"></i>编辑</a></li>'
                        +'  <li><a href="user/njDelete?userId=' + row.id + '" data-msg="确定删除吗？" data-model="ajaxToDo" data-callback="refreshTable"><i class="fa fa-trash-o"></i>删除</a></li>'
                        + htmlTpl.dropdown.suffix;
                    return html;
                }
            }],
            "drawCallback": function (settings) {
                drawICheck('defaultCheck', 'chx_default');
            },
            "initComplete": function () {
                initSearchForm(null, "搜索 账号/用户/角色");
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
        if (toFirst) {//表格重绘，并跳转到第一页
            defTable.draw();
        } else {//表格重绘，保持在当前页
            defTable.draw(false);
        }
    }

</script>