package com.nj.admin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExportUtil
{
  private static Logger log = LoggerFactory.getLogger(ExportUtil.class);
  private static XSSFWorkbook workbook;
  private static SimpleDateFormat sdf_date;
  private static SimpleDateFormat sdf_time;
  private static SimpleDateFormat sdf_datetime;
  private static SimpleDateFormat sdf_timestamp;
  private static String fileDirpath = ExportUtil.class.getResource("/").getPath() + "temp" + File.separator + "relative";
  
  public static <T> void baseExport(List<T> datas, Class<T> clazz, String filename, String sheetname, String titlename, HttpServletResponse response)
    throws Exception
  {
    int columnNum = 0;
    List<ExportFormat> formatList = new ArrayList();
    
    Field[] fields = clazz.getDeclaredFields();
    for (int i = 0; i < fields.length; i++)
    {
      ExportFormat exportFormat = (ExportFormat)fields[i].getAnnotation(ExportFormat.class);
      if (null != exportFormat)
      {
        columnNum++;
        formatList.add(exportFormat);
      }
    }
    Object[] rs = sort(formatList);
    formatList = (List)rs[0];
    Map<Integer, Integer> sortMap = (Map)rs[1];
    
    String[] tableHeaderArray = new String[columnNum];
    String[] fieldNameArray = new String[columnNum];
    for (int i = 0; i < fields.length; i++)
    {
      ExportFormat exportFormat = (ExportFormat)fields[i].getAnnotation(ExportFormat.class);
      if (null != exportFormat)
      {
        int index = ((Integer)sortMap.get(Integer.valueOf(exportFormat.sort()))).intValue();
        tableHeaderArray[index] = exportFormat.name();
        fieldNameArray[index] = fields[i].getName();
      }
    }
    try
    {
      int rowIndex = 0;
      
      workbook = new XSSFWorkbook();
      XSSFSheet sheet = workbook.createSheet(sheetname);
      
      rowIndex = createHeader(columnNum, rowIndex, tableHeaderArray, sheet);
      if ((datas != null) && (datas.size() > 0)) {
        baseCreateData(datas, columnNum, formatList, rowIndex, fieldNameArray, sheet);
      }
      File file = new File(fileDirpath);
      if (!file.exists()) {
        file.mkdirs();
      }
      file = new File(fileDirpath + File.separator + filename);
      if (!file.exists()) {
        file.createNewFile();
      }
      OutputStream out = new FileOutputStream(file);
      workbook.write(out);
    }
    catch (Exception e)
    {
      log.error("����������������������������������", e);
      e.printStackTrace();
      return;
    }
    download(fileDirpath, filename, response);
  }
  
  private static Object[] sort(List<ExportFormat> efList)
  {
    List<Integer> list = new ArrayList();
    List<ExportFormat> ef = new ArrayList();
    
    Map<Integer, ExportFormat> map = new HashMap();
    for (ExportFormat exportFormat : efList)
    {
      map.put(Integer.valueOf(exportFormat.sort()), exportFormat);
      list.add(Integer.valueOf(exportFormat.sort()));
    }
    Collections.sort(list);
    
    Object sortMap = new HashMap();
    int index = 0;
    for (Integer integer : list)
    {
      ef.add(map.get(integer));
      ((Map)sortMap).put(integer, Integer.valueOf(index++));
    }
    Object[] result = new Object[2];
    result[0] = ef;
    result[1] = sortMap;
    
    return result;
  }
  
  private static int createHeader(int columnNum, int rowIndex, String[] tableHeaderArray, XSSFSheet sheet)
  {
    XSSFRow tableHeaderRow = sheet.createRow(rowIndex++);
    
    XSSFCellStyle tableHeaderStyle = workbook.createCellStyle();
    tableHeaderStyle.setAlignment((short)2);
    tableHeaderStyle.setVerticalAlignment((short)1);
    
    XSSFFont tableHeaderFont = workbook.createFont();
    
    tableHeaderFont.setFontName("Courier New");
    tableHeaderFont.setFontHeightInPoints((short)14);
    
    tableHeaderStyle.setFont(tableHeaderFont);
    for (int i = 0; i < columnNum; i++)
    {
      XSSFCell cell = tableHeaderRow.createCell(i);
      cell.setCellValue(tableHeaderArray[i]);
      cell.setCellStyle(tableHeaderStyle);
    }
    return rowIndex;
  }
  
  private static <T> void baseCreateData(List<T> datas, int columnNum, List<ExportFormat> formatList, int rowIndex, String[] fieldNameArray, XSSFSheet sheet)
  {
    XSSFCellStyle DefaultStringCellType = workbook.createCellStyle();
    DefaultStringCellType.setAlignment((short)1);
    DefaultStringCellType.setVerticalAlignment((short)1);
    
    XSSFCellStyle defaultnumberCellTypeumberCellType = workbook.createCellStyle();
    defaultnumberCellTypeumberCellType.setAlignment((short)3);
    defaultnumberCellTypeumberCellType.setVerticalAlignment((short)1);
    
    XSSFCellStyle defaultimeCellTypeimeCellType = workbook.createCellStyle();
    defaultimeCellTypeimeCellType.setAlignment((short)2);
    defaultimeCellTypeimeCellType.setVerticalAlignment((short)1);
    try
    {
      for (T data : datas)
      {
        XSSFRow dataRow = sheet.createRow(rowIndex++);
        for (int i = 0; i < columnNum; i++)
        {
          XSSFCell dataCell = dataRow.createCell(i);
          
          String name = fieldNameArray[i];
          name = name.substring(0, 1).toUpperCase() + name.substring(1);
          Method m = data.getClass().getMethod("get" + name, new Class[0]);
          Object result = m.invoke(data, new Object[0]);
          if (null != result)
          {
            String formatType = ((ExportFormat)formatList.get(i)).formatType();
            String formatTypeValue = ((ExportFormat)formatList.get(i)).formatTypeValue();
            String align = ((ExportFormat)formatList.get(i)).align();
            if (formatType.equals("String"))
            {
              XSSFCellStyle cellStyle = getDataCellType(align);
              dataCell.setCellStyle(null == cellStyle ? DefaultStringCellType : cellStyle);
              dataCell.setCellValue(result.toString());
            }
            else if (formatType.equals("number"))
            {
              XSSFCellStyle cellStyle = getDataCellType(align);
              dataCell.setCellStyle(null == cellStyle ? defaultnumberCellTypeumberCellType : cellStyle);
              dataCell.setCellValue(format(formatType, formatTypeValue, result));
            }
            else if (formatType.equals("time"))
            {
              XSSFCellStyle cellStyle = getDataCellType(align);
              dataCell.setCellStyle(null == cellStyle ? defaultimeCellTypeimeCellType : cellStyle);
              dataCell.setCellValue(format(formatType, formatTypeValue, result));
            }
          }
          else
          {
            dataCell.setCellStyle(DefaultStringCellType);
            dataCell.setCellValue("");
          }
        }
      }
    }
    catch (Exception e)
    {
      log.error("����������������������������������", e);
      e.printStackTrace();
    }
  }
  
  private static XSSFCellStyle getDataCellType(String align)
  {
    if ((align != null) && (!align.equals("")))
    {
      XSSFCellStyle cellType = workbook.createCellStyle();
      if (align.equals("center")) {
        cellType.setAlignment((short)2);
      } else if (align.equals("left")) {
        cellType.setAlignment((short)1);
      } else if (align.equals("right")) {
        cellType.setAlignment((short)3);
      }
      cellType.setVerticalAlignment((short)1);
      
      return cellType;
    }
    return null;
  }
  
  private static String format(String formatType, String formatTypeValue, Object value)
  {
    if (formatType.equals("number"))
    {
      if ((value instanceof BigDecimal))
      {
        if (formatTypeValue.equals("int")) {
          return String.valueOf(((BigDecimal)value).intValue());
        }
        if (formatTypeValue.equals("nothing")) {
          return value.toString();
        }
        if (formatTypeValue.equals("number_2"))
        {
          BigDecimal bg_2 = (BigDecimal)value;
          return bg_2.setScale(2, 5).toString();
        }
        if (formatTypeValue.equals("number_4"))
        {
          BigDecimal bg_4 = (BigDecimal)value;
          return bg_4.setScale(4, 5).toString();
        }
        return value.toString();
      }
      if (formatTypeValue.equals("int")) {
        return String.valueOf(Double.valueOf(value.toString()).intValue());
      }
      if (formatTypeValue.equals("nothing")) {
        return value.toString();
      }
      if (formatTypeValue.equals("number_2"))
      {
        BigDecimal bg_2 = new BigDecimal(value.toString());
        return bg_2.setScale(2, 5).toString();
      }
      if (formatTypeValue.equals("number_4"))
      {
        BigDecimal bg_4 = new BigDecimal(value.toString());
        return bg_4.setScale(4, 5).toString();
      }
      return value.toString();
    }
    if (formatType.equals("time"))
    {
      initDateFormat();
      
      Date date = (Date)value;
      if (formatTypeValue.equals("date")) {
        return sdf_date.format(date);
      }
      if (formatTypeValue.equals("time")) {
        return sdf_time.format(date);
      }
      if (formatTypeValue.equals("datetime")) {
        return sdf_datetime.format(date);
      }
      if (formatTypeValue.equals("timestamp")) {
        return sdf_timestamp.format(date);
      }
      return "";
    }
    return "";
  }
  
  private static void initDateFormat()
  {
    if (null == sdf_date) {
      sdf_date = new SimpleDateFormat("yyyy-MM-dd");
    } else if (null == sdf_datetime) {
      sdf_date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    } else if (null == sdf_time) {
      sdf_date = new SimpleDateFormat("hh:mm:ss");
    } else if (null == sdf_timestamp) {
      sdf_date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss sss");
    }
  }
  
  private static void download(String fileDirpath, String filename, HttpServletResponse response)
    throws Exception, IOException
  {
    response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
    response.setContentType("application/vnd.ms-excel");
    
    InputStream is = null;
    OutputStream out = null;
    try
    {
      is = new FileInputStream(new File(fileDirpath + File.separator + filename));
      out = response.getOutputStream();
      byte[] buffer = new byte[40960];
      int byteCount = is.read(buffer);
      while (byteCount > 0)
      {
        out.write(buffer, 0, byteCount);
        byteCount = is.read(buffer);
      }
      out.flush();
    }
    catch (Exception e)
    {
      File file;
      throw e;
    }
    finally
    {
      if (is != null) {
        is.close();
      }
      if (out != null) {
        out.close();
      }
      File file = new File(fileDirpath + File.separator + filename);
      file.delete();
    }
  }
}
