<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", -10);
%>
<link rel="stylesheet" href="${ctx}/static/css/account/verify.css">
<link rel="stylesheet"
	href="${ctx}/static/css/relation/relation_list.css">
<link rel="stylesheet"
	href="<%=basePath%>static/css/order/order_list.css">
<!-- Main content -->
<div class="container-fluid">
	<section class="content">
		<div class="row toolbar">
			<div class="col-xs-12">
				<input id="search" class="form-control" type="text"
					placeholder="客户名称、客户经理名称、手机号、身份证">
				<button class="btn" id="searchTable">搜索</button>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="statistics clearfix product-btns">
					<button class="btn btn-sm pull-right" id="del_acct">移除客户</button>
					<button class="btn btn-sm pull-right" id="replace_acct">更换客户经理</button>
				</div>
				<div class="box">
					<div class="box-body">
						<table id="default_table"
							class="table table-primary table-hover table-striped my-table product-table">
							<thead>
								<tr>
									<th><input type='checkbox' id="allCheck" />全选</th>
									<th>客户名称</th>
									<th>手机号</th>
									<th>身份证</th>
									<th>银行卡</th>
									<th>客户经理</th>
								</tr>
							</thead>
						</table>
					</div>
					<!-- /.box-body -->
				</div>
			</div>
			<!-- /.box-body -->
		</div>
		<!-- /.row -->
		<!--模态框-->
		<div class="modal fade" tabindex="-1" role="dialog"
			id="myModal_confirm" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-confirm" id="confirmReplace"
							data-url="<%=basePath%>customer/relation/repalceResult">确认</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
		<!--模态框-->
		<div class="modal fade" tabindex="-1" role="dialog"
			id="myModal_cancel" data-backdrop="static" data-keyboard="false">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-confirm" id="confirmDelAcct"
							data-dismiss="modal">确认</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!-- /.modal -->
	</section>
</div>

<script type="text/javascript">

