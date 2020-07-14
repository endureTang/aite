<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.nj.core.base.enums.ERoleType"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<link rel="stylesheet" href="<%=basePath%>static/css/order/order_list.css">
<div class="container-fluid">
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix h30"></div>

                <div class="panel panel-default channel-edit">
                    <div class="panel-heading">
                        <h3 class="panel-title">新增账户</h3>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>
                                <i class="con-name">用户姓名:</i>
                                <input type="text" class="form-control" id="userName">
                            </li>
                            <li>
                                <i class="con-name">角色分配:</i>
                                <div id="roleAllot" class="roleAllot"></div>
                            </li>
                            <li id="leaderLine" style="display:none">
                                <i class="con-name">主管分配:</i>
                                <select id="leaderSelect" class="form-control acct-add">
                                </select>
                            </li>
                            <li id="products" style="display:none">
                                <i class="con-name">产品:</i>
                                <div style="display:inline-block;">
	                                <c:forEach items="${products}" var="product" varStatus="status">
		                               	<input type="checkbox" name="product" value="${product.id}"/>${product.productName}&nbsp;&nbsp;
		                               	<c:if test="${(status.index+1) % 10 == 0}">
		                               		</br>
		                               	</c:if>
	                                </c:forEach>
                                </div>
                            </li>
                            <li id="channels" style="display:none">
                                <i class="con-name">渠道:</i>
                                <div style="display:inline-block;">
	                                <c:forEach items="${channelList}" var="channel" varStatus="status">
		                               	<input type="checkbox" name="channel" value="${channel.id}"/>${channel.name}&nbsp;&nbsp;
		                               	<c:if test="${(status.index+1) % 10 == 0}">
		                               		</br>
		                               	</c:if>
	                                </c:forEach>
                                </div>
                            </li>
                             <li>
                                <i class="con-name">登录账号:</i>
                                <input type="text" maxlength="11" class="form-control" id="mobile" placeholder="请输入不超过11个字符" >
                            </li>
                            <li>
                                <i class="con-name">登录密码:</i>
                                <input type="password" maxlength="20" class="form-control" id="password" placeholder="请输入不超过20个字符" >
                            </li>
                            <li>
                                <i class="con-name">备注:</i>
                                <input type="text" maxlength="100" class="form-control" id="reamrks" placeholder="请输入不超过100个字符" >&nbsp;&nbsp;选填
                            </li>
                            <li>
                                <i class="con-name">状态:</i>
                               	<input type="radio" name="state" value="0" checked="checked">启用&nbsp;&nbsp;
                               	<input type="radio" name="state" value="1">冻结
                            </li>
                        </ul>
                        <button class="btn btn-primary" id="saveAcct">保存</button>
                        <button class="btn btn-primary" id="return">返回</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
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

