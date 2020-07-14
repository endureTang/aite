<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
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
                <input id="search" class="form-control" type="text" placeholder="产品名称">
                <button class="btn" id="searchTable">搜索</button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix product-btns">
                    <button class="btn btn-sm pull-right" id="del_product">删除</button>
                    <button class="btn btn-sm pull-right" id="sole_out">下架</button>
                    <button class="btn btn-sm pull-right" id="putaway">上架</button>
                    <shiro:hasPermission name="/product/goAddProductBaseInfo">
                        <div id="creatProduct" class="pull-right btn">
                            新建产品
                            <ul id="productTmpList">
                                <!--<li><a data-model="navTab"-->
                                <!--data-url="<%=basePath%>product/goAddProductBaseInfo?productTempId=1">信用类产品</a></li>-->
                                <!--<li><a data-model="navTab"-->
                                <!--data-url="<%=basePath%>product/goAddProductBaseInfo?productTempId=2">房屋类产品</a></li>-->
                            </ul>
                        </div>
                    </shiro:hasPermission>
                </div>
                <div class="box">
                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table product-table">
                            <thead>
                            <tr>
                                <th>
                                    <input type='checkbox' id="allCheck"/>
                                    产品编号
                                </th>
                                <!--<th>产品资金端编号</th>-->
                                <th>推荐状态</th>
                                <th>产品名</th>
                                <th>产品类型</th>
                                <th>提交时间</th>
                                <th>提交人</th>
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
        <div class="modal fade" tabindex="-1" role="dialog" id="myModal_confirm" data-backdrop="static"
             data-keyboard="false">
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
        <div class="modal fade" tabindex="-1" role="dialog" id="myModal_cancel" data-backdrop="static"
             data-keyboard="false">
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
        checkOrderId: [],
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击筛选按钮重绘表格
            $('#searchTable').on('click', function () {
                _this.tableParams = {
                    productName: $.trim($('#search').val()) == '' ? null : $.trim($('#search').val())
                };
                _this.defTable.draw();
            });
            // 删除产品
            $('#del_product').on('click', function () {
                if (_this.getCheckboxItem('check_id').length == 0) {
                    _this.alertModel('请至少选择一条订单');
                } else {
                    $('#myModal_confirm .modal-body').html('<p>确认要删除吗?</p>')
                    $('#myModal_confirm').modal('show');
                }
            })
            // 确认删除
            $('#confirmDelProduct').on('click', function () {
                $('#myModal_confirm').modal('hide');
                _this.editProduct(-1);
            })
            // 上架产品
            $('#putaway').on('click', function () {
                if (_this.getCheckboxItem('check_id').length == 0) {
                    _this.alertModel('请至少选择一条订单');
                } else {
                    _this.editProduct(5);
                }
            })
            // 下架产品
            $('#sole_out').on('click', function () {
                if (_this.getCheckboxItem('check_id').length == 0) {
                    _this.alertModel('请至少选择一条订单');
                } else {
                    _this.editProduct(6);
                }
            })
            // 新建产品
            $('#creatProduct').on('click', function () {
                $(this).children('ul').toggleClass('show-dom');
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
                        url: util.getServerUrl('/product/listProductPage'),
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
                    if (data.state == 0) {
                        $('td:eq(0)', row).html("<input type='checkbox' name='check_id' value='" + data.id + "'/>" + data.productCode);
                    } else {
                        $('td:eq(0)', row).html("<input type='checkbox' name='check_id' value='" + data.id + "'/>" + data.productCode);
                    }
                },
                lengthMenu: [[10, 20, 30], [10, 20, 30]],
                columns: [
                    {"data": "productCode"},
                    // {"data": "openProductId"},
                    {
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.switchStatus(row.isRecommand);
                        }
                    },
                    {"data": "productName"},
                    {
                        "data": null,
                        "render": function (data, type, row) {
                            switch (row.productTempId) {
                                case 1:
                                    return '3C消费类';
                                    break;
                                case 2:
                                    return '房屋类';
                                    break;
                                case 3:
                                    return '汽车金融类';
                                    break;
                                case 4:
                                    return '现金类';
                                    break;
                            }
                        }
                    },
                    {
                        "data": null,
                        "render": function (data, type, row) {
                            return _this.formatTime(row.createDate);
                        }
                    },
                    {"data": "createByName"},
                    {"data": "stateShow"}, // 状态
                    {
                        "data": null,
                        "render": function (data, type, row) {
                            return '<a data-model="navTab" data-url="<%=basePath%>product/goEditProductBaseInfo?productTempId=' + row.productTempId + '&id=' + row.id + '" class="edit-product">编辑</a>';
                        }
                    },
                ],
                initComplete: function (setting, json) {
                    _this.getSelectList();
                },
                drawCallback: function () {
                    drawICheck('allCheck', 'check_id');
                }

            })
        },
        // 获取下拉模板
        getSelectList: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/common/selecttCoporateTemplate'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        renderList(res.data);
                    } else {
                        if (res.msg == '' || res.msg == undefined) {
                            _this.alertModel('获取产品模板失败!');
                        } else {
                            _this.alertModel(msg);
                        }
                    }
                },
                error: function (error) {
                    this.alertModel('获取产品模板失败!');
                }
            })
            function renderList(data) {
                var str = ''
                $.each(data,function (k, v) {
                    str += '<li><a data-model="navTab" data-url="<%=basePath%>product/goAddProductBaseInfo?productTempId='+v.productTempId+'">'+v.productTempName+'</a></li>'
                })
                $('#productTmpList').html(str);
            }
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
        // 操作产品
        editProduct: function (state) {
            var params = {
                ids: this.getCheckboxItem('check_id').join(','),
                state: state
            }, _this = this;
            $.ajax({
                url: util.getServerUrl('/product/updateProductState'),
                method: 'POST',
                data: params,
                success: function (res) {
                    if (res.status == 0) {
                        _this.alertModel('操作成功!');
                        _this.defTable.draw();
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('操作失败!,请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('操作失败!,请稍后重试!');
                }
            })
        },
        // 判断是否推荐状态
        switchStatus: function (status) {
            switch (status) {
                case false :
                    return '非推荐';
                    break;
                case true :
                    return '推荐';
                    break;
            }
        }


    }
    $(function () {
        table.init();
    })

</script>