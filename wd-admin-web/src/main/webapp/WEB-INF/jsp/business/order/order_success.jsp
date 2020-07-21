<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <div class="modal-header">
        <div class='bootstrap-dialog-header'>
            <div class='bootstrap-dialog-close-button'
                 style='display: block;'>
                <button class='close' data-dismiss='modal' aria-label='Close'>×</button>
            </div>
            <div class='bootstrap-dialog-title'>选择填充表格</div>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid" id="programMain">

            <c:forEach items="${strategyOrders}" var="strategy">
                <div class="form-group">
                    <label class="col-sm-4 control-label">${strategy.fileName}</label>
                    <div class="col-sm-7">
                       <a href="${strategy.filePath}" class="btn btn-primary btn-edit">下载反馈订单</a>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>

</script>