<script type="text/javascript">
	var isShowProducts = false;
	var isShowChannels = false;

	function roleChange(obj){
		var roleType = $(obj).val().split("-")[1];
		if($(obj).is(":checked")){
			if(roleType == '<%=ERoleType.CUSTOMERMANAGER.getValue()%>'){
				$("#leaderLine").show();
				$.ajax({
			        url: '<%=basePath%>acctManage/getBusinessManagerByCoporateId',
			        method: 'POST',
			        success: function (res) {
			            if (res.status == 0) {
			            	var data = res.data;
			            	for(var i=0;data.length;i++){
			            		$("#leaderSelect").append("<option value='"+data[i].id+"'>"+data[i].userName+"</option>");
			            	}
			            } 
			        },
			    })
			}
			if(roleType == '<%=ERoleType.AGENT.getValue()%>'){
				isShowChannels = true;
			}
		}else{
			if(roleType == '<%=ERoleType.CUSTOMERMANAGER.getValue()%>'){
				$("#leaderLine").hide();
				$("#leaderSelect").empty();
			}
			if(roleType == '<%=ERoleType.AGENT.getValue()%>'){
				isShowChannels = false;
			}
		}
		
		var roleChecked = $("#roleAllot input[name='role']:checked");
		if(roleChecked.length == 0){
			isShowProducts = false;
		}else{
			roleChecked.each(function(){
				var roleType2 = $(this).val().split("-")[1];
				if(roleType2 == '<%=ERoleType.CUSTOMERMANAGER.getValue()%>'
					|| roleType2 == '<%=ERoleType.BUSINESSMANAGER.getValue()%>'
					|| roleType2 == '<%=ERoleType.RISKCONTROLMANAGER.getValue()%>'
					|| roleType2 == '<%=ERoleType.RISKCONTROLCOMMISSIONER.getValue()%>'
					|| roleType2 == '<%=ERoleType.LEGALAFFAIRS.getValue()%>'
					|| roleType2 == '<%=ERoleType.LENDINGPERSON.getValue()%>'
					|| roleType2 == '<%=ERoleType.FINANCEPERSON.getValue()%>'){
					isShowProducts = true;
					return false;;
				}else{
					isShowProducts = false;
				}
			});
		}
		if(isShowProducts){
			$("#products").show();
		}else{
			$("#products").hide();
		}
		if(isShowChannels){
			$("#channels").show();
		}else{
			$("#channels").hide();
		}
	}
	
    var acct = {
        init: function () {
        	this.initRole();
            this.bindEvent();
        },
        // 初始化页面控件数据
        initRole:function(){
        	$.ajax({
                url: '<%=basePath%>acctManage/getRoleByCoporateId',
                method: 'POST',
                success: function (res) {
                    if (res.status == '0') {
                    	var data = res.data;
                    	for(var i=0;data.length;i++){
	                    	$("#roleAllot").append("<input type='checkBox' name='role' onClick='roleChange(this)' value='"+data[i].id+"-"+data[i].roleType+"'>"+data[i].name+"</input>&nbsp;&nbsp;");
                    	}
                    } 
                },
            })
        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击保存
            $('#saveAcct').click(function () {
                _this.saveAcct();
            });
            $('#return').click(function () {
                $("#navTab").load("<%=basePath%>acctManage/acctListPage");
            });
        },
        // 保存账号
        saveAcct: function () {
            var _this = this;
            var products = "";
            if(isShowProducts){			//选择产品后，去掉需选择产品的角色，再保存，若没有此代码，还是会保存产品。	
            	products = $("input[name='product']:checked").map(function(index,elem) { 
		               		return $(elem).val(); 
		           		}).get().join(',');
            };
            var channels = "";
            if(isShowChannels){
            	channels = $("input[name='channel']:checked").map(function(index,elem) { 
		               		return $(elem).val(); 
		           		}).get().join(',');
            }
            var params = {
                userName: $.trim($('#userName').val()),
                role: $("input:checkbox[name='role']:checked").map(function(index,elem) { 
                    		return $(elem).val(); 
                		}).get().join(','),
                products:products,
                channels:channels,
                leaderSelect: $.trim($('#leaderSelect').val()),
                mobile: $.trim($('#mobile').val()),
                password: $.trim($('#password').val()),
                reamrks: $.trim($('#reamrks').val()),
                state: $.trim($('input[name="state"]:checked').val())
            };
            if (params.userName == '') {
                _this.alertModel('请输入用户姓名!');
                return;
            }
            if (params.role == '') {
                _this.alertModel('请选择角色!');
                return;
            }
            var roleType = params.role.split("-")[1];
            if(roleType == '<%=ERoleType.CUSTOMERMANAGER.getValue()%>'){
	            if (params.leaderSelect == '') {
	                _this.alertModel('请选择主管!');
	                return;
	            }
            }
            if (params.mobile == '') {
                _this.alertModel('请输入登陆账号!');
                return;
            }
            if (params.password == '') {
                _this.alertModel('请输入登陆密码!');
                return;
            }
            $.ajax({
                url: '<%=basePath%>acctManage/add',
                data: params,
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        _this.alertModel('保存成功!');
                        setTimeout(function () {
                            $('#myModal').modal('hide');
                        }, 1000);
                        $('#myModal').on('hidden.bs.modal', function (e) {
                            $('#navTab').load('<%=basePath%>acctManage/acctListPage');
                        })
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('保存失败，请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('保存失败，请稍后重试!');
                }
            })
        },
        // 模态框弹出
        alertModel: function (str) {
            $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#myModal').modal('show');
        },
    };
    
    $(document).ready(function () {
    	acct.init();
    	$("input[type='text']").val('');
    })

</script>
