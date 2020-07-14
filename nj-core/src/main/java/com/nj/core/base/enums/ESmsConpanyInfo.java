package com.nj.core.base.enums;

/**
 * 短信公司编号
 * @author MaSong
 * @date 2018-07-20 15:06:06
 */
public enum ESmsConpanyInfo {
	
	RLYSMS("容联云通讯","rlysms"),
	ALISMS("阿里大鱼","alisms");
	
	protected String value;
	protected String name;
	
	private ESmsConpanyInfo(String name,String value){
        this.name=name;
        this.value=value;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
