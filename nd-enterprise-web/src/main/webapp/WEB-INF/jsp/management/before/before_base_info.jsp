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
<link rel="stylesheet" href="static/plugins/magnify/jquery.magnify.min.css">
<link rel="stylesheet" href="static/plugins/webuploader/webuploader.css">
<link rel="stylesheet" href="static/css/management-first-trial.css">
<div class="container-fluid">
    <div class="nav-bar">
        <a data-model="navTab" data-url="<%=basePath%>loanOrder/listPreOrderPage?start=${start}&keyword=${keyword}&orderStatus=${orderStatus}&period=${period}&createDate=${createDate}"> < 返回贷前管理订单列表 </a>
        <div class="reject-reason"><span id="rejectName"></span> &nbsp;&nbsp;:&nbsp;&nbsp; <span id="rejectContent"></span></div>
    </div>
    <div class="steps">
        <ul class="clearfix" id="step_process">
            <li class="active">
                <span class="time-out"></span>
                <span class="normal">进件</span>
            </li>
            <li class="process active"></li>
            <li class="active">
                        <span class="time-out">
                            耗时: <i>20</i> 分钟
                        </span>
                <span class="normal">业务分单</span>
            </li>
            <li class="process active"></li>
            <li class="active">
                        <span class="time-out">
                            耗时: <i>20</i> 分钟
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

                <span class="normal">自动发标</span>
            </li>
        </ul>
    </div>
    <div class="tab-con">
        <div>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist">
                <li class="active"><a href="#one" aria-controls="one" role="tab" data-toggle="tab">基础信息<span
                        class="badge"></span></a></li>

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
                                <li><i class="desc-name">申请金额: </i><input type="text" class="form-control" value="" id="amount"> 元 <span class="badge">*</span></li>
                                <li><i class="desc-name">申请期限: </i><input type="text" class="form-control" value="" id="period"> 期 <span class="badge">*</span></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">用途: </i><input type="text" id="usageDesc" class="form-control" value=""> <span class="badge">*</span></li>
                                <li><i class="desc-name">合作商户: </i><input type="text" id="channelName" class="form-control" value=""></li>
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
                                    <li><i class="desc-name">姓名: </i><input disabled class="form-control" type="text" value="" id="name"> <span class="badge">*</span></li>
                                    <li><i class="desc-name">学历:</i>
                                        <select name="education" id="education" class="form-control">
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
                                    <li><i class="desc-name">银行卡: </i><input disabled class="form-control" type="text" value="" id="bankAccount"> <span class="badge">*</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">身份证号: </i> <input disabled class="form-control" type="text"
                                                     value="" id="identity"> <span class="badge">*</span></li>
                                    <li><i class="desc-name">婚姻状况: </i>
                                        <select name="marrStatus" id="marrStatus" class="form-control">
                                            <option value="1">已婚</option>
                                            <option value="2">未婚</option>
                                            <option value="3">离异</option>
                                            <option value="4">丧偶</option>
                                            <option value="5">再婚</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">手机号码: </i> <input disabled class="form-control" type="text" value="" id="phone"> <span class="badge">*</span></li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">性别: </i>
                                        <select name="sex" id="sex" class="form-control">
                                            <option value="1">男</option>
                                            <option value="0">女</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">年龄: </i> <input class="form-control" type="text" value="" id="age"> <span class="badge">*</span></li>
                                    <li><i class="desc-name">居住性质: </i>
                                        <select name="estateType" id="estateType" class="form-control">
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
                                    <li><i class="desc-name">户籍: </i> <input class="form-control" type="text" value="" id="householdReg"></li>
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
                                <input class="special-length form-control" type="text" value="" id="address"> <span class="badge">*</span>
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
                                        <select name="orgNature" id="orgNature" class="form-control">
                                            <option value="">无</option>
                                            <option value="1">行政机关</option>
                                            <option value="2">国有企业</option>
                                            <option value="3">事业单位</option>
                                            <option value="4">三资企业</option>
                                            <option value="5">私营企业</option>
                                            <option value="6">个体户</option>
                                            <option value="7">其他</option>
                                        </select>
                                        <!--<span class="badge">*</span>-->
                                    </li>
                                    <li><i class="desc-name">单位名称: </i> <input class="form-control" type="text" value="" id="orgName"></li>
                                    <li><i class="desc-name">单位电话: </i> <input class="form-control" type="text" value="" id="orgContact">
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">职位: </i> <input class="form-control" type="text"
                                                   value="" id="position"></li>
                                    <li>
                                        <i class="desc-name">月收入: </i>
                                        <select name="monthIncome" id="monthIncome" class="form-control">
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
                                        <select name="workYears" id="workYears" class="form-control">
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
                                <input class="special-length form-control" type="text" value="" id="orgAddress">
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
                                <li><i class="desc-name">品牌: </i> <input id="brand" class="form-control" type="text" value=""></li>
                                <li>
                                    <i class="desc-name">价格: </i>
                                    <input id="buyPrice" class="form-control" type="text" value="">
                                </li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">型号: </i> <input id="model" class="form-control" type="text" value=""></li>
                                <li><i class="desc-name">首付款: </i> <input id="firstPayment" class="form-control" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name" style="width: 125px;">上一承租人项目编号: </i> <input id="lastProjectNo" class="form-control lastProjectNo" type="text" value=""></li>
                                <li><i class="desc-name" style="width: 125px;">第一个承租人项目编号: </i> <input id="firstProjectNo" class="form-control firstProjectNo" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">车辆保单号: </i> <input id="insuranceNo" class="form-control insuranceNo" type="text" value=""></li>
                                <li><i class="desc-name">车架号: </i> <input id="vin" class="form-control vin" type="text" value=""></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">车牌号: </i> <input id="carNumber" class="form-control carNumber" type="text" value=""></li>
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

                    <!--上传资产佐证（业务人员补充）-->
                    <div class="panel panel-info contact-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">上传资产佐证（业务人员补充）</h3>
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

                    <button id="saveInfo" class="btn btn-info pull-right btn-lg btn-block">保存</button>
                </div>
            </div>
        </div>
    </div>
    <!--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="myModal" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
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

