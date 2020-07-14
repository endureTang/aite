package com.nj.model.esign.constants;

public class EsignCoporateAccountConstant {

	public static final int ACCOUNTTYPE_COPORATE = 1;		//企业账户
	public static final int ACCOUNTTYPE_LEGAL = 2;			//法人账户
	
	public static String getAcctTypeStr(int type){
		switch (type) {
		case ACCOUNTTYPE_COPORATE:
			return "企业账户";
		case ACCOUNTTYPE_LEGAL:
			return "法人账户";
		default:
			return "";
		}
	}
}
