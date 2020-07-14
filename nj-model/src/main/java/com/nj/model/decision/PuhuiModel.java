package com.nj.model.decision;

import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Lizy
 * @version 2018/4/24.
 */
public class PuhuiModel {
    /**
     * 贷款编号
     */
    @ApiModelProperty(value = "贷款编号")
    private String loanNo;
    /**
     * 商品总价
     */
    @ApiModelProperty(value = "商品总价")
    private BigDecimal goodPrice;
    /**
     * 首付金额
     */
    @ApiModelProperty(value = "首付金额")
    private BigDecimal fisrtPay;
    /**
     * 首次还款额
     */
    @ApiModelProperty(value = "首次还款额")
    private BigDecimal firstRepay;
    /**
     * 贷款金额
     */
    @ApiModelProperty(value = "贷款金额")
    private BigDecimal amt;
    /**
     * 月还款金额
     */
    @ApiModelProperty(value = "月还款金额")
    private BigDecimal repayAmt;
    /**
     * 分期期数
     */
    @ApiModelProperty(value = "分期期数")
    private Integer period;
    /**
     * 客户账户开户行
     */
    @ApiModelProperty(value = "客户账户开户行")
    private String acctName;
    /**
     * 提交日期
     */
    @ApiModelProperty(value = "提交日期")
    private Date dlvDate;
    /**
     * 审批日期
     */
    @ApiModelProperty(value = "审批日期")
    private Date auditDate;
    /**
     * 是否保险
     */
    @ApiModelProperty(value = "是否保险")
    private String insurance;
    /**
     * 灵活还款包
     */
    @ApiModelProperty(value = "灵活还款包")
    private String flxPackage;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;
    /**
     * 证件有效期
     */
    @ApiModelProperty(value = "证件有效期")
    private Date idAva;
    /**
     * 证件发证机关
     */
    @ApiModelProperty(value = "证件发证机关")
    private String idIssue;
    /**
     * 户籍类型
     */
    @ApiModelProperty(value = "户籍类型")
    private String resType;
    /**
     * 省
     */
    @ApiModelProperty(value = "省")
    private String prv;
    /**
     * 市
     */
    @ApiModelProperty(value = "市")
    private String city;
    /**
     * 居住地址是否同户籍
     */
    @ApiModelProperty(value = "居住地址是否同户籍")
    private String isAddRes;
    /**
     * 住房性质
     */
    @ApiModelProperty(value = "住房性质")
    private String houseType;
    /**
     * 现地址居住时间（月）
     */
    @ApiModelProperty(value = "现地址居住时间（月）")
    private String crrAddTime;
    /**
     * 现居住省
     */
    @ApiModelProperty(value = "现居住省")
    private String prv1;
    /**
     * 居住市
     */
    @ApiModelProperty(value = "居住市")
    private String city1;
    /**
     * 资料类型
     */
    @ApiModelProperty(value = "资料类型")
    private String docType;
    /**
     * 月租金
     */
    @ApiModelProperty(value = "月租金")
    private String rentFee;
    /**
     * 民族
     */
    @ApiModelProperty(value = "民族")
    private String race;
    /**
     * 手机号码使用年限
     */
    @ApiModelProperty(value = "手机号码使用年限")
    private String mobileMths;
    /**
     * 每月平均消费话费
     */
    @ApiModelProperty(value = "每月平均消费话费")
    private String mthBill;
    /**
     * 手机号码是否实名
     */
    @ApiModelProperty(value = "手机号码是否实名")
    private String isVerified;
    /**
     * qq
     */
    @ApiModelProperty(value = "qq")
    private String qq;
    /**
     * 婚姻状况
     */
    @ApiModelProperty(value = "婚姻状况")
    private String marrState;
    /**
     * 配偶电话，0为无，1为有
     */
    @ApiModelProperty(value = "配偶电话")
    private String spouseMobile;
    /**
     * 工作单位
     */
    @ApiModelProperty(value = "工作单位")
    private String crrOrgName;
    /**
     * 单位性质
     */
    @ApiModelProperty(value = "单位性质")
    private String orgType;
    /**
     * 是否有单位电话，0为无，1为有
     */
    @ApiModelProperty(value = "是否有单位电话")
    private String orgPhone;
    /**
     * 任职部门
     */
    @ApiModelProperty(value = "任职部门")
    private String dpt;
    /**
     * 职位
     */
    @ApiModelProperty(value = "职位")
    private String position;
    /**
     * 所属行业
     */
    @ApiModelProperty(value = "所属行业")
    private String industry;
    /**
     * 现单位工作时间
     */
    @ApiModelProperty(value = "现单位工作时间")
    private String workTime;
    /**
     * 单位省
     */
    @ApiModelProperty(value = "单位省")
    private String prv2;
    /**
     * 单位市
     */
    @ApiModelProperty(value = "单位市")
    private String city2;
    /**
     * 单位联系人电话，0为无，1为有
     */
    @ApiModelProperty(value = "单位联系人电话")
    private String orgContactMobile;
    /**
     * 学制
     */
    @ApiModelProperty(value = "学制")
    private String eduType;
    /**
     * 联系人职位
     */
    @ApiModelProperty(value = "联系人职位")
    private String orgContactPosition;
    /**
     * 单位规模
     */
    @ApiModelProperty(value = "单位规模")
    private String orgSize;
    /**
     * 个人收入
     */
    @ApiModelProperty(value = "个人收入")
    private String income;

