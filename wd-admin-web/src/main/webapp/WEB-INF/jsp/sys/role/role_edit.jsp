<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form class="form-horizontal" action="role/edit" method="post" id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button' style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>修改角色</div>
		</div>
	</div>
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<input type="hidden" name="roleId" value="${role.id}" /> 
				<label for="roleName" class="col-sm-2 control-label">角色名称</label>
				<div class="col-sm-7">
					<input id="roleName" name="roleName" value="${role.name}"
						type="text" maxlength="32" minlength="2"
						class="form-control required" placeholder="请输入角色名称">
				</div>
			</div>
            <div class="form-group">
                <label for="roleType" class="col-sm-2 control-label">角色类型</label>
                <div class="col-sm-7">
					<select name="roleType" id="roleType" class="form-control required">
						<c:forEach var="roles" items="${roleList}">
							<option <c:if test="${roles.roleValue == role.roleType}">selected</c:if> value="${roles.roleValue}">${roles.roleName}</option>
						</c:forEach>
					</select>

                </div>
            </div>
			<div class="form-group">
				<label for="type" class="col-sm-2 control-label">类型</label>
				<div class="col-sm-7">
					<select name="type" id="type" class="form-control">
						<option <c:if test="${role.type == 1}">selected</c:if> value="1">管理后台</option>
						<option <c:if test="${role.type == 2}">selected</c:if> value="2">业务后台</option>
					</select>
				</div>
			</div>
			<div class="form-group" id="companyName">
				<label for="coporate" class="col-sm-2 control-label">企业名称</label>
				<div class="col-sm-7">
					<select name="coporateId" id="coporate" class="form-control">
                        <option value="" selected>-请选择企业名称-</option>
                        <c:forEach items="${coporateList}" var ="li" varStatus="coporateStatus">
                            <option value="${li.id}" <c:if test="${li.id == role.officeId}" >selected</c:if>>${li.companName}</option>
                        </c:forEach>
                    </select>
				</div>
			</div>
			<div class="form-group">
				<label for="remarks" class="col-sm-2 control-label">描述</label>
				<div class="col-sm-7">
					<textarea id="remarks" name="remarks" class="form-control"
						rows="3">${role.remarks}</textarea>
				</div>
			</div>
		</div>
	</div>
	<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
		<shiro:hasPermission name="role/edit">
			<button type="submit" class="btn btn-primary btn-save">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
    $(function () {
        judgeHasDom();
        $('#type').change(function () {
            judgeHasDom();
        })

        $("#defForm").validate();

        function renderSelect(data) {
            var str = '<option value="">-请选择企业名称-</option>';
            $.each(data, function (k, v) {
                str += '<option value="' + v.id + '">' + v.companName + '</option>';
            })
            $('#coporate').html(str);
        }

        function judgeHasDom() {
            if($('#type').val() == 1){
                $('#companyName').addClass('hide-dom')
            }else{
                $('#companyName').removeClass('hide-dom')
            }
        }
    })
</script>