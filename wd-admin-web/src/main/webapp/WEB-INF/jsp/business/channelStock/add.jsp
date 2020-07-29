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
            <div class='bootstrap-dialog-title'>选择填充表格，策略请勿重复选择</div>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid" id="programMain">
            <c:forEach items="${strategyOrders}" var="strategyOder">
            <div class="form-group">
                <label class="col-sm-3 control-label">策略选择</label>
                <label class="col-sm-3 control-label" style="text-align: left;">选择待填充渠道订单</label>
                <label class="col-sm-3 control-label" style="text-align: left;"></label>
                <label class="col-sm-3 control-label" style="text-align: left;"></label>
            </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label">
                        <select id="strategyId" name="strategyId">
                            <c:forEach items="${strategyList}" var="strategy">
                                <c:if test="${strategyOder.strategyId == strategy.id}">
                                    <option value="${strategy.id}" selected>${strategy.name}</option>
                                </c:if>
                                <c:if test="${strategyOder.strategyId != strategy.id}">
                                    <option value="${strategy.id}">${strategy.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </label>
                    <label class="col-sm-3 control-label">
                        <input class="file" type="file" name="file"/>
                    </label>
                    <label class="col-sm-3 control-label">
                        <input type="hidden" id ="id" name="id" value="${strategyOder.id}">
                        <a title="${strategyOder.fileName}，点击下载，重复上传将覆盖之前的文件" href="${strategyOder.filePath}" style="color: red">已上传过</a>&nbsp;&nbsp;&nbsp;&nbsp;
                    </label>
                    <label class="col-sm-3 control-label">
                        <input type="button" name="导入" value="导入" onclick="uploadFile(this)"/>

                    </label>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="returnBtn">返回</button>
        <button type="button" class="btn btn-primary btn-edit" onclick="addProgram()">新增导入项目</button>
        <button type="button" class="btn btn-primary btn-edit" onclick="deleteProgram()">删除导入项目</button>
        <shiro:hasPermission name="dict/add">
            <button type="button" data-url="erpOrder/doSplit" data-model="dialog"
                    class="btn btn-sm btn-primary">
                <i class="fa fa-fw fa-plus"></i>执行拆分
            </button>
        </shiro:hasPermission>
    </div>
</form>
<script type="text/javascript">


    $(function () {
        if("${message}"){
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_WARNING,
                title: '操作结果提示',
                message: "${message}"
            });

            $("button").attr("disabled","disabled");
            $("#returnBtn").attr("disabled",false);
            $(".close").attr("disabled",false);

        }

    });

    function addProgram() {
        var html = "<div class='programDiv'><div class=\"form-group\">\n" +
            "                <label class=\"col-sm-3 control-label\">策略选择</label>\n" +
            "                <label class=\"col-sm-3 control-label\" style=\"text-align: left;\">标时字段-XXX渠道</label>\n" +
            "                <label class=\"col-sm-3 control-label\" style=\"text-align: left;\"></label>\n" +
            "            </div>\n" +
            "            <div class=\"form-group\">\n" +
            "                <label class=\"col-sm-3 control-label\">";

        html += '<select id="strategyId" name="strategyId"><c:forEach items="${strategyList}" var="strategy"><option value="${strategy.id}">${strategy.name}</option></c:forEach></select>';
        html += "</label>\n" +
            "                <label class=\"col-sm-3 control-label\">\n" +
            "                    <input class='file' type=\"file\"/>\n" +
            "                </label>\n" +
            "                <label class=\"col-sm-6 control-label\">\n" +
            "                    <input type=\"button\" name=\"导入\" value=\"导入\"/ onclick='uploadFile(this)'>\n" +
            "                </label>\n" +
            "            </div></div>";
        $("#programMain").append(html);
    }
    function deleteProgram(){
        var programDivs = $(".programDiv");
        if(programDivs.length == 0){
            return;
        }
        var deleteDiv = programDivs[programDivs.length-1];
        console.log($(deleteDiv).find());
        if($(deleteDiv).find("#strategyId").is(":disabled")){
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_WARNING,
                title: '提示',
                message: "填充渠道订单已上传，如需重新上传，请关闭当前弹窗重新打开",
            });
            return ;
        }
        deleteDiv.remove();
    }

    function uploadFile(obj){
        var strategyId = $(obj).parent().parent().find("#strategyId").val();
        var id = $(obj).parent().parent().find("#id").val();
        var file = $(obj).parent().parent().find(".file")[0].files[0];
        if(!file){
            BootstrapDialog.show({
                type: BootstrapDialog.TYPE_WARNING,
                title: '提示',
                message: "请选择上传文件",
            });
            return ;
        }
        var formData = new FormData();
        formData.append("file",file);
        formData.append("strategyId", strategyId);
        if(id){
            formData.append("id", id);
        }else{
            formData.append("id", 0);
        }
        $.ajax({
            url:'file/uploadReturnFile',
            dataType:'json',
            type:'POST',
            async: false,
            data: formData,
            processData : false, // 使数据不做处理
            contentType : false, // 不要设置Content-Type请求头
            success: function(data){
                console.log(data);
                if (data.status == '1') {
                    $(obj).attr("disabled","disabled");
                    $(obj).parent().parent().find("#strategyId").attr("disabled","disabled");
                    $(obj).parent().parent().find(".file").attr("disabled","disabled");
                    BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_SUCCESS,
                        title: '操作结果提示',
                        message: "上传成功",
                    });
                }else{
                    BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_WARNING,
                        title: '操作结果提示',
                        message: "上传失败，"+data.msg,
                    });
                }
            },
            error:function(response){
                console.log(response);
            }
        });

    }
    
    function doSubmit() {
        $.ajax({
            url:'erpOrder/doSplit',
            dataType:'json',
            type:'POST',
            async: false,
            success: function(data){
                console.log(data);
                if (data.status == '1') {
                    $(obj).attr("disabled","disabled");
                    $(obj).parent().parent().find("#strategyId").attr("disabled","disabled");
                    $(obj).parent().parent().find(".file").attr("disabled","disabled");
                    BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_SUCCESS,
                        title: '操作结果提示',
                        message: "上传成功",
                    });
                }else{
                    BootstrapDialog.show({
                        type: BootstrapDialog.TYPE_WARNING,
                        title: '操作结果提示',
                        message: "上传失败"+data.msg,
                    });
                }
            },
            error:function(response){
                console.log(response);
            }
        });
    }
</script>