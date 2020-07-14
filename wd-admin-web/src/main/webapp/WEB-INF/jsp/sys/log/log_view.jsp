<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="role/add" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>查看日志</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="userName" class="col-sm-2 control-label">用户</label>
				<div class="col-sm-7">
					<input id="roleName" name="userName" type="text" maxlength="32"
						minlength="2" class="form-control" value="${log.userName}" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="operateFunction" class="col-sm-2 control-label">功能</label>
				<div class="col-sm-7">
					<input id="operateFunction" name="operateFunction" type="text" maxlength="32"
						minlength="2" class="form-control" value="${log.operateFunction}" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="operateContent" class="col-sm-2 control-label">内容</label>
				<div class="col-sm-7">
					<textarea id="operateContent" name="operateContent" class="form-control" readonly="readonly"
						rows="3">${log.operateContent}</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="createTime" class="col-sm-2 control-label">日期</label>
				<div class="col-sm-7">
					<input id="createTime" name="createTime" type="text" maxlength="32"
						minlength="2" class="form-control" value="${log.createTime}" readonly="readonly">
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="submit" class="btn btn-primary btn-save" data-dismiss="modal">确定</button>
	</div>
</form>