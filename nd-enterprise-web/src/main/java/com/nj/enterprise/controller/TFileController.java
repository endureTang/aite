package com.nj.enterprise.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nj.core.base.common.Constants;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.FileMeta;
import com.nj.core.base.entity.Image;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.MD5;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.model.generate.NjOrderUpdateAttachment;
import com.nj.model.generate.NjTemplate;
import com.nj.model.generate.NjUserAttachment;
import com.nj.service.base.system.TemplateService;
import com.nj.service.enterprise.AttachmentFileService;
import com.nj.service.enterprise.OrderService;


@Controller
@RequestMapping("/file")
/*
 * 扩展和性能-当前实现仅仅为了后期便于迁移图片和服务独立
 */
//@SessionAttributes(App.USER_SESSION_KEY)
public class TFileController extends BaseController {
	
	LinkedList<FileMeta> files = new LinkedList<FileMeta>();
	FileMeta fileMeta = null;
	
	@Resource(name = "orderService")
	private OrderService orderService;
	
	@Resource(name = "attachmentFileService")
	AttachmentFileService attachmentFileService;
	
	@RequestMapping(value = "/{fileId:.+}", method = RequestMethod.GET)
	@ResponseBody
	public void getFile(
			@PathVariable("fileId") String fileId,
						HttpServletResponse response,
							HttpSession session) {
		
		try {
			
			StringBuilder path = new StringBuilder();
			path.append(Const.FILEPATHIMG);
			
			//根据文件id,文件类型获取图片
			
			NjUserAttachment attachFile = attachmentFileService.getAttachmentByFileId(fileId);
			StringBuilder realPath = new StringBuilder();
			realPath.append(attachFile.getFilePath());
			realPath.append(attachFile.getFileName());
			ServletOutputStream out= response.getOutputStream();
			FileInputStream in= new FileInputStream(realPath.toString());
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition", "attachment;fileName="
					+ attachFile.getFileName());
			
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
	public PageData add(MultipartFile uploadfile,HttpServletResponse response,@RequestParam("orderNo") String orderNo){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			StringBuilder sb = new StringBuilder();
//			pd.put("sort", new Date().getTime());
			{
				//only one file
					if (uploadfile.isEmpty()) {
						result.put("msg","上传失败");
						result.put("status", 0);
//						System.out.println(e.getMessage());
					} else {
						String originalFileName = uploadfile.getOriginalFilename();
						String prefix = originalFileName.substring(originalFileName.lastIndexOf("."));
					
//						pd.put("moduleicon", fileName);
						String newFileName = MD5.md5(originalFileName)+prefix;
						StringBuilder path = new StringBuilder();
						path.append(Const.FILEPATHIMG);
						if(StringUtils.isNotEmptyAndNull(orderNo)){
							path.append(orderNo).append("/");
						}
						FileUtils.copyInputStreamToFile(uploadfile.getInputStream(),
								new File(path.toString(), newFileName));
						
						//更新订单信息
						NjOrderUpdateAttachment attachRelation = new NjOrderUpdateAttachment();
						attachRelation.setOrderId(orderNo);
						
						NjUserAttachment attachment = new NjUserAttachment();
						attachment.setFilePath(path.toString());
						attachment.setFileName(newFileName);
						attachment.setFileTag(originalFileName);
						attachment.setFileType(uploadfile.getContentType());
						attachment.setBusinessType(1001);//业务类型
						
						NjUserAttachment savedAttachment = orderService.addImgsByAuditor(attachRelation, attachment);
						
						sb.append(newFileName);
						result.put("fileId",savedAttachment.getId());
						result.put("fileTag", originalFileName);
						result.put("status", 1);
					}
				}

				pd.put("imgs", sb.toString());
			
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
    
    @RequestMapping(value="attachmentTest", method=RequestMethod.GET)
	public ModelAndView attachmentTest(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("product/attachmentTest");
		return mv;
	}
    
    @RequestMapping(value = { "attachment" }, method = RequestMethod.POST)
	@ResponseBody
	public PageData upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request,
			ModelMap model, RedirectAttributes redirectAttributes,NjUserAttachment att) {
		PageData result = new PageData();
		
		String path = request.getSession().getServletContext().getRealPath("attachment");
		String fileName = System.currentTimeMillis()+".jpg";
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
			att.setFileName(fileName);
			att.setFilePath("attachment"+ File.separator + fileName);
			attachmentFileService.add(att);
			
			result.put("id", att.getId());
			result.put("status", 1);
			result.put("msg", "上传成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("id", att.getId());
			result.put("status", 0);
			result.put("msg", "上传失败！");
		}
		return result;
	}
    
    @RequestMapping("/download")
	public String download(String id, HttpServletRequest request,
			HttpServletResponse response) {
		
		try {
			String fileName = attachmentFileService.getAttachmentById(id);
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			response.setHeader("Content-Disposition", "attachment;fileName="
					+ fileName);
			
			String path = request.getSession().getServletContext().getRealPath("attachment");
			InputStream inputStream = new FileInputStream(new File(path
					+ File.separator + fileName));

			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}

			 // 这里主要关闭。
			os.close();

			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
            //  返回值要注意，要不然就出现下面这句错误！
            //java+getOutputStream() has already been called for this response
		return null;
	}
    
    /**
     * 上传合同附件
     * @param uploadfile
     * @param response
     * @param orderNo
     * @return
     */
	@RequestMapping(value="/uploadContract", method=RequestMethod.POST)
	@ResponseBody
	public PageData uploadContract(MultipartFile uploadfile,HttpServletResponse response,@RequestParam("orderNo") String orderNo){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			StringBuilder sb = new StringBuilder();
//			pd.put("sort", new Date().getTime());
			{
				//only one file
					if (uploadfile.isEmpty()) {
						result.put("msg","上传失败");
						result.put("status", 0);
//						System.out.println(e.getMessage());
					} else {
						String originalFileName = uploadfile.getOriginalFilename();
						
						if(originalFileName.toLowerCase().indexOf(".pdf") == -1){
							result.put("status", 0);
							result.put("msg", "请上传pdf格式文件！");
							return result;
						}
						
						String prefix = originalFileName.substring(originalFileName.lastIndexOf("."));
					
//						pd.put("moduleicon", fileName);
						String newFileName = MD5.md5(originalFileName)+prefix;
						StringBuilder path = new StringBuilder();
						path.append(Const.FILEPATHFILE);
						if(StringUtils.isNotEmptyAndNull(orderNo)){
							path.append(orderNo).append("/");
						}
						FileUtils.copyInputStreamToFile(uploadfile.getInputStream(),
								new File(path.toString(), newFileName));
						
						
						NjUserAttachment attachment = new NjUserAttachment();
						attachment.setFilePath(path.toString());
						attachment.setFileName(newFileName);
						attachment.setFileTag(originalFileName);
						attachment.setFileType(uploadfile.getContentType());
						attachment.setBusinessType(Constants.BUSINESSTYPE.CONTRACT);//业务类型，合同
						
						NjUserAttachment savedAttachment = orderService.addImgsByAuditor(attachment);
						
						sb.append(newFileName);
						result.put("fileId",savedAttachment.getId());
						result.put("fileTag", originalFileName);
						result.put("status", 1);
						result.put("msg","上传成功");
					}
				}

				pd.put("imgs", sb.toString());
			
		} catch (Exception e) {
			
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
}
