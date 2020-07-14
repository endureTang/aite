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
                <li class="active"><a href="<%=basePath%>loanOrder/myOrderBaseInfoPage?orderId=<%=orderId%>" aria-controls="one" role="tab" data-toggle="tab" data-target="navTab">基础信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderCreditInfoPage?orderId=<%=orderId%>" aria-controls="two" role="tab" data-toggle="tab"  data-target="navTab">信用信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderInvestigatePage?orderId=<%=orderId%>" aria-controls="three" role="tab" data-toggle="tab"  data-target="navTab">业务调查</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderBusinessApprovePage?orderId=<%=orderId%>" aria-controls="fore" role="tab" data-toggle="tab"  data-target="navTab">业务审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderContractsPage?orderId=<%=orderId%>" aria-controls="five" role="tab" data-toggle="tab"  data-target="navTab">合同管理</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderLoanApprovePage?orderId=<%=orderId%>" aria-controls="six" role="tab" data-toggle="tab"  data-target="navTab">放款审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderOperateLogPage?orderId=<%=orderId%>" aria-controls="seven" role="tab" data-toggle="tab"  data-target="navTab">操作日志</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content" id="baseInfo" v-cloak>
                <div class="tab-pane active" id="one">
                    <div id="print_baseInfo_box">
                        <!--申请信息-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">申请信息</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <form id="applyInfo">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">申请额度(元): </i>
                                            <input name="amount" type="number" class="form-control" :value="applyInfo.amount">
                                        </li>
                                        <li>
                                            <i class="desc-name">客户经理: </i>
                                            <select class="form-control" name="userName">
                                                <option :selected="option.id == baseInfo.channelUserId"
                                                        :value="option.id" v-for="option in manageInfo">
                                                    {{option.user_name}}
                                                </option>
                                            </select>
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">申请期限: </i>
                                            <select class="form-control" name="period" id="applyPeriod">
                                                <option v-for="item in periodInfo" :selected="item.value == applyInfo.period"
                                                        :value="item.value">
                                                    {{item.labelText}}
                                                </option>
                                            </select>
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li class="spe-li clearfix relative">
                                            <i style="margin-top: 10px;"
                                               class="desc-name pull-left">还款方式及月利率: </i>
                                            <div class="pull-left">
                                                <select class="form-control short-select" name="repayWay">
                                                    <option :selected="repayWay.value == applyInfo.repayWay"
                                                            :value="repayWay.value"
                                                            v-for="repayWay in repayWays">{{repayWay.text}}
                                                    </option>
                                                </select>
                                                <input style="width: 160px;" id="auditRating" name="auditRating" type="number" oninput="if(value.length>8)value=value.slice(0,8)" class="form-control"
                                                       :value="applyInfo.auditRating | monthRating">
                                            </div>
                                            <span class="unit" style="left: 485px;">%</span>
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                        <!--借款人基本信息-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">借款人基本信息</h3>
                            </div>
                            <div class="panel-body clearfix payee-base-info">
                                <form id="borrowerBaseInfo">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">姓名: </i>
                                            <input name="name" type="text" class="form-control" :value="baseInfo.name">
                                        </li>
                                        <li>
                                            <i class="desc-name">年龄: </i>
                                            <input name="age" type="number" class="form-control" :value="baseInfo.age">
                                        </li>
                                        <li>
                                            <i class="desc-name">学历: </i>
                                            <select name="education" class="form-control">
                                                <option :value="item.value"
                                                        :selected="item.value==baseInfo.education"
                                                        v-for="item in educations">{{item.name}}
                                                </option>
                                            </select>
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">性别: </i>
                                            <select name="sex" class="form-control">
                                                <option :value="item.value" :selected="item.value==baseInfo.sex"
                                                        v-for="item in sexs">{{item.name}}
                                                </option>
                                            </select>
                                        </li>
                                        <li>
                                            <i class="desc-name">身份证号: </i>
                                            <input name="identity" type="text" class="form-control" :value="baseInfo.identity">
                                        </li>
                                        <li>
                                            <i class="desc-name">手机号: </i>
                                            <input name="phone" type="number" class="form-control" :value="baseInfo.phone">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">民族: </i>
                                            <input name="nation" type="text" class="form-control" :value="baseInfo.nation">
                                        </li>
                                        <li>
                                            <i class="desc-name">婚姻状况: </i>
                                            <select name="marrStatus" class="form-control">
                                                <option :value="item.value" v-for="item in marrStatus"
                                                        :selected="item.value==baseInfo.marrStatus">
                                                    {{item.name}}
                                                </option>
                                            </select>
                                        </li>
                                        <li>
                                            <i class="desc-name">住宅电话: </i>
                                            <input name="telephone" type="text" class="form-control" :value="baseInfo.telephone">
                                        </li>
                                    </ul>
                                    <ul>
                                        <li>
                                            <i class="desc-name">住宅地址: </i>
                                            <select name="" id="liveProvince" class="form-control city">

                                            </select>
                                            <select name="" id="liveCity" class="form-control city">

                                            </select>
                                            <select name="" id="liveArea" class="form-control city">

                                            </select>
                                            <input id="baseAddress" style="width: 450px;" type="text" class="form-control"
                                                   :value="baseInfo.address">
                                        </li>
                                    </ul>
                                    <div class="live-status-box">
                                        <i class="desc-name pull-left" style="margin-top: 10px;">居住状况:</i>
                                        <div class="live-status">
                                            <label for="buy">
                                                <input checked type="radio" name="houseStatus" id="buy"
                                                       value="1">一次性购买
                                            </label>
                                            <label for="payForMonth">
                                                <input type="radio" name="houseStatus" id="payForMonth"
                                                       value="2">按揭(月还款)
                                                <input id="payForMonthMoney" type="text" class="form-control pay-month hide" value="0">
                                            </label>
                                            <label for="rent">
                                                <input type="radio" name="houseStatus" id="rent" value="3">租赁(月租金)
                                                <input id="rentMoney" type="text" class="form-control pay-month hide" value="0">
                                            </label>
                                            <label for="withParents">
                                                <input type="radio" name="houseStatus" id="withParents"
                                                       value="4">与父母同住
                                            </label>
                                            <label for="selBuild">
                                                <input type="radio" name="houseStatus" id="selBuild" value="5">自建
                                            </label>
                                            <label for="others">
                                                <input type="radio" name="houseStatus" id="others" value="6">其他
                                            </label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--借款人职业及收入信息-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">借款人职业及收入信息</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <form id="workInfo">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">单位性质: </i>
                                            <select class="form-control" name="orgNature">
                                                <option v-for="item in orgNatures"
                                                        :selected="item.value==workInfo.orgNature"
                                                        :value="item.value">{{item.name}}
                                                </option>
                                            </select>
                                        </li>
                                        <li>
                                            <i class="desc-name">职位: </i>
                                            <input name="position" type="text" class="form-control" :value="workInfo.position">
                                        </li>
                                        <li>
                                            <i class="desc-name">年工资收入(元): </i>
                                            <input name="annualIncome" type="number" class="form-control"
                                                   :value="workInfo.annualIncome">
                                        </li>
                                        <li>
                                            <i class="desc-name">家庭年收入合计(元): </i>
                                            <input name="familyIncome" type="number" class="form-control"
                                                   :value="workInfo.familyIncome">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">工作单位: </i>
                                            <input name="orgName" type="text" class="form-control" :value="workInfo.orgName">
                                        </li>
                                        <li>
                                            <i class="desc-name">单位电话: </i>
                                            <input name="orgContact" type="text" class="form-control"
                                                   :value="workInfo.orgContact">
                                        </li>
                                        <li>
                                            <i class="desc-name">年经营收入(元): </i>
                                            <input name="manageIncome" type="number" class="form-control"
                                                   :value="workInfo.manageIncome">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">部门: </i>
                                            <input name="department" type="text" class="form-control"
                                                   :value="workInfo.department">
                                        </li>
                                        <li>
                                            <i class="desc-name">单位地址: </i>
                                            <input name="orgAddress" type="text" class="form-control"
                                                   :value="workInfo.orgAddress">
                                        </li>
                                        <li>
                                            <i class="desc-name">年租金收入(元): </i>
                                            <input name="rentIncome" type="number" class="form-control"
                                                   :value="workInfo.rentIncome">
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                        <!--配偶信息-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">配偶信息</h3>
                            </div>
                            <div class="panel-body clearfix payee-base-info">
                                <form id="spouseInfo">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">姓名: </i>
                                            <input name="relativeName" type="text" class="form-control"
                                                   :value="spouseInfo.relativeName">
                                        </li>
                                        <li>
                                            <i class="desc-name">年龄: </i>
                                            <input name="age" type="number" class="form-control" :value="spouseInfo.age">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">性别: </i>
                                            <select name="sex" class="form-control">
                                                <option v-for="item in sexs" :value="item.value"
                                                        :selected="item.value==spouseInfo.sex">{{item.name}}
                                                </option>
                                            </select>
                                        </li>
                                        <li>
                                            <i class="desc-name">身份证号: </i>
                                            <input name="idCardNum" type="text" class="form-control"
                                                   :value="spouseInfo.idCardNum">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">民族: </i>
                                            <input name="nation" type="text" class="form-control" :value="spouseInfo.nation">
                                        </li>
                                        <li>
                                            <i class="desc-name">联系电话: </i>
                                            <input name="relativeMobile" type="number" class="form-control"
                                                   :value="spouseInfo.relativeMobile">
                                        </li>
                                    </ul>
                                    <div>
                                        <i class="desc-name">住宅地址: </i>
                                        <input name="address" type="text" class="form-control parter-house"
                                               :value="spouseInfo.address">
                                    </div>
                                    <div class="live-status-box">
                                        <i class="desc-name pull-left" style="margin-top: 10px;">工作单位:</i>
                                        <input type="input" name="orgName" class="form-control" :value="spouseInfo.orgName">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--紧急联系人信息-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">紧急联系人信息</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <form id="relativesInfo">
                                    <div class="clearfix" v-for="(item,index) in relativesInfo">
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">联系人{{index+1}}姓名: </i>
                                                <input name="relativeName" type="text" class="form-control relName" :value="item.relativeName">
                                            </li>
                                            <li>
                                                <i class="desc-name">与借款人关系: </i>
                                                <select class="form-control relType" name="relativeType">
                                                    <option :value="relShip.value"
                                                            v-for="relShip in relationship"
                                                            :selected="relShip.value==item.relativeType">
                                                        {{relShip.name}}
                                                    </option>
                                                </select>
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">性别: </i>
                                                <select name="sex" class="form-control relSex">
                                                    <option v-for="sexItem in sexs" :value="sexItem.value"
                                                            :selected="sexItem.value==item.sex">
                                                        {{sexItem.name}}
                                                    </option>
                                                </select>
                                            </li>
                                            <li>
                                                <i class="desc-name">地址: </i>
                                                <input name="address" type="text" class="form-control relAddr" :value="item.address">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">联系人{{index+1}}电话: </i>
                                                <input name="relativeMobile" type="number" class="form-control relMobile" :value="item.relativeMobile">
                                            </li>
                                        </ul>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--抵押物信息-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">抵押物信息</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <form id="pawnInfo">
                                    <div class="pawn-place">
                                        <i class="desc-name">地址: </i>
                                        <select name="" id="pawnProvince" class="form-control city">
                                        </select>
                                        <select name="" id="pawnCity" class="form-control city">
                                        </select>
                                        <select name="" id="pawnArea" class="form-control city">
                                        </select>
                                        <input id="pawnAddr" style="width: 450px;" type="text"
                                               class="form-control parter-house" :value="housePawnInfo.address">
                                    </div>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">产权号: </i>
                                            <input name="warrantNo" type="text" class="form-control"
                                                   :value="housePawnInfo.warrantNo">
                                        </li>
                                        <li class="relative">
                                            <i class="desc-name">市场价格: </i>
                                            <input name="marketMoney" type="number" class="form-control"
                                                   :value="housePawnInfo.marketMoney">
                                            <span class="unit">元</span>
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">所有权人: </i>
                                            <input name="owner" type="text" class="form-control"
                                                   :value="housePawnInfo.owner">
                                        </li>
                                        <li class="relative">
                                            <i class="desc-name">贷款金额(元): </i>
                                            <input name="loanMoney" type="number" class="form-control"
                                                   :value="housePawnInfo.loanMoney">
                                            <span class="unit">元</span>
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li class="relative">
                                            <i class="desc-name">面积: </i>
                                            <input name="coveredArea" type="number" class="form-control"
                                                   :value="housePawnInfo.coveredArea">
                                            <span class="unit">m<sup>2</sup></span>
                                        </li>
                                        <li>
                                            <i class="desc-name">贷款期限(年): </i>
                                            <input name="loanTerm" type="number" class="form-control"
                                                   :value="housePawnInfo.loanTerm">
                                        </li>
                                    </ul>

                                </form>
                            </div>
                        </div>
                        <!--其他个人资产信息-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">其他个人资产信息</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <form id="userCar">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">车辆品牌: </i>
                                            <input name="brand" type="text" class="form-control" :value="carInfo.brand">
                                        </li>
                                        <li>
                                            <i class="desc-name">房产地址: </i>
                                            <input id="houseAddress" name="address" type="text" class="form-control"
                                                   :value="houseInfo.address">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">购车时间: </i>
                                            <input name="buyDate" id="buyCarTime" type="text" class="form-control" :value="carInfo.buyDate | formatTime">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">购车价格(元): </i>
                                            <input name="buyPrice" type="number" class="form-control" :value="carInfo.buyPrice">
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                        <!--其他个人负债情况-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">其他个人负债情况</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <form id="debtInfo">
                                    <div class="clearfix">
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">贷款机构1: </i>
                                                <input id="orgName01" type="text" class="form-control" :value="debtInfo[0].orgName">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">金额(元): </i>
                                                <input id="loanMoney01" type="number" class="form-control" :value="debtInfo[0].loanMoney">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">起止日期: </i>
                                                <input id="beginTime01" type="text" class="form-control city02"
                                                       :value="debtInfo[0].beginTime">
                                                -
                                                <input id="endTime01" type="text" class="form-control city02"
                                                       :value="debtInfo[0].endTime">
                                            </li>
                                        </ul>
                                        <div>
                                            <i class="desc-name">担保措施: </i>
                                            <textarea id="warrantWay01" rows="5" class="form-control" name=""
                                                      placeholder="请输入担保措施">{{debtInfo[0].warrantWay}}</textarea>
                                        </div>
                                    </div>
                                    <div class="clearfix" style="margin-top: 25px;">
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">贷款机构2: </i>
                                                <input id="orgName02" type="text" class="form-control" :value="debtInfo[1].orgName">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">金额(元): </i>
                                                <input id="loanMoney02" type="number" class="form-control" :value="debtInfo[1].loanMoney">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name">起止日期: </i>
                                                <input id="beginTime02" type="text" class="form-control city02"
                                                       :value="debtInfo[1].beginTime">
                                                -
                                                <input id="endTime02" type="text" class="form-control city02"
                                                       :value="debtInfo[1].endTime">
                                            </li>
                                        </ul>
                                        <div>
                                            <i class="desc-name">担保措施: </i>
                                            <textarea id="warrantWay02" rows="5" class="form-control" name=""
                                                      placeholder="请输入担保措施">{{debtInfo[1].warrantWay}}</textarea>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--贷款用途-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">贷款用途</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <div class="panel-body clearfix payee-base-info">
                                    <form id="usageForm">
                                        <div class="live-status-box">
                                            <div class="live-status" style="margin-left: 0;">
                                                <label :for="item.id" v-for="item in usage">
                                                    <input :checked="applyInfo.usageId == item.value"
                                                           type="radio" name="usageId" :id="item.id"
                                                           :value="item.id">{{item.labelText}}
                                                </label>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--附件-->
                    <div class="panel panel-info asset-images">
                        <div class="panel-heading">
                            <h3 class="panel-title">附件</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <c:if test="${fn:contains(roleType, 'businessCommissioner')}">
                            <button id="delPics" class="btn btn-danger pull-right">一键删除</button>
                            </c:if>
                            <ul class="asset-prove">
                                <!--<li>-->
                                <!--<p>房产</p>-->
                                <!--<span>-->
                                    <!--<img data-magnify="gallery" src="static/img/02.jpg" data-src="static/img/02.jpg" alt="">-->
                                    <!--<input type="checkbox" value="aaa" name="attachPic">-->
                                <!--</span>-->
                                <!--</li>-->
                            </ul>
                        </div>
                    </div>
                    <!--上传资料（业务人员补充）-->
                    <div class="panel panel-info contact-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">上传资料（业务人员补充）</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div id="fileUploadContent" class="fileUploadContent">
                                <div class="upload-control clearfix">
                                    <select name="uploadProve" id="uploadProve" class="form-control"></select>
                                    <div id="filePicker">选择图片</div>
                                    <button class="btn btn-success" id="uploadBtn">点击上传</button>
                                    <button class="btn btn-danger" id="clearBtn">清空列表</button>
                                </div>
                                <div id="fileList" class="uploader-list clearfix"></div>
                            </div>
                        </div>
                    </div>
                    <div class="control">
                        <a href="<%=basePath%>baseInfoPrint.html?orderId=<%=orderId%>" target="_blank" class="btn btn-print btn-new" id="printBaseInfo">业务申请表预览</a>
                        <c:if test="${fn:contains(roleType, 'businessCommissioner')}">
                            <button class="btn btn-submit btn-new" id="saveBaseInfo">保存</button>
                        </c:if>
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
    </div>
