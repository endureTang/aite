package com.nj.core.doc2pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.CommonStatus;
import com.nj.core.doc2pdf.generator.PdfGenerator;
import com.nj.core.doc2pdf.generator.PdfGeneratorImpl;
import com.nj.core.doc2pdf.generator.WordUtil;

public class DocToPdfUtil {
	
	/**
	 * 生成word
	 * @param map  数据
	 * @param templateFilePath  word模板文件
	 * @param outputFilePath    填充内容之后的word文件
	 * @return
	 */
	public  static  ResponseDto<String> generatorDOCX(Map<String,Object>  map,String templateFilePath,String outputFilePath){
		
		  ResponseDto<String> msg = new ResponseDto<String>();
		try {
			
			
			File  templateFile  =  new  File(templateFilePath);
			if(!templateFile.exists()){
				
				throw  new Exception("文件:"+templateFilePath+"-不存在");
			}
		
			String outFileDir = outputFilePath.substring(0,outputFilePath.lastIndexOf("/"));
			File  outFile  =  new  File(outFileDir);
			if(!outFile.exists()){
				
				throw  new Exception("DOCX生成文件夹:"+outputFilePath+"-不存在");
			}
		
		    //根据模板文件生成最终docx文件
			WordUtil.generateDocx(map,  templateFilePath,  outputFilePath);
			
	        msg.setReturnCode(CommonStatus.SUCCEED.getCode());
	  	    msg.setReturnMsg("DOCX生成成功");
	  	    return  msg;
	  	    
		} catch (Exception e) {
			 msg.setReturnCode(CommonStatus.PARAMS_ERROR.getCode());
		  	 msg.setReturnMsg("DOCX生成失败__【"+e.getMessage()+"】");
		  	 return  msg;
		}
	
		
	}
	
	
	/**
	 * 生成pdf
	 * @param map  数据
	 * @param templateFilePath  模板文件目录
	 * @param bakFilePath    填充内容之后的word文件
	 * @param outputFilePath pdf生成文件目录
	 * Return  ResponseDto
	 */
	public  static  ResponseDto<String> generatorPdf(Map<String,Object>  map,String templateFilePath,String bakFilePath,String outputFilePath){
	
		  ResponseDto<String> msg = new ResponseDto<String>();
		try {
			File  templateFile  =  new  File(templateFilePath);
			if(!templateFile.exists()){
				
				throw  new Exception("文件:"+templateFilePath+"-不存在");
			}
		
			
			String bakFileDir = bakFilePath.substring(0,bakFilePath.lastIndexOf("/"));
			File  bakFile  =  new  File(bakFileDir);
			System.out.println(bakFile.isDirectory());
			if(!bakFile.exists()){
				
				throw  new Exception("临时文件夹:"+bakFileDir+"-不存在");
			}
			
			String outFileDir = outputFilePath.substring(0,outputFilePath.lastIndexOf("/"));
			File  outFile  =  new  File(outFileDir);
			if(!outFile.exists()){
				
				throw  new Exception("pdf生成文件夹:"+bakFileDir+"-不存在");
			}
		
		    //根据模板文件生成最终docx文件
			WordUtil.generateDocx(map,  templateFilePath,  bakFilePath);
			//生成pdf文件
	        PdfGenerator pdfGenerator = new PdfGeneratorImpl();
	        pdfGenerator.generate(bakFilePath, outputFilePath);
	        //删除零时文件
	        deleteFile(bakFilePath);
	        
	        
	        msg.setReturnCode(CommonStatus.SUCCEED.getCode());
	  	    msg.setReturnMsg("pdf生成成功");
	  	    return  msg;
	  	    
		} catch (Exception e) {
			 msg.setReturnCode(CommonStatus.PARAMS_ERROR.getCode());
		  	 msg.setReturnMsg("pdf生成失败__【"+e.getMessage()+"】");
		  	 return  msg;
		}
	
		
	}
	
	/**
	 * 删除文件
	 */
	private static void deleteFile(String fileUrl) {
		File file = new File(fileUrl);
		file.delete();
	}
	
	
	
	public static void main(String[] args) throws FileNotFoundException {
		//数据准备
    	Map<String, Object> map = new HashMap<String, Object>();
		map.put("${TITLE}", "标题");
		map.put("${ORGNAME}", "贰拾元");
		map.put("${TJDATE}", "标题33");
		map.put("loanAmt", 27.12);

		

		//②图片  图片信息放在map 中
		String fileName="E:/testDoc2PdfData/Image/123.jpg";
		Map<String,Object> img = new HashMap<String, Object>();
		img.put("width", 159);
		img.put("height", 159);
		img.put("type", "jpg");
	    img.put("content", WordUtil.inputStream2ByteArray(new FileInputStream(fileName), true));
	    map.put("GAISHU",img);
	    
	   String templateFilePath = "E:/testDoc2PdfData/template/个人借款合同-2018年版.docx";
	   String bakFilePath = "E:/testDoc2PdfData/bak/out.docx";
	   String outputFilePath = "E:/testDoc2PdfData/pdf/aa.pdf";
//	   ResponseDto<String> generatorPdf = generatorPdf(map, templateFilePath, bakFilePath, outputFilePath);
//	   System.out.println(generatorPdf.getReturnMsg());
//	   System.out.println(generatorPdf.getReturnCode());
	   
	//   templateFilePath = "E:/aaaa.docx"; 
	  // bakFilePath = "E:/out.docx";
	  ResponseDto<String> generatorDOCX = generatorDOCX(map, templateFilePath, bakFilePath);
	  System.out.println(generatorDOCX.getReturnMsg());
	  System.out.println(generatorDOCX.getReturnCode());
	}

}
