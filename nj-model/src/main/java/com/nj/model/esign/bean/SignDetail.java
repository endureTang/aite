package com.nj.model.esign.bean;

import java.util.List;

import com.timevale.esign.sdk.tech.bean.CertInfoBean;
import com.timevale.esign.sdk.tech.bean.EventBean.EventTargetBean;
import com.timevale.esign.sdk.tech.bean.SignatureInfoBean;

/**
 * 签署详情
 * @author wkh
 *
 */
public class SignDetail {

	private String comment;						//时间内容描述
	private List<EventTargetBean> signers;		//签署事件关联的对象集合
	private CertInfoBean signCert;				//签名使用的证书信息
	private SignatureInfoBean signature;		//签署详情
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public List<EventTargetBean> getSigners() {
		return signers;
	}
	public void setSigners(List<EventTargetBean> signers) {
		this.signers = signers;
	}
	public CertInfoBean getSignCert() {
		return signCert;
	}
	public void setSignCert(CertInfoBean signCert) {
		this.signCert = signCert;
	}
	public SignatureInfoBean getSignature() {
		return signature;
	}
	public void setSignature(SignatureInfoBean signature) {
		this.signature = signature;
	}
}
