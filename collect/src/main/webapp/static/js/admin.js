/**
 * Created by fangyh on 2015/4/20.
 */
dialogMng = {
    htmlContent:{
        outHtml:"<div class='modal bootstrap-dialog type-primary fade size-normal in' id='#dataid'><div class='modal-dialog'><div class='modal-content'>#datacontent</div></div></div>",
        contentHtml:"<div class='modal-header'><div class='bootstrap-dialog-header'><div class='bootstrap-dialog-close-button' style='display: block;font-family: \"Helvetica Neue\";'><button class='close' data-dismiss='modal' aria-label='Close'>×</button></div><div class='bootstrap-dialog-title'>#datatitle</div></div></div><div class='modal-body'>#databody</div><div class='modal-footer'>#databutton</div>",
        closeButtonHtml:"<button type='button' class='btn btn-default' data-dismiss='modal'>取消</button>",
        submitButtonHtml:"<button type='button' data-type='comfirm' class='btn btn-primary'>确认</button>",
        warnTips : "<div class='error-page' style='height: 140px; margin-left: 20px; margin-top: -15px;'><h2 class='headline text-yellow'>#status</h2>"
			+ "<div class='error-content' style='padding-top: 30px;'>"
			+ "<h3><i class='fa fa-warning text-yellow'></i> 对不起! 系统出错了。</h3>"
			+ "<p>请您反馈给系统管理员，我们会尽快解决该问题</p></div></div>"
    },
    dialogHtml:function(targetId){
            return "<div class=\"modal bootstrap-dialog type-primary fade size-normal in\" id=\""+targetId+"\">"
                +"<div class=\"modal-dialog\">"
                +"<div class=\"modal-content\"></div>"
                +"</div></div>"
    },
    basedialog : function(targetid, url, data) {
		var html = this.dialogHtml(targetid);
		$("body").append(html)
		if(data.width){
			$('#' + targetid).find(".modal-dialog").css("width",data.width);
		}
		$.ajax({
			'type' : data.method || "GET",
			'url' : url,
			'data' : data,
			'async' : false,
			'success' : function(data, status) {
				if (status != 'success') {
					$('#' + targetid).modal('hide')
					$('#' + targetid).remove();
					BootstrapDialog.show({
						type : BootstrapDialog.TYPE_WARNING,
						title : '操作提示',
						message : "连接不存在或刷新页面后重新尝试！",
					});
					return;
				} else {
					$("#" + targetid).find(".modal-content").html(data);
					$('#' + targetid).modal({
						keyboard : false,
						backdrop : 'static'
					})
				}
			},
			'error' : function(XmlHttpRequest, textStatus, errorThrown) {
				$('#' + targetid).modal('hide')
				$('#' + targetid).remove();
				BootstrapDialog.show({
					type : BootstrapDialog.TYPE_WARNING,
					title : '操作提示',
					message : dialogMng.htmlContent.warnTips.replace("#status", XmlHttpRequest.status)
				});
				return;
			}
		});
		$('#' + targetid).on('hide.bs.modal', function() {
			$(this).remove();
		})
	},
    basecomfirm: function (obj) {
        var contentHtml = this.htmlContent.contentHtml
        var datatitle = "操作确认";
        var databody = obj.msg;
        var databutton = this.htmlContent.closeButtonHtml+this.htmlContent.submitButtonHtml;
        var htmlText = this.htmlContent.outHtml.replace("#dataid",obj.targetid);
        htmlText = htmlText.replace("#datacontent",contentHtml)
        htmlText = htmlText.replace("#datatitle",datatitle)
        htmlText = htmlText.replace("#databody",databody)
        htmlText = htmlText.replace("#databutton",databutton)
        $("body").append(htmlText)
        $('#'+obj.targetid).modal({
            keyboard:false
            ,backdrop :'static'
        })
        $('#'+obj.targetid).on('hide.bs.modal', function () {
            $(this).remove();
        });
        $('#'+obj.targetid).find("button[data-type='comfirm']").click(function(){
            if(obj.callback)
            {
                obj.callback();
            }
        });
    },
    basemsg:function(targetid,msg){
        var contentHtml = this.htmlContent.contentHtml
        var datatitle = "提示";
        var databody = msg;
        var databutton = this.htmlContent.closeButtonHtml;
        var htmlText = this.htmlContent.outHtml.replace("#dataid",targetid);
        htmlText = htmlText.replace("#datacontent",contentHtml)
        htmlText = htmlText.replace("#datatitle",datatitle)
        htmlText = htmlText.replace("#databody",databody)
        htmlText = htmlText.replace("#databutton",databutton)
        $("body").append(htmlText)
        $('#'+targetid).modal({
            keyboard:false
            ,backdrop :'static'
        })
        $('#'+targetid).on('hide.bs.modal', function () {
           $(this).remove();
        })
    },
    dialog:function(targetid,url,data){
    	if(window.top!=window){
    		window.top.dialogMng.basedialog(targetid,url,data);
    	}else{
    		dialogMng.basedialog(targetid,url,data);
    	}
    },
    comfirm:function(obj){
    	window.top.dialogMng.basecomfirm(obj);
    },
    msg:function(targetid,msg){
    	window.top.dialogMng.basemsg(targetid,msg);
    }
}
function newGuid()
{
    var guid = "";
    for (var i = 1; i <= 32; i++){
      var n = Math.floor(Math.random()*16.0).toString(16);
      guid +=n;
    }
    guid += new Date().getTime();
    return guid.toUpperCase();
}
$(function(){
    $('.user-menu.user').on('mouseover',function () {
        $(this).addClass('open');
    })
    $('.user-menu.user').on('mouseout',function () {
        $(this).removeClass('open');
    })




	$("body").delegate("a[data-target='navTab']","click",function(){
		var url = $(this).attr("href");
		var md = $(this).attr("md");
		if(md=='ajax'){
			
		}else{
			$("#navTab").load(url);
		}
		return false;
	});
    $("body").delegate("*[data-model='dialog']","click",function(){
        var targetid = $(this).data("targetid");
        if(targetid == undefined){
        	targetid = newGuid();
        }
        var width = $(this).data("width");
        var method = $(this).data("method") || "GET";
        var url = $(this).data("url");
        if(!url){
        	url = $(this).attr("href")
        }
        window.top.dialogMng.dialog(targetid,url,{'method':method, 'width'  : width});
        return false;
    });
    $("body").delegate("*[data-model='ajaxToDo']","click",function(){
    	// 改操作分单条/批量数据操作
        var targetid = $(this).data("targetid");
        if(targetid == undefined){
        	targetid = newGuid();
        }
        var url = $(this).data("url");
        if (!url) {
			url = $(this).attr("href")
		}
        var msg = $(this).data("msg");
        var callback = $(this).data("callback");// 回调函数
        var checkboxName = $(this).data("checkboxName"); // 多选框NAME，批量操作时才会有值
        
        var ids = "";
        if (null != checkboxName && checkboxName != 'undefined') {
        	// 批量操作
        	ids = getCheckboxItem(checkboxName);
    		if(ids == ""){
    			BootstrapDialog.show({
					type: BootstrapDialog.TYPE_WARNING,
		            title: '操作提示',
		            message: '请先勾选数据！',
		            onshown: function(dialogRef){
		            	setTimeout(function() {
		            		dialogRef.close();
						}, 1000);
		            }
		        });
    			return false;
    		}
        } else {
        	// 单条数据操作
        }
        
        var obj = {
            targetid:targetid,
            msg:msg
        }
        obj.callback=function(){
            $.ajax({
                url:url,
                data : {
                	"ids" : ids
                },
                dataType:'json',
                success:function(data){
                	$('#'+targetid).modal("hide");
                    if(data.status) {
    	                if(callback)
    	                {
    	                	eval(callback + "()");
    	                }
                        BootstrapDialog.show({
        					type: BootstrapDialog.TYPE_SUCCESS,
        		            title: '操作结果提示',
        		            message: data.msg || "操作成功!",
        		            onshown: function(dialogRef){
        		            	setTimeout(function() {
        		            		dialogRef.close();
        						}, 1000);
        		            }
        		        });
                    }else{
                        BootstrapDialog.show({
        					type: BootstrapDialog.TYPE_WARNING,
        		            title: '操作结果提示',
        		            message: data.msg || "未知错误警告!请您反馈给系统管理员，我们会尽快解决该问题",
        		        });
                    }
                },
                error:function(XmlHttpRequest, textStatus, errorThrown){
                	$('#'+targetid).modal("hide");
                	BootstrapDialog.show({
        				type: BootstrapDialog.TYPE_WARNING,
        	            title: '操作结果提示',
        	            message: dialogMng.htmlContent.warnTips.replace("#status", XmlHttpRequest.status)
        	        });
                }
            });
        }
        dialogMng.comfirm(obj);
        return false;
    });
    $("body").delegate("input:checkbox[data-aim='reselect']","change",function(){
    	var name = $(this).data("name");
    	ReSel(name, $(this).is(':checked'));
		return true;
	});
})

