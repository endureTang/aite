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
<link rel="stylesheet" href="static/plugins/jRebox/jquery-rebox.css">

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
                <li class="active"><a href="<%=basePath%>loanOrder/myOrderInvestigatePage?orderId=<%=orderId%>"
                                      aria-controls="three" role="tab" data-toggle="tab" data-target="navTab">业务调查</a>
                </li>
                <li><a href="<%=basePath%>loanOrder/myOrderBusinessApprovePage?orderId=<%=orderId%>"
                       aria-controls="fore" role="tab" data-toggle="tab" data-target="navTab">业务审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderContractsPage?orderId=<%=orderId%>" aria-controls="five"
                       role="tab" data-toggle="tab" data-target="navTab">合同管理</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderLoanApprovePage?orderId=<%=orderId%>" aria-controls="six"
                       role="tab" data-toggle="tab" data-target="navTab">放款审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderOperateLogPage?orderId=<%=orderId%>" aria-controls="seven"
                       role="tab" data-toggle="tab" data-target="navTab">操作日志</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content" id="investigateInfo" v-cloak>
                <div class="tab-pane active" id="three">
                    <!--申请部门-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">申请部门</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <form id="applyInfo">
                                <ul class="base-info">
                                    <li class="relative">
                                        <i class="desc-name text-right">业务部: </i>
                                        <input name="department" type="text" class="form-control"
                                               :value="businessSurveyInfo.department">
                                        <span class="unit">部</span>
                                    </li>
                                    <li>
                                        <i class="desc-name text-right">客户经理: </i>
                                        <select class="form-control" name="channelUserId" id="">
                                            <option value="">-请选择客户经理-</option>
                                            <option :selected="item.id==businessSurveyInfo.channelUserId"
                                                    v-for="item in manageInfo" :value="item.id">{{item.user_name}}
                                            </option>
                                        </select>
                                    </li>
                                </ul>
                                <ul class="base-info">
                                    <li>
                                        <i class="desc-name text-right">日期: </i>
                                        <input name="createTime" disabled type="text" class="form-control css-disabled"
                                               :value="businessSurveyInfo.createTime | formatTime">
                                    </li>
                                    <li>
                                        <i class="desc-name text-right">编号: </i>
                                        <input name="businessNo" disabled type="text" class="form-control css-disabled"
                                               :value="businessSurveyInfo.businessNo">
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
                        <div class="panel-body clearfix">
                            <form id="baseInfo">
                                <div class="borrower01">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">主借人姓名: </i>
                                            <input name="name" readonly type="text" class="form-control css-disabled"
                                                   :value="baseInfo.name">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">主借人电话: </i>
                                            <input name="phone" readonly type="number" class="form-control css-disabled"
                                                   :value="baseInfo.phone">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">主借人身份证: </i>
                                            <input name="identity" readonly type="text"
                                                   class="form-control css-disabled" :value="baseInfo.identity">
                                        </li>
                                    </ul>
                                </div>
                                <div class="borrower02">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">配偶姓名: </i>
                                            <input name="relativeName" readonly type="text"
                                                   class="form-control css-disabled"
                                                   :value="spouseInfo[0].relativeName">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">配偶电话: </i>
                                            <input name="relativeMobile" readonly type="number"
                                                   class="form-control css-disabled"
                                                   :value="spouseInfo[0].relativeMobile">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">配偶身份证: </i>
                                            <input name="idCardNum" readonly type="text"
                                                   class="form-control css-disabled" :value="spouseInfo[0].idCardNum">
                                        </li>
                                    </ul>
                                </div>
                                <div class="borrower03">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">共借人姓名: </i>
                                            <input id="togetherName" name="togetherName" type="text"
                                                   class="form-control"
                                                   :value="businessSurveyInfo.togetherName">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">共借人电话: </i>
                                            <input id="togetherMobile" name="togetherMobile" type="number"
                                                   class="form-control"
                                                   :value="businessSurveyInfo.togetherMobile">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">共借人身份证: </i>
                                            <input id="togetherIdentity" name="togetherIdentity" type="text"
                                                   class="form-control" :value="businessSurveyInfo.togetherIdentity">
                                        </li>
                                    </ul>
                                </div>
                                <div class="mb20">
                                    <i class="desc-name text-right">主借人常住地址: </i>
                                    <select readonly name="province" id="liveProvince"
                                            class="form-control city css-disabled">

                                    </select>
                                    <select readonly name="city" id="liveCity" class="form-control city css-disabled">

                                    </select>
                                    <select readonly name="county" id="liveArea" class="form-control city css-disabled">

                                    </select>
                                    <input name="address" disabled type="text" style="width: 450px;"
                                           class="form-control css-disabled" :value="baseInfo.address">
                                </div>
                                <div class="borrower-work">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">主借人单位部门: </i>
                                            <input name="department" readonly type="text"
                                                   class="form-control css-disabled" :value="workInfo.department">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">职位: </i>
                                            <input name="position" readonly type="text"
                                                   class="form-control css-disabled" :value="workInfo.position">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">单位电话: </i>
                                            <input name="orgContact" readonly type="text"
                                                   class="form-control css-disabled" :value="workInfo.orgContact">
                                        </li>
                                    </ul>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!--贷款要素-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">贷款要素</h3>
                        </div>
                        <div class="panel-body clearfix borrow-factor">
                            <form id="borrowFactor">
                                <div class="clearfix">
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">贷款金额: </i>
                                            <input name="amount" type="number" class="form-control text-red"
                                                   :value="applyInfo.amount">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">贷款期限: </i>
                                            <input name="period" type="number" class="form-control text-red"
                                                   :value="applyInfo.period">
                                        </li>
                                    </ul>
                                </div>
                                <div class="mb20">
                                    <i class="desc-name text-right">产品类型: </i>
                                    <label class="mr60">
                                        <input type="radio" name="productType" value="1">一抵产品
                                    </label>
                                    <label>
                                        <input type="radio" name="productType" value="2">二抵产品
                                    </label>
                                </div>
                                <div class="guarantee mb20">
                                    <i class="desc-name text-right">抵押物类型: </i>
                                    <label>
                                        <input type="radio" name="pawnType" value="0">一类房产
                                    </label>
                                    <label>
                                        <input type="radio" name="pawnType" value="1">二类房产
                                    </label>
                                    <label>
                                        <input type="radio" name="pawnType" value="2">三类房产
                                    </label>
                                </div>
                                <div class="guarantee mb20">
                                    <i class="desc-name text-right">抵押物区域: </i>
                                    <label>
                                        <input type="radio" name="pawnArea" value="0">一类区域
                                    </label>
                                    <label>
                                        <input type="radio" name="pawnArea" value="1">二类区域
                                    </label>
                                    <label>
                                        <input type="radio" name="pawnArea" value="2">三类区域
                                    </label>
                                </div>
                            </form>
                            <div class="mb20 clearfix pay-type">
                                <i class="desc-name text-right pull-left">还款方式及利率: </i>
                                <div style="margin-left: 120px;">
                                    <label>
                                        <input type="radio" name="payType" value="10101">
                                        <span class="name">等本等息</span>
                                        <span style="margin: 0 15px;">月利率:</span>
                                        <input id="rating01" type="number" class="form-control text-red" value=""
                                               oninput="if(value.length>8)value=value.slice(0,8)"
                                               style="margin-right: 15px;">%
                                    </label>
                                    <label>
                                        <input type="radio" name="payType" value="10110">
                                        <span class="name">先息后本</span>
                                        <span style="margin: 0 15px;">月利率:</span>
                                        <input id="rating02" type="number" class="form-control text-red" value=""
                                               oninput="if(value.length>8)value=value.slice(0,8)"
                                               style="margin-right: 15px;">%
                                    </label>
                                </div>
                            </div>
                            <div class="mb20 clearfix pay-type">
                                <i class="desc-name text-right pull-left">贷款用途: </i>
                                <div style="margin-left: 120px;">
                                    <label>
                                        <input type="radio" name="borrowFor" value="0">
                                        <span class="name">个人经营性贷款</span>
                                        <span style="margin: 0 21px;">用于:</span>
                                        <input id="usageDesc01" type="text" class="form-control text-red">
                                    </label>
                                    <label>
                                        <input type="radio" name="borrowFor" value="1">
                                        <span class="name">个人消费贷款</span>
                                        <span style="margin: 0 21px;">购买:</span>
                                        <input id="usageDesc02" type="text" class="form-control text-red">
                                    </label>
                                </div>
                            </div>

                        </div>
                    </div>
                    <!--借款人综合情况调查-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">借款人综合情况调查</h3>
                        </div>
                        <div class="panel-body clearfix all-status-container">
                            <form id="pawnInfo">
                                <div class="pledge-container">
                                    <h3>一、抵押物情况:</h3>
                                    <div class="clearfix">
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name text-right">小区名称: </i>
                                                <input name="houseName" type="text" class="form-control"
                                                       :value="housePawnInfo.houseName">
                                            </li>
                                        </ul>
                                        <ul class="base-info" style="width: 900px;">
                                            <li>
                                                <i class="desc-name text-right">小区地址: </i>
                                                <select name="province" id="pledgeProvince"
                                                        class="form-control city02 mr25">

                                                </select>
                                                <select name="city" id="pledgeCity" class="form-control city02 mr25">

                                                </select>
                                                <select name="county" id="pledgeArea" class="form-control city02 mr25">

                                                </select>
                                                <input name="address" type="text" class="form-control"
                                                       style="width: 320px;" :value="housePawnInfo.address">
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="clearfix">
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name text-right">产权号: </i>
                                                <input name="warrantNo" type="text" class="form-control text-red"
                                                       :value="housePawnInfo.warrantNo">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name text-right">所有权人: </i>
                                                <input name="owner" type="text" class="form-control text-red"
                                                       :value="housePawnInfo.owner">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li class="relative">
                                                <i class="desc-name text-right">面积: </i>
                                                <input name="coveredArea" type="text" class="form-control text-red"
                                                       :value="housePawnInfo.coveredArea">
                                                <span class="unit">m<sup>2</sup></span>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="clearfix">
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name text-right">首次登记日期: </i>
                                                <input name="recordDate" type="text" id="firstRegister"
                                                       class="form-control text-red"
                                                       :value="housePawnInfo.recordDate | formatTime">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name text-right">房龄: </i>
                                                <input name="houseAge" type="number" class="form-control text-red"
                                                       :value="housePawnInfo.houseAge">
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="fitmen-status">
                                        <i class="desc-name text-right">装修情况: </i>
                                        <label>
                                            <input type="radio" name="fitmentStatus" value="0">精装
                                        </label>
                                        <label>
                                            <input type="radio" name="fitmentStatus" value="1">简装
                                        </label>
                                        <label>
                                            <input type="radio" name="fitmentStatus" value="2">清水
                                        </label>
                                        <label>
                                            <input type="radio" name="fitmentStatus" value="3">其他
                                        </label>
                                    </div>
                                    <div class="fitmen-status">
                                        <i class="desc-name text-right">是否唯一住房: </i>
                                        <label>
                                            <input type="radio" name="isOnly" value="1">是
                                        </label>
                                        <label>
                                            <input type="radio" name="isOnly" value="0">否
                                        </label>

                                    </div>
                                    <div class="mb20 clearfix pledge">
                                        <i class="desc-name text-right pull-left">抵押情况: </i>
                                        <div style="margin-left: 120px;">
                                            <label>
                                                <input type="radio" name="pawnStatus" value="1">
                                                <span class="name">已办理抵押，抵押银行</span>
                                                <input name="pawnBank" type="text" class="form-control text-red">
                                            </label>
                                            <label>
                                                <input type="radio" name="pawnStatus" value="0">
                                                <span class="name">未办理抵押</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="evaluate" id="gallery">
                                        <h4>评估价值及贷款额度计算(单位：元)</h4>
                                        <p>
                                            <span>上传网查价格图片：（查询浏览器界面、网站地址、网站名称、楼盘名称、房屋总价、面积或房屋单价清晰可见）</span>
                                        </p>
                                        <div class="clearfix">
                                            <ul class="base-info" id="oneWeb">
                                                <li>
                                                    <i class="desc-name text-right">1 网站名称: </i>
                                                    <input name="webOneName" type="text" class="form-control"
                                                           :value="housePawnInfo.webOneName">
                                                </li>
                                                <li>
                                                    <i class="desc-name text-right">价格: </i>
                                                    <input name="webOnePrice" type="number" class="form-control"
                                                           :value="housePawnInfo.webOnePrice">
                                                </li>
                                            </ul>
                                            <ul class="images clearfix">
                                                <li class="uploader-list clearfix" v-for="item in picFileOne">
                                                    <div class="file-item thumbnail">
                                                        <!--<img data-magnify="gallery" :src="'<%=basePath%>attachment/download?attachId=' + item"-->
                                                             <!--:data-src="'<%=basePath%>attachment/download?attachId=' + item" alt="">-->
                                                        <a :href="'<%=basePath%>attachment/download?attachId=' + item"><img :src="'<%=basePath%>attachment/download?attachId=' + item"></a>
                                                        <i class="fa fa-times" :data-id="item" data-pos="picFileOne"></i>
                                                    </div>
                                                </li>
                                                <li class="split-li" v-show="picFileOne.length != 0"></li>
                                                <li class="uploader-list clearfix" id="listPicOne"></li>
                                            </ul>
                                            <ul class="clearfix control-area">
                                                <li>
                                                    <div class="select-btn" id="selPicOne">选择图片</div>
                                                    <button type="button" class="btn btn-success" id="upPicOne">点击上传</button>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="clearfix">
                                            <ul class="base-info" id="twoWeb">
                                                <li>
                                                    <i class="desc-name text-right">2 网站名称: </i>
                                                    <input name="webTwoName" type="text" class="form-control"
                                                           :value="housePawnInfo.webTwoName">
                                                </li>
                                                <li>
                                                    <i class="desc-name text-right">价格: </i>
                                                    <input name="webTwoPrice" type="number" class="form-control"
                                                           :value="housePawnInfo.webTwoPrice">
                                                </li>
                                            </ul>
                                            <ul class="images clearfix">
                                                <li class="uploader-list clearfix" v-for="item in picFileTwo">
                                                    <div class="file-item thumbnail">
                                                        <a :href="'<%=basePath%>attachment/download?attachId=' + item"><img :src="'<%=basePath%>attachment/download?attachId=' + item"></a>
                                                        <i class="fa fa-times" :data-id="item" data-pos="picFileTwo"></i>
                                                    </div>
                                                </li>
                                                <li class="split-li" v-show="picFileTwo.length != 0"></li>
                                                <li class="uploader-list clearfix" id="listPicTwo"></li>
                                            </ul>
                                            <ul class="clearfix control-area">
                                                <li>
                                                    <div class="select-btn" id="selPicTwo">选择图片</div>
                                                    <button type="button" class="btn btn-success" id="upPicTwo">点击上传</button>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="clearfix">
                                            <ul class="base-info" id="threeWeb">
                                                <li>
                                                    <i class="desc-name text-right">3 网站名称: </i>
                                                    <input name="webThreeName" type="text" class="form-control"
                                                           :value="housePawnInfo.webThreeName">
                                                </li>
                                                <li>
                                                    <i class="desc-name text-right">价格: </i>
                                                    <input name="webThreePrice" type="number" class="form-control"
                                                           :value="housePawnInfo.webThreePrice">
                                                </li>
                                            </ul>
                                            <ul class="images clearfix">
                                                <li class="uploader-list clearfix" v-for="item in picFileThree">
                                                    <div class="file-item thumbnail">
                                                        <a :href="'<%=basePath%>attachment/download?attachId=' + item"><img :src="'<%=basePath%>attachment/download?attachId=' + item"></a>
                                                        <i class="fa fa-times" :data-id="item" data-pos="picFileThree"></i>
                                                    </div>
                                                </li>
                                                <li class="split-li" v-show="picFileThree.length != 0"></li>
                                                <li class="uploader-list clearfix" id="listPicThree"></li>
                                            </ul>
                                            <ul class="clearfix control-area">
                                                <li>
                                                    <div class="select-btn" id="selPicThree">选择图片</div>
                                                    <button type="button" class="btn btn-success" id="upPicThree">点击上传</button>
                                                </li>
                                            </ul>
                                        </div>
                                        <div class="clearfix">
                                            <ul class="base-info" id="fourWeb">
                                                <li>
                                                    <i class="desc-name text-right">4 评估公司名称: </i>
                                                    <input name="companyName" type="text" class="form-control"
                                                           :value="housePawnInfo.companyName">
                                                </li>
                                                <li>
                                                    <i class="desc-name text-right">价格: </i>
                                                    <input name="companyPrice" type="number" class="form-control"
                                                           :value="housePawnInfo.companyPrice">
                                                </li>
                                            </ul>
                                            <ul class="images clearfix">
                                                <li class="uploader-list clearfix" v-for="item in picFileFour">
                                                    <div class="file-item thumbnail">
                                                        <a :href="'<%=basePath%>attachment/download?attachId=' + item"><img :src="'<%=basePath%>attachment/download?attachId=' + item"></a>
                                                        <i class="fa fa-times" :data-id="item" data-pos="picFileFour"></i>
                                                    </div>
                                                </li>
                                                <li class="split-li" v-show="picFileFour.length != 0"></li>
                                                <li class="uploader-list clearfix" id="listPicFour"></li>
                                            </ul>
                                            <ul class="clearfix control-area">
                                                <li>
                                                    <div class="select-btn" id="selPicFour">选择图片</div>
                                                    <button type="button" class="btn btn-success" id="upPicFour">点击上传</button>
                                                </li>
                                            </ul>
                                        </div>

                                        <div class="clearfix">
                                            <ul class="base-info" id="fiveWeb">
                                                <li>
                                                    <i class="desc-name text-right">认定价格: </i>
                                                    <input name="cognizancePrice" type="number" class="form-control"
                                                           :value="housePawnInfo.cognizancePrice">
                                                </li>
                                                <li class="relative">
                                                    <i class="desc-name text-right">抵押成数: </i>
                                                    <input name="mortgageNo" type="number" class="form-control"
                                                           :value="housePawnInfo.mortgageNo">
                                                    <span class="tip">% &nbsp;&nbsp; <i class="red-tag">请输入0-99的正整数</i></span>
                                                </li>
                                                <li>
                                                    <i class="desc-name text-right">房贷余额: </i>
                                                    <input name="loanBalance" type="number" class="form-control"
                                                           :value="housePawnInfo.loanBalance">
                                                </li>
                                                <li>
                                                    <i class="desc-name text-right">可贷额度: </i>
                                                    <input name="loanQuta" type="number" class="form-control"
                                                           :value="housePawnInfo.loanQuta">
                                                </li>
                                                <li id="textRemark">
                                                    <p>
                                                        <span>1)认定价值为网评均值*0.9或评估公司估值；</span>
                                                        <span>2)可贷额度=认定价值*抵押类型成数-房贷余额</span>
                                                    </p>
                                                </li>
                                            </ul>
                                        </div>

                                    </div>
                                </div>
                            </form>
                            <form id="businessSurveyInfo">
                                <div class="credit-container">
                                    <h3>二、征信情况:</h3>
                                    <div class="clearfix">
                                        <div>
                                            <div class="credit">
                                                <i class="desc-name text-right">主借人贷款情况: </i>
                                                <span>近两年连续逾期</span>
                                                <input name="overdue" type="number" class="form-control short-width"
                                                       :value="businessSurveyInfo.overdue">
                                                <s>次,</s>
                                                <b>累计逾期</b>
                                                <input name="overdueTotal" type="number"
                                                       class="form-control short-width"
                                                       :value="businessSurveyInfo.overdueTotal">
                                                次
                                            </div>
                                            <div class="credit">
                                                <i class="desc-name text-right">主借人信用卡: </i>
                                                <span>近两年连续逾期</span>
                                                <input name="creditOverdue" type="number"
                                                       class="form-control short-width"
                                                       :value="businessSurveyInfo.creditOverdue">
                                                <s>次,</s>
                                                <b>累计逾期</b>
                                                <input name="creditOverdueTotal" type="number"
                                                       class="form-control short-width"
                                                       :value="businessSurveyInfo.creditOverdueTotal">
                                                次
                                            </div>
                                            <div class="credit" style="margin-bottom: 40px;">
                                                <i class="desc-name text-right">主借人综述: </i>
                                                <label>
                                                    <input type="radio" name="userReview" value="0">
                                                    <span>A类</span>
                                                </label>
                                                <label>
                                                    <input type="radio" name="userReview" value="1">
                                                    <span>B类</span>
                                                </label>
                                                <label>
                                                    <input type="radio" name="userReview" value="2">
                                                    <span>C类</span>
                                                </label>
                                                <s id="helpTip" class="red-tag">
                                                    帮助
                                                    <div class="help">
                                                        <table class="table">
                                                            <thead>
                                                            <tr>
                                                                <th>客户类型</th>
                                                                <th>贷款期限</th>
                                                                <th>还款方式</th>
                                                                <th>一抵</th>
                                                                <th>二抵</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            <tr>
                                                                <td rowspan="2">A</td>
                                                                <td>1-12期</td>
                                                                <td>先息后本</td>
                                                                <td>0.90%</td>
                                                                <td>0.95%</td>
                                                            </tr>
                                                            <tr>
                                                                <td>12-60期</td>
                                                                <td>等本等息</td>
                                                                <td>0.64%</td>
                                                                <td>0.67%</td>
                                                            </tr>
                                                            <tr>
                                                                <td rowspan="2">B</td>
                                                                <td>1-12期</td>
                                                                <td>先息后本</td>
                                                                <td>0.95%</td>
                                                                <td>1.00%</td>
                                                            </tr>
                                                            <tr>
                                                                <td>12-60期</td>
                                                                <td>等本等息</td>
                                                                <td>0.67%</td>
                                                                <td>0.70%</td>
                                                            </tr>
                                                            <tr>
                                                                <td rowspan="2">C</td>
                                                                <td>1-12期</td>
                                                                <td>先息后本</td>
                                                                <td>0.99%</td>
                                                                <td>1.05%</td>
                                                            </tr>
                                                            <tr>
                                                                <td>12-60期</td>
                                                                <td>等本等息</td>
                                                                <td>0.70%</td>
                                                                <td>0.74%</td>
                                                            </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </s>

                                            </div>
                                        </div>
                                        <div>
                                            <div class="credit">
                                                <i class="desc-name text-right">共借人贷款情况: </i>
                                                <span>近两年连续逾期</span>
                                                <input name="togetherOverdue" type="number"
                                                       class="form-control short-width"
                                                       :value="businessSurveyInfo.togetherOverdue">
                                                <s>次,</s>
                                                <b>累计逾期</b>
                                                <input name="togetherOverdueTotal" type="number"
                                                       class="form-control short-width"
                                                       :value="businessSurveyInfo.togetherOverdueTotal">
                                                次
                                            </div>
                                            <div class="credit">
                                                <i class="desc-name text-right">共借人信用卡: </i>
                                                <span>近两年连续逾期</span>
                                                <input name="togetherCreditOverdue" type="number"
                                                       class="form-control short-width"
                                                       :value="businessSurveyInfo.togetherCreditOverdue">
                                                <s>次,</s>
                                                <b>累计逾期</b>
                                                <input name="togetherCreditOverdueTotal" type="number"
                                                       class="form-control short-width"
                                                       :value="businessSurveyInfo.togetherCreditOverdueTotal">
                                                次
                                            </div>
                                            <div class="credit" style="margin-bottom: 40px;">
                                                <i class="desc-name text-right">共借人综述: </i>
                                                <label>
                                                    <input type="radio" name="userTogetherReview" value="0">
                                                    <span>A类</span>
                                                </label>
                                                <label>
                                                    <input type="radio" name="userTogetherReview" value="1">
                                                    <span>B类</span>
                                                </label>
                                                <label>
                                                    <input type="radio" name="userTogetherReview" value="2">
                                                    <span>C类</span>
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="lawsuit-container">
                                    <h3>三、涉诉查询情况</h3>
                                    <div>
                                        <i class="desc-name text-right">被执行人网查询: </i>
                                        <label>
                                            <input type="radio" name="netQuery" value="1">
                                            <span>是</span>
                                        </label>
                                        <label>
                                            <input type="radio" name="netQuery" value="0">
                                            <span>否</span>
                                        </label>
                                    </div>
                                    <div>
                                        <i class="desc-name text-right">失信被执行人网查询: </i>
                                        <label>
                                            <input type="radio" name="creditNetQuery" value="1">
                                            <span>是</span>
                                        </label>
                                        <label>
                                            <input type="radio" name="creditNetQuery" value="0">
                                            <span>否</span>
                                        </label>
                                    </div>
                                </div>
                                <div class="family-container">
                                    <h3>四、家庭情况</h3>
                                    <div class="clearfix">
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name text-right">婚姻状况: </i>
                                                <input name="marrStatus" type="text" class="form-control"
                                                       :value="businessSurveyInfo.marrStatus">
                                            </li>
                                            <li>
                                                <i class="desc-name text-right">婚姻年限: </i>
                                                <input name="marrYear" type="number" class="form-control"
                                                       :value="businessSurveyInfo.marrYear">
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name text-right">是否有子女: </i>
                                                <select name="haveChildren" class="form-control">
                                                    <option :selected="item.value == businessSurveyInfo.haveChildren"
                                                            v-for="item in haveChildren" :value="item.value">
                                                        {{item.name}}
                                                    </option>
                                                </select>
                                            </li>
                                            <li>
                                                <i class="desc-name text-right">赡养人口: </i>
                                                <input name="supportNumber" type="number" class="form-control"
                                                       :value="businessSurveyInfo.supportNumber">
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="family-debt-container">
                                    <h3>五、家庭负债情况(单位:元)</h3>
                                    <div class="clearfix">
                                        <ul class="base-info">
                                            <li class="relative">
                                                <i class="desc-name text-right">当前负债总额: </i>
                                                <input name="familyDebt" type="number" class="form-control" value=""
                                                       :value="businessSurveyInfo.familyDebt">
                                                <span>(含信用卡、贷款等)</span>
                                            </li>
                                        </ul>
                                        <ul class="base-info">
                                            <li>
                                                <i class="desc-name text-right">月还款额: </i>
                                                <input name="monthRepay" type="number" class="form-control"
                                                       :value="businessSurveyInfo.monthRepay">
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="family-asset-container">
                                    <h3>六、家庭资产情况(单位:元)</h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>类型</th>
                                            <th>房产1({{businessSurveyInfo.houseOneName}})</th>
                                            <th>房产2({{businessSurveyInfo.houseTwoName}})</th>
                                            <th>汽车</th>
                                            <th>股票</th>
                                            <th>理财</th>
                                            <th>其他</th>
                                            <th>合计</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td>价值</td>
                                            <td><input name="houseOnePrice" type="number"
                                                       class="form-control text-center"
                                                       :value="businessSurveyInfo.houseOnePrice"></td>
                                            <td><input name="houseTwoPrice" type="number"
                                                       class="form-control text-center"
                                                       :value="businessSurveyInfo.houseTwoPrice"></td>
                                            <td><input name="carPrice" type="number" class="form-control text-center"
                                                       :value="businessSurveyInfo.carPrice"></td>
                                            <td><input name="stockPrice" type="number" class="form-control text-center"
                                                       :value="businessSurveyInfo.stockPrice"></td>
                                            <td><input name="financialPrice" type="number"
                                                       class="form-control text-center"
                                                       :value="businessSurveyInfo.financialPrice"></td>
                                            <td><input name="otherPrice" type="number" class="form-control text-center"
                                                       :value="businessSurveyInfo.otherPrice"></td>
                                            <td><input type="number" class="form-control text-center" value=""
                                                       id="familyTotalMoney"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="family-asset-container">
                                    <h3>七、借款人及共借人银行账户近六个月流水:(提供主要结算银行流水)</h3>
                                    <table class="table table-bordered">
                                        <tbody>
                                        <tr>
                                            <td class="bgc">贷方合计</td>
                                            <td><input name="bankDetail" style="width: 450px;" type="number"
                                                       class="form-control text-center"
                                                       :value="businessSurveyInfo.bankDetail"></td>
                                            <td class="bgc">月均</td>
                                            <td><input style="width: 450px;" type="number"
                                                       class="form-control text-center"
                                                       :value="businessSurveyInfo.bankDetail | monthAvg"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="family-asset-container">
                                    <h3>八、第一还款来源</h3>
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>月工资收入</th>
                                            <th>月经营收入</th>
                                            <th>月租金收入</th>
                                            <th>月其他收入</th>
                                            <th>家庭月收入合计</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td><input name="monthIncome" type="number" class="form-control text-center"
                                                       :value="businessSurveyInfo.monthIncome"></td>
                                            <td><input name="manageIncome" type="number"
                                                       class="form-control text-center"
                                                       :value="businessSurveyInfo.manageIncome"></td>
                                            <td><input name="rentIncome" type="number" class="form-control text-center"
                                                       :value="businessSurveyInfo.rentIncome"></td>
                                            <td><input name="otherIncome" type="number" class="form-control text-center"
                                                       :value="businessSurveyInfo.otherIncome"></td>
                                            <td><input type="number" class="form-control text-center" value=""
                                                       id="repayWayTotalMoney"></td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!--附件-->
                    <div class="panel panel-info asset-images">
                        <div class="panel-heading">
                            <h3 class="panel-title">附件</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul class="asset-prove">
                                <!--<li>-->
                                <!--<p>房产</p>-->
                                <!--<img data-magnify="gallery" src="static/img/02.jpg" data-src="static/img/02.jpg" alt="">-->
                                <!--<img data-magnify="gallery" src="static/img/02.jpg" data-src="static/img/02.jpg" alt="">-->
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

                    <!--调查意见展示-->
                    <div v-show="processInfo.length == 0 ? false : true">
                        <div class="panel panel-info" v-for="item in processInfo">
                            <div class="panel-heading">
                                <h3 class="panel-title">{{item.processName}}意见</h3>
                                <p class="pull-right" style="margin-top: -15px;">
                                    审批人员: <span>{{item.userName}}</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>{{item.updateDate}}</span>
                                </p>
                            </div>
                            <div class="panel-body clearfix survey">
                                <form>
                                    <ul class="base-info">
                                        <li class="relative">
                                            <i class="desc-name text-right">贷款额度(元): </i>
                                            <input disabled name="auditAmount" type="number"
                                                   class="form-control css-disabled" :value="item.auditAmount">
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">贷款期限(月): </i>
                                            <select disabled name="auditPeriod" class="form-control css-disabled">
                                                <option :selected="periodItem.value == item.auditPeriod"
                                                        v-for="periodItem in productPeriodInfo"
                                                        :value="periodItem.value">{{periodItem.labelText}}
                                                </option>
                                            </select>
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">月利率(%): </i>
                                            <input disabled name="auditMonthRate" type="number"
                                                   class="form-control css-disabled"
                                                   oninput="if(value.length>8)value=value.slice(0,8)"
                                                   :value="item.auditMonthRate | monthRating">
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">还款方式: </i>
                                            <select disabled name="repayWay" class="form-control css-disabled">
                                                <option :selected="repayWayItem.value == item.repayWay"
                                                        v-for="repayWayItem in repayWayInfo"
                                                        :value="repayWayItem.value">{{repayWayItem.text}}
                                                </option>
                                            </select>
                                        </li>
                                    </ul>
                                    <ul class="base-info idea-ul">
                                        <li class="relative">
                                            <i class="desc-name text-right">审批意见: </i>
                                            <textarea rows="4" readonly name="" type="text"
                                                      class="form-control idea css-disabled pointer">{{item.updateReason}}</textarea>
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">备注: </i>
                                            <textarea rows="4" readonly name="" type="text"
                                                      class="form-control idea css-disabled pointer">{{item.remark}}</textarea>
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                    </div>

                    <!--调查意见填写-->
                    <c:if test="${fn:contains(roleType, 'businessCommissioner') || fn:contains(roleType, 'businessManager')}">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <c:if test="${fn:contains(roleType, 'businessCommissioner')}">
                                    <h3 class="panel-title">业务部调查意见</h3>
                                </c:if>
                                <c:if test="${fn:contains(roleType, 'businessManager')}">
                                    <h3 class="panel-title">业务部部门经理意见</h3>
                                </c:if>
                            </div>
                            <div class="panel-body clearfix survey">
                                <form id="auditForm">
                                    <ul class="base-info">
                                        <li class="relative">
                                            <i class="desc-name text-right">贷款额度(元): </i>
                                            <input id="auditAmount" name="auditAmount" type="number"
                                                   class="form-control" value="">
                                                   <span id="toUpperMoney"></span>
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">贷款期限(月): </i>
                                            <select name="auditPeriod" class="form-control">
                                                <option value="">-请选择贷款期限-</option>
                                                <option v-for="periodItem in productPeriodInfo"
                                                        :value="periodItem.value">{{periodItem.labelText}}
                                                </option>
                                            </select>
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">月利率(%): </i>
                                            <input id="auditMonthRate" name="auditMonthRate" type="number"
                                                   oninput="if(value.length>8)value=value.slice(0,8)"
                                                   class="form-control" value="">
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">还款方式: </i>
                                            <select name="repayWay" class="form-control">
                                                <option value="">-请选择还款方式-</option>
                                                <option v-for="repayWayItem in repayWayInfo"
                                                        :value="repayWayItem.value">{{repayWayItem.text}}
                                                </option>
                                            </select>
                                        </li>
                                    </ul>
                                    <ul class="base-info remark-ul">
                                        <li class="relative">
                                            <i class="desc-name text-right">备注: </i>
                                            <textarea maxlength="1000" placeholder="请输入不超过1000字" name="remark" id="remark" class="form-control inline-block remark" rows="6"></textarea>
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <div class="control">
                        <div>
                            <a href="<%=basePath%>investigatePrint.html?orderId=<%=orderId%>" target="_blank"
                               class="btn btn-print btn-new">打印</a>
                            <!--客户经理-->
                            <c:if test="${fn:contains(roleType, 'businessCommissioner')  && orderStatus == 20}">
                                <button type="button" class="btn btn-reject btn-new" id="saveInvestigate">保存</button>
                                <button class="btn btn-submit btn-new" id="auditFormButton">提交</button>
                                <button class="btn btn-refuse btn-new" id="auditFormButtonRefuse">拒绝</button>
                            </c:if>
                            <!--部门经理-->
                            <c:if test="${fn:contains(roleType, 'businessManager') && orderStatus == 21}">
                            	<span class="">
	                                 <button class="btn btn-submit btn-new" id="auditPass">通过</button>
	                                 <button class="btn btn-refuse btn-new" id="auditRefuse">拒绝</button>
	                                 <button class="btn btn-reject btn-new" id="auditReject">驳回</button>
	                                 <span>驳回理由:</span>
	                                 <textarea  maxlength="1000" placeholder="请输入理由不超过1000字" cols="5"
                                               class="form-control rejectReason"></textarea>
                                    <span>驳回到:</span>
                                    <select name="" class="form-control rejectTo">
                                        <option v-for="item in processFlowInfo" :value="item.processId">{{item.processName}}</option>
                                    </select>
	                             </span>
                            </c:if>
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
    <!--删除图片模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="myDelPicModal" data-backdrop="static"
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
                    <button id="confirmDelPic" type="button" class="btn btn-confirm" data-dismiss="modal">确认</button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
