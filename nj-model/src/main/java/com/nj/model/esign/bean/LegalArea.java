package com.nj.model.esign.bean;

/**
 * 归属地
 * @author wkh
 *
 */
public enum LegalArea {

	MAINLAND(0),HONGKONG(1),AOMEN(2),TAIWANG(3),WAIJI(4);
	
	private int value;

	public int getValue() {
		return value;
	}

	private LegalArea(int value){
		this.value = value;
	}
}
