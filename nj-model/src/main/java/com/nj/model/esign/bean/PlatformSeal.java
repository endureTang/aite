package com.nj.model.esign.bean;

/**
 * 平台印章sealId
 * @author wkh
 *
 */
public enum PlatformSeal {

	DEFAULT(0);
	
	private int value;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	private PlatformSeal(int value){
		this.value = value;
	}
}
