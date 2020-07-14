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
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix h30"></div>

                <div class="panel panel-default channel-edit">
                    <div class="panel-heading">
                        <h3 class="panel-title" id="channelTitle">绑定账户</h3>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>
                                <i class="con-name">绑定平台账户:</i>
                                <input type="text" class="form-control" id="bindAccount"
                                       placeholder="请输入天府财富账户">
                            </li>
                            <li>
                                <i class="con-name">收款账户:</i>
                                <div class="account">
                                    <button class="btn btn-primary" id="bindRepee">绑定</button>
                                    <button class="btn btn-default" id="unbindRepee">解绑</button>
                                    <span id="repeeName" class="red-tag"></span>
                                </div>
                            </li>
                            <li>
                                <i class="con-name">还款账户:</i>
                                <div class="account">
                                    <button class="btn btn-primary" id="bindRepay">绑定</button>
                                    <button class="btn btn-default" id="unbindRepay">解绑</button>
                                    <span id="repayName" class="red-tag"></span>
                                </div>
                            </li>
                        </ul>
                        <button class="btn btn-primary" id="backToList">返回列表</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
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
<script type="text/javascript">
    var channel = {
        init: function () {
            this.renderHtml();
            this.bindEvent();
        },
        variable: {
            channelId: '${channelId}',
            repayId: '${repayId}',
            repayName: '${repayName}',
            repeeId: '${repeeId}',
            repeeName: '${repeeName}',
        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击返回列表
            $('#backToList').click(function () {
                $('#navTab').load('<%=basePath%>channel/list');
            })
            // 点击收款账户绑定
            $('#bindRepee').click(function () {
                _this.bindAccount(1);
            })
            // 点击还款账户绑定
            $('#bindRepay').click(function () {
                _this.bindAccount(2);
            })
            // 点击收款账户解绑
            $('#unbindRepee').click(function () {
                _this.unbindAccount(2);
            })
            // 点击还款账户解绑
            $('#unbindRepay').click(function () {
                _this.unbindAccount(1);
            })
        },
        // 账户绑定
        bindAccount: function (type) {
            var _this = this;
            var params = {
                username: $.trim($('#bindAccount').val()),
                select: type,
                channelId: _this.variable.channelId,
            };
            if (type == 1) {
                params.repeeId = _this.variable.repeeId;
            }
            if (type == 2) {
                params.repayId = _this.variable.repayId;
            }
            $.ajax({
                url: util.getServerUrl('/channel/bindTFCFChannel'),
                data: params,
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        // 根据type给收款人还款人id赋值
                        type == 1 ? _this.variable.repeeId = res.data.userId : _this.variable.repayId = res.data.userId;
                        // 页面展示
                        type == 1 ? $('#repeeName').text(params.username) : $('#repayName').text(params.username);
                        // 判断按钮状态
                        _this.judgeBtn();
                        _this.alertModel('绑定成功!');
                        setTimeout(function () {
                            $('#myModal').modal('hide');
                        }, 1000)
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('绑定失败，请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('绑定失败，请稍后重试!');
                }
            })
        },
        // 解绑账户
        unbindAccount: function (type) {
            var _this = this;
            var params = {
                reId: type == 1 ? _this.variable.repayId : _this.variable.repeeId,
                type: type,
                channelId: _this.variable.channelId,
            };
            $.ajax({
                url: util.getServerUrl('/channel/unbind'),
                data: params,
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        // 根据type给收款人还款人id清空
                        type == 1 ? _this.variable.repayId = '' : _this.variable.repeeId = '';
                        // 页面展示
                        type == 1 ? $('#repayName').text('未绑定') : $('#repeeName').text('未绑定');
                        // 判断按钮状态
                        _this.judgeBtn();
                        _this.alertModel('解绑成功!');
                        setTimeout(function () {
                            $('#myModal').modal('hide');
                        }, 1000)
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('解绑失败，请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('解绑失败，请稍后重试!');
                }
            })
        },
        // 渲染页面
        renderHtml: function () {
            $('#repeeName').text(this.variable.repeeName == '' ? '未绑定' : this.variable.repeeName);// 收款账户
            $('#repayName').text(this.variable.repayName == '' ? '未绑定' : this.variable.repayName);// 还款账户
            this.judgeBtn();
        },
        // 判断绑定解绑按钮可用状态
        judgeBtn: function () {
            var bindRepee = $('#bindRepee'),
                unbindRepee = $('#unbindRepee'),
                bindRepay = $('#bindRepay'),
                unbindRepay = $('#unbindRepay');
            if (this.variable.repeeId=='') { // 收款人未绑定
                unbindRepee.attr('disabled', true);
                bindRepee.removeAttr('disabled');
            } else {
                bindRepee.attr('disabled', true);
                unbindRepee.removeAttr('disabled');
            }
            if (this.variable.repayId=='') { // 还款人未绑定
                unbindRepay.attr('disabled', true);
                bindRepay.removeAttr('disabled');
            } else {
                bindRepay.attr('disabled', true);
                unbindRepay.removeAttr('disabled');
            }
        },
        // 模态框弹出
        alertModel: function (str) {
            $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#myModal').modal('show');
        },
    }
    $(document).ready(function () {
        channel.init();
    })

</script>







