package com.nj.model.datamodel;

import java.util.Date;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

/**
 * 导出联系人model
 * @author Administrator
 *
 */
public class NjUserContactModel {
    
    private Date createTime;

    @ExportFormat(name = "联系人",align = ExportFormatConstant.Align.CENTER,sort = 1)
    private String name;
   
    @ExportFormat(name = "联系电话",align = ExportFormatConstant.Align.CENTER,sort = 2)
    private String phoneNo;

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
    
}