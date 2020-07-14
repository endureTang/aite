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
<form class="form-horizontal" action="coporate/copyRights" method="post"
      id="defForm" callfn="refreshTable">
    <input type="hidden" value="${coporateId}" name="sourceCoporateId">
    <div class="modal-header">
        <div class='bootstrap-dialog-header'>
            <div class='bootstrap-dialog-close-button' style='display: block;'>
                <button class='close' data-dismiss='modal' aria-label='Close'>×</button>
            </div>
            <div class='bootstrap-dialog-title'>角色复制</div>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid">

            <div class="form-group">
                <label for="targetCoporateId" class="col-sm-2 control-label copy-name">将 <span class="company-name">${companyName}</span> 的角色复制到</label>
                <div class="col-sm-7">
                    <select name="targetCoporateId" id="targetCoporateId" class="form-control">
                        <!--<option value="1" data-companyName="德阳金坤">德阳金坤</option>-->
                    </select>
                </div>
            </div>

        </div>
    </div>
    <div class="modal-footer">
        <p>一旦选择复制，<span class="company-name" id="targetCopName">德阳金坤</span>的原有角色和权限都将消失</p>
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <!--<shiro:hasPermission name="user/njAdd">-->
            <button type="submit" id="saveEdit" class="btn btn-primary btn-save">保存</button>
        <!--</shiro:hasPermission>-->
    </div>
</form>
<script type="text/javascript">

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
        // 获取公司列表
        $.ajax({
            url: '<%=basePath%>coporate/list',
            method: 'POST',
            success: function (res) {
                if (res.status == 0) {
                    var str = '';
                    $.each(res.data, function (k, v) {
                        str += '<option data-companyName="'+v.companName+'" value="' + v.id + '">' + v.companName + '</option>';
                    })
                    $('#targetCoporateId').html(str);

                    $('#targetCoporateId option').each(function (k, v) {
                        if($(this).attr('value') == $('#targetCoporateId').val()){
                            $('#targetCopName').html($(this).attr('data-companyName'));
                        }
                    })

                } else {
                    alert('企业列表获取失败');
                }
            },
            error: function (error) {
                alert(error);
            }
        })


        $('#targetCoporateId').change(function () {
            $('#targetCoporateId option').each(function (k, v) {
                if($(this).attr('value') == $('#targetCoporateId').val()){
                    $('#targetCopName').html($(this).attr('data-companyName'));
                }
            })
        })

    });
</script>