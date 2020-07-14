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
<link rel="stylesheet" href="static/plugins/swiper/swiper-3.4.2.min.css">
<link rel="stylesheet" href="static/css/dynamic-data.css">
<div class="container-fluid">
    <div id="mask" class="scene">
        <svg
                version="1.1"
                id="dc-spinner"
                xmlns="http://www.w3.org/2000/svg"
                x="0px" y="0px"
                width:
        "38"
        height:"38"
        viewBox="0 0 38 38"
        preserveAspectRatio="xMinYMin meet"
        >
        <text x="14" y="21" font-family="Monaco" font-size="2px" style="letter-spacing:0.6" fill="grey">LOADING
            <animate
                    attributeName="opacity"
                    values="0;1;0" dur="1.8s"
                    repeatCount="indefinite"/>
        </text>
        <path fill="#373a42" d="M20,35c-8.271,0-15-6.729-15-15S11.729,5,20,5s15,6.729,15,15S28.271,35,20,35z M20,5.203
    C11.841,5.203,5.203,11.841,5.203,20c0,8.159,6.638,14.797,14.797,14.797S34.797,28.159,34.797,20
    C34.797,11.841,28.159,5.203,20,5.203z">
        </path>

        <path fill="#373a42" d="M20,33.125c-7.237,0-13.125-5.888-13.125-13.125S12.763,6.875,20,6.875S33.125,12.763,33.125,20
    S27.237,33.125,20,33.125z M20,7.078C12.875,7.078,7.078,12.875,7.078,20c0,7.125,5.797,12.922,12.922,12.922
    S32.922,27.125,32.922,20C32.922,12.875,27.125,7.078,20,7.078z">
        </path>

        <path fill="#2AA198" stroke="#2AA198" stroke-width="0.6027" stroke-miterlimit="10" d="M5.203,20
			c0-8.159,6.638-14.797,14.797-14.797V5C11.729,5,5,11.729,5,20s6.729,15,15,15v-0.203C11.841,34.797,5.203,28.159,5.203,20z">
            <animateTransform
                    attributeName="transform"
                    type="rotate"
                    from="0 20 20"
                    to="360 20 20"
                    calcMode="spline"
                    keySplines="0.4, 0, 0.2, 1"
                    keyTimes="0;1"
                    dur="2s"
                    repeatCount="indefinite"/>
        </path>

        <path fill="#859900" stroke="#859900" stroke-width="0.2027" stroke-miterlimit="10" d="M7.078,20
  c0-7.125,5.797-12.922,12.922-12.922V6.875C12.763,6.875,6.875,12.763,6.875,20S12.763,33.125,20,33.125v-0.203
  C12.875,32.922,7.078,27.125,7.078,20z">
            <animateTransform
                    attributeName="transform"
                    type="rotate"
                    from="0 20 20"
                    to="360 20 20"
                    dur="1.8s"
                    repeatCount="indefinite"/>
        </path>
        </svg>
    </div>
    <div class="echarts">
        <div class="row title">
            <div class="col-md-12">
                <h1 class="text-center">${title} 数据可视化</h1>
            </div>
        </div>
        <div class="row echarts-content">
            <div class="col-md-3 left-echarts">
                <div class="left01-wrapper">
                    <h3 class="title">近5日各环节拒绝率水平</h3>
                    <div class="echart-tag" id="left01"></div>
                </div>
                <div class="left02-wrapper">
                    <h3 class="title">近3个月信用模型档位分布</h3>
                    <div class="echart-tag" id="left02"></div>
                </div>
                <div class="left03-wrapper">
                    <h3 class="title">近1个月每日放款走势(万元)</h3>
                    <div class="echart-tag" id="left03"></div>
                </div>
            </div>
            <div class="col-md-6 center-echarts">
                <div class="center01-wrapper">
                    <div class="static-wrapper clearfix">
                        <div class="pull-left left">
                            <p>累计撮合金额(元)</p>
                            <h2 id="totalMoney"></h2>
                        </div>
                        <div class="pull-left right">
                            <p>累计撮合件数(件)</p>
                            <h2 id="totalMount"></h2>
                        </div>
                    </div>
                    <div class="echart-tag" id="center01"></div>
                </div>
                <div class="row">
                    <div class="center02-wrapper col-md-6">
                        <!--<h3 class="title">Vintage账龄图(剩余本息逾期率)</h3>-->
                        <h3 class="title">每月放款件数走势</h3>
                        <div class="echart-tag" id="center02"></div>
                    </div>
                    <!--<div class="center03-wrapper col-md-6">-->
                    <!--<h3 class="title">堆积图图例</h3>-->
                    <!--<div class="echart-tag" id="center03"></div>-->
                    <!--</div>-->
                </div>
            </div>
            <div class="col-md-3 right-echarts">
                <div class="right01-wrapper">
                    <h3 class="title">产品放款金额分布</h3>
                    <div class="echart-tag" id="right01"></div>
                </div>
                <div class="right02-wrapper">
                    <h3 class="title">每月撮合金额走势图</h3>
                    <div class="echart-tag" id="right02"></div>
                </div>
                <div class="right03-wrapper">
                    <h3 class="title">近1个月每日平均撮合时效走势(小时)</h3>
                    <div class="echart-tag" id="right03"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--<script src="../../../static/plugins/echarts/echarts.min.js"></script>-->
