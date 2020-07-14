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
String orderNo = request.getParameter("orderNo") ;
%>
<%
String orderId = request.getParameter("orderId") ;
%>
<style>
    [v-cloak] {
        display: none !important;
    }
</style>
<link rel="stylesheet" href="static/css/after-loan.css">
<div class="container-fluid" id="afterLoan" v-cloak>
    <div class="nav-bar">
        <a data-model="navTab" data-url="<%=basePath%>loanOrder/listAfterOrderPage">< 返回贷后管理</a>
    </div>
    <div class="tab-con">
        <div>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane">
                    <!--还款信息-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">还款信息</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table after-loan-table">
                                <tbody>
                                <tr>
                                    <td class="bg">借款订单编号</td>
                                    <td class="order-num">{{payInfo.orderNo}}</td>
                                    <td class="bg">产品名称</td>
                                    <td>{{payInfo.productName}}</td>
                                    <td class="bg">平台手续费(月化)</td>
                                    <td>{{payInfo.auditServiceRating}}</td>
                                </tr>
                                <tr>
                                    <td class="bg">借款金额(元)</td>
                                    <td>{{payInfo.auditAmount | formatMoney(2)}}</td>
                                    <td class="bg">借款期限(期)</td>
                                    <td>{{payInfo.auditPeriod}}</td>
                                    <td class="bg">借款利率(月化)</td>
                                    <td>{{payInfo.auditRating}}</td>
                                </tr>
                                <tr>
                                    <td class="bg">借款人</td>
                                    <td>{{payInfo.userName}}</td>
                                    <td class="bg">联系电话</td>
                                    <td>{{payInfo.userMobile}}</td>
                                    <td class="bg">渠道手续费(月化)</td>
                                     <td>{{payInfo.auditSxf}}</td>
                                </tr>
                                <tr>
                                    <td class="bg">应还本金</td>
                                    <td>{{payInfo.planRepayCapital | formatMoney(2)}}</td>
                                    <td class="bg">应还利息</td>
                                    <td>{{payInfo.planRepayInterest | formatMoney(2)}}</td>
                                    <td class="bg">还款方式</td>
                                    <td>{{payInfo.repayWay}}</td>
                                </tr>
                                <tr>
                                    <td class="bg">已还本金</td>
                                    <td>{{payInfo.accRepayCapital | formatMoney(2)}}</td>
                                    <td class="bg">已还利息</td>
                                    <td>{{payInfo.accReapyInterest | formatMoney(2)}}</td>
                                    <td class="bg">还款状态</td>
                                    <td>{{payInfo.repayStatus}}</td>
                                </tr>
                                <tr>
                                	<td class="bg">银行</td>
                                    <td>{{payInfo.bankName}}</td>
                                    <td class="bg">银行卡号</td>
                                    <td>{{payInfo.cardNumber}}</td>
                                    <td class="bg">放款时间</td>
                                    <td>{{payInfo.makeLoanDate}}</td>
                                   
                                </tr>
                                <tr>
                                	<td class="bg">贷款信息</td>
                                    <td><a data-model="navTab"
                                           data-url="<%=basePath%>loanOrder/baseInfoPage?orderId=${orderId}">详情</a></td>
                                    <td class="bg">提前结清</td>
                                    <td><a data-model="navTab"
                                                       data-url="<%=basePath%>repayInfoMenu/toEarlySettlePage?orderNo=<%=orderNo%>">申请</a>
                                    </td>
                                     <td class="bg">交易流水号</td>
                                    <td>{{payInfo.transactionNo}}</td>
                                </tr>
                                <tr>
                                	<td class="bg">小贷公司实际放款金额</td>
                                    <td>
                                   	 {{payInfo.actualAmount}}
                                    </td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--还款计划-->
                    <div class="panel panel-info">
                        <div class="panel-heading pay-plan" @click="toggleHeight">
                            <h3 class="panel-title">还款计划</h3>
                            <a href="<%=basePath%>repayInfoMenu/exportRepayPlan?orderNo=<%=orderNo%>" class="btn"
                               target="_blank">导出</a>
                        </div>
                        <div class="panel-body slide-panel-body">
                        	<span id="rpEarlySettleServiceFee"></span>
                            <table class="table after-loan-table pay-plan-table">
                                <thead>
                                <tr>
                                    <th>期数</th>
                                    <th id="planRepayDate">计划还款日期</th>

                                    <th>应还总额</th>
                                    <th id="accRepayDate">实际还款日期</th>

                                    <th>实还总额</th>
                                    <th>还款状态</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="(item,index) in payPlan">
                                    <td>{{item.period}}</td>
                                    <td>{{item.planRepayDate}}</td>
                                    <td v-for="list in item.planFeeValueList">
                                    	{{list.value}}
                                   	</td>
                                    <td>{{item.planRepayTotalAmt}}</td>
                                    <td>{{item.accRepayDate}}</td>
                                    <td v-for="list in item.accFeeValueList">
                                    	{{list.value}}
                                    </td>
                                    <td>{{item.accRepayTotalAmt}}</td>
                                    <td>{{item.repayStatus}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                     <!--回款计划-->
                    <div class="panel panel-info">
                        <div class="panel-heading pay-plan" @click="toggleHeight">
                            <h3 class="panel-title">回款计划</h3>
                            <a href="<%=basePath%>repayInfoMenu/exportMoneyBackPlan?orderNo=<%=orderNo%>" class="btn"
                               target="_blank">导出</a>
                        </div>
                        <div class="panel-body slide-panel-body">
                        	<span id="mbEarlySettleServiceFee"></span>
                            <table class="table after-loan-table">
                                <thead>
                                <tr>
                                    <th>期数</th>
                                    <th id="planRepayDate_back">计划还款日期</th>
                                    
                                    <th>应还总额</th>
                                    <th id="accRepayDate_back">实际还款日期</th>
                                    
                                    <th>实还总额</th>
                                    <th>还款状态</th>
                                    <th>扣款方式</th>
                                    <th>操作</th>
                                    <th width="200px">扣款结果</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="(item,index) in moneyBackPlan">
                                    <td>{{item.period}}</td>
                                    <td>{{item.planRepayDate}}</td>
                                    <td v-for="list in item.planFeeValueList">
                                    	{{list.value}}
                                   	</td>
                                    <td>{{item.planRepayTotalAmt}}</td>
                                    <td>{{item.accRepayDate}}</td>
                                    <td v-for="list in item.accFeeValueList">
                                    	{{list.value}}
                                    </td>
                                    <td>{{item.accRepayTotalAmt}}</td>
                                    <td>{{item.repayStatus}}</td>
                                    <td>{{item.deductType}}</td>
                                    <td>
                                        <button type="button"
                                                v-show="(payInfo.ownLoanType==1)&&(payInfo.isOverdueAutoDeduct==0)&&(item.repayStatus == '逾期')"
                                                class="btn payBtn"
                                                @click="showModelSDXSHK(item.period)">
                                                                                                                                    手动线上还款
                                        </button>
                                      <button type="button"
                                        		class="btn payBtn" 
                                        		v-show="(payInfo.ownLoanType==1) && ((item.repayStatus == '还款中') || (item.repayStatus == '未还款')||(item.repayStatus == '逾期')) && (item.status==0)"
                                        		@click="changeStatus(item.period,1)">
                                        	暂停自动扣款
                                        </button>
                                        <button type="button"
                                                class="btn payBtn"
                                                v-show="(payInfo.ownLoanType==1) && ((item.repayStatus == '还款中') || (item.repayStatus == '未还款')||(item.repayStatus == '逾期')) && (item.status==1)"
                                                @click="changeStatus(item.period,0)">
                                          	 继续自动扣款
                                        </button>
                                     </td>
                                     <td>{{item.deductionResult}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--德阳银行回款计划-->
                    <div v-if="dyMoneyBackPlan.length>0" class="panel panel-info">
                        <div class="panel-heading pay-plan" @click="toggleHeight">
                            <h3 class="panel-title">德阳银行回款计划</h3>
                        </div>
                        <div class="panel-body slide-panel-body">
                            <table class="table after-loan-table">
                                <thead>
                                <tr>
                                    <th>期数</th>
                                    <th>还款总额</th>
                                    <th>本金</th>
                                    <th>利息</th>
                                    <th>还款状态</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="(item,index) in dyMoneyBackPlan">
                                    <td>{{item.period}}</td>
                                    <td>{{(Number(item.capital_value)+Number(item.interest_value)).toFixed(2)}}</td>
                                    <td>{{item.capital_value}}</td>
                                    <td>{{item.interest_value}}</td>
                                    <td>{{item.repayStatus}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--逾期情况-->
                    <div class="panel panel-info">
                        <div class="panel-heading" @click="toggleHeight">
                            <h3 class="panel-title">逾期情况</h3>
                        </div>
                        <div class="panel-body slide-panel-body">
                            <table class="table after-loan-table">
                                <thead>
                                <tr>
                                    <th>当前期数</th>
                                    <th>当前逾期开始日期</th>
                                    <th>当前逾期天数</th>
                                    <th>当前逾期等级</th>
                                    <th>当前逾期开始期数</th>
                                    <th>当前未还本金累计</th>
                                    <th>当前未还利息累计</th>
                                    <th>当前未还本息累计</th>
                                    <th>剩余应收本金</th>
                                    <th>剩余应收利息</th>
                                    <th>剩余应收罚息</th>
                                    <th>剩余应收总和</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="item in outlineDay">
                                    <td>{{item.curPeriod}}</td>
                                    <td>{{item.overdueBegin}}</td>
                                    <td>{{item.overdueDays}}</td>
                                    <td>{{item.overdueLevel}}</td>
                                    <td>{{item.overdueBeginPeriod}}</td>
                                    <td>{{item.unpayCapital | formatMoney(2)}}</td>
                                    <td>{{item.unpayInterest | formatMoney(2)}}</td>
                                    <td>{{item.unpayTotal | formatMoney(2)}}</td>
                                    <td>{{item.remainCapital | formatMoney(2)}}</td>
                                    <td>{{item.remainInterest | formatMoney(2)}}</td>
                                    <td>{{item.remainPenalty | formatMoney(2)}}</td>
                                    <td>{{item.remainTotal | formatMoney(2)}}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!--摊余成本收入计算-->
                    <div class="panel panel-info">
                        <div class="panel-heading" @click="toggleHeight">
                            <h3 class="panel-title">摊余成本收入计算</h3>
                        </div>
                        <div class="panel-body slide-panel-body">
                            <table class="table after-loan-table">
                                <thead>
                                <tr>
                                    <th>总期数</th>
                                    <th>期数</th>
                                    <th>期初本金(元)</th>
                                    <th>利率(月)</th>
                                    <th>每期收息(元)</th>
                                    <th>每月本金</th>
                                    <th>每月回收本息</th>
                                    <th>期初摊余成本</th>
                                    <th>实际利率</th>
                                    <th>实际利息</th>
                                    <th>期末摊余成本</th>
                                    <th>当期利息调整</th>
                                    <th>利息调整累计</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr v-for="item in costCalc">
                                    <td>{{item.totalPeriod}}</td>
                                    <td>{{item.period}}</td>
                                    <td>{{item.periodBeginCapital | formatMoney(2)}}</td>
                                    <td>{{item.monthRate}}</td>
                                    <td>{{item.planRepayInterest | formatMoney(2)}}</td>
                                    <td>{{item.planRepayCapital | formatMoney(2)}}</td>
                                    <td>{{item.planRepayCapInter | formatMoney(2)}}</td>
                                    <td>{{item.periodBeginAmortizationCost | formatMoney(2)}}</td>
                                    <td>{{item.accRate}}</td>
                                    <td>{{item.accInterest | formatMoney(2)}}</td>
                                    <td>{{item.periodEndAmortizationCost | formatMoney(2)}}</td>
                                    <td>{{item.curInterestAdjust | formatMoney(2)}}</td>
                                    <td>{{item.interestAdjustNum | formatMoney(2)}}</td>
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
    <!--成功跳转模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="mySuccessModal" data-backdrop="static" data-keyboard="false">
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
    <!-- 手动线上扣款模态框 -->
    <div class="modal fade" tabindex="-1" role="dialog" id="confirmPay" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body text-center">
                    <h1>扣款金额如下，请核对:</h1>
                    <h3 v-if="false">还款记录:</h3>
                    <table v-if="false" class="table">
                        <thead>
                        <tr class="bold">
                            <td v-if="item.code!='planRepayTotalAmt'" v-for="item in rpPlanMap">{{item.name}}</td>
                        </tr>
                        </thead>
                        <tr>
                            <td v-if="item.code!='planRepayTotalAmt'" v-for="item in rpPlanMap">{{item.value}}</td>
                        </tr>
                    </table>
                    <table v-if="false" class="table">
                        <thead>
                        <tr class="bold">
                            <td v-if="item.code!='accRepayTotalAmt'" v-for="item in rpAccMap">{{item.name}}</td>
                        </tr>
                        </thead>
                        <tr>
                            <!--<td v-for="(item,index) in accPlanMap"><input :id="item.code" :readonly="item.code=='planAccDate'?true:false" :name="item.code" type="text" v-model="accPlanMap[index].value"></td>-->
                            <td v-if="item.code!='accRepayTotalAmt'" v-for="(item,index) in rpAccMap"><input :id="item.code+'_rp1'" :name="item.code" type="text" v-model="rpAccMap[index].value"></td>
                        </tr>
                    </table>
                    <h3>回款记录:</h3>
                    <table class="table">
                        <thead>
                        <tr class="bold">
                            <td v-if="item.code!='planRepayTotalAmt'" v-for="item in mbPlanMap">{{item.name}}</td>
                        </tr>
                        </thead>
                        <tr>
                            <td v-if="item.code!='planRepayTotalAmt'" v-for="item in mbPlanMap">{{item.value}}</td>
                        </tr>
                    </table>
                    <table class="table">
                        <thead>
                        <tr class="bold">
                            <td v-if="item.code!='accRepayTotalAmt'" v-for="item in mbAccMap">{{item.name}}</td>
                        </tr>
                        </thead>
                        <tr>
                            <!--<td v-for="(item,index) in backAccMap"><input :id="item.code" :readonly="item.code=='backAccDate'?true:false" :name="item.code" type="text" v-model="backAccMap[index].value"></td>-->
                            <td v-if="item.code!='accRepayTotalAmt'" v-for="(item,index) in mbAccMap"><input :id="item.code+'_mb1'" :name="item.code" type="text" v-model="mbAccMap[index].value"></td>
                        </tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button v-show="showSubmitButton" @click="confirmPay" type="button" class="btn btn-confirm" data-dismiss="modal">确认</button>
                    <button type="button" class="btn" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!-- 线下扣款模态框 -->
    <div class="modal fade" tabindex="-1" role="dialog" id="offlineRepay" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body text-center">
                    <h1>扣款金额如下，请核对:</h1>
                    <h3 v-show="false">还款记录:</h3>
                    <table v-show="false" class="table">
                        <thead>
                        <tr class="bold">
                            <td v-if="item.code!='planRepayTotalAmt' && item.code!='planRepayDate'" v-for="item in rpPlanMap">{{item.name}}</td>
                        </tr>
                        </thead>
                        <tr>
                            <td v-if="item.code!='planRepayTotalAmt' && item.code!='planRepayDate'" v-for="item in rpPlanMap">{{item.value}}</td>
                        </tr>
                    </table>
                    <table v-show="false" class="table">
                        <thead>
                        <tr class="bold">
                            <td v-if="item.code!='accRepayTotalAmt' && item.code!='accRepayDate'" v-for="item in rpAccMap">{{item.name}}</td>
                        </tr>
                        </thead>
                        <tr>
                            <!--<td v-for="(item,index) in accPlanMap"><input :id="item.code" :readonly="item.code=='planAccDate'?true:false" :name="item.code" type="text" v-model="accPlanMap[index].value"></td>-->
                            <td v-if="item.code!='accRepayTotalAmt' && item.code!='accRepayDate'" v-for="(item,index) in rpAccMap"><input :id="item.code+'_rp2'" :name="item.code" type="text" v-model="rpAccMap[index].value"></td>
                        </tr>
                    </table>
                    <h3>回款记录:</h3>
                    <table class="table">
                        <thead>
                        <tr class="bold">
                            <td v-if="item.code!='planRepayTotalAmt' && item.code!='planRepayDate'" v-for="item in mbPlanMap">{{item.name}}</td>
                        </tr>
                        </thead>
                        <tr>
                            <td v-if="item.code!='planRepayTotalAmt' && item.code!='planRepayDate'" v-for="item in mbPlanMap">{{item.value}}</td>
                        </tr>
                    </table>
                    <table class="table">
                        <thead>
                        <tr class="bold">
                            <td v-if="item.code!='accRepayTotalAmt' && item.code!='accRepayDate'" v-for="item in mbAccMap">{{item.name}}</td>
                        </tr>
                        </thead>
                        <tr>
                            <!--<td v-for="(item,index) in backAccMap"><input :id="item.code" :readonly="item.code=='backAccDate'?true:false" :name="item.code" type="text" v-model="backAccMap[index].value"></td>-->
                            <td v-if="item.code!='accRepayTotalAmt' && item.code!='accRepayDate'" v-for="(item,index) in mbAccMap"><input :id="item.code+'_mb2'" :name="item.code" type="text" v-model="mbAccMap[index].value"></td>
                        </tr>
                    </table>
                    <table class="table acc-table">
                    	<tr>
                    		<td> <span>实际还款时间</span><input placeholder="请选择日期" id="accRepayDate_offRey" type="text" readonly="readonly"/></td>
                    		<td>
                                <span>还款状态</span>
                    			<select id="repayStatus" >
                             		<option v-for="item in repayStatusList" :value="item.value">{{item.name}}</option>                                
                         		</select>
                         	</td>
                    	</tr>
                    </table>
                </div>
                <div class="modal-footer">
                    <button @click="offlineRepay" type="button" class="btn btn-confirm" data-dismiss="modal">确认</button>
                    <button type="button" class="btn" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
<script src="static/plugins/vue/vue.min.js"></script>
<script>

    var beforeBaseInfo = {
        vm: {},
        init: function () {
            this.newVue();
            this.getData();

        },
        getData: function () {
            this.getPayInfo();
            this.getPayPlan();
            this.getMoneyBackPlan();
            this.getDyMoneyBackPlan();
            this.getOutLineDay();
            this.getCostCalc();
        },
        newVue: function () {
            var _this = this;
            this.vm = new Vue({
                el: '#afterLoan',
                data: {
                    payInfo: {},
                    payPlan: [],
                    moneyBackPlan:[],
                    dyMoneyBackPlan:[],
                    outlineDay: [],
                    costCalc: [],
                    showSubmitButton : true,
                    curPeriod : -1,
                    rpPlanMap: [],		// 还款计划应还
                    rpAccMap: [],		// 还款计划实还
                    mbPlanMap: [],		// 回款计划应还
                    mbAccMap: [],		// 回款计划实还
                    submitParams : {}, 	// 提交的参数
                    repayStatusList : {}	//还款状态列表
                },
                methods:{
                    isThisMonth : function (time) {
                        var date = new Date(),
                            year = date.getFullYear(),
                            month = date.getMonth() + 1,
                            day = date.getDate();
                        var thisMonth = year + '-' + preZero(month) + '-' + preZero(day) + '000';
                        var reg = new RegExp(time.slice(0,7));
                        return reg.test(thisMonth) ? true:false;
                        function preZero(num) {
                            return num < 10 ? '0'+num : num;
                        }
                    },
                    showModelSDXSHK : function(period) {
                        this.rpPlanMap.length=0;
                        this.rpAccMap.length=0;
                        this.mbPlanMap.length=0;
                        this.mbAccMap.length=0;
                        this.curPeriod = period;
                        this.getTableItems(period,function () {
                            $('#confirmPay').modal('show');
                        });
                    },
                    changeStatus : function(period,status){
                        $.ajax({
                            url : util.getServerUrl('/repayInfoMenu/changeStatus'),
                            method : 'POST',
                            data : {orderNo:'<%=orderNo%>',period:period,status:status},
                            success : function (res) {
                                if(res.returnCode == 0) {
                                    _this.alertSuccessModel('修改成功!', function () {
                                        $('#navTab').load('<%=basePath%>repayInfoMenu/getRepayInfo?orderNo=<%=orderNo%>&orderId=<%=orderId%>');
                                    });
                                }else{
                                    _this.alertModel(res.returnMsg);
                                }
                            },
                            error : function (error) {
                                _this.alertModel(error);
                            }
                        })
                    },
                    showModelXXHK : function(period) {
                        this.rpPlanMap.length=0;
                        this.rpAccMap.length=0;
                        this.mbPlanMap.length=0;
                        this.mbAccMap.length=0;
                        this.curPeriod = period;
                        this.getTableItems(period,function () {
                            $('#offlineRepay').modal('show');
                        });
                    },
                    confirmPay : function() {
                        var params = {};
                        params.orderNo = '<%=orderNo%>';
                        params.period = this.curPeriod;
                        params.payBackType = "ownPayBack";
                        
                        var rpCodeValue = {};
                        for (var i = 0; i < this.rpAccMap.length; i++) {
                        	rpCodeValue[this.rpAccMap[i]['code']]=this.rpAccMap[i]['value']
                        }
                        params.rpCodeValue = JSON.stringify(rpCodeValue);
                        
                        var mbCodeValue = {};
                        for (var i = 0; i < this.mbAccMap.length; i++) {
                        	mbCodeValue[this.mbAccMap[i]['code']]=this.mbAccMap[i]['value']
                        }
                        params.mbCodeValue = JSON.stringify(mbCodeValue);
                        
                        $.ajax({
                            url : util.getServerUrl('/repayInfoMenu/WithdrawingNew'),
                            method : 'POST',
                            data : params,
                            success : function (res) {
                                if(res.returnCode == 0) {
                                    _this.alertSuccessModel('正在扣款中!', function () {
                                        $('#navTab').load('<%=basePath%>repayInfoMenu/getRepayInfo?orderNo=<%=orderNo%>&orderId=<%=orderId%>');
                                    });
                                }else{
                                    _this.alertModel(res.returnMsg);
                                }
                            },
                            error : function (error) {
                                _this.alertModel(error);
                            }
                        })
                    },
                    offlineRepay : function() {
                        var params = {};
                        params.orderNo = '<%=orderNo%>';
                        params.period = this.curPeriod;
                        params.accRepayDate = $("#accRepayDate_offRey").val();
                        params.repayStatus = $("#repayStatus").val();
                        
                        if(params.accRepayDate == null || params.accRepayDate == undefined || params.accRepayDate == ''){
                        	_this.alertModel("实际还款日期不能为空");
                        	return false;
                        }
                        
                        var rpCodeValue = {};
                        for (var i = 0; i < this.rpAccMap.length; i++) {
                        	rpCodeValue[this.rpAccMap[i]['code']]=this.rpAccMap[i]['value']
                        }
                        params.rpCodeValue = JSON.stringify(rpCodeValue);
                        
                        var mbCodeValue = {};
                        for (var i = 0; i < this.mbAccMap.length; i++) {
                        	mbCodeValue[this.mbAccMap[i]['code']]=this.mbAccMap[i]['value']
                        }
                        params.mbCodeValue = JSON.stringify(mbCodeValue);
                        
                        $.ajax({
                            url : util.getServerUrl('/repayInfoMenu/offlineRepay'),
                            method : 'POST',
                            data : params,
                            success : function (res) {
                                if(res.returnCode == 0) {
                                    _this.alertSuccessModel('正在扣款中!', function () {
                                        $('#navTab').load('<%=basePath%>repayInfoMenu/getRepayInfo?orderNo=<%=orderNo%>&orderId=<%=orderId%>');
                                    });
                                }else{
                                    _this.alertModel(res.returnMsg);
                                }
                            },
                            error : function (error) {
                                _this.alertModel(error);
                            }
                        })
                    },
                    _handleData: function(data) {
                        var mbPlanMap = Object.keys(data.mbPlanMap),
                        	mbAccMap = Object.keys(data.mbAccMap),
                        	rpPlanMap = Object.keys(data.rpPlanMap),
                        	rpAccMap = Object.keys(data.rpAccMap);
                        
                        // 回款计划应还
                        for(var i =0;i<mbPlanMap.length;i++) {
                            this.mbPlanMap.push({
                                name : mbPlanMap[i].split(',')[0],
                                code : mbPlanMap[i].split(',')[1],
                                value : data.mbPlanMap[mbPlanMap[i]]
                            })
                        }
                        // 回款计划实还
                        for(var i =0;i<mbAccMap.length;i++) {
                            this.mbAccMap.push({
                                name : mbAccMap[i].split(',')[0],
                                code : mbAccMap[i].split(',')[1],
                                value : data.mbAccMap[mbAccMap[i]]
                            })
                        }
                        // 还款计划应还
                        for(var i =0;i<rpPlanMap.length;i++) {
                            this.rpPlanMap.push({
                                name : rpPlanMap[i].split(',')[0],
                                code : rpPlanMap[i].split(',')[1],
                                value : data.rpPlanMap[rpPlanMap[i]]
                            })
                        }
                        // 还款计划实还
                        for(var i =0;i<rpAccMap.length;i++) {
                            this.rpAccMap.push({
                                name : rpAccMap[i].split(',')[0],
                                code : rpAccMap[i].split(',')[1],
                                value : data.rpAccMap[rpAccMap[i]]
                            })
                        }
                        console.log(data.repayStatusList);
                        this.repayStatusList = data.repayStatusList;
                    },
                    getTableItems : function(period,cb) {
                        var self = this;
                        $.ajax({
                            url : util.getServerUrl('/repayInfoMenu/getRepayPlanInfo'),
                            method : 'POST',
                            data : {orderNo:'<%=orderNo%>',period:period},
                            success : function (res) {
                                if(res.returnCode == 0) {
                                    self.showSubmitButton = res.result.showSubmitButton
                                    self._handleData(res.result);
                                    cb&&cb()
                                }else{
                                    _this.alertModel(res.returnMsg);
                                }
                            },
                            error : function (error) {
                                _this.alertModel(error);
                            }
                        })
                    },
                    toggleHeight : function ($event) {
                        $($event.currentTarget).next('.slide-panel-body').slideToggle()
                    }
                },
                filters: {
                    toFixed: function (value, num) {
                        return Number(value).toFixed(num);
                    },
                    formatMoney: function (val, num) {
                        var str = Number(val).toFixed(num) + '';
                        var intSum = str.substring(0, str.indexOf(".")).replace(/\B(?=(?:\d{3})+$)/g, ',');//取到整数部分
                        var dot = str.substring(str.length, str.indexOf("."))//取到小数部分搜索
                        var ret = intSum + dot;
                        return ret;
                    },
                },
                updated : function () {
                    var that = this;
                    laydate.render({
                  	  elem: '#accRepayDate_offRey',
                  	  format: 'yyyy-MM-dd',
                  	  type: 'date'
                  	});
                    laydate.render({
                        elem: '#planAccDate',
                        format: 'yyyy-MM-dd',
                        type: 'date',
                        done: function (value) {
                            // vue对象的属性设置为当前的日期
                            that.accPlanMap.forEach(function (item) {
                                if(item.code=='planAccDate') {
                                    item.value=value
                                }
                            })
                        },
                    });
                    laydate.render({
                        elem: '#backAccDate',
                        format: 'yyyy-MM-dd',
                        type: 'date',
                        done: function (value) {
                            // vue对象的属性设置为当前的日期
                            that.backAccMap.forEach(function (item) {
                                if(item.code=='backAccDate') {
                                    item.value=value
                                }
                            })
                        },
                    });
                }
            })
        },
        getPayInfo: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/repayInfoMenu/getRepayInfo'),
                data: {orderNo:'${orderNo}'},
                method: 'POST',
                success: function (res) {
                    if (res.returnCode == 0) {
                        _this.vm.payInfo = res.result;
                    } else {
                        _this.alertModel('获取信息出错!');
                    }
                },
                error: function (error) {
                    _this.alertModel(error);
                }
            })
        },
        getPayPlan: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/repayInfoMenu/getRepayPlanByOrderNo'),
                data: {orderNo:'${orderNo}'},
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                    	// 动态添加应还的表头
                     	var planFeeTableHead = res.planFeeTableHead;
                     	var addPlanTableHeadHtml = "";
                     	for (var i = 0; i < planFeeTableHead.length; i++) {
                     		addPlanTableHeadHtml += "<th>" + planFeeTableHead[i] + "</th>"; 
    					}
                   		$("#planRepayDate").after(addPlanTableHeadHtml);
                   		
                   		// 动态添加实还的表头
                   		var accFeeTableHead = res.accFeeTableHead;
                     	var addAccTableHeadHtml = "";
                     	for (var i = 0; i < accFeeTableHead.length; i++) {
                     		addAccTableHeadHtml += "<th>" + accFeeTableHead[i] + "</th>";
    					}
                   		$("#accRepayDate").after(addAccTableHeadHtml);
                    	
                        _this.vm.payPlan = res.dataList;
                        
                        var rpEarlySettleServiceFee = res.rpEarlySettleServiceFee;
                        if(null != rpEarlySettleServiceFee && rpEarlySettleServiceFee > 0){
                        	$("#rpEarlySettleServiceFee").text("提前结清违约金：" + rpEarlySettleServiceFee);
                        }
                    } else {
                        _this.alertModel('获取信息出错!');
                    }
                },
                error: function (error) {
                    _this.alertModel(error);
                }
            })
        },
        getMoneyBackPlan: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/repayInfoMenu/getMoneyBackPlanByOrderNo'),
                data: {orderNo:'${orderNo}'},
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                    	// 动态添加应还的表头
                     	var planFeeTableHead = res.planFeeTableHead;
                     	var addPlanTableHeadHtml = "";
                     	for (var i = 0; i < planFeeTableHead.length; i++) {
                     		addPlanTableHeadHtml += "<th>" + planFeeTableHead[i] + "</th>"; 
    					}
                   		$("#planRepayDate_back").after(addPlanTableHeadHtml);
                   		
                   		// 动态添加实还的表头
                   		var accFeeTableHead = res.accFeeTableHead;
                     	var addAccTableHeadHtml = "";
                     	for (var i = 0; i < accFeeTableHead.length; i++) {
                     		addAccTableHeadHtml += "<th>" + accFeeTableHead[i] + "</th>";
    					}
                   		$("#accRepayDate_back").after(addAccTableHeadHtml);
                    	
                        _this.vm.moneyBackPlan = res.dataList;
                        
                        var mbEarlySettleServiceFee = res.mbEarlySettleServiceFee;
                        if(null != mbEarlySettleServiceFee && mbEarlySettleServiceFee > 0){
                        	$("#mbEarlySettleServiceFee").text("提前结清违约金：" + mbEarlySettleServiceFee);
                        }
                    } else {
                        _this.alertModel('获取信息出错!');
                    }
                },
                error: function (error) {
                    _this.alertModel(error);
                }
            })
        },
        getDyMoneyBackPlan: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/lendingReview/dyBankMoneyBackList'),
                data: {orderId:'${orderId}'},
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        _this.vm.dyMoneyBackPlan = res.list;
                    } else {
                        _this.alertModel('获取信息出错!');
                    }
                },
                error: function (error) {
                    _this.alertModel(error);
                }
            })
        },
        getOutLineDay: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/repayInfoMenu/getOverdueByOrderNo'),
                data: {orderNo: '<%=orderNo%>'},
                method: 'POST',
                success: function (res) {
                    if (res.returnCode == 0) {
                        _this.vm.outlineDay = res.result;
                    } else {
                        _this.alertModel('获取信息出错!');
                    }
                },
                error: function (error) {
                    _this.alertModel(error);
                }
            })
        },
        getCostCalc: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/repayInfoMenu/getAmortizedCostByOrderNo'),
                data: {orderNo: '<%=orderNo%>'},
                method: 'POST',
                success: function (res) {
                    if (res.returnCode == 0) {
                        _this.vm.costCalc = res.result;
                    } else {
                        _this.alertModel('获取信息出错!');
                    }
                },
                error: function (error) {
                    _this.alertModel(error);
                }
            })
        },
        // 模态框弹出
        alertModel: function (str) {
            $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#myModal').modal('show');
        },
        alertSuccessModel: function (str,cb) {
            $('#mySuccessModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#mySuccessModal').modal('show');
            $('#mySuccessModal').on('hidden.bs.modal', function (e) {
                cb&&cb();
            })
        },
        tool: {
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
        }
    }
    $(function () {
        beforeBaseInfo.init();
    })

</script>