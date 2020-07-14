package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NjDeductionNoticeExample {
    /**
     * nj_deduction_notice
     */
    protected String orderByClause;

    /**
     * nj_deduction_notice
     */
    protected boolean distinct;

    /**
     * nj_deduction_notice
     */
    protected List<Criteria> oredCriteria;

    public NjDeductionNoticeExample() {
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
     * nj_deduction_notice 2019-03-01
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (Criteria) this;
        }

        public Criteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoIsNull() {
            addCriterion("source_order_no is null");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoIsNotNull() {
            addCriterion("source_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoEqualTo(String value) {
            addCriterion("source_order_no =", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoNotEqualTo(String value) {
            addCriterion("source_order_no <>", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoGreaterThan(String value) {
            addCriterion("source_order_no >", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("source_order_no >=", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoLessThan(String value) {
            addCriterion("source_order_no <", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoLessThanOrEqualTo(String value) {
            addCriterion("source_order_no <=", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoLike(String value) {
            addCriterion("source_order_no like", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoNotLike(String value) {
            addCriterion("source_order_no not like", value, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoIn(List<String> values) {
            addCriterion("source_order_no in", values, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoNotIn(List<String> values) {
            addCriterion("source_order_no not in", values, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoBetween(String value1, String value2) {
            addCriterion("source_order_no between", value1, value2, "sourceOrderNo");
            return (Criteria) this;
        }

        public Criteria andSourceOrderNoNotBetween(String value1, String value2) {
            addCriterion("source_order_no not between", value1, value2, "sourceOrderNo");
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

        public Criteria andPlanRepayDateIsNull() {
            addCriterion("plan_repay_date is null");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateIsNotNull() {
            addCriterion("plan_repay_date is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateEqualTo(Date value) {
            addCriterionForJDBCDate("plan_repay_date =", value, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("plan_repay_date <>", value, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateGreaterThan(Date value) {
            addCriterionForJDBCDate("plan_repay_date >", value, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_repay_date >=", value, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateLessThan(Date value) {
            addCriterionForJDBCDate("plan_repay_date <", value, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("plan_repay_date <=", value, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateIn(List<Date> values) {
            addCriterionForJDBCDate("plan_repay_date in", values, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("plan_repay_date not in", values, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_repay_date between", value1, value2, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("plan_repay_date not between", value1, value2, "planRepayDate");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtIsNull() {
            addCriterion("plan_repay_total_amt is null");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtIsNotNull() {
            addCriterion("plan_repay_total_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtEqualTo(BigDecimal value) {
            addCriterion("plan_repay_total_amt =", value, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtNotEqualTo(BigDecimal value) {
            addCriterion("plan_repay_total_amt <>", value, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtGreaterThan(BigDecimal value) {
            addCriterion("plan_repay_total_amt >", value, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_repay_total_amt >=", value, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtLessThan(BigDecimal value) {
            addCriterion("plan_repay_total_amt <", value, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("plan_repay_total_amt <=", value, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtIn(List<BigDecimal> values) {
            addCriterion("plan_repay_total_amt in", values, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtNotIn(List<BigDecimal> values) {
            addCriterion("plan_repay_total_amt not in", values, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_repay_total_amt between", value1, value2, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andPlanRepayTotalAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("plan_repay_total_amt not between", value1, value2, "planRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtIsNull() {
            addCriterion("acc_repay_total_amt is null");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtIsNotNull() {
            addCriterion("acc_repay_total_amt is not null");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtEqualTo(BigDecimal value) {
            addCriterion("acc_repay_total_amt =", value, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtNotEqualTo(BigDecimal value) {
            addCriterion("acc_repay_total_amt <>", value, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtGreaterThan(BigDecimal value) {
            addCriterion("acc_repay_total_amt >", value, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("acc_repay_total_amt >=", value, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtLessThan(BigDecimal value) {
            addCriterion("acc_repay_total_amt <", value, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("acc_repay_total_amt <=", value, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtIn(List<BigDecimal> values) {
            addCriterion("acc_repay_total_amt in", values, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtNotIn(List<BigDecimal> values) {
            addCriterion("acc_repay_total_amt not in", values, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("acc_repay_total_amt between", value1, value2, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andAccRepayTotalAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("acc_repay_total_amt not between", value1, value2, "accRepayTotalAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionDateIsNull() {
            addCriterion("deduction_date is null");
            return (Criteria) this;
        }

        public Criteria andDeductionDateIsNotNull() {
            addCriterion("deduction_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionDateEqualTo(Date value) {
            addCriterion("deduction_date =", value, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateNotEqualTo(Date value) {
            addCriterion("deduction_date <>", value, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateGreaterThan(Date value) {
            addCriterion("deduction_date >", value, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateGreaterThanOrEqualTo(Date value) {
            addCriterion("deduction_date >=", value, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateLessThan(Date value) {
            addCriterion("deduction_date <", value, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateLessThanOrEqualTo(Date value) {
            addCriterion("deduction_date <=", value, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateIn(List<Date> values) {
            addCriterion("deduction_date in", values, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateNotIn(List<Date> values) {
            addCriterion("deduction_date not in", values, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateBetween(Date value1, Date value2) {
            addCriterion("deduction_date between", value1, value2, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andDeductionDateNotBetween(Date value1, Date value2) {
            addCriterion("deduction_date not between", value1, value2, "deductionDate");
            return (Criteria) this;
        }

        public Criteria andIsNoticeIsNull() {
            addCriterion("is_notice is null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeIsNotNull() {
            addCriterion("is_notice is not null");
            return (Criteria) this;
        }

        public Criteria andIsNoticeEqualTo(Boolean value) {
            addCriterion("is_notice =", value, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeNotEqualTo(Boolean value) {
            addCriterion("is_notice <>", value, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeGreaterThan(Boolean value) {
            addCriterion("is_notice >", value, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_notice >=", value, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeLessThan(Boolean value) {
            addCriterion("is_notice <", value, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_notice <=", value, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeIn(List<Boolean> values) {
            addCriterion("is_notice in", values, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeNotIn(List<Boolean> values) {
            addCriterion("is_notice not in", values, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_notice between", value1, value2, "isNotice");
            return (Criteria) this;
        }

        public Criteria andIsNoticeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_notice not between", value1, value2, "isNotice");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusIsNull() {
            addCriterion("diduction_status is null");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusIsNotNull() {
            addCriterion("diduction_status is not null");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusEqualTo(Byte value) {
            addCriterion("diduction_status =", value, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusNotEqualTo(Byte value) {
            addCriterion("diduction_status <>", value, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusGreaterThan(Byte value) {
            addCriterion("diduction_status >", value, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("diduction_status >=", value, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusLessThan(Byte value) {
            addCriterion("diduction_status <", value, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusLessThanOrEqualTo(Byte value) {
            addCriterion("diduction_status <=", value, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusIn(List<Byte> values) {
            addCriterion("diduction_status in", values, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusNotIn(List<Byte> values) {
            addCriterion("diduction_status not in", values, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusBetween(Byte value1, Byte value2) {
            addCriterion("diduction_status between", value1, value2, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andDiductionStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("diduction_status not between", value1, value2, "diductionStatus");
            return (Criteria) this;
        }

        public Criteria andFailReasionIsNull() {
            addCriterion("fail_reasion is null");
            return (Criteria) this;
        }

        public Criteria andFailReasionIsNotNull() {
            addCriterion("fail_reasion is not null");
            return (Criteria) this;
        }

        public Criteria andFailReasionEqualTo(String value) {
            addCriterion("fail_reasion =", value, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionNotEqualTo(String value) {
            addCriterion("fail_reasion <>", value, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionGreaterThan(String value) {
            addCriterion("fail_reasion >", value, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionGreaterThanOrEqualTo(String value) {
            addCriterion("fail_reasion >=", value, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionLessThan(String value) {
            addCriterion("fail_reasion <", value, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionLessThanOrEqualTo(String value) {
            addCriterion("fail_reasion <=", value, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionLike(String value) {
            addCriterion("fail_reasion like", value, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionNotLike(String value) {
            addCriterion("fail_reasion not like", value, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionIn(List<String> values) {
            addCriterion("fail_reasion in", values, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionNotIn(List<String> values) {
            addCriterion("fail_reasion not in", values, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionBetween(String value1, String value2) {
            addCriterion("fail_reasion between", value1, value2, "failReasion");
            return (Criteria) this;
        }

        public Criteria andFailReasionNotBetween(String value1, String value2) {
            addCriterion("fail_reasion not between", value1, value2, "failReasion");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andTrueNameIsNull() {
            addCriterion("true_name is null");
            return (Criteria) this;
        }

        public Criteria andTrueNameIsNotNull() {
            addCriterion("true_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrueNameEqualTo(String value) {
            addCriterion("true_name =", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotEqualTo(String value) {
            addCriterion("true_name <>", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameGreaterThan(String value) {
            addCriterion("true_name >", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameGreaterThanOrEqualTo(String value) {
            addCriterion("true_name >=", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLessThan(String value) {
            addCriterion("true_name <", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLessThanOrEqualTo(String value) {
            addCriterion("true_name <=", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameLike(String value) {
            addCriterion("true_name like", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotLike(String value) {
            addCriterion("true_name not like", value, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameIn(List<String> values) {
            addCriterion("true_name in", values, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotIn(List<String> values) {
            addCriterion("true_name not in", values, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameBetween(String value1, String value2) {
            addCriterion("true_name between", value1, value2, "trueName");
            return (Criteria) this;
        }

        public Criteria andTrueNameNotBetween(String value1, String value2) {
            addCriterion("true_name not between", value1, value2, "trueName");
            return (Criteria) this;
        }

        public Criteria andBankNumIsNull() {
            addCriterion("bank_num is null");
            return (Criteria) this;
        }

        public Criteria andBankNumIsNotNull() {
            addCriterion("bank_num is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumEqualTo(String value) {
            addCriterion("bank_num =", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotEqualTo(String value) {
            addCriterion("bank_num <>", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumGreaterThan(String value) {
            addCriterion("bank_num >", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumGreaterThanOrEqualTo(String value) {
            addCriterion("bank_num >=", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLessThan(String value) {
            addCriterion("bank_num <", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLessThanOrEqualTo(String value) {
            addCriterion("bank_num <=", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumLike(String value) {
            addCriterion("bank_num like", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotLike(String value) {
            addCriterion("bank_num not like", value, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumIn(List<String> values) {
            addCriterion("bank_num in", values, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotIn(List<String> values) {
            addCriterion("bank_num not in", values, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumBetween(String value1, String value2) {
            addCriterion("bank_num between", value1, value2, "bankNum");
            return (Criteria) this;
        }

        public Criteria andBankNumNotBetween(String value1, String value2) {
            addCriterion("bank_num not between", value1, value2, "bankNum");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtIsNull() {
            addCriterion("deduction_amt is null");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtIsNotNull() {
            addCriterion("deduction_amt is not null");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtEqualTo(BigDecimal value) {
            addCriterion("deduction_amt =", value, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtNotEqualTo(BigDecimal value) {
            addCriterion("deduction_amt <>", value, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtGreaterThan(BigDecimal value) {
            addCriterion("deduction_amt >", value, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction_amt >=", value, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtLessThan(BigDecimal value) {
            addCriterion("deduction_amt <", value, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction_amt <=", value, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtIn(List<BigDecimal> values) {
            addCriterion("deduction_amt in", values, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtNotIn(List<BigDecimal> values) {
            addCriterion("deduction_amt not in", values, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction_amt between", value1, value2, "deductionAmt");
            return (Criteria) this;
        }

        public Criteria andDeductionAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("deduction_amt not between", value1, value2, "deductionAmt");
            return (Criteria) this;
        }
    }

    /**
     * nj_deduction_notice
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_deduction_notice 2019-03-01
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