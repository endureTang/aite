package com.nj.core.base.enums;

/**
 * 
 * @Name com.nj.core.base.enums.ERoleType
 * @Description 产品数据字典 配置项  分类
 * 
 * @Author bruce
 * @Version 2018年6月26日 上午9:37:06
 * @Copyright 金鼎财富
 *
 */
public enum EBusinessDictType {
	BASEINFO("个人基本信息",new String[] {"1","77","168","181"}),
	WORKINFO("职业收入信息",new String[] {"2","78","182"}),
	CONTACTINFO("联系人信息",new String[] {"3","183"}),
	CONTACTINFOOTHER("紧急联系人信息",new String[] {"80"}),
	ASSETSINFO("场景/其他个人资产信息",new String[] {"4","82","184"}),
	ATTACHEDINFO("附件信息",new String[] {"5","6","8","84","86","179","185","186","270","277","291"}),
	SPOUSEINFO("配偶信息",new String[] {"79"}),
	PAWNINFO("抵押物信息",new String[] {"81"}),
	AUTHORIZATION("授权信息",new String[] {"7,85","179","187"}),
	COMPANYBASEINFO("企业资料基本信息",new String[] {"288"}),
	COMPANYRELATEINFO("企业联系人信息",new String[] {"289"}),
	COMPANYSCENESINFO("企业场景信息",new String[] {"290"}),
	LIABILITIESINFO("负债情况",new String[] {"83"});

	protected String name;
	protected String[] value;
    
	private EBusinessDictType(String name,String[] value){
        this.name=name;
        this.value=value;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getValue() {
		return value;
	}

	public void setValue(String[] value) {
		this.value = value;
	}

}
