<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" enctype="multipart/form-data" action="processTemplate/editConfig" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>配置流程跳转属性</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid" style="margin-top: 30px">
			<c:choose>
				<c:when test="${list != null}">
					<c:forEach items="${list}" var="obj">
						<c:if test="${obj.tag == 'sequenceFlow'}">
							<div class="form-group">
								<div style="width: 200px; float: left; line-height: 28px;">
									<c:forEach items="${list}" var="ob">
										<c:if test="${ob.id == obj.sourceRef}">
											<span style="width: 60px;display: inline-block;">${ob.name}</span>
										</c:if>
									</c:forEach>
									--- > <span style="color: red">${obj.name}</span> --- >
									<c:forEach items="${list}" var="ob">
										<c:if test="${ob.id == obj.targetRef}">${ob.name}</c:if>
									</c:forEach>
								</div>
								
								<input type="hidden" name="ids" value="${pid},${obj.id},${obj.sourceRef},${obj.targetRef}"/>
								&nbsp;&nbsp;&nbsp;&nbsp;跳转页面URL:  
								<input class="input-txt" style="height: 28px; padding: 0 5px; width: 273px" type="text" maxlength="120" placeholder="不跳转不填写" id="termInfo" name="urls" value="${obj.url}"/>
							</div>
						</c:if>
					</c:forEach>
				</c:when>
				<c:otherwise>
					没有需要配置的信息。
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="processTemplate/editConfig">
			<input type="hidden" name="pid" value="${pid}"/>
			<button type="submit" class="btn btn-primary">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
$("#defForm").validate();
</script>