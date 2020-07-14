<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
                <li class="active"><a href="<%=basePath%>loanOrder/myOrderBusinessApprovePage?orderId=<%=orderId%>"
                                      aria-controls="fore" role="tab" data-toggle="tab" data-target="navTab">业务审批</a>
                </li>
                <li><a href="<%=basePath%>loanOrder/myOrderContractsPage?orderId=<%=orderId%>" aria-controls="five"
                       role="tab" data-toggle="tab" data-target="navTab">合同管理</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderLoanApprovePage?orderId=<%=orderId%>" aria-controls="six"
                       role="tab" data-toggle="tab" data-target="navTab">放款审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderOperateLogPage?orderId=<%=orderId%>" aria-controls="seven"
                       role="tab" data-toggle="tab" data-target="navTab">操作日志</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content" id="businessApprove" v-cloak>

                <div class="tab-pane active" id="fore">
                    <form id="form1">
                        <!--资料完整性审查-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">资料完整性审查</h3>
                            </div>

                            <div class="panel-body clearfix examine">

                                <ul class="spe-ul" id="ulCheckbox">
                                    <li>
                                        <i class="desc-name">1、借款人身份证: </i>
                                        <input type="hidden" name="identityCard" id="identityCard"
                                               value="${userBusinessApproval.identityCard}"/>
                                        <!--
                                        <label for="">
                                        <input type="radio" name="identityCardRadio" id="identityCardRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="identityCardRadio" id="identityCardRadioY" value="1">
                                        	<span>有</span>
                                        </label>
                                        -->
                                        <label for="">
                                            <input type="checkbox" name="identityCardCheckbox" id="identityCardF"
                                                   value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="identityCardCheckbox" id="identityCardY"
                                                   value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li class="spe-li">
                                        <i class="desc-name">借款人配偶身份证: </i>
                                        <input type="hidden" name="spouseIdentityCard" id="spouseIdentityCard"
                                               value="${userBusinessApproval.spouseIdentityCard}"/>
                                        <!-- 
                                        <label for="">
                                        	<input type="radio" name="spouseIdentityCardRadio" id="spouseIdentityCardRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="spouseIdentityCardRadio" id="spouseIdentityCardRadioY" value="1">
                                        	<span>有</span>
                                        </label> -->
                                        <label for="">
                                            <input type="checkbox" name="spouseIdentityCardCheckbox"
                                                   id="spouseIdentityCardF" value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="spouseIdentityCardCheckbox"
                                                   id="spouseIdentityCardY" value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">2、借款人户口簿: </i>
                                        <input type="hidden" name="houseAccount" id="houseAccount"
                                               value="${userBusinessApproval.houseAccount}"/>
                                        <!--  
                                        <label for="">
                                        	<input type="radio" name="houseAccountRadio" id="houseAccountRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="houseAccountRadio" id="houseAccountRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="houseAccountCheckbox" id="houseAccountF"
                                                   value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="houseAccountCheckbox" id="houseAccountY"
                                                   value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li class="spe-li">
                                        <i class="desc-name">借款人配偶户口簿: </i>
                                        <input type="hidden" name="spouseHouseAccount" id="spouseHouseAccount"
                                               value="${userBusinessApproval.spouseHouseAccount}"/>
                                        <!--  
                                        <label for="">
                                        	<input type="radio" name="spouseHouseAccountRadio" id="spouseHouseAccountRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="spouseHouseAccountRadio" id="spouseHouseAccountRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="spouseHouseAccountCheckbox"
                                                   id="spouseHouseAccountF" value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="spouseHouseAccountCheckbox"
                                                   id="spouseHouseAccountY" value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">3、婚姻证明: </i>
                                        <input type="hidden" name="marrProve" id="marrProve"
                                               value="${userBusinessApproval.marrProve}"/>
                                        <!--  
                                        <label for="">
                                        	<input type="radio" name="marrProveRadio" id="marrProveRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="marrProveRadio" id="marrProveRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="marrProveCheckbox" id="marrProveF" value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="marrProveCheckbox" id="marrProveY" value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">4、借款人个人征信报告: </i>
                                        <input type="hidden" name="creditReport" id="creditReport"
                                               value="${userBusinessApproval.creditReport }"/>
                                        <!--  
                                        <label for="">
                                        	<input type="radio" name="creditReportRadio" id="creditReportRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="creditReportRadio" id="creditReportRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="creditReportCheckbox" id="creditReportF"
                                                   value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="creditReportCheckbox" id="creditReportY"
                                                   value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li class="spe-li">
                                        <i class="desc-name">借款人配偶个人征信报告: </i>
                                        <input type="hidden" name="spouseCreditReport" id="spouseCreditReport"
                                               value="${userBusinessApproval.spouseCreditReport}"/>
                                        <!--
                                        <label for="">
                                        	<input type="radio" name="spouseCreditReportRadio" id="spouseCreditReportRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="spouseCreditReportRadio" id="spouseCreditReportRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="spouseCreditReportCheckbox"
                                                   id="spouseCreditReportF" value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="spouseCreditReportCheckbox"
                                                   id="spouseCreditReportY" value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">5、房产证(或不动产证): </i>
                                        <input type="hidden" name="houseCertificate" id="houseCertificate"
                                               value="${userBusinessApproval.houseCertificate}"/>
                                        <!--
                                        <label for="">
                                        	<input type="radio" name="houseCertificateRadio" id="houseCertificateRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="houseCertificateRadio" id="houseCertificateRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="houseCertificateCheckbox"
                                                   id="houseCertificateF" value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="houseCertificateCheckbox"
                                                   id="houseCertificateY" value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">6、国土证: </i>
                                        <input type="hidden" name="nationCertificate" id="nationCertificate"
                                               value="${userBusinessApproval.nationCertificate}"/>
                                        <!--
                                        <label for="">
                                        	<input type="radio" name="nationCertificateRadio" id="nationCertificateRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="nationCertificateRadio" id="nationCertificateRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="nationCertificateCheckbox"
                                                   id="nationCertificateF" value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="nationCertificateCheckbox"
                                                   id="nationCertificateY" value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">7、房屋信息查询记录: </i>
                                        <input type="hidden" name="houseQuery" id="houseQuery"
                                               value="${userBusinessApproval.houseQuery}"/>
                                        <!--
                                        <label for="">
                                        	<input type="radio" name="houseQueryRadio" id="houseQueryRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="houseQueryRadio" id="houseQueryRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="houseQueryCheckbox" id="houseQueryF" value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="houseQueryCheckbox" id="houseQueryY" value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">8、近6个月账户流水: </i>
                                        <input type="hidden" name="bankDetail" id="bankDetail"
                                               value="${userBusinessApproval.bankDetail }"/>
                                        <!--
                                        <label for="">
                                        	<input type="radio" name="bankDetailRadio" id="bankDetailRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="bankDetailRadio" id="bankDetailRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="bankDetailCheckbox" id="bankDetailF" value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="bankDetailCheckbox" id="bankDetailY" value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">9、特殊房产配套资料: </i>
                                        <input type="hidden" name="houseMessage" id="houseMessage"
                                               value="${userBusinessApproval.houseMessage}"/>
                                        <!--
                                        <label for="">
                                        	<input type="radio" name="houseMessageRadio" id="houseMessageRadioN" value="0">
                                        	<span>无</span>
                                        </label>
                                        <label for="">
                                        	<input type="radio" name="houseMessageRadio" id="houseMessageRadioY" value="1">
                                        	<span>有</span>
                                        </label>-->
                                        <label for="">
                                            <input type="checkbox" name="houseMessageCheckbox" id="houseMessageF"
                                                   value="0">
                                            <span>复印件</span>
                                        </label>
                                        <label for="">
                                            <input type="checkbox" name="houseMessageCheckbox" id="houseMessageY"
                                                   value="1">
                                            <span>影印件</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">10、抵押物现场入境照片: </i>
                                        <label for="">
                                            <input type="radio" name="pawnPhoto" id="pawnPhotoY" value="1"
                                                   ${userBusinessApproval.pawnPhoto=="1" ? 'checked':'' }>
                                            <span>有</span>
                                        </label>
                                        <label for="">
                                            <input type="radio" name="pawnPhoto" id="pawnPhotoN" value="0"
                                                   ${userBusinessApproval.pawnPhoto=="0" ? 'checked':'' }>
                                            <span>无</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">11、用途合同或证明: </i>
                                        <label for="">
                                            <input type="radio" name="contractProve" id="contractProveY" value="1"
                                                   ${userBusinessApproval.contractProve=="1" ? 'checked':'' }>
                                            <span>有</span>
                                        </label>
                                        <label for="">
                                            <input type="radio" name="contractProve" id="contractProveN" value="0"
                                                   ${userBusinessApproval.contractProve=="0" ? 'checked':'' }>
                                            <span>无</span>
                                        </label>
                                    </li>
                                    <li>
                                        <i class="desc-name">12、其他: </i>
                                        <input type="text" class="form-control" name="otherProve" id="otherProve"
                                               value="${userBusinessApproval.otherProve }">
                                    </li>
                                </ul>
                                <div class="check-idea">
                                    <i>意见</i>
                                    <label for="">
                                        <input type="radio" name="opinion" value="0" ${userBusinessApproval.opinion=="0"
                                               ? 'checked':'' }>
                                        <span>资料标准</span>
                                    </label>
                                    <label for="">
                                        <input type="radio" name="opinion" value="1" ${userBusinessApproval.opinion=="1"
                                               ? 'checked':'' }>
                                        <span>资料完整但部分为影像资料，放款前补齐复印件</span>
                                    </label>
                                    <label for="">
                                        <input type="radio" name="opinion" value="2" ${userBusinessApproval.opinion=="2"
                                               ? 'checked':'' }>
                                        <span>退件</span>
                                    </label>
                                </div>
                                <div>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">收件人: </i>
                                            <input type="text" class="form-control" name="userReceive"
                                                   value="${userBusinessApproval.userReceive }">
                                        </li>
                                    </ul>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name">收件日期: </i>
                                            <fmt:formatDate value="${userBusinessApproval.receiveTime}"
                                                            pattern="yyyy-MM-dd" var="receiveTime"/>
                                            <input id="receiveTime" type="text" class="form-control" name="receiveTime"
                                                   value="${receiveTime}">
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <!--风控审查-->
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <h3 class="panel-title">风控审查</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <form>
                                    <div class="proposer-check">
                                        <h3>一、申请人审查</h3>
                                        <ul>
                                            <li>
                                                <i>1、工作单位</i>
                                                <label for="">
                                                    <input type="radio" name="workCompany" value="1"
                                                           ${userBusinessApproval.workCompany=="1" ? 'checked':'' }>
                                                    <span>与业务部描述一致</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="workCompany" value="0"
                                                           ${userBusinessApproval.workCompany=="0" ? 'checked':'' }>
                                                    <span>与业务部描述不一致</span>
                                                </label>
                                            </li>
                                            <li>
                                                <i>2、征信情况</i>
                                                <label for="">
                                                    <input type="radio" name="creditResult" value="0"
                                                           ${userBusinessApproval.creditResult=="0" ? 'checked':'' }>
                                                    <span>A类</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="creditResult" value="1"
                                                           ${userBusinessApproval.creditResult=="1" ? 'checked':'' }>
                                                    <span>B类</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="creditResult" value="2"
                                                           ${userBusinessApproval.creditResult=="2" ? 'checked':'' }>
                                                    <span>C类</span>
                                                </label>
                                            </li>
                                            <li>
                                                <i>3、大数据查询情况</i>
                                                <input type="text" class="form-control middle-width"
                                                       name="bigdataQueryMessge"
                                                       value="${userBusinessApproval.bigdataQueryMessge }">
                                                <span style="margin-right: 20px;">涉诉查询情况</span>
                                                <input type="text" class="form-control middle-width"
                                                       name="lawsuitQueryMessage"
                                                       value="${userBusinessApproval.lawsuitQueryMessage }">
                                            </li>
                                            <li>
                                                <i>4、家庭资产负债率</i>
                                                <input type="text" class="form-control middle-width" name="famliyDebt"
                                                       value="${userBusinessApproval.famliyDebt}">
                                                <span>%</span>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="check-pawn">
                                        <h3>二、抵押物审查</h3>
                                        <ul>
                                            <li>
                                                <i>1、所有权人、地址及权证号</i>
                                                <label for="">
                                                    <input type="radio" name="warrantNo" value="1"
                                                           ${userBusinessApproval.warrantNo=="1" ? 'checked':'' }>
                                                    <span>与业务部描述一致</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="warrantNo" value="0"
                                                           ${userBusinessApproval.warrantNo=="0" ? 'checked':'' }>
                                                    <span>与业务部描述不一致</span>
                                                </label>
                                            </li>
                                            <li>
                                                <i>2、区域</i>
                                                <label for="">
                                                    <input type="radio" name="area" value="0"
                                                           ${userBusinessApproval.area=="0" ? 'checked':'' }>
                                                    <span>一类区域</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="area" value="1"
                                                           ${userBusinessApproval.area=="1" ? 'checked':'' }>
                                                    <span>二类区域</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="area" value="2"
                                                           ${userBusinessApproval.area=="2" ? 'checked':'' }>
                                                    <span>三类区域</span>
                                                </label>
                                            </li>
                                            <li class="pledge-orders">
                                                <i>3、本次抵押顺位</i>
                                                <label for="">
                                                    <input type="radio" name="pawnSw" value="0"
                                                           ${userBusinessApproval.pawnSw=="0" ? 'checked':'' }>
                                                    <span>一抵</span>
                                                </label>
                                                <label for="" class="relative">
                                                    <input type="radio" name="pawnSw" value="1"
                                                           ${userBusinessApproval.pawnSw=="1" ? 'checked':'' }>
                                                    <span>二抵(一抵机构名称)</span>
                                                    <input type="text" class="form-control short-width" name="pawnOrg"
                                                           value="${userBusinessApproval.pawnOrg}">
                                                </label>
                                            </li>
                                            <li>
                                                <i>4、唯一住房</i>
                                                <label for="">
                                                    <input type="radio" name="onlyHouse" value="1"
                                                           ${userBusinessApproval.onlyHouse=="1" ? 'checked':'' }>
                                                    <span>是</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="onlyHouse" value="0"
                                                           ${userBusinessApproval.onlyHouse=="0" ? 'checked':'' }>
                                                    <span>否</span>
                                                </label>
                                            </li>
                                            <li>
                                                <i>5、类型</i>
                                                <label for="">
                                                    <input type="radio" name="houseType" value="0"
                                                           ${userBusinessApproval.houseType=="0" ? 'checked':'' }>
                                                    <span>一类房产</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="houseType" value="1"
                                                           ${userBusinessApproval.houseType=="1" ? 'checked':'' }>
                                                    <span>二类房产</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="houseType" value="2"
                                                           ${userBusinessApproval.houseType=="2" ? 'checked':'' }>
                                                    <span>三类房产</span>
                                                </label>
                                            </li>
                                            <li>
                                                <i>6、现状</i>
                                                <label for="">
                                                    <input type="radio" name="houseStatus" value="0"
                                                           ${userBusinessApproval.houseStatus=="0" ? 'checked':'' }>
                                                    <span>自住</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="houseStatus" value="1"
                                                           ${userBusinessApproval.houseStatus=="1" ? 'checked':'' }>
                                                    <span>出租</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="houseStatus" value="2"
                                                           ${userBusinessApproval.houseStatus=="2" ? 'checked':'' }>
                                                    <span>空置</span>
                                                </label>
                                            </li>
                                            <li>
                                                <i>7、是否限售</i>
                                                <label for="">
                                                    <input type="radio" name="houseLimit" value="1"
                                                           ${userBusinessApproval.houseLimit=="1" ? 'checked':'' }>
                                                    <span>是</span>
                                                </label>
                                                <label for="">
                                                    <input type="radio" name="houseLimit" value="0"
                                                           ${userBusinessApproval.houseLimit=="0" ? 'checked':'' }>
                                                    <span>否</span>
                                                </label>
                                            </li>
                                        </ul>
                                        <div class="pawn-price">
                                            <i>8、价值认定</i>
                                            <input type="text" class="form-control spe-form-width" name="cognizancePrice"
                                                   value="${userBusinessApproval.cognizancePrice }">
                                            <span>元</span>
                                            <i>可贷额度:</i>
                                            <input type="text" class="form-control spe-form-width" name="loanQuta"
                                                   value="${userBusinessApproval.loanQuta }">
                                            <span>元</span>
                                            <i>抵押率:</i>
                                            <input type="text" class="form-control spe-form-width" name="pawnRate"
                                                   value="${userBusinessApproval.pawnRate }">
                                            <span>%</span>
                                        </div>
                                    </div>
                                    <div class="borrow-usefor">
                                        <i>三、贷款用途审查</i>
                                        <label for="">
                                            <input type="radio" name="loanUsage" value="0"
                                                   ${userBusinessApproval.loanUsage=="0" ? 'checked':'' }>
                                            <span>与业务部描述一致</span>
                                        </label>
                                        <label for="">
                                            <input type="radio" name="loanUsage" value="1"
                                                   ${userBusinessApproval.loanUsage=="1" ? 'checked':'' }>
                                            <span>与业务部描述基本一致</span>
                                        </label>
                                        <label for="">
                                            <input type="radio" name="loanUsage" value="2"
                                                   ${userBusinessApproval.loanUsage=="2" ? 'checked':'' }>
                                            <span>与业务部描述不一致</span>
                                        </label>
                                    </div>
                                    <div class="borrow-usefor">
                                        <i>四、还款来源审查</i>
                                        <label for="">
                                            <input type="radio" name="repaySource" value="0"
                                                   ${userBusinessApproval.repaySource=="0" ? 'checked':'' }>
                                            <span>充足</span>
                                        </label>
                                        <label for="">
                                            <input type="radio" name="repaySource" value="1"
                                                   ${userBusinessApproval.repaySource=="1" ? 'checked':'' }>
                                            <span>一般</span>
                                        </label>
                                        <label for="">
                                            <input type="radio" name="repaySource" value="2"
                                                   ${userBusinessApproval.repaySource=="2" ? 'checked':'' }>
                                            <span>不足</span>
                                        </label>
                                    </div>
                                    <div class="borrow-usefor">
                                        <i>五、产品指引要求</i>
                                        <label for="">
                                            <input type="radio" name="productRequire" value="1"
                                                   ${userBusinessApproval.productRequire=="1" ? 'checked':'' }>
                                            <span>符合</span>
                                        </label>
                                        <label for="" class="relative">
                                            <input type="radio" name="productRequire" value="0"
                                                   ${userBusinessApproval.productRequire=="0" ? 'checked':'' }>
                                            <span>不符合,(注明原因):</span>
                                            <input type="text" class="form-control middle-width productRequired"
                                                   name="requireMessage" value="${userBusinessApproval.requireMessage}">
                                        </label>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </form>

                    <!--调查意见回显-->
                    <div v-show="processInfo.length != 0">
                        <div class="panel panel-info department" v-for="item in processInfo">
                            <div class="panel-heading">
                                <h3 class="panel-title">{{item.processName}}意见</h3>
                                <p class="pull-right" style="margin-top: -15px;">
                                    审批人员: <span>{{item.userName}}</span>&nbsp;&nbsp;&nbsp;&nbsp;<span>{{item.updateDate}}</span>
                                </p>
                            </div>
                            <div class="panel-body clearfix">
                                <form>
                                    <ul class="base-info">
                                        <li>
                                            <i class="desc-name text-right">贷款额度(元): </i>
                                            <input disabled type="text" class="form-control css-disabled"
                                                   :value="item.auditAmount" name="auditAmount">
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">贷款期限(月): </i>
                                            <select disabled name="auditPeriod" class="form-control css-disabled">
                                                <option :selected="periodItem.value == item.auditPeriod" v-for="periodItem in productPeriodInfo" :value="periodItem.value">{{periodItem.labelText}}</option>
                                            </select>
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">月利率(%): </i>
                                            <input disabled type="text" class="form-control css-disabled"
                                                   :value="item.auditMonthRate | monthRating" name="auditMonthRate">
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">还款方式: </i>
                                            <select disabled class="form-control css-disabled" name="repayWay">
                                                <option :selected="repayWayItem.value == item.repayWay"
                                                        v-for="repayWayItem in repayWayInfo"
                                                        :value="repayWayItem.value">{{repayWayItem.text}}
                                                </option>
                                            </select>
                                        </li>
                                    </ul>
                                    <ul class="base-info" v-show="item.guaranteeWay != undefined">
                                        <li>
                                            <i class="desc-name text-right">担保方式: </i>
                                            <textarea readonly class="form-control idea css-disabled pointer" rows="4"
                                                    name="guaranteeWay">{{item.guaranteeWay}}</textarea>
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">业务风险点: </i>
                                            <textarea readonly class="form-control idea css-disabled pointer" rows="4"
                                                    name="businessRiskTip">{{item.businessRiskTip}}</textarea>
                                        </li>
                                    </ul>
                                    <ul class="base-info" v-show="item.leaderOpinion != undefined">
                                        <li>
                                            <i class="desc-name text-right">领导意见: </i>
                                            <textarea readonly class="form-control idea css-disabled pointer" rows="4"
                                                      name="leaderOpinion">{{item.leaderOpinion}}</textarea>
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


                    <!--调查意见-->
                    <c:if test="${fn:contains(roleType, 'riskManager') || fn:contains(roleType, 'riskCommissioner') || fn:contains(roleType, 'riskDirector') || fn:contains(roleType, 'chairman')}">
                        <div class="panel panel-info department">
                            <div class="panel-heading">
                                <h3 class="panel-title">审批意见</h3>
                            </div>
                            <div class="panel-body clearfix">
                                <form id="auditForm">
                                    <ul class="base-info mr0">
                                        <li class="relative">
                                            <i class="desc-name text-right">贷款额度(元): </i>
                                            <input id="auditAmount" type="number" class="form-control" value=""
                                                   name="auditAmount">
                                            <span id="toUpperMoney"></span>
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">贷款期限(月): </i>
                                            <select name="auditPeriod" class="form-control">
                                                <option value="">-请选择贷款期限-</option>
                                                <option v-for="periodItem in productPeriodInfo" :value="periodItem.value">{{periodItem.labelText}}</option>
                                            </select>
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">月利率(%): </i>
                                            <input type="text" id="auditMonthRate" class="form-control" value=""
                                                   oninput="if(value.length>8)value=value.slice(0,8)"
                                                   name="auditMonthRate">
                                        </li>
                                        <li>
                                            <i class="desc-name text-right">还款方式: </i>
                                            <select id="" class="form-control" name="repayWay">
                                                <option value="">-请选择还款方式-</option>
                                                <option v-for="repayWayItem in repayWayInfo"
                                                        :value="repayWayItem.value">{{repayWayItem.text}}
                                                </option>
                                            </select>
                                        </li>
                                    </ul>
                                    <c:if test="${fn:contains(roleType, 'riskCommissioner') || fn:contains(roleType, 'riskManager')}">
                                        <ul class="base-info mr0">
                                            <li>
                                                <i class="desc-name text-right">担保方式: </i>
                                                <textarea maxlength="1000" placeholder="请输入不超过1000字" name="guaranteeWay" class="form-control inline-block remark" rows="4"></textarea>
                                            </li>
                                            <li>
                                                <i class="desc-name text-right">业务风险点: </i>
                                                <textarea maxlength="1000" placeholder="请输入不超过1000字" name="businessRiskTip" class="form-control inline-block remark" rows="4"></textarea>
                                            </li>
                                        </ul>
                                    </c:if>
                                    <c:if test="${fn:contains(roleType, 'riskDirector') || fn:contains(roleType, 'chairman')}">
                                        <ul class="base-info mr0">
                                            <li>
                                                <i class="desc-name text-right">领导意见: </i>
                                                <textarea maxlength="1000" placeholder="请输入不超过1000字" class="form-control idea" rows="4"
                                                          name="leaderOpinion"></textarea>
                                            </li>
                                        </ul>
                                    </c:if>
                                    <ul class="base-info remark-ul mr0">
                                        <li class="relative">
                                            <i class="desc-name text-right">备注: </i>
                                            <textarea maxlength="1000" placeholder="请输入不超过1000字" name="remark" id="remark" class="form-control inline-block remark" rows="4"></textarea>
                                        </li>
                                    </ul>
                                </form>
                            </div>
                        </div>
                    </c:if>
                    <div class="control">
                        <div>
                            <a href="<%=basePath%>businessApprovePrint.html?orderId=<%=orderId%>" target="_blank" class="btn btn-print btn-new">打印</a>
                            <c:if test="${fn:contains(roleType, 'riskCommissioner')}">
                                <span>
                                    <input type="hidden" name="orderId" id="orderId" value="${orderId}"/>
                                    <input type="hidden" name="id" id="otherId" value="${userBusinessApproval.id}"/>
                                    <button class="btn btn-new btn-submit" id="saveBusinessApprove"
                                            onclick="return false">保存</button>
                                </span>
                            </c:if>
                            <c:if test="${fn:contains(roleType, 'riskCommissioner') && orderStatus == 3}">
                            	<span class="btns">
                                    <input type="hidden" processid="6">
	                                <button class="btn btn-submit btn-new" id="riskCommissionerAuditPass">通过</button>
	                                 <button class="btn btn-refuse btn-new" id="riskCommissionerAuditRefuse">拒绝</button>
	                                 <button class="btn btn-reject btn-new" id="riskCommissionerAuditReject">驳回</button>
	                                 <span>驳回理由:</span>
	                                 <textarea maxlength="1000" placeholder="请输入理由不超过1000字" cols="5"
                                               class="form-control rejectReason business-reply"></textarea>
	                                 <span>驳回到:</span>
	                                 <select name="" class="form-control rejectTo business-reply-select">
                                        <option v-for="item in processFlowInfo" :value="item.processId">{{item.processName}}</option>
	                                 </select>
	                             </span>
                            </c:if>
                            <c:if test="${fn:contains(roleType, 'riskManager') && orderStatus == 51}">
	                            <span class="btns">
                                    <input type="hidden" processid="61">
	                                <button class="btn btn-submit btn-new" id="riskManagerAuditPass">通过</button>
	                                 <button class="btn btn-refuse btn-new" id="riskManagerAuditRefuse">拒绝</button>
	                                 <button class="btn btn-reject btn-new" id="riskManagerAuditReject">驳回</button>
	                                 <span>驳回理由:</span>
	                                 <textarea maxlength="1000" placeholder="请输入理由不超过1000字" cols="5"
                                               class="form-control rejectReason business-reply"></textarea>
	                                 <span>驳回到:</span>
	                                 <select name="" class="form-control rejectTo business-reply-select">
                                        <option v-for="item in processFlowInfo" :value="item.processId">{{item.processName}}</option>
	                                 </select>
	                             </span>
                            </c:if>
                            <c:if test="${fn:contains(roleType, 'riskDirector') && orderStatus == 53}">
	                            <span class="btns">
                                    <input type="hidden" processid="62">
	                                <button class="btn btn-submit btn-new" id="riskDirectorCheckAuditPass">通过</button>
	                                 <button class="btn btn-refuse btn-new"
                                             id="riskDirectorCheckAuditRefuse">拒绝</button>
	                                 <button class="btn btn-reject btn-new"
                                             id="riskDirectorCheckAuditReject">驳回</button>
	                                 <span>驳回理由:</span>
	                                 <textarea maxlength="1000" placeholder="请输入理由不超过1000字" cols="5"
                                               class="form-control rejectReason business-reply"></textarea>
	                                 <span>驳回到:</span>
	                                 <select name="" class="form-control rejectTo business-reply-select">
                                        <option v-for="item in processFlowInfo" :value="item.processId">{{item.processName}}</option>
	                                 </select>
	                             </span>
                            </c:if>
                            <c:if test="${fn:contains(roleType, 'riskDirector') && orderStatus == 54}">
	                            <span class="btns">
                                    <input type="hidden" processid="7">
	                                <button class="btn btn-submit btn-new" id="riskDirectorFinalAuditPass">通过</button>
	                                 <button class="btn btn-refuse btn-new"
                                             id="riskDirectorFinalAuditRefuse">拒绝</button>
	                                 <button class="btn btn-reject btn-new"
                                             id="riskDirectorFinalAuditReject">驳回</button>
	                                 <span>驳回理由:</span>
	                                 <textarea maxlength="1000" placeholder="请输入理由不超过1000字" cols="5"
                                               class="form-control rejectReason business-reply"></textarea>
	                                 <span>驳回到:</span>
	                                 <select name="" class="form-control rejectTo business-reply-select">
                                        <option v-for="item in processFlowInfo" :value="item.processId">{{item.processName}}</option>
	                                 </select>
	                             </span>
                            </c:if>
                            <c:if test="${fn:contains(roleType, 'chairman') && orderStatus == 54}">
	                            <span class="btns">
                                    <input type="hidden" processid="7">
	                                <button class="btn btn-submit btn-new" id="chairmanAuditPass">通过</button>
	                                 <button class="btn btn-refuse btn-new" id="chairmanAuditRefuse">拒绝</button>
	                                 <button class="btn btn-reject btn-new" id="chairmanAuditReject">驳回</button>
	                                 <span>驳回理由:</span>
	                                 <textarea maxlength="1000" placeholder="请输入理由不超过1000字" cols="5"
                                               class="form-control rejectReason business-reply"></textarea>
	                                 <span>驳回到:</span>
	                                 <select name="" class="form-control rejectTo business-reply-select">
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
</div>
<div id="mask">
    <div class="areaContent"></div>
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
            basePath : '<%=basePath%>'
        });
    })
