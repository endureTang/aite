<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<form class="form-horizontal" action="user/njAdd" method="post"
      id="defForm" callfn="refreshTable">
    <div class="modal-header">
        <div class='bootstrap-dialog-header'>
            <div class='bootstrap-dialog-close-button' style='display: block;'>
                <button class='close' data-dismiss='modal' aria-label='Close'>×</button>
            </div>
            <div class='bootstrap-dialog-title'>新增用户</div>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-7">
                    <input id="name" name="name" type="text" maxlength="32"
                           minlength="2" class="form-control required" placeholder="请输入用户名">
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">登录密码</label>
                <div class="col-sm-7">
                    <input id="password" name="password" type="password" maxlength="32"
                           minlength="2" class="form-control required" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-7">
                    <input id="email" name="email" type="text" maxlength="32"
                           class="form-control required" placeholder="请输入邮箱">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">电话</label>
                <div class="col-sm-7">
                    <input id="phone" name="phone" type="text" maxlength="32"
                           class="form-control required" placeholder="请输入电话">
                </div>
            </div>
            <div class="form-group">
                <label for="coporate" class="col-sm-2 control-label">企业名称</label>
                <div class="col-sm-7">
                    <select name="coporateId" id="coporate" class="form-control">

                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="role" class="col-sm-2 control-label">角色</label>
                <input name="roleList" id="roleList" type="hidden"/>
                <div class="col-sm-7" id="roleItem">
                    <c:forEach var="role" items="${roleList }">
                        <label><input name="roleItem" class="item" id="${role.id }" type="checkbox" value="${role.id }">${role.name
                            }</label>&nbsp;
                    </c:forEach>
                </div>
            </div>
            <div class="form-group">
                <label for="remarks" class="col-sm-2 control-label">描述</label>
                <div class="col-sm-7">
					<textarea id="remarks" name="remarks" class="form-control"
                              rows="4"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">产品</label>
                <input name="productList" id="productList" type="hidden"/>
                <div class="col-sm-7" id="productItem">
                    <label class="total-check" for="totalCheck"><input type="checkbox" name="productItem"
                                                                       id="totalCheck">全选</label>
                    <c:forEach var="product" items="${productList }">
                        <label><input name="productItem" class="item" id="${product.id }" type="checkbox"
                                      value="${product.id }">
                            <c:choose>
                                <c:when test="${product.productName ==null || product.productName ==''}">
                                    未命名
                                </c:when>
                                <c:otherwise>
                                    ${product.productName }
                                </c:otherwise>
                            </c:choose>
                        </label>&nbsp;
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <shiro:hasPermission name="user/njAdd">
            <button type="button" id="saveEdit" class="btn btn-primary btn-save">保存</button>
        </shiro:hasPermission>
    </div>
</form>
<script type="text/javascript">
    renderCheckbox();

    function renderCheckbox() {
        var productItems = $('input[name="productItem"]');
        $('input[name="roleItem"]').iCheck({
            checkboxClass: 'icheckbox_minimal-blue my-check',
            increaseArea: '' // optional
        });
        productItems.iCheck({
            checkboxClass: 'icheckbox_minimal-blue my-check',
            increaseArea: '' // optional
        });
        // 产品全选
        $('#totalCheck').on('ifChanged', function () {
            if ($(this).is(':checked')) {
                productItems.iCheck("check");
            } else {
                productItems.iCheck("uncheck");
            }
        });
    }


    $("#joinDate").datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 0,
        forceParse: 0,
        showMeridian: 0
    });
    $("#leaveDate").datetimepicker({
        format: 'yyyy-mm-dd',
        language: 'zh',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 0,
        forceParse: 0,
        showMeridian: 0
    });
    $('#defForm').validate({
        rules: {
            loginName: {
                required: true,
                remote: {
                    type: "post",
                    url: "user/checkName",
                    dataType: "json",
                    dataFilter: function (data, type) {
                        if (data == 1) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
            }
        },
        messages: {
            loginName: {
                required: "请输入用户名",
                remote: "用户名重复"
            }
        }
    });

    $(function () {
        $('#saveEdit').click(function () {
            var roleIds = "", productIds = "";
            ;
            $("#roleItem label input").each(function () {
                if (this.checked) {
                    roleIds += $(this).attr('value') + ",";
                }
            })
            $("#roleList").val(roleIds);

            $("#productItem label input").each(function () {
                if (this.checked) {
                    productIds += $(this).attr('value') + ",";
                }
            })
            $("#productList").val(productIds);

            $('#defForm').submit();
        })

        // $("#productItem").children().children(".item").click(function(){
        // 	var productIds = "";
        // 	$("#productItem label input").each(function(){
        // 		if(this.checked){
        // 			productIds += $(this).attr('value')+",";
        // 		}
        // 	})
        // 	$("#productList").val(productIds);
        // });
        //
        // $("#roleItem").children().children(".item").click(function(){
        // 	var roleIds = "";
        // 	$("#roleItem label input").each(function(){
        // 		if(this.checked){
        // 			roleIds += $(this).attr('value')+",";
        // 		}
        // 	})
        // 	$("#roleList").val(roleIds);
        // });
        // 获取公司列表
        $.ajax({
            url: '<%=basePath%>coporate/list',
            method: 'POST',
            success: function (res) {
                if (res.status == 0) {
                    var str = '<option value="">-请选择企业名称-</option>';
                    $.each(res.data, function (k, v) {
                        str += '<option value="' + v.id + '">' + v.companName + '</option>';
                    })
                    $('#coporate').html(str);
                    changeCompany();
                } else {
                    alert('企业列表获取失败');
                }
            },
            error: function (error) {
                alert(error);
            }
        })

        function changeCompany() {
            $('#coporate').change(function () {
                $.ajax({
                    url: '<%=basePath%>user/getRolesAndProducts?coporateId=' + $(this).val(),
                    method: 'POST',
                    success: function (res) {
                        renderRole(res.roleList);
                        renderProduct(res.productList);
                    }
                })
            })
        }

        function renderRole(data) {
            var str = '';
            $.each(data,function (k, v) {
                str += '<label><input name="roleItem" class="item" id="' + v.id + '" type="checkbox" value="' + v.id + '">' + v.name + '</label>&nbsp;';
            })
            $('#roleItem').html(str)
            renderCheckbox();
        }

        function renderProduct(data) {
            var str = '<label class="total-check" for="totalCheck"><input type="checkbox" name="productItem" id="totalCheck">全选</label>';
            $.each(data, function (k, v) {
                str += '<label><input name="productItem" class="item" id="' + v.id + '" type="checkbox" value="' + v.id + '">' + v.productName + '</label>';
            })
            $('#productItem').html(str)
            renderCheckbox();
        }


    });
</script>