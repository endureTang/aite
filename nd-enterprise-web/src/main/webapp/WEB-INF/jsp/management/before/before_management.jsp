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
                <input type='text' class='form-control' id='datetimepicker' name='date' value='' placeholder="请选择日期">
                <button class="btn" id="searchTable">筛选</button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix">
                    <button id="appoint" type="button" data-model="myModel"
                            class="pull-right btn btn-sm btn-padd-spel">
                        订单分单
                    </button>
                </div>

                <div class="box">

                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table">
                            <thead>
                            <tr>
                                <th>
                                    <input type='checkbox' id="allCheck"/>
                                    序号
                                </th>
                                <th>订单编号</th>
                                <th>订单状态</th>
                                <th>产品名</th>
                                <th>贷款申请人</th>
                                <th>身份证</th>
                                <th>申请金额</th>
                                <th>申请期限</th>
                                <th>申请时间</th>
                                <th>渠道商</th>
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
        <!--模态框2-->
        <div class="modal fade" tabindex="-1" role="dialog" id="myModal_confirm" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                    </div>
                    <div class="modal-body text-center">

                    </div>
                    <div class="modal-footer">
                        <p style="color: #e11f25;font-size: 12px;" id="appointAlertMsg">审批人员必须都不同，请重新分单!</p>
                        <button type="button" class="btn btn-confirm" id="confirmAppoint">
                            确认
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </section>
</div>
<script src="<%=basePath%>static/js/base64.js"></script>
<script type="text/html" id="appointTemplate">
    <div class="row">
        <div class="col-sm-12">
            <table id="appointTable" class="table table-primary table-hover my-table">
                <thead>
                <tr>
                    <th>订单编号</th>
                    <th>产品名</th>
                    <th>贷款申请人</th>
                    <th>申请金额</th>
                    <th>申请期限</th>
                    <th>申请时间</th>
                </tr>
                </thead>
                <tbody id="appointList">

                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">
            <div class="row">
                {{each CheckProcess}}
                    {{if $value==5}}
                        <div class="col-sm-4 title">
                            初审
                        </div>
                    {{/if}}
                {{/each}}
                {{each CheckProcess}}
                    {{if $value==6}}
                    <div class="col-sm-4 title">
                        复审
                    </div>
                    {{/if}}
                {{/each}}
                {{each CheckProcess}}
                    {{if $value==7}}
                    <div class="col-sm-4 title">
                        终审
                    </div>
                    {{/if}}
                {{/each}}
            </div>
            <div class="row appoint-people">
                {{each CheckProcess}}
                    {{if $value==5}}
                        <div class="col-sm-4 radio-name text-left">
                            {{each firstUserList}}
                            <p><input type="radio" name="first_examine" value="{{$value.user_id}}">{{$value.user_name}}</p>
                            {{/each}}
                        </div>
                    {{/if}}
                {{/each}}
                {{each CheckProcess}}
                    {{if $value==6}}
                        <div class="col-sm-4 radio-name text-left">
                            {{each secondUserList}}
                            <p><input type="radio" name="again_examine" value="{{$value.user_id}}">{{$value.user_name}}</p>
                            {{/each}}
                        </div>
                    {{/if}}
                {{/each}}
                {{each CheckProcess}}
                    {{if $value==7}}
                        <div class="col-sm-4 radio-name text-left">
                            {{each lastUserList}}
                            <p><input type="radio" name="final_examine" value="{{$value.user_id}}">{{$value.user_name}}</p>
                            {{/each}}
                        </div>
                    {{/if}}
                {{/each}}
            </div>
        </div>
    </div>