    /**
     * 受教育程度
     */
    @ApiModelProperty(value = "受教育程度")
    private String eduLevel;

    /**
     * 是否办理过贷款
     */
    @ApiModelProperty(value = "是否办理过贷款")
    private String isPastLoan;
    /**
     * 产品代码
     */
    @ApiModelProperty(value = "产品代码")
    private String productId;

    /**
     * 渠道代码
     */
    @ApiModelProperty(value = "渠道代码")
    private String channelId;

    /**
     * 客户类型
     */
    @ApiModelProperty(value = "客户类型")
    private String userType;
    /**
     * 申请日期
     */
    @ApiModelProperty(value = "申请日期")
    private Date applyDate;
    /**
     * 审批结果
     */
    @ApiModelProperty(value = "审批结果")
    private String aprovResult;

    /**
     * 文件类型
     */
    @ApiModelProperty(value = "文件类型")
    private String fileType;
    /**
     * 决定原因
     */
    @ApiModelProperty(value = "决定原因")
    private String aprovReason;
    /**
     * 注册日期
     */
    @ApiModelProperty(value = "注册日期")
    private Date registDate;
    /**
     * 是否返回销售
     */
    @ApiModelProperty(value = "是否返回销售")
    private String isBackSale;
    /**
     * 是否返回审核
     */
    @ApiModelProperty(value = "是否返回审核")
    private String isBackCheck;

    /**
     * 门店所在省
     */
    @ApiModelProperty(value = "门店所在省")
    private String storeProv;

    /**
     * 门店所在城市
     */
    @ApiModelProperty(value = "门店所在城市")
    private String storeCity;

    /**
     * 商品类型,分类为 手机/电动车/其他：CASE WHEN regexp_LIKE(GOODS_TYPE,'(手机)') then '手机'
     * when regexp_LIKE(GOODS_TYPE,'(电动车）|（电瓶车）|（摩托车）|（三轮车）|（机车）|（电动自行车)')
     * then '电动车' else '其他' end GOODS_TYPE
     */
    @ApiModelProperty(value = "商品类型")
    private String goodsType;

    /**
     * 品牌,分类为 苹果/三星/其他：case when regexp_LIKE(A.BRAND,'(iphone)|(ipad)|(iPhone)|(iPhone6)|(iPad)|(Iphone)|(Iphone)|(Ipad)|(IPAD)|(Apple)|(APPLE)|(Ipad)|(IPHONE)') then '苹果'
     * when regexp_LIKE(A.BRAND,'(三星)') then '三星'
     * else '其它' end  BRAND
     */
    @ApiModelProperty(value = "品牌")
    private String brand;

    /**
     * 审批时长
     */
    @ApiModelProperty(value = "审批时长")
    private String aprovDuration;

    /**
     * 审核时长
     */
    @ApiModelProperty(value = "审核时长")
    private String checkDuration;

    /**
     * 复核时长
     */
    @ApiModelProperty(value = "复核时长")
    private String reCheckDuration;

    /**
     * 生日
     */
    @ApiModelProperty(value = "生日")
    private Date birthday;

    /**
     * 所学专业
     */
    @ApiModelProperty(value = "所学专业")
    private String profession;

    /**
     * 商户签约日期
     */
    @ApiModelProperty(value = "商户签约日期")
    private Date signDate;

    /**
     * 微信
     */
    @ApiModelProperty(value = "微信")
    private String weichat;

    public String getLoanNo() {
        return loanNo;
    }

    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    public BigDecimal getFisrtPay() {
        return fisrtPay;
    }

    public void setFisrtPay(BigDecimal fisrtPay) {
        this.fisrtPay = fisrtPay;
    }

    public BigDecimal getFirstRepay() {
        return firstRepay;
    }

    public void setFirstRepay(BigDecimal firstRepay) {
        this.firstRepay = firstRepay;
    }

    public BigDecimal getAmt() {
        return amt;
    }

    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    public BigDecimal getRepayAmt() {
        return repayAmt;
    }

