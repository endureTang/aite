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
            <c:forEach items="${dictList}" var="dict">
                <div class="form-group">
                    <label for="${dict.type}" class="col-sm-2 control-label">${dict.value}</label>
                    <label>启用<input type="checkbox" id="${dict.type}Status" name="${dict.type}Status" value=""></label>
                    <input type="hidden" id="${dict.type}Data" name="${dict.type}Stus" value="0">
                    <div class="col-sm-7">
                        <input id="${dict.type}" name="${dict.type}" type="text" maxlength="32"
                               minlength="1" class="form-control" placeholder="请输入匹配值">
                    </div>
                </div>
            </c:forEach>

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