<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script src="static/plugins/webuploader/webuploader.nolog.js"></script>
<script>
    $(function () {
        var beforeBaseInfo = {
            init:function (cb) {
                var _this = this;
                this.getProcess();
                this.getInfo(function () {
                    _this.initImage();
                });
                cb&&cb();
                this.saveInfo();

            },
            variable : {
              carId : '',
                workInfoId : '',
                attachIds : []// 绑定order需要的上传图片后返回的id
            },
            dom : {
                applyInfo : {
                    amount : $('#amount'),
                    period : $('#period'),
                    usageDesc : $('#usageDesc'),
                    channelName : $('#channelName'),
                },
                baseInfo : {
                    bankAccount: $('#bankAccount'),
                    areaCode: $('#areaCode'),
                    education: $('#education'),
                    estateType: $('#estateType'),
                    address: $('#address'),
                    marrStatus: $('#marrStatus'),
                    phone: $('#phone'),
                    identity: $('#identity'),
                    sex: $('#sex'),
                    name: $('#name'),
                    householdReg: $('#householdReg'),
                    age: $('#age')
                },
                workInfo :{
                    orgNature: $('#orgNature'),
                    workYears:$('#workYears'),
                    orgName: $('#orgName'),
                    orgContact: $('#orgContact'),
                    monthIncome: $('#monthIncome'),
                    orgAddress: $('#orgAddress'),
                    position: $('#position'),
                },
                carInfo : {
                    buyPrice : $('#buyPrice'),
                    brand : $('#brand'),
                    model : $('#model'),
                    firstPayment : $('#firstPayment'),
                    insuranceNo : $('#insuranceNo'),
                    vin : $('#vin'),
                    carNumber : $('#carNumber'),
                    lastProjectNo : $('#lastProjectNo'),
                    firstProjectNo : $('#firstProjectNo')
                },
            },
            // 获取数据
            getInfo : function (cb) {
                var _this = this;
                $.ajax({
                    url: util.getServerUrl('/loanOrder/getOrderBaseInfo'),
                    dataType: 'json',
                    method: 'POST',
                    data:{
                        orderId : '<%=orderId%>'
                    },
                    success: function (res) {

                        if (res.status == '0') {
                            if(res.data.workInfo != ''){
                                _this.variable.workInfoId = res.data.workInfo.id;
                            }
                            if(res.data.carInfo==''){
                                $('.car-info').remove();
                                _this.renderHtml(res.data,false);
                            }else {
                                _this.renderHtml(res.data,true);
                                _this.variable.carId = res.data.carInfo.id;
                            }
                            // 驳回拒绝提示
                            if(toString.call(res.data.refuseReson) == '[object Object]'){
                                tipReject(res.data.refuseReson);
                            }
                            // 展示附件
                            if(res.data.attachMaterial.length > 0){
                                renderAssetProve(res.data.attachMaterial,'assetProve');
                                $('.asset-prove').show();
                            }
                            if(res.data.attachMaterialOther.length > 0){
                                renderAssetProve(res.data.attachMaterialOther,'otherProve');
                                $('.other-prove').show();
                            }
                            cb&&cb();

                        }else{
                            if(res.msg==''){
                                _this.alertModel('信息获取失败，请稍后再试!');
                            }else {
                                _this.alertModel(res.msg);
                            };
                        }
                    },
                    error : function (res) {
                        _this.alertModel('信息获取失败，请稍后再试!');
                    }
                })
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
                function tipReject(data) {
                    var name = '';
                    switch (data.processId) {
                        case 5 :
                            name = '初审';
                            break;
                        case 6:
                            name = '复审';
                        case 7 :
                            name = '终审';
                            break;
                    }
                    $('#rejectName').text(name+data.status);
                    $('#rejectContent').text(data.remark);
                    $('.reject-reason').addClass('go-show');
                }
            },
            // 根据获取的数据渲染页面
            renderHtml : function (data,boolean) {
                var _this = this;
                // 申请信息
                for(var k in this.dom.applyInfo) {
                    this.dom.applyInfo[k].val(data.applyInfo[k]);
                }
                // 个人信息
                for(var k in this.dom.baseInfo) {
                    this.dom.baseInfo[k].val(data.baseInfo[k]);
                }
                // 工作单位
                for(var k in this.dom.workInfo) {
                    this.dom.workInfo[k].val(data.workInfo[k]);
                }
                // 联系人
                renderRelative(data.relativesInfo);
                if(boolean){
                    // 车辆信息
                    for(var k in this.dom.carInfo) {
                        this.dom.carInfo[k].val(data.carInfo[k]);
                    }
                }
                // 单独渲染联系人模块
                function renderRelative(data) {
                    var strName = '',strMobile = '';
                    $.each(data,function (k, v) {
                        strName += '<li><i class="desc-name">'+v.typeName+': </i> <input data-id="'+v.id+'" data-type="'+v.relativeType+'" class="form-control" type="text" value="'+v.relativeName+'"></li>';
                        strMobile += '<li><i class="desc-name">'+v.typeName+'电话: </i> <input data-id="'+v.id+'" data-type="'+v.relativeType+'" class="form-control" type="text" value="'+v.relativeMobile+'"></li>';
                    })
                    $('.relative-name').html(strName);
                    $('.relative-mobile').html(strMobile);
                }
            },
            judgeOpt : function (el, val) {
                el.find('option[value='+val+']').attr('selected',true);
            },
            // 判断节点是否存在
            exist:function ($dom) {
                if($dom.length>=1){
                    return true;
                }
                return false;
            },
            // 保存信息
            saveInfo : function () {
                var _this = this;
                $('#saveInfo').click(function () {
                    // 获取修改过后的值
                    var formData = _this.getModifyInfo();
                    formData.data.orderId = '<%=orderId%>';
                    // 验证
                    var validateResult = _this.formValidate(formData.data,formData.carFlag);

                    if(validateResult.status){
                        var obj = {};
                        for(var i in formData.data) {
                            if(i=='carInfo'){
                                var userCar = {};
                                for(var q in formData.data[i]){
                                    userCar[q] = formData.data[i][q];
                                }
                                userCar['id'] = _this.variable.carId;
                                obj.userCar = JSON.stringify(userCar);
                            }else{
                                if($.isPlainObject(formData.data[i])){
                                    for(var k in formData.data[i]){
                                        obj[k] = formData.data[i][k];
                                    }
                                }else {
                                    obj[i] = formData.data[i];
                                }
                            }

                        }
                        // 单独获取联系人
                        obj.relativesInfo = JSON.stringify(getRelativeInfo());
                        // 保存工作单位id
                        obj.workId = _this.variable.workInfoId;
                        $.ajax({
                            url : util.getServerUrl('/loanOrder/saveOrderBaseInfo'),
                            method : 'POST',
                            data : obj,
                            success : function (res) {
                                if(res.status == 0) {
                                    $('#myModal').find('.modal-body').text('保存成功！');
                                    $('#myModal').modal();
                                    $('#myModal').on('hidden.bs.modal', function (e) {
                                        $("#navTab").load('<%=basePath%>loanOrder/listPreOrderPage');
                                    })
                                }else {
                                    $('#myModal').find('.modal-body').text('保存失败，请稍后再试');
                                    $('#myModal').modal();
                                }
                            },
                            error : function (error) {
                                $('#myModal').find('.modal-body').text('保存失败，请稍后再试');
                                $('#myModal').modal();
                            }
                        })
                    }else {
                        $('#myModal').find('.modal-body').text(validateResult.msg);
                        $('#myModal').modal();
                    }
                })
                function getRelativeInfo() {
                    var arr = [];
                    $('.relative-name input').each(function (k, v) {
                        var obj = {};
                        obj.relativeName = $.trim($(this).val());
                        obj.type = $(this).attr('data-type');
                        obj.id = $(this).attr('data-id');
                        arr.push(obj);
                    })
                    $('.relative-mobile input').each(function (k, v) {
                        $.each(arr,function (key, val) {
                            if(val.id==$(v).attr('data-id')){
                                val.relativeMobile = $.trim($(v).val());
                            }
                        })
                    })
                    return arr;
                }
            },
            // 获取修改后的信息
            getModifyInfo : function () {
                var _this = this;
                // 根据this.dom结构自动获取对应的val值
                var calculate = function (dom,key) {
                    var obj = {};
                    for(var k in dom) {
                        if(key==k){
                            for (var n in dom[k]){
                                obj[n] = dom[k][n].val();
                            }
                        }
                    }
                    return obj;
                };
                // 车辆信息不存在的数据
                var obj = {
                    data : {
                        applyInfo : calculate(_this.dom,'applyInfo'),
                        baseInfo : calculate(_this.dom,'baseInfo'),
                        workInfo : calculate(_this.dom,'workInfo'),
                    },
                    carFlag : false
                }
                // 车辆信息存在的数据
                if(this.exist($('.car-info'))){
                    obj.data.carInfo = calculate(_this.dom,'carInfo');
                    obj.carFlag = true;
                    return obj;
                }
                return obj;
            },
            formValidate : function (data,boolean) {
                var result = {
                    status : false,
                    msg : ''
                };
                // 申请信息
                if(!util.validate(data.applyInfo.amount,'require')){
                    result.msg = '申请信息-申请金额不能为空';
                    return result;
                }
                if(!util.validate(data.applyInfo.period,'require')){
                    result.msg = '申请信息-申请期限不能为空';
                    return result;
                }
                if(!util.validate(data.applyInfo.usageDesc,'require')){
                    result.msg = '申请信息-用途不能为空';
                    return result;
                }
                // 个人信息
                // if(!util.validate(data.baseInfo.bankAccount,'require')){
                //     result.msg = '个人信息-银行卡号不能为空';
                //     return result;
                // }
                // if(!util.validate(data.baseInfo.areaCode,'require')){
                //     result.msg = '个人信息-户籍不能为空';
                //     return result;
                // }
                if(!util.validate(data.baseInfo.education,'require')){
                    result.msg = '个人信息-学历不能为空';
                    return result;
                }
                if(!util.validate(data.baseInfo.estateType,'require')){
                    result.msg = '个人信息-居住性质不能为空';
                    return result;
                }
                if(!util.validate(data.baseInfo.address,'require')){
                    result.msg = '个人信息-住址不能为空';
                    return result;
                }
                if(!util.validate(data.baseInfo.marrStatus,'require')){
                    result.msg = '个人信息-婚姻状况不能为空';
                    return result;
                }
                if(!util.validate(data.baseInfo.phone,'require')){
                    result.msg = '个人信息-手机号码不能为空';
                    return result;
                }
                if(!util.validate(data.baseInfo.phone,'phone')){
                    result.msg = '个人信息-请输入正确手机号码';
                    return result;
                }
                if(!util.validate(data.baseInfo.identity,'require')){
                    result.msg = '个人信息-身份证号不能为空';
                    return result;
                }
                if(!util.validate(data.baseInfo.sex,'require')){
                    result.msg = '个人信息-性别不能为空';
                    return result;
                }
                if(!util.validate(data.baseInfo.name,'require')){
                    result.msg = '个人信息-姓名不能为空';
                    return result;
                }
                // if(!util.validate(data.baseInfo.householdReg,'require')){
                //     result.msg = '个人信息-户籍不能为空';
                //     return result;
                // }
                if(!util.validate(data.baseInfo.age,'require')){
                    result.msg = '个人信息-年龄不能为空';
                    return result;
                }
                // 工作单位
                // if(!util.validate(data.workInfo.orgNature,'require')){
                //     result.msg = '工作单位-单位性质不能为空';
                //     return result;
                // }
                // if(!util.validate(data.workInfo.workYears,'require')){
                //     result.msg = '工作单位-最近工作年限不能为空';
                //     return result;
                // }
                // if(!util.validate(data.workInfo.orgName,'require')){
                //     result.msg = '工作单位-单位名称不能为空';
                //     return result;
                // }
                // if(!util.validate(data.workInfo.orgContact,'require')){
                //     result.msg = '工作单位-单位电话不能为空';
                //     return result;
                // }
                if(!util.validate(data.workInfo.monthIncome,'require')){
                    result.msg = '工作单位-月收入不能为空';
                    return result;
                }
                // if(!util.validate(data.workInfo.orgAddress,'require')){
                //     result.msg = '工作单位-单位地址不能为空';
                //     return result;
                // }
                // if(!util.validate(data.workInfo.position,'require')){
                //     result.msg = '工作单位-职位不能为空';
                //     return result;
                // }
                // 联系人
                // if(!util.validate(data.relativesInfo.couple,'require')){
                //     result.msg = '联系人-配偶名称不能为空';
                //     return result;
                // }
                // if(boolean){
                //     // 车辆信息
                //     if(!util.validate(data.carInfo.buyPrice,'require')){
                //         result.msg = '车辆信息-车辆价格不能为空';
                //         return result;
                //     }
                //     if(!util.validate(data.carInfo.model,'require')){
                //         result.msg = '车辆信息-型号不能为空';
                //         return result;
                //     }
                //     if(!util.validate(data.carInfo.brand,'require')){
                //         result.msg = '车辆信息-品牌不能为空';
                //         return result;
                //     }
                //     if(!util.validate(data.carInfo.firstPayment,'require')){
                //         result.msg = '车辆信息-首付款不能为空';
                //         return result;
                //     }
                // }

                result.status = true;
                result.msg = '验证通过';
                return result;
            },
            // 获取订单流程状态
            getProcess: function () {
                var _this = this;
                $.ajax({
                    url: util.getServerUrl('/common/listOrderProcess'),
                    method:'POST',
                    data : {
                        orderId : '<%=orderId%>'
                    },
                    success: function (res) {
                        if (res.status == 0) {
                            _this.renderProcess(res.data);
                        }else {
                            if(res.msg==''){
                                _this.alertModel('订单流程状态获取失败，请稍后再试!');
                            }else {
                                _this.alertModel(res.msg);
                            };
                        }
                    },
                    error: function (error) {
                        _this.alertModel('订单流程状态获取失败，请稍后再试!');
                    }
                })
            },
            // 渲染流程
            renderProcess: function (data) {
                var str = '';
                for (var i = 0; i < data.length; i++) {
                    str += '<li class="' + (data[i].status != 0 ? "active" : "") + '">';
                    str += '<span class="time-out ' + (data[i].status != 2 ? "hide" : "") + ' ' + (i == 0 ? "hide" : " ") + '' + (data[i].execTime == undefined ? "hide" : " ") + '">';
                    str += '耗时: <i>' + util.MillisecondToDate(data[i].execTime) + '</i>';
                    str += '</span>';
                    str += '<span class="normal">' + data[i].processName + '</span>';
                    str += '</li>';
                    str += '<li class="process ' + (data[i].status == 2 ? "active" : "") + ' ' + (i == data.length - 1 ? "hide" : " ") + '"></li>';
                }
                $('#step_process').html(str);
            },
            // 初始化图片
            initImage : function () {
                $('[data-magnify=gallery]').magnify({
                    i18n : {
                        minimize : '最小化',
                        maximize  : '最大化',
                        close : '关闭',
                        zoomIn  : '缩小',
                        zoomOut  : '放大',
                        prev  : '上一张',
                        next : '下一张',
                        fullscreen  : '全屏',
                        actualSize  : '自适应',
                        rotateLeft  : '左旋转',
                        rotateRight  : '右旋转',
                    },
                    footToolbar : ['zoomIn','zoomOut','prev','fullscreen','next','actualSize','rotateLeft','rotateRight'],
                    headToolbar : ['maximize','close']
                });
            },
            // 上传图片下拉框
            getUploadSel: function (cb) {
                $.ajax({
                    url: util.getServerUrl('/common/productFileSelect'),
                    method: 'POST',
                    data:{productTempId:1},
                    success: function (res) {
                        if (res.status == 0) {
                            renderUpSel(res.data)
                            cb&&cb();
                        }
                    }
                })

                function renderUpSel(data) {
                    var str = '<option value="">-请选择佐证-</option>';
                    $.each(data,function (k, v) {
                        str += '<optgroup label="'+v.descption+'">';
                        $.each(v.items,function (key, value) {
                            str += '<option value="' + value.keyword + '">' + value.descption + '</option>';
                        })
                        str += '</optgroup>';
                    })
                    $('#uploadProve').html(str);
                }
            },
            // 模态框弹出
            alertModel: function (str) {
                $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
                $('#myModal').modal('show');
            },

        }
        beforeBaseInfo.init(function () {
            beforeBaseInfo.getUploadSel(function () {
                // 初始化Web Uploader
                var uploader = WebUploader.create({
                    // 选完文件后，是否自动上传。
                    auto: false,
                    // swf文件路径
                    swf: '<%=basePath%>static/plugins/webuploader/Uploader.swf',
                    // 文件接收服务端。
                    server: '<%=basePath%>attachment/upload',
                    pick: '#filePicker',
                    // 只允许选择图片文件。
                    accept: {
                        title: 'Images',
                        extensions: 'gif,jpg,jpeg,bmp,png',
                        mimeTypes: 'image/*'
                    },
                    fileNumLimit : 5,
                    duplicate : true,
                    fileSingleSizeLimit : 1024*1024*3,
                    formData : {},
                    compress : {
                        // 是否保留头部meta信息。
                        preserveHeaders: true,
                        // 图片质量，只有type为`image/jpeg`的时候才有效。
                        quality: 80,
                    }

                });
                // 上传之前
                uploader.on('uploadBeforeSend',function (object, data, headers) {

                })
                // 点击上传
                $('#uploadBtn').click(function () {
                    if($('#uploadProve').val()==''){
                        beforeBaseInfo.alertModel('请选择分类!');
                        return false;
                    }
                    uploader.option('formData',{
                        tag : $('#uploadProve').val()
                    })
                    uploader.upload();
                })
                // 清空
                $('#clearBtn').on('click',function () {
                    uploader.reset();
                    $('#fileList').empty();
                })
                // 当有文件添加进来的时候
                uploader.on( 'fileQueued', function( file ) {
                    if(file.size > 1024*1024*3) {
                        beforeBaseInfo.alertModel('文件大小必须小于3M!');
                        return false;
                    }
                    var $li = $(
                        '<div id="' + file.id + '" class="file-item thumbnail">' +
                        '<img>' +
                        '<div class="info">' + file.name + '</div>' +
                        '<div class="remove-this"><i class="fa fa-trash"></i></div>' +
                        '</div>'
                        ),
                        $img = $li.find('img');
                    $('#fileList').append( $li );
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
                // 文件上传过程中创建进度条实时显示。
                uploader.on( 'uploadProgress', function( file, percentage ) {
                    var $li = $( '#'+file.id ),
                        $percent = $li.find('.progress span');
                    // 避免重复创建
                    if ( !$percent.length ) {
                        $percent = $('<p class="progress"><span></span></p>')
                            .appendTo( $li )
                            .find('span');
                    }
                    $percent.css( 'width', percentage * 100 + '%' );
                });
                // 文件上传成功，给item添加成功class, 用样式标记上传成功。
                uploader.on( 'uploadSuccess', function( file,response ) {
                    if(response.returnCode==0){
                        $.ajax({
                            url : util.getServerUrl('/loanOrder/dataAdd'),
                            method : 'POST',
                            data : {
                                orderId : '<%=orderId%>',
                                attachIds : response.result
                            },
                            success : function (res) {
                                if(res.status==0){
                                    $( '#'+file.id ).addClass('upload-state-done');
                                    $('#'+file.id).append('<div class="result"><i class="fa fa-check"></i></div>')
                                }else {
                                    $( '#'+file.id ).addClass('upload-state-failed');
                                    $('#'+file.id).append('<div class="result"><i class="fa fa-minus-circle"></i></div>')
                                }
                            },
                            error : function (error) {
                                $( '#'+file.id ).addClass('upload-state-failed');
                                $('#'+file.id).append('<div class="result"><i class="fa fa-minus-circle"></i></div>')
                            }
                        })
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



            });

        });

    })

</script>
</body>
</html>