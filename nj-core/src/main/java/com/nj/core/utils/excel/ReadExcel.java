package com.nj.core.utils.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.nj.core.base.util.DateUtil;
import jxl.CellType;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
public ReadExcel(){
}
public static void readExcel(String filepath){
try {
    FileInputStream fis = new FileInputStream(filepath);
    XSSFWorkbook wb = new XSSFWorkbook(fis);
    int sheet_size = wb.getNumberOfSheets();
    XSSFSheet xssfSheet = wb.getSheet("MIG_LN_SCHED");
    XSSFRow titleRow = xssfSheet.getRow(0);
    //循环取每行的数据
    for (int rowIndex = 1; rowIndex < xssfSheet.getPhysicalNumberOfRows(); rowIndex++) {
        XSSFRow xssfRow = xssfSheet.getRow(rowIndex);
        if (xssfRow == null) {
            continue;
        }
        Map<String, String> map = new LinkedHashMap<String, String>();
        //循环取每个单元格(cell)的数据
        for (int cellIndex = 0; cellIndex < xssfRow.getPhysicalNumberOfCells(); cellIndex++) {
            if(cellIndex == 13){
                XSSFCell xssfCell = xssfRow.getCell(cellIndex);
                String dateStr = xssfCell.getStringCellValue();
                if(dateStr != null && dateStr!= ""){

                    Date date = new Date(dateStr);
                    System.out.println(DateUtil.formatDate(date,"yyyy-MM-dd HH:mm:ss"));
                }else{
                    System.out.println("");
                }

            }

        }
    }
    } catch (FileNotFoundException e) {
    e.printStackTrace();
    }  catch (IOException e) {
    e.printStackTrace();
    }
    }

    public static void main(String[] args) {
        readExcel("D:\\11\\test.xlsx");
    }


}