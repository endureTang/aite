<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<section class="content-header">
	<ol class="breadcrumb">
		<li><a href="./"><i class="fa fa-dashboard"></i> 主页</a></li>
		<li class="active">业务管理</li>
		<li><a href="stockBase/page" data-target="navTab">库存汇总</a></li>
	</ol>
</section>
<!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header" id="boxHeader">
					<div class="col-sm-2">
					<select name="type" id="type" class="form-control required">
						<option value="1">模板一</option>
						<option value="2">模板二</option>
						<option value="3">模板三</option>
					</select>
					</div>
					<a type="button" onclick="easyUpload()" id="import"class="btn btn-sm btn-primary" >
						<i class="fa fa-fw fa-plus"></i>导入库存汇总zip
					</a>

					<a onclick="clearData()"
					   class="btn btn-sm btn-custom role-del">
						<i class="fa fa-fw fa-plus"></i>清空数据
					</a>
				</div>

				<div class="box-header">

	<%--				<a type="button" onclick="execZip()" class="btn btn-sm btn-primary" >
						<i class="fa fa-fw fa-plus"></i>执行汇总压缩（xml）
					</a>--%>
					<a type="button" onclick="execCollect()" class="btn btn-sm btn-primary" >
						<i class="fa fa-fw fa-plus"></i>执行汇总压缩
					</a>
					</a>
				</div>
				<!-- /.box-header -->
				<div class="box-body" style="border-top:solid #ACC0D8 1px;width: 100%;margin-top: 10px;">

					<h5>上传的模板zip文件和执行生成文件均会在此展示，点击即可下载。</h5>
					<hr>
					<div >已上传文件：<div id="uploadDiv"></div></div>
					<hr>
					<div >待下载文件：<div id="downloadDiv"></div></div>
				</div>

				<div class="box-body" style="border-top:solid #ACC0D8 1px;width: 100%;margin-top: 10px;">
					<h4>操作说明：</h4>
					<hr>
					<ul>
						<li>操作汇总前，请确保活动文档已经上传，否则无法完成参与活动关联。</li>
						<li>处理过程可以在程序中查看。</li>
						<li>模板：
							<ul>
								<li><label style="color: red">根据PPT三种模板分类，需保证上传压缩zip文件中仅有对应的模板文件，否则将出现程序将报错或者数据紊乱。</label></li>
								<li>下拉框选择模板分类后，点击”导入库存汇总zip“选择压缩文件进行上传。</li>
								<li >这一步操作是后续工作的基础。</li>
								<li><label style="color: red">注意</label>：如果数据量太大，为了避免压缩包过大导致系统内存空间不足，建议分批次压缩，多次上传。</li>
							</ul>
						</li>
						</li>
						<li>执行汇总压缩：
							<ul>
								<li>将上传的模板文件按照给定的格式和不同门店重新生成excel文件，并将生成后的excel文件压缩为zip文件，以供下载。</li>
								<li>同时会将所有上传的文件数据汇总成一个Excel文件，名为”库存汇总.xlsx“，以供下载。</li>
								<li>这一步由于涉及到excel的创建，耗费时间会较长，请耐心等待。</li>
							</ul>
						</li>
						<li>清空数据：删除所有文件和数据。
					</ul>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>
<style type="text/css">
	ul li{
		margin: 10px 0px;
	}
</style>

