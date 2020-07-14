package com.nj.service.esign;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.nj.core.base.dao.BaseDao;
import com.timevale.esign.sdk.tech.bean.result.Result;
import com.timevale.esign.sdk.tech.service.EsignsdkService;
import com.timevale.esign.sdk.tech.service.factory.EsignsdkServiceFactory;
import com.timevale.tech.sdk.bean.ProjectConfig;

public abstract class BaseEsignService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	private static Boolean isInit = false;		//是否已初始化
	
	@Autowired
	private Environment env;
	
	/**
	 * sdk初始化
	 */
	protected void sdkInit() throws Exception {
		if(!isInit){
			init();
		}
	}
	
	/**
	 * 初始化sdk
	 */
	private void init() throws Exception{
		// 设置项目配置信息
		ProjectConfig pcCfg = new ProjectConfig();
		
		pcCfg.setProjectId(env.getProperty("esign.projectId"));
		pcCfg.setProjectSecret(env.getProperty("esign.projectSecret"));
		pcCfg.setItsmApiUrl(env.getProperty("esign.itsmApiUrl"));
		
		EsignsdkService sdkService = EsignsdkServiceFactory.instance();
		Result rs = sdkService.init(pcCfg, null, null);
		if (rs.getErrCode() != 0) {
			throw new Exception("e签宝SDK初始化失败，失败信息：" + rs.getMsg());
		}
		
		isInit = true;
	}
}
