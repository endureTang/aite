<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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

    #mask_loading {
        position: fixed;
        left: 0;
        top: 0;
        right: 0;
        bottom: 0;
        background-color: rgba(0, 0, 0, 0.5);
        z-index: 999;
        display: none;
    }

    .loadEffect {
        width: 100px;
        height: 100px;
        position: absolute;
        left: 50%;
        top: 50%;
    }

    .loadEffect span {
        display: inline-block;
        width: 16px;
        height: 16px;
        border-radius: 50%;
        background: #fff;
        position: absolute;
        -webkit-animation: load 1.04s ease infinite;
    }

    @-webkit-keyframes load {
        0% {
            opacity: 1;
        }
        100% {
            opacity: 0.2;
        }
    }

    .loadEffect span:nth-child(1) {
        left: 0;
        top: 50%;
        margin-top: -8px;
        -webkit-animation-delay: 0.13s;
    }

    .loadEffect span:nth-child(2) {
        left: 14px;
        top: 14px;
        -webkit-animation-delay: 0.26s;
    }

    .loadEffect span:nth-child(3) {
        left: 50%;
        top: 0;
        margin-left: -8px;
        -webkit-animation-delay: 0.39s;
    }

    .loadEffect span:nth-child(4) {
        top: 14px;
        right: 14px;
        -webkit-animation-delay: 0.52s;
    }

    .loadEffect span:nth-child(5) {
        right: 0;
        top: 50%;
        margin-top: -8px;
        -webkit-animation-delay: 0.65s;
    }

    .loadEffect span:nth-child(6) {
        right: 14px;
        bottom: 14px;
        -webkit-animation-delay: 0.78s;
    }

    .loadEffect span:nth-child(7) {
        bottom: 0;
        left: 50%;
        margin-left: -8px;
        -webkit-animation-delay: 0.91s;
    }

    .loadEffect span:nth-child(8) {
        bottom: 14px;
        left: 14px;
        -webkit-animation-delay: 1.04s;
    }
</style>

