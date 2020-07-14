package com.nj.core.base.enums;

/**
 * 
 * @Name com.nj.core.base.enums.EProcessResult
 * @Description 
 * 
 * @Author bruce
 * @Version 2018年2月11日 上午9:13:32
 * @Copyright 金鼎财富
 *
 */
public enum EProcessResult {
	AGREE("通过",(short)1),
	REJECT("驳回",(short)2),
	REFUSE("拒绝",(short)3),
	PAUSE("暂停",(short)4),
	SKIPCHECK("跳过人工审核",(short)5);
	
	protected String name;
    protected short value;
    protected String remark;
    /**
     * 结果状态
     */
    private int resultStatus=0;
    
    private EProcessResult(String name, short value){
        this.name=name;
        this.value=value;
        this.remark="";
    }
    public static EProcessResult getEProcessResult(short value) {
    	for(EProcessResult epresult:EProcessResult.values()) {
    		if(epresult.getValue()==value) {
    			return epresult;
    		}
    	}
    	return null;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getValue() {
		return value;
	}

	public void setValue(short value) {
		this.value = value;
	}
	public String getRemark() {
		if(remark.equals("")) {
			remark = name;
		}
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getResultStatus() {
		return resultStatus;
	}
	public void setResultStatus(int resultStatus) {
		this.resultStatus = resultStatus;
	}
    
    
}
