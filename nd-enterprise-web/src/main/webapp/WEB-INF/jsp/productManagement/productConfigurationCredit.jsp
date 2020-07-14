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
<!--开关-->
<link href="<%=basePath%>static/plugins/honeySwitch/honeySwitch.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="<%=basePath%>static/css/product-configuration.css">
<div class="container-fluid">
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <jsp:include page="./steps.jsp">
                    <jsp:param value="${productTempId}" name="productTempId"/>
                </jsp:include>
                <div class="configuration">
                    <!--基本配置-->
                    <div class="panel panel-info base-configuration">
                        <div class="panel-heading">
                            <h3 class="panel-title">基本配置</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <li>
                                    <i class="con-name">产品名称 :</i>
                                    <input type="text" class="form-control" id="firstProductName"
                                           placeholder="请不要超过8个字符" maxlength="8">
                                    <div id="tagBox">

                                    </div>
                                    <button class="btn btn-mine btn-product" id="addProductTags">+产品标签</button>
                                </li>
                                <li class="eg">
                                    <span>示例: xxx</span>xxx代表产品名
                                </li>
                                <li style="position: relative;" id="isRecommand">
                                    <i class="con-name">推荐产品 :</i>
                                    <span themeColor="#008bff" class="switch-off"></span>
                                </li>
                                <li>
                                    <i class="con-name">产品资金端编号 :</i>
                                    <input type="text" class="form-control" id="productCode"
                                           placeholder="请不要超过50个字符">
                                    <span class="red-tag">注：请录入资金端生成的项目编号</span>
                                </li>
                                <li>
                                    <i class="con-name">生成项目编码 :</i>
                                    <input type="text" class="form-control" id="productCodeZj"
                                           placeholder="请不要超过50个字符">
                                    <span class="red-tag">例：普惠引流贷(JD-PHYLD)</span>
                                </li>
                                <li>
                                    <i class="con-name">产品场景介绍 :</i>
                                    <textarea class="form-control" rows="6" id="firstProScene"
                                              placeholder="请输入不要超过200个字符" maxlength="200"></textarea>
                                </li>
                                <li>
                                    <i class="con-name">借款主体 :</i>
                                    <select name="" id="borrower" class="form-control">
                                        <option value="">--请选择--</option>
                                        <option value="1">个人</option>
                                        <option value="2">机构</option>
                                    </select>
                                </li>
                                <li id="monRateInterva">
                                    <i class="con-name">月费率区间 :</i>
                                    <input type="number" class="form-control" id="monRateInterval01"
                                           placeholder="请不要超过50个字符">
                                    ~
                                    <input type="number" class="form-control" id="monRateInterval02"
                                           placeholder="请不要超过50个字符">
                                    <span class="red-tag">注：系统自动添加%单位</span>
                                </li>
                                <li id="borrowInterval">
                                    <i class="con-name">借款金额区间 :</i>
                                    <input type="number" class="form-control" id="borrowInterval01"
                                           placeholder="请不要超过50个字符">
                                    ~
                                    <input type="number" class="form-control" id="borrowInterval02"
                                           placeholder="请不要超过50个字符">
                                    <span class="red-tag">注：借款主体为“个人”，为 0元 < 借款金额 <= 200,000元；借款主体为“机构”，为 0元 < 借款金额 <= 1,000,000元</span>
                                </li>
                                <li class="borrow">
                                    <i class="con-name">借款期限 :</i>
                                    <div id="borrowBox">
                                        <label for="allSelect"><input type="checkbox" name="borrowDeatline"
                                                                      id="allSelect">全选</label>
                                        <label for="6period"><input type="checkbox" name="borrowDeatline"
                                                                    id="6period"
                                                                    value="62e89f2ff10b4314bce8c8a96143cfd4">6期</label>
                                        <label for="12period"><input type="checkbox" name="borrowDeatline"
                                                                     id="12period"
                                                                     value="f7cb0e9c98584410a4b6be60b4871618">12期</label>
                                        <label for="18period"><input type="checkbox" name="borrowDeatline"
                                                                     id="18period"
                                                                     value="aeb8ca77105849ccb5c7c09fcddac48e">18期</label>
                                        <label for="24period"><input type="checkbox" name="borrowDeatline"
                                                                     id="24period"
                                                                     value="3e5a0df164b440858117c4961ca21b95">24期</label>
                                        <label for="36period"><input type="checkbox" name="borrowDeatline"
                                                                     id="36period"
                                                                     value="2946f3588aae493ea9b2bbf3143e1156">36期</label>
                                        <div id="borrowBoxInner">

                                        </div>
                                    </div>
                                    <span style="margin-left: 15px;" class="blue-tag"
                                          id="morePeriod">更多期数</span>
                                </li>
                                
                                <li>
                                    <i class="con-name">借款类型 </i>
                                    <select name="" id="borrowTypeForReport" class="form-control">
                                    </select>
                                    <span class="red-tag">注：用于资产上报，不参与实际业务</span>
                                </li>
                                <li>
                                    <i class="con-name">借款用途 </i>
                                    <select name="" id="borrowUseForReport" class="form-control">
                                    </select>
                                    <span class="red-tag">注：用于资产上报，不参与实际业务</span>
                                </li>
                                
                                <li class="borrow" id="borrowType">
                                    <i class="con-name">借款类型 :</i>
                                    <div id="borrowTypeBox"></div>
                                    <!--<label for="borrowType01"><input type="checkbox" name="borrowType" id="borrowType01" value="信用类">信用类</label>-->
                                </li>
                                <li class="borrow">
                                    <i class="con-name">担保方式 :</i>
                                    <label for="ensureWay01">
                                        <input type="radio" name="ensureWay" id="ensureWay01" value="1">渠道担保
                                        <input type="text" class="form-control ensure-way-input"
                                               id="ensureWay01Name">
                                    </label>
                                    <label for="ensureWay02"><input type="radio" name="ensureWay"
                                                                    id="ensureWay02" value="2">第三方担保
                                        <input type="text" class="form-control ensure-way-input"
                                               id="ensureWay02Name">
                                    </label>
                                    <label for="ensureWay03"><input type="radio" name="ensureWay"
                                                                    id="ensureWay03" value="0">无</label>
                                </li>
                                <li class="borrow" id="borrowUse">
                                    <i class="con-name">借款用途 :</i>
                                    <div id="borrowUseBox"></div>
                                    <!--<label for="borrowUse01"><input type="checkbox" name="borrowUse" id="borrowUse01" value="消费">消费</label>-->
                                </li>
                                
                                <li>
                                    <i class="con-name">风险报告有效期 :</i>
                                    <input type="number" class="form-control" id="tdReportValidDate" value="30"
                                           placeholder="单位天，默认30">
                                </li>
                                
                                <li class="credit-area-li clearfix" id="creditArea">
                                    <i class="con-name">授信区域 :</i>
                                    <div class="area-container">
                                        <div class="credit-area">
                                            <select name="province" id="province" class="form-control">
                                                <!--<option proValue="-1" value="-1">-请选择省份-</option>-->
                                                <!--<option proValue="0" value="0">全国</option>-->
                                            </select>
                                            <select name="city" id="city" class="form-control">
                                                <!--<option value="0">-请选择城市-</option>-->
                                            </select>

                                            <button class="btn btn-mine add-area" id="addAreaBtn">添加</button>
                                            <input type="checkbox" id="allCountry" name="allCountry">全国
                                            <div id="showCityBox"><input type="checkbox" id="showCity" name="showCity">精确到市
                                            </div>
                                        </div>
                                        <div class="display-area">
                                            <!--<span>111 <i class="glyphicon glyphicon-remove remove-area"></i></span>-->
                                        </div>
                                    </div>
                                </li>
                                <li>
                                    <button id="firToSec" class="btn btn-mine">下一步</button>
                                </li>


                            </ul>
                        </div>
                    </div>
                    <!--渠道配置-->
                    <div class="panel panel-info channel-configuration">
                        <div class="panel-heading">
                            <h3 class="panel-title">渠道配置</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <li id="introType">
                                    <i class="con-name">进件类型: </i>
                                    <s><input id="introType01" type="checkbox" name="introType"
                                              value="1">渠道进件</s>
                                    <s><input id="introType02" type="checkbox" name="introType"
                                              value="2">引流进件</s>
                                    <s><input id="introType03" type="checkbox" name="introType"
                                              value="3">自主进件</s>
                                </li>
                            </ul>
                            <ul class="introType" id="introType01Box">
                                <li>
                                    <i class="con-name">渠道进件:</i>
                                    <div>
                                        <div class="operate">
                                            <div>
                                                <span class="channel-name" id="introType01Name">请添加产品合作渠道</span>
                                                <button class="btn btn-mine" id="chooseChannel01">选择渠道</button>
                                                <button class="btn btn-default" id="clear01">清空</button>
                                            </div>
                                            <div id="type01feeType" class="clearfix feeType">
                                                <i class="con-name pull-left">趸收手续费:</i>
                                                <div>
                                                    <p>
                                                        <span class="title">固定金额</span>
                                                        <input fee-type="1" type="number"
                                                               class="form-control text-right">元
                                                    </p>
                                                    <p>
                                                        <span class="title">固定费率</span>
                                                        <input fee-type="2" type="number"
                                                               class="form-control text-right">%
                                                        <span class="red-tag">注：借款本金比率的x%</span>
                                                    </p>
                                                </div>
                                            </div>
                                            <div id="type01bondType" class="clearfix bondType">
                                                <i class="con-name pull-left">期收手续费:</i>
                                                <div>
                                                    <p>
                                                        <span class="title">固定金额</span>
                                                        <input bond-type="1" type="number"
                                                               class="form-control text-right">元
                                                    </p>
                                                    <p>
                                                        <span class="title">固定费率</span>
                                                        <input bond-type="2" type="number"
                                                               class="form-control text-right">%
                                                        <span class="red-tag">注：借款本金比率的x%</span>
                                                    </p>
                                                </div>
                                            </div>
                                            <button class="btn btn-mine" id="addIntroType01">保存</button>
                                        </div>
                                        <div class="introTypeContent">
                                            <div class="oContent" id="introContent01">
                                                <!--<div class="item">-->
                                                <!--<div class="addedChannelTitle">-->
                                                <!--<span class="channel-name add-channel-name">请添加产品合作渠道</span>-->
                                                <!--<button class="btn btn-default delType01">删除</button>-->
                                                <!--</div>-->
                                                <!--<div class="clearfix feeType">-->
                                                <!--<i class="con-name pull-left">手续费:</i>-->
                                                <!--<div>-->
                                                <!--<p>-->
                                                <!--<span class="title">固定费率</span>-->
                                                <!--<input disabled fee-type="2" type="text" class="form-control text-right">%-->
                                                <!--</p>-->
                                                <!--</div>-->
                                                <!--</div>-->
                                                <!--<div class="clearfix bondType">-->
                                                <!--<i class="con-name pull-left">保证金:</i>-->
                                                <!--<div>-->
                                                <!--<p>-->
                                                <!--<span class="title">非固定费率</span>-->
                                                <!--<input disabled bond-type="3" type="text" class="form-control text-right">-->
                                                <!--</p>-->
                                                <!--</div>-->
                                                <!--</div>-->
                                                <!--</div>-->
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            <ul class="introType" id="introType02Box">
                                <li>
                                    <i class="con-name">引流进件:</i>
                                    <div>
                                        <div class="operate">
                                            <div>
                                                <span class="channel-name" id="introType02Name">请添加产品合作渠道</span>
                                                <button class="btn btn-mine" id="chooseChannel02">选择渠道</button>
                                                <button class="btn btn-default" id="clear02">清空</button>
                                            </div>
                                            <div id="type02feeType" class="clearfix feeType">
                                                <i class="con-name pull-left">趸收手续费:</i>
                                                <div>
                                                    <p>
                                                        <span class="title">固定金额</span>
                                                        <input fee-type="1" type="text" class="form-control text-right">元
                                                    </p>
                                                    <p>
                                                        <span class="title">固定费率</span>
                                                        <input fee-type="2" type="text" class="form-control text-right">%
                                                        <span class="red-tag">注：借款本金比率的x%</span>
                                                    </p>
                                                </div>
                                            </div>
                                            <div id="type02bondType" class="clearfix bondType">
                                                <i class="con-name pull-left">期收手续费:</i>
                                                <div>
                                                    <p>
                                                        <span class="title">固定金额</span>
                                                        <input bond-type="1" type="text"
                                                               class="form-control text-right">元
                                                    </p>
                                                    <p>
                                                        <span class="title">固定费率</span>
                                                        <input bond-type="2" type="text"
                                                               class="form-control text-right">%
                                                        <span class="red-tag">注：借款本金比率的x%</span>
                                                    </p>
                                                </div>
                                            </div>
                                            <button class="btn btn-mine" id="addIntroType02">保存</button>
                                        </div>
                                        <div class="introTypeContent">
                                            <div class="oContent" id="introContent02">
                                                <!--<div class="item">-->
                                                <!--<div class="addedChannelTitle">-->
                                                <!--<span class="channel-name add-channel-name">请添加产品合作渠道</span>-->
                                                <!--<button class="btn btn-default delType02">删除</button>-->
                                                <!--</div>-->
                                                <!--<div class="clearfix feeType">-->
                                                <!--<i class="con-name pull-left">手续费:</i>-->
                                                <!--<div>-->
                                                <!--<p>-->
                                                <!--<span class="title">固定费率</span>-->
                                                <!--<input disabled fee-type="2" type="text" class="form-control text-right">%-->
                                                <!--</p>-->
                                                <!--</div>-->
                                                <!--</div>-->
                                                <!--<div class="clearfix bondType">-->
                                                <!--<i class="con-name pull-left">保证金:</i>-->
                                                <!--<div>-->
                                                <!--<p>-->
                                                <!--<span class="title">非固定费率</span>-->
                                                <!--<input disabled bond-type="3" type="text" class="form-control text-right">-->
                                                <!--</p>-->
                                                <!--</div>-->
                                                <!--</div>-->
                                                <!--</div>-->
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                            <div class="btns">
                                <button id="secToFir" class="btn btn-mine">上一步</button>
                                <button id="secToThird" class="btn btn-mine">下一步</button>
                            </div>
                        </div>
                    </div>
                    <!--业务受理配置-->
                    <div class="panel panel-info business-configuration">
                        <div class="panel-heading">
                            <h3 class="panel-title">业务受理配置</h3>
                        </div>
                        <div class="panel-body">
                            <div class="base-info clearfix">
                                <div class="base-info-name text-left">基础资料:</div>
                                <div class="base-info-content">
                                    <table class="table" id="baseTable">
                                        <!--<thead>-->
                                        <!--<tr>-->
                                        <!--<th colspan="4">个人信息</th>-->
                                        <!--<th>类型</th>-->
                                        <!--<th>应用</th>-->
                                        <!--</tr>-->
                                        <!--</thead>-->
                                        <!--<tbody>-->
                                        <!--<tr>-->
                                        <!--<td>姓名</td>-->
                                        <!--<td><input type="radio" name="_name">必填</td>-->
                                        <!--<td><input type="radio" name="_name">选填</td>-->
                                        <!--<td><input type="radio" name="_name">不填</td>-->
                                        <!--<td class="shallow">文本</td>-->
                                        <!--<td class="shallow">OCR读取</td>-->
                                        <!--</tr>-->

                                        <!--</tbody>-->

                                    </table>
                                </div>
                            </div>

                            <div class="base-info clearfix">
                                <div class="base-info-name text-left">身份证相关资料:</div>
                                <div class="base-info-content">
                                    <table class="table" id="idTable">
                                        <!--<thead>-->
                                        <!--<tr>-->
                                        <!--<th colspan="4">个人信息</th>-->
                                        <!--<th>类型</th>-->
                                        <!--<th>应用</th>-->
                                        <!--</tr>-->
                                        <!--</thead>-->
                                        <!--<tbody>-->
                                        <!--<tr>-->
                                        <!--<td>姓名</td>-->
                                        <!--<td><input type="radio" name="_name">必填</td>-->
                                        <!--<td><input type="radio" name="_name">选填</td>-->
                                        <!--<td><input type="radio" name="_name">不填</td>-->
                                        <!--<td class="shallow">文本</td>-->
                                        <!--<td class="shallow">OCR读取</td>-->
                                        <!--</tr>-->

                                        <!--</tbody>-->

                                    </table>
                                </div>
                            </div>

                            <div class="uploading-info clearfix">
                                <div class="uploading-info-name text-left">上传资料:</div>
                                <div class="uploading-info-content">
                                    <table class="table" id="upLoadTable">
                                        <!--<thead>-->
                                        <!--<tr>-->
                                        <!--<th colspan="4">资产佐证</th>-->
                                        <!--<th>类型</th>-->
                                        <!--<th>应用</th>-->
                                        <!--</tr>-->
                                        <!--</thead>-->
                                        <!--<tbody id="_assetProve">-->
                                        <!--<tr>-->
                                        <!--<td>房产</td>-->
                                        <!--<td><input type="radio" name="_house">必填</td>-->
                                        <!--<td><input type="radio" name="_house">选填</td>-->
                                        <!--<td><input type="radio" name="_house">不填</td>-->
                                        <!--<td class="shallow">图片</td>-->
                                        <!--<td class="shallow">应用获取用户手机拍照、灯光、储存卡使用权限</td>-->
                                        <!--</tr>-->

                                        <!--</tbody>-->

                                    </table>
                                </div>
                            </div>
                            <div class="accredit-info clearfix">
                                <div class="accredit-info-name text-left">授权资料:</div>
                                <div class="accredit-info-content">
                                    <table class="table" id="accTable">
                                        <!--<tbody id="_accreditInfo">-->
                                        <!--<tr>-->
                                        <!--<td>通讯录授权</td>-->
                                        <!--<td><input type="radio" name="_addrList">必填</td>-->
                                        <!--<td><input type="radio" name="_addrList">选填</td>-->
                                        <!--<td><input type="radio" name="_addrList">不填</td>-->
                                        <!--<td class="shallow invisibled">图片</td>-->
                                        <!--<td class="shallow invisibled">应用获取用户手机拍照、灯光、储存卡使用权限</td>-->
                                        <!--</tr>-->

                                        <!--</tbody>-->
                                    </table>
                                </div>
                            </div>
                            <div class="business-btns">
                                <button id="thirdToSec" class="btn btn-mine">上一步</button>
                                <button id="thirdToFour" class="btn btn-mine">下一步</button>
                            </div>
                        </div>
                    </div>
                    <!--交易配置-->
                    <div class="panel panel-info deal-configuration">
                        <div class="panel-heading">
                            <h3 class="panel-title">交易配置</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <li id="repaymentPlanWay">
                                    <i class="con-name">还款计划表:</i>
                                    <!--<s><input type="radio" name="repaymentPlanWay" value="1">渠道方提供</s>-->
                                    <!--<s><input type="radio" name="repaymentPlanWay" value="0">系统自动生成</s>-->
                                    <s><input type="radio" name="repaymentPlanWay" value="1">资产端生成</s>
                                    <s><input type="radio" name="repaymentPlanWay" value="0">资金端推送</s>
                                </li>
                                <li class="hide" id="repaymentPlanWayOffsetBox">
                                    <i class="con-name">还款计划表生成时间:</i>
                                    系统自动生成 <select name="repaymentPlanWayOffset">
                                    <option value="+">+</option>
                                    <option value="-">-</option>
                                </select>
                                    <input value="0" class="form-control text-right" type="number"
                                           id="repaymentPlanWayOffset">天
                                </li>
                                <li class="clearfix" id="repayWay">
                                    <i class="con-name">还款方式:</i>
                                    <sub>
                                        <!--<label><input name="repayWay" type="checkbox">等额本息</label>-->
                                    </sub>
                                </li>
                            </ul>
                            <ul>
                                <li>
                                    <i class="con-name">产品利率:</i>
                                    <input type="number" class="form-control text-right" id="fixedInterestRate">%
                                    <span class="red-tag spel-tag">注：产品利率</span>
                                </li>
                                <li>
                                    <i class="con-name">平台趸收服务费率:</i>
                                    <input type="number" class="form-control text-right" id="serviceCharge">%
                                    <span class="red-tag spel-tag">注：天府财富平台趸收服务费率</span>
                                </li>
                                <li>
                                    <i class="con-name">固定投资人费率:</i>
                                    <input type="number" class="form-control text-right" id="serviceChargeTerm">%
                                    <span class="red-tag spel-tag">注：固定投资人费率</span>
                                </li>
                            </ul>
                            <ul>
                                <li class="hide">
                                    <i class="con-name">提款控制:</i>
                                    <s><input checked type="radio" name="drawingControl" value="1">控制</s>
                                    <s><input type="radio" name="drawingControl" value="0">不控制</s>
                                </li>
                                <li class="hide">
                                    <i class="con-name">提前还款:</i>
                                    <s><input checked type="radio" name="isPrepaySup" value="1">是</s>
                                    <s><input type="radio" name="isPrepaySup" value="0">否</s>
                                </li>
                                <li class="hide">
                                    <i class="con-name">罚息:</i>
                                    <s><input checked type="radio" name="isPenaltySup" value="1">是</s>
                                    <s><input type="radio" name="isPenaltySup" value="0">否</s>
                                </li>
                                <li>
                                    <i class="con-name">用户确认:</i>
                                    <s><input checked type="radio" name="isOnlineSign" value="1">是</s>
                                    <s><input type="radio" name="isOnlineSign" value="0">否</s>
                                </li>
                                <li>
                                    <i class="con-name">合同生成方式:</i>
                                    <s><input checked type="radio" name="contractGenerationType" value="1">系统生成</s>
                                    <s><input type="radio" name="contractGenerationType" value="2">审批上传</s>
                                </li>
                            </ul>
                            <ul id="acSetting" style="position: relative;">
                                <li>
                                    <i class="con-name">还款账户设置:</i>
                                    <span class="spe-width">还款角色:</span>
                                    <select id="repayment">
                                        <option value="-1">不配置</option>
                                        <option value="0">借款人还款</option>
                                        <option value="1">渠道还款</option>
                                        <option value="2">指定渠道还款</option>
                                        <option value="3">还款人还本第三方渠道还息</option>
                                    </select>
                                    <span class="spe-width hide-dom">代还方设置:</span>
                                    <select id="repayment2" class="hide-dom">

                                    </select>
                                </li>
                                <li>
                                    <i class="con-name">代偿账户设置:</i>
                                </li>
                                <li class="repay-li-wrap">
                                    <div style="margin-bottom: 10px;" data-index="0" class="repay-li">
                                        <i class="con-name"></i>
                                        <span class="spe-width">代偿方设置:</span>
                                        <select class="repay">
                                            <option value="-1">不配置</option>
                                            <option value="0">借款人代偿</option>
                                            <option value="1">渠道代偿</option>
                                            <option value="2">指定渠道代偿</option>
                                        </select>
                                        <select class="repayList hide-dom">

                                        </select>
                                    </div>
                                </li>

                                <li class="payee">
                                    <i class="con-name">收款账户设置:</i>
                                    <span class="spe-width">收款角色:</span>
                                    <select id="payee">
                                        <option value="-1">不配置</option>
                                        <option value="0">借款人收款</option>
                                        <option value="1">渠道收款</option>
                                        <option value="2">指定渠道收款</option>
                                    </select>
                                    <span class="spe-width hide-dom">代收方设置:</span>
                                    <select id="payee2" class="hide-dom">

                                    </select>
                                </li>
                                <li class="btn-wrap" style="position: absolute;left: 165px;top: 58px;">
                                    <button type="button" class="btn" id="addRepayLi">增加</button>
                                    <button type="button" class="btn btn-danger" id="removeRepayLi">删除</button>
                                </li>
                            </ul>
                            <div class="deal-btns">
                                <button id="fourTothird" class="btn btn-mine">上一步</button>
                                <button id="fourToFive" class="btn btn-mine">下一步</button>
                            </div>
                        </div>
                    </div>
                    <!--流程配置-->
                    <div class="panel panel-info process-configuration">
                        <div class="panel-heading">
                            <h3 class="panel-title">流程配置</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <li>
                                    <i class="con-name">启动流程:</i>
                                    <input checked type="radio" name="start" execOrders="1"
                                           value="1" data-name="启动流程" template-id=""><span>开始</span>
                                    <select name="" id="startNext" class="next-step">
                                        <option value="">--下一步动作--</option>
                                        <option value="0">待开启审批流程</option>
                                        <option selected value="1">启动流程</option>
                                        <option value="2">决策引擎通过</option>
                                        <option value="3">分单成功</option>
                                        <option value="4">平台拒绝</option>
                                        <option value="5">初审通过</option>
                                        <option value="7">终审通过</option>
                                        <option value="8">生成合同</option>
                                        <option value="9">用户确认</option>
                                        <option value="10">生成标的物</option>
                                        <option value="11">发标成功</option>
                                        <option value="12">募资成功/放款成功</option>
                                        <option value="15">发标失败/</option>
                                        <option value="20">逾期</option>
                                        <option value="41">用户拒绝</option>
                                        <option value="51">复审通过</option>
                                        <option value="52">驳回</option>
                                        <option value="99">还款完成</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="con-name">决策引擎:</i>
                                    <input type="checkbox" name="engine" execOrders="2"
                                           value="2" data-name="决策引擎" template-id="" id="engine"><span>决策引擎</span>
                                    <select name="" id="engineNext" class="next-step sepcial-left-user">
                                        <option value="">--下一步动作--</option>
                                        <option value="0">待开启审批流程</option>
                                        <option value="1">启动流程</option>
                                        <option value="2">决策引擎通过</option>
                                        <option value="3">分单成功</option>
                                        <option value="4">平台拒绝</option>
                                        <option value="5">初审通过</option>
                                        <option selected value="7">终审通过</option>
                                        <option value="8">生成合同</option>
                                        <option value="9">用户确认</option>
                                        <option value="10">生成标的物</option>
                                        <option value="11">发标成功</option>
                                        <option value="12">募资成功/放款成功</option>
                                        <option value="15">发标失败/</option>
                                        <option value="20">逾期</option>
                                        <option value="41">用户拒绝</option>
                                        <option value="51">复审通过</option>
                                        <option value="52">驳回</option>
                                        <option value="99">还款完成</option>
                                    </select>
                                    <select name="" id="engineMethod">
                                        <option value="">--请选择决策引擎--</option>
                                        <option value="phkjDecisionEngineService">普惠快捷规则</option>
                                        <option value="carLoanDecisionEngineService">车贷决策引擎</option>
                                        <option value="ymfqRule1">医美分期</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="con-name">业务分单流程:</i>
                                    <input type="checkbox" name="shuntSwitch" id="shuntSwitch"><span>分单启用</span>
                                    <div class="assign-bill">
                                        <input type="radio" name="shunt" execOrders="3"
                                               value="3" data-name="自动分单" template-id=""><span>自动分单</span>
                                        <input type="radio" name="shunt" execOrders="3"
                                               value="4" data-name="手动分单" template-id=""><span>手动分单</span>
                                    </div>
                                    <select name="" id="shuntNext" class="next-step sepcial-left">
                                        <option value="">--下一步动作--</option>
                                        <option value="0">待开启审批流程</option>
                                        <option value="1">启动流程</option>
                                        <option value="2">决策引擎通过</option>
                                        <option selected value="3">分单成功</option>
                                        <option value="4">平台拒绝</option>
                                        <option value="5">初审通过</option>
                                        <option value="7">终审通过</option>
                                        <option value="8">生成合同</option>
                                        <option value="9">用户确认</option>
                                        <option value="10">生成标的物</option>
                                        <option value="11">发标成功</option>
                                        <option value="12">募资成功/放款成功</option>
                                        <option value="15">发标失败/</option>
                                        <option value="20">逾期</option>
                                        <option value="41">用户拒绝</option>
                                        <option value="51">复审通过</option>
                                        <option value="52">驳回</option>
                                        <option value="99">还款完成</option>
                                    </select>
                                    <select name="" id="shuntMethod">
                                        <option value="">--请选择分单算法--</option>
                                        <option value="rrandomShunt">随机分单</option>
                                        <option value="averageShunt">平均分单</option>
                                    </select>
                                </li>
                                <li class="clearfix business-reply">
                                    <i class="con-name pull-left">业务审批流程:</i>
                                    <div>
                                        <p>
                                            <input type="checkbox" name="firstCheck" execOrders="4"
                                                   value="5" data-name="初审" template-id=""><span>初审</span>
                                            <select name="" id="firstNext" class="next-step-spe">
                                                <option value="">--下一步动作--</option>
                                                <option value="5">初审通过</option>
                                                <option value="51">复审通过</option>
                                                <option value="7">终审通过</option>
                                                <option value="8">生成合同</option>
                                            </select>
                                        </p>
                                        <p>
                                            <input type="checkbox" name="againCheck" execOrders="5"
                                                   value="6" data-name="复审" template-id="next-step-spe"><span>复审</span>
                                            <select name="" id="againNext" class="next-step-spe">
                                                <option value="">--下一步动作--</option>
                                                <option value="5">初审通过</option>
                                                <option value="51">复审通过</option>
                                                <option value="7">终审通过</option>
                                                <option value="8">生成合同</option>
                                            </select>
                                        </p>
                                        <p>
                                            <input type="checkbox" name="finalCheck" execOrders="6"
                                                   value="7" data-name="终审" template-id=""><span>终审</span>
                                            <select name="" id="finalNext" class="next-step-spe">
                                                <option value="">--下一步动作--</option>
                                                <option value="5">初审通过</option>
                                                <option value="51">复审通过</option>
                                                <option value="7">终审通过</option>
                                                <option value="8">生成合同</option>
                                            </select>
                                        </p>
                                    </div>
                                </li>
                                <li>
                                    <i class="con-name">用户确认:</i>
                                    <input type="checkbox" name="userConfirm" execOrders="7"
                                           value="9" data-name="用户确认" template-id=""><span>用户确认</span>
                                    <select name="" id="userConfirmNext" class="sepcial-left-user">
                                        <option value="">--下一步动作--</option>
                                        <option selected value="9">用户确认</option>
                                        <option value="10">生成标的物</option>
                                        <option value="11">发标成功</option>
                                        <option value="12">募资成功/放款成功</option>
                                        <option value="15">发标失败/</option>
                                        <option value="20">逾期</option>
                                        <option value="41">用户拒绝</option>
                                        <option value="51">复审通过</option>
                                        <option value="52">驳回</option>
                                        <option value="99">还款完成</option>
                                    </select>
                                    </select>
                                    <select name="" id="userConfirm">
                                        <option checked value="userConfirm">用户确认</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="con-name">资产发标流程:</i>
                                    <input type="checkbox" name="sendMark" execOrders="8" value="10"
                                           data-name="发标" template-id=""><span>发标</span>
                                    <select name="" id="sendMarkNext" class="next-step">
                                        <option value="">--下一步动作--</option>
                                        <option value="0">待开启审批流程</option>
                                        <option value="1">启动流程</option>
                                        <option value="2">决策引擎通过</option>
                                        <option value="3">分单成功</option>
                                        <option value="4">平台拒绝</option>
                                        <option value="5">初审通过</option>
                                        <option value="7">终审通过</option>
                                        <option value="8">生成合同</option>
                                        <option value="9">用户确认</option>
                                        <option value="10">生成标的物</option>
                                        <option selected value="11">发标成功</option>
                                        <option value="12">募资成功/放款成功</option>
                                        <option value="15">发标失败/</option>
                                        <option value="20">逾期</option>
                                        <option value="41">用户拒绝</option>
                                        <option value="51">复审通过</option>
                                        <option value="52">驳回</option>
                                        <option value="99">还款完成</option>
                                    </select>
                                    <select name="" id="sendMark">
                                        <option checked value="sendMark">发标</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="con-name">放款流程:</i>
                                    <input type="checkbox" name="autoLoan" execOrders="9" value="11"
                                           data-name="放款" template-id=""><span>放款</span>
                                    <select name="" id="autoLoanNext" class="next-step">
                                        <option value="">--下一步动作--</option>
                                        <option value="0">待开启审批流程</option>
                                        <option value="1">启动流程</option>
                                        <option value="2">决策引擎通过</option>
                                        <option value="3">分单成功</option>
                                        <option value="4">平台拒绝</option>
                                        <option value="5">初审通过</option>
                                        <option value="7">终审通过</option>
                                        <option value="8">生成合同</option>
                                        <option value="9">用户确认</option>
                                        <option value="10">生成标的物</option>
                                        <option value="11">发标成功</option>
                                        <option selected value="12">募资成功/放款成功</option>
                                        <option value="15">发标失败/</option>
                                        <option value="20">逾期</option>
                                        <option value="41">用户拒绝</option>
                                        <option value="51">复审通过</option>
                                        <option value="52">驳回</option>
                                        <option value="99">还款完成</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="con-name">流程结束:</i>
                                    <input checked type="radio" name="finish" execOrders="10"
                                           value="99" data-name="流程结束" template-id=""><span>结束</span>
                                    <button class="btn btn-mine creat-product-process" id="creatProcess">
                                        生成产品审批流程
                                    </button>
                                </li>
                            </ul>
                            <div class="steps">
                                <ul class="clearfix" id="step_process"></ul>
                            </div>
                            <div class="process-btns">
                                <button id="fiveToFour" class="btn btn-mine">上一步</button>
                                <button id="saveProduct" class="btn btn-mine">保存</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!--交易配置渠道商模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="channelListModal" data-backdrop="static"
         data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body text-center">
                    <div class="search">
                        <input type="text" class="form-control" id="sChannelInput">
                        <button class="btn btn-mine" id="sChannelList">搜索</button>
                    </div>
                    <div class="channel-list">
                        <ul id="channelListUl">
                            <!--<li>重庆真牛汽车销售公司</li>-->
                        </ul>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-mine" id="confirmAddIntro">确认</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <!--模态框-->
    <div class="modal fade asset-classify" tabindex="-1" role="dialog" id="myModal" data-backdrop="static"
         data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <!--<label for="1period"><input type="checkbox" name="borrowDeatlineAll" id="1period" value="1">1期</label>-->
                </div>
                <div class="modal-footer">
                    <span class="red-tag" style="margin-right: 20px;">您选的期数已经存在于常用期数中， 请勿重复添加!</span>
                    <button id="conAddPeriod" type="button" class="btn btn-mine">确认</button>
                    <button type="button" class="btn btn-confirm" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
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

