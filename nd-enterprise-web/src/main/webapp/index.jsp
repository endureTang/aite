<%@ page language="java" import="java.util.*, com.nj.core.base.util.Const"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${not empty sessionScope.sessionUser}">
<jsp:forward page="/home" />
</c:if>
<c:if test="${empty sessionScope.sessionUser}">
<jsp:forward page="/user/login" />
</c:if>
