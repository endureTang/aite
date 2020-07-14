package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjLoanOrderExample {
    /**
     * nj_loan_order
     */
    protected String orderByClause;

    /**
     * nj_loan_order
     */
    protected boolean distinct;

    /**
     * nj_loan_order
     */
    protected List<Criteria> oredCriteria;

    public NjLoanOrderExample() {
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
     * nj_loan_order 2019-04-02
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(BigDecimal value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(BigDecimal value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(BigDecimal value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(BigDecimal value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<BigDecimal> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<BigDecimal> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("amount not between", value1, value2, "amount");
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

        public Criteria andAuditAmountIsNull() {
            addCriterion("audit_amount is null");
            return (Criteria) this;
        }

        public Criteria andAuditAmountIsNotNull() {
            addCriterion("audit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAuditAmountEqualTo(BigDecimal value) {
            addCriterion("audit_amount =", value, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountNotEqualTo(BigDecimal value) {
            addCriterion("audit_amount <>", value, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountGreaterThan(BigDecimal value) {
            addCriterion("audit_amount >", value, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("audit_amount >=", value, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountLessThan(BigDecimal value) {
            addCriterion("audit_amount <", value, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("audit_amount <=", value, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountIn(List<BigDecimal> values) {
            addCriterion("audit_amount in", values, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountNotIn(List<BigDecimal> values) {
            addCriterion("audit_amount not in", values, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("audit_amount between", value1, value2, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("audit_amount not between", value1, value2, "auditAmount");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodIsNull() {
            addCriterion("audit_period is null");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodIsNotNull() {
            addCriterion("audit_period is not null");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodEqualTo(Integer value) {
            addCriterion("audit_period =", value, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodNotEqualTo(Integer value) {
            addCriterion("audit_period <>", value, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodGreaterThan(Integer value) {
            addCriterion("audit_period >", value, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_period >=", value, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodLessThan(Integer value) {
            addCriterion("audit_period <", value, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("audit_period <=", value, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodIn(List<Integer> values) {
            addCriterion("audit_period in", values, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodNotIn(List<Integer> values) {
            addCriterion("audit_period not in", values, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodBetween(Integer value1, Integer value2) {
            addCriterion("audit_period between", value1, value2, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andAuditPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_period not between", value1, value2, "auditPeriod");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andUsageIdIsNull() {
            addCriterion("usage_id is null");
            return (Criteria) this;
        }

        public Criteria andUsageIdIsNotNull() {
            addCriterion("usage_id is not null");
            return (Criteria) this;
        }

        public Criteria andUsageIdEqualTo(String value) {
            addCriterion("usage_id =", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdNotEqualTo(String value) {
            addCriterion("usage_id <>", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdGreaterThan(String value) {
            addCriterion("usage_id >", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdGreaterThanOrEqualTo(String value) {
            addCriterion("usage_id >=", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdLessThan(String value) {
            addCriterion("usage_id <", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdLessThanOrEqualTo(String value) {
            addCriterion("usage_id <=", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdLike(String value) {
            addCriterion("usage_id like", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdNotLike(String value) {
            addCriterion("usage_id not like", value, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdIn(List<String> values) {
            addCriterion("usage_id in", values, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdNotIn(List<String> values) {
            addCriterion("usage_id not in", values, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdBetween(String value1, String value2) {
            addCriterion("usage_id between", value1, value2, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageIdNotBetween(String value1, String value2) {
            addCriterion("usage_id not between", value1, value2, "usageId");
            return (Criteria) this;
        }

        public Criteria andUsageDescIsNull() {
            addCriterion("usage_desc is null");
            return (Criteria) this;
        }

        public Criteria andUsageDescIsNotNull() {
            addCriterion("usage_desc is not null");
            return (Criteria) this;
        }

        public Criteria andUsageDescEqualTo(String value) {
            addCriterion("usage_desc =", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescNotEqualTo(String value) {
            addCriterion("usage_desc <>", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescGreaterThan(String value) {
            addCriterion("usage_desc >", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescGreaterThanOrEqualTo(String value) {
            addCriterion("usage_desc >=", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescLessThan(String value) {
            addCriterion("usage_desc <", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescLessThanOrEqualTo(String value) {
            addCriterion("usage_desc <=", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescLike(String value) {
            addCriterion("usage_desc like", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescNotLike(String value) {
            addCriterion("usage_desc not like", value, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescIn(List<String> values) {
            addCriterion("usage_desc in", values, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescNotIn(List<String> values) {
            addCriterion("usage_desc not in", values, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescBetween(String value1, String value2) {
            addCriterion("usage_desc between", value1, value2, "usageDesc");
            return (Criteria) this;
        }

        public Criteria andUsageDescNotBetween(String value1, String value2) {
            addCriterion("usage_desc not between", value1, value2, "usageDesc");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andRelativeChanIdIsNull() {
            addCriterion("relative_chan_id is null");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdIsNotNull() {
            addCriterion("relative_chan_id is not null");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdEqualTo(String value) {
            addCriterion("relative_chan_id =", value, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdNotEqualTo(String value) {
            addCriterion("relative_chan_id <>", value, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdGreaterThan(String value) {
            addCriterion("relative_chan_id >", value, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdGreaterThanOrEqualTo(String value) {
            addCriterion("relative_chan_id >=", value, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdLessThan(String value) {
            addCriterion("relative_chan_id <", value, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdLessThanOrEqualTo(String value) {
            addCriterion("relative_chan_id <=", value, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdLike(String value) {
            addCriterion("relative_chan_id like", value, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdNotLike(String value) {
            addCriterion("relative_chan_id not like", value, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdIn(List<String> values) {
            addCriterion("relative_chan_id in", values, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdNotIn(List<String> values) {
            addCriterion("relative_chan_id not in", values, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdBetween(String value1, String value2) {
            addCriterion("relative_chan_id between", value1, value2, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andRelativeChanIdNotBetween(String value1, String value2) {
            addCriterion("relative_chan_id not between", value1, value2, "relativeChanId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(String value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(String value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(String value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(String value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(String value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(String value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLike(String value) {
            addCriterion("agent_id like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotLike(String value) {
            addCriterion("agent_id not like", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<String> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<String> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(String value1, String value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(String value1, String value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
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

        public Criteria andDelFlagIsNull() {
            addCriterion("del_flag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("del_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(Boolean value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Boolean value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Boolean value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Boolean value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Boolean value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Boolean value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Boolean> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Boolean> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Boolean value1, Boolean value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Boolean value1, Boolean value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andAuditRatingIsNull() {
            addCriterion("audit_rating is null");
            return (Criteria) this;
        }

        public Criteria andAuditRatingIsNotNull() {
            addCriterion("audit_rating is not null");
            return (Criteria) this;
        }

        public Criteria andAuditRatingEqualTo(String value) {
            addCriterion("audit_rating =", value, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingNotEqualTo(String value) {
            addCriterion("audit_rating <>", value, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingGreaterThan(String value) {
            addCriterion("audit_rating >", value, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingGreaterThanOrEqualTo(String value) {
            addCriterion("audit_rating >=", value, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingLessThan(String value) {
            addCriterion("audit_rating <", value, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingLessThanOrEqualTo(String value) {
            addCriterion("audit_rating <=", value, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingLike(String value) {
            addCriterion("audit_rating like", value, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingNotLike(String value) {
            addCriterion("audit_rating not like", value, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingIn(List<String> values) {
            addCriterion("audit_rating in", values, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingNotIn(List<String> values) {
            addCriterion("audit_rating not in", values, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingBetween(String value1, String value2) {
            addCriterion("audit_rating between", value1, value2, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditRatingNotBetween(String value1, String value2) {
            addCriterion("audit_rating not between", value1, value2, "auditRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingIsNull() {
            addCriterion("audit_service_rating is null");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingIsNotNull() {
            addCriterion("audit_service_rating is not null");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingEqualTo(String value) {
            addCriterion("audit_service_rating =", value, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingNotEqualTo(String value) {
            addCriterion("audit_service_rating <>", value, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingGreaterThan(String value) {
            addCriterion("audit_service_rating >", value, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingGreaterThanOrEqualTo(String value) {
            addCriterion("audit_service_rating >=", value, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingLessThan(String value) {
            addCriterion("audit_service_rating <", value, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingLessThanOrEqualTo(String value) {
            addCriterion("audit_service_rating <=", value, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingLike(String value) {
            addCriterion("audit_service_rating like", value, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingNotLike(String value) {
            addCriterion("audit_service_rating not like", value, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingIn(List<String> values) {
            addCriterion("audit_service_rating in", values, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingNotIn(List<String> values) {
            addCriterion("audit_service_rating not in", values, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingBetween(String value1, String value2) {
            addCriterion("audit_service_rating between", value1, value2, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andAuditServiceRatingNotBetween(String value1, String value2) {
            addCriterion("audit_service_rating not between", value1, value2, "auditServiceRating");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateIsNull() {
            addCriterion("charge_fee_rate is null");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateIsNotNull() {
            addCriterion("charge_fee_rate is not null");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateEqualTo(String value) {
            addCriterion("charge_fee_rate =", value, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateNotEqualTo(String value) {
            addCriterion("charge_fee_rate <>", value, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateGreaterThan(String value) {
            addCriterion("charge_fee_rate >", value, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateGreaterThanOrEqualTo(String value) {
            addCriterion("charge_fee_rate >=", value, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateLessThan(String value) {
            addCriterion("charge_fee_rate <", value, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateLessThanOrEqualTo(String value) {
            addCriterion("charge_fee_rate <=", value, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateLike(String value) {
            addCriterion("charge_fee_rate like", value, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateNotLike(String value) {
            addCriterion("charge_fee_rate not like", value, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateIn(List<String> values) {
            addCriterion("charge_fee_rate in", values, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateNotIn(List<String> values) {
            addCriterion("charge_fee_rate not in", values, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateBetween(String value1, String value2) {
            addCriterion("charge_fee_rate between", value1, value2, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andChargeFeeRateNotBetween(String value1, String value2) {
            addCriterion("charge_fee_rate not between", value1, value2, "chargeFeeRate");
            return (Criteria) this;
        }

        public Criteria andFeeValueIsNull() {
            addCriterion("fee_value is null");
            return (Criteria) this;
        }

        public Criteria andFeeValueIsNotNull() {
            addCriterion("fee_value is not null");
            return (Criteria) this;
        }

        public Criteria andFeeValueEqualTo(String value) {
            addCriterion("fee_value =", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotEqualTo(String value) {
            addCriterion("fee_value <>", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueGreaterThan(String value) {
            addCriterion("fee_value >", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueGreaterThanOrEqualTo(String value) {
            addCriterion("fee_value >=", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueLessThan(String value) {
            addCriterion("fee_value <", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueLessThanOrEqualTo(String value) {
            addCriterion("fee_value <=", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueLike(String value) {
            addCriterion("fee_value like", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotLike(String value) {
            addCriterion("fee_value not like", value, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueIn(List<String> values) {
            addCriterion("fee_value in", values, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotIn(List<String> values) {
            addCriterion("fee_value not in", values, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueBetween(String value1, String value2) {
            addCriterion("fee_value between", value1, value2, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeValueNotBetween(String value1, String value2) {
            addCriterion("fee_value not between", value1, value2, "feeValue");
            return (Criteria) this;
        }

        public Criteria andFeeRateIsNull() {
            addCriterion("fee_rate is null");
            return (Criteria) this;
        }

        public Criteria andFeeRateIsNotNull() {
            addCriterion("fee_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRateEqualTo(String value) {
            addCriterion("fee_rate =", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotEqualTo(String value) {
            addCriterion("fee_rate <>", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateGreaterThan(String value) {
            addCriterion("fee_rate >", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateGreaterThanOrEqualTo(String value) {
            addCriterion("fee_rate >=", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLessThan(String value) {
            addCriterion("fee_rate <", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLessThanOrEqualTo(String value) {
            addCriterion("fee_rate <=", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLike(String value) {
            addCriterion("fee_rate like", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotLike(String value) {
            addCriterion("fee_rate not like", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateIn(List<String> values) {
            addCriterion("fee_rate in", values, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotIn(List<String> values) {
            addCriterion("fee_rate not in", values, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateBetween(String value1, String value2) {
            addCriterion("fee_rate between", value1, value2, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotBetween(String value1, String value2) {
            addCriterion("fee_rate not between", value1, value2, "feeRate");
            return (Criteria) this;
        }

        public Criteria andLendMethodIsNull() {
            addCriterion("lend_method is null");
            return (Criteria) this;
        }

        public Criteria andLendMethodIsNotNull() {
            addCriterion("lend_method is not null");
            return (Criteria) this;
        }

        public Criteria andLendMethodEqualTo(String value) {
            addCriterion("lend_method =", value, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodNotEqualTo(String value) {
            addCriterion("lend_method <>", value, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodGreaterThan(String value) {
            addCriterion("lend_method >", value, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodGreaterThanOrEqualTo(String value) {
            addCriterion("lend_method >=", value, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodLessThan(String value) {
            addCriterion("lend_method <", value, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodLessThanOrEqualTo(String value) {
            addCriterion("lend_method <=", value, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodLike(String value) {
            addCriterion("lend_method like", value, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodNotLike(String value) {
            addCriterion("lend_method not like", value, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodIn(List<String> values) {
            addCriterion("lend_method in", values, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodNotIn(List<String> values) {
            addCriterion("lend_method not in", values, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodBetween(String value1, String value2) {
            addCriterion("lend_method between", value1, value2, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andLendMethodNotBetween(String value1, String value2) {
            addCriterion("lend_method not between", value1, value2, "lendMethod");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceIsNull() {
            addCriterion("ge_agcy_advice is null");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceIsNotNull() {
            addCriterion("ge_agcy_advice is not null");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceEqualTo(String value) {
            addCriterion("ge_agcy_advice =", value, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceNotEqualTo(String value) {
            addCriterion("ge_agcy_advice <>", value, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceGreaterThan(String value) {
            addCriterion("ge_agcy_advice >", value, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("ge_agcy_advice >=", value, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceLessThan(String value) {
            addCriterion("ge_agcy_advice <", value, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceLessThanOrEqualTo(String value) {
            addCriterion("ge_agcy_advice <=", value, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceLike(String value) {
            addCriterion("ge_agcy_advice like", value, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceNotLike(String value) {
            addCriterion("ge_agcy_advice not like", value, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceIn(List<String> values) {
            addCriterion("ge_agcy_advice in", values, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceNotIn(List<String> values) {
            addCriterion("ge_agcy_advice not in", values, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceBetween(String value1, String value2) {
            addCriterion("ge_agcy_advice between", value1, value2, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andGeAgcyAdviceNotBetween(String value1, String value2) {
            addCriterion("ge_agcy_advice not between", value1, value2, "geAgcyAdvice");
            return (Criteria) this;
        }

        public Criteria andFundsUseIsNull() {
            addCriterion("funds_use is null");
            return (Criteria) this;
        }

        public Criteria andFundsUseIsNotNull() {
            addCriterion("funds_use is not null");
            return (Criteria) this;
        }

        public Criteria andFundsUseEqualTo(String value) {
            addCriterion("funds_use =", value, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseNotEqualTo(String value) {
            addCriterion("funds_use <>", value, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseGreaterThan(String value) {
            addCriterion("funds_use >", value, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseGreaterThanOrEqualTo(String value) {
            addCriterion("funds_use >=", value, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseLessThan(String value) {
            addCriterion("funds_use <", value, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseLessThanOrEqualTo(String value) {
            addCriterion("funds_use <=", value, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseLike(String value) {
            addCriterion("funds_use like", value, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseNotLike(String value) {
            addCriterion("funds_use not like", value, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseIn(List<String> values) {
            addCriterion("funds_use in", values, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseNotIn(List<String> values) {
            addCriterion("funds_use not in", values, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseBetween(String value1, String value2) {
            addCriterion("funds_use between", value1, value2, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andFundsUseNotBetween(String value1, String value2) {
            addCriterion("funds_use not between", value1, value2, "fundsUse");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseIsNull() {
            addCriterion("enterprise_case is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseIsNotNull() {
            addCriterion("enterprise_case is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseEqualTo(String value) {
            addCriterion("enterprise_case =", value, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseNotEqualTo(String value) {
            addCriterion("enterprise_case <>", value, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseGreaterThan(String value) {
            addCriterion("enterprise_case >", value, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_case >=", value, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseLessThan(String value) {
            addCriterion("enterprise_case <", value, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseLessThanOrEqualTo(String value) {
            addCriterion("enterprise_case <=", value, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseLike(String value) {
            addCriterion("enterprise_case like", value, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseNotLike(String value) {
            addCriterion("enterprise_case not like", value, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseIn(List<String> values) {
            addCriterion("enterprise_case in", values, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseNotIn(List<String> values) {
            addCriterion("enterprise_case not in", values, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseBetween(String value1, String value2) {
            addCriterion("enterprise_case between", value1, value2, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCaseNotBetween(String value1, String value2) {
            addCriterion("enterprise_case not between", value1, value2, "enterpriseCase");
            return (Criteria) this;
        }

        public Criteria andProjectContentIsNull() {
            addCriterion("project_content is null");
            return (Criteria) this;
        }

        public Criteria andProjectContentIsNotNull() {
            addCriterion("project_content is not null");
            return (Criteria) this;
        }

        public Criteria andProjectContentEqualTo(String value) {
            addCriterion("project_content =", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotEqualTo(String value) {
            addCriterion("project_content <>", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentGreaterThan(String value) {
            addCriterion("project_content >", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentGreaterThanOrEqualTo(String value) {
            addCriterion("project_content >=", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLessThan(String value) {
            addCriterion("project_content <", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLessThanOrEqualTo(String value) {
            addCriterion("project_content <=", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentLike(String value) {
            addCriterion("project_content like", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotLike(String value) {
            addCriterion("project_content not like", value, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentIn(List<String> values) {
            addCriterion("project_content in", values, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotIn(List<String> values) {
            addCriterion("project_content not in", values, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentBetween(String value1, String value2) {
            addCriterion("project_content between", value1, value2, "projectContent");
            return (Criteria) this;
        }

        public Criteria andProjectContentNotBetween(String value1, String value2) {
            addCriterion("project_content not between", value1, value2, "projectContent");
            return (Criteria) this;
        }

        public Criteria andRepayWayIsNull() {
            addCriterion("repay_way is null");
            return (Criteria) this;
        }

        public Criteria andRepayWayIsNotNull() {
            addCriterion("repay_way is not null");
            return (Criteria) this;
        }

        public Criteria andRepayWayEqualTo(String value) {
            addCriterion("repay_way =", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotEqualTo(String value) {
            addCriterion("repay_way <>", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayGreaterThan(String value) {
            addCriterion("repay_way >", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayGreaterThanOrEqualTo(String value) {
            addCriterion("repay_way >=", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayLessThan(String value) {
            addCriterion("repay_way <", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayLessThanOrEqualTo(String value) {
            addCriterion("repay_way <=", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayLike(String value) {
            addCriterion("repay_way like", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotLike(String value) {
            addCriterion("repay_way not like", value, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayIn(List<String> values) {
            addCriterion("repay_way in", values, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotIn(List<String> values) {
            addCriterion("repay_way not in", values, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayBetween(String value1, String value2) {
            addCriterion("repay_way between", value1, value2, "repayWay");
            return (Criteria) this;
        }

        public Criteria andRepayWayNotBetween(String value1, String value2) {
            addCriterion("repay_way not between", value1, value2, "repayWay");
            return (Criteria) this;
        }

        public Criteria andCfstatusIsNull() {
            addCriterion("cfstatus is null");
            return (Criteria) this;
        }

        public Criteria andCfstatusIsNotNull() {
            addCriterion("cfstatus is not null");
            return (Criteria) this;
        }

        public Criteria andCfstatusEqualTo(Integer value) {
            addCriterion("cfstatus =", value, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusNotEqualTo(Integer value) {
            addCriterion("cfstatus <>", value, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusGreaterThan(Integer value) {
            addCriterion("cfstatus >", value, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cfstatus >=", value, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusLessThan(Integer value) {
            addCriterion("cfstatus <", value, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusLessThanOrEqualTo(Integer value) {
            addCriterion("cfstatus <=", value, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusIn(List<Integer> values) {
            addCriterion("cfstatus in", values, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusNotIn(List<Integer> values) {
            addCriterion("cfstatus not in", values, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusBetween(Integer value1, Integer value2) {
            addCriterion("cfstatus between", value1, value2, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCfstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("cfstatus not between", value1, value2, "cfstatus");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNull() {
            addCriterion("callback_url is null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIsNotNull() {
            addCriterion("callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlEqualTo(String value) {
            addCriterion("callback_url =", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotEqualTo(String value) {
            addCriterion("callback_url <>", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThan(String value) {
            addCriterion("callback_url >", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("callback_url >=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThan(String value) {
            addCriterion("callback_url <", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("callback_url <=", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlLike(String value) {
            addCriterion("callback_url like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotLike(String value) {
            addCriterion("callback_url not like", value, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlIn(List<String> values) {
            addCriterion("callback_url in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotIn(List<String> values) {
            addCriterion("callback_url not in", values, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlBetween(String value1, String value2) {
            addCriterion("callback_url between", value1, value2, "callbackUrl");
            return (Criteria) this;
        }

        public Criteria andCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("callback_url not between", value1, value2, "callbackUrl");
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

        public Criteria andRelendMethodIsNull() {
            addCriterion("relend_method is null");
            return (Criteria) this;
        }

        public Criteria andRelendMethodIsNotNull() {
            addCriterion("relend_method is not null");
            return (Criteria) this;
        }

        public Criteria andRelendMethodEqualTo(String value) {
            addCriterion("relend_method =", value, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodNotEqualTo(String value) {
            addCriterion("relend_method <>", value, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodGreaterThan(String value) {
            addCriterion("relend_method >", value, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodGreaterThanOrEqualTo(String value) {
            addCriterion("relend_method >=", value, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodLessThan(String value) {
            addCriterion("relend_method <", value, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodLessThanOrEqualTo(String value) {
            addCriterion("relend_method <=", value, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodLike(String value) {
            addCriterion("relend_method like", value, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodNotLike(String value) {
            addCriterion("relend_method not like", value, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodIn(List<String> values) {
            addCriterion("relend_method in", values, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodNotIn(List<String> values) {
            addCriterion("relend_method not in", values, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodBetween(String value1, String value2) {
            addCriterion("relend_method between", value1, value2, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andRelendMethodNotBetween(String value1, String value2) {
            addCriterion("relend_method not between", value1, value2, "relendMethod");
            return (Criteria) this;
        }

        public Criteria andAuditSxfIsNull() {
            addCriterion("audit_sxf is null");
            return (Criteria) this;
        }

        public Criteria andAuditSxfIsNotNull() {
            addCriterion("audit_sxf is not null");
            return (Criteria) this;
        }

        public Criteria andAuditSxfEqualTo(String value) {
            addCriterion("audit_sxf =", value, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfNotEqualTo(String value) {
            addCriterion("audit_sxf <>", value, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfGreaterThan(String value) {
            addCriterion("audit_sxf >", value, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfGreaterThanOrEqualTo(String value) {
            addCriterion("audit_sxf >=", value, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfLessThan(String value) {
            addCriterion("audit_sxf <", value, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfLessThanOrEqualTo(String value) {
            addCriterion("audit_sxf <=", value, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfLike(String value) {
            addCriterion("audit_sxf like", value, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfNotLike(String value) {
            addCriterion("audit_sxf not like", value, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfIn(List<String> values) {
            addCriterion("audit_sxf in", values, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfNotIn(List<String> values) {
            addCriterion("audit_sxf not in", values, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfBetween(String value1, String value2) {
            addCriterion("audit_sxf between", value1, value2, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfNotBetween(String value1, String value2) {
            addCriterion("audit_sxf not between", value1, value2, "auditSxf");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeIsNull() {
            addCriterion("audit_sxf_type is null");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeIsNotNull() {
            addCriterion("audit_sxf_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeEqualTo(Integer value) {
            addCriterion("audit_sxf_type =", value, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeNotEqualTo(Integer value) {
            addCriterion("audit_sxf_type <>", value, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeGreaterThan(Integer value) {
            addCriterion("audit_sxf_type >", value, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_sxf_type >=", value, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeLessThan(Integer value) {
            addCriterion("audit_sxf_type <", value, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeLessThanOrEqualTo(Integer value) {
            addCriterion("audit_sxf_type <=", value, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeIn(List<Integer> values) {
            addCriterion("audit_sxf_type in", values, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeNotIn(List<Integer> values) {
            addCriterion("audit_sxf_type not in", values, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeBetween(Integer value1, Integer value2) {
            addCriterion("audit_sxf_type between", value1, value2, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditSxfTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_sxf_type not between", value1, value2, "auditSxfType");
            return (Criteria) this;
        }

        public Criteria andAuditBondIsNull() {
            addCriterion("audit_bond is null");
            return (Criteria) this;
        }

        public Criteria andAuditBondIsNotNull() {
            addCriterion("audit_bond is not null");
            return (Criteria) this;
        }

        public Criteria andAuditBondEqualTo(String value) {
            addCriterion("audit_bond =", value, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondNotEqualTo(String value) {
            addCriterion("audit_bond <>", value, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondGreaterThan(String value) {
            addCriterion("audit_bond >", value, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondGreaterThanOrEqualTo(String value) {
            addCriterion("audit_bond >=", value, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondLessThan(String value) {
            addCriterion("audit_bond <", value, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondLessThanOrEqualTo(String value) {
            addCriterion("audit_bond <=", value, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondLike(String value) {
            addCriterion("audit_bond like", value, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondNotLike(String value) {
            addCriterion("audit_bond not like", value, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondIn(List<String> values) {
            addCriterion("audit_bond in", values, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondNotIn(List<String> values) {
            addCriterion("audit_bond not in", values, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondBetween(String value1, String value2) {
            addCriterion("audit_bond between", value1, value2, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondNotBetween(String value1, String value2) {
            addCriterion("audit_bond not between", value1, value2, "auditBond");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeIsNull() {
            addCriterion("audit_bond_type is null");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeIsNotNull() {
            addCriterion("audit_bond_type is not null");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeEqualTo(Integer value) {
            addCriterion("audit_bond_type =", value, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeNotEqualTo(Integer value) {
            addCriterion("audit_bond_type <>", value, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeGreaterThan(Integer value) {
            addCriterion("audit_bond_type >", value, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("audit_bond_type >=", value, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeLessThan(Integer value) {
            addCriterion("audit_bond_type <", value, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeLessThanOrEqualTo(Integer value) {
            addCriterion("audit_bond_type <=", value, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeIn(List<Integer> values) {
            addCriterion("audit_bond_type in", values, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeNotIn(List<Integer> values) {
            addCriterion("audit_bond_type not in", values, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeBetween(Integer value1, Integer value2) {
            addCriterion("audit_bond_type between", value1, value2, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditBondTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("audit_bond_type not between", value1, value2, "auditBondType");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksIsNull() {
            addCriterion("audit_remarks is null");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksIsNotNull() {
            addCriterion("audit_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksEqualTo(String value) {
            addCriterion("audit_remarks =", value, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksNotEqualTo(String value) {
            addCriterion("audit_remarks <>", value, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksGreaterThan(String value) {
            addCriterion("audit_remarks >", value, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("audit_remarks >=", value, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksLessThan(String value) {
            addCriterion("audit_remarks <", value, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksLessThanOrEqualTo(String value) {
            addCriterion("audit_remarks <=", value, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksLike(String value) {
            addCriterion("audit_remarks like", value, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksNotLike(String value) {
            addCriterion("audit_remarks not like", value, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksIn(List<String> values) {
            addCriterion("audit_remarks in", values, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksNotIn(List<String> values) {
            addCriterion("audit_remarks not in", values, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksBetween(String value1, String value2) {
            addCriterion("audit_remarks between", value1, value2, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andAuditRemarksNotBetween(String value1, String value2) {
            addCriterion("audit_remarks not between", value1, value2, "auditRemarks");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsIsNull() {
            addCriterion("blocked_funds is null");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsIsNotNull() {
            addCriterion("blocked_funds is not null");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsEqualTo(String value) {
            addCriterion("blocked_funds =", value, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsNotEqualTo(String value) {
            addCriterion("blocked_funds <>", value, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsGreaterThan(String value) {
            addCriterion("blocked_funds >", value, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsGreaterThanOrEqualTo(String value) {
            addCriterion("blocked_funds >=", value, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsLessThan(String value) {
            addCriterion("blocked_funds <", value, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsLessThanOrEqualTo(String value) {
            addCriterion("blocked_funds <=", value, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsLike(String value) {
            addCriterion("blocked_funds like", value, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsNotLike(String value) {
            addCriterion("blocked_funds not like", value, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsIn(List<String> values) {
            addCriterion("blocked_funds in", values, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsNotIn(List<String> values) {
            addCriterion("blocked_funds not in", values, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsBetween(String value1, String value2) {
            addCriterion("blocked_funds between", value1, value2, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andBlockedFundsNotBetween(String value1, String value2) {
            addCriterion("blocked_funds not between", value1, value2, "blockedFunds");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdIsNull() {
            addCriterion("contract_attr_id is null");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdIsNotNull() {
            addCriterion("contract_attr_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdEqualTo(String value) {
            addCriterion("contract_attr_id =", value, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdNotEqualTo(String value) {
            addCriterion("contract_attr_id <>", value, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdGreaterThan(String value) {
            addCriterion("contract_attr_id >", value, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdGreaterThanOrEqualTo(String value) {
            addCriterion("contract_attr_id >=", value, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdLessThan(String value) {
            addCriterion("contract_attr_id <", value, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdLessThanOrEqualTo(String value) {
            addCriterion("contract_attr_id <=", value, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdLike(String value) {
            addCriterion("contract_attr_id like", value, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdNotLike(String value) {
            addCriterion("contract_attr_id not like", value, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdIn(List<String> values) {
            addCriterion("contract_attr_id in", values, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdNotIn(List<String> values) {
            addCriterion("contract_attr_id not in", values, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdBetween(String value1, String value2) {
            addCriterion("contract_attr_id between", value1, value2, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andContractAttrIdNotBetween(String value1, String value2) {
            addCriterion("contract_attr_id not between", value1, value2, "contractAttrId");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoIsNull() {
            addCriterion("tfcf_project_no is null");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoIsNotNull() {
            addCriterion("tfcf_project_no is not null");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoEqualTo(String value) {
            addCriterion("tfcf_project_no =", value, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoNotEqualTo(String value) {
            addCriterion("tfcf_project_no <>", value, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoGreaterThan(String value) {
            addCriterion("tfcf_project_no >", value, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("tfcf_project_no >=", value, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoLessThan(String value) {
            addCriterion("tfcf_project_no <", value, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoLessThanOrEqualTo(String value) {
            addCriterion("tfcf_project_no <=", value, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoLike(String value) {
            addCriterion("tfcf_project_no like", value, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoNotLike(String value) {
            addCriterion("tfcf_project_no not like", value, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoIn(List<String> values) {
            addCriterion("tfcf_project_no in", values, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoNotIn(List<String> values) {
            addCriterion("tfcf_project_no not in", values, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoBetween(String value1, String value2) {
            addCriterion("tfcf_project_no between", value1, value2, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andTfcfProjectNoNotBetween(String value1, String value2) {
            addCriterion("tfcf_project_no not between", value1, value2, "tfcfProjectNo");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateIsNull() {
            addCriterion("make_loans_date is null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateIsNotNull() {
            addCriterion("make_loans_date is not null");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateEqualTo(Date value) {
            addCriterion("make_loans_date =", value, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateNotEqualTo(Date value) {
            addCriterion("make_loans_date <>", value, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateGreaterThan(Date value) {
            addCriterion("make_loans_date >", value, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateGreaterThanOrEqualTo(Date value) {
            addCriterion("make_loans_date >=", value, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateLessThan(Date value) {
            addCriterion("make_loans_date <", value, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateLessThanOrEqualTo(Date value) {
            addCriterion("make_loans_date <=", value, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateIn(List<Date> values) {
            addCriterion("make_loans_date in", values, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateNotIn(List<Date> values) {
            addCriterion("make_loans_date not in", values, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateBetween(Date value1, Date value2) {
            addCriterion("make_loans_date between", value1, value2, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andMakeLoansDateNotBetween(Date value1, Date value2) {
            addCriterion("make_loans_date not between", value1, value2, "makeLoansDate");
            return (Criteria) this;
        }

        public Criteria andRiskGradeIsNull() {
            addCriterion("risk_grade is null");
            return (Criteria) this;
        }

        public Criteria andRiskGradeIsNotNull() {
            addCriterion("risk_grade is not null");
            return (Criteria) this;
        }

        public Criteria andRiskGradeEqualTo(String value) {
            addCriterion("risk_grade =", value, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeNotEqualTo(String value) {
            addCriterion("risk_grade <>", value, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeGreaterThan(String value) {
            addCriterion("risk_grade >", value, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeGreaterThanOrEqualTo(String value) {
            addCriterion("risk_grade >=", value, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeLessThan(String value) {
            addCriterion("risk_grade <", value, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeLessThanOrEqualTo(String value) {
            addCriterion("risk_grade <=", value, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeLike(String value) {
            addCriterion("risk_grade like", value, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeNotLike(String value) {
            addCriterion("risk_grade not like", value, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeIn(List<String> values) {
            addCriterion("risk_grade in", values, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeNotIn(List<String> values) {
            addCriterion("risk_grade not in", values, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeBetween(String value1, String value2) {
            addCriterion("risk_grade between", value1, value2, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andRiskGradeNotBetween(String value1, String value2) {
            addCriterion("risk_grade not between", value1, value2, "riskGrade");
            return (Criteria) this;
        }

        public Criteria andAfterStatusIsNull() {
            addCriterion("after_status is null");
            return (Criteria) this;
        }

        public Criteria andAfterStatusIsNotNull() {
            addCriterion("after_status is not null");
            return (Criteria) this;
        }

        public Criteria andAfterStatusEqualTo(Byte value) {
            addCriterion("after_status =", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusNotEqualTo(Byte value) {
            addCriterion("after_status <>", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusGreaterThan(Byte value) {
            addCriterion("after_status >", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("after_status >=", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusLessThan(Byte value) {
            addCriterion("after_status <", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusLessThanOrEqualTo(Byte value) {
            addCriterion("after_status <=", value, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusIn(List<Byte> values) {
            addCriterion("after_status in", values, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusNotIn(List<Byte> values) {
            addCriterion("after_status not in", values, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusBetween(Byte value1, Byte value2) {
            addCriterion("after_status between", value1, value2, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAfterStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("after_status not between", value1, value2, "afterStatus");
            return (Criteria) this;
        }

        public Criteria andAssetGradeIsNull() {
            addCriterion("asset_grade is null");
            return (Criteria) this;
        }

        public Criteria andAssetGradeIsNotNull() {
            addCriterion("asset_grade is not null");
            return (Criteria) this;
        }

        public Criteria andAssetGradeEqualTo(String value) {
            addCriterion("asset_grade =", value, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeNotEqualTo(String value) {
            addCriterion("asset_grade <>", value, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeGreaterThan(String value) {
            addCriterion("asset_grade >", value, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeGreaterThanOrEqualTo(String value) {
            addCriterion("asset_grade >=", value, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeLessThan(String value) {
            addCriterion("asset_grade <", value, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeLessThanOrEqualTo(String value) {
            addCriterion("asset_grade <=", value, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeLike(String value) {
            addCriterion("asset_grade like", value, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeNotLike(String value) {
            addCriterion("asset_grade not like", value, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeIn(List<String> values) {
            addCriterion("asset_grade in", values, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeNotIn(List<String> values) {
            addCriterion("asset_grade not in", values, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeBetween(String value1, String value2) {
            addCriterion("asset_grade between", value1, value2, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andAssetGradeNotBetween(String value1, String value2) {
            addCriterion("asset_grade not between", value1, value2, "assetGrade");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(String value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(String value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(String value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(String value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(String value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLike(String value) {
            addCriterion("company_id like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotLike(String value) {
            addCriterion("company_id not like", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<String> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<String> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(String value1, String value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(String value1, String value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andIsArchiveIsNull() {
            addCriterion("is_archive is null");
            return (Criteria) this;
        }

        public Criteria andIsArchiveIsNotNull() {
            addCriterion("is_archive is not null");
            return (Criteria) this;
        }

        public Criteria andIsArchiveEqualTo(Integer value) {
            addCriterion("is_archive =", value, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveNotEqualTo(Integer value) {
            addCriterion("is_archive <>", value, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveGreaterThan(Integer value) {
            addCriterion("is_archive >", value, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_archive >=", value, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveLessThan(Integer value) {
            addCriterion("is_archive <", value, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveLessThanOrEqualTo(Integer value) {
            addCriterion("is_archive <=", value, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveIn(List<Integer> values) {
            addCriterion("is_archive in", values, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveNotIn(List<Integer> values) {
            addCriterion("is_archive not in", values, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveBetween(Integer value1, Integer value2) {
            addCriterion("is_archive between", value1, value2, "isArchive");
            return (Criteria) this;
        }

        public Criteria andIsArchiveNotBetween(Integer value1, Integer value2) {
            addCriterion("is_archive not between", value1, value2, "isArchive");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridIsNull() {
            addCriterion("together_loan_userid is null");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridIsNotNull() {
            addCriterion("together_loan_userid is not null");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridEqualTo(String value) {
            addCriterion("together_loan_userid =", value, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridNotEqualTo(String value) {
            addCriterion("together_loan_userid <>", value, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridGreaterThan(String value) {
            addCriterion("together_loan_userid >", value, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridGreaterThanOrEqualTo(String value) {
            addCriterion("together_loan_userid >=", value, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridLessThan(String value) {
            addCriterion("together_loan_userid <", value, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridLessThanOrEqualTo(String value) {
            addCriterion("together_loan_userid <=", value, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridLike(String value) {
            addCriterion("together_loan_userid like", value, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridNotLike(String value) {
            addCriterion("together_loan_userid not like", value, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridIn(List<String> values) {
            addCriterion("together_loan_userid in", values, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridNotIn(List<String> values) {
            addCriterion("together_loan_userid not in", values, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridBetween(String value1, String value2) {
            addCriterion("together_loan_userid between", value1, value2, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTogetherLoanUseridNotBetween(String value1, String value2) {
            addCriterion("together_loan_userid not between", value1, value2, "togetherLoanUserid");
            return (Criteria) this;
        }

        public Criteria andTransactionNoIsNull() {
            addCriterion("transaction_no is null");
            return (Criteria) this;
        }

        public Criteria andTransactionNoIsNotNull() {
            addCriterion("transaction_no is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionNoEqualTo(String value) {
            addCriterion("transaction_no =", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotEqualTo(String value) {
            addCriterion("transaction_no <>", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoGreaterThan(String value) {
            addCriterion("transaction_no >", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_no >=", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLessThan(String value) {
            addCriterion("transaction_no <", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLessThanOrEqualTo(String value) {
            addCriterion("transaction_no <=", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoLike(String value) {
            addCriterion("transaction_no like", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotLike(String value) {
            addCriterion("transaction_no not like", value, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoIn(List<String> values) {
            addCriterion("transaction_no in", values, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotIn(List<String> values) {
            addCriterion("transaction_no not in", values, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoBetween(String value1, String value2) {
            addCriterion("transaction_no between", value1, value2, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andTransactionNoNotBetween(String value1, String value2) {
            addCriterion("transaction_no not between", value1, value2, "transactionNo");
            return (Criteria) this;
        }

        public Criteria andFixRateIsNull() {
            addCriterion("fix_rate is null");
            return (Criteria) this;
        }

        public Criteria andFixRateIsNotNull() {
            addCriterion("fix_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFixRateEqualTo(String value) {
            addCriterion("fix_rate =", value, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateNotEqualTo(String value) {
            addCriterion("fix_rate <>", value, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateGreaterThan(String value) {
            addCriterion("fix_rate >", value, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateGreaterThanOrEqualTo(String value) {
            addCriterion("fix_rate >=", value, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateLessThan(String value) {
            addCriterion("fix_rate <", value, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateLessThanOrEqualTo(String value) {
            addCriterion("fix_rate <=", value, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateLike(String value) {
            addCriterion("fix_rate like", value, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateNotLike(String value) {
            addCriterion("fix_rate not like", value, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateIn(List<String> values) {
            addCriterion("fix_rate in", values, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateNotIn(List<String> values) {
            addCriterion("fix_rate not in", values, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateBetween(String value1, String value2) {
            addCriterion("fix_rate between", value1, value2, "fixRate");
            return (Criteria) this;
        }

        public Criteria andFixRateNotBetween(String value1, String value2) {
            addCriterion("fix_rate not between", value1, value2, "fixRate");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeIsNull() {
            addCriterion("assets_code is null");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeIsNotNull() {
            addCriterion("assets_code is not null");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeEqualTo(String value) {
            addCriterion("assets_code =", value, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeNotEqualTo(String value) {
            addCriterion("assets_code <>", value, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeGreaterThan(String value) {
            addCriterion("assets_code >", value, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("assets_code >=", value, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeLessThan(String value) {
            addCriterion("assets_code <", value, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeLessThanOrEqualTo(String value) {
            addCriterion("assets_code <=", value, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeLike(String value) {
            addCriterion("assets_code like", value, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeNotLike(String value) {
            addCriterion("assets_code not like", value, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeIn(List<String> values) {
            addCriterion("assets_code in", values, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeNotIn(List<String> values) {
            addCriterion("assets_code not in", values, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeBetween(String value1, String value2) {
            addCriterion("assets_code between", value1, value2, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andAssetsCodeNotBetween(String value1, String value2) {
            addCriterion("assets_code not between", value1, value2, "assetsCode");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlIsNull() {
            addCriterion("diduction_callback_url is null");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlIsNotNull() {
            addCriterion("diduction_callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlEqualTo(String value) {
            addCriterion("diduction_callback_url =", value, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlNotEqualTo(String value) {
            addCriterion("diduction_callback_url <>", value, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlGreaterThan(String value) {
            addCriterion("diduction_callback_url >", value, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("diduction_callback_url >=", value, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlLessThan(String value) {
            addCriterion("diduction_callback_url <", value, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("diduction_callback_url <=", value, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlLike(String value) {
            addCriterion("diduction_callback_url like", value, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlNotLike(String value) {
            addCriterion("diduction_callback_url not like", value, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlIn(List<String> values) {
            addCriterion("diduction_callback_url in", values, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlNotIn(List<String> values) {
            addCriterion("diduction_callback_url not in", values, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlBetween(String value1, String value2) {
            addCriterion("diduction_callback_url between", value1, value2, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andDiductionCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("diduction_callback_url not between", value1, value2, "diductionCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIsNull() {
            addCriterion("project_amount is null");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIsNotNull() {
            addCriterion("project_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAmountEqualTo(BigDecimal value) {
            addCriterion("project_amount =", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotEqualTo(BigDecimal value) {
            addCriterion("project_amount <>", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountGreaterThan(BigDecimal value) {
            addCriterion("project_amount >", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("project_amount >=", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountLessThan(BigDecimal value) {
            addCriterion("project_amount <", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("project_amount <=", value, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountIn(List<BigDecimal> values) {
            addCriterion("project_amount in", values, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotIn(List<BigDecimal> values) {
            addCriterion("project_amount not in", values, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_amount between", value1, value2, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andProjectAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("project_amount not between", value1, value2, "projectAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountIsNull() {
            addCriterion("first_amount is null");
            return (Criteria) this;
        }

        public Criteria andFirstAmountIsNotNull() {
            addCriterion("first_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFirstAmountEqualTo(BigDecimal value) {
            addCriterion("first_amount =", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountNotEqualTo(BigDecimal value) {
            addCriterion("first_amount <>", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountGreaterThan(BigDecimal value) {
            addCriterion("first_amount >", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_amount >=", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountLessThan(BigDecimal value) {
            addCriterion("first_amount <", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_amount <=", value, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountIn(List<BigDecimal> values) {
            addCriterion("first_amount in", values, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountNotIn(List<BigDecimal> values) {
            addCriterion("first_amount not in", values, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_amount between", value1, value2, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andFirstAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_amount not between", value1, value2, "firstAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountIsNull() {
            addCriterion("middle_amount is null");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountIsNotNull() {
            addCriterion("middle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountEqualTo(BigDecimal value) {
            addCriterion("middle_amount =", value, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountNotEqualTo(BigDecimal value) {
            addCriterion("middle_amount <>", value, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountGreaterThan(BigDecimal value) {
            addCriterion("middle_amount >", value, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("middle_amount >=", value, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountLessThan(BigDecimal value) {
            addCriterion("middle_amount <", value, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("middle_amount <=", value, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountIn(List<BigDecimal> values) {
            addCriterion("middle_amount in", values, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountNotIn(List<BigDecimal> values) {
            addCriterion("middle_amount not in", values, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("middle_amount between", value1, value2, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andMiddleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("middle_amount not between", value1, value2, "middleAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNull() {
            addCriterion("actual_amount is null");
            return (Criteria) this;
        }

        public Criteria andActualAmountIsNotNull() {
            addCriterion("actual_amount is not null");
            return (Criteria) this;
        }

        public Criteria andActualAmountEqualTo(BigDecimal value) {
            addCriterion("actual_amount =", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotEqualTo(BigDecimal value) {
            addCriterion("actual_amount <>", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThan(BigDecimal value) {
            addCriterion("actual_amount >", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_amount >=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThan(BigDecimal value) {
            addCriterion("actual_amount <", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("actual_amount <=", value, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountIn(List<BigDecimal> values) {
            addCriterion("actual_amount in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotIn(List<BigDecimal> values) {
            addCriterion("actual_amount not in", values, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_amount between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andActualAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("actual_amount not between", value1, value2, "actualAmount");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedIsNull() {
            addCriterion("is_company_payed is null");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedIsNotNull() {
            addCriterion("is_company_payed is not null");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedEqualTo(Boolean value) {
            addCriterion("is_company_payed =", value, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedNotEqualTo(Boolean value) {
            addCriterion("is_company_payed <>", value, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedGreaterThan(Boolean value) {
            addCriterion("is_company_payed >", value, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_company_payed >=", value, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedLessThan(Boolean value) {
            addCriterion("is_company_payed <", value, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_company_payed <=", value, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedIn(List<Boolean> values) {
            addCriterion("is_company_payed in", values, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedNotIn(List<Boolean> values) {
            addCriterion("is_company_payed not in", values, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_company_payed between", value1, value2, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCompanyPayedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_company_payed not between", value1, value2, "isCompanyPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedIsNull() {
            addCriterion("is_capital_channel_payed is null");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedIsNotNull() {
            addCriterion("is_capital_channel_payed is not null");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedEqualTo(Boolean value) {
            addCriterion("is_capital_channel_payed =", value, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedNotEqualTo(Boolean value) {
            addCriterion("is_capital_channel_payed <>", value, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedGreaterThan(Boolean value) {
            addCriterion("is_capital_channel_payed >", value, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_capital_channel_payed >=", value, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedLessThan(Boolean value) {
            addCriterion("is_capital_channel_payed <", value, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_capital_channel_payed <=", value, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedIn(List<Boolean> values) {
            addCriterion("is_capital_channel_payed in", values, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedNotIn(List<Boolean> values) {
            addCriterion("is_capital_channel_payed not in", values, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_capital_channel_payed between", value1, value2, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andIsCapitalChannelPayedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_capital_channel_payed not between", value1, value2, "isCapitalChannelPayed");
            return (Criteria) this;
        }

        public Criteria andTotalRatingIsNull() {
            addCriterion("total_rating is null");
            return (Criteria) this;
        }

        public Criteria andTotalRatingIsNotNull() {
            addCriterion("total_rating is not null");
            return (Criteria) this;
        }

        public Criteria andTotalRatingEqualTo(String value) {
            addCriterion("total_rating =", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingNotEqualTo(String value) {
            addCriterion("total_rating <>", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingGreaterThan(String value) {
            addCriterion("total_rating >", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingGreaterThanOrEqualTo(String value) {
            addCriterion("total_rating >=", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingLessThan(String value) {
            addCriterion("total_rating <", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingLessThanOrEqualTo(String value) {
            addCriterion("total_rating <=", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingLike(String value) {
            addCriterion("total_rating like", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingNotLike(String value) {
            addCriterion("total_rating not like", value, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingIn(List<String> values) {
            addCriterion("total_rating in", values, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingNotIn(List<String> values) {
            addCriterion("total_rating not in", values, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingBetween(String value1, String value2) {
            addCriterion("total_rating between", value1, value2, "totalRating");
            return (Criteria) this;
        }

        public Criteria andTotalRatingNotBetween(String value1, String value2) {
            addCriterion("total_rating not between", value1, value2, "totalRating");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andContractRateIsNull() {
            addCriterion("contract_rate is null");
            return (Criteria) this;
        }

        public Criteria andContractRateIsNotNull() {
            addCriterion("contract_rate is not null");
            return (Criteria) this;
        }

        public Criteria andContractRateEqualTo(String value) {
            addCriterion("contract_rate =", value, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateNotEqualTo(String value) {
            addCriterion("contract_rate <>", value, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateGreaterThan(String value) {
            addCriterion("contract_rate >", value, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateGreaterThanOrEqualTo(String value) {
            addCriterion("contract_rate >=", value, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateLessThan(String value) {
            addCriterion("contract_rate <", value, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateLessThanOrEqualTo(String value) {
            addCriterion("contract_rate <=", value, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateLike(String value) {
            addCriterion("contract_rate like", value, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateNotLike(String value) {
            addCriterion("contract_rate not like", value, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateIn(List<String> values) {
            addCriterion("contract_rate in", values, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateNotIn(List<String> values) {
            addCriterion("contract_rate not in", values, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateBetween(String value1, String value2) {
            addCriterion("contract_rate between", value1, value2, "contractRate");
            return (Criteria) this;
        }

        public Criteria andContractRateNotBetween(String value1, String value2) {
            addCriterion("contract_rate not between", value1, value2, "contractRate");
            return (Criteria) this;
        }

        public Criteria andTdReportIdIsNull() {
            addCriterion("td_report_id is null");
            return (Criteria) this;
        }

        public Criteria andTdReportIdIsNotNull() {
            addCriterion("td_report_id is not null");
            return (Criteria) this;
        }

        public Criteria andTdReportIdEqualTo(String value) {
            addCriterion("td_report_id =", value, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdNotEqualTo(String value) {
            addCriterion("td_report_id <>", value, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdGreaterThan(String value) {
            addCriterion("td_report_id >", value, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdGreaterThanOrEqualTo(String value) {
            addCriterion("td_report_id >=", value, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdLessThan(String value) {
            addCriterion("td_report_id <", value, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdLessThanOrEqualTo(String value) {
            addCriterion("td_report_id <=", value, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdLike(String value) {
            addCriterion("td_report_id like", value, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdNotLike(String value) {
            addCriterion("td_report_id not like", value, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdIn(List<String> values) {
            addCriterion("td_report_id in", values, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdNotIn(List<String> values) {
            addCriterion("td_report_id not in", values, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdBetween(String value1, String value2) {
            addCriterion("td_report_id between", value1, value2, "tdReportId");
            return (Criteria) this;
        }

        public Criteria andTdReportIdNotBetween(String value1, String value2) {
            addCriterion("td_report_id not between", value1, value2, "tdReportId");
            return (Criteria) this;
        }
    }

    /**
     * nj_loan_order
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_loan_order 2019-04-02
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