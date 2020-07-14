<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form class="form-horizontal" action="role/add" method="post"
      id="defForm" callfn="refreshTable">
    <div class="modal-header">
        <div class='bootstrap-dialog-header'>
            <div class='bootstrap-dialog-close-button'
                 style='display: block;'>
                <button class='close' data-dismiss='modal' aria-label='Close'>×</button>
            </div>
            <div class='bootstrap-dialog-title'>新增角色</div>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid">
            <div class="form-group">
                <label for="roleName" class="col-sm-2 control-label">角色名称</label>
                <div class="col-sm-7">
                    <input id="roleName" name="roleName" type="text" maxlength="32"
                           minlength="2" class="form-control required" placeholder="请输入角色名称">
                </div>
            </div>
            <div class="form-group">
                <label for="roleType" class="col-sm-2 control-label">角色类型</label>
                <div class="col-sm-7">
                    <select name="roleType" id="roleType" class="form-control required">
                        <c:forEach var="roles" items="${roleList}">
                            <option value="${roles.roleValue}">${roles.roleName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="type" class="col-sm-2 control-label">类型</label>
                <div class="col-sm-7">
                    <select name="type" id="type" class="form-control">
                        <option value="1">管理后台</option>
                        <option value="2">业务后台</option>
                    </select>
                </div>
            </div>
            <div class="form-group" id="companyName">
                <label for="coporate" class="col-sm-2 control-label">企业名称</label>
                <div class="col-sm-7">
                    <select name="coporateId" id="coporate" class="form-control"></select>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-2 control-label">描述</label>
                <div class="col-sm-7">
					<textarea id="description" name="description" class="form-control"
                              rows="3"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <shiro:hasPermission name="role/add">
            <button type="submit" class="btn btn-primary btn-save">保存</button>
        </shiro:hasPermission>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: '<%=basePath%>coporate/list',
            method: 'POST',
            success: function (res) {
                if (res.status == 0) {
                    renderSelect(res.data);
                    judgeHasDom();

                } else {
                    alert('企业列表获取失败');
                }
            },
            error: function (error) {
                alert(error);
            }
        })
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