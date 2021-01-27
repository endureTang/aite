<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal">
    <div class="modal-header">
        <div class='bootstrap-dialog-header'>
            <div class='bootstrap-dialog-close-button'
                 style='display: block;'>
                <button class='close' data-dismiss='modal' aria-label='Close'>×</button>
            </div>
            <div class='bootstrap-dialog-title'>新增</div>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid">
            <div class="form-group">
                <label for="stockNoEdit" class="col-sm-2 control-label">货品编号</label>
                <div class="col-sm-7">
                    <input id="stockNoEdit" name="stockNo" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入货品编号">
                </div>
            </div>
            <div class="form-group">
                <label for="specEdit" class="col-sm-2 control-label">货品规格</label>
                <div class="col-sm-7">
                    <input id="specEdit" name="spec" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入货品规格">
                </div>
            </div>
            <div class="form-group">
                <label for="priceEdit" class="col-sm-2 control-label">成本价</label>
                <div class="col-sm-7">
                    <input id="priceEdit" name="price" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入成本价">
                </div>
            </div>


        </div>
    </div>
    <div class="modal-footer">
        <button type="button" id="closeBtn" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" onclick="editSubmit()" class="btn btn-primary btn-save">保存</button>
    </div>
</form>
<script type="text/javascript">
    function editSubmit(){
        var stockNo = $("#stockNoEdit").val();
        var spec = $("#specEdit").val();
        var price = $("#priceEdit").val();
        if(stockNo == null || stockNo == ''){
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_WARNING,
                title: '提示',
                message: "货品编号不能为空",
            });
            return ;
        }
        if(price == null || price == ''){
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_WARNING,
                title: '提示',
                message: "价格不能为空",
            });
            return ;
        } if(spec == null || spec == ''){
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_WARNING,
                title: '提示',
                message: "规格不能为空",
            });
            return ;
        }
        $.ajax({
            type: "POST",
            url: 'addPrice',
            data: {
                spec: spec,
                stockNo: stockNo,
                price:price
            },
            dataType: 'json',
            cache: false,
            success: function (data) {
                refreshTable(true);
                $("#closeBtn").click();
                BootstrapDialog.show({
                    type: BootstrapDialog.TYPE_SUCCESS,
                    title: '操作结果提示',
                    message: "修改成功"
                });
            }
        });
    }
</script>