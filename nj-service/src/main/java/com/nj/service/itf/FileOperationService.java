package com.nj.service.itf;

import com.nj.core.base.util.FileOperationUtil;
import com.nj.core.base.util.StringUtils;
import com.nj.model.generate.NjUserAttachment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;

/**
 * 文件操作工具类
 *
 * @author Lizy
 * @version 2018/4/9
 */
@Service("fileOperationService")
public class FileOperationService {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(FileOperationService.class);
    /**
     * 图片存放路径
     */
    private static final String DIR = "pic";
    /**
     * 附件sevice
     */
    @Resource(name = "attachmentService")
    private AttachmentService attachmentService;

    /**
     * 上传图片附件
     *
     * @param file 附件文件
     * @return 附件id
     * @throws Exception
     */
    public String uploadPic(MultipartFile file, String tag) throws Exception {
        String originalName = file.getOriginalFilename();
        int dotPlace = originalName.lastIndexOf(".");
        String postPix = "";
        if (dotPlace > 0) {
            postPix = originalName.substring(dotPlace + 1);
        }
        if (StringUtils.isEmpty(postPix)) {
            postPix = "jpg";
        }
        String filePath = FileOperationUtil.uploadFile(DIR, file.getInputStream(), postPix);
        // 写数据库
        NjUserAttachment att = new NjUserAttachment();
        att.setDelFlag(false);
        att.setFileName(originalName);
        att.setCreateDate(new Date());
        att.setFileTag(tag);
        att.setFilePath(filePath);
        att.setUpdateBy(System.currentTimeMillis() + "");
        att.setFileSize(Long.toString(file.getSize()));
        att.setVersion(0);
        attachmentService.save(att);
        return att.getId();
    }

    public boolean deleteFile(String attachId) throws Exception {
        NjUserAttachment attach = attachmentService.getAttachment(attachId);
        if (null != attach) {
            return FileOperationUtil.deleteFile(attach.getFilePath());
        }
        return false;
    }

    public void download(NjUserAttachment attach, HttpServletResponse response) throws Exception {
        if (null != attach) {
            FileOperationUtil.download(DIR, attach.getFilePath(), attach.getFileName(), response);
        }
    }
}
