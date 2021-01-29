package com.nj.core.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nj.core.base.util.StringUtils;

public class ExportUtil {

	private static Logger log = LoggerFactory.getLogger(ExportUtil.class);

	private static XSSFWorkbook workbook;
	
	private static SimpleDateFormat sdf_date;
	private static SimpleDateFormat sdf_time;
	private static SimpleDateFormat sdf_datetime;
	private static SimpleDateFormat sdf_timestamp;
	
	private static String fileDirpath = ExportUtil.class.getResource("/").getPath() + "temp" + File.separator + "relative";
	
	/**
	 * 基础导出方法
	 * @param datas	导出的数据集合
	 * @param clazz	导出对象的Class对象
	 * @param filename	文件名称
	 * @param sheetname	sheet名称
	 * @param titlename	主题名称
	 * @param response	相应对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> void baseExport(List<T> datas,
									 Class<T> clazz,
									 String filename,
									 String sheetname,
									 String titlename,
									 HttpServletResponse response) throws Exception{

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
			workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(sheetname);
			
			//创建标题行
//			rowIndex = createTitle(columnNum, rowIndex, sheet ,titlename);
			
			//创建表头行
			rowIndex = createHeader(columnNum, rowIndex, tableHeaderArray, sheet);
			
			if(CollectionUtils.isNotEmpty(datas)){
				//创建数据行
				baseCreateData(datas, columnNum, formatList, rowIndex, fieldNameArray, sheet);
			}
			
			File file = new File(fileDirpath);
			if(!file.exists()){
				file.mkdirs();
			}
			file = new File(fileDirpath + File.separator + filename);
			if(!file.exists()){
				file.createNewFile();
			}
			
			OutputStream out = new FileOutputStream(file);
			workbook.write(out);
		} catch (Exception e) {
			log.error("创建行数据时发生异常，异常信息为：",e);
			e.printStackTrace();
			return;
		} 
		
		//下载
		download(fileDirpath, filename, response);
	}
	
	/**
	 * 自由导出
	 * @param freeExportParam {@link FreeExportParam}
	 * @param response
	 * @throws Exception 
	 */
	public static void freeExport(FreeExportParam freeExportParam,HttpServletResponse response) throws Exception{
		
		//验证参数的合法性
		freeExportParamValidate(freeExportParam);
		
		//生成excel文档
		try {
			int rowIndex = 0;		//行索引
			int columnNum = freeExportParam.getTableHeaderList().size();	//导出的列数
			//创建workbook和sheet
			workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet(freeExportParam.getSheetname());
			
			//创建标题行
			rowIndex = createTitle(columnNum, rowIndex, sheet ,freeExportParam.getTitlename());
			
			//创建表头行
			List<String> tableHeadList = freeExportParam.getTableHeaderList();
			String[] tableHeaderArray = new String[tableHeadList.size()];
			tableHeadList.toArray(tableHeaderArray);
			rowIndex = createHeader(columnNum, rowIndex, tableHeaderArray, sheet);
			
			if(CollectionUtils.isNotEmpty(freeExportParam.getDatas())){
				//创建数据行
				freeExportCreateData(freeExportParam, columnNum, rowIndex, sheet);
			}
			
			File file = new File(fileDirpath);
			if(!file.exists()){
				file.mkdirs();
			}
			file = new File(fileDirpath + File.separator + freeExportParam.getFilename());
			if(!file.exists()){
				file.createNewFile();
			}
			
			OutputStream out = new FileOutputStream(file);
			workbook.write(out);
		} catch (Exception e) {
			log.error("创建行数据时发生异常，异常信息为：",e);
			e.printStackTrace();
			return;
		} 
		
		//下载
		download(fileDirpath, freeExportParam.getFilename(), response);
	}

	
	
