<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="stockBase/edit" method="post"
	  id="defForm" callfn="refreshTable" >
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				 style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>编辑</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="stockNo" class="col-sm-2 control-label">货号</label>
				<div class="col-sm-7">
					<input type="hidden" id = "id" name="id" value="${pd.id}">
					<input id="stockNo" name="stockNo" type="text" maxlength="32" value="${pd.stockNo}"
						   minlength="1" class="form-control required" placeholder="请输入货号">
				</div>
			</div>
			<div class="form-group">
				<label for="specification" class="col-sm-2 control-label">尺码</label>
				<div class="col-sm-7">
					<input id="specification" name="specification" type="text" maxlength="32" value="${pd.specification}"
						   minlength="1" class="form-control required" placeholder="请输入尺码">
				</div>
			</div>
			<div class="form-group">
				<label for="amount" class="col-sm-2 control-label">数量</label>
				<div class="col-sm-7">
					<input id="amount" name="amount" type="number" maxlength="32" value="${pd.amount}"
						   minlength="1" class="form-control" placeholder="请输入数量">
				</div>
			</div>
			<div class="form-group">
				<label for="channelPrice" class="col-sm-2 control-label">渠道价</label>
				<input type="hidden" id="transMoneyData" name="transMoneyStus" value="0">
				<div class="col-sm-7">
					<input id="channelPrice" name="channelPrice" type="number" maxlength="32" value="${pd.channelPrice}"
						   minlength="1" class="form-control" placeholder="请输入渠道价">
				</div>
			</div>
			<div class="form-group">
				<label for="remark" class="col-sm-2 control-label">备注</label>
				<div class="col-sm-7">
					<input id="remark" name="remark" type="number" maxlength="32" value="${pd.remark}"
						   minlength="1" class="form-control" placeholder="请输入备注">
				</div>
			</div>


		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="dict/eidt">
			<button type="submit" class="btn btn-primary btn-save">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
	$("#defForm").validate();
</script>