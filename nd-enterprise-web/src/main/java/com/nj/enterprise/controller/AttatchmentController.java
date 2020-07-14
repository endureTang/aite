package com.nj.enterprise.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nj.core.base.entity.ResponseDto;
import com.nj.core.base.enums.CommonStatus;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjUserAttachment;
import com.nj.service.itf.AttachmentService;
import com.nj.service.itf.FileOperationService;
import com.nj.service.itf.ItfLoanOrderService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/attachment")
@Controller
public class AttatchmentController {

    private Logger logger = LoggerFactory.getLogger(AttatchmentController.class);

    @Resource(name = "attachmentService")
    private AttachmentService attachmentService;

    @Resource
    private FileOperationService fileOperationService;
    
    @Resource(name = "itfLoanOrderService")
    private ItfLoanOrderService itfLoanOrderService;
    
    @RequestMapping(value = "download", method = {RequestMethod.POST, RequestMethod.GET})
    public void download(String attachId, HttpServletResponse response) throws Exception {
    	NjUserAttachment attach = attachmentService.getAttachment(attachId);
    	fileOperationService.download(attach,response);
    }

    /**
     * 文件上传接口
     *
     * @param file 上传文件
     * @return 响应体
     */
    @RequestMapping(value = "upload", method = {RequestMethod.POST})
    @ApiOperation("文件上传")
    @ResponseBody
    public ResponseDto<String> upload(@ApiParam("上传文件") MultipartFile file, String tag) {
        try {
            if (null == file) {
                logger.error("/attachment/upload：上传文件为空");
                return new ResponseDto<>(CommonStatus.PARAMS_ERROR.getCode(), CommonStatus.PARAMS_ERROR.getMessage());
            }
            String attachmentId = fileOperationService.uploadPic(file, tag);
            return new ResponseDto<>(CommonStatus.SUCCEED.getCode(), CommonStatus.SUCCEED.getMessage(), attachmentId);
        } catch (Exception e) {
            logger.error("upload attachment error", e);
            return new ResponseDto<>(CommonStatus.SYSTEM_ERROR.getCode(), CommonStatus.SYSTEM_ERROR.getMessage());
        }
    }
    
    @ApiOperation("删除附件信息")
	@RequestMapping(value = "delete", method = { RequestMethod.POST }, produces = {
			"application/json;charset=utf-8" })
	public PageData delete(HttpServletRequest request,@RequestParam String id,@RequestParam String orderId) {
    	PageData result = new PageData();
		try {
			Map<String, String> map = new HashMap<>();
			map.put("attachId", id);
			map.put("orderId", orderId);
			itfLoanOrderService.deleteUserOrderAttach(map);
			result.put(Constants.Datas.STATUS, 0);
            result.put(Constants.Datas.MSG, "保存成功");
		} catch (Exception e) {
			logger.info("/attachment/delete:" + orderId + ": 系统错误", e);
			result.put(Constants.Datas.STATUS, 1000);
			result.put(Constants.Datas.MSG, "系统错误，请联系管理员");
		}
		return result;
	}
}
