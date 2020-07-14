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
                    <button type="button" class="btn btn-sm btn-primary btn-save" style="margin-right: 10px;" id="savePorts">
                        <i class="fa fa-fw fa-plus"></i>保存
                    </button>
                </div>
                <div class="box-body">
                    <table id="default_table"
                           class="table table-primary table-bordered table-hover table-striped table-custom">
                        <thead>
                        <tr>
                            <th width="10px" style="padding-right: 12px;"><input type='checkbox' id="defaultCheck" /></th>
                            <th>接口厂商</th>
                            <th>接口功能</th>
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
            url : 'product/getProductApiList',
            data : {productId : '${productId}'},
            method : 'POST',
            success : function (res) {
                defTable = $('#default_table').DataTable( {
                    "ordering": false,
                    "pagingType": "simple_numbers",
                    "processing": true,
                    "autoWidth": false,
                    "serverSide": false,
                    "dom" : 't',
                    "ajax": {
                        "url" : "product/getAllApiList",
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
                        { "data": "supplierName" },
                        { "data": "apiName" },
                    ],
                    "drawCallback": function (settings) {
                        drawICheck('defaultCheck', 'chx_default');
                    },
                    "initComplete": function () {
                        // initSearchForm(null, "搜索角色名");
                        var input = $('input[name="chx_default"]');
                        $.each(res.data,function (key,val) {
                            $.each(input,function (k,v) {
                                if($(v).val()==val.id){
                                    $(v).attr('checked',true);
                                }
                            })
                        })
                        input.iCheck({
                            checkboxClass : 'icheckbox_minimal-blue my-check',
                        })
                    }
                });

            },
            error : function (error) {

            }
        })

        // 点击保存
        $('#savePorts').click(function () {
            var ids = [];
            $('input[name="chx_default"]').each(function (k,v) {
                if($(this).is(':checked')){
                    ids.push($(this).val());
                }
            })
            $.ajax({
                url : 'product/saveProductApi',
                data : {
                    productId : '${productId}',
                    apiIds : ids.join(',')
                },
                method : 'POST',
                success : function (res) {
                    if(res.status==0){
                        alert('保存成功');
                        $('#navTab').load('<%=basePath%>product/listApi');
                    }else{
                        alert('保存失败');
                    }
                },
                error : function (error) {
                    alert('保存失败');
                }
            })
        })
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