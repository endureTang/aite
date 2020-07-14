var firstTrial = {
    tmp: {
        orderId: '',
        processId: '', // 贷中状态
        afterLoan: '', // 贷后
        totalOrder: '', // 全部订单
        keyword : '',
        orderStatus :'',
        period :'',
        createDate :'',
        start : ''
    },
    // 一些控制变量
    variable: {
        basePath: '', // jsp页面获取的根路径
    },
    init: function (tmp, basePath) {
        var _this = this;
        var flag = 0; // 根据flag在clicktab时判断是否全部订单进行不同的调用
        this.tmp = tmp;
        this.variable.basePath = basePath;
        this.getStatus(); // 获取订单状态
        if (this.tmp.afterLoan == 1) { // 贷后订单
            this.renderAfterLoan(function () {
                _this.initImage();
            });
        }else if(this.tmp.totalOrder == 1){ // 全部订单
            flag = 1;
            this.renderTotalOrder(function () {
                _this.initImage();
            });
        } else { // 贷中订单
            if (this.tmp.processId == 5) { // 初审订单
                this.getBaseInfo(function () {
                    _this.initImage();
                });
                $('#saveCredit').css('display', 'block');
                // 更改返回按钮内容
                $('.nav-bar a').text('< 返回贷中初审订单').attr('data-url', _this.variable.basePath + 'loanOrder/listProcessOrderPageForFirst?start='+_this.tmp.start+'&keyword='+_this.tmp.keyword+'&orderStatus='+_this.tmp.orderStatus+'&period='+_this.tmp.period+'&createDate='+_this.tmp.createDate);
            } else if (this.tmp.processId == 6) { // 复审订单
                // 隐藏按钮操作区
                this.hideControlBtns();
                // 征信情况为禁止状态
                this.disUserCredit();
                // 调用获取复审数据并渲染
                // this.getAuditAgainInfo();
                // 显示信审信息tab页
                // $('#myTabs a:eq(3)').tab('show');
                this.getBaseInfo(function () {
                    _this.initImage();
                });
                $('.nav-bar a').text('< 返回贷中复审订单').attr('data-url', _this.variable.basePath + 'loanOrder/listProcessOrderPageForReview?start='+_this.tmp.start+'&keyword='+_this.tmp.keyword+'&orderStatus='+_this.tmp.orderStatus+'&period='+_this.tmp.period+'&createDate='+_this.tmp.createDate);

            } else { // 终审订单
                this.hideControlBtns();
                this.disUserCredit();
                // this.getAuditFinalInfo();
                // $('#myTabs a:eq(3)').tab('show');
                this.getBaseInfo(function () {
                    _this.initImage();
                });
                $('.nav-bar a').text('< 返回贷中终审订单').attr('data-url', _this.variable.basePath + 'loanOrder/listProcessOrderPageForLast?start='+_this.tmp.start+'&keyword='+_this.tmp.keyword+'&orderStatus='+_this.tmp.orderStatus+'&period='+_this.tmp.period+'&createDate='+_this.tmp.createDate);

            }
            $('.treeview-menu li').removeClass('active');
        }
        this.renderRefuseHtml();
        this.bindEvent(flag);

    },
    bindEvent: function (flag) {
        var _this = this;
        // 所有拒绝列表渲染及点击获取事件
        this.refuseListEvent();
        // 核对拒绝驳回事件
        this.examineEvent();
        // 打印审批表
        this.printTable();
        // 导出通讯录
        $('#export_list').click(function () {
            window.open(_this.variable.basePath + 'loanOrder/exportContacts?orderId='+_this.tmp.orderId,'_blank');
        })
        // 信用信息保存征信情况
        $('#saveCredit').click(function () {
            var data = {
                agentCount: $.trim($('#agentCount').val()),
                personCount: $.trim($('#personCount').val()),
                overdueMonth6: $.trim($('#overdueMonth6').val()),
                overdueMonth12: $.trim($('#overdueMonth12').val()),
                creditCardAmt: $.trim($('#creditCardAmt').val()),
                mortageBalance: $.trim($('#mortageBalance').val()),
                creditBalance: $.trim($('#creditBalance').val()),
                balanceAvr: $.trim($('#balanceAvr').val()),
                overdueStatus: $.trim($('#overdueStatus').val()),
                accountStatus: $.trim($('#accountStatus').val()),
                overdueMonth24: $.trim($('#overdueMonth24').val())
            }
            _this.saveCredit(data);
        })
        // 点击tab调用数据
        this.clickTab(flag);
        // 初审信审信息电话核查新增按钮
        $('#add_credit_table').click(function () {
            _this.addPhoneExamine();
        })
        // 初审信审信息电话修改保存按钮
        $('#savePhoneExamineEdit').click(function () {
            _this.savePhoneExamine();
        })
        // 初审通过
        $('#credit_trial_first_btn_checked').on('click', function () {
            _this.firstAuditPass();
        })
        // 复审通过
        $('#credit_trial_again_btn_checked').on('click', function () {
            _this.againAuditPass();
        })
        // 终审通过
        $('#credit_trial_final_btn_checked').on('click', function () {
            _this.finalAuditPass();
        })

        $('#saveRevCheat').click(function () {
            _this.saveRevCheck();
        })

    },
    dom: {
        applyInfo: {
            amount: $('.amount'),
            period: $('.period'),
            usageDesc: $('.usageDesc'),
            channelName: $('.channelName'),
        },
        applyInfoCheck: {
            abnormal: $('#applyInfoCheckAbnormal'),
            remark: $('#applyInfoCheckRemark')
        },
        baseInfo: {
            bankAccount: $('.bankAccount'),
            areaCode: $('.areaCode'),
            education: $('.education'),
            estateType: $('.estateType'),
            address: $('.address'),
            marrStatus: $('.marrStatus'),
            phone: $('.phone'),
            identity: $('.identity'),
            sex: $('.sex'),
            name: $('.name'),
            householdReg: $('.householdReg'),
            age: $('.age')
        },
        baseInfoCheck: {
            abnormal: $('#baseInfoCheckAbnormal'),
            remark: $('#baseInfoCheckRemark')
        },
        workInfo: {
            orgNature: $('.orgNature'),
            workYears: $('.workYears'),
            orgName: $('.orgName'),
            orgContact: $('.orgContact'),
            monthIncome: $('.monthIncome'),
            orgAddress: $('.orgAddress'),
            position: $('.position'),
        },
        workInfoCheck: {
            abnormal: $('#workInfoCheckAbnormal'),
            remark: $('#workInfoCheckRemark')
        },
        carInfo: {
            buyPrice: $('.buyPrice'),
            brand: $('.brand'),
            model: $('.model'),
            firstPayment: $('.firstPayment'),
            insuranceNo: $('.insuranceNo'),
            vin: $('.vin'),
            carNumber: $('.carNumber'),
            lastProjectNo: $('.lastProjectNo'),
            firstProjectNo: $('.firstProjectNo')
        },
        carInfoCheck: {
            abnormal: $('#carInfoCheckAbnormal'),
            remark: $('#carInfoCheckRemark')
        },
        // relativesInfo: {
        //     couple: $('.couple'),
        //     couple_mob: $('.couple_mob'),
        //     brother: $('.brother'),
        //     brother_mob: $('.brother_mob'),
        //     friend: $('.friend'),
        //     friend_mob: $('.friend_mob'),
        //     workmate: $('.workmate'),
        //     workmate_mob: $('.workmate_mob')
        // },
        relativesInfoCheck: {
            abnormal: $('#relativesInfoCheckAbnormal'),
            remark: $('#relativesInfoCheckRemark')
        },
        // 信审信息征信情况
        userCredit: {
            agentCount: $('#agentCount'),
            overdueMonth6: $('#overdueMonth6'),
            creditCardAmt: $('#creditCardAmt'),
            creditBalance: $('#creditBalance'),
            overdueStatus: $('#overdueStatus'),
            overdueMonth24: $('#overdueMonth24'),
            personCount: $('#personCount'),
            overdueMonth12: $('#overdueMonth12'),
            mortageBalance: $('#mortageBalance'),
            balanceAvr: $('#balanceAvr'),
            accountStatus: $('#accountStatus')
        }

    },
    // 电话编辑模态框dom
    phoneModalDom : {
        name : $('#phoneName'),
        number : $('#phoneNumber'),
        relation : $('#phoneRelation'),
        remark : $('#phoneRemark')
    },
    // 点击tab调用数据(flag为判断是否所有订单进入的权限控制变量值)
    clickTab: function (flag) {
        var _this = this;
        if(flag==1){
            // 点击基础信息
            $('#myTabs a:eq(0)').one('click', function () {
               _this.getAjax({
                   url : '/common/checkAuthority',
                   data : {keyword:'/loanOrder/getOrderBaseInfo'},
                   success : function (res) {
                       if(res.status==0){
                           _this.getBaseInfo();
                       }else{
                            _this.alertModel('您没有权限查看该页面!');
                       }
                   },
                   error : function (error) {
                       _this.alertModel('数据读取出错,请稍后重试!');
                   }
               })
            })
            // 点击信用信息
            $('#myTabs a:eq(1)').one('click', function () {
                _this.getAjax({
                    url : '/common/checkAuthority',
                    data : {keyword:'/loanOrder/getOrderCreditInfo'},
                    success : function (res) {
                        if(res.status==0){
                            _this.getCreditInfo();
                        }else{
                            _this.alertModel('您没有权限查看该页面!');
                        }
                    },
                    error : function (error) {
                        _this.alertModel('数据读取出错,请稍后重试!');
                    }
                })
            })
            // 点击人工核查
            $('#myTabs a:eq(2)').one('click', function () {
                _this.getAjax({
                    url : '/common/checkAuthority',
                    data : {keyword:'/loanOrder/getOrderHumanVerifyInfo'},
                    success : function (res) {
                        if(res.status==0){
                            _this.getPeopleCheckInfo();
                        }else{
                            _this.alertModel('您没有权限查看该页面!');
                        }
                    },
                    error : function (error) {
                        _this.alertModel('数据读取出错,请稍后重试!');
                    }
                })
            })
            // 点击信审信息
            $('#myTabs a:eq(3)').one('click', function () {
                _this.getAjax({
                    url : '/common/checkAuthority',
                    data : {keyword:'/loanOrder/getOrderAuditInfo'},
                    success : function (res) {
                        if(res.status==0){
                            _this.getAuditAfterLoan();
                        }else{
                            _this.alertModel('您没有权限查看该页面!');
                        }
                    },
                    error : function (error) {
                        _this.alertModel('数据读取出错,请稍后重试!');
                    }
                })
            })
            // 点击审批订单打印表
            $('#myTabs a:eq(4)').one('click', function () {
                _this.getAjax({
                    url : '/common/checkAuthority',
                    data : {keyword:'/loanOrder/getOrderApprovalInfo'},
                    success : function (res) {
                        if(res.status==0){
                            _this.renderOrderReply();
                        }else{
                            _this.alertModel('您没有权限查看该页面!');
                        }
                    },
                    error : function (error) {
                        _this.alertModel('数据读取出错,请稍后重试!');
                    }
                })
            })
            // 点击操作日志
            $('#myTabs a:eq(5)').one('click', function () {
                _this.getAjax({
                    url : '/common/checkAuthority',
                    data : {keyword:'/loanOrder/getOrderOperateLog'},
                    success : function (res) {
                        if(res.status==0){
                            _this.renderOperateHtml();
                        }else{
                            _this.alertModel('您没有权限查看该页面!');
                        }
                    },
                    error : function (error) {
                        _this.alertModel('数据读取出错,请稍后重试!');
                    }
                })
            })


        }else{
            // 点击基础信息
            $('#myTabs a:eq(0)').one('click', function () {
                _this.getBaseInfo();
            })
            // 点击信用信息
            $('#myTabs a:eq(1)').one('click', function () {
                _this.getCreditInfo();
            })
            // 点击人工核查
            $('#myTabs a:eq(2)').one('click', function () {
                _this.getPeopleCheckInfo();
            })
            // 点击信审信息
            $('#myTabs a:eq(3)').one('click', function () {
                if (_this.tmp.afterLoan == 1) {
                    _this.getAuditAfterLoan();
                } else {
                    if (_this.tmp.processId == 5) {
                        _this.getAuditFirstInfo();
                    } else if (_this.tmp.processId == 6) {
                        _this.getAuditAgainInfo();
                    } else {
                        _this.getAuditFinalInfo();
                    }
                }
            })

            // 点击审批订单打印表
            $('#myTabs a:eq(4)').on('click', function () {
                _this.renderOrderReply();
            })

            // 点击操作日志
            $('#myTabs a:eq(5)').one('click', function () {
                _this.renderOperateHtml();
            })
        }


    },
    // 渲染贷后
    renderAfterLoan: function (cb) {
        var _this = this;
        var a = $('#checkCheat'),
            b = $('#saveRevCheat');
        this.hideControlBtns();
        this.getAjax({
            url: '/loanOrder/getOrderBaseInfo',
            data: {
                afterLoan: _this.tmp.afterLoan
            },
            success: function (res) {
                if (res.status == 0) {
                    // 判断反核查
                    if (res.data.checkRecord == '') {
                        $('input[name="rev-cheat-result"]').iCheck({
                            radioClass: 'iradio_square-blue',
                            increaseArea: '20%'
                        });
                        a.css('visibility', 'hidden');
                        b.text('保存');
                    } else {
                        $('#checkCheat span:eq(0)').text(res.data.checkRecord.user_name);
                        $('#checkCheat span:eq(1)').text(_this.formatTime(res.data.checkRecord.check_date));
                        $('#revCheatDesc').val(res.data.checkRecord.remark);

                        $('input[name="rev-cheat-result"]').each(function () {
                            if ($(this).val() == res.data.checkRecord.abnormal) {
                                $(this).attr('checked', true);
                            }
                        });
                        $('input[name="rev-cheat-result"]').iCheck({
                            radioClass: 'iradio_square-blue',
                            increaseArea: '20%'
                        });
                        b.text('修改');
                        a.css('visibility', 'visible');
                    }
                    // 渲染基础信息
                    if (res.data.carInfo == '') {
                        $('.car-info').remove();
                        _this.renderBaseHtml(res.data, false);
                    } else {
                        _this.renderBaseHtml(res.data, true);
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

                } else {
                    $('input[name="rev-cheat-result"]').iCheck({
                        radioClass: 'iradio_square-blue',
                        increaseArea: '20%'
                    });
                    if (res.msg == '') {
                        _this.alertModel('获取数据失败,请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                }
            },
            error: function (error) {
                $('input[name="rev-cheat-result"]').iCheck({
                    radioClass: 'iradio_square-blue',
                    increaseArea: '20%'
                });
                _this.alertModel('获取数据失败,请稍后重试!');
            }
        })
        $('.check-cheat').show();
        $('.steps').hide();
        $('#add_credit_table').hide();
        $('#fore .first-reply').show().find('.credit-trial-first-control-info').hide();
        $('#fore .again-reply').show().find('.credit-trial-again-control-info').hide();
        $('#fore .final-reply').show().find('.credit-trial-final-control-info').hide();
        $('.tab-content input').attr('disabled', 'true');
        $('.tab-content select').attr('disabled', 'true');
        $('.tab-content textarea').attr('disabled', 'true');

        // 更改返回按钮内容
        $('.nav-bar a').text('< 返回贷后订单').attr('data-url', _this.variable.basePath + 'loanOrder/listAfterOrderPage?start='+_this.tmp.start+'&keyword='+_this.tmp.keyword+'&orderStatus='+_this.tmp.orderStatus+'&period='+_this.tmp.period+'&createDate='+_this.tmp.createDate);
        $('.treeview-menu li').removeClass('active');

        function renderAssetProve(data,target) {
            var str = '';
            $.each(data,function (k, v) {
                var attachIds = v.attachId.split(',');
                var filePathIds = v.filePath.split(',');
                str += '<li>';
                str += '<p>'+v.fileTag+'</p>';
                if(/^http/g.test(v.filePath)){
                    $.each(v.filePath.split(','),function (key, val) {
                        str += '<img data-magnify="gallery" src="'+val+'" data-src="'+val+'" alt="">';
                    })
                }else{
                    if(attachIds[0]!==''){// 避免attachIds为空
                        $.each(attachIds,function (key, val) {
                            str += '<img data-magnify="gallery" src="'+(util.getImgTmpUrl("/attachment/download?attachId=")+val)+'" data-src="'+(util.getImgTmpUrl("/attachment/download?attachId=")+val)+'" alt="">';
                        })
                    }
                }
                str +='</li>';
            })
            $('.'+target).html(str);
        }

    },
    // 渲染所有订单
    renderTotalOrder : function (cb) {
        var _this = this;
        this.hideControlBtns();
        this.getAjax({
            url: '/loanOrder/getOrderBaseInfo',
            success: function (res) {
                if (res.status == 0) {
                    // 渲染基础信息
                    if (res.data.carInfo == '') {
                        $('.car-info').remove();
                        _this.renderBaseHtml(res.data, false);
                    } else {
                        _this.renderBaseHtml(res.data, true);
                    }

                    // 驳回拒绝提示
                    if(Object.prototype.toString.call(res.data.refuseReson) == '[object Object]'){
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

                } else {
                    if (res.msg == '') {
                        _this.alertModel('获取数据失败,请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                }
            },
            error: function (error) {
                _this.alertModel('获取数据失败,请稍后重试!');
            }
        })
        $('#add_credit_table').hide();
        $('#fore .first-reply').show().find('.credit-trial-first-control-info').hide();
        $('#fore .again-reply').show().find('.credit-trial-again-control-info').hide();
        $('#fore .final-reply').show().find('.credit-trial-final-control-info').hide();
        $('.tab-content input').attr('disabled', 'true');
        $('.tab-content select').attr('disabled', 'true');
        $('.tab-content textarea').attr('disabled', 'true');

        // 更改返回按钮内容
        $('.nav-bar a').text('< 返回所有订单').attr('data-url', _this.variable.basePath + 'loanOrder/listOrderPage?start='+_this.tmp.start+'&keyword='+_this.tmp.keyword+'&orderStatus='+_this.tmp.orderStatus+'&period='+_this.tmp.period+'&createDate='+_this.tmp.createDate);
        $('.treeview-menu li').removeClass('active');

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
    // 前三tab已核对功能
    hasChecked: function (dataType, cb) {
        var _this = this;
        $.ajax({
            url: util.getServerUrl('/loanOrder/addOrderInfoCheck'),
            method: 'POST',
            contentType: 'application/json;charset=UTF-8',
            data: JSON.stringify([{
                "orderId": _this.tmp.orderId,
                "dataType": dataType,
                "abnormal": "",
                "remark": "ok"
            }]),
            success: function (res) {
                if (res.status == 0) {
                    cb && cb();
                } else {
                    _this.alertModel('订单核对出错，请稍后重试!');
                }
            },
            error: function (error) {
                _this.alertModel('订单核对出错，请稍后重试!');
            }
        })

    },
    // 复审终审隐藏前三个tab的按钮操作区
    hideControlBtns: function () {
        $('#one .select-flag').hide();
        $('#two .select-flag').hide();
        $('#three .select-flag').hide();
    },
    // 核对拒绝驳回所有事件
    examineEvent: function () {
        var _this = this;
        // 点击基础信息已核对
        $('#base_info_btn_checked').click(function () {
            _this.hasChecked(1, function () {
                $('#myTabs li:eq(0) span.badge').addClass('show-badge');
                _this.getCreditInfo();
                $('#myTabs a:eq(1)').tab('show');
                $(document).scrollTop(0);
            });
        })
        // 点击信用信息已核对
        $('#credit_info_btn_checked').click(function () {
            _this.hasChecked(2, function () {
                $('#myTabs li:eq(1) span.badge').addClass('show-badge');
                _this.getPeopleCheckInfo();
                $('#myTabs a:eq(2)').tab('show');
                $(document).scrollTop(0);
            });
        })
        // 点击人工核查已核对
        $('#people_check_btn_checked').click(function () {
            var data = [
                {
                    "orderId": _this.tmp.orderId,
                    "dataType": 11,
                    "abnormal": $('#applyInfoCheckAbnormal').val(),
                    "remark": $.trim($('#applyInfoCheckRemark').val())
                },
                {
                    "orderId": _this.tmp.orderId,
                    "dataType": 12,
                    "abnormal": $('#baseInfoCheckAbnormal').val(),
                    "remark": $.trim($('#baseInfoCheckRemark').val())
                },
                {
                    "orderId": _this.tmp.orderId,
                    "dataType": 13,
                    "abnormal": $('#workInfoCheckAbnormal').val(),
                    "remark": $.trim($('#workInfoCheckRemark').val())
                },
                {
                    "orderId": _this.tmp.orderId,
                    "dataType": 15,
                    "abnormal": $('#relativesInfoCheckAbnormal').val(),
                    "remark": $.trim($('#relativesInfoCheckRemark').val())
                }
            ];
            var carInfo = {
                "orderId": _this.tmp.orderId,
                "dataType": 14,
                "abnormal": $('#carInfoCheckAbnormal').val(),
                "remark": $.trim($('#carInfoCheckRemark').val())
            };
            if (_this.exist($('.car-info'))) {
                data.push(carInfo);
            }
            $.ajax({
                url: util.getServerUrl('/loanOrder/addOrderInfoCheck'),
                data: JSON.stringify(data),
                contentType: 'application/json;charset=UTF-8',
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        _this.hasChecked(3, function () {
                            $('#myTabs li:eq(2) span.badge').addClass('show-badge');
                            _this.getAuditFirstInfo();
                            $('#myTabs a:eq(3)').tab('show');
                            $(document).scrollTop(0);
                        });
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('备注信息保存失败，请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('备注信息保存失败，请稍后重试!');
                }
            })


        })
        // 点击基础信息拒绝
        $('#base_info_btn_refuse').click(function () {
            _this.refuseOrder($('#base_info_refuse'), $('#base_info_refuse_reason'),5);
        })
        // 点击信用信息拒绝
        $('#credit_info_btn_refuse').click(function () {
            _this.refuseOrder($('#credit_info_refuse'), $('#credit_info_refuse_reason'),5);
        })
        // 点击人工核查拒绝
        $('#people_check_btn_refuse').click(function () {
            _this.refuseOrder($('#people_check_refuse'), $('#people_check_refuse_reason'),5);
        })
        // 点击信审信息初审拒绝
        $('#credit_trial_first_btn_refuse').click(function () {
            _this.refuseOrder($('#credit_trial_first_refuse'), $('#credit_trial_first_refuse_reason'),5);
        })
        // 点击信审信息复审拒绝
        $('#credit_trial_again_btn_refuse').click(function () {
            _this.refuseOrder($('#credit_trial_again_refuse'), $('#credit_trial_again_refuse_reason'),6);
        })
        // 点击信审信息终审拒绝
        $('#credit_trial_final_btn_refuse').click(function () {
            _this.refuseOrder($('#credit_trial_final_refuse'), $('#credit_trial_final_refuse_reason'),7);
        })
        // 点击基础信息驳回
        $('#base_info_btn_reject').click(function () {
            _this.rejectOrder($('#base_info_btn_reject_reason'),5,$('#base_info_btn_reject_to').val());
        })
        // 点击信用信息驳回
        $('#credit_info_btn_reject').click(function () {
            _this.rejectOrder($('#credit_info_btn_reject_reason'),5,$('#credit_info_btn_reject_to').val());
        })
        // 点击人工核查驳回
        $('#people_check_btn_reject').click(function () {
            _this.rejectOrder($('#people_check_btn_reject_reason'),5,$('#people_check_btn_reject_to').val());
        })
        // 点击信审信息初审驳回
        $('#credit_trial_first_btn_reject').click(function () {
            _this.rejectOrder($('#credit_trial_first_btn_reject_reason'),5,$('#credit_trial_first_btn_reject_to').val());
        })
        // 点击信审信息复审驳回
        $('#credit_trial_again_btn_reject').click(function () {
            _this.rejectOrder($('#credit_trial_again_btn_reject_reason'),6,$('#credit_trial_again_btn_reject_to').val());
        })
        // 点击信审信息终审驳回
        $('#credit_trial_final_btn_reject').click(function () {
            _this.rejectOrder($('#credit_trial_final_btn_reject_reason'),7,$('#credit_trial_final_btn_reject_to').val());
        })
    },
    // 拒绝列表及原因所有事件
    refuseListEvent: function () {
        // 基础信息拒绝渲染
        this.toggleRefuse('#base_info_refuse_reason', '.base-info-refuseTree');
        this.renderRefuseReasonHtml('.base-info-refuseTree', '#base_info_refuse_reason');
        // 信用信息拒绝渲染
        this.toggleRefuse('#credit_info_refuse_reason', '.credit-info-refuseTree');
        this.renderRefuseReasonHtml('.credit-info-refuseTree', '#credit_info_refuse_reason');
        // 人工核查拒绝渲染
        this.toggleRefuse('#people_check_refuse_reason', '.people-check-refuseTree');
        this.renderRefuseReasonHtml('.people-check-refuseTree', '#people_check_refuse_reason');
        // 初审信审信息拒绝渲染
        this.toggleRefuse('#credit_trial_first_refuse_reason', '.credit-trial-first-refuseTree');
        this.renderRefuseReasonHtml('.credit-trial-first-refuseTree', '#credit_trial_first_refuse_reason');
        // 复审信审信息拒绝渲染
        this.toggleRefuse('#credit_trial_again_refuse_reason', '.credit-trial-again-refuseTree');
        this.renderRefuseReasonHtml('.credit-trial-again-refuseTree', '#credit_trial_again_refuse_reason');
        // 终审信审信息拒绝渲染
        this.toggleRefuse('#credit_trial_final_refuse_reason', '.credit-trial-final-refuseTree');
        this.renderRefuseReasonHtml('.credit-trial-final-refuseTree', '#credit_trial_final_refuse_reason');
    },
    // 拒绝
    refuseOrder: function ($reason, $cause, type) {
        var _this = this;
        var url = '';
        switch (type) {
            case 5 :
                url = 'loanOrder/listProcessOrderPageForFirst';
                break;
            case 6 :
                url = 'loanOrder/listProcessOrderPageForReview';
                break;
            case 7 :
                url = 'loanOrder/listProcessOrderPageForLast';
                break;
        }
        this.getAjax({
            url: '/loanOrder/examineOrder',
            data: {
                resultValue: 3,
                processId: _this.tmp.processId,
                remark: $reason.val() + ',' + $cause.val()
            },
            success: function (res) {
                if (res.status == 0) {
                    _this.alertModel('订单拒绝成功!');
                    setTimeout(function () {
                        $('#myModal').modal('hide');
                    },1500);
                    $('#myModal').on('hidden.bs.modal', function (e) {
                        $('#navTab').load(_this.variable.basePath + url);
                    })
                } else {
                    if (res.msg == '') {
                        _this.alertModel('订单拒绝失败!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                }
            },
            error: function (error) {
                _this.alertModel('订单拒绝失败!');
            }
        })
    },
    // 驳回
    rejectOrder: function ($reject,type,rejectTo) {
        var _this = this;
        var url = '';
        switch (type) {
            case 5 :
                url = 'loanOrder/listProcessOrderPageForFirst';
                break;
            case 6 :
                url = 'loanOrder/listProcessOrderPageForReview';
                break;
            case 7 :
                url = 'loanOrder/listProcessOrderPageForLast';
                break;
        }
        this.getAjax({
            url: '/loanOrder/examineOrder',
            data: {
                resultValue: 2,
                processId: _this.tmp.processId,
                rejectProcessId : rejectTo,
                remark: $.trim($reject.val())
            },
            success: function (res) {
                if (res.status == 0) {
                    _this.alertModel('订单驳回成功!');
                    setTimeout(function () {
                        $('#myModal').modal('hide');
                    },1500);
                    $('#myModal').on('hidden.bs.modal', function (e) {
                        $('#navTab').load(_this.variable.basePath + url);
                    })
                } else {
                    if (res.msg == '') {
                        _this.alertModel('订单驳回失败!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                }
            },
            error: function (error) {
                _this.alertModel('订单驳回失败!');
            }
        })
    },
    getAjax: function (params) {
        var _this = this;
        var defData = {
            orderId: _this.tmp.orderId
        }
        if (params.data) {
            $.extend(defData, params.data);
        }
        $.ajax({
            url: util.getServerUrl(params.url),
            dataType: 'json',
            method: params.method || 'POST',
            data: defData,
            success: function (res) {
                params.success(res);
            },
            error: function (error) {
                params.error(error);
            }

        })
    },

    // 获取基础信息数据
    getBaseInfo: function (cb) {
        var _this = this;
        this.getAjax({
            url: '/loanOrder/getOrderBaseInfo',
            success: function (res) {
                if (res.status == '0') {
                    if (res.data.carInfo == '') {
                        $('.car-info').remove();
                        _this.renderBaseHtml(res.data, false);
                    } else {
                        _this.renderBaseHtml(res.data, true);
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

                } else {
                    if (res.msg == '') {
                        _this.alertModel('信息获取失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('信息获取失败，请稍后重试!');
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
    },
    // 根据获取的数据渲染基本信息页面
    renderBaseHtml: function (data, boolean) {
        var _this = this;
        // 申请信息
        for (var k in this.dom.applyInfo) {
            this.dom.applyInfo[k].val(data.applyInfo[k]);
        }
        // 个人信息
        for (var k in this.dom.baseInfo) {
            this.dom.baseInfo[k].val(data.baseInfo[k]);
        }
        // 工作单位
        for (var k in this.dom.workInfo) {
            this.dom.workInfo[k].val(data.workInfo[k]);
        }
        // 联系人
        renderRelative(data.relativesInfo);
        if (boolean) {
            // 车辆信息
            for (var k in this.dom.carInfo) {
                this.dom.carInfo[k].val(data.carInfo[k]);
            }
        }

        // 单独渲染联系人模块
        function renderRelative(data) {
            var strName = '',strMobile = '';
            $.each(data,function (k, v) {
                strName += '<li><i class="desc-name">'+v.typeName+': </i> <input disabled data-id="'+v.id+'" data-type="'+v.relativeType+'" class="form-control" type="text" value="'+v.relativeName+'"></li>';
                strMobile += '<li><i class="desc-name">'+v.typeName+'电话: </i> <input disabled data-id="'+v.id+'" data-type="'+v.relativeType+'" class="form-control" type="text" value="'+v.relativeMobile+'"></li>';
            })
            $('.relative-name').html(strName);
            $('.relative-mobile').html(strMobile);
        }
    },
    // 获取信用信息数据
    getCreditInfo: function () {
        var _this = this;
        this.getAjax({
            url: '/loanOrder/getOrderCreditInfo',
            success: function (res) {
                if (res.status == 0) {
                    _this.renderCreditHtml(res.data);
                } else {
                    if (res.msg == '') {
                        _this.alertModel('信用信息获取失败，请稍后刷新重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (res) {
                _this.alertModel('信用信息获取失败，请稍后刷新重试!');
            }
        })

    },
    // 渲染信用信息页面
    renderCreditHtml: function (data) {
        // 如果有征信情况
        if (JSON.stringify(data.userCredit) != '{}') {
            for (var k in this.dom.userCredit) {
                this.dom.userCredit[k].val(data.userCredit[k]);
            }
        }

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
    // 信用信息征信情况保存
    saveCredit: function (data) {
        var _this = this;
        this.getAjax({
            url: '/loanOrder/addUserCredit',
            data: data,
            success: function (res) {
                if (res.status == 0) {
                    _this.alertModel('征信情况保存成功!');
                } else {
                    if (res.msg == '') {
                        _this.alertModel('征信情况保存失败!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('征信情况保存失败!');
            }
        })
    },
    // 征信情况为禁止状态
    disUserCredit: function () {
        for (var k in this.dom.userCredit) {
            this.dom.userCredit[k].attr('disabled', true);
        }
    },
    // 获取人工核查信息数据
    getPeopleCheckInfo: function () {
        var _this = this;
        this.getAjax({
            url: '/loanOrder/getOrderHumanVerifyInfo',
            success: function (res) {
                if (res.status == '0') {
                    if (res.data.carInfo.data == '') {
                        $('.car-info').remove();
                        _this.renderPeopleCheckHtml(res.data, false);
                    } else {
                        _this.renderPeopleCheckHtml(res.data, true);
                    }
                    renderAssetProve(res.data.attachMaterial,'idProve');
                    //此处必须重新渲染一次图片实例
                    $('.idProve [data-magnify=gallery]').magnify({
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
                        multiInstances : false,
                        footToolbar : ['zoomIn','zoomOut','prev','fullscreen','next','rotateLeft','rotateRight'],
                        headToolbar : ['maximize','close'],
                        callbacks : {
                            closed: function(el){
                                // Will fire after modal is closed
                            },
                        }
                    });
                    _this.getTooltip();
                } else {
                    if (res.msg == '') {
                        _this.alertModel('信息获取失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('信息获取失败，请稍后重试!');
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
    },
    // 渲染人工核查信息数据
    renderPeopleCheckHtml: function (data, boolean) {
        var _this = this;
        // 申请信息
        for (var k in this.dom.applyInfo) {
            this.dom.applyInfo[k].val(data.applyInfo.data[k]);
        }
        // 申请信息是否异常
        for (var k in this.dom.applyInfoCheck) {
            this.dom.applyInfoCheck[k].val('' + data.applyInfo.check[k]);
        }
        // 个人信息
        for (var k in this.dom.baseInfo) {
            this.dom.baseInfo[k].val(data.baseInfo.data[k]);
        }
        // 个人信息是否异常
        for (var k in this.dom.baseInfoCheck) {
            this.dom.baseInfoCheck[k].val('' + data.baseInfo.check[k]);
        }
        // 工作单位
        for (var k in this.dom.workInfo) {
            this.dom.workInfo[k].val(data.workInfo.data[k]);
        }
        // 工作单位是否异常
        for (var k in this.dom.workInfoCheck) {
            this.dom.workInfoCheck[k].val('' + data.workInfo.check[k]);
        }
        // 联系人
        renderRelative(data.relativesInfo.data);
        // 联系人是否异常
        for (var k in this.dom.relativesInfoCheck) {
            this.dom.relativesInfoCheck[k].val('' + data.relativesInfo.check[k]);
        }
        if (boolean) {
            // 车辆信息
            for (var k in this.dom.carInfo) {
                this.dom.carInfo[k].val(data.carInfo.data[k]);
            }
            // 车辆信息是否异常
            for (var k in this.dom.carInfoCheck) {
                this.dom.carInfoCheck[k].val('' + data.carInfo.check[k]);
            }
        }
        // 单独渲染联系人模块
        function renderRelative(data) {
            var strName = '',strMobile = '';
            $.each(data,function (k, v) {
                strName += '<li><i class="desc-name">'+v.typeName+': </i> <input disabled data-id="'+v.id+'" data-type="'+v.relativeType+'" class="form-control" type="text" value="'+v.relativeName+'"></li>';
                strMobile += '<li><i class="desc-name">'+v.typeName+'电话: </i> <input disabled data-id="'+v.id+'" data-type="'+v.relativeType+'" class="form-control" type="text" value="'+v.relativeMobile+'"></li>';
            })
            $('.relative-name').html(strName);
            $('.relative-mobile').html(strMobile);
        }
    },
    // 信审信息初审获取
    getAuditFirstInfo: function () {
        var _this = this;
        $('#fore .first-reply').show();
        _this.getAjax({
            url: '/loanOrder/getOrderAuditInfo',
            success: function (res) {
                if (res.status == 0) {
                    _this.renderAuditBaseHtml(res.data);
                    $('#riskGrade').val(res.data.auditInfo.riskGrade);
                    $('#auditAmount').val(res.data.auditInfo.auditAmount==''?res.data.auditInfo.amount:res.data.auditInfo.auditAmount).attr('data-amount',res.data.auditInfo.amount);
                    $('#enterpriseCase').val(res.data.auditInfo.enterpriseCase);
                    $('#projectContent').val(res.data.auditInfo.projectContent);
                    $('#fundsUse').val(res.data.auditInfo.fundsUse);
                    $('#geAgcyAdvice').val(res.data.auditInfo.geAgcyAdvice);
                } else {
                    if (res.msg == '') {
                        _this.alertModel('信审信息获取失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('信审信息获取失败，请稍后重试!');
            }
        })

    },
    // 信审信息复审获取
    getAuditAgainInfo: function () {
        var _this = this;
        $('#fore .first-reply').show().find('.credit-trial-first-control-info').hide();
        $('#fore .phone-examine').hide();
        $('#fore .again-reply').show();
        _this.getAjax({
            url: '/loanOrder/getOrderAuditInfo',
            success: function (res) {
                if (res.status == 0) {
                    _this.renderAuditBaseHtml(res.data);
                    _this.renderFirstReplyHtml(res.data);
                } else {
                    if (res.msg == '') {
                        _this.alertModel('信审信息获取失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('信审信息获取失败，请稍后重试!');
            }
        })
    },
    // 信审信息终审获取
    getAuditFinalInfo: function () {
        var _this = this;
        $('#fore .first-reply').show().find('.credit-trial-first-control-info').hide();
        $('#fore .phone-examine').hide();
        $('#fore .final-reply').show();
        _this.getAjax({
            url: '/loanOrder/getOrderAuditInfo',
            success: function (res) {
                if (res.status == 0) {
                    _this.renderAuditBaseHtml(res.data);
                    _this.renderFirstReplyHtml(res.data);
                    if (isHasAgainReply(res.data.updateLog)) {
                        $('#fore .again-reply').show().find('.credit-trial-again-control-info').hide();
                        _this.renderAgainReplyHtml(res.data);
                    }

                } else {
                    if (res.msg == '') {
                        _this.alertModel('信审信息获取失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('信审信息获取失败，请稍后重试!');
            }
        })

        // 判断是否有复审
        function isHasAgainReply(data) {
            var flag = false;
            $.each(data, function (key, val) {
                if (val.updateStatus == 51) {
                    flag = true;
                }
            })
            return flag;
        }
    },
    // 信审信息贷后获取
    getAuditAfterLoan: function () {
        var _this = this;
        _this.getAjax({
            url: '/loanOrder/getOrderAuditInfo',
            success: function (res) {
                if (res.status == 0) {
                    _this.renderAuditBaseHtml(res.data);

                    if (isHasReply(5, res.data.updateLog)) {
                        $('#fore .first-reply').show().find('.credit-trial-first-control-info').hide();
                        _this.renderFirstReplyHtml(res.data);
                    }
                    if (isHasReply(51, res.data.updateLog)) {
                        $('#fore .again-reply').show().find('.credit-trial-again-control-info').hide();
                        _this.renderAgainReplyHtml(res.data);
                    }
                    if (isHasReply(7, res.data.updateLog)) {
                        $('#fore .final-reply').show().find('.credit-trial-final-control-info').hide();
                        _this.renderFinalReplyHtml(res.data);
                    }

                } else {
                    if (res.msg == '') {
                        _this.alertModel('信审信息获取失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('信审信息获取失败，请稍后重试!');
            }
        })

        function isHasReply(value, data) {
            var flag = false;
            $.each(data, function (key, val) {
                if (val.updateStatus == value) {
                    flag = true;
                }
            })
            return flag;
        }
    },
    // 信审信息基本渲染
    renderAuditBaseHtml: function (data) {
        // 渲染电话核查
        var str = '', str2 = '', arr = data.teleAuditInfo;
        for (var i = 0; i < arr.length; i++) {
            str += '<tr>';
            str += '<td>' + arr[i].contactName + '</td>';
            str += '<td>' + arr[i].contactPhone + '</td>';
            str += '<td>' + arr[i].relation + '</td>';
            str += '<td>' + (arr[i].remark == undefined ? "" : arr[i].remark) + '</td>';
            str += '<td><span onclick="firstTrial.editPhoneFunc(this)" data-id="'+arr[i].id+'" class="edit-phone">编辑</span><span data-id="'+arr[i].id+'" onclick="firstTrial.delPhoneFunc(this)" class="del-phone">删除</span></td>';
            str += '</tr>';
        }
        $("#teleAuditInfoTbody").html(str);
        // 渲染电审内容
        str2 += '<ul>';
        str2 += '<li>合作渠道: &nbsp;<span>' + data.auditInfo.channelName + '</span></li>';
        str2 += '<li>还款方式: &nbsp;<span>' + data.auditInfo.repayWay + '</span></li>';
        str2 += '<li>期限: &nbsp;<span>' + data.auditInfo.period + '</span></li>';
        str2 += '</ul>';
        str2 += '<ul>';
        str2 += '<li>所购车辆: &nbsp;<span>' + data.auditInfo.usageDesc + '</span></li>';
        str2 += '<li>贷款金额: &nbsp;<span>' + data.auditInfo.amount + '</span></li>';
        str2 += '<li>贷款利率: &nbsp;<span>' + data.auditInfo.auditRating + '</span></li>';
        str2 += '</ul>';
        str2 += '<ul>';
        str2 += '<li>平台服务费率: &nbsp;<span>' + data.auditInfo.auditServiceRating + '</span></li>';
        str2 += '</ul>';
        $("#auditContent").html(str2);
    },
    // 渲染初审批复
    renderFirstReplyHtml: function (data) {
        $('#riskGrade').val(data.auditInfo.riskGrade);
        $('#auditAmount').val(data.auditInfo.auditAmount);
        $('#enterpriseCase').val(data.auditInfo.enterpriseCase);
        $('#projectContent').val(data.auditInfo.projectContent);
        $('#fundsUse').val(data.auditInfo.fundsUse);
        $('#geAgcyAdvice').val(data.auditInfo.geAgcyAdvice);
        $('#firstRemark').val(this.getReply(data.updateLog, 5).remark);
        // 右侧审批时间
        $('#firstReplyTime').addClass('show');
        $('#firstReplyTime span:eq(0)').text(this.getReply(data.updateLog, 5).userName);
        $('#firstReplyTime span:eq(1)').text(this.getReply(data.updateLog, 5).updateDate);
        // 通过状态图标
        $('#fore .first-reply span.icon-font-checked').addClass('show-icon');
    },
    // 渲染复审批复
    renderAgainReplyHtml: function (data) {
        $('#againRemark').val(this.getReply(data.updateLog, 51).remark);
        // 右侧审批时间
        $('#againReplyTime').addClass('show');
        $('#againReplyTime span:eq(0)').text(this.getReply(data.updateLog, 51).userName);
        $('#againReplyTime span:eq(1)').text(this.getReply(data.updateLog, 51).updateDate);
        // 通过状态图标
        $('#fore .again-reply span.icon-font-checked').addClass('show-icon');
    },
    // 渲染终审批复
    renderFinalReplyHtml: function (data) {
        $('#finalRemark').val(this.getReply(data.updateLog, 7).remark);
        // 右侧审批时间
        $('#finalReplyTime').addClass('show');
        $('#finalReplyTime span:eq(0)').text(this.getReply(data.updateLog, 7).userName);
        $('#finalReplyTime span:eq(1)').text(this.getReply(data.updateLog, 7).updateDate);
        // 通过状态图标
        $('#fore .final-reply span.icon-font-checked').addClass('show-icon');
    },
    // 初审批复通过
    firstAuditPass: function () {
        var _this = this;
        var params = {
            resultValue: 1,
            riskGrade: $('#riskGrade').val(),
            auditAmount: $.trim($('#auditAmount').val()),
            remark: $.trim($('#firstRemark').val()),
            enterpriseCase: $.trim($('#enterpriseCase').val()),
            projectContent: $.trim($('#projectContent').val()),
            fundsUse: $.trim($('#fundsUse').val()),
            geAgcyAdvice: $.trim($('#geAgcyAdvice').val()),
            processId: this.tmp.processId
        },limitAmountValue = $('#auditAmount').attr('data-amount');
        if(params.auditAmount==''){
            _this.alertModel('请填写贷款金额!');
            return;
        }
        if(Number(limitAmountValue)!=0){
            if(Number(params.auditAmount) > Number(limitAmountValue)){
                _this.alertModel('批复金额不能超过申请金额,请重新填写!');
                return;
            }
        }
        if(params.remark==''){
            _this.alertModel('请填写初审意见!');
            return;
        }
        this.getAjax({
            url: '/loanOrder/examineOrder',
            data: params,
            success: function (res) {
                if (res.status == 0) {
                    // 查询listOrderProcess根据orderStatus判断产品配置情况
                    _this.getAjax({
                        url: '/common/listOrderProcess',
                        success: function (res) {
                            if (res.status == 0) {
                                _this.auditIsChecked(res.orderStatus);
                            }
                        }
                    })

                    var top = $('#fore .first-reply').offset().top - 100;
                    $('html,body').animate({scrollTop: top}, 250, function () {
                        $('#fore .first-reply span.icon-font-checked').addClass('show-icon');
                    });

                    // 直接隐藏操作区
                    $('#fore .first-reply .select-flag').hide();

                } else {
                    if (res.msg == '') {
                        _this.alertModel('初审通过失败,请检查是否有未填项!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('初审通过失败!');
            }
        })
    },
    // 复审批复通过
    againAuditPass: function () {
        var _this = this;
        var params = {
            resultValue: 1,
            remark: $.trim($('#againRemark').val()),
            processId: this.tmp.processId
        }
        if(params.remark==''){
            _this.alertModel('请填写复审意见!');
            return;
        }
        this.getAjax({
            url: '/loanOrder/examineOrder',
            data: params,
            success: function (res) {
                if (res.status == 0) {
                    // 查询listOrderProcess根据orderStatus判断产品配置情况
                    _this.getAjax({
                        url: '/common/listOrderProcess',
                        success: function (res) {
                            if (res.status == 0) {
                                _this.auditIsChecked(res.orderStatus);
                            }
                        }
                    })

                    var top = 0;
                    $('html,body').animate({scrollTop: top}, 250, function () {
                        $('#fore .again-reply span.icon-font-checked').addClass('show-icon');
                    });

                    // 直接隐藏操作区
                    $('#fore .again-reply .select-flag').hide();


                } else {
                    if (res.msg == '') {
                        _this.alertModel('复审通过失败!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('复审通过失败!');
            }
        })
    },
    // 终审批复通过
    finalAuditPass: function () {
        var _this = this;
        var params = {
            resultValue: 1,
            remark: $.trim($('#finalRemark').val()),
            processId: this.tmp.processId
        }
        if(params.remark==''){
            _this.alertModel('请填写终审意见!');
            return;
        }
        this.getAjax({
            url: '/loanOrder/examineOrder',
            data: params,
            success: function (res) {
                if (res.status == 0) {
                    // 查询listOrderProcess根据orderStatus判断产品配置情况
                    _this.getAjax({
                        url: '/common/listOrderProcess',
                        success: function (res) {
                            if (res.status == 0) {
                                _this.auditIsChecked(res.orderStatus);
                            }
                        }
                    })

                    var top = 0;
                    $('html,body').animate({scrollTop: top}, 250, function () {
                        $('#fore .final-reply span.icon-font-checked').addClass('show-icon');
                    });

                    // 直接隐藏操作区
                    $('#fore .final-reply .select-flag').hide();

                } else {
                    if (res.msg == '') {
                        _this.alertModel('终审通过失败!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('终审通过失败!');
            }
        })
    },
    // 获取updateLog中需要的批复
    getReply: function (dataArr, dataType) {
        var obj = {};
        $.each(dataArr, function (key, val) {
            if (val.updateStatus == dataType) {
                obj = val;
            }
        })
        return obj;
    },
    //信审信息电话核查新增
    addPhoneExamine: function () {
        var _this = this;
        $('#phoneModal input').val('');
        $('#phoneModal textarea').val('');
        $('#phoneModal').modal('show');
        $('#savePhoneExamine').off('click').on('click', function () {
            var value = {
                contactName: $.trim($('#phoneModal input:eq(0)').val()),
                contactPhone: $.trim($('#phoneModal input:eq(1)').val()),
                relation: $.trim($('#phoneModal input:eq(2)').val()),
                remark: $.trim($('#phoneModal textarea').val()),
                orderId: _this.tmp.orderId
            }, alertMsg = $('#phoneModal .modal-footer span');
            if (!util.validate(value.contactName, 'require')) {
                alertMsg.addClass('show-msg');
                return;
            }
            if (!util.validate(value.contactPhone, 'require')) {
                alertMsg.addClass('show-msg');
                return;
            }
            if (!util.validate(value.relation, 'require')) {
                alertMsg.addClass('show-msg');
                return;
            }
            $.ajax({
                url: util.getServerUrl('/loanOrder/addPhoneCheck'),
                method: 'POST',
                data: value,
                success: function (res) {
                    $('#phoneModal').modal('hide');
                    if (res.status == 0) {
                        _this.getAuditFirstInfo();
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('电话核查保存失败，请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                        ;
                    }
                },
                error: function (error) {
                    $('#phoneModal').modal('hide');
                    _this.alertModel('电话核查保存失败，请稍后重试!');
                }
            })
        })
    },
    // 信审信息电话修改保存
    savePhoneExamine : function(){
        var _this = this;
        var name = this.phoneModalDom.name,
            number = this.phoneModalDom.number,
            relation = this.phoneModalDom.relation,
            remark = this.phoneModalDom.remark;
        var value = {
            contactName: $.trim(name.val()),
            contactPhone: $.trim(number.val()),
            relation: $.trim(relation.val()),
            remark: $.trim(remark.val()),
            orderId: _this.tmp.orderId,
            id : $('#savePhoneExamineEdit').attr('data-id')
        }, alertMsg = $('#phoneModal .modal-footer span');
        if (!util.validate(value.contactName, 'require')) {
            alertMsg.addClass('show-msg');
            return;
        }
        if (!util.validate(value.contactPhone, 'require')) {
            alertMsg.addClass('show-msg');
            return;
        }
        if (!util.validate(value.relation, 'require')) {
            alertMsg.addClass('show-msg');
            return;
        }
        $.ajax({
            url: util.getServerUrl('/loanOrder/addPhoneCheck'),
            method: 'POST',
            data: value,
            success: function (res) {
                $('#phoneModalEdit').modal('hide');
                if (res.status == 0) {
                    _this.getAuditFirstInfo();
                } else {
                    if (res.msg == '') {
                        _this.alertModel('电话核查保存失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                $('#phoneModalEdit').modal('hide');
                _this.alertModel('电话核查保存失败，请稍后重试!');
            }
        })
    },
    // 电话删除请求
    delPhone : function(id){
        var _this = this;
        $.ajax({
            url: util.getServerUrl('/loanOrder/deletePhoneCheck'),
            data : {id:id},
            method: 'POST',
            success: function (res) {
                if (res.status == 0) {
                    _this.alertModel('删除成功');
                    setTimeout(function(){
                        $('#myModal').modal('hide');
                    },1500);
                    $('#myModal').on('hidden.bs.modal', function (e) {
                        _this.getAuditFirstInfo();
                    })
                } else {
                    if (res.msg == '') {
                        _this.alertModel('删除出错，请稍后重试!')
                    } else {
                        _this.alertModel(res.msg);
                    }
                }
            },
            error: function (error) {
                _this.alertModel('删除出错，请稍后重试!')
            }
        })
    },
    // 电话删除方法
    delPhoneFunc : function(dom){
        var id = $(dom).data('id'),_this=this;
        this.alertModelConfirm('确认要删除吗?');
        $('#confirmDelPhone').off('click').on('click', function () {
            _this.delPhone(id);
            $('#myModalConfirm').modal('hide');
        });
    },
    // 电话编辑请求
    editPhone : function(id){
        var _this = this;
        var name = this.phoneModalDom.name,
            number = this.phoneModalDom.number,
            relation = this.phoneModalDom.relation,
            remark = this.phoneModalDom.remark;
        $.ajax({
            url: util.getServerUrl('/loanOrder/getPhoneCheck'),
            data : {id:id},
            method: 'POST',
            success: function (res) {
                if (res.status == 0) {
                    name.val(res.data.contactName);
                    number.val(res.data.contactPhone);
                    relation.val(res.data.relation);
                    remark.val(res.data.remark);
                    $('#savePhoneExamineEdit').attr('data-id', id);
                } else {
                    _this.alertModel('信息读取出错，请稍后重试!');
                }
            },
            error: function (error) {
                _this.alertModel('信息读取出错，请稍后重试!')
            }
        })
    },
    // 电话编辑方法
    editPhoneFunc : function(dom){
        var id = $(dom).data('id');
        this.editPhone(id);
        $('#phoneModalEdit').modal('show');
    },
    // 保存反欺诈核查
    saveRevCheck: function () {
        var checkVal = '', _this = this;
        $('input[name="rev-cheat-result"]').each(function () {
            if ($(this).is(':checked')) {
                checkVal = $(this).val();
            }
        });
        var data = [{
            "orderId": _this.tmp.orderId,
            "abnormal": parseInt(checkVal),
            "remark": $.trim($('#revCheatDesc').val()),
            "dataType": 21
        }];
        $.ajax({
            url: util.getServerUrl('/loanOrder/addOrderInfoCheck'),
            data: JSON.stringify(data),
            contentType: 'application/json;charset=UTF-8',
            method: 'POST',
            success: function (res) {
                if (res.status == 0) {
                    _this.alertModel('信息保存成功!');
                    $('#myModal').on('hidden.bs.modal', function (e) {
                        $("#navTab").load(_this.variable.basePath + 'loanOrder/listAfterOrderPage');
                    })
                } else {
                    if (res.msg == '') {
                        _this.alertModel('信息保存失败!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('信息保存失败!');
            }
        })
    },
    // 操作日志渲染
    renderOperateHtml: function () {
        var _this = this;
        this.getAjax({
            url: '/loanOrder/getOrderOperateLog',
            success: function (res) {
                var tbody = $('#six tbody'),
                    str = '',
                    orderLogInfo = res.data.orderLogInfo;
                if (res.status == 0) {
                    if (orderLogInfo.length != 0) {
                        for (var i = 0; i < orderLogInfo.length; i++) {
                            str += '<tr>';
                            str += '<td>' + _this.optimizeVal(orderLogInfo[i].processName) + '</td>';
                            str += '<td>' + _this.optimizeVal(orderLogInfo[i].updateStatusName) + '('+_this.optimizeVal(orderLogInfo[i].updateStatus)+')' + '</td>';
                            str += '<td>' + _this.optimizeVal(_this.formatTime(orderLogInfo[i].updateDate)) + '</td>';
                            str += '<td>' + _this.optimizeVal(orderLogInfo[i].userName) + '</td>';
                            str += '<td>' + _this.optimizeVal(orderLogInfo[i].updateStatusName) + '</td>';
                            str += '<td>' + _this.optimizeVal(orderLogInfo[i].remark) + '</td>';
                            str += '</tr>';
                        }
                        tbody.html(str);
                    }
                } else {
                    if (res.msg == '') {
                        _this.alertModel('操作日志获取失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('操作日志获取失败，请稍后重试!');
            }
        })
    },
    // 如果传入为空则返回空否则为该值
    optimizeVal: function (value) {
        return value ? value : '';
    },
    // 渲染拒绝理由
    renderRefuseHtml: function () {
        var opt = '<option value="不符合产品政策">不符合产品政策</option>';
        opt += '<option value="法院执行">法院执行</option>';
        opt += '<option value="直系亲属联系人反对贷款">直系亲属联系人反对贷款</option>';
        opt += '<option value="工作虚假">工作虚假</option>';
        opt += '<option value="联系人虚假">联系人虚假</option>';
        opt += '<option value="客户不需要">客户不需要</option>';
        opt += '<option value="第三方征信建议拒绝">第三方征信建议拒绝</option>';
        opt += '<option value="通讯录异常">通讯录异常</option>';
        opt += '<option value="资料虚假">资料虚假</option>';
        opt += '<option value="综合情况差(真实性、稳定性、还款能力、还款意愿)">综合情况差(真实性、稳定性、还款能力、还款意愿)</option>';
        opt += '<option value="其他">其他</option>';
        $('.select-flag select[name="refuse"]').html(opt);
    },
    // 渲染拒件原因
    renderRefuseReasonHtml: function (treeClass, input) {
        $(treeClass).treeview({
            data: refuseData,
            levels: 0, // 默认展开级别
            onNodeSelected: function (event, data) {
                $(input).val(data.text);
                $(treeClass).toggleClass('show');
            }
        });
    },
    // 显示隐藏拒绝列表
    toggleRefuse: function (clickId, showClass) {
        // 点击拒绝原因弹出列表选择
        $(clickId).on('click', function () {
            $(this).siblings(showClass).toggleClass('show');
        })
    },
    // 订单审批数据渲染
    renderOrderReply: function () {
        var _this = this;
        this.getAjax({
            url: '/loanOrder/getOrderApprovalInfo',
            success: function (res) {
                if (res.status == 0) {
                    var html = template('orderReply', res.data);
                    $('#order_reply_table').html(html);
                    // 根据返回的数字判断中文
                    $('#tpl_sex').text(sex(res.data.familyInfo.sex));
                    $('#tpl_marrStatus').text(marryStatus(res.data.familyInfo.marrStatus));
                    $('#tpl_estateType').text(estateType(res.data.familyInfo.estateType));
                    // 填充初审复审终审
                    $.each(res.data.updateLog, function (key, val) {
                        var str = '';
                        str += val.updateReason + '<br>';
                        str += val.userName + '，' + val.updateDate;
                        if (val.updateStatus == 5) {
                            $('#tableFirstAudit td:eq(1)').html(str);
                        } else if (val.updateStatus == 51) {
                            $('#tableAgainAudit td:eq(1)').html(str);
                        } else if (val.updateStatus == 7) {
                            $('#tableFinalAudit td:eq(1)').html(str);
                        }
                    })


                } else {
                    if (res.msg == '') {
                        _this.alertModel('订单审批数据获取失败，请稍后重试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
                }
            },
            error: function (error) {
                _this.alertModel('订单审批数据获取失败，请稍后重试!');
            }
        })

        function sex(n) {
            switch (n) {
                case 1 :
                    return '男';
                    break;
                case 0 :
                    return '女';
                    break;
            }
        }

        function marryStatus(n) {
            switch (n) {
                case 1 :
                    return '已婚';
                    break;
                case 2 :
                    return '未婚';
                    break;
                case 3 :
                    return '离异';
                    break;
                case 4 :
                    return '丧偶';
                    break;
                case 5 :
                    return '再婚';
                    break;
            }
        }

        function estateType(n) {
            switch (n) {
                case 1 :
                    return '一次性购买';
                    break;
                case 2:
                    return '按揭(月还款)';
                    break;
                case 3 :
                    return '租赁(月租金)';
                    break;
                case 4 :
                    return '与父母同住';
                    break;
                case 5 :
                    return '自建';
                    break;
                case 6 :
                    return '其他';
                    break;
            }
        }
    },
    // 获取订单状态
    getStatus: function () {
        var _this = this;
        this.getAjax({
            url: '/common/listOrderProcess',
            success: function (res) {
                if (res.status == 0) {
                    _this.renderProcess(res.data);
                    _this.isChecked(res.checkRecord);
                    _this.auditIsChecked(res.orderStatus);
                } else {
                    if (res.msg == '') {
                        _this.alertModel('订单流程状态获取失败，请稍后再试!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                    ;
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
    // 渲染是否已经核对过的状态
    isChecked: function (data) {
        for (var i = 0; i < data.length; i++) {
            $('#myTabs a:eq(' + (data[i].dataType - 1) + ')').find('span.badge').addClass('show-badge');
        }
    },
    // 信审信息单独检查是否已核对
    auditIsChecked: function (orderStatus) {
        if ((orderStatus >= 7 && orderStatus != 51) && (orderStatus >= 7 && orderStatus != 52)) {
            $('#myTabs a:eq(3)').find('span.badge').addClass('show-badge');
        }
    },
    // 打印审批表
    printTable: function () {
        $('#printer_table').on('click', function () {
            $('#order_reply_table').jqprint();
        })
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
    // 删除模态框
    alertModelConfirm : function(str){
        $('#myModalConfirm .modal-body').empty().html('<p>' + str + '</p>');
        $('#myModalConfirm').modal('show');
    },
    // 初始化图片
    initImage : function () {
        $('[data-magnify=gallery]').magnify({
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
            multiInstances : false,
            footToolbar : ['zoomIn','zoomOut','prev','fullscreen','next','rotateLeft','rotateRight'],
            headToolbar : ['maximize','close'],
            callbacks : {
                closed: function(el){
                    // Will fire after modal is closed
                },
            }
        });
    },
    // 转换时间
    formatTime: function (time) {
        if (time) {
            var date = new Date(time);
            return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate() + ' ' + date.getHours() + ':' + date.getMinutes() + ':' + date.getSeconds();
        }
    },
    // 判断节点是否存在
    exist: function ($dom) {
        if ($dom.length >= 1) {
            return true;
        }
        return false;
    },

};
