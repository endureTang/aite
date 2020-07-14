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
<link rel="stylesheet" href="static/css/management-first-trial.css">
<div class="container-fluid">
    <div class="nav-bar">
        <a data-model="navTab" data-url="<%=basePath%>loanOrder/listOrderPage">< 返回所有订单</a>
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
                                <li><i class="desc-name">申请金额: </i> <input disabled type="text" class="form-control" value="" id="amount"> 元 <span class="badge">*</span></li>
                                <li><i class="desc-name">申请期限: </i>  <input disabled type="text" class="form-control" value="" id="period"> 期 <span class="badge">*</span></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">用途: </i> <input disabled type="text" id="usageDesc" class="form-control" value=""> <span class="badge">*</span></li>
                                <li><i class="desc-name">合作商户: </i>  <input data-toggle="tooltip" data-placement="right" disabled type="text" id="channelName" class="form-control" value=""></li>
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
                                    <li><i class="desc-name">姓名: </i> <input disabled class="form-control" type="text" value="" id="name"> <span class="badge">*</span></li>
                                    <li><i class="desc-name">学历: </i>
                                        <select disabled name="education" id="education" class="form-control">
                                            <option value="1">高中及以下</option>
                                            <option value="2">大专</option>
                                            <option value="3">本科</option>
                                            <option value="4">研究生及以上</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">银行卡: </i> <input disabled class="form-control" type="text" value="" id="bankAccount"> <span class="badge">*</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">身份证号: </i> <input disabled class="form-control" type="text"
                                                     value="" id="identity"> <span class="badge">*</span></li>
                                    <li><i class="desc-name">婚姻状况: </i>
                                        <select disabled name="marrStatus" id="marrStatus" class="form-control">
                                            <option value="1">已婚</option>
                                            <option value="2">未婚</option>
                                            <option value="3">离异</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">手机号码:</i> <input disabled class="form-control" type="text" value="" id="phone"> <span class="badge">*</span></li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">性别:</i>
                                        <select disabled name="sex" id="sex" class="form-control">
                                            <option value="1">男</option>
                                            <option value="2">女</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">年龄: </i><input disabled class="form-control" type="text" value="" id="age"> <span class="badge">*</span></li>
                                    <li><i class="desc-name">居住性质: </i>
                                        <select disabled name="estateType" id="estateType" class="form-control">
                                            <option value="1">自有无贷</option>
                                            <option value="2">自有还款中</option>
                                            <option value="3">未购房</option>
                                        </select>
                                        <span class="badge">*</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">户籍: </i><input data-toggle="tooltip" data-placement="right" disabled class="form-control" type="text" value="" id="householdReg"> <span class="badge">*</span></li>
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
                                <input disabled class="special-length form-control" type="text" value="" id="address"> <span class="badge">*</span>
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
                                        <select disabled name="orgNature" id="orgNature" class="form-control">
                                            <option value="1">行政机关</option>
                                            <option value="2">国有企业</option>
                                            <option value="3">事业单位</option>
                                            <option value="4">三资企业</option>
                                            <option value="5">私营企业</option>
                                            <option value="6">个体户</option>
                                            <option value="7">其他</option>
                                        </select>
                                        <span class="badge">*</span></li>
                                    <li><i class="desc-name">单位名称: </i> <input data-toggle="tooltip" data-placement="right" disabled class="form-control" type="text" value="" id="orgName"> <span class="badge">*</span></li>
                                    <li><i class="desc-name">单位电话: </i> <input disabled class="form-control" type="text" value="" id="orgContact"> <span class="badge">*</span>
                                    </li>
                                </ul>
                                <ul>
                                    <li><i class="desc-name">职位: </i> <input disabled class="form-control" type="text"
                                                   value="" id="position"> <span class="badge">*</span></li>
                                    <li>
                                        <i class="desc-name">月收入: </i>
                                        <select disabled name="monthIncome" id="monthIncome" class="form-control">
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
                                        <select disabled name="workYears" id="workYears" class="form-control">
                                            <option value="1">1年内</option>
                                            <option value="2">1-3年</option>
                                            <option value="3">3-5年</option>
                                            <option value="4">5年以上</option>
                                        </select>
                                        <span class="badge">*</span>
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
                                <input disabled class="special-length form-control" type="text" value="" id="orgAddress"> <span class="badge">*</span>
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
                                <li><i class="desc-name">品牌: </i> <input disabled id="brand" class="form-control" type="text" value=""> <span class="badge">*</span></li>
                                <li>
                                    <i class="desc-name">价格: </i>
                                    <input disabled id="buyPrice" class="form-control" type="text" value="">
                                    <span class="badge">*</span>
                                </li>
                                <li><i class="desc-name">首付款: </i> <input disabled id="firstPayment" class="form-control" type="text" value=""> <span class="badge">*</span></li>
                            </ul>
                            <ul>
                                <li><i class="desc-name">型号: </i> <input disabled id="model" class="form-control" type="text" value=""> <span class="badge">*</span></li>
                                <li>
                                    <i class="desc-name">款型: </i>
                                    <select disabled name="carType" id="carType" class="form-control">
                                        <option value="1">小型车</option>
                                        <option value="2">紧凑车</option>
                                        <option value="3">中级车</option>
                                        <option value="4">豪华车</option>
                                        <option value="5">客车</option>
                                        <option value="6">货车</option>
                                    </select>
                                    <span class="badge">*</span>
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
                                <!--<li><i class="desc-name">配偶: </i> <input disabled id="couple" class="form-control" type="text" value=""> <span class="badge">*</span></li>-->
                            </ul>
                            <ul class="relative-mobile">
                                <!--<li><i class="desc-name">配偶电话: </i> <input disabled id="couple_mob" class="form-control" type="text" value=""> <span class="badge">*</span></li>-->
                            </ul>
                        </div>
                    </div>
                    <!--上传资产佐证-->
                    <div class="panel panel-info contact-info asset-prove">
                        <div class="panel-heading">
                            <h3 class="panel-title">上传资产佐证(选填)</h3>
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
</div>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script>
    $(function () {
        var beforeBaseInfo = {
            init:function () {
                var _this = this;
            	this.getProcess();
                this.getInfo(function () {
                    _this.initImage();
                });

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
                    carType : $('#carType'),
                    brand : $('#brand'),
                    model : $('#model'),
                    firstPayment : $('#firstPayment'),
                },
                // relativesInfo : {
                //
                // },

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
                            if(res.data.carInfo==''){
                                $('.car-info').remove();
                                _this.renderHtml(res.data,false);
                            }else {
                                _this.renderHtml(res.data,true);
                            }

                            // 驳回拒绝提示
                            if(toString.call(res.data.refuseReson) == '[object Object]'){
                                tipReject(res.data.refuseReson);
                            }

                            if(res.data.attachMaterial.length > 0){
                                renderAssetProve(res.data.attachMaterial,'assetProve');
                                $('.asset-prove').show();
                            }
                            if(res.data.attachMaterialOther.length > 0){
                                renderAssetProve(res.data.attachMaterialOther,'otherProve');
                                $('.other-prove').show();
                            }

                            _this.getTooltip();
                            cb&&cb();
                        }
                    }
                })
                function renderAssetProve(data,target) {
                    var str = '';
                    $.each(data,function (k, v) {
                        var attachIds = v.attachId.split(',');
                        str += '<li>';
                        str += '<p>'+v.fileTag+'</p>';
                        $.each(attachIds,function (key, val) {
                            str += '<img data-magnify="gallery" src="'+(util.getImgTmpUrl("/attachment/download?attachId=")+val)+'" data-src="'+(util.getImgTmpUrl("/attachment/download?attachId=")+val)+'" alt="">';
                        })
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
                        strName += '<li><i class="desc-name">'+v.typeName+': </i> <input disabled class="form-control" type="text" value="'+v.name+'"></li>';
                        strMobile += '<li><i class="desc-name">'+v.typeName+'电话: </i> <input disabled class="form-control" type="text" value="'+v.mobile+'"></li>';
                    })
                    $('.relative-name').html(strName);
                    $('.relative-mobile').html(strMobile);
                }
            },
            judgeOpt : function (el, val) {
                el.find('option[value='+val+']').attr('selected',true);
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
            // 判断节点是否存在
            exist:function ($dom) {
                if($dom.length>=1){
                    return true;
                }
                return false;
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
                            if(res.orderStatus==4){
                                _this.renderRefuseProcess(res.data);
                            }else{
                                _this.renderProcess(res.data);
                            }
                        }else {
                           if(res.msg==''){
                               _this.alertModel('订单流程状态获取失败，请稍后再试!');
                           }else{
                               _this.alertModel(res.msg);
                           }
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
            // 渲染平台拒绝流程
            renderRefuseProcess : function (data) {
                var arr = [];
                $.each(data,function (k, v) {
                    if(v.status==2) arr.push(v);
                })
                var str = '';
                for (var i = 0; i < arr.length; i++) {
                    str+='<li class="active">';
                        str+='<span class="time-out '+(i==0?"hide":" ")+'">';
                            str+='耗时: <i>'+util.MillisecondToDate(arr[i].execTime)+'</i>';
                        str+='</span>';
                        str+='<span class="normal">'+arr[i].processName+'</span>';
                    str+='</li>';
                    str+='<li class="process active"></li>';
                }
                str+='<li class="active">';
                str+='<span class="normal">平台拒绝</span>';
                str+='</li>';
                $('#step_process').html(str);
            },
            // tooltip获取对应的内容
            getTooltip : function () {
              $('input[data-toggle="tooltip"]').each(function (k, v) {
                  $(this).tooltip({
                      title : $(this).val()
                  })
              })
            },
            // 模态框弹出
            alertModel: function (str) {
                $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
                $('#myModal').modal('show');
            },

        }

        beforeBaseInfo.init();
    })

</script>
</body>
</html>