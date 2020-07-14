package com.nj.service.esign;

import com.timevale.esign.sdk.tech.bean.PosBean;
import com.timevale.esign.sdk.tech.bean.SignPDFFileBean;
import com.timevale.esign.sdk.tech.bean.result.FileDigestSignResult;
import com.timevale.esign.sdk.tech.bean.result.Result;
import com.timevale.esign.sdk.tech.impl.constants.SignType;
import com.timevale.esign.sdk.tech.service.EsignsdkService;
import com.timevale.esign.sdk.tech.service.SelfSignService;
import com.timevale.esign.sdk.tech.service.factory.EsignsdkServiceFactory;
import com.timevale.esign.sdk.tech.service.factory.SelfSignServiceFactory;
import com.timevale.tech.sdk.bean.ProjectConfig;

/**
 * e签宝手动签署类
 */
public class EsignSign {

	// 生产环境配置
	public final static String projectId = "1111564752";
	public final static String projectSecret = "19a793b6cd152eef7ca117f66eb94ce1";
	public final static String itsmApiUrl = "http://itsm.tsign.cn/tgmonitor/rest/app!getAPIInfo2";
	
	// 测试环境配置
//	public final static String projectId = "1111563517";
//	public final static String projectSecret = "95439b0863c241c63a861b87d1e647b7";
//	public final static String itsmApiUrl = "http://121.40.164.61:8080/tgmonitor/rest/app!getAPIInfo2";
	
	public static void main(String[] args) throws Exception {
		init();
		platformPdfSign_file();
	}
	
	
	/**
	 * 初始化sdk
	 */
	private static void init() throws Exception{
		// 设置项目配置信息
		ProjectConfig pcCfg = new ProjectConfig();
		
		pcCfg.setProjectId(projectId);
		pcCfg.setProjectSecret(projectSecret);
		pcCfg.setItsmApiUrl(itsmApiUrl);
		
		EsignsdkService sdkService = EsignsdkServiceFactory.instance();
		Result rs = sdkService.init(pcCfg, null, null);
		if (rs.getErrCode() != 0) {
			throw new Exception("e签宝SDK初始化失败，失败信息：" + rs.getMsg());
		}
	}
	
	/**
	 * 平台签署
	 */
	private static void platformPdfSign_file() throws Exception {

		SignPDFFileBean pdfFile = new SignPDFFileBean();
		pdfFile.setSrcPdfFile("D:\\罗良军结清证明_20200407.pdf");
		pdfFile.setDstPdfFile("C:\\Users\\Administrator\\Desktop\\罗良军结清证明_20200407.pdf");
		
		PosBean signPos = new PosBean();
		signPos.setPosType(0);		//定位类型，0-坐标定位，1-关键字定位，默认0
		signPos.setPosPage("1");	//签署页码，若为多页签章，支持页码格式“1-3,5,8“，若为坐标定位时，不可空
		signPos.setPosX(420);		//签署位置X坐标，若为关键字定位，相对于关键字的X坐标偏移量，默认0
		signPos.setPosY(440);		//签署位置Y坐标，若为关键字定位，相对于关键字的Y坐标偏移量，默认0
//		signPos.setWidth(34);		//印章展现宽度，将以此宽度对印章图片做同比缩放。1)	为空：若图片宽度超过159，印章宽度等比缩小至159；若图片宽度小于159，印章尺寸默认以图片大小为准；2)不为空,印章宽度以传入参数为准。

		SelfSignService selfSignSrv = SelfSignServiceFactory.instance();
		FileDigestSignResult result = selfSignSrv.localSignPdf(pdfFile, signPos, 0, SignType.Single);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}
	}
}
