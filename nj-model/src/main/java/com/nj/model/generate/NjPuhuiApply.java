package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjPuhuiApply {
    /**
     * 贷款编号
     */
    @ApiModelProperty(value = "贷款编号")
    private String loanNo;

    /**
     * 贷款类型
     */
    @ApiModelProperty(value = "贷款类型")
    private String loanType;

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
     * 代收手续费
     */
    @ApiModelProperty(value = "代收手续费")
    private BigDecimal repayFee;

    /**
     * 贷款金额
     */
    @ApiModelProperty(value = "贷款金额")
    private BigDecimal amt;

    /**
     * 首次还款日
     */
    @ApiModelProperty(value = "首次还款日")
    private Date firstRepayDay;

    /**
     * 每月还款日
     */
    @ApiModelProperty(value = "每月还款日")
    private Date repayDay;

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
     * 客户账号
     */
    @ApiModelProperty(value = "客户账号")
    private String acct;

    /**
     * 客户账户户名
     */
    @ApiModelProperty(value = "客户账户户名")
    private String acctId;

    /**
     * 呵护账户开户行
     */
    @ApiModelProperty(value = "呵护账户开户行")
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
     * 月利率
     */
    @ApiModelProperty(value = "月利率")
    private BigDecimal monthRate;

    /**
     * bill都指话费
     */
    @ApiModelProperty(value = "bill都指话费")
    private Date firstBillDate;

    /**
     * 每月话费到账日
     */
    @ApiModelProperty(value = "每月话费到账日")
    private Date billDate;

    /**
     * 月代缴
     */
    @ApiModelProperty(value = "月代缴")
    private BigDecimal payOther;

    /**
     * 是否保险
     */
    @ApiModelProperty(value = "是否保险")
    private String insurance;

    /**
     * 保险费率
     */
    @ApiModelProperty(value = "保险费率")
    private BigDecimal insuranceRate;

    /**
     * 灵活还款包
     */
    @ApiModelProperty(value = "灵活还款包")
    private String flxPackage;

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
     * 活动代码
     */
    @ApiModelProperty(value = "活动代码")
    private String actvId;

    /**
     * 客户类型
     */
    @ApiModelProperty(value = "客户类型")
    private String userType;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String tureName;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 证件类型
     */
    @ApiModelProperty(value = "证件类型")
    private String idType;

    /**
     * 证件号
     */
    @ApiModelProperty(value = "证件号")
    private String identifyId;

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
     * 区/县
     */
    @ApiModelProperty(value = "区/县")
    private String county;

    /**
     * 镇
     */
    @ApiModelProperty(value = "镇")
    private String town;

    /**
     * 路/街道/村
     */
    @ApiModelProperty(value = "路/街道/村")
    private String str;

    /**
     * 小区/楼盘
     */
    @ApiModelProperty(value = "小区/楼盘")
    private String cmty;

    /**
     * 栋/单元/房号
     */
    @ApiModelProperty(value = "栋/单元/房号")
    private String houseNo;

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

    private String prv1;

    private String city1;

    private String county1;

    private String town1;

    private String str1;

    private String cmty1;

    private String houseNo1;

    private String docType;

    private String rentFee;

    private String race;

    private String mobile;

    private String mobileMths;

    private String mthBill;

    private String isVerified;

    private String addPhone;

    private String addPhoneAcc;

    private String eMail;

    private String qq;

    /**
     * 婚姻状态
     */
    @ApiModelProperty(value = "婚姻状态")
    private String marrState;

    /**
     * 配偶姓名
     */
    @ApiModelProperty(value = "配偶姓名")
    private String spouseName;

    /**
     * 配偶电话
     */
    @ApiModelProperty(value = "配偶电话")
    private String spouseMobile;

    /**
     * 家庭成员姓名
     */
    @ApiModelProperty(value = "家庭成员姓名")
    private String fmlName;

    /**
     * 关系
     */
    @ApiModelProperty(value = "关系")
    private String relation;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String fmlContact;

    /**
     * 家庭成员是否知道
     */
    @ApiModelProperty(value = "家庭成员是否知道")
    private String isKFlm;

    /**
     * 是否有效2
     */
    @ApiModelProperty(value = "是否有效2")
    private String isValid2;

    /**
     * 家庭成员居住地是否同户籍
     */
    @ApiModelProperty(value = "家庭成员居住地是否同户籍")
    private String isFmlRes;

    /**
     * 家庭居住地
     */
    @ApiModelProperty(value = "家庭居住地")
    private String fmlAdd;

    private String isSpouseCtcTrue;

    private String isFmlCtcTrue;

    private String crrOrgName;

    private String orgType;

    private String orgPhone;

    private String orgName;

    private String dpt;

    private String position;

    private String industry;

    private String workTime;

    private String prv2;

    private String city2;

    private String county2;

    private String town2;

    private String str2;

    private String str3;

    private String cmty2;

    private String houseNo2;

    private String isValid;

    private String orgContact;

    private String orgContactMobile;

    private String eduType;

    private String orgContactPosition;

    private String orgSize;

    private String income;

    private String fmlIncome;

    private String eduLevel;

    private String isPastLoan;

    private BigDecimal pastLoanRepay;

    private String isValid3;

    private Date applyDate;

    private String aprovResult;

    private String aprovRemark;

    private String fileType;

    private String aprovReason;

    private Date registDate;

    private String isBackSale;

    private String isBackCheck;

    private String bussNo;

    private String storeNo;

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
     * 门店所在区或县
     */
    @ApiModelProperty(value = "门店所在区或县")
    private String storeArea;

    /**
     * 商品类型
     */
    @ApiModelProperty(value = "商品类型")
    private String goodsType;

    /**
     * 品牌
     */
    @ApiModelProperty(value = "品牌")
    private String brand;

    /**
     * 型号
     */
    @ApiModelProperty(value = "型号")
    private String marques;

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
     * 销售备注
     */
    @ApiModelProperty(value = "销售备注")
    private String saleRemark;

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

    /**
     * 贷款编号
     * @return loan_no 贷款编号
     */
    public String getLoanNo() {
        return loanNo;
    }

    /**
     * 贷款编号
     * @param loanNo 贷款编号
     */
    public void setLoanNo(String loanNo) {
        this.loanNo = loanNo;
    }

    /**
     * 贷款类型
     * @return loan_type 贷款类型
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * 贷款类型
     * @param loanType 贷款类型
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    /**
     * 商品总价
     * @return good_price 商品总价
     */
    public BigDecimal getGoodPrice() {
        return goodPrice;
    }

    /**
     * 商品总价
     * @param goodPrice 商品总价
     */
    public void setGoodPrice(BigDecimal goodPrice) {
        this.goodPrice = goodPrice;
    }

    /**
     * 首付金额
     * @return fisrt_pay 首付金额
     */
    public BigDecimal getFisrtPay() {
        return fisrtPay;
    }

    /**
     * 首付金额
     * @param fisrtPay 首付金额
     */
    public void setFisrtPay(BigDecimal fisrtPay) {
        this.fisrtPay = fisrtPay;
    }

    /**
     * 首次还款额
     * @return first_repay 首次还款额
     */
    public BigDecimal getFirstRepay() {
        return firstRepay;
    }

    /**
     * 首次还款额
     * @param firstRepay 首次还款额
     */
    public void setFirstRepay(BigDecimal firstRepay) {
        this.firstRepay = firstRepay;
    }

    /**
     * 代收手续费
     * @return repay_fee 代收手续费
     */
    public BigDecimal getRepayFee() {
        return repayFee;
    }

    /**
     * 代收手续费
     * @param repayFee 代收手续费
     */
    public void setRepayFee(BigDecimal repayFee) {
        this.repayFee = repayFee;
    }

    /**
     * 贷款金额
     * @return amt 贷款金额
     */
    public BigDecimal getAmt() {
        return amt;
    }

    /**
     * 贷款金额
     * @param amt 贷款金额
     */
    public void setAmt(BigDecimal amt) {
        this.amt = amt;
    }

    /**
     * 首次还款日
     * @return first_repay_day 首次还款日
     */
    public Date getFirstRepayDay() {
        return firstRepayDay;
    }

    /**
     * 首次还款日
     * @param firstRepayDay 首次还款日
     */
    public void setFirstRepayDay(Date firstRepayDay) {
        this.firstRepayDay = firstRepayDay;
    }

    /**
     * 每月还款日
     * @return repay_day 每月还款日
     */
    public Date getRepayDay() {
        return repayDay;
    }

    /**
     * 每月还款日
     * @param repayDay 每月还款日
     */
    public void setRepayDay(Date repayDay) {
        this.repayDay = repayDay;
    }

    /**
     * 月还款金额
     * @return repay_amt 月还款金额
     */
    public BigDecimal getRepayAmt() {
        return repayAmt;
    }

    /**
     * 月还款金额
     * @param repayAmt 月还款金额
     */
    public void setRepayAmt(BigDecimal repayAmt) {
        this.repayAmt = repayAmt;
    }

    /**
     * 分期期数
     * @return period 分期期数
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 分期期数
     * @param period 分期期数
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 客户账号
     * @return acct 客户账号
     */
    public String getAcct() {
        return acct;
    }

    /**
     * 客户账号
     * @param acct 客户账号
     */
    public void setAcct(String acct) {
        this.acct = acct;
    }

    /**
     * 客户账户户名
     * @return acct_id 客户账户户名
     */
    public String getAcctId() {
        return acctId;
    }

    /**
     * 客户账户户名
     * @param acctId 客户账户户名
     */
    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    /**
     * 呵护账户开户行
     * @return acct_name 呵护账户开户行
     */
    public String getAcctName() {
        return acctName;
    }

    /**
     * 呵护账户开户行
     * @param acctName 呵护账户开户行
     */
    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    /**
     * 提交日期
     * @return dlv_date 提交日期
     */
    public Date getDlvDate() {
        return dlvDate;
    }

    /**
     * 提交日期
     * @param dlvDate 提交日期
     */
    public void setDlvDate(Date dlvDate) {
        this.dlvDate = dlvDate;
    }

    /**
     * 审批日期
     * @return audit_date 审批日期
     */
    public Date getAuditDate() {
        return auditDate;
    }

    /**
     * 审批日期
     * @param auditDate 审批日期
     */
    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    /**
     * 月利率
     * @return month_rate 月利率
     */
    public BigDecimal getMonthRate() {
        return monthRate;
    }

    /**
     * 月利率
     * @param monthRate 月利率
     */
    public void setMonthRate(BigDecimal monthRate) {
        this.monthRate = monthRate;
    }

    /**
     * bill都指话费
     * @return first_bill_date bill都指话费
     */
    public Date getFirstBillDate() {
        return firstBillDate;
    }

    /**
     * bill都指话费
     * @param firstBillDate bill都指话费
     */
    public void setFirstBillDate(Date firstBillDate) {
        this.firstBillDate = firstBillDate;
    }

    /**
     * 每月话费到账日
     * @return bill_date 每月话费到账日
     */
    public Date getBillDate() {
        return billDate;
    }

    /**
     * 每月话费到账日
     * @param billDate 每月话费到账日
     */
    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    /**
     * 月代缴
     * @return pay_other 月代缴
     */
    public BigDecimal getPayOther() {
        return payOther;
    }

    /**
     * 月代缴
     * @param payOther 月代缴
     */
    public void setPayOther(BigDecimal payOther) {
        this.payOther = payOther;
    }

    /**
     * 是否保险
     * @return insurance 是否保险
     */
    public String getInsurance() {
        return insurance;
    }

    /**
     * 是否保险
     * @param insurance 是否保险
     */
    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    /**
     * 保险费率
     * @return insurance_rate 保险费率
     */
    public BigDecimal getInsuranceRate() {
        return insuranceRate;
    }

    /**
     * 保险费率
     * @param insuranceRate 保险费率
     */
    public void setInsuranceRate(BigDecimal insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    /**
     * 灵活还款包
     * @return flx_package 灵活还款包
     */
    public String getFlxPackage() {
        return flxPackage;
    }

    /**
     * 灵活还款包
     * @param flxPackage 灵活还款包
     */
    public void setFlxPackage(String flxPackage) {
        this.flxPackage = flxPackage;
    }

    /**
     * 产品代码
     * @return product_id 产品代码
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 产品代码
     * @param productId 产品代码
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 渠道代码
     * @return channel_id 渠道代码
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 渠道代码
     * @param channelId 渠道代码
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 活动代码
     * @return actv_id 活动代码
     */
    public String getActvId() {
        return actvId;
    }

    /**
     * 活动代码
     * @param actvId 活动代码
     */
    public void setActvId(String actvId) {
        this.actvId = actvId;
    }

    /**
     * 客户类型
     * @return user_type 客户类型
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 客户类型
     * @param userType 客户类型
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 姓名
     * @return ture_name 姓名
     */
    public String getTureName() {
        return tureName;
    }

    /**
     * 姓名
     * @param tureName 姓名
     */
    public void setTureName(String tureName) {
        this.tureName = tureName;
    }

    /**
     * 性别
     * @return sex 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 证件类型
     * @return id_type 证件类型
     */
    public String getIdType() {
        return idType;
    }

    /**
     * 证件类型
     * @param idType 证件类型
     */
    public void setIdType(String idType) {
        this.idType = idType;
    }

    /**
     * 证件号
     * @return identify_id 证件号
     */
    public String getIdentifyId() {
        return identifyId;
    }

    /**
     * 证件号
     * @param identifyId 证件号
     */
    public void setIdentifyId(String identifyId) {
        this.identifyId = identifyId;
    }

    /**
     * 证件有效期
     * @return id_ava 证件有效期
     */
    public Date getIdAva() {
        return idAva;
    }

    /**
     * 证件有效期
     * @param idAva 证件有效期
     */
    public void setIdAva(Date idAva) {
        this.idAva = idAva;
    }

    /**
     * 证件发证机关
     * @return id_issue 证件发证机关
     */
    public String getIdIssue() {
        return idIssue;
    }

    /**
     * 证件发证机关
     * @param idIssue 证件发证机关
     */
    public void setIdIssue(String idIssue) {
        this.idIssue = idIssue;
    }

    /**
     * 户籍类型
     * @return res_type 户籍类型
     */
    public String getResType() {
        return resType;
    }

    /**
     * 户籍类型
     * @param resType 户籍类型
     */
    public void setResType(String resType) {
        this.resType = resType;
    }

    /**
     * 省
     * @return prv 省
     */
    public String getPrv() {
        return prv;
    }

    /**
     * 省
     * @param prv 省
     */
    public void setPrv(String prv) {
        this.prv = prv;
    }

    /**
     * 市
     * @return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 区/县
     * @return county 区/县
     */
    public String getCounty() {
        return county;
    }

    /**
     * 区/县
     * @param county 区/县
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 镇
     * @return town 镇
     */
    public String getTown() {
        return town;
    }

    /**
     * 镇
     * @param town 镇
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * 路/街道/村
     * @return str 路/街道/村
     */
    public String getStr() {
        return str;
    }

    /**
     * 路/街道/村
     * @param str 路/街道/村
     */
    public void setStr(String str) {
        this.str = str;
    }

    /**
     * 小区/楼盘
     * @return cmty 小区/楼盘
     */
    public String getCmty() {
        return cmty;
    }

    /**
     * 小区/楼盘
     * @param cmty 小区/楼盘
     */
    public void setCmty(String cmty) {
        this.cmty = cmty;
    }

    /**
     * 栋/单元/房号
     * @return house_no 栋/单元/房号
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * 栋/单元/房号
     * @param houseNo 栋/单元/房号
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * 居住地址是否同户籍
     * @return is_add_res 居住地址是否同户籍
     */
    public String getIsAddRes() {
        return isAddRes;
    }

    /**
     * 居住地址是否同户籍
     * @param isAddRes 居住地址是否同户籍
     */
    public void setIsAddRes(String isAddRes) {
        this.isAddRes = isAddRes;
    }

    /**
     * 住房性质
     * @return house_type 住房性质
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * 住房性质
     * @param houseType 住房性质
     */
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    /**
     * 现地址居住时间（月）
     * @return crr_add_time 现地址居住时间（月）
     */
    public String getCrrAddTime() {
        return crrAddTime;
    }

    /**
     * 现地址居住时间（月）
     * @param crrAddTime 现地址居住时间（月）
     */
    public void setCrrAddTime(String crrAddTime) {
        this.crrAddTime = crrAddTime;
    }

    /**
     * 
     * @return prv1 
     */
    public String getPrv1() {
        return prv1;
    }

    /**
     * 
     * @param prv1 
     */
    public void setPrv1(String prv1) {
        this.prv1 = prv1;
    }

    /**
     * 
     * @return city1 
     */
    public String getCity1() {
        return city1;
    }

    /**
     * 
     * @param city1 
     */
    public void setCity1(String city1) {
        this.city1 = city1;
    }

    /**
     * 
     * @return county1 
     */
    public String getCounty1() {
        return county1;
    }

    /**
     * 
     * @param county1 
     */
    public void setCounty1(String county1) {
        this.county1 = county1;
    }

    /**
     * 
     * @return town1 
     */
    public String getTown1() {
        return town1;
    }

    /**
     * 
     * @param town1 
     */
    public void setTown1(String town1) {
        this.town1 = town1;
    }

    /**
     * 
     * @return str1 
     */
    public String getStr1() {
        return str1;
    }

    /**
     * 
     * @param str1 
     */
    public void setStr1(String str1) {
        this.str1 = str1;
    }

    /**
     * 
     * @return cmty1 
     */
    public String getCmty1() {
        return cmty1;
    }

    /**
     * 
     * @param cmty1 
     */
    public void setCmty1(String cmty1) {
        this.cmty1 = cmty1;
    }

    /**
     * 
     * @return house_no1 
     */
    public String getHouseNo1() {
        return houseNo1;
    }

    /**
     * 
     * @param houseNo1 
     */
    public void setHouseNo1(String houseNo1) {
        this.houseNo1 = houseNo1;
    }

    /**
     * 
     * @return doc_type 
     */
    public String getDocType() {
        return docType;
    }

    /**
     * 
     * @param docType 
     */
    public void setDocType(String docType) {
        this.docType = docType;
    }

    /**
     * 
     * @return rent_fee 
     */
    public String getRentFee() {
        return rentFee;
    }

    /**
     * 
     * @param rentFee 
     */
    public void setRentFee(String rentFee) {
        this.rentFee = rentFee;
    }

    /**
     * 
     * @return race 
     */
    public String getRace() {
        return race;
    }

    /**
     * 
     * @param race 
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * 
     * @return mobile 
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 
     * @param mobile 
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 
     * @return mobile_mths 
     */
    public String getMobileMths() {
        return mobileMths;
    }

    /**
     * 
     * @param mobileMths 
     */
    public void setMobileMths(String mobileMths) {
        this.mobileMths = mobileMths;
    }

    /**
     * 
     * @return mth_bill 
     */
    public String getMthBill() {
        return mthBill;
    }

    /**
     * 
     * @param mthBill 
     */
    public void setMthBill(String mthBill) {
        this.mthBill = mthBill;
    }

    /**
     * 
     * @return is_verified 
     */
    public String getIsVerified() {
        return isVerified;
    }

    /**
     * 
     * @param isVerified 
     */
    public void setIsVerified(String isVerified) {
        this.isVerified = isVerified;
    }

    /**
     * 
     * @return add_phone 
     */
    public String getAddPhone() {
        return addPhone;
    }

    /**
     * 
     * @param addPhone 
     */
    public void setAddPhone(String addPhone) {
        this.addPhone = addPhone;
    }

    /**
     * 
     * @return add_phone_acc 
     */
    public String getAddPhoneAcc() {
        return addPhoneAcc;
    }

    /**
     * 
     * @param addPhoneAcc 
     */
    public void setAddPhoneAcc(String addPhoneAcc) {
        this.addPhoneAcc = addPhoneAcc;
    }

    /**
     * 
     * @return e_mail 
     */
    public String geteMail() {
        return eMail;
    }

    /**
     * 
     * @param eMail 
     */
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    /**
     * 
     * @return qq 
     */
    public String getQq() {
        return qq;
    }

    /**
     * 
     * @param qq 
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 婚姻状态
     * @return marr_state 婚姻状态
     */
    public String getMarrState() {
        return marrState;
    }

    /**
     * 婚姻状态
     * @param marrState 婚姻状态
     */
    public void setMarrState(String marrState) {
        this.marrState = marrState;
    }

    /**
     * 配偶姓名
     * @return spouse_name 配偶姓名
     */
    public String getSpouseName() {
        return spouseName;
    }

    /**
     * 配偶姓名
     * @param spouseName 配偶姓名
     */
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    /**
     * 配偶电话
     * @return spouse_mobile 配偶电话
     */
    public String getSpouseMobile() {
        return spouseMobile;
    }

    /**
     * 配偶电话
     * @param spouseMobile 配偶电话
     */
    public void setSpouseMobile(String spouseMobile) {
        this.spouseMobile = spouseMobile;
    }

    /**
     * 家庭成员姓名
     * @return fml_name 家庭成员姓名
     */
    public String getFmlName() {
        return fmlName;
    }

    /**
     * 家庭成员姓名
     * @param fmlName 家庭成员姓名
     */
    public void setFmlName(String fmlName) {
        this.fmlName = fmlName;
    }

    /**
     * 关系
     * @return relation 关系
     */
    public String getRelation() {
        return relation;
    }

    /**
     * 关系
     * @param relation 关系
     */
    public void setRelation(String relation) {
        this.relation = relation;
    }

    /**
     * 联系电话
     * @return fml_contact 联系电话
     */
    public String getFmlContact() {
        return fmlContact;
    }

    /**
     * 联系电话
     * @param fmlContact 联系电话
     */
    public void setFmlContact(String fmlContact) {
        this.fmlContact = fmlContact;
    }

    /**
     * 家庭成员是否知道
     * @return is_k_flm 家庭成员是否知道
     */
    public String getIsKFlm() {
        return isKFlm;
    }

    /**
     * 家庭成员是否知道
     * @param isKFlm 家庭成员是否知道
     */
    public void setIsKFlm(String isKFlm) {
        this.isKFlm = isKFlm;
    }

    /**
     * 是否有效2
     * @return is_valid2 是否有效2
     */
    public String getIsValid2() {
        return isValid2;
    }

    /**
     * 是否有效2
     * @param isValid2 是否有效2
     */
    public void setIsValid2(String isValid2) {
        this.isValid2 = isValid2;
    }

    /**
     * 家庭成员居住地是否同户籍
     * @return is_fml_res 家庭成员居住地是否同户籍
     */
    public String getIsFmlRes() {
        return isFmlRes;
    }

    /**
     * 家庭成员居住地是否同户籍
     * @param isFmlRes 家庭成员居住地是否同户籍
     */
    public void setIsFmlRes(String isFmlRes) {
        this.isFmlRes = isFmlRes;
    }

    /**
     * 家庭居住地
     * @return fml_add 家庭居住地
     */
    public String getFmlAdd() {
        return fmlAdd;
    }

    /**
     * 家庭居住地
     * @param fmlAdd 家庭居住地
     */
    public void setFmlAdd(String fmlAdd) {
        this.fmlAdd = fmlAdd;
    }

    /**
     * 
     * @return is_spouse_ctc_true 
     */
    public String getIsSpouseCtcTrue() {
        return isSpouseCtcTrue;
    }

    /**
     * 
     * @param isSpouseCtcTrue 
     */
    public void setIsSpouseCtcTrue(String isSpouseCtcTrue) {
        this.isSpouseCtcTrue = isSpouseCtcTrue;
    }

    /**
     * 
     * @return is_fml_ctc_true 
     */
    public String getIsFmlCtcTrue() {
        return isFmlCtcTrue;
    }

    /**
     * 
     * @param isFmlCtcTrue 
     */
    public void setIsFmlCtcTrue(String isFmlCtcTrue) {
        this.isFmlCtcTrue = isFmlCtcTrue;
    }

    /**
     * 
     * @return crr_org_name 
     */
    public String getCrrOrgName() {
        return crrOrgName;
    }

    /**
     * 
     * @param crrOrgName 
     */
    public void setCrrOrgName(String crrOrgName) {
        this.crrOrgName = crrOrgName;
    }

    /**
     * 
     * @return org_type 
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 
     * @param orgType 
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    /**
     * 
     * @return org_phone 
     */
    public String getOrgPhone() {
        return orgPhone;
    }

    /**
     * 
     * @param orgPhone 
     */
    public void setOrgPhone(String orgPhone) {
        this.orgPhone = orgPhone;
    }

    /**
     * 
     * @return org_name 
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 
     * @param orgName 
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 
     * @return dpt 
     */
    public String getDpt() {
        return dpt;
    }

    /**
     * 
     * @param dpt 
     */
    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    /**
     * 
     * @return position 
     */
    public String getPosition() {
        return position;
    }

    /**
     * 
     * @param position 
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * 
     * @return industry 
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 
     * @param industry 
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 
     * @return work_time 
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * 
     * @param workTime 
     */
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    /**
     * 
     * @return prv2 
     */
    public String getPrv2() {
        return prv2;
    }

    /**
     * 
     * @param prv2 
     */
    public void setPrv2(String prv2) {
        this.prv2 = prv2;
    }

    /**
     * 
     * @return city2 
     */
    public String getCity2() {
        return city2;
    }

    /**
     * 
     * @param city2 
     */
    public void setCity2(String city2) {
        this.city2 = city2;
    }

    /**
     * 
     * @return county2 
     */
    public String getCounty2() {
        return county2;
    }

    /**
     * 
     * @param county2 
     */
    public void setCounty2(String county2) {
        this.county2 = county2;
    }

    /**
     * 
     * @return town2 
     */
    public String getTown2() {
        return town2;
    }

    /**
     * 
     * @param town2 
     */
    public void setTown2(String town2) {
        this.town2 = town2;
    }

    /**
     * 
     * @return str2 
     */
    public String getStr2() {
        return str2;
    }

    /**
     * 
     * @param str2 
     */
    public void setStr2(String str2) {
        this.str2 = str2;
    }

    /**
     * 
     * @return str3 
     */
    public String getStr3() {
        return str3;
    }

    /**
     * 
     * @param str3 
     */
    public void setStr3(String str3) {
        this.str3 = str3;
    }

    /**
     * 
     * @return cmty2 
     */
    public String getCmty2() {
        return cmty2;
    }

    /**
     * 
     * @param cmty2 
     */
    public void setCmty2(String cmty2) {
        this.cmty2 = cmty2;
    }

    /**
     * 
     * @return house_no2 
     */
    public String getHouseNo2() {
        return houseNo2;
    }

    /**
     * 
     * @param houseNo2 
     */
    public void setHouseNo2(String houseNo2) {
        this.houseNo2 = houseNo2;
    }

    /**
     * 
     * @return is_valid 
     */
    public String getIsValid() {
        return isValid;
    }

    /**
     * 
     * @param isValid 
     */
    public void setIsValid(String isValid) {
        this.isValid = isValid;
    }

    /**
     * 
     * @return org_contact 
     */
    public String getOrgContact() {
        return orgContact;
    }

    /**
     * 
     * @param orgContact 
     */
    public void setOrgContact(String orgContact) {
        this.orgContact = orgContact;
    }

    /**
     * 
     * @return org_contact_mobile 
     */
    public String getOrgContactMobile() {
        return orgContactMobile;
    }

    /**
     * 
     * @param orgContactMobile 
     */
    public void setOrgContactMobile(String orgContactMobile) {
        this.orgContactMobile = orgContactMobile;
    }

    /**
     * 
     * @return edu_type 
     */
    public String getEduType() {
        return eduType;
    }

    /**
     * 
     * @param eduType 
     */
    public void setEduType(String eduType) {
        this.eduType = eduType;
    }

    /**
     * 
     * @return org_contact_position 
     */
    public String getOrgContactPosition() {
        return orgContactPosition;
    }

    /**
     * 
     * @param orgContactPosition 
     */
    public void setOrgContactPosition(String orgContactPosition) {
        this.orgContactPosition = orgContactPosition;
    }

    /**
     * 
     * @return org_size 
     */
    public String getOrgSize() {
        return orgSize;
    }

    /**
     * 
     * @param orgSize 
     */
    public void setOrgSize(String orgSize) {
        this.orgSize = orgSize;
    }

    /**
     * 
     * @return income 
     */
    public String getIncome() {
        return income;
    }

    /**
     * 
     * @param income 
     */
    public void setIncome(String income) {
        this.income = income;
    }

    /**
     * 
     * @return fml_income 
     */
    public String getFmlIncome() {
        return fmlIncome;
    }

    /**
     * 
     * @param fmlIncome 
     */
    public void setFmlIncome(String fmlIncome) {
        this.fmlIncome = fmlIncome;
    }

    /**
     * 
     * @return edu_level 
     */
    public String getEduLevel() {
        return eduLevel;
    }

    /**
     * 
     * @param eduLevel 
     */
    public void setEduLevel(String eduLevel) {
        this.eduLevel = eduLevel;
    }

    /**
     * 
     * @return is_past_loan 
     */
    public String getIsPastLoan() {
        return isPastLoan;
    }

    /**
     * 
     * @param isPastLoan 
     */
    public void setIsPastLoan(String isPastLoan) {
        this.isPastLoan = isPastLoan;
    }

    /**
     * 
     * @return past_loan_repay 
     */
    public BigDecimal getPastLoanRepay() {
        return pastLoanRepay;
    }

    /**
     * 
     * @param pastLoanRepay 
     */
    public void setPastLoanRepay(BigDecimal pastLoanRepay) {
        this.pastLoanRepay = pastLoanRepay;
    }

    /**
     * 
     * @return is_valid3 
     */
    public String getIsValid3() {
        return isValid3;
    }

    /**
     * 
     * @param isValid3 
     */
    public void setIsValid3(String isValid3) {
        this.isValid3 = isValid3;
    }

    /**
     * 
     * @return apply_date 
     */
    public Date getApplyDate() {
        return applyDate;
    }

    /**
     * 
     * @param applyDate 
     */
    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    /**
     * 
     * @return aprov_result 
     */
    public String getAprovResult() {
        return aprovResult;
    }

    /**
     * 
     * @param aprovResult 
     */
    public void setAprovResult(String aprovResult) {
        this.aprovResult = aprovResult;
    }

    /**
     * 
     * @return aprov_remark 
     */
    public String getAprovRemark() {
        return aprovRemark;
    }

    /**
     * 
     * @param aprovRemark 
     */
    public void setAprovRemark(String aprovRemark) {
        this.aprovRemark = aprovRemark;
    }

    /**
     * 
     * @return file_type 
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * 
     * @param fileType 
     */
    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    /**
     * 
     * @return aprov_reason 
     */
    public String getAprovReason() {
        return aprovReason;
    }

    /**
     * 
     * @param aprovReason 
     */
    public void setAprovReason(String aprovReason) {
        this.aprovReason = aprovReason;
    }

    /**
     * 
     * @return regist_date 
     */
    public Date getRegistDate() {
        return registDate;
    }

    /**
     * 
     * @param registDate 
     */
    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    /**
     * 
     * @return is_back_sale 
     */
    public String getIsBackSale() {
        return isBackSale;
    }

    /**
     * 
     * @param isBackSale 
     */
    public void setIsBackSale(String isBackSale) {
        this.isBackSale = isBackSale;
    }

    /**
     * 
     * @return is_back_check 
     */
    public String getIsBackCheck() {
        return isBackCheck;
    }

    /**
     * 
     * @param isBackCheck 
     */
    public void setIsBackCheck(String isBackCheck) {
        this.isBackCheck = isBackCheck;
    }

    /**
     * 
     * @return buss_no 
     */
    public String getBussNo() {
        return bussNo;
    }

    /**
     * 
     * @param bussNo 
     */
    public void setBussNo(String bussNo) {
        this.bussNo = bussNo;
    }

    /**
     * 
     * @return store_no 
     */
    public String getStoreNo() {
        return storeNo;
    }

    /**
     * 
     * @param storeNo 
     */
    public void setStoreNo(String storeNo) {
        this.storeNo = storeNo;
    }

    /**
     * 门店所在省
     * @return store_prov 门店所在省
     */
    public String getStoreProv() {
        return storeProv;
    }

    /**
     * 门店所在省
     * @param storeProv 门店所在省
     */
    public void setStoreProv(String storeProv) {
        this.storeProv = storeProv;
    }

    /**
     * 门店所在城市
     * @return store_city 门店所在城市
     */
    public String getStoreCity() {
        return storeCity;
    }

    /**
     * 门店所在城市
     * @param storeCity 门店所在城市
     */
    public void setStoreCity(String storeCity) {
        this.storeCity = storeCity;
    }

    /**
     * 门店所在区或县
     * @return store_area 门店所在区或县
     */
    public String getStoreArea() {
        return storeArea;
    }

    /**
     * 门店所在区或县
     * @param storeArea 门店所在区或县
     */
    public void setStoreArea(String storeArea) {
        this.storeArea = storeArea;
    }

    /**
     * 商品类型
     * @return goods_type 商品类型
     */
    public String getGoodsType() {
        return goodsType;
    }

    /**
     * 商品类型
     * @param goodsType 商品类型
     */
    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    /**
     * 品牌
     * @return brand 品牌
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 品牌
     * @param brand 品牌
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 型号
     * @return marques 型号
     */
    public String getMarques() {
        return marques;
    }

    /**
     * 型号
     * @param marques 型号
     */
    public void setMarques(String marques) {
        this.marques = marques;
    }

    /**
     * 审批时长
     * @return aprov_duration 审批时长
     */
    public String getAprovDuration() {
        return aprovDuration;
    }

    /**
     * 审批时长
     * @param aprovDuration 审批时长
     */
    public void setAprovDuration(String aprovDuration) {
        this.aprovDuration = aprovDuration;
    }

    /**
     * 审核时长
     * @return check_duration 审核时长
     */
    public String getCheckDuration() {
        return checkDuration;
    }

    /**
     * 审核时长
     * @param checkDuration 审核时长
     */
    public void setCheckDuration(String checkDuration) {
        this.checkDuration = checkDuration;
    }

    /**
     * 复核时长
     * @return re_check_duration 复核时长
     */
    public String getReCheckDuration() {
        return reCheckDuration;
    }

    /**
     * 复核时长
     * @param reCheckDuration 复核时长
     */
    public void setReCheckDuration(String reCheckDuration) {
        this.reCheckDuration = reCheckDuration;
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 销售备注
     * @return sale_remark 销售备注
     */
    public String getSaleRemark() {
        return saleRemark;
    }

    /**
     * 销售备注
     * @param saleRemark 销售备注
     */
    public void setSaleRemark(String saleRemark) {
        this.saleRemark = saleRemark;
    }

    /**
     * 所学专业
     * @return profession 所学专业
     */
    public String getProfession() {
        return profession;
    }

    /**
     * 所学专业
     * @param profession 所学专业
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     * 商户签约日期
     * @return sign_date 商户签约日期
     */
    public Date getSignDate() {
        return signDate;
    }

    /**
     * 商户签约日期
     * @param signDate 商户签约日期
     */
    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    /**
     * 微信
     * @return weichat 微信
     */
    public String getWeichat() {
        return weichat;
    }

    /**
     * 微信
     * @param weichat 微信
     */
    public void setWeichat(String weichat) {
        this.weichat = weichat;
    }
}