<script type="text/javascript">

	getDownloadFiles();
	getUploadFiles();

	function easyUpload(){
		var type = $("#type").val();
		var input = document.createElement("input");
		input.type = "file";
		input.click();
		input.onchange = function(){
			MaskUtil.mask("文件上传中...");
			var file = input.files[0];
			var form = new FormData();
			form.append("file", file); //第一个参数是后台读取的请求key值
			form.append("fileName", file.name);
			form.append("type", type);
			var xhr = new XMLHttpRequest();
			var action = "stockCollect/updateZipFile"; //上传服务的接口地址
			xhr.open("POST", action);
			xhr.send(form); //发送表单数据
			xhr.onreadystatechange = function(){
				if(xhr.readyState==4 && xhr.status==200){
					var resultObj = JSON.parse(xhr.responseText);
					if(resultObj.status== 1){
						getUploadFiles();
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_SUCCESS,
							title: '操作结果提示',
							message: "上传完毕",
						});
					}else{
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_WARNING,
							title: '操作结果提示',
							message: "上传出错，"+resultObj.msg,
						});
					}
					MaskUtil.unmask();
				}
			}
		}
	}

	//将所有上传的门店数据按照门店名称分别生成excel并压缩
	function execZip(){
		MaskUtil.mask("请耐心等待，执行zip压缩中...");
		$.ajax({
			url:'stockCollect/execZip',
			dataType:'json',
			type:'POST',
			processData : false, // 使数据不做处理
			contentType : false, // 不要设置Content-Type请求头
			success: function(data){
				MaskUtil.unmask();
				if (data.status == '1') {
					$("#downLoadZip").show();
					getDownloadFiles();
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_SUCCESS,
						title: '操作结果提示',
						message: "后端程序执行中，请耐心等待",
					});
				}else{
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_WARNING,
						title: '操作结果提示',
						message: data.msg,
					});
				}
			},
			error:function(response){
				MaskUtil.unmask();
				console.log(response);
			}
		});
	}

	//生成汇总excel
	function execCollect(){
		MaskUtil.mask("请耐心等待，生成总库存中...");
		$.ajax({
			url:'stockCollect/execZipAndExcel',
			dataType:'json',
			type:'POST',
			processData : false, // 使数据不做处理
			contentType : false, // 不要设置Content-Type请求头
			success: function(data){
				MaskUtil.unmask();
				console.log(data);
				if (data.status == '1') {
					$("#downLoadCollect").show();
					getDownloadFiles();
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_SUCCESS,
						title: '操作结果提示',
						message: "处理完成，耗时"+data.msg,
					});
				}else{
					BootstrapDialog.show({
						type: BootstrapDialog.TYPE_WARNING,
						title: '操作结果提示',
						message: data.msg,
					});
				}
			},
			error:function(response){
				MaskUtil.unmask();
				console.log(response);
			}
		});
	}

	function clearData(){
		if(confirm("确认清空数据？")){
			MaskUtil.mask("数据清除中...");
			$.ajax({
				url:'stockCollect/clearStockCollectAndFiles',
				dataType:'json',
				type:'POST',
				success: function(data){
					MaskUtil.unmask();
					if (data.status == '1') {
						getUploadFiles();
						getDownloadFiles();
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_SUCCESS,
							title: '操作结果提示',
							message: "数据已清空",
						});
					}else{
						BootstrapDialog.show({
							type: BootstrapDialog.TYPE_WARNING,
							title: '操作结果提示',
							message: "数据清空失败，"+data.msg,
						});
					}
				},
				error:function(response){
					MaskUtil.unmask();
					console.log(response);
				}
			});
		}

	}

	//获取已经上传的文件
	function getUploadFiles(){
		$("#uploadDiv").html();
		$.ajax({
			url:'stockCollect/getUploadFiles',
			dataType:'json',
			type:'POST',
			success: function(data){
				if (data.status == '1') {
					const files = data.files;
					let tempStr = "";
					$.each(files,function(index,element){
						tempStr +="<a style='margin-right: 10px;' href="+element.filePath+">"+element.fileName+"</a>"
					});
					$("#uploadDiv").html(tempStr);
				}
			}
		});
	}
	//获取已经生成待下载的文件
	function getDownloadFiles(){
		$.ajax({
			url:'stockCollect/getDownloadFiles',
			dataType:'json',
			type:'POST',
			success: function(data){
				if (data.status == '1') {
					const files = data.files;
					let tempStr = "";
					$.each(files,function(index,element){
						tempStr +="<a style='margin-right: 10px;' href="+element.filePath+">"+element.fileName+"</a>"
					});
					$("#downloadDiv").html(tempStr);
				}
			}
		});
	}

</script>

<script type="text/javascript">
	/**
	 * 使用方法:
	 * 开启:MaskUtil.mask();
	 * 关闭:MaskUtil.unmask();
	 *
	 * MaskUtil.mask('其它提示文字...');
	 */

// MaskUtil Start

	var MaskUtil = (function(){
		var $mask,$maskMsg;
		var defMsg = '处理中，请耐心等待...';
		function init(){
			if(!$mask){
				$mask = $("<div></div>")

						.css({
							'position' : 'absolute'

							,'left' : '0'

							,'top' : '0'

							,'width' : '100%'

							,'height' : '100%'

							,'opacity' : '0.3'

							,'filter' : 'alpha(opacity=30)'

							,'display' : 'none'

							,'background-color': '#ccc'

						})

						.appendTo("body");

			}

			if(!$maskMsg){
				$maskMsg = $("<div></div>")
						.css({
							'position': 'absolute'

							,'top': '50%'

							,'margin-top': '-20px'

							,'padding': '5px 20px 5px 20px'

							,'width': 'auto'

							,'border-width': '1px'

							,'border-style': 'solid'

							,'display': 'none'

							,'background-color': '#ffffff'

							,'font-size':'14px'

						})

						.appendTo("body");

			}

			$mask.css({width:"100%",height:$(document).height()});

			var scrollTop = $(document.body).scrollTop();

			$maskMsg.css({
				left:( $(document.body).outerWidth(true) - 190 ) / 2

				,top:( ($(window).height() - 45) / 2 ) + scrollTop

			});

		}

		return {
			mask:function(msg){
				init();

				$mask.show();

				$maskMsg.html(msg||defMsg).show();

			}

			,unmask:function(){
				$mask.hide();

				$maskMsg.hide();

			}

		}

	}());
</script>