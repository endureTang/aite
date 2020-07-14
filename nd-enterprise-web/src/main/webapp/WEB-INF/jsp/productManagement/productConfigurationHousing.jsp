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
                <jsp:include page="./steps.jsp"></jsp:include>
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
                                    <span class="red-tag">注：借款主体为“个人”，为 0元 < 借款金额 <= 2,000,000元；借款主体为“机构”，为 0元 < 借款金额 <= 1,000,000元</span>
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
                                    <!--<label for="borrowUse01"><input type="radio" name="borrowUse" id="borrowUse01" value="消费">消费</label>-->
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
                                                    <p class="hide-dom">
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
                                                    <p class="hide-dom">
                                                        <span class="title">非固定费率</span>
                                                        <input fee-type="3" type="text" class="form-control text-right">
                                                        <span class="red-tag sepcial-left">注：计算公式</span>
                                                    </p>
                                                </div>
                                            </div>
                                            <div id="type01bondType" class="clearfix bondType">
                                                <i class="con-name pull-left">期收手续费:</i>
                                                <div>
                                                    <p class="hide-dom">
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
                                                    <p class="hide-dom">
                                                        <span class="title">非固定费率</span>
                                                        <input bond-type="3" type="text"
                                                               class="form-control text-right">
                                                        <span class="red-tag sepcial-left">注：计算公式</span>
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
                            <!--<div class="btns">-->
                            <!--<button id="secToFir" class="btn btn-mine">上一步</button>-->
                            <!--<button id="secToThird" class="btn btn-mine">下一步</button>-->
                            <!--</div>-->
                        </div>
                        <div style="width: 100%;height: 30px;background-color: #eee;"></div>
                        <div class="panel-heading">
                            <h3 class="panel-title">资金渠道配置</h3>
                        </div>
                        <div class="panel-body">
                            <ul>
                                <li id="mIntroType">
                                    <i class="con-name">资金渠道: </i>
                                    <s><input id="zjqdRadio1" type="radio" name="mIntroType"
                                              value="1">是</s>
                                    <s><input type="radio" name="mIntroType"
                                              value="0">否</s>
                                    <span id="redhint" class="red-tag">提示：贵公司尚未开通联合贷业务，不可配置资金渠道</span>
                                </li>
                           
                            </ul>
                            <ul class="introType" id="mIntroTypeBox">
                                <li>
                                    <i class="con-name">资金渠道:</i>
                                    <div>
                                        <div class="operate">
                                            <div>
                                                <span class="channel-name" id="mIntroTypeName">请添加产品资金合作渠道</span>
                                                <button class="btn btn-mine" id="mChooseChannel">选择资金渠道</button>
                                                <button class="btn btn-default" id="mClear">清空</button>
                                            </div>
                                            <button class="btn btn-mine" id="addMIntroType">保存</button>
                                        </div>
                                        <div class="introTypeContent">
                                            <div class="oContent" id="mIntroContent">
                                                <!--<div class="item">-->
                                                    <!--<div class="addedChannelTitle">-->
                                                        <!--<span class="channel-name add-channel-name">渠道1</span>-->
                                                        <!--<button class="btn btn-default delType">删除</button>-->
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
                                    <s><input type="radio" name="repaymentPlanWay" value="0">系统自动生成</s>
                                    <s><input type="radio" name="repaymentPlanWay" value="2">用户指定日期</s>
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
                                <li class="hide" id="repaymentPlanWayOffsetDayBox">
                                    <i class="con-name">还款计划表生成时间:</i>
                                    用户指定日期<input style="margin: 0 10px;" value="0" class="form-control text-right"
                                                 type="number"
                                                 id="repaymentPlanWayOffsetDay">日
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
                                    <i class="con-name">产品月利率:</i>
                                    <input type="number" class="form-control text-right" id="fixedInterestRate">%
                                </li>
