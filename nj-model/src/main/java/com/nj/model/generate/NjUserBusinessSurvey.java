package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class NjUserBusinessSurvey {
    private String id;

    /**
     * 抵押 ID
     */
    @ApiModelProperty(value = "抵押 ID")
    private String pawnId;

    /**
     * 订单ID
     */
    @ApiModelProperty(value = "订单ID")
    private String orderId;

    /**
     * 用户ID
     */
    @ApiModelProperty(value = "用户ID")
    private String userId;

    /**
     * 业务编号
     */
    @ApiModelProperty(value = "业务编号")
    private String businessNo;

    /**
     * 部门
     */
    @ApiModelProperty(value = "部门")
    private String department;

    /**
     * 客户经理ID
     */
    @ApiModelProperty(value = "客户经理ID")
    private String channelUserId;

    /**
     * 产品类型 : 1 一抵产品  2 二抵产品
     */
    @ApiModelProperty(value = "产品类型 : 1 一抵产品  2 二抵产品")
    private String productType;

    /**
     * 抵押物类型：  0 普通商品住房  1特殊房产 2商办公寓 3别墅 （0 一类房产 1二类房产 2 三类房产），目前该值未定
     */
    @ApiModelProperty(value = "抵押物类型：  0 普通商品住房  1特殊房产 2商办公寓 3别墅 （0 一类房产 1二类房产 2 三类房产），目前该值未定")
    private String pawnType;

    /**
     *  抵押区域 ： 0 一类区域  1二类区域  2三类区域
     */
    @ApiModelProperty(value = " 抵押区域 ： 0 一类区域  1二类区域  2三类区域")
    private String pawnArea;

    /**
     * 还款方式
     */
    @ApiModelProperty(value = "还款方式")
    private String repayWay;

    /**
     * 利率
     */
    @ApiModelProperty(value = "利率")
    private String rating;

    /**
     * 贷款类型 : 0 个人经营性贷款 1 个人消费贷款 
     */
    @ApiModelProperty(value = "贷款类型 : 0 个人经营性贷款 1 个人消费贷款 ")
    private String loanType;

    /**
     * 贷款用途
     */
    @ApiModelProperty(value = "贷款用途")
    private String usageDesc;

    /**
     * 连续两年逾期次数
     */
    @ApiModelProperty(value = "连续两年逾期次数")
    private Integer overdue;

    /**
     * 贷款两年累计逾期次数
     */
    @ApiModelProperty(value = "贷款两年累计逾期次数")
    private Integer overdueTotal;

    /**
     * 信用卡连续两年逾期次数
     */
    @ApiModelProperty(value = "信用卡连续两年逾期次数")
    private Integer creditOverdue;

    /**
     * 信用卡两岸累计逾期次数
     */
    @ApiModelProperty(value = "信用卡两岸累计逾期次数")
    private Integer creditOverdueTotal;

    /**
     * 主借人综述: 0 :A  1: B  2:C
     */
    @ApiModelProperty(value = "主借人综述: 0 :A  1: B  2:C")
    private String userReview;

    /**
     * 连续两年逾期次数
     */
    @ApiModelProperty(value = "连续两年逾期次数")
    private Integer togetherOverdue;

    /**
     * 贷款两年累计逾期次数
     */
    @ApiModelProperty(value = "贷款两年累计逾期次数")
    private Integer togetherOverdueTotal;

    /**
     * 信用卡连续两年逾期次数
     */
    @ApiModelProperty(value = "信用卡连续两年逾期次数")
    private Integer togetherCreditOverdue;

    /**
     * 信用卡两岸累计逾期次数
     */
    @ApiModelProperty(value = "信用卡两岸累计逾期次数")
    private Integer togetherCreditOverdueTotal;

    /**
     * 共借人综述: 0 :A  1: B  2:C
     */
    @ApiModelProperty(value = "共借人综述: 0 :A  1: B  2:C")
    private String userTogetherReview;

    /**
     * 被执行人网查询 
     */
    @ApiModelProperty(value = "被执行人网查询 ")
    private Boolean netQuery;

    /**
     * 被执行人网查询
     */
    @ApiModelProperty(value = "被执行人网查询")
    private Boolean creditNetQuery;

    /**
     * 婚姻状态
     */
    @ApiModelProperty(value = "婚姻状态")
    private String marrStatus;

    /**
     * 婚姻年限
     */
    @ApiModelProperty(value = "婚姻年限")
    private Integer marrYear;

    /**
     * 是否有子女
     */
    @ApiModelProperty(value = "是否有子女")
    private Boolean haveChildren;

    /**
     * 赡养人数
     */
    @ApiModelProperty(value = "赡养人数")
    private Integer supportNumber;

    /**
     * 家庭负债总额
     */
    @ApiModelProperty(value = "家庭负债总额")
    private BigDecimal familyDebt;

    /**
     * 信用卡、打款负债额
     */
    @ApiModelProperty(value = "信用卡、打款负债额")
    private BigDecimal otherDebt;

    /**
     * 月还款额
     */
    @ApiModelProperty(value = "月还款额")
    private BigDecimal monthRepay;

    /**
     * 房产1名称
     */
    @ApiModelProperty(value = "房产1名称")
    private String houseOneName;

    /**
     * 房产1价格
     */
    @ApiModelProperty(value = "房产1价格")
    private BigDecimal houseOnePrice;

    /**
     * 房产2名称
     */
    @ApiModelProperty(value = "房产2名称")
    private String houseTwoName;

    /**
     * 房价2价格
     */
    @ApiModelProperty(value = "房价2价格")
    private BigDecimal houseTwoPrice;

    /**
     * 车价格
     */
    @ApiModelProperty(value = "车价格")
    private BigDecimal carPrice;

    /**
     * 股票价格
     */
    @ApiModelProperty(value = "股票价格")
    private BigDecimal stockPrice;

    /**
     * 理财价格
     */
    @ApiModelProperty(value = "理财价格")
    private BigDecimal financialPrice;

    /**
     * 其它资产价格
     */
    @ApiModelProperty(value = "其它资产价格")
    private BigDecimal otherPrice;

    /**
     * 银行流水明细
     */
    @ApiModelProperty(value = "银行流水明细")
    private BigDecimal bankDetail;

    /**
     * 月工资收入
     */
    @ApiModelProperty(value = "月工资收入")
    private String monthIncome;

    /**
     * 月经营收入
     */
    @ApiModelProperty(value = "月经营收入")
    private BigDecimal manageIncome;

    /**
     * 月租金收入
     */
    @ApiModelProperty(value = "月租金收入")
    private BigDecimal rentIncome;

    /**
     * 月其它收入
     */
    @ApiModelProperty(value = "月其它收入")
    private BigDecimal otherIncome;

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
     * 共借人姓名
     */
    @ApiModelProperty(value = "共借人姓名")
    private String togetherName;

    /**
     * 共借人手机号码
     */
    @ApiModelProperty(value = "共借人手机号码")
    private String togetherMobile;

    /**
     * 共借人身份证
     */
    @ApiModelProperty(value = "共借人身份证")
    private String togetherIdentity;

    private String picFile;

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
     * 抵押 ID
     * @return pawn_id 抵押 ID
     */
    public String getPawnId() {
        return pawnId;
    }

    /**
     * 抵押 ID
     * @param pawnId 抵押 ID
     */
    public void setPawnId(String pawnId) {
        this.pawnId = pawnId;
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
     * 业务编号
     * @return business_no 业务编号
     */
    public String getBusinessNo() {
        return businessNo;
    }

    /**
     * 业务编号
     * @param businessNo 业务编号
     */
    public void setBusinessNo(String businessNo) {
        this.businessNo = businessNo;
    }

    /**
     * 部门
     * @return department 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 部门
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 客户经理ID
     * @return channel_user_id 客户经理ID
     */
    public String getChannelUserId() {
        return channelUserId;
    }

    /**
     * 客户经理ID
     * @param channelUserId 客户经理ID
     */
    public void setChannelUserId(String channelUserId) {
        this.channelUserId = channelUserId;
    }

    /**
     * 产品类型 : 1 一抵产品  2 二抵产品
     * @return product_type 产品类型 : 1 一抵产品  2 二抵产品
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 产品类型 : 1 一抵产品  2 二抵产品
     * @param productType 产品类型 : 1 一抵产品  2 二抵产品
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 抵押物类型：  0 普通商品住房  1特殊房产 2商办公寓 3别墅 （0 一类房产 1二类房产 2 三类房产），目前该值未定
     * @return pawn_type 抵押物类型：  0 普通商品住房  1特殊房产 2商办公寓 3别墅 （0 一类房产 1二类房产 2 三类房产），目前该值未定
     */
    public String getPawnType() {
        return pawnType;
    }

    /**
     * 抵押物类型：  0 普通商品住房  1特殊房产 2商办公寓 3别墅 （0 一类房产 1二类房产 2 三类房产），目前该值未定
     * @param pawnType 抵押物类型：  0 普通商品住房  1特殊房产 2商办公寓 3别墅 （0 一类房产 1二类房产 2 三类房产），目前该值未定
     */
    public void setPawnType(String pawnType) {
        this.pawnType = pawnType;
    }

    /**
     *  抵押区域 ： 0 一类区域  1二类区域  2三类区域
     * @return pawn_area  抵押区域 ： 0 一类区域  1二类区域  2三类区域
     */
    public String getPawnArea() {
        return pawnArea;
    }

    /**
     *  抵押区域 ： 0 一类区域  1二类区域  2三类区域
     * @param pawnArea  抵押区域 ： 0 一类区域  1二类区域  2三类区域
     */
    public void setPawnArea(String pawnArea) {
        this.pawnArea = pawnArea;
    }

    /**
     * 还款方式
     * @return repay_way 还款方式
     */
    public String getRepayWay() {
        return repayWay;
    }

    /**
     * 还款方式
     * @param repayWay 还款方式
     */
    public void setRepayWay(String repayWay) {
        this.repayWay = repayWay;
    }

    /**
     * 利率
     * @return rating 利率
     */
    public String getRating() {
        return rating;
    }

    /**
     * 利率
     * @param rating 利率
     */
    public void setRating(String rating) {
        this.rating = rating;
    }

    /**
     * 贷款类型 : 0 个人经营性贷款 1 个人消费贷款 
     * @return loan_type 贷款类型 : 0 个人经营性贷款 1 个人消费贷款 
     */
    public String getLoanType() {
        return loanType;
    }

    /**
     * 贷款类型 : 0 个人经营性贷款 1 个人消费贷款 
     * @param loanType 贷款类型 : 0 个人经营性贷款 1 个人消费贷款 
     */
    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    /**
     * 贷款用途
     * @return usage_desc 贷款用途
     */
    public String getUsageDesc() {
        return usageDesc;
    }

    /**
     * 贷款用途
     * @param usageDesc 贷款用途
     */
    public void setUsageDesc(String usageDesc) {
        this.usageDesc = usageDesc;
    }

    /**
     * 连续两年逾期次数
     * @return overdue 连续两年逾期次数
     */
    public Integer getOverdue() {
        return overdue;
    }

    /**
     * 连续两年逾期次数
     * @param overdue 连续两年逾期次数
     */
    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    /**
     * 贷款两年累计逾期次数
     * @return overdue_total 贷款两年累计逾期次数
     */
    public Integer getOverdueTotal() {
        return overdueTotal;
    }

    /**
     * 贷款两年累计逾期次数
     * @param overdueTotal 贷款两年累计逾期次数
     */
    public void setOverdueTotal(Integer overdueTotal) {
        this.overdueTotal = overdueTotal;
    }

    /**
     * 信用卡连续两年逾期次数
     * @return credit_overdue 信用卡连续两年逾期次数
     */
    public Integer getCreditOverdue() {
        return creditOverdue;
    }

    /**
     * 信用卡连续两年逾期次数
     * @param creditOverdue 信用卡连续两年逾期次数
     */
    public void setCreditOverdue(Integer creditOverdue) {
        this.creditOverdue = creditOverdue;
    }

    /**
     * 信用卡两岸累计逾期次数
     * @return credit_overdue_total 信用卡两岸累计逾期次数
     */
    public Integer getCreditOverdueTotal() {
        return creditOverdueTotal;
    }

    /**
     * 信用卡两岸累计逾期次数
     * @param creditOverdueTotal 信用卡两岸累计逾期次数
     */
    public void setCreditOverdueTotal(Integer creditOverdueTotal) {
        this.creditOverdueTotal = creditOverdueTotal;
    }

    /**
     * 主借人综述: 0 :A  1: B  2:C
     * @return user_review 主借人综述: 0 :A  1: B  2:C
     */
    public String getUserReview() {
        return userReview;
    }

    /**
     * 主借人综述: 0 :A  1: B  2:C
     * @param userReview 主借人综述: 0 :A  1: B  2:C
     */
    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    /**
     * 连续两年逾期次数
     * @return together_overdue 连续两年逾期次数
     */
    public Integer getTogetherOverdue() {
        return togetherOverdue;
    }

    /**
     * 连续两年逾期次数
     * @param togetherOverdue 连续两年逾期次数
     */
    public void setTogetherOverdue(Integer togetherOverdue) {
        this.togetherOverdue = togetherOverdue;
    }

    /**
     * 贷款两年累计逾期次数
     * @return together_overdue_total 贷款两年累计逾期次数
     */
    public Integer getTogetherOverdueTotal() {
        return togetherOverdueTotal;
    }

    /**
     * 贷款两年累计逾期次数
     * @param togetherOverdueTotal 贷款两年累计逾期次数
     */
    public void setTogetherOverdueTotal(Integer togetherOverdueTotal) {
        this.togetherOverdueTotal = togetherOverdueTotal;
    }

    /**
     * 信用卡连续两年逾期次数
     * @return together_credit_overdue 信用卡连续两年逾期次数
     */
    public Integer getTogetherCreditOverdue() {
        return togetherCreditOverdue;
    }

    /**
     * 信用卡连续两年逾期次数
     * @param togetherCreditOverdue 信用卡连续两年逾期次数
     */
    public void setTogetherCreditOverdue(Integer togetherCreditOverdue) {
        this.togetherCreditOverdue = togetherCreditOverdue;
    }

    /**
     * 信用卡两岸累计逾期次数
     * @return together_credit_overdue_total 信用卡两岸累计逾期次数
     */
    public Integer getTogetherCreditOverdueTotal() {
        return togetherCreditOverdueTotal;
    }

    /**
     * 信用卡两岸累计逾期次数
     * @param togetherCreditOverdueTotal 信用卡两岸累计逾期次数
     */
    public void setTogetherCreditOverdueTotal(Integer togetherCreditOverdueTotal) {
        this.togetherCreditOverdueTotal = togetherCreditOverdueTotal;
    }

    /**
     * 共借人综述: 0 :A  1: B  2:C
     * @return user_together_review 共借人综述: 0 :A  1: B  2:C
     */
    public String getUserTogetherReview() {
        return userTogetherReview;
    }

    /**
     * 共借人综述: 0 :A  1: B  2:C
     * @param userTogetherReview 共借人综述: 0 :A  1: B  2:C
     */
    public void setUserTogetherReview(String userTogetherReview) {
        this.userTogetherReview = userTogetherReview;
    }

    /**
     * 被执行人网查询 
     * @return net_query 被执行人网查询 
     */
    public Boolean getNetQuery() {
        return netQuery;
    }

    /**
     * 被执行人网查询 
     * @param netQuery 被执行人网查询 
     */
    public void setNetQuery(Boolean netQuery) {
        this.netQuery = netQuery;
    }

    /**
     * 被执行人网查询
     * @return credit_net_query 被执行人网查询
     */
    public Boolean getCreditNetQuery() {
        return creditNetQuery;
    }

    /**
     * 被执行人网查询
     * @param creditNetQuery 被执行人网查询
     */
    public void setCreditNetQuery(Boolean creditNetQuery) {
        this.creditNetQuery = creditNetQuery;
    }

    /**
     * 婚姻状态
     * @return marr_status 婚姻状态
     */
    public String getMarrStatus() {
        return marrStatus;
    }

    /**
     * 婚姻状态
     * @param marrStatus 婚姻状态
     */
    public void setMarrStatus(String marrStatus) {
        this.marrStatus = marrStatus;
    }

    /**
     * 婚姻年限
     * @return marr_year 婚姻年限
     */
    public Integer getMarrYear() {
        return marrYear;
    }

    /**
     * 婚姻年限
     * @param marrYear 婚姻年限
     */
    public void setMarrYear(Integer marrYear) {
        this.marrYear = marrYear;
    }

    /**
     * 是否有子女
     * @return have_children 是否有子女
     */
    public Boolean getHaveChildren() {
        return haveChildren;
    }

    /**
     * 是否有子女
     * @param haveChildren 是否有子女
     */
    public void setHaveChildren(Boolean haveChildren) {
        this.haveChildren = haveChildren;
    }

    /**
     * 赡养人数
     * @return support_number 赡养人数
     */
    public Integer getSupportNumber() {
        return supportNumber;
    }

    /**
     * 赡养人数
     * @param supportNumber 赡养人数
     */
    public void setSupportNumber(Integer supportNumber) {
        this.supportNumber = supportNumber;
    }

    /**
     * 家庭负债总额
     * @return family_debt 家庭负债总额
     */
    public BigDecimal getFamilyDebt() {
        return familyDebt;
    }

    /**
     * 家庭负债总额
     * @param familyDebt 家庭负债总额
     */
    public void setFamilyDebt(BigDecimal familyDebt) {
        this.familyDebt = familyDebt;
    }

    /**
     * 信用卡、打款负债额
     * @return other_debt 信用卡、打款负债额
     */
    public BigDecimal getOtherDebt() {
        return otherDebt;
    }

    /**
     * 信用卡、打款负债额
     * @param otherDebt 信用卡、打款负债额
     */
    public void setOtherDebt(BigDecimal otherDebt) {
        this.otherDebt = otherDebt;
    }

    /**
     * 月还款额
     * @return month_repay 月还款额
     */
    public BigDecimal getMonthRepay() {
        return monthRepay;
    }

    /**
     * 月还款额
     * @param monthRepay 月还款额
     */
    public void setMonthRepay(BigDecimal monthRepay) {
        this.monthRepay = monthRepay;
    }

    /**
     * 房产1名称
     * @return house_one_name 房产1名称
     */
    public String getHouseOneName() {
        return houseOneName;
    }

    /**
     * 房产1名称
     * @param houseOneName 房产1名称
     */
    public void setHouseOneName(String houseOneName) {
        this.houseOneName = houseOneName;
    }

    /**
     * 房产1价格
     * @return house_one_price 房产1价格
     */
    public BigDecimal getHouseOnePrice() {
        return houseOnePrice;
    }

    /**
     * 房产1价格
     * @param houseOnePrice 房产1价格
     */
    public void setHouseOnePrice(BigDecimal houseOnePrice) {
        this.houseOnePrice = houseOnePrice;
    }

    /**
     * 房产2名称
     * @return house_two_name 房产2名称
     */
    public String getHouseTwoName() {
        return houseTwoName;
    }

    /**
     * 房产2名称
     * @param houseTwoName 房产2名称
     */
    public void setHouseTwoName(String houseTwoName) {
        this.houseTwoName = houseTwoName;
    }

    /**
     * 房价2价格
     * @return house_two_price 房价2价格
     */
    public BigDecimal getHouseTwoPrice() {
        return houseTwoPrice;
    }

    /**
     * 房价2价格
     * @param houseTwoPrice 房价2价格
     */
    public void setHouseTwoPrice(BigDecimal houseTwoPrice) {
        this.houseTwoPrice = houseTwoPrice;
    }

    /**
     * 车价格
     * @return car_price 车价格
     */
    public BigDecimal getCarPrice() {
        return carPrice;
    }

    /**
     * 车价格
     * @param carPrice 车价格
     */
    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    /**
     * 股票价格
     * @return stock_price 股票价格
     */
    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    /**
     * 股票价格
     * @param stockPrice 股票价格
     */
    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    /**
     * 理财价格
     * @return financial_price 理财价格
     */
    public BigDecimal getFinancialPrice() {
        return financialPrice;
    }

    /**
     * 理财价格
     * @param financialPrice 理财价格
     */
    public void setFinancialPrice(BigDecimal financialPrice) {
        this.financialPrice = financialPrice;
    }

    /**
     * 其它资产价格
     * @return other_price 其它资产价格
     */
    public BigDecimal getOtherPrice() {
        return otherPrice;
    }

    /**
     * 其它资产价格
     * @param otherPrice 其它资产价格
     */
    public void setOtherPrice(BigDecimal otherPrice) {
        this.otherPrice = otherPrice;
    }

    /**
     * 银行流水明细
     * @return bank_detail 银行流水明细
     */
    public BigDecimal getBankDetail() {
        return bankDetail;
    }

    /**
     * 银行流水明细
     * @param bankDetail 银行流水明细
     */
    public void setBankDetail(BigDecimal bankDetail) {
        this.bankDetail = bankDetail;
    }

    /**
     * 月工资收入
     * @return month_income 月工资收入
     */
    public String getMonthIncome() {
        return monthIncome;
    }

    /**
     * 月工资收入
     * @param monthIncome 月工资收入
     */
    public void setMonthIncome(String monthIncome) {
        this.monthIncome = monthIncome;
    }

    /**
     * 月经营收入
     * @return manage_income 月经营收入
     */
    public BigDecimal getManageIncome() {
        return manageIncome;
    }

    /**
     * 月经营收入
     * @param manageIncome 月经营收入
     */
    public void setManageIncome(BigDecimal manageIncome) {
        this.manageIncome = manageIncome;
    }

    /**
     * 月租金收入
     * @return rent_income 月租金收入
     */
    public BigDecimal getRentIncome() {
        return rentIncome;
    }

    /**
     * 月租金收入
     * @param rentIncome 月租金收入
     */
    public void setRentIncome(BigDecimal rentIncome) {
        this.rentIncome = rentIncome;
    }

    /**
     * 月其它收入
     * @return other_income 月其它收入
     */
    public BigDecimal getOtherIncome() {
        return otherIncome;
    }

    /**
     * 月其它收入
     * @param otherIncome 月其它收入
     */
    public void setOtherIncome(BigDecimal otherIncome) {
        this.otherIncome = otherIncome;
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

    /**
     * 共借人姓名
     * @return together_name 共借人姓名
     */
    public String getTogetherName() {
        return togetherName;
    }

    /**
     * 共借人姓名
     * @param togetherName 共借人姓名
     */
    public void setTogetherName(String togetherName) {
        this.togetherName = togetherName;
    }

    /**
     * 共借人手机号码
     * @return together_mobile 共借人手机号码
     */
    public String getTogetherMobile() {
        return togetherMobile;
    }

    /**
     * 共借人手机号码
     * @param togetherMobile 共借人手机号码
     */
    public void setTogetherMobile(String togetherMobile) {
        this.togetherMobile = togetherMobile;
    }

    /**
     * 共借人身份证
     * @return together_identity 共借人身份证
     */
    public String getTogetherIdentity() {
        return togetherIdentity;
    }

    /**
     * 共借人身份证
     * @param togetherIdentity 共借人身份证
     */
    public void setTogetherIdentity(String togetherIdentity) {
        this.togetherIdentity = togetherIdentity;
    }

    /**
     * 
     * @return pic_file 
     */
    public String getPicFile() {
        return picFile;
    }

    /**
     * 
     * @param picFile 
     */
    public void setPicFile(String picFile) {
        this.picFile = picFile;
    }
}