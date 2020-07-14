package com.nj.core.utils.excel;

import java.util.List;

/**
 * 自由导出方法传入的参数类
 */
public class FreeExportParam {

	private String filename;					//导出文件的名称
	private String sheetname;					//导出excel中sheet的名称
	private String titlename;					//导出文件的标题
	private List<String> tableHeaderList;		//导出文件的表头
	private List<List<String>> datas;			//导出文件的数据
	private List<String> alignList;				//数据的对齐方式
	private List<String> formatTypeList;		//格式化类型
	private List<String> formatTypeValueList;	//格式化值。当格式化类型为数值和时间时，该字段必须传值
	  
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getSheetname() {
		return sheetname;
	}
	public void setSheetname(String sheetname) {
		this.sheetname = sheetname;
	}
	public String getTitlename() {
		return titlename;
	}
	public void setTitlename(String titlename) {
		this.titlename = titlename;
	}
	public List<String> getTableHeaderList() {
		return tableHeaderList;
	}
	public void setTableHeaderList(List<String> tableHeaderList) {
		this.tableHeaderList = tableHeaderList;
	}
	public List<List<String>> getDatas() {
		return datas;
	}
	public void setDatas(List<List<String>> datas) {
		this.datas = datas;
	}
	public List<String> getAlignList() {
		return alignList;
	}
	public void setAlignList(List<String> alignList) {
		this.alignList = alignList;
	}
	public List<String> getFormatTypeList() {
		return formatTypeList;
	}
	public void setFormatTypeList(List<String> formatTypeList) {
		this.formatTypeList = formatTypeList;
	}
	public List<String> getFormatTypeValueList() {
		return formatTypeValueList;
	}
	public void setFormatTypeValueList(List<String> formatTypeValueList) {
		this.formatTypeValueList = formatTypeValueList;
	}
}
