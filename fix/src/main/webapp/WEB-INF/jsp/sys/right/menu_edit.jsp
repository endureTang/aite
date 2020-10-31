<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="right/editMenu" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>修改菜单</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<input type="hidden" name="id" value="${pd.id}" />
				<label
					for="name" class="col-sm-2 control-label">名称</label>
				<div class="col-sm-7">
					<input id="name" name="name" value="${pd.name}"
						type="text" maxlength="32" minlength="2"
						class="form-control required" placeholder="请输入名称">
				</div>
			</div>
			<div class="form-group">
				<label for="href" class="col-sm-2 control-label">路径</label>
				<div class="col-sm-7">


							<input id="href" name="href" value="${pd.href}"
								type="text" maxlength="32" class="form-control required"
								<c:if test="${pd.parentId == 0 && (pd.isShow == 1 || pd.isShow == 2)}">readonly="readonly"</c:if>
								placeholder="请输入路径">

				</div>
			</div>
			<div class="form-group">
				<label for="sort" class="col-sm-2 control-label">排序</label>
				<div class="col-sm-7">
					<input id="sort" name="sort" value="${pd.sort}"
						type="text" maxlength="32" class="form-control required"
						<c:if test="${pd.isShow != 1 && pd.isShow != 2}">readonly="readonly"</c:if>
						placeholder="请输入数值">
				</div>
			</div>
			<div class="form-group">
				<label for="remarks" class="col-sm-2 control-label">描述</label>
				<div class="col-sm-7">
					<textarea id="remarks" name="remarks" class="form-control"
						rows="3">${pd.remarks}</textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="right/editMenu">
			<button type="submit" class="btn btn-primary btn-save">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$("#defForm").validate();
</script>