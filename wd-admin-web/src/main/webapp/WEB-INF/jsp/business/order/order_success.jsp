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
            <div class='bootstrap-dialog-title'>渠道反馈订单</div>
            <label class="col-sm-4 control-label"></label>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid" id="programMain">
            <c:forEach items="${strategyOrders}" var="strategy">
                <div class="form-group">
                    <label class="col-sm-4 control-label">${strategy.fileName}</label>
                    <label class="col-sm-3 control-label"> <a href="${strategy.filePath}" class="btn btn-primary btn-edit downLoad">下载</a></label>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
        <button type="button" class="btn btn-primary btn-edit" onclick="downLoadAdd()">一键下载</button>
    </div>

</form>
<script type="text/javascript">
    
    function downLoadAdd() {
        <c:forEach items="${strategyOrders}" var="t">
        window.open("${t.filePath}");
        </c:forEach>
    }

</script>