</div>
<script src="static/plugins/vue/vue.js"></script>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script src="<%=basePath%>static/js/province.js"></script>
<script src="static/plugins/webuploader/webuploader.nolog.js"></script>
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
    var creditInfo = {
        vari: {
            orderId: '<%=orderId%>',
            usage: {}
        },
        vm: {},
        init: function () {
            this.asyncAjax();
            this.renderProvince();
            this.getData();
            var flag = '${fn:contains(roleType, "businessCommissioner")}' === 'false' ? true : false;
            if(flag){
                $('input').attr('disabled',true);
                $('textarea').attr('disabled',true);
                $('select').attr('disabled',true);
            }
        },
        bindEvent: function () {
            var _this = this;
            this.houseStatus();
            // 点击保存
            $('#saveBaseInfo').on('click',function () {
                _this.saveData();
            })
            myOrderTpl.getUploadSel(2,function () {
                myOrderTpl.uploadImgs();
            })
            // 删除附件图片
            $('#delPics').click(function () {
                var value = myOrderTpl.getiCheckItem('attachPic');
                if(value.length == 0) {
                    myOrderTpl.alertModel('请至少选择一张图片附件!');
                    return;
                }
                _this.delAttachPics(value);

            })
        },
        // 获取数据
        getData: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/loanOrder/getOrderBaseInfo'),
                method: 'POST',
                data: {orderId: this.vari.orderId},
                success: function (res) {
                    if (res.status == 0) {
                        _this.newVue(res.data);

                        _this.renderIcheck();
                        _this.renderTime();
                        _this.renderCreditArea($('#liveProvince'),$('#liveCity'),$('#liveArea'));
                        _this.renderCreditArea($('#pawnProvince'),$('#pawnCity'),$('#pawnArea'));
                        aloneRender(res.data);

                        if(res.data.attachMaterial.length > 0){
                            renderAssetProve(res.data.attachMaterial,'asset-prove');
                            $('.asset-images').show();
                        }
                        _this.bindEvent();
                        _this.initImages();

                    } else {
                        if (res.msg == '' || res.msg == 'undefined') {
                            myOrderTpl.alertModel('基础信息获取失败，请稍后刷新重试!');
                        } else {
                            myOrderTpl.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    myOrderTpl.alertModel(error);
                }
            })

            // 单独渲染
            function aloneRender(data) {
                // 居住状况
                $('input[name="houseStatus"]').each(function (k, v) {
                    if ($(this).val() == data.baseInfo.addressNature) {
                        $('.pay-month').addClass('hide');
                        $(this).iCheck('check');
                        if (data.baseInfo.addressNature == 2 || data.baseInfo.addressNature == 3) {
                            $(this).parents('label').find('.pay-month').removeClass('hide').val(data.baseInfo.addressMoney);
                        }
                    }
                })
                // 住宅地址
                $('#liveProvince').val(data.baseInfo.province);
                // 回填省市县
                cbAddress(
                    $('#liveCity'),
                    $('#liveArea'),
                    data.baseInfo.province,
                    data.baseInfo.city,
                    data.baseInfo.county
                );
                if(data.housePawnInfo.length != 0) {
                    // 抵押物地址
                    $('#pawnProvince').val(data.housePawnInfo[0].province);
                    // 回填省市县
                    cbAddress(
                        $('#pawnCity'),
                        $('#pawnArea'),
                        data.housePawnInfo[0].province,
                        data.housePawnInfo[0].city,
                        data.housePawnInfo[0].county
                    );
                }

                function cbAddress($city,$area,provinceVal,cityVal,areaVal) {
                    // 根据省份请求城市
                    $city.empty();
                    $.ajax({
                        method: 'POST',
                        url: util.getServerUrl('/areaCtr/getAreaByParentId'),
                        data: {parentId: provinceVal},
                        dataType: 'json',
                        success: function (data) {
                            if(data.result!=undefined){
                                var cityList = data.result, optionList = '<option value="">-请选择城市-</option>';
                                $.each(cityList, function (n, value) {
                                    optionList += "<option value='" + value.id + "'>" + value.name + "</option>";
                                });
                                $city.html(optionList);
                                $city.val(cityVal);
                            }
                        }
                    });
                    $area.empty();
                    $.ajax({
                        method: 'POST',
                        url: util.getServerUrl('/areaCtr/getAreaByParentId'),
                        data: {parentId: cityVal},
                        dataType: 'json',
                        success: function (data) {
                            if(data.result!=undefined){
                                var cityList = data.result, optionList = '<option value="">-请选择城市-</option>';
                                $.each(cityList, function (n, value) {
                                    optionList += "<option value='" + value.id + "'>" + value.name + "</option>";
                                });
                                $area.html(optionList);
                                $area.val(areaVal);
                            }
                        }
                    });
                }
            }
            // 渲染图片
            function renderAssetProve(data,target) {
                var str = '';
                $.each(data,function (k, v) {
                    var attachIds = v.attachId.split(',');
                    str += '<li>';
                    str += '<p>'+v.fileTag+'</p>';
                    if(/^http/g.test(v.filePath)){
                        $.each(v.filePath.split(','),function (key, val) {
                            str += '<img data-magnify="gallery" src="'+val+'" data-src="'+val+'" alt="">';
                        })
                    }else{
                        $.each(attachIds,function (key, val) {
                            str += '<span>';
                            str += '<img data-magnify="gallery" src="'+(util.getImgTmpUrl("/attachment/download?attachId=")+val)+'" data-src="'+(util.getImgTmpUrl("/attachment/download?attachId=")+val)+'" alt="">';
                            str += '<input type="checkbox" value="'+ val +'" name="attachPic">'
                            str += '</span>';
                        })
                    }
                    str +='</li>';
                })
                $('.'+target).html(str);
                _this.renderIcheck();
            }
        },
        newVue: function (data) {
            var _this = this;
            this.vm = new Vue({
                el: '#baseInfo',
                data: {
                    educations: [
                        {name: '高中',value: '1'},
                        {name: '大专',value: '2'},
                        {name: '大学',value: '3'},
                        {name: '研究生',value: '4'},
                        {name: '中专学校',value: '5'},
                        {name: '技术学校',value: '6'},
                        {name: '初中',value: '7'},
                        {name: '小学',value: '8'},
                        {name: '文盲或半文盲',value: '9'}
                    ],
                    sexs: [
                        {name: '-请选择-', value: ''},
                        {name: '男', value: '1'},
                        {name: '女', value: '0'}
                    ],
                    marrStatus: [
                        {name: '已婚', value: '1'},
                        {name: '未婚', value: '2'},
                        {name: '离异', value: '3'},
                        {name: '丧偶', value: '4'},
                        {name: '再婚', value: '5'}
                    ],
                    orgNatures: [
                        {name: '-请选择-', value: ''},
                        {name: '行政机关', value: '1'},
                        {name: '国有企业', value: '2'},
                        {name: '事业单位', value: '3'},
                        {name: '三资企业', value: '4'},
                        {name: '私营企业', value: '5'},
                        {name: '个体户', value: '6'},
                        {name: '其他', value: '7'}
                    ],
                    relationship: [
                        {name: '-请选择-', value: ''},
                        // {name: '夫妻', value: 1},
                        {name: '父母', value: 2},
                        {name: '儿女', value: 3},
                        {name: '兄妹', value: 4},
                        {name: '亲戚', value: 5},
                        {name: '朋友', value: 6},
                        {name: '同事', value: 7},
                        {name: '同学', value: 8}
                    ],
                    applyInfo: data.applyInfo,
                    baseInfo: data.baseInfo,
                    manageInfo: data.manageInfo,
                    periodInfo : data.periodInfo,
                    usage: _this.vari.usage,
                },
                computed: {
                    // periods: function () { // 申请期限
                    //     var arr = [];
                    //     for (var i = 1; i <= 60; i++) {
                    //         (function (j) {
                    //             var obj = {};
                    //             obj.name = j + '期';
                    //             obj.value = j;
                    //             arr.push(obj);
                    //         })(i)
                    //     }
                    //     return arr;
                    // },
                    debtInfo : function () {
                        var debtInfo = [
                            {
                                orgName:'',
                                loanMoney:'',
                                beginTime:'',
                                endTime:'',
                                warrantWay:'',
                                id:''
                            },
                            {
                                orgName:'',
                                loanMoney:'',
                                beginTime:'',
                                endTime:'',
                                warrantWay:'',
                                id:''
                            },
                        ]
                        if(data.debtInfo.length == 0){
                            return debtInfo;
                        }else if(data.debtInfo.length ==1){
                            debtInfo[0] = data.debtInfo[0];
                            return debtInfo;
                        }
                        return data.debtInfo;
                    },
                    spouseInfo : function () {
                        var spouse = [
                            {
                                "profession": "",
                                "relativeName": "",
                                "address": "",
                                "nation": "",
                                "id":'',
                                "sex": "",
                                "orgName": "",
                                "idCardNum": "",
                                "relativeMobile": "",
                                "age": "",
                                "relativeType": "1"
                            }
                        ];
                        if(data.spouseInfo.length==0){
                            return spouse[0];
                        }
                        return data.spouseInfo[0];
                    },
                    workInfo : function () {
                        var workInfo = {
                            "workYears": "",
                            "orgName": "",
                            "annualIncome": "",
                            "orgContact": "",
                            "familyIncome": '',
                            "orgAddress": "",
                            "manageIncome": '',
                            "orgNature": "",
                            "rentIncome": '',
                            "monthIncome": "",
                            "position": "'",
                            "id": "",
                            "department": ""
                        };
                        if(data.workInfo.length==0){
                            return workInfo;
                        }
                        return data.workInfo;
                    },
                    housePawnInfo : function () {
                        var housePawnInfo = [{
                            "pawnStatus": "",
                            "city": "",
                            "warrantNo": "",
                            "houseAge": '',
                            "companyName": "",
                            "county": "",
                            "loanBalance": '',
                            "isOnly": '',
                            "houseName": "",
                            "webOneName": "",
                            "province": "",
                            "loanMoney": '',
                            "recordDate": '',
                            "pawnBank": "",
                            "id": "",
                            "owner": "",
                            "address": "",
                            "companyPrice": '',
                            "marketMoney": '',
                            "coveredArea": '',
                            "mortgageNo": '',
                            "webOnePrice": '',
                            "loanQuta": '',
                            "userId": "",
                            "webTwoName": "",
                            "loanTerm": '',
                            "createTime": '',
                            "cognizancePrice": '',
                            "webTwoPrice": '',
                            "webThreeName": "",
                            "webThreePrice": '',
                            "remarks": "",
                            "fitmentStatus": ''
                        }]
                        if(data.housePawnInfo.length ==0 ) {
                            return housePawnInfo[0];
                        }
                        return data.housePawnInfo[0];
                    },
                    relativesInfo : function () {
                        var relativesInfo = [
                            {
                                "address": "",
                                "sex": '',
                                "relativeName": "",
                                "relativeMobile": "",
                                "typeName": "",
                                "id": "",
                                "relativeType": ""
                            },
                            {
                                "address": "",
                                "sex": '',
                                "relativeName": "",
                                "relativeMobile": "",
                                "typeName": "",
                                "id": "",
                                "relativeType": ""
                            }
                        ],relativeObj= [];
                        if(data.relativesInfo.length == 0){
                            return relativesInfo;
                        }
                        $.each(data.relativesInfo,function (k, v) {
                            if(v.relativeType != 1){
                                relativeObj.push(v);
                            }
                        })
                        return relativeObj;
                    },
                    carInfo : function () {
                        var carInfo = {
                            "id": "",
                            "version": '',
                            "brand": "",
                            "buyPrice": "",
                            "createDate": '',
                            "delFlag": '',
                            "userId": "",
                            "buyDate": ''
                        }
                        if(data.carInfo.length==0){
                            return carInfo;
                        }
                        return data.carInfo;
                    },
                    houseInfo : function () {
                        var houseInfo = [{
                            "id": "",
                            "buyPrice": "",
                            "address": ''
                        }]
                        if(data.houseInfo.length==0){
                            return houseInfo[0];
                        }
                        return data.houseInfo[0];
                    },
                    repayWays : function () {
                        var repayWays = [];
                        if(data.repayWayInfo.length==0){
                            return repayWays;
                        }
                        return data.repayWayInfo;
                    }

                },
                filters : {
                    formatTime : function (time) {
                        if (time) {
                            var date = new Date(time);
                            return date.getFullYear() + '-' + (preZero(date.getMonth() + 1)) + '-' + preZero(date.getDate()) + ' ' + preZero(date.getHours()) + ':' + preZero(date.getMinutes()) + ':' + preZero(date.getSeconds());
                        }
                        function preZero(num) {
                            num = '' + num;
                            return num.length == 1 ? '0' + num : num;
                        }
                    },
                    monthRating : function (value) {
                        return Number(value).div(12).toFixed(6);
                    }
                }
            })
        },
        // 保存数据
        saveData : function(){
            var params = {
                spouseInfo : {},
                relativesInfo : [],
                pawnInfo : [],
                userCar : {},
                debtInfo : [],
                houseInfo : []
            };
            var _this = this;
            //  申请信息
            for (var i = 0; i < $('#applyInfo').serializeArray().length; i++) {
                params[$('#applyInfo').serializeArray()[i].name] = $('#applyInfo').serializeArray()[i].value
            }
            if(Number($('#auditRating').val()) > 999) {
                myOrderTpl.alertModel('利率输入过大!');
                return;
            }
            params.auditRating = Number(params.auditRating).mul(12);
            // 借款人基本信息
            for (var i = 0; i < $('#borrowerBaseInfo').serializeArray().length; i++) {
                params[$('#borrowerBaseInfo').serializeArray()[i].name] = $('#borrowerBaseInfo').serializeArray()[i].value
            }
            delete params.houseStatus; // 手动删除居住状况，重新获取
            params.province = $('#liveProvince').val();
            params.city = $('#liveCity').val();
            params.county = $('#liveArea').val();
            params.address = $('#baseAddress').val();
            params.addressNature = myOrderTpl.getiCheckItem('houseStatus')[0];
            params.addressMoney = getAddressMoney();
            // 工作信息
            for (var i = 0; i < $('#workInfo').serializeArray().length; i++) {
                params[$('#workInfo').serializeArray()[i].name] = $('#workInfo').serializeArray()[i].value;
                if($('#workInfo').serializeArray()[i].value != ''){
                    params.workId = this.vm.workInfo.id;
                }
            }
            // 配偶信息
            for (var i = 0; i < $('#spouseInfo').serializeArray().length; i++) {
                params['spouseInfo'][$('#spouseInfo').serializeArray()[i].name] = $('#spouseInfo').serializeArray()[i].value;
                if($('#spouseInfo').serializeArray()[i].value != ''){
                    params['spouseInfo']['id'] = this.vm.spouseInfo.id;
                }
            }
            params['spouseInfo']['relativeType'] = 1;
            var spouseInfo = JSON.stringify(params.spouseInfo); // 将键值对用string保存
            params.spouseInfo = spouseInfo;
            // 紧急联系人信息
            if($('.relName').eq(0).length >= 1){
                params.relativesInfo.push({
                    relativeName : $('.relName').eq(0).val(),
                    relativeType : $('.relType').eq(0).val(),
                    sex : $('.relSex').eq(0).val(),
                    address : $('.relAddr').eq(0).val(),
                    relativeMobile : $('.relMobile').eq(0).val(),
                    id : this.vm.relativesInfo[0].id
                })
            }
            if($('.relName').eq(1).length >= 1){
                params.relativesInfo.push({
                    relativeName : $('.relName').eq(1).val(),
                    relativeType : $('.relType').eq(1).val(),
                    sex : $('.relSex').eq(1).val(),
                    address : $('.relAddr').eq(1).val(),
                    relativeMobile : $('.relMobile').eq(1).val(),
                    id : this.vm.relativesInfo[1].id
                })
            }
            var relativesInfo = JSON.stringify(params.relativesInfo);// 将键值对用string保存
            params.relativesInfo = relativesInfo;
            // 抵押物信息
            var tmpPawnInfo = {};
            for (var i = 0; i < $('#pawnInfo').serializeArray().length; i++) {
                tmpPawnInfo[$('#pawnInfo').serializeArray()[i].name] = $('#pawnInfo').serializeArray()[i].value;
                if($('#pawnInfo').serializeArray()[i].value != ''){
                    tmpPawnInfo.id = this.vm.housePawnInfo.id;
                }
            }
            tmpPawnInfo['province']=$("#pawnProvince").val();
            tmpPawnInfo['city']=$("#pawnCity").val();
            tmpPawnInfo['county']=$("#pawnArea").val();
            tmpPawnInfo['address']=$("#pawnAddr").val();
            params.pawnInfo.push(tmpPawnInfo);
            var pawnInfo = JSON.stringify(params.pawnInfo);// 将键值对用string保存
            params.pawnInfo = pawnInfo;
            // 其他个人资产信息
            for (var i = 0; i < $('#userCar').serializeArray().length; i++) {
                params['userCar'][$('#userCar').serializeArray()[i].name] = $('#userCar').serializeArray()[i].value;
                if($('#userCar').serializeArray()[i].value != ''){
                    params.userCar.id = this.vm.carInfo.id;
                }
            }
            if(params.userCar.buyDate != ''){
                params.userCar.buyDate += ' 00:00:00';
            }
            var userCar = JSON.stringify(params.userCar);// 将键值对用string保存
            params.userCar = userCar;
            // 其他个人资产中houseInfo
            var houseInfoObj = {address:$.trim($('#houseAddress').val())};
            if(houseInfoObj.address!=''){
                houseInfoObj.id = this.vm.houseInfo.id;
            }
            params.houseInfo.push(houseInfoObj);
            var houseInfo = JSON.stringify(params.houseInfo);// 将键值对用string保存
            params.houseInfo = houseInfo;
            // 其他个人负债情况
            params.debtInfo.push({
                orgName : $('#orgName01').val(),
                loanMoney : $('#loanMoney01').val(),
                beginTime : $('#beginTime01').val(),
                endTime : $('#endTime01').val(),
                warrantWay : $('#warrantWay01').val(),
            })
            params.debtInfo.push({
                orgName : $('#orgName02').val(),
                loanMoney : $('#loanMoney02').val(),
                beginTime : $('#beginTime02').val(),
                endTime : $('#endTime02').val(),
                warrantWay : $('#warrantWay02').val(),
            })
            $.each(params.debtInfo,function (key, val) {
                for (var k in val){
                    if(k=='beginTime' || k == 'endTime'){
                        if(val[k] != ''){
                            val[k] += ' 00:00:00';
                        }
                    }
                    if(val[k] != ''){
                        val['id'] = _this.vm.debtInfo[key].id;
                    }
                }
            })
            var debtInfo = JSON.stringify(params.debtInfo);// 将键值对用string保存
            // 贷款用途
            params.usageId = myOrderTpl.getiCheckItem('usageId')[0];
            params.debtInfo = debtInfo;
            params.orderId = this.vari.orderId;
            $.ajax({
                url: util.getServerUrl('/loanOrder/saveOrderBaseInfo'),
                method: 'POST',
                data: params,
                success: function (res) {
                    if (res.status == 0) {
                        myOrderTpl.alertModel('订单保存成功');
                    } else {
                        if (res.msg == '' || res.msg == 'undefined') {
                            myOrderTpl.alertModel('基础信息保存失败!');
                        } else {
                            myOrderTpl.alertModel(res.data);
                        }
                    }
                },
                error: function (error) {
                    myOrderTpl.alertModel(error);
                }
            })
            // 获取居住状况
            function getAddressMoney() {
                var val = myOrderTpl.getiCheckItem('houseStatus')[0];
                if(val == 3){
                    return $('#rentMoney').val();
                }else if(val ==4){
                    return $('#payForMonthMoney').val();
                }else {
                    return '';
                }
            }
        },
        // 同步请求
        asyncAjax: function () {
            var _this = this;
            // 获取贷款用途
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType?type=CPYTPZ'),
                method: 'POST',
                async: false,
                success: function (res) {
                    if (res.status == 0) {
                        _this.vari.usage = res.data;
                    } else {
                        myOrderTpl.alertModel('获取贷款用途出错')
                    }
                },
                error: function (error) {
                    myOrderTpl.alertModel(error)
                }
            })
        },
        // 渲染选择时间组件
        renderTime : function () {
            var i18n = { // 本地化
                previousMonth: '上个月',
                nextMonth: '下个月',
                months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
                weekdays: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
                weekdaysShort: ['日', '一', '二', '三', '四', '五', '六']
            }
            var buyCarTime = new Pikaday({
                field: $('#buyCarTime')[0] ,
                i18n : i18n,
                format: 'YYYY-M-D',
            });
            var beginTime01 = new Pikaday({
                field: $('#beginTime01')[0] ,
                i18n : i18n,
                format: 'YYYY-M-D',
            });
            var endTime01 = new Pikaday({
                field: $('#endTime01')[0] ,
                i18n : i18n,
                format: 'YYYY-M-D',
            });
            var beginTime02 = new Pikaday({
                field: $('#beginTime02')[0] ,
                i18n : i18n,
                format: 'YYYY-M-D',
            });
            var endTime02 = new Pikaday({
                field: $('#endTime02')[0] ,
                i18n : i18n,
                format: 'YYYY-M-D',
            });
        },
        // 渲染radio和checkbox
        renderIcheck: function () {
            $('input[type="radio"]').iCheck({
                radioClass: 'iradio_minimal-blue'
            });
            $('input[type="checkbox"]').iCheck({
                checkboxClass: 'icheckbox_minimal-blue'
            });
        },
        // 借款人居住性质radio点击、配偶信息职业点击
        houseStatus: function () {
            //居住性质
            $('input[name="houseStatus"]').on('ifClicked', function () {
                $('.pay-month').addClass('hide');
                if ($(this).attr('id') == 'rent') {
                    $(this).parents('label').find('.pay-month').removeClass('hide')
                }
                if ($(this).attr('id') == 'payForMonth') {
                    $(this).parents('label').find('.pay-month').removeClass('hide')
                }
            })


        },
        // 渲染省份
        renderProvince : function(){
            var str = '<option value="">-请选择-</option>';
            $.each(provinceData,function (k, v) {
                str += '<option value="'+v.id+'">'+v.name+'</option>';
            });
            $('#liveProvince').html(str);
            $('#pawnProvince').html(str);
        },
        // 两级联动
        renderCreditArea: function ($province,$city,$area) {
            // 省份改变
            $province.change(function () {
                $city.empty();
                $area.empty();
                $.ajax({
                    method: 'POST',
                    url: util.getServerUrl('/areaCtr/getAreaByParentId'),
                    data: {parentId: $(this).val()},
                    dataType: 'json',
                    success: function (data) {
                        if(data.result!=undefined){
                            var cityList = data.result, optionList = '<option value="">-请选择城市-</option>';
                            $.each(cityList, function (n, value) {
                                optionList += "<option value='" + value.id + "'>" + value.name + "</option>";
                            });
                            $city.html(optionList);
                        }

                    }
                });
            });
            // 城市改变
            $city.change(function () {
                $area.empty();
                $.ajax({
                    method: 'POST',
                    url: util.getServerUrl('/areaCtr/getAreaByParentId'),
                    data: {parentId: $(this).val()},
                    dataType: 'json',
                    success: function (data) {
                        if(data.result!=undefined){
                            var cityList = data.result, optionList = '<option value="">-请选择城市-</option>';
                            $.each(cityList, function (n, value) {
                                optionList += "<option value='" + value.id + "'>" + value.name + "</option>";
                            });
                            $area.html(optionList);
                        }

                    }
                });
            });
        },
        // 初始化图片
        initImages : function () {
            $('[data-magnify="gallery"]').magnify({
                i18n : {
                    minimize : '最小化',
                    maximize  : '最大化',
                    close : '关闭',
                    zoomIn  : '放大',
                    zoomOut  : '缩小',
                    prev  : '上一张',
                    next : '下一张',
                    fullscreen  : '全屏',
                    actualSize  : '自适应',
                    rotateLeft  : '左旋转',
                    rotateRight  : '右旋转',
                },
                icons:{
                    fullscreen : 'fa fa-arrows-alt',
                },
                footToolbar : ['zoomIn','zoomOut','prev','fullscreen','next','rotateLeft','rotateRight'],
                headToolbar : ['maximize','close']
            });
        },
        // 删除图片
        delAttachPics : function (data) {
            $.ajax({
                url : util.getServerUrl('/loanOrder/deleteOrderAttach'),
                method : 'POST',
                data : {
                    attachIds : data.join(','),
                    orderId : this.vari.orderId
                },
                success : function (res) {
                    if (res.status == 0){
                        myOrderTpl.alertSuccessModel('图片删除成功!', function () {
                            $('#navTab').load('<%=basePath%>loanOrder/myOrderBaseInfoPage?orderId=<%=orderId%>');
                        });
                    } else {
                        if (res.msg == '' || res.msg == 'undefined') {
                            myOrderTpl.alertModel('图片删除失败，请稍后重试!');
                        } else {
                            myOrderTpl.alertModel(res.msg);
                        }
                    }
                },
                error : function (error) {
                    myOrderTpl.alertModel(error);
                }
            })
        }
    }
    $(function () {
        creditInfo.init();
    })
</script>