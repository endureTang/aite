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
                <div class="statistics clearfix">
                    <button class="btn btn-primary pull-right" id="creatNewAsset">新建资产分类</button>
                </div>
                <div class="box">
                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table asset-table">
                            <thead>
                            <tr>
                                <th>级别</th>
                                <th>说明</th>
                                <th>筛选比例</th>
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
    </section>
    <!--模态框-->
    <div class="modal fade asset-classify" tabindex="-1" role="dialog" id="myModal" data-backdrop="static"
         data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <ul>
                        <li>
                            <i>级别</i>
                            <select class="form-control" name="grade" id="assetGrade"></select>
                        </li>
                        <li>
                            <i>说明</i>
                            <textarea class="form-control" rows="5" id="assetRemark"></textarea>
                        </li>
                        <li>
                            <i>筛选比例</i>
                            <input placeholder="请输入数字" type="text" class="form-control" id="assetScale">
                        </li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <span class="error-msg">错误提示错误提示错误提示错误提示</span>
                    <button id="saveAssetClassify" type="button" class="btn btn-primary">确认</button>
                    <button type="button" class="btn btn-confirm" data-dismiss="modal" id="closeAssetClassify">关闭
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!--编辑模态框-->
    <div class="modal fade asset-classify" tabindex="-1" role="dialog" id="myModal_edit" data-backdrop="static"
         data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <ul>
                        <li>
                            <i>级别</i>
                            <select class="form-control" name="grade" id="assetGradeEdit"></select>
                        </li>
                        <li>
                            <i>说明</i>
                            <textarea class="form-control" rows="5" id="assetRemarkEdit"></textarea>
                        </li>
                        <li>
                            <i>筛选比例</i>
                            <input placeholder="请输入数字" type="text" class="form-control" id="assetScaleEdit">
                        </li>
                    </ul>
                </div>
                <div class="modal-footer">
                    <span class="error-msg">错误提示错误提示错误提示错误提示</span>
                    <button id="editSaveAssetClassify" type="button" class="btn btn-primary">保存</button>
                    <button type="button" class="btn btn-confirm" data-dismiss="modal" id="editCloseAssetClassify">关闭
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!--确认模态框-->
    <div class="modal fade asset-classify" tabindex="-1" role="dialog" id="myModal_confirm" data-backdrop="static"
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
                    <button id="confirmDel" type="button" class="btn btn-primary">确认</button>
                    <button type="button" class="btn btn-confirm asset-close" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!--取消模态框-->
    <div class="modal fade asset-classify" tabindex="-1" role="dialog" id="myModal_cancel" data-backdrop="static"
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
                    <button type="button" class="btn btn-confirm asset-close" data-dismiss="modal">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
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
            $('#creatNewAsset').click(function () { // 新建弹出模态框
                $('#myModal').modal('show');
            });
            $('#saveAssetClassify').click(function () {
                _this.saveCategory();
            })
            $('#closeAssetClassify').click(function () {
                _this.clearVal();
            })
            $('#editSaveAssetClassify').on('click', function () {
                _this.saveEditCategory($(this).attr('data-id'));
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
                info: false,
                dom: '', // 为空则隐藏所有的组件
                ajax: function (data, callback, settings) {
                    //封装请求参数
                    var param = {};
                    param.length = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                    // param.startIndex = data.start;//开始的记录序号
                    param.start = (data.start / data.length) + 1;//当前页码
                    param.draw = data.draw;
                    $.ajax({
                        type: "POST",
                        url: util.getServerUrl('/underlyingAsset/list'),
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
                lengthMenu: [[30], [30]],
                columns: [
                    {"data": 'grade'},
                    {"data": 'descption'},
                    {
                        "data": null,
                        "render": function (data, type, row) {
                            return row.screenRate + '%';
                        }
                    },
                    {
                        "data": null,
                        "render": function (data, type, row) {
                            if (row.isDefault) {
                                return '<span onclick="table.editClassifyFunc(this)" class="edit-asset" data-id="' + row.id + '">编辑</span>';
                            } else {
                                return '<span onclick="table.editClassifyFunc(this)" class="edit-asset" data-id="' + row.id + '">编辑</span><span onclick="table.delClassifyFunc(this)" class="del-asset" data-id="' + row.id + '">删除</span>';
                            }

                        }
                    }
                ],
                initComplete: function (setting, json) {
                    _this.renderGrade();
                },
                drawCallback: function (setting) {

                }

            })
        },
        // 生成大写字母下拉选择
        renderGrade: function () {
            var ch_big = 'A';
            var str = '<option value="">-请选择-</option>';
            for (var i = 0; i < 26; i++) {
                str += '<option value="' + String.fromCharCode(ch_big.charCodeAt(0) + i) + '">' + String.fromCharCode(ch_big.charCodeAt(0) + i) + '</option>'
            }
            $('#assetGrade').html(str);
            $('#assetGradeEdit').html(str);
        },
        // 保存分类
        saveCategory: function () {
            var _this = this;
            var params = {
                grade: $('#assetGrade').val(),
                descption: $.trim($('#assetRemark').val()),
                screenRate: $.trim($('#assetScale').val()),
            };
            if (params.grade == '') {
                changeMsg('请选择级别');
                return;
            }
            else if (params.descption == '') {
                changeMsg('请填写说明');
                return;
            }
            else if (params.screenRate == '') {
                changeMsg('请填写筛选比例');
                return;
            } else {
                if (!util.validate(params.screenRate, 'number')) {
                    changeMsg('筛选比例必须为数字');
                    return;
                }
            }
            $.ajax({
                url: util.getServerUrl('/underlyingAsset/create'),
                data: params,
                method: 'POST',
                headers: {"X-Requested-With": "XMLHttpRequest"},
                beforeSend: function () {
                    $('#myModal span.error-msg').text('').removeClass('show-msg');
                },
                success: function (res) {
                    if (res.status == 0) {
                        $('#myModal').modal('hide');
                        _this.clearVal();
                        _this.defTable.draw();
                    } else {
                        changeMsg(res.msg);
                    }
                },
                error: function (error) {

                }

            })

            function changeMsg(str) {
                $('#myModal span.error-msg').text(str).addClass('show-msg');
            }
        },
        // 清空弹框value值
        clearVal: function () {
            $('#assetGrade').val('');
            $('#assetRemark').val('');
            $('#assetScale').val('');
        },
        // 保存修改的分类
        saveEditCategory: function (id) {
            var _this = this;
            var params = {
                grade: $('#assetGradeEdit').val(),
                descption: $.trim($('#assetRemarkEdit').val()),
                screenRate: $.trim($('#assetScaleEdit').val()),
                id: id
            };
            if (params.grade == '') {
                changeMsg('请选择级别');
                return;
            }
            else if (params.descption == '') {
                changeMsg('请填写说明');
                return;
            }
            else if (params.screenRate == '') {
                changeMsg('请填写筛选比例');
                return;
            } else {
                if (!util.validate(params.screenRate, 'number')) {
                    changeMsg('筛选比例必须为数字');
                    return;
                }
                if (!/^\d+$/.test(params.screenRate)) {
                    changeMsg('筛选比例必须为正整数 ');
                    return;
                }
            }
                $.ajax({
                    url: util.getServerUrl('/underlyingAsset/update'),
                    data: params,
                    method: 'POST',
                    headers: {"X-Requested-With": "XMLHttpRequest"},
                    beforeSend: function () {
                        $('#myModal_edit span.error-msg').text('').removeClass('show-msg');
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            $('#myModal_edit').modal('hide');
                            _this.defTable.draw();
                            $('#editSaveAssetClassify').attr('data-id', null);
                        } else {
                            changeMsg(res.msg);
                        }
                    },
                    error: function (error) {

                    }

                })

                function changeMsg(str) {
                    $('#myModal_edit span.error-msg').text(str).addClass('show-msg');
                }
            },
            // 删除分类请求
            delClassify : function (id) {
                var _this = this;
                $.ajax({
                    url: util.getServerUrl('/underlyingAsset/delete?id=' + id),
                    method: 'POST',
                    success: function (res) {
                        if (res.status == 0) {
                            _this.defTable.draw();
                        } else {
                            if (res.msg == '') {
                                _this.alertModelCancel('删除出错，请稍后重试!')
                            } else {
                                _this.alertModelCancel(res.msg);
                            }
                        }
                    },
                    error: function (error) {
                        _this.alertModelCancel('删除出错，请稍后重试!')
                    }
                })
            }
        ,
            // 删除分类方法
            delClassifyFunc : function (dom) {
                var id = $(dom).data('id');
                var _this = this;
                this.alertModel('确认要删除吗?');
                $('#confirmDel').off('click').on('click', function () {
                    _this.delClassify(id);
                    $('#myModal_confirm').modal('hide');
                });
            }
        ,
            // 编辑分类发请求并填数据
            editClassify : function (id) {
                var _this = this;
                $.ajax({
                    url: util.getServerUrl('/underlyingAsset/get?id=' + id),
                    method: 'GET',
                    headers: {"X-Requested-With": "XMLHttpRequest"},
                    success: function (res) {
                        if (res.status == 0) {
                            $('#assetGradeEdit').val(res.data.grade);
                            $('#assetRemarkEdit').val(res.data.descption);
                            $('#assetScaleEdit').val(res.data.screenRate);
                            $('#editSaveAssetClassify').attr('data-id', id);
                        } else {
                            _this.alertModelCancel('信息读取出错，请稍后重试!');
                        }
                    },
                    error: function (error) {
                        _this.alertModelCancel('信息读取出错，请稍后重试!')
                    }
                })
            }
        ,
            // 编辑分类方法
            editClassifyFunc : function (dom) {
                var id = $(dom).data('id');
                this.editClassify(id);
                $('#myModal_edit').modal('show');
            }
        ,
            // 模态框弹出
            alertModel: function (str) {
                $('#myModal_confirm .modal-body').empty().html('<p>' + str + '</p>');
                $('#myModal_confirm').modal('show');
            }
        ,
            // 取消模态框
            alertModelCancel : function (str) {
                $('#myModal_cancel .modal-body').empty().html('<p>' + str + '</p>');
                $('#myModal_cancel').modal('show');
            }
        }
        $(function () {
            table.init();
        }
    )

</script>