var returnData = {};
var table = {
        // 表格实例
        defTable: {},
        // 表格参数
        tableParams: {},
        init: function () {
            this.renderTable();
            this.bindEvent();

        },
        // 存储选中的checkOrderId
        checkOrderId : [],
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击筛选按钮重绘表格
            $('#searchTable').on('click', function () {
            	   _this.tableParams = {
            			   keyword: $.trim($('#search').val()) == '' ? null : $.trim($('#search').val())
                       };
                       _this.defTable.draw();
            });
         // 更换客户经理
            $('#replace_acct').on('click',function () {
                 if(_this.getCheckboxItem('check_id').length==0){
                    _this.alertModel('请至少选择一个账号');
                }else{ 
                	  _this.replace();
                }
            });
            // 确认
            $('#confirmReplace').on('click',function () {
                $('#myModal_confirm').modal('hide');
                  _this.confirmReplace(_this.getCheckboxItemModalBody('checkbox_busiId').join(',')); 
            });
            
            // 确认
            $('#confirmDelAcct').on('click',function () {
                $('#myModal_confirm').modal('hide');
                  _this.confirmDelAcct(); 
            });
         // 移除客户经理
            $('#del_acct').on('click',function () {
                if(_this.getCheckboxItem('check_id').length==0){
                    _this.alertModel('请至少选择一个账号');
                }else{
                	  _this.delect();
                }
            });
        },
     
          
        // 初始化页面渲染表格数据
        renderTable: function () {
            var _this = this;
            this.defTable = $('#default_table').DataTable({
                ordering: false,
                pagingType: "simple_numbers",
                autoWidth: false,
                processing: true,
                serverSide: true,
                info: true,
                ajax : function (data, callback, settings) {
                    //封装请求参数
                    var param = {};
                    param.length = data.length;//页面显示记录条数，在页面显示每页显示多少项的时候
                    // param.startIndex = data.start;//开始的记录序号
                    param.start = (data.start / data.length)+1;//当前页码
                    param.draw = data.draw;
                    $.ajax({
                        type: "POST",
                        url: '<%=basePath%>customer/relation/toCustomerListPage',
                        data: $.extend(param,_this.tableParams),  //传入组装的参数
                        dataType: "json",
                        success : function (result) {
                            //封装返回数据
                            if (result.status == 0) {
                            	 returnData.draw = result.draw; //返回了draw计数器
                                 returnData.recordsTotal = result.recordsTotal;//返回数据全部记录
                                 returnData.recordsFiltered = result.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
                                 returnData.data = result.data;//返回的数据列表
                                 callback(returnData); 
                            }else{
                                alert(result.msg);
                            }
                           
                           
                        }
                    })
                },
                language: {
                    url: "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
                },
                createdRow: function (row, data, index) {
                    $('td:eq(0)', row).html("<input type='checkbox' name='check_id' value='" + data.id + "'/>" + (index + 1));
                    
                   /*  if(data.state == '1'){
                    	$('td:eq(5)', row).html('冻结');
                    }else if(data.state == '0'){
                    	$('td:eq(5)', row).html('使用中');
                    }else{
                    	$('td:eq(5)', row).html('');
                    } */
                    
                    <%-- $('td:eq(6)', row).html('<a data-model="navTab" data-url="<%=basePath%>acctManage/toEditPage?userId='+data.id+'">编辑</a>'); --%>
                },
                lengthMenu: [[10, 20, 30], [10, 20, 30]],
                columns: [
                    {"data": "id"},
                    {"data": "customerName"},
                    {"data": "mobile"},
                    {"data": "identityNo"},
                    {"data": "bankCardNo"},
                    {"data": "accountManagerName"},
/*                     {"data": null} */
                ],
                initComplete: function (setting, json) {

                },
                drawCallback: function () {
                    drawICheck('allCheck', 'check_id');
                }

            })
        },
     // 转换时间
        formatTime: function (time) {
            if (time) {
                var date = new Date(time);
                return date.getFullYear() + '-' + (preZero(date.getMonth() + 1)) + '-' + preZero(date.getDate()) + ' ' + preZero(date.getHours()) + ':' + preZero(date.getMinutes()) + ':' + preZero(date.getSeconds());
            }
            function preZero(num) {
                num = '' + num;
                return num.length == 1 ? '0' + num : num;
            }
        },
        // 模态框弹出
        alertModel: function (str) {
            $('#myModal_cancel .modal-body').empty();
            $('#myModal_cancel .modal-body').html('<p>' + str + '</p>');
            $('#myModal_cancel').modal('show');
        },
        // 获取checkbox值
        getCheckboxItemModalBody: function (checkBoxName) {
            var arr = [];
            var ids = $('.modal-body input[name="' + checkBoxName + '"]');
            ids.each(function () {
                if (this.checked) {
                    arr.push(this.value);
                }
            });
            return arr;
        },
        
        // 获取checkbox值
        getCheckboxItem: function (checkBoxName) {
            var arr = [];
            var ids = $('.my-table input[name="' + checkBoxName + '"]');
            ids.each(function () {
                if (this.checked) {
                    arr.push(this.value);
                }
            })
            return arr;
        },
        
        confirmDelAcct : function () {
        
        	var id=this.getCheckboxItem('check_id').join(',');
            var params = {
            		customerIds : id
            },_this = this;
            $.ajax({
                url : '<%=basePath%>customer/relation/removeAppuser',
                method : 'POST',
                data : params,
                success : function (res) {
                	  console.log(res);
                    if(res.status==0){
                    	var result = JSON.stringify(res.data)
                    	var storage = window.localStorage; 
                    	storage.setItem("relationMoveResult",result);
                    	$('#navTab').load('<%=basePath%>customer/relation/repalceMoveResult');
                    }else{
                        if(res.msg==''){
                            alert('操作失败!,请稍后重试!');
                        }else{
                        	alert(res.msg);
                        }
                    }
                },
                error : function (error) {
                	alert('操作失败!,请稍后重试!');
                }
            })
        },
        // 确认替换客户经理
        confirmReplace : function (busiId) {
        
        	var id=this.getCheckboxItem('check_id').join(',');
        	console.log(id);
            var params = {
            		busiCommId:busiId,
            		customerIds : id
            		
            },_this = this;
            $.ajax({
                url : '<%=basePath%>customer/relation/replaceBusiComm',
                method : 'POST',
                data : params,
                success : function (res) {
                	console.log(res);
                    if(res.status==0){
                       
                    	var result = JSON.stringify(res.data)
                    	var storage = window.localStorage; 
                    	storage.setItem("relationResult",result);
                    	$('#navTab').load('<%=basePath%>customer/relation/repalceResult');
                    	
                    }else{
                        if(res.msg==''){
                            alert('操作失败!,请稍后重试!');
                        }else{
                            alert(res.msg);
                        }
                    }
                },
                error : function (error) {
                    alert('操作失败!,请稍后重试!');
                }
            })
        },
        delect : function () {
        	var  id_arr=this.getCheckboxItem('check_id');
          	 $('#myModal_cancel .modal-header').html('<h3>是否确认移除以下客户</h3><br>');
             var str='';
             $.each(returnData.data, function (k, v) {
            	 for(var i=0;i<id_arr.length;i++){ 
            		 if(v.id==id_arr[i]){
            			 str +="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+v.customerName+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+v.mobile+"<br>";
                	 }
            	 }
            	 });
       	 $('#myModal_cancel .modal-body').html(str);
         $('#myModal_cancel').modal('show');
           	
              
           },
        // 更换客户经理
        replace : function () {
        	
        	
            var params = {
                },_this = this;
                $.ajax({
                    url : '<%=basePath%>customer/relation/getBusiCommForCoro',
                    method : 'POST',
                    data : params,
                    success : function (res) {
                    	
                    	   console.log(res.data);
                        if(res.status==0){
                        	 $('#myModal_confirm .modal-header').html('<h3>请选择要更换的客户经理</h3><br>');
                             var str='';
                             $.each(res.data, function (k, v) {
                            	  str +="<input type='radio' name='checkbox_busiId' value='"+v.id+"' with='200px'' />" +"&nbsp;&nbsp;&nbsp;"+ v.user_mobile+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+v.user_name+"<br>";
                             })
                        	 $('#myModal_confirm .modal-body').html( str);
                          $('#myModal_confirm').modal('show');
                            
                        }else{
                            if(res.msg==''){
                                alert('操作失败!,请稍后重试!');
                            }else{
                                alert(res.msg);
                            } 
                        }
                    },
                    error : function (error) {
                        alert('操作失败!,请稍后重试!');
                    }
                });
        	
        	
       	
    
        	
           
        },
    }
    $(function () {
        table.init();
    })