<!--                                <li>-->
<!--                                    <i class="con-name">发标上限额度:</i>-->
<!--                                    <input type="number" class="form-control text-right" id="maxAmount">(万元)-->
<!--                                </li>-->
                                <li class="hide-dom">
                                    <i class="con-name">服务费率:</i>
                                    <input value="0" type="number" class="form-control text-right" id="serviceCharge">%
                                </li>
                            </ul>
                            <ul>
                                <li class="hide-dom">
                                    <i class="con-name">提款控制:</i>
                                    <s><input checked type="radio" name="drawingControl" value="1">控制</s>
                                    <s><input type="radio" name="drawingControl" value="0">不控制</s>
                                </li>
                                <li>
                                    <i class="con-name">提前还款:</i>
                                    <s><input checked type="radio" name="isPrepaySup" value="1">是</s>
                                    <s><input type="radio" name="isPrepaySup" value="0">否</s>
                                </li>
                                <li class="hide-dom">
                                    <i class="con-name">罚息:</i>
                                    <s><input checked type="radio" name="isPenaltySup" value="1">是</s>
                                    <s><input type="radio" name="isPenaltySup" value="0">否</s>
                                </li>
                                <li>
                                    <i class="con-name">用户确认:</i>
                                    <s><input checked type="radio" name="isOnlineSign" value="1">是</s>
                                    <s><input type="radio" name="isOnlineSign" value="0">否</s>
                                </li>
                                <li class="hide-dom">
                                    <i class="con-name">合同生成方式:</i>
                                    <s><input checked type="radio" name="contractGenerationType" value="1">系统生成</s>
                                    <s><input disabled type="radio" name="contractGenerationType" value="2">审批上传</s>
                                </li>
                                <li>
                                    <i class="con-name">自有资金放款通道:</i>
                                    <s><input checked type="radio" name="ownLoanType" value="1">系统放款</s>
                                    <s><input type="radio" name="ownLoanType" value="2">体外放款</s>
                                </li>
                                <li>
                                    <i class="con-name">渠道资金放款通道:</i>
                                    <s><input checked type="radio" name="channelLoanType" value="1">系统放款</s>
                                    <s><input type="radio" name="channelLoanType" value="2">体外放款</s>
                                </li>
                                <li>
                                    <i class="con-name">自有资金回款通道:</i>
                                    <s><input checked type="radio" name="ownPaybackType" value="1">系统回款</s>
                                    <s><input type="radio" name="ownPaybackType" value="2">体外回款</s>
                                </li>
                                <li>
                                    <i class="con-name">渠道资金回款通道:</i>
                                    <s><input disabled="disabled" type="radio" name="channelPaybackType" value="1">系统回款</s>
                                    <s><input checked type="radio" name="channelPaybackType" value="2">体外回款</s>
                                </li>
                            </ul>
                            <ul class="hide-dom">
                                <li>
                                    <i class="con-name">还款人设置:</i>
                                    <span class="spe-width">第一还款人:</span>
                                    <select name="" id="repay1">
                                        <option value="-1">不配置</option>
                                        <option selected value="0">借款人还款</option>
                                        <option value="1">渠道还款</option>
                                    </select>
                                    <span class="spe-width">第二还款人(选填):</span>
                                    <select name="" id="repay2">
                                        <option value="-1">不配置</option>
                                        <option value="0">借款人还款</option>
                                        <option value="1">渠道还款</option>
                                    </select>
                                </li>
                                <li>
                                    <i class="con-name">收款人设置:</i>
                                    <span class="spe-width">收款人:</span>
                                    <select name="" id="payee">
                                        <option value="-1">不配置</option>
                                        <option selected value="0">借款人收款</option>
                                        <option value="1">渠道收款</option>
                                    </select>
                                </li>
                            </ul>
                            <div class="deal-btns">
                                <button id="fourTothird" class="btn btn-mine">上一步</button>
                                <button id="fourToFive" class="btn btn-mine">下一步</button>
                            </div>
                        </div>
                    </div>
                    <!--费用配置-->
                    <div class="panel panel-info money-configuration">
                        <div style="display: none;" class="panel-heading">
                            <h3 class="panel-title">还款计划费用项配置</h3>
                        </div>
                        <div style="display: none;" class="panel-body">
                            <ul class="money-configuration-content repayFeeItems" data-type="1" data-classify=".repayFeeItems">

                            </ul>
                        </div>
                        <div  style="width: 100%;height: 30px;background-color: #eee;display: none;"></div>
                        <div class="panel-heading">
                            <h3 class="panel-title">回款计划费用项配置</h3>
                        </div>
                        <div class="panel-body">
                            <ul class="money-configuration-content payBakFeeItems" data-type="2" data-classify=".payBakFeeItems">

                            </ul>
                            <ul class="isAutoDeduct">
                                <li>
                                    <i class="con-name">逾期是否自动扣款:</i>
                                    <s><input checked type="radio" name="isOverdueAutoDeduct" value="1">是</s>
                                    <s><input type="radio" name="isOverdueAutoDeduct" value="0">否</s>
                                </li>
                            </ul>
                            <div class="deal-btns">
                                <button id="fiveToFour" class="btn btn-mine">上一步</button>
                                <button id="fiveToSix" class="btn btn-mine">下一步</button>
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
                                    <input checked type="radio" name="processRadioStart" data-name="启动流程">
                                    <span>开始</span>
                                </li>
                                <li>
                                    <i class="con-name">订单初始化:</i>
                                    <input checked type="checkbox" name="processCheckbox" data-name="订单初始化">
                                    <span>订单初始化</span>
                                </li>
                                <li>
                                    <i class="con-name">业务调查:</i>
                                    <input checked type="checkbox" name="processCheckbox" data-name="进件预审">
                                    <span>进件预审(客服经理)</span>
                                </li>
                                <li class="clearfix business-reply">
                                    <i class="con-name pull-left">订单审批流程:</i>
                                    <div>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="初审">
                                            <span>初审(部门经理)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="分单">
                                            <span>分单(风控经理)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="复审">
                                            <span>复审1(风控专员)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="有权审批人判定">
                                            <span>有权审批人判定</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="风控经理复审">
                                            <span>复审2(风控经理)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="风控总监复审">
                                            <span>复审3(风控总监)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="终审">
                                            <span>终审(有权审批人)</span>
                                        </p>
                                    </div>
                                </li>
                                <li class="clearfix business-reply">
                                    <i class="con-name pull-left">合同审核:</i>
                                    <div>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="合同制作">
                                            <span>合同制作</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="合同审核">
                                            <span>合同审核(法务审)</span>
                                        </p>
                                    </div>
                                </li>
                                <li class="clearfix business-reply">
                                    <i class="con-name pull-left">放款审批流程:</i>
                                    <div>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="发起放款">
                                            <span>发起放款流程</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="放款初审">
                                            <span>放款初审(部门经理)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="放款专员复审">
                                            <span>放款复审1(放款专员)</span>
                                        </p>
                                    </div>
                                </li>
                                <li class="clearfix business-reply">
                                    <i class="con-name pull-left">财务放款:</i>
                                    <div>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="风控经理复审">
                                            <span>放款复审2(风控经理)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="有权审批人判定">
                                            <span>有权审批人判定</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="风控总监复审">
                                            <span>放款复审3(风控总监)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="有权审批人终审">
                                            <span>放款终审(有权审批人)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="财务放款审查">
                                            <span>放款审查(财务专员)</span>
                                        </p>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="财务经理复核">
                                            <span>放款复核(财务经理)</span>
                                        </p>
                                    </div>
                                </li>
                                <li class="clearfix business-reply">
                                    <i class="con-name pull-left">自动放款:</i>
                                    <div>
                                        <p>
                                            <input checked type="checkbox" name="processCheckbox" data-name="自动放款">
                                            <span>自动放款</span>
                                        </p>
                                    </div>
                                </li>
                                <li>
                                    <i class="con-name">流程结束:</i>
                                    <input checked type="radio" name="processRadioEnd" data-name="流程结束">
                                    <span>结束</span>
                                    <button class="btn btn-mine creat-product-process" id="creatProcess">
                                        生成产品审批流程
                                    </button>
                                </li>
                            </ul>
                            <div class="steps">
                                <ul class="clearfix" id="step_process"></ul>
                            </div>
                            <div class="process-btns">
                                <button id="sixToFive" class="btn btn-mine">上一步</button>
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
    Number.prototype.div = function (arg) { // 除法
        return accDiv(this, arg);
    }
    Number.prototype.mul = function (arg) { // 乘法
        return accMul(arg, this);
    }

    function accDiv(arg1, arg2) {
        var t1 = 0, t2 = 0, r1, r2;
        try {
            t1 = arg1.toString().split(".")[1].length
        } catch (e) {
        }
        try {
            t2 = arg2.toString().split(".")[1].length
        } catch (e) {
        }
        with (Math) {
            r1 = Number(arg1.toString().replace(".", ""))
            r2 = Number(arg2.toString().replace(".", ""))
            return (r1 / r2) * pow(10, t2 - t1);
        }
    }

    function accMul(arg1, arg2) {
        var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
        try {
            m += s1.split(".")[1].length
        } catch (e) {
        }
        try {
            m += s2.split(".")[1].length
        } catch (e) {
        }
        return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m)
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
            // 渠道配置-渠道进件和引流进件,资金渠道
            introType: {introType01: [], introType02: [], moneyChannelItems: []},
            // 单独选择引流进件flag
            iTFlag: false,
            deal: {
                pdTransactionId: '', // 交易配置id
                payeeObj: {id: '', repayRole: -1, repayType: -1}, // 收款人
                repayList: [ // 还款人
                    {id: '', repayRole: -1, repayOrder: 1},
                    {id: '', repayRole: -1, repayOrder: 2}
                ]
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
            ownLoanType: $('input[name="ownLoanType"]'),
            channelLoanType: $('input[name="channelLoanType"]'),
            ownPaybackType: $('input[name="ownPaybackType"]'),
            channelPaybackType: $('input[name="channelPaybackType"]'),
            contractGenerationType: $('input[name="contractGenerationType"]')
        },
        processDom: {
            processCheckbox: {
                orderInit: $('input[data-name="订单初始化"]'),
                diaocha: $('input[data-name="进件预审"]'),
                firstCheck: $('input[data-name="初审"]'),
                fendan: $('input[data-name="分单"]'),
                againCheck: $('input[data-name="复审"]'),

                panding: $('input[data-name="有权审批人判定"]'),
                jinlifushen: $('input[data-name="风控经理复审"]'),
                zongjianfushen: $('input[data-name="风控总监复审"]'),


                finalCheck: $('input[data-name="终审"]'),
                makeHetong: $('input[data-name="合同制作"]'),
                hetong: $('input[data-name="合同审核"]'),

                startMoney: $('input[data-name="发起放款"]'),
                startMoney01: $('input[data-name="放款初审"]'),
                startMoney0201: $('input[data-name="放款专员复审"]'),
                startMoney0202: $('input[data-name="风控经理复审"]'),

                panding02: $('input[data-name="有权审批人判定"]'),
                zongjainfushenfangkuan: $('input[data-name="风控总监复审"]'),

                startMoney03: $('input[data-name="有权审批人终审"]'),
                startMoney04: $('input[data-name="财务放款审查"]'),
                startMoney05: $('input[data-name="财务经理复核"]'),

                autoLoan: $('input[data-name="自动放款"]'),
            },
            processRadio: {
                start: $('input[data-name="启动流程"]'),
                finish: $('input[data-name="流程结束"]')
            }
        },
        init: function () {
            this.baseConfigurationInit();
            this.renderCheckBox();
            this.bindEvent();


         	//只有德阳金坤才能使用
            var id = '${coporateId}';
    
           	//测试：b69303a1e8a14bc8893fd90b6f6ace0a
           	//生成：b69303a1e8a14bc8893fd90b6f6ace0a1
			if (id == 'b69303a1e8a14bc8893fd90b6f6ace0a') {
				
				 $('#redhint').addClass('hide');
				
				 $('#zjqdRadio1').removeAttr('disabled',true);
			}else{
			
				$('#redhint').removeClass('hide');
				 $('#zjqdRadio1').attr('disabled', true);
			}
        },
        bindEvent: function () {
            this.bindBaseEvent();
            this.bindChannelEvent();
            this.bindBusinessEvent();
            this.bindDealEvent();
            this.bindMoneyEvent();
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
                    // openProductId: $.trim($('#productCode').val()),
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
                    guaranteeValue: guaranteeValue()//担保公司
                }
                if (self.variable.productId != '') { // 如果productId有值 则进行更新 否则为新建
                    params.productId = self.variable.productId;
                }
                // 判断资金端编号是否填写
                if (params.openProductId == '') {
                    self.alertModelCancel('请输入产品资金端编号!');
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
                    if (Number($.trim($('#borrowInterval01').val())) < 0 || Number($.trim($('#borrowInterval01').val())) > 2000000 || $.trim($('#borrowInterval01').val()) == '') {
                        self.alertModelCancel('请输入正确的借款金额区间!');
                        return;
                    }
                    if (Number($.trim($('#borrowInterval02').val())) < 0 || Number($.trim($('#borrowInterval02').val())) > 2000000) {
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
                        if (res.data.scopeList.length > 0) {
                            renderTypeUse(res.data.scopeList, 'borrowUse');
                        }
                        renderBorrow(res.data.cycleList);
                        renderEnsureWay(res.data.productInfo);
                        renderArea(res.data.areaMap);
                        self.variable.areaType = res.data.areaMap.type;
                    }
                }
            })

            // 渲染产品基本信息
            function renderProduct(data) {
                $('#firstProductName').val(data.productName);
                $('#firstProScene').val(data.productDescription);
                $('#productCode').val(data.openProductId);
                $('#tdReportValidDate').val(data.tdReportValidDate);
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
            function renderTypeUse(data, name) {
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
            var a = $('#introType01Name'),
                b = $('#chooseChannel01'),
                c = $('#clear01'),
                d = $('#addIntroType01');
            var e = $('#mIntroTypeName'), // 资金合作渠道名字
                f = $('#mChooseChannel'),
                g = $('#mClear'),
                h = $('#addMIntroType');
            var j = $('#type01feeType'),
                k = $('#type01bondType');
            var iT01 = $('#introType01'),
                iT03 = $('#introType03');
            // 上一步
            $('#secToFir').click(function () {
                if (judgeChecked()) {
                    self.alertModelCancel('请至少选择一项进件类型!');
                    return false;
                }
                if (judgeIsHasContent01()) return false;
                saveChecked(function () {
                    self.baseConfigurationInit();
                    $('.configuration > div').hide();
                    $('.base-configuration').show();
                })
            })
            // 下一步
            $('#secToThird').off('click').on('click', function () {
                if (judgeChecked()) {
                    self.alertModelCancel('请勾选进件类型!');
                    return false;
                }
                if (judgeIsHasContent01()) return false;


                saveChecked(function () {
                    self.businessInit(); // 业务受理配置初始化
                    $('.configuration > div').hide();
                    $('.business-configuration').show();
                })

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

            // 点击搜索按钮搜索列表
            $('#sChannelList').click(function () {
                var type = $('#channelListModal').attr('data-type');
                self.renderChannelList(type, $.trim($('#sChannelInput').val()));
            })

            // 点击资金渠道选择渠道
            f.click(function () {
                alertChannelList(2);
            })
            // 点击资金渠道清空
            g.on('click', function () {
                e.text('请添加产品资金合作渠道').removeAttr('channel-id');
            })
            // 点击资金渠道新增渠道
            h.click(function () {
                var params = {
                    id: e.attr('channel-id'),
                    channelName: e.text(),
                    type: 2
                };
                if (params.id == undefined) {
                    self.alertModelCancel('请选择资金渠道!');
                    return false;
                }
                // 判断是否重复添加
                for (var i = 0; i < self.variable.introType.moneyChannelItems.length; i++) {
                    var obj = self.variable.introType.moneyChannelItems[i];
                    if (obj.id == params.id) {
                        self.alertModelCancel('请勿重复添加!');
                        g.trigger('click'); // 清空
                        return;
                    }
                }
                self.variable.introType.moneyChannelItems.push(params);
                self.rendermIntroType();
                g.trigger('click'); // 清空
            })
            // 点击资金渠道删除按钮
            $('#mIntroContent').on('click', '.delType', function () {
                self.variable.introType.moneyChannelItems.splice($(this).parents('.item').index(), 1);
                self.rendermIntroType();
            })

            // 点击所有渠道列表选中效果
            chooseEffect();

            // 点击资金渠道显示隐藏
            $('#mIntroType input[value=0]').on('ifClicked', function () {
                $('#mIntroTypeBox').addClass('hide');
            })
            $('#mIntroType input[value=1]').on('ifClicked', function () {
                $('#mIntroTypeBox').removeClass('hide');
            })

            // 手续费
            function fee(flag) {
                var obj = {type: '', value: ''};
                if ($.trim(flag.find('input[fee-type="1"]').val()) != '') { // 手续费第一个输入框值不为空
                    obj.type = 1;
                    obj.value = $.trim(flag.find('input[fee-type="1"]').val());
                } else if ($.trim(flag.find('input[fee-type="2"]').val()) != '') { // 第二个输入框不为空
                    obj.type = 2;
                    obj.value = $.trim(flag.find('input[fee-type="2"]').val());
                } else if ($.trim(flag.find('input[fee-type="3"]').val()) != '') {
                    obj.type = 3;
                    obj.value = $.trim(flag.find('input[fee-type="3"]').val());
                }
                return obj;
            }

            // 保证金
            function bond(flag) {
                var obj = {type: '', value: ''};
                if ($.trim(flag.find('input[bond-type="1"]').val()) != '') { // 保证金第一个输入框值不为空
                    obj.type = 1;
                    obj.value = $.trim(flag.find('input[bond-type="1"]').val());
                } else if ($.trim(flag.find('input[bond-type="2"]').val()) != '') { // 第二个输入框不为空
                    obj.type = 2;
                    obj.value = $.trim(flag.find('input[bond-type="2"]').val());
                } else if ($.trim(flag.find('input[bond-type="3"]').val()) != '') {
                    obj.type = 3;
                    obj.value = $.trim(flag.find('input[bond-type="3"]').val());
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
                modal.attr('data-type', type);
                $('#sChannelInput').val('');
                self.renderChannelList(type);
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
                    productId: self.variable.productId,
                    channelItems: JSON.stringify(channelItems()),
                    moneyChannelItems: JSON.stringify(moneyChannelItems()),
                    isOwnChannel: isOwnChannel()
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
                    if (iT03.is(':checked')) {
                        return 1;
                    } else {
                        return 0;
                    }
                }

                function channelItems() {
                    if (iT01.is(':checked')) {
                        return self.variable.introType.introType01;
                    } else {
                        return [];
                    }
                }
                function moneyChannelItems() {
                    if ($('input[name="mIntroType"]:checked').val()==1) {
                        return self.variable.introType.moneyChannelItems;
                    } else {
                        return [];
                    }
                }
            }


        },
        // 渲染渠道配置列表
        renderChannelList: function (type, keyword) {
            var self = this,
                params = {productId: self.variable.productId, type: type};
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
        // 渲染资金渠道列表
        rendermIntroType : function() {
            var str = '';
            $.each(this.variable.introType.moneyChannelItems, function (k, v) {
                str += '<div class="item">';
                str += '<div class="addedChannelTitle">';
                str += '<span class="channel-name add-channel-name">'+v.channelName+'</span>';
                str += '<button class="btn btn-default delType">删除</button>';
                str += '</div>';
                str += '</div>';
            })
            $('#mIntroContent').html(str);
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
                        if(res.data.moneyChannelItems.length>0) {
                            self.variable.introType.moneyChannelItems = res.data.moneyChannelItems;
                            $('input[name="mIntroType"]').eq(0).attr('checked',true)
                        }else{
                            $('input[name="mIntroType"]').eq(1).attr('checked',true)
                            self.variable.introType.moneyChannelItems.length = 0;
                            $('#mIntroTypeBox').addClass('hide');
                        }
                        $.each(res.data.channelItems, function (k, v) {
                            if (v.type == 1) {
                                $('#introType01').attr('checked', true).iCheck({
                                    checkboxClass: 'icheckbox_minimal-blue'
                                });
                                self.variable.introType.introType01.push(v);
                            } else if (v.type == 2) {
                                $('#introType02').attr('checked', true).iCheck({
                                    checkboxClass: 'icheckbox_minimal-blue'
                                });
                                self.variable.introType.introType02.push(v);
                            }
                        })
                        $('input[name="mIntroType"]').iCheck({
                            radioClass: 'iradio_minimal-blue',
                        });
                        self.renderIntroType01();
                        self.rendermIntroType();
                        // 点击资金渠道显示隐藏
                        $('#mIntroType input[value=0]').on('ifClicked', function () {
                            $('#mIntroTypeBox').addClass('hide');
                        })
                        $('#mIntroType input[value=1]').on('ifClicked', function () {
                            $('#mIntroTypeBox').removeClass('hide');
                        })
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
                    case 6 :
                        return '数字';
                        break;
                    case 7 :
                        return '日期';
                        break;
                    case 8 :
                        return '身份证相关';
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
            this.getRepayWay(function () {
                self.getDealData();
            });
        },
        // 交易配置绑定事件
        bindDealEvent: function () {
            var self = this;
            // 点击还款计划表系统自动生成展示时间
            $('#repaymentPlanWay input[value=0]').on('ifClicked', function () {
                $('#repaymentPlanWayOffsetBox').removeClass('hide');
                $('#repaymentPlanWayOffsetDayBox').addClass('hide');
            })
            $('#repaymentPlanWay input[value=2]').on('ifClicked', function () {
                $('#repaymentPlanWayOffsetDayBox').removeClass('hide');
                $('#repaymentPlanWayOffsetBox').addClass('hide');
            })

            // 上一步
            $('#fourTothird').click(function () {
                saveChecked(function () {
                    self.businessInit();
                    $('.configuration > div').hide();
                    $('.business-configuration').show();
                })
            })
            // 下一步
            $('#fourToFive').click(function () {
                saveChecked(function () {
                    self.moneyInit();
                    $('.configuration > div').hide();
                    $('.money-configuration').show();
                })
            })

            function saveChecked(cb) {
                var params = {
                    productId: self.variable.productId,
                    pdTransactionId: self.variable.deal.pdTransactionId,
                    repaymentPlanWay: self.getCheckboxItem('repaymentPlanWay')[0],
                    repaymentPlanDayOffset: getRepayDay(), // 系统自动生成
                    repaymentPlanDay: getRepayDayCus(), // 用户自定义
                    repayWay: self.getCheckboxItem('repayWay').join(','), // 还款方式
                    fixedInterestRate: Number($.trim($('#fixedInterestRate').val())).mul(12), // 后台存年利率
                    serviceCharge: Number($.trim($('#serviceCharge').val())).mul(12),
                    // maxAmount: Number($.trim($('#maxAmount').val()))*10000, // 发标上限额度
                    drawingControl: self.getCheckboxItem('drawingControl')[0],
                    isPrepaySup: self.getCheckboxItem('isPrepaySup')[0],
                    isPenaltySup: self.getCheckboxItem('isPenaltySup')[0],
                    isOnlineSign: self.getCheckboxItem('isOnlineSign')[0],
                    ownLoanType: self.getCheckboxItem('ownLoanType')[0],
                    channelLoanType: self.getCheckboxItem('channelLoanType')[0],
                    ownPaybackType: self.getCheckboxItem('ownPaybackType')[0],
                    channelPaybackType: self.getCheckboxItem('channelPaybackType')[0],
                    contractGenerationType: self.getCheckboxItem('contractGenerationType')[0],
                    payeeItem: JSON.stringify(payee()),
                    repayItems: JSON.stringify(repay())
                };
                if (self.getCheckboxItem('repayWay').length == 0) {
                    self.alertModelCancel('请选择还款方式');
                    return;
                }
                if (params.repaymentPlanWay == null || params.repaymentPlanWay == '' || params.repaymentPlanWay == undefined) {
                    self.alertModelCancel('请选择还款计划表');
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

            // 还款人
            function repay() {
                var ids = {};
                for (var i = 0; i < self.variable.deal.repayList.length; i++) {
                    var obj = self.variable.deal.repayList[i];
                    if (obj.repayOrder == 1) {
                        ids.firstId = obj.id;
                    } else if (obj.repayOrder == 2) {
                        ids.secondId = obj.id;
                    }
                }
                return [
                    {
                        id: ids.firstId == undefined ? '' : ids.firstId,
                        repayOrder: 1,
                        repayRole: $('#repay1').val()
                    },
                    {
                        id: ids.secondId == undefined ? '' : ids.secondId,
                        repayOrder: 2,
                        repayRole: $('#repay2').val()
                    }
                ];
            }

            // 收款人
            function payee() {
                return {
                    id: self.variable.deal.payeeObj.id == undefined ? '' : self.variable.deal.payeeObj.id,
                    payeeType: $('#payee').val(),
                    payeeRole: $('#payee').val()
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

            // 获取指定日期
            function getRepayDayCus() {
                return Number($.trim($('#repaymentPlanWayOffsetDay').val()));
            }

        },
        // 获取还款方式
        getRepayWay: function (cb) {
            $.ajax({
                url: util.getServerUrl('/common/getDictListByType'),
                data: {type: 'CPHKFS'},
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
                    checkboxClass: 'icheckbox_minimal-blue'
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
                        if (res.data.repayList.length != 0) {
                            self.variable.deal.repayList = res.data.repayList;
                        }
                        renderRadioInfo(res.data.njProductTransaction);
                        renderPayment(res.data.njProductTransaction.repayWay);
                        renderSerRate(res.data.njProductTransaction);
                        // renderPayee(res.data.payeeObj);
                        // renderRepay(res.data.repayList);
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
                    $('#repaymentPlanWayOffsetDayBox').addClass('hide');
                } else if ($('#repaymentPlanWay input[value="2"]').is(':checked')) {
                    $('#repaymentPlanWayOffsetDay').val(data.repaymentPlanDayOffset);
                    $('#repaymentPlanWayOffsetDayBox').removeClass('hide');
                    $('#repaymentPlanWayOffsetBox').addClass('hide');
                }

                // 由于重新渲染了dom 所以必须重新绑定事件
                // 点击还款计划表系统自动生成展示时间
                $('#repaymentPlanWay input[value=0]').on('ifClicked', function () {
                    $('#repaymentPlanWayOffsetBox').removeClass('hide');
                    $('#repaymentPlanWayOffsetDayBox').addClass('hide');
                })
                $('#repaymentPlanWay input[value=2]').on('ifClicked', function () {
                    $('#repaymentPlanWayOffsetDayBox').removeClass('hide');
                    $('#repaymentPlanWayOffsetBox').addClass('hide');
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
            }

            // 渲染还款人设置
            function renderRepay(data) {
                for (var i = 0; i < data.length; i++) {
                    if (data[i].repayOrder == 1) {
                        $('#repay1').val(data[i].repayRole);
                    } else if (data[i].repayOrder == 2) {
                        $('#repay2').val(data[i].repayRole);
                    }
                }
            }

            // 渲染服务费率等
            function renderSerRate(data) {
                $('#fixedInterestRate').val(data.fixedInterestRate);
                $('#serviceCharge').val(data.serviceCharge);
                // $('#maxAmount').val(Number(data.max_amount)/10000);
            }


        },

        /**
         * 费用配置
         */
        moneyInit : function() {
            var self = this;
            this.getPageItems(function () {
                self.getMoneyData()
            })

        },
        bindMoneyEvent : function() {
            var self = this;
            $('#fiveToFour').click(function() {
                saveChecked(function () {
                    self.dealInit();
                    $('.configuration > div').hide();
                    $('.deal-configuration').show();
                })
            })
            $('#fiveToSix').click(function() {
                saveChecked(function () {
                    self.processInit();
                    $('.configuration > div').hide();
                    $('.process-configuration').show();
                })
            })
            function saveChecked(cb) {
                var params=[];
                $('.money-configuration-content input').each(function() {
                    var result = getCheckbox($(this).parents('ul').attr('data-classify'),$(this).attr('name'));
                    if(result.length!=0){ // 被选中
                        params.push({
                            code: result[0],
                            type:$(this).parents('ul').attr('data-type'),
                            calCode : $(this).parents('li').find('select').val()
                        })
                    }
                })
                $.ajax({
                    url: util.getServerUrl('/product/saveProductFeeInfo'),
                    method: 'POST',
                    data: {
                        moneyArr : JSON.stringify(params),
                        productId : self.variable.productId,
                        isOverdueAutoDeduct:self.getCheckboxItem('isOverdueAutoDeduct')[0]
                    },
                    beforeSend: function () {
                        $('#fiveToFour').attr('disabled', true);
                        $('#fiveToSix').attr('disabled', true);
                    },
                    complete: function () {
                        $('#fiveToFour').removeAttr('disabled');
                        $('#fiveToSix').removeAttr('disabled');
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            cb && cb();
                        } else {
                            self.alertModelCancel(res.msg);
                        }
                    }
                })
                function getCheckbox(fatherClass,checkBoxName) {
                    var arr = [];
                    var ids = $(fatherClass + ' input[name="' + checkBoxName + '"]');
                    ids.each(function () {
                        if (this.checked) {
                            arr.push(this.value);
                        }
                    })
                    return arr;
                }
            }
            // 切换下拉框说明
            $('.money-configuration-content').on('change','select',function () {
                $(this).next().text($(this).children('option:selected').attr('data-description'))
            })
        },
        getPageItems : function(cb) {
            var self = this;
            $.ajax({
                url: util.getServerUrl('/common/getProductFeeItems'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        renderHtml(res.data)
                        cb && cb();
                    } else {
                        self.alertModelCancel(res.msg);
                    }
                }
            })
            function renderHtml(data) {
                var str = '',option='';
                $.each(data,function(k,v){
                   if(v.calList.length>0) {
                       option = '';
                       $.each(v.calList,function(key,value){
                           option += '<option data-description="'+value.explain+'" value="'+value.code+'">'+value.name+'</option>';
                       })
                   }
                    str += '<li>';
                    str += '<s><input '+(v.isMustSelected?"checked":"")+' name="'+v.code+'" type="checkbox" value="'+v.code+'">'+v.name+'</s>';
                    str += '<select class="form-control '+(v.calList.length>0?"":"hide-dom")+'">';
                    str += option;
                    str += '</select>';
                    str += '<span class="red-tag hide-dom">描述性文字</span>';
                    str += '</li>';
                })
                $('.money-configuration-content').html(str).find('span.red-tag').each(function(){
                    if($(this).prev('select').children('option').length!=0){
                        $(this).text($(this).prev('select').children('option').eq(0).attr('data-description')).removeClass('hide-dom')
                    }
                })
                self.renderMoneyCheckBox();

            }
        },
        getMoneyData:function() {
            var self = this;
            $.ajax({
                url: util.getServerUrl('/product/productInfo'),
                method: 'POST',
                data: {id: self.variable.productId, page: 6},
                success: function (res) {
                    if (res.status == 0) {
                        var repayCheckbox = $('.repayFeeItems input'),
                            payBakCheckbox = $('.payBakFeeItems input'),
                            isOverdueAutoDeduct = $('.isAutoDeduct input[name="isOverdueAutoDeduct"]');
                        if (res.data.repayFeeItems.length != 0) { // 还款
                            $.each(res.data.repayFeeItems,function(k,v) {
                                $.each(repayCheckbox,function() {
                                    if($(this).val()==v.businessFeeCode){
                                        $(this).attr('checked',true)
                                        if(v.algorithmCode!=undefined) { // 存在算法
                                            if(v.algorithmCode.indexOf('$')!=-1) {
                                                var value = v.algorithmCode.split('$')[0],
                                                    desc = v.algorithmCode.split('$')[1];
                                                var select = $(this).parents('li').find('select');
                                                select.val(value);
                                                select.next('span').text(desc);
                                            }
                                        }
                                    }
                                })
                            })
                        }
                        if (res.data.payBakFeeItems.length != 0) { // 回款
                            $.each(res.data.payBakFeeItems,function(k,v) {
                                $.each(payBakCheckbox,function() {
                                    if($(this).val()==v.businessFeeCode){
                                        $(this).attr('checked',true)
                                        if(v.algorithmCode!=undefined) { // 存在算法
                                            if(v.algorithmCode.indexOf('$')!=-1) {
                                                var value = v.algorithmCode.split('$')[0],
                                                    desc = v.algorithmCode.split('$')[1];
                                                var select = $(this).parents('li').find('select');
                                                select.val(value);
                                                select.next('span').text(desc);
                                            }
                                        }
                                    }
                                })
                            })
                        }
                        isOverdueAutoDeduct.each(function(){
                            if($(this).val()==res.data.isOverdueAutoDeduct)$(this).attr('checked',true)
                        })
                    }else {
                        self.alertModelCancel(res.msg);
                    }
                    self.renderMoneyCheckBox();
                },
                error: function (error) {
                    self.alertModelCancel(error);
                }
            })
        },
        renderMoneyCheckBox : function() {
            $('.money-configuration input[type="checkbox"]').iCheck({
                checkboxClass: 'icheckbox_minimal-blue',
            });
            $('.money-configuration input[type="radio"]').iCheck({
                radioClass: 'iradio_minimal-blue',
            });
        },
        /**
         * 流程配置
         */
        // 流程配置初始化
        processInit: function () {
            this.getProcessData(function () {
                $('input[name="processRadioStart"]').iCheck({
                    radioClass: 'iradio_minimal-blue'
                })
                $('input[name="processRadioEnd"]').iCheck({
                    radioClass: 'iradio_minimal-blue'
                })
                $('input[name="processCheckbox"]').iCheck({
                    checkboxClass: 'icheckbox_minimal-blue',
                })
            })

        },
        // 流程配置绑定事件
        bindProcessEvent: function () {
            var self = this;
            var a = self.processDom.processCheckbox,
                b = self.processDom.processRadio,
                c = self.variable.processLine;
            // 上一步
            $('#sixToFive').click(function () {
                saveChecked(function () {
                    self.moneyInit();
                    $('.configuration > div').hide();
                    $('.money-configuration').show();
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
            // 点击生成流程图
            $('#creatProcess').click(function () {
                var str = '';
                c.length = 0; // 清空流程图数组
                if (b.start.is(':checked')) {
                    c.push(b.start.attr('data-name'));
                }
                // if (a.jinjian.is(':checked')) {
                //     c.push(a.jinjian.attr('data-name'));
                // }
                if (a.orderInit.is(':checked')) {
                    c.push(a.orderInit.attr('data-name'));
                }
                if (a.diaocha.is(':checked')) {
                    c.push(a.diaocha.attr('data-name'));
                }
                if (a.firstCheck.is(':checked')) {
                    c.push(a.firstCheck.attr('data-name'));
                }
                if (a.fendan.is(':checked')) {
                    c.push(a.fendan.attr('data-name'));
                }
                if (a.againCheck.is(':checked')) {
                    c.push(a.againCheck.attr('data-name'));
                }

                if (a.panding.is(':checked')) {
                    c.push(a.panding.attr('data-name'));
                }
                if (a.jinlifushen.is(':checked')) {
                    c.push(a.jinlifushen.attr('data-name'));
                }
                if (a.zongjianfushen.is(':checked')) {
                    c.push(a.zongjianfushen.attr('data-name'));
                }

                if (a.finalCheck.is(':checked')) {
                    c.push(a.finalCheck.attr('data-name'));
                }
                if (a.makeHetong.is(':checked')) {
                    c.push(a.makeHetong.attr('data-name'));
                }
                if (a.hetong.is(':checked')) {
                    c.push(a.hetong.attr('data-name'));
                }
                if (a.startMoney.is(':checked')) {
                    c.push(a.startMoney.attr('data-name'));
                }
                if (a.startMoney01.is(':checked')) {
                    c.push(a.startMoney01.attr('data-name'));
                }
                if (a.startMoney0201.is(':checked')) {
                    c.push(a.startMoney0201.attr('data-name'));
                }
                if (a.startMoney0202.is(':checked')) {
                    c.push(a.startMoney0202.attr('data-name'));
                }

                if (a.panding02.is(':checked')) {
                    c.push(a.panding02.attr('data-name'));
                }
                if (a.zongjainfushenfangkuan.is(':checked')) {
                    c.push(a.zongjainfushenfangkuan.attr('data-name'));
                }

                if (a.startMoney03.is(':checked')) {
                    c.push(a.startMoney03.attr('data-name'));
                }
                if (a.startMoney04.is(':checked')) {
                    c.push(a.startMoney04.attr('data-name'));
                }
                if (a.startMoney05.is(':checked')) {
                    c.push(a.startMoney05.attr('data-name'));
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
                var items = [
                    {
                        "processName": "开始",
                        "execAgreeStatus": "1",
                        "execOrders": "1",
                        "processId": "1",
                        "execFunction": ""
                    }, // 开始
                    {
                        "processName": "订单初始化",
                        "execAgreeStatus": "20",
                        "execOrders": "2",
                        "processId": "3",
                        "execFunction": "cdjkShunt"
                    }, // 订单初始化
                    {
                        "processName": "进件预审",
                        "execAgreeStatus": "21",
                        "execOrders": "3",
                        "processId": "21",
                        "execFunction": ""
                    }, // 进件预审(客服经理)
                    {
                        "processName": "初审",
                        "execAgreeStatus": "5",
                        "execOrders": "4",
                        "processId": "5",
                        "execFunction": ""
                    }, // 初审(部门经理)
                    {
                        "processName": "分单",
                        "execAgreeStatus": "3",
                        "execOrders": "5",
                        "processId": "4",
                        "execFunction": ""
                    }, // 分单(风控经理)
                    {
                        "processName": "复审",
                        "execAgreeStatus": "51",
                        "execOrders": "6",
                        "processId": "6",
                        "execFunction": ""
                    }, // 复审1(风控专员)

                    {
                        "processName": "有权审批人判定",
                        "execAgreeStatus": "0",
                        "execOrders": "7",
                        "processId": "24",
                        "execFunction": "cdjkAuthorizedJudge"
                    }, // 终审(有权审批人)
                    {
                        "processName": "风控经理复审",
                        "execAgreeStatus": "53",
                        "execOrders": "8",
                        "processId": "61",
                        "execFunction": ""
                    }, // 复审2(风控经理)
                    {
                        "processName": "风控总监复审",
                        "execAgreeStatus": "54",
                        "execOrders": "9",
                        "processId": "62",
                        "execFunction": ""
                    }, // 复审3(风控总监)


                    {
                        "processName": "终审",
                        "execAgreeStatus": "7",
                        "execOrders": "10",
                        "processId": "7",
                        "execFunction": ""
                    }, // 终审(有权审批人)
                    {
                        "processName": "合同制作",
                        "execAgreeStatus": "8",
                        "execOrders": "11",
                        "processId": "22",
                        "execFunction": ""
                    }, // 合同制作
                    {
                        "processName": "合同审核",
                        "execAgreeStatus": "81",
                        "execOrders": "12",
                        "processId": "23",
                        "execFunction": ""
                    }, // 合同审核（法务审）
                    {
                        "processName": "发起放款",
                        "execAgreeStatus": "31",
                        "execOrders": "13",
                        "processId": "31",
                        "execFunction": ""
                    }, // 发起放款流程
                    {
                        "processName": "放款初审",
                        "execAgreeStatus": "32",
                        "execOrders": "14",
                        "processId": "32",
                        "execFunction": ""
                    }, // 放款初审(部门经理)
                    {
                        "processName": "放款专员复审",
                        "execAgreeStatus": "33",
                        "execOrders": "15",
                        "processId": "33",
                        "execFunction": ""
                    }, // 放款复审1(放款专员)

                    {
                        "processName": "风控经理复审",
                        "execAgreeStatus": "34",
                        "execOrders": "16",
                        "processId": "38",
                        "execFunction": ""
                    }, // 放款复审2(风控经理)
                    {
                        "processName": "有权审批人判定",
                        "execAgreeStatus": "0",
                        "execOrders": "17",
                        "processId": "24",
                        "execFunction": "cdjkAuthorizedJudge"
                    }, // 放款终审(有权审批人)
                    {
                        "processName": "风控总监复审",
                        "execAgreeStatus": "35",
                        "execOrders": "18",
                        "processId": "34",
                        "execFunction": ""
                    }, // 放款复审3(风控总监)

                    {
                        "processName": "有权审批人终审",
                        "execAgreeStatus": "36",
                        "execOrders": "19",
                        "processId": "35",
                        "execFunction": ""
                    }, // 放款终审(有权审批人)
                    {
                        "processName": "财务放款审查",
                        "execAgreeStatus": "37",
                        "execOrders": "20",
                        "processId": "36",
                        "execFunction": ""
                    }, // 放款审查(财务专员)
                    {
                        "processName": "财务经理复核",
                        "execAgreeStatus": "38",
                        "execOrders": "21",
                        "processId": "37",
                        "execFunction": ""
                    }, // 放款复核(财务经理)


                    {
                        "processName": "结束",
                        "execAgreeStatus": "99",
                        "execOrders": "23",
                        "processId": "99",
                        "execFunction": ""
                    }, // 结束
                ], params;
                var autoLoan = {
                    "processName": "自动放款",
                    "execAgreeStatus": "12",
                    "execOrders": "22",
                    "processId": "39",
                    "execFunction": "autoLoanService"
                }; // 自动放款

                // 判断自动放款是否选中
                if ($('input[data-name="自动放款"]').is(':checked')) {
                    items.push(autoLoan);
                }
                params = {
                    productId: self.variable.productId,
                    processItems: JSON.stringify(items),
                    templateId: self.templateId
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


            }
        },
        // 渲染流程配置数据
        getProcessData: function (cb) {
            var self = this;
            var a = this.processDom.processCheckBox,
                b = this.processDom.processRadio;
            $.ajax({
                url: util.getServerUrl('/product/productInfo'),
                method: 'POST',
                data: {id: self.variable.productId, page: 5},
                success: function (res) {
                    if (res.status == 0) {
                        if (res.data.length != 0) {
                            self.templateId = res.data[0].templateId;
                        }
                        cb && cb();
                    }
                }
            })
        },
        templateId: '',


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
            $('input[name="mIntroType"]').iCheck({
                radioClass: 'iradio_minimal-blue',
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