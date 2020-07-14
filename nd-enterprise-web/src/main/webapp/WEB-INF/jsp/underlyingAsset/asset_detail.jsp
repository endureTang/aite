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
        <div class="row toolbar">
            <div class="col-xs-12">
                <input id="search" class="form-control" type="text" placeholder="产品名称、订单编号、资产分类">
                <select name="orderStatus" id="orderStatus" class="form-control">
                    <option value="">--订单状态--</option>
                    <option value="9">用户确认</option>
                    <option value="10">生成标的物</option>
                    <option value="11">发标成功</option>
                    <option value="12">募资成功/放款成功</option>
                    <option value="15">发标失败</option>
                    <option value="20">逾期</option>
                    <option value="41">用户拒绝</option>
                    <option value="99">还款完成</option>
                </select>
                <button class="btn" id="searchTable">筛选</button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix h30">

                </div>

                <div class="box">

                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table">
                            <thead>
                            <tr>
                                <th>编号</th>
                                <th>资产分类</th>
                                <th>产品名称</th>
                                <th>订单编号</th>
                                <th>项目编号</th>
                                <th>费率</th>
                                <th>期数</th>
                                <th>金额</th>
                                <th>状态</th>
                                <th>进入库存日期</th>
                                <th>发标日期</th>
                                <th>完成发标日期</th>
                                <th>等待时间</th>
                                <th>发标时间</th>
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
            // 点击筛选按钮重绘表格
            $('#searchTable').on('click', function () {
                _this.tableParams = {
                    keyword: $.trim($('#search').val()) == '' ? null : $.trim($('#search').val()),
                    status: $.trim($('#orderStatus').val()) == '' ? null : $.trim($('#orderStatus').val())
                };
                _this.defTable.draw();
            })
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
                ajax: function (data, callback, settings) {
                    //封装请求参数
                    var param = {};
                    param.length = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                    // param.startIndex = data.start;//开始的记录序号
                    param.start = (data.start / data.length) + 1;//当前页码
                    param.draw = data.draw;
                    $.ajax({
                        type: "POST",
                        url: util.getServerUrl('/underlyingAsset/listBuildCorporeDetails'),
                        data: $.extend(param, _this.tableParams),  //传入组装的参数
                        dataType: "json",
                        success: function (result) {
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
                createdRow: function (row, data, index) {
                    $('td:eq(0)', row).html(index + 1);
                },
                lengthMenu: [[10, 20, 30], [10, 20, 30]],
                columns: [
                    {"data": 'assetGrade'},
                    {"data": 'assetGrade'},
                    {"data": "productName"},
                    { // 订单编号
                        "data": null,
                        "render": function (data, type, row) {
                            return '<a data-model="navTab" class="order-num">' + row.orderNo + '</a>'
                        }
                    },
                    {"data": "tfcfProjectNo"},
                    {"data": "auditRating"},
                    {"data": "auditPeriod"},
                    {"data": "auditAmount"},
                    { // 状态
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.switchStatus(row.status);
                        }
                    },
                    {// 进入库存日期
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.formatTime(row.userConfirmDate);
                        }
                    },
                    {// 发标日期
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.formatTime(row.buildCorporeDate);
                        }
                    },
                    { // 完成发标日期
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.formatTime(row.completeDate);
                        }
                    },
                    {// 等待时间
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.switchTime(row.buildCorporeDate - row.userConfirmDate)==''?'<1秒':_this.switchTime(row.buildCorporeDate - row.userConfirmDate);
                        }
                    },
                    { // 发标时间
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.switchTime(row.completeDate - row.buildCorporeDate);
                        }
                    }
                ],
                initComplete: function (setting, json) {

                },
                drawCallback: function (setting) {
                    var json = _this.defTable.ajax.json();
                }
            })
        },
        // 转换时间
        formatTime: function (time) {
            if (time) {
                var date = new Date(time);
                return date.getFullYear() + '-' + (preZero(date.getMonth() + 1)) + '-' + preZero(date.getDate()) + ' ' + preZero(date.getHours()) + ':' + preZero(date.getMinutes()) + ':' + preZero(date.getSeconds());
            }

            function preZero(num) {
                num = '' + num;
                return num.length == 1 ? '0' + num : num;
            }
        },
        // 毫秒转化小时
        switchTime: function (msd) {
            var time = parseFloat(msd / 1000);
            if (null != time && "" != time) {
                if (time > 60 && time < 60 * 60) {
                    time = parseInt(time / 60.0) + "分钟";
                } else if (time >= 60 * 60 && time < 60 * 60 * 24) {
                    time = parseInt(time / 3600.0) + "小时" + parseInt((parseFloat(time / 3600.0) -
                        parseInt(time / 3600.0)) * 60) + "分钟";
                } else if (time > 60 * 60 * 24) {
                    time = parseInt(time / 3600.0) + "小时";
                }else {
                    time = '';
                }
            }else {
                time = "";
            }
            return time;
        },
        // 转换订单状态
        switchStatus: function (status) {
            if (!!status) {
                switch (status) {
                    case 9 :
                        return '用户确认';
                        break;
                    case 10 :
                        return '资产发标';
                        break;
                    case 11 :
                        return '发标成功';
                        break;
                    case 12 :
                        return '募资成功/放款成功';
                        break;
                    case 20 :
                        return '逾期';
                        break;
                }
            } else {
                return '';
            }
        }


    }
    $(document).ready(function () {
        table.init();
    })

</script>