package com.nj.core.utils.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
/**
 * 读取Excel
 * @author lp
 *
 */
public class ExcelReadUtil {	
	public int totalRows; //sheet中总行数
	public static int totalCells; //每一行总单元格数
	/**
	 * read the Excel .xlsx,.xls
	 * @param file jsp中的上传文件
	 * @return
	 * @throws IOException 
	 */
	public List<ArrayList<String>> readExcel(MultipartFile file) throws IOException {
		if(file==null||ExcelUtil.EMPTY.equals(file.getOriginalFilename().trim())){
			return null;
		}else{
			String postfix = ExcelUtil.getPostfix(file.getOriginalFilename());
			if(!ExcelUtil.EMPTY.equals(postfix)){
				if(ExcelUtil.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)){
					return readXls(file);
				}else if(ExcelUtil.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)){
					return readXlsx(file);
				}else{					
					return null;
				}
			}
		}
		return null;
	}
	/**
	 * read the Excel 2010 .xlsx
	 * @param file
	 * @param beanclazz
	 * @param titleExist
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	public List<ArrayList<String>> readXlsx(MultipartFile file){
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	    // IO流读取文件
	    InputStream input = null;
	    XSSFWorkbook wb = null;
	    ArrayList<String> rowList = null;
		try {
			input = file.getInputStream();
		    // 创建文档
		    wb = new XSSFWorkbook(input);           		    
	        //读取sheet(页)
	        for(int numSheet=0;numSheet<wb.getNumberOfSheets();numSheet++){
	        	XSSFSheet xssfSheet = wb.getSheetAt(numSheet);
	        	if(xssfSheet == null){
	        		continue;
	        	}
	        	totalRows = xssfSheet.getLastRowNum();	        	
	        	//读取Row,从第二行开始
	        	for(int rowNum = 2;rowNum <= totalRows;rowNum++){
	        		XSSFRow xssfRow = xssfSheet.getRow(rowNum);
	        		if(xssfRow!=null){
	        			rowList = new ArrayList<String>();
//	        			totalCells = xssfRow.getLastCellNum();
	        			totalCells = 7;
	        			//读取列，从第一列开始
	        			for(int c=0;c<totalCells;c++){
	        				XSSFCell cell = xssfRow.getCell(c);
	        				if(cell==null){
	        					rowList.add(ExcelUtil.EMPTY);
	        					continue;
	        				}	        				
	        				rowList.add(ExcelUtil.getXValue(cell).trim());
	        			}	
	        			list.add(rowList);
	        		}
	        	}
	        }
	        return list;
		} catch (IOException e) {			
			e.printStackTrace();
		} finally{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
		
	}
	/**
	 * read the Excel 2003-2007 .xls
	 * @param file
	 * @param beanclazz
	 * @param titleExist
	 * @return
	 * @throws IOException 
	 */
	public List<ArrayList<String>> readXls(MultipartFile file){ 
		List<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	    // IO流读取文件
	    InputStream input = null;
	    HSSFWorkbook wb = null;
	    ArrayList<String> rowList = null;
		try {
			input = file.getInputStream();
		    // 创建文档
		    wb = new HSSFWorkbook(input);           		    
	        //读取sheet(页)
	        for(int numSheet=0;numSheet<wb.getNumberOfSheets();numSheet++){
	        	HSSFSheet hssfSheet = wb.getSheetAt(numSheet);
	        	if(hssfSheet == null){
	        		continue;
	        	}
	        	totalRows = hssfSheet.getLastRowNum();	        	
	        	//读取Row,从第二行开始
	        	for(int rowNum = 2;rowNum <= totalRows;rowNum++){
	        		HSSFRow hssfRow = hssfSheet.getRow(rowNum);
	        		if(hssfRow!=null){
	        			rowList = new ArrayList<String>();
//	        			totalCells = hssfRow.getLastCellNum();
	        			totalCells = 7;
	        			//读取列，从第一列开始
	        			for(short c=0;c<=totalCells+1;c++){
	        				HSSFCell cell = hssfRow.getCell(c);
	        				if(cell==null){
	        					rowList.add(ExcelUtil.EMPTY);
	        					continue;
	        				}	        				
	        				rowList.add(ExcelUtil.getHValue(cell).trim());
	        			}	     
	        			list.add(rowList);
	        		}	        		
	        	}
	        }
	        return list;
		} catch (IOException e) {			
			e.printStackTrace();
		} finally{
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {

		String picPath ="C:\\Users\\Administrator\\Desktop\\1.xlsx";  
        MultipartFile file = getMulFileByPath(picPath);  
        try {
        	List<ArrayList<String>> str = new ExcelReadUtil().readExcel(file);
        	for (int i = 0; i < str.size(); i++) {
        		List<String> str2 = str.get(i);
        		System.out.println(str2.get(0));
			}
        	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	    public static MultipartFile getMulFileByPath(String picPath) {  
	        FileItem fileItem = createFileItem(picPath);  
	        MultipartFile mfile = new CommonsMultipartFile(fileItem);  
	        return mfile;  
	    } 
	    private static FileItem createFileItem(String filePath)  
	    {  
	        FileItemFactory factory = new DiskFileItemFactory(16, null);  
	        String textFieldName = "textField";  
	        int num = filePath.lastIndexOf(".");  
	        String extFile = filePath.substring(num);  
	        FileItem item = factory.createItem(textFieldName, "text/plain", true,  
	            "MyFileName" + extFile);  
	        File newfile = new File(filePath);  
	        int bytesRead = 0;  
	        byte[] buffer = new byte[8192];  
	        try  
	        {  
	            FileInputStream fis = new FileInputStream(newfile);  
	            OutputStream os = item.getOutputStream();  
	            while ((bytesRead = fis.read(buffer, 0, 8192))  
	                != -1)  
	            {  
	                os.write(buffer, 0, bytesRead);  
	            }  
	            os.close();  
	            fis.close();  
	        }  
	        catch (IOException e)  
	        {  
	            e.printStackTrace();  
	        }  
	        return item;  
	    } 
}
