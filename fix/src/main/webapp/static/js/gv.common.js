//获得选中项 返回字符串
function getCheckboxItem(checkBoxName) {
	var allSel = "";
	var ids = $("input[name='" + checkBoxName + "']");

	$(ids).each(function(i) {
		if (this.disabled == false) {
			if (this.checked) {
				if (allSel == "")
					allSel = this.value;
				else
					allSel = allSel + "," + this.value;
			}
		}
	});
	return allSel;
}
// 获取checkbox或者radio值
function getiCheckItem(name) {
    var arr = [];
    var ids = $('input[name="' + name + '"]');
    ids.each(function () {
        if (this.checked) {
            arr.push(this.value);
        }
    })
    return arr;
}
function drawICheck(cId, oName) {
	var cCheck = $('#' + cId);
	var oChecks = $('.table input[name="' + oName + '"]');

	// Enable iCheck plugin for checkboxes
	// iCheck for checkbox and radio inputs
	cCheck.iCheck({
		checkboxClass : 'icheckbox_minimal-blue my-check',
		// increaseArea : '20%' // optional
	});

	oChecks.iCheck({
		checkboxClass : 'icheckbox_minimal-blue my-check',
		radioClass : 'iradio_flat-blue'
	});

	cCheck.on('ifChanged', function(event) {
		if ($(this).is(':checked')) {
			oChecks.iCheck("check");
		} else {
			oChecks.iCheck("uncheck");
		}

	});
}
function initSearchForm(others, placeholderText) {
	others = others || "";
	placeholderText = placeholderText || "关键字搜索";
	$("#boxHeader")
			.prepend(
					others
							+ '<div class="input-group input-group-sm input-adjust search-container">'
							+ '<input type="text" placeholder="' + placeholderText + '" name="keyword" id="keyword" class="form-control">'
							+ '<span class="input-group-btn">'
							+ '<button type="button" class="btn btn-primary btn-flat btn-custom" id="mybtn" onclick="javacript:refreshTable(1);">搜索</button>'
							+ '</span>' + '</div>');
	$("#boxHeader").keydown(function(e) {
		var curKey = e.which;
		if (curKey == 13) {
			$("#mybtn").click();
			return false;
		}
	});
}


htmlTpl = {
	dropdown : {
		prefix : '<div class="btn-group">'
				+ '<a title="更多操作" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-lg fa-cog"></i></a>'
				+ '<ul role="menu" class="dropdown-menu">',
		suffix : '</ul></div>',
	}
}
