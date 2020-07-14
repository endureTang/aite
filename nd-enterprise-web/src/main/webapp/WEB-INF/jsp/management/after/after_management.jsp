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
                <input id="search" class="form-control" type="text" placeholder="订单编号、产品名、借款人姓名、身份证、渠道商">
                <select name="orderStatus" id="orderStatus" class="form-control">

                </select>
                <select name="period" id="period" class="form-control">

                </select>
                <input type='text' class='form-control' id='beginTime' name='date' value='' placeholder="请选择开始日期">
                <input type='text' class='form-control' id='endTime' name='date' value='' placeholder="请选择结束日期">
                <button class="btn" id="searchTable">筛选</button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix">
                	<span>贷款余额：${loanBalance}</span>
                    <a data-toggle="tooltip" data-placement="left" title="单次导出不能超过1万条" id="exportList" href="javascript:;" class="pull-right btn btn-success" style="margin-top: 20px;">导出列表</a>
                </div>
                <div class="box">
                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table">
                            <thead>
                            <tr>
                                <th>序号</th>
                                <th>贷后核查</th>
                                <th>订单编号</th>
                                <th>订单状态</th>
                                <th>产品名</th>
                                <th>贷款申请人</th>
                                <th>身份证</th>
                                <th>放款金额</th>
                                <th>金坤实际放款金额</th>
                                <th>贷款期限</th>
                                <th>月利率</th>
                                <th>绑定银行卡</th>
                                <th>申请时间</th>
                                <th>放款时间</th>
                                <th>渠道商</th>
                                <th>资料归档</th>
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
        <!--模态框1-->
        <div class="modal fade" tabindex="-1" role="dialog" id="myModal_cancel" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                    </div>
                    <div class="modal-body text-center">

                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">确认</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </section>
