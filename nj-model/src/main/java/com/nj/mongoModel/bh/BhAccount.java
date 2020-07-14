package com.nj.mongoModel.bh;

import com.nj.mongoModel.MongoEntity;

/**
 * 百行征信账户信息
 * @author MaSong
 * @date 2019-08-05
 */
public class BhAccount extends MongoEntity{
	
	/**公司名称*/
	private String companyName;
	
	/**公司编号*/
	private String companyCode;
	
	/**账号信息*/
	private String account;
	
	/**密码*/
	private String password;
	
	/**公钥*/
	private String publicKey;
	
	/**私钥*/
	private String privateKey;
	 

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}
}
