<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
<link rel="stylesheet" type="text/css" href="static/plugins/webuploader/webuploader.css">
<div class="container-fluid">
    <jsp:include page="./orderSteps.jsp"></jsp:include>
    <div class="tab-con">
        <div>
            <!-- Nav tabs -->
            <ul class="nav nav-tabs" role="tablist" id="myTabs">
                <li><a href="<%=basePath%>loanOrder/myOrderBaseInfoPage?orderId=<%=orderId%>" aria-controls="one" role="tab" data-toggle="tab" data-target="navTab">基础信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderCreditInfoPage?orderId=<%=orderId%>" aria-controls="two" role="tab" data-toggle="tab"  data-target="navTab">信用信息</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderInvestigatePage?orderId=<%=orderId%>" aria-controls="three" role="tab" data-toggle="tab"  data-target="navTab">业务调查</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderBusinessApprovePage?orderId=<%=orderId%>" aria-controls="fore" role="tab" data-toggle="tab"  data-target="navTab">业务审批</a></li>
                <li class="active"><a href="<%=basePath%>loanOrder/myOrderContractsPage?orderId=<%=orderId%>" aria-controls="five" role="tab" data-toggle="tab"  data-target="navTab">合同管理</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderLoanApprovePage?orderId=<%=orderId%>" aria-controls="six" role="tab" data-toggle="tab"  data-target="navTab">放款审批</a></li>
                <li><a href="<%=basePath%>loanOrder/myOrderOperateLogPage?orderId=<%=orderId%>" aria-controls="seven" role="tab" data-toggle="tab"  data-target="navTab">操作日志</a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <div class="tab-pane active" id="five">
                    <!--合同管理-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">合同模板</h3>
                        </div>
                        <div class="panel-body compact clearfix">
                            <form>
                                <ul class="base-info">
                                <c:forEach items="${contractTempList}" var="temp">
                                    <li>
                                        <i class="desc-name">${temp.typeName}: </i>
                                        <s>${temp.templateName}</s>
                                            <span>
                                                <a href="<%=basePath%>loanOrder/downloadContractTemp?tempId=${temp.id}&orderId=<%=orderId%>">下载</a>
                                            </span>
                                    </li>
                                </c:forEach>
                                </ul>
                            </form>
                        </div>
                    </div>
                    <!--合同制作-->
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <h3 class="panel-title">合同制作</h3>
                        </div>
                        <div class="panel-body compact clearfix">
                            <div id="upLoadCompact" style="margin-bottom: 25px;">
                                <select id="tempType" class="form-control" style="margin-right: 30px;width: 180px;">
                                   <c:forEach items="${contractTempList}" var="temp">
	                                   <option value="${temp.id}">${temp.typeName}</option>
                                	</c:forEach>
                                </select>
                                <p type="button" id="picker" class="btn btn-new btn-print" style="margin-right: 25px;">选择文件</p>
                                <c:if test="${(fn:contains(roleType, 'businessCommissioner') && orderStatus == 7)  || (fn:contains(roleType, 'legalAffairs') && orderStatus == 8) }">
                                    <p type="button" id="ctlBtn" class="btn btn-new btn-submit" onclick="upload()">上传</p>
                                </c:if>
                                <div class="description">
                                    <p>温馨提示:</p>
                                    <p>1、一抵客户所需合同：《授信合同》、《个人借款合同》、《最高额抵押合同》</p>
                                    <p>2、二抵客户所需合同：《个人借款合同》、《抵押合同》</p>
                                    <p>如各小贷公司办理最高额抵押登记时，当地房管部门或不动产中心未要求必须提供授信合同，可以不签署授信合同。所签订的合同必须办理强制执行公证。</p>
                                </div>
                                <div id="thelist" class="uploader-list hide"></div>
                            </div>
                            <form>
                                <ul class="base-info" id="contractList">
                                	<c:forEach items="${contractList}" var="contract">
	                                	<li>
	                                		<i class='desc-name'>${contract.typeNmae}</i>
	                                		<s>${contract.contractName}</s>
	                                		<span><a href="<%=basePath%>loanOrder/downloadOrderContract?contractId=${contract.id}">下载</a></span>
	                                		<c:if test="${fn:contains(roleType, 'businessCommissioner') && orderStatus == 7}">
	                                			<span><a class="del-contract" href="javascript:;" data-id="${contract.id}">删除</a></span>
	                                		</c:if>
	                                	</li>
                                	</c:forEach>
                                </ul>
                            </form>
                        </div>
                    </div>
                    <div class="control">
                        <div style="padding-left: 20px;">
                            <c:if test="${fn:contains(roleType, 'legalAffairs')}">
                            <textarea placeholder="请输入不超过50字审批意见" maxlength="50" rows="4" style="resize: none;width: 350px;border-color: #d2d6de;padding: 10px;margin-top: -20px" id="legalCondition">${remarkExtend}</textarea>
                            </c:if>
                            <c:if test="${fn:contains(roleType, 'businessCommissioner') && orderStatus == 7}">
                                <button class="btn btn-submit btn-new" id="auditPass">提交审核</button>
                            </c:if>

                            <c:if test="${fn:contains(roleType, 'legalAffairs') && orderStatus == 8}">
                                <button class="btn btn-submit btn-new" id="legalAuditPass">通过</button>
                                <button class="btn btn-reject btn-new" id="legalAuditReject">驳回</button>
                            </c:if>
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
    <!--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="mySuccessModal" data-backdrop="static" data-keyboard="false">
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
<script src="static/plugins/vue/vue.min.js"></script>
<script src="<%=basePath%>static/js/jquery-migrate-1.2.1.min.js"></script>
<script src="<%=basePath%>static/js/jquery.jqprint-0.3.js"></script>
<script src="static/plugins/magnify/jquery.magnify.min.js"></script>
<script src="<%=basePath%>static/js/myOrderCommon.js"></script>
<script type="text/javascript" src="<%=basePath%>static/plugins/webuploader/webuploader.js"></script>

