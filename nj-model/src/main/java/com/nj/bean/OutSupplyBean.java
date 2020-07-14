package com.nj.bean;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * @Name com.nj.bean.OutSupplyBean
 * @Description 补充资料实体类
 * @Author bruce
 * @Version 2018年3月8日 下午2:30:29
 * @Copyright 金鼎财富
 */
public class OutSupplyBean {
    /**
     * 放款时间
     */
    @NotNull(message = "放款时间不能为空")
    private String makeLoansDate;
    /**
     * 银行卡号
     */
    @NotNull(message = "银行卡号不能为空")
    private String bankAccount;
    /**
     * 合同地址
     */
    private String contractUrl;


    public String getMakeLoansDate() {
        return makeLoansDate;
    }

    public void setMakeLoansDate(String makeLoansDate) {
        this.makeLoansDate = makeLoansDate;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getContractUrl() {
        return contractUrl;
    }

    public void setContractUrl(String contractUrl) {
        this.contractUrl = contractUrl;
    }
}
