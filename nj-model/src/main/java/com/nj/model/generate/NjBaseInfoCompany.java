package com.nj.model.generate;

import io.swagger.annotations.ApiModelProperty;

public class NjBaseInfoCompany {
    private String id;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String companyName;

    /**
     * 统一社会信用代码
     */
    @ApiModelProperty(value = "统一社会信用代码")
    private String tyshCode;

    /**
     * 营业执照编号
     */
    @ApiModelProperty(value = "营业执照编号")
    private String yezzCode;

    /**
     * 税务登记号
     */
    @ApiModelProperty(value = "税务登记号")
    private String swdjCode;

    /**
     * 组织机构代码
     */
    @ApiModelProperty(value = "组织机构代码")
    private String zzjgCode;

    /**
     * 机构信用代码
     */
    @ApiModelProperty(value = "机构信用代码")
    private String jgxyCode;

    /**
     * 开户行许可证核准号
     */
    @ApiModelProperty(value = "开户行许可证核准号")
    private String bankXkzCode;

    /**
     * 银行对公账号
     */
    @ApiModelProperty(value = "银行对公账号")
    private String bankOutAccount;

    /**
     * 企业主体性质
     */
    @ApiModelProperty(value = "企业主体性质")
    private String companyNature;

    /**
     * 所属行业
     */
    @ApiModelProperty(value = "所属行业")
    private String ownIndustry;

    /**
     * 注册资本
     */
    @ApiModelProperty(value = "注册资本")
    private String registMoney;

    /**
     * 注册地址
     */
    @ApiModelProperty(value = "注册地址")
    private String registAddress;

    /**
     * 办公地址
     */
    @ApiModelProperty(value = "办公地址")
    private String companyAddress;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private String createDate;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 成立时间
     */
    @ApiModelProperty(value = "成立时间")
    private String companyCreateDate;

    /**
     * 
     * @return id 
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 企业名称
     * @return company_name 企业名称
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 企业名称
     * @param companyName 企业名称
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 统一社会信用代码
     * @return tysh_code 统一社会信用代码
     */
    public String getTyshCode() {
        return tyshCode;
    }

    /**
     * 统一社会信用代码
     * @param tyshCode 统一社会信用代码
     */
    public void setTyshCode(String tyshCode) {
        this.tyshCode = tyshCode;
    }

    /**
     * 营业执照编号
     * @return yezz_code 营业执照编号
     */
    public String getYezzCode() {
        return yezzCode;
    }

    /**
     * 营业执照编号
     * @param yezzCode 营业执照编号
     */
    public void setYezzCode(String yezzCode) {
        this.yezzCode = yezzCode;
    }

    /**
     * 税务登记号
     * @return swdj_code 税务登记号
     */
    public String getSwdjCode() {
        return swdjCode;
    }

    /**
     * 税务登记号
     * @param swdjCode 税务登记号
     */
    public void setSwdjCode(String swdjCode) {
        this.swdjCode = swdjCode;
    }

    /**
     * 组织机构代码
     * @return zzjg_code 组织机构代码
     */
    public String getZzjgCode() {
        return zzjgCode;
    }

    /**
     * 组织机构代码
     * @param zzjgCode 组织机构代码
     */
    public void setZzjgCode(String zzjgCode) {
        this.zzjgCode = zzjgCode;
    }

    /**
     * 机构信用代码
     * @return jgxy_code 机构信用代码
     */
    public String getJgxyCode() {
        return jgxyCode;
    }

    /**
     * 机构信用代码
     * @param jgxyCode 机构信用代码
     */
    public void setJgxyCode(String jgxyCode) {
        this.jgxyCode = jgxyCode;
    }

    /**
     * 开户行许可证核准号
     * @return bank_xkz_code 开户行许可证核准号
     */
    public String getBankXkzCode() {
        return bankXkzCode;
    }

    /**
     * 开户行许可证核准号
     * @param bankXkzCode 开户行许可证核准号
     */
    public void setBankXkzCode(String bankXkzCode) {
        this.bankXkzCode = bankXkzCode;
    }

    /**
     * 银行对公账号
     * @return bank_out_account 银行对公账号
     */
    public String getBankOutAccount() {
        return bankOutAccount;
    }

    /**
     * 银行对公账号
     * @param bankOutAccount 银行对公账号
     */
    public void setBankOutAccount(String bankOutAccount) {
        this.bankOutAccount = bankOutAccount;
    }

    /**
     * 企业主体性质
     * @return company_nature 企业主体性质
     */
    public String getCompanyNature() {
        return companyNature;
    }

    /**
     * 企业主体性质
     * @param companyNature 企业主体性质
     */
    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    /**
     * 所属行业
     * @return own_industry 所属行业
     */
    public String getOwnIndustry() {
        return ownIndustry;
    }

    /**
     * 所属行业
     * @param ownIndustry 所属行业
     */
    public void setOwnIndustry(String ownIndustry) {
        this.ownIndustry = ownIndustry;
    }

    /**
     * 注册资本
     * @return regist_money 注册资本
     */
    public String getRegistMoney() {
        return registMoney;
    }

    /**
     * 注册资本
     * @param registMoney 注册资本
     */
    public void setRegistMoney(String registMoney) {
        this.registMoney = registMoney;
    }

    /**
     * 注册地址
     * @return regist_address 注册地址
     */
    public String getRegistAddress() {
        return registAddress;
    }

    /**
     * 注册地址
     * @param registAddress 注册地址
     */
    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress;
    }

    /**
     * 办公地址
     * @return company_address 办公地址
     */
    public String getCompanyAddress() {
        return companyAddress;
    }

    /**
     * 办公地址
     * @param companyAddress 办公地址
     */
    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    /**
     * 创建时间
     * @return create_date 创建时间
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 成立时间
     * @return company_create_date 成立时间
     */
    public String getCompanyCreateDate() {
        return companyCreateDate;
    }

    /**
     * 成立时间
     * @param companyCreateDate 成立时间
     */
    public void setCompanyCreateDate(String companyCreateDate) {
        this.companyCreateDate = companyCreateDate;
    }
}