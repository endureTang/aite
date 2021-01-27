<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="user/add" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>新增用户</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">用户名</label>
				<div class="col-sm-7">
					<input id="name" name="name" type="text" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="enName" class="col-sm-2 control-label">英文名</label>
				<div class="col-sm-7">
					<input id="" name="enName" type="text" maxlength="32"
						class="form-control required" placeholder="请输入英文名">
				</div>
			</div>
			<div class="form-group">
				<label for="empNo" class="col-sm-2 control-label">员工号</label>
				<div class="col-sm-7">
					<input id="empNo" name="empNo" type="text" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入员工号">
				</div>
			</div>

			<div class="form-group">
				<label for="compId" class="col-sm-2 control-label">所属公司</label>
				<div class="col-sm-7">
					<div class="input-group input-group-sm input-adjust">
						<select id="compId" name="compId" class="form-control">
						<option value="">请选择公司</option>
						<option value="1">1</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="departId" class="col-sm-2 control-label">所属部门</label>
				<div class="col-sm-7">
					<div class="input-group input-group-sm input-adjust">
						<select id="departId" name="departId" class="form-control">
						<option value="">请选择部门</option>
						<option value="1">1</option>
						</select>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="team" class="col-sm-2 control-label">所属团队</label>
				<div class="col-sm-7">
					<input id="team" name="team" type="text" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入团队">
				</div>
			</div>
			
			<div class="form-group">
				<label for="joinDate" class="col-sm-2 control-label">入职时间</label>
				<div class="col-sm-7">
					<div class="input-group input-group-sm input-adjust">
						<div class="input-group-addon">
							<label for="joinDate"><i class="fa fa-calendar"></i></label>
						</div>
						<input id="joinDate" readonly name="joinDate" type="text" class="form-control" placeholder="请输入入职时间" />
					</div>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="onDuty" class="col-sm-2 control-label">是否在职</label>
				<div class="col-sm-7">
						<div class="checkbox">
					      <label>
					      <input  id="onDuty" name="onDuty" checked type="checkbox">
					      </label>
					   </div>
				</div>
			</div>
			
			<div class="form-group">
				<label for="leaveDate" class="col-sm-2 control-label">离职时间</label>
				<div class="col-sm-7">
					<div class="input-group input-group-sm input-adjust">
						<div class="input-group-addon">
							<label for="leaveDate"><i class="fa fa-calendar"></i></label>
						</div>
						<input id="leaveDate" readonly name="leaveDate" type="text" class="form-control" placeholder="请输入离职时间" />
					</div>
				</div>
			</div>
			
			
			<div class="form-group">
				<label for="position" class="col-sm-2 control-label">职位</label>
				<div class="col-sm-7">
					<input id="position" name="position" type="text" maxlength="32"
						class="form-control required" placeholder="请输入职位">
				</div>
			</div>
			
			<div class="form-group">
				<label for="job" class="col-sm-2 control-label">工种</label>
				<div class="col-sm-7">
					<input id="job" name="job" type="text" maxlength="32"
						class="form-control required" placeholder="请输入工种">
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
				<label for="email" class="col-sm-2 control-label">邮箱</label>
				<div class="col-sm-7">
					<input id="email" name="email" type="text" maxlength="32"
						class="form-control required" placeholder="请输入邮箱">
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
				<label for="description" class="col-sm-2 control-label">描述</label>
				<div class="col-sm-7">
					<textarea id="description" name="description" class="form-control"
						rows="3"></textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="user/add">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
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
	rules: {
		loginName: {
            required: true,
            remote: {
                type: "post",
                url: "user/checkName",
                dataType: "json",
                dataFilter: function(data, type) {
                    if (data == 1){
                    	return false;
                    }else{
                    	return true;
                    }  
                }
            }
    	}
    },
    messages: {
    	loginName: {
            required: "请输入用户名",
            remote: "用户名重复"
        }
    }
});
</script>