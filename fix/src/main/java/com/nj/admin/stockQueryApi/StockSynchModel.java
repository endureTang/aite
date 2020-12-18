package com.nj.admin.stockQueryApi;

import java.util.List;

public class StockSynchModel {
    public String warehouseno;
    public String tradeno;
    public String operater;
    public String type;
    public String keytype;
    public List<OrderGoodsObj> goodslist;
	public String getWarehouseno() {
		return warehouseno;
	}
	public void setWarehouseno(String warehouseno) {
		this.warehouseno = warehouseno;
	}
	public String getTradeno() {
		return tradeno;
	}
	public void setTradeno(String tradeno) {
		this.tradeno = tradeno;
	}
	public String getOperater() {
		return operater;
	}
	public void setOperater(String operater) {
		this.operater = operater;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeytype() {
		return keytype;
	}
	public void setKeytype(String keytype) {
		this.keytype = keytype;
	}
	public List<OrderGoodsObj> getGoodslist() {
		return goodslist;
	}
	public void setGoodslist(List<OrderGoodsObj> goodslist) {
		this.goodslist = goodslist;
	}
}


