<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ page import="com.nj.core.base.enums.ERepayStatus"%>
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
<link rel="stylesheet" href="${ctx}/static/css/account/verify.css">
<link rel="stylesheet" href="${ctx}/static/css/order/order_list.css">
<link rel="stylesheet" href="<%=basePath%>static/css/order/order_list.css">
<!-- Main content -->
<div class="container-fluid">
	<section class="content">
		<div class="row toolbar">
			<div class="col-xs-12">
                <input id="beginDate" class="form-control" type="text" value="" readonly="readonly">&nbsp;至&nbsp;
                <input id="endDate" class="form-control" type="text" value="" readonly="readonly">
                <select id="repayStatus" class="form-control">
                	<option value="">全部</option>
                	<option value="<%=ERepayStatus.NOT.getValue()%>"><%=ERepayStatus.NOT.getName()%></option>
                	<option value="<%=ERepayStatus.NORMAL.getValue()%>"><%=ERepayStatus.NORMAL.getName()%></option>
                	<option value="<%=ERepayStatus.COLLECTION.getValue()%>"><%=ERepayStatus.COLLECTION.getName()%></option>
                	<option value="<%=ERepayStatus.EARLY_CLEARANCE.getValue()%>"><%=ERepayStatus.EARLY_CLEARANCE.getName()%></option>
                	<option value="<%=ERepayStatus.OVERDUE.getValue()%>"><%=ERepayStatus.OVERDUE.getName()%></option>
                </select>
                <button class="btn btn-success" id="searchTable" style="background-color: #008d4c;margin-right: 5px;">搜索</button>
                <button class="btn btn-submit" id="exportAll">导出</button>
            </div>
        </div>
		<div class="row">
			<div class="statistics clearfix h30"></div>
			<div class="col-xs-12">
				 <div class="box">
                    <div class="box-body">
                        <table id="default_table"
                               class="table table-primary table-hover table-striped my-table product-table">
                            <thead>
	                            <tr>
	                                <th>期数</th>
	                               	<th>订单号</th>
									<th>还款状态</th>
									<th>回款状态</th>
									<th>产品名</th>
									<th>借款人姓名</th>
									<th>身份证</th>
									<th>客户借款金额</th>
									<th>小贷放款金额</th>
									<th>客户借款余额</th>
									<th>小贷放款余额</th>
									<th>借款期限</th>
									<th id="planRepayDate">计划还款日期</th>
									<th id="planRepayTotalAmount">应还总额</th>
									<th>实还总额</th>
									<th>当月实际还款日期</th>
									<th>扣款情况</th>
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
	</section>
	
	<!--模态框-->
    <div class="modal fade" tabindex="-1" role="dialog" id="myModal" data-backdrop="static" data-keyboard="false">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                            aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body text-center">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-confirm" data-dismiss="modal">确认</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>