<script type="text/javascript">
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
    
    var uploader = WebUploader.create({
    	
	    // swf文件路径
	    swf: '<%=basePath%>static/plugins/webuploader/js/Uploader.swf',
	    // 文件接收服务端。
	    server: '<%=basePath%>/loanOrder/uploadOrderContract',
	    // 选择文件的按钮。可选。
	    pick: '#picker',
	    resize: false,
        duplicate : false,
        accept : {
            extensions : 'doc,docx'
        }

	});
    
    uploader.on( 'fileQueued', function( file ) {
        var $content = $('<div id="' + file.id + '" class="item">' +
            '<h4 class="info"><i class="remove-this">删除</i>' + file.name + '</h4>' +
            '</div>');
        $('#thelist').removeClass('hide').append($content);
        // 点击删除
        $content.on('click', '.remove-this', function() {
            uploader.removeFile( file,true );
            $( '#'+file.id ).remove();
        })
    });
    uploader.on('fileDequeued',function (file) {
        if(uploader.getFiles().length == uploader.getStats().cancelNum) {
            $('#thelist').addClass('hide');
        }
    })
    
    // uploader.on( 'uploadSuccess', function( file ) {
    //     uploader.reset();
    // 	loadContractList();
    // });

    uploader.on( 'uploadSuccess', function( file ) {
        uploader.removeFile( file,true );
        $( '#'+file.id ).remove();
        // loadContractList();
    });
    uploader.on( 'uploadComplete', function( file ) {
        // uploader.reset();
        loadContractList();
    });

    function loadContractList(){
	    $.ajax({
	        url : util.getServerUrl('/loanOrder/getContractByOrderId'),
	        method : 'POST',
	        data : {orderId:'<%=orderId%>'},
	        success : function (res) {
	            if (res.returnCode == 0){
	            	var contractList = res.result;
	            	var str = '';
	            	for (var int = 0; int < contractList.length; int++) {
	            	    str += "<li><i class='desc-name'> "+contractList[int].typeNmae+"</i><s>"+contractList[int].contractName+"</s><span><a href='<%=basePath%>loanOrder/downloadOrderContract?contractId="+contractList[int].id+"'>下载</a></span><span><a class='del-contract' href='javascript:;' data-id='"+contractList[int].id+"'>删除</a></span></li>"
					}
                    $("#contractList").html(str);
	            }else{
	                myOrderTpl.alertModel(res.returnMsg);
	            }
	        },
	        error : function (error) {
	            myOrderTpl.alertModel(error);
	        }
	    })
	}
	
	function upload(){
		  uploader.option('formData',{
			  orderId :'<%=orderId%>',
			  contractTemplateId:$("#tempType").val()
          })
          console.log(uploader.formData);
		uploader.upload();
	}
</script>
<script>
    var contractsApprove = {
        init : function () {
            this.bindEvent();
        },
        bindEvent : function () {
            var _this = this;
            //合同制作通过
            this.examize($('#auditPass'),1,22);
            //法务审核通过
            this.examize($('#legalAuditPass'),1,23);
            //法务审核拒绝
            this.examize($('#legalAuditReject'),2,22);
            // 删除合同
            $('#contractList').on('click','a.del-contract',function () {
                _this.delContract($(this).attr('data-id'))
            })
            
        },
        // 审核 通过拒绝审核
        examize : function(btn,resultValue,processId){
        	  btn.click(function(){
          	  $.ajax({
                    url : util.getServerUrl('/loanOrder/examineOrder'),
                    method : 'POST',
                    data : {orderId : '<%=orderId%>',resultValue:resultValue,processId:processId,remarkExtend:JSON.stringify({legalCondition : $('#legalCondition').val()}),rejectProcessId:22},
                    success : function (res) {
                        if (res.status == '0'){
                            myOrderTpl.alertSuccessModel(res.msg,function () {
                                $('#navTab').load('<%=basePath%>loanOrder/myLoanOrderList');
                            });
                        }else{
                            myOrderTpl.alertModel(res.msg);
                        }
                    },
                    error : function (error) {
                        myOrderTpl.alertModel(error);
                    }
                })
            })
        },
        // 删除合同
        delContract : function (id) {
            $.ajax({
                url : util.getServerUrl('/loanOrder/deleteOrderContract?contractId=' + id),
                method : 'GET',
                success : function (res) {
                    if (res.returnCode == '0'){
                        myOrderTpl.alertSuccessModel(res.returnMsg,function () {
                            $('#navTab').load('<%=basePath%>loanOrder/myOrderContractsPage?orderId=<%=orderId%>');
                        });
                    }else{
                        myOrderTpl.alertModel(res.returnMsg);
                    }
                },
                error : function (error) {
                    myOrderTpl.alertModel(error);
                }
            })
        }
    }
    $(function () {
    	contractsApprove.init();
    })
</script>