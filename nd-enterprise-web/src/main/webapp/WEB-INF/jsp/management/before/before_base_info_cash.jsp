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
                                    <li><i class="desc-name">户籍: </i> <input class="form-control" type="text" value="" id="householdReg"> <span class="badge">*</span></li>
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
                        _this.renderHtml(res.data);
                        // 驳回拒绝提示
                        if(toString.call(res.data.refuseReson) == '[object Object]'){
                            tipReject(res.data.refuseReson);
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
        renderHtml : function (data) {
            var _this = this;
            // 申请信息
            for(var k in this.dom.applyInfo) {
                this.dom.applyInfo[k].val(data.applyInfo[k]);
            }
            // 个人信息
            for(var k in this.dom.baseInfo) {
                this.dom.baseInfo[k].val(data.baseInfo[k]);
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
                var validateResult = _this.formValidate(formData.data);

                if(validateResult.status){
                    var obj = {};
                    for(var i in formData.data) {
                        if($.isPlainObject(formData.data[i])){
                            for(var k in formData.data[i]){
                                obj[k] = formData.data[i][k];
                            }
                        }else {
                            obj[i] = formData.data[i];
                        }
                    }

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
                }
            }

            return obj;
        },
        formValidate : function (data) {
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
            if(!util.validate(data.baseInfo.householdReg,'require')){
                result.msg = '个人信息-户籍不能为空';
                return result;
            }
            if(!util.validate(data.baseInfo.age,'require')){
                result.msg = '个人信息-年龄不能为空';
                return result;
            }


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
        // 模态框弹出
        alertModel: function (str) {
            $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#myModal').modal('show');
        },
    }
    $(function () {
        beforeBaseInfo.init();
    })

</script>
</body>
</html>