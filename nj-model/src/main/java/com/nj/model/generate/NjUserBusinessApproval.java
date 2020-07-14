package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserBusinessApproval {
    private String id;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private String orderId;

    /**
     * 身份证: 0复印件,1影像件,复选用井号隔开
     */
    @ApiModelProperty(value = "身份证: 0复印件,1影像件,复选用井号隔开")
    private String identityCard;

    /**
     * 配偶身份证: 0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "配偶身份证: 0复印件 1影像件，复选用井号隔开")
    private String spouseIdentityCard;

    /**
     * 户口：0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "户口：0复印件 1影像件，复选用井号隔开")
    private String houseAccount;

    /**
     * 配偶户口:0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "配偶户口:0复印件 1影像件，复选用井号隔开")
    private String spouseHouseAccount;

    /**
     * 婚姻证明:0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "婚姻证明:0复印件 1影像件，复选用井号隔开")
    private String marrProve;

    /**
     * 征信报告：0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "征信报告：0复印件 1影像件，复选用井号隔开")
    private String creditReport;

    /**
     * 配偶征信报告0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "配偶征信报告0复印件 1影像件，复选用井号隔开")
    private String spouseCreditReport;

    /**
     * 房产证：0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "房产证：0复印件 1影像件，复选用井号隔开")
    private String houseCertificate;

    /**
     * 国土证
     */
    @ApiModelProperty(value = "国土证")
    private String nationCertificate;

    /**
     * 房屋查询记录:0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "房屋查询记录:0复印件 1影像件，复选用井号隔开")
    private String houseQuery;

    /**
     * 6个月银行行流水：0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "6个月银行行流水：0复印件 1影像件，复选用井号隔开")
    private String bankDetail;

    /**
     * 特殊房产资料: 0复印件 1影像件，复选用井号隔开
     */
    @ApiModelProperty(value = "特殊房产资料: 0复印件 1影像件，复选用井号隔开")
    private String houseMessage;

    /**
     * 抵押现场照片:  0 无  1有
     */
    @ApiModelProperty(value = "抵押现场照片:  0 无  1有")
    private String pawnPhoto;

    /**
     * 合同证明： 0 无  1有
     */
    @ApiModelProperty(value = "合同证明： 0 无  1有")
    private String contractProve;

    /**
     * 其它证明
     */
    @ApiModelProperty(value = "其它证明")
    private String otherProve;

    /**
     * 意见：0 资料标准  1资料完整但部分为影像资料，放款前补齐复印件 2退件
     */
    @ApiModelProperty(value = "意见：0 资料标准  1资料完整但部分为影像资料，放款前补齐复印件 2退件")
    private String opinion;

    /**
     * 接收人
     */
    @ApiModelProperty(value = "接收人")
    private String userReceive;

    /**
     * 接收时间
     */
    @ApiModelProperty(value = "接收时间")
    private Date receiveTime;

    /**
     * 工作单位 :  0 不一致  1一致
     */
    @ApiModelProperty(value = "工作单位 :  0 不一致  1一致")
    private String workCompany;

    /**
     * 征信情况：  0：a类 ，1：b类 ， 2：c类
     */
    @ApiModelProperty(value = "征信情况：  0：a类 ，1：b类 ， 2：c类")
    private String creditResult;

    /**
     * 大数据查询情况
     */
    @ApiModelProperty(value = "大数据查询情况")
    private String bigdataQueryMessge;

    /**
     * 涉诉查询情况
     */
    @ApiModelProperty(value = "涉诉查询情况")
    private String lawsuitQueryMessage;

    /**
     * 家庭负债
     */
    @ApiModelProperty(value = "家庭负债")
    private BigDecimal famliyDebt;

    /**
     * 权证号、地址、所有权人: 0不一致  1一致
     */
    @ApiModelProperty(value = "权证号、地址、所有权人: 0不一致  1一致")
    private String warrantNo;

    /**
     * 区域 0一类区域  1二类区域  2三类区域
     */
    @ApiModelProperty(value = "区域 0一类区域  1二类区域  2三类区域")
    private String area;

    /**
     * 抵押顺位： 0 一抵   1二抵 （二抵时需要填写一抵机构名称）
     */
    @ApiModelProperty(value = "抵押顺位： 0 一抵   1二抵 （二抵时需要填写一抵机构名称）")
    private String pawnSw;

    /**
     * 一抵机构名称
     */
    @ApiModelProperty(value = "一抵机构名称")
    private String pawnOrg;

    /**
     * 唯一住房： 0否 1是
     */
    @ApiModelProperty(value = "唯一住房： 0否 1是")
    private String onlyHouse;

    /**
     * 房屋类型：0 一类房产  1二类房产  2三类房产
     */
    @ApiModelProperty(value = "房屋类型：0 一类房产  1二类房产  2三类房产")
    private String houseType;

    /**
     * 房屋状态： 0自住 1出租 2空置
     */
    @ApiModelProperty(value = "房屋状态： 0自住 1出租 2空置")
    private String houseStatus;

    /**
     * 房屋限售 0否1是
     */
    @ApiModelProperty(value = "房屋限售 0否1是")
    private String houseLimit;

    /**
     * 认定价格
     */
    @ApiModelProperty(value = "认定价格")
    private BigDecimal cognizancePrice;

    /**
     * 可贷额度
     */
    @ApiModelProperty(value = "可贷额度")
    private BigDecimal loanQuta;

    /**
     * 抵押率
     */
    @ApiModelProperty(value = "抵押率")
    private String pawnRate;

    /**
     * 贷款用途: 0 一致 1 基本一致 2 不一致
     */
    @ApiModelProperty(value = "贷款用途: 0 一致 1 基本一致 2 不一致")
    private String loanUsage;

    /**
     * 还款来源：0充足 1一般 2不足
     */
    @ApiModelProperty(value = "还款来源：0充足 1一般 2不足")
    private String repaySource;

    /**
     *  产品要求 0 不符合  1符合
     */
    @ApiModelProperty(value = " 产品要求 0 不符合  1符合")
    private String productRequire;

    /**
     * 要求明细
     */
    @ApiModelProperty(value = "要求明细")
    private String requireMessage;

    /**
     * 是否删除 0 否1 是
     */
    @ApiModelProperty(value = "是否删除 0 否1 是")
    private Boolean isDel;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 更新人
     */
    @ApiModelProperty(value = "更新人")
    private String updateBy;

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
     * 订单ID
     * @return order_id 订单ID
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单ID
     * @param orderId 订单ID
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 身份证: 0复印件,1影像件,复选用井号隔开
     * @return identity_card 身份证: 0复印件,1影像件,复选用井号隔开
     */
    public String getIdentityCard() {
        return identityCard;
    }

    /**
     * 身份证: 0复印件,1影像件,复选用井号隔开
     * @param identityCard 身份证: 0复印件,1影像件,复选用井号隔开
     */
    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    /**
     * 配偶身份证: 0复印件 1影像件，复选用井号隔开
     * @return spouse_identity_card 配偶身份证: 0复印件 1影像件，复选用井号隔开
     */
    public String getSpouseIdentityCard() {
        return spouseIdentityCard;
    }

    /**
     * 配偶身份证: 0复印件 1影像件，复选用井号隔开
     * @param spouseIdentityCard 配偶身份证: 0复印件 1影像件，复选用井号隔开
     */
    public void setSpouseIdentityCard(String spouseIdentityCard) {
        this.spouseIdentityCard = spouseIdentityCard;
    }

    /**
     * 户口：0复印件 1影像件，复选用井号隔开
     * @return house_account 户口：0复印件 1影像件，复选用井号隔开
     */
    public String getHouseAccount() {
        return houseAccount;
    }

    /**
     * 户口：0复印件 1影像件，复选用井号隔开
     * @param houseAccount 户口：0复印件 1影像件，复选用井号隔开
     */
    public void setHouseAccount(String houseAccount) {
        this.houseAccount = houseAccount;
    }

    /**
     * 配偶户口:0复印件 1影像件，复选用井号隔开
     * @return spouse_house_account 配偶户口:0复印件 1影像件，复选用井号隔开
     */
    public String getSpouseHouseAccount() {
        return spouseHouseAccount;
    }

    /**
     * 配偶户口:0复印件 1影像件，复选用井号隔开
     * @param spouseHouseAccount 配偶户口:0复印件 1影像件，复选用井号隔开
     */
    public void setSpouseHouseAccount(String spouseHouseAccount) {
        this.spouseHouseAccount = spouseHouseAccount;
    }

    /**
     * 婚姻证明:0复印件 1影像件，复选用井号隔开
     * @return marr_prove 婚姻证明:0复印件 1影像件，复选用井号隔开
     */
    public String getMarrProve() {
        return marrProve;
    }

    /**
     * 婚姻证明:0复印件 1影像件，复选用井号隔开
     * @param marrProve 婚姻证明:0复印件 1影像件，复选用井号隔开
     */
    public void setMarrProve(String marrProve) {
        this.marrProve = marrProve;
    }

    /**
     * 征信报告：0复印件 1影像件，复选用井号隔开
     * @return credit_report 征信报告：0复印件 1影像件，复选用井号隔开
     */
    public String getCreditReport() {
        return creditReport;
    }

    /**
     * 征信报告：0复印件 1影像件，复选用井号隔开
     * @param creditReport 征信报告：0复印件 1影像件，复选用井号隔开
     */
    public void setCreditReport(String creditReport) {
        this.creditReport = creditReport;
    }

    /**
     * 配偶征信报告0复印件 1影像件，复选用井号隔开
     * @return spouse_credit_report 配偶征信报告0复印件 1影像件，复选用井号隔开
     */
    public String getSpouseCreditReport() {
        return spouseCreditReport;
    }

    /**
     * 配偶征信报告0复印件 1影像件，复选用井号隔开
     * @param spouseCreditReport 配偶征信报告0复印件 1影像件，复选用井号隔开
     */
    public void setSpouseCreditReport(String spouseCreditReport) {
        this.spouseCreditReport = spouseCreditReport;
    }

    /**
     * 房产证：0复印件 1影像件，复选用井号隔开
     * @return house_certificate 房产证：0复印件 1影像件，复选用井号隔开
     */
    public String getHouseCertificate() {
        return houseCertificate;
    }

    /**
     * 房产证：0复印件 1影像件，复选用井号隔开
     * @param houseCertificate 房产证：0复印件 1影像件，复选用井号隔开
     */
    public void setHouseCertificate(String houseCertificate) {
        this.houseCertificate = houseCertificate;
    }

    /**
     * 国土证
     * @return nation_certificate 国土证
     */
    public String getNationCertificate() {
        return nationCertificate;
    }

    /**
     * 国土证
     * @param nationCertificate 国土证
     */
    public void setNationCertificate(String nationCertificate) {
        this.nationCertificate = nationCertificate;
    }

    /**
     * 房屋查询记录:0复印件 1影像件，复选用井号隔开
     * @return house_query 房屋查询记录:0复印件 1影像件，复选用井号隔开
     */
    public String getHouseQuery() {
        return houseQuery;
    }

    /**
     * 房屋查询记录:0复印件 1影像件，复选用井号隔开
     * @param houseQuery 房屋查询记录:0复印件 1影像件，复选用井号隔开
     */
    public void setHouseQuery(String houseQuery) {
        this.houseQuery = houseQuery;
    }

    /**
     * 6个月银行行流水：0复印件 1影像件，复选用井号隔开
     * @return bank_detail 6个月银行行流水：0复印件 1影像件，复选用井号隔开
     */
    public String getBankDetail() {
        return bankDetail;
    }

    /**
     * 6个月银行行流水：0复印件 1影像件，复选用井号隔开
     * @param bankDetail 6个月银行行流水：0复印件 1影像件，复选用井号隔开
     */
    public void setBankDetail(String bankDetail) {
        this.bankDetail = bankDetail;
    }

    /**
     * 特殊房产资料: 0复印件 1影像件，复选用井号隔开
     * @return house_message 特殊房产资料: 0复印件 1影像件，复选用井号隔开
     */
    public String getHouseMessage() {
        return houseMessage;
    }

    /**
     * 特殊房产资料: 0复印件 1影像件，复选用井号隔开
     * @param houseMessage 特殊房产资料: 0复印件 1影像件，复选用井号隔开
     */
    public void setHouseMessage(String houseMessage) {
        this.houseMessage = houseMessage;
    }

    /**
     * 抵押现场照片:  0 无  1有
     * @return pawn_photo 抵押现场照片:  0 无  1有
     */
    public String getPawnPhoto() {
        return pawnPhoto;
    }

    /**
     * 抵押现场照片:  0 无  1有
     * @param pawnPhoto 抵押现场照片:  0 无  1有
     */
    public void setPawnPhoto(String pawnPhoto) {
        this.pawnPhoto = pawnPhoto;
    }

    /**
     * 合同证明： 0 无  1有
     * @return contract_prove 合同证明： 0 无  1有
     */
    public String getContractProve() {
        return contractProve;
    }

    /**
     * 合同证明： 0 无  1有
     * @param contractProve 合同证明： 0 无  1有
     */
    public void setContractProve(String contractProve) {
        this.contractProve = contractProve;
    }

    /**
     * 其它证明
     * @return other_prove 其它证明
     */
    public String getOtherProve() {
        return otherProve;
    }

    /**
     * 其它证明
     * @param otherProve 其它证明
     */
    public void setOtherProve(String otherProve) {
        this.otherProve = otherProve;
    }

    /**
     * 意见：0 资料标准  1资料完整但部分为影像资料，放款前补齐复印件 2退件
     * @return opinion 意见：0 资料标准  1资料完整但部分为影像资料，放款前补齐复印件 2退件
     */
    public String getOpinion() {
        return opinion;
    }

    /**
     * 意见：0 资料标准  1资料完整但部分为影像资料，放款前补齐复印件 2退件
     * @param opinion 意见：0 资料标准  1资料完整但部分为影像资料，放款前补齐复印件 2退件
     */
    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    /**
     * 接收人
     * @return user_receive 接收人
     */
    public String getUserReceive() {
        return userReceive;
    }

    /**
     * 接收人
     * @param userReceive 接收人
     */
    public void setUserReceive(String userReceive) {
        this.userReceive = userReceive;
    }

    /**
     * 接收时间
     * @return receive_time 接收时间
     */
    public Date getReceiveTime() {
        return receiveTime;
    }

    /**
     * 接收时间
     * @param receiveTime 接收时间
     */
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    /**
     * 工作单位 :  0 不一致  1一致
     * @return work_company 工作单位 :  0 不一致  1一致
     */
    public String getWorkCompany() {
        return workCompany;
    }

    /**
     * 工作单位 :  0 不一致  1一致
     * @param workCompany 工作单位 :  0 不一致  1一致
     */
    public void setWorkCompany(String workCompany) {
        this.workCompany = workCompany;
    }

    /**
     * 征信情况：  0：a类 ，1：b类 ， 2：c类
     * @return credit_result 征信情况：  0：a类 ，1：b类 ， 2：c类
     */
    public String getCreditResult() {
        return creditResult;
    }

    /**
     * 征信情况：  0：a类 ，1：b类 ， 2：c类
     * @param creditResult 征信情况：  0：a类 ，1：b类 ， 2：c类
     */
    public void setCreditResult(String creditResult) {
        this.creditResult = creditResult;
    }

    /**
     * 大数据查询情况
     * @return bigdata_query_messge 大数据查询情况
     */
    public String getBigdataQueryMessge() {
        return bigdataQueryMessge;
    }

    /**
     * 大数据查询情况
     * @param bigdataQueryMessge 大数据查询情况
     */
    public void setBigdataQueryMessge(String bigdataQueryMessge) {
        this.bigdataQueryMessge = bigdataQueryMessge;
    }

    /**
     * 涉诉查询情况
     * @return lawsuit_query_message 涉诉查询情况
     */
    public String getLawsuitQueryMessage() {
        return lawsuitQueryMessage;
    }

    /**
     * 涉诉查询情况
     * @param lawsuitQueryMessage 涉诉查询情况
     */
    public void setLawsuitQueryMessage(String lawsuitQueryMessage) {
        this.lawsuitQueryMessage = lawsuitQueryMessage;
    }

    /**
     * 家庭负债
     * @return famliy_debt 家庭负债
     */
    public BigDecimal getFamliyDebt() {
        return famliyDebt;
    }

    /**
     * 家庭负债
     * @param famliyDebt 家庭负债
     */
    public void setFamliyDebt(BigDecimal famliyDebt) {
        this.famliyDebt = famliyDebt;
    }

    /**
     * 权证号、地址、所有权人: 0不一致  1一致
     * @return warrant_no 权证号、地址、所有权人: 0不一致  1一致
     */
    public String getWarrantNo() {
        return warrantNo;
    }

    /**
     * 权证号、地址、所有权人: 0不一致  1一致
     * @param warrantNo 权证号、地址、所有权人: 0不一致  1一致
     */
    public void setWarrantNo(String warrantNo) {
        this.warrantNo = warrantNo;
    }

    /**
     * 区域 0一类区域  1二类区域  2三类区域
     * @return area 区域 0一类区域  1二类区域  2三类区域
     */
    public String getArea() {
        return area;
    }

    /**
     * 区域 0一类区域  1二类区域  2三类区域
     * @param area 区域 0一类区域  1二类区域  2三类区域
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 抵押顺位： 0 一抵   1二抵 （二抵时需要填写一抵机构名称）
     * @return pawn_sw 抵押顺位： 0 一抵   1二抵 （二抵时需要填写一抵机构名称）
     */
    public String getPawnSw() {
        return pawnSw;
    }

    /**
     * 抵押顺位： 0 一抵   1二抵 （二抵时需要填写一抵机构名称）
     * @param pawnSw 抵押顺位： 0 一抵   1二抵 （二抵时需要填写一抵机构名称）
     */
    public void setPawnSw(String pawnSw) {
        this.pawnSw = pawnSw;
    }

    /**
     * 一抵机构名称
     * @return pawn_org 一抵机构名称
     */
    public String getPawnOrg() {
        return pawnOrg;
    }

    /**
     * 一抵机构名称
     * @param pawnOrg 一抵机构名称
     */
    public void setPawnOrg(String pawnOrg) {
        this.pawnOrg = pawnOrg;
    }

    /**
     * 唯一住房： 0否 1是
     * @return only_house 唯一住房： 0否 1是
     */
    public String getOnlyHouse() {
        return onlyHouse;
    }

    /**
     * 唯一住房： 0否 1是
     * @param onlyHouse 唯一住房： 0否 1是
     */
    public void setOnlyHouse(String onlyHouse) {
        this.onlyHouse = onlyHouse;
    }

    /**
     * 房屋类型：0 一类房产  1二类房产  2三类房产
     * @return house_type 房屋类型：0 一类房产  1二类房产  2三类房产
     */
    public String getHouseType() {
        return houseType;
    }

    /**
     * 房屋类型：0 一类房产  1二类房产  2三类房产
     * @param houseType 房屋类型：0 一类房产  1二类房产  2三类房产
     */
    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    /**
     * 房屋状态： 0自住 1出租 2空置
     * @return house_status 房屋状态： 0自住 1出租 2空置
     */
    public String getHouseStatus() {
        return houseStatus;
    }

    /**
     * 房屋状态： 0自住 1出租 2空置
     * @param houseStatus 房屋状态： 0自住 1出租 2空置
     */
    public void setHouseStatus(String houseStatus) {
        this.houseStatus = houseStatus;
    }

    /**
     * 房屋限售 0否1是
     * @return house_limit 房屋限售 0否1是
     */
    public String getHouseLimit() {
        return houseLimit;
    }

    /**
     * 房屋限售 0否1是
     * @param houseLimit 房屋限售 0否1是
     */
    public void setHouseLimit(String houseLimit) {
        this.houseLimit = houseLimit;
    }

    /**
     * 认定价格
     * @return cognizance_price 认定价格
     */
    public BigDecimal getCognizancePrice() {
        return cognizancePrice;
    }

    /**
     * 认定价格
     * @param cognizancePrice 认定价格
     */
    public void setCognizancePrice(BigDecimal cognizancePrice) {
        this.cognizancePrice = cognizancePrice;
    }

    /**
     * 可贷额度
     * @return loan_quta 可贷额度
     */
    public BigDecimal getLoanQuta() {
        return loanQuta;
    }

    /**
     * 可贷额度
     * @param loanQuta 可贷额度
     */
    public void setLoanQuta(BigDecimal loanQuta) {
        this.loanQuta = loanQuta;
    }

    /**
     * 抵押率
     * @return pawn_rate 抵押率
     */
    public String getPawnRate() {
        return pawnRate;
    }

    /**
     * 抵押率
     * @param pawnRate 抵押率
     */
    public void setPawnRate(String pawnRate) {
        this.pawnRate = pawnRate;
    }

    /**
     * 贷款用途: 0 一致 1 基本一致 2 不一致
     * @return loan_usage 贷款用途: 0 一致 1 基本一致 2 不一致
     */
    public String getLoanUsage() {
        return loanUsage;
    }

    /**
     * 贷款用途: 0 一致 1 基本一致 2 不一致
     * @param loanUsage 贷款用途: 0 一致 1 基本一致 2 不一致
     */
    public void setLoanUsage(String loanUsage) {
        this.loanUsage = loanUsage;
    }

    /**
     * 还款来源：0充足 1一般 2不足
     * @return repay_source 还款来源：0充足 1一般 2不足
     */
    public String getRepaySource() {
        return repaySource;
    }

    /**
     * 还款来源：0充足 1一般 2不足
     * @param repaySource 还款来源：0充足 1一般 2不足
     */
    public void setRepaySource(String repaySource) {
        this.repaySource = repaySource;
    }

    /**
     *  产品要求 0 不符合  1符合
     * @return product_require  产品要求 0 不符合  1符合
     */
    public String getProductRequire() {
        return productRequire;
    }

    /**
     *  产品要求 0 不符合  1符合
     * @param productRequire  产品要求 0 不符合  1符合
     */
    public void setProductRequire(String productRequire) {
        this.productRequire = productRequire;
    }

    /**
     * 要求明细
     * @return require_message 要求明细
     */
    public String getRequireMessage() {
        return requireMessage;
    }

    /**
     * 要求明细
     * @param requireMessage 要求明细
     */
    public void setRequireMessage(String requireMessage) {
        this.requireMessage = requireMessage;
    }

    /**
     * 是否删除 0 否1 是
     * @return is_del 是否删除 0 否1 是
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * 是否删除 0 否1 是
     * @param isDel 是否删除 0 否1 是
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 创建人
     * @return create_by 创建人
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 创建人
     * @param createBy 创建人
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 更新人
     * @return update_by 更新人
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新人
     * @param updateBy 更新人
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}