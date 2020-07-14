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
                <li><a href="<%=basePath%>loanOrder/myOrderBaseInfoPage?orderId=<%=orderId%>" aria-controls="one" role="tab" data-toggle="tab" data-target="navTab">基础信息</a></li>
                <li class="active"><a href="<%=basePath%>loanOrder/myOrderCreditInfoPage?orderId=<%=orderId%>" aria-controls="two" role="tab" data-toggle="tab"  data-target="navTab">信用信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderInvestigatePage?orderId=<%=orderId%>" aria-controls="three" role="tab" data-toggle="tab"  data-target="navTab">业务调查</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderBusinessApprovePage?orderId=<%=orderId%>" aria-controls="fore" role="tab" data-toggle="tab"  data-target="navTab">业务审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderContractsPage?orderId=<%=orderId%>" aria-controls="five" role="tab" data-toggle="tab"  data-target="navTab">合同管理</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderLoanApprovePage?orderId=<%=orderId%>" aria-controls="six" role="tab" data-toggle="tab"  data-target="navTab">放款审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderOperateLogPage?orderId=<%=orderId%>" aria-controls="seven" role="tab" data-toggle="tab"  data-target="navTab">操作日志</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content" id="creditInfo" v-cloak>
                <div class="tab-pane active" id="two">
                    <!--申请信息-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">申请信息</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <form id="applyInfo">
                                <ul class="base-info">
                                    <li>
                                        <i class="desc-name">申请额度: </i>
                                        <input name="amount" type="text" class="form-control" :value="applyInfo.amount">
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
                                            <option :selected="period.value == applyInfo.period"
                                                    :value="period.value" v-for="period in periodInfo">
                                                {{period.labelText}}
                                            </option>
                                        </select>
                                    </li>
                                    <li>
                                        <i class="desc-name">银行: </i>
                                        <input name="bankName" type="text" class="form-control" :value="baseInfo.bankName">
                                    </li>
                                </ul>
                                <ul class="base-info">
                                    <li class="spe-li clearfix relative">
                                        <i style="margin-top: 10px;"
                                           class="desc-name pull-left">还款方式及利率: </i>
                                        <div class="pull-left">
                                            <select class="form-control short-select" name="repayWay">
                                                <option :selected="repayWay.value == applyInfo.repayWay"
                                                        :value="repayWay.value"
                                                        v-for="repayWay in repayWays">{{repayWay.text}}
                                                </option>
                                            </select>
                                            <input style="width: 160px;" name="auditRating" type="number" oninput="if(value.length>8)value=value.slice(0,8)" class="form-control"
                                                   :value="applyInfo.auditRating | monthRating">

                                        </div>
                                        <span class="unit" style="left: 485px;">%</span>
                                    </li>
                                    <li>
                                        <i class="desc-name">银行卡号: </i>
                                        <input name="bankAccount" type="text" class="form-control" :value="baseInfo.bankAccount">
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
                                        <input name="age" type="text" class="form-control" :value="baseInfo.age">
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
                                        <input name="phone" type="text" class="form-control" :value="baseInfo.phone">
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
                    <!--同盾贷前反欺诈-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">同盾贷前反欺诈</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div class="tongdun">
                                <div class="score">
                                    <span>{{tdScore.final_score}}</span><br>
                                    <i>{{tdScore.finalSuggest}}</i>
                                </div>
                                <div class="introduce">
                                    <h3>{{tdScore.finalSuggest}}</h3>
                                    <span>共发现 <i class="red-tag">{{tdScore.risk_items.length}}</i> 处异常</span>
                                    <a target="_blank" class="btn btn-new btn-submit" href="<%=path%>/tdScore.html?orderId=<%=orderId%>&path=<%=path%>">同盾报告预览</a>
                                    <a v-if="spouseInfo.length != 0" target="_blank" style="left:550px" class="btn btn-new btn-print" :href="'<%=path%>/tdScore.html?mobile='+spouseMobile+'&path=<%=path%>'">配偶同盾报告预览</a>
                                </div>
                            </div>
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
                                <button class="btn btn-submit btn-small-new" id="export_list">导出</button>
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
                    <button type="button" class="btn btn-submit" data-dismiss="modal">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
