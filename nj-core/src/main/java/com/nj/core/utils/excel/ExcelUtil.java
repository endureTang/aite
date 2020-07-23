package com.nj.core.utils.excel;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Excel工具类
 * @author lp
 *
 */
public class ExcelUtil {
	public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";
	public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";
	public static final String EMPTY = "";
	public static final String POINT = ".";
	public static SimpleDateFormat sdf =   new SimpleDateFormat("yyyy/MM/dd");
	/**
	 * 获得path的后缀名
	 * @param path
	 * @return
	 */
	public static String getPostfix(String path){
		if(path==null || EMPTY.equals(path.trim())){
			return EMPTY;
		}
		if(path.contains(POINT)){
			return path.substring(path.lastIndexOf(POINT)+1,path.length());
		}
		return EMPTY;
	}
	/**
	 * 单元格格式
	 * @param hssfCell
	 * @return
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public static String getHValue(HSSFCell hssfCell){
		 if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			 return String.valueOf(hssfCell.getBooleanCellValue());
		 } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			 String cellValue = "";
			 if(HSSFDateUtil.isCellDateFormatted(hssfCell)){				
				 Date date = HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue());
				 cellValue = sdf.format(date);
			 }else{
				 DecimalFormat df = new DecimalFormat("#.##");
				 cellValue = df.format(hssfCell.getNumericCellValue());
				 String strArr = cellValue.substring(cellValue.lastIndexOf(POINT)+1,cellValue.length());
				 if(strArr.equals("00")){
					 cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));
				 }	
			 }
			 return cellValue;
		 } else {
			return String.valueOf(hssfCell.getStringCellValue());
		 }
	}
	/**
	 * 单元格格式
	 * @param xssfCell
	 * @return
	 */
	public static String getXValue(XSSFCell xssfCell){
		 if (xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			 return String.valueOf(xssfCell.getBooleanCellValue());
		 } else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			 String cellValue = "";
			 if(XSSFDateUtil.isCellDateFormatted(xssfCell)){
				 Date date = XSSFDateUtil.getJavaDate(xssfCell.getNumericCellValue());
				 cellValue = sdf.format(date);
			 }else{
				 DecimalFormat df = new DecimalFormat("#.##");
				 cellValue = df.format(xssfCell.getNumericCellValue());
				 String strArr = cellValue.substring(cellValue.lastIndexOf(POINT)+1,cellValue.length());
				 if(strArr.equals("00")){
					 cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));
				 }	
			 }
			 return cellValue;
		 } else {
			return String.valueOf(xssfCell.getStringCellValue());
		 }
	}	
	/**
	 * 自定义xssf日期工具类
	 * @author lp
	 *
	 */
	static class XSSFDateUtil extends DateUtil{
		protected static int absoluteDay(Calendar cal, boolean use1904windowing) {
			return DateUtil.absoluteDay(cal, use1904windowing);
		}
	}
}
