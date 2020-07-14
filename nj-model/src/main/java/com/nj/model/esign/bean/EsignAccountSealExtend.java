package com.nj.model.esign.bean;

import org.springframework.beans.BeanUtils;

import com.nj.model.esign.base.EsignAccountSeal;

public class EsignAccountSealExtend extends EsignAccountSeal{

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public EsignAccountSealExtend(EsignAccountSeal eas){
		BeanUtils.copyProperties(eas, this);
	}
	
}
