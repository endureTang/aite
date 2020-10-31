<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="dict/edit" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>修改</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<input type="hidden" name="id" value="${pd.id}" />
			<div class="form-group">
				<label for="type" class="col-sm-2 control-label">代码</label>
				<div class="col-sm-7">
					<input id="type" name="type" type="text" maxlength="32"
						value="${pd.type}"
						readonly="readonly"
						minlength="1" class="form-control" placeholder="请输入代码">
				</div>
			</div>
			<div class="form-group">
				<label for="labelText" class="col-sm-2 control-label">名称</label>
				<div class="col-sm-7">
					<input id="labelText" name="labelText" type="text" maxlength="32"
						value="${pd.labelText}"
						minlength="1" class="form-control required" placeholder="请输入名称">
				</div>
			</div>
			<div class="form-group">
				<label for="value" class="col-sm-2 control-label">值</label>
				<div class="col-sm-7">
					<input id="value" name="value" type="text" maxlength="32"
						value="${pd.value}"
						readonly="readonly"
						minlength="1" class="form-control" placeholder="请输入值">
				</div>
			</div>
			<div class="form-group">
				<label for="sort" class="col-sm-2 control-label">排序</label>
				<div class="col-sm-7">
					<input id="sort" name="sort" type="text" maxlength="32"
						value="${pd.sort}"
						minlength="1" class="form-control required" placeholder="请输入排序">
				</div>
			</div>
			<div class="form-group">
				<label for="description" class="col-sm-2 control-label">描述</label>
				<div class="col-sm-7">
					<textarea id="description" name="description" class="form-control"
						rows="3">${pd.description}</textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="dict/edit">
			<button type="submit" class="btn btn-primary btn-save">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$("#defForm").validate();
</script>