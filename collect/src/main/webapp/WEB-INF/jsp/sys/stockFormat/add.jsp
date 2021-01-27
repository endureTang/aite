<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="stockFormat/add" method="post"
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
        <div class="container-fluid" id="programMain">
            <div style="color: red"><h7>顺序将决定导出Excel列名顺序</h7></div>
            <hr>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">格式名</label>
                <div class="col-sm-5">
                    <input id="name" name="name" type="text" maxlength="32"
                           minlength="1" class="form-control required" placeholder="请输格式名">
                </div>
                <div class="col-sm-4">
                    <label >启用 &nbsp;&nbsp;<input type="checkbox" id="status" name="status" value="0"></label>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">列名</label>
                <div class="col-sm-5">
                    <input name="stockFormatDictList[0].columName" type="text" maxlength="32"
                           minlength="1" class="form-control required" placeholder="请输入序列号">
                </div>
                <div class="col-sm-4">
                    <label>
                        <select name="stockFormatDictList[0].dictId">
                            <option value="-1" selected>选择字段</option>
                            <c:forEach items="${dictList}" var="dict">
                                <option value="${dict.id}" >${dict.labelText}</option>
                            </c:forEach>
                        </select>
                    </label>
                </div>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary btn-edit" onclick="addProgram()">添加字段</button>
        <button type="button" class="btn btn-primary btn-edit" onclick="deleteProgram()">删除字段</button>
        <shiro:hasPermission name="dict/add">
            <button type="submit" class="btn btn-primary btn-save">保存</button>
        </shiro:hasPermission>
    </div>
</form>
<script type="text/javascript">
    function addProgram() {
        var programDivs = $(".programDiv");
        var count = programDivs.length +1;
        var html = "<div class=\"form-group programDiv\">\n" +
            "                <label class=\"col-sm-2 control-label\">列名</label>\n" +
            "                <div class=\"col-sm-5\">\n" +
            "                    <input name=\"stockFormatDictList["+count+"].columName\" type=\"text\" maxlength=\"32\"\n" +
            "                           minlength=\"1\" class=\"form-control required\" placeholder=\"请输入序列号\">\n" +
            "                </div>\n" +
            "                <div class=\"col-sm-4\">\n" +
            "                    <label>";

        html += '<select name="stockFormatDictList['+count+'].dictId"> <option value="-1" selected>选择字段</option> <c:forEach items="${dictList}" var="dict"><option value="${dict.id}">${dict.labelText}</option></c:forEach></select>';
        html += "</label>\n" +
            "                </div>\n" +
            "            </div>";
        $("#programMain").append(html);
    }

    function deleteProgram(){
        var programDivs = $(".programDiv");
        if(programDivs.length == 0){
            return;
        }
        var deleteDiv = programDivs[programDivs.length-1];
        deleteDiv.remove();
    }

    $("#defForm").validate();
    function checkBoxData() {
        var status = $('#status').is(':checked');
        if(status){
            $("#status").val(1);
        }
    }
</script>