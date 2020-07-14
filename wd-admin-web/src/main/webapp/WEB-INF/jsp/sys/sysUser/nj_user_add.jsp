<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<form class="form-horizontal" action="sysUser/add" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>新增用户</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="loginName" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-7">
					<input id="loginName" name="loginName" type="text" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入用户名">
				</div>
			</div>

			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">登录密码</label>
				<div class="col-sm-7">
					<input id="password" name="password" type="password" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">姓名</label>
				<div class="col-sm-7">
					<input id="name" name="name" type="text" maxlength="32"
						class="form-control required" placeholder="请输入姓名">
				</div>
			</div>
			<div class="form-group">
				<label for="phone" class="col-sm-2 control-label">电话</label>
				<div class="col-sm-7">
					<input id="phone" name="phone" type="text" maxlength="32"
						class="form-control required" placeholder="请输入电话">
				</div>
			</div>

			<div class="form-group">
				<label for="role" class="col-sm-2 control-label">角色</label>
				<input name="roleList" id="roleList" type="hidden"/>
				<div class="col-sm-7 enterprise" id="roleItem">
					<c:forEach var="role" items="${roleList }">
						<label ><input name="roleItem" class="item" id="${role.id }" type="checkbox" value="${role.id }">${role.name }</label>&nbsp;
					</c:forEach>
					<!-- <label for="assignment"><input id="assignment" name="assignment" type="checkbox" value="1">系统管理员</label>&nbsp; 
					<label for="busiAudit"><input id="busiAudit" name="busiAudit" type="checkbox" value="2">业务审批</label>&nbsp;
					<label><input id="approvalSupervisor" name="approvalSupervisor" type="checkbox" value="10">审批主管</label>&nbsp;
					<label for="riskAudit"><input id="riskAudit" name="riskAudit" type="checkbox" value="3">审批专员</label>&nbsp;
					<label for="cAdmin"><input id="cAdmin" name="cAdmin" type="checkbox" value="4">企业管理员</label>&nbsp;
					<label for="businessReception"><input id="businessReception" name="businessReception" type="checkbox" value="5">业务接待</label>&nbsp;
					<label for="backgroundManager"><input id="backgroundManager" name="backgroundManager" type="checkbox" value="6">贷后管理</label>&nbsp;
					<label for="businessExecutive"><input id="businessExecutive" name="businessExecutive" type="checkbox" value="7">业务主管</label>&nbsp;
					<label for="loanOfficer"><input id="loanOfficer" name="loanOfficer" type="checkbox" value="8">放款专员</label>&nbsp; -->
					
				</div>
			</div>
			<div class="form-group">
				<label for="remarks" class="col-sm-2 control-label">描述</label>
				<div class="col-sm-7">
					<textarea id="remarks" name="remarks" class="form-control"
						rows="4"></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="user/njAdd">
			<button type="button" id="saveEdit" class="btn btn-primary btn-save">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
	$('input[name="roleItem"]').iCheck({
        checkboxClass : 'icheckbox_minimal-blue my-check',
        increaseArea : '' // optional
    });

	$("#joinDate").datetimepicker({
		format : 'yyyy-mm-dd',
		language : 'zh',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 0,
		forceParse : 0,
		showMeridian : 0
	});
	$("#leaveDate").datetimepicker({
		format : 'yyyy-mm-dd',
		language : 'zh',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		minView : 0,
		forceParse : 0,
		showMeridian : 0
	});
	$('#defForm').validate({
		rules : {
			loginName : {
				required : true,
				remote : {
					type : "post",
					url : "user/checkName",
					dataType : "json",
					dataFilter : function(data, type) {
						if (data == 1) {
							return false;
						} else {
							return true;
						}
					}
				}
			}
		},
		messages : {
			loginName : {
				required : "请输入用户名",
				remote : "用户名重复"
			}
		}
	});
	
	$(function() {
        $('#saveEdit').click(function () {
            var roleIds = "";
            $("#roleItem label input").each(function () {
                if (this.checked) {
                    roleIds += $(this).attr('value') + ",";
                }
            })
            $("#roleList").val(roleIds);

            $('#defForm').submit();
        })

		// $("#productItem").children().children(".item").click(function(){
		// 	var productIds = "";
		// 	$("#productItem label input").each(function(){
		// 		if(this.checked){
		// 			productIds += $(this).attr('value')+",";
		// 		}
		// 	})
		// 	$("#productList").val(productIds);
		// });
		//
		// $("#roleItem").children().children(".item").click(function(){
		// 	var roleIds = "";
		// 	$("#roleItem label input").each(function(){
		// 		if(this.checked){
		// 			roleIds += $(this).attr('value')+",";
		// 		}
		// 	})
		// 	$("#roleList").val(roleIds);
		// });
    }); 
</script>