<script type="text/javascript">
	laydate.render({
	  elem: '#beginDate',
	  format: 'yyyy-MM-dd',
	  type: 'date'
	});
	
	laydate.render({
	  elem: '#endDate',
	  format: 'yyyy-MM-dd',
	  type: 'date'
	});

	$("#beginDate").val(getLastSevenDays(new Date()));
	$("#endDate").val(getCurDate());
	
	function getLastSevenDays(date){
        var date = date || new Date(),
            timestamp, 
            newDate;
        if(!(date instanceof Date)){
            date = new Date(date.replace(/-/g, '/'));
        }
        timestamp = date.getTime();
        newDate = new Date(timestamp - 7 * 24 * 3600 * 1000);
        var month = newDate.getMonth() + 1;
        month = month.toString().length == 1 ? '0' + month : month; 
        var day = newDate.getDate().toString().length == 1 ? '0' + newDate.getDate() :newDate.getDate();
        return [newDate.getFullYear(), month, day].join('-');
    }
	
	function getCurDate(){
		var now = new Date();
	    var year = now.getFullYear(); //得到年份
	   	var month = now.getMonth();//得到月份
	   	var date = now.getDate();//得到日期
	   	month = month + 1;
	    if (month < 10) month = "0" + month;
	    if (date < 10) date = "0" + date;
	    var time = "";
	    time = year + "-" + month + "-" + date;
	    return time;
	}
	
	 // 模态框弹出
    function alertModel(str) {
        $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
        $('#myModal').modal('show');
    }

    var columns = [{"data": "period"},
                   {
			        "data": null,
			        render : function (data, type, row,meta) {
			            return '<a data-model="navTab" data-url="<%=basePath%>repayInfoMenu/getRepayInfo?start='+meta.settings.oAjaxData.start+'&beginDate='+$.trim($('#beginDate').val())+'&endDate='+$.trim($('#endDate').val())+'&orderId='+row.orderId+'&keyword='+$.trim($('#search').val())+'&orderStatus='+$.trim($('#orderStatus').val())+'&period='+$.trim($('#period').val())+'&orderNo='+row.orderNo+'">'+row.orderNo+'</a>'                        }
			    },
			    {"data": "repayStatus"},
			    {"data": "moneyRepayStatus"},
			    {"data": "productName"},
			    {"data": "userName"},
			    {"data": "identifyId"},
			    {"data": "auditAmount"},
			    {"data": "actualAmount"},
			    {"data": "repayLoanBalance"},
			    {"data": "moneyLoanBalance"},
			    {"data": "auditPeriod"},
			    {"data": "planRepayDate"}];
	 // 同步执行，获取动态费用相关信息
	 function getDynamicFeeInfo(){
		 $.ajax({
             type: "POST",
             url: util.getServerUrl('/repaySituation/getDynamicFeeInfo'),
             data: "",  //传入组装的参数 
             dataType: "json",
             async:false,
             success : function (result) {
                 //封装返回数据
                 if(result.status != 0){
                 	alertModel(result.msg);
                 }else{
                 	// 动态添加应还的表头
                 	var planFeeTableHead = result.planFeeTableHead;
                 	var addPlanTableHeadHtml = "";
                 	for (var i = 0; i < planFeeTableHead.length; i++) {
                 		addPlanTableHeadHtml += "<th>" + planFeeTableHead[i] + "</th>"; 
					}
               		$("#planRepayDate").after(addPlanTableHeadHtml);
               		
               		// 动态添加实还的表头
               		var accFeeTableHead = result.accFeeTableHead;
                 	var addAccTableHeadHtml = "";
                 	for (var i = 0; i < accFeeTableHead.length; i++) {
                 		addAccTableHeadHtml += "<th>" + accFeeTableHead[i] + "</th>";
					}
               		$("#planRepayTotalAmount").after(addAccTableHeadHtml);
               		
               		// 动态设置columns
               		var planFeeCodeSortList = result.planFeeCodeSortList; 
               		for (var i = 0; i < planFeeCodeSortList.length; i++) {
               			columns.push({"data":planFeeCodeSortList[i]});
					}	
               		columns.push({"data": "planRepayTotalAmt"});
               		
               		var accFeeCodeSortList = result.accFeeCodeSortList;
               		for (var i = 0; i < accFeeCodeSortList.length; i++) {
               			columns.push({"data":accFeeCodeSortList[i]});
					}
               		columns.push({"data": "accRepayTotalAmt"},{"data": "accRepayDate"},{"data": "deductionResult"});
                 }
             }
         })
	 }
	 getDynamicFeeInfo();
	 
	var table = {
        // 表格实例
        defTable: {},
        // 表格参数
        tableParams: {
        },
        init: function () {
            this.renderTable();
            this.bindEvent();

        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            // 点击筛选按钮重绘表格
            $('#searchTable').on('click', function () {
                _this.defTable.draw();
            });
            
            $("#exportAll").on('click',function(){
            	var beginDate= $.trim($('#beginDate').val()) == '' ? null : $.trim($('#beginDate').val());  
            	var endDate= $.trim($('#endDate').val()) == '' ? null : $.trim($('#endDate').val()); 
            	var repayStatus = $("#repayStatus :selected").val();    
                
            	window.open("<%=basePath%>repaySituation/exportAll?beginDate="+beginDate+"&endDate="+endDate+"&repayStatus="+repayStatus);
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
                    // param.start = (data.start / data.length)+1;//当前页码
                    param.start = '${start}' == '' ? (data.start / data.length)+1 : ('${start}' / data.length) + 1;
                    param.draw = data.draw;
                    param.beginDate= $.trim($('#beginDate').val()) == '' ? null : $.trim($('#beginDate').val());
                    param.endDate= $.trim($('#endDate').val()) == '' ? null : $.trim($('#endDate').val());
                    param.repayStatus = $("#repayStatus :selected").val();
                    $.ajax({
                        type: "POST",
                        url: util.getServerUrl('/repaySituation/listPage'),
                        data: $.extend(param,_this.tableParams),  //传入组装的参数
                        dataType: "json",
                        success : function (result) {
                            //封装返回数据
                            if(result.status != 0){
                            	alertModel(result.msg);
                            }else{
	                            var returnData = {};
	                            returnData.draw = result.draw; //返回了draw计数器
	                            returnData.recordsTotal = result.recordsTotal; //返回数据全部记录
	                            returnData.recordsFiltered = result.recordsFiltered; //后台不实现过滤功能，每次查询均视作全部结果
	                            returnData.data = result.data; //返回的数据列表
	                            callback(returnData);
                            }
                        }
                    })
                },
                language: {
                    url: "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
                },
                createdRow: function (row, data, index) {
                	
                },
                lengthMenu: [[10, 20, 30], [10, 20, 30]],
                columns: columns,
                initComplete: function (setting, json) {

                },
                drawCallback: function () {
                    
                }

            })
        },
    }
    
    $(function () {
        table.init();
    })
</script>