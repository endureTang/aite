package com.nj.model.generate;

import java.math.BigDecimal;

public class NjUserCredit {
    /**
     * 编号
     */
    private String id;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 用户号
     */
    private String userId;

    /**
     * 近三个月机构查询次数
     */
    private Integer agentCount;

    /**
     * 近三个月个人查询次数
     */
    private Integer personCount;

    /**
     * 近6个月逾期次数
     */
    private Integer overdueMonth6;

    /**
     * 近12个月逾期次数
     */
    private Integer overdueMonth12;

    /**
     * 信用卡近6个月平均使用额度
     */
    private Integer creditCardAmt;

    /**
     * 抵押负债余额
     */
    private BigDecimal mortageBalance;

    /**
     * 信用负债余额
     */
    private BigDecimal creditBalance;

    /**
     * 总月平均负债
     */
    private BigDecimal balanceAvr;

    /**
     * 当前逾期状态
     */
    private String overdueStatus;

    /**
     * 账户异常状态
     */
    private String accountStatus;

    /**
     * 近两年连续逾期次数
     */
    private Integer overdueMonth24;

    /**
     * 编号
     * @return id 编号
     */
    public String getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 订单号
     * @return order_id 订单号
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * 订单号
     * @param orderId 订单号
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * 用户号
     * @return user_id 用户号
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户号
     * @param userId 用户号
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 近三个月机构查询次数
     * @return agent_count 近三个月机构查询次数
     */
    public Integer getAgentCount() {
        return agentCount;
    }

    /**
     * 近三个月机构查询次数
     * @param agentCount 近三个月机构查询次数
     */
    public void setAgentCount(Integer agentCount) {
        this.agentCount = agentCount;
    }

    /**
     * 近三个月个人查询次数
     * @return person_count 近三个月个人查询次数
     */
    public Integer getPersonCount() {
        return personCount;
    }

    /**
     * 近三个月个人查询次数
     * @param personCount 近三个月个人查询次数
     */
    public void setPersonCount(Integer personCount) {
        this.personCount = personCount;
    }

    /**
     * 近6个月逾期次数
     * @return overdue_month6 近6个月逾期次数
     */
    public Integer getOverdueMonth6() {
        return overdueMonth6;
    }

    /**
     * 近6个月逾期次数
     * @param overdueMonth6 近6个月逾期次数
     */
    public void setOverdueMonth6(Integer overdueMonth6) {
        this.overdueMonth6 = overdueMonth6;
    }

    /**
     * 近12个月逾期次数
     * @return overdue_month12 近12个月逾期次数
     */
    public Integer getOverdueMonth12() {
        return overdueMonth12;
    }

    /**
     * 近12个月逾期次数
     * @param overdueMonth12 近12个月逾期次数
     */
    public void setOverdueMonth12(Integer overdueMonth12) {
        this.overdueMonth12 = overdueMonth12;
    }

    /**
     * 信用卡近6个月平均使用额度
     * @return credit_card_amt 信用卡近6个月平均使用额度
     */
    public Integer getCreditCardAmt() {
        return creditCardAmt;
    }

    /**
     * 信用卡近6个月平均使用额度
     * @param creditCardAmt 信用卡近6个月平均使用额度
     */
    public void setCreditCardAmt(Integer creditCardAmt) {
        this.creditCardAmt = creditCardAmt;
    }

    /**
     * 抵押负债余额
     * @return mortage_balance 抵押负债余额
     */
    public BigDecimal getMortageBalance() {
        return mortageBalance;
    }

    /**
     * 抵押负债余额
     * @param mortageBalance 抵押负债余额
     */
    public void setMortageBalance(BigDecimal mortageBalance) {
        this.mortageBalance = mortageBalance;
    }

    /**
     * 信用负债余额
     * @return credit_balance 信用负债余额
     */
    public BigDecimal getCreditBalance() {
        return creditBalance;
    }

    /**
     * 信用负债余额
     * @param creditBalance 信用负债余额
     */
    public void setCreditBalance(BigDecimal creditBalance) {
        this.creditBalance = creditBalance;
    }

    /**
     * 总月平均负债
     * @return balance_avr 总月平均负债
     */
    public BigDecimal getBalanceAvr() {
        return balanceAvr;
    }

    /**
     * 总月平均负债
     * @param balanceAvr 总月平均负债
     */
    public void setBalanceAvr(BigDecimal balanceAvr) {
        this.balanceAvr = balanceAvr;
    }

    /**
     * 当前逾期状态
     * @return overdue_status 当前逾期状态
     */
    public String getOverdueStatus() {
        return overdueStatus;
    }

    /**
     * 当前逾期状态
     * @param overdueStatus 当前逾期状态
     */
    public void setOverdueStatus(String overdueStatus) {
        this.overdueStatus = overdueStatus;
    }

    /**
     * 账户异常状态
     * @return account_status 账户异常状态
     */
    public String getAccountStatus() {
        return accountStatus;
    }

    /**
     * 账户异常状态
     * @param accountStatus 账户异常状态
     */
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    /**
     * 近两年连续逾期次数
     * @return overdue_month24 近两年连续逾期次数
     */
    public Integer getOverdueMonth24() {
        return overdueMonth24;
    }

    /**
     * 近两年连续逾期次数
     * @param overdueMonth24 近两年连续逾期次数
     */
    public void setOverdueMonth24(Integer overdueMonth24) {
        this.overdueMonth24 = overdueMonth24;
    }
}