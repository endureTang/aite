<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<link rel="stylesheet" href="static/plugins/webuploader/webuploader.css">
<link rel="stylesheet" href="static/plugins/magnify/jquery.magnify.min.css">
<link rel="stylesheet" href="static/css/management-first-trial.css">
<link rel="stylesheet" href="static/css/after-loan.css">
<div class="container-fluid" v-cloak>
    <div class="nav-bar">
        <a data-model="navTab" data-url="<%=basePath%>repayInfoMenu/getRepayInfo?orderNo=${orderNo}">返回还款信息</a>
    </div>
    <div class="tab-con">
        <div>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane" id="one">
                    <!--还款信息-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">提前结清</h3>
                        </div>
                        <div class="panel-body">
                            <table class="table after-loan-table">
                                <tbody>
                                <tr>
                                    <td class="bg">借款订单编号</td>
                                    <td class="order-num">${repayInfo.orderNo}</td>
                                    <td class="bg">产品名称</td>
                                    <td>${repayInfo.productName}</td>
                                    <td class="bg">平台服务费</td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td class="bg">借款金额(元)</td>
                                    <td>${repayInfo.auditAmount}</td>
                                    <td class="bg">借款期限(期)</td>
                                    <td>${repayInfo.auditPeriod}</td>
                                    <td class="bg">借款利率（年化）</td>
                                    <td>${repayInfo.auditRating}</td>
                                </tr>
                                <tr>
                                    <td class="bg">借款人</td>
                                    <td>${repayInfo.userName}</td>
                                    <td class="bg">联系电话</td>
                                    <td>${repayInfo.userMobile}</td>
                                    <td class="bg">还款方式</td>
                                    <td>${repayInfo.repayWay}</td>
                                </tr>
                                <tr>
                                    <td class="bg">应还本金</td>
                                    <td>${repayInfo.planRepayCapital}</td>
                                    <td class="bg">应还利息</td>
                                    <td colspan="3">${repayInfo.planRepayInterest}</td>
                                    
                                </tr>
                                <tr>
                                    <td class="bg">已还本金</td>
                                    <td>${repayInfo.accRepayCapital}</td>
                                    <td class="bg">已还利息</td>
                                    <td colspan="3">${repayInfo.accReapyInterest}</td>
                                </tr>
                                <tr>
                                    <td class="bg">剩余本金</td>
                                    <td>${repayInfo.planRepayCapital - repayInfo.accRepayCapital}</td>
                                    <td class="bg">剩余利息</td>
                                    <td colspan="3">${repayInfo.planRepayInterest - repayInfo.accReapyInterest}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="panel-body">
                            <table class="table after-loan-table">		<!-- 还款计划 -->
                                <tbody>
                                	<tr>
                                		<td colspan="6"><span style="float:left;">还款计划结清</span></td>
                                	</tr>
	                               	<tr>
	                                   <td class="bg">结清时间</td>
	                                   <td colspan="5">
	                                   	<input value="${repayInfo.rpEarlySettleDate}" id="rpAccRepayDate" class="form-control" />
	                                   </td>
	                                </tr>
	                                <c:forEach items="${repayInfo.rpAccFeeTableHead}" var="tableHead" varStatus="sta">
	                                	<tr>
		                                    <td class="bg">${tableHead}</td>
		                                    <td class="order-num" colspan="5">
		                                    	<input id="${repayInfo.rpAccFeeCodeSortList[sta.index]}" name="repayPlanDynamicFee" value="${repayInfo.rpAccFeeValueList[sta.index]}" class="form-control" />
		                                    </td>
	                                	</tr>
	                                </c:forEach>
	                                <tr>
	                                    <td class="bg">违约金</td>
	                                    <td class="order-num" colspan="5">
	                                    	<input value="${repayInfo.rpEarlySettleServiceFee}" id="rpAccPayPenalty" class="form-control" />
	                                    </td>
	                                </tr>
                                </tbody>
                            </table>
                            <table class="table after-loan-table">	<!-- 小贷公司 -->
                                <tbody>
                                	<tr>
                                		<td colspan="6"><span style="float:left;">${repayInfo.mbCoporateName}回款计划结清</span></td>
                                	</tr>
                                	<tr>
	                                   <td class="bg">结清时间</td>
	                                   <td colspan="5">
	                                   	<input value="${repayInfo.mbEarlySettleDate}" id="mbAccRepayDate" class="form-control" />
	                                   </td>
	                                </tr>
	                                <c:forEach var="tableHead" items="${repayInfo.mbAccFeeTableHead}" varStatus="sta">
	                                	<tr>
		                                    <td class="bg">${tableHead}</td>
		                                    <td class="order-num" colspan="5">
		                                    	<input id="${repayInfo.mbAccFeeCodeSortList[sta.index]}" name="moneyBackPlanDynamicFee" value="${repayInfo.mbAccFeeValueList[sta.index]}" class="form-control" />
		                                    </td>
	                                	</tr>
	                                </c:forEach>
	                                <tr>
	                                    <td class="bg">违约金</td>
	                                    <td class="order-num" colspan="5">
	                                    	<input value="${repayInfo.mbEarlySettleServiceFee}" id="mbAccPayPenalty" class="form-control" />
	                                    </td>
	                                </tr>
                                </tbody>
                            </table>
                            <c:if test="${repayInfo.cmbCoporateName != null && repayInfo.cmbCoporateName != ''}">
	                            <table class="table after-loan-table">	<!-- 资金渠道 -->
	                                <tbody>
	                                	<tr>
	                                		<td colspan="6"><span style="float:left;">${repayInfo.cmbCoporateName}回款计划结清</span></td>
	                                	</tr>
	                                	<tr>
		                                   <td class="bg">结清时间</td>
		                                   <td colspan="5">
		                                   	<input value="${repayInfo.cmbEarlySettleDate}" id="cmbAccRepayDate" class="form-control" />
		                                   </td>
		                                </tr>
		                                <c:forEach var="tableHead" items="${repayInfo.cmbAccFeeTableHead}" varStatus="sta">
		                                	<tr>
			                                    <td class="bg">${tableHead}</td>
			                                    <td class="order-num" colspan="5">
			                                    	<input id="${repayInfo.cmbAccFeeCodeSortList[sta.index]}" name="captialMoneyBackPlanDynamicFee" value="${repayInfo.cmbAccFeeValueList[sta.index]}" class="form-control" />
			                                    </td>
		                                	</tr>
		                                </c:forEach>
		                                <tr>
		                                    <td class="bg">违约金</td>
		                                    <td class="order-num" colspan="5">
		                                    	<input value="${repayInfo.cmbEarlySettleServiceFee}" id="cmbAccPayPenalty" class="form-control" />
		                                    </td>
		                                </tr>
	                                </tbody>
	                            </table>
                            </c:if>
                        </div>
                    </div>

                    <!--附件-->
                    <div class="panel panel-info asset-images">
                        <div class="panel-heading">
                            <h3 class="panel-title">附件</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <ul class="asset-prove" style="display: block;">
                                <li>
                                    <p>提前结清</p>
                                    <c:forEach items="${repayInfo.attahmentIdList}" var="attId">
                                     <img data-magnify="gallery" src="/attachment/download?attachId=${attId}" data-src="/attachment/download?attachId=${attId}" alt="提前结清">
                                    </c:forEach>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel panel-info contact-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">上传凭证</h3>
                        </div>
                        <div class="panel-body clearfix">
                            <div id="fileUploadContent" class="fileUploadContent">
                                <div class="upload-control clearfix">
                                    <div id="filePicker">选择图片</div>
                                    <button class="btn btn-success" id="uploadBtn">点击上传</button>
                                    <button class="btn btn-danger" id="clearBtn">清空列表</button>
                                </div>
                                <div id="fileList" class="uploader-list clearfix"></div>
                            </div>
                        </div>
                        <div>
                            <button type="button" class="btn btn-confirm" data-dismiss="modal" onclick="earlySettle()">已结清</button>
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
            </div>
        </div>
    </div>
