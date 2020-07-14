<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<form class="form-horizontal" action="coporate/corEdit" method="post"
      id="defForm" callfn="refreshTable">
    <input type="hidden" name="coporateId" value="${njCoporateObj.id}">
    <div class="modal-header">
        <div class='bootstrap-dialog-header'>
            <div class='bootstrap-dialog-close-button' style='display: block;'>
                <button class='close' data-dismiss='modal' aria-label='Close'>×</button>
            </div>
            <div class='bootstrap-dialog-title'>编辑企业</div>
        </div>
    </div>
    <div class="modal-body">
        <div class="container-fluid">
            <div class="form-group">
                <label for="companCode" class="col-sm-2 control-label">企业编号</label>
                <div class="col-sm-7">
                    <input id="companCode" readonly name="companCode" type="text" maxlength="32"
                           minlength="2" class="form-control required" placeholder="请输入企业编号" value="${njCoporateObj.companCode}">
                </div>
            </div>

            <div class="form-group">
                <label for="companName" class="col-sm-2 control-label">企业名称</label>
                <div class="col-sm-7">
                    <input id="companName" name="companName" type="text" maxlength="32"
                           minlength="2" class="form-control required" placeholder="请输入企业名称" value="${njCoporateObj.companName}">
                </div>
            </div>

            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">企业地址</label>
                <div class="col-sm-7">
                    <input id="address" name="address" type="text" maxlength="32"
                           minlength="2" class="form-control required" placeholder="请输入企业地址" value="${njCoporateObj.address}">
                </div>
            </div>

            <div class="form-group">
                <label for="maxCreditLimit" class="col-sm-2 control-label">最大授信额度(万元)</label>
                <div class="col-sm-7">
                    <input id="maxCreditLimit" name="maxCreditLimit" type="number" maxlength="10"
                           minlength="1" class="form-control required" placeholder="请输入最大授信额度" value="<fmt:formatNumber type='number' value='${njCoporateObj.maxCreditLimit}' pattern='#'/>">
                </div>
            </div>

            <div class="form-group">
                <label for="" class="col-sm-2 control-label">支付渠道</label>
                <input name="payChannel" id="payChannel" type="hidden"/>
                <div class="col-sm-7">
                    <c:forEach var="payChannelMap" items="${payChannelList}">
                        <c:forEach var="item" items="${payChannelMap}">
                            <label><input name="payWay" class="item" type="radio" <c:if test="${njCoporateObj.payChannel == item.key}">checked</c:if> value="${item.key}">${item.value}</label>
                        </c:forEach>
                    </c:forEach>
                </div>
            </div>

            <div class="form-group">
                <label for="" class="col-sm-2 control-label">资产推送渠道</label>
                <input name="capitalEndChannel" id="capitalEndChannel" type="hidden"/>
                <div class="col-sm-7">
                    <c:forEach var="capticalEndListMap" items="${capticalEndList}">
                        <c:forEach var="item" items="${capticalEndListMap}">
                            <label><input name="pushWay" class="item" <c:if test="${njCoporateObj.capitalEndChannel == item.key}">checked</c:if> type="radio" value="${item.key}">${item.value}</label>
                        </c:forEach>
                    </c:forEach>
                </div>
            </div>

            <div class="form-group">
                <label for="" class="col-sm-2 control-label">授权使用个人产品模板</label>
                <input name="productTempIds" id="productTempIds" type="hidden"/>
                <div class="col-sm-7">
                    <c:forEach var="personTemplateListMap" items="${personTemplateList}">
                        <c:forEach var="item" items="${personTemplateListMap}">
                            <label><input class="item productModel"
                                <c:forEach var="list" items="${cptList}">
                                    <c:if test="${list.productTempId == item.key}">checked</c:if>
                                </c:forEach>
                                type="checkbox" value="${item.key}">${item.value}</label>
                        </c:forEach>
                    </c:forEach>
                </div>
            </div>

            <div class="form-group">
                <label for="" class="col-sm-2 control-label">授权使用企业产品模板</label>
                <div class="col-sm-7">
                    <c:forEach var="companyTemplateListMap" items="${companyTemplateList}">
                        <c:forEach var="item" items="${companyTemplateListMap}">
                            <label><input class="item productModel"
                                <c:forEach var="list" items="${cptList}">
                                    <c:if test="${list.productTempId == item.key}">checked</c:if>
                                </c:forEach>
                                type="checkbox" value="${item.key}">${item.value}</label>
                        </c:forEach>
                    </c:forEach>
                </div>
            </div>

        </div>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <!--<shiro:hasPermission name="user/njAdd">-->
        <button type="button" id="saveEdit" class="btn btn-primary btn-save">保存</button>
        <!--</shiro:hasPermission>-->
    </div>
</form>
<script type="text/javascript">
    renderCheckbox();

    function renderCheckbox() {
        $('input.productModel').iCheck({
            checkboxClass: 'icheckbox_minimal-blue my-check',
        });
        $('input[name="payWay"]').iCheck({
            radioClass: 'iradio_minimal-blue my-check',
        });
        $('input[name="pushWay"]').iCheck({
            radioClass: 'iradio_minimal-blue my-check',
        });

    }


    $('#defForm').validate({
        rules: {
            loginName: {
                required: true,
                remote: {
                    type: "post",
                    url: "user/checkName",
                    dataType: "json",
                    dataFilter: function (data, type) {
                        if (data == 1) {
                            return false;
                        } else {
                            return true;
                        }
                    }
                }
            }
        },
        messages: {
            loginName: {
                required: "请输入用户名",
                remote: "用户名重复"
            }
        }
    });

    $(function () {
        $('#saveEdit').click(function () {
            var productIds = "";

            $('#payChannel').val(getiCheckItem('payWay')[0]);
            $('#capitalEndChannel').val(getiCheckItem('pushWay')[0]);

            $("input.productModel").each(function () {
                if (this.checked) {
                    productIds += $(this).attr('value') + ",";
                }
            })
            $("#productTempIds").val(productIds.slice(0,productIds.length-1));


            // 判断有无小数点
            if( /^[0-9]\d{0,10}$/.test(Number($('#maxCreditLimit').val())) && String($('#maxCreditLimit').val()).indexOf('.')==-1){
                $('#defForm').submit();
            }else{
                alert('最大授信额度必须是正整数并且不能有小数!');
            }


        })


    });
</script>