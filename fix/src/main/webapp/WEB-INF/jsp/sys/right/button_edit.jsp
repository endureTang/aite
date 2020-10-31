<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form class="form-horizontal" action="right/editBtn" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>修改权限</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<input type="hidden" name="buttonId" value="${pd.buttonId}" /> <label
					for="buttonName" class="col-sm-2 control-label">名称</label>
				<div class="col-sm-7">
					<input id="buttonName" name="buttonName" value="${pd.buttonName}"
						type="text" maxlength="32" minlength="2"
						class="form-control required" placeholder="请输入名称">
				</div>
			</div>
			<div class="form-group">
				<label for="buttonUrl" class="col-sm-2 control-label">路径</label>
				<div class="col-sm-7">
					<input id="buttonUrl" name="buttonUrl" value="${pd.buttonUrl}"
						type="text" maxlength="32" class="form-control required"
						placeholder="请输入路径">
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="right/editBtn">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$("#defForm").validate();
</script>