<div id="mask">
    <div class="areaContent"></div>
</div>
<script src="static/plugins/vue/vue.js"></script>
<script src="static/plugins/webuploader/webuploader.js"></script>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>

<script type="text/javascript" src="static/plugins/jRebox/lib/jquery-litelighter.js"></script>

<script type="text/javascript" src="static/plugins/jRebox/jquery-rebox.js"></script>

<script src="<%=basePath%>static/js/ChinaNumToEnglishNum.js"></script>
<script src="<%=basePath%>static/js/province.js"></script>
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
            basePath : '<%=basePath%>'
        });
    })
</script>
<script>
    var creditInfo = {
        vari: {
            orderId: '<%=orderId%>',
            pawnId: '', // 抵押物信息id
            surveyId: '', // 业务调查id,
            picFileOne : [],
            picFileTwo : [],
            picFileThree : [],
            picFileFour : [],
        },
        vm: {},
        init: function () {
            var _this = this;
            this.newVue();
            this.renderProvince();
            this.renderIcheck();
            this.renderTime();
            // 地址联动
            this.renderCreditArea($('#pledgeProvince'), $('#pledgeCity'), $('#pledgeArea'));
            this.getData(function () {
                // _this.initImage();
                setTimeout(function () {
                    $('#gallery a').rebox({
                        zIndex:1030
                    });
                },3000)
                // 删除图片功能
                _this.delPic();
            });
            this.getProcessOrderFlows(5); // 获取驳回到列表
            this.bindEvent();
        },
        bindEvent: function () {
            var _this = this;
            // 点击保存
            $('#saveInvestigate').on('click', function () {
                _this.saveData();
            })
            $('#auditAmount').keyup(function () {
            	if($(this).val()==''){
            		$('#toUpperMoney').text('');
            		return false;
            	}
                $('#toUpperMoney').text(toUpperMoney(Number($(this).val())))
            })
            // 客户经理提交
            $('#auditFormButton').click(function () {
                // 判断是否保存资料
                if (_this.vm.businessSurveyInfo == '') {
                    myOrderTpl.alertModel('客户经理请先保存资料!');
                    return;
                }
                var remarkTemp = $("#auditForm").serializeArray();
                var remarkExtend = {};
                for (var i = 0; i < remarkTemp.length; i++) {
                    remarkExtend[remarkTemp[i].name] = remarkTemp[i].value;
                }
                for (var k in remarkExtend) {
                    if (remarkExtend[k] == '') {
                        myOrderTpl.alertModel('请检查调查意见是否有未填项!')
                        return;
                    }
                }
                if (!/^[0-9]\d*$/.test(Number($('#auditAmount').val()))) {
                    myOrderTpl.alertModel('贷款额度不能为负数!')
                    return;
                }
                if (Number($('#auditMonthRate').val()) > 999) {
                    myOrderTpl.alertModel('利率输入过大!');
                    return;
                }
                remarkExtend.auditMonthRate = Number(remarkExtend.auditMonthRate).mul(12).toFixed(6);
                $.ajax({
                    url: util.getServerUrl('/loanOrder/examineOrder'),
                    method: 'POST',
                    data: {
                        orderId: '<%=orderId%>',
                        resultValue: 1,
                        processId: 21,
                        remarkExtend: JSON.stringify(remarkExtend)
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
            })
            // 客户经理拒绝
            this.examize($('#auditFormButtonRefuse'), 3, 21);
            // 部门经理操作
            this.examize($('#auditPass'), 1, 5);
            this.examize($('#auditRefuse'), 3, 5);
            this.examize($('#auditReject'), 2, 5);
            // 上传图片
            this.initUpload('selPicOne','upPicOne','listPicOne');
            this.initUpload('selPicTwo','upPicTwo','listPicTwo');
            this.initUpload('selPicThree','upPicThree','listPicThree');
            this.initUpload('selPicFour','upPicFour','listPicFour');

            myOrderTpl.getUploadSel(2,function () {
                myOrderTpl.uploadImgs();
            })
            myOrderTpl.showTextArea();
        },
        // 审核 通过拒绝驳回
        examize: function (btn, resultValue, processId) {
            btn.click(function () {
                var remarkTemp = $("#auditForm").serializeArray();
                var remarkExtend = {};
                for (var i = 0; i < remarkTemp.length; i++) {
                    remarkExtend[remarkTemp[i].name] = remarkTemp[i].value;
                }
                if (resultValue == 1) {
                    for (var k in remarkExtend) {
                        if (remarkExtend[k] == '') {
                            myOrderTpl.alertModel('请检查调查意见是否有未填项!')
                            return;
                        }
                    }
                    if (!/^[0-9]\d*$/.test(Number($('#auditAmount').val()))) {
                        myOrderTpl.alertModel('贷款额度不能为负数!')
                        return;
                    }
                    if (Number($('#auditMonthRate').val()) > 999) {
                        myOrderTpl.alertModel('利率输入过大!');
                        return;
                    }
                }
                remarkExtend.auditMonthRate = Number(remarkExtend.auditMonthRate).mul(12).toFixed(6);
                if(resultValue==3){
                    if(!window.confirm('确认要拒绝吗?')){
                        return;
                    }
                }
                $.ajax({
                    url: util.getServerUrl('/loanOrder/examineOrder'),
                    method: 'POST',
                    data: {
                        orderId: '<%=orderId%>',
                        resultValue: resultValue,
                        processId: processId,
                        rejectProcessId: $('.rejectTo').val(),
                        remark: $.trim($('.rejectReason').val()),
                        remarkExtend: JSON.stringify(remarkExtend)
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
            })
        },
        // 获取数据
        getData: function (cb) {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/loanOrder/getBusinessSurvey'),
                method: 'POST',
                data: {orderId: this.vari.orderId},
                success: function (res) {
                    if (res.status == 0) {
                        _this.vm.applyInfo = res.data.applyInfo;

                        _this.vm.manageInfo = res.data.manageInfo;
                        _this.vm.baseInfo = res.data.baseInfo;
                        _this.vm.housePawnInfo = res.data.housePawnInfo == '' ? _this.vm.housePawnInfo : res.data.housePawnInfo;
                        _this.vm.workInfo = res.data.workInfo;
                        _this.vm.spouseInfo = res.data.spouseInfo.length == 0 ? _this.vm.spouseInfo : res.data.spouseInfo;
                        _this.vm.processInfo = res.data.processInfo;
                        _this.vm.productPeriodInfo = res.data.productPeriodInfo;
                        _this.vm.repayWayInfo = res.data.repayWayInfo;

                        if (res.data.businessSurveyInfo != '') {
                            _this.vari.surveyId = res.data.businessSurveyInfo.id;
                            _this.vm.businessSurveyInfo = res.data.businessSurveyInfo;
                        }
                        if (res.data.housePawnInfo != '') {
                            _this.vari.pawnId = res.data.housePawnInfo.id;
                            savePics(res.data.housePawnInfo);
                        }

                        if(res.data.attachMaterial.length > 0){
                            renderAssetProve(res.data.attachMaterial,'asset-prove');
                            $('.asset-images').show();
                        }

                        _this.initImages();

                        aloneRender(res.data);
                        _this.renderIcheck();
                        cb && cb();
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

            // 保存返回的图片id
            function savePics(data) {
                if(data.picFileOne != '')_this.vari.picFileOne = data.picFileOne.split(',')
                if(data.picFileTwo != '')_this.vari.picFileTwo = data.picFileTwo.split(',');
                if(data.picFileThree != '')_this.vari.picFileThree = data.picFileThree.split(',');
                if(data.picFileFour != '')_this.vari.picFileFour = data.picFileFour.split(',');
            }
            // 单独渲染
            function aloneRender(data) {
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
                // 抵押物地址
                if (data.housePawnInfo == '') {
                    $('#pledgeProvince').val(_this.vm.housePawnInfo.province);
                    // 回填省市县
                    cbAddress(
                        $('#pledgeCity'),
                        $('#pledgeArea'),
                        _this.vm.housePawnInfo.province,
                        _this.vm.housePawnInfo.city,
                        _this.vm.housePawnInfo.county
                    );
                } else {
                    $('#pledgeProvince').val(data.housePawnInfo.province);
                    // 回填省市县
                    cbAddress(
                        $('#pledgeCity'),
                        $('#pledgeArea'),
                        data.housePawnInfo.province,
                        data.housePawnInfo.city,
                        data.housePawnInfo.county
                    );
                }

                function cbAddress($city, $area, provinceVal, cityVal, areaVal) {
                    // 根据省份请求城市
                    $city.empty();
                    $.ajax({
                        method: 'POST',
                        url: util.getServerUrl('/areaCtr/getAreaByParentId'),
                        data: {parentId: provinceVal},
                        dataType: 'json',
                        success: function (data) {
                            if (data.result != undefined) {
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
                            if (data.result != undefined) {
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

                // 还款方式及利率
                $('input[name="payType"]').each(function (k, v) {
                    if ($(this).val() == data.businessSurveyInfo.repayWay) {
                        $(this).attr('checked', true);
                        $(this).parents('label').children('input[type="number"]').val(data.businessSurveyInfo.rating)
                    }
                })
                // 贷款用途
                $('input[name="borrowFor"]').each(function (k, v) {
                    if ($(this).val() == data.businessSurveyInfo.loanType) {
                        $(this).attr('checked', true);
                        $(this).parents('label').children('input[type="text"]').val(data.businessSurveyInfo.usageDesc)
                    }
                })
                //抵押情况
                $('input[name="pawnStatus"]').each(function (k, v) {
                    if (data.housePawnInfo != '') {
                        if ($(this).val() == data.housePawnInfo.pawnStatus) {
                            $(this).attr('checked', true);
                            if (data.housePawnInfo.pawnStatus == 1) {
                                $(this).parents('label').children('input[type="text"]').val(data.housePawnInfo.pawnBank)
                            }
                        }
                    } else {
                        if ($(this).val() == _this.vm.housePawnInfo.pawnStatus) {
                            $(this).attr('checked', true);
                            if (_this.vm.housePawnInfo.pawnStatus == 1) {
                                $(this).parents('label').children('input[type="text"]').val(_this.vm.housePawnInfo.pawnBank)
                            }
                        }
                    }
                })
                // 产品类型
                checkRadioRender('productType', data.businessSurveyInfo.productType)
                // 抵押物类型
                checkRadioRender('pawnType', data.businessSurveyInfo.pawnType)
                // 抵押物区域
                checkRadioRender('pawnArea', data.businessSurveyInfo.pawnArea)
                // 装修情况
                checkRadioRender('fitmentStatus', data.housePawnInfo.fitmentStatus)
                // 是否唯一住房
                checkRadioRender('isOnly', data.housePawnInfo.isOnly)

                // 主借人综述
                checkRadioRender('userReview', data.businessSurveyInfo.userReview)
                // 共借人综述
                checkRadioRender('userTogetherReview', data.businessSurveyInfo.userTogetherReview)

                // 被执行网查询
                checkRadioRender('netQuery', data.businessSurveyInfo.netQuery)
                // 失信被执行人网查询
                checkRadioRender('creditNetQuery', data.businessSurveyInfo.creditNetQuery)
                // 家庭资产总计
                var familyTotalMoney = sNumber(data.businessSurveyInfo.houseOnePrice) +
                    sNumber(data.businessSurveyInfo.houseTwoPrice) +
                    sNumber(data.businessSurveyInfo.carPrice) +
                    sNumber(data.businessSurveyInfo.stockPrice) +
                    sNumber(data.businessSurveyInfo.financialPrice) +
                    sNumber(data.businessSurveyInfo.otherPrice);
                $('#familyTotalMoney').val(familyTotalMoney);
                // 第一还款来源总计
                var repayWayTotalMoney = sNumber(data.businessSurveyInfo.monthIncome) +
                    sNumber(data.businessSurveyInfo.manageIncome) +
                    sNumber(data.businessSurveyInfo.rentIncome) +
                    sNumber(data.businessSurveyInfo.otherIncome);
                $('#repayWayTotalMoney').val(repayWayTotalMoney);

                function checkRadioRender(typeName, value) {
                    $('input[name="' + typeName + '"]').each(function (k, v) {
                        if ($(this).val() == value) {
                            $(this).attr('checked', true);
                        }
                    })
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
                            str += '<img data-magnify="gallery" src="'+(util.getImgTmpUrl("/attachment/download?attachId=")+val)+'" data-src="'+(util.getImgTmpUrl("/attachment/download?attachId=")+val)+'" alt="">';
                        })
                    }
                    str +='</li>';
                })
                $('.'+target).html(str);
            }
            function sNumber(num) {
                return num == undefined ? 0 : Number(num)
            }
        },
        newVue: function () {
            var _this = this;
            this.vm = new Vue({
                el: '#investigateInfo',
                data: {
                    applyInfo: {
                        "usageId": "",
                        "amount": '',
                        "period": '',
                        "repayWay": "",
                        "auditRating": "",
                        "auditPeriod": '',
                        "channelName": "",
                        "usageDesc": ""
                    },
                    baseInfo: {
                        "bankAccount": "",
                        "education": '',
                        "estateType": '',
                        "address": "",
                        "nation": "",
                        "city": "",
                        "sex": '',
                        "county": "",
                        "telephone": "",
                        "addressMoney": "",
                        "areaCode": "",
                        "marrStatus": '',
                        "province": "",
                        "addressNature": "",
                        "phone": "",
                        "channelUserId": "",
                        "identity": "",
                        "name": "",
                        "householdReg": "",
                        "age": ''
                    },
                    manageInfo: [{
                        "user_mobile": "",
                        "user_name": "",
                        "id": ""
                    }],
                    workInfo: {
                        "orgNature": "",
                        "workYears": "",
                        "orgName": "",
                        "annualIncome": "",
                        "rentIncome": "",
                        "orgContact": "",
                        "monthIncome": "",
                        "familyIncome": "",
                        "orgAddress": "",
                        "manageIncome": "",
                        "position": "",
                        "department": ""
                    },
                    housePawnInfo: {
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
                        "pawnBank": '',
                        "id": '',
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
                        "fitmentStatus": '',
                        "picFileOne":'',
                        "picFileTwo":'',
                        "picFileThree":'',
                        "picFileFour":''
                    },
                    businessSurveyInfo: {
                        "id": "",
                        "pawnId": "",
                        "orderId": "",
                        "userId": "",
                        "businessNo": "",
                        "department": "",
                        "channelUserId": "",
                        "productType": "",
                        "pawnType": "",
                        "repayWay": "",
                        "rating": "",
                        "loanType": "",
                        "usageDesc": "",
                        "overdue": 0,
                        "overdueTotal": 0,
                        "creditOverdue": 0,
                        "creditOverdueTotal": 0,
                        "userReview": "",
                        "togetherOverdue": 0,
                        "togetherOverdueTotal": 0,
                        "togetherCreditOverdue": 0,
                        "togetherCreditOverdueTotal": 0,
                        "userTogetherReview": "",
                        "netQuery": '',
                        "creditNetQuery": '',
                        "marrStatus": "",
                        "marrYear": '',
                        "haveChildren": '',
                        "supportNumber": '',
                        "familyDebt": '',
                        "otherDebt": '',
                        "monthRepay": '',
                        "houseOneName": "",
                        "houseOnePrice": '',
                        "houseTwoName": "",
                        "houseTwoPrice": '',
                        "carPrice": '',
                        "stockPrice": '',
                        "financialPrice": '',
                        "otherPrice": '',
                        "bankDetail": '',
                        "monthIncome": "",
                        "manageIncome": '',
                        "rentIncome": '',
                        "otherIncome": '',
                        "isDel": '',
                        "createTime": '',
                        "createBy": "",
                        "updateTime": '',
                        "updateBy": ""
                    },
                    spouseInfo: [{
                        "profession": "",
                        "relativeName": "",
                        "address": "",
                        "nation": "",
                        "sex": "",
                        "idCardNum": "",
                        "relativeMobile": "",
                        "id": "",
                        "age": "",
                        "relativeType": ""
                    }],
                    processInfo: [],
                    processFlowInfo: [],
                    productPeriodInfo: [],
                    repayWayInfo: [],
                    haveChildren: [
                        {name: '是', value: '1'},
                        {name: '否', value: '0'}
                    ]
                },
                computed: {
                    picFileOne : function () {
                        if(this.housePawnInfo.picFileOne != ''){
                            return this.housePawnInfo.picFileOne.split(',');
                        }else{
                            return [];
                        }

                    },
                    picFileTwo : function () {
                        if(this.housePawnInfo.picFileTwo != ''){
                            return this.housePawnInfo.picFileTwo.split(',');
                        }else{
                            return [];
                        }
                    },
                    picFileThree : function () {
                        if(this.housePawnInfo.picFileThree != ''){
                            return this.housePawnInfo.picFileThree.split(',');
                        }else{
                            return [];
                        }
                    },
                    picFileFour : function () {
                        if(this.housePawnInfo.picFileFour != ''){
                            return this.housePawnInfo.picFileFour.split(',');
                        }else{
                            return [];
                        }
                    },
                },
                filters: {
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
                    // 贷方合计(银行流水)的月均
                    monthAvg: function (value) {
                        if (value) {
                            return Number(value).div(6).toFixed(3);
                        } else {
                            return '';
                        }
                    },
                    monthRating: function (value) {
                        return Number(value).div(12).toFixed(6);
                    }
                },
            })
        },
        // 保存数据
        saveData: function () {
            var params = {
                pawnInfo: {},
                businessSurveyInfo: {}
            }, _this = this;

            params.businessSurveyInfo.id = this.vari.surveyId; // 添加业务调查id
            params.pawnInfo.id = this.vari.pawnId; // 添加抵押物id

            //  申请信息
            for (var i = 0; i < $('#applyInfo').serializeArray().length; i++) {
                params['businessSurveyInfo'][$('#applyInfo').serializeArray()[i].name] = $('#applyInfo').serializeArray()[i].value
            }
            //  借款人基本信息
            for (var i = 0; i < $('#baseInfo').serializeArray().length; i++) {
                params[$('#baseInfo').serializeArray()[i].name] = $('#baseInfo').serializeArray()[i].value
            }
            // 贷款要素
            for (var i = 0; i < $('#borrowFactor').serializeArray().length; i++) {
                params['businessSurveyInfo'][$('#borrowFactor').serializeArray()[i].name] = $('#borrowFactor').serializeArray()[i].value
            }
            params.businessSurveyInfo.repayWay = myOrderTpl.getiCheckItem('payType')[0];
            params.businessSurveyInfo.rating = repayWayRating();
            params.businessSurveyInfo.loanType = myOrderTpl.getiCheckItem('borrowFor')[0];
            params.businessSurveyInfo.usageDesc = usageDesc();

            // 抵押物情况
            for (var i = 0; i < $('#pawnInfo').serializeArray().length; i++) {
                params['pawnInfo'][$('#pawnInfo').serializeArray()[i].name] = $('#pawnInfo').serializeArray()[i].value
            }
            params['pawnInfo']['recordDate'] = params['pawnInfo']['recordDate'] == '' ? '' : params['pawnInfo']['recordDate'] + ' 00:00:00';
            // 抵押物图片
            params['pawnInfo']['picFileOne'] = this.vari.picFileOne.join(',');
            params['pawnInfo']['picFileTwo'] = this.vari.picFileTwo.join(',');
            params['pawnInfo']['picFileThree'] = this.vari.picFileThree.join(',');
            params['pawnInfo']['picFileFour'] = this.vari.picFileFour.join(',');

            var oneFlag = 0,twoFlag=0,threeFlag=0,fourFlag=0;
            $('#oneWeb input').each(function (k, v) {
                if($(v).val()!=''){
                    if(_this.vari.picFileOne.length==0){
                        oneFlag = 1;
                        myOrderTpl.alertModel('请上传网站1图片!');
                        return false;
                    }else{
                        oneFlag=0;
                    }
                }else{
                    oneFlag = 0;
                }
            });
            if(oneFlag)return;
            $('#twoWeb input').each(function (k, v) {
                if($(v).val()!=''){
                    if(_this.vari.picFileTwo.length==0){
                        twoFlag = 1;
                        myOrderTpl.alertModel('请上传网站2图片!');
                        return false;
                    }else{
                        twoFlag=0;
                    }
                }else{
                    twoFlag = 0;
                }
            });
            if(twoFlag)return;
            $('#threeWeb input').each(function (k, v) {
                if($(v).val()!=''){
                    if(_this.vari.picFileThree.length==0){
                        threeFlag = 1;
                        myOrderTpl.alertModel('请上传网站3图片!');
                        return false;
                    }else{
                        threeFlag=0;
                    }
                }else{
                    threeFlag = 0;
                }
            });
            if(threeFlag)return;
            $('#fourWeb input').each(function (k, v) {
                if($(v).val()!=''){
                    if(_this.vari.picFileFour.length==0){
                        fourFlag = 1;
                        myOrderTpl.alertModel('请上传评估公司图片!');
                        return false;
                    }else{
                        fourFlag=0;
                    }
                }else{
                    fourFlag = 0;
                }
            });
            if(fourFlag)return;

            if(Number(params.pawnInfo.mortgageNo) > 99){
                myOrderTpl.alertModel('抵押成数错误，请重新输入!');
                return;
            }


            // 剩下所有调查表
            for (var i = 0; i < $('#businessSurveyInfo').serializeArray().length; i++) {
                params['businessSurveyInfo'][$('#businessSurveyInfo').serializeArray()[i].name] = $('#businessSurveyInfo').serializeArray()[i].value
            }
            params['businessSurveyInfo']['togetherName'] = $('#togetherName').val(); // 共借人
            params['businessSurveyInfo']['togetherMobile'] = $('#togetherMobile').val();
            params['businessSurveyInfo']['togetherIdentity'] = $('#togetherIdentity').val();

            // 校验非负数
            var integer = [
                params.businessSurveyInfo.overdue,
                params.businessSurveyInfo.overdueTotal,
                params.businessSurveyInfo.creditOverdue,
                params.businessSurveyInfo.creditOverdueTotal,
                params.businessSurveyInfo.togetherOverdue,
                params.businessSurveyInfo.togetherOverdueTotal,
                params.businessSurveyInfo.togetherCreditOverdue,
                params.businessSurveyInfo.togetherCreditOverdueTotal
            ], reg = /^[0-9]\d*$/;

            for (var i = 0; i < integer.length; i++) {
                if (!reg.test(integer[i])) {
                    myOrderTpl.alertModel('请输入正整数!');
                    return;
                }
            }

            var pawnInfo = JSON.stringify(params.pawnInfo); // 将键值对用string保存
            params.pawnInfo = pawnInfo;

            var businessSurveyInfo = JSON.stringify(params.businessSurveyInfo); // 将键值对用string保存
            params.businessSurveyInfo = businessSurveyInfo;


            params.orderId = this.vari.orderId;
            $.ajax({
                url: util.getServerUrl('/loanOrder/saveBusinessSurvey'),
                method: 'POST',
                data: params,
                success: function (res) {
                    if (res.status == 0) {
                        _this.vari.surveyId = res.data.surveyId;
                        _this.vari.pawnId = res.data.pawnId;
                        myOrderTpl.alertSuccessModel('业务调查保存成功', function () {
                            $('#navTab').load('<%=basePath%>loanOrder/myOrderInvestigatePage?orderId=<%=orderId%>');
                        });
                    } else {
                        if (res.msg == '' || res.msg == 'undefined') {
                            myOrderTpl.alertModel('业务调查保存失败!');
                        } else {
                            myOrderTpl.alertModel(res.data);
                        }
                    }
                },
                error: function (error) {
                    myOrderTpl.alertModel(error);
                }
            })

            function repayWayRating() {
                if (myOrderTpl.getiCheckItem('payType')[0] == 10101) {
                    return $('#rating01').val();
                } else if (myOrderTpl.getiCheckItem('payType')[0] == 10110) {
                    return $('#rating02').val();
                } else {
                    return '';
                }
            }

            function usageDesc() {
                if (myOrderTpl.getiCheckItem('borrowFor')[0] == '0') {
                    return $('#usageDesc01').val();
                } else if (myOrderTpl.getiCheckItem('borrowFor')[0] == '1') {
                    return $('#usageDesc02').val();
                } else {
                    return '';
                }
            }
        },
        // 获取驳回到列表
        getProcessOrderFlows: function (processId) {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/common/getProcessOrderFlows'),
                method: 'POST',
                data: {
                    orderId: this.vari.orderId,
                    processId: processId
                },
                success: function (res) {
                    if (res.status == 0) {
                        _this.vm.processFlowInfo = res.data.processFlowInfo;
                    } else {
                        if (res.msg == '' || res.msg == undefined) {
                            myOrderTpl.alertModel('获取驳回列表失败，请稍后刷新重试!');
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
        // 渲染选择时间组件
        renderTime: function () {
            var i18n = { // 本地化
                previousMonth: '上个月',
                nextMonth: '下个月',
                months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
                weekdays: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
                weekdaysShort: ['日', '一', '二', '三', '四', '五', '六']
            }
            var firstRegister = new Pikaday({
                field: $('#firstRegister')[0],
                i18n: i18n,
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
        // 渲染省份
        renderProvince: function () {
            var str = '<option value="">-请选择-</option>';
            $.each(provinceData, function (k, v) {
                str += '<option value="' + v.id + '">' + v.name + '</option>';
            });
            $('#liveProvince').html(str);
            $('#pledgeProvince').html(str);
        },
        // 两级联动
        renderCreditArea: function ($province, $city, $area) {
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
                        if (data.result != undefined) {
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
                        if (data.result != undefined) {
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
        initImages: function () {
            $('[data-magnify=gallery]').magnify({
                i18n: {
                    minimize: '最小化',
                    maximize: '最大化',
                    close: '关闭',
                    zoomIn: '缩小',
                    zoomOut: '放大',
                    prev: '上一张',
                    next: '下一张',
                    fullscreen: '全屏',
                    actualSize: '自适应',
                    rotateLeft: '左旋转',
                    rotateRight: '右旋转',
                },
                footToolbar: ['zoomIn', 'zoomOut', 'prev', 'fullscreen', 'next', 'actualSize', 'rotateLeft', 'rotateRight'],
                headToolbar: ['maximize', 'close']
            });
        },
        // 上传webuploader
        initUpload : function (selPic,upBtn,fileList) {
            var _this = this;
            // 初始化Web Uploader
            var uploader = WebUploader.create({
                // 选完文件后，是否自动上传。
                auto: false,
                // swf文件路径
                swf: '<%=basePath%>static/plugins/webuploader/Uploader.swf',
                // 文件接收服务端。
                server: '<%=basePath%>attachment/upload',
                pick: '#'+selPic,
                // 只允许选择图片文件。
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/*'
                },
                fileNumLimit : 1,
                duplicate : true,
                fileSingleSizeLimit : 1024*1024*8,
                formData : {},
                compress : {
                    // 是否保留头部meta信息。
                    preserveHeaders: true,
                    // 图片质量，只有type为`image/jpeg`的时候才有效。
                    quality: 80,
                }

            });
            // 加入队列前
            uploader.on('beforeFileQueued',function () {
                if(judgeBtn(upBtn).length >= 3) {
                    myOrderTpl.alertModel('该项最多只能有3张!');
                     return false;
                }

            })
            // 点击上传
            $('#'+upBtn).click(function () {
                uploader.upload();
            })
            // 当有文件添加进来的时候
            uploader.on( 'fileQueued', function( file ) {
                if(file.size > 1024*1024*8) {
                    beforeBaseInfo.alertModel('文件大小必须小于8M!');
                    return false;
                }
                var $li = $(
                    '<div id="' + file.id + '" class="file-item thumbnail">' +
                    '<img>' +
                    '<div class="remove-this"><i class="fa fa-trash"></i></div>' +
                    '</div>'
                    ),
                    $img = $li.find('img');
                $('#'+fileList).append( $li );
                // 创建缩略图
                uploader.makeThumb( file, function( error, src ) {
                    if ( error ) {
                        $img.replaceWith('<span>不能预览</span>');
                        return;
                    }
                    $img.attr( 'src', src );
                }, 150, 150 );
                // 点击删除
                $li.on('click', '.remove-this', function() {
                    uploader.removeFile( file,true );
                    $( '#'+file.id ).remove();
                })
            });
            // 文件上传成功，给item添加成功class, 用样式标记上传成功。
            uploader.on( 'uploadSuccess', function( file,response ) {
                if(response.returnCode==0){
                    judgeBtn(upBtn).push(response.result);
                    $( '#'+file.id ).addClass('upload-state-done');
                    $('#'+file.id).append('<div class="result"><i class="fa fa-check"></i></div>')
                }else if(response.returnCode==2000){
                    myOrderTpl.alertModel(response.returnMsg);
                }else{
                    $( '#'+file.id ).addClass('upload-state-failed');
                    $('#'+file.id).append('<div class="result"><i class="fa fa-minus-circle"></i></div>')
                }
            });
            // 文件上传失败，显示上传出错。
            uploader.on( 'uploadError', function( file ) {
                $( '#'+file.id ).addClass('upload-state-failed');
                $('#'+file.id).append('<i class="fa fa-minus-circle"></i>')
            });

            function judgeBtn(btn) {
                switch (btn) {
                    case 'upPicOne':
                        return _this.vari.picFileOne;
                        break;
                    case 'upPicTwo':
                        return _this.vari.picFileTwo;
                        break;
                    case 'upPicThree':
                        return _this.vari.picFileThree;
                        break;
                    case 'upPicFour':
                        return _this.vari.picFileFour;
                        break;
                }
            }
            function judgeList(btn) {
                switch (btn) {
                    case 'selPicOne':
                        return 'listPicOne';
                        break;
                    case 'selPicTwo':
                        return 'listPicTwo';
                        break;
                    case 'selPicThree':
                        return 'listPicThree';
                        break;
                    case 'selPicFour':
                        return 'listPicFour';
                        break;
                }
            }

        },
        // 删除模态框
        delPicModal : function(str,cb){
            $('#myDelPicModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#myDelPicModal').modal('show');
            $('#myDelPicModal').on('hidden.bs.modal', function (e) {
                cb&&cb();
            })
        },
        // 删除图片附件
        delPic : function () {
            var _this = this,delBtn = $('#confirmDelPic');
            $('#gallery').off('click').on('click','.file-item i',function () {

                delBtn.attr('data-id',$(this).attr('data-id'))
                delBtn.attr('data-pos',$(this).attr('data-pos'))
                _this.delPicModal('确认删除吗？');
                delBtn.off('click').on('click',function () {
                    // 删除图片id数组中的值
                   var delPic = judgePos(delBtn.attr('data-id'),delBtn.attr('data-pos'));
                    $.ajax({
                        url : util.getServerUrl('/loanOrder/deletePawnInfoPic'),
                        method : 'POST',
                        data : {
                            id:_this.vari.pawnId,
                            picFileOne : _this.vari.picFileOne.join(','),
                            picFileTwo : _this.vari.picFileTwo.join(','),
                            picFileThree : _this.vari.picFileThree.join(','),
                            picFileFour : _this.vari.picFileFour.join(',')
                        },
                        success : function (res) {
                            if (res.status == 0) {
                                myOrderTpl.alertSuccessModel('图片删除成功', function () {
                                    $('#navTab').load('<%=basePath%>loanOrder/myOrderInvestigatePage?orderId=<%=orderId%>');
                                });
                            }else if(res.returnCode==2000){
                                myOrderTpl.alertModel(res.returnMsg);
                                // 将删除的还原到vari中
                                _this.vari[delBtn.attr('data-pos')].push(delPic);
                            }else {
                                if (res.msg == '' || res.msg == 'undefined') {
                                    myOrderTpl.alertModel('图片删除失败!');
                                } else {
                                    myOrderTpl.alertModel(res.msg);
                                }
                                _this.vari[delBtn.attr('data-pos')].push(delPic);
                            }
                        },
                        error : function (error) {
                            myOrderTpl.alertModel(error);
                            _this.vari[delBtn.attr('data-pos')].push(delPic);
                        }
                    })
                })
            })
            function judgePos(id,pos) {
                var index = _this.vari[pos].indexOf(id);
                return _this.vari[pos].splice(index,1)
            }
        }
    }
    $(function () {
        creditInfo.init();
    })
</script>