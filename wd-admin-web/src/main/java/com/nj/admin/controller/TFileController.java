package com.nj.admin.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.FileMeta;
import com.nj.core.base.entity.Image;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.PageData;


@Controller
@RequestMapping("/file")
//@SessionAttributes(App.USER_SESSION_KEY)
public class TFileController extends BaseController {
	
	LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	FileMeta fileMeta = null;
	
	@RequestMapping(value = "/{fileName:.+}", method = RequestMethod.GET)
	@ResponseBody
	public void getFile(
			@PathVariable("fileName") String fileName,
						HttpServletResponse response,
							HttpSession session) {
		response.setContentType("image/jpeg; charset=GBK");
		
		try {
			
			String realPath =  Const.FILEPATHIMG;
		
			ServletOutputStream out= response.getOutputStream();
			FileInputStream in= new FileInputStream(realPath +"/"+ fileName);
			byte[] buffer = new byte[1024];
			int n;
			while ((n = in.read(buffer)) != -1) {
			    out.write(buffer, 0, n);
			}
			out.flush();
			out.close();
			in.close();
			
		} catch (Exception e) {
//			rs.setSuccessful(false);
//			rs.setData("上传失败: " + e.getMessage());
		}
//		return rs;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(@RequestParam MultipartFile[] attachments,MultipartFile imgs,HttpServletResponse response){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			StringBuilder sb = new StringBuilder();
//			pd.put("sort", new Date().getTime());
			{
				//only one file
				for (MultipartFile myfile : attachments) {
					if (myfile.isEmpty()) {
						result.put("msg","上传失败");
//						System.out.println(e.getMessage());
					} else {
						String fileName = myfile.getOriginalFilename();
						pd.put("moduleicon", fileName);
						FileUtils.copyInputStreamToFile(myfile.getInputStream(),
								new File(Const.FILEPATHIMG, fileName));
						sb.append(fileName);
						sb.append(",");
					}
				}

				pd.put("imgs", sb.toString());
				
				result.put("status", 1);
			}
		} catch (Exception e) {
			
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	@RequestMapping(value="/mvcupload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
 
		LinkedList<FileMeta> fileJson = new LinkedList<FileMeta>();
		//1. build an iterator
		 Iterator<String> itr =  request.getFileNames();
		 MultipartFile mpf = null;

		 //2. get each file
		 while(itr.hasNext()){
			 
			 //2.1 get next MultipartFile
			 mpf = request.getFile(itr.next()); 

			 //2.2 if files > 10 remove the first from the list
			 if(fileJson.size() > 2)
				 fileJson.pop();
			 
			 //2.3 create new fileMeta
			 Date current = new Date();
				long time = current.getTime();
			 fileMeta = new FileMeta();
			 String newFileName = time +mpf.getOriginalFilename();
			 fileMeta.setFileName(newFileName);
			 fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
			 fileMeta.setFileType(mpf.getContentType());
			 
			 try {
//				fileMeta.setBytes(mpf.getBytes());
				
				// copy file to local disk (make sure the path "e.g. D:/temp/files" exists)
				
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(Const.FILEPATHIMG +newFileName ));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 //2.4 add to files
			 fileJson.add(fileMeta);
			 
		 }
		 
		return fileJson;
 
	}
	
	@RequestMapping(value = "/uploads", method = RequestMethod.GET)
    public @ResponseBody Map list() {
		List<Image> list = new ArrayList<Image>();
		Image image = new Image();
            image.setUrl("/picture/"+image.getId());
            image.setThumbnailUrl("/thumbnail/"+image.getId());
            image.setDeleteUrl("/delete/"+image.getId());
            image.setDeleteType("DELETE");
 
        Map<String, Object> files = new HashMap<String, Object>();
        files.put("files", list);
       
        return files;
    }
	 /*
     * file upload
     */
    @RequestMapping(value = "/uploads", method = RequestMethod.POST)
    public @ResponseBody Map uploads(MultipartHttpServletRequest request, HttpServletResponse response) {
       
    	
        Iterator<String> itr = request.getFileNames();
        MultipartFile mpf;
        List<Image> list = new LinkedList<Image>();
        
        while (itr.hasNext()) {
            mpf = request.getFile(itr.next());
          
            String newFilenameBase = UUID.randomUUID().toString();
            String originalFileExtension = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
            String newFilename = newFilenameBase + originalFileExtension;
            String storageDirectory = Const.FILEPATHIMG;
            String contentType = mpf.getContentType();
            
            File newFile = new File(storageDirectory  + newFilename);
            try {
                mpf.transferTo(newFile);
                
                BufferedImage thumbnail = Scalr.resize(ImageIO.read(newFile), 120);
                
                String thumbnailFilename = newFilenameBase + "-thumbnail.png";
                File thumbnailFile = new File(storageDirectory  + thumbnailFilename);
                ImageIO.write(thumbnail, "png", thumbnailFile);
                
                Image image = new Image();
                image.setName(mpf.getOriginalFilename());
                image.setThumbnailFilename(thumbnailFilename);
                image.setNewFilename(newFilename);
                image.setContentType(contentType);
                image.setSize(mpf.getSize());
                image.setThumbnailSize(thumbnailFile.length());
                
                image.setUrl("file/" + newFilename);
                image.setThumbnailUrl("file/" + thumbnailFilename);
                image.setDeleteUrl("/delete/"+image.getId());
                image.setDeleteType("DELETE");
                
                list.add(image);
                
            } catch(IOException e) {
                
            }
            
        }
        
        Map<String, Object> files = new HashMap<String, Object>();
        files.put("files", list);
        return files;
    }
}
