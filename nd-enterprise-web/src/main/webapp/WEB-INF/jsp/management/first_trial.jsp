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
String processId = request.getParameter("processId") ;
%>
<%
String orderId = request.getParameter("orderId") ;
%>
<link rel="stylesheet" href="static/plugins/magnify/jquery.magnify.min.css">
<link rel="stylesheet" href="<%=basePath%>static/css/management-first-trial.css">

<div class="container-fluid">
    <div class="nav-bar">
        <a data-model="navTab"></a>
        <div class="reject-reason"><span id="rejectName"></span> &nbsp;&nbsp;:&nbsp;&nbsp; <span id="rejectContent"></span></div>
    </div>
    <div class="steps">
        <ul class="clearfix" id="step_process">
            <li class="active">
                <span class="time-out"></span>
                <span class="normal">启动</span>
            </li>
            <li class="process"></li>
            <li class="">
                        <span class="time-out">
                        </span>
                <span class="normal">手动分单</span>
            </li>
            <li class="process"></li>
            <li class="">
                        <span class="time-out">
                        </span>
                <span class="normal">初审</span>
            </li>
            <li class="process"></li>
            <li>

                <span class="normal">复审</span>
            </li>
            <li class="process"></li>
            <li>

                <span class="normal">终审</span>
            </li>
            <li class="process"></li>
            <li>

                <span class="normal">结束</span>
            </li>
        </ul>
    </div>

    <div class="check-cheat" style="display: none">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h3 class="panel-title pull-left">反欺诈核查</h3>
                <p class="pull-right" style="margin: 0;" id="checkCheat">
                    核查人员: <span></span>&nbsp;&nbsp;&nbsp;&nbsp; 操作时间: <span></span>
                </p>
            </div>
            <div class="panel-body">
                <div class="rev-cheat-result">
                    <span>反欺诈结果:</span>
                    <label for="cheatResult"><input id="cheatResult" type="radio" name="rev-cheat-result" value="1">欺诈</label>
                    <label for="normalResult"><input checked id="normalResult" type="radio" name="rev-cheat-result" value="0">正常</label>
                </div>
                <div class="rev-cheat-describe">
                    <span>反欺诈核查描述：（限500个字内）</span>
                    <textarea id="revCheatDesc" class="form-control" rows="6"></textarea>
                </div>
                <button class="btn btn-primary" id="saveRevCheat">保存</button>
            </div>
        </div>

    </div>
    <div class="tab-con">
        <div>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist" id="myTabs">
                <li class="active"><a href="#one" aria-controls="one" role="tab" data-toggle="tab">基础信息<span
                        class="badge"></span></a></li>
                <li><a href="#two" aria-controls="two" role="tab" data-toggle="tab">信用信息<span
                        class="badge"></span></a></li>
                <li><a href="#three" aria-controls="three" role="tab" data-toggle="tab">人工核查<span
                        class="badge"></span></a></li>
                <li><a href="#fore" aria-controls="fore" role="tab" data-toggle="tab">信审信息<span
                        class="badge"></span></a></li>
                <li><a href="#five" aria-controls="five" role="tab" data-toggle="tab">订单审批</a></li>
                <li><a href="#six" aria-controls="six" role="tab" data-toggle="tab">操作日志</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane active" id="one">
                    <!--申请信息-->
                    <div class="panel panel-info apply-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">申请信息</h3>
                        </div>
                        <div class="panel-body clearfix application">
                            <ul>
                                <li><i class="desc-name">申请金额: </i> <input disabled type="text" class="form-control amount" value="">
                                    元 <span class="badge">*</span></li>
                                <li><i class="desc-name">申请期限: </i> <input disabled type="text" class="form-control period" value="">
                                    期 <span class="badge">*</span></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">用途: </i> <input disabled type="text" class="form-control usageDesc"
                                               value=""> <span class="badge">*</span></li>
                                <li><i class="desc-name">合作商户: </i> <input data-toggle="tooltip" data-placement="right" disabled type="text" class="form-control channelName"
                                                 value=""></li>
                            </ul>
                        </div>
                    </div>
                    <!--个人信息-->
                    <div class="panel panel-info self-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">个人信息</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div class="not-home-pos clearfix">
                                <ul>
                                    <li><i class="desc-name">姓名: </i> <input disabled class="form-control name" type="text" value="">
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">学历: </i>
                                        <select name="education" class="form-control education" disabled>
                                            <option value="1">高中</option>
                                            <option value="2">大专</option>
                                            <option value="3">大学</option>
                                            <option value="4">研究生</option>
                                            <option value="5">中专学校</option>
                                            <option value="6">技术学校</option>
                                            <option value="7">初中</option>
                                            <option value="8">小学</option>
                                            <option value="9">文盲或半文盲</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">银行卡: </i> <input disabled class="form-control bankAccount" type="text"
                                                    value=""> <span
                                            class="badge">*</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">身份证号: </i> <input disabled class="form-control identity" type="text"
                                                     value=""> <span class="badge">*</span></li>
                                    <li><i class="desc-name">婚姻状况: </i>
                                        <select disabled name="marrStatus" class="form-control marrStatus">
                                            <option value="1">已婚</option>
                                            <option value="2">未婚</option>
                                            <option value="3">离异</option>
                                            <option value="4">丧偶</option>
                                            <option value="5">再婚</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">手机号码: </i> <input disabled class="form-control phone" type="text" value=""
                                    > <span class="badge">*</span></li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">性别: </i>
                                        <select disabled name="sex" class="form-control sex">
                                            <option value="1">男</option>
                                            <option value="0">女</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">年龄: </i> <input disabled class="form-control age" type="text" value="">
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">居住性质: </i>
                                        <select disabled name="estateType" class="form-control estateType">
                                            <option value="1">一次性购买</option>
                                            <option value="2">按揭(月还款)</option>
                                            <option value="3">租赁(月租金)</option>
                                            <option value="4">与父母同住</option>
                                            <option value="5">自建</option>
                                            <option value="6">其他</option>
                                        </select>
                                        <span class="badge">*</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">户籍: </i> <input data-toggle="tooltip" data-placement="right" disabled class="form-control householdReg" type="text"
                                                   value=""
                                    ></li>
                                </ul>
                            </div>
                            <div class="home-pos">
                                <i class="desc-name">住址: </i>
                                <!--<select name="home_province" id="home_province" class="form-control">-->
                                <!--<option value="0" selected>四川省</option>-->
                                <!--<option value="1">江西省</option>-->
                                <!--</select>-->
                                <!--<select name="home_city" id="home_city" class="form-control">-->
                                <!--<option value="0" selected>成都市</option>-->
                                <!--<option value="1">绵阳市</option>-->
                                <!--</select>-->
                                <!--<select name="home_area" id="home_area" class="form-control">-->
                                <!--<option value="0" selected>锦江区</option>-->
                                <!--<option value="1">高新区</option>-->
                                <!--</select>-->
                                <input disabled class="special-length form-control address" type="text"
                                       value=""> <span
                                    class="badge">*</span>
                            </div>
                        </div>
                    </div>
                    <!--工作单位-->
                    <div class="panel panel-info work-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">工作单位</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div class="not-work-pos clearfix">
                                <ul>
                                    <li><i class="desc-name">单位性质: </i>
                                        <select disabled name="orgNature" class="form-control orgNature">
                                            <option value="">无</option>
                                            <option value="1">行政机关</option>
                                            <option value="2">国有企业</option>
                                            <option value="3">事业单位</option>
                                            <option value="4">三资企业</option>
                                            <option value="5">私营企业</option>
                                            <option value="6">个体户</option>
                                            <option value="7">其他</option>
                                        </select>
                                        </li>
                                    <li><i class="desc-name">单位名称: </i> <input data-toggle="tooltip" data-placement="right" disabled class="form-control orgName" type="text" value=""
                                    ></li>
                                    <li><i class="desc-name">单位电话: </i> <input disabled class="form-control orgContact" type="text"
                                                     value=""
                                    >
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">职位: </i> <input disabled class="form-control position" type="text"
                                                   value=""></li>
                                    <li>
                                        <i class="desc-name">月收入: </i> 
                                        <select disabled name="monthIncome" class="form-control monthIncome">
                                            <option value="">无</option>
                                            <option value="1">3000及以下</option>
                                            <option value="2">3001~5000</option>
                                            <option value="3">5001~7000</option>
                                            <option value="4">7001~10000</option>
                                            <option value="5">10001~15000</option>
                                            <option value="6">15000以上</option>
                                        </select>
                                        <span class="badge">*</span>
                                    </li>
                                    <li>
                                        <i class="desc-name">最近工作年限: </i>
                                        <select disabled name="workYears" class="form-control workYears">
                                            <option value="">无</option>
                                            <option value="1">1年内</option>
                                            <option value="2">1-3年</option>
                                            <option value="3">3-5年</option>
                                            <option value="4">5年以上</option>
                                        </select>
                                        <!--<span class="badge">*</span>-->
                                    </li>
                                </ul>
                            </div>
                            <div class="work-pos">
                                <i class="desc-name">单位地址: </i>
                                <!--<select name="work_province" id="work_province" class="form-control">-->
                                <!--<option value="0" selected>四川省</option>-->
                                <!--<option value="1">江西省</option>-->
                                <!--</select>-->
                                <!--<select name="work_city" id="work_city" class="form-control">-->
                                <!--<option value="0" selected>成都市</option>-->
                                <!--<option value="1">绵阳市</option>-->
                                <!--</select>-->
                                <!--<select name="work_area" id="work_area" class="form-control">-->
                                <!--<option value="0" selected>锦江区</option>-->
                                <!--<option value="1">高新区</option>-->
                                <!--</select>-->
                                <input disabled class="special-length form-control orgAddress" type="text"
                                       value="">
                            </div>
                        </div>
                    </div>
                    <!--车辆信息-->
                    <div class="panel panel-info car-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">车辆信息</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul>
                                <li><i class="desc-name">品牌: </i> <input disabled class="form-control brand" type="text" value=""></li>
                                <li>
                                    <i class="desc-name">价格: </i>
                                    <input disabled class="form-control buyPrice" type="text" value="">
                                </li>

                            </ul>
                            <ul>
                                <li><i class="desc-name">型号: </i> <input disabled class="form-control model" type="text" value=""></li>
                                <li><i class="desc-name">首付款: </i> <input disabled class="form-control firstPayment" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name" style="width: 125px;">上一承租人项目编号: </i> <input disabled class="form-control lastProjectNo" type="text" value=""></li>
                                <li><i class="desc-name" style="width: 125px;">第一个承租人项目编号: </i> <input disabled class="form-control firstProjectNo" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">车辆保单号: </i> <input disabled class="form-control insuranceNo" type="text" value=""></li>
                                <li><i class="desc-name">车架号: </i> <input disabled class="form-control vin" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">车牌号: </i> <input disabled class="form-control carNumber" type="text" value=""></li>
                            </ul>
                        </div>
                    </div>
                    <!--联系人-->
                    <div class="panel panel-info contact-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">联系人</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul class="relative-name">

                            </ul>
                            <ul class="relative-mobile">

                            </ul>
                        </div>
                    </div>
                    <!--上传资产佐证-->
                    <div class="panel panel-info contact-info asset-prove">
                        <div class="panel-heading">
                            <h3 class="panel-title">上传资料(选填)</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul class="assetProve">
                                <!--<li>-->
                                <!--<p>房产</p>-->
                                <!--<img data-magnify="gallery" src="static/img/02.jpg" data-src="static/img/01.jpg" alt="" id="demo">-->
                                <!--<img data-magnify="gallery" src="static/img/02.jpg" data-src="static/img/01.jpg" alt="" id="demo">-->
                                <!--</li>-->
                            </ul>
                        </div>
                    </div>
                    <!--上传其他资料-->
                    <div class="panel panel-info contact-info other-prove">
                        <div class="panel-heading">
                            <h3 class="panel-title">上传其他资料(选填)</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul class="otherProve">

                            </ul>
                        </div>
                    </div>
                    <div class="panel base-info-control-info select-flag">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-7">
                                    <button class="btn btn-success" id="base_info_btn_checked">已核对</button>
                                    <div class="base-info-refuse row block">
                                        <button class="btn btn-danger" id="base_info_btn_refuse">拒绝</button>
                                        <div class="base-info-refuse mlr15">
                                            拒绝理由:
                                            <select name="refuse" id="base_info_refuse" class="form-control">

                                            </select>
                                        </div>
                                        <div class="base-info-refuse">
                                            拒件原因:
                                            <input type="text" class="form-control refuse-reason"
                                                   id="base_info_refuse_reason">
                                            <div class="base-info-refuseTree">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="row">
                                        <div class="col-sm-1">
                                            <button type="button" class="btn btn-primary"
                                                    id="base_info_btn_reject">驳回
                                            </button>
                                        </div>
                                        <div class="col-sm-10">
                                                    <textarea id="base_info_btn_reject_reason" class="form-control"
                                                              rows="4"
                                                              placeholder="驳回理由"></textarea>
                                            驳回到: <select class="form-control" id="base_info_btn_reject_to">
                                            <option value="0" selected>增补资料</option>
                                            <option value="5">初审</option>
                                            <option value="6">复审</option>
                                            <option value="7">终审</option>
                                        </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="two">
                    <!--征信情况-->
                    <div class="panel panel-info credit-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">征信情况</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul>
                                <li class="w400"><i class="desc-spe-name">近3个月机构查询次数:</i> <input type="number" class="form-control" value=""
                                                       id="agentCount"></li>
                                <li class="w400"><i class="desc-spe-name">近6个月逾期次数:</i> <input type="number" class="form-control" value=""
                                                     id="overdueMonth6"></li>
                                <li class="w400"><i class="desc-spe-name">信用卡近6个月平均使用额度:</i> <input type="number" class="form-control" value=""
                                                          id="creditCardAmt"></li>
                                <li class="w400"><i class="desc-spe-name">信用负债余额:</i> <input type="number" class="form-control" value="" id="creditBalance">
                                </li>
                                <li class="w400"><i class="desc-spe-name">当前逾期状态:</i> <select name="" id="overdueStatus" class="form-control">
                                    <option value="否">否</option>
                                    <option value="是">是</option>
                                </select></li>
                                <li class="w400"><i class="desc-spe-name">近两年连续逾期次数:</i> <input type="number" class="form-control" value=""
                                                      id="overdueMonth24"></li>
                            </ul>
                            <ul>
                                <li class="w400"><i class="desc-spe-name">近3个月个人查询次数:</i> <input type="number" id="personCount" class="form-control"
                                                       value=""></li>
                                <li class="w400"><i class="desc-spe-name">近12个月逾期次数:</i> <input type="number" id="overdueMonth12" class="form-control"
                                                      value=""></li>
                                <li class="w400"><i class="desc-spe-name">抵押负债余额:</i> <input type="number" id="mortageBalance" class="form-control"
                                                   value=""></li>
                                <li class="w400"><i class="desc-spe-name">总月均负债:</i> <input type="number" id="balanceAvr" class="form-control" value="">
                                </li>
                                <li class="w400"><i class="desc-spe-name">账户异常状态:</i> <select name="" id="accountStatus" class="form-control">
                                    <option value="正常">正常</option>
                                    <option value="关注">关注</option>
                                    <option value="次级">次级</option>
                                    <option value="损失">损失</option>
                                    <option value="坏账">坏账</option>
                                    <option value="止付">止付</option>
                                    <option value="冻结">冻结</option>
                                    <option value="呆账">呆账</option>
                                </select></li>
                            </ul>
                            <button class="btn btn-success" id="saveCredit">保存</button>
                        </div>
                    </div>
                    <!--授权资料-->
                    <div class="panel panel-info authorization-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">授权资料</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div class="address-list">
                                <span>通讯录</span>
                                <button class="btn btn-success" id="export_list">导出</button>
                            </div>
                            <div class="recently-login">
                                <span>最近登录:</span>
                                <div class="rencently-map clearfix">
                                    <div class="display-text pull-left">
                                        <p id="map_info">地理位置获取中...</p>
                                    </div>
                                    <div class="map-location pull-left" id="map_location"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--贷款历史记录-->
                    <!--<div class="panel panel-info credit-history">-->
                        <!--<div class="panel-heading">-->
                            <!--<h3 class="panel-title">贷款历史记录</h3>-->
                        <!--</div>-->
                        <!--<div class="panel-body clearfix">-->
                            <!--<ul>-->
                                <!--<li>是否存在其他产品贷款申请处于审核中: <span class="credit-history-tag">0</span></li>-->
                                <!--<li>贷款申请成功次数: <span class="credit-history-tag">1</span></li>-->
                                <!--<li>贷款累计申请次数: <span class="credit-history-tag">2</span></li>-->
                            <!--</ul>-->
                            <!--<ul>-->
                                <!--<li>是否存在本平台贷款正在还款中: <span class="credit-history-tag">3</span></li>-->
                                <!--<li>贷款申请拒绝次数: <span class="credit-history-tag">4</span></li>-->
                            <!--</ul>-->
                        <!--</div>-->
                    <!--</div>-->
                    <!--按钮操作-->
                    <div class="panel credit-info-control-info select-flag">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-7">
                                    <button class="btn btn-success" id="credit_info_btn_checked">已核对</button>
                                    <div class="credit-info-refuse row block">
                                        <button class="btn btn-danger" id="credit_info_btn_refuse">拒绝</button>
                                        <div class="credit-info-refuse mlr15">
                                            拒绝理由:
                                            <select name="refuse" id="credit_info_refuse" class="form-control">

                                            </select>
                                        </div>
                                        <div class="credit-info-refuse">
                                            拒件原因:
                                            <input type="text" class="form-control refuse-reason"
                                                   id="credit_info_refuse_reason">
                                            <div class="credit-info-refuseTree">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="row">
                                        <div class="col-sm-1">
                                            <button type="button" class="btn btn-primary"
                                                    id="credit_info_btn_reject">驳回
                                            </button>
                                        </div>
                                        <div class="col-sm-10">
                                                    <textarea id="credit_info_btn_reject_reason" class="form-control"
                                                              rows="4"
                                                              placeholder="驳回理由"></textarea>
                                            驳回到: <select class="form-control" id="credit_info_btn_reject_to">
                                            <option value="0" selected>增补资料</option>
                                            <option value="5">初审</option>
                                            <option value="6">复审</option>
                                            <option value="7">终审</option>
                                        </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="three">
                    <!--申请信息-->
                    <div class="panel panel-info apply-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">申请信息</h3>
                        </div>
                        <div class="panel-body clearfix application">
                            <ul>
                                <li><i class="desc-name">申请金额: </i> <input disabled type="text" class="form-control amount" value="">
                                    元 <span class="badge">*</span></li>
                                <li><i class="desc-name">申请期限: </i> <input disabled type="text" class="form-control period" value="">
                                    期 <span class="badge">*</span></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">用途: </i> <input disabled type="text" class="form-control usageDesc"
                                               value=""> <span class="badge">*</span></li>
                                <li><i class="desc-name">合作商户: </i> <input data-toggle="tooltip" data-placement="right" disabled type="text" class="form-control channelName"
                                                 value=""></li>
                            </ul>
                            <ul>
                                <li>
                                    <i class="desc-name">是否异常: </i>
                                    <select id="applyInfoCheckAbnormal" name="" class="form-control">
                                        <option value="false">否</option>
                                        <option value="true">是</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="desc-name">备注: </i>
                                    <textarea id="applyInfoCheckRemark" class="form-control"></textarea>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!--个人信息-->
                    <div class="panel panel-info self-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">个人信息</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div class="not-home-pos clearfix">
                                <ul>
                                    <li><i class="desc-name">姓名: </i> <input disabled class="form-control name" type="text" value="">
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">学历: </i>
                                        <select name="education" class="form-control education" disabled>
                                            <option value="1">高中</option>
                                            <option value="2">大专</option>
                                            <option value="3">大学</option>
                                            <option value="4">研究生</option>
                                            <option value="5">中专学校</option>
                                            <option value="6">技术学校</option>
                                            <option value="7">初中</option>
                                            <option value="8">小学</option>
                                            <option value="9">文盲或半文盲</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">银行卡: </i> <input disabled class="form-control bankAccount" type="text"
                                                    value=""> <span
                                            class="badge">*</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">身份证号: </i> <input disabled class="form-control identity" type="text"
                                                     value=""> <span class="badge">*</span></li>
                                    <li><i class="desc-name">婚姻状况: </i>
                                        <select disabled name="marrStatus" class="form-control marrStatus">
                                            <option value="1">已婚</option>
                                            <option value="2">未婚</option>
                                            <option value="3">离异</option>
                                            <option value="4">丧偶</option>
                                            <option value="5">再婚</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">手机号码: </i> <input disabled class="form-control phone" type="text" value=""
                                    > <span class="badge">*</span></li>

                                </ul>
                                <ul>
                                    <li><i class="desc-name">性别: </i>
                                        <select disabled name="sex" class="form-control sex">
                                            <option value="1">男</option>
                                            <option value="0">女</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">年龄: </i> <input disabled class="form-control age" type="text" value="">
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">居住性质: </i>
                                        <select disabled name="estateType" class="form-control estateType">
                                            <option value="1">一次性购买</option>
                                            <option value="2">按揭(月还款)</option>
                                            <option value="3">租赁(月租金)</option>
                                            <option value="4">与父母同住</option>
                                            <option value="5">自建</option>
                                            <option value="6">其他</option>
                                        </select>
                                        <span class="badge">*</span>
                                    </li>
                                </ul>
                                <!--<ul>-->
                                    <!---->
                                <!--</ul>-->

                                <ul>
                                    <li><i class="desc-name">户籍: </i> <input data-toggle="tooltip" data-placement="right" disabled class="form-control householdReg" type="text"
                                                                             value=""
                                    ></li>
                                    <li>
                                        <i class="desc-name">是否异常: </i>
                                        <select id="baseInfoCheckAbnormal" name="" class="form-control">
                                            <option value="false">否</option>
                                            <option value="true">是</option>
                                        </select>
                                    </li>
                                    <li>
                                        <i class="desc-name">备注: </i>
                                        <textarea id="baseInfoCheckRemark" class="form-control"></textarea>
                                    </li>
                                </ul>

                            </div>
                            <div class="home-pos">
                                <i class="desc-name">住址: </i>
                                <input disabled class="special-length form-control address" type="text"
                                       value=""> <span
                                    class="badge">*</span>
                            </div>
                            <ul class="idProve">
                                <!--<li>-->
                                    <!--<p>身份证正反面</p>-->
                                    <!--<img data-magnify="gallery" src="static/img/01.jpg" data-src="static/img/01.jpg" alt="" id="demo">-->
                                <!--</li>-->
                            </ul>
                        </div>
                    </div>
                    <!--工作单位-->
                    <div class="panel panel-info work-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">工作单位</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div class="not-work-pos clearfix">
                                <ul>
                                    <li><i class="desc-name">单位性质: </i>
                                        <select disabled name="orgNature" class="form-control orgNature">
                                            <option value="">无</option>
                                            <option value="1">行政机关</option>
                                            <option value="2">国有企业</option>
                                            <option value="3">事业单位</option>
                                            <option value="4">三资企业</option>
                                            <option value="5">私营企业</option>
                                            <option value="6">个体户</option>
                                            <option value="7">其他</option>
                                        </select>
                                        </li>
                                    <li><i class="desc-name">单位名称: </i> <input data-toggle="tooltip" data-placement="right" disabled class="form-control orgName" type="text" value=""
                                    ></li>
                                    <li><i class="desc-name">单位电话: </i> <input disabled class="form-control orgContact" type="text"
                                                     value=""
                                    >
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">职位: </i> <input disabled class="form-control position" type="text"
                                                   value=""></li>
                                    <li>
                                        <i class="desc-name">月收入: </i> 
                                        <select disabled name="monthIncome" class="form-control monthIncome">
                                            <option value="">无</option>
                                            <option value="1">3000及以下</option>
                                            <option value="2">3001~5000</option>
                                            <option value="3">5001~7000</option>
                                            <option value="4">7001~10000</option>
                                            <option value="5">10001~15000</option>
                                            <option value="6">15000以上</option>
                                        </select>
                                        <span class="badge">*</span>
                                    </li>
                                    <li>
                                        <i class="desc-name">最近工作年限: </i>
                                        <select disabled name="workYears" class="form-control workYears">
                                            <option value="">无</option>
                                            <option value="1">1年内</option>
                                            <option value="2">1-3年</option>
                                            <option value="3">3-5年</option>
                                            <option value="4">5年以上</option>
                                        </select>

                                    </li>
                                </ul>
                                <ul>
                                    <li>
                                        <i class="desc-name">是否异常: </i>
                                        <select id="workInfoCheckAbnormal" name="" class="form-control">
                                            <option value="false">否</option>
                                            <option value="true">是</option>
                                        </select>
                                    </li>
                                    <li>
                                        <i class="desc-name">备注: </i>
                                        <textarea id="workInfoCheckRemark" class="form-control"></textarea>
                                    </li>
                                </ul>
                            </div>
                            <div class="work-pos">
                                <i class="desc-name">单位地址: </i>
                                <!--<select name="work_province" id="work_province" class="form-control">-->
                                <!--<option value="0" selected>四川省</option>-->
                                <!--<option value="1">江西省</option>-->
                                <!--</select>-->
                                <!--<select name="work_city" id="work_city" class="form-control">-->
                                <!--<option value="0" selected>成都市</option>-->
                                <!--<option value="1">绵阳市</option>-->
                                <!--</select>-->
                                <!--<select name="work_area" id="work_area" class="form-control">-->
                                <!--<option value="0" selected>锦江区</option>-->
                                <!--<option value="1">高新区</option>-->
                                <!--</select>-->
                                <input disabled class="special-length form-control orgAddress" type="text"
                                       value="">
                            </div>
                        </div>
                    </div>
                    <!--车辆信息-->
                    <div class="panel panel-info car-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">车辆信息</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul>
                                <li><i class="desc-name">品牌: </i> <input disabled class="form-control brand" type="text" value=""></li>
                                <li>
                                    <i class="desc-name">价格: </i>
                                    <input disabled class="form-control buyPrice" type="text" value="">
                                </li>

                            </ul>
                            <ul>
                                <li><i class="desc-name">型号: </i> <input disabled class="form-control model" type="text" value=""></li>
                                <li><i class="desc-name">首付款: </i> <input disabled class="form-control firstPayment" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">车辆保单号: </i> <input disabled class="form-control insuranceNo" type="text" value=""></li>
                                <li><i class="desc-name">车架号: </i> <input disabled class="form-control vin" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name" style="width: 125px;">上一承租人项目编号: </i> <input disabled class="form-control lastProjectNo" type="text" value=""></li>
                                <li><i class="desc-name" style="width: 125px;">第一个承租人项目编号: </i> <input disabled class="form-control firstProjectNo" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">车牌号: </i> <input disabled class="form-control carNumber" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li>
                                    <i class="desc-name">是否异常: </i>
                                    <select id="carInfoCheckAbnormal" name="" class="form-control">
                                        <option value="false">否</option>
                                        <option value="true">是</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="desc-name">备注: </i>
                                    <textarea id="carInfoCheckRemark" class="form-control"></textarea>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!--联系人-->
                    <div class="panel panel-info contact-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">联系人</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul class="relative-name">

                            </ul>
                            <ul class="relative-mobile">

                            </ul>
                            <ul>
                                <li>
                                    <i class="desc-name">是否异常: </i>
                                    <select id="relativesInfoCheckAbnormal" name="" class="form-control">
                                        <option value="false">否</option>
                                        <option value="true">是</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="desc-name">备注: </i>
                                    <textarea id="relativesInfoCheckRemark" class="form-control"></textarea>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <!--上传资产佐证-->
                    <div class="panel panel-info contact-info asset-prove">
                        <div class="panel-heading">
                            <h3 class="panel-title">上传资料(选填)</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul class="assetProve">
                                <!--<li>-->
                                <!--<p>房产</p>-->
                                <!--<img data-magnify="gallery" src="static/img/02.jpg" data-src="static/img/01.jpg" alt="" id="demo">-->
                                <!--<img data-magnify="gallery" src="static/img/02.jpg" data-src="static/img/01.jpg" alt="" id="demo">-->
                                <!--</li>-->
                            </ul>
                        </div>
                    </div>
                    <!--上传其他资料-->
                    <div class="panel panel-info contact-info other-prove">
                        <div class="panel-heading">
                            <h3 class="panel-title">上传其他资料(选填)</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul class="otherProve">

                            </ul>
                        </div>
                    </div>
                    <div class="panel people-check-control-info select-flag">
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-7">
                                    <button class="btn btn-success" id="people_check_btn_checked">已核对</button>
                                    <div class="people-check-refuse row block">
                                        <button class="btn btn-danger" id="people_check_btn_refuse">拒绝</button>
                                        <div class="people-check-refuse mlr15">
                                            拒绝理由:
                                            <select name="refuse" id="people_check_refuse" class="form-control">

                                            </select>
                                        </div>
                                        <div class="people-check-refuse">
                                            拒件原因:
                                            <input type="text" class="form-control refuse-reason"
                                                   id="people_check_refuse_reason">
                                            <div class="people-check-refuseTree">

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-5">
                                    <div class="row">
                                        <div class="col-sm-1">
                                            <button type="button" class="btn btn-primary"
                                                    id="people_check_btn_reject">驳回
                                            </button>
                                        </div>
                                        <div class="col-sm-10">
                                                    <textarea id="people_check_btn_reject_reason" class="form-control"
                                                              rows="4"
                                                              placeholder="驳回理由"></textarea>
                                            驳回到: <select class="form-control" id="people_check_btn_reject_to">
                                            <option value="0" selected>增补资料</option>
                                            <option value="5">初审</option>
                                            <option value="6">复审</option>
                                            <option value="7">终审</option>
                                        </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="fore">

                    <!--电审内容-->
                    <div class="panel panel-info electric-trial">
                        <div class="panel-heading">
                            <h3 class="panel-title">电审内容</h3>
                        </div>
                        <div class="panel-body clearfix" id="auditContent">

                        </div>
                    </div>
                    <!--电话核查-->
                    <div class="panel panel-info phone-examine">
                        <div class="panel-heading">
                            <h3 class="panel-title">电话核查</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <table class="table credit-table">
                                <thead>
                                <tr>
                                    <th>姓名</th>
                                    <th>电话</th>
                                    <th>关系</th>
                                    <th>备注</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody id="teleAuditInfoTbody">

                                </tbody>
                            </table>
                            <button class="btn btn-success" id="add_credit_table">新增</button>
                        </div>
                    </div>
                    <!--初审批复-->
                    <div class="first-reply">
                        <div class="panel panel-info first-trial-replay">
                            <span class="icon-font-checked"></span>
                            <div class="panel-heading clearfix">
                                <h3 class="panel-title pull-left">初审批复</h3>
                                <p class="pull-right" style="margin: 0;" id="firstReplyTime">
                                    审批人员: <span></span>&nbsp;&nbsp;&nbsp;&nbsp;<span></span>
                                </p>
                            </div>
                            <div class="panel-body clearfix">
                                <ul>
                                    <li>
                                        <i class="desc-reply-name">风险等级:</i>
                                        <select id="riskGrade" name="" class="form-control">
                                            <option value="一级">一级</option>
                                            <option value="二级">二级</option>
                                            <option value="三级">三级</option>
                                        </select>
                                    </li>
                                    <li><i class="desc-reply-name">贷款金额:</i> <input id="auditAmount" type="text" class="form-control" value="">
                                        元
                                    </li>
                                    <li><i class="desc-reply-name">审批意见:</i>
                                        <textarea id="firstRemark" class="form-control input-box"></textarea>
                                    </li>
                                    <li><i class="desc-reply-name">借款用途:</i>
                                        <textarea id="enterpriseCase" class="form-control input-box"></textarea>
                                        <!--<input id="enterpriseCase" type="text" class="form-control" value="">-->
                                    </li>
                                    <li><i class="desc-reply-name">项目概况:</i>
                                        <textarea id="projectContent" class="form-control input-box"></textarea>
                                    </li>
                                    <li><i class="desc-reply-name">还款来源:</i>
                                        <textarea id="fundsUse" class="form-control input-box"></textarea>
                                    </li>
                                    <li><i class="desc-reply-name">担保方式:</i>
                                        <textarea id="geAgcyAdvice" class="form-control input-box"></textarea>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel credit-trial-first-control-info select-flag">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-7">
                                        <button class="btn btn-success" id="credit_trial_first_btn_checked">通过
                                        </button>
                                        <div class="credit-trial-first-refuse row block">
                                            <button class="btn btn-danger"
                                                    id="credit_trial_first_btn_refuse">拒绝
                                            </button>
                                            <div class="credit-trial-first-refuse mlr15">
                                                拒绝理由:
                                                <select name="refuse" id="credit_trial_first_refuse"
                                                        class="form-control">

                                                </select>
                                            </div>
                                            <div class="credit-trial-first-refuse">
                                                拒件原因:
                                                <input type="text" class="form-control refuse-reason"
                                                       id="credit_trial_first_refuse_reason">
                                                <div class="credit-trial-first-refuseTree">

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="row">
                                            <div class="col-sm-1">
                                                <button type="button" class="btn btn-primary"
                                                        id="credit_trial_first_btn_reject">驳回
                                                </button>
                                            </div>
                                            <div class="col-sm-10">
                                                    <textarea id="credit_trial_first_btn_reject_reason"
                                                              class="form-control" rows="4"
                                                              placeholder="驳回理由"></textarea>
                                                驳回到: <select class="form-control" id="credit_trial_first_btn_reject_to">
                                                <option value="0" selected>增补资料</option>
                                                <option value="5">初审</option>
                                                <option value="6">复审</option>
                                                <option value="7">终审</option>
                                            </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--复审批复-->
                    <div class="again-reply">
                        <div class="panel panel-info again-trial-replay">
                            <span class="icon-font-checked"></span>
                            <div class="panel-heading clearfix">
                                <h3 class="panel-title pull-left">复审批复</h3>
                                <p class="pull-right" style="margin: 0;" id="againReplyTime">
                                    审批人员: &nbsp;<span></span>&nbsp;&nbsp;&nbsp;&nbsp;<span></span>
                                </p>
                            </div>
                            <div class="panel-body clearfix">
                                <ul>
                                    <li><i class="desc-reply-name">审批意见:</i>
                                        <textarea id="againRemark" class="form-control input-box"></textarea>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel credit-trial-again-control-info select-flag">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-7">
                                        <button class="btn btn-success" id="credit_trial_again_btn_checked">通过
                                        </button>
                                        <div class="credit-trial-again-refuse row block">
                                            <button class="btn btn-danger"
                                                    id="credit_trial_again_btn_refuse">拒绝
                                            </button>
                                            <div class="credit-trial-again-refuse mlr15">
                                                拒绝理由:
                                                <select name="refuse" id="credit_trial_again_refuse"
                                                        class="form-control">

                                                </select>
                                            </div>
                                            <div class="credit-trial-again-refuse">
                                                拒件原因:
                                                <input type="text" class="form-control refuse-reason"
                                                       id="credit_trial_again_refuse_reason">
                                                <div class="credit-trial-again-refuseTree">

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="row">
                                            <div class="col-sm-1">
                                                <button type="button" class="btn btn-primary"
                                                        id="credit_trial_again_btn_reject">驳回
                                                </button>
                                            </div>
                                            <div class="col-sm-10">
                                                    <textarea id="credit_trial_again_btn_reject_reason"
                                                              class="form-control" rows="4"
                                                              placeholder="驳回理由"></textarea>
                                                驳回到: <select class="form-control" id="credit_trial_again_btn_reject_to">
                                                <option value="0" selected>增补资料</option>
                                                <option value="5">初审</option>
                                                <option value="6">复审</option>
                                                <option value="7">终审</option>
                                            </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--终审批复-->
                    <div class="final-reply">
                        <div class="panel panel-info final-trial-replay">
                            <span class="icon-font-checked"></span>
                            <div class="panel-heading clearfix">
                                <h3 class="panel-title pull-left">终审批复</h3>
                                <p class="pull-right" style="margin: 0;" id="finalReplyTime">
                                    审批人员: <span></span>&nbsp;&nbsp;&nbsp;&nbsp;<span></span>
                                </p>
                            </div>
                            <div class="panel-body clearfix">
                                <ul>
                                    <li><i class="desc-reply-name">审批意见:</i>
                                        <textarea id="finalRemark" class="form-control input-box"></textarea>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="panel credit-trial-final-control-info select-flag">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-7">
                                        <button class="btn btn-success" id="credit_trial_final_btn_checked">通过
                                        </button>
                                        <div class="credit-trial-final-refuse row block">
                                            <button class="btn btn-danger"
                                                    id="credit_trial_final_btn_refuse">拒绝
                                            </button>
                                            <div class="credit-trial-final-refuse mlr15">
                                                拒绝理由:
                                                <select name="refuse" id="credit_trial_final_refuse"
                                                        class="form-control">

                                                </select>
                                            </div>
                                            <div class="credit-trial-final-refuse">
                                                拒件原因:
                                                <input type="text" class="form-control refuse-reason"
                                                       id="credit_trial_final_refuse_reason">
                                                <div class="credit-trial-final-refuseTree">

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-5">
                                        <div class="row">
                                            <div class="col-sm-1">
                                                <button type="button" class="btn btn-primary"
                                                        id="credit_trial_final_btn_reject">驳回
                                                </button>
                                            </div>
                                            <div class="col-sm-10">
                                                    <textarea id="credit_trial_final_btn_reject_reason"
                                                              class="form-control" rows="4"
                                                              placeholder="驳回理由"></textarea>
                                                驳回到: <select class="form-control" id="credit_trial_final_btn_reject_to">
                                                <option value="0" selected>增补资料</option>
                                                <option value="5">初审</option>
                                                <option value="6">复审</option>
                                                <option value="7">终审</option>
                                            </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="five">
                    <div class="panel panel-info order-reply">
                        <button class="btn btn-success" id="printer_table">打印</button>
                        <div class="panel-heading">
                            <h3 class="panel-title">审批表预览</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <table class="order-reply-table" id="order_reply_table">

                            </table>
                        </div>
                    </div>
                </div>
                <div class="tab-pane" id="six">
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
                                <tbody>
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
<!--删除确认模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="myModalConfirm" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body text-center">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-confirm" data-dismiss="modal">取消</button>
                <button id="confirmDelPhone" type="button" class="btn btn-primary">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!--电话核查模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="phoneModal" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body text-center">
                <ul>
                    <li>
                        姓名: &nbsp;&nbsp;<input type="text" class="form-control">
                    </li>
                    <li>
                        电话: &nbsp;&nbsp;<input type="text" class="form-control">
                    </li>
                    <li>
                        关系: &nbsp;&nbsp;<input type="text" class="form-control">
                    </li>
                    <li>
                        备注: &nbsp;&nbsp;<textarea rows="8" style="resize: none" class="form-control"></textarea>
                    </li>
                </ul>
            </div>
            <div class="modal-footer">
                <span>姓名、电话、关系为必填</span>
                <button type="button" class="btn btn-confirm" data-dismiss="modal">取消</button>
                <button id="savePhoneExamine" type="button" class="btn btn-primary">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!--电话核查编辑模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="phoneModalEdit" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body text-center">
                <ul>
                    <li>
                        姓名: &nbsp;&nbsp;<input type="text" class="form-control" id="phoneName">
                    </li>
                    <li>
                        电话: &nbsp;&nbsp;<input type="text" class="form-control" id="phoneNumber">
                    </li>
                    <li>
                        关系: &nbsp;&nbsp;<input type="text" class="form-control" id="phoneRelation">
                    </li>
                    <li>
                        备注: &nbsp;&nbsp;<textarea rows="8" style="resize: none" class="form-control" id="phoneRemark"></textarea>
                    </li>
                </ul>
            </div>
            <div class="modal-footer">
                <span>姓名、电话、关系为必填</span>
                <button type="button" class="btn btn-confirm" data-dismiss="modal">取消</button>
                <button id="savePhoneExamineEdit" type="button" class="btn btn-primary">保存</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script src="<%=basePath%>static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=basePath%>static/js/jquery.jqprint-0.3.js"></script>
