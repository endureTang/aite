<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<link rel="stylesheet" href="static/css/verify.css">
<link rel="stylesheet" href="static/plugins/pikaday/pikaday.css">
<section class="content-header">
    <ol class="breadcrumb">
        <li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li class="active">数据统计</li>
        <li><a href="/statistics/thirdPart" data-target="navTab">进件统计</a></li>
    </ol>
</section>
<!-- Main content -->
<section class="content">
    <div class="row">
        <div class="col-xs-12">

            <div class="box">
                <div class="box-header data-picker" id="boxHeader">
                    <button type="button" class="btn btn-primary btn-flat btn-custom" id="mybtn" onclick="javacript:refreshTable(1);">搜索</button>
                    <input type="text" placeholder="请选择结束日期" name="endTime" id="endTime"
                           class="form-control" value="${endTime}">
                    <input type="text" placeholder="请选择开始日期" name="startTime" id="startTime"
                           class="form-control" value="${startTime}">
                </div>
                <div class="box-body">
                    <table id="default_table"
                           class="table table-primary table-bordered table-hover table-striped table-custom">
                        <thead>
                        <tr>
                            <th>企业名称</th>
                            <th>进件数量</th>
                            <th>进件金额</th>
                            <th>通过审批数量</th>
                            <th>通过审批金额</th>
                            <th>通过率</th>
                            <th>放款金额</th>
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
<script src="static/plugins/pikaday/moment.min.js"/>
<script src="static/plugins/pikaday/pikaday.js"/>
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
                "url": "statistics/input",
                "type": "post",
                "data": function (data) {
                    data.startTime = $('#startTime').val();
                    data.endTime = $('#endTime').val();
                }
            },
            "language": {
                "url": "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
            },
            "lengthMenu": [[12, 24, 36], [12, 24, 36]],
            "columns": [
                {
                    "data": null,
                    "render": function (data, type, row, meta) {
                        return '<a data-target="navTab" href="<%=basePath%>statistics/inputByCompany?startTime='+$("#startTime").val()+'&endTime='+$("#endTime").val()+'&companyId=' + row.companyId + '">' + row.companyName + '</a>'
                    }
                },
                {"data": "orderNum"},
                {"data": "orderAmount"},
                {"data": "passNum"},
                {"data": "passAmount"},
                {"data": "passRate"},
                {"data": "loanAmount"}
            ],
            "initComplete": function () {
                renderTime();
            }
        });
    });
    function renderTime() {
        var i18n = { // 本地化
            previousMonth: '上个月',
            nextMonth: '下个月',
            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
            weekdays: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
            weekdaysShort: ['日', '一', '二', '三', '四', '五', '六']
        }
        var startTime = new Pikaday({
            field: $('#startTime')[0],
            i18n: i18n,
            format: 'YYYY-MM-DD',
        });
        var endTime = new Pikaday({
            field: $('#endTime')[0],
            i18n: i18n,
            format: 'YYYY-MM-DD',
        });
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