    public void setRepayAmt(BigDecimal repayAmt) {
        this.repayAmt = repayAmt;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public Date getDlvDate() {
        return dlvDate;
    }

    public void setDlvDate(Date dlvDate) {
        this.dlvDate = dlvDate;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getFlxPackage() {
        return flxPackage;
    }

    public void setFlxPackage(String flxPackage) {
        this.flxPackage = flxPackage;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getIdAva() {
        return idAva;
    }

    public void setIdAva(Date idAva) {
        this.idAva = idAva;
    }

    public String getIdIssue() {
        return idIssue;
    }

    public void setIdIssue(String idIssue) {
        this.idIssue = idIssue;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public String getPrv() {
        return prv;
    }

    public void setPrv(String prv) {
        this.prv = prv;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getIsAddRes() {
        return isAddRes;
    }

    public void setIsAddRes(String isAddRes) {
        this.isAddRes = isAddRes;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getCrrAddTime() {
        return crrAddTime;
    }

    public void setCrrAddTime(String crrAddTime) {
        this.crrAddTime = crrAddTime;
    }

    public String getPrv1() {
        return prv1;
    }

    public void setPrv1(String prv1) {
        this.prv1 = prv1;
    }

    public String getCity1() {
        return city1;
    }

    public void setCity1(String city1) {
        this.city1 = city1;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getRentFee() {
        return rentFee;
    }

    public void setRentFee(String rentFee) {
        this.rentFee = rentFee;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getMobileMths() {
        return mobileMths;
    }

    public void setMobileMths(String mobileMths) {
        this.mobileMths = mobileMths;
    }

    public String getMthBill() {
        return mthBill;
    }

    public void setMthBill(String mthBill) {
        this.mthBill = mthBill;
    }

    public String getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMarrState() {
        return marrState;
    }

    public void setMarrState(String marrState) {
        this.marrState = marrState;
    }

    public String getSpouseMobile() {
        return spouseMobile;
    }

    public void setSpouseMobile(String spouseMobile) {
        this.spouseMobile = spouseMobile;
    }

    public String getCrrOrgName() {
        return crrOrgName;
    }

    public void setCrrOrgName(String crrOrgName) {
        this.crrOrgName = crrOrgName;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgPhone() {
        return orgPhone;
    }

    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getPrv2() {
        return prv2;
    }

    public void setPrv2(String prv2) {
        this.prv2 = prv2;
    }

    public String getCity2() {
        return city2;
    }

    public void setCity2(String city2) {
        this.city2 = city2;
    }

    public String getOrgContactMobile() {
        return orgContactMobile;
    }

    public void setOrgContactMobile(String orgContactMobile) {
        this.orgContactMobile = orgContactMobile;
    }

    public String getEduType() {
        return eduType;
    }

    public void setEduType(String eduType) {
        this.eduType = eduType;
    }

    public String getOrgContactPosition() {
        return orgContactPosition;
    }

    public void setOrgContactPosition(String orgContactPosition) {
        this.orgContactPosition = orgContactPosition;
    }

    public String getOrgSize() {
        return orgSize;
    }

    public void setOrgSize(String orgSize) {
        this.orgSize = orgSize;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getIsPastLoan() {
        return isPastLoan;
    }

    public void setIsPastLoan(String isPastLoan) {
        this.isPastLoan = isPastLoan;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getAprovResult() {
        return aprovResult;
    }

    public void setAprovResult(String aprovResult) {
        this.aprovResult = aprovResult;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getAprovReason() {
        return aprovReason;
    }

    public void setAprovReason(String aprovReason) {
        this.aprovReason = aprovReason;
    }

    public Date getRegistDate() {
        return registDate;
    }

    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    public String getIsBackSale() {
        return isBackSale;
    }

    public void setIsBackSale(String isBackSale) {
        this.isBackSale = isBackSale;
    }

    public String getIsBackCheck() {
        return isBackCheck;
    }

    public void setIsBackCheck(String isBackCheck) {
        this.isBackCheck = isBackCheck;
    }

    public String getStoreProv() {
        return storeProv;
    }

    public void setStoreProv(String storeProv) {
        this.storeProv = storeProv;
    }

    public String getStoreCity() {
        return storeCity;
    }

    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getAprovDuration() {
        return aprovDuration;
    }

    public void setAprovDuration(String aprovDuration) {
        this.aprovDuration = aprovDuration;
    }

    public String getCheckDuration() {
        return checkDuration;
    }

    public void setCheckDuration(String checkDuration) {
        this.checkDuration = checkDuration;
    }

    public String getReCheckDuration() {
        return reCheckDuration;
    }

    public void setReCheckDuration(String reCheckDuration) {
        this.reCheckDuration = reCheckDuration;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getWeichat() {
        return weichat;
    }

    public void setWeichat(String weichat) {
        this.weichat = weichat;
    }
}