</div>
<script src="<%=basePath%>static/js/base64.js"></script>
<script>
    var table = {
        // 贷后核查需要红色显示的字段
        redExamine : ['异常'],
        // 订单状态需要红色显示的字段
        orderStatusArr : ['平台拒绝', '用户拒绝', '初审驳回'],
        // 表格实例
        defTable: {},
        // 表格参数
        tableParams: {},
        init: function () {
            var _this = this;
            // 渲染贷款期数
            this.renderPeriod();
            // 渲染时间组件
            this.renderPickTime();
            // 渲染订单状态
            this.renderOrderStatus(function () {
                // 回填保存的搜索值
                $('#search').val('${keyword}');
                $('#orderStatus').val('${orderStatus}');
                $('#period').val('${period}');
                $('#beginTime').val('${createDate}');
                _this.tableParams = {
                    keyword : $.trim($('#search').val())==''?null:$.trim($('#search').val()),
                    orderStatus : $.trim($('#orderStatus').val())==''?null:$.trim($('#orderStatus').val()),
                    period : $.trim($('#period').val())==''?null:$.trim($('#period').val()),
                    beginTime : $.trim($('#beginTime').val())==''?null:$.trim($('#beginTime').val()),
                    endTime : $.trim($('#endTime').val())==''?null:$.trim($('#endTime').val()),
                };

                _this.renderTable();
                _this.bindEvent();
            });
        },
        // 解码Base64字符串
        decode: function (str) {
            if (!!str) {
                return new Base64().decode(str)
            } else {
                return false;
            }
        },
        // 储存初审复审终审
        audit: {},
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击筛选按钮重绘表格
            $('#searchTable').on('click', function () {
                _this.tableParams = {
                    keyword : $.trim($('#search').val())==''?null:$.trim($('#search').val()),
                    orderStatus : $.trim($('#orderStatus').val())==''?null:$.trim($('#orderStatus').val()),
                    period : $.trim($('#period').val())==''?null:$.trim($('#period').val()),
                    beginTime : $.trim($('#beginTime').val())==''?null:$.trim($('#beginTime').val()),
                    endTime : $.trim($('#endTime').val())==''?null:$.trim($('#endTime').val()),
                };
                if(_this.tableParams.beginTime != null && _this.tableParams.endTime != null){
                    if(new Date(_this.tableParams.endTime).getTime()  <  new Date(_this.tableParams.beginTime).getTime()){
                        _this.alertModelCancel('结束时间必须大于开始时间!');
                        return;
                    }
                }
                _this.defTable.draw();
            })
            // 导出
            $('#exportList').click(function () {
                window.open('<%=basePath%>loanOrder/exportAfterOrder?keyword='+$('#search').val()+'&orderStatus='+$('#orderStatus').val()+'&period='+$('#period').val()+'&createDate='+$('#datetimepicker').val());
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
                ajax : function (data, callback, settings) {
                    //封装请求参数
                    var param = {};
                    param.length = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                    // param.startIndex = data.start;//开始的记录序号
                    // param.start = (data.start / data.length)+1;//当前页码
                    param.start = '${start}' == '' ? (data.start / data.length)+1 : ('${start}' / data.length) + 1;
                    param.draw = data.draw;
                    $.ajax({
                        type: "POST",
                        url: util.getServerUrl('/loanOrder/listAfterOrderPage'),
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
                createdRow: function (row, data, index) {
                    $('td:eq(0)', row).html(index + 1);
                },
                lengthMenu: [[10, 20, 30], [10, 20, 30]],
                columns: [
                    {"data": "orderId"},
                    {
                        "data": null,
                        "render": function (data, type, row,meta) {
                            if(row.after_status != ''){
                                var arr = _this.redExamine;
                                if (arr.indexOf(afterStatusCov(row.after_status)) != -1) {
                                    // return '<span class="red-tag">' + afterStatusCov(row.after_status) + '</span>';
                                    return '<a data-model="navTab" data-url="<%=basePath%>loanOrder/baseInfoPage?start='+meta.settings.oAjaxData.start+'&keyword='+$.trim($('#search').val())+'&orderStatus='+$.trim($('#orderStatus').val())+'&period='+$.trim($('#period').val())+'&createDate='+$.trim($('#datetimepicker').val())+'&orderId=' + row.orderId+'&afterLoan='+'1'+'" class="order-num"><span class="red-tag">'+afterStatusCov(row.after_status)+'</span></a>'
                                }
                                return '<a data-model="navTab" data-url="<%=basePath%>loanOrder/baseInfoPage?start='+meta.settings.oAjaxData.start+'&keyword='+$.trim($('#search').val())+'&orderStatus='+$.trim($('#orderStatus').val())+'&period='+$.trim($('#period').val())+'&createDate='+$.trim($('#datetimepicker').val())+'&orderId=' + row.orderId+'&afterLoan='+'1'+'" class="order-num">'+afterStatusCov(row.after_status)+'</a>'
                            }else{
                                return '<a data-model="navTab" data-url="<%=basePath%>loanOrder/baseInfoPage?start='+meta.settings.oAjaxData.start+'&keyword='+$.trim($('#search').val())+'&orderStatus='+$.trim($('#orderStatus').val())+'&period='+$.trim($('#period').val())+'&createDate='+$.trim($('#datetimepicker').val())+'&orderId=' + row.orderId+'&afterLoan='+'1'+'" class="order-num">正常</a>'
                            }

                            function afterStatusCov(status) {
                                switch (status) {
                                    case 0 :
                                        return '正常';
                                        break;
                                    case 1:
                                        return '异常';
                                        break;
                                }
                            }
                        }
                    }, // 贷后核查
                    {
                        "data": null,
                        "render": function (data, type, row,meta) {
                            return '<a data-model="navTab" data-url="<%=basePath%>repayInfoMenu/getRepayInfo?start='+meta.settings.oAjaxData.start+'&keyword='+$.trim($('#search').val())+'&orderStatus='+$.trim($('#orderStatus').val())+'&period='+$.trim($('#period').val())+'&createDate='+$.trim($('#datetimepicker').val())+'&orderId=' + row.orderId+'&afterLoan='+'1'+'&orderNo='+row.orderNo+'" class="order-num">' + row.orderNo + '</a>'
                        }
                    },
                    {
                        "data": null,
                        "render": function (data, type, row) {
                            var arr = _this.orderStatusArr;
                            if (arr.indexOf(row.orderStatus) != -1) {
                                return '<span class="red-tag">' + row.orderStatus + '</span>';
                            }
                            return row.orderStatus;
                        }
                    }, // 订单状态
                    {"data": "productName"},
                    {"data": "trueName"},
                    {"data": "identifyId"},
                    {"data": "auditAmount"},
                    {"data": "actualAmount"},
                    {"data": "auditPeriod"},
                    {"data": "rate"}, // 月利率
                    {"data": "bankCard"}, // 绑定银行卡
                    {// 申请时间
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.formatTime(row.createDate);
                        }
                    },
                    {// 放款时间
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.formatTime(row.makeLoansDate);
                        }
                    },
                    {"data": "channelName"},
                    {
                        data : null,
                        "render": function (data, type, row) {
                            return '<a href="<%=basePath%>loanOrder/getOrderArchiveRecord?isArchive='+row.isArchive+'&orderId='+row.orderId+'" data-model="dialog">'+(row.isArchive == 1 ? "已归档" : "未归档")+'</a>'
                        }
                    }

                ],
                initComplete: function (setting, json) {

                }

            })
        },
        // 渲染选择时间组件
        renderPickTime: function () {
            var i18n = { // 本地化
                previousMonth: '上个月',
                nextMonth: '下个月',
                months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
                weekdays: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
                weekdaysShort: ['日', '一', '二', '三', '四', '五', '六']
            }
            var beginTime = new Pikaday({
                field: $('#beginTime')[0] ,
                i18n : i18n,
                format: 'YYYY-M-D',
            });
            var endTime = new Pikaday({
                field: $('#endTime')[0] ,
                i18n : i18n,
                format: 'YYYY-M-D',
            });
        },
        // 渲染贷款期数
        renderPeriod: function () {
            var $period = $('#period'), i = 1, option = '<option value="" selected>--贷款期数--</option>';
            $period.empty();
            for (i; i < 37; i++) {
                option += '<option value="' + i + '">' + i + '期</option>'
            }
            $period.html(option);
        },
        // 渲染订单状态
        renderOrderStatus: function (cb) {
            $.ajax({
                url: util.getServerUrl('/common/getOrderStatusList'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        var option = '<option value="">--订单状态--</option>';
                        for (var k in res.data.orderStatus) {
                            option += '<option value="' + k + '">' + res.data.orderStatus[k] + '</option>';
                        }
                        $('#orderStatus').html(option);
                        cb&&cb();
                    } else {
                        $('#orderStatus').attr('disabled', 'true');
                    }
                },
                error: function (error) {

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
        // "5:孙骁, 6:gj, 7:王大锤"
        formatAudit: function (str) {
            var audit = {};
            if (!!str) {
                var arr, _this = this;
                $.each(str.split(','), function (key, val) {
                    arr = val.split(':');
                    audit[arr[0]] = arr[1];
                })
                return audit;
            }
            return audit;
        },
        // 模态框1弹出
        alertModelCancel: function (str) {
            $('#myModal_cancel .modal-body').empty();
            $('#myModal_cancel .modal-body').html('<p>' + str + '</p>');
            $('#myModal_cancel').modal('show');
        },

    }
    $(function () {
        table.init();
    })

</script>
</body>
</html>