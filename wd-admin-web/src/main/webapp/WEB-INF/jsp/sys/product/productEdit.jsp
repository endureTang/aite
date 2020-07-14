<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

<form class="form-horizontal" action="product/edit" method="post" id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>修改产品</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<input type="hidden" name="id" value="${product.id}" /> 
				<label for="remarks" class="col-sm-2 control-label">产品名称</label>
				<div class="col-sm-7">
					<input id="productName" name="productName" value="${product.productName}"
						type="text" readonly="readonly" disabled="disabled"
						class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="remarks" class="col-sm-2 control-label">产品编码</label>
				<div class="col-sm-7">
					<input id="openProductId" name="openProductId" value="${product.openProductId}"
						type="text" maxlength="32"
						class="form-control required" placeholder="请输入产品编码">
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="product/edit">
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>

<script type="text/javascript">
	$("#defForm").validate();
</script>