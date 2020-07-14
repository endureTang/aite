package com.nj.core.base.util;

import com.jd.core.util.StringUtil;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

/**
 * 文件操作工具类（上传、下载文件）
 *
 * @author Lizy
 * @version 2018/4/2.
 */
public class FileOperationUtil {
    /**
     * 文件目录
     */
    public static String FILE_DIR;
//    private static final String FILE_DIR = "E:";
    /**
     * 默认文件夹
     */
    private static final String FILE_DEFAULT_DIR = "default";
    /**
     * 文件夹命名时间格式
     */
    private static final String FILE_DATE_DIR_FORMAT = "yyyyMMdd";
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(FileOperationUtil.class);

    private FileOperationUtil() {
    }

    /**
     * 文件上传方法
     *
     * @param dir    文件归属目录
     * @param file   文件流
     * @param suffix 文件后缀
     * @return 保存后文件相对路径
     * @throws IOException 上传文件异常
     */
    public static String uploadFile(String dir, InputStream file, String suffix) throws IOException {
        logger.info("upload file start");

        String fileName = UUID.randomUUID().toString() + "." + suffix;
        // 判断是否存在文件夹，不存在则赋值默认文件夹
        if (StringUtil.isBlank(dir)) {
            dir = FILE_DEFAULT_DIR;
        }
        String currentDate = new SimpleDateFormat(FILE_DATE_DIR_FORMAT).format(Calendar.getInstance().getTime());
        String dirPath = FILE_DIR + File.separator + currentDate;
        File fileDir = new File(dirPath);
        // 判断文件夹是否存在
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        FileUtils.copyInputStreamToFile(file,
                new File(fileDir, fileName));
        logger.info("upload file end, file name:" + fileName);
        return File.separator + currentDate + File.separator + fileName;
    }

    /**
     * 文件上传方法
     *
     * @param dir    文件归属目录
     * @param file   文件流
     * @param suffix 文件后缀
     * @return 保存后文件相对路径
     * @throws IOException 上传文件异常
     */
    public static String uploadFile2(String dir, InputStream file, String suffix) throws IOException {

        String fileName = UUID.randomUUID().toString() + "." + suffix;
        // 判断是否存在文件夹，不存在则赋值默认文件夹
        if (StringUtil.isBlank(dir)) {
            dir = FILE_DEFAULT_DIR;
        }
        String currentDate = new SimpleDateFormat(FILE_DATE_DIR_FORMAT).format(Calendar.getInstance().getTime());
        String dirPath = dir + File.separator + currentDate;
        File fileDir = new File(dirPath);
        // 判断文件夹是否存在
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        FileUtils.copyInputStreamToFile(file,
                new File(fileDir, fileName));
        logger.info("upload file end, file name:" + fileName);
        return File.separator + currentDate + File.separator + fileName;
    }

    /**
     * 下载文件
     *
     * @param dir         文件归属目录
     * @param filePath    文件相对路径
     * @param orgFileName 原始文件名
     * @param response    响应
     * @throws IOException 下载异常
     */
    public static void download(String dir, String filePath, String orgFileName, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + orgFileName);
        // 判断是否存在文件夹，不存在则赋值默认文件夹
        if (StringUtil.isBlank(dir)) {
            dir = FILE_DEFAULT_DIR;
        }
        logger.info("请求地址=============：" + FILE_DIR + filePath);
        File file = new File(FILE_DIR + filePath);

        if (file.exists()) {
            logger.info("download file start");
            InputStream inputStream = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        }
        logger.info("download end");
    }


    public static boolean deleteFile(String filePath) {
        logger.info("请求地址=============：" + FILE_DIR + filePath);
        File file = new File(FILE_DIR + filePath);
        return file.exists() && file.delete();
    }

    /**
     * 下载文件
     *
     * @param dir         文件归属目录
     * @param filePath    文件相对路径
     * @param orgFileName 原始文件名
     * @param response    响应
     * @throws IOException 下载异常
     */
    public static void download2(String dir, String filePath, String orgFileName, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + URLEncoder.encode(orgFileName, "UTF-8"));
        // 判断是否存在文件夹，不存在则赋值默认文件夹
        if (StringUtil.isBlank(dir)) {
            dir = FILE_DEFAULT_DIR;
        }
        logger.info("请求地址=============：" + dir + filePath);
        File file = new File(dir + filePath);

        if (file.exists()) {
            logger.info("download file start");
            InputStream inputStream = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        }
        logger.info("download end");
    }

    /**
     * 下载文件，传入被下载文件的绝对路径
     *
     * @param filePath    文件绝度路径，包含文件名
     * @param orgFileName 原始文件名
     * @param response    响应
     * @throws IOException 下载异常
     */
    public static void download3(String filePath, String orgFileName, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + URLEncoder.encode(orgFileName, "UTF-8"));
        // 判断是否存在文件夹，不存在则赋值默认文件夹
        if (StringUtil.isBlank(filePath)) {
            filePath = FILE_DEFAULT_DIR;
        }
        logger.info("请求地址=============：" + filePath);
        File file = new File(filePath);

        if (file.exists()) {
            logger.info("download file start");
            InputStream inputStream = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        }
        logger.info("download end");
    }
    
    

  /**
   * 
   * @param fileName  包含路径的文件名
   * @param response
   * @throws IOException
   */
    public static void download4(String fileName,  HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName="
                + URLEncoder.encode(getFileNameWithSuffix(fileName), "UTF-8"));
       
        logger.info("请求地址=============：" + fileName);
        File file = new File(fileName);

        if (file.exists()) {
            logger.info("download file start");
            InputStream inputStream = new FileInputStream(file);
            OutputStream os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }

            // 这里主要关闭。
            os.close();
            inputStream.close();
        }
        logger.info("download end");
    }
    
    /**
	 * 保留文件名及后缀
	 */
	public  static String getFileNameWithSuffix(String pathandname) {		
		int start = pathandname.lastIndexOf("/");
		if (start != -1 ) {
			return pathandname.substring(start + 1);
		} else {
			return null;
		}		
	}
	
	
   

}