</div>
<script src="static/plugins/webuploader/webuploader.nolog.js"></script>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script>

	laydate.render({
	  elem: '#rpAccRepayDate',
	  format: 'yyyy-MM-dd',
	  type: 'date'
	});
	laydate.render({
		  elem: '#mbAccRepayDate',
		  format: 'yyyy-MM-dd',
		  type: 'date'
		});
	laydate.render({
		  elem: '#cmbAccRepayDate',
		  format: 'yyyy-MM-dd',
		  type: 'date'
		});
	
	function alertModel(str) {
	    $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
	    $('#myModal').modal('show');
	}

	var scIds = [];
	function earlySettle(){
		/* if($("#rpAccPayPenalty").val() == ''){
			alertModel('请输入还款计划违约金!');
			return false;
		} */
	/* 	if($("#rpAccRepayDate").val() == ''){
			alertModel('请输入还款计划结清时间!');
			return false;
		} */
		var settleCertId = scIds.join(",");
		/* if(settleCertId == null || settleCertId == undefined){
			alertModel('请上传结清凭证!');
			return false;
		} */
		
		// 还款计划动态参数
		var repayPlanDynamicFee = "[";		
		$("input[name='repayPlanDynamicFee']").each(function(){
			var code = $(this).attr("id");
			var value = $(this).val();
			repayPlanDynamicFee += "{code:'" + code + "',value:'" + value + "'},";
		});
		repayPlanDynamicFee = repayPlanDynamicFee.substring(0, repayPlanDynamicFee.length-1);
		repayPlanDynamicFee += "]";
		
		// 小贷公司回款计划动态参数
		var moneyBackPlanDynamicFee = "[";
		$("input[name='moneyBackPlanDynamicFee']").each(function(){
			var code = $(this).attr("id");
			var value = $(this).val();
			moneyBackPlanDynamicFee += "{code:'" + code + "',value:'" + value + "'},";
		});
		moneyBackPlanDynamicFee = moneyBackPlanDynamicFee.substring(0, moneyBackPlanDynamicFee.length-1);
		moneyBackPlanDynamicFee += "]";
		
		// 资金渠道回款计划动态参数
		var captialMoneyBackPlanDynamicFee = "[";
		$("input[name='captialMoneyBackPlanDynamicFee']").each(function(){
			var code = $(this).attr("id");
			var value = $(this).val();
			captialMoneyBackPlanDynamicFee += "{code:'" + code + "',value:'" + value + "'},";
		});
		captialMoneyBackPlanDynamicFee = captialMoneyBackPlanDynamicFee.substring(0, captialMoneyBackPlanDynamicFee.length-1);
		captialMoneyBackPlanDynamicFee += "]";
		
		var param = {
			orderNo:'${orderNo}',
			rpAccPayPenalty:$("#rpAccPayPenalty").val(),
			rpAccRepayDate:$("#rpAccRepayDate").val(),
			repayPlanDynamicFee:repayPlanDynamicFee,
			mbAccPayPenalty:$("#mbAccPayPenalty").val(),
			mbAccRepayDate:$("#mbAccRepayDate").val(),
			moneyBackPlanDynamicFee:moneyBackPlanDynamicFee,
			cmbCoporateId:'${cmbCoporateId}',
			cmbAccPayPenalty:$("#cmbAccPayPenalty").val(),
			cmbAccRepayDate:$("#cmbAccRepayDate").val(),
			captialMoneyBackPlanDynamicFee:captialMoneyBackPlanDynamicFee,
			settleCert:settleCertId
		};
		$.ajax({
            url : '<%=basePath%>repayInfoMenu/earlySettle',
            data : {params:JSON.stringify(param)},
            method : 'POST',
            success : function (res) {
                if(res.returnCode==0){
                    $("#navTab").load("<%=basePath%>repayInfoMenu/getRepayInfo?orderNo=${orderNo}&orderId=${orderId}");
                }else{
                    alertModel(res.returnMsg);
                }
            },
            error : function (error) {
                alertModel(error);
            }
        })
	}
    function initImages() {
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
    }
	
    $(function () {
        initImages();
        uploader();
        function uploader() {
            // 初始化Web Uploader
            var uploader = WebUploader.create({
                // 选完文件后，是否自动上传。
                auto: false,
                // swf文件路径
                swf: '<%=basePath%>static/plugins/webuploader/Uploader.swf',
                // 文件接收服务端。
                server: '<%=basePath%>attachment/upload',
                // 选择文件的控件
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
                uploader.upload();
            })
            // 清空
            $('#clearBtn').on('click',function () {
                uploader.reset();
                $('#fileList').empty();
            })
            // 当有文件添加进来的时候
            uploader.on( 'fileQueued', function( file ) {
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
                    $( '#'+file.id ).addClass('upload-state-done');
                    $('#'+file.id).append('<div class="result"><i class="fa fa-check"></i></div>')
                    
                    scIds.push(response.result);
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
        }
    })

</script>