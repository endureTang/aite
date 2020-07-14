<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String orderId = request.getParameter("orderId") ;
%>
<%
String isArchive = request.getParameter("isArchive") ;
%>
<style>
    form .modal-body .form-group i.isArchive-name {
        margin-right: 10px;
    }
</style>
<form class="form-horizontal" action="loanOrder/saveOrderArchiveRecord" method="post" id="defForm" callfn="refreshTable">
    <input type="hidden" id="tmpId" value="">
    <div class="modal-header">
        <div class='bootstrap-dialog-header'>
            <div class='bootstrap-dialog-close-button' style='display: block;'>
                <button class='close' data-dismiss='modal' aria-label='Close'>×</button>
            </div>
            <div class='bootstrap-dialog-title'>资料归档</div>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid">
            <div class="form-group">
                <label class="col-sm-2 control-label">归档资料(多选项)</label>
                <div class="col-sm-7">
                    <i class="isArchive-name">1、登记证书</i><input type="checkbox" name="certificate">
                    <i class="isArchive-name">2、车辆保单</i><input type="checkbox" name="carWarranty">
                    <i class="isArchive-name">3、购车发票</i><input type="checkbox" name="carInvoice">
                    <i class="isArchive-name">4、GPS照片</i><input type="checkbox" name="gpsPhoto">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">归档情况(单选项)</label>
                <div class="col-sm-7">
                    <i class="isArchive-name">已完成</i><input type="radio" name="isArchive" value="1">
                    <i class="isArchive-name">未完成</i><input type="radio" name="isArchive" value="0">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">归档时间</label>
                <div class="col-sm-7">
                    <span id="createTime"></span>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" id="submitBtn" data-dismiss="modal" class="btn btn-primary btn-save">提交</button>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        // 获取数据
        $.ajax({
            url : util.getServerUrl('/loanOrder/getOrderArchiveRecord'),
            method : 'POST',
            data : {
                orderId : '<%=orderId%>',
            },
            success : function (res) {
                if(res.status==0){
                    renderHtml(res.data)
                }else {
                    table.alertModelCancel(res.msg);
                }
            },
            error : function (error) {
                table.alertModelCancel(error);
            }
        })
        function renderHtml(data){
            // 保存id
            $('#tmpId').val(data.id);
            // 归档时间
            $('#createTime').html(table.formatTime(data.createTime));
            // 是否归档单选框
            $('input[name="isArchive"]').each(function (k, v) {
                if($(this).val() == '<%=isArchive%>'){
                    $(this).attr('checked',true)
                }
            })
            // 复选框
            data.certificate == 1 ? $('input[name="certificate"]').attr('checked',true) : $('input[name="certificate"]').removeAttr('checked');
            data.carWarranty == 1 ? $('input[name="carWarranty"]').attr('checked',true) : $('input[name="carWarranty"]').removeAttr('checked');
            data.carInvoice == 1 ? $('input[name="carInvoice"]').attr('checked',true) : $('input[name="carInvoice"]').removeAttr('checked');
            data.gpsPhoto == 1 ? $('input[name="gpsPhoto"]').attr('checked',true) : $('input[name="gpsPhoto"]').removeAttr('checked');
            renderIcheck();
        }
        function renderIcheck(){
            $('input[name="certificate"]').iCheck({
                checkboxClass : 'icheckbox_minimal-blue'
            });
            $('input[name="carWarranty"]').iCheck({
                checkboxClass : 'icheckbox_minimal-blue'
            });
            $('input[name="carInvoice"]').iCheck({
                checkboxClass : 'icheckbox_minimal-blue'
            });
            $('input[name="gpsPhoto"]').iCheck({
                checkboxClass : 'icheckbox_minimal-blue'
            });
            $('input[name="isArchive"]').iCheck({
                radioClass : 'iradio_minimal-blue'
            });
        }
        $('#submitBtn').click(function () {
            var params = {
                orderId : '<%=orderId%>',
                id : $('#tmpId').val(),
                certificate : isChecked('certificate'),
                carWarranty : isChecked('carWarranty'),
                carInvoice : isChecked('carInvoice'),
                gpsPhoto : isChecked('gpsPhoto'),
                isArchive : getChecked("isArchive")[0]
            }
            $.ajax({
                url : util.getServerUrl('/loanOrder/saveOrderArchiveRecord'),
                method : 'POST',
                data : params,
                success : function (res) {
                    if(res.status==0){
                        table.alertModelCancel(res.msg);
                        table.defTable.draw();
                    }else {
                        table.alertModelCancel(res.msg);
                    }
                },
                error : function (error) {
                    table.alertModelCancel(error);
                }
            })
        })
        function isChecked(name) {
            return $('input[name="'+name+'"]').is(':checked') ? 1 : 0
        }
        function getChecked(name) {
            var arr = [];
            var ids = $('input[name="' + name + '"]');
            ids.each(function () {
                if (this.checked) {
                    arr.push(this.value);
                }
            })
            return arr;
        }
    })
</script>