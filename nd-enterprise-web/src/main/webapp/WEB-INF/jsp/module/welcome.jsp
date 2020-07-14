<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<section>
	 <div class="content">
	  	<div class="index-pic">
			<img alt="" src="<%=basePath %>${welcome}">
            <h1>${title}后台系统欢迎你</h1>
		</div>
    </div>
  <!--   <div class="footer">
        版权所有&copy;金鼎财富信息技术有限公司
    </div> -->
</section>

<script type="text/javascript">
	function gotoCompany(){
		//获取选中的公司
		
		//获取当前选中的公司信息
		var selectedDiv = $("div.selected");
		var coporateId = selectedDiv.children("input").val();
		var url = "user/deftCompany";
		var userId,coporateId;
		var checked = 0;
		if($('#isDefaultLogin').is(':checked')) {
		    checked = 1;
		}
		
		var postData = {"coporateId":coporateId,"isDefaultLogin":checked};
		
		$.post(url,postData,function(data){
			if(data.status == 1){
				window.location.href = "home?coporateId=" + coporateId;
			}else{
				alert(data.msg);
			}
		});
	}

</script>
</html>