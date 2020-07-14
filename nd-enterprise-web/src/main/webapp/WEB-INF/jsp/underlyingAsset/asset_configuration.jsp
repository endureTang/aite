
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
                <input id="search" class="form-control" type="text" placeholder="产品名称、资产类别">
                <button class="btn" id="searchTable">筛选</button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix">
                    <select name="" id="batchRiskGrade" class="form-control risk-grade"></select>
                    <button class="btn btn-primary pull-right" id="saveAsset">保存</button>
                </div>
                <div class="box">
                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table asset-table">
                            <thead>
                            <tr>
                                <th>
                                    <input type='checkbox' id="allCheck"/>
                                    序号
                                </th>
                                <th>产品名称</th>
                                <th>费率</th>
                                <th>期数</th>
                                <th>资产类别</th>
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
    <div class="modal fade asset-classify" tabindex="-1" role="dialog" id="myModal" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body text-center">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-confirm" data-dismiss="modal">确认</button>
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
        // 记录每次请求回来的数据
        cbData : {},
        // 保存下拉框数据
        selData : {},
        init: function () {
            this.renderTable();
            this.bindEvent();
        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            $('#saveAsset').click(function () { // 新建弹出模态框
                _this.saveAsset();
            });
            // 点击筛选按钮重绘表格
            $('#searchTable').on('click', function () {
                _this.tableParams = {
                    keyword: $.trim($('#search').val()) == '' ? null : $.trim($('#search').val())
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
                info: false,
                ajax: function (data, callback, settings) {
                    //封装请求参数
                    var param = {};
                    param.length = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                    // param.startIndex = data.start;//开始的记录序号
                    param.start = (data.start / data.length) + 1;//当前页码
                    param.draw = data.draw;
                    $.ajax({
                        type: "POST",
                        url: util.getServerUrl('/underlyingAsset/listProductGrade'),
                        data: $.extend(param, _this.tableParams),  //传入组装的参数
                        dataType: "json",
                        success: function (result) {
                            //封装返回数据
                            var returnData = {};
                            returnData.draw = result.draw; //返回了draw计数器
                            returnData.recordsTotal = result.recordsTotal;//返回数据全部记录
                            returnData.recordsFiltered = result.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
                            returnData.data = result.data;//返回的数据列表
                            _this.cbData = returnData; // 将返回的数据保存
                            callback(returnData);
                        }
                    })
                },
                language: {
                    url: "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
                },
                lengthMenu: [[10, 20, 30], [10, 20, 30]],
                columns: [
                    {
                        "data": null,
                        "render": function (data, type, row, meta) {
                            return "<input data-index='"+meta.row+"' type='checkbox' name='chx_default' value='" + data.id + "'/>" + (meta.row + 1);
                        }
                    },
                    {"data": 'product_name'},
                    {"data": 'fee'},
                    {"data": 'label_text'},
                    {
                        "data": null,
                        "render": function (data, type, row) {
                            return '<select class="form-control risk-grade risk-grade-spe" data-id="' + row.id + '"></select>';
                        }
                    }
                ],
                initComplete: function (setting, json) {
                    // console.log(json.data);   // 返回的数据
                    _this.renderSelect(function (data) {
                        _this.renderSelsectHtml(data);
                        $.each(json.data,function (k, v) {
                            $('.risk-grade-spe').eq(k).val(v.grade==''?'O':v.grade);
                        })
                    });
                },
                drawCallback: function (setting) {
                    drawICheck('allCheck', 'chx_default');
                    _this.renderSelsectHtml(_this.selData);
                    $.each(_this.cbData.data,function (k, v) {
                        $('.risk-grade-spe').eq(k).val(v.grade==''?'O':v.grade);
                    })
                }

            })
        },
        // 获取checkbox值
        getCheckboxItem: function (checkBoxName) {
            var arr = [];
            var ids = $('.my-table input[name="' + checkBoxName + '"]');
            ids.each(function (k,v) {
                if (this.checked) {
                    arr.push({index:k,value:this.value});
                }
            })
            return arr;
        },
        // 渲染下拉框
        renderSelect: function (cb) {
            var _this = this;
            $.ajax({
                type: "POST",
                url: util.getServerUrl('/underlyingAsset/listDistinctGrade'),
                success: function (res) {
                    if (res.status == 0) {
                        _this.selData = res.data;
                        cb&&cb(res.data);
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('获取资产等级下拉框失败,请稍后重试!')
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('获取资产等级下拉框失败,请稍后重试!')
                }
            })
        },
        renderSelsectHtml : function(data){
            var str = '';
            $.each(data, function (k, v) {
                str += '<option value="' + v + '">' + v + '</option>';
            })
            $('.risk-grade').html(str);
        },
        // 保存分类
        saveAsset: function () {
            var value = this.getCheckboxItem('chx_default');
            if (value.length == 0) {
                this.alertModel('请至少选择一条进行配置');
            } else if (value.length == 1) { // 只选了一条
                var params = {
                    id: value[0].value,
                    grade: $('.risk-grade-spe').eq(value[0].index).val(),
                    index : value[0].index
                };
                this.saveAssetAjax(params);
            } else { // 选了多条
                var arr = [];
                // $.each(value,function (k,v) { // 保存不同的select值
                //     arr.push({id:v.value,grade:$('.risk-grade-spe').eq(v.index).val()})
                // })
                $.each(value,function (k,v) { // 保存相同的select值
                    arr.push({id:v.value,grade:$('#batchRiskGrade').val(),index:v.index})
                })
                this.saveBatchAssetAjax(arr);
            }
        },
        // 单独保存分类请求
        saveAssetAjax : function (params) {
            var _this = this;
            $.ajax({
                type: "POST",
                url: util.getServerUrl('/underlyingAsset/changeProductGrade?productCycleId='+params.id+'&grade='+params.grade),
                success: function (res) {
                    if (res.status == 0) {
                        $('.risk-grade-spe').eq(params.index).val(params.grade);
                        _this.alertModel('保存资产分类成功!');
                        $('#myModal').on('hidden.bs.modal', function (e) {
                            $('input[name="chx_default"]').iCheck('uncheck');
                            // $('#navTab').load('<%=basePath%>underlyingAsset/listProductGrade');
                        })
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('保存资产分类失败,请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('保存资产分类失败,请稍后重试!');
                }
            })
        },
        // 批量保存分类请求
        saveBatchAssetAjax : function (params) {
            var _this = this;
            $.ajax({
                type: "POST",
                url: util.getServerUrl('/underlyingAsset/batchChangeProductGrade'),
                data : {'productGradeJson':JSON.stringify(params)},
                success: function (res) {
                    if (res.status == 0) {
                        var totalVal = $('#batchRiskGrade').val();
                        var opts = $('.risk-grade-spe');
                        $.each(params,function (k,v) {
                            opts.eq(v.index).val(totalVal);
                        })
                        _this.alertModel('保存资产分类成功!');
                        $('#myModal').on('hidden.bs.modal', function (e) {
                            $('input[name="chx_default"]').iCheck('uncheck');
                            // $('#navTab').load('<%=basePath%>underlyingAsset/listProductGrade');

                        })
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('保存资产分类失败,请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('保存资产分类失败,请稍后重试!');
                }
            })
        },
        // 模态框弹出
        alertModel: function (str) {
            $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#myModal').modal('show');
        },


    }
    $(function () {
        table.init();
    })

</script>