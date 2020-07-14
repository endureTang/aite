<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.nj.core.base.enums.ERoleType"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>

<link rel="stylesheet" href="<%=basePath%>static/css/order/order_list.css">
<div class="container-fluid">
    <section class="content">
        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix h30"></div>

                <div class="panel panel-default channel-edit">
                    <div class="panel-heading">
                        <h3 class="panel-title">移除结果</h3>
                    </div>
                    <div class="panel-body">
                        				
                        		
						
                        
                    </div>
                </div>
            </div>
        </div>
    </section>
   
</div>

<script type="text/javascript">

	var result = window.localStorage.getItem("relationMoveResult"); 
	var data  = JSON.parse(result)
	var temStr = '';
	for(var i = 0 ;i < data.length;i++){
		var item = data[i];
		temStr += '<li>'+
						'<i class="con-name">'+item.result+'</i>'+
						'<label class="con-name">'+item.resultInfo+'</label>'+	
					'</li>'
	}
	temStr +='<button class="btn btn-primary" id="return">返回</button>';
	$(".panel-body").html(temStr);
    var acct = {
        init: function () {
            this.bindEvent();
        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            
            $('#return').click(function () {
            	$("#navTab").load("<%=basePath%>customer/relation/toCustomerListPage");
            });
        },
        
    }
    
    $(document).ready(function () {
    	acct.init();
    })
    

</script>
