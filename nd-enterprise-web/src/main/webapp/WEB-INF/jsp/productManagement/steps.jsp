<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<div class="steps steps-process">
    <ul class="clearfix" id="process">
        <li class="active dot">
            <span class="normal">基本配置</span>
        </li>
        <li class="process"></li>
        <li class="dot">
            <span class="normal">渠道配置</span>
        </li>
        <li class="process"></li>
        <li class="dot">
            <span class="normal">业务受理配置</span>
        </li>
        <li class="process"></li>
        <li class="dot">
            <span class="normal">交易配置</span>
        </li>
        <li class="process"></li>
        <c:if test="${productTempId == 2}">
            <li class="dot">
                <span class="normal">费用配置</span>
            </li>
            <li class="process"></li>
        </c:if>
        <li class="dot">
            <span class="normal">流程配置</span>
        </li>
    </ul>
</div>
<script>
    $(function () {
        $('#process').on('click','li.dot',function () {
            $('.configuration > div').hide();
            switch ($(this).index()) {
                case 0 :
                    product.baseConfigurationInit();
                    $('.configuration > div').eq(0).show();
                    break;
                case 2 :
                    product.channelInit();
                    $('.configuration > div').eq(1).show();
                    break;
                case 4 :
                    product.businessInit();
                    $('.configuration > div').eq(2).show();
                    break;
                case 6 :
                    product.dealInit();
                    $('.configuration > div').eq(3).show();
                    break;
                case 8 :
                    if('${productTempId}'==2) {
                        product.moneyInit();
                        $('.configuration > div').eq(4).show();
                    }else{
                        product.processInit();
                        $('.configuration > div').eq(4).show();
                    }
                    break;
                case 10 :
                    product.processInit();
                    $('.configuration > div').eq(5).show();
                    break;
            }

        })
    })
</script>