<link rel="stylesheet" href="static/plugins/magnify/jquery.magnify.min.css">
<link rel="stylesheet" href="static/plugins/webuploader/webuploader.css">
<link rel="stylesheet" href="static/css/my-order.css">
<div class="container-fluid">
    <jsp:include page="./orderSteps.jsp"></jsp:include>
    <div class="tab-con">
        <div>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist" id="myTabs">
                <li><a href="<%=basePath%>loanOrder/myOrderBaseInfoPage?orderId=<%=orderId%>" aria-controls="one"
                       role="tab" data-toggle="tab" data-target="navTab">基础信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderCreditInfoPage?orderId=<%=orderId%>" aria-controls="two"
                       role="tab" data-toggle="tab" data-target="navTab">信用信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderInvestigatePage?orderId=<%=orderId%>" aria-controls="three"
                       role="tab" data-toggle="tab" data-target="navTab">业务调查</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderBusinessApprovePage?orderId=<%=orderId%>"
                       aria-controls="fore" role="tab" data-toggle="tab" data-target="navTab">业务审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderContractsPage?orderId=<%=orderId%>" aria-controls="five"
                       role="tab" data-toggle="tab" data-target="navTab">合同管理</a></li>
                <li class="active"><a href="<%=basePath%>loanOrder/myOrderLoanApprovePage?orderId=<%=orderId%>"
                                      aria-controls="six" role="tab" data-toggle="tab" data-target="navTab">放款审批</a>
                </li>
                <li><a href="<%=basePath%>loanOrder/myOrderOperateLogPage?orderId=<%=orderId%>" aria-controls="seven"
                       role="tab" data-toggle="tab" data-target="navTab">操作日志</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content" id="loanApprove" v-cloak>
                <div class="tab-pane active" id="six">
                    <!--上传图片-->
                    <div v-show="retList.length==1 && retList[0].processId == 31 && retList[0].showButton=='true'"
                         class="panel loan-upload panel-info contact-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">客户经理上传图片</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div id="fileUploadContent" class="fileUploadContent">
                                <div class="upload-control clearfix">
                                    <select name="uploadProve" id="uploadProve" class="form-control hide-dom">
                                        <option selected value="faceSignPic">放款凭证</option>
                                    </select>
                                    <div id="filePicker">选择图片</div>
                                    <button class="btn btn-success" id="uploadBtn">点击上传</button>
                                    <button class="btn btn-danger" id="clearBtn">清空列表</button>
                                </div>
                                <div id="fileList" class="uploader-list clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <!--显示图片-->
                    <div class="panel panel-info asset-images" :class="[attachmentList.length == 0 ? '' : 'show-dom']">
                        <div class="panel-heading">
                            <h3 class="panel-title">客户经理上传的图片</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <button v-if="retList.length==1 && retList[0].processId == 31 && retList[0].showButton=='true'"
                                    id="delPics" class="btn btn-danger pull-right">一键删除
                            </button>
                            <ul class="asset-prove clearfix">
                                <li v-for="picItem in attachmentList">
                                <span>
                                 <input type="checkbox" :value="picItem.attachId" name="attachPic">
                                <img data-magnify="gallery"
                                     :src="'<%=basePath%>/attachment/download?attachId=' + picItem.attachId"
                                     :data-src="'<%=basePath%>/attachment/download?attachId=' + picItem.attachId"
                                     alt="">
                                </span>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!--放款审批流程-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">放款审批流程</h3>
                        </div>
                        <div class="panel-body loan-process clearfix">
                            <form v-for="retListItem in retList">
                                <div class="loan-wrapper"
                                     :class="[retListItem.showButton === 'false' ? 'checked' : '']">
                                    <div class="loan-content" v-show="retListItem.editData != 0">
                                        <label class="relative">
                                            <i>贷款金额:</i>
                                            <input :value="retListItem.jsonObj.auditAmount" type="text"
                                                   class="form-control text-red" name="auditAmount"
                                            >
                                            <span id="toUpperMoney"></span>
                                        </label>
                                        <label>
                                            <i>贷款期限:</i>
                                            <select name="auditPeriod" class="form-control text-red">
                                                <option value="">-请选择贷款期限-</option>
                                                <option :selected="periodItem.periodId == retListItem.jsonObj.auditPeriod"
                                                        v-for="periodItem in periodList" :value="periodItem.periodId">
                                                    {{periodItem.periodValue}}
                                                </option>
                                            </select>
                                        </label>
                                        <label>
                                            <i>月利率:</i>
                                            <input :value="retListItem.jsonObj.auditRatingMonth" type="number"
                                                   class="form-control text-red"
                                                   oninput="if(value.length>8)value=value.slice(0,8)"
                                                   name="auditMonthRate">
                                        </label>
                                        <label>
                                            <i>还款方式:</i>
                                            <select class="form-control text-red" name="repayWay">
                                                <option value="">-请选择还款方式-</option>
                                                <option :selected="repayWayItem.processId == retListItem.jsonObj.repayWay"
                                                        v-for="repayWayItem in repayWayList"
                                                        :value="repayWayItem.processId">{{repayWayItem.processName}}
                                                </option>
                                            </select>
                                        </label>
                                        <div v-if="retListItem.showOrderFeeArea" class="fee">
                                            <ul>
                                                <li>
                                                    <span>金坤实际放款金额</span>
                                                    <input type="text" name="actualAmount" class="form-control"
                                                           :value="retListItem.jsonObj.actualAmount">
                                                </li>
                                                <li v-for="moneyItem in orderFeeList" class="order-fee-list">
                                                    <span :data-productid="moneyItem.productId"
                                                          :data-businessfeecode="moneyItem.code">{{moneyItem.name}}</span>
                                                    <input type="text" class="form-control" :value="moneyItem.amount">
                                                    <p>{{moneyItem.explain}}</p>
                                                </li>
                                                <li v-for="list in capticalChannelList" class="clearfix channel-wrap">
                                                    <div class="channel">
                                                        <span>资金渠道</span>
                                                        <input type="text" class="form-control form-control-s" readonly
                                                               :data-channelid="list.channelId"
                                                               :value="list.channelName"
                                                               :data-productid="list.productId">
                                                    </div>
                                                    <div class="channel-amount">
                                                        <span>资金渠道放款金额</span>
                                                        <input type="number" class="form-control form-control-s"
                                                               :value="list.amount">
                                                    </div>
                                                </li>
                                            </ul>
                                        </div>
                                        <div v-if="capticalChannelList.length > 0 && (retListItem.showButton === 'false' ? false : true)"
                                             class="bank-repayplan fee">
                                            <ul>
                                                <li>
                                                    <span>银行回款计划</span>
                                                    <input v-if="retListItem.processId == 31" type="file" id="file"
                                                           style="display: inline-block;border:none;">
                                                    <button id="uploadExcel" v-if="retListItem.processId == 31"
                                                            style="color: #fff;margin-bottom: 15px;margin-right: 15px;"
                                                            type="button" class="btn btn-print">上传
                                                    </button>
                                                    <button id="downloadExcel" v-if="retListItem.processId == 31"
                                                            style="color: #fff;margin-left: 115px;margin-right: 15px;"
                                                            type="button" class="btn btn-submit">模板下载
                                                    </button>
                                                    <button @click="showRepayPlan" :disabled="!!!showRepayPlanBtn"
                                                            style="color: #fff;" type="button" class="btn btn-success">
                                                        查看回款计划
                                                    </button>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="point"></div>
                                    <h2 class="process-title">{{retListItem.processName}}</h2>
                                    <span class="process-name"
                                          :class="[retListItem.showButton === 'false' ? 'pass' : '']"
                                          v-show="retListItem.processId == 31">{{retListItem.showButton === 'false' ? '已发起放款' : '待审核'}}</span>
                                    <span class="process-name"
                                          :class="[retListItem.showButton === 'false' ? 'pass' : '']"
                                          v-show="retListItem.processId != 31">{{retListItem.showButton === 'false' ? '已审核' : '待审核'}}</span>
                                    <!--<span class="process-time">2018-08-11 14:32:21</span>-->
                                    <div class="btns btns-pos"
                                         :class="[retListItem.processId == 31 || retListItem.processId == 36 || retListItem.processId == 37 ? isLeft : '',retListItem.processId == 37 ? isLefts : '']"
                                         v-show="retListItem.showButton === 'false' ? false : true">
                                        <span v-if="retListItem.processId == 31">
                                            <button type="button" class="btn btn-new btn-submit"
                                                    @click="passLoan($event,retListItem.processId)">
                                                发起放款流程
                                            </button>
                                        </span>
                                        <span v-else-if="retListItem.processId == 36">
                                            <button type="button" class="btn btn-new btn-submit" :class="[pos120]"
                                                    @click="passLoan($event,retListItem.processId)">
                                                同意放款
                                            </button>
                                        </span>
                                        <span v-else-if="retListItem.processId == 37">
                                            <button v-if="retListItem.showOnlinePayButton" type="button"
                                                    class="btn btn-new btn-submit"
                                                    @click="onLinePassLoan($event,retListItem.processId)">
                                                同意放款
                                            </button>
                                            <button v-if="retListItem.showOfflinePayButton&&capticalChannelList.length>0"
                                                    type="button" class="btn btn-new btn-submit"
                                                    @click="showDialog($event,retListItem.processId)">
                                                确认资金渠道已放款
                                            </button>
                                            <span v-if="!retListItem.showOfflinePayButton&&capticalChannelList.length>0"
                                                  class="btn btn-new btn-gray">
                                                资金渠道已确认放款
                                            </span>
                                        </span>
                                        <span v-else>
                                            <button type="button" class="btn btn-new btn-submit"
                                                    @click="passLoan($event,retListItem.processId)">
                                                同意
                                            </button>
                                            <button type="button" class="btn btn-new btn-refuse"
                                                    @click="refuse($event,retListItem.processId)">拒绝
                                            </button>
                                            <button type="button" class="btn btn-new btn-reject"
                                                    @click="reject($event,retListItem.processId)">驳回
                                            </button>
                                            <span>驳回至:</span>
                                            <select name="" id="" class="form-control">
                                                <option v-for="rejectToItem in reviewedList"
                                                        :value="rejectToItem.processId">
                                                {{rejectToItem.processName}}
                                                </option>
                                            </select>
                                        </span>
                                    </div>
                                    <!--输入框-->
                                    <div v-if="retListItem.processId == 31 && retListItem.editData != 0"
                                         class="input-wrap clearfix">
                                        <ul>
                                            <li>
                                                <span>业务部门</span>
                                                <input type="text" name="department" class="form-control"
                                                       :value="retListItem.jsonObj.department">
                                            </li>
                                            <li>
                                                <span>面签时间</span>
                                                <input id="faceSignTime" type="text" name="faceSignTime"
                                                       class="form-control" :value="retListItem.jsonObj.faceSignTime">
                                            </li>
                                            <li>
                                                <span>抵押登记办理人</span>
                                                <input type="text" name="pledgeTransact" class="form-control"
                                                       :value="retListItem.jsonObj.pledgeTransact">
                                            </li>
                                        </ul>
                                        <ul>
                                            <li>
                                                <span>录入意见</span>
                                                <textarea maxlength="100" class="form-control" rows="4"
                                                          name="loanCondition">{{retListItem.jsonObj.loanCondition}}</textarea>
                                            </li>
                                            <li>
                                                <span>时间</span>
                                                <input id="pledgeTransactT" type="text" name="pledgeTransactT"
                                                       class="form-control"
                                                       :value="retListItem.jsonObj.pledgeTransactT">
                                            </li>
                                        </ul>
                                    </div>
                                    <div v-if="retListItem.processId == 33 && retListItem.editData != 0"
                                         class="input-wrap clearfix">
                                        <ul>
                                            <li>
                                                <span>他权编号</span>
                                                <input type="text" name="pledgeNum" class="form-control"
                                                       :value="retListItem.jsonObj.pledgeNum">
                                            </li>
                                            <li>
                                                <span>他权领取人</span>
                                                <input id="heRightTransact" type="text" name="heRightTransact"
                                                       class="form-control"
                                                       :value="retListItem.jsonObj.heRightTransact">
                                            </li>
                                            <li>
                                                <span>国土证编号</span>
                                                <input type="text" name="landNum" class="form-control"
                                                       :value="retListItem.jsonObj.landNum">
                                            </li>
                                        </ul>
                                        <ul>
                                            <li>
                                                <span>不动产证明编号</span>
                                                <input type="text" name="estateProveNum" class="form-control"
                                                       :value="retListItem.jsonObj.estateProveNum">
                                            </li>
                                            <li>
                                                <span>时间</span>
                                                <input id="heRightTransactT" type="text" name="heRightTransactT"
                                                       class="form-control"
                                                       :value="retListItem.jsonObj.heRightTransactT">
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!--手动扣款按钮-->
                    <div class="control">
                        <div>
                            <button v-if="showPaymentByPersonButton" style="margin-left: 50px;"
                                    class="btn btn-submit btn-new" id="auditPass" @click="personPaypal">手动扣款
                            </button>
                            <a href="<%=basePath%>loanApprovePrint.html?orderId=<%=orderId%>" target="_blank"
                               class="btn btn-print btn-new">打印</a>
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
    <!--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="mySuccessModal" data-backdrop="static"
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
                    <button type="button" class="btn btn-confirm" data-dismiss="modal">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!--确认是否扣款模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="isPay" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body text-center">
                    <p>请确认资金渠道已经放款成功，只有资金渠道放款成功才能点击确定。</p>
                </div>
                <div class="modal-footer">
                    <button id="confirmOffLine" data-dismiss="modal" type="button" class="btn btn-danger">确认</button>
                    <button type="button" class="btn btn-confirm" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <div id="mask_loading">
        <div class="loadEffect">
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
            <span></span>
        </div>
    </div>
