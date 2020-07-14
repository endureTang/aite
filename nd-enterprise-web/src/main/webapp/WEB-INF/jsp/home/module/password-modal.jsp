<%@ page language="java"  import="java.util.Map" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="static/css/module/modify-passwd.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Main Header -->
<%
   Map user = (Map)session.getAttribute("userCoporate");
%>
<!--模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="passwdModal" data-backdrop="static" data-keyboard="false">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
                <h4 class="modal-title">修改密码</h4>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
						aria-hidden="true">&times;</span></button>
			</div>
			<div class="modal-body text-center">

                <ul>
                    <li>
                        <label for="originPasswd" class="col-sm-2 control-label">原登录密码:</label>
                        <div class="col-sm-7">
                            <input id="originPasswd" name="originPasswd" type="password" maxlength="32"
                                   minlength="2" class="form-control required" placeholder="请输入原登录密码">
                            <span class="badge">*</span>
                            <i class="toggle-passWd"></i>
                        </div>

                    </li>
                    <li>
                        <label for="newPasswd" class="col-sm-2 control-label">新登录密码:</label>
                        <div class="col-sm-7">
                            <input id="newPasswd" name="originPasswd" type="password" maxlength="32"
                                   minlength="2" class="form-control required" placeholder="请输入新登录密码">
                            <span class="badge">*</span>
                            <i class="toggle-passWd"></i>
                        </div>
                        <p id="msgTip01" class="msg-tip">密码为8-16个数字和字母的组合</p>
                    </li>
                    <li>
                        <label for="newAgainPasswd" class="col-sm-2 control-label">新登录密码:</label>
                        <div class="col-sm-7">
                            <input id="newAgainPasswd" name="originPasswd" type="password" maxlength="32"
                                   minlength="2" class="form-control required" placeholder="请再次输入新登录密码">
                            <span class="badge">*</span>
                            <i class="toggle-passWd"></i>
                        </div>
                        <p class="msg-tip">两次输入密码不一致</p>
                    </li>
                </ul>

			</div>
			<div class="modal-footer">
				<button type="button" id="saveModifyPasswd" class="btn btn-confirm btn-submit" style="color: #fff;background-color: #008bff;">保存</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!--确认模态框-->
<div class="modal fade" tabindex="-1" role="dialog" id="myCModal" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body text-center">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-confirm btn-submit" style="color: #fff;background-color: #008bff;" data-dismiss="modal">确认</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script src="static/js/util.js"></script>
<script>
    $(function () {
        var reg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,12}$/;
        var passwd = '';
        // 点击修改密码
        $('#modifyPasswd').click(function () {
            $('#passwdModal input').val('');
            $('.msg-tip').removeClass('go-show')
            $('#passwdModal').modal('show');
        })
        // 点击保存密码
        $('#saveModifyPasswd').click(function () {
            var oldPasswd = $.trim($('#originPasswd').val());
            var newPasswd = $.trim($('#newPasswd').val());
            if(!reg.test(newPasswd)){
                $('#msgTip01').addClass('go-show');
                return;
            }
            if($('#newAgainPasswd').val() != newPasswd){
                $('#msgTip02').addClass('go-show');
                return;
            }
            $.ajax({
                url : util.getServerUrl('/common/personalmodify'),
                method : 'POST',
                data : {oldpassword:oldPasswd,password:newPasswd},
                success : function (res) {
                    var errMsg = '';
                    if(res.status==0){
                        $('#passwdModal').modal('hide');
                        $('#passwdModal').on('hidden.bs.modal', function (e) {
                            alertModal('密码修改成功');
                        })
                    }else if(res.status == 1){
                        errMsg = res.msg;
                        alertModal(errMsg);
                    }else {
                        if(res.msg == '' || res.msg == undefined){
                            errMsg = '密码修改失败';
                        }else{
                            errMsg = res.msg;
                        }
                        $('#passwdModal').modal('hide');
                        $('#passwdModal').on('hidden.bs.modal', function (e) {
                            alertModal(errMsg);
                        })
                    }
                },
                error : function (error) {

                }
            })
        })
        function alertModal(str){
            $('#myCModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#myCModal').modal('show');
        }
        // 新密码失去焦点
        $('#newPasswd').blur(function () {
            passwd = $.trim($(this).val());
            if(!reg.test(passwd)){
                $(this).parents('li').find('.msg-tip').addClass('go-show');
            }else{
                $(this).parents('li').find('.msg-tip').removeClass('go-show');
            }

        })
        // 再次新密码失去焦点
        $('#newAgainPasswd').blur(function () {
            if($.trim($(this).val()) != passwd) {
                $(this).parents('li').find('.msg-tip').addClass('go-show');
            }else{
                $(this).parents('li').find('.msg-tip').removeClass('go-show');
            }
        })
        // 点击眼睛显示隐藏密码
        $('.toggle-passWd').off().on('click',function () {
            if ($(this).siblings('input').attr('type') == 'password') {
                $(this).addClass('show-passwd');
                $(this).siblings('input').attr('type', 'text');
            } else {
                $(this).removeClass('show-passwd');
                $(this).siblings('input').attr('type', 'password');
            }
        })
    })
</script>