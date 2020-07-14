package com.nj.model.generate;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

/**
 * 导出用
 * 不用原生实体类，是因为以后增删字段时会重新通过数据库自动生成实体类，我们加入的注解需要重新添加
 */
public class NjUserRelativeForExport {

	@ExportFormat(name = "电话号码",align = ExportFormatConstant.Align.CENTER,sort = 3)
	private String relativeMobile;

	@ExportFormat(name = "姓名",sort = 1)
	private String relativeName;

//	@ExportFormat(name="关系",sort = 2)
//	private String relativeType;

	public String getRelativeMobile() {
		return relativeMobile;
	}

	public void setRelativeMobile(String relativeMobile) {
		this.relativeMobile = relativeMobile;
	}

	public String getRelativeName() {
		return relativeName;
	}

	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

//	public String getRelativeType() {
//		return relativeType;
//	}
//
//	public void setRelativeType(String relativeType) {
//		this.relativeType = relativeType;
//	}
	
	public void copyProperties(NjUserRelatives ur){
		this.relativeMobile = ur.getRelativeMobile();
		this.relativeName = ur.getRelativeName();
//		this.relativeType = ur.getRelativeType();
	}

}
