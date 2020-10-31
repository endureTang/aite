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
<input id="hassignment" name="hassignment" type="hidden"
       value="${pd.assignment}">
<input id="hbusiAudit" name="hbusiAudit" type="hidden"
       value="${pd.busiaudit}">
<input id="hriskAudit" name="hriskAudit" type="hidden"
       value="${pd.riskaudit}">
<input id="hcAdmin" name="hcAdmin" type="hidden" value="${pd.cadmin}">
<input id="hbusinessReception" name="hbusinessReception" type="hidden"
       value="${pd.businessReception}">
<input id="hbackgroundManager" name="hbackgroundManager" type="hidden"
       value="${pd.backgroundManager}">
<input id="hbusinessExecutive" name="hbusinessExecutive" type="hidden"
       value="${pd.businessExecutive}">
<input id="hloanOfficer" name="hloanOfficer" type="hidden"
       value="${pd.loanofficer}">

<form class="form-horizontal" action="user/njEdit" method="post"
      id="defForm" callfn="refreshTable">
    <div class="modal-header">
        <div class='bootstrap-dialog-header'>
            <div class='bootstrap-dialog-close-button' style='display: block;'>
                <button class='close' data-dismiss='modal' aria-label='Close'>×</button>
            </div>
            <div class='bootstrap-dialog-title'>编辑用户</div>
        </div>
    </div>

    <input id="userId" name="userId" type="hidden" value="${pd.userId}">

    <div class="modal-body">
        <div class="container-fluid">
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">用户名</label>
                <div class="col-sm-7">
                    <input id="name" name="name" type="text" maxlength="32"
                           minlength="2" class="form-control required" value="${pd.userName}">
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">登录密码</label>
                <div class="col-sm-7">
                    <input id="password" name="password" type="password" maxlength="64"
                           minlength="2" class="form-control required" value="${pd.password}">
                </div>
            </div>
            <div class="form-group">
                <label for="email" class="col-sm-2 control-label">邮箱</label>
                <div class="col-sm-7">
                    <input id="email" name="email" type="text" maxlength="32"
                           class="form-control required" value="${pd.email}">
                </div>
            </div>
            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">电话</label>
                <div class="col-sm-7">
                    <input id="phone" name="phone" type="text" maxlength="32"
                           class="form-control required" value="${pd.mobile}">
                </div>
            </div>
            <div class="form-group">
                <label for="coporate" class="col-sm-2 control-label">企业名称</label>
                <div class="col-sm-7">
                    <select name="coporateId" id="coporate" class="form-control">
                        <c:forEach items="${coporateList}" var ="li" varStatus="coporateStatus">
                            <option value="${li.id}" <c:if test="${li.id == coporateId}" >selected</c:if>>${li.companName}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="form-group">
                <label for="role" class="col-sm-2 control-label">角色</label>
                <input name="roleList" id="roleList" type="hidden"/>
                <div class="col-sm-7" id="roleItem">
                    <c:forEach var="role" items="${pd.roleList }">
                        <label>
                            <input name="roleItem" class="item" id="${role.id }" type="checkbox" value="${role.id }"
                            <c:forEach var="hasRole" items="${pd.hasRoleList}">
                                <c:if test="${role.id == hasRole.id }">
                                    checked="checked"
                                </c:if>
                            </c:forEach>
                            >
                            ${role.name }
                        </label>&nbsp;
                    </c:forEach>
                    <!-- <label for="assignment"><input id="assignment"
                        name="assignment" type="checkbox" value="1">系统管理员</label>&nbsp; <label
                        for="busiAudit"><input id="busiAudit" name="busiAudit"
                        type="checkbox" value="2">业务审批</label>&nbsp; <label
                        for="riskAudit"><input id="riskAudit" name="riskAudit"
                        type="checkbox" value="3">风控审批</label>&nbsp; <label for="cAdmin"><input
                        id="cAdmin" name="cAdmin" type="checkbox" value="4">企业管理员</label>&nbsp;
                    <label for="businessReception"><input
                        id="businessReception" name="businessReception" type="checkbox"
                        value="5">业务接待</label>&nbsp; <label for="backgroundManager"><input
                        id="backgroundManager" name="backgroundManager" type="checkbox"
                        value="6">贷后管理</label>&nbsp; <label for="businessExecutive"><input
                        id="businessExecutive" name="businessExecutive" type="checkbox"
                        value="7">业务主管</label>&nbsp; <label for="loanOfficer"><input
                        id="loanOfficer" name="loanOfficer" type="checkbox" value="8">放款专员</label>&nbsp; -->
                </div>
            </div>
            <div class="form-group">
                <label for="remarks" class="col-sm-2 control-label">描述</label>
                <div class="col-sm-7">
                    <textarea id="remarks" name="remarks" class="form-control" rows="4">${pd.remarks}</textarea>
                </div>
            </div>

            <div class="form-group">
                <label for="phone" class="col-sm-2 control-label">产品</label>
                <input name="productList" id="productList" type="hidden"/>
                <div class="col-sm-7" id="productItem">
                    <label class="total-check" for="totalCheck"><input type="checkbox" name="productItem"
                                                                       id="totalCheck">全选</label>
                    <c:forEach var="product" items="${pd.productList }">
                        <label>
                            <input name="productItem" class="item" id="${product.id }" type="checkbox"
                                   value="${product.id }"
                            <c:forEach var="hasProduct" items="${pd.hasProductList}">
                                <c:if test="${product.id == hasProduct.productId }">
                                    checked="checked"
                                </c:if>
                            </c:forEach>
                            >

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
        <shiro:hasPermission name="user/njEdit">
            <button id="saveEdit" type="button" class="btn btn-primary btn-save">保存</button>
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
</script>
<script>
    $(function () {
        var assignmentV = $("#hassignment").val();
        if (assignmentV == '1') {
            $("#assignment").attr("checked", "checked");
        }

        var busiAuditV = $("#hbusiAudit").val();
        if (busiAuditV == '1') {
            $("#busiAudit").attr("checked", "checked");
        }

        var riskAuditV = $("#hriskAudit").val();
        if (riskAuditV == '1') {
            $("#riskAudit").attr("checked", "checked");
        }

        var cAdminV = $("#hcAdmin").val();
        if (cAdminV == '1') {
            $("#cAdmin").attr("checked", "checked");
        }

        var businessReceptionV = $("#hbusinessReception").val();
        if (businessReceptionV == '1') {
            $("#businessReception").attr("checked", "checked");
        }

        var backgroundManagerV = $("#hbackgroundManager").val();
        if (backgroundManagerV == '1') {
            $("#backgroundManager").attr("checked", "checked");
        }

        var businessExecutiveV = $("#hbusinessExecutive").val();
        if (businessExecutiveV == '1') {
            $("#businessExecutive").attr("checked", "checked");
        }

        var loanOfficerV = $("#hloanOfficer").val();
        if (loanOfficerV == '1') {
            $("#loanOfficer").attr("checked", "checked");
        }
    });


    $(function () {

        $('#saveEdit').click(function () {
            var roleIds = "",productIds = "";;
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


        // $("#roleItem").children().children(".item").click(function(){
        // var productIds = "";
        // $("#roleItem label input").each(function(){
        // 	if(this.checked){
        // 		productIds += $(this).attr('value')+",";
        // 	}
        // })
        //
        // $("#roleList").val(productIds);
        // });
        changeCompany();
        function changeCompany() {
            $('#coporate').change(function () {
                $.ajax({
                    url: '<%=basePath%>user/getRolesAndProducts?userId=${userId}&coporateId=' + $(this).val(),
                    method: 'POST',
                    success: function (res) {
                        renderRole(res.roleList);
                        renderProduct(res.productList);

                        $('input[name="productItem"]').each(function (k, v) {
                            $.each(res.hasProductList,function (key, val) {
                                if($(v).val()==val.id){
                                    $(v).attr('checked',true);
                                }
                            })
                        })
                        $('input[name="roleItem"]').each(function (k, v) {
                            $.each(res.hasRoleList,function (key, val) {
                                if($(v).val()==val.id){
                                    $(v).attr('checked',true);
                                }
                            })
                        })

                        renderCheckbox();
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

        }

        function renderProduct(data) {
            var str = '<label class="total-check" for="totalCheck"><input type="checkbox" name="productItem" id="totalCheck">全选</label>';
            $.each(data, function (k, v) {
                str += '<label><input name="productItem" class="item" id="' + v.id + '" type="checkbox" value="' + v.id + '">' + v.productName + '</label>';
            })
            $('#productItem').html(str)
        }
    });
</script>