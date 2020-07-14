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
                        <h3 class="panel-title">编辑账户</h3>
                    </div>
                    <div class="panel-body">
                        <ul>
                            <li>
                                <i class="con-name">用户姓名:</i>
                                <input type="text" class="form-control" id="userName">
                            </li>
                            <li>
                                <i class="con-name">角色分配:</i>
                                <div id="roleAllot" class="roleAllot">
                                	<c:forEach items="${roleData}" var="role">
	                                	<input type='checkBox' name='role' onClick='roleChange(this)' value='${role.id}-${role.roleType}'>${role.name}</input>
                                	</c:forEach>
                                </div>
                            </li>
                            <li id="leaderLine" style="display:none">
                                <i class="con-name" >主管分配:</i>
                                <select id="leaderSelect" class="form-control acct-edit">
                                	<option value=''></option>
                                	<c:forEach items="${bmData}" var="bm">
                                		<option value='${bm.id}' >${bm.userName}</option>
                                	</c:forEach>
                                </select>
                            </li>
                            <li id="products" style="display:none">
                                <i class="con-name">产品:</i>
                                <div  style="display:inline-block;">
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
                                <input type="text" maxlength="11" class="form-control" id="mobile" placeholder="请输入不超过11个字符">
                            </li>
                            <li>
                                <i class="con-name">登录密码:</i>
                                <input type="hidden" id="oldpassword">
                                <input type="password" maxlength="20" class="form-control" id="password" placeholder="请输入不超过20个字符">
                            </li>
                            <li>
                                <i class="con-name">备注:</i>
                                <input type="text" maxlength="100" class="form-control" id="reamrks" placeholder="请输入不超过100个字符">&nbsp;&nbsp;选填
                            </li>
                            <li>
                                <i class="con-name">状态:</i>
                               	<input type="radio" name="state" value="0">启用&nbsp;&nbsp;
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
	var parentId = "";
	var roleIds = "";
	var productIds = "";
	var channelIds = "";
	
    var acct = {
        init: function () {
            this.bindEvent();
        	this.initUserData();
         	this.initRoleData();
         	this.initLeaderData();
         	this.initProductData();
         	this.initChannelData();
        },
        initUserData:function(){
        	$.ajax({
                url: '<%=basePath%>acctManage/toEditPage',
                method: 'POST',
                async : false,
                data:'userId=${userId}',
                success: function (res) {
                    if (res.status == 0) {
                    	var data = res.data;
                    	$("#userName").val(data.userName);
                    	$("#mobile").val(data.userMobile);
                    	$("#password").val(data.password);
                    	$("#oldpassword").val(data.password);
                    	$("#reamrks").val(data.remarks);
                    	parentId = data.parentId;
                    	roleIds = data.roleIds;
                    	productIds = data.productIds;
                    	channelIds = data.channelIds;
						$("input:radio[name='state']").each(function(){
							if(this.value == data.state){
								$(this).attr("checked","checked");
							}
						});
                    } 
                },
            })
        },
        //设置选中的角色，若选中角色中有客户经理，则显示业务主管的下拉框
        initRoleData:function(){
        	$("input[name='role']").each(function(){
        		if(-1 != roleIds.indexOf($(this).val().split("-")[0])){
        			$(this).attr("checked","checked");
	        		if('<%=ERoleType.CUSTOMERMANAGER.getValue()%>' == $(this).val().split("-")[1]){
	        			$("#leaderLine").css("display","inline");
	        		}
        		}
        	});
        },
        //设置选中的业务主管
        initLeaderData:function(){
        	$("#leaderSelect option").each(function(){
        		if(parentId == $(this).val()){
        			$(this).attr("selected","selected");
        		};
        	});
        },
        //设置产品显示还是隐藏
        initProductData:function(){
      		updateIsShowProducts();
  			if(isShowProducts){
  				$("#products").show();
  			}else{
  				$("#products").hide();
  			}
       		if(productIds != ''){
       			$("input[name='product']").each(function(){
	        		if(-1 != productIds.indexOf($(this).val())){
	        			$(this).attr("checked","checked");
	        		}
       			})
       		}
        },
        initChannelData:function(){
       		updateisShowChannels();
   			if(isShowChannels){
   				$("#channels").show();
   			}else{
   				$("#channels").hide();
   			}
        	if(channelIds != ''){
       			$("input[name='channel']").each(function(){
	        		if(-1 != channelIds.indexOf($(this).val())){
	        			$(this).attr("checked","checked");
	        		}
       			})
       		}
        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击保存
            $('#saveAcct').click(function () {
                _this.saveAcct();
            })
            $('#return').click(function () {
            	$("#navTab").load("<%=basePath%>acctManage/acctListPage");
            });
        },
        // 保存渠道编辑
        saveAcct: function () {
            var _this = this;
            var products = "";
            if(isShowProducts){		//选择产品后，去掉需选择产品的角色，再保存，若没有此代码，还是会保存产品。
            	products = $("input[name='product']:checked").map(function(index,elem) { 
		               		return $(elem).val(); 
		           		}).get().join(',');
            };  
            var channels = "";
            if(isShowChannels){			
            	channels = $("input[name='channel']:checked").map(function(index,elem) { 
		               		return $(elem).val(); 
		           		}).get().join(',');
            };
            var params = {
            	userId:'${userId}',
                userName: $.trim($('#userName').val()),
                role: $("input:checkbox[name='role']:checked").map(function(index,elem) { 
		            		return $(elem).val(); 
		        		}).get().join(','),
		        products:products,
		        channels:channels,
                leaderSelect: $.trim($('#leaderSelect').val()),
                mobile: $.trim($('#mobile').val()),
                password: $.trim($('#password').val()),
                oldpassword:$.trim($('#oldpassword').val()),
                reamrks: $.trim($('#reamrks').val()),
                state: $.trim($('input[name="state"]:checked').val())
            };
            if (params.userName == '') {
                _this.alertModel('请输入用户姓名!');
                return;
            }
            if (params.password == '') {
                _this.alertModel('请输入密码!');
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
            $.ajax({
                url: '<%=basePath%>acctManage/edit',
                data: params,
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        _this.alertModel('保存成功!');
                        setTimeout(function () {
                            $('#myModal').modal('hide');
                        }, 1000)
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
    }
    $(document).ready(function () {
    	acct.init();
    })
    
    //角色选中客户经理时，重新加载业务主管。若取消客户经理时，隐藏并清空业务主管
	function roleChange(obj){
		if($(obj).is(":checked")){
			if($(obj).val().split("-")[1] == '<%=ERoleType.CUSTOMERMANAGER.getValue()%>'){
				$("#leaderLine").css("display","inline");
				$("#leaderSelect").empty();
				$.ajax({
			        url: '<%=basePath%>acctManage/getBusinessManagerByCoporateId',
			        method: 'POST',
			        success: function (res) {
			            if (res.status == 0) {
			            	var data = res.data;
			            	$("#leaderSelect").append("<option value=''></option>");
			            	for(var i=0;data.length;i++){
			            		$("#leaderSelect").append("<option value='"+data[i].id+"'>"+data[i].userName+"</option>");
			            	}
			            } 
			        },
			    })
			}
			if($(obj).val().split("-")[1] == '<%=ERoleType.AGENT.getValue()%>'){
				$("#channels").show();
			}
		}else{
			if($(obj).val().split("-")[1] == '<%=ERoleType.CUSTOMERMANAGER.getValue()%>'){
				$("#leaderLine").css("display","none");
				$("#leaderSelect").empty();
			}
			if($(obj).val().split("-")[1] == '<%=ERoleType.AGENT.getValue()%>'){
				$("#channels").hide();
			}
		}
		
		updateIsShowProducts();
		if(isShowProducts){
			$("#products").show();
		}else{
			$("#products").hide();
		}
	}
    
    //更新isShowProducts的值
    function updateIsShowProducts(){
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
    }
    
  //更新isShowProducts的值
    function updateisShowChannels(){
    	var roleChecked = $("#roleAllot input[name='role']:checked");
		if(roleChecked.length == 0){
			isShowChannels = false;
		}else{
			roleChecked.each(function(){
				var roleType2 = $(this).val().split("-")[1];
				if(roleType2 == '<%=ERoleType.AGENT.getValue()%>'){
					isShowChannels = true;
					return false;
				}else{
					isShowChannels = false;
				}
			});
		}
    }

</script>
