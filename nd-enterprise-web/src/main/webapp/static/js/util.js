;(function (win) {
    var util = {
        // host : '/nd-enterprise-web',
        host : '',
//        imgTest : 'http://39.108.195.181:8080/nj-api',
//        imgSrc : 'http://api.52jdjf.com:8086',
        getServerUrl : function (url) {
            return this.host + url;
        },
        getImgTmpUrl : function (url) {
            return url;
        },
        validate : function (value,type) {
            var value = $.trim(value);
            // 非空验证
            if(type==='require'){
                return !!value;
            }
            // 手机号验证
            if(type==='phone'){
                return /^[1][3,4,5,7,8,9][0-9]{9}$/.test(value);
            }
            // 数字验证
            if(type=='number'){
                return /^(-)?\d+(\.\d+)?$/.test(value);
            }
        },
        // 获取url参数
        getUrlParam : function (name) {
            var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)');
            var result = window.location.search.substr(1).match(reg);
            return result ? result[2] : null ;
        },
        // 将时间戳转换为时分秒
        MillisecondToDate : function (time) {
            var time = parseFloat(time);// 传入秒
            if (null!= time &&""!= time) {
                if (time >60&& time <60*60) {
                    time = parseInt(time /60.0) +"分钟";
                }else if (time >=60*60&& time <60*60*24) {
                    time = parseInt(time /3600.0) +"小时"+ parseInt((parseFloat(time /3600.0) -
                        parseInt(time /3600.0)) *60) +"分钟";
                }else if(time >= 60*60*24){
                    time = parseInt(time / 3600.0/24) + "天" +parseInt((parseFloat(time / 3600.0/24)-
                        parseInt(time / 3600.0/24))*24) + "小时"
                }else {
                    time = parseInt(time) +"秒";
                }
            }else{
                time = "0 时 0 分0 秒";
            }
            return time;
        }
    };
    win.util = util;
})(window);