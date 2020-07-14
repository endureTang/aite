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
<%
String orderId = request.getParameter("orderId") ;
%>
<div class="nav-bar">
    <a data-model="navTab" data-url="<%=basePath%>loanOrder/myLoanOrderList">< 返回我的订单</a>
    <div class="reject-reason"><span id="rejectName"></span> &nbsp;&nbsp;:&nbsp;&nbsp; <span
            id="rejectContent"></span></div>
</div>
<div class="steps">
    <ul class="clearfix" id="step_process">
        <li class="active">
                        <span class="time-out">

                        </span>
            <span class="normal">启动</span>
        </li>
        <li class="process"></li>
        <li class="">
                        <span class="time-out">
                            耗时: <i>35</i> 分钟
                        </span>
            <span class="normal">手动分单</span>
        </li>
        <li class="process"></li>
        <li class="">
                        <span class="time-out">
                            耗时: <i>35</i> 分钟
                        </span>
            <span class="normal">初审</span>
        </li>
        <li class="process"></li>
        <li>

            <span class="normal">复审</span>
        </li>
        <li class="process"></li>
        <li>

            <span class="normal">终审</span>
        </li>
        <li class="process"></li>
        <li>

            <span class="normal">结束</span>
        </li>
    </ul>
</div>