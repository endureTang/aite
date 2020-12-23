package com.nj.mongoModel.after;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.nj.core.base.util.DateUtil;
import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;
import com.nj.mongoModel.MongoEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 回款计划
 */
@ApiModel(description = "回款计划")
public class MoneyBackNew extends MongoEntity {

    @ApiModelProperty(value = "订单编号")
    @ExportFormat(align = ExportFormatConstant.Align.LEFT, formatType = ExportFormatConstant.FormatType.STRING, name = "订单编号", sort = 1)
    private String orderNo;                    //订单编号

    @ApiModelProperty(value = "期数")
    private Integer period;                    //期数
    
    @JSONField(format = "yyyy-MM-dd")
    @ApiModelProperty(value = "计划还款日期")
    private Date planRepayDate;                //计划还款日期

    @ApiModelProperty(value = "计划应还总额")
    private BigDecimal planRepayTotalAmt;        //计划应还总额
    
    @JSONField(format = "yyyy-MM-dd")
    @ApiModelProperty(value = "实际还款日期")
    private Date accRepayDate;                //实际还款日期

    @ApiModelProperty(value = "实还总额")
    private BigDecimal accRepayTotalAmt;        //实还总额

    @ApiModelProperty(value = "还款状态")
    @ExportFormat(align = ExportFormatConstant.Align.LEFT, formatType = ExportFormatConstant.FormatType.STRING, name = "还款状态", sort = 2)
    private String repayStatus;                //还款状态

    @ApiModelProperty(value = "逾期天数")
    private Integer overdueDays;            //逾期天数

    @ApiModelProperty(value = "逾期等级")
    private Integer overdueLevel;            //逾期等级
    
    @ApiModelProperty(value = "贷款余额")
    private BigDecimal loanBalance;

    @ApiModelProperty(value = "扣款结果")
    private String deductionResult;            //扣款结果

    @ApiModelProperty(value = "扣款失败原因")
    private Integer deductionFailReason;    //扣款失败原因.   3:余额不足,失败     4:系统原因,失败

    @ApiModelProperty(value = "企业id")
    private String coporateId;                //企业id

    @ApiModelProperty(value = "产品id")
    private String productId;                //产品id

    @ApiModelProperty(value = "产品名称")
    @ExportFormat(align = ExportFormatConstant.Align.LEFT, formatType = ExportFormatConstant.FormatType.STRING, name = "产品名称", sort = 3)
    private String productName;    //产品名称

    @ApiModelProperty(value = "贷款人id")
    private String loanUserId;                //贷款人id

    @ApiModelProperty(value = "客户经理id")
    private String businessCommissionerId;    //客户经理id

    @ApiModelProperty(value = "数据类型：his 的时候为历史数据")
    private String dataFlag;
    @ApiModelProperty(value = "还款方式：0：线上中金扣款,9：线下还款 ；默认0")
    private Integer repayType;

    @ApiModelProperty(value = "企业名称")
    private String coporateName;
    private List<MoneyBackDetaileNew> listMoneyBackDetaileNew;
    @ApiModelProperty(value = "扣款状态：1暂停扣款；默认0")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 保存到mongo时对时间格式化，解决时间相差8小时问题
     */
    public void saveToMongoFormat() {
        this.planRepayDate = DateUtil.getAfterDate(this.getPlanRepayDate(), Calendar.HOUR_OF_DAY, 8);
        this.accRepayDate = DateUtil.getAfterDate(this.getAccRepayDate(), Calendar.HOUR_OF_DAY, 8);
    }

    public List<MoneyBackDetaileNew> getListMoneyBackDetaileNew() {
        return listMoneyBackDetaileNew;
    }

    public void setListMoneyBackDetaileNew(List<MoneyBackDetaileNew> listMoneyBackDetaileNew) {
        this.listMoneyBackDetaileNew = listMoneyBackDetaileNew;
    }

    public Integer getRepayType() {
        return repayType;
    }

    public void setRepayType(Integer repayType) {
        this.repayType = repayType;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Date getPlanRepayDate() {
        return planRepayDate;
    }

    public void setPlanRepayDate(Date planRepayDate) {
        this.planRepayDate = planRepayDate;
    }

    public BigDecimal getPlanRepayTotalAmt() {
        return planRepayTotalAmt;
    }

    public void setPlanRepayTotalAmt(BigDecimal planRepayTotalAmt) {
        this.planRepayTotalAmt = planRepayTotalAmt;
    }

    public Date getAccRepayDate() {
        return accRepayDate;
    }

    public void setAccRepayDate(Date accRepayDate) {
        this.accRepayDate = accRepayDate;
    }

    public BigDecimal getAccRepayTotalAmt() {
        return accRepayTotalAmt;
    }

    public void setAccRepayTotalAmt(BigDecimal accRepayTotalAmt) {
        this.accRepayTotalAmt = accRepayTotalAmt;
    }

    public String getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(String repayStatus) {
        this.repayStatus = repayStatus;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Integer getOverdueLevel() {
        return overdueLevel;
    }

    public void setOverdueLevel(Integer overdueLevel) {
        this.overdueLevel = overdueLevel;
    }

    public String getDeductionResult() {
        return deductionResult;
    }

    public void setDeductionResult(String deductionResult) {
        this.deductionResult = deductionResult;
    }

    public Integer getDeductionFailReason() {
        return deductionFailReason;
    }

    public void setDeductionFailReason(Integer deductionFailReason) {
        this.deductionFailReason = deductionFailReason;
    }

    public String getCoporateId() {
        return coporateId;
    }

    public void setCoporateId(String coporateId) {
        this.coporateId = coporateId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getLoanUserId() {
        return loanUserId;
    }

    public void setLoanUserId(String loanUserId) {
        this.loanUserId = loanUserId;
    }

    public String getBusinessCommissionerId() {
        return businessCommissionerId;
    }

    public void setBusinessCommissionerId(String businessCommissionerId) {
        this.businessCommissionerId = businessCommissionerId;
    }

    public String getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(String dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getCoporateName() {
        return coporateName;
    }

    public void setCoporateName(String coporateName) {
        this.coporateName = coporateName;
    }

	public BigDecimal getLoanBalance() {
		return loanBalance;
	}

	public void setLoanBalance(BigDecimal loanBalance) {
		this.loanBalance = loanBalance;
	}
}