	/**
	 * 基础导出创建数据行
	 */
	private static <T> void baseCreateData(List<T> datas, int columnNum,  List<ExportFormat> formatList, int rowIndex,String[] fieldNameArray,  XSSFSheet sheet){
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
				XSSFRow dataRow = sheet.createRow(rowIndex++);
				for (int i = 0; i < columnNum; i++) {
					XSSFCell dataCell = dataRow.createCell(i);
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
	 * 创建excel的title
	 */
	private static int createTitle(int columnNum, int rowIndex, XSSFSheet sheet, String titlename) {
		//创建标题行
		XSSFRow titleRow = sheet.createRow(rowIndex++);
		for (int i = 0; i < columnNum; i++) {
			sheet.setColumnWidth(i, 30 * 150);			//设置每列的宽度,以一个字符的1/256作为单位
		}

		//为标题行设置样式
		XSSFCellStyle titleCellType = workbook.createCellStyle();
		titleCellType.setAlignment(XSSFCellStyle.ALIGN_CENTER);			//水平对齐
		titleCellType.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);	//垂直对齐
		
		titleCellType.setWrapText(true);				//数据过多，自动换行
		
		XSSFFont titleFont = workbook.createFont();
		titleFont.setBold(true);						//加粗
		titleFont.setFontName("Courier New");			//字体样式
//		titleFont.setItalic(true);						//斜体字
		titleFont.setFontHeightInPoints((short)18);		//设置字体大小
		
		titleCellType.setFont(titleFont);
		
		for (int i = 0; i < columnNum; i++) {
			XSSFCell cell = titleRow.createCell(i);
			if(0 == i){
				cell.setCellValue(titlename);
			}
			cell.setCellStyle(titleCellType);
		}
		
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, columnNum-1));
		return rowIndex;
	}
	
	/**
	 * 创建表头信息
	 */
	private static int createHeader(int columnNum, int rowIndex, String[] tableHeaderArray, XSSFSheet sheet) {
		//创建表头行
		XSSFRow tableHeaderRow = sheet.createRow(rowIndex++);
		
		XSSFCellStyle tableHeaderStyle = workbook.createCellStyle();
		tableHeaderStyle.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		tableHeaderStyle.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		
		XSSFFont tableHeaderFont = workbook.createFont();
//		tableHeaderFont.setBold(true);
//		tableHeaderFont.setItalic(true);
		tableHeaderFont.setFontName("Courier New");
		tableHeaderFont.setFontHeightInPoints((short)14);
		
		tableHeaderStyle.setFont(tableHeaderFont);
		
		for (int i = 0; i < columnNum; i++) {
			XSSFCell cell = tableHeaderRow.createCell(i);
			cell.setCellValue(tableHeaderArray[i]);
			cell.setCellStyle(tableHeaderStyle);
		}
		return rowIndex;
	}
	
	/**
	 * 得到数据格式类型
	 */
	private static XSSFCellStyle getDataCellType(String align){
		if(StringUtils.isNotEmpty(align)){
			XSSFCellStyle cellType = workbook.createCellStyle();
			if(align.equals(ExportFormatConstant.Align.CENTER)){
				cellType.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			}else if(align.equals(ExportFormatConstant.Align.LEFT)){
				cellType.setAlignment(XSSFCellStyle.ALIGN_LEFT);
			}else if(align.equals(ExportFormatConstant.Align.RIGHT)){
				cellType.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
			}
			cellType.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
			
			return cellType;
		}
		return null;
	}
	
	/**
	 * 格式化数据
	 * @param formatType
	 * @param formatTypeValue
	 * @param value
	 * @return
	 */
	private static String format(String formatType,String formatTypeValue,Object value){
		
		 if(formatType.equals(ExportFormatConstant.FormatType.NUMBER)){
			 if(value instanceof BigDecimal){
				 if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.INT)){
					 return String.valueOf(((BigDecimal) value).intValue());
				 }else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.NOTHING)){
					 return value.toString();
				 }else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.NUMBER_2)){
					 BigDecimal bg_2 = (BigDecimal)value;
					 return bg_2.setScale(2,BigDecimal.ROUND_HALF_DOWN).toString();
				 }else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.NUMBER_4)){
					 BigDecimal bg_4 = (BigDecimal)value;
					 return bg_4.setScale(4,BigDecimal.ROUND_HALF_DOWN).toString();
				 }else{
					 return value.toString();
				 }
			 }else{
				 if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.INT)){
					 return String.valueOf(Double.valueOf(value.toString()).intValue());
				 }else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.NOTHING)){
					 return value.toString();
				 }else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.NUMBER_2)){
					 BigDecimal bg_2 = new BigDecimal(value.toString());
					 return bg_2.setScale(2,BigDecimal.ROUND_HALF_DOWN).toString();
				 }else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.NUMBER_4)){
					 BigDecimal bg_4 = new BigDecimal(value.toString());
					 return bg_4.setScale(4,BigDecimal.ROUND_HALF_DOWN).toString();
				 }else{
					 return value.toString();
				 }
			 }
			
		}else if(formatType.equals(ExportFormatConstant.FormatType.TIME)){
			initDateFormat();
			
			Date date = (Date) value;
			
			if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.DATE)){
				return sdf_date.format(date);
			}else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.TIME)){
				return sdf_time.format(date);
			}else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.DATETIME)){
				return sdf_datetime.format(date);
			}else if(formatTypeValue.equals(ExportFormatConstant.FormatTypeValue.TIMESTAMP)){
				return sdf_timestamp.format(date);
			}else{
				return "";
			}
		}else{
			return "";
		}
	}
	
	/**
	 * 初始化时间格式化工具
	 */
	private static void initDateFormat(){
		if(null == sdf_date){
			sdf_date = new SimpleDateFormat("yyyy-MM-dd");
		}else if(null == sdf_datetime){
			sdf_date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		}else if(null == sdf_time){
			sdf_date = new SimpleDateFormat("hh:mm:ss");
		}else if(null == sdf_timestamp){
			sdf_date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss sss");
		}
	}
	
	/**
	 * 下载
	 */
	public static void download(String fileDirpath, String filename, HttpServletResponse response)
			throws Exception, IOException {
		response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(filename, "UTF-8"));
		response.setContentType("application/vnd.ms-excel");
		
		InputStream is = null;
		OutputStream out = null;
		try {
			is = new FileInputStream(new File(fileDirpath + File.separator + filename));
			out = response.getOutputStream();
			byte[] buffer = new byte[40960];
			int byteCount = is.read(buffer);
			while (byteCount > 0) {
				out.write(buffer, 0, byteCount);
				byteCount = is.read(buffer);
			}
			out.flush();
		}catch(Exception e){
			throw e;
		}finally {
			if (is != null)
				is.close();
			if (out != null)
				out.close();
			
			File file = new File(fileDirpath + File.separator + filename);
			file.delete();
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
	 * 对自由导出传入参数的合法性进行验证
	 * @param freeExportParam
	 * @throws Exception
	 */
	private static void freeExportParamValidate(FreeExportParam freeExportParam) throws Exception {
		// 验证参数是否合法
		List<String> tableHeaderList = freeExportParam.getTableHeaderList();
		if(null == tableHeaderList){
			throw new Exception("表头为空");
		}
		int colNum = tableHeaderList.size();
		if(colNum == 0){
			throw new Exception("表头为空");
		}
		
		if(freeExportParam.getAlignList().size() != colNum){
			throw new Exception("alignList对齐方式列表大小与表头列表大小不一致");
		}
		
		if(freeExportParam.getFormatTypeList().size() != colNum){
			throw new Exception("formatTypeList格式化类型列表大小与表头列表大小不一致");
		}
		
		if(freeExportParam.getFormatTypeValueList().size() != colNum){
			throw new Exception("formatTypeValueList格式化类型值列表大小与表头列表大小不一致");
		}
		
		List<List<String>> datas = freeExportParam.getDatas();
		for (List<String> list : datas) {
			if(list.size() != colNum){
				throw new Exception(org.apache.commons.lang.StringUtils.join(list.toArray(), ",") + "的列数大小与表头列表大小不一致");
			}
		}
	}
	
	/**
	 * 自由导出创建数据行
	 */
	private static <T> void freeExportCreateData(FreeExportParam freeExportParam, 
											     int columnNum, 
											     int rowIndex,
											     XSSFSheet sheet){
		
		XSSFCellStyle DefaultStringCellType = workbook.createCellStyle();
		DefaultStringCellType.setAlignment(XSSFCellStyle.ALIGN_LEFT);
		DefaultStringCellType.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		
		XSSFCellStyle defaultNumberCellTypeumberCellType = workbook.createCellStyle();
		defaultNumberCellTypeumberCellType.setAlignment(XSSFCellStyle.ALIGN_RIGHT);
		defaultNumberCellTypeumberCellType.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		
		XSSFCellStyle defaulTimeCellTypeimeCellType = workbook.createCellStyle();
		defaulTimeCellTypeimeCellType.setAlignment(XSSFCellStyle.ALIGN_CENTER);
		defaulTimeCellTypeimeCellType.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);
		
		List<String> alignList = freeExportParam.getAlignList();
		List<String> formatTypeList = freeExportParam.getFormatTypeList();
		List<String> formatTypeValueList = freeExportParam.getFormatTypeValueList();
		
		//创建数据行
		try {
			for (List<String> rowData : freeExportParam.getDatas()) {
				XSSFRow dataRow = sheet.createRow(rowIndex++);
				
				for (int i = 0; i < columnNum; i++) {
					XSSFCell dataCell = dataRow.createCell(i);
					String dataCellValue = rowData.get(i);
					
					if(StringUtils.isNotEmpty(dataCellValue)){
						String formatType = formatTypeList.get(i);
						String formatTypeValue = formatTypeValueList.get(i);
						String align = alignList.get(i);
						
						if(formatType.equals(ExportFormatConstant.FormatType.STRING)){
							XSSFCellStyle cellStyle = getDataCellType(align);
							dataCell.setCellStyle(null == cellStyle?DefaultStringCellType:cellStyle);
							dataCell.setCellValue(dataCellValue);
						}else if(formatType.equals(ExportFormatConstant.FormatType.NUMBER)){
							XSSFCellStyle cellStyle = getDataCellType(align);
							dataCell.setCellStyle(null == cellStyle?defaultNumberCellTypeumberCellType:cellStyle);
							dataCell.setCellValue(format(formatType, formatTypeValue, dataCellValue));
						}else if(formatType.equals(ExportFormatConstant.FormatType.TIME)){
							XSSFCellStyle cellStyle = getDataCellType(align);
							dataCell.setCellStyle(null == cellStyle?defaulTimeCellTypeimeCellType:cellStyle);
							dataCell.setCellValue(format(formatType, formatTypeValue, dataCellValue));
						}
					}else{
						dataCell.setCellStyle(DefaultStringCellType);
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
		log.info("门店"+filename+"创建开始...");
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
			workbook = new XSSFWorkbook();

			//将数据以20w为一个sheet进行excel创建
			int pageSize = 200000;
			int sheetCount = datas.size() % pageSize == 0 ? datas.size() / pageSize :datas.size() % pageSize +1;
			for (int sheetNo = 0; sheetNo < sheetCount; sheetNo++) {
				System.out.println("创建第"+sheetNo+1+"个sheet");
				List<T> tempList = datas.stream().skip(sheetNo*pageSize).limit(pageSize).collect(Collectors.toList());
				XSSFSheet sheet = workbook.createSheet(sheetname+sheetNo);
				//创建表头行
				XSSFRow tableHeaderRow = sheet.createRow(rowIndex++);
				for (int i = 0; i < columnNum; i++) {
					XSSFCell cell = tableHeaderRow.createCell(i);
					cell.setCellValue(tableHeaderArray[i]);
				}
				if(CollectionUtils.isNotEmpty(datas)){
					//创建数据行
					baseCreateData(tempList, columnNum, formatList, rowIndex++, fieldNameArray, sheet);

				}
			}


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
			log.info("门店"+filename+"创建完毕！");
		} catch (Exception e) {
			log.error("门店"+filename+"创建行数据时发生异常，异常信息为：",e);
			e.printStackTrace();
			return;
		}
	}
}
