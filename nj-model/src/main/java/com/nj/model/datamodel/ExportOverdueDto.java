package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

/**
 * 
 * @Name com.nj.model.datamodel.ExportOrderModel
 * @Description 导出订单model
 * 
 * @Author bruce
 * @Version 2018年2月8日 下午4:38:26
 * @Copyright 金鼎财富
 *
 */
public class ExportOverdueDto {
	@ExportFormat(name = "放款月份",align = ExportFormatConstant.Align.CENTER,sort = 1)
	private String month;
	@ExportFormat(name = "VINTAGE",align = ExportFormatConstant.Align.CENTER,sort = 2)
	private String vintage;
	@ExportFormat(name = "1月",align = ExportFormatConstant.Align.CENTER,sort = 3,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double one;
	@ExportFormat(name = "2月",align = ExportFormatConstant.Align.CENTER,sort = 4,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double two;
	
	@ExportFormat(name = "3月",align = ExportFormatConstant.Align.CENTER,sort = 5,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double three;
	
	@ExportFormat(name = "4月",align = ExportFormatConstant.Align.CENTER,sort = 6,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double four;
	
	@ExportFormat(name = "5月",align = ExportFormatConstant.Align.CENTER,sort = 7,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double five;
	
	@ExportFormat(name = "6月",align = ExportFormatConstant.Align.CENTER,sort = 8,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double six;
	
	@ExportFormat(name = "7月",align = ExportFormatConstant.Align.CENTER,sort = 9,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double seven;
	
	@ExportFormat(name = "8月",align = ExportFormatConstant.Align.CENTER,sort = 10,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double eight;
	
	@ExportFormat(name = "9月",align = ExportFormatConstant.Align.CENTER,sort = 11,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double nine;
	
	@ExportFormat(name = "10月",align = ExportFormatConstant.Align.CENTER,sort = 12,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double ten;
	
	@ExportFormat(name = "11月",align = ExportFormatConstant.Align.CENTER,sort = 13,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double eleven;
	
	@ExportFormat(name = "12月",align = ExportFormatConstant.Align.CENTER,sort = 14,formatType=ExportFormatConstant.FormatType.NUMBER,formatTypeValue=ExportFormatConstant.FormatTypeValue.NUMBER_4)
	private Double twelve;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getVintage() {
		return vintage;
	}

	public void setVintage(String vintage) {
		this.vintage = vintage;
	}

	public Double getOne() {
		return one;
	}

	public void setOne(Double one) {
		this.one = one;
	}

	public Double getTwo() {
		return two;
	}

	public void setTwo(Double two) {
		this.two = two;
	}

	public Double getThree() {
		return three;
	}

	public void setThree(Double three) {
		this.three = three;
	}

	public Double getFour() {
		return four;
	}

	public void setFour(Double four) {
		this.four = four;
	}

	public Double getFive() {
		return five;
	}

	public void setFive(Double five) {
		this.five = five;
	}

	public Double getSix() {
		return six;
	}

	public void setSix(Double six) {
		this.six = six;
	}

	public Double getSeven() {
		return seven;
	}

	public void setSeven(Double seven) {
		this.seven = seven;
	}

	public Double getEight() {
		return eight;
	}

	public void setEight(Double eight) {
		this.eight = eight;
	}

	public Double getNine() {
		return nine;
	}

	public void setNine(Double nine) {
		this.nine = nine;
	}

	public Double getTen() {
		return ten;
	}

	public void setTen(Double ten) {
		this.ten = ten;
	}

	public Double getEleven() {
		return eleven;
	}

	public void setEleven(Double eleven) {
		this.eleven = eleven;
	}

	public Double getTwelve() {
		return twelve;
	}

	public void setTwelve(Double twelve) {
		this.twelve = twelve;
	}
	
}
