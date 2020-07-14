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

        <div class="row">
            <div class="col-xs-12">
                <div class="statistics clearfix h30"></div>

                <div class="panel panel-default asset-mount-allocation">
                    <div class="panel-heading">
                        <h3 class="panel-title">发标量配置</h3>
                    </div>
                    <div class="panel-body">
                        待发标库总金额低于 <input type="number" class="form-control" id="assetMount"> 元,启动资产筛选规则。
                        <button class="btn btn-primary pull-right" id="saveAssetMount">保存</button>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
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

<script type="text/javascript">
    var table = {
        // 表格实例
        defTable: {},
        // 表格参数
        tableParams: {},
        init: function () {
            this.getData();
            this.bindEvent();
        },
        // 绑定事件
        bindEvent: function () {
            var _this = this;
            $('#saveAssetMount').click(function () {
                _this.saveAssetMount();
            })
        },

        // 保存发标量配置
        saveAssetMount: function () {
            var _this = this, val = $.trim($('#assetMount').val());
            if(val<0){
                this.alertModel('请输入正确的发标量!');
                return;
            }
            $.ajax({
                url: util.getServerUrl('/sysDict/configBuildCorporeLimit'),
                data: {
                    buildCorporeLimit: val
                },
                method: 'POST',
                success: function (res) {
                    if (res.status == 0) {
                        _this.alertModel('保存成功!');
                    } else {
                        if (res.msg == '') {
                            _this.alertModel('保存失败，请稍后重试!');
                        } else {
                            _this.alertModel(res.msg);
                        }
                    }
                },
                error: function (error) {
                    _this.alertModel('保存失败，请稍后重试!');
                }
            })
        },
        // 模态框弹出
        alertModel: function (str) {
            $('#myModal .modal-body').empty().html('<p>' + str + '</p>');
            $('#myModal').modal('show');
        },
        getData: function () {
            var _this = this;
            $.ajax({
                url : util.getServerUrl('/sysDict/getBuildCorporeLimit'),
                method : 'POST',
                success : function (res) {
                    if(res.status==0){
                        if(res.data){
                            $('#assetMount').val(res.data);
                        }
                    }else{
                        _this.alertModel('获取发标量配置值失败!');
                    }
                },
                error : function (error) {
                    _this.alertModel('获取发标量配置值失败!');
                }
            })
        }


    }
    $(document).ready(function () {
        table.init();
    })

</script>