</div>
<!--开关-->
<script src="<%=basePath%>static/plugins/honeySwitch/honeySwitch.js"></script>
<script>
    Number.prototype.div = function (arg){ // 除法
        return accDiv(this, arg);
    }
    Number.prototype.mul = function (arg){ // 乘法
        return accMul(arg, this);
    }
    function accDiv(arg1,arg2){
        var t1=0,t2=0,r1,r2;
        try{t1=arg1.toString().split(".")[1].length}catch(e){}
        try{t2=arg2.toString().split(".")[1].length}catch(e){}
        with(Math){
            r1=Number(arg1.toString().replace(".",""))
            r2=Number(arg2.toString().replace(".",""))
            return (r1/r2)*pow(10,t2-t1);
        }
    }
    function accMul(arg1,arg2){
        var m=0,s1=arg1.toString(),s2=arg2.toString();
        try{m+=s1.split(".")[1].length}catch(e){}
        try{m+=s2.split(".")[1].length}catch(e){}
        return Number(s1.replace(".",""))*Number(s2.replace(".",""))/Math.pow(10,m)
    }
    var product = {
        // 一些变量值
        variable: {
            productId: '${id}',
            area: [
                // {labelText :'',id :''}
            ],
            provinceArea: [],
            areaType: null,
            // 渠道配置-渠道进件和引流进件
            introType: {introType01: [], introType02: []},
            // 单独选择引流进件flag
            iTFlag: false,
            channelUserList : '',
            deal: {
                pdTransactionId: '', // 交易配置id
                count : 0,
                payeeObj: {id: '', repayRole: -1, repayType: -1}, // 收款人
                repayList: [ // 代偿
                    {id: '', repayRole: -1, repayOrder: 1,accountId:''}, // 不能变
                ],
                repaymentObj : { // 还款人
                    id: '', repayRole: -1, repayType: -1
                }
            },
            processLine: [] // 流程配置图
        },
        radioDom: {},
        dealDom: {
            repaymentPlanWay: $('input[name="repaymentPlanWay"]'), // 还款计划表
            drawingControl: $('input[name="drawingControl"]'),
            isPrepaySup: $('input[name="isPrepaySup"]'),
            isPenaltySup: $('input[name="isPenaltySup"]'),
            isOnlineSign: $('input[name="isOnlineSign"]'),
            contractGenerationType: $('input[name="contractGenerationType"]')
        },
        processDom: {
            processCheckBox: {
                engine: $('input[name="engine"]'),
                shuntSwitch: $('input[name="shuntSwitch"]'),
                firstCheck: $('input[name="firstCheck"]'),
                againCheck: $('input[name="againCheck"]'),
                finalCheck: $('input[name="finalCheck"]'),
                userConfirm: $('input[name="userConfirm"]'),
                sendMark: $('input[name="sendMark"]'),
                autoLoan: $('input[name="autoLoan"]')
            },
            processRadio: {
                start: $('input[name="start"]'),
                shunt: $('input[name="shunt"]'),
                finish: $('input[name="finish"]')
            }
        },
        init: function () {
            this.baseConfigurationInit();
            this.renderCheckBox();
            this.bindEvent();


        },
        bindEvent: function () {
            this.bindBaseEvent();
            this.bindChannelEvent();
            this.bindBusinessEvent();
            this.bindDealEvent();
            this.bindProcessEvent();
        },
        /**
         * 基本配置
         */
        // 基本配置初始化
        baseConfigurationInit: function () {
            var self = this;
            this.renderBorrowType(function () {
                self.renderBorrowUse(function () {
                    self.getBaseData();
                });
            });
            this.renderCreditArea();
            this.renderMorePeriod();
            this.renderBorrTypeReport();
            this.renderBorrUseReport();
        },
        // 基本配置绑定事件
        bindBaseEvent: function () {
            var self = this;
            /**
             * 基本配置
             */
            // 选中担保方式让对应输入框弹出
            $('input[name="ensureWay"]').each(function () {
                $(this).parents('label').click(function () {
                    $('input.ensure-way-input').removeClass('show-input');
                    $(this).children('input').addClass('show-input')
                })
                $(this).siblings('ins').click(function () {
                    $('input.ensure-way-input').removeClass('show-input');
                    $(this).parent('div').siblings('input').addClass('show-input')
                })
            })
            // 点击产品标签
            $('#addProductTags').click(function () {
                var tagBox = $('#tagBox');
                if (tagBox.children('.product-tag-container').length >= 4) {
                    self.alertModelCancel('最多添加4个标签');
                    return false;
                }
                $('<div class="product-tag-container"><input maxlength="4" class="form-control product-tag"><i id="delProductTag" class="glyphicon glyphicon-remove"></i></div>').appendTo(tagBox);
            })
            // 点击删除产品标签
            $('.base-configuration .panel-body li:eq(0)').on('click', 'i#delProductTag', function () {
                $(this).parent('div.product-tag-container').remove();
            })
            // 点击更多期数
            $('#morePeriod').click(function () {
                $('#myModal span.red-tag').removeClass('go-show');
                $('input[name="borrowDeatlineAll"]').iCheck('uncheck');
                $('#myModal').modal('show');
            })
            // 点击更多期数确认添加到常用期数
            $('#conAddPeriod').click(function () {
                var arr = self.getMorePeriod('borrowDeatlineAll');
                var exist = $.makeArray($('input[name="borrowDeatline"]'));
                // 判断是否重复添加
                for (var i = 0; i < arr.length; i++) {
                    for (var j = 0; j < exist.length; j++) {
                        if (exist[j].value == arr[i].value) {
                            $('#myModal span.red-tag').addClass('go-show');
                            return;
                        }
                    }
                }

                var str = '';
                for (var i = 0; i < arr.length; i++) {
                    str += '<label for="' + arr[i].id + '"><input checked type="checkbox" name="borrowDeatline" id="' + arr[i].id + '" value="' + arr[i].value + '">' + arr[i].labelText + '</label>'
                }
                $('#borrowBoxInner').append(str); // 将选中的期数插入到页面中
                // 重新渲染icheck组件及全选功能
                var periodChecks = $('input[name="borrowDeatline"]'),
                    allSelect = $('#allSelect');
                periodChecks.iCheck({
                    checkboxClass: 'icheckbox_minimal-blue',
                });
                allSelect.on('ifChanged', function (event) {
                    if ($(this).is(':checked')) {
                        periodChecks.iCheck("check");
                    } else {
                        periodChecks.iCheck("uncheck");
                    }
                });
                $('#myModal').modal('hide');
            })

            // 点击删除授信区域-----------
            $('#creditArea').on('click', 'i.remove-area', function () {
                if ($('#showCity').parent('div').hasClass('checked')) { // 精确到市被选中
                    // 删除json中对应存储的值
                    self.variable.area.splice($(this).parent('span').index(), 1);
                    // 删除dom 界面上也被删除
                    $(this).parent('span').remove();
                } else {
                    self.variable.provinceArea.splice($(this).parent('span').index(), 1);
                    $(this).parent('span').remove();
                }

            })
            // 点击授信区域勾选全国复选框
            $('#allCountry').siblings('ins').on('click', function () {
                var province = $('#province'),
                    city = $('#city'),
                    btn = $('#addAreaBtn'),
                    displayArea = $('.display-area'),
                    showCity = $('#showCityBox');
                if ($(this).parent().hasClass('checked')) {
                    province.val('-1');
                    city.val('-1');
                    province.attr('disabled', true);
                    city.attr('disabled', true);
                    btn.attr('disabled', true);
                    showCity.addClass('go-hide');
                    displayArea.empty();
                    self.variable.area.splice(0, self.variable.area.length); // 清空市数组
                    self.variable.provinceArea.splice(0, self.variable.provinceArea.length); // 清空省数组
                } else {
                    province.removeAttr('disabled', true);
                    city.removeAttr('disabled', true);
                    btn.removeAttr('disabled', true);
                    showCity.removeClass('go-hide');
                    self.variable.area.splice(0, self.variable.area.length); // 清空市数组
                    self.variable.provinceArea.splice(0, self.variable.provinceArea.length); // 清空省数组
                }
            })
            // 点击添加授信区域---------
            $('#addAreaBtn').on('click', function () {
                var city = $('#city'),
                    province = $('#province'),
                    cityVal = city.val(),
                    provinceVal = province.val();

                // 精确到市
                if ($('#showCity').parent('div').hasClass('checked')) {
                    // 防止重复选择
                    for (var i = 0; i < self.variable.area.length; i++) {
                        var obj = self.variable.area[i];
                        if (obj.id == cityVal) {
                            self.alertModelCancel('请勿重复添加!');
                            return;
                        }
                    }
                    var json = {};
                    city.children('option').each(function () {
                        if ($(this).val() == cityVal && $(this).val() != -1) {
                            json.id = cityVal;
                            json.labelText = $(this).text();
                            self.variable.area.push(json);
                            return false;
                        }
                    })
                    // 渲染市
                    self.renderArrData(self.variable.area);
                } else { // 选择省
                    for (var i = 0; i < self.variable.provinceArea.length; i++) {
                        var obj = self.variable.provinceArea[i];
                        if (obj.id == provinceVal) {
                            self.alertModelCancel('请勿重复添加!');
                            return;
                        }
                    }
                    var json = {};
                    province.children('option').each(function () {
                        if ($(this).val() == provinceVal && $(this).val() != -1) {
                            json.id = provinceVal;
                            json.labelText = $(this).text();
                            self.variable.provinceArea.push(json);
                            return false;
                        }
                    })
                    // 渲染省
                    self.renderArrData(self.variable.provinceArea);
                }


            })
            // 点击精确到市显示市下拉框
            $('#showCity').siblings('ins').on('click', function () {
                if ($(this).parent().hasClass('checked')) {
                    $('#city').addClass('go-show');
                    self.renderArrData(self.variable.area);
                } else {
                    $('#city').removeClass('go-show');
                    self.renderArrData(self.variable.provinceArea);
                }

                // if(self.variable.areaType==1){ // 省
                //     self.variable.area.length=0;
                // }else if(self.variable.areaType==2) { // 市
                //     self.variable.provinceArea.length=0;
                // }


            })
            // 下一步
            $('#firToSec').on('click', function () {
                var params = {
                    productTempId: '${productTempId}',
                    productName: $.trim($('#firstProductName').val()),
                    productTags: productTags(),
                    openProductId: $.trim($('#productCode').val()),
                    productCodeZj : $.trim($('#productCodeZj').val()),
                    productDescription: $.trim($('#firstProScene').val()),
                    isRecommand: isRecommand(),
                    loanSubject: $('#borrower').val(),
                    feeInfo: $.trim($('#monRateInterval01').val()) + '%~' + $.trim($('#monRateInterval02').val()) + '%',
                    amountInfo: $.trim($('#borrowInterval01').val()) + '~' + $.trim($('#borrowInterval02').val()),
                    productCycle: productCycle(),
                    borrowType: self.getCheckboxItem('borrowType').join(','), // 借款类型
                    scope: self.getCheckboxItem('borrowUse').join(','),// 借款用途
                    tdReportValidDate: $.trim($('#tdReportValidDate').val()),// 风险报告有效期
                    guaranteeType: self.getCheckboxItem('ensureWay').join(','), // 担保方式
                    guaranteeValue: guaranteeValue(),//担保公司
                    wdBorrowType:$('#borrowTypeForReport').val(),//借款类型，资产上报专用
                    wdUsageNo:$('#borrowUseForReport').val()//借款用途，资产上报专用
                }
                if (self.variable.productId != '') { // 如果productId有值 则进行更新 否则为新建
                    params.productId = self.variable.productId;
                }
                // 判断资金端编号是否填写
                if (params.openProductId == '') {
                    self.alertModelCancel('请输入产品资金端编号!');
                    return;
                }
                if (params.productCodeZj == '') {
                    self.alertModelCancel('请输入生成项目编号!');
                    return;
                }
                // 判断月费率区间
                if (Number($.trim($('#monRateInterval01').val())) < 0 || Number($.trim($('#monRateInterval02').val())) < 0) {
                    self.alertModelCancel('请输入正确的月费率区间!');
                    return;
                }
                if (Number($.trim($('#monRateInterval01').val())) > Number($.trim($('#monRateInterval02').val()))) {
                    self.alertModelCancel('请输入正确的月费率区间!');
                    return;
                }
                // 判断借款金额区间
                if (params.loanSubject == 1) {
                    if (Number($.trim($('#borrowInterval01').val())) < 0 || Number($.trim($('#borrowInterval01').val())) > 200000 || $.trim($('#borrowInterval01').val()) == '') {
                        self.alertModelCancel('请输入正确的借款金额区间!');
                        return;
                    }
                    if (Number($.trim($('#borrowInterval02').val())) < 0 || Number($.trim($('#borrowInterval02').val())) > 200000) {
                        self.alertModelCancel('请输入正确的借款金额区间!');
                        return;
                    }
                    if (Number($.trim($('#borrowInterval01').val())) > Number($.trim($('#borrowInterval02').val()))) {
                        self.alertModelCancel('请输入正确的借款金额区间!');
                        return;
                    }
                } else if (params.loanSubject == 2) {
                    if (Number($.trim($('#borrowInterval01').val())) < 0 || Number($.trim($('#borrowInterval01').val())) > 1000000 || $.trim($('#borrowInterval01').val()) == '') {
                        self.alertModelCancel('请输入正确的借款金额区间!');
                        return;
                    }
                    if (Number($.trim($('#borrowInterval02').val())) < 0 || Number($.trim($('#borrowInterval02').val())) > 1000000) {
                        self.alertModelCancel('请输入正确的借款金额区间!');
                        return;
                    }
                    if (Number($.trim($('#borrowInterval01').val())) > Number($.trim($('#borrowInterval02').val()))) {
                        self.alertModelCancel('请输入正确的借款金额区间!');
                        return;
                    }
                }
                if (areaList().type != 0) {
                    if (areaList().ids == '') {
                        self.alertModelCancel('请添加授信区域!');
                        return;
                    }
                }
                params.areaList = JSON.stringify(areaList());  // 授信区域
                $.ajax({
                    url: util.getServerUrl('/product/saveProductBaseInfo'),
                    method: 'POST',
                    data: params,
                    beforeSend: function () {
                        $('#firToSec').attr('disabled', true);
                    },
                    complete: function () {
                        $('#firToSec').removeAttr('disabled');
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            if (self.variable.productId == '') {
                                self.variable.productId = res.data;
                            }
                            $('.configuration > div').hide();
                            self.channelInit(); // 初始化渠道配置(渲染列表等功能)
                            $('.channel-configuration').show();

                        } else {
                            if (res.msg == '') {
                                self.alertModelCancel('新建/更新产品失败!');
                            } else {
                                self.alertModelCancel(res.msg);
                            }
                        }
                    },
                    error: function (error) {
                        self.alertModelCancel('新建/更新产品失败!');
                    }
                })

                // 获取产品标签
                function productTags() {
                    var productTags = $('.product-tag'), arr = [];
                    if (self.exist(productTags)) {
                        productTags.each(function () {
                            arr.push($.trim($(this).val()));
                        })
                        return arr.join(',');
                    } else {
                        return '';
                    }
                }

                // 获取是否推荐的值
                function isRecommand() {
                    return $('#isRecommand').children('span').hasClass('switch-off') ? 0 : 1;
                }

                // 获取借款期限
                function productCycle() {
                    if ($('#allSelect').is(':checked')) {
                        return self.getCheckboxItem('borrowDeatline').slice(1).join(',')
                    } else {
                        return self.getCheckboxItem('borrowDeatline').join(',')
                    }
                }

                // 获取授信区域
                function areaList() {
                    if ($('#allCountry').is(':checked')) {
                        return {type: 0, ids: ''};
                    } else if ($('#showCity').is(':checked')) { // 市
                        var arr1 = [];
                        for (var i = 0; i < self.variable.area.length; i++) {
                            var obj = self.variable.area[i];
                            arr1.push(obj.id);
                        }
                        return {type: 2, ids: arr1.join(',')};
                    } else { // 省
                        var arr2 = [];
                        for (var i = 0; i < self.variable.provinceArea.length; i++) {
                            var obj = self.variable.provinceArea[i];
                            arr2.push(obj.id);
                        }
                        return {type: 1, ids: arr2.join(',')};
                    }
                }

                // 获取担保公司
                function guaranteeValue() {
                    var val = self.getCheckboxItem('ensureWay')[0];
                    if (val == 1) {
                        return $.trim($('#ensureWay01Name').val());
                    } else if (val == 2) {
                        return $.trim($('#ensureWay02Name').val());
                    } else {
                        return '';
                    }
                }

            })

        },
        // 渲染基本配置更多期数
        renderMorePeriod: function () {
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType?type=CPDKKXQX'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        morePeriod(res.data);
                        var allChecks = $('input[name="borrowDeatlineAll"]'); // 隐藏的所有checkbox
                        allChecks.iCheck({
                            checkboxClass: 'icheckbox_minimal-blue',
                        })
                    }
                }
            })

            function morePeriod(data) {
                var str = '';
                for (var i = 0; i < data.length; i++) {
                    str += '<label for="' + data[i].value + 'period">';
                    str += '<input type="checkbox" period-text="' + data[i].labelText + '" name="borrowDeatlineAll" id="' + data[i].value + 'period" value="' + data[i].id + '">' + data[i].labelText;
                    str += '</label>';
                }
                $('#myModal .modal-body').html(str);
            }
        },
        
     	// 渲染借款类型上报信息
        renderBorrTypeReport: function (cb) {
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType?type=ZCSBJKLX'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                    	borrowUseTypeReport(res.data);
                        cb && cb();
                    }
                }
            })

            function borrowUseTypeReport(data) {
                var str = '';
                for (var i = 0; i < data.length; i++) {
                	str += '<option name="borrowTypeOption" value="'+data[i].value+'">'+data[i].labelText+'</option>';
                }
                $('#borrowTypeForReport').html(str);
            }
        },
     	// 渲染借款用途上报信息
        renderBorrUseReport: function (cb) {
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType?type=ZCSBJKYT'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                    	borrowUseTypeReport(res.data);
                        cb && cb();
                    }
                }
            })

            function borrowUseTypeReport(data) {
                var str = '';
                for (var i = 0; i < data.length; i++) {
                	str += '<option name="borrowUseOption" value="'+data[i].value+'">'+data[i].labelText+'</option>';
                }
                $('#borrowUseForReport').html(str);
            }
        },
        // 渲染借款用途
        renderBorrowUse: function (cb) {
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType?type=CPYTPZ'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        borrowUseType(res.data);
                        var borrowUse = $('input[name="borrowUse"]'); // 借款用途的radio
                        borrowUse.iCheck({
                            checkboxClass: 'icheckbox_minimal-blue',
                        });
                        cb && cb();
                    }
                }
            })

            function borrowUseType(data) {
                var str = '';
                for (var i = 0; i < data.length; i++) {
                    str += '<label for="borrowUse0' + data[i].value + '">';
                    str += '<input type="checkbox" name="borrowUse" id="borrowUse0' + data[i].value + '" value="' + data[i].id + '">' + data[i].labelText;
                    str += '</label>';
                }
                $('#borrowUseBox').html(str);
            }
        },
        // 渲染借款类型
        renderBorrowType: function (cb) {
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType?type=CPFBSXFL'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        borrowType(res.data);
                        var typeChecks = $('input[name="borrowType"]'); // 借款类型的checkbox
                        typeChecks.iCheck({
                            checkboxClass: 'icheckbox_minimal-blue',
                        });
                        cb && cb();
                    }
                }
            })

            function borrowType(data) {
                var str = '';
                for (var i = 0; i < data.length; i++) {
                    str += '<label for="borrowType0' + data[i].value + '">';
                    str += '<input type="checkbox" name="borrowType" id="borrowType0' + data[i].value + '" value="' + data[i].id + '">' + data[i].labelText;
                    str += '</label>';
                }
                $('#borrowTypeBox').html(str);
            }
        },
        // 授信区域两级联动
        renderCreditArea: function () {
            var province = $('#province'),
                city = $('#city');
            // 获取渲染省份
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType?type=SYSCITY&parentValue=0'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        renderProvinceList(res.data);
                    }
                },
            })

            function renderProvinceList(data) {
                var str = '<option proValue="-1" value="-1">-请选择省份-</option>';
                for (var i = 0; i < data.length; i++) {
                    str += '<option proValue="' + data[i].value + '" value="' + data[i].id + '">' + data[i].labelText + '</option>';
                }
                province.html(str);
            }

            // 省份改变
            $("#province").change(function () {
                var id = $(this).val(), pid = '';
                $.each($(this).children('option'), function (k, v) {
                    if ($(this).val() == id) {
                        pid = $(this).attr('proValue');
                    }
                })
                $("#city").empty();
                if (pid == 0) {
                    city.attr('disabled', true);
                    return false;
                } else {
                    city.removeAttr('disabled');
                }
                $.ajax({
                    method: 'POST',
                    url: util.getServerUrl('/common/getDictListByType?type=SYSCITY'),
                    data: {parentValue: pid},
                    dataType: 'json',
                    success: function (data) {
                        var cityList = data.data, optionList = '<option value="-1">-请选择城市-</option>';
                        $.each(cityList, function (n, value) {
                            optionList += "<option value='" + value.id + "'>" + value.labelText + "</option>";
                        });
                        city.html(optionList);
                    }
                });
            });
        },
        // 仅渲染授信区域数组展示
        renderArrData: function (area) {
            if (area) {
                var str = '';
                for (var i = 0; i < area.length; i++) {
                    var obj = area[i];
                    str += '<span>' + obj.labelText + ' <i class="glyphicon glyphicon-remove remove-area"></i></span>'
                }
                $('.display-area').html(str);
            }
        },
        // 获取数据并渲染
        getBaseData: function () {
            var self = this;
            $.ajax({
                url: util.getServerUrl('/product/productInfo'),
                data: {id: self.variable.productId, page: 1},
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        renderProduct(res.data.productInfo);
                        if (res.data.typeList.length > 0) {
                            renderTypeUse(res.data.typeList, 'borrowType');
                        }
                        if (res.data.productInfo.wdBorrowType) {
                            renderTypeUse(res.data.scopeList, 'borrowUse');
                        }
                        renderBorrow(res.data.cycleList);
                        renderEnsureWay(res.data.productInfo);
                        renderArea(res.data.areaMap);
                        self.variable.areaType = res.data.areaMap.type;
                        renderTypeReport(res.data.productInfo.wdBorrowType, 'borrowTypeOption');//资产上报借款类型
                        renderUseReport(res.data.productInfo.wdUsageNo, 'borrowUseOption');//资产上报借款用途
                    }
                }
            })

            // 渲染资产上报借款类型
            function renderTypeReport(value,name) {
                var a = $('option[name="' + name + '"]');
                if (value != '') {
                	a.each(function () {
                        if ($(this).val() == value) {
                            $(this).attr('selected', true);
                        }
                    })
                }
            }
            // 渲染资产上报借款用途
            function renderUseReport(value,name) {
                var a = $('option[name="' + name + '"]');
                if (value != '') {
                	a.each(function () {
                        if ($(this).val() == value) {
                            $(this).attr('selected', true);
                        }
                    })
                }
            }
            
            // 渲染产品基本信息
            function renderProduct(data) {
                $('#firstProductName').val(data.productName);
                $('#firstProScene').val(data.productDescription);
                $('#productCode').val(data.openProductId);
                $('#tdReportValidDate').val(data.tdReportValidDate);
                $('#productCodeZj').val(data.productCodeZj);
                $('#borrower').val(data.loanSubject);
                if (data.isRecommand) {
                    $('#isRecommand').children('span').removeClass().addClass('switch-on')
                        .attr('style', 'border-color: rgb(0, 139, 255); box-shadow: rgb(0, 139, 255) 0px 0px 0px 16px inset; background-color: rgb(0, 139, 255);');
                } else {
                    $('#isRecommand').children('span').removeClass().addClass('switch-off')
                        .attr('style', 'border-color: rgb(223, 223, 223); box-shadow: rgb(223, 223, 223) 0px 0px 0px 0px inset; background-color: rgb(255, 255, 255);');
                }
                // 月费率区间
                if (data.feeInfo) {
                    var monRateInterva = data.feeInfo.split('~');
                    $('#monRateInterval01').val(monRateInterva[0].slice(0, monRateInterva[0].length - 1));
                    $('#monRateInterval02').val(monRateInterva[1].slice(0, monRateInterva[1].length - 1));
                }

                // 借款金额区间
                if (data.amountInfo) {
                    var borrowInterval = data.amountInfo.split('~');
                    $('#borrowInterval01').val(borrowInterval[0]);
                    $('#borrowInterval02').val(borrowInterval[1]);
                }

                // 渲染标签
                if (data.productTags) {
                    $('#tagBox').empty();
                    var productTags = data.productTags.split(',');
                    var tagStr = '';
                    for (var i = 0; i < productTags.length; i++) {
                        tagStr += '<div class="product-tag-container">';
                        tagStr += '<input maxlength="4" type="text" class="form-control product-tag" value="' + productTags[i] + '">';
                        tagStr += '<i id="delProductTag" class="glyphicon glyphicon-remove"></i>';
                        tagStr += '</div>';
                    }
                    $('#tagBox').html(tagStr);
                }

            }

            // 渲染借款类型和借款用途
            function renderTypeUse(data,name) {
                var a = $('input[name="' + name + '"]');
                if (data != '') {
                    for (var i = 0; i < data.length; i++) {
                        a.each(function () {
                            if ($(this).val() == data[i].id) {
                                $(this).attr('checked', true);
                            }
                        })
                    }
                    a.iCheck({checkboxClass: 'icheckbox_minimal-blue'});
                }
            }


            // 渲染借款期限
            function renderBorrow(data) {
                $('#borrowBoxInner').empty();
                var oStr = '';
                $.each(data, function (k, v) {
                    switch (v.labelText) {
                        case '6期' :
                            $('#6period').attr('checked', true);
                            break;
                        case '12期' :
                            $('#12period').attr('checked', true);
                            break;
                        case '18期' :
                            $('#18period').attr('checked', true);
                            break;
                        case '24期' :
                            $('#24period').attr('checked', true);
                            break;
                        case '36期' :
                            $('#36period').attr('checked', true);
                            break;
                        default :
                            oStr += addBorrow(v);
                    }
                })
                $('#borrowBoxInner').html(oStr);
                // 重新渲染checkbox以及事件
                var allSelect = $('#allSelect'), periodChecks = $('input[name="borrowDeatline"]');
                periodChecks.iCheck({checkboxClass: 'icheckbox_minimal-blue'});
                allSelect.on('ifChanged', function (event) {
                    if ($(this).is(':checked')) {
                        periodChecks.iCheck("check");
                    } else {
                        periodChecks.iCheck("uncheck");
                    }
                });

                function addBorrow(val) {
                    var str = '<label for="' + val.value + 'period">';
                    str += '<input checked type="checkbox" name="borrowDeatline" id="' + val.value + 'period" value="' + val.id + '">' + val.labelText;
                    str += '</label>';
                    return str;
                }
            }

            // 渲染授信区域
            function renderArea(data) {
                // return;
                if (data.type == 0) {
                    // $('#allCountry').siblings('ins').trigger('click');

                    $('#allCountry').attr('checked', true).iCheck({checkboxClass: 'icheckbox_minimal-blue'});

                    $('#province').val('-1');
                    $('#city').val('-1');
                    $('#province').attr('disabled', true);
                    $('#city').attr('disabled', true);
                    $('#addAreaBtn').attr('disabled', true);
                    $('#showCityBox').addClass('go-hide');
                    $('.display-area').empty();
                    self.variable.area.splice(0, self.variable.area.length); // 清空市数组
                    self.variable.provinceArea.splice(0, self.variable.provinceArea.length); // 清空省数组

                    // 点击授信区域勾选全国复选框
                    $('#allCountry').siblings('ins').on('click', allCountry);
                } else if (data.type == 1) {
                    // self.variable.provinceArea.length=0;
                    self.variable.provinceArea = data.areaList;
                    self.renderArrData(self.variable.provinceArea);
                } else if (data.type == 2) {
                    $('#showCity').attr('checked', true).iCheck({
                        checkboxClass: 'icheckbox_minimal-blue',
                    });
                    $('#showCity').siblings('ins').on('click', function () {
                        if ($(this).parent().hasClass('checked')) {
                            $('#city').addClass('go-show');
                            self.renderArrData(self.variable.area);
                        } else {
                            $('#city').removeClass('go-show');
                            self.renderArrData(self.variable.provinceArea);
                        }
                        // if(self.variable.areaType==1){ // 省
                        //     self.variable.area.length=0;
                        // }else if(self.variable.areaType==2) { // 市
                        //     self.variable.provinceArea.length=0;
                        // }
                    })
                    $('#city').addClass('go-show');
                    self.variable.area.length = 0;
                    self.variable.area = data.areaList;
                    self.renderArrData(self.variable.area);
                }

                // 全国勾选
                function allCountry() {
                    var province = $('#province'),
                        city = $('#city'),
                        btn = $('#addAreaBtn'),
                        displayArea = $('.display-area'),
                        showCity = $('#showCityBox');
                    if ($(this).parent().hasClass('checked')) {
                        province.val('-1');
                        city.val('-1');
                        province.attr('disabled', true);
                        city.attr('disabled', true);
                        btn.attr('disabled', true);
                        showCity.addClass('go-hide');
                        displayArea.empty();
                        self.variable.area.splice(0, self.variable.area.length); // 清空数组
                        self.variable.provinceArea.splice(0, self.variable.provinceArea.length); // 清空省数组
                    } else {
                        province.removeAttr('disabled', true);
                        city.removeAttr('disabled', true);
                        btn.removeAttr('disabled', true);
                        showCity.removeClass('go-hide');
                        self.variable.area.splice(0, self.variable.area.length); // 清空数组
                        self.variable.provinceArea.splice(0, self.variable.provinceArea.length); // 清空省数组
                    }
                }
            }

            // 渲染担保方式
            function renderEnsureWay(data) {
                var a = $('#ensureWay01Name'),
                    b = $('#ensureWay02Name'),
                    c = $('#ensureWay01'),
                    d = $('#ensureWay02'),
                    e = $('#ensureWay03');
                if (data.guaranteeType == 0) {
                    e.attr('checked', true);
                    a.removeClass('show-input');
                    b.removeClass('show-input');
                } else if (data.guaranteeType == 1) {
                    c.attr('checked', true);
                    a.addClass('show-input').val(data.guaranteeValue);
                    b.removeClass('show-input');
                } else if (data.guaranteeType == 2) {
                    d.attr('checked', true);
                    b.addClass('show-input').val(data.guaranteeValue);
                    a.removeClass('show-input');
                }
                var ensureWay = $('input[name="ensureWay"]');
                ensureWay.iCheck({
                    radioClass: 'iradio_minimal-blue',
                });
                // 选中担保方式让对应输入框弹出
                $('input[name="ensureWay"]').each(function () {
                    $(this).parents('label').click(function () {
                        $('input.ensure-way-input').removeClass('show-input');
                        $(this).children('input').addClass('show-input')
                    })
                    $(this).siblings('ins').click(function () {
                        $('input.ensure-way-input').removeClass('show-input');
                        $(this).parent('div').siblings('input').addClass('show-input')
                    })
                })
            }


        },

        /**
         * 渠道配置
         */
        // 渠道配置初始化
        channelInit: function () {
            this.renderChannelList();
            this.renderChannelData();

        },
        // 渠道配置绑定事件
        bindChannelEvent: function () {
            var self = this;
            // 渠道
            var a = $('#introType01Name'),
                b = $('#chooseChannel01'),
                c = $('#clear01'),
                d = $('#addIntroType01'),
                // 引流
                e = $('#introType02Name'),
                f = $('#chooseChannel02'),
                g = $('#clear02'),
                h = $('#addIntroType02');

                // 渠道手续费
            var j = $('#type01feeType'),
                k = $('#type01bondType'),
                // 引流手续费
                m = $('#type02feeType'),
                n = $('#type02bondType');

                // checkbox
            var iT01 = $('#introType01'),
                iT02 = $('#introType02'),
                iT03 = $('#introType03');
            // 上一步
            $('#secToFir').click(function () {
                if (judgeChecked()) {
                    self.alertModelCancel('请至少选择一项进件类型!');
                    return false;
                }
                if (judgeIsHasContent01()) return false;
                if (judgeIsHasContent02()) return false;
                saveChecked(function () {
                    self.baseConfigurationInit();
                    $('.configuration > div').hide();
                    $('.base-configuration').show();
                })
            })
            // 下一步
            $('#secToThird').off('click').on('click', function () {
                if (judgeChecked()) {
                    self.alertModelCancel('请至少选择一项进件类型!');
                    return false;
                }
                if (judgeIsHasContent01()) return false;
                if (judgeIsHasContent02()) return false;

                if (judgeIntro02()) {
                    self.variable.iTFlag = true;
                } else {
                    self.variable.iTFlag = false;
                }
                ;
                if (self.variable.iTFlag) {
                    // 隐藏业务受理配置
                    saveChecked(function () {
                        self.dealInit(); // 交易配置初始化
                        $('.configuration > div').hide();
                        $('.deal-configuration').show();
                    })
                } else {
                    saveChecked(function () {
                        self.businessInit(); // 业务受理配置初始化
                        $('.configuration > div').hide();
                        $('.business-configuration').show();
                    })
                }

            })

            function judgeChecked() {
                var flag = 0, value = false;
                $('#introType input').each(function (k, v) {
                    if ($(this).is(':checked')) {
                        flag++;
                    }
                })
                if (flag == 0) {
                    value = true;
                }
                return value;
            }

            function judgeIsHasContent01() {
                var flag = false;
                if (iT01.is(':checked')) {
                    if (self.variable.introType.introType01.length == 0) {
                        self.alertModelCancel('请添加渠道进件合作渠道!');
                        flag = true;
                    }
                }
                return flag;
            }

            function judgeIsHasContent02() {
                var flag = false;
                if (iT02.is(':checked')) {
                    if (self.variable.introType.introType02.length == 0) {
                        self.alertModelCancel('请添加引流进件合作渠道!');
                        flag = true;
                    }
                }
                return flag;
            }

            // 判断是否只是引流进件选中
            function judgeIntro02() {
                var flag = 0, value = false, index = 0;
                $('#introType input').each(function (k, v) {
                    if ($(this).is(':checked')) {
                        flag++;
                        index = k;
                    }
                })
                if (flag == 1 && index == 1) {
                    value = true;
                }
                return value;
            }

            // 点击渠道进件选择渠道
            b.click(function () {
                alertChannelList(1);
            })
            // 点击渠道进件清空
            c.on('click', function () {
                a.text('请添加产品合作渠道').removeAttr('channel-id');
                j.find('input').each(function (k, v) {
                    $(v).val('');
                })
                k.find('input').each(function (k, v) {
                    $(v).val('');
                })
            })
            // 点击渠道进件新增渠道
            d.click(function () {
                var params = {
                    id: a.attr('channel-id'),
                    channelName: a.text(),
                    type: 1,
                    channelType : 1,
                    feeType: fee(j).type,
                    feeValue: fee(j).value,
                    bondType: bond(k).type,
                    bondValue: bond(k).value
                };
                if (params.id == undefined) {
                    self.alertModelCancel('请选择合作渠道!');
                    return false;
                } else if (params.feeValue == '') {
                    self.alertModelCancel('请输入趸收手续费!');
                    return false;
                } else if (params.bondValue == '') {
                    self.alertModelCancel('请输入期收手续费!');
                    return false;
                }
                // 判断是否重复添加
                for (var i = 0; i < self.variable.introType.introType01.length; i++) {
                    var obj = self.variable.introType.introType01[i];
                    if (obj.id == params.id) {
                        self.alertModelCancel('请勿重复添加!');
                        c.trigger('click'); // 清空
                        return;
                    }
                }
                self.variable.introType.introType01.push(params);
                self.renderIntroType01();
                c.trigger('click'); // 清空
            })
            // 点击渠道进件商删除按钮
            $('#introContent01').on('click', '.delType01', function () {
                self.variable.introType.introType01.splice($(this).parents('.item').index(), 1);
                self.renderIntroType01();
            })
            // 点击引流进件选择渠道
            f.click(function () {
                alertChannelList(2);
            })
            // 点击引流进件清空
            g.on('click', function () {
                e.text('请添加产品合作渠道').removeAttr('channel-id');
                m.find('input').each(function (k, v) {
                    $(v).val('');
                })
                n.find('input').each(function (k, v) {
                    $(v).val('');
                })
            })
            // 点击引流进件新增渠道
            h.click(function () {
                var params = {
                    id: e.attr('channel-id'),
                    channelName: e.text(),
                    type: 1,
                    channelType : 2,
                    feeType: fee(m).type,
                    feeValue: fee(m).value,
                    bondType: bond(n).type,
                    bondValue: bond(n).value
                };
                if (params.id == undefined) {
                    self.alertModelCancel('请选择合作渠道!');
                    return false;
                } else if (params.feeValue == '') {
                    self.alertModelCancel('请输入趸收手续费!');
                    return false;
                } else if (params.bondValue == '') {
                    self.alertModelCancel('请输入期收手续费!');
                    return false;
                }
                // 判断是否重复添加
                for (var i = 0; i < self.variable.introType.introType02.length; i++) {
                    var obj = self.variable.introType.introType02[i];
                    if (obj.id == params.id) {
                        self.alertModelCancel('请勿重复添加!');
                        g.trigger('click'); // 清空
                        return;
                    }
                }
                self.variable.introType.introType02.push(params);
                self.renderIntroType02();
                g.trigger('click'); // 清空
            })
            // 点击引流进件商删除按钮
            $('#introContent02').on('click', '.delType02', function () {
                self.variable.introType.introType02.splice($(this).parents('.item').index(), 1);
                self.renderIntroType02();
            })
            // 点击搜索按钮搜索列表
            $('#sChannelList').click(function () {
                self.renderChannelList($.trim($('#sChannelInput').val()));
            })
            // 点击所有渠道列表选中效果
            chooseEffect();

            // 趸收手续费
            function fee(flag) {
                var obj = {type: '', value: ''};
                if ($.trim(flag.find('input[fee-type="1"]').val()) != '') { // 手续费第一个输入框值不为空
                    obj.type = 1;
                    obj.value = $.trim(flag.find('input[fee-type="1"]').val());
                } else if ($.trim(flag.find('input[fee-type="2"]').val()) != '') { // 第二个输入框不为空
                    obj.type = 2;
                    obj.value = $.trim(flag.find('input[fee-type="2"]').val());
                }
                return obj;
            }

            // 期收手续费
            function bond(flag) {
                var obj = {type: '', value: ''};
                if ($.trim(flag.find('input[bond-type="1"]').val()) != '') { // 保证金第一个输入框值不为空
                    obj.type = 1;
                    obj.value = $.trim(flag.find('input[bond-type="1"]').val());
                } else if ($.trim(flag.find('input[bond-type="2"]').val()) != '') { // 第二个输入框不为空
                    obj.type = 2;
                    obj.value = $.trim(flag.find('input[bond-type="2"]').val());
                }
                return obj;
            }

            // 点击所有列表选中效果
            function chooseEffect() {
                $('#channelListUl').on('click', 'li', function () {
                    if ($(this).hasClass('choose')) {
                        $(this).removeClass('choose');
                    } else {
                        $(this).siblings().removeClass('choose').end().addClass('choose');
                    }
                })
            }

            // 弹出渠道列表模态框
            function alertChannelList(type) {
                var modal = $('#channelListModal');
                $('#sChannelInput').val('');
                self.renderChannelList();
                $('#channelListModal').modal('show');
                $('#confirmAddIntro').off('click').on('click', function () {
                    $('#channelListUl li').each(function (k, v) {
                        if ($(this).hasClass('choose')) {
                            if (type == 1) {
                                a.text($(this).text()).attr('channel-id', $(this).attr('channel-id'));
                            } else if (type == 2) {
                                e.text($(this).text()).attr('channel-id', $(this).attr('channel-id'));
                            }
                        }
                    })
                    modal.modal('hide');
                })
            }

            // 保存
            function saveChecked(cb) {
                var params = {
                    isOwnChannel: isOwnChannel(), // 是否自主进件
                    productId: self.variable.productId,
                    channelItems: JSON.stringify(channelItems())
                }
                $.ajax({
                    url: util.getServerUrl('/product/saveProductChannelInfo'),
                    method: 'POST',
                    data: params,
                    beforeSend: function () {
                        $('#secToFir').attr('disabled', true);
                        $('#secToThird').attr('disabled', true);
                    },
                    complete: function () {
                        $('#secToFir').removeAttr('disabled');
                        $('#secToThird').removeAttr('disabled');
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            cb && cb();
                        }
                    },
                    error: function (error) {

                    }
                })

                function isOwnChannel() {
                    if ($('#introType03').is(':checked')) {
                        return 1;
                    } else {
                        return 0;
                    }
                }

                function channelItems() {
                    if ($('#introType01').is(':checked') && $('#introType02').is(':checked')) {
                        return self.variable.introType.introType01.concat(self.variable.introType.introType02);
                    } else if ($('#introType01').is(':checked')) {
                        return self.variable.introType.introType01;
                    } else if ($('#introType02').is(':checked')) {
                        return self.variable.introType.introType02;
                    } else {
                        return [];
                    }
                }
            }


        },
        // 渲染渠道配置列表
        renderChannelList: function (keyword) {
            var self = this,
                params = {productId: self.variable.productId};
            if (keyword) params.name = keyword;
            $.ajax({
                url: util.getServerUrl('/channel/channelList'),
                method: 'POST',
                data: params,
                success: function (res) {
                    if (res.status == 0) {
                        renderChannelListHtml(res.data);
                    }
                },
                error: function (error) {

                }
            })

            function renderChannelListHtml(data) {
                var str = '';
                $.each(data, function (k, v) {
                    str += '<li channel-id="' + v.id + '">' + v.name + '</li>';
                })
                $('#channelListUl').html(str);
            }
        },
        // 渲染渠道进件列表
        renderIntroType01: function () {
            var str = '';
            $.each(this.variable.introType.introType01, function (k, v) {
                str += '<div class="item">';
                str += '<div class="addedChannelTitle">';
                str += '<span class="channel-name add-channel-name">' + v.channelName + '</span>';
                str += '<button class="btn btn-default delType01">删除</button>';
                str += '</div>';
                str += '<div class="clearfix feeType">';
                str += '<i class="con-name pull-left">趸收手续费:</i>';
                str += '<div>';
                str += '<p>';
                str += '<span class="title">' + feeAndBond(v.feeType).name + '</span>';
                str += '<input disabled fee-type="2" type="text" value="' + v.feeValue + '" class="form-control text-right">' + feeAndBond(v.feeType).flag;
                str += '</p>';
                str += '</div>';
                str += '</div>';
                str += '<div class="clearfix bondType">';
                str += '<i class="con-name pull-left">期收手续费:</i>';
                str += '<div>';
                str += '<p>';
                str += '<span class="title">' + feeAndBond(v.bondType).name + '</span>';
                str += '<input disabled bond-type="3" type="text" value="' + v.bondValue + '" class="form-control text-right">' + feeAndBond(v.bondType).flag;
                str += '</p>';
                str += '</div>';
                str += '</div>';
                str += '</div>';
            })
            $('#introContent01').html(str);

            function feeAndBond(type) {
                var obj = {name: '', flag: ''};
                switch (type) {
                    case 1:
                        obj.name = '固定金额';
                        obj.flag = '元';
                        break;
                    case 2:
                        obj.name = '固定费率';
                        obj.flag = '%';
                        break;
                    case 3:
                        obj.name = '非固定费率';
                        obj.flag = '';
                        break;
                }
                return obj;
            }
        },
        // 渲染引流进件列表
        renderIntroType02: function () {
            var str = '';
            $.each(this.variable.introType.introType02, function (k, v) {
                str += '<div class="item">';
                str += '<div class="addedChannelTitle">';
                str += '<span class="channel-name add-channel-name">' + v.channelName + '</span>';
                str += '<button class="btn btn-default delType02">删除</button>';
                str += '</div>';
                str += '<div class="clearfix feeType">';
                str += '<i class="con-name pull-left">趸收手续费:</i>';
                str += '<div>';
                str += '<p>';
                str += '<span class="title">' + feeAndBond(v.feeType).name + '</span>';
                str += '<input disabled fee-type="2" type="text" value="' + v.feeValue + '" class="form-control text-right">' + feeAndBond(v.feeType).flag;
                str += '</p>';
                str += '</div>';
                str += '</div>';
                str += '<div class="clearfix bondType">';
                str += '<i class="con-name pull-left">期收手续费:</i>';
                str += '<div>';
                str += '<p>';
                str += '<span class="title">' + feeAndBond(v.bondType).name + '</span>';
                str += '<input disabled bond-type="3" type="text" value="' + v.bondValue + '" class="form-control text-right">' + feeAndBond(v.bondType).flag;
                str += '</p>';
                str += '</div>';
                str += '</div>';
                str += '</div>';
            })
            $('#introContent02').html(str);

            function feeAndBond(type) {
                var obj = {name: '', flag: ''};
                switch (type) {
                    case 1:
                        obj.name = '固定金额';
                        obj.flag = '元';
                        break;
                    case 2:
                        obj.name = '固定费率';
                        obj.flag = '%';
                        break;
                    case 3:
                        obj.name = '非固定费率';
                        obj.flag = '';
                        break;
                }
                return obj;
            }
        },
        // 渲染数据
        renderChannelData: function () {
            var self = this;
            $.ajax({
                url: util.getServerUrl('/product/productInfo'),
                method: 'POST',
                data: {id: self.variable.productId, page: 2},
                success: function (res) {
                    if (res.status == 0) {
                        renderIsOwnChannel(res.data.isOwnChannel);
                        self.variable.introType.introType01.length = 0;
                        self.variable.introType.introType02.length = 0;
                        $.each(res.data.channelItems, function (k, v) {
                            if (v.channelType == 1) {
                                $('#introType01').attr('checked', true).iCheck({
                                    checkboxClass: 'icheckbox_minimal-blue'
                                });
                                self.variable.introType.introType01.push(v);
                            } else if (v.channelType == 2) {
                                $('#introType02').attr('checked', true).iCheck({
                                    checkboxClass: 'icheckbox_minimal-blue'
                                });
                                self.variable.introType.introType02.push(v);
                            }
                        })
                        self.renderIntroType01();
                        self.renderIntroType02();
                    }
                }
            })


            // 渲染自主进件
            function renderIsOwnChannel(data) {
                if (data == 1) {
                    $('#introType03').attr('checked', true).iCheck({
                        checkboxClass: 'icheckbox_minimal-blue'
                    });
                }
            }

        },

        /**
         * 业务受理配置
         */
        // 业务受理配置初始化
        businessInit: function () {
            var self = this;
            this.getBusinessList(function () {
                self.getBusinessChecked();
            });
        },
        // 业务受理配置绑定事件
        bindBusinessEvent: function () {
            var self = this;
            // 上一步
            $('#thirdToSec').click(function () {
                saveChecked(function (res) {
                    self.channelInit();
                    $('.configuration > div').hide();
                    $('.channel-configuration').show();
                })
            })
            // 下一步
            $('#thirdToFour').click(function () {
                saveChecked(function (res) {
                    self.dealInit();
                    $('.configuration > div').hide();
                    $('.deal-configuration').show();
                })
            })

            function getRadioVal() {
                var arr = [];
                for (var k in self.radioDom) {
                    self.radioDom[k].each(function (k, v) {
                        var json = {};
                        if (this.checked) {
                            json.state = this.value;
                            json.id = $(this).attr('data-id');
                            arr.push(json);
                        }
                    })
                }
                return arr;
            }

            function saveChecked(cb) {
                var params = {
                    productId: self.variable.productId,
                    businessItems: JSON.stringify(getRadioVal())
                };
                $.ajax({
                    url: util.getServerUrl('/product/saveProductBusinessInfo'),
                    method: 'POST',
                    data: params,
                    beforeSend: function () {
                        $('#thirdToSec').attr('disabled', true);
                        $('#thirdToFour').attr('disabled', true);
                    },
                    complete: function () {
                        $('#thirdToSec').removeAttr('disabled');
                        $('#thirdToFour').removeAttr('disabled');
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            cb && cb(res);
                        }
                    }
                })
            }
        },
        // 获取业务受理配置项目并渲染(添加回调便于编辑订单渲染数据)
        getBusinessList: function (callback) {
            var self = this;
            $.ajax({
                url: util.getServerUrl('/product/listProductBusinessDictInfo'),
                method: 'POST',
                data: {productTempId: '${productTempId}'},
                success: function (res) {
                    if (res.status == 0) {
                        renderInfo(res.data)
                        // 获取渲染好的radio
                        getDom(res.data);
                        // 编辑时的赋值回调
                        callback && callback();
                        // 渲染checkRadio
                        for (var k in self.radioDom) {
                            self.radioDom[k].iCheck({
                                radioClass: 'iradio_minimal-blue',
                            });
                        }
                    } else {
                        if (res.msg == '') {
                            self.alertModelCancel('配置项请求出错，请稍后重试!');
                        } else {
                            self.alertModelCancel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    self.alertModelCancel('配置项请求出错，请稍后重试!');
                }
            })

            function renderInfo(data) {
                var baseStr = '', upStr = '', accStr = '', idStr = '';
                $.each(data, function (key, value) {
                    if (value.showType == 1) {
                        baseStr += '<thead>';
                        baseStr += '<tr>';
                        baseStr += '<th colspan="4"></th>';
                        baseStr += '<th>类型</th>';
                        baseStr += '<th>应用</th>';
                        baseStr += '</tr>';
                        baseStr += '</thead>';
                        baseStr += '<thead>';
                        baseStr += '<tr>';
                        baseStr += '<th>' + value.descption + '</th>';
                        baseStr += '<th class="col-md-2"><input checked data-id="' + value.id + '" value="1" type="radio" name="_' + value.keyword + '">必填</th>';
                        baseStr += '<th class="col-md-2"><input data-id="' + value.id + '" value="2" type="radio" name="_' + value.keyword + '">选填</th>';
                        baseStr += '<th class="col-md-2"><input data-id="' + value.id + '" value="3" type="radio" name="_' + value.keyword + '">不填</th>';
                        baseStr += '</tr>';
                        baseStr += '</thead>';
                        baseStr += '<tbody>';
                        $.each(value.items, function (k, v) {
                            baseStr += '<tr>';
                            baseStr += '<td class="col-md-3">' + v.descption + '</td>';
                            baseStr += '<td class="col-md-2"><input checked data-id="' + v.id + '" value="1" type="radio" name="_' + v.keyword + '">必填</td>';
                            baseStr += '<td class="col-md-2"><input data-id="' + v.id + '" value="2" type="radio" name="_' + v.keyword + '">选填</td>';
                            baseStr += '<td class="col-md-2"><input data-id="' + v.id + '" value="3" type="radio" name="_' + v.keyword + '">不填</td>';
                            baseStr += '<td class="shallow col-md-1">' + judgeType(v.dataType) + '</td>';
                            baseStr += '<td class="shallow col-md-2">' + switchType(v.dataType) + '</td>';
                            baseStr += '</tr>';
                        })
                    }
                    if (value.showType == 2) {
                        upStr += '<thead>';
                        upStr += '<tr>';
                        upStr += '<th colspan="4"></th>';
                        upStr += '<th>类型</th>';
                        upStr += '<th>应用</th>';
                        upStr += '</tr>';
                        upStr += '</thead>';
                        upStr += '<thead>';
                        upStr += '<tr>';
                        upStr += '<th>' + value.descption + '</th>';
                        upStr += '<th class="col-md-2"><input checked data-id="' + value.id + '" value="1" type="radio" name="_' + value.keyword + '">必填</th>';
                        upStr += '<th class="col-md-2"><input data-id="' + value.id + '" value="2" type="radio" name="_' + value.keyword + '">选填</th>';
                        upStr += '<th class="col-md-2"><input data-id="' + value.id + '" value="3" type="radio" name="_' + value.keyword + '">不填</th>';
                        upStr += '</tr>';
                        upStr += '</thead>';
                        upStr += '<tbody>';
                        $.each(value.items, function (k, v) {
                            upStr += '<tr>';
                            upStr += '<td class="col-md-3">' + v.descption + '</td>';
                            upStr += '<td class="col-md-2"><input checked data-id="' + v.id + '" value="1" type="radio" name="_' + v.keyword + '">必填</td>';
                            upStr += '<td class="col-md-2"><input data-id="' + v.id + '" value="2" type="radio" name="_' + v.keyword + '">选填</td>';
                            upStr += '<td class="col-md-2"><input data-id="' + v.id + '" value="3" type="radio" name="_' + v.keyword + '">不填</td>';
                            upStr += '<td class="shallow col-md-1">' + judgeType(v.dataType) + '</td>';
                            upStr += '<td class="shallow col-md-2">' + switchType(v.dataType) + '</td>';
                            upStr += '</tr>';
                        })
                    }
                    if (value.showType == 3) {
                        accStr += '<thead>';
                        accStr += '<tr>';
                        accStr += '<th colspan="4"></th>';
                        accStr += '<th>类型</th>';
                        accStr += '<th>应用</th>';
                        accStr += '</tr>';
                        accStr += '</thead>';
                        accStr += '<thead>';
                        accStr += '<tr>';
                        accStr += '<th>' + value.descption + '</th>';
                        accStr += '<th class="col-md-2"><input checked data-id="' + value.id + '" value="1" type="radio" name="_' + value.keyword + '">必填</th>';
                        accStr += '<th class="col-md-2"><input data-id="' + value.id + '" value="2" type="radio" name="_' + value.keyword + '">选填</th>';
                        accStr += '<th class="col-md-2"><input data-id="' + value.id + '" value="3" type="radio" name="_' + value.keyword + '">不填</th>';
                        accStr += '</tr>';
                        accStr += '</thead>';
                        accStr += '<tbody>';
                        $.each(value.items, function (k, v) {
                            accStr += '<tr>';
                            accStr += '<td class="col-md-3">' + v.descption + '</td>';
                            accStr += '<td class="col-md-2"><input checked data-id="' + v.id + '" value="1" type="radio" name="_' + v.keyword + '">必填</td>';
                            accStr += '<td class="col-md-2"><input data-id="' + v.id + '" value="2" type="radio" name="_' + v.keyword + '">选填</td>';
                            accStr += '<td class="col-md-2"><input data-id="' + v.id + '" value="3" type="radio" name="_' + v.keyword + '">不填</td>';
                            accStr += '<td class="shallow col-md-1 invisibled">' + judgeType(v.dataType) + '</td>';
                            accStr += '<td class="shallow col-md-2 invisibled">' + switchType(v.dataType) + '</td>';
                            accStr += '</tr>';
                        })
                    }
                    if (value.showType == 4) {
                        idStr += '<thead>';
                        idStr += '<tr>';
                        idStr += '<th colspan="4"></th>';
                        idStr += '<th>类型</th>';
                        idStr += '<th>应用</th>';
                        idStr += '</tr>';
                        idStr += '</thead>';
                        idStr += '<thead>';
                        idStr += '<tr>';
                        idStr += '<th>' + value.descption + '</th>';
                        idStr += '<th class="col-md-2"><input checked data-id="' + value.id + '" value="1" type="radio" name="_' + value.keyword + '">必填</th>';
                        idStr += '<th class="col-md-2"><input data-id="' + value.id + '" value="2" type="radio" name="_' + value.keyword + '">选填</th>';
                        idStr += '<th class="col-md-2"><input data-id="' + value.id + '" value="3" type="radio" name="_' + value.keyword + '">不填</th>';
                        idStr += '</tr>';
                        idStr += '</thead>';
                        idStr += '<tbody>';
                        $.each(value.items, function (k, v) {
                            idStr += '<tr>';
                            idStr += '<td class="col-md-3">' + v.descption + '</td>';
                            idStr += '<td class="col-md-2"><input checked data-id="' + v.id + '" value="1" type="radio" name="_' + v.keyword + '">必填</td>';
                            idStr += '<td class="col-md-2"><input data-id="' + v.id + '" value="2" type="radio" name="_' + v.keyword + '">选填</td>';
                            idStr += '<td class="col-md-2"><input data-id="' + v.id + '" value="3" type="radio" name="_' + v.keyword + '">不填</td>';
                            idStr += '<td class="shallow col-md-1">' + judgeType(v.dataType) + '</td>';
                            idStr += '<td class="shallow col-md-2">' + switchType(v.dataType) + '</td>';
                            idStr += '</tr>';
                        })
                    }
                })
                $('#baseTable').html(baseStr);
                $('#idTable').html(idStr);
                $('#upLoadTable').html(upStr);
                $('#accTable').html(accStr);

            }

            function switchType(dataType) {
                switch (dataType) {
                    case 1 :
                        return '字符串输入';
                        break;
                    case 2 :
                        return '图片';
                        break;
                    case 3 :
                        return 'ocr读取';
                        break;
                    case 4 :
                        return '行政区域';
                        break;
                    case 5 :
                        return '下拉框';
                        break;
                }
            }

            function judgeType(dataType) {
                return dataType == 2 ? '图片' : '文本';
            }

            function getDom(data) {
                // 大类
                for (var i = 0; i < data.length; i++) {
                    self.radioDom[data[i].keyword] = $('input[name="_' + data[i].keyword + '"]');
                }
                // 小类
                for (var i = 0; i < data.length; i++) {
                    for (var j = 0; j < data[i].items.length; j++) {
                        self.radioDom[data[i].items[j].keyword] = $('input[name="_' + data[i].items[j].keyword + '"]');
                    }
                }
            }


        },
        // 渲染已选择的项目
        getBusinessChecked: function () {
            var self = this;
            $.ajax({
                url: util.getServerUrl('/product/productInfo'),
                method: 'POST',
                data: {id: self.variable.productId, page: 3},
                success: function (res) {
                    if (res.status == 0) {
                        for (var i = 0; i < res.data.length; i++) {
                            var obj = res.data[i];
                            for (var k in self.radioDom) {
                                $.each(self.radioDom[k], function (key, val) {
                                    if ($(this).attr('data-id') == obj.id) {
                                        if ($(this).val() == obj.inputType) {
                                            $(this).attr('checked', true);
                                        }
                                    }
                                })
                            }
                        }
                        // 渲染checkRadio
                        for (var k in self.radioDom) {
                            self.radioDom[k].iCheck({
                                radioClass: 'iradio_minimal-blue',
                            });
                        }
                    }
                }
            })
        },

        /**
         * 交易配置
         */
        // 交易配置初始化
        dealInit: function () {
            var self = this;
            this.getRepayChannelUserList(function () {
                self.getRepayWay(function () {
                    self.getDealData();
                });
            })
        },
        changeEvent : function() {
            // 还款下拉框改变
            $('#repayment').change(function () {
                if($(this).val()==2 || $(this).val()==3) {
                    $('#repayment2').removeClass('hide-dom')
                    $(this).next('span').removeClass('hide-dom')
                }else{
                    $('#repayment2').addClass('hide-dom').val('')
                    $(this).next('span').addClass('hide-dom')
                }
            })
            // 收款下拉框改变
            $('#payee').change(function () {
                if($(this).val()==2) {
                    $('#payee2').removeClass('hide-dom')
                    $(this).next('span').removeClass('hide-dom')
                }else{
                    $('#payee2').addClass('hide-dom').val('')
                    $(this).next('span').addClass('hide-dom')
                }
            })
            $('#acSetting').on('change','.repay',function () {
                if($(this).val()==2) {
                    $(this).next('.repayList').removeClass('hide-dom')
                }else {
                    $(this).next('.repayList').addClass('hide-dom')
                }
            })
        },
        // 交易配置绑定事件
        bindDealEvent: function () {
            var self = this;
            // 点击还款计划表系统自动生成展示时间
            $('input[name="repaymentPlanWay"]').each(function () {
                var _this = this;
                $(this).siblings('ins').click(function () {
                    if ($(_this).val() == 0) {
                        $('#repaymentPlanWayOffsetBox').removeClass('hide');
                    } else {
                        $('#repaymentPlanWayOffsetBox').addClass('hide');
                    }
                })
            })
            this.changeEvent();
            // 增加代偿
            $('#addRepayLi').click(function () {
                self.variable.deal.count++;
                var str = '<div style="margin-bottom: 10px;" class="repay-li" data-index="'+self.variable.deal.count+'">' ;
                    str += '<i class="con-name"></i>';
                    str += '<span class="spe-width">代偿方设置:</span>';
                    str += '<select class="repay">';
                    str += ' <option value="-1">不配置</option>';
                    str += '<option value="0">借款人代偿</option>';
                    str += '<option value="1">渠道代偿</option>';
                    str += '<option value="2">指定渠道代偿</option>';
                    str += '</select>';
                    str += '<select class="repayList hide-dom">';
                    str += self.variable.channelUserList;
                    str += '</select>';
                    str += '</div>';
                self.variable.deal.repayList.push({id: '', repayRole: -1, repayOrder: self.variable.deal.count,accountId:''})
                $('.repay-li-wrap').append(str)
            })
            // 删除代偿
            $('#removeRepayLi').click(function() {
                if(self.variable.deal.repayList.length <=1)return;
                self.variable.deal.repayList.pop()
                $('.repay-li-wrap > div').last().remove()
                self.variable.deal.count--
            })
            $('#acSetting').on('change','select.repay',function() {
                var index = $(this).parent('.repay-li').attr('data-index');
                self.variable.deal.repayList[index]['repayRole'] = $(this).val()
            })
            $('#acSetting').on('change','select.repayList',function() {
                var index = $(this).parent('.repay-li').attr('data-index');
                self.variable.deal.repayList[index]['accountId'] = $(this).val()
            })

            // 上一步
            $('#fourTothird').click(function () {
                if (self.variable.iTFlag) {
                    // 为引流进件 跳过第三页
                    saveChecked(function () {
                        self.channelInit();
                        $('.configuration > div').hide();
                        $('.channel-configuration').show();
                    })
                } else {
                    saveChecked(function () {
                        self.businessInit();
                        $('.configuration > div').hide();
                        $('.business-configuration').show();
                    })
                }

            })
            // 下一步
            $('#fourToFive').click(function () {
                saveChecked(function () {
                    self.processInit();
                    $('.configuration > div').hide();
                    $('.process-configuration').show();
                })
            })

            function saveChecked(cb) {
                var params = {
                    productId: self.variable.productId,
                    pdTransactionId: self.variable.deal.pdTransactionId,
                    repaymentPlanWay: self.getCheckboxItem('repaymentPlanWay')[0],
                    repaymentPlanDayOffset: getRepayDay(),
                    repayWay: self.getCheckboxItem('repayWay').join(','),
                    fixedInterestRate: Number($.trim($('#fixedInterestRate').val())),
                    serviceCharge: Number($.trim($('#serviceCharge').val())), // 趸收
                    serviceChargeTerm: Number($.trim($('#serviceChargeTerm').val())), // 期收
                    drawingControl: self.getCheckboxItem('drawingControl')[0],
                    isPrepaySup: self.getCheckboxItem('isPrepaySup')[0],
                    isPenaltySup: self.getCheckboxItem('isPenaltySup')[0],
                    isOnlineSign: self.getCheckboxItem('isOnlineSign')[0],
                    contractGenerationType: self.getCheckboxItem('contractGenerationType')[0],
                    payeeItem: JSON.stringify(payee()), // 收款人
                    repayItems: JSON.stringify(repay()), // 代偿
                    repaymentItems : JSON.stringify(repayment()) // 还款账户
                };

                if (self.getCheckboxItem('repayWay').length == 0) {
                    self.alertModelCancel('请选择还款方式');
                    return;
                }

                $.ajax({
                    url: util.getServerUrl('/product/saveProductTransactionInfo'),
                    method: 'POST',
                    data: params,
                    beforeSend: function () {
                        $('#fourTothird').attr('disabled', true);
                        $('#fourToFive').attr('disabled', true);
                    },
                    complete: function () {
                        $('#fourTothird').removeAttr('disabled');
                        $('#fourToFive').removeAttr('disabled');
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            cb && cb(res);
                        } else {
                            self.alertModelCancel(res.msg);
                        }
                    },
                    error: function (error) {
                        self.alertModelCancel('保存失败!');
                    }
                })
            }

            // 代偿
            function repay() {
                return self.variable.deal.repayList
            }

            // 收款人
            function payee() {
                return {
                    id: self.variable.deal.payeeObj.id == undefined ? '' : self.variable.deal.payeeObj.id,
                    payeeType: $('#payee').val(),
                    payeeRole: $('#payee').val(),
                    accountId : $('#payee2').val()
                }
            }
            // 还款人
            function repayment() {
                return {
                    id: self.variable.deal.repaymentObj.id == undefined ? '' : self.variable.deal.repaymentObj.id,
                    repaymentType: $('#repayment').val(),
                    repaymentRole: $('#repayment').val(),
                    accountId : $('#repayment2').val()
                }
            }


            // 获取系统计划还款表时间
            function getRepayDay() {
                if ($.trim($('#repaymentPlanWayOffset').val()) == '') {
                    return 0;
                } else {
                    return String($('#repaymentPlanWayOffsetBox select').val() + $.trim($('#repaymentPlanWayOffset').val()));
                }
            }

        },
        // 获取还款方式
        getRepayWay: function (cb) {
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType'),
                data: {type: 'WDCPHKFS'},
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        renderRepayWay(res.data);
                        cb && cb();
                    }
                }
            })

            function renderRepayWay(data) {
                var str = '';
                for (var i = 0; i < data.length; i++) {
                    str += '<label>';
                    str += '<input name="repayWay" type="checkbox" value="' + data[i].value + '">' + data[i].labelText;
                    str += '</label>';
                }
                $('#repayWay sub').html(str);
                var repayWay = $('input[name="repayWay"]');// 还款方式
                repayWay.iCheck({
                    checkboxClass: 'icheckbox_minimal-blue',
                });
            }
        },
        // 获取渲染数据
        getDealData: function () {
            var self = this;
            $.ajax({
                url: util.getServerUrl('/product/productInfo'),
                method: 'POST',
                data: {id: self.variable.productId, page: 4},
                success: function (res) {
                    if (res.status == 0) {
                        if (res.data.njProductTransaction.pdTransactionId) {
                            self.variable.deal.pdTransactionId = res.data.njProductTransaction.pdTransactionId;
                        }
                        if (res.data.payeeObj != '') {
                            self.variable.deal.payeeObj = res.data.payeeObj;
                        }
                        if (res.data.repaymentObj != '') {
                            self.variable.deal.repaymentObj = res.data.repaymentObj;
                        }
                        if (res.data.repayList.length != 0) {
                            self.variable.deal.repayList = res.data.repayList;
                        }
                        renderRadioInfo(res.data.njProductTransaction);
                        renderPayment(res.data.njProductTransaction.repayWay);
                        renderSerRate(res.data.njProductTransaction);
                        renderPayee(res.data.payeeObj); // 收款人
                        renderRepay(res.data.repayList); // 代偿
                        renderRepayment(res.data.repaymentObj); // 还款人
                    }
                }
            })

            // 渲染单选框内容
            function renderRadioInfo(data) {
                for (var k in self.dealDom) {
                    self.dealDom[k].each(function () {
                        if ($(this).val() == data[k]) {
                            $(this).attr('checked', true);
                        }
                    })
                    self.dealDom[k].iCheck({
                        radioClass: 'iradio_minimal-blue',
                    });
                }
                // 如果系统自动生成选项选中，则显示计划表
                if ($('#repaymentPlanWay input[value="0"]').is(':checked')) {
                    if (data.repaymentPlanDayOffset != 0) {
                        if (data.repaymentPlanDayOffset > 0) { // 如果返回正数 则手动添加+
                            $('#repaymentPlanWayOffsetBox select').val('+');
                            $('#repaymentPlanWayOffset').val(data.repaymentPlanDayOffset);
                        } else {
                            $('#repaymentPlanWayOffsetBox select').val('-');
                            $('#repaymentPlanWayOffset').val(Math.abs(data.repaymentPlanDayOffset));
                        }
                    }
                    $('#repaymentPlanWayOffsetBox').removeClass('hide');
                }
                // 由于重新渲染了dom 所以必须重新绑定事件
                $('input[name="repaymentPlanWay"]').each(function () {
                    var _this = this;
                    $(this).siblings('ins').click(function () {
                        if ($(_this).val() == 0) {
                            $('#repaymentPlanWayOffsetBox').removeClass('hide');
                        } else {
                            $('#repaymentPlanWayOffsetBox').addClass('hide');
                        }
                    })
                })
            }

            // 渲染还款方式
            function renderPayment(data) {
                if (data != '') {
                    var repayWay = data.split(',');
                    for (var i = 0; i < repayWay.length; i++) {
                        $('#repayWay input[name="repayWay"]').each(function () {
                            if ($(this).val() == repayWay[i]) {
                                $(this).attr('checked', true);
                            }
                        })
                    }
                    var repayWay = $('input[name="repayWay"]');// 还款方式
                    repayWay.iCheck({
                        checkboxClass: 'icheckbox_minimal-blue',
                    });
                }
            }

            // 渲染收款人设置
            function renderPayee(data) {
                $('#payee').val(data.payeeRole);
                $('#payee2').val(data.userId);
                if(data.payeeRole==2) {
                    $('#payee').next('span').removeClass('hide-dom')
                    $('#payee2').removeClass('hide-dom')
                }
            }

            // 渲染还款人设置
            function renderRepayment(data) {
                $('#repayment').val(data.repayRole);
                $('#repayment2').val(data.userId)
                if(data.repayRole==2 || data.repayRole==3) {
                    $('#repayment').next('span').removeClass('hide-dom')
                    $('#repayment2').removeClass('hide-dom')
                }
            }

            // 渲染代偿设置
            function renderRepay(data) {
                self.variable.deal.count = typeof data == 'string' ? 0 : data.length-1 ;
                var str = '';

                if(data.length != 0) {

                    for (var i = 0; i < data.length; i++) {
                        str += '<div style="margin-bottom: 10px;" class="repay-li" data-index="'+i+'">' ;
                        str += '<i class="con-name"></i>';
                        str += '<span class="spe-width">代偿方设置:</span>';
                        str += '<select class="repay">';
                        str += ' <option value="-1" '+ (data[i].repayRole==-1?"selected" : " ")+'>不配置</option>';
                        str += '<option value="0" '+ (data[i].repayRole==0?"selected" : " ")+'>借款人代偿</option>';
                        str += '<option value="1" '+ (data[i].repayRole==1?"selected" : " ")+'>渠道代偿</option>';
                        str += '<option value="2" ' + (data[i].repayRole==2?"selected" : " ")+'>指定渠道代偿</option>';
                        str += '</select>';
                        str += '<select class="repayList '+ (data[i].repayRole!=2?"hide-dom":" ") +'">';
                        str += self.variable.channelUserList;
                        str += '</select>';
                        str += '</div>';
                    }
                    $('.repay-li-wrap').html(str)
                    for (var k = 0; k < data.length; k++) {
                        $('.repay-li').eq(k).find('.repayList').val(data[k]['userId'])
                    }
                }
            }

            // 渲染服务费率等
            function renderSerRate(data) {
                $('#fixedInterestRate').val(data.fixedInterestRate);
                $('#serviceCharge').val(data.serviceCharge);
                $('#serviceChargeTerm').val(data.serviceChargeTerm);
            }


        },
        // 获取代偿账户设置
        getRepayChannelUserList : function(cb){
            var _this = this
            $.ajax({
                url: util.getServerUrl('/common/getRepayChannelUserList'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        renderList(res.data);
                        cb&&cb();
                    }
                },
                error : function (error) {

                }
            })
            function renderList(data) {
                var str = '<option value="">-请选择-</option>'
                for (var i = 0,len=data.length; i < len; i++) {
                    str += '<option value="'+data[i].repayAccountId+'">'+data[i].name+'</option>'
                }
                // $('#repay1').html(str);
                $('#repayment2').html(str)
                $('#payee2').html(str)
                $('.repayList').html(str)
                _this.variable.channelUserList = str
            }
        },

        /**
         * 流程配置
         */
        // 流程配置初始化
        processInit: function () {
            var self = this;
            self.getProcessData();
        },
        // 流程配置绑定事件
        bindProcessEvent: function () {
            var self = this;
            var a = self.processDom.processCheckBox,
                b = self.processDom.processRadio,
                c = self.variable.processLine;
            // 上一步
            $('#fiveToFour').click(function () {
                saveChecked(function () {
                    self.dealInit();
                    $('.configuration > div').hide();
                    $('.deal-configuration').show();
                })
            })
            // 保存
            $('#saveProduct').click(function () {
                saveChecked(function () {
                    self.alertModelCancel('产品保存成功!');
                    $('#myModal_cancel').on('hidden.bs.modal', function (e) {
                        $("#navTab").load('<%=basePath%>product/listProductPage');
                    })
                })
            })
            // 点击决策引擎启动启用后面规则
            $('#engine').siblings('ins').on('click', function () {
                if ($('#engine').is(':checked')) {
                    $('#engineMethod').val('phkjDecisionEngineService');
                } else {
                    $('#engineMethod').val('');
                }
            })
            // 点击分单启用
            $('#shuntSwitch').siblings('ins').on('click', function () {
                if ($('#shuntSwitch').is(':checked')) {
                    $('.assign-bill').addClass('go-show');
                } else {
                    $('.assign-bill').removeClass('go-show');
                }
            })
            // 点击生成流程图
            $('#creatProcess').click(function () {
                var str = '';
                c.length = 0; // 清空流程图数组
                if (b.start.is(':checked')) {
                    c.push(b.start.attr('data-name'));
                }
                if (a.engine.is(':checked')) {
                    c.push(a.engine.attr('data-name'));
                }
                if (a.shuntSwitch.is(':checked')) {
                    b.shunt.each(function () {
                        if ($(this).is(':checked')) {
                            c.push($(this).attr('data-name'));
                        }
                    })
                }
                if (a.firstCheck.is(':checked')) {
                    c.push(a.firstCheck.attr('data-name'));
                }
                if (a.againCheck.is(':checked')) {
                    c.push(a.againCheck.attr('data-name'));
                }
                if (a.finalCheck.is(':checked')) {
                    c.push(a.finalCheck.attr('data-name'));
                }
                if (a.userConfirm.is(':checked')) {
                    c.push(a.userConfirm.attr('data-name'));
                }
                if (a.sendMark.is(':checked')) {
                    c.push(a.sendMark.attr('data-name'));
                }
                if (a.autoLoan.is(':checked')) {
                    c.push(a.autoLoan.attr('data-name'));
                }
                if (b.finish.is(':checked')) {
                    c.push(b.finish.attr('data-name'));
                }
                for (var i = 0; i < c.length; i++) {
                    str += '<li>';
                    str += '<span class="normal">' + c[i] + '</span>';
                    str += '</li>';
                    str += '<li class="process ' + (i == c.length - 1 ? "hide" : "") + '"></li>';
                }
                $('#step_process').html(str);
                $('.steps').addClass('show');


            })


            function saveChecked(cb) {
                var items = [], params;

                // 开始
                getValue(b.start, 'startNext', '开始');
                // 决策引擎
                if (a.engine.is(':checked')) {
                    items.push({
                        processId: a.engine.val(),
                        execOrders: a.engine.attr('execOrders'),
                        execAgreeStatus: $('#engineNext').val(),
                        execFunction: $('#engineMethod').val(),
                        processName: '决策引擎'
                    })
                }
                // 分单
                if (a.shuntSwitch.is(':checked')) {
                    b.shunt.each(function () {
                        if ($(this).is(':checked')) {
                            items.push({
                                processId: $(this).val(),
                                execOrders: $(this).attr('execOrders'),
                                execAgreeStatus: $('#shuntNext').val(),
                                execFunction: $('#shuntMethod').val(),
                                processName: $(this).attr('data-name')
                            })
                        }
                    })
                }
                // 初审
                getValue(a.firstCheck, 'firstNext', '初审');
                // 复审
                getValue(a.againCheck, 'againNext', '复审');
                // 终审
                getValue(a.finalCheck, 'finalNext', '终审');
                // 用户确认
                getValueEx(a.userConfirm, 'userConfirmNext', 'userConfirm', '用户确认');
                // 发标
                getValueEx(a.sendMark, 'sendMarkNext', 'sendMark', '发标');
                // 放款
                getValue(a.autoLoan, 'autoLoanNext', '放款');
                // 结束
                if (b.finish.is(':checked')) {
                    items.push({
                        processId: b.finish.val(),
                        execOrders: b.finish.attr('execOrders'),
                        execAgreeStatus: '99',
                        execFunction: '',
                        processName: '结束'
                    })
                }
                params = {
                    productId: self.variable.productId,
                    processItems: JSON.stringify(items),
                    templateId: b.start.attr('template-id')
                }
                $.ajax({
                    url: util.getServerUrl('/product/saveProductProcess'),
                    method: 'POST',
                    data: params,
                    beforeSend: function () {
                        $('#fiveToFour').attr('disabled', true);
                        $('#saveProduct').attr('disabled', true);
                    },
                    complete: function () {
                        $('#fiveToFour').removeAttr('disabled');
                        $('#saveProduct').removeAttr('disabled');
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            cb && cb();
                        } else {
                            self.alertModelCancel(res.msg);
                        }
                    }
                })


                function getValue($dom, id, processName) {
                    if ($dom.is(':checked')) {
                        items.push({
                            processId: $dom.val(),
                            execOrders: $dom.attr('execOrders'),
                            execAgreeStatus: $('#' + id).val(),
                            execFunction: '',
                            processName: processName
                        })
                    }
                }

                function getValueEx($dom, id, select, processName) {
                    if ($dom.is(':checked')) {
                        items.push({
                            processId: $dom.val(),
                            execOrders: $dom.attr('execOrders'),
                            execAgreeStatus: $('#' + id).val(),
                            execFunction: $('#' + select).val(),
                            processName: processName
                        })
                    }
                }

            }
        },
        // 获取下一步动作
        getNextStep: function (cb) {
            var self = this;
            $.ajax({
                url: util.getServerUrl('/common/getOrderStatusList'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        renderStep(res.data.orderStatus);
                        // 设置下一步初始默认值
                        $('#startNext').val('1');
                        $('#engineNext').val('2');
                        $('#shuntNext').val('3');
                        $('#firstNext').val('5');
                        $('#againNext').val('51');
                        $('#finalNext').val('7');
                        $('#userConfirmNext').val('9');
                        $('#sendMarkNext').val('11');
                        $('#autoLoanNext').val('12');
                        cb && cb();
                    }
                }
            })

            function renderStep(data) {
                var str = '<option value="">--下一步动作--</option>';
                for (var k in data) {
                    str += '<option value="' + k + '">' + data[k] + '</option>';
                }
                $('.next-step').html(str);
            }
        },
        // 渲染流程配置数据
        getProcessData: function () {
            var self = this;
            var a = this.processDom.processCheckBox,
                b = this.processDom.processRadio;
            $.ajax({
                url: util.getServerUrl('/product/productInfo'),
                method: 'POST',
                data: {id: self.variable.productId, page: 5},
                success: function (res) {
                    if (res.status == 0) {
                        renderData(res.data);
                    }
                }
            })

            function renderData(data) {
                for (var i = 0; i < data.length; i++) {
                    switch (data[i].processId) {
                        case 1 :
                            b.start.attr('template-id', data[i].templateId);
                            b.start.attr('checked', true);
                            $('#startNext').val(data[i].execAgreeStatus);
                            break;
                        case 2:
                            a.engine.attr('checked', true);
                            $('#engineNext').val(data[i].execAgreeStatus);
                            $('#engineMethod').val(data[i].execFunction);
                            break;
                        case 3 :
                            a.shuntSwitch.attr('checked', true);
                            b.shunt.eq(0).attr('checked', true);
                            $('.assign-bill').addClass('go-show');
                            $('#shuntNext').val(data[i].execAgreeStatus);
                            $('#shuntMethod').val(data[i].execFunction);
                            break;
                        case 4 :
                            a.shuntSwitch.attr('checked', true);
                            b.shunt.eq(1).attr('checked', true);
                            $('.assign-bill').addClass('go-show');
                            $('#shuntNext').val(data[i].execAgreeStatus);
                            $('#shuntMethod').val(data[i].execFunction);
                            break;
                        case 5 :
                            a.firstCheck.attr('checked', true);
                            $('#firstNext').val(data[i].execAgreeStatus);
                            break;
                        case 6 :
                            a.againCheck.attr('checked', true);
                            $('#againNext').val(data[i].execAgreeStatus);
                            break;
                        case 7 :
                            a.finalCheck.attr('checked', true);
                            $('#finalNext').val(data[i].execAgreeStatus);
                            break;
                        case 9 :
                            a.userConfirm.attr('checked', true);
                            $('#userConfirmNext').val(data[i].execAgreeStatus);
                            $('#userConfirm').val(data[i].execFunction);
                            break;
                        case 10 :
                            a.sendMark.attr('checked', true);
                            $('#sendMarkNext').val(data[i].execAgreeStatus);
                            $('#sendMark').val(data[i].execFunction);
                            break;
                        case 11 :
                            a.autoLoan.attr('checked', true);
                            $('#autoLoanNext').val(data[i].execAgreeStatus);
                            break;
                        case 99 :
                            b.finish.attr('checked', true);
                            break;

                    }
                }
                for (var k in a) {
                    a[k].iCheck({
                        checkboxClass: 'icheckbox_minimal-blue',
                    });
                }
                for (var k in b) {
                    b[k].iCheck({
                        radioClass: 'iradio_minimal-blue',
                    });
                }
                $('#engine').siblings('ins').on('click', function () {
                    if ($('#engine').is(':checked')) {
                        $('#engineMethod').val('phkjDecisionEngineService');
                    } else {
                        $('#engineMethod').val('');
                    }
                })
                $('#shuntSwitch').siblings('ins').on('click', function () {
                    if ($('#shuntSwitch').is(':checked')) {
                        $('.assign-bill').addClass('go-show');
                    } else {
                        $('.assign-bill').removeClass('go-show');
                    }
                })

            }
        },


        // 渲染checkbox
        renderCheckBox: function () {
            /**
             * 基本配置
             */
            var allSelect = $('#allSelect'),
                periodChecks = $('input[name="borrowDeatline"]'), // 展示出来的checkbox
                allCountry = $('input[name="allCountry"]'), // 授信地区勾选全国的checkbox
                showCity = $('input[name="showCity"]'), // 授信地区勾选精确到市的checkbox
                ensureWay = $('input[name="ensureWay"]');// 借款类型的radio
            periodChecks.iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
            });
            allCountry.iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
            });
            showCity.iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
            });
            ensureWay.iCheck({
                radioClass: 'iradio_minimal-blue',
            });
            allSelect.on('ifChanged', function (event) {
                if ($(this).is(':checked')) {
                    periodChecks.iCheck("check");
                } else {
                    periodChecks.iCheck("uncheck");
                }
            });
            /**
             * 渠道配置
             */
            var introType = $('input[name="introType"]'); // 进件类型
            introType.iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
            });
            /**
             * 交易配置
             */
            for (var k in this.dealDom) {
                this.dealDom[k].iCheck({
                    radioClass: 'iradio_minimal-blue',
                });
            }
            /**
             * 流程配置
             */
            for (var k in this.processDom.processCheckBox) {
                this.processDom.processCheckBox[k].iCheck({
                    checkboxClass: 'icheckbox_minimal-blue',
                });
            }
            for (var k in this.processDom.processRadio) {
                this.processDom.processRadio[k].iCheck({
                    radioClass: 'iradio_minimal-blue',
                });
            }


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
        // 单独为更多期数获取checkbox值
        getMorePeriod: function (name) {
            var arr = [];
            var ids = $('input[name="' + name + '"]');
            ids.each(function () {
                var json = {};
                if (this.checked) {
                    json.labelText = $(this).attr('period-text');
                    json.value = $(this).val();
                    json.id = $(this).attr('id');
                    arr.push(json);
                }
            })
            return arr;
        },
        // 判断节点是否存在
        exist: function ($dom) {
            if ($dom.length >= 1) {
                return true;
            }
            return false;
        },
        // 模态框1弹出
        alertModelCancel: function (str) {
            $('#myModal_cancel .modal-body').empty();
            $('#myModal_cancel .modal-body').html('<p>' + str + '</p>');
            $('#myModal_cancel').modal('show');
        },
    }
    $(function () {
        product.init();
    })
</script>