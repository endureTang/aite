package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjPuhuiApplyExample {
    /**
     * nj_puhui_apply
     */
    protected String orderByClause;

    /**
     * nj_puhui_apply
     */
    protected boolean distinct;

    /**
     * nj_puhui_apply
     */
    protected List<Criteria> oredCriteria;

    public NjPuhuiApplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * nj_puhui_apply 2018-04-27
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLoanNoIsNull() {
            addCriterion("loan_no is null");
            return (Criteria) this;
        }

        public Criteria andLoanNoIsNotNull() {
            addCriterion("loan_no is not null");
            return (Criteria) this;
        }

        public Criteria andLoanNoEqualTo(String value) {
            addCriterion("loan_no =", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoNotEqualTo(String value) {
            addCriterion("loan_no <>", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoGreaterThan(String value) {
            addCriterion("loan_no >", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoGreaterThanOrEqualTo(String value) {
            addCriterion("loan_no >=", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoLessThan(String value) {
            addCriterion("loan_no <", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoLessThanOrEqualTo(String value) {
            addCriterion("loan_no <=", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoLike(String value) {
            addCriterion("loan_no like", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoNotLike(String value) {
            addCriterion("loan_no not like", value, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoIn(List<String> values) {
            addCriterion("loan_no in", values, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoNotIn(List<String> values) {
            addCriterion("loan_no not in", values, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoBetween(String value1, String value2) {
            addCriterion("loan_no between", value1, value2, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanNoNotBetween(String value1, String value2) {
            addCriterion("loan_no not between", value1, value2, "loanNo");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNull() {
            addCriterion("loan_type is null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIsNotNull() {
            addCriterion("loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andLoanTypeEqualTo(String value) {
            addCriterion("loan_type =", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotEqualTo(String value) {
            addCriterion("loan_type <>", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThan(String value) {
            addCriterion("loan_type >", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeGreaterThanOrEqualTo(String value) {
            addCriterion("loan_type >=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThan(String value) {
            addCriterion("loan_type <", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLessThanOrEqualTo(String value) {
            addCriterion("loan_type <=", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeLike(String value) {
            addCriterion("loan_type like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotLike(String value) {
            addCriterion("loan_type not like", value, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeIn(List<String> values) {
            addCriterion("loan_type in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotIn(List<String> values) {
            addCriterion("loan_type not in", values, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeBetween(String value1, String value2) {
            addCriterion("loan_type between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andLoanTypeNotBetween(String value1, String value2) {
            addCriterion("loan_type not between", value1, value2, "loanType");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNull() {
            addCriterion("good_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIsNotNull() {
            addCriterion("good_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodPriceEqualTo(BigDecimal value) {
            addCriterion("good_price =", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotEqualTo(BigDecimal value) {
            addCriterion("good_price <>", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThan(BigDecimal value) {
            addCriterion("good_price >", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("good_price >=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThan(BigDecimal value) {
            addCriterion("good_price <", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("good_price <=", value, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceIn(List<BigDecimal> values) {
            addCriterion("good_price in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotIn(List<BigDecimal> values) {
            addCriterion("good_price not in", values, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("good_price between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andGoodPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("good_price not between", value1, value2, "goodPrice");
            return (Criteria) this;
        }

        public Criteria andFisrtPayIsNull() {
            addCriterion("fisrt_pay is null");
            return (Criteria) this;
        }

        public Criteria andFisrtPayIsNotNull() {
            addCriterion("fisrt_pay is not null");
            return (Criteria) this;
        }

        public Criteria andFisrtPayEqualTo(BigDecimal value) {
            addCriterion("fisrt_pay =", value, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayNotEqualTo(BigDecimal value) {
            addCriterion("fisrt_pay <>", value, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayGreaterThan(BigDecimal value) {
            addCriterion("fisrt_pay >", value, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fisrt_pay >=", value, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayLessThan(BigDecimal value) {
            addCriterion("fisrt_pay <", value, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fisrt_pay <=", value, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayIn(List<BigDecimal> values) {
            addCriterion("fisrt_pay in", values, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayNotIn(List<BigDecimal> values) {
            addCriterion("fisrt_pay not in", values, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fisrt_pay between", value1, value2, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFisrtPayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fisrt_pay not between", value1, value2, "fisrtPay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayIsNull() {
            addCriterion("first_repay is null");
            return (Criteria) this;
        }

        public Criteria andFirstRepayIsNotNull() {
            addCriterion("first_repay is not null");
            return (Criteria) this;
        }

        public Criteria andFirstRepayEqualTo(BigDecimal value) {
            addCriterion("first_repay =", value, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayNotEqualTo(BigDecimal value) {
            addCriterion("first_repay <>", value, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayGreaterThan(BigDecimal value) {
            addCriterion("first_repay >", value, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_repay >=", value, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayLessThan(BigDecimal value) {
            addCriterion("first_repay <", value, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_repay <=", value, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayIn(List<BigDecimal> values) {
            addCriterion("first_repay in", values, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayNotIn(List<BigDecimal> values) {
            addCriterion("first_repay not in", values, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_repay between", value1, value2, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_repay not between", value1, value2, "firstRepay");
            return (Criteria) this;
        }

        public Criteria andRepayFeeIsNull() {
            addCriterion("repay_fee is null");
            return (Criteria) this;
        }

        public Criteria andRepayFeeIsNotNull() {
            addCriterion("repay_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRepayFeeEqualTo(BigDecimal value) {
            addCriterion("repay_fee =", value, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeNotEqualTo(BigDecimal value) {
            addCriterion("repay_fee <>", value, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeGreaterThan(BigDecimal value) {
            addCriterion("repay_fee >", value, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_fee >=", value, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeLessThan(BigDecimal value) {
            addCriterion("repay_fee <", value, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_fee <=", value, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeIn(List<BigDecimal> values) {
            addCriterion("repay_fee in", values, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeNotIn(List<BigDecimal> values) {
            addCriterion("repay_fee not in", values, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_fee between", value1, value2, "repayFee");
            return (Criteria) this;
        }

        public Criteria andRepayFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_fee not between", value1, value2, "repayFee");
            return (Criteria) this;
        }

        public Criteria andAmtIsNull() {
            addCriterion("amt is null");
            return (Criteria) this;
        }

        public Criteria andAmtIsNotNull() {
            addCriterion("amt is not null");
            return (Criteria) this;
        }

        public Criteria andAmtEqualTo(BigDecimal value) {
            addCriterion("amt =", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotEqualTo(BigDecimal value) {
            addCriterion("amt <>", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThan(BigDecimal value) {
            addCriterion("amt >", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amt >=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThan(BigDecimal value) {
            addCriterion("amt <", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amt <=", value, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtIn(List<BigDecimal> values) {
            addCriterion("amt in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotIn(List<BigDecimal> values) {
            addCriterion("amt not in", values, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amt between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amt not between", value1, value2, "amt");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayIsNull() {
            addCriterion("first_repay_day is null");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayIsNotNull() {
            addCriterion("first_repay_day is not null");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayEqualTo(Date value) {
            addCriterion("first_repay_day =", value, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayNotEqualTo(Date value) {
            addCriterion("first_repay_day <>", value, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayGreaterThan(Date value) {
            addCriterion("first_repay_day >", value, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayGreaterThanOrEqualTo(Date value) {
            addCriterion("first_repay_day >=", value, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayLessThan(Date value) {
            addCriterion("first_repay_day <", value, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayLessThanOrEqualTo(Date value) {
            addCriterion("first_repay_day <=", value, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayIn(List<Date> values) {
            addCriterion("first_repay_day in", values, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayNotIn(List<Date> values) {
            addCriterion("first_repay_day not in", values, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayBetween(Date value1, Date value2) {
            addCriterion("first_repay_day between", value1, value2, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andFirstRepayDayNotBetween(Date value1, Date value2) {
            addCriterion("first_repay_day not between", value1, value2, "firstRepayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayIsNull() {
            addCriterion("repay_day is null");
            return (Criteria) this;
        }

        public Criteria andRepayDayIsNotNull() {
            addCriterion("repay_day is not null");
            return (Criteria) this;
        }

        public Criteria andRepayDayEqualTo(Date value) {
            addCriterion("repay_day =", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotEqualTo(Date value) {
            addCriterion("repay_day <>", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayGreaterThan(Date value) {
            addCriterion("repay_day >", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayGreaterThanOrEqualTo(Date value) {
            addCriterion("repay_day >=", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayLessThan(Date value) {
            addCriterion("repay_day <", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayLessThanOrEqualTo(Date value) {
            addCriterion("repay_day <=", value, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayIn(List<Date> values) {
            addCriterion("repay_day in", values, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotIn(List<Date> values) {
            addCriterion("repay_day not in", values, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayBetween(Date value1, Date value2) {
            addCriterion("repay_day between", value1, value2, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayDayNotBetween(Date value1, Date value2) {
            addCriterion("repay_day not between", value1, value2, "repayDay");
            return (Criteria) this;
        }

        public Criteria andRepayAmtIsNull() {
            addCriterion("repay_amt is null");
            return (Criteria) this;
        }

        public Criteria andRepayAmtIsNotNull() {
            addCriterion("repay_amt is not null");
            return (Criteria) this;
        }

        public Criteria andRepayAmtEqualTo(BigDecimal value) {
            addCriterion("repay_amt =", value, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtNotEqualTo(BigDecimal value) {
            addCriterion("repay_amt <>", value, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtGreaterThan(BigDecimal value) {
            addCriterion("repay_amt >", value, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_amt >=", value, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtLessThan(BigDecimal value) {
            addCriterion("repay_amt <", value, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("repay_amt <=", value, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtIn(List<BigDecimal> values) {
            addCriterion("repay_amt in", values, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtNotIn(List<BigDecimal> values) {
            addCriterion("repay_amt not in", values, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_amt between", value1, value2, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andRepayAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("repay_amt not between", value1, value2, "repayAmt");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Integer value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Integer value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Integer value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Integer value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Integer> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Integer> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Integer value1, Integer value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andAcctIsNull() {
            addCriterion("acct is null");
            return (Criteria) this;
        }

        public Criteria andAcctIsNotNull() {
            addCriterion("acct is not null");
            return (Criteria) this;
        }

        public Criteria andAcctEqualTo(String value) {
            addCriterion("acct =", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctNotEqualTo(String value) {
            addCriterion("acct <>", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctGreaterThan(String value) {
            addCriterion("acct >", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctGreaterThanOrEqualTo(String value) {
            addCriterion("acct >=", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctLessThan(String value) {
            addCriterion("acct <", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctLessThanOrEqualTo(String value) {
            addCriterion("acct <=", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctLike(String value) {
            addCriterion("acct like", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctNotLike(String value) {
            addCriterion("acct not like", value, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctIn(List<String> values) {
            addCriterion("acct in", values, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctNotIn(List<String> values) {
            addCriterion("acct not in", values, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctBetween(String value1, String value2) {
            addCriterion("acct between", value1, value2, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctNotBetween(String value1, String value2) {
            addCriterion("acct not between", value1, value2, "acct");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNull() {
            addCriterion("acct_id is null");
            return (Criteria) this;
        }

        public Criteria andAcctIdIsNotNull() {
            addCriterion("acct_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcctIdEqualTo(String value) {
            addCriterion("acct_id =", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotEqualTo(String value) {
            addCriterion("acct_id <>", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThan(String value) {
            addCriterion("acct_id >", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdGreaterThanOrEqualTo(String value) {
            addCriterion("acct_id >=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThan(String value) {
            addCriterion("acct_id <", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLessThanOrEqualTo(String value) {
            addCriterion("acct_id <=", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdLike(String value) {
            addCriterion("acct_id like", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotLike(String value) {
            addCriterion("acct_id not like", value, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdIn(List<String> values) {
            addCriterion("acct_id in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotIn(List<String> values) {
            addCriterion("acct_id not in", values, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdBetween(String value1, String value2) {
            addCriterion("acct_id between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctIdNotBetween(String value1, String value2) {
            addCriterion("acct_id not between", value1, value2, "acctId");
            return (Criteria) this;
        }

        public Criteria andAcctNameIsNull() {
            addCriterion("acct_name is null");
            return (Criteria) this;
        }

        public Criteria andAcctNameIsNotNull() {
            addCriterion("acct_name is not null");
            return (Criteria) this;
        }

        public Criteria andAcctNameEqualTo(String value) {
            addCriterion("acct_name =", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotEqualTo(String value) {
            addCriterion("acct_name <>", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameGreaterThan(String value) {
            addCriterion("acct_name >", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameGreaterThanOrEqualTo(String value) {
            addCriterion("acct_name >=", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLessThan(String value) {
            addCriterion("acct_name <", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLessThanOrEqualTo(String value) {
            addCriterion("acct_name <=", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameLike(String value) {
            addCriterion("acct_name like", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotLike(String value) {
            addCriterion("acct_name not like", value, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameIn(List<String> values) {
            addCriterion("acct_name in", values, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotIn(List<String> values) {
            addCriterion("acct_name not in", values, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameBetween(String value1, String value2) {
            addCriterion("acct_name between", value1, value2, "acctName");
            return (Criteria) this;
        }

        public Criteria andAcctNameNotBetween(String value1, String value2) {
            addCriterion("acct_name not between", value1, value2, "acctName");
            return (Criteria) this;
        }

        public Criteria andDlvDateIsNull() {
            addCriterion("dlv_date is null");
            return (Criteria) this;
        }

        public Criteria andDlvDateIsNotNull() {
            addCriterion("dlv_date is not null");
            return (Criteria) this;
        }

        public Criteria andDlvDateEqualTo(Date value) {
            addCriterion("dlv_date =", value, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateNotEqualTo(Date value) {
            addCriterion("dlv_date <>", value, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateGreaterThan(Date value) {
            addCriterion("dlv_date >", value, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateGreaterThanOrEqualTo(Date value) {
            addCriterion("dlv_date >=", value, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateLessThan(Date value) {
            addCriterion("dlv_date <", value, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateLessThanOrEqualTo(Date value) {
            addCriterion("dlv_date <=", value, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateIn(List<Date> values) {
            addCriterion("dlv_date in", values, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateNotIn(List<Date> values) {
            addCriterion("dlv_date not in", values, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateBetween(Date value1, Date value2) {
            addCriterion("dlv_date between", value1, value2, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andDlvDateNotBetween(Date value1, Date value2) {
            addCriterion("dlv_date not between", value1, value2, "dlvDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNull() {
            addCriterion("audit_date is null");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNotNull() {
            addCriterion("audit_date is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDateEqualTo(Date value) {
            addCriterion("audit_date =", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotEqualTo(Date value) {
            addCriterion("audit_date <>", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThan(Date value) {
            addCriterion("audit_date >", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThanOrEqualTo(Date value) {
            addCriterion("audit_date >=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThan(Date value) {
            addCriterion("audit_date <", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThanOrEqualTo(Date value) {
            addCriterion("audit_date <=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateIn(List<Date> values) {
            addCriterion("audit_date in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotIn(List<Date> values) {
            addCriterion("audit_date not in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateBetween(Date value1, Date value2) {
            addCriterion("audit_date between", value1, value2, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotBetween(Date value1, Date value2) {
            addCriterion("audit_date not between", value1, value2, "auditDate");
            return (Criteria) this;
        }

        public Criteria andMonthRateIsNull() {
            addCriterion("month_rate is null");
            return (Criteria) this;
        }

        public Criteria andMonthRateIsNotNull() {
            addCriterion("month_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMonthRateEqualTo(BigDecimal value) {
            addCriterion("month_rate =", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotEqualTo(BigDecimal value) {
            addCriterion("month_rate <>", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateGreaterThan(BigDecimal value) {
            addCriterion("month_rate >", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("month_rate >=", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLessThan(BigDecimal value) {
            addCriterion("month_rate <", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("month_rate <=", value, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateIn(List<BigDecimal> values) {
            addCriterion("month_rate in", values, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotIn(List<BigDecimal> values) {
            addCriterion("month_rate not in", values, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_rate between", value1, value2, "monthRate");
            return (Criteria) this;
        }

        public Criteria andMonthRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("month_rate not between", value1, value2, "monthRate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateIsNull() {
            addCriterion("first_bill_date is null");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateIsNotNull() {
            addCriterion("first_bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateEqualTo(Date value) {
            addCriterion("first_bill_date =", value, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateNotEqualTo(Date value) {
            addCriterion("first_bill_date <>", value, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateGreaterThan(Date value) {
            addCriterion("first_bill_date >", value, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateGreaterThanOrEqualTo(Date value) {
            addCriterion("first_bill_date >=", value, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateLessThan(Date value) {
            addCriterion("first_bill_date <", value, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateLessThanOrEqualTo(Date value) {
            addCriterion("first_bill_date <=", value, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateIn(List<Date> values) {
            addCriterion("first_bill_date in", values, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateNotIn(List<Date> values) {
            addCriterion("first_bill_date not in", values, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateBetween(Date value1, Date value2) {
            addCriterion("first_bill_date between", value1, value2, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andFirstBillDateNotBetween(Date value1, Date value2) {
            addCriterion("first_bill_date not between", value1, value2, "firstBillDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNull() {
            addCriterion("bill_date is null");
            return (Criteria) this;
        }

        public Criteria andBillDateIsNotNull() {
            addCriterion("bill_date is not null");
            return (Criteria) this;
        }

        public Criteria andBillDateEqualTo(Date value) {
            addCriterion("bill_date =", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotEqualTo(Date value) {
            addCriterion("bill_date <>", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThan(Date value) {
            addCriterion("bill_date >", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateGreaterThanOrEqualTo(Date value) {
            addCriterion("bill_date >=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThan(Date value) {
            addCriterion("bill_date <", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateLessThanOrEqualTo(Date value) {
            addCriterion("bill_date <=", value, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateIn(List<Date> values) {
            addCriterion("bill_date in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotIn(List<Date> values) {
            addCriterion("bill_date not in", values, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateBetween(Date value1, Date value2) {
            addCriterion("bill_date between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andBillDateNotBetween(Date value1, Date value2) {
            addCriterion("bill_date not between", value1, value2, "billDate");
            return (Criteria) this;
        }

        public Criteria andPayOtherIsNull() {
            addCriterion("pay_other is null");
            return (Criteria) this;
        }

        public Criteria andPayOtherIsNotNull() {
            addCriterion("pay_other is not null");
            return (Criteria) this;
        }

        public Criteria andPayOtherEqualTo(BigDecimal value) {
            addCriterion("pay_other =", value, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherNotEqualTo(BigDecimal value) {
            addCriterion("pay_other <>", value, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherGreaterThan(BigDecimal value) {
            addCriterion("pay_other >", value, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_other >=", value, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherLessThan(BigDecimal value) {
            addCriterion("pay_other <", value, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pay_other <=", value, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherIn(List<BigDecimal> values) {
            addCriterion("pay_other in", values, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherNotIn(List<BigDecimal> values) {
            addCriterion("pay_other not in", values, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_other between", value1, value2, "payOther");
            return (Criteria) this;
        }

        public Criteria andPayOtherNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pay_other not between", value1, value2, "payOther");
            return (Criteria) this;
        }

        public Criteria andInsuranceIsNull() {
            addCriterion("insurance is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceIsNotNull() {
            addCriterion("insurance is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceEqualTo(String value) {
            addCriterion("insurance =", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotEqualTo(String value) {
            addCriterion("insurance <>", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceGreaterThan(String value) {
            addCriterion("insurance >", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceGreaterThanOrEqualTo(String value) {
            addCriterion("insurance >=", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceLessThan(String value) {
            addCriterion("insurance <", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceLessThanOrEqualTo(String value) {
            addCriterion("insurance <=", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceLike(String value) {
            addCriterion("insurance like", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotLike(String value) {
            addCriterion("insurance not like", value, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceIn(List<String> values) {
            addCriterion("insurance in", values, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotIn(List<String> values) {
            addCriterion("insurance not in", values, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceBetween(String value1, String value2) {
            addCriterion("insurance between", value1, value2, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceNotBetween(String value1, String value2) {
            addCriterion("insurance not between", value1, value2, "insurance");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateIsNull() {
            addCriterion("insurance_rate is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateIsNotNull() {
            addCriterion("insurance_rate is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateEqualTo(BigDecimal value) {
            addCriterion("insurance_rate =", value, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateNotEqualTo(BigDecimal value) {
            addCriterion("insurance_rate <>", value, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateGreaterThan(BigDecimal value) {
            addCriterion("insurance_rate >", value, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("insurance_rate >=", value, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateLessThan(BigDecimal value) {
            addCriterion("insurance_rate <", value, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("insurance_rate <=", value, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateIn(List<BigDecimal> values) {
            addCriterion("insurance_rate in", values, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateNotIn(List<BigDecimal> values) {
            addCriterion("insurance_rate not in", values, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insurance_rate between", value1, value2, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andInsuranceRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("insurance_rate not between", value1, value2, "insuranceRate");
            return (Criteria) this;
        }

        public Criteria andFlxPackageIsNull() {
            addCriterion("flx_package is null");
            return (Criteria) this;
        }

        public Criteria andFlxPackageIsNotNull() {
            addCriterion("flx_package is not null");
            return (Criteria) this;
        }

        public Criteria andFlxPackageEqualTo(String value) {
            addCriterion("flx_package =", value, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageNotEqualTo(String value) {
            addCriterion("flx_package <>", value, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageGreaterThan(String value) {
            addCriterion("flx_package >", value, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageGreaterThanOrEqualTo(String value) {
            addCriterion("flx_package >=", value, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageLessThan(String value) {
            addCriterion("flx_package <", value, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageLessThanOrEqualTo(String value) {
            addCriterion("flx_package <=", value, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageLike(String value) {
            addCriterion("flx_package like", value, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageNotLike(String value) {
            addCriterion("flx_package not like", value, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageIn(List<String> values) {
            addCriterion("flx_package in", values, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageNotIn(List<String> values) {
            addCriterion("flx_package not in", values, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageBetween(String value1, String value2) {
            addCriterion("flx_package between", value1, value2, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andFlxPackageNotBetween(String value1, String value2) {
            addCriterion("flx_package not between", value1, value2, "flxPackage");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andActvIdIsNull() {
            addCriterion("actv_id is null");
            return (Criteria) this;
        }

        public Criteria andActvIdIsNotNull() {
            addCriterion("actv_id is not null");
            return (Criteria) this;
        }

        public Criteria andActvIdEqualTo(String value) {
            addCriterion("actv_id =", value, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdNotEqualTo(String value) {
            addCriterion("actv_id <>", value, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdGreaterThan(String value) {
            addCriterion("actv_id >", value, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdGreaterThanOrEqualTo(String value) {
            addCriterion("actv_id >=", value, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdLessThan(String value) {
            addCriterion("actv_id <", value, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdLessThanOrEqualTo(String value) {
            addCriterion("actv_id <=", value, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdLike(String value) {
            addCriterion("actv_id like", value, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdNotLike(String value) {
            addCriterion("actv_id not like", value, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdIn(List<String> values) {
            addCriterion("actv_id in", values, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdNotIn(List<String> values) {
            addCriterion("actv_id not in", values, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdBetween(String value1, String value2) {
            addCriterion("actv_id between", value1, value2, "actvId");
            return (Criteria) this;
        }

        public Criteria andActvIdNotBetween(String value1, String value2) {
            addCriterion("actv_id not between", value1, value2, "actvId");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andTureNameIsNull() {
            addCriterion("ture_name is null");
            return (Criteria) this;
        }

        public Criteria andTureNameIsNotNull() {
            addCriterion("ture_name is not null");
            return (Criteria) this;
        }

        public Criteria andTureNameEqualTo(String value) {
            addCriterion("ture_name =", value, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameNotEqualTo(String value) {
            addCriterion("ture_name <>", value, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameGreaterThan(String value) {
            addCriterion("ture_name >", value, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameGreaterThanOrEqualTo(String value) {
            addCriterion("ture_name >=", value, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameLessThan(String value) {
            addCriterion("ture_name <", value, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameLessThanOrEqualTo(String value) {
            addCriterion("ture_name <=", value, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameLike(String value) {
            addCriterion("ture_name like", value, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameNotLike(String value) {
            addCriterion("ture_name not like", value, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameIn(List<String> values) {
            addCriterion("ture_name in", values, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameNotIn(List<String> values) {
            addCriterion("ture_name not in", values, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameBetween(String value1, String value2) {
            addCriterion("ture_name between", value1, value2, "tureName");
            return (Criteria) this;
        }

        public Criteria andTureNameNotBetween(String value1, String value2) {
            addCriterion("ture_name not between", value1, value2, "tureName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNull() {
            addCriterion("id_type is null");
            return (Criteria) this;
        }

        public Criteria andIdTypeIsNotNull() {
            addCriterion("id_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdTypeEqualTo(String value) {
            addCriterion("id_type =", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotEqualTo(String value) {
            addCriterion("id_type <>", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThan(String value) {
            addCriterion("id_type >", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("id_type >=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThan(String value) {
            addCriterion("id_type <", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLessThanOrEqualTo(String value) {
            addCriterion("id_type <=", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeLike(String value) {
            addCriterion("id_type like", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotLike(String value) {
            addCriterion("id_type not like", value, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeIn(List<String> values) {
            addCriterion("id_type in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotIn(List<String> values) {
            addCriterion("id_type not in", values, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeBetween(String value1, String value2) {
            addCriterion("id_type between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdTypeNotBetween(String value1, String value2) {
            addCriterion("id_type not between", value1, value2, "idType");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdIsNull() {
            addCriterion("identify_id is null");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdIsNotNull() {
            addCriterion("identify_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdEqualTo(String value) {
            addCriterion("identify_id =", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdNotEqualTo(String value) {
            addCriterion("identify_id <>", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdGreaterThan(String value) {
            addCriterion("identify_id >", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdGreaterThanOrEqualTo(String value) {
            addCriterion("identify_id >=", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdLessThan(String value) {
            addCriterion("identify_id <", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdLessThanOrEqualTo(String value) {
            addCriterion("identify_id <=", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdLike(String value) {
            addCriterion("identify_id like", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdNotLike(String value) {
            addCriterion("identify_id not like", value, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdIn(List<String> values) {
            addCriterion("identify_id in", values, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdNotIn(List<String> values) {
            addCriterion("identify_id not in", values, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdBetween(String value1, String value2) {
            addCriterion("identify_id between", value1, value2, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdentifyIdNotBetween(String value1, String value2) {
            addCriterion("identify_id not between", value1, value2, "identifyId");
            return (Criteria) this;
        }

        public Criteria andIdAvaIsNull() {
            addCriterion("id_ava is null");
            return (Criteria) this;
        }

        public Criteria andIdAvaIsNotNull() {
            addCriterion("id_ava is not null");
            return (Criteria) this;
        }

        public Criteria andIdAvaEqualTo(Date value) {
            addCriterion("id_ava =", value, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaNotEqualTo(Date value) {
            addCriterion("id_ava <>", value, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaGreaterThan(Date value) {
            addCriterion("id_ava >", value, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaGreaterThanOrEqualTo(Date value) {
            addCriterion("id_ava >=", value, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaLessThan(Date value) {
            addCriterion("id_ava <", value, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaLessThanOrEqualTo(Date value) {
            addCriterion("id_ava <=", value, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaIn(List<Date> values) {
            addCriterion("id_ava in", values, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaNotIn(List<Date> values) {
            addCriterion("id_ava not in", values, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaBetween(Date value1, Date value2) {
            addCriterion("id_ava between", value1, value2, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdAvaNotBetween(Date value1, Date value2) {
            addCriterion("id_ava not between", value1, value2, "idAva");
            return (Criteria) this;
        }

        public Criteria andIdIssueIsNull() {
            addCriterion("id_issue is null");
            return (Criteria) this;
        }

        public Criteria andIdIssueIsNotNull() {
            addCriterion("id_issue is not null");
            return (Criteria) this;
        }

        public Criteria andIdIssueEqualTo(String value) {
            addCriterion("id_issue =", value, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueNotEqualTo(String value) {
            addCriterion("id_issue <>", value, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueGreaterThan(String value) {
            addCriterion("id_issue >", value, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueGreaterThanOrEqualTo(String value) {
            addCriterion("id_issue >=", value, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueLessThan(String value) {
            addCriterion("id_issue <", value, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueLessThanOrEqualTo(String value) {
            addCriterion("id_issue <=", value, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueLike(String value) {
            addCriterion("id_issue like", value, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueNotLike(String value) {
            addCriterion("id_issue not like", value, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueIn(List<String> values) {
            addCriterion("id_issue in", values, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueNotIn(List<String> values) {
            addCriterion("id_issue not in", values, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueBetween(String value1, String value2) {
            addCriterion("id_issue between", value1, value2, "idIssue");
            return (Criteria) this;
        }

        public Criteria andIdIssueNotBetween(String value1, String value2) {
            addCriterion("id_issue not between", value1, value2, "idIssue");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNull() {
            addCriterion("res_type is null");
            return (Criteria) this;
        }

        public Criteria andResTypeIsNotNull() {
            addCriterion("res_type is not null");
            return (Criteria) this;
        }

        public Criteria andResTypeEqualTo(String value) {
            addCriterion("res_type =", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotEqualTo(String value) {
            addCriterion("res_type <>", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThan(String value) {
            addCriterion("res_type >", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeGreaterThanOrEqualTo(String value) {
            addCriterion("res_type >=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThan(String value) {
            addCriterion("res_type <", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLessThanOrEqualTo(String value) {
            addCriterion("res_type <=", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeLike(String value) {
            addCriterion("res_type like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotLike(String value) {
            addCriterion("res_type not like", value, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeIn(List<String> values) {
            addCriterion("res_type in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotIn(List<String> values) {
            addCriterion("res_type not in", values, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeBetween(String value1, String value2) {
            addCriterion("res_type between", value1, value2, "resType");
            return (Criteria) this;
        }

        public Criteria andResTypeNotBetween(String value1, String value2) {
            addCriterion("res_type not between", value1, value2, "resType");
            return (Criteria) this;
        }

        public Criteria andPrvIsNull() {
            addCriterion("prv is null");
            return (Criteria) this;
        }

        public Criteria andPrvIsNotNull() {
            addCriterion("prv is not null");
            return (Criteria) this;
        }

        public Criteria andPrvEqualTo(String value) {
            addCriterion("prv =", value, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvNotEqualTo(String value) {
            addCriterion("prv <>", value, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvGreaterThan(String value) {
            addCriterion("prv >", value, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvGreaterThanOrEqualTo(String value) {
            addCriterion("prv >=", value, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvLessThan(String value) {
            addCriterion("prv <", value, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvLessThanOrEqualTo(String value) {
            addCriterion("prv <=", value, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvLike(String value) {
            addCriterion("prv like", value, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvNotLike(String value) {
            addCriterion("prv not like", value, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvIn(List<String> values) {
            addCriterion("prv in", values, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvNotIn(List<String> values) {
            addCriterion("prv not in", values, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvBetween(String value1, String value2) {
            addCriterion("prv between", value1, value2, "prv");
            return (Criteria) this;
        }

        public Criteria andPrvNotBetween(String value1, String value2) {
            addCriterion("prv not between", value1, value2, "prv");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountyIsNull() {
            addCriterion("county is null");
            return (Criteria) this;
        }

        public Criteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (Criteria) this;
        }

        public Criteria andCountyEqualTo(String value) {
            addCriterion("county =", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotEqualTo(String value) {
            addCriterion("county <>", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThan(String value) {
            addCriterion("county >", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyGreaterThanOrEqualTo(String value) {
            addCriterion("county >=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThan(String value) {
            addCriterion("county <", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLessThanOrEqualTo(String value) {
            addCriterion("county <=", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyLike(String value) {
            addCriterion("county like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotLike(String value) {
            addCriterion("county not like", value, "county");
            return (Criteria) this;
        }

        public Criteria andCountyIn(List<String> values) {
            addCriterion("county in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotIn(List<String> values) {
            addCriterion("county not in", values, "county");
            return (Criteria) this;
        }

        public Criteria andCountyBetween(String value1, String value2) {
            addCriterion("county between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andCountyNotBetween(String value1, String value2) {
            addCriterion("county not between", value1, value2, "county");
            return (Criteria) this;
        }

        public Criteria andTownIsNull() {
            addCriterion("town is null");
            return (Criteria) this;
        }

        public Criteria andTownIsNotNull() {
            addCriterion("town is not null");
            return (Criteria) this;
        }

        public Criteria andTownEqualTo(String value) {
            addCriterion("town =", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotEqualTo(String value) {
            addCriterion("town <>", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThan(String value) {
            addCriterion("town >", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownGreaterThanOrEqualTo(String value) {
            addCriterion("town >=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThan(String value) {
            addCriterion("town <", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLessThanOrEqualTo(String value) {
            addCriterion("town <=", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownLike(String value) {
            addCriterion("town like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotLike(String value) {
            addCriterion("town not like", value, "town");
            return (Criteria) this;
        }

        public Criteria andTownIn(List<String> values) {
            addCriterion("town in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotIn(List<String> values) {
            addCriterion("town not in", values, "town");
            return (Criteria) this;
        }

        public Criteria andTownBetween(String value1, String value2) {
            addCriterion("town between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andTownNotBetween(String value1, String value2) {
            addCriterion("town not between", value1, value2, "town");
            return (Criteria) this;
        }

        public Criteria andStrIsNull() {
            addCriterion("str is null");
            return (Criteria) this;
        }

        public Criteria andStrIsNotNull() {
            addCriterion("str is not null");
            return (Criteria) this;
        }

        public Criteria andStrEqualTo(String value) {
            addCriterion("str =", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrNotEqualTo(String value) {
            addCriterion("str <>", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrGreaterThan(String value) {
            addCriterion("str >", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrGreaterThanOrEqualTo(String value) {
            addCriterion("str >=", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrLessThan(String value) {
            addCriterion("str <", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrLessThanOrEqualTo(String value) {
            addCriterion("str <=", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrLike(String value) {
            addCriterion("str like", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrNotLike(String value) {
            addCriterion("str not like", value, "str");
            return (Criteria) this;
        }

        public Criteria andStrIn(List<String> values) {
            addCriterion("str in", values, "str");
            return (Criteria) this;
        }

        public Criteria andStrNotIn(List<String> values) {
            addCriterion("str not in", values, "str");
            return (Criteria) this;
        }

        public Criteria andStrBetween(String value1, String value2) {
            addCriterion("str between", value1, value2, "str");
            return (Criteria) this;
        }

        public Criteria andStrNotBetween(String value1, String value2) {
            addCriterion("str not between", value1, value2, "str");
            return (Criteria) this;
        }

        public Criteria andCmtyIsNull() {
            addCriterion("cmty is null");
            return (Criteria) this;
        }

        public Criteria andCmtyIsNotNull() {
            addCriterion("cmty is not null");
            return (Criteria) this;
        }

        public Criteria andCmtyEqualTo(String value) {
            addCriterion("cmty =", value, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyNotEqualTo(String value) {
            addCriterion("cmty <>", value, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyGreaterThan(String value) {
            addCriterion("cmty >", value, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyGreaterThanOrEqualTo(String value) {
            addCriterion("cmty >=", value, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyLessThan(String value) {
            addCriterion("cmty <", value, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyLessThanOrEqualTo(String value) {
            addCriterion("cmty <=", value, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyLike(String value) {
            addCriterion("cmty like", value, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyNotLike(String value) {
            addCriterion("cmty not like", value, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyIn(List<String> values) {
            addCriterion("cmty in", values, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyNotIn(List<String> values) {
            addCriterion("cmty not in", values, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyBetween(String value1, String value2) {
            addCriterion("cmty between", value1, value2, "cmty");
            return (Criteria) this;
        }

        public Criteria andCmtyNotBetween(String value1, String value2) {
            addCriterion("cmty not between", value1, value2, "cmty");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNull() {
            addCriterion("house_no is null");
            return (Criteria) this;
        }

        public Criteria andHouseNoIsNotNull() {
            addCriterion("house_no is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNoEqualTo(String value) {
            addCriterion("house_no =", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotEqualTo(String value) {
            addCriterion("house_no <>", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThan(String value) {
            addCriterion("house_no >", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoGreaterThanOrEqualTo(String value) {
            addCriterion("house_no >=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThan(String value) {
            addCriterion("house_no <", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLessThanOrEqualTo(String value) {
            addCriterion("house_no <=", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoLike(String value) {
            addCriterion("house_no like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotLike(String value) {
            addCriterion("house_no not like", value, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoIn(List<String> values) {
            addCriterion("house_no in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotIn(List<String> values) {
            addCriterion("house_no not in", values, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoBetween(String value1, String value2) {
            addCriterion("house_no between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andHouseNoNotBetween(String value1, String value2) {
            addCriterion("house_no not between", value1, value2, "houseNo");
            return (Criteria) this;
        }

        public Criteria andIsAddResIsNull() {
            addCriterion("is_add_res is null");
            return (Criteria) this;
        }

        public Criteria andIsAddResIsNotNull() {
            addCriterion("is_add_res is not null");
            return (Criteria) this;
        }

        public Criteria andIsAddResEqualTo(String value) {
            addCriterion("is_add_res =", value, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResNotEqualTo(String value) {
            addCriterion("is_add_res <>", value, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResGreaterThan(String value) {
            addCriterion("is_add_res >", value, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResGreaterThanOrEqualTo(String value) {
            addCriterion("is_add_res >=", value, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResLessThan(String value) {
            addCriterion("is_add_res <", value, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResLessThanOrEqualTo(String value) {
            addCriterion("is_add_res <=", value, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResLike(String value) {
            addCriterion("is_add_res like", value, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResNotLike(String value) {
            addCriterion("is_add_res not like", value, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResIn(List<String> values) {
            addCriterion("is_add_res in", values, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResNotIn(List<String> values) {
            addCriterion("is_add_res not in", values, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResBetween(String value1, String value2) {
            addCriterion("is_add_res between", value1, value2, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andIsAddResNotBetween(String value1, String value2) {
            addCriterion("is_add_res not between", value1, value2, "isAddRes");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNull() {
            addCriterion("house_type is null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIsNotNull() {
            addCriterion("house_type is not null");
            return (Criteria) this;
        }

        public Criteria andHouseTypeEqualTo(String value) {
            addCriterion("house_type =", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotEqualTo(String value) {
            addCriterion("house_type <>", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThan(String value) {
            addCriterion("house_type >", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("house_type >=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThan(String value) {
            addCriterion("house_type <", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLessThanOrEqualTo(String value) {
            addCriterion("house_type <=", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeLike(String value) {
            addCriterion("house_type like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotLike(String value) {
            addCriterion("house_type not like", value, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeIn(List<String> values) {
            addCriterion("house_type in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotIn(List<String> values) {
            addCriterion("house_type not in", values, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeBetween(String value1, String value2) {
            addCriterion("house_type between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andHouseTypeNotBetween(String value1, String value2) {
            addCriterion("house_type not between", value1, value2, "houseType");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeIsNull() {
            addCriterion("crr_add_time is null");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeIsNotNull() {
            addCriterion("crr_add_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeEqualTo(String value) {
            addCriterion("crr_add_time =", value, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeNotEqualTo(String value) {
            addCriterion("crr_add_time <>", value, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeGreaterThan(String value) {
            addCriterion("crr_add_time >", value, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeGreaterThanOrEqualTo(String value) {
            addCriterion("crr_add_time >=", value, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeLessThan(String value) {
            addCriterion("crr_add_time <", value, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeLessThanOrEqualTo(String value) {
            addCriterion("crr_add_time <=", value, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeLike(String value) {
            addCriterion("crr_add_time like", value, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeNotLike(String value) {
            addCriterion("crr_add_time not like", value, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeIn(List<String> values) {
            addCriterion("crr_add_time in", values, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeNotIn(List<String> values) {
            addCriterion("crr_add_time not in", values, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeBetween(String value1, String value2) {
            addCriterion("crr_add_time between", value1, value2, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andCrrAddTimeNotBetween(String value1, String value2) {
            addCriterion("crr_add_time not between", value1, value2, "crrAddTime");
            return (Criteria) this;
        }

        public Criteria andPrv1IsNull() {
            addCriterion("prv1 is null");
            return (Criteria) this;
        }

        public Criteria andPrv1IsNotNull() {
            addCriterion("prv1 is not null");
            return (Criteria) this;
        }

        public Criteria andPrv1EqualTo(String value) {
            addCriterion("prv1 =", value, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1NotEqualTo(String value) {
            addCriterion("prv1 <>", value, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1GreaterThan(String value) {
            addCriterion("prv1 >", value, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1GreaterThanOrEqualTo(String value) {
            addCriterion("prv1 >=", value, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1LessThan(String value) {
            addCriterion("prv1 <", value, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1LessThanOrEqualTo(String value) {
            addCriterion("prv1 <=", value, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1Like(String value) {
            addCriterion("prv1 like", value, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1NotLike(String value) {
            addCriterion("prv1 not like", value, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1In(List<String> values) {
            addCriterion("prv1 in", values, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1NotIn(List<String> values) {
            addCriterion("prv1 not in", values, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1Between(String value1, String value2) {
            addCriterion("prv1 between", value1, value2, "prv1");
            return (Criteria) this;
        }

        public Criteria andPrv1NotBetween(String value1, String value2) {
            addCriterion("prv1 not between", value1, value2, "prv1");
            return (Criteria) this;
        }

        public Criteria andCity1IsNull() {
            addCriterion("city1 is null");
            return (Criteria) this;
        }

        public Criteria andCity1IsNotNull() {
            addCriterion("city1 is not null");
            return (Criteria) this;
        }

        public Criteria andCity1EqualTo(String value) {
            addCriterion("city1 =", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1NotEqualTo(String value) {
            addCriterion("city1 <>", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1GreaterThan(String value) {
            addCriterion("city1 >", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1GreaterThanOrEqualTo(String value) {
            addCriterion("city1 >=", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1LessThan(String value) {
            addCriterion("city1 <", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1LessThanOrEqualTo(String value) {
            addCriterion("city1 <=", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1Like(String value) {
            addCriterion("city1 like", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1NotLike(String value) {
            addCriterion("city1 not like", value, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1In(List<String> values) {
            addCriterion("city1 in", values, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1NotIn(List<String> values) {
            addCriterion("city1 not in", values, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1Between(String value1, String value2) {
            addCriterion("city1 between", value1, value2, "city1");
            return (Criteria) this;
        }

        public Criteria andCity1NotBetween(String value1, String value2) {
            addCriterion("city1 not between", value1, value2, "city1");
            return (Criteria) this;
        }

        public Criteria andCounty1IsNull() {
            addCriterion("county1 is null");
            return (Criteria) this;
        }

        public Criteria andCounty1IsNotNull() {
            addCriterion("county1 is not null");
            return (Criteria) this;
        }

        public Criteria andCounty1EqualTo(String value) {
            addCriterion("county1 =", value, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1NotEqualTo(String value) {
            addCriterion("county1 <>", value, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1GreaterThan(String value) {
            addCriterion("county1 >", value, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1GreaterThanOrEqualTo(String value) {
            addCriterion("county1 >=", value, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1LessThan(String value) {
            addCriterion("county1 <", value, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1LessThanOrEqualTo(String value) {
            addCriterion("county1 <=", value, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1Like(String value) {
            addCriterion("county1 like", value, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1NotLike(String value) {
            addCriterion("county1 not like", value, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1In(List<String> values) {
            addCriterion("county1 in", values, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1NotIn(List<String> values) {
            addCriterion("county1 not in", values, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1Between(String value1, String value2) {
            addCriterion("county1 between", value1, value2, "county1");
            return (Criteria) this;
        }

        public Criteria andCounty1NotBetween(String value1, String value2) {
            addCriterion("county1 not between", value1, value2, "county1");
            return (Criteria) this;
        }

        public Criteria andTown1IsNull() {
            addCriterion("town1 is null");
            return (Criteria) this;
        }

        public Criteria andTown1IsNotNull() {
            addCriterion("town1 is not null");
            return (Criteria) this;
        }

        public Criteria andTown1EqualTo(String value) {
            addCriterion("town1 =", value, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1NotEqualTo(String value) {
            addCriterion("town1 <>", value, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1GreaterThan(String value) {
            addCriterion("town1 >", value, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1GreaterThanOrEqualTo(String value) {
            addCriterion("town1 >=", value, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1LessThan(String value) {
            addCriterion("town1 <", value, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1LessThanOrEqualTo(String value) {
            addCriterion("town1 <=", value, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1Like(String value) {
            addCriterion("town1 like", value, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1NotLike(String value) {
            addCriterion("town1 not like", value, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1In(List<String> values) {
            addCriterion("town1 in", values, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1NotIn(List<String> values) {
            addCriterion("town1 not in", values, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1Between(String value1, String value2) {
            addCriterion("town1 between", value1, value2, "town1");
            return (Criteria) this;
        }

        public Criteria andTown1NotBetween(String value1, String value2) {
            addCriterion("town1 not between", value1, value2, "town1");
            return (Criteria) this;
        }

        public Criteria andStr1IsNull() {
            addCriterion("str1 is null");
            return (Criteria) this;
        }

        public Criteria andStr1IsNotNull() {
            addCriterion("str1 is not null");
            return (Criteria) this;
        }

        public Criteria andStr1EqualTo(String value) {
            addCriterion("str1 =", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1NotEqualTo(String value) {
            addCriterion("str1 <>", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1GreaterThan(String value) {
            addCriterion("str1 >", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1GreaterThanOrEqualTo(String value) {
            addCriterion("str1 >=", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1LessThan(String value) {
            addCriterion("str1 <", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1LessThanOrEqualTo(String value) {
            addCriterion("str1 <=", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1Like(String value) {
            addCriterion("str1 like", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1NotLike(String value) {
            addCriterion("str1 not like", value, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1In(List<String> values) {
            addCriterion("str1 in", values, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1NotIn(List<String> values) {
            addCriterion("str1 not in", values, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1Between(String value1, String value2) {
            addCriterion("str1 between", value1, value2, "str1");
            return (Criteria) this;
        }

        public Criteria andStr1NotBetween(String value1, String value2) {
            addCriterion("str1 not between", value1, value2, "str1");
            return (Criteria) this;
        }

        public Criteria andCmty1IsNull() {
            addCriterion("cmty1 is null");
            return (Criteria) this;
        }

        public Criteria andCmty1IsNotNull() {
            addCriterion("cmty1 is not null");
            return (Criteria) this;
        }

        public Criteria andCmty1EqualTo(String value) {
            addCriterion("cmty1 =", value, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1NotEqualTo(String value) {
            addCriterion("cmty1 <>", value, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1GreaterThan(String value) {
            addCriterion("cmty1 >", value, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1GreaterThanOrEqualTo(String value) {
            addCriterion("cmty1 >=", value, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1LessThan(String value) {
            addCriterion("cmty1 <", value, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1LessThanOrEqualTo(String value) {
            addCriterion("cmty1 <=", value, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1Like(String value) {
            addCriterion("cmty1 like", value, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1NotLike(String value) {
            addCriterion("cmty1 not like", value, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1In(List<String> values) {
            addCriterion("cmty1 in", values, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1NotIn(List<String> values) {
            addCriterion("cmty1 not in", values, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1Between(String value1, String value2) {
            addCriterion("cmty1 between", value1, value2, "cmty1");
            return (Criteria) this;
        }

        public Criteria andCmty1NotBetween(String value1, String value2) {
            addCriterion("cmty1 not between", value1, value2, "cmty1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1IsNull() {
            addCriterion("house_no1 is null");
            return (Criteria) this;
        }

        public Criteria andHouseNo1IsNotNull() {
            addCriterion("house_no1 is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNo1EqualTo(String value) {
            addCriterion("house_no1 =", value, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1NotEqualTo(String value) {
            addCriterion("house_no1 <>", value, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1GreaterThan(String value) {
            addCriterion("house_no1 >", value, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1GreaterThanOrEqualTo(String value) {
            addCriterion("house_no1 >=", value, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1LessThan(String value) {
            addCriterion("house_no1 <", value, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1LessThanOrEqualTo(String value) {
            addCriterion("house_no1 <=", value, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1Like(String value) {
            addCriterion("house_no1 like", value, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1NotLike(String value) {
            addCriterion("house_no1 not like", value, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1In(List<String> values) {
            addCriterion("house_no1 in", values, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1NotIn(List<String> values) {
            addCriterion("house_no1 not in", values, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1Between(String value1, String value2) {
            addCriterion("house_no1 between", value1, value2, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andHouseNo1NotBetween(String value1, String value2) {
            addCriterion("house_no1 not between", value1, value2, "houseNo1");
            return (Criteria) this;
        }

        public Criteria andDocTypeIsNull() {
            addCriterion("doc_type is null");
            return (Criteria) this;
        }

        public Criteria andDocTypeIsNotNull() {
            addCriterion("doc_type is not null");
            return (Criteria) this;
        }

        public Criteria andDocTypeEqualTo(String value) {
            addCriterion("doc_type =", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotEqualTo(String value) {
            addCriterion("doc_type <>", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeGreaterThan(String value) {
            addCriterion("doc_type >", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeGreaterThanOrEqualTo(String value) {
            addCriterion("doc_type >=", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLessThan(String value) {
            addCriterion("doc_type <", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLessThanOrEqualTo(String value) {
            addCriterion("doc_type <=", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeLike(String value) {
            addCriterion("doc_type like", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotLike(String value) {
            addCriterion("doc_type not like", value, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeIn(List<String> values) {
            addCriterion("doc_type in", values, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotIn(List<String> values) {
            addCriterion("doc_type not in", values, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeBetween(String value1, String value2) {
            addCriterion("doc_type between", value1, value2, "docType");
            return (Criteria) this;
        }

        public Criteria andDocTypeNotBetween(String value1, String value2) {
            addCriterion("doc_type not between", value1, value2, "docType");
            return (Criteria) this;
        }

        public Criteria andRentFeeIsNull() {
            addCriterion("rent_fee is null");
            return (Criteria) this;
        }

        public Criteria andRentFeeIsNotNull() {
            addCriterion("rent_fee is not null");
            return (Criteria) this;
        }

        public Criteria andRentFeeEqualTo(String value) {
            addCriterion("rent_fee =", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotEqualTo(String value) {
            addCriterion("rent_fee <>", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeGreaterThan(String value) {
            addCriterion("rent_fee >", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeGreaterThanOrEqualTo(String value) {
            addCriterion("rent_fee >=", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeLessThan(String value) {
            addCriterion("rent_fee <", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeLessThanOrEqualTo(String value) {
            addCriterion("rent_fee <=", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeLike(String value) {
            addCriterion("rent_fee like", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotLike(String value) {
            addCriterion("rent_fee not like", value, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeIn(List<String> values) {
            addCriterion("rent_fee in", values, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotIn(List<String> values) {
            addCriterion("rent_fee not in", values, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeBetween(String value1, String value2) {
            addCriterion("rent_fee between", value1, value2, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRentFeeNotBetween(String value1, String value2) {
            addCriterion("rent_fee not between", value1, value2, "rentFee");
            return (Criteria) this;
        }

        public Criteria andRaceIsNull() {
            addCriterion("race is null");
            return (Criteria) this;
        }

        public Criteria andRaceIsNotNull() {
            addCriterion("race is not null");
            return (Criteria) this;
        }

        public Criteria andRaceEqualTo(String value) {
            addCriterion("race =", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceNotEqualTo(String value) {
            addCriterion("race <>", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceGreaterThan(String value) {
            addCriterion("race >", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceGreaterThanOrEqualTo(String value) {
            addCriterion("race >=", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceLessThan(String value) {
            addCriterion("race <", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceLessThanOrEqualTo(String value) {
            addCriterion("race <=", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceLike(String value) {
            addCriterion("race like", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceNotLike(String value) {
            addCriterion("race not like", value, "race");
            return (Criteria) this;
        }

        public Criteria andRaceIn(List<String> values) {
            addCriterion("race in", values, "race");
            return (Criteria) this;
        }

        public Criteria andRaceNotIn(List<String> values) {
            addCriterion("race not in", values, "race");
            return (Criteria) this;
        }

        public Criteria andRaceBetween(String value1, String value2) {
            addCriterion("race between", value1, value2, "race");
            return (Criteria) this;
        }

        public Criteria andRaceNotBetween(String value1, String value2) {
            addCriterion("race not between", value1, value2, "race");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileMthsIsNull() {
            addCriterion("mobile_mths is null");
            return (Criteria) this;
        }

        public Criteria andMobileMthsIsNotNull() {
            addCriterion("mobile_mths is not null");
            return (Criteria) this;
        }

        public Criteria andMobileMthsEqualTo(String value) {
            addCriterion("mobile_mths =", value, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsNotEqualTo(String value) {
            addCriterion("mobile_mths <>", value, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsGreaterThan(String value) {
            addCriterion("mobile_mths >", value, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_mths >=", value, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsLessThan(String value) {
            addCriterion("mobile_mths <", value, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsLessThanOrEqualTo(String value) {
            addCriterion("mobile_mths <=", value, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsLike(String value) {
            addCriterion("mobile_mths like", value, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsNotLike(String value) {
            addCriterion("mobile_mths not like", value, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsIn(List<String> values) {
            addCriterion("mobile_mths in", values, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsNotIn(List<String> values) {
            addCriterion("mobile_mths not in", values, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsBetween(String value1, String value2) {
            addCriterion("mobile_mths between", value1, value2, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMobileMthsNotBetween(String value1, String value2) {
            addCriterion("mobile_mths not between", value1, value2, "mobileMths");
            return (Criteria) this;
        }

        public Criteria andMthBillIsNull() {
            addCriterion("mth_bill is null");
            return (Criteria) this;
        }

        public Criteria andMthBillIsNotNull() {
            addCriterion("mth_bill is not null");
            return (Criteria) this;
        }

        public Criteria andMthBillEqualTo(String value) {
            addCriterion("mth_bill =", value, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillNotEqualTo(String value) {
            addCriterion("mth_bill <>", value, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillGreaterThan(String value) {
            addCriterion("mth_bill >", value, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillGreaterThanOrEqualTo(String value) {
            addCriterion("mth_bill >=", value, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillLessThan(String value) {
            addCriterion("mth_bill <", value, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillLessThanOrEqualTo(String value) {
            addCriterion("mth_bill <=", value, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillLike(String value) {
            addCriterion("mth_bill like", value, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillNotLike(String value) {
            addCriterion("mth_bill not like", value, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillIn(List<String> values) {
            addCriterion("mth_bill in", values, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillNotIn(List<String> values) {
            addCriterion("mth_bill not in", values, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillBetween(String value1, String value2) {
            addCriterion("mth_bill between", value1, value2, "mthBill");
            return (Criteria) this;
        }

        public Criteria andMthBillNotBetween(String value1, String value2) {
            addCriterion("mth_bill not between", value1, value2, "mthBill");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedIsNull() {
            addCriterion("is_verified is null");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedIsNotNull() {
            addCriterion("is_verified is not null");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedEqualTo(String value) {
            addCriterion("is_verified =", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedNotEqualTo(String value) {
            addCriterion("is_verified <>", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedGreaterThan(String value) {
            addCriterion("is_verified >", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedGreaterThanOrEqualTo(String value) {
            addCriterion("is_verified >=", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedLessThan(String value) {
            addCriterion("is_verified <", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedLessThanOrEqualTo(String value) {
            addCriterion("is_verified <=", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedLike(String value) {
            addCriterion("is_verified like", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedNotLike(String value) {
            addCriterion("is_verified not like", value, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedIn(List<String> values) {
            addCriterion("is_verified in", values, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedNotIn(List<String> values) {
            addCriterion("is_verified not in", values, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedBetween(String value1, String value2) {
            addCriterion("is_verified between", value1, value2, "isVerified");
            return (Criteria) this;
        }

        public Criteria andIsVerifiedNotBetween(String value1, String value2) {
            addCriterion("is_verified not between", value1, value2, "isVerified");
            return (Criteria) this;
        }

        public Criteria andAddPhoneIsNull() {
            addCriterion("add_phone is null");
            return (Criteria) this;
        }

        public Criteria andAddPhoneIsNotNull() {
            addCriterion("add_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAddPhoneEqualTo(String value) {
            addCriterion("add_phone =", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneNotEqualTo(String value) {
            addCriterion("add_phone <>", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneGreaterThan(String value) {
            addCriterion("add_phone >", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("add_phone >=", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneLessThan(String value) {
            addCriterion("add_phone <", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneLessThanOrEqualTo(String value) {
            addCriterion("add_phone <=", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneLike(String value) {
            addCriterion("add_phone like", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneNotLike(String value) {
            addCriterion("add_phone not like", value, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneIn(List<String> values) {
            addCriterion("add_phone in", values, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneNotIn(List<String> values) {
            addCriterion("add_phone not in", values, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneBetween(String value1, String value2) {
            addCriterion("add_phone between", value1, value2, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneNotBetween(String value1, String value2) {
            addCriterion("add_phone not between", value1, value2, "addPhone");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccIsNull() {
            addCriterion("add_phone_acc is null");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccIsNotNull() {
            addCriterion("add_phone_acc is not null");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccEqualTo(String value) {
            addCriterion("add_phone_acc =", value, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccNotEqualTo(String value) {
            addCriterion("add_phone_acc <>", value, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccGreaterThan(String value) {
            addCriterion("add_phone_acc >", value, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccGreaterThanOrEqualTo(String value) {
            addCriterion("add_phone_acc >=", value, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccLessThan(String value) {
            addCriterion("add_phone_acc <", value, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccLessThanOrEqualTo(String value) {
            addCriterion("add_phone_acc <=", value, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccLike(String value) {
            addCriterion("add_phone_acc like", value, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccNotLike(String value) {
            addCriterion("add_phone_acc not like", value, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccIn(List<String> values) {
            addCriterion("add_phone_acc in", values, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccNotIn(List<String> values) {
            addCriterion("add_phone_acc not in", values, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccBetween(String value1, String value2) {
            addCriterion("add_phone_acc between", value1, value2, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andAddPhoneAccNotBetween(String value1, String value2) {
            addCriterion("add_phone_acc not between", value1, value2, "addPhoneAcc");
            return (Criteria) this;
        }

        public Criteria andEMailIsNull() {
            addCriterion("e_mail is null");
            return (Criteria) this;
        }

        public Criteria andEMailIsNotNull() {
            addCriterion("e_mail is not null");
            return (Criteria) this;
        }

        public Criteria andEMailEqualTo(String value) {
            addCriterion("e_mail =", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotEqualTo(String value) {
            addCriterion("e_mail <>", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThan(String value) {
            addCriterion("e_mail >", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailGreaterThanOrEqualTo(String value) {
            addCriterion("e_mail >=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThan(String value) {
            addCriterion("e_mail <", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLessThanOrEqualTo(String value) {
            addCriterion("e_mail <=", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailLike(String value) {
            addCriterion("e_mail like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotLike(String value) {
            addCriterion("e_mail not like", value, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailIn(List<String> values) {
            addCriterion("e_mail in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotIn(List<String> values) {
            addCriterion("e_mail not in", values, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailBetween(String value1, String value2) {
            addCriterion("e_mail between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andEMailNotBetween(String value1, String value2) {
            addCriterion("e_mail not between", value1, value2, "eMail");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("qq is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("qq is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("qq =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("qq <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("qq >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("qq >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("qq <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("qq <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("qq like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("qq not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("qq in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("qq not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("qq between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("qq not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andMarrStateIsNull() {
            addCriterion("marr_state is null");
            return (Criteria) this;
        }

        public Criteria andMarrStateIsNotNull() {
            addCriterion("marr_state is not null");
            return (Criteria) this;
        }

        public Criteria andMarrStateEqualTo(String value) {
            addCriterion("marr_state =", value, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateNotEqualTo(String value) {
            addCriterion("marr_state <>", value, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateGreaterThan(String value) {
            addCriterion("marr_state >", value, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateGreaterThanOrEqualTo(String value) {
            addCriterion("marr_state >=", value, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateLessThan(String value) {
            addCriterion("marr_state <", value, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateLessThanOrEqualTo(String value) {
            addCriterion("marr_state <=", value, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateLike(String value) {
            addCriterion("marr_state like", value, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateNotLike(String value) {
            addCriterion("marr_state not like", value, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateIn(List<String> values) {
            addCriterion("marr_state in", values, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateNotIn(List<String> values) {
            addCriterion("marr_state not in", values, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateBetween(String value1, String value2) {
            addCriterion("marr_state between", value1, value2, "marrState");
            return (Criteria) this;
        }

        public Criteria andMarrStateNotBetween(String value1, String value2) {
            addCriterion("marr_state not between", value1, value2, "marrState");
            return (Criteria) this;
        }

        public Criteria andSpouseNameIsNull() {
            addCriterion("spouse_name is null");
            return (Criteria) this;
        }

        public Criteria andSpouseNameIsNotNull() {
            addCriterion("spouse_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseNameEqualTo(String value) {
            addCriterion("spouse_name =", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameNotEqualTo(String value) {
            addCriterion("spouse_name <>", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameGreaterThan(String value) {
            addCriterion("spouse_name >", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameGreaterThanOrEqualTo(String value) {
            addCriterion("spouse_name >=", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameLessThan(String value) {
            addCriterion("spouse_name <", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameLessThanOrEqualTo(String value) {
            addCriterion("spouse_name <=", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameLike(String value) {
            addCriterion("spouse_name like", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameNotLike(String value) {
            addCriterion("spouse_name not like", value, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameIn(List<String> values) {
            addCriterion("spouse_name in", values, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameNotIn(List<String> values) {
            addCriterion("spouse_name not in", values, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameBetween(String value1, String value2) {
            addCriterion("spouse_name between", value1, value2, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseNameNotBetween(String value1, String value2) {
            addCriterion("spouse_name not between", value1, value2, "spouseName");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileIsNull() {
            addCriterion("spouse_mobile is null");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileIsNotNull() {
            addCriterion("spouse_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileEqualTo(String value) {
            addCriterion("spouse_mobile =", value, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileNotEqualTo(String value) {
            addCriterion("spouse_mobile <>", value, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileGreaterThan(String value) {
            addCriterion("spouse_mobile >", value, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileGreaterThanOrEqualTo(String value) {
            addCriterion("spouse_mobile >=", value, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileLessThan(String value) {
            addCriterion("spouse_mobile <", value, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileLessThanOrEqualTo(String value) {
            addCriterion("spouse_mobile <=", value, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileLike(String value) {
            addCriterion("spouse_mobile like", value, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileNotLike(String value) {
            addCriterion("spouse_mobile not like", value, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileIn(List<String> values) {
            addCriterion("spouse_mobile in", values, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileNotIn(List<String> values) {
            addCriterion("spouse_mobile not in", values, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileBetween(String value1, String value2) {
            addCriterion("spouse_mobile between", value1, value2, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andSpouseMobileNotBetween(String value1, String value2) {
            addCriterion("spouse_mobile not between", value1, value2, "spouseMobile");
            return (Criteria) this;
        }

        public Criteria andFmlNameIsNull() {
            addCriterion("fml_name is null");
            return (Criteria) this;
        }

        public Criteria andFmlNameIsNotNull() {
            addCriterion("fml_name is not null");
            return (Criteria) this;
        }

        public Criteria andFmlNameEqualTo(String value) {
            addCriterion("fml_name =", value, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameNotEqualTo(String value) {
            addCriterion("fml_name <>", value, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameGreaterThan(String value) {
            addCriterion("fml_name >", value, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameGreaterThanOrEqualTo(String value) {
            addCriterion("fml_name >=", value, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameLessThan(String value) {
            addCriterion("fml_name <", value, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameLessThanOrEqualTo(String value) {
            addCriterion("fml_name <=", value, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameLike(String value) {
            addCriterion("fml_name like", value, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameNotLike(String value) {
            addCriterion("fml_name not like", value, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameIn(List<String> values) {
            addCriterion("fml_name in", values, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameNotIn(List<String> values) {
            addCriterion("fml_name not in", values, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameBetween(String value1, String value2) {
            addCriterion("fml_name between", value1, value2, "fmlName");
            return (Criteria) this;
        }

        public Criteria andFmlNameNotBetween(String value1, String value2) {
            addCriterion("fml_name not between", value1, value2, "fmlName");
            return (Criteria) this;
        }

        public Criteria andRelationIsNull() {
            addCriterion("relation is null");
            return (Criteria) this;
        }

        public Criteria andRelationIsNotNull() {
            addCriterion("relation is not null");
            return (Criteria) this;
        }

        public Criteria andRelationEqualTo(String value) {
            addCriterion("relation =", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotEqualTo(String value) {
            addCriterion("relation <>", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThan(String value) {
            addCriterion("relation >", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationGreaterThanOrEqualTo(String value) {
            addCriterion("relation >=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThan(String value) {
            addCriterion("relation <", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLessThanOrEqualTo(String value) {
            addCriterion("relation <=", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationLike(String value) {
            addCriterion("relation like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotLike(String value) {
            addCriterion("relation not like", value, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationIn(List<String> values) {
            addCriterion("relation in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotIn(List<String> values) {
            addCriterion("relation not in", values, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationBetween(String value1, String value2) {
            addCriterion("relation between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andRelationNotBetween(String value1, String value2) {
            addCriterion("relation not between", value1, value2, "relation");
            return (Criteria) this;
        }

        public Criteria andFmlContactIsNull() {
            addCriterion("fml_contact is null");
            return (Criteria) this;
        }

        public Criteria andFmlContactIsNotNull() {
            addCriterion("fml_contact is not null");
            return (Criteria) this;
        }

        public Criteria andFmlContactEqualTo(String value) {
            addCriterion("fml_contact =", value, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactNotEqualTo(String value) {
            addCriterion("fml_contact <>", value, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactGreaterThan(String value) {
            addCriterion("fml_contact >", value, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactGreaterThanOrEqualTo(String value) {
            addCriterion("fml_contact >=", value, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactLessThan(String value) {
            addCriterion("fml_contact <", value, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactLessThanOrEqualTo(String value) {
            addCriterion("fml_contact <=", value, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactLike(String value) {
            addCriterion("fml_contact like", value, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactNotLike(String value) {
            addCriterion("fml_contact not like", value, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactIn(List<String> values) {
            addCriterion("fml_contact in", values, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactNotIn(List<String> values) {
            addCriterion("fml_contact not in", values, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactBetween(String value1, String value2) {
            addCriterion("fml_contact between", value1, value2, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andFmlContactNotBetween(String value1, String value2) {
            addCriterion("fml_contact not between", value1, value2, "fmlContact");
            return (Criteria) this;
        }

        public Criteria andIsKFlmIsNull() {
            addCriterion("is_k_flm is null");
            return (Criteria) this;
        }

        public Criteria andIsKFlmIsNotNull() {
            addCriterion("is_k_flm is not null");
            return (Criteria) this;
        }

        public Criteria andIsKFlmEqualTo(String value) {
            addCriterion("is_k_flm =", value, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmNotEqualTo(String value) {
            addCriterion("is_k_flm <>", value, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmGreaterThan(String value) {
            addCriterion("is_k_flm >", value, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmGreaterThanOrEqualTo(String value) {
            addCriterion("is_k_flm >=", value, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmLessThan(String value) {
            addCriterion("is_k_flm <", value, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmLessThanOrEqualTo(String value) {
            addCriterion("is_k_flm <=", value, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmLike(String value) {
            addCriterion("is_k_flm like", value, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmNotLike(String value) {
            addCriterion("is_k_flm not like", value, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmIn(List<String> values) {
            addCriterion("is_k_flm in", values, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmNotIn(List<String> values) {
            addCriterion("is_k_flm not in", values, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmBetween(String value1, String value2) {
            addCriterion("is_k_flm between", value1, value2, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsKFlmNotBetween(String value1, String value2) {
            addCriterion("is_k_flm not between", value1, value2, "isKFlm");
            return (Criteria) this;
        }

        public Criteria andIsValid2IsNull() {
            addCriterion("is_valid2 is null");
            return (Criteria) this;
        }

        public Criteria andIsValid2IsNotNull() {
            addCriterion("is_valid2 is not null");
            return (Criteria) this;
        }

        public Criteria andIsValid2EqualTo(String value) {
            addCriterion("is_valid2 =", value, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2NotEqualTo(String value) {
            addCriterion("is_valid2 <>", value, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2GreaterThan(String value) {
            addCriterion("is_valid2 >", value, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2GreaterThanOrEqualTo(String value) {
            addCriterion("is_valid2 >=", value, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2LessThan(String value) {
            addCriterion("is_valid2 <", value, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2LessThanOrEqualTo(String value) {
            addCriterion("is_valid2 <=", value, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2Like(String value) {
            addCriterion("is_valid2 like", value, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2NotLike(String value) {
            addCriterion("is_valid2 not like", value, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2In(List<String> values) {
            addCriterion("is_valid2 in", values, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2NotIn(List<String> values) {
            addCriterion("is_valid2 not in", values, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2Between(String value1, String value2) {
            addCriterion("is_valid2 between", value1, value2, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsValid2NotBetween(String value1, String value2) {
            addCriterion("is_valid2 not between", value1, value2, "isValid2");
            return (Criteria) this;
        }

        public Criteria andIsFmlResIsNull() {
            addCriterion("is_fml_res is null");
            return (Criteria) this;
        }

        public Criteria andIsFmlResIsNotNull() {
            addCriterion("is_fml_res is not null");
            return (Criteria) this;
        }

        public Criteria andIsFmlResEqualTo(String value) {
            addCriterion("is_fml_res =", value, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResNotEqualTo(String value) {
            addCriterion("is_fml_res <>", value, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResGreaterThan(String value) {
            addCriterion("is_fml_res >", value, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResGreaterThanOrEqualTo(String value) {
            addCriterion("is_fml_res >=", value, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResLessThan(String value) {
            addCriterion("is_fml_res <", value, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResLessThanOrEqualTo(String value) {
            addCriterion("is_fml_res <=", value, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResLike(String value) {
            addCriterion("is_fml_res like", value, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResNotLike(String value) {
            addCriterion("is_fml_res not like", value, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResIn(List<String> values) {
            addCriterion("is_fml_res in", values, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResNotIn(List<String> values) {
            addCriterion("is_fml_res not in", values, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResBetween(String value1, String value2) {
            addCriterion("is_fml_res between", value1, value2, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andIsFmlResNotBetween(String value1, String value2) {
            addCriterion("is_fml_res not between", value1, value2, "isFmlRes");
            return (Criteria) this;
        }

        public Criteria andFmlAddIsNull() {
            addCriterion("fml_add is null");
            return (Criteria) this;
        }

        public Criteria andFmlAddIsNotNull() {
            addCriterion("fml_add is not null");
            return (Criteria) this;
        }

        public Criteria andFmlAddEqualTo(String value) {
            addCriterion("fml_add =", value, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddNotEqualTo(String value) {
            addCriterion("fml_add <>", value, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddGreaterThan(String value) {
            addCriterion("fml_add >", value, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddGreaterThanOrEqualTo(String value) {
            addCriterion("fml_add >=", value, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddLessThan(String value) {
            addCriterion("fml_add <", value, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddLessThanOrEqualTo(String value) {
            addCriterion("fml_add <=", value, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddLike(String value) {
            addCriterion("fml_add like", value, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddNotLike(String value) {
            addCriterion("fml_add not like", value, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddIn(List<String> values) {
            addCriterion("fml_add in", values, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddNotIn(List<String> values) {
            addCriterion("fml_add not in", values, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddBetween(String value1, String value2) {
            addCriterion("fml_add between", value1, value2, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andFmlAddNotBetween(String value1, String value2) {
            addCriterion("fml_add not between", value1, value2, "fmlAdd");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueIsNull() {
            addCriterion("is_spouse_ctc_true is null");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueIsNotNull() {
            addCriterion("is_spouse_ctc_true is not null");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueEqualTo(String value) {
            addCriterion("is_spouse_ctc_true =", value, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueNotEqualTo(String value) {
            addCriterion("is_spouse_ctc_true <>", value, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueGreaterThan(String value) {
            addCriterion("is_spouse_ctc_true >", value, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueGreaterThanOrEqualTo(String value) {
            addCriterion("is_spouse_ctc_true >=", value, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueLessThan(String value) {
            addCriterion("is_spouse_ctc_true <", value, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueLessThanOrEqualTo(String value) {
            addCriterion("is_spouse_ctc_true <=", value, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueLike(String value) {
            addCriterion("is_spouse_ctc_true like", value, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueNotLike(String value) {
            addCriterion("is_spouse_ctc_true not like", value, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueIn(List<String> values) {
            addCriterion("is_spouse_ctc_true in", values, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueNotIn(List<String> values) {
            addCriterion("is_spouse_ctc_true not in", values, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueBetween(String value1, String value2) {
            addCriterion("is_spouse_ctc_true between", value1, value2, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsSpouseCtcTrueNotBetween(String value1, String value2) {
            addCriterion("is_spouse_ctc_true not between", value1, value2, "isSpouseCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueIsNull() {
            addCriterion("is_fml_ctc_true is null");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueIsNotNull() {
            addCriterion("is_fml_ctc_true is not null");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueEqualTo(String value) {
            addCriterion("is_fml_ctc_true =", value, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueNotEqualTo(String value) {
            addCriterion("is_fml_ctc_true <>", value, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueGreaterThan(String value) {
            addCriterion("is_fml_ctc_true >", value, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueGreaterThanOrEqualTo(String value) {
            addCriterion("is_fml_ctc_true >=", value, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueLessThan(String value) {
            addCriterion("is_fml_ctc_true <", value, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueLessThanOrEqualTo(String value) {
            addCriterion("is_fml_ctc_true <=", value, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueLike(String value) {
            addCriterion("is_fml_ctc_true like", value, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueNotLike(String value) {
            addCriterion("is_fml_ctc_true not like", value, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueIn(List<String> values) {
            addCriterion("is_fml_ctc_true in", values, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueNotIn(List<String> values) {
            addCriterion("is_fml_ctc_true not in", values, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueBetween(String value1, String value2) {
            addCriterion("is_fml_ctc_true between", value1, value2, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andIsFmlCtcTrueNotBetween(String value1, String value2) {
            addCriterion("is_fml_ctc_true not between", value1, value2, "isFmlCtcTrue");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameIsNull() {
            addCriterion("crr_org_name is null");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameIsNotNull() {
            addCriterion("crr_org_name is not null");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameEqualTo(String value) {
            addCriterion("crr_org_name =", value, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameNotEqualTo(String value) {
            addCriterion("crr_org_name <>", value, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameGreaterThan(String value) {
            addCriterion("crr_org_name >", value, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("crr_org_name >=", value, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameLessThan(String value) {
            addCriterion("crr_org_name <", value, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameLessThanOrEqualTo(String value) {
            addCriterion("crr_org_name <=", value, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameLike(String value) {
            addCriterion("crr_org_name like", value, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameNotLike(String value) {
            addCriterion("crr_org_name not like", value, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameIn(List<String> values) {
            addCriterion("crr_org_name in", values, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameNotIn(List<String> values) {
            addCriterion("crr_org_name not in", values, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameBetween(String value1, String value2) {
            addCriterion("crr_org_name between", value1, value2, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andCrrOrgNameNotBetween(String value1, String value2) {
            addCriterion("crr_org_name not between", value1, value2, "crrOrgName");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNull() {
            addCriterion("org_type is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("org_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(String value) {
            addCriterion("org_type =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(String value) {
            addCriterion("org_type <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(String value) {
            addCriterion("org_type >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("org_type >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(String value) {
            addCriterion("org_type <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("org_type <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLike(String value) {
            addCriterion("org_type like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotLike(String value) {
            addCriterion("org_type not like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<String> values) {
            addCriterion("org_type in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<String> values) {
            addCriterion("org_type not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(String value1, String value2) {
            addCriterion("org_type between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(String value1, String value2) {
            addCriterion("org_type not between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIsNull() {
            addCriterion("org_phone is null");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIsNotNull() {
            addCriterion("org_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneEqualTo(String value) {
            addCriterion("org_phone =", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotEqualTo(String value) {
            addCriterion("org_phone <>", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneGreaterThan(String value) {
            addCriterion("org_phone >", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("org_phone >=", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLessThan(String value) {
            addCriterion("org_phone <", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLessThanOrEqualTo(String value) {
            addCriterion("org_phone <=", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneLike(String value) {
            addCriterion("org_phone like", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotLike(String value) {
            addCriterion("org_phone not like", value, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneIn(List<String> values) {
            addCriterion("org_phone in", values, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotIn(List<String> values) {
            addCriterion("org_phone not in", values, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneBetween(String value1, String value2) {
            addCriterion("org_phone between", value1, value2, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgPhoneNotBetween(String value1, String value2) {
            addCriterion("org_phone not between", value1, value2, "orgPhone");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andDptIsNull() {
            addCriterion("dpt is null");
            return (Criteria) this;
        }

        public Criteria andDptIsNotNull() {
            addCriterion("dpt is not null");
            return (Criteria) this;
        }

        public Criteria andDptEqualTo(String value) {
            addCriterion("dpt =", value, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptNotEqualTo(String value) {
            addCriterion("dpt <>", value, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptGreaterThan(String value) {
            addCriterion("dpt >", value, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptGreaterThanOrEqualTo(String value) {
            addCriterion("dpt >=", value, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptLessThan(String value) {
            addCriterion("dpt <", value, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptLessThanOrEqualTo(String value) {
            addCriterion("dpt <=", value, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptLike(String value) {
            addCriterion("dpt like", value, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptNotLike(String value) {
            addCriterion("dpt not like", value, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptIn(List<String> values) {
            addCriterion("dpt in", values, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptNotIn(List<String> values) {
            addCriterion("dpt not in", values, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptBetween(String value1, String value2) {
            addCriterion("dpt between", value1, value2, "dpt");
            return (Criteria) this;
        }

        public Criteria andDptNotBetween(String value1, String value2) {
            addCriterion("dpt not between", value1, value2, "dpt");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNull() {
            addCriterion("industry is null");
            return (Criteria) this;
        }

        public Criteria andIndustryIsNotNull() {
            addCriterion("industry is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryEqualTo(String value) {
            addCriterion("industry =", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotEqualTo(String value) {
            addCriterion("industry <>", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThan(String value) {
            addCriterion("industry >", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("industry >=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThan(String value) {
            addCriterion("industry <", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLessThanOrEqualTo(String value) {
            addCriterion("industry <=", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryLike(String value) {
            addCriterion("industry like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotLike(String value) {
            addCriterion("industry not like", value, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryIn(List<String> values) {
            addCriterion("industry in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotIn(List<String> values) {
            addCriterion("industry not in", values, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryBetween(String value1, String value2) {
            addCriterion("industry between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andIndustryNotBetween(String value1, String value2) {
            addCriterion("industry not between", value1, value2, "industry");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNull() {
            addCriterion("work_time is null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIsNotNull() {
            addCriterion("work_time is not null");
            return (Criteria) this;
        }

        public Criteria andWorkTimeEqualTo(String value) {
            addCriterion("work_time =", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotEqualTo(String value) {
            addCriterion("work_time <>", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThan(String value) {
            addCriterion("work_time >", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeGreaterThanOrEqualTo(String value) {
            addCriterion("work_time >=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThan(String value) {
            addCriterion("work_time <", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLessThanOrEqualTo(String value) {
            addCriterion("work_time <=", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeLike(String value) {
            addCriterion("work_time like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotLike(String value) {
            addCriterion("work_time not like", value, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeIn(List<String> values) {
            addCriterion("work_time in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotIn(List<String> values) {
            addCriterion("work_time not in", values, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeBetween(String value1, String value2) {
            addCriterion("work_time between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andWorkTimeNotBetween(String value1, String value2) {
            addCriterion("work_time not between", value1, value2, "workTime");
            return (Criteria) this;
        }

        public Criteria andPrv2IsNull() {
            addCriterion("prv2 is null");
            return (Criteria) this;
        }

        public Criteria andPrv2IsNotNull() {
            addCriterion("prv2 is not null");
            return (Criteria) this;
        }

        public Criteria andPrv2EqualTo(String value) {
            addCriterion("prv2 =", value, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2NotEqualTo(String value) {
            addCriterion("prv2 <>", value, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2GreaterThan(String value) {
            addCriterion("prv2 >", value, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2GreaterThanOrEqualTo(String value) {
            addCriterion("prv2 >=", value, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2LessThan(String value) {
            addCriterion("prv2 <", value, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2LessThanOrEqualTo(String value) {
            addCriterion("prv2 <=", value, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2Like(String value) {
            addCriterion("prv2 like", value, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2NotLike(String value) {
            addCriterion("prv2 not like", value, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2In(List<String> values) {
            addCriterion("prv2 in", values, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2NotIn(List<String> values) {
            addCriterion("prv2 not in", values, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2Between(String value1, String value2) {
            addCriterion("prv2 between", value1, value2, "prv2");
            return (Criteria) this;
        }

        public Criteria andPrv2NotBetween(String value1, String value2) {
            addCriterion("prv2 not between", value1, value2, "prv2");
            return (Criteria) this;
        }

        public Criteria andCity2IsNull() {
            addCriterion("city2 is null");
            return (Criteria) this;
        }

        public Criteria andCity2IsNotNull() {
            addCriterion("city2 is not null");
            return (Criteria) this;
        }

        public Criteria andCity2EqualTo(String value) {
            addCriterion("city2 =", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2NotEqualTo(String value) {
            addCriterion("city2 <>", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2GreaterThan(String value) {
            addCriterion("city2 >", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2GreaterThanOrEqualTo(String value) {
            addCriterion("city2 >=", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2LessThan(String value) {
            addCriterion("city2 <", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2LessThanOrEqualTo(String value) {
            addCriterion("city2 <=", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2Like(String value) {
            addCriterion("city2 like", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2NotLike(String value) {
            addCriterion("city2 not like", value, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2In(List<String> values) {
            addCriterion("city2 in", values, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2NotIn(List<String> values) {
            addCriterion("city2 not in", values, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2Between(String value1, String value2) {
            addCriterion("city2 between", value1, value2, "city2");
            return (Criteria) this;
        }

        public Criteria andCity2NotBetween(String value1, String value2) {
            addCriterion("city2 not between", value1, value2, "city2");
            return (Criteria) this;
        }

        public Criteria andCounty2IsNull() {
            addCriterion("county2 is null");
            return (Criteria) this;
        }

        public Criteria andCounty2IsNotNull() {
            addCriterion("county2 is not null");
            return (Criteria) this;
        }

        public Criteria andCounty2EqualTo(String value) {
            addCriterion("county2 =", value, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2NotEqualTo(String value) {
            addCriterion("county2 <>", value, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2GreaterThan(String value) {
            addCriterion("county2 >", value, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2GreaterThanOrEqualTo(String value) {
            addCriterion("county2 >=", value, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2LessThan(String value) {
            addCriterion("county2 <", value, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2LessThanOrEqualTo(String value) {
            addCriterion("county2 <=", value, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2Like(String value) {
            addCriterion("county2 like", value, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2NotLike(String value) {
            addCriterion("county2 not like", value, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2In(List<String> values) {
            addCriterion("county2 in", values, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2NotIn(List<String> values) {
            addCriterion("county2 not in", values, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2Between(String value1, String value2) {
            addCriterion("county2 between", value1, value2, "county2");
            return (Criteria) this;
        }

        public Criteria andCounty2NotBetween(String value1, String value2) {
            addCriterion("county2 not between", value1, value2, "county2");
            return (Criteria) this;
        }

        public Criteria andTown2IsNull() {
            addCriterion("town2 is null");
            return (Criteria) this;
        }

        public Criteria andTown2IsNotNull() {
            addCriterion("town2 is not null");
            return (Criteria) this;
        }

        public Criteria andTown2EqualTo(String value) {
            addCriterion("town2 =", value, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2NotEqualTo(String value) {
            addCriterion("town2 <>", value, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2GreaterThan(String value) {
            addCriterion("town2 >", value, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2GreaterThanOrEqualTo(String value) {
            addCriterion("town2 >=", value, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2LessThan(String value) {
            addCriterion("town2 <", value, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2LessThanOrEqualTo(String value) {
            addCriterion("town2 <=", value, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2Like(String value) {
            addCriterion("town2 like", value, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2NotLike(String value) {
            addCriterion("town2 not like", value, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2In(List<String> values) {
            addCriterion("town2 in", values, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2NotIn(List<String> values) {
            addCriterion("town2 not in", values, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2Between(String value1, String value2) {
            addCriterion("town2 between", value1, value2, "town2");
            return (Criteria) this;
        }

        public Criteria andTown2NotBetween(String value1, String value2) {
            addCriterion("town2 not between", value1, value2, "town2");
            return (Criteria) this;
        }

        public Criteria andStr2IsNull() {
            addCriterion("str2 is null");
            return (Criteria) this;
        }

        public Criteria andStr2IsNotNull() {
            addCriterion("str2 is not null");
            return (Criteria) this;
        }

        public Criteria andStr2EqualTo(String value) {
            addCriterion("str2 =", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2NotEqualTo(String value) {
            addCriterion("str2 <>", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2GreaterThan(String value) {
            addCriterion("str2 >", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2GreaterThanOrEqualTo(String value) {
            addCriterion("str2 >=", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2LessThan(String value) {
            addCriterion("str2 <", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2LessThanOrEqualTo(String value) {
            addCriterion("str2 <=", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2Like(String value) {
            addCriterion("str2 like", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2NotLike(String value) {
            addCriterion("str2 not like", value, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2In(List<String> values) {
            addCriterion("str2 in", values, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2NotIn(List<String> values) {
            addCriterion("str2 not in", values, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2Between(String value1, String value2) {
            addCriterion("str2 between", value1, value2, "str2");
            return (Criteria) this;
        }

        public Criteria andStr2NotBetween(String value1, String value2) {
            addCriterion("str2 not between", value1, value2, "str2");
            return (Criteria) this;
        }

        public Criteria andStr3IsNull() {
            addCriterion("str3 is null");
            return (Criteria) this;
        }

        public Criteria andStr3IsNotNull() {
            addCriterion("str3 is not null");
            return (Criteria) this;
        }

        public Criteria andStr3EqualTo(String value) {
            addCriterion("str3 =", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3NotEqualTo(String value) {
            addCriterion("str3 <>", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3GreaterThan(String value) {
            addCriterion("str3 >", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3GreaterThanOrEqualTo(String value) {
            addCriterion("str3 >=", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3LessThan(String value) {
            addCriterion("str3 <", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3LessThanOrEqualTo(String value) {
            addCriterion("str3 <=", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3Like(String value) {
            addCriterion("str3 like", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3NotLike(String value) {
            addCriterion("str3 not like", value, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3In(List<String> values) {
            addCriterion("str3 in", values, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3NotIn(List<String> values) {
            addCriterion("str3 not in", values, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3Between(String value1, String value2) {
            addCriterion("str3 between", value1, value2, "str3");
            return (Criteria) this;
        }

        public Criteria andStr3NotBetween(String value1, String value2) {
            addCriterion("str3 not between", value1, value2, "str3");
            return (Criteria) this;
        }

        public Criteria andCmty2IsNull() {
            addCriterion("cmty2 is null");
            return (Criteria) this;
        }

        public Criteria andCmty2IsNotNull() {
            addCriterion("cmty2 is not null");
            return (Criteria) this;
        }

        public Criteria andCmty2EqualTo(String value) {
            addCriterion("cmty2 =", value, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2NotEqualTo(String value) {
            addCriterion("cmty2 <>", value, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2GreaterThan(String value) {
            addCriterion("cmty2 >", value, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2GreaterThanOrEqualTo(String value) {
            addCriterion("cmty2 >=", value, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2LessThan(String value) {
            addCriterion("cmty2 <", value, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2LessThanOrEqualTo(String value) {
            addCriterion("cmty2 <=", value, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2Like(String value) {
            addCriterion("cmty2 like", value, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2NotLike(String value) {
            addCriterion("cmty2 not like", value, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2In(List<String> values) {
            addCriterion("cmty2 in", values, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2NotIn(List<String> values) {
            addCriterion("cmty2 not in", values, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2Between(String value1, String value2) {
            addCriterion("cmty2 between", value1, value2, "cmty2");
            return (Criteria) this;
        }

        public Criteria andCmty2NotBetween(String value1, String value2) {
            addCriterion("cmty2 not between", value1, value2, "cmty2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2IsNull() {
            addCriterion("house_no2 is null");
            return (Criteria) this;
        }

        public Criteria andHouseNo2IsNotNull() {
            addCriterion("house_no2 is not null");
            return (Criteria) this;
        }

        public Criteria andHouseNo2EqualTo(String value) {
            addCriterion("house_no2 =", value, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2NotEqualTo(String value) {
            addCriterion("house_no2 <>", value, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2GreaterThan(String value) {
            addCriterion("house_no2 >", value, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2GreaterThanOrEqualTo(String value) {
            addCriterion("house_no2 >=", value, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2LessThan(String value) {
            addCriterion("house_no2 <", value, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2LessThanOrEqualTo(String value) {
            addCriterion("house_no2 <=", value, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2Like(String value) {
            addCriterion("house_no2 like", value, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2NotLike(String value) {
            addCriterion("house_no2 not like", value, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2In(List<String> values) {
            addCriterion("house_no2 in", values, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2NotIn(List<String> values) {
            addCriterion("house_no2 not in", values, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2Between(String value1, String value2) {
            addCriterion("house_no2 between", value1, value2, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andHouseNo2NotBetween(String value1, String value2) {
            addCriterion("house_no2 not between", value1, value2, "houseNo2");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(String value) {
            addCriterion("is_valid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(String value) {
            addCriterion("is_valid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(String value) {
            addCriterion("is_valid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(String value) {
            addCriterion("is_valid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(String value) {
            addCriterion("is_valid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(String value) {
            addCriterion("is_valid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLike(String value) {
            addCriterion("is_valid like", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotLike(String value) {
            addCriterion("is_valid not like", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<String> values) {
            addCriterion("is_valid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<String> values) {
            addCriterion("is_valid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(String value1, String value2) {
            addCriterion("is_valid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(String value1, String value2) {
            addCriterion("is_valid not between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andOrgContactIsNull() {
            addCriterion("org_contact is null");
            return (Criteria) this;
        }

        public Criteria andOrgContactIsNotNull() {
            addCriterion("org_contact is not null");
            return (Criteria) this;
        }

        public Criteria andOrgContactEqualTo(String value) {
            addCriterion("org_contact =", value, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactNotEqualTo(String value) {
            addCriterion("org_contact <>", value, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactGreaterThan(String value) {
            addCriterion("org_contact >", value, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactGreaterThanOrEqualTo(String value) {
            addCriterion("org_contact >=", value, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactLessThan(String value) {
            addCriterion("org_contact <", value, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactLessThanOrEqualTo(String value) {
            addCriterion("org_contact <=", value, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactLike(String value) {
            addCriterion("org_contact like", value, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactNotLike(String value) {
            addCriterion("org_contact not like", value, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactIn(List<String> values) {
            addCriterion("org_contact in", values, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactNotIn(List<String> values) {
            addCriterion("org_contact not in", values, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactBetween(String value1, String value2) {
            addCriterion("org_contact between", value1, value2, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactNotBetween(String value1, String value2) {
            addCriterion("org_contact not between", value1, value2, "orgContact");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileIsNull() {
            addCriterion("org_contact_mobile is null");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileIsNotNull() {
            addCriterion("org_contact_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileEqualTo(String value) {
            addCriterion("org_contact_mobile =", value, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileNotEqualTo(String value) {
            addCriterion("org_contact_mobile <>", value, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileGreaterThan(String value) {
            addCriterion("org_contact_mobile >", value, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileGreaterThanOrEqualTo(String value) {
            addCriterion("org_contact_mobile >=", value, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileLessThan(String value) {
            addCriterion("org_contact_mobile <", value, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileLessThanOrEqualTo(String value) {
            addCriterion("org_contact_mobile <=", value, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileLike(String value) {
            addCriterion("org_contact_mobile like", value, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileNotLike(String value) {
            addCriterion("org_contact_mobile not like", value, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileIn(List<String> values) {
            addCriterion("org_contact_mobile in", values, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileNotIn(List<String> values) {
            addCriterion("org_contact_mobile not in", values, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileBetween(String value1, String value2) {
            addCriterion("org_contact_mobile between", value1, value2, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andOrgContactMobileNotBetween(String value1, String value2) {
            addCriterion("org_contact_mobile not between", value1, value2, "orgContactMobile");
            return (Criteria) this;
        }

        public Criteria andEduTypeIsNull() {
            addCriterion("edu_type is null");
            return (Criteria) this;
        }

        public Criteria andEduTypeIsNotNull() {
            addCriterion("edu_type is not null");
            return (Criteria) this;
        }

        public Criteria andEduTypeEqualTo(String value) {
            addCriterion("edu_type =", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeNotEqualTo(String value) {
            addCriterion("edu_type <>", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeGreaterThan(String value) {
            addCriterion("edu_type >", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeGreaterThanOrEqualTo(String value) {
            addCriterion("edu_type >=", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeLessThan(String value) {
            addCriterion("edu_type <", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeLessThanOrEqualTo(String value) {
            addCriterion("edu_type <=", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeLike(String value) {
            addCriterion("edu_type like", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeNotLike(String value) {
            addCriterion("edu_type not like", value, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeIn(List<String> values) {
            addCriterion("edu_type in", values, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeNotIn(List<String> values) {
            addCriterion("edu_type not in", values, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeBetween(String value1, String value2) {
            addCriterion("edu_type between", value1, value2, "eduType");
            return (Criteria) this;
        }

        public Criteria andEduTypeNotBetween(String value1, String value2) {
            addCriterion("edu_type not between", value1, value2, "eduType");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionIsNull() {
            addCriterion("org_contact_position is null");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionIsNotNull() {
            addCriterion("org_contact_position is not null");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionEqualTo(String value) {
            addCriterion("org_contact_position =", value, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionNotEqualTo(String value) {
            addCriterion("org_contact_position <>", value, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionGreaterThan(String value) {
            addCriterion("org_contact_position >", value, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionGreaterThanOrEqualTo(String value) {
            addCriterion("org_contact_position >=", value, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionLessThan(String value) {
            addCriterion("org_contact_position <", value, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionLessThanOrEqualTo(String value) {
            addCriterion("org_contact_position <=", value, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionLike(String value) {
            addCriterion("org_contact_position like", value, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionNotLike(String value) {
            addCriterion("org_contact_position not like", value, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionIn(List<String> values) {
            addCriterion("org_contact_position in", values, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionNotIn(List<String> values) {
            addCriterion("org_contact_position not in", values, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionBetween(String value1, String value2) {
            addCriterion("org_contact_position between", value1, value2, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgContactPositionNotBetween(String value1, String value2) {
            addCriterion("org_contact_position not between", value1, value2, "orgContactPosition");
            return (Criteria) this;
        }

        public Criteria andOrgSizeIsNull() {
            addCriterion("org_size is null");
            return (Criteria) this;
        }

        public Criteria andOrgSizeIsNotNull() {
            addCriterion("org_size is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSizeEqualTo(String value) {
            addCriterion("org_size =", value, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeNotEqualTo(String value) {
            addCriterion("org_size <>", value, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeGreaterThan(String value) {
            addCriterion("org_size >", value, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeGreaterThanOrEqualTo(String value) {
            addCriterion("org_size >=", value, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeLessThan(String value) {
            addCriterion("org_size <", value, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeLessThanOrEqualTo(String value) {
            addCriterion("org_size <=", value, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeLike(String value) {
            addCriterion("org_size like", value, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeNotLike(String value) {
            addCriterion("org_size not like", value, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeIn(List<String> values) {
            addCriterion("org_size in", values, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeNotIn(List<String> values) {
            addCriterion("org_size not in", values, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeBetween(String value1, String value2) {
            addCriterion("org_size between", value1, value2, "orgSize");
            return (Criteria) this;
        }

        public Criteria andOrgSizeNotBetween(String value1, String value2) {
            addCriterion("org_size not between", value1, value2, "orgSize");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNull() {
            addCriterion("income is null");
            return (Criteria) this;
        }

        public Criteria andIncomeIsNotNull() {
            addCriterion("income is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeEqualTo(String value) {
            addCriterion("income =", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotEqualTo(String value) {
            addCriterion("income <>", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThan(String value) {
            addCriterion("income >", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("income >=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThan(String value) {
            addCriterion("income <", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLessThanOrEqualTo(String value) {
            addCriterion("income <=", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeLike(String value) {
            addCriterion("income like", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotLike(String value) {
            addCriterion("income not like", value, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeIn(List<String> values) {
            addCriterion("income in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotIn(List<String> values) {
            addCriterion("income not in", values, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeBetween(String value1, String value2) {
            addCriterion("income between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andIncomeNotBetween(String value1, String value2) {
            addCriterion("income not between", value1, value2, "income");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeIsNull() {
            addCriterion("fml_income is null");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeIsNotNull() {
            addCriterion("fml_income is not null");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeEqualTo(String value) {
            addCriterion("fml_income =", value, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeNotEqualTo(String value) {
            addCriterion("fml_income <>", value, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeGreaterThan(String value) {
            addCriterion("fml_income >", value, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("fml_income >=", value, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeLessThan(String value) {
            addCriterion("fml_income <", value, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeLessThanOrEqualTo(String value) {
            addCriterion("fml_income <=", value, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeLike(String value) {
            addCriterion("fml_income like", value, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeNotLike(String value) {
            addCriterion("fml_income not like", value, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeIn(List<String> values) {
            addCriterion("fml_income in", values, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeNotIn(List<String> values) {
            addCriterion("fml_income not in", values, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeBetween(String value1, String value2) {
            addCriterion("fml_income between", value1, value2, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andFmlIncomeNotBetween(String value1, String value2) {
            addCriterion("fml_income not between", value1, value2, "fmlIncome");
            return (Criteria) this;
        }

        public Criteria andEduLevelIsNull() {
            addCriterion("edu_level is null");
            return (Criteria) this;
        }

        public Criteria andEduLevelIsNotNull() {
            addCriterion("edu_level is not null");
            return (Criteria) this;
        }

        public Criteria andEduLevelEqualTo(String value) {
            addCriterion("edu_level =", value, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelNotEqualTo(String value) {
            addCriterion("edu_level <>", value, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelGreaterThan(String value) {
            addCriterion("edu_level >", value, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelGreaterThanOrEqualTo(String value) {
            addCriterion("edu_level >=", value, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelLessThan(String value) {
            addCriterion("edu_level <", value, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelLessThanOrEqualTo(String value) {
            addCriterion("edu_level <=", value, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelLike(String value) {
            addCriterion("edu_level like", value, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelNotLike(String value) {
            addCriterion("edu_level not like", value, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelIn(List<String> values) {
            addCriterion("edu_level in", values, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelNotIn(List<String> values) {
            addCriterion("edu_level not in", values, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelBetween(String value1, String value2) {
            addCriterion("edu_level between", value1, value2, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andEduLevelNotBetween(String value1, String value2) {
            addCriterion("edu_level not between", value1, value2, "eduLevel");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanIsNull() {
            addCriterion("is_past_loan is null");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanIsNotNull() {
            addCriterion("is_past_loan is not null");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanEqualTo(String value) {
            addCriterion("is_past_loan =", value, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanNotEqualTo(String value) {
            addCriterion("is_past_loan <>", value, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanGreaterThan(String value) {
            addCriterion("is_past_loan >", value, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanGreaterThanOrEqualTo(String value) {
            addCriterion("is_past_loan >=", value, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanLessThan(String value) {
            addCriterion("is_past_loan <", value, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanLessThanOrEqualTo(String value) {
            addCriterion("is_past_loan <=", value, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanLike(String value) {
            addCriterion("is_past_loan like", value, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanNotLike(String value) {
            addCriterion("is_past_loan not like", value, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanIn(List<String> values) {
            addCriterion("is_past_loan in", values, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanNotIn(List<String> values) {
            addCriterion("is_past_loan not in", values, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanBetween(String value1, String value2) {
            addCriterion("is_past_loan between", value1, value2, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andIsPastLoanNotBetween(String value1, String value2) {
            addCriterion("is_past_loan not between", value1, value2, "isPastLoan");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayIsNull() {
            addCriterion("past_loan_repay is null");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayIsNotNull() {
            addCriterion("past_loan_repay is not null");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayEqualTo(BigDecimal value) {
            addCriterion("past_loan_repay =", value, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayNotEqualTo(BigDecimal value) {
            addCriterion("past_loan_repay <>", value, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayGreaterThan(BigDecimal value) {
            addCriterion("past_loan_repay >", value, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("past_loan_repay >=", value, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayLessThan(BigDecimal value) {
            addCriterion("past_loan_repay <", value, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("past_loan_repay <=", value, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayIn(List<BigDecimal> values) {
            addCriterion("past_loan_repay in", values, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayNotIn(List<BigDecimal> values) {
            addCriterion("past_loan_repay not in", values, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("past_loan_repay between", value1, value2, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andPastLoanRepayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("past_loan_repay not between", value1, value2, "pastLoanRepay");
            return (Criteria) this;
        }

        public Criteria andIsValid3IsNull() {
            addCriterion("is_valid3 is null");
            return (Criteria) this;
        }

        public Criteria andIsValid3IsNotNull() {
            addCriterion("is_valid3 is not null");
            return (Criteria) this;
        }

        public Criteria andIsValid3EqualTo(String value) {
            addCriterion("is_valid3 =", value, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3NotEqualTo(String value) {
            addCriterion("is_valid3 <>", value, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3GreaterThan(String value) {
            addCriterion("is_valid3 >", value, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3GreaterThanOrEqualTo(String value) {
            addCriterion("is_valid3 >=", value, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3LessThan(String value) {
            addCriterion("is_valid3 <", value, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3LessThanOrEqualTo(String value) {
            addCriterion("is_valid3 <=", value, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3Like(String value) {
            addCriterion("is_valid3 like", value, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3NotLike(String value) {
            addCriterion("is_valid3 not like", value, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3In(List<String> values) {
            addCriterion("is_valid3 in", values, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3NotIn(List<String> values) {
            addCriterion("is_valid3 not in", values, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3Between(String value1, String value2) {
            addCriterion("is_valid3 between", value1, value2, "isValid3");
            return (Criteria) this;
        }

        public Criteria andIsValid3NotBetween(String value1, String value2) {
            addCriterion("is_valid3 not between", value1, value2, "isValid3");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterion("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterion("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterion("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterion("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterion("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterion("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterion("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("apply_date not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andAprovResultIsNull() {
            addCriterion("aprov_result is null");
            return (Criteria) this;
        }

        public Criteria andAprovResultIsNotNull() {
            addCriterion("aprov_result is not null");
            return (Criteria) this;
        }

        public Criteria andAprovResultEqualTo(String value) {
            addCriterion("aprov_result =", value, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultNotEqualTo(String value) {
            addCriterion("aprov_result <>", value, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultGreaterThan(String value) {
            addCriterion("aprov_result >", value, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultGreaterThanOrEqualTo(String value) {
            addCriterion("aprov_result >=", value, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultLessThan(String value) {
            addCriterion("aprov_result <", value, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultLessThanOrEqualTo(String value) {
            addCriterion("aprov_result <=", value, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultLike(String value) {
            addCriterion("aprov_result like", value, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultNotLike(String value) {
            addCriterion("aprov_result not like", value, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultIn(List<String> values) {
            addCriterion("aprov_result in", values, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultNotIn(List<String> values) {
            addCriterion("aprov_result not in", values, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultBetween(String value1, String value2) {
            addCriterion("aprov_result between", value1, value2, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovResultNotBetween(String value1, String value2) {
            addCriterion("aprov_result not between", value1, value2, "aprovResult");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkIsNull() {
            addCriterion("aprov_remark is null");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkIsNotNull() {
            addCriterion("aprov_remark is not null");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkEqualTo(String value) {
            addCriterion("aprov_remark =", value, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkNotEqualTo(String value) {
            addCriterion("aprov_remark <>", value, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkGreaterThan(String value) {
            addCriterion("aprov_remark >", value, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("aprov_remark >=", value, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkLessThan(String value) {
            addCriterion("aprov_remark <", value, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkLessThanOrEqualTo(String value) {
            addCriterion("aprov_remark <=", value, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkLike(String value) {
            addCriterion("aprov_remark like", value, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkNotLike(String value) {
            addCriterion("aprov_remark not like", value, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkIn(List<String> values) {
            addCriterion("aprov_remark in", values, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkNotIn(List<String> values) {
            addCriterion("aprov_remark not in", values, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkBetween(String value1, String value2) {
            addCriterion("aprov_remark between", value1, value2, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andAprovRemarkNotBetween(String value1, String value2) {
            addCriterion("aprov_remark not between", value1, value2, "aprovRemark");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andAprovReasonIsNull() {
            addCriterion("aprov_reason is null");
            return (Criteria) this;
        }

        public Criteria andAprovReasonIsNotNull() {
            addCriterion("aprov_reason is not null");
            return (Criteria) this;
        }

        public Criteria andAprovReasonEqualTo(String value) {
            addCriterion("aprov_reason =", value, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonNotEqualTo(String value) {
            addCriterion("aprov_reason <>", value, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonGreaterThan(String value) {
            addCriterion("aprov_reason >", value, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonGreaterThanOrEqualTo(String value) {
            addCriterion("aprov_reason >=", value, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonLessThan(String value) {
            addCriterion("aprov_reason <", value, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonLessThanOrEqualTo(String value) {
            addCriterion("aprov_reason <=", value, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonLike(String value) {
            addCriterion("aprov_reason like", value, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonNotLike(String value) {
            addCriterion("aprov_reason not like", value, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonIn(List<String> values) {
            addCriterion("aprov_reason in", values, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonNotIn(List<String> values) {
            addCriterion("aprov_reason not in", values, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonBetween(String value1, String value2) {
            addCriterion("aprov_reason between", value1, value2, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andAprovReasonNotBetween(String value1, String value2) {
            addCriterion("aprov_reason not between", value1, value2, "aprovReason");
            return (Criteria) this;
        }

        public Criteria andRegistDateIsNull() {
            addCriterion("regist_date is null");
            return (Criteria) this;
        }

        public Criteria andRegistDateIsNotNull() {
            addCriterion("regist_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegistDateEqualTo(Date value) {
            addCriterion("regist_date =", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotEqualTo(Date value) {
            addCriterion("regist_date <>", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateGreaterThan(Date value) {
            addCriterion("regist_date >", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateGreaterThanOrEqualTo(Date value) {
            addCriterion("regist_date >=", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateLessThan(Date value) {
            addCriterion("regist_date <", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateLessThanOrEqualTo(Date value) {
            addCriterion("regist_date <=", value, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateIn(List<Date> values) {
            addCriterion("regist_date in", values, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotIn(List<Date> values) {
            addCriterion("regist_date not in", values, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateBetween(Date value1, Date value2) {
            addCriterion("regist_date between", value1, value2, "registDate");
            return (Criteria) this;
        }

        public Criteria andRegistDateNotBetween(Date value1, Date value2) {
            addCriterion("regist_date not between", value1, value2, "registDate");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleIsNull() {
            addCriterion("is_back_sale is null");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleIsNotNull() {
            addCriterion("is_back_sale is not null");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleEqualTo(String value) {
            addCriterion("is_back_sale =", value, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleNotEqualTo(String value) {
            addCriterion("is_back_sale <>", value, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleGreaterThan(String value) {
            addCriterion("is_back_sale >", value, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleGreaterThanOrEqualTo(String value) {
            addCriterion("is_back_sale >=", value, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleLessThan(String value) {
            addCriterion("is_back_sale <", value, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleLessThanOrEqualTo(String value) {
            addCriterion("is_back_sale <=", value, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleLike(String value) {
            addCriterion("is_back_sale like", value, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleNotLike(String value) {
            addCriterion("is_back_sale not like", value, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleIn(List<String> values) {
            addCriterion("is_back_sale in", values, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleNotIn(List<String> values) {
            addCriterion("is_back_sale not in", values, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleBetween(String value1, String value2) {
            addCriterion("is_back_sale between", value1, value2, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackSaleNotBetween(String value1, String value2) {
            addCriterion("is_back_sale not between", value1, value2, "isBackSale");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckIsNull() {
            addCriterion("is_back_check is null");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckIsNotNull() {
            addCriterion("is_back_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckEqualTo(String value) {
            addCriterion("is_back_check =", value, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckNotEqualTo(String value) {
            addCriterion("is_back_check <>", value, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckGreaterThan(String value) {
            addCriterion("is_back_check >", value, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckGreaterThanOrEqualTo(String value) {
            addCriterion("is_back_check >=", value, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckLessThan(String value) {
            addCriterion("is_back_check <", value, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckLessThanOrEqualTo(String value) {
            addCriterion("is_back_check <=", value, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckLike(String value) {
            addCriterion("is_back_check like", value, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckNotLike(String value) {
            addCriterion("is_back_check not like", value, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckIn(List<String> values) {
            addCriterion("is_back_check in", values, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckNotIn(List<String> values) {
            addCriterion("is_back_check not in", values, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckBetween(String value1, String value2) {
            addCriterion("is_back_check between", value1, value2, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andIsBackCheckNotBetween(String value1, String value2) {
            addCriterion("is_back_check not between", value1, value2, "isBackCheck");
            return (Criteria) this;
        }

        public Criteria andBussNoIsNull() {
            addCriterion("buss_no is null");
            return (Criteria) this;
        }

        public Criteria andBussNoIsNotNull() {
            addCriterion("buss_no is not null");
            return (Criteria) this;
        }

        public Criteria andBussNoEqualTo(String value) {
            addCriterion("buss_no =", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoNotEqualTo(String value) {
            addCriterion("buss_no <>", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoGreaterThan(String value) {
            addCriterion("buss_no >", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoGreaterThanOrEqualTo(String value) {
            addCriterion("buss_no >=", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoLessThan(String value) {
            addCriterion("buss_no <", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoLessThanOrEqualTo(String value) {
            addCriterion("buss_no <=", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoLike(String value) {
            addCriterion("buss_no like", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoNotLike(String value) {
            addCriterion("buss_no not like", value, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoIn(List<String> values) {
            addCriterion("buss_no in", values, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoNotIn(List<String> values) {
            addCriterion("buss_no not in", values, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoBetween(String value1, String value2) {
            addCriterion("buss_no between", value1, value2, "bussNo");
            return (Criteria) this;
        }

        public Criteria andBussNoNotBetween(String value1, String value2) {
            addCriterion("buss_no not between", value1, value2, "bussNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoIsNull() {
            addCriterion("store_no is null");
            return (Criteria) this;
        }

        public Criteria andStoreNoIsNotNull() {
            addCriterion("store_no is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNoEqualTo(String value) {
            addCriterion("store_no =", value, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoNotEqualTo(String value) {
            addCriterion("store_no <>", value, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoGreaterThan(String value) {
            addCriterion("store_no >", value, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoGreaterThanOrEqualTo(String value) {
            addCriterion("store_no >=", value, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoLessThan(String value) {
            addCriterion("store_no <", value, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoLessThanOrEqualTo(String value) {
            addCriterion("store_no <=", value, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoLike(String value) {
            addCriterion("store_no like", value, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoNotLike(String value) {
            addCriterion("store_no not like", value, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoIn(List<String> values) {
            addCriterion("store_no in", values, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoNotIn(List<String> values) {
            addCriterion("store_no not in", values, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoBetween(String value1, String value2) {
            addCriterion("store_no between", value1, value2, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreNoNotBetween(String value1, String value2) {
            addCriterion("store_no not between", value1, value2, "storeNo");
            return (Criteria) this;
        }

        public Criteria andStoreProvIsNull() {
            addCriterion("store_prov is null");
            return (Criteria) this;
        }

        public Criteria andStoreProvIsNotNull() {
            addCriterion("store_prov is not null");
            return (Criteria) this;
        }

        public Criteria andStoreProvEqualTo(String value) {
            addCriterion("store_prov =", value, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvNotEqualTo(String value) {
            addCriterion("store_prov <>", value, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvGreaterThan(String value) {
            addCriterion("store_prov >", value, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvGreaterThanOrEqualTo(String value) {
            addCriterion("store_prov >=", value, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvLessThan(String value) {
            addCriterion("store_prov <", value, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvLessThanOrEqualTo(String value) {
            addCriterion("store_prov <=", value, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvLike(String value) {
            addCriterion("store_prov like", value, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvNotLike(String value) {
            addCriterion("store_prov not like", value, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvIn(List<String> values) {
            addCriterion("store_prov in", values, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvNotIn(List<String> values) {
            addCriterion("store_prov not in", values, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvBetween(String value1, String value2) {
            addCriterion("store_prov between", value1, value2, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreProvNotBetween(String value1, String value2) {
            addCriterion("store_prov not between", value1, value2, "storeProv");
            return (Criteria) this;
        }

        public Criteria andStoreCityIsNull() {
            addCriterion("store_city is null");
            return (Criteria) this;
        }

        public Criteria andStoreCityIsNotNull() {
            addCriterion("store_city is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCityEqualTo(String value) {
            addCriterion("store_city =", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotEqualTo(String value) {
            addCriterion("store_city <>", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityGreaterThan(String value) {
            addCriterion("store_city >", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityGreaterThanOrEqualTo(String value) {
            addCriterion("store_city >=", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLessThan(String value) {
            addCriterion("store_city <", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLessThanOrEqualTo(String value) {
            addCriterion("store_city <=", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityLike(String value) {
            addCriterion("store_city like", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotLike(String value) {
            addCriterion("store_city not like", value, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityIn(List<String> values) {
            addCriterion("store_city in", values, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotIn(List<String> values) {
            addCriterion("store_city not in", values, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityBetween(String value1, String value2) {
            addCriterion("store_city between", value1, value2, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreCityNotBetween(String value1, String value2) {
            addCriterion("store_city not between", value1, value2, "storeCity");
            return (Criteria) this;
        }

        public Criteria andStoreAreaIsNull() {
            addCriterion("store_area is null");
            return (Criteria) this;
        }

        public Criteria andStoreAreaIsNotNull() {
            addCriterion("store_area is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAreaEqualTo(String value) {
            addCriterion("store_area =", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaNotEqualTo(String value) {
            addCriterion("store_area <>", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaGreaterThan(String value) {
            addCriterion("store_area >", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaGreaterThanOrEqualTo(String value) {
            addCriterion("store_area >=", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaLessThan(String value) {
            addCriterion("store_area <", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaLessThanOrEqualTo(String value) {
            addCriterion("store_area <=", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaLike(String value) {
            addCriterion("store_area like", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaNotLike(String value) {
            addCriterion("store_area not like", value, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaIn(List<String> values) {
            addCriterion("store_area in", values, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaNotIn(List<String> values) {
            addCriterion("store_area not in", values, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaBetween(String value1, String value2) {
            addCriterion("store_area between", value1, value2, "storeArea");
            return (Criteria) this;
        }

        public Criteria andStoreAreaNotBetween(String value1, String value2) {
            addCriterion("store_area not between", value1, value2, "storeArea");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNull() {
            addCriterion("goods_type is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIsNotNull() {
            addCriterion("goods_type is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeEqualTo(String value) {
            addCriterion("goods_type =", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotEqualTo(String value) {
            addCriterion("goods_type <>", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThan(String value) {
            addCriterion("goods_type >", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("goods_type >=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThan(String value) {
            addCriterion("goods_type <", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLessThanOrEqualTo(String value) {
            addCriterion("goods_type <=", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeLike(String value) {
            addCriterion("goods_type like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotLike(String value) {
            addCriterion("goods_type not like", value, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeIn(List<String> values) {
            addCriterion("goods_type in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotIn(List<String> values) {
            addCriterion("goods_type not in", values, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeBetween(String value1, String value2) {
            addCriterion("goods_type between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andGoodsTypeNotBetween(String value1, String value2) {
            addCriterion("goods_type not between", value1, value2, "goodsType");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andMarquesIsNull() {
            addCriterion("marques is null");
            return (Criteria) this;
        }

        public Criteria andMarquesIsNotNull() {
            addCriterion("marques is not null");
            return (Criteria) this;
        }

        public Criteria andMarquesEqualTo(String value) {
            addCriterion("marques =", value, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesNotEqualTo(String value) {
            addCriterion("marques <>", value, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesGreaterThan(String value) {
            addCriterion("marques >", value, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesGreaterThanOrEqualTo(String value) {
            addCriterion("marques >=", value, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesLessThan(String value) {
            addCriterion("marques <", value, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesLessThanOrEqualTo(String value) {
            addCriterion("marques <=", value, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesLike(String value) {
            addCriterion("marques like", value, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesNotLike(String value) {
            addCriterion("marques not like", value, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesIn(List<String> values) {
            addCriterion("marques in", values, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesNotIn(List<String> values) {
            addCriterion("marques not in", values, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesBetween(String value1, String value2) {
            addCriterion("marques between", value1, value2, "marques");
            return (Criteria) this;
        }

        public Criteria andMarquesNotBetween(String value1, String value2) {
            addCriterion("marques not between", value1, value2, "marques");
            return (Criteria) this;
        }

        public Criteria andAprovDurationIsNull() {
            addCriterion("aprov_duration is null");
            return (Criteria) this;
        }

        public Criteria andAprovDurationIsNotNull() {
            addCriterion("aprov_duration is not null");
            return (Criteria) this;
        }

        public Criteria andAprovDurationEqualTo(String value) {
            addCriterion("aprov_duration =", value, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationNotEqualTo(String value) {
            addCriterion("aprov_duration <>", value, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationGreaterThan(String value) {
            addCriterion("aprov_duration >", value, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationGreaterThanOrEqualTo(String value) {
            addCriterion("aprov_duration >=", value, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationLessThan(String value) {
            addCriterion("aprov_duration <", value, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationLessThanOrEqualTo(String value) {
            addCriterion("aprov_duration <=", value, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationLike(String value) {
            addCriterion("aprov_duration like", value, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationNotLike(String value) {
            addCriterion("aprov_duration not like", value, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationIn(List<String> values) {
            addCriterion("aprov_duration in", values, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationNotIn(List<String> values) {
            addCriterion("aprov_duration not in", values, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationBetween(String value1, String value2) {
            addCriterion("aprov_duration between", value1, value2, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andAprovDurationNotBetween(String value1, String value2) {
            addCriterion("aprov_duration not between", value1, value2, "aprovDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationIsNull() {
            addCriterion("check_duration is null");
            return (Criteria) this;
        }

        public Criteria andCheckDurationIsNotNull() {
            addCriterion("check_duration is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDurationEqualTo(String value) {
            addCriterion("check_duration =", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationNotEqualTo(String value) {
            addCriterion("check_duration <>", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationGreaterThan(String value) {
            addCriterion("check_duration >", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationGreaterThanOrEqualTo(String value) {
            addCriterion("check_duration >=", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationLessThan(String value) {
            addCriterion("check_duration <", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationLessThanOrEqualTo(String value) {
            addCriterion("check_duration <=", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationLike(String value) {
            addCriterion("check_duration like", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationNotLike(String value) {
            addCriterion("check_duration not like", value, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationIn(List<String> values) {
            addCriterion("check_duration in", values, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationNotIn(List<String> values) {
            addCriterion("check_duration not in", values, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationBetween(String value1, String value2) {
            addCriterion("check_duration between", value1, value2, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andCheckDurationNotBetween(String value1, String value2) {
            addCriterion("check_duration not between", value1, value2, "checkDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationIsNull() {
            addCriterion("re_check_duration is null");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationIsNotNull() {
            addCriterion("re_check_duration is not null");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationEqualTo(String value) {
            addCriterion("re_check_duration =", value, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationNotEqualTo(String value) {
            addCriterion("re_check_duration <>", value, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationGreaterThan(String value) {
            addCriterion("re_check_duration >", value, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationGreaterThanOrEqualTo(String value) {
            addCriterion("re_check_duration >=", value, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationLessThan(String value) {
            addCriterion("re_check_duration <", value, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationLessThanOrEqualTo(String value) {
            addCriterion("re_check_duration <=", value, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationLike(String value) {
            addCriterion("re_check_duration like", value, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationNotLike(String value) {
            addCriterion("re_check_duration not like", value, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationIn(List<String> values) {
            addCriterion("re_check_duration in", values, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationNotIn(List<String> values) {
            addCriterion("re_check_duration not in", values, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationBetween(String value1, String value2) {
            addCriterion("re_check_duration between", value1, value2, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andReCheckDurationNotBetween(String value1, String value2) {
            addCriterion("re_check_duration not between", value1, value2, "reCheckDuration");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkIsNull() {
            addCriterion("sale_remark is null");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkIsNotNull() {
            addCriterion("sale_remark is not null");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkEqualTo(String value) {
            addCriterion("sale_remark =", value, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkNotEqualTo(String value) {
            addCriterion("sale_remark <>", value, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkGreaterThan(String value) {
            addCriterion("sale_remark >", value, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("sale_remark >=", value, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkLessThan(String value) {
            addCriterion("sale_remark <", value, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkLessThanOrEqualTo(String value) {
            addCriterion("sale_remark <=", value, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkLike(String value) {
            addCriterion("sale_remark like", value, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkNotLike(String value) {
            addCriterion("sale_remark not like", value, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkIn(List<String> values) {
            addCriterion("sale_remark in", values, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkNotIn(List<String> values) {
            addCriterion("sale_remark not in", values, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkBetween(String value1, String value2) {
            addCriterion("sale_remark between", value1, value2, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andSaleRemarkNotBetween(String value1, String value2) {
            addCriterion("sale_remark not between", value1, value2, "saleRemark");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNull() {
            addCriterion("sign_date is null");
            return (Criteria) this;
        }

        public Criteria andSignDateIsNotNull() {
            addCriterion("sign_date is not null");
            return (Criteria) this;
        }

        public Criteria andSignDateEqualTo(Date value) {
            addCriterion("sign_date =", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotEqualTo(Date value) {
            addCriterion("sign_date <>", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThan(Date value) {
            addCriterion("sign_date >", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateGreaterThanOrEqualTo(Date value) {
            addCriterion("sign_date >=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThan(Date value) {
            addCriterion("sign_date <", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateLessThanOrEqualTo(Date value) {
            addCriterion("sign_date <=", value, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateIn(List<Date> values) {
            addCriterion("sign_date in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotIn(List<Date> values) {
            addCriterion("sign_date not in", values, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateBetween(Date value1, Date value2) {
            addCriterion("sign_date between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andSignDateNotBetween(Date value1, Date value2) {
            addCriterion("sign_date not between", value1, value2, "signDate");
            return (Criteria) this;
        }

        public Criteria andWeichatIsNull() {
            addCriterion("weichat is null");
            return (Criteria) this;
        }

        public Criteria andWeichatIsNotNull() {
            addCriterion("weichat is not null");
            return (Criteria) this;
        }

        public Criteria andWeichatEqualTo(String value) {
            addCriterion("weichat =", value, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatNotEqualTo(String value) {
            addCriterion("weichat <>", value, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatGreaterThan(String value) {
            addCriterion("weichat >", value, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatGreaterThanOrEqualTo(String value) {
            addCriterion("weichat >=", value, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatLessThan(String value) {
            addCriterion("weichat <", value, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatLessThanOrEqualTo(String value) {
            addCriterion("weichat <=", value, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatLike(String value) {
            addCriterion("weichat like", value, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatNotLike(String value) {
            addCriterion("weichat not like", value, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatIn(List<String> values) {
            addCriterion("weichat in", values, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatNotIn(List<String> values) {
            addCriterion("weichat not in", values, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatBetween(String value1, String value2) {
            addCriterion("weichat between", value1, value2, "weichat");
            return (Criteria) this;
        }

        public Criteria andWeichatNotBetween(String value1, String value2) {
            addCriterion("weichat not between", value1, value2, "weichat");
            return (Criteria) this;
        }
    }

    /**
     * nj_puhui_apply
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_puhui_apply 2018-04-27
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}