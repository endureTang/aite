package com.nj.enterprise.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.nj.core.base.common.AddressConstants;
import com.nj.core.base.util.FileOperationUtil;

/**
 * 
 * @Name com.nj.service.common.EnterpriseConfigService
 * @Description 业务后台配置服务
 * 
 * @Author bruce
 * @Version 2018年4月13日 下午4:43:48
 * @Copyright 金鼎财富
 *
 */
@Component
@PropertySource(value = {"classpath:${spring.profiles.active}/appConfig.properties"},encoding="utf-8")  
@ConfigurationProperties
public class EnterpriseConfig{
	@Autowired
	private Environment env;
	
	/**
	 * 当前环境
	 */
	private  String active;
	/**
	 * 金鼎财务接口地址
	 */
	@Value("${jdcf_url}")
	protected String jdcfUrl;
	/**
	 * 金鼎财富提供的aes_key
	 */
	@Value("${jdcf_aes_key}")
	protected String jdcfAesKey;
	
	@Value("${jdcf_call_back_key}")
	public String jdcfCallBackKey;
	/**
	 * 成都金坤订单流程个数
	 */
	@Value("${cdjk_process_number}")
	private Integer cdjkProcessNumber;
	
	/**
	 * 图片存放路径
	 */
	@Value("${image_file_dir}")
	private String imageFileDir;
	
	/**
	 * 登录token秘钥
	 */
	@Value("${token_secret}")
	private String tokenSecret;
	
	/**
	 * 登录token超时时间
	 */
	@Value("${token_over_time}")
	private String tokenOverTime;
	/**
	 * 支付宝银行卡所属查询地址
	 */
	@Value("${ali_bank_info_url}")
	private String aliBankInfoUrl;
	
	@Bean
	public String InitConstant() {
		AddressConstants.JdcfUrl = jdcfUrl;
		AddressConstants.JdcfAesKey = jdcfAesKey;
		AddressConstants.jdcfCallBackKey = jdcfCallBackKey;
		AddressConstants.CdjkProcessNumber = cdjkProcessNumber;
		AddressConstants.AliBankInfoUrl = aliBankInfoUrl;
		active = env.getProperty("spring.profiles.active");
		FileOperationUtil.FILE_DIR = imageFileDir;
		return active;
	}

	public String getActive() {
		active = env.getProperty("spring.profiles.active");
		return active;
	}

	public String getJdcfUrl() {
		return jdcfUrl;
	}

	public void setJdcfUrl(String jdcfUrl) {
		this.jdcfUrl = jdcfUrl;
	}

	public String getJdcfAesKey() {
		return jdcfAesKey;
	}

	public void setJdcfAesKey(String jdcfAesKey) {
		this.jdcfAesKey = jdcfAesKey;
	}

	public String getJdcfCallBackKey() {
		return jdcfCallBackKey;
	}

	public void setJdcfCallBackKey(String jdcfCallBackKey) {
		this.jdcfCallBackKey = jdcfCallBackKey;
	}

	public Integer getCdjkProcessNumber() {
		return cdjkProcessNumber;
	}

	public void setCdjkProcessNumber(Integer cdjkProcessNumber) {
		this.cdjkProcessNumber = cdjkProcessNumber;
	}

	public String getTokenSecret() {
		return tokenSecret;
	}

	public void setTokenSecret(String tokenSecret) {
		this.tokenSecret = tokenSecret;
	}

	public String getTokenOverTime() {
		return tokenOverTime;
	}

	public void setTokenOverTime(String tokenOverTime) {
		this.tokenOverTime = tokenOverTime;
	}
	
}
	