<script src="static/plugins/echarts/china.js"></script>
<script src="static/js/countUp.min.js"></script>
<script src="static/js/lodash.min.js"></script>
<script>
    var dynamicData = {
        init: function () {
            var _this = this;
            $('h1').trigger('click');

            getAllData();
            function getAllData() {
                $.ajax({
                    url: util.getServerUrl('/statistics/getStatusDataForCoporate'),
                    method: 'POST',
                    success: function (res) {
                        if (res.returnCode == 0) {
                            _this.countOpts.totalMoney = new CountUp('totalMoney', 0, res.result.matchTotalAmt, 2, 2.5,_this.countOpts.countUpOpts);
                            _this.countOpts.totalMount = new CountUp('totalMount', 0, res.result.matchTotalNum, 0, 2.5,_this.countOpts.countUpOpts);
                            _this.countOpts.totalMoney.start();
                            _this.countOpts.totalMount.start();

                            _this.iLeftEcharts(res.result);
                            _this.iCenterEcharts(res.result);
                            _this.iRightEcharts(res.result);
                            $('#mask').remove();
                        }
                    },
                    error: function (error) {

                    }
                })
            }
            this.bindEvent();
        },
        countOpts: {
            countUpOpts: {
                useEasing: true,
                easingFn: function (t, b, c, d) { // 数字缓动动画
                    var ts = (t /= d) * t;
                    var tc = ts * t;
                    return b + c * (tc * ts + -5 * ts * ts + 10 * tc + -10 * ts + 5 * t);
                },
                useGrouping: true, // 千位分割
                separator: ',',
                decimal: '.',
            },
            totalMoney: {},
            totalMount: {},
            time : 0,
            timer : function () {
                this.time = dynamicData.tool().fRandomBy(50,120)*1000;
            }
        },
        bindEvent: function () {
            this.countOpts.timer();
            var _this = this;
            var flag = 1;
            $('h1').on('click', function () {
                flag++;
                if (flag % 2 == 0) {
                    _this.tool().fullScreen();
                } else {
                    _this.tool().exitFullScreen();
                }
                $('.echarts').toggleClass('full-screen');
                _this.echarts().left01.resize();
                _this.echarts().left02.resize();
                _this.echarts().left03.resize();
                _this.echarts().center01.resize();
                _this.echarts().center02.resize();
                // _this.echarts().center03.resize();
                _this.echarts().right01.resize();
                _this.echarts().right02.resize();
                _this.echarts().right03.resize();
            })

            // 随机时间更新数据(setTimeout递归，不能用setInterval)
            function fun(){
                $.ajax({
                    url: util.getServerUrl('/statistics/getStatusDataForCoporate'),
                    method: 'POST',
                    success : function (res) {
                        if(res.returnCode == 0) {
                            _this.countOpts.totalMoney.update(res.result.matchTotalAmt);
                            _this.countOpts.totalMount.update(res.result.matchTotalNum);
                            _this.countOpts.time = _this.tool().fRandomBy(50,120)*1000; // 改变时间随机数
                        }
                    }
                })
                setTimeout(fun,dynamicData.countOpts.time);
            }
            setTimeout(fun,this.countOpts.time);

        },
        echarts: function () {
            return {
                left01: echarts.init(document.getElementById('left01')),
                left02: echarts.init(document.getElementById('left02')),
                left03: echarts.init(document.getElementById('left03')),
                center01: echarts.init(document.getElementById('center01')),
                center02: echarts.init(document.getElementById('center02')),
                // center03: echarts.init(document.getElementById('center03')),
                right01: echarts.init(document.getElementById('right01')),
                right02: echarts.init(document.getElementById('right02')),
                right03: echarts.init(document.getElementById('right03'))
            }
        },
        // 初始化左边三个echarts
        iLeftEcharts: function (data) {
            this.iLeftEcharts01(data);
            this.iLeftEcharts02(data);
            this.iLeftEcharts03(data);
        },
        // 初始化中间echarts
        iCenterEcharts: function (data) {
            this.iCenterEcharts01(data);
            this.iCenterEcharts02Temp(data); // 每月走势图
            // this.iCenterEcharts02(data); // 账龄图
        },
        // 初始化右边echarts
        iRightEcharts: function (data) {
            this.iRightEcharts01(data);
            this.iRightEcharts02(data);
            this.iRightEcharts03(data);
        },
        // 初始化左边第一个echarts
        iLeftEcharts01: function (data) {
            var option = {
                tooltip: {
                    textStyle: {
                        fontSize: 12
                    }
                },
                radar: {
                    name: {
                        textStyle: {
                            color: '#04FAFE',
                            borderRadius: 3,
                        }
                    },
                    center: ['50%', '55%'], // 圆心,
                    radius: '65%', // 半径
                    splitNumber: 8,
                    shape: 'polygon',
                    axisLine: { // 坐标轴轴线
                        show: true,
                        lineStyle: {
                            color: '#1F3D75'
                        }
                    },
                    splitLine: { // 分割线
                        lineStyle: {
                            color: ['#1F3D75']
                        }
                    },
                    splitArea: { // 分割区域
                        show: false
                    },
                    indicator: [
                        {name: '产品政策', max: 17},
                        {name: '信用模型', max: 17},
                        {name: '欺诈验证', max: 17},
                        {name: '黑名单验证', max: 17},
                        {name: '多头借贷', max: 17},
                        {name: '人工拒绝', max: 17}
                    ]
                },
                series: [{
                    name: '拒绝率',
                    type: 'radar',
                    color: ['#04FAFE'], // 配置legend图标颜色
                    lineStyle: {
                        width: 0
                    },
                    itemStyle: { // 拐点样式 opacity为0表示不绘制
                        opacity: 0
                    },
                    data: [
                        {
                            value: [7, 10, 6, 5, 3, 2],
                            emphasis: {
                                itemStyle: {
                                    opacity: 0
                                }
                            },
                            areaStyle: {
                                color: '#04FAFE',
                                opacity: 0.7
                            },
                        }
                    ]
                }]
            }
            this.echarts().left01.setOption(option);
        },
        // 初始化左边第二个echarts
        iLeftEcharts02: function (data) {
            var colors = ['#04FAFE', '#04FAFE', '#172E50', '#476B8F'];
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    },
                    textStyle: {
                        fontSize: 12
                    },
                    formatter: '{b}:<br />{a}:{c}%'
                },
                axisPointer: {
                    lineStyle: {
                        color: '#555',
                        type: 'dashed'
                    }
                },
                grid: {
                    top: 70,
                    bottom: 30,
                    right: 5
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2],
                            },

                        },
                        axisLabel: {
                            show: true,
                            color: colors[3],
                            margin: 10,

                        },
                        data: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10']
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        nameGap: 25,
                        // min: 0,
                        // max: 100,
                        splitNumber: 5,
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2]
                            }
                        },
                        axisTick: {
                            show: false,
                        },
                        axisLabel: {
                            color: colors[3]
                        },
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2],
                                opacity: 0.3
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '近3个月信用模型档位分布',
                        type: 'bar',
                        smooth: true,
                        data: [5.61, 8.14, 8.96, 9.97, 12.26, 12.27, 12.62, 11.64, 10.65, 7.88],
                        itemStyle: {
                            opacity: 1,
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
                                offset: 0,
                                color: '#04FAFE'
                            }, {
                                offset: 1,
                                color: '#0dd5f5'
                            }])
                        },

                    }
                ]
            };
            this.echarts().left02.setOption(option);
        },
        // 初始化左边第三个echarts
        iLeftEcharts03: function (data) {
            var colors = ['#E3F20B', '#04FAFE', '#172E50', '#476B8F'];
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    // axisPointer: {
                    //     type: 'cross'
                    // },
                    textStyle: {
                        fontSize: 12
                    }
                },
                axisPointer: {
                    lineStyle: {
                        color: '#555',
                        type: 'dashed'
                    }
                },
                grid: {
                    top: 70,
                    bottom: 30,
                    right: 5
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2],
                            },

                        },
                        axisLabel: {
                            show: false,
                            color: colors[3],
                            margin: 15,

                        },
                        data: data.fkjezsX
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        nameGap: 25,
                        // min: 0,
                        // max: 100,
                        splitNumber: 5,
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2]
                            }
                        },
                        axisTick: {
                            show: false,
                        },
                        axisLabel: {
                            color: colors[3]
                        },
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2],
                                opacity: 0.3
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '近1个月每日放款走势(万元)',
                        type: 'line',
                        smooth: true,
                        data: data.fkjezsY,
                        areaStyle: {
                            opacity: 0.3,
                        },
                        markLine: {
                            precision: 2,
                            label: {
                                position: 'middle'
                            },
                            lineStyle: {
                                color: colors[1],
                            },
                            data: [{
                                name: '平均线',
                                type: 'average'
                            }]
                        }

                    }
                ]
            };
            this.echarts().left03.setOption(option);
        },
        // 初始化中间第一个echarts
        iCenterEcharts01: function (data) {
            var colors = ['#E3F20B', '#04FAFE', '#172E50', '#476B8F', '#E3F20B'];
            var option = {
                tooltip: {
                    trigger: 'item',
                    formatter: '{b}:{c}元'
                },
                visualMap: {
                    min: 0,
                    max: 100000000,
                    left: 'left',
                    top: 'bottom',
                    text: ['high', 'low'],
                    calculable: true,
                    inRange: {
                        color: [colors[3], colors[1]]
                    },
                    textStyle: {
                        color: colors[3]
                    }
                },
                series: [
                    {
                        // name: '',
                        type: 'map',
                        mapType: 'china',
                        roam: false,
                        label: {
                            normal: {
                                show: false
                            },
                            emphasis: {
                                show: true,
                            }
                        },
                        emphasis: {
                            itemStyle: {
                                areaColor: colors[4],
                            },
                            label: {
                                show: false,
                                color: '#fff'
                            }
                        },
                        data: data.provinceData
                    }
                ]
            };

            this.echarts().center01.setOption(option);
        },
        // 初始化中间第二个echarts
        iCenterEcharts02: function (data) {
            var colors = ['#e5d92f', '#04FAFE', '#22a3ff', '#ffa800', '#f25de6', '#824afe', '#ff1867', '#33e942'];
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    },
                    textStyle: {
                        fontSize: 12
                    }
                },
                axisPointer: {
                    lineStyle: {
                        color: '#555',
                        type: 'dashed'
                    }
                },
                legend: {
                    type: 'scroll',
                    orient: 'vertical',
                    icon: 'circle',
                    textStyle: {
                        color: '#476B8F'
                    },
                    data: ['2017-03', '2017-04', '2017-05', '2017-06', '2017-07', '2017-08', '2017-09', '2017-10'],
                    top: '12%',
                    right: 5
                },
                grid: {
                    top: 70,
                    bottom: 35,
                    left: 30,

                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: '#172E50'
                            }
                        },
                        axisLabel: {
                            show: true,
                            color: '#476B8F',
                            margin: 15
                        },
                        data: ['2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14']
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        nameGap: 25,
                        // min: 0,
                        // max: 100,
                        splitNumber: 5,
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: '#172E50'
                            }
                        },
                        axisTick: {
                            show: false,
                        },
                        axisLabel: {
                            color: '#476B8F'
                        },
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: '#172E50',
                                opacity: 0.3
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '2017-03',
                        type: 'line',
                        smooth: true,
                        data: [0.89, 0.00, 0.00, 0.00, 0.88, 1.05, 2.08, 4.07, 6.83, 5.59, 5.16, 5.97, 5.65],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                            ]
                        }
                    },
                    {
                        name: '2017-04',
                        type: 'line',
                        smooth: true,
                        data: [1.22, 1.22, 2.38, 6.11, 8.13, 9.52, 10.01, 10.76, 9.33, 10.57, 11.97, 10.35],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                            ]
                        }
                    },
                    {
                        name: '2017-05',
                        type: 'line',
                        smooth: true,
                        data: [0.00, 1.73, 2.49, 2.49, 2.93, 6.33, 10.31, 10.89, 10.38, 9.27, 10.73],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                            ]
                        }
                    },
                    {
                        name: '2017-06',
                        type: 'line',
                        smooth: true,
                        data: [0.00, 1.00, 0.57, 1.60, 2.34, 4.90, 5.32, 5.30, 5.94, 6.96],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                            ]
                        }
                    },
                    {
                        name: '2017-07',
                        type: 'line',
                        smooth: true,
                        data: [0.00, 1.22, 2.85, 3.14, 3.94, 4.21, 3.14, 3.14, 4.70],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                            ]
                        }
                    },
                    {
                        name: '2017-08',
                        type: 'line',
                        smooth: true,
                        data: [0.00, 0.00, 4.16, 5.97, 5.38, 5.27, 6.32, 6.47],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                            ]
                        }
                    },
                    {
                        name: '2017-09',
                        type: 'line',
                        smooth: true,
                        data: [1.25, 2.11, 1.89, 2.18, 2.18, 3.48, 4.21],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                            ]
                        }
                    },
                    {
                        name: '2017-10',
                        type: 'line',
                        smooth: true,
                        data: [0.00, 1.96, 2.40, 2.37, 2.82, 2.76],
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                            ]
                        }
                    }
                ]
            };
            this.echarts().center02.setOption(option);
        },
        // 初始化中间第二个 临时
        iCenterEcharts02Temp : function(data){
            var colors = ['#f25de6'];
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    },
                    textStyle: {
                        fontSize: 12
                    }
                },
                axisPointer: {
                    label : {
                      show : true,
                    },
                    lineStyle: {
                        color: '#555',
                        type: 'dashed'
                    }
                },
                grid: {
                    top: 70,
                    bottom: 35,
                    left: 30,
                    right : 30

                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: '#172E50'
                            }
                        },
                        axisLabel: {
                            show: false,
                            color: '#476B8F',
                            margin: 15
                        },
                        data: data.fkjszsX
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        nameGap: 25,
                        // min: 0,
                        // max: 100,
                        splitNumber: 5,
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: '#172E50'
                            }
                        },
                        axisTick: {
                            show: false,
                        },
                        axisLabel: {
                            color: '#476B8F'
                        },
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: '#172E50',
                                opacity: 0.3
                            }
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        smooth: true,
                        data: data.fkjszsY,
                        markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        }
                    }
                ]
            };
            this.echarts().center02.setOption(option);
        },
        // 初始化右边第一个echarts
        iRightEcharts01: function (data) {
            var colors = ['#CDD61B', '#06F2F8', '#939069'];
            var option = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c}万 ({d}%)",
                    textStyle: {
                        fontSize: 12
                    }
                },
                legend: {
                    orient: 'vertical',
                    left: 15,
                    top: 30,
                    data: ['3C消费类', '汽车金融类', '信用类'],
                    textStyle: {
                        color: '#476B8F'
                    }
                },
                series: [
                    {
                        name: '产品放款金额分布',
                        type: 'pie',
                        radius: '55%',
                        center: ['55%', '55%'],
                        // roseType: 'radius',
                        data: [
                            {value: 28840.1, name: '3C消费类', itemStyle: {color: colors[0]}},
                            {value: 9371.0, name: '信用类', itemStyle: {color: colors[1]}},
                            {value: 17006.3, name: '汽车金融类', itemStyle: {color: colors[2]}},
                        ].sort(function (a, b) {
                            return a.value - b.value;
                        }),
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };
            this.echarts().right01.setOption(option);
        },
        // 初始化右边第二个echarts
        iRightEcharts02: function (data) {
            var colors = ['#E3F20B', '#04FAFE', '#172E50', '#476B8F'];
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross'
                    },
                    textStyle: {
                        fontSize: 12
                    }
                },
                axisPointer: {
                    lineStyle: {
                        color: '#555',
                        type: 'dashed'
                    }
                },
                legend: {
                    textStyle: {
                        color: colors[3]
                    },
                    data: [{
                        name: '3C消费类(元)',
                        icon: 'circle',
                        textStyle: {}
                    },
                        {
                            name: '汽车金融类(元)',
                            icon: 'circle',
                            textStyle: {}
                        }],
                    top: '12%',
                },
                grid: {
                    top: 70,
                    bottom: 35,
                    left: 90
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2]
                            }
                        },
                        axisLabel: {
                            show: true,
                            color: colors[3],
                            margin: 15
                        },
                        data: data.xAxis
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        nameGap: 25,
                        // min: 0,
                        // max: 100,
                        splitNumber: 5,
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2]
                            }
                        },
                        axisTick: {
                            show: false,
                        },
                        axisLabel: {
                            color: colors[3]
                        },
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2],
                                opacity: 0.3
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '3C消费类(元)',
                        type: 'line',
                        // smooth: true,
                        data: data.y3C,
                        areaStyle: {
                            opacity: 0.3,
                        },

                    },
                    {
                        name: '汽车金融类(元)',
                        type: 'line',
                        // smooth: true,
                        data: data.yCar,
                        areaStyle: {
                            opacity: 0.3,
                        },
                    }
                ]
            };

            this.echarts().right02.setOption(option);
        },
        // 初始化右边第三个echarts
        iRightEcharts03: function (data) {
            var colors = ['#04FAFE', '#04FAFE', '#172E50', '#476B8F', '#E3F20B'];
            var option = {
                color: colors,
                tooltip: {
                    trigger: 'axis',
                    // axisPointer: {
                    //     type: 'cross'
                    // },
                    textStyle: {
                        fontSize: 12
                    }
                },
                axisPointer: {
                    lineStyle: {
                        color: '#555',
                        type: 'dashed'
                    }
                },
                grid: {
                    top: 70,
                    bottom: 30,
                    right: 5
                },
                xAxis: [
                    {
                        type: 'category',
                        axisTick: {
                            alignWithLabel: true
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2],
                            },

                        },
                        axisLabel: {
                            show: false,
                            color: colors[3],
                            margin: 15,

                        },
                        data: data.pjchsxX
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        nameGap: 25,
                        // min: 0,
                        // max: 100,
                        splitNumber: 5,
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2]
                            }
                        },
                        axisTick: {
                            show: false,
                        },
                        axisLabel: {
                            color: colors[3]
                        },
                        splitLine: {
                            show: true,
                            lineStyle: {
                                color: colors[2],
                                opacity: 0.3
                            }
                        }
                    }
                ],
                series: [
                    {
                        name: '近1个月每日平均撮合时效走势(小时)',
                        type: 'line',
                        smooth: true,
                        data: data.pjchsxY,
                        areaStyle: {
                            opacity: 0.3,
                        },
                        markLine: {
                            precision: 2,
                            label: {
                                position: 'middle'
                            },
                            lineStyle: {
                                color: colors[4],
                            },
                            data: [{
                                name: '平均线',
                                type: 'average'
                            }]
                        }
                    }
                ]
            };
            this.echarts().right03.setOption(option);
        },
        // 工具类
        tool: function () {
            return {
                // 格式化金额
                formatNumber: function (s, n) {
                    n = n > 0 && n <= 20 ? n : 2;
                    s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";
                    var l = s.split(".")[0].split("").reverse(), r = s.split(".")[1];
                    t = "";
                    for (i = 0; i < l.length; i++) {
                        t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");
                    }
                    return t.split("").reverse().join("") + "." + r;
                },
                // 全屏
                fullScreen: function () {
                    var el = document.documentElement;
                    var rfs = el.requestFullScreen || el.webkitRequestFullScreen ||
                        el.mozRequestFullScreen || el.msRequestFullScreen;
                    if (typeof rfs != "undefined" && rfs) {
                        rfs.call(el);
                    } else if (typeof window.ActiveXObject != "undefined") {
                        //for IE，这里其实就是模拟了按下键盘的F11，使浏览器全屏
                        var wscript = new ActiveXObject("WScript.Shell");
                        if (wscript != null) {
                            wscript.SendKeys("{F11}");
                        }
                    }
                },
                // 退出全屏
                exitFullScreen: function () {
                    var exitMethod = document.exitFullscreen || document.mozCancelFullScreen || document.webkitExitFullscreen || document.webkitExitFullscreen;
                    if (exitMethod) {
                        exitMethod.call(document);
                    }
                    else if (typeof window.ActiveXObject !== "undefined") {//for Internet Explorer
                        var wscript = new ActiveXObject("WScript.Shell");
                        if (wscript !== null) {
                            wscript.SendKeys("{F11}");
                        }
                    }
                },
                // 指定范围内随机数
                fRandomBy: function (under, over) {
                    switch (arguments.length) {
                        case 1:
                            return parseInt(Math.random() * under + 1);
                        case 2:
                            return parseInt(Math.random() * (over - under + 1) + under);
                        default:
                            return 0;
                    }
                }
            }
        }
    }
    $(function () {
        dynamicData.init();
    })
</script>
</body>
</html>