<script src="<%=basePath%>static/js/refuseData.js"></script>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script src="<%=basePath%>static/js/firstTrial.js"></script>
<script type="text/html" id="orderReply">
    <caption>{{auditInfo.productName}}审批表</caption>
    <!--家庭情况-->
    <thead>
    <tr>
        <th colspan="8">家庭情况</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td class="bold">客户姓名</td>
        <td>{{familyInfo.name}}</td>
        <td class="bold">性别</td>
        <td id="tpl_sex"></td>
        <td class="bold">身份证号</td>
        <td colspan="3">{{familyInfo.identity}}</td>
    </tr>
    <tr>
        <td class="bold">年龄</td>
        <td colspan="2">{{familyInfo.age}}</td>
        <td class="bold">婚姻</td>
        <td colspan="4" id="tpl_marrStatus"></td>
    </tr>
    <tr>
        <td class="bold">现居住地址</td>
        <td colspan="7">{{familyInfo.address}}</td>
    </tr>
    <tr>
        <td class="bold">自有/租住</td>
        <td colspan="7" id="tpl_estateType"></td>
    </tr>
    </tbody>
    <!--征信情况-->
    <thead>
    <tr>
        <th colspan="8">征信情况</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td class="bold">近3个月机构查询次数</td>
        <td colspan="2">{{userCredit.agentCount}}</td>
        <td class="bold">近3个月个人查询次数</td>
        <td colspan="4">{{userCredit.personCount}}</td>
    </tr>
    <tr>
        <td class="bold">近6个月逾期次数</td>
        <td colspan="2">{{userCredit.overdueMonth6}}</td>
        <td class="bold">近12个月逾期次数</td>
        <td colspan="4">{{userCredit.overdueMonth12}}</td>
    </tr>
    <tr>
        <td class="bold">信用卡近6个月平均使用额度</td>
        <td colspan="2">{{userCredit.creditCardAmt}}</td>
        <td class="bold">抵押负债余额</td>
        <td colspan="4">{{userCredit.mortageBalance}}</td>
    </tr>
    <tr>
        <td class="bold">信用负债余额</td>
        <td colspan="2">{{userCredit.creditBalance}}</td>
        <td class="bold">总月均负债</td>
        <td colspan="4">{{userCredit.balanceAvr}}</td>
    </tr>
    <tr>
        <td class="bold">同盾网</td>
        <td colspan="2" id="tpl_tongdun">{{tdScore}}</td>
        <td class="bold">执行网</td>
        <td colspan="4" id="tpl_zhixing">无</td>
    </tr>
    </tbody>
    <!--电话核查-->
    <thead>
    <tr>
        <th colspan="8">电话核查</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td class="bold">姓名</td>
        <td class="bold">电话</td>
        <td class="bold">关系</td>
        <td colspan="5" class="bold">备注</td>
    </tr>
    {{each teleAuditInfo}}
    <tr>
        <td>{{$value.contactName}}</td>
        <td>{{$value.contactPhone}}</td>
        <td>{{$value.relation}}</td>
        <td colspan="5">{{$value.remark}}</td>
    </tr>
    {{/each}}
    </tbody>
    <!--信审-->
    <thead>
    <tr>
        <th colspan="8">信审</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td class="bold">合作渠道</td>
        <td colspan="3">{{auditInfo.channelName}}</td>
        <td class="bold">所购商品</td>
        <td colspan="3">{{auditInfo.usageDesc}}</td>
    </tr>
    <tr>
        <td class="bold">支付方式</td>
        <td>{{auditInfo.repayWay}}</td>
        <td class="bold">金额</td>
        <td>{{auditInfo.auditAmount}}</td>
        <td class="bold">期限</td>
        <td>{{auditInfo.auditPeriod}}</td>
        <td class="bold">费率</td>
        <td>{{auditInfo.auditRating}}</td>
    </tr>
    <tr id="tableFirstAudit">
        <td colspan="2" class="bold">初审</td>
        <td colspan="6"></td>
    </tr>
    <tr id="tableAgainAudit">
        <td colspan="2" class="bold">复核人</td>
        <td colspan="6"></td>
    </tr>
    <tr id="tableFinalAudit">
        <td colspan="2" class="bold">终审</td>
        <td colspan="6"></td>
    </tr>
    <tr id="tableRemark">
        <td colspan="2" class="bold">审批意见</td>
        <td colspan="6">{{auditInfo.auditRemarks}}</td>
    </tr>
    <tr>
        <td colspan="2" class="bold">借款用途</td>
        <td colspan="6">{{auditInfo.enterpriseCase}}</td>
    </tr>
    <tr>
        <td colspan="2" class="bold">项目概况</td>
        <td colspan="6">{{auditInfo.projectContent}}</td>
    </tr>
    <tr>
        <td colspan="2" class="bold">还款来源</td>
        <td colspan="6">{{auditInfo.fundsUse}}</td>
    </tr>
    <tr>
        <td colspan="2" class="bold">担保方式</td>
        <td colspan="6">{{auditInfo.geAgcyAdvice}}</td>
    </tr>
    </tbody>
</script>
<script>
    $(function () {
        firstTrial.init({
            orderId: '<%=orderId%>',
            processId: '${processId}', // 贷中状态
            afterLoan : '${afterLoan}', // 贷后,
            totalOrder : '${totalOrder}', // 全部订单
            // 搜索条件保存 便于返回之前状态
            keyword: '${keyword}',
            orderStatus: '${orderStatus}',
            period: '${period}',
            createDate: '${createDate}',
        },'<%=basePath%>');
    })
</script>

</body>
</html>