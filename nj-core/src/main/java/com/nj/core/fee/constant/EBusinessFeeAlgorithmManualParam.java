package com.nj.core.fee.constant;

/**
 * 业务费用算法需要输入的参数
 * 这些参数都是在放款时,由业务员手动输入的
 */
public enum EBusinessFeeAlgorithmManualParam {

	CHANNELFEE_TOTALAMOUNT("channelFee_totalAmount","渠道费总额",""),
	MEDIACYFEE_TOTALAMOUNT("mediacyFee_totalAmount","居间费总额","");
	
	private String code;			//算法编码
	private String name;			//算法名称
	private String explain;			//算法的说明文字
	
	private EBusinessFeeAlgorithmManualParam(String code,String name,String explain){
		this.code = code;
		this.name = name;
		this.explain = explain;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}
	public static  EBusinessFeeAlgorithmManualParam  getInstanse(String code){
		for(EBusinessFeeAlgorithmManualParam  obj:EBusinessFeeAlgorithmManualParam.values()){
			 if(obj.getCode().equalsIgnoreCase(code)){
				 return  obj;
			 }
		}
		return  null;
	}
}
