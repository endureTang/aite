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
                <label for="brandNameEdit" class="col-sm-2 control-label">品名</label>
                <div class="col-sm-7">
                    <input id="brandNameEdit" name="brandNameEdit" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入品名">
                </div>
            </div>
            <div class="form-group">
                <label for="specEdit" class="col-sm-2 control-label">规格</label>
                <div class="col-sm-7">
                    <input id="specEdit" name="spec" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入规格">
                </div>
            </div>
            <div class="form-group">
                <label for="unitEdit" class="col-sm-2 control-label">单位</label>
                <div class="col-sm-7">
                    <input id="unitEdit" name="unitEdit" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入单位">
                </div>
            </div>
            <div class="form-group">
                <label for="amountEdit" class="col-sm-2 control-label">数量</label>
                <div class="col-sm-7">
                    <input id="amountEdit" name="amount" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入数量">
                </div>
            </div>
            <div class="form-group">
                <label for="priceEdit" class="col-sm-2 control-label">单价</label>
                <div class="col-sm-7">
                    <input id="priceEdit" name="price" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入单价">
                </div>
            </div>
            <div class="form-group">
                <label for="discountPriceEdit" class="col-sm-2 control-label">优惠</label>
                <div class="col-sm-7">
                    <input id="discountPriceEdit" name="discountPriceEdit" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入优惠">
                </div>
            </div>
            <div class="form-group">
                <label for="basePriceEdit" class="col-sm-2 control-label">分摊成本</label>
                <div class="col-sm-7">
                    <input id="basePriceEdit" name="basePriceEdit" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入分摊成本">
                </div>
            </div>
            <div class="form-group">
                <label for="remarkEdit" class="col-sm-2 control-label">备注</label>
                <div class="col-sm-7">
                    <input id="remarkEdit" name="remarkEdit" value=""
                           type="text" maxlength="32" minlength="2"
                           class="form-control required" placeholder="请输入备注">
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
        var spec = $("#specEdit").val();
        var stockNo = $("#stockNoEdit").val();
        var amount = $("#amountEdit").val();
        var price = $("#priceEdit").val();
        var brandName = $("#brandNameEdit").val();
        var unit = $("#unitEdit").val();
        var discountPrice = $("#discountPriceEdit").val();
        var basePrice = $("#basePriceEdit").val();
        var remark = $("#remarkEdit").val();
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
                message: "单价不能为空",
            });
            return ;
        }
        if(amount == null || amount == ''){
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_WARNING,
                title: '提示',
                message: "数量不能为空",
            });
            return ;
        }
        $.ajax({
            type: "POST",
            url: 'addStock',
            data: {
                spec: spec,
                stockNo: stockNo,
                amount: amount,
                brandName: brandName,
                unit: unit,
                discountPrice: discountPrice,
                basePrice: basePrice,
                remark: remark,
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