</script>




<!--




 
  <%--  var params = {
              ids : _this.getCheckboxItemModalBody('checkbox_busiId').join(',');
          },
          $.ajax({
              url : '<%=basePath%>acctManage/delete',
              method : 'GET',
              data : params,
              success : function (res) {
              	 if (res.status == 0) {
			            	var data = res.data;
			            	console.log(data);
			            	
			            } 
              },
              error : function (error) {
                  _this.alertModel('操作失败!,请稍后重试!');
              }
          }) --%>





 this.getAjax({
            url: '/loanOrder/examineOrder',
            data: {
                resultValue: 3,
                processId: _this.tmp.processId,
                remark: $reason.val() + ',' + $cause.val()
            },
            success: function (res) {
                if (res.status == 0) {
                    _this.alertModel('订单拒绝成功!');
                    setTimeout(function () {
                        $('#myModal').modal('hide');
                    },1500);
                    $('#myModal').on('hidden.bs.modal', function (e) {
                        $('#navTab').load(_this.variable.basePath + url);
                    })
                } else {
                    if (res.msg == '') {
                        _this.alertModel('订单拒绝失败!');
                    } else {
                        _this.alertModel(res.msg);
                    }
                }
            },
            error: function (error) {
                _this.alertModel('订单拒绝失败!');
            }
        }) -->