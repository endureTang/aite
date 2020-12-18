package com.nj.admin.stockQueryApi.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OpenApi {
	/**
	 * �ӿ�����
	 */
	@Value("wdgj.erp.warehouse.detail")
	public String method;
	/**
	 * ������Ч����Ȩ��
	 */
	@Value("1d9f5fd4962244c9b70c3950c3faf366")
	public String accesstoken;
	/**
	 * ����Ӧ�ý���ʱ�����appkey
	 */
	@Value("40420831")
	public String appkey;
	/**
	 * ����Ӧ�ý���ʱ�����appsecret
	 */
	@Value("malc12m3agg1285kk2ae20eag19797b9")
	public String appsecret;
	/**
	 * ��ǰʱ���Unixʱ���
	 */
	public String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
	/**
	 * ���ݷ���ֵ��ʽxml/json��Ĭ��xml��
	 */
	public String format = "xml";
	/**
	 * Э��汾�ţ�1.1��
	 */
	public String versions = "1.1";
	/**
	 * ǩ��
	 */
	public String sign;
	/**
	 * ���Ͳ��� ����ʱʹ��
	 */
	public String postparas;
	/**
	 * �ӿڵ�ַ  http://api.wdgj.com/wdgjcloud/api
	 */
	public String url = "http://api.wdgj.com/wdgjcloud/api";
	/**
	 * �������
	 */
	public Map<String, String> requestparas = new HashMap<String, String>();
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getAccesstoken() {
		return accesstoken;
	}
	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}
	public String getAppkey() {
		return appkey;
	}
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getVersions() {
		return versions;
	}
	public void setVersions(String versions) {
		this.versions = versions;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	public String getPostparas() {
		return postparas;
	}
	public void setPostparas(String postparas) {
		this.postparas = postparas;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Map<String, String> getRequestparas() {
		return requestparas;
	}
	public void setRequestparas(Map<String, String> requestparas) {
		this.requestparas = requestparas;
	}
}
