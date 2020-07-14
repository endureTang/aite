var myOrderTpl = {
//     host : '/nj-enterprise-web',
    host : '',
    tmp: {
        orderId: '',
        keyword : '',
        orderStatus :'',
        period :'',
        createDate :'',
        start : '',
        basePath : ''
    },
    init: function (tmp) {
        this.tmp = tmp;
        this.getStatus(); // 获取订单状态
    },
    // 获取订单状态
    getStatus: function () {
        var _this = this;
        $.ajax({
            url: util.getServerUrl('/common/listOrderProcess'),
            method:'POST',
            data : {orderId: _this.tmp.orderId},
            success: function (res) {
                if (res.status == 0) {
                    _this.renderProcess(res.data);
                } else {
                    if (res.msg == '') {
                        _this.alertModel('订单流程状态获取失败，请稍后再试!');
                    } else {
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
            str += '耗时: <i>' + (util.MillisecondToDate(data[i].execTime) == "1秒" ? "<1秒" : util.MillisecondToDate(data[i].execTime)) + '</i>';
            str += '</span>';
            str += '<span class="normal">' + data[i].processName + '</span>';
            str += '<span class="people-name">'+ '<i class="'+(data[i].userName == ""?"hide":" ")+'">(' + data[i].userName + ')</i>' +'</span>';
            str += '</li>';
            str += '<li class="process ' + (data[i].status == 2 ? "active" : "") + ' ' + (i == data.length - 1 ? "hide" : " ") + '"></li>';
        }
        $('#step_process').html(str);
    },
    // 模态框弹出
    alertModel: function (str) {
        $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
        $('#myModal').modal('show');
    },
    // 模态框成功弹出
    alertSuccessModel: function (str,cb) {
        $('#mySuccessModal .modal-body').empty().html('<p>' + str + '</p>');
        $('#mySuccessModal').modal('show');
        $('#mySuccessModal').on('hidden.bs.modal', function (e) {
            cb&&cb();
        })
    },
    // 获取checkbox或者radio值
    getiCheckItem: function (name) {
        var arr = [];
        var ids = $('input[name="' + name + '"]');
        ids.each(function () {
            if (this.checked) {
                arr.push(this.value);
            }
        })
        return arr;
    },
    tool: {
        // 转换时间
        formatTime: function (time) {
            if (time) {
                var date = new Date(time);
                return date.getFullYear() + '-' + (preZero(date.getMonth() + 1)) + '-' + preZero(date.getDate()) + ' ' + preZero(date.getHours()) + ':' + preZero(date.getMinutes()) + ':' + preZero(date.getSeconds());
            }

            function preZero(num) {
                num = '' + num;
                return num.length == 1 ? '0' + num : num;
            }
        },
    },
    // 上传图片下拉框
    getUploadSel: function (productTempId,cb) {
        $.ajax({
            url: util.getServerUrl('/common/productFileSelect'),
            method: 'POST',
            data:{productTempId:productTempId},
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
    // 上传图片
    uploadImgs : function (limitNum) {
        var _this = this;
        // 初始化Web Uploader
        var uploader = WebUploader.create({
            // 选完文件后，是否自动上传。
            auto: false,
            // swf文件路径
            swf: _this.tmp.basePath + 'static/plugins/webuploader/Uploader.swf',
            // 文件接收服务端。
            server: _this.tmp.basePath + 'attachment/upload',
            pick: '#filePicker',
            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            },
            fileNumLimit : limitNum || 10,
            duplicate : true,
            fileSingleSizeLimit : 1024*1024*8,
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
                _this.alertModel('请选择分类!');
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
            if(file.size > 1024*1024*8) {
                _this.alertModel('文件大小必须小于8M!');
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
                    url : _this.host + '/loanOrder/dataAdd',
                    method : 'POST',
                    data : {
                        orderId : _this.tmp.orderId,
                        attachIds : response.result
                    },
                    success : function (res) {
                        if(res.status==0){
                            $( '#'+file.id ).addClass('upload-state-done');
                            $('#'+file.id).append('<div class="result"><i class="fa fa-check"></i></div>')
                        }else if(res.returnCode == 2000){
                            _this.alertModel(res.returnMsg);
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
    },
    // textarea点击展示内容
    showTextArea:function () {
        $('.tab-content').on('click','.pointer',function () {
            $('#mask .areaContent').html($(this).html()).parents('#mask').fadeIn(300);
        })
        $('#mask').click(function (el) {
            if(el.target.id=='mask'){
                $(this).fadeOut(300);
            }
        })
    }
}
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