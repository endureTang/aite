<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="strategy/edit" method="post"
	  id="defForm" callfn="refreshTable" onsubmit="return checkBoxData()">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				 style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>新增</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">策略名</label>
				<div class="col-sm-7">
					<input type="hidden" id = "id" name="id" value="${pd.id}">
					<input id="name" name="name" type="text" maxlength="32" value="${pd.name}"
						   minlength="1" class="form-control required" placeholder="请输策略名">
				</div>
			</div>
			<div class="form-group">
				<label for="source" class="col-sm-2 control-label">订单来源</label>
				<div class="col-sm-7">
					<input id="source" name="source" type="text" maxlength="32" value="${pd.source}"
						   minlength="1" class="form-control required" placeholder="请输入订单来源">
				</div>
			</div>
			<div class="form-group">
				<label for="sourceNo" class="col-sm-2 control-label">原始订单号</label>
				<label>启用<input type="checkbox" id="sourceNoStatus" name="sourceNoStatus" value=""  <c:if test="${pd.sourceNoStus == 1}">checked</c:if> ></label>
				<input type="hidden" id="sourceNoData" name="sourceNoStus" value="0">
				<div class="col-sm-7">
					<input id="sourceNo" name="sourceNo" type="text" maxlength="32" value="${pd.sourceNo}"
						   minlength="1" class="form-control" placeholder="请输入匹配值">
				</div>
			</div>
			<div class="form-group">
				<label for="transWay" class="col-sm-2 control-label">物流方式</label>
				<label>启用<input type="checkbox" id="transWayStatus" name="transWayStatus" value="" <c:if test="${pd.transWayStus == 1}">checked</c:if>></label>
				<input type="hidden" id="transWayData" name="transWayStus" value="0">
				<div class="col-sm-7">
					<input id="transWay" name="transWay" type="text" maxlength="32" value="${pd.transWay}"
						   minlength="1" class="form-control" placeholder="请输入匹配值">
				</div>
			</div>
			<div class="form-group">
				<label for="transNo" class="col-sm-2 control-label">物流单号</label>
				<label>启用<input type="checkbox" id="transNoStatus" name="transNoStatus" value="" <c:if test="${pd.transNoStus == 1}">checked</c:if>></label>
				<input type="hidden" id="transNoData" name="transNoStus" value="0">
				<div class="col-sm-7">
					<input id="transNo" name="transNo" type="text" maxlength="32" value="${pd.transNo}"
						   minlength="1" class="form-control" placeholder="请输入匹配值">
				</div>
			</div>
			<div class="form-group">
				<label for="transMoney" class="col-sm-2 control-label">运费</label>
				<label>启用<input type="checkbox" id="transMoneyStatus" name="transMoneyStatus" value="" <c:if test="${pd.transMoneyStus == 1}">checked</c:if>></label>
				<input type="hidden" id="transMoneyData" name="transMoneyStus" value="0">
				<div class="col-sm-7">
					<input id="transMoney" name="transMoney" type="text" maxlength="32" value="${pd.transMoney}"
						   minlength="1" class="form-control" placeholder="请输入匹配值">
				</div>
			</div>
			<div class="form-group">
				<label for="amount" class="col-sm-2 control-label">数量</label>
				<label>启用<input type="checkbox" id="amountStatus" name="amountStatus" value="" <c:if test="${pd.amountStus == 1}">checked</c:if>></label>
				<input type="hidden" id="amountData" name="amountStus" value="0">
				<div class="col-sm-7">
					<input id="amount" name="amount" type="text" maxlength="32" value="${pd.amount}"
						   minlength="1" class="form-control" placeholder="请输入匹配值">
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
	function checkBoxData() {
		var sourceNoStatus = $('#sourceNoStatus').is(':checked');
		var transWayStatus = $("#transWayStatus").is(':checked');
		var transNoStatus = $("#transNoStatus").is(':checked');
		var transMoneyStatus = $("#transMoneyStatus").is(':checked');
		var amountStatus = $("#amountStatus").is(':checked');
		if(sourceNoStatus){
			$("#sourceNoData").val(1);
		}
		if(transWayStatus){
			$("#transWayData").val(1);
		}
		if(transNoStatus){
			$("#transNoData").val(1);
		}
		if(transMoneyStatus){
			$("#transMoneyData").val(1);
		}
		if(amountStatus){
			$("#amountData").val(1);
		}
	}
</script>