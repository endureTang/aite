package com.nj.core.base.enums;

/**
 * 资产推送渠道
 * 
 * @author Administrator
 *
 */
public enum ECapitalEndChannel {
	microCredit(1, "小贷资金"),
	p2p(2, "p2p资金");

	protected int id;
	protected String desc;
	

	private ECapitalEndChannel(int id, String desc) {
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

	public static ECapitalEndChannel getEpayChannel(int id) {
		for (ECapitalEndChannel einfo : ECapitalEndChannel.values()) {
			if (einfo.getId()==id) {
				return einfo;
			}
		}
		return null;
	}
}
