<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="cycon" uri="http://www.cycon.com.cn/jsp/jstl/common"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- Content Header (Page header) -->
<!--<section class="content-header">-->
<!--<cycon:navigater path="role"></cycon:navigater>-->
<!--</section>-->
<!-- Content Header (Page header) -->
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">系统设置</li>
		<li><a href="/role/page" data-target="navTab">角色管理</a></li>
	</ol>
</section>

<form class="form-horizontal" action="file/upload" method="post" enctype="multipart/form-data"
	  id="defForm" callfn="refreshTable">
	<div class="modal-body">
		<div class="container-fluid">
			<div class="form-group">
				<label class="col-sm-2 control-label">附件</label>
				<div class="col-sm-7">
					<input type="file" value="上传">
				</div>
				<shiro:hasPermission name="file/upload">
					<button type="submit" id="import"class="btn btn-sm btn-primary">
						<i class="fa fa-fw fa-plus"></i>导入
					</button>
				</shiro:hasPermission>
			</div>

		</div>
	</div>
</form>

