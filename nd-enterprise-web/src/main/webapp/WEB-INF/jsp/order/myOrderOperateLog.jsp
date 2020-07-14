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
<%
String orderId = request.getParameter("orderId") ;
%>
<style>
    [v-cloak] {
        display: none !important;
    }
</style>
<link rel="stylesheet" href="static/plugins/magnify/jquery.magnify.min.css">
<link rel="stylesheet" href="static/css/my-order.css">
<div class="container-fluid">
    <jsp:include page="./orderSteps.jsp"></jsp:include>
    <div class="tab-con">
        <div>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist" id="myTabs">
                <li><a href="<%=basePath%>loanOrder/myOrderBaseInfoPage?orderId=<%=orderId%>" aria-controls="one" role="tab" data-toggle="tab" data-target="navTab">基础信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderCreditInfoPage?orderId=<%=orderId%>" aria-controls="two" role="tab" data-toggle="tab"  data-target="navTab">信用信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderInvestigatePage?orderId=<%=orderId%>" aria-controls="three" role="tab" data-toggle="tab"  data-target="navTab">业务调查</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderBusinessApprovePage?orderId=<%=orderId%>" aria-controls="fore" role="tab" data-toggle="tab"  data-target="navTab">业务审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderContractsPage?orderId=<%=orderId%>" aria-controls="five" role="tab" data-toggle="tab"  data-target="navTab">合同管理</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderLoanApprovePage?orderId=<%=orderId%>" aria-controls="six" role="tab" data-toggle="tab"  data-target="navTab">放款审批</a></li>
                <li class="active"><a href="<%=basePath%>loanOrder/myOrderOperateLogPage?orderId=<%=orderId%>" aria-controls="seven" role="tab" data-toggle="tab"  data-target="navTab">操作日志</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane active" id="seven">
                    <!--操作日志-->
                    <div class="panel panel-info operation-log">
                        <div class="panel-heading">
                            <h3 class="panel-title">订单操作记录</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <table class="table operation-log-table">
                                <thead>
                                <tr>
                                    <th>操作环节</th>
                                    <th>订单状态</th>
                                    <th>操作时间</th>
                                    <th>操作人</th>
                                    <th>操作结果</th>
                                    <th>备注</th>
                                </tr>
                                </thead>
                                <tbody id="operateLog">
                                <tr>
                                    <td>--</td>
                                    <td>--</td>
                                    <td>--</td>
                                    <td>--</td>
                                    <td>--</td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="myModal" data-backdrop="static" data-keyboard="false">
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
<script src="static/plugins/vue/vue.min.js"></script>
<script src="<%=basePath%>static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=basePath%>static/js/jquery.jqprint-0.3.js"></script>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script src="<%=basePath%>static/js/myOrderCommon.js"></script>
<script>
    $(function () {
        myOrderTpl.init({
            orderId: '<%=orderId%>',
            keyword : '',
            orderStatus :'',
            period :'',
            createDate :'',
            start : '',
            basePath : '<%=basePath%>'
        });
    })
</script>
<script>
    var operateLog = (function () {

        return {
            init : function () {
                this.renderOperateHtml();
            },
            // 操作日志渲染
            renderOperateHtml: function () {
                var _this = this;
                $.ajax({
                    url: util.getServerUrl('/loanOrder/getOrderOperateLog'),
                    method : 'POST',
                    data : {orderId:'<%=orderId%>'},
                    success: function (res) {
                        var tbody = $('#operateLog'),
                            str = '',
                            orderLogInfo = res.data.orderLogInfo;
                        if (res.status == 0) {
                            if (orderLogInfo.length != 0) {
                                for (var i = 0; i < orderLogInfo.length; i++) {
                                    str += '<tr>';
                                    str += '<td>' + _this.optimizeVal(orderLogInfo[i].processName) + '</td>';
                                    str += '<td>' + _this.optimizeVal(orderLogInfo[i].updateStatusName) + '('+_this.optimizeVal(orderLogInfo[i].updateStatus)+')' + '</td>';
                                    str += '<td>' + _this.optimizeVal(myOrderTpl.tool.formatTime(orderLogInfo[i].updateDate)) + '</td>';
                                    str += '<td>' + _this.optimizeVal(orderLogInfo[i].userName) + '</td>';
                                    str += '<td>' + _this.optimizeVal(orderLogInfo[i].updateStatusName) + '</td>';
                                    str += '<td>' + _this.optimizeVal(orderLogInfo[i].remark) + '</td>';
                                    str += '</tr>';
                                }
                                tbody.html(str);
                            }
                        } else {
                            if (res.msg == '') {
                                myOrderTpl.alertModel('操作日志获取失败，请稍后重试!');
                            } else {
                                myOrderTpl.alertModel(res.msg);
                            }
                            ;
                        }
                    },
                    error: function (error) {
                        myOrderTpl.alertModel('操作日志获取失败，请稍后重试!');
                    }
                })
            },
            // 如果传入为空则返回空否则为该值
            optimizeVal: function (value) {
                return value ? value : '';
            },

        }
    })()
    $(function () {
        operateLog.init();
    })
</script>