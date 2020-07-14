<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" enctype="multipart/form-data" action="processTemplate/edit" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>修改流程模板</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<input type="hidden" name="id" value="${temp.id}" /> <label
					for="roleName" class="col-sm-2 control-label">流程名称</label>
				<div class="col-sm-7">
					<input id="processName" name="processName" value="${temp.processName}"
						type="text" maxlength="32" minlength="2"
						class="form-control required" placeholder="请输入流程名称">
				</div>
			</div>
			<div class="form-group">
				<label for="removable" class="col-sm-2 control-label">bpmn文件</label>
				<div class="col-sm-7">
					<input type="file" name="file"/> 
				</div>
			</div>
			<div class="form-group">
				<label for="removable" class="col-sm-2 control-label">图片文件</label>
				<div class="col-sm-7">
					<input type="file" name="file1"/> 
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="role/edit">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$("#defForm").validate();
</script>