<script src="static/plugins/vue/vue.min.js"></script>
<script src="<%=basePath%>static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=basePath%>static/js/jquery.jqprint-0.3.js"></script>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script src="<%=basePath%>static/js/province.js"></script>
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
        vari : {
            orderId : '<%=orderId%>'
        },
        vm:{},
        init : function () {
            this.newVue();
            this.renderProvince();
            this.getData();
            this.bindEvent();
        },
        bindEvent : function(){
            var _this = this;
            // 导出通讯录
            $('#export_list').click(function () {
                window.open('<%=basePath%>loanOrder/exportContacts?orderId=<%=orderId%>','_blank');
            })
            this.houseStatus();
        },
        // 获取数据
        getData : function(){
            var _this = this;
            $.ajax({
                url : util.getServerUrl('/loanOrder/getOrderCreditInfo'),
                method : 'POST',
                data : {orderId : this.vari.orderId},
                success : function (res) {
                    if (res.status == 0) {
                        _this.vm.applyInfo = res.data.applyInfo;
                        _this.vm.baseInfo = res.data.baseInfo;
                        _this.vm.workInfo = res.data.workInfo;
                        _this.vm.repayWays = res.data.repayWayInfo;
                        _this.vm.manageInfo = res.data.manageInfo;
                        _this.vm.periodInfo = res.data.periodInfo;
                        _this.vm.spouseInfo = res.data.spouseInfo;

                        if(res.data.attachMaterial.length > 0){
                            renderAssetProve(res.data.attachMaterial,'asset-prove');
                            $('.asset-images').show();
                        }
                        _this.initImages();

                        // 报告
                        if(res.data.tdReportData != '') {
                            _this.vm.tdScore = res.data.tdReportData;
                            _this.vm.tdScore.risk_items = JSON.parse(replaceTdScore(res.data.tdReportData.risk_items));
                        }else if(res.data.tdReportData == '') {
                            _this.vm.tdScore.final_score = '无';
                            _this.vm.tdScore.finalSuggest = '无';
                            _this.vm.tdScore.risk_items = [];
                        }

                        _this.renderIcheck();
                        aloneRender(res.data);
                        $('#creditInfo .form-control').attr('disabled',true).addClass('css-disabled');
                        $('#creditInfo input[type="radio"]').attr('disabled',true);
                        _this.renderCreditHtml(res.data);
                        // _this.bindEvent();
                    } else {
                        if (res.msg == '' || res.msg == 'undefined') {
                            myOrderTpl.alertModel('信用信息获取失败，请稍后刷新重试!');
                        } else {
                            myOrderTpl.alertModel(res.msg);
                        }
                        _this.renderIcheck();
                    }
                },
                error : function (error) {
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
                        $.each(attachIds,function (key, val) {
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
            function replaceTdScore(str) {
                return str.replace('\\','');
            }
        },
        newVue : function(data){
            this.vm = new Vue({
                el : '#creditInfo',
                data : {
                    repayWays : [],
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
                        {name: '夫妻', value: 1},
                        {name: '父母', value: 2},
                        {name: '儿女', value: 3},
                        {name: '兄妹', value: 4},
                        {name: '亲戚', value: 5},
                        {name: '朋友', value: 6},
                        {name: '同事', value: 7},
                        {name: '同学', value: 8}
                    ],
                    applyInfo: {},
                    baseInfo: {},
                    manageInfo: [],
                    workInfo: {},
                    periodInfo : [],
                    spouseInfo : [],
                    tdScore : {
                        risk_items : [],
                        address_detect : {}
                    }

                },
                computed : {
                    tdScore : function () {
                        var tdScore = {
                            risk_items : [],
                            address_detect : {}
                        };
                        if(data.tdReportData != '') {
                            tdScore = data.tdReportData;
                            tdScore.risk_items = JSON.parse(replaceTdScore(data.tdReportData.risk_items));
                        }
                        return tdScore;
                    },
                    spouseMobile : function () {
                      return this.spouseInfo.length > 0 ? this.spouseInfo[0].relativeMobile : '';
                    },
                    // workInfo : function () {
                    //     var workInfo = {
                    //         "workYears": "",
                    //         "orgName": "",
                    //         "annualIncome": "",
                    //         "orgContact": "",
                    //         "familyIncome": '',
                    //         "orgAddress": "",
                    //         "manageIncome": '',
                    //         "orgNature": "",
                    //         "rentIncome": '',
                    //         "monthIncome": "",
                    //         "position": "'",
                    //         "id": "",
                    //         "department": ""
                    //     };
                    //     if(data.workInfo.length==0){
                    //         return workInfo;
                    //     }
                    //     return data.workInfo;
                    // },
                },
                filters : {
                    monthRating : function (value) {
                        return Number(value).div(12).toFixed(6);
                    }
                }
            })
        },
        // 渲染信用信息页面
        renderCreditHtml: function (data) {
            if ((data.location.latitude == null) && (data.location.longitude == null)) {
                mapNoPoint();
            } else {
                mapHasPoint({longitude: data.location.longitude, latitude: data.location.latitude});
            }

            //  渲染地图
            function mapHasPoint(location) {
                // 百度地图API功能
                var map = new BMap.Map("map_location");
                var point = new BMap.Point(location.longitude, location.latitude);
                map.centerAndZoom(point, 17);  // 初始化地图,设置中心点坐标和地图级别
                var marker = new BMap.Marker(point);        // 创建标注
                map.addOverlay(marker);                     // 将标注添加到地图中
                //添加地图类型控件
                map.addControl(new BMap.MapTypeControl({
                    mapTypes: [
                        BMAP_NORMAL_MAP,
                        BMAP_HYBRID_MAP
                    ]
                }));
                map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
                // 逆地址解析
                var geoc = new BMap.Geocoder();
                geoc.getLocation(point, function (rs) {
                    var addComp = rs.addressComponents;
                    $('#map_info').text(addComp.province + " " + addComp.city + " " + addComp.district + " " + addComp.street + " " + addComp.streetNumber + '号')
                });
            }

            function mapNoPoint() {
                // 百度地图API功能
                var map = new BMap.Map("map_location");
                var point = new BMap.Point(104.072329, 30.66342);
                map.centerAndZoom(point, 17);  // 初始化地图,设置中心点坐标和地图级别
                map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
                $('#map_info').text('没有最近登陆地');
            }

        },
        // 渲染radio和checkbox
        renderIcheck : function () {
            $('input[type="radio"]').iCheck({
                radioClass: 'iradio_minimal-blue'
            });
            $('input[type="checkbox"]').iCheck({
                checkboxClass: 'icheckbox_minimal-blue'
            });
        },
        // 居住性质radio点击
        houseStatus : function () {
            $('input[name="houseStatus"]').on('ifClicked',function () {
                $('.pay-month').addClass('hide');
                if($(this).attr('id')=='rent'){
                    $(this).parents('label').find('.pay-month').removeClass('hide')
                }
                if($(this).attr('id')=='payForMonth'){
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

    }
    $(function () {
        creditInfo.init();
    })
</script>