$.fn.gvTables = function(obj){
    $(this).dataTable( {
        "bLengthChange": false,
        "iDisplayLength": 10,
        "bFilter": false,
        "bSort": false,
        "scrollY": "360px",
         "bServerSide": true,
        "scrollCollapse": "true",
        "bProcessing": true,//进度
        "pagingType":   "full_numbers",
        "createdRow": function ( row, data, index ) {
            $('td', row).eq(4).css('font-weight',"bold").css("color","red");
        },
        "columns": [
            { "data": "name", "sWidth": "10%" },
            { "data": "age" },
            { "data": "salary", "sWidth": "20%" },
            { "data": "tel" },
            { "data": "desc" },
            { "data": "id"}
        ],
        "columnDefs": [{
            "render": function(data, type, row) {
                return '<a href="javascript:;"><i title="详情" class="glyphicon glyphicon-zoom-in"></i></a><a href="'+row['id']+'"><i title="修改" class="glyphicon glyphicon-pencil"></i></a><a href="javascript:;"><i title="删除" class="glyphicon glyphicon-trash"></i></a>';
            },
            "targets": 5
        }],
        "sAjaxSource": obj.url+"?" + new Date().getTime(),
        "fnServerData": function (sSource, aDataSet, fnCallback) {
            $.ajax({
                "dataType": 'json',
                "type": "POST",
                "url": sSource,
                "data": aDataSet,
                "success": fnCallback
            });
        },
        "oLanguage": {
            "sProcessing": "正在加载中......",
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sZeroRecords": "正在加载中......",
            "sEmptyTable": "表中无指定条件数据存在！",
            "sInfo": "当前显示 _START_ 到 _END_ 条，共 _TOTAL_ 条记录",
            "sInfoEmpty": "显示0到0条记录",
            "sInfoFiltered": "数据表中共为 _MAX_ 条记录",
            "sSearch": "搜索",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "上一页",
                "sNext": "下一页",
                "sLast": "末页"
            }
        }
    } );
}