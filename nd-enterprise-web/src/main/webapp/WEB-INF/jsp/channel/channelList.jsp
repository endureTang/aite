<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
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
                <input id="search" class="form-control" type="text" placeholder="渠道名称">
                <button class="btn" id="searchTable">搜索</button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix product-btns">
                    <button class="btn btn-sm pull-right" id="del_channel">删除</button>
                    <a id="creatProduct"
                       class="pull-right btn"
                       data-url="<%=basePath%>channel/create"
                       data-model="navTab">
                        新建渠道
                    </a>
                </div>
                <div class="box">
                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table product-table">
                            <thead>
                            <tr>
                                <th>
                                    <input type='checkbox' id="allCheck"/>
                                    序号
                                </th>
                                <th>渠道名称</th>
                                <th>渠道编码</th>
                                <!--<th>渠道类型</th>-->
                                <th>收款账户</th>
                                <th>还款账户</th>
                                <th>创建时间</th>
                                <th>状态</th>
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
        <!--删除模态框-->
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
                        <button type="button" class="btn btn-confirm" id="confirmDelProduct">
                            确认
                        </button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!--模态框-->
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
<script>
    var table = {
        // 表格实例
        defTable: {},
        // 表格参数
        tableParams: {},
        init: function () {
            this.renderTable();
            this.bindEvent();

        },
        // 存储选中的checkOrderId
        checkOrderId : [],
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击筛选按钮重绘表格
            $('#searchTable').on('click', function () {
                _this.tableParams = {
                    channelName: $.trim($('#search').val()) == '' ? null : $.trim($('#search').val())
                };
                _this.defTable.draw();
            });
            // 删除渠道
            $('#del_channel').on('click',function () {
                if(_this.getCheckboxItem('check_id').length==0){
                    _this.alertModel('请至少选择一条渠道');
                }else{
                    $('#myModal_confirm .modal-body').html('<p>确认要删除吗?</p>')
                    $('#myModal_confirm').modal('show');
                }
            })
            // 确认删除
            $('#confirmDelProduct').on('click',function () {
                $('#myModal_confirm').modal('hide');
                _this.delChannel();
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
                    param.start = (data.start / data.length)+1;//当前页码
                    param.draw = data.draw;
                    $.ajax({
                        type: "POST",
                        url: util.getServerUrl('/channel/list'),
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
                    $('td:eq(0)', row).html("<input type='checkbox' name='check_id' value='" + data.id + "'/>" + (index + 1));
                    $('td:eq(7)', row).html('<a data-model="navTab" data-url="<%=basePath%>channel/goBindTFCF?repeeName='+data.repeeName+'&repeeId='+data.repeeId+'&repayName='+data.repayName+'&repayId='+data.repayId+'&channelId='+data.id+'" class="edit-product">绑定账户</a><a data-model="navTab" data-url="<%=basePath%>channel/edit?userInfoId='+data.userInfoId+'&remark='+data.remark+'&channelType='+data.channelType+'&delFlag='+data.delFlag+'&fundsLimit='+data.fundsLimit+'&channelCode='+data.channelCode+'&channelName='+data.channelName+'&id='+data.id+'" class="edit-product">编辑</a>');
                },
                lengthMenu: [[10, 20, 30], [10, 20, 30]],
                columns: [
                    {"data": "id"},
                    {"data": "channelName"},
                    {"data": "channelCode"},
                    // { // 渠道类型
                    //     "data": null,
                    //     "render" : function (data, type, row) {
                    //         return row.channelType == 1 ? '进件渠道' : '资金渠道'
                    //     }
                    // },
                    { // 收款账户
                        "data": null,
                        "render" : function (data, type, row) {
                            return row.repeeName == null || row.repeeName == '' ? '未绑定' : row.repeeName;
                        }
                    },
                    { // 还款账户
                        "data": null,
                        "render" : function (data, type, row) {
                            return row.repayName == null || row.repayName == '' ? '未绑定' : row.repayName;
                        }
                    },
                    {
                        "data": null,
                        "render" : function (data, type, row) {
                            return _this.formatTime(row.createDate);
                        }
                    }, // 创建时间
                    {
                        "data": null,
                        "render" : function (data, type, row) {
                            return row.delFlag == 1 ? '<span class="red-tag">冻结</span>' : '使用中';
                        }
                    },
                    {"data": null},
                ],
                initComplete: function (setting, json) {

                },
                drawCallback: function () {
                    drawICheck('allCheck', 'check_id');
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
        // 模态框弹出
        alertModel: function (str) {
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
        // 删除渠道
        delChannel : function () {
            var params = {
                ids : this.getCheckboxItem('check_id').join(',')
            },_this = this;
            $.ajax({
                url : util.getServerUrl('/channel/batchDelete'),
                method : 'GET',
                data : params,
                success : function (res) {
                    if(res.status==0){
                        _this.alertModel('操作成功!');
                        setTimeout(function () {
                            $('#myModal_cancel').modal('hide');
                        },1000);
                        _this.defTable.draw();
                    }else{
                        if(res.msg==''){
                            _this.alertModel('操作失败!,请稍后重试!');
                        }else{
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error : function (error) {
                    _this.alertModel('操作失败!,请稍后重试!');
                }
            })
        },
    }
    $(function () {
        table.init();
    })

</script>







