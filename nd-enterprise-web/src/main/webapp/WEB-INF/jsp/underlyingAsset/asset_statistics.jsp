<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>

<link rel="stylesheet" href="<%=basePath%>static/css/order/order_list.css">
<div class="container-fluid">
    <section class="content">

        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix h30"></div>
                <div class="box">
                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table">
                            <thead>
                            <tr>
                                <th>资产分类</th>
                                <th>库存总金额</th>
                                <th>筛选金额</th>
                                <th>资金端待发金额</th>
                                <th>当日募资成功总额</th>
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
</div>

<script type="text/javascript">

    $(document).ready(function () {

        var table = {
            // 表格实例
            defTable: {},
            // 表格参数
            tableParams: {},
            init: function () {
                this.renderTable();
                this.bindEvent();
            },
            // 绑定事件
            bindEvent: function () {
                var _this = this;

            },
            // 初始化页面渲染表格数据
            renderTable: function () {
                var _this = this;
                this.defTable = $('#default_table').DataTable({
                    ordering: false,
                    pagingType: "simple_numbers",
                    autoWidth: false,
                    processing: true,
                    serverSide: true,
                    info: true,
                    ajax : function (data, callback, settings) {
                        //封装请求参数
                        var param = {};
                        param.length = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                        // param.startIndex = data.start;//开始的记录序号
                        param.start = (data.start / data.length)+1;//当前页码
                        param.draw = data.draw;
                        $.ajax({
                            type: "POST",
                            url: util.getServerUrl('/underlyingAsset/productGradeSummary'),
                            data: $.extend(param,_this.tableParams),  //传入组装的参数
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
                    language: {
                        url: "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
                    },
                    lengthMenu: [[30], [30]],
                    columns: [
                        {"data": 'asset_grade'},
                        {"data": 'userConfirmAmount'},
                        {"data": "buildCorporeAmount"},
                        {"data": "fundraisingSuccessAmount"},
                        {"data": "makeLoansAmount"}
                    ],
                    initComplete: function (setting, json) {
                        var even = $('tbody').children('tr').length % 2 == 0 ? 'odd' : 'even';
                        if(json.data.length){
                            var  userConfirmAmount = 0, // 库存总金额
                                buildCorporeAmount = 0, // 筛选金额
                                fundraisingSuccessAmount = 0, // 资金端待发金额
                                makeLoansAmount = 0; // 当日募资成功总额
                            for (var i = 0; i < json.data.length; i++) {
                                var item = json.data[i];
                                userConfirmAmount += item.userConfirmAmount;
                                buildCorporeAmount += item.buildCorporeAmount;
                                fundraisingSuccessAmount += item.fundraisingSuccessAmount;
                                makeLoansAmount += item.makeLoansAmount;
                            }

                            var str = '<tr role="row" class="red-tag '+ even+'">' +
                                '<td>合计</td>' +
                                '<td>'+userConfirmAmount+'</td>' +
                                '<td>'+buildCorporeAmount+'</td>' +
                                '<td>'+fundraisingSuccessAmount+'</td>' +
                                '<td>'+makeLoansAmount+'</td>' +
                                '</tr>';
                            $('tbody').append(str);
                        }

                    }

                })
            },


        }
        table.init();
    })

</script>