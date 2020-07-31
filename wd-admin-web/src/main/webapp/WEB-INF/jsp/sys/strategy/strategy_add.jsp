<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="strategy/add" method="post"
      id="defForm" callfn="refreshTable" onsubmit="return checkBoxData()">
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
                <label for="name" class="col-sm-2 control-label">策略名</label>
                <div class="col-sm-7">
                    <input id="name" name="name" type="text" maxlength="32"
                           minlength="1" class="form-control required" placeholder="请输策略名">
                </div>
            </div>
            <div class="form-group">
                <label for="source" class="col-sm-2 control-label">订单来源</label>
                <div class="col-sm-7">
                    <input id="source" name="source" type="text" maxlength="32"
                           minlength="1" class="form-control required" placeholder="请输入订单来源">
                </div>
            </div>
            <div style="color: red"><h7>设置填充数据：设置渠道反馈订单需要被填充的数据字段。</h7></div>
            <hr>
            <div class="form-group">
                <label for="sourceNo" class="col-sm-2 control-label">原始订单号</label>
                <label>启用<input type="checkbox" id="sourceNoStatus" name="sourceNoStatus" value=""></label>
                <input type="hidden" id="sourceNoData" name="sourceNoStus" value="0">
                <div class="col-sm-7">
                    <input id="sourceNo" name="sourceNo" type="text" maxlength="32" value=""
                           minlength="1" class="form-control" placeholder="请输入匹配值">
                </div>
            </div>
            <div class="form-group">
                <label for="transWay" class="col-sm-2 control-label">物流方式</label>
                <label>启用<input type="checkbox" id="transWayStatus" name="transWayStatus" value=""></label>
                <input type="hidden" id="transWayData" name="transWayStus" value="0">
                <div class="col-sm-7">
                    <input id="transWay" name="transWay" type="text" maxlength="32" value=""
                           minlength="1" class="form-control" placeholder="请输入匹配值">
                </div>
            </div>
            <div class="form-group">
                <label for="transNo" class="col-sm-2 control-label">物流单号</label>
                <label>启用<input type="checkbox" id="transNoStatus" name="transNoStatus" value=""></label>
                <input type="hidden" id="transNoData" name="transNoStus" value="0">
                <div class="col-sm-7">
                    <input id="transNo" name="transNo" type="text" maxlength="32" value=""
                           minlength="1" class="form-control" placeholder="请输入匹配值">
                </div>
            </div>
            <div class="form-group">
                <label for="transMoney" class="col-sm-2 control-label">运费</label>
                <label>启用<input type="checkbox" id="transMoneyStatus" name="transMoneyStatus" value="" ></label>
                <input type="hidden" id="transMoneyData" name="transMoneyStus" value="0">
                <div class="col-sm-7">
                    <input id="transMoney" name="transMoney" type="text" maxlength="32" value=""
                           minlength="1" class="form-control" placeholder="请输入匹配值">
                </div>
            </div>
            <div class="form-group">
                <label for="amount" class="col-sm-2 control-label">数量</label>
                <label>启用<input type="checkbox" id="amountStatus" name="amountStatus" value="" ></label>
                <input type="hidden" id="amountData" name="amountStus" value="0">
                <div class="col-sm-7">
                    <input id="amount" name="amount" type="text" maxlength="32" value=""
                           minlength="1" class="form-control" placeholder="请输入匹配值">
                </div>
            </div>
            <div style="color: red"><h7>设置匹配数据：设置渠道反馈订单与ERP订单匹配的字段名称。</h7></div>
            <hr>
            <div class="form-group">
                <label for="amount" class="col-sm-2 control-label">货品编号</label>
                <div class="col-sm-7">
                    <input id="stockNo" name="stockNo" type="text" maxlength="32" value=""
                           minlength="1" class="form-control required" placeholder="请输入渠道订单货品编号列名">
                </div>
            </div>
            <div class="form-group">
                <label for="amount" class="col-sm-2 control-label">规格</label>
                <div class="col-sm-7">
                    <input id="specification" name="specification" type="text" maxlength="32" value=""
                           minlength="1" class="form-control required" placeholder="请输入渠道订单规格列名">
                </div>
            </div>
            <div class="form-group">
                <label for="amount" class="col-sm-2 control-label">备注</label>
                <div class="col-sm-7">
                    <input id="remark" name="remark" type="text" maxlength="32" value="备注"
                           minlength="1" class="form-control required" placeholder="请输入渠道订单备注列名">
                </div>
            </div>

        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <shiro:hasPermission name="dict/add">
            <button type="submit" class="btn btn-primary btn-save">保存</button>
        </shiro:hasPermission>
    </div>
</form>
<script type="text/javascript">
    $("#defForm").validate();
    function checkBoxData() {
        var sourceNoStatus = $('#sourceNoStatus').is(':checked');
        var transWayStatus = $("#transWayStatus").is(':checked');
        var transNoStatus = $("#transNoStatus").is(':checked');
        var transMoneyStatus = $("#transMoneyStatus").is(':checked');
        var amountStatus = $("#amountStatus").is(':checked');
        if(sourceNoStatus){
            $("#sourceNoData").val(1);
        }
        if(transWayStatus){
            $("#transWayData").val(1);
        }
        if(transNoStatus){
            $("#transNoData").val(1);
        }
        if(transMoneyStatus){
            $("#transMoneyData").val(1);
        }
        if(amountStatus){
            $("#amountData").val(1);
        }
    }
</script>