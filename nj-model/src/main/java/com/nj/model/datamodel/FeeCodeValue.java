package com.nj.model.datamodel;

public class FeeCodeValue {

	private String code;				//费用编码
	private String value;				//费用值
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "FeeCodeValue [code=" + code + ", value=" + value + "]";
	}	
}
