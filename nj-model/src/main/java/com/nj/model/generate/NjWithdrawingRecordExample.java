package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjWithdrawingRecordExample {
    /**
     * nj_withdrawing_record
     */
    protected String orderByClause;

    /**
     * nj_withdrawing_record
     */
    protected boolean distinct;

    /**
     * nj_withdrawing_record
     */
    protected List<Criteria> oredCriteria;

    public NjWithdrawingRecordExample() {
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
     * nj_withdrawing_record 2018-07-17
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

        public Criteria andCurrentPeriodIsNull() {
            addCriterion("current_period is null");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodIsNotNull() {
            addCriterion("current_period is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodEqualTo(Integer value) {
            addCriterion("current_period =", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodNotEqualTo(Integer value) {
            addCriterion("current_period <>", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodGreaterThan(Integer value) {
            addCriterion("current_period >", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_period >=", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodLessThan(Integer value) {
            addCriterion("current_period <", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("current_period <=", value, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodIn(List<Integer> values) {
            addCriterion("current_period in", values, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodNotIn(List<Integer> values) {
            addCriterion("current_period not in", values, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodBetween(Integer value1, Integer value2) {
            addCriterion("current_period between", value1, value2, "currentPeriod");
            return (Criteria) this;
        }

        public Criteria andCurrentPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("current_period not between", value1, value2, "currentPeriod");
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

        public Criteria andWithdrawingCapitalIsNull() {
            addCriterion("withdrawing_capital is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalIsNotNull() {
            addCriterion("withdrawing_capital is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalEqualTo(BigDecimal value) {
            addCriterion("withdrawing_capital =", value, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalNotEqualTo(BigDecimal value) {
            addCriterion("withdrawing_capital <>", value, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalGreaterThan(BigDecimal value) {
            addCriterion("withdrawing_capital >", value, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdrawing_capital >=", value, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalLessThan(BigDecimal value) {
            addCriterion("withdrawing_capital <", value, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdrawing_capital <=", value, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalIn(List<BigDecimal> values) {
            addCriterion("withdrawing_capital in", values, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalNotIn(List<BigDecimal> values) {
            addCriterion("withdrawing_capital not in", values, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdrawing_capital between", value1, value2, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdrawing_capital not between", value1, value2, "withdrawingCapital");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestIsNull() {
            addCriterion("withdrawing_interest is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestIsNotNull() {
            addCriterion("withdrawing_interest is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestEqualTo(BigDecimal value) {
            addCriterion("withdrawing_interest =", value, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestNotEqualTo(BigDecimal value) {
            addCriterion("withdrawing_interest <>", value, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestGreaterThan(BigDecimal value) {
            addCriterion("withdrawing_interest >", value, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("withdrawing_interest >=", value, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestLessThan(BigDecimal value) {
            addCriterion("withdrawing_interest <", value, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("withdrawing_interest <=", value, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestIn(List<BigDecimal> values) {
            addCriterion("withdrawing_interest in", values, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestNotIn(List<BigDecimal> values) {
            addCriterion("withdrawing_interest not in", values, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdrawing_interest between", value1, value2, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andWithdrawingInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("withdrawing_interest not between", value1, value2, "withdrawingInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestIsNull() {
            addCriterion("default_interest is null");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestIsNotNull() {
            addCriterion("default_interest is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestEqualTo(BigDecimal value) {
            addCriterion("default_interest =", value, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestNotEqualTo(BigDecimal value) {
            addCriterion("default_interest <>", value, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestGreaterThan(BigDecimal value) {
            addCriterion("default_interest >", value, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("default_interest >=", value, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestLessThan(BigDecimal value) {
            addCriterion("default_interest <", value, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("default_interest <=", value, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestIn(List<BigDecimal> values) {
            addCriterion("default_interest in", values, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestNotIn(List<BigDecimal> values) {
            addCriterion("default_interest not in", values, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("default_interest between", value1, value2, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andDefaultInterestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("default_interest not between", value1, value2, "defaultInterest");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIsNull() {
            addCriterion("is_overdue is null");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIsNotNull() {
            addCriterion("is_overdue is not null");
            return (Criteria) this;
        }

        public Criteria andIsOverdueEqualTo(Boolean value) {
            addCriterion("is_overdue =", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotEqualTo(Boolean value) {
            addCriterion("is_overdue <>", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueGreaterThan(Boolean value) {
            addCriterion("is_overdue >", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_overdue >=", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueLessThan(Boolean value) {
            addCriterion("is_overdue <", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueLessThanOrEqualTo(Boolean value) {
            addCriterion("is_overdue <=", value, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueIn(List<Boolean> values) {
            addCriterion("is_overdue in", values, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotIn(List<Boolean> values) {
            addCriterion("is_overdue not in", values, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueBetween(Boolean value1, Boolean value2) {
            addCriterion("is_overdue between", value1, value2, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andIsOverdueNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_overdue not between", value1, value2, "isOverdue");
            return (Criteria) this;
        }

        public Criteria andOverdueDayIsNull() {
            addCriterion("overdue_day is null");
            return (Criteria) this;
        }

        public Criteria andOverdueDayIsNotNull() {
            addCriterion("overdue_day is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueDayEqualTo(Integer value) {
            addCriterion("overdue_day =", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayNotEqualTo(Integer value) {
            addCriterion("overdue_day <>", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayGreaterThan(Integer value) {
            addCriterion("overdue_day >", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayGreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue_day >=", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayLessThan(Integer value) {
            addCriterion("overdue_day <", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayLessThanOrEqualTo(Integer value) {
            addCriterion("overdue_day <=", value, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayIn(List<Integer> values) {
            addCriterion("overdue_day in", values, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayNotIn(List<Integer> values) {
            addCriterion("overdue_day not in", values, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayBetween(Integer value1, Integer value2) {
            addCriterion("overdue_day between", value1, value2, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andOverdueDayNotBetween(Integer value1, Integer value2) {
            addCriterion("overdue_day not between", value1, value2, "overdueDay");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateIsNull() {
            addCriterion("withdrawing_date is null");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateIsNotNull() {
            addCriterion("withdrawing_date is not null");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateEqualTo(Date value) {
            addCriterion("withdrawing_date =", value, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateNotEqualTo(Date value) {
            addCriterion("withdrawing_date <>", value, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateGreaterThan(Date value) {
            addCriterion("withdrawing_date >", value, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateGreaterThanOrEqualTo(Date value) {
            addCriterion("withdrawing_date >=", value, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateLessThan(Date value) {
            addCriterion("withdrawing_date <", value, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateLessThanOrEqualTo(Date value) {
            addCriterion("withdrawing_date <=", value, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateIn(List<Date> values) {
            addCriterion("withdrawing_date in", values, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateNotIn(List<Date> values) {
            addCriterion("withdrawing_date not in", values, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateBetween(Date value1, Date value2) {
            addCriterion("withdrawing_date between", value1, value2, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andWithdrawingDateNotBetween(Date value1, Date value2) {
            addCriterion("withdrawing_date not between", value1, value2, "withdrawingDate");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }
    }

    /**
     * nj_withdrawing_record
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_withdrawing_record 2018-07-17
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