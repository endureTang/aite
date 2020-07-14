package com.nj.service.esign;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nj.core.base.dao.BaseDao;
import com.timevale.esign.sdk.tech.bean.SignBean;
import com.timevale.esign.sdk.tech.bean.result.VerifyPdfResult;
import com.timevale.esign.sdk.tech.service.SignService;
import com.timevale.esign.sdk.tech.service.factory.SignServiceFactory;

/**
 * 验签服务:验证本地pdf文档签名的有效性
 * @author wkh
 *
 */
@Service("pdfVerifySignService")
public class PdfVerifySignService extends BaseEsignService{

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	/**
	 * 验证签名的合法性并返回pdf文档的所有签名信息 
	 * @param filePath	文件在本地的完整路径
	 */
	public List<SignBean> verifySign_file(String filePath) throws Exception{
		
		sdkInit();
		
		SignService sSrv = SignServiceFactory.instance();
		VerifyPdfResult result = sSrv.localVerifyPdf(filePath);
		if(result.getErrCode() != 0){
			throw new Exception(result.getMsg());
		}
		
		return result.getSignatures();
	}
	
	/**
	 * 验证签名的合法性并返回pdf文档的所有签名信息 
	 * @param stream 待验证pdf文档在本地的二进制流数据
	 */
	public List<SignBean> verifySign_Stream(byte[] stream) throws Exception{
		
		sdkInit();
		
		SignService sSrv = SignServiceFactory.instance();
		VerifyPdfResult result = sSrv.localVerifyPdf(stream);
		if(result.getErrCode() != 0){
			throw new Exception(result.getMsg());
		}
		
		return result.getSignatures();
	}
}