</script>
<script>
    var businessApprove = {
        vari: {
            orderId: '<%=orderId%>',
            userBusinessApproval: '' // 判断有无保存过
        },
        init: function () {
            this.newVue();
            this.getReply();
            this.getProcessOrderFlows($('.control span.btns input[type="hidden"]').attr('processid'));
            this.bindEvent();
            this.renderTime();
        },
        bindEvent: function () {
            // 点击保存表单
            $('#saveBusinessApprove').click(function () {
                // 组装复选项
                checkboxZL();

                var params = {};
                for (var i = 0; i < $("#form1").serializeArray().length; i++) {
                    params[$("#form1").serializeArray()[i].name] = $("#form1").serializeArray()[i].value;
                }

                // 时间补全
                if (params["receiveTime"] != "") {
                    params["receiveTime"] = params["receiveTime"] + " 00:00:00"
                }
                // 一些id
                params.orderId = $('#orderId').val();
                params.id = $('#otherId').val();

                $.ajax({
                    url: '<%=path%>/loanOrder/saveBusinessApproval',
                    method: 'POST',
                    data: params,
                    success: function (res) {
                        if (res.status == 0) {
                            myOrderTpl.alertSuccessModel('业务审批保存成功',function () {
                                $('#navTab').load('<%=basePath%>loanOrder/myOrderBusinessApprovePage?orderId=<%=orderId%>');
                            });
                        } else {
                            myOrderTpl.alertModel("保存失败");
                        }
                    },
                    error: function (error) {
                        myOrderTpl.alertModel("保存失败");
                    }
                })

            })
            // 数字转大写金额
            $('#auditAmount').keyup(function () {
                if($(this).val()==''){
                    $('#toUpperMoney').text('');
                    return false;
                }
                $('#toUpperMoney').text(toUpperMoney(Number($(this).val())))
            })
            //风控专员
            this.examize($('#riskCommissionerAuditPass'), 1, 6);
            this.examize($('#riskCommissionerAuditRefuse'), 3, 6);
            this.examize($('#riskCommissionerAuditReject'), 2, 6);
            //风控经理
            this.examize($('#riskManagerAuditPass'), 1, 61);
            this.examize($('#riskManagerAuditRefuse'), 3, 61);
            this.examize($('#riskManagerAuditReject'), 2, 61);

            //风控总监(复审)
            this.examize($('#riskDirectorCheckAuditPass'), 1, 62);
            this.examize($('#riskDirectorCheckAuditRefuse'), 3, 62);
            this.examize($('#riskDirectorCheckAuditReject'), 2, 62);

            //风控总监(有权审批人)
            this.examize($('#riskDirectorFinalAuditPass'), 1, 7);
            this.examize($('#riskDirectorFinalAuditRefuse'), 3, 7);
            this.examize($('#riskDirectorFinalAuditReject'), 2, 7);

            //董事长
            this.examize($('#chairmanAuditPass'), 1, 7);
            this.examize($('#chairmanAuditRefuse'), 3, 7);
            this.examize($('#chairmanAuditReject'), 2, 7);

            myOrderTpl.showTextArea();
        },
        vm: {},
        // 审核 通过拒绝审核
        examize: function (btn, resultValue, processId) {
            var _this = this;
            btn.click(function () {
                var remarkTemp = $("#auditForm").serializeArray();
                var remarkExtend = {};
                for (var i = 0; i < remarkTemp.length; i++) {
                    remarkExtend[remarkTemp[i].name] = remarkTemp[i].value;
                }
                if (resultValue == 1) {
                    // 判断有无保存过
                    if (_this.vari.userBusinessApproval == '') {
                        myOrderTpl.alertModel('风控专员请先保存资料!');
                        return;
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
        newVue: function () {
            this.vm = new Vue({
                el: '#businessApprove',
                data: {
                    processFlowInfo: [],
                    processInfo: [],
                    productPeriodInfo : [],
                    repayWayInfo: [],
                },
                filters: {
                    monthRating: function (value) {
                        return Number(value).div(12).toFixed(6);
                    }
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
            var receiveTime = new Pikaday({
                field: $('#receiveTime')[0],
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
        // 获取审批意见
        getReply: function () {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/loanOrder/getBusinessApproval'),
                method: 'POST',
                data: {
                    orderId: this.vari.orderId,
                },
                success: function (res) {
                    if (res.status == 0) {
                        _this.vm.processInfo = res.data.processInfo;
                        _this.vm.productPeriodInfo = res.data.productPeriodInfo;
                        _this.vm.repayWayInfo = res.data.repayWayInfo;
                        _this.vari.userBusinessApproval = res.data.userBusinessApproval;
                    } else {
                        if (res.msg == '' || res.msg == undefined) {
                            myOrderTpl.alertModel('获取审批意见失败，请稍后刷新重试!');
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
        // 金额大于100万
        judegMoney: function () {
            return Number('${orderAmount}') > 1000000 ? true : false;
        },
    }
    $(function () {
        businessApprove.init();

        // 数据整理
        checkboxData();

    })

    // 提交时整理checkbox数据
    function checkboxZL() {
        $.each($('#ulCheckbox li'), function (k, v) {
            var name = $(this).find('input[type="checkbox"]').eq(0).attr('name');
            $(this).find('input[type="hidden"]').val(myOrderTpl.getiCheckItem(name).join('#'));
        })
    }

    // 初始化checkbox
    function checkboxData() {

        $.each($('#ulCheckbox li'), function (k, v) {
            var hiddenObj = $(this).find('input[type="hidden"]').eq(0).get(0);
            var checkboxOne = $(this).find('input[type="checkbox"]').eq(0).get(0);
            var checkboxTwo = $(this).find('input[type="checkbox"]').eq(1).get(0);
            if (hiddenObj != null) {
                var hiddenValue = hiddenObj.value;
                if (hiddenValue != "") {
                    var hiddenValueArr = hiddenValue.split("#");
                    for (var i = 0; i < hiddenValueArr.length; i++) {
                        var hvalue = hiddenValueArr[i];
                        if (hvalue == "0") {
                            checkboxOne.checked = true;
                        }
                        if (hvalue == "1") {
                            checkboxTwo.checked = true;
                        }
                    }
                }
            }
        })
        businessApprove.renderIcheck();

    }
</script>