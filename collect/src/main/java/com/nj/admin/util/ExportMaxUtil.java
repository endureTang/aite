package com.nj.admin.util;

import com.nj.core.base.util.StringUtils;
import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;
import com.nj.core.utils.excel.FreeExportParam;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class ExportMaxUtil {

	private static Logger log = LoggerFactory.getLogger(ExportMaxUtil.class);

	private static SXSSFWorkbook workbook;
	
	private static SimpleDateFormat sdf_date;
	private static SimpleDateFormat sdf_time;
	private static SimpleDateFormat sdf_datetime;
	private static SimpleDateFormat sdf_timestamp;
	
	private static String fileDirpath = ExportMaxUtil.class.getResource("/").getPath() + "temp" + File.separator + "relative";

	/**
	 * 基础导出创建数据行
	 */
	private static <T> void baseCreateData(List<T> datas, int columnNum,  List<ExportFormat> formatList, int rowIndex,String[] fieldNameArray,  Sheet sheet){
		//创建数据行
		try {
			int count = 0;
			int times = 0;
			for (T data : datas) {
				count ++;
				if(count %10000 ==0){
					times++;
					System.out.println("已处理"+times+"万条数据！");
				}
				Row dataRow = sheet.createRow(rowIndex++);
				for (int i = 0; i < columnNum; i++) {
					Cell dataCell = dataRow.createCell(i);
					//得到要显示的值
					String name = fieldNameArray[i];
					name = name.substring(0, 1).toUpperCase() + name.substring(1);
					Method m = data.getClass().getMethod("get" + name);
					Object result = m.invoke(data);
					if(null != result){
						dataCell.setCellValue(result.toString());
					}else{
						dataCell.setCellValue("");
					}
				}
			}
		} catch (Exception e) {
			log.error("创建行数据时发生异常，异常信息为：",e);
			e.printStackTrace();
		}
	}






	
	/**
	 * 对集合排序
	 */
	public static Object[] sort(List<ExportFormat> efList){

		List<Integer> list = new ArrayList<Integer>();
		List<ExportFormat> ef = new ArrayList<ExportFormat>();

		Map<Integer,ExportFormat> map = new HashMap<Integer,ExportFormat>();
		for (ExportFormat exportFormat : efList) {
			map.put(exportFormat.sort(), exportFormat);
			list.add(exportFormat.sort());
		}

		Collections.sort(list);

		Map<Integer,Integer> sortMap = new HashMap<Integer,Integer>();
		int index = 0;
		for (Integer integer : list) {
			ef.add(map.get(integer));
			sortMap.put(integer, index++);
		}

		Object [] result = new Object[2];
		result[0] = ef;
		result[1] = sortMap;

		return result;
	}

	/**
	 * 库存汇总
	 * @param datas	导出的数据集合
	 * @param clazz	导出对象的Class对象
	 * @param filename	文件名称
	 * @param sheetname	sheet名称
	 */
	@SuppressWarnings("unchecked")
	public static <T> void baseExportStockCollect(String savePath,List<T> datas,
									  Class<T> clazz,
									  String filename,
									  String sheetname) throws Exception{
		int columnNum = 0;		//要导出的数据列数
		List<ExportFormat> formatList = new ArrayList<ExportFormat>();	//注解信息

		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			ExportFormat exportFormat = fields[i].getAnnotation(ExportFormat.class);
			if(null != exportFormat){
				++columnNum;
				formatList.add(exportFormat);
			}
		}
		Object[] rs = sort(formatList);
		formatList = (List<ExportFormat>)rs[0];
		Map<Integer,Integer> sortMap = (Map<Integer, Integer>) rs[1];

		String[] tableHeaderArray = new String[columnNum];		//表头
		String[] fieldNameArray = new String[columnNum];		//要导出的列名

		for (int i = 0; i < fields.length; i++) {
			ExportFormat exportFormat = fields[i].getAnnotation(ExportFormat.class);
			if(null != exportFormat){
				int index = sortMap.get(exportFormat.sort());
				tableHeaderArray[index] = exportFormat.name();
				fieldNameArray[index] = fields[i].getName();
			}
		}
		try {
			int rowIndex = 0;		//行索引
			//创建workbook和sheet
			workbook = new SXSSFWorkbook(200000);
			Sheet sheet = workbook.createSheet(sheetname);
			//创建表头行
			Row tableHeaderRow = sheet.createRow(rowIndex++);
			for (int i = 0; i < columnNum; i++) {
				Cell cell = tableHeaderRow.createCell(i);
				cell.setCellValue(tableHeaderArray[i]);
			}
			if(CollectionUtils.isNotEmpty(datas)){
				//创建数据行
				baseCreateData(datas, columnNum, formatList, rowIndex++, fieldNameArray, sheet);

			}

//			//将数据以20w为一个sheet进行excel创建
//			int pageSize = 200000;
//			int sheetCount = datas.size() % pageSize == 0 ? datas.size() / pageSize :datas.size() % pageSize +1;
//			for (int sheetNo = 0; sheetNo < sheetCount; sheetNo++) {
//				System.out.println("创建第"+sheetNo+1+"个sheet");
//				List<T> tempList = datas.stream().skip(sheetNo*pageSize).limit(pageSize).collect(Collectors.toList());
//				Sheet sheet = workbook.createSheet(sheetname+sheetNo);
//				//创建表头行
//				Row tableHeaderRow = sheet.createRow(rowIndex++);
//				for (int i = 0; i < columnNum; i++) {
//					Cell cell = tableHeaderRow.createCell(i);
//					cell.setCellValue(tableHeaderArray[i]);
//				}
//				if(CollectionUtils.isNotEmpty(datas)){
//					//创建数据行
//					baseCreateData(tempList, columnNum, formatList, rowIndex++, fieldNameArray, sheet);
//
//				}
//			}


			File file = new File(savePath);
			if(!file.exists()){
				file.mkdirs();
			}
			file = new File(savePath + File.separator + filename);
			if(!file.exists()){
				file.createNewFile();
			}

			OutputStream out = new FileOutputStream(file);
			workbook.write(out);
		} catch (Exception e) {
			log.error("门店"+filename+"创建行数据时发生异常，异常信息为：",e);
			e.printStackTrace();
			return;
		}
	}
}
