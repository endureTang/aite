<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<style>
    .table>tbody+tbody {
        border-top: none;
    }
</style>
<div class="container-fluid" id="repayStatistics">
    <section class="content">
        <div class="row toolbar">
            <div class="col-xs-12">
                <span class="desc-name">
                    统计范围
                </span>
                <input type='text' class='form-control' id='beginYear' name='beginYear' value='' placeholder="请选择开始年">
                <input type='text' class='form-control' id='beginMonth' name='beginMonth' value='' placeholder="请选择开始月">
                -
                <input type='text' class='form-control' id='endYear' name='endYear' value='' placeholder="请选择结束年">
                <input type='text' class='form-control' id='endMonth' name='endMonth' value='' placeholder="请选择结束月">
                <button @click="searchList" class="btn" id="searchTable">筛选</button>
                <a data-toggle="tooltip" data-placement="right" title="单次导出不能超过1万条" id="exportList"
                   href="javascript:;" class="btn btn-success" @click="exportList">导出列表</a>
            </div>
            <div class="col-xs-12" style="background: #fff;margin-bottom: 10px;">
                <span class="desc-name">
                    统计产品
                </span>
                <div class="product-list">
                    <label>全部: <input v-model="checkedAll" @change="changeAllChecked()" type="checkbox"></label>
                    <c:forEach var="product" items="${listProduct}">
                        <label>${product.productName} <input type="checkbox" name="product" v-model="productIds"
                                                             value="${product.id}"></label>&nbsp;
                    </c:forEach>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table">
                            <thead>
                            <tr>
                                <th>月份</th>
                                <th>产品名</th>
                                <th>应收本金</th>
                                <th>应收利息</th>
                                <th>应还罚息</th>
                                <th>应还渠道费</th>
                                <th>应还居间费</th>
                                <th>应收总额</th>
                                <th>实收本金</th>
                                <th>实收利息</th>
                                <th>实收罚息</th>
                                <th>实收居间费</th>
                                <th>实收渠道费</th>
                                <th>实收总额</th>
                            </tr>
                            </thead>
                            <tbody v-show="productList.length==0">
                            <tr>
                                <td style="text-align: center" colspan="14">无内容</td>
                            </tr>
                            </tbody>
                            <tbody v-for="(list,listIndex) in productList" v-show="productList.length>0">
                            <tr v-for="(item,index) in list[productKeys[listIndex]]">
                                <td v-if="index==0" :rowspan="list[productKeys[listIndex]].length">{{item.statisticsDate}}</td>
                                <td>{{item.productName}}</td>
                                <td>{{item.planCapital}}</td>
                                <td>{{item.planInterest}}</td>
                                <td>{{item.planPenaltyInterest}}</td>
                                <td>{{item.planChannelFee}}</td>
                                <td>{{item.planMediacyFee}}</td>
                                <td>{{item.planAmount}}</td>
                                <td>{{item.accCapital}}</td>
                                <td>{{item.accInterest}}</td>
                                <td>{{item.accPenaltyInterest}}</td>
                                <td>{{item.accMediacyFee}}</td>
                                <td>{{item.accChannelFee}}</td>
                                <td>{{item.accAmount}}</td>
                            </tr>
                            </tbody>

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
<script src="static/plugins/vue/vue.min.js"></script>
<script>
    var table = {
        vm: {},
        init: function () {
            this.newVue()
            this.renderPickTime()
        },
        newVue: function () {
            this.vm = new Vue({
                el: '#repayStatistics',
                data: {
                    checkedAll: false,
                    productIds: [],
                    ids: [],
                    productList: []
                },
                computed: {
                    productKeys: function () {
                        var keys = []
                        this.productList.forEach(function (item) {
                            keys.push(Object.keys(item)[0])
                        })
                        return keys
                    }
                },
                mounted: function () {
                    var _this = this;
                    $('input[name="product"]').each(function (key, item) {
                        _this.ids.push($(item).val())
                    })
                },
                methods: {
                    changeAllChecked() {
                        this.productIds = this.checkedAll ? this.ids : []
                    },
                    searchList() {
                        var _this = this;
                        var params = {
                            productIds: this.productIds.join(','),
                            beginYear: Number($('#beginYear').val()),
                            beginMonth: Number($('#beginMonth').val()),
                            endYear: Number($('#endYear').val()),
                            endMonth: Number($('#endMonth').val())
                        }
                        for (var key in params) {
                            if (!params[key]) {
                                table.alertModelCancel('请选择统计时间和统计产品!');
                                return;
                            }
                        }
                        if (params.beginYear > params.endYear) {
                            table.alertModelCancel('开始年不能大于结束年!');
                            return;
                        }
                        if (params.beginMonth > params.endMonth) {
                            table.alertModelCancel('开始月不能大于结束月!');
                            return;
                        }
                        $.ajax({
                            url: util.getServerUrl('/repayStatistics/getRepayStatistics'),
                            method: 'POST',
                            data: params,
                            success: function (res) {
                                if (res.status == 0) {
                                    _this.productList = res.data
                                } else {
                                    table.alertModelCancel(res.msg);
                                }
                            },
                            error: function (error) {
                                table.alertModelCancel(error);
                            }
                        })
                    },
                    exportList() {
                        // 导出
                        var params = {
                            productIds: this.productIds.join(','),
                            beginYear: Number($('#beginYear').val()),
                            beginMonth: Number($('#beginMonth').val()),
                            endYear: Number($('#endYear').val()),
                            endMonth: Number($('#endMonth').val())
                        }
                        window.open('<%=basePath%>repayStatistics/exportStatistics?' + jQuery.param(params, true));
                    }
                },
                watch: {
                    productIds: function (value) {
                        this.checkedAll = value.length === this.ids.length ? true : false
                    }
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
            var beginYear = new Pikaday({
                field: $('#beginYear')[0],
                i18n: i18n,
                format: 'YYYY',
            });
            var beginMonth = new Pikaday({
                field: $('#beginMonth')[0],
                i18n: i18n,
                format: 'M',
            });
            var endYear = new Pikaday({
                field: $('#endYear')[0],
                i18n: i18n,
                format: 'YYYY',
            });
            var endMonth = new Pikaday({
                field: $('#endMonth')[0],
                i18n: i18n,
                format: 'M',
            });
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