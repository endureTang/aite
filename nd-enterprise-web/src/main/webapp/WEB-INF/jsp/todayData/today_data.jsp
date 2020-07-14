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
<!--<link rel="stylesheet" href="static/plugins/swiper/swiper-3.4.2.min.css">-->
<link rel="stylesheet" href="static/css/today-data.css">
<div class="container-fluid">
    <div class="swiper-container">
        <div class="swiper-wrapper">
            <div class="swiper-slide first">
                <div class="order-total">
                    <h2>订单统计</h2>
                    <div class="row">
                        <div class="col-md-3">
                            <img src="<%=basePath%>static/img/today_data/icon_01.png" alt="">
                            <h2 id="todayOrderCount" style="color: #33a2ff;"></h2>
                            <span>今日进件</span>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-3">
                            <img src="<%=basePath%>static/img/today_data/icon_02.png" alt="">
                            <h2 id="auditPassCount" style="color: #39c567;"></h2>
                            <span>通过审批</span>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-3">
                            <img src="<%=basePath%>static/img/today_data/icon_03.png" alt="">
                            <h2 id="waitAuditCount" style="color: #4cd3ff;"></h2>
                            <span>待审批</span>
                        </div>
                    </div>
                </div>
                <div class="money-total">
                    <h2>金额统计</h2>
                    <div class="row">
                        <div class="col-md-3">
                            <img src="<%=basePath%>static/img/today_data/icon_04.png" alt="">
                            <h2 id="applyAmount" style="color: #fe6147;"></h2>
                            <span>申请贷款总额(元)</span>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-3">
                            <img src="<%=basePath%>static/img/today_data/icon_05.png" alt="">
                            <h2 id="successCount" style="color: #ffcb3f;"></h2>
                            <span>成功放款笔数</span>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-3">
                            <img src="<%=basePath%>static/img/today_data/icon_06.png" alt="">
                            <h2 id="successAmount" style="color: #ffdab6;"></h2>
                            <span>累积放款金额(元)</span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="swiper-slide second">
                <div class="row toolbar">
                    <div class="col-xs-12">
                        <div class="title">各类资产统计</div>
                        <div class="filter">
                            <!--<select name="secCategory" id="secCategory" class="form-control category">-->
                            <!--<option value="0">-请选择-</option>-->
                            <!--<option value="1">汽车金融借贷类</option>-->
                            <!--<option value="2">3C手机消费借贷类</option>-->
                            <!--<option value="3">个人助力借贷类</option>-->
                            <!--</select>-->
                            <input type='text' class='form-control datetimepicker' id='secStartTime' name='date'
                                   value='' placeholder="开始时间">
                            <input type='text' class='form-control datetimepicker' id='secEndTime' name='date'
                                   value='' placeholder="结束时间">
                            <button class="btn" id="secSearchTable">筛选</button>
                        </div>
                    </div>
                </div>
                <div class="echarts">
                    <div class="row">
                        <div class="col-xs-6">
                            <div id="sec01"></div>
                        </div>
                        <div class="col-xs-6 pull-money">
                            <div id="sec02"></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="swiper-slide third">
                <div class="row toolbar">
                    <div class="col-xs-12">
                        <div class="title">进件走势统计</div>
                        <div class="filter">
                            <!--<select name="secCategory" id="thirdCategory" class="form-control category">-->
                            <!--<option value="0">-请选择-</option>-->
                            <!--<option value="1">汽车金融借贷类</option>-->
                            <!--<option value="2">3C手机消费借贷类</option>-->
                            <!--<option value="3">个人助力借贷类</option>-->
                            <!--</select>-->
                            <select name="productSel" id="productSel" class="form-control"></select>
                            <select name="channelSel" id="channelSel" class="form-control"></select>
                            <input type='text' class='form-control datetimepicker' id='thirdStartTime'
                                   name='date' value='' placeholder="开始时间">
                            <input type='text' class='form-control datetimepicker' id='thirdEndTime' name='date'
                                   value='' placeholder="结束时间">
                            <button class="btn" id="thirdSearchTable">筛选</button>
                        </div>
                    </div>
                </div>
                <div class="echarts">
                    <div class="row">
                        <div class="col-xs-6">
                            <div id="third01"></div>
                        </div>
                        <div class="col-xs-6 pull-money">
                            <div id="third02"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="swiper-pagination"></div>
    </div>
    <!--取消模态框-->
    <div class="modal fade asset-classify" tabindex="-1" role="dialog" id="myModal_cancel" data-backdrop="static"
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
                    <button type="button" class="btn btn-confirm asset-close" data-dismiss="modal">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>
