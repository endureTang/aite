package com.nj.core.base.enums;

/**
 * 支付渠道枚举类
 * 
 * @author Administrator
 *
 */
public enum EpayChannel {
	jingding(1, "金鼎支付"),
	cib(2, "兴业存管");

	protected int id;
	protected String desc;
	

	private EpayChannel(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static EpayChannel getEpayChannel(int id) {
		for (EpayChannel einfo : EpayChannel.values()) {
			if (einfo.getId()==id) {
				return einfo;
			}
		}
		return null;
	}
}