</div>
<script src="static/plugins/vue/vue.min.js"></script>
<script src="<%=basePath%>static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=basePath%>static/js/jquery.jqprint-0.3.js"></script>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script src="<%=basePath%>static/js/ChinaNumToEnglishNum.js"></script>
<script src="<%=basePath%>static/js/myOrderCommon.js"></script>
<script>
    $(function () {
        myOrderTpl.init({
            orderId: '<%=orderId%>',
            keyword: '',
            orderStatus: '',
            period: '',
            createDate: '',
            start: '',
            basePath: '<%=basePath%>'
        });
    })
</script>
<script>

    var loanApprove = {
        vari: {
            orderId: '<%=orderId%>',
        },
        vm: {},
        init: function () {
            var _this = this;
            this.newVue();
            this.getData();
        },
        bindEvent: function () {
            var _this = this;
            // 删除附件图片
            $('#delPics').click(function () {
                var value = myOrderTpl.getiCheckItem('attachPic');
                if (value.length == 0) {
                    myOrderTpl.alertModel('请至少选择一张图片附件!');
                    return;
                }
                _this.delAttachPics(value);

            })
            $('input[name="auditAmount"]').mouseenter(function () {
                if ($(this).val() == '') {
                    $(this).siblings('#toUpperMoney').hide()
                    return false;
                }
                $(this).siblings('#toUpperMoney').text(toUpperMoney(Number($(this).val()))).show()
            })
            $('input[name="auditAmount"]').mouseleave(function () {
                $(this).siblings('#toUpperMoney').hide()
            })
            $('input[name="auditAmount"]').keyup(function () {
                if ($(this).val() == '') {
                    $(this).siblings('#toUpperMoney').hide()
                    return false;
                }
                $(this).siblings('#toUpperMoney').text(toUpperMoney(Number($(this).val()))).show()
            })
            $('#confirmOffLine').click(function () {
                _this.vm.offLinePassLoan()
            })
            $('li.order-fee-list').on('focus', 'input', function () {
                var p = $(this).next('p');
                if (p.text() != '') {
                    p.show();
                }
            })
            $('li.order-fee-list').on('blur', 'input', function () {
                $(this).next('p').hide()
            })
            // 模板下载
            $('#downloadExcel').on('click', function () {
                window.open('<%=basePath%>lendingReview/downloadreapyBackTemp')
            })
            // 上传文档
            $('#uploadExcel').off('click').on('click', function () {
                _this.uploadExcel()
            })
        },
        newVue: function () {
            var _this = this;
            this.vm = new Vue({
                el: '#loanApprove',
                data: {
                    retList: [],
                    repayWayList: [],
                    reviewedList: [],
                    attachmentList: [],
                    periodList: [],
                    orderFeeList: [],
                    capticalChannelList: [],
                    showPaymentByPersonButton: '',
                    processTemplateId: '',
                    showRepayPlanBtn: '',
                    isChecked: 'checked',
                    isLeft: 'isLeft',
                    isLefts: 'isLeft-s',
                    pos120: 'pos-l120',
                    pass: 'pass',
                    showDom: 'show-dom'
                },
                computed: {
                    formClassObj: function () {
                        return {}
                    },

                },
                methods: {
                    passLoan: function ($event, processId) {
                        this.examize($event.currentTarget, 1, processId);
                    },
                    refuse: function ($event, processId) {
                        this.examize($event.currentTarget, 3, processId);
                    },
                    reject: function ($event, processId) {
                        this.examize($event.currentTarget, 2, processId);
                    },
                    onLinePassLoan: function ($event, processId) {
                        this.examize($event.currentTarget, 1, processId, true);
                    },
                    offLinePassLoan: function () {
                        this.examize(this.target, 1, this.processId, false);
                    },
                    showDialog: function ($event, processId) {
                        this.target = $event.currentTarget;
                        this.processId = processId;
                        $('#isPay').modal('show');
                    },
                    personPaypal: function () {
                        var _this = this;
                        $.ajax({
                            url: util.getServerUrl('/lendingReview/paymentByPerson'),
                            method: 'POST',
                            data: {
                                orderId: '<%=orderId%>',
                                processTemplateId: _this.processTemplateId
                            },
                            success: function (res) {
                                if (res.status == '0') {
                                    myOrderTpl.alertSuccessModel(res.msg, function () {
                                        $('#navTab').load('<%=basePath%>loanOrder/myLoanOrderList');
                                    });
                                } else {
                                    myOrderTpl.alertModel(res.msg);
                                }
                            },
                            error: function (error) {
                                myOrderTpl.alertModel(error);
                            }
                        })
                    },
                    examize: function (target, resultValue, processId, isOnline) {
                        var rejectProcessId = $(target).parents('div.btns').find('select').val();
                        var formObj = $(target).parents('form');
                        var remarkTemp = formObj.serializeArray();
                        var remarkExtend = {};
                        var url = '/loanOrder/examineOrder'; // 默认url
                        for (var i = 0; i < remarkTemp.length; i++) {
                            remarkExtend[remarkTemp[i].name] = remarkTemp[i].value;
                        }
                        if (resultValue == 1) {
                            var arr = ['auditAmount', 'auditPeriod', 'auditMonthRate', 'repayWay'];
                            for (var i = 0; i < arr.length; i++) {
                                if (remarkExtend[arr[i]] == '') {
                                    myOrderTpl.alertModel('请检查调查意见是否有未填项!')
                                    return;
                                }
                            }
                            if (remarkExtend.auditMonthRate > 999) {
                                myOrderTpl.alertModel('利率输入过大!')
                                return;
                            }
                        }
                        remarkExtend.auditMonthRate = Number(remarkExtend.auditMonthRate).mul(12).toFixed(6);
                        if (resultValue == 3) {
                            if (!window.confirm('确认要拒绝吗?')) {
                                return;
                            }
                        }
                        if (processId == 31) {
                            url = '/lendingReview/lendingRevieBegin';
                            if (!!!remarkExtend.department) {
                                myOrderTpl.alertModel('请填写业务部门!');
                                return;
                            }
                            var capticalChannelListInfo = [],
                            	flag = 0,
                                orderFeeTypeListInfo = [];
                            $('li.channel-wrap').each(function () {
                                var val = $(this).find('input').eq(1).val();
                                if(val==0||val=='') {
                                    myOrderTpl.alertModel('请检查资金渠道放款金额');
                                    flag = 1;
                                    return false;
                                }else {
                                	flag = 0
                                }
                                capticalChannelListInfo.push({
                                    productId: $(this).find('input').eq(0).attr('data-productid'),
                                    channelId: $(this).find('input').eq(0).attr('data-channelid'),
                                    orderId: '<%=orderId%>',
                                    amount: $(this).find('input').eq(1).val()
                                })
                            })
                            if(flag==1)return;
                            $('li.order-fee-list').each(function () {
                                orderFeeTypeListInfo.push({
                                    productId: $(this).children('span').attr('data-productid'),
                                    businessFeeCode: $(this).children('span').attr('data-businessfeecode'),
                                    orderId: '<%=orderId%>',
                                    businessFeeCodeName: $(this).children('span').text(),
                                    amount: $(this).children('input').val()
                                })
                            })
                            // 联合贷并且需要上传了附件才能通过
                            if(this.capticalChannelList.length > 0 && this.showRepayPlanBtn==false) {
                                myOrderTpl.alertModel('请上传银行回款计划后再操作!');
                                return;
                            }
                        }
                        if (processId == 37 && !!isOnline) { // 财务经理复核同意
                            url = '/lendingReview/onlineToPay';
                        }
                        if (processId == 37 && !!!isOnline) { // 财务经理复核线下放款
                            url = '/lendingReview/offlineToPay';
                        }
                        $.ajax({
                            url: util.getServerUrl(url),
                            method: 'POST',
                            data: {
                                orderId: '<%=orderId%>',
                                resultValue: resultValue,
                                processId: processId,
                                rejectProcessId: rejectProcessId,
                                fileTag: $('#uploadProve').val(),
                                remarkExtend: JSON.stringify(remarkExtend),
                                capticalChannelListInfo: JSON.stringify(capticalChannelListInfo),
                                orderFeeTypeListInfo: JSON.stringify(orderFeeTypeListInfo),
                                actualAmount: $('input[name="actualAmount"]').val()
                            },
                            success: function (res) {
                                if (res.status == '0') {
                                    myOrderTpl.alertSuccessModel(res.msg, function () {
                                        $('#navTab').load('<%=basePath%>loanOrder/myLoanOrderList');
                                    });
                                } else {
                                    myOrderTpl.alertModel(res.msg);
                                }
                            },
                            error: function (error) {
                                myOrderTpl.alertModel(error);
                            }
                        })
                    },
                    _getRepayPlan(cb) {
                        $.ajax({
                            url: util.getServerUrl('/lendingReview/dyBankMoneyBackList'),
                            method: 'POST',
                            data: {
                                orderId: '<%=orderId%>',
                            },
                            success: function (res) {
                                if (res.status == '0') {
                                    cb && cb(res.list)
                                } else {
                                    myOrderTpl.alertModel(res.msg);
                                }
                            },
                            error: function (error) {
                                myOrderTpl.alertModel(error);
                            }
                        })
                    },
                    showRepayPlan() {
                        this._getRepayPlan(function (data) {
                            var str = '<table class="table table-hover">';
                            str += '<thead>';
                            str += '<tr>';
                            str += '<td>期数</td>';
                            str += '<td>还款总数</td>';
                            str += '<td>本金</td>';
                            str += '<td>利息</td>';
                            str += '</tr>';
                            str += '</thead>';
                            str += '<tbody>';
                            for (var i = 0; i < data.length; i++) {
                                str += '<tr>';
                                str += '<td>' + data[i].period + '</td>';
                                str += '<td>' + ((Number(data[i].capital_value) + Number(data[i].interest_value)).toFixed(2)) + '</td>';
                                str += '<td>' + data[i].capital_value + '</td>';
                                str += '<td>' + data[i].interest_value + '</td>';
                                str += '</tr>';
                            }
                            str += '</tbody>';
                            str += '</table>';
                            $('#myModal .modal-body').css({
                                'max-height': 600,
                                'overflow-y': 'auto'
                            })
                            myOrderTpl.alertModel(str)
                            $('#myModal').on('hidden.bs.modal', function (e) {
                                $('#myModal .modal-body').css('max-height', 'none')
                            })
                        })
                    }
                },
                filters: {
                    monthRating: function (value) {
                        return Number(value).div(12).toFixed(6);
                    }
                },
                mounted: function () {

                },
                updated: function () {
                    // 初始化图片上传
                    myOrderTpl.uploadImgs(30);
                    _this.renderTime();
                    _this.renderCheckBox();
                    _this.initImages();
                    _this.bindEvent();
                }
            })
        },
        // 获取信息
        getData: function (cb) {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/lendingReview/getLendingReviewList'),
                method: 'POST',
                data: {
                    orderId: this.vari.orderId,
                    fileTag: $('#uploadProve').val(),
                },
                success: function (res) {
                    if (res.status == 0) {
                        _this.vm.retList = res.retList;
                        _this.vm.repayWayList = res.repayWayList;
                        _this.vm.reviewedList = res.reviewedList;
                        _this.vm.attachmentList = res.attachmentList;
                        _this.vm.periodList = res.periodList;
                        _this.vm.orderFeeList = res.orderFeeList;
                        _this.vm.capticalChannelList = res.capticalChannelList;
                        _this.vm.showRepayPlanBtn = res.showRepayPlanBtn;
                        _this.vm.processTemplateId = res.processTemplateId;
                        _this.vm.showPaymentByPersonButton = res.showPaymentByPersonButton;
                        cb && cb();
                    } else if (res.status == 1) {
                        $('.btns').addClass('hide');
                        if (res.msg == '' || res.msg == undefined) {
                            myOrderTpl.alertModel('订单状态还未到放款流程!');
                        } else {
                            myOrderTpl.alertModel(res.msg);
                        }
                    } else {
                        $('.btns').addClass('hide');
                        if (res.msg == '' || res.msg == undefined) {
                            myOrderTpl.alertModel('获取信息失败!');
                        } else {
                            myOrderTpl.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    myOrderTpl.alertModel(error);
                }
            })
        },
        // 初始化图片
        initImages: function () {
            $('[data-magnify="gallery"]').magnify({
                i18n: {
                    minimize: '最小化',
                    maximize: '最大化',
                    close: '关闭',
                    zoomIn: '放大',
                    zoomOut: '缩小',
                    prev: '上一张',
                    next: '下一张',
                    fullscreen: '全屏',
                    actualSize: '自适应',
                    rotateLeft: '左旋转',
                    rotateRight: '右旋转',
                },
                icons: {
                    fullscreen: 'fa fa-arrows-alt',
                },
                footToolbar: ['zoomIn', 'zoomOut', 'prev', 'fullscreen', 'next', 'rotateLeft', 'rotateRight'],
                headToolbar: ['maximize', 'close']
            });
        },
        // 删除图片
        delAttachPics: function (data) {
            if (window.confirm('确认删除吗?')) {
                $.ajax({
                    url: util.getServerUrl('/loanOrder/deleteOrderAttach'),
                    method: 'POST',
                    data: {
                        attachIds: data.join(','),
                        orderId: this.vari.orderId
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            myOrderTpl.alertSuccessModel('图片删除成功!', function () {
                                $('#navTab').load('<%=basePath%>loanOrder/myOrderLoanApprovePage?orderId=<%=orderId%>');
                            });
                        } else {
                            if (res.msg == '' || res.msg == 'undefined') {
                                myOrderTpl.alertModel('图片删除失败，请稍后重试!');
                            } else {
                                myOrderTpl.alertModel(res.msg);
                            }
                        }
                    },
                    error: function (error) {
                        myOrderTpl.alertModel(error);
                    }
                })
            }
        },
        // 上传文档
        uploadExcel: function () {
            var formData = new FormData(), _this = this;
            //var repayWay = $('select[name="repayWay"]').val();
            if (document.getElementById("file").files[0] == undefined) {
                myOrderTpl.alertModel('请选择上传文件');
                return;
            }
            formData.append("uploadfile", document.getElementById("file").files[0]);
            formData.append("orderId", '<%=orderId%>');
           // formData.append("repayWay", repayWay);
            $.ajax({
                url: util.getServerUrl("/lendingReview/uploadrepayBack"),
                type: "POST",
                data: formData,
                contentType: false,
                processData: false,
                beforeSend: function () {
                    $('#uploadExcel').attr('disabled', true);
                    $('#mask_loading').show();
                },
                complete: function () {
                    $('#uploadExcel').removeAttrs('disabled');
                    $('#mask_loading').hide();
                },
                success: function (res) {
                    if (res.status == 0) {
                        _this.vm.showRepayPlanBtn = true;
                    } else {
                        myOrderTpl.alertModel(res.msg);
                    }
                },
                error: function (error) {
                    myOrderTpl.alertModel(error);
                }
            });
        },
        // 渲染选择时间组件
        renderTime: function () {
            var i18n = { // 本地化
                previousMonth: '上个月',
                nextMonth: '下个月',
                months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
                weekdays: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
                weekdaysShort: ['日', '一', '二', '三', '四', '五', '六']
            }
            // var faceSignTime = new Pikaday({
            //     field: $('#faceSignTime')[0] ,
            //     i18n : i18n,
            //     format: 'YYYY-M-D',
            // });
            // var pledgeTransactT = new Pikaday({
            //     field: $('#pledgeTransactT')[0] ,
            //     i18n : i18n,
            //     format: 'YYYY-M-D',
            // });
            // var heRightTransactT = new Pikaday({
            //     field: $('#heRightTransactT')[0] ,
            //     i18n : i18n,
            //     format: 'YYYY-M-D',
            // });
            laydate.render({
                elem: '#faceSignTime',
                format: 'yyyy-MM-dd',
                type: 'date'
            });
            laydate.render({
                elem: '#pledgeTransactT',
                format: 'yyyy-MM-dd',
                type: 'date'
            });
            laydate.render({
                elem: '#heRightTransactT',
                format: 'yyyy-MM-dd',
                type: 'date'
            });
        },
        // 渲染checkbox
        renderCheckBox: function () {
            $('input[name="attachPic"]').iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
            });
        }
    }

    $(function () {
        loanApprove.init();
    })
</script>