</script>
<script>
    $(function () {
        var table = {
            // 表格实例
            defTable: {},
            // 表格参数
            tableParams: {},
            flag:true,
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
                    $('#datetimepicker').val('${createDate}');
                    _this.tableParams = {
                        keyword : $.trim($('#search').val())==''?null:$.trim($('#search').val()),
                        orderStatus : $.trim($('#orderStatus').val())==''?null:$.trim($('#orderStatus').val()),
                        period : $.trim($('#period').val())==''?null:$.trim($('#period').val()),
                        createDate : $.trim($('#datetimepicker').val())==''?null:$.trim($('#datetimepicker').val()),
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
            // 存储选中的checkOrderId
            checkOrderId : [],
            // 储存获取的CheckProcess
            CheckProcess : '',
            // 绑定事件
            bindEvent: function () {
                var _this = this;
                // 点击筛选按钮重绘表格
                $('#searchTable').on('click', function () {
                    _this.tableParams = {
                        keyword: $.trim($('#search').val()) == '' ? null : $.trim($('#search').val()),
                        orderStatus: $.trim($('#orderStatus').val()) == '' ? null : $.trim($('#orderStatus').val()),
                        period: $.trim($('#period').val()) == '' ? null : $.trim($('#period').val()),
                        createDate: $.trim($('#datetimepicker').val()) == '' ? null : $.trim($('#datetimepicker').val())
                    };
                    _this.defTable.draw();
                })
                // 点击指派进行分单
                $('#appoint').on('click', function () {
                    $('#appointAlertMsg').removeClass('show');
                    if (_this.getCheckboxItem('chx_default').length == 0) {
                        _this.alertModelCancel('请至少选择一条订单进行分单！');
                    } else {
                        _this.appointAjax(_this.getCheckboxItem('chx_default'));
                    }
                })
                // 确认分单
                $('#confirmAppoint').on('click', function () {
                    var params = {
                        orderIds : _this.checkOrderId.join(','),
                        users : ''
                    };
                    var arr = [];
                    // 根据储存的CheckProcess[5,6,7]或者[5,6]等状态进行判断
                    // 此处一定要进行升序排序，否则返回[7,6,5]则会影响后面初审复审终审人员顺序
                    $.each(_this.CheckProcess.sort(function (a, b) {
                        return a-b;
                    }),function (k, v) {
                        if(v==5){
                            arr.push(_this.getRadioItem('first_examine'));
                        }
                        if (v==6){
                            arr.push(_this.getRadioItem('again_examine'));
                        }
                        if (v==7){
                            arr.push(_this.getRadioItem('final_examine'));
                        }
                    })
                    for (var i = 0; i < arr.length; i++) {
                        if(arr[i]==''){
                            $('#appointAlertMsg').text('请选择审批人员!').addClass('show');
                            return;
                        }
                    }
                    if(_this.isAllEquals(arr)){
                        $('#appointAlertMsg').text('审批人员必须都不同，请重新分单!').addClass('show');
                    }else {
                        params.users = arr.join(',');
                        _this.confirmAppoint(params);
                        $('#myModal_confirm').modal('hide');
                        _this.defTable.draw();
                    }


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
                        param.start = '${start}' == '' ? (data.start / data.length)+1 : ('${start}' / data.length) + 1
                        param.draw = data.draw;
                        $.ajax({
                            type: "POST",
                            url: util.getServerUrl('/loanOrder/listPreOrderPage'),
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
                        if (data.state == 0) {
                            $('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.orderId + "'/>" + (index + 1));
                        } else {
                            $('td:eq(0)', row).html("<input type='checkbox' name='chx_default' value='" + data.orderId + "'/>" + (index + 1));
                        }
                    },
                    lengthMenu: [[10, 20, 30], [10, 20, 30]],
                    columns: [
                        {"data": "orderId"},
                        {
                            "data": null,
                            "render": function (data, type, row,meta) {
                                return '<a data-model="navTab" data-url="<%=basePath%>loanOrder/baseInfoBeforePage?start='+meta.settings.oAjaxData.start+'&keyword='+$.trim($('#search').val())+'&orderStatus='+$.trim($('#orderStatus').val())+'&period='+$.trim($('#period').val())+'&createDate='+$.trim($('#datetimepicker').val())+'&orderId=' + row.orderId + '" class="order-num">' + row.orderNo + '</a>'
                            }
                        },
                        {"data": "orderStatus"},
                        {"data": "productName"},
                        {"data": "trueName"},
                        {"data": "identifyId"},
                        {"data": "amount"},
                        {"data": "period"},
                        {
                            "data": null,
                            "render" : function (data,type,row) {
                                return _this.formatTime(row.createDate);
                            }
                        },
                        {"data": "channelName"},
                        // {// 初审 5
                        //     "data": null,
                        //     "render": function (data, type, row) {
                        //         // 将获取到的初审复审终审名单解码并转换成对象
                        //         if(row.audit=='' || row.audit==null){
                        //             return '--';
                        //         }else{
                        //             if (_this.formatAudit(row.audit)[5]) {
                        //                 return '<span class="audit">' + _this.formatAudit(row.audit)[5] + '</span>';
                        //             } else {
                        //                 return '--';
                        //             }
                        //         }
                        //     }
                        // },
                        // { // 复审 6
                        //     "data": null,
                        //     "render": function (data, type, row) {
                        //         // 将获取到的初审复审终审名单解码并转换成对象
                        //         if(row.audit=='' || row.audit==null){
                        //             return '--';
                        //         }else{
                        //             if (_this.formatAudit(row.audit)[6]) {
                        //                 return '<span class="audit">' + _this.formatAudit(row.audit)[6] + '</span>';
                        //             } else {
                        //                 return '--';
                        //             }
                        //         }
                        //     }
                        // },
                        // {// 终审 7
                        //     "data": null,
                        //     "render": function (data, type, row) {
                        //         // 将获取到的初审复审终审名单解码并转换成对象
                        //         if(row.audit=='' || row.audit==null){
                        //             return '--';
                        //         }else{
                        //             if (_this.formatAudit(row.audit)[7]) {
                        //                 return '<span class="audit">' + _this.formatAudit(row.audit)[7] + '</span>';
                        //             } else {
                        //                 return '--';
                        //             }
                        //         }
                        //     }
                        // },


                    ],
                    initComplete: function (setting, json) {
                        // 渲染订单和总金额
                        // $('#moneyTotal').text(json.data.totalAmount);
                        // $('#recordsTotal').text(json.data.recordsTotal);

                    },
                    drawCallback: function () {
                        drawICheck('allCheck', 'chx_default');
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
                    var picker = new Pikaday({
                        field: $('#datetimepicker')[0] ,
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
            // 判断数组中值是否相等
            isEquals: function (arr) {
                var bool = true;
                for (var i = 1; i < arr.length; i++) {
                    if (arr[i] != arr[0]) bool = false;
                }
                return bool;
            },
            // 判断数组中的值都不同
            isAllEquals : function (arr) {
                var bool = true , len = arr.length;
                if(len==1){
                    bool=false;
                }else if(len==2){
                    if((arr[0]!=arr[1]) && (arr[1]!=arr[2])) bool=false;
                }else if (len==3){
                    if((arr[0]!=arr[1]) && (arr[1]!=arr[2]) && (arr[0]!=arr[2])) bool=false;
                }

                return bool;
            },
            // 模态框1弹出
            alertModelCancel: function (str) {
                $('#myModal_cancel .modal-body').empty();
                $('#myModal_cancel .modal-body').html('<p>' + str + '</p>');
                $('#myModal_cancel').modal('show');
            },
            // 获取checkbox值
            getCheckboxItem: function (checkBoxName) {
                var arr = [];
                var ids = $('.my-table input[name="' + checkBoxName + '"]');
                ids.each(function () {
                    if (this.checked) {
                        arr.push(this.value);
                    }
                })
                return arr;
            },
            // 获取radio值
            getRadioItem : function (checkBoxName) {
                var str = '';
                var ids = $('.appoint-people input[name="' + checkBoxName + '"]');
                ids.each(function () {
                    if (this.checked) {
                        str = this.value;
                    }
                })
                return str;
            },
            // 指派分单请求
            appointAjax: function (paramsArr) {
                var _this = this;
                var params = paramsArr.join(',');
                $.ajax({
                    url: util.getServerUrl('/loanOrder/listDispatchUserList'),
                    method: 'POST',
                    data: {
                        orderIdList: params
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            if(res.data.checkUserList.length==0){
                                _this.alertModelCancel('没有找到符合条件的审批人员,请分配权限!');
                            }else{
                                _this.renderAppointHtml(res.data);
                                _this.checkOrderId.length=0; // 先清空
                                // 将选中的orderId存起来便于点击确认分单时传给后台
                                $.each(res.data.orderList,function (key, val) {
                                    _this.checkOrderId.push(val.orderId);
                                })
                                // 将CheckProcess存起来便于点击确认分单时进行判断
                                _this.CheckProcess = res.data.CheckProcess;
                                $('#myModal_confirm').modal('show');
                            }
                        } else {
                            _this.alertModelCancel(res.msg);
                        }
                    },
                    error: function (error) {
                        _this.alertModelCancel('系统故障，请稍后再试!');
                    }
                })
            },
            // 渲染指派分单页面
            renderAppointHtml: function (data) {
                var _this = this;
                var json = {
                    orderList: data.orderList,
                    firstUserList: data.checkUserList,
                    secondUserList: data.checkUserList,
                    lastUserList: data.checkUserList,
                    CheckProcess : data.CheckProcess
                }
                var html = template('appointTemplate', json);
                $('#myModal_confirm .modal-body').html(html);
                // 将列表单独渲染进table
                _this.renderAppointTable(data.orderList);
                //  初始化icheck选项
                $('#myModal_confirm input[type="radio"]').iCheck({
                    radioClass: 'iradio_minimal-blue'
                });


            },
            // 单独渲染分单列表
            renderAppointTable : function (data) {
                var str = '';
                for (var i = 0; i < data.length; i++) {
                    str+='<tr>';
                        str+='<td>'+data[i].orderNo+'</td>';
                        str+='<td>'+data[i].productName+'</td>';
                        str+='<td>'+data[i].trueName+'</td>';
                        str+='<td>'+data[i].amount+'</td>';
                        str+='<td>'+data[i].period+'</td>';
                        str+='<td>'+this.formatTime(data[i].createDate)+'</td>';
                    str+='</tr>';
                }
                $('#appointList').html(str);
            },
            // 确认订单分单
            confirmAppoint: function (data) {
                var _this = this;
                $.ajax({
                    url: util.getServerUrl('/loanOrder/saveDispathOrderUser'),
                    method: 'POST',
                    data: data,
                    success: function (res) {
                        if(res.status==0){
                            _this.alertModelCancel('订单分单成功!')
                        }else {
                            if(res.msg==''){
                                _this.alertModelCancel('订单分单失败，请稍后再试!');
                            }else{
                                _this.alertModelCancel(res.msg);
                            }
                        }
                    },
                    error: function (error) {
                        _this.alertModelCancel('订单分单失败，请稍后再试!')
                    }
                })
            }

        }
        table.init();

    })

</script>
</body>
</html>