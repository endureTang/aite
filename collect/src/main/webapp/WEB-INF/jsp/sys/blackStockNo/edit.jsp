<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="blackStockNo/modify" method="post"
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
				<label for="stockNo" class="col-sm-3 control-label">货号</label>
				<div class="col-sm-7">
					<input type="hidden" id = "id" name="id" value="${pd.id}">
					<input id="stockNo" name="stockNo" type="text" maxlength="32" value="${pd.stockNo}"
						   minlength="1" class="form-control required" placeholder="请输入货号">
				</div>
			</div>
			<div class="form-group">
				<label for="sizeRange" class="col-sm-3 control-label">过滤尺码范围</label>
				<div class="col-sm-7">
					<input id="sizeRange" name="sizeRange" type="text" maxlength="32" value="${pd.sizeRange}"
						   minlength="1" class="form-control required" placeholder="请输入过滤尺码范围"> 全部过滤：ALL。部分过滤：请以英文逗号分隔。
				</div>
			</div>

		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<button type="submit" class="btn btn-primary btn-save">保存</button>
	</div>
</form>
<script type="text/javascript">
	$("#defForm").validate();
</script>