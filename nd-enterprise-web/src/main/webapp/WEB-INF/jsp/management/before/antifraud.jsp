<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", -10);
%>
<link rel="stylesheet" href="<%=basePath%>static/css/order/order_list.css">
<div class="container-fluid">
    <section class="content">
        <div class="row toolbar">
            <div class="col-xs-12">
                <input id="search" class="form-control" type="text" placeholder="姓名,电话,身份证">
                <button class="btn" id="searchTable">筛选</button>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <div class="box">
                    <div class="box-body">
                        <table id="default_table" class="table table-primary table-hover table-striped my-table">
                            <thead>
	                            <tr>
	                                <th>序号</th>
	                                <th>姓名</th>
	                                <th>电话</th>
	                                <th>身份证</th>
	                                <th>同盾分</th>
	                                <th>审核结果</th>
	                                <th>操作</th>
	                            </tr>
                            </thead>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->
    </section>
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
<script>
    var table = {
        // 表格实例
        defTable: {},
        // 表格参数
        tableParams : {},
        init: function () {
            this.renderTable();
            this.bindEvent();
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
                        url: util.getServerUrl('/loanOrder/antiFraudPage'),
                        data: $.extend(param,_this.tableParams),  //传入组装的参数
                        dataType: "json",
                        success : function (result) {
                        	 //封装返回数据
                            var returnData = {};
                            returnData.draw = result.draw; //返回了draw计数器
                            returnData.recordsTotal = result.recordsTotal;//返回数据全部记录
                            returnData.recordsFiltered = result.recordsFiltered;//后台不实现过滤功能，每次查询均视作全部结果
                            returnData.data = result.data;//返回的数据列表
                            callback(returnData);
                        }
                    })
                },
                language: {
                    url: "<%=basePath%>static/AdminLTE/plugins/datatables/cn.txt"
                },
                createdRow: function (row, data, index) {
                    $('td:eq(0)', row).html(index + 1);
                    
                    if(data.fraudType == '0'){
                    	 $('td:eq(5)', row).html("未审核");
                    }else if(data.fraudType == '1'){
                    	$('td:eq(5)', row).html("已通过");
                    }else if(data.fraudType == '2'){
                    	$('td:eq(5)', row).html("不通过");
                    }else{
                    	$('td:eq(5)', row).html("xx");
                    }
                    
                    
                    $('td:eq(6)', row).html("<input type='button' id='adopt' value='通过' onclick='adopt(\""+data.id+"\")'/>"
				    						+"&nbsp;"
				    						+"<input type='button' id='reject' value='拒绝' onclick='reject(\""+data.id+"\")'/>");
                },
                lengthMenu: [[10, 20, 30], [10, 20, 30]],
                columns: [
                    {"data": "id"},
                    {"data": "name"},
                    {"data": "mobile"},
                    {"data": "identifyId"},
                    {"data": "tdScore"},
                    {"data": "fraudType"},
                    {"data": "null"}
                ],
                initComplete: function (setting, json) {

                }
            })
        },
        // 绑定事件
        bindEvent : function () {
            var _this = this;
            // 点击筛选按钮重绘表格
            $('#searchTable').on('click',function () {
                _this.tableParams = {
                    queryCondition : $.trim($('#search').val())==''?null:$.trim($('#search').val()),
                };
                _this.defTable.draw();
            });
            
        }
    }
	
 	// 模态框弹出
    function alertModel (str) {
        $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
        $('#myModal').modal('show');
    }
    //通过
    function adopt(id){
    	$.ajax({
            type: "POST",
            url: util.getServerUrl('/loanOrder/adopt'),
            data: {userId:id},  //传入组装的参数
            success : function (result) {
            	if (result.status == 0) {
                    alertModel('通过成功!');
                    setTimeout(function () {
                        $('#myModal').modal('hide');
                    }, 1000)
                    $('#myModal').on('hidden.bs.modal', function (e) {
                    	$('#navTab').load('<%=basePath%>loanOrder/antiFraudPage');
                    })
                } else {
                    if (result.msg == '') {
                        alertModel('通过失败，请联系管理员!');
                    } else {
                        alertModel(res.msg);
                    }
                }
            }
        })
    }
    //拒绝
    function reject(id){
    	$.ajax({
            type: "POST",
            url: util.getServerUrl('/loanOrder/reject'),
            data: {userId:id},  //传入组装的参数
            dataType: "json",
            success : function (result) {
            	if (result.status == 0) {
                    alertModel('拒绝成功!');
                    setTimeout(function () {
                        $('#myModal').modal('hide');
                    }, 1000)
                    $('#myModal').on('hidden.bs.modal', function (e) {
                    	$('#navTab').load('<%=basePath%>loanOrder/antiFraudPage');
                    })
                } else {
                    if (result.msg == '') {
                        alertModel('reject失败，请联系管理员!');
                    } else {
                        alertModel(res.msg);
                    }
                }
            }
        })
    }
    
    $(function () {
        table.init();
    })
</script>
</body>
</html>