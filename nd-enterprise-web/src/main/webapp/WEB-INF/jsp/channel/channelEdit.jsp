<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                        <h3 class="panel-title" id="channelTitle"></h3>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>
                                <i class="con-name">渠道名称:</i>
                                <input type="text" maxlength="50" class="form-control" id="channelName" placeholder="请输入不超过50个字符">
                            </li>
                            <li>
                                <i class="con-name">渠道编码:</i>
                                <input type="text" class="form-control" id="channelCode" disabled placeholder="系统生成4位数渠道编码">
                                <button class="btn btn-primary" id="creatCode">生成渠道编码</button>
                            </li>
                            <li>
                                <i class="con-name">分配渠道管理客户经理:</i>
                                <select name="" id="userInfos" class="form-control">
                                    <option value="">-请选择-</option>
                                    <c:forEach items="${userInfos}" var="comPerson">
                                        <option <c:if test="${comPerson.id == userInfoId}">selected</c:if> value="${comPerson.id}">${comPerson.userName}</option>
                                    </c:forEach>
                                </select>
                            </li>
                            <li>
                                <i class="con-name">每日接收资产上限设置:</i>
                                <input type="number" class="form-control" id="fundsLimit" placeholder="请输入预设值"> &nbsp;&nbsp;元
                            </li>
                            <!--<li>-->
                                <!--<i class="con-name">渠道类型:</i>-->
                                <!--<select name="" id="channelType" class="form-control">-->
                                    <!--<option value="">-请选择-</option>-->
                                    <!--<option value="1">进件渠道</option>-->
                                    <!--<option value="2">资金渠道</option>-->
                                <!--</select>-->
                            <!--</li>-->
                            <li>
                                <i class="con-name">备注:</i>
                                <textarea class="form-control" rows="4" id="remark">${remark}</textarea>
                            </li>
                            <li>
                                <i class="con-name">状态</i>
                                <label for="delFlag01">
                                    <input value="0" <c:if test="${delFlag == false}">checked</c:if> type="radio" name="delFlag" id="delFlag01">启用
                                </label>
                                <label for="delFlag02">
                                    <input value="1" <c:if test="${delFlag == true}">checked</c:if>  type="radio" name="delFlag" id="delFlag02">冻结
                                </label>
                            </li>
                        </ul>
                        <button class="btn btn-primary" id="saveChannel">保存</button>
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
            channelName: '${channelName}',
            channelCode: '${channelCode}',
            channelId: '${id}',
            // channelType: '${channelType}',
            fundsLimit: '${fundsLimit}'
        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击保存
            $('#saveChannel').click(function () {
                _this.saveChannel();
            })
            // 生成渠道编码
            $('#creatCode').click(function () {
                _this.creatCode();
            })
        },
        // 保存渠道编辑
        saveChannel: function () {
            var _this = this;
            var params = {
                name: $.trim($('#channelName').val()),
                id: _this.variable.channelId,
                companyId: '',
                code: $.trim($('#channelCode').val()),
                // type: $.trim($('#channelType').val()),
                remark: $.trim($('#remark').val()),
                fundsLimit: $.trim($('#fundsLimit').val()),
                userInfoId : $('#userInfos').val(),
                delFlag : this.getCheckboxItem('delFlag')[0]
            };
            if (params.name == '') {
                _this.alertModel('请输入渠道名称!');
                return;
            }
            if (params.code == '') {
                _this.alertModel('请生成渠道编码!');
                return;
            }
            if (params.type == '') {
                _this.alertModel('请选择渠道类型!');
                return;
            }
            // if (params.fundsLimit == '' || params.fundsLimit < 0) {
            //     _this.alertModel('请输入正确的每日接收资产上限设置!');
            //     return;
            // }
            $.ajax({
                url: util.getServerUrl('/channel/create'),
                data: params,
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        _this.alertModel('保存成功!');
                        setTimeout(function () {
                            $('#myModal').modal('hide');
                        }, 1000)
                        $('#myModal').on('hidden.bs.modal', function (e) {
                            $('#navTab').load('<%=basePath%>channel/list');
                        })
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('保存失败，请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('保存失败，请稍后重试!');
                }
            })
        },
        // 渲染页面
        renderHtml: function () {
            $('#channelTitle').text(this.variable.channelId == '' ? '新建渠道' : '渠道编辑');
            if (this.variable.channelCode) {
                $('#creatCode').hide();
            }
            $('#channelName').val(this.variable.channelName);
            $('#channelCode').val(this.variable.channelCode);
            // $('#channelType').val(this.variable.channelType);
            $('#fundsLimit').val(this.variable.fundsLimit);
            this.iCheckRadio();
        },
        // 渲染radio
        iCheckRadio : function(){
          $('input[name="delFlag"]') .iCheck({
              radioClass: 'iradio_minimal-blue'
          })
        },
        // 获取checkbox值
        getCheckboxItem: function (checkBoxName) {
            var arr = [];
            var ids = $('input[name="' + checkBoxName + '"]');
            ids.each(function () {
                if (this.checked) {
                    arr.push(this.value);
                }
            })
            return arr;
        },
        // 生成渠道编码
        creatCode: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/channel/generateChannelCode'),
                method: 'POST',
                beforeSend: function () {
                    $('#creatCode').attr('disabled', true);
                },
                complete: function () {
                    $('#creatCode').removeAttr('disabled');
                },
                success: function (res) {
                    if (res.status == 0) {
                        $('#channelCode').val(res.data);
                        $('#creatCode').attr('disabled', true);
                    } else {
                        _this.alertModel('生成渠道编码出错');
                    }
                },
                error: function (error) {
                    _this.alertModel('生成渠道编码出错');
                }
            })
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







