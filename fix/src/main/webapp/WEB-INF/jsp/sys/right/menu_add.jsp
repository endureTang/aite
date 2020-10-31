<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<form class="form-horizontal" action="right/addMenu" method="post"
	id="defForm" callfn="refreshTable">
	<div class="modal-header">
		<div class='bootstrap-dialog-header'>
			<div class='bootstrap-dialog-close-button'
				style='display: block;'>
				<button class='close' data-dismiss='modal' aria-label='Close'>×</button>
			</div>
			<div class='bootstrap-dialog-title'>新增${menuType == 1 ? '菜单' : '子菜单'}</div>
		</div>
	</div>
	<div class="modal-body menu">
		<div class="container-fluid">
			<div class="form-group">
				<label for="menuName" class="col-sm-2 control-label">名称</label>
				<div class="col-sm-7">
					<input id="menuName" name="menuName" type="text" maxlength="32"
						minlength="2" class="form-control required" placeholder="请输入名称">
				</div>
			</div>
			<div class="form-group" id="sysType">
				<label class="col-sm-2 control-label">系统类型</label>
				<div class="col-sm-7">
					<label for="backMenuRadio"><input id="backMenuRadio" name="isShow" type="radio" value="1" checked onclick="checkMenuType()">后台系统菜单</label>
					<label for="bussiMenuRadio"><input id="bussiMenuRadio" name="isShow" type="radio" value="2" onclick="checkMenuType()">业务系统菜单</label>
					<label for="bussiResRadio"><input id="bussiResRadio" name="isShow" type="radio" value="" onclick="hideMenuType()">业务系统资源</label>
				</div>
			</div>
			<div class="form-group" id="menuType">
				<label class="col-sm-2 control-label">菜单类型</label>
				<div class="col-sm-7">
					<label for="parentMenuRadio"><input id="parentMenuRadio"  name="menuType" type="radio" value="1" onclick="hideParentMenu()" checked>顶级菜单</label>
					<label for="childMenuRadio"><input id="childMenuRadio"  name="menuType" type="radio" value="2" onclick="getPMenuList()">子菜单</label>
					<div id="parentMenuDiv">
						<span>请选择父菜单：</span>
						<span><select name="parentId" id="parentId"><option value="0">--</option></select></span>										
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="menuUrl" class="col-sm-2 control-label">路径</label>
				<div class="col-sm-7">
					<input id="menuUrl" name="menuUrl" type="text" maxlength="32"
							class="form-control required" placeholder="请输入路径">
<%-- 					<c:choose>
						<c:when test="${menuType == 1}">
							<input id="menuUrl" name="menuUrl" type="text" maxlength="32"
								class="form-control" value="#" readonly="readonly">
						</c:when>
						<c:otherwise>
							<input id="menuUrl" name="menuUrl" type="text" maxlength="32"
								class="form-control required" placeholder="请输入路径">
						</c:otherwise>
					</c:choose> --%>
				</div>
			</div>
			<div class="form-group">
				<label for="menuOrder" class="col-sm-2 control-label">排序</label>
				<div class="col-sm-7">
					<input id="menuOrder" name="menuOrder" type="text" maxlength="32"
						class="form-control required" placeholder="请输入数值">
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
		<shiro:hasPermission name="right/addMenu">
			<button type="submit" class="btn btn-primary btn-save">保存</button>
		</shiro:hasPermission>
	</div>
</form>
<script type="text/javascript">
	var sysType = $('input[name="isShow"]'),
        menuType = $('input[name="menuType"]');
//     sysType.iCheck({
//         radioClass : 'iradio_minimal-blue'
//     });
//     menuType.iCheck({
//         radioClass : 'iradio_minimal-blue'
//     });
//
// $('#backMenuRadio').on('ifClicked',checkMenuType);
// $('#bussiMenuRadio').on('ifClicked',checkMenuType);
// $('#bussiResRadio').on('ifClicked',hideMenuType);
//
// $('#parentMenuRadio').on('ifClicked',hideParentMenu);
// $('#childMenuRadio').on('ifClicked',getPMenuList);




$("#defForm").validate();

hideParentMenu();

function getPMenuList(){
	showParentMenu();
	$.ajax({
		url : "right/parentMenu",
		data : {
            isShow: $('#sysType input:radio:checked').val(),
        },
		dataType : 'json',
		type: 'POST',
		success : function(data) {
			var options = '';
			var others = '';
			for (var i = 0; i < data.length; i++) {
	            var item = data[i];
	            others += "<option value=" + item.id + ">" + item.name + "</option>";
	        }
			others += '</select></div>';
			$("#parentId").html("");
			$("#parentId").html(others);
		}
	});
}

function checkMenuType(){
	$('#menuType').show();
	var menuType = $('#menuType input:radio:checked').val();
	if(menuType == 2){
		getPMenuList();
	}
}

function hideParentMenu(){
	$('#parentMenuDiv').hide();
	$('#menuUrl').attr("readonly","readonly");
	$('#menuUrl').val("#");
}

function showParentMenu(){
	$('#menuType').show();
	$('#parentMenuDiv').show();
	$('#menuUrl').removeAttr("readonly");
	$('#menuUrl').val("");
}

function hideMenuType(){
	$('#menuType').hide();
	$('#menuUrl').removeAttr("readonly");
	$('#menuUrl').val("");
}

</script>