<script src="static/plugins/swiper/swiper-3.4.2.jquery.min.js"></script>
<!--<script src="static/plugins/echarts/echarts.min.js"></script>-->
<script src="static/js/countUp.min.js"></script>
<script src="static/js/lodash.min.js"></script>
<script>
    var todayData = {
        opts: {
            eHeight: 400, // echarts高度
            eLeftGap: 45, // y轴 名称位置 第二页左边echarts
            eLeftGapPos: 'center', // y轴 名称位置 第二页左边echarts
            eRightGap: 85, // y轴 名称位置 第二页右边echarts
            eRightGapPos: 'center', // y轴 名称位置 第二页右边echarts
            dataZoomScaleLeft: 20, // 第二页左边组件缩放结束值
            dataZoomScaleRight: 30, // 第二页右边组件缩放结束值
            dataZoomScaleLeftThird: 50, // 第三页左边组件缩放结束值
            dataZoomScaleRightThird: 50, // 第三页右边组件缩放结束值
        },
        init: function () {
            this.matchBook();
            this.initSwiper();
            this.initFirstData();
            this.bindEvent();
        },
        // 适配笔记本
        matchBook: function () {
            if ($(window).width() <= 1366) {
                this.opts.eHeight = 300;
                this.opts.eLeftGap = 20;
                this.opts.eLeftGapPos = 'end';
                this.opts.eRightGap = 20;
                this.opts.eRightGapPos = 'end';
                this.opts.dataZoomScaleLeft = 10;
                this.opts.dataZoomScaleRight = 30;
                this.opts.dataZoomScaleLeftThird = 40;
                this.opts.dataZoomScaleRightThird = 40;
            }
        },
        // 初始化swiper
        initSwiper: function () {
            var _this = this;
            var flag02 = 0;
            var flag01 = 0;
            var todaySwiper = new Swiper('.swiper-container', {
                direction: 'vertical',
                loop: false,
                speed: 600,
                // 禁止模拟拖动
                simulateTouch: false,
                // 鼠标控制
                mousewheelControl: true,
                // 分页器
                pagination: '.swiper-pagination',
                paginationClickable: true,
                // 初始化完成
                onInit: function (swiper) {
                    // 初始化时间选择器
                    _this.renderPickTime('secStartTime');
                    _this.renderPickTime('secEndTime');
                    _this.renderPickTime('thirdStartTime');
                    _this.renderPickTime('thirdEndTime');
                },
                onSlideChangeStart : function (swiper) {
                    if(swiper.activeIndex == 1){
                        if( ++flag01 == 1){
                            /* var script = document.createElement('script');
                            $(script).attr('src','static/plugins/echarts/echarts.min.js');
                            $('#navTab').prepend($(script)); */
                            _this.initSecondData();;
                        }
                    }
                    if(swiper.activeIndex == 2){
                        if( ++flag02 == 1){
                            _this.getChannelList();
                            _this.getProductList();
                            _this.initThirdData();
                        }
                    }
                },
                initialSlide: 0,
            })
        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 第二页搜索
            $('#secSearchTable').click(function () {
                var params = {
                    page: 2,
                    beginDate: $('#secStartTime').val(),
                    endDate: $('#secEndTime').val()
                };
                if(new Date(params.endDate) - new Date(params.beginDate) < 0){
                    _this.alertModelCancel('请选择正确的开始和结束时间!');
                    return;
                }
                _this.renderEchartsSecond(function (sec01, sec02) {
                    _this.$ajaxSec(sec01, sec02, params);
                })
            })
            // 第三页搜索
            $('#thirdSearchTable').click(function () {
                var params = {
                    page: 3,
                    beginDate: $('#thirdStartTime').val(),
                    endDate: $('#thirdEndTime').val(),
                    productId: $('#productSel').val(),
                    channelId: $('#channelSel').val(),
                };
                if(new Date(params.endDate) - new Date(params.beginDate) < 0){
                    _this.alertModelCancel('请选择正确的开始和结束时间!');
                    return;
                }
                _this.renderEchartsThird(function (third01, third02) {
                    _this.$ajaxThird(third01, third02, params);
                })
            })
        },
        // 初始化第一页数据
        initFirstData: function () {
            var countOpts = {
                useEasing: true,
                useGrouping: true,
                separator: ',',
                decimal: '.',
            };
            $.ajax({
                url: util.getServerUrl('/loanOrder/statistics'),
                data: {page: 1},
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        new CountUp('todayOrderCount', 0, res.data.todayOrderCount, 0, 1.5, countOpts).start();
                        new CountUp('auditPassCount', 0, res.data.auditPassCount, 0, 1.5, countOpts).start();
                        new CountUp('waitAuditCount', 0, res.data.waitAuditCount, 0, 1.5, countOpts).start();
                        new CountUp('applyAmount', 0, res.data.applyAmount, 2, 1.5, countOpts).start();
                        new CountUp('successCount', 0, res.data.successCount, 0, 1.5, countOpts).start();
                        new CountUp('successAmount', 0, res.data.successAmount, 2, 1.5, countOpts).start();
                    }
                }
            })
        },
        // 初始化第二页各类资产统计数据
        initSecondData: function () {
            var _this = this;
            this.renderEchartsSecond(function (sec01, sec02) {
                _this.$ajaxSec(sec01, sec02, {page: 2});
            });
        },
        // 初始化第三页进件走势统计数据
        initThirdData: function () {
            var _this = this;
            this.renderEchartsThird(function (third01, third02) {
                _this.$ajaxThird(third01, third02, {page: 3});
            });
        },
        // 第二页echarts
        renderEchartsSecond: function (cb) {
            var _this = this;
            var sec01 = echarts.init(document.getElementById('sec01'), {
                height: this.opts.eHeight
            });
            var sec02 = echarts.init(document.getElementById('sec02'), {
                height: this.opts.eHeight,
            });
            var option01 = {
                backgroundColor: '#fff',
                title: {
                    text: '进件情况',
                    left: 'center'
                },
                tooltip: {},
                legend: {
                    data: ['进件量', '通过率'],
                    bottom: '20px',

                },
                grid: {
                    show: false,
                    top : 80,
                },
                dataZoom: [
                    {
                        xAxisIndex: [0],
                        type: 'slider', // 这个 dataZoom 组件是 slider 型 dataZoom 组件
                        start: 0,      // 左边在 0% 的位置。
                        end: 20,         // 右边在 20% 的位置。
                        orient: 'horizontal', // 布局方式
                        bottom: 65
                    }
                ],
                xAxis: {
                    data: [],
                    type: 'category',
                    axisLabel: {
                        show: true,
                        interval: 0,
                    },
                },
                yAxis: [{
                    name: '件数',
                    type: 'value',
                    nameLocation: this.opts.eLeftGapPos,
                    nameGap: this.opts.eLeftGap,
                    splitNumber: 10,
                    max: 14000,
                    min: 0,
                    splitLine: {show: false},
                },
                    {
                        name: '通过率',
                        type: 'value',
                        nameLocation: this.opts.eLeftGapPos,
                        nameGap: this.opts.eLeftGap,
                        splitNumber: 10,
                        max: 100,
                        min: 0,
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            formatter: '{value} %'
                        },
                        show: true,
                        splitLine: {show: false},
                    }
                ],
                series: [{
                    name: '进件量',
                    type: 'bar',
                    data: [],
                    barWidth: 40,
                    itemStyle: {
                        color: '#71B345',
                    },
                    yAxisIndex: 0,
                    label: {
                        show: true,
                        position: [5, -25],
                        color: '#333'
                    }
                }, {
                    name: '通过率',
                    type: 'line',
                    data: [],
                    itemStyle: {
                        color: '#e18312',
                    },
                    tooltip: {
                        formatter: '{a}<br/>{b}:{c}%',
                    },
                    yAxisIndex: 1,
                    smooth: true,
                    label: {
                        show: true,
                        formatter: '{c}%',
                        position: 'top',
                        distance: 20,
                        color: '#333',
                    }
                }]
            };
            var option02 = {
                backgroundColor: '#fff',
                title: {
                    text: '放款金额',
                    left: 'center'
                },
                tooltip: {},
                legend: {
                    data: ['放款金额'],
                    bottom: '20px',
                },
                grid: {
                    show: false,
                    left: '15%',
                    top : 80,
                },
                dataZoom: [
                    {
                        xAxisIndex: [0],
                        type: 'slider', // 这个 dataZoom 组件是 slider 型 dataZoom 组件
                        start: 0,      // 左边在 0% 的位置。
                        end: 30,         // 右边在 25% 的位置。
                        orient: 'horizontal', // 布局方式
                        bottom: 65
                    }
                ],
                xAxis: {
                    data: [],
                    type: 'category',
                    axisLabel: {
                        show: true,
                        interval: 0,
                    },
                },
                yAxis: [{
                    name: '放款金额 单位:元',
                    type: 'value',
                    nameLocation: this.opts.eRightGapPos,
                    nameGap: this.opts.eRightGap,
                    splitNumber: 7,
                    max: 70000000,
                    min: 0,
                    splitLine: {show: false},
                }],
                series: [{
                    name: '放款金额',
                    type: 'bar',
                    data: [],
                    barWidth: 40,
                    itemStyle: {
                        color: '#396BC5',
                    },
                    yAxisIndex: 0,
                    label: {
                        show: true,
                        position: [0, -25],
                        color: '#333'
                    }
                }]
            };
            sec01.setOption(option01);
            sec01.showLoading();
            sec02.setOption(option02);
            sec02.showLoading();
            cb && cb(sec01, sec02);
        },
        // 第三页echarts
        renderEchartsThird: function (cb) {
            var _this = this;
            var third01 = echarts.init(document.getElementById('third01'), {
                height: this.opts.eHeight
            });
            var third02 = echarts.init(document.getElementById('third02'), {
                height: this.opts.eHeight,
            });
            var option01 = {
                backgroundColor: '#fff',
                title: {
                    text: '进件情况',
                    left: 'center'
                },
                tooltip: {},
                legend: {
                    data: ['进件量', '通过率'],
                    bottom: '20px',

                },
                grid: {
                    show: false,
                    top : 80,
                },
                dataZoom: [
                    {
                        xAxisIndex: [0],
                        type: 'slider', // 这个 dataZoom 组件是 slider 型 dataZoom 组件
                        start: 0,      // 左边在 0% 的位置。
                        end: 20,         // 右边在 20% 的位置。
                        orient: 'horizontal', // 布局方式
                        bottom: 65
                    }
                ],
                xAxis: {
                    data: [],
                    type: 'category',
                    axisLabel: {
                        show: true,
                        interval: 0,
                    },
                },
                yAxis: [{
                    name: '件数',
                    type: 'value',
                    nameLocation: this.opts.eLeftGapPos,
                    nameGap: this.opts.eLeftGap,
                    splitNumber: 6,
                    max: 12000,
                    min: 0,
                    splitLine: {show: false},
                },
                    {
                        name: '通过率',
                        type: 'value',
                        nameLocation: this.opts.eLeftGapPos,
                        nameGap: this.opts.eLeftGap,
                        splitNumber: 10,
                        max: 100,
                        min: 0,
                        axisLabel: {
                            show: true,
                            interval: 'auto',
                            formatter: '{value} %'
                        },
                        show: true,
                        splitLine: {show: false},
                    }
                ],
                series: [{
                    name: '进件量',
                    type: 'bar',
                    data: [],
                    barWidth: 40,
                    itemStyle: {
                        color: '#71B345',
                    },
                    yAxisIndex: 0,
                    label: {
                        show: true,
                        position: [5, -25],
                        color: '#333'
                    }
                }, {
                    name: '通过率',
                    type: 'line',
                    data: [],
                    itemStyle: {
                        color: '#e18312',
                    },
                    tooltip: {
                        formatter: '{a}<br/>{b}:{c}%',
                    },
                    yAxisIndex: 1,
                    smooth: true,
                    label: {
                        show: true,
                        formatter: '{c}%',
                        position: 'top',
                        distance: 20,
                        color: '#333',
                    }
                }]
            };
            var option02 = {
                backgroundColor: '#fff',
                title: {
                    text: '放款金额',
                    left: 'center'
                },
                tooltip: {},
                legend: {
                    data: ['放款金额'],
                    bottom: '20px',
                },
                grid: {
                    show: false,
                    left: '15%',
                    top : 80,
                },
                dataZoom: [
                    {
                        xAxisIndex: [0],
                        type: 'slider', // 这个 dataZoom 组件是 slider 型 dataZoom 组件
                        start: 0,      // 左边在 0% 的位置。
                        end: 30,         // 右边在 25% 的位置。
                        orient: 'horizontal', // 布局方式
                        bottom: 65
                    }
                ],
                xAxis: {
                    data: [],
                    type: 'category',
                    axisLabel: {
                        show: true,
                        interval: 0,
                    },
                },
                yAxis: [{
                    name: '放款金额 单位:元',
                    type: 'value',
                    nameLocation: this.opts.eRightGapPos,
                    nameGap: this.opts.eRightGap,
                    splitNumber: 10,
                    max: 50000000,
                    min: 0,
                    splitLine: {show: false},
                }],
                series: [{
                    name: '放款金额',
                    type: 'line',
                    data: [],
                    itemStyle: {
                        color: '#396BC5',
                    },
                    yAxisIndex: 0,
                    smooth: true,
                    label: {
                        show: true,
                        position: [-20, -25],
                        color: '#333',
                        formatter: function (params) {
                            return _this.formatMoney(params.value);
                        }
                    }
                }]
            };
            third01.setOption(option01);
            third01.showLoading();
            third02.setOption(option02);
            third02.showLoading();
            cb && cb(third01, third02);
        },
        // 第二页ajax
        $ajaxSec: function (sec01, sec02, params) {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/loanOrder/statistics'),
                data: params,
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        sec01.hideLoading();
                        sec02.hideLoading();
                        sec01.setOption({
                            dataZoom: [
                                {
                                    end: _.map(res.data.listAmount, 'productName').length <= 6 ? 100 : _this.opts.dataZoomScaleLeft
                                }
                            ],
                            xAxis: {
                                data: _.map(res.data.listAmount, 'productName'),
                            },
                            series: [{
                                name: '进件量',
                                data: _.map(res.data.listAmount, 'total'),
                            }, {
                                name: '通过率',
                                data: _.map(res.data.listAmount, 'passRate'),
                            }]
                        });
                        sec02.setOption({
                            dataZoom: [
                                {
                                    end: _.map(res.data.listCount, 'productName').length <= 6 ? 100 : _this.opts.dataZoomScaleRight
                                }
                            ],
                            xAxis: {
                                data: _.map(res.data.listCount, 'productName'),
                            },
                            series: [{
                                name: '放款金额',
                                data: _.map(res.data.listCount, 'auditAmount'),
                            }]
                        });
                    }
                }
            })
        },
        // 第三页ajax
        $ajaxThird: function (third01, third02, params) {
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/loanOrder/statistics'),
                data: params,
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        third01.hideLoading();
                        third02.hideLoading();
                        third01.setOption({
                            dataZoom: [
                                {
                                    end: _.map(res.data.listCount, 'dateName').length <= 6 ? 100 : _this.opts.dataZoomScaleLeftThird
                                }
                            ],
                            xAxis: {
                                data: _.map(res.data.listCount, 'dateName').reverse(),
                            },
                            series: [{
                                name: '进件量',
                                data: _.map(res.data.listCount, 'total').reverse(),
                            }, {
                                name: '通过率',
                                data: _.map(res.data.listCount, 'passRate').reverse(),
                            }]
                        });
                        third02.setOption({
                            dataZoom: [
                                {
                                    end: _.map(res.data.listAmount, 'dateName').length <= 6 ? 100 : _this.opts.dataZoomScaleRightThird
                                }
                            ],
                            xAxis: {
                                data: _.map(res.data.listAmount, 'dateName').reverse(),
                            },
                            series: [{
                                name: '放款金额',
                                data: _.map(res.data.listAmount, 'auditAmount').reverse(),
                            }]
                        });
                    }
                }
            })
        },
        // 获取渠道列表
        getChannelList: function () {
            var str = '<option value="">-请选择渠道-</option>';
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/channel/channelList'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        for (var i = 0; i < res.data.length; i++) {
                            str += '<option value="'+res.data[i].id+'">'+res.data[i].name+'</option>';
                        }
                        $('#channelSel').html(str);
                    }else{
                        _this.alertModelCancel('获取渠道列表失败，请稍后重试!');
                    }
                },
                error : function (error) {
                    _this.alertModelCancel('获取渠道列表失败，请稍后重试!');
                }
            })
        },
        // 获取产品列表
        getProductList : function () {
            var str = '<option value="">-请选择产品-</option>';
            var _this = this;
            $.ajax({
                url: util.getServerUrl('/product/selectProduct'),
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        for (var i = 0; i < res.data.length; i++) {
                            str += '<option value="'+res.data[i].id+'">'+res.data[i].productName+'</option>';
                        }
                        $('#productSel').html(str);
                    }else{
                        _this.alertModelCancel('获取产品列表失败，请稍后重试!');
                    }
                },
                error : function (error) {
                    _this.alertModelCancel('获取产品列表失败，请稍后重试!');
                }
            })
        },
        // 渲染选择时间组件
        renderPickTime: function (id) {
            var i18n = { // 本地化
                previousMonth: '上个月',
                nextMonth: '下个月',
                months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
                weekdays: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
                weekdaysShort: ['日', '一', '二', '三', '四', '五', '六']
            }
            new Pikaday({
                field: $('#' + id)[0],
                i18n: i18n,
                format: 'YYYY-M-D',
            });

        },
        // 格式化金额
        formatMoney: function (num) {
            var num = (num || 0).toString(), result = '';
            while (num.length > 3) {
                result = ',' + num.slice(-3) + result;
                num = num.slice(0, num.length - 3);
            }
            if (num) {
                result = num + result;
            }
            return result;
        },
        // 取消模态框
        alertModelCancel : function (str) {
            $('#myModal_cancel .modal-body').empty().html('<p>' + str + '</p>');
            $('#myModal_cancel').modal('show');
        }

    }
    $(function () {
        todayData.init();
    })
</script>
