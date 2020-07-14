package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjNaturalerCreditCompanyExample {
    /**
     * nj_naturaler_credit_company
     */
    protected String orderByClause;

    /**
     * nj_naturaler_credit_company
     */
    protected boolean distinct;

    /**
     * nj_naturaler_credit_company
     */
    protected List<Criteria> oredCriteria;

    public NjNaturalerCreditCompanyExample() {
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
     * nj_naturaler_credit_company 2019-06-19
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(String value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(String value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(String value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(String value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(String value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(String value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLike(String value) {
            addCriterion("order_id like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotLike(String value) {
            addCriterion("order_id not like", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<String> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<String> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(String value1, String value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(String value1, String value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andXykzhsIsNull() {
            addCriterion("xykzhs is null");
            return (Criteria) this;
        }

        public Criteria andXykzhsIsNotNull() {
            addCriterion("xykzhs is not null");
            return (Criteria) this;
        }

        public Criteria andXykzhsEqualTo(String value) {
            addCriterion("xykzhs =", value, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsNotEqualTo(String value) {
            addCriterion("xykzhs <>", value, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsGreaterThan(String value) {
            addCriterion("xykzhs >", value, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsGreaterThanOrEqualTo(String value) {
            addCriterion("xykzhs >=", value, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsLessThan(String value) {
            addCriterion("xykzhs <", value, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsLessThanOrEqualTo(String value) {
            addCriterion("xykzhs <=", value, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsLike(String value) {
            addCriterion("xykzhs like", value, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsNotLike(String value) {
            addCriterion("xykzhs not like", value, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsIn(List<String> values) {
            addCriterion("xykzhs in", values, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsNotIn(List<String> values) {
            addCriterion("xykzhs not in", values, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsBetween(String value1, String value2) {
            addCriterion("xykzhs between", value1, value2, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykzhsNotBetween(String value1, String value2) {
            addCriterion("xykzhs not between", value1, value2, "xykzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsIsNull() {
            addCriterion("xykwjqwxhzhs is null");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsIsNotNull() {
            addCriterion("xykwjqwxhzhs is not null");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsEqualTo(String value) {
            addCriterion("xykwjqwxhzhs =", value, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsNotEqualTo(String value) {
            addCriterion("xykwjqwxhzhs <>", value, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsGreaterThan(String value) {
            addCriterion("xykwjqwxhzhs >", value, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsGreaterThanOrEqualTo(String value) {
            addCriterion("xykwjqwxhzhs >=", value, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsLessThan(String value) {
            addCriterion("xykwjqwxhzhs <", value, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsLessThanOrEqualTo(String value) {
            addCriterion("xykwjqwxhzhs <=", value, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsLike(String value) {
            addCriterion("xykwjqwxhzhs like", value, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsNotLike(String value) {
            addCriterion("xykwjqwxhzhs not like", value, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsIn(List<String> values) {
            addCriterion("xykwjqwxhzhs in", values, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsNotIn(List<String> values) {
            addCriterion("xykwjqwxhzhs not in", values, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsBetween(String value1, String value2) {
            addCriterion("xykwjqwxhzhs between", value1, value2, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykwjqwxhzhsNotBetween(String value1, String value2) {
            addCriterion("xykwjqwxhzhs not between", value1, value2, "xykwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsIsNull() {
            addCriterion("xykfsgyqzhs is null");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsIsNotNull() {
            addCriterion("xykfsgyqzhs is not null");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsEqualTo(String value) {
            addCriterion("xykfsgyqzhs =", value, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsNotEqualTo(String value) {
            addCriterion("xykfsgyqzhs <>", value, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsGreaterThan(String value) {
            addCriterion("xykfsgyqzhs >", value, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsGreaterThanOrEqualTo(String value) {
            addCriterion("xykfsgyqzhs >=", value, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsLessThan(String value) {
            addCriterion("xykfsgyqzhs <", value, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsLessThanOrEqualTo(String value) {
            addCriterion("xykfsgyqzhs <=", value, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsLike(String value) {
            addCriterion("xykfsgyqzhs like", value, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsNotLike(String value) {
            addCriterion("xykfsgyqzhs not like", value, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsIn(List<String> values) {
            addCriterion("xykfsgyqzhs in", values, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsNotIn(List<String> values) {
            addCriterion("xykfsgyqzhs not in", values, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsBetween(String value1, String value2) {
            addCriterion("xykfsgyqzhs between", value1, value2, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsgyqzhsNotBetween(String value1, String value2) {
            addCriterion("xykfsgyqzhs not between", value1, value2, "xykfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsIsNull() {
            addCriterion("xykfsg90tysyqdzhs is null");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsIsNotNull() {
            addCriterion("xykfsg90tysyqdzhs is not null");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsEqualTo(String value) {
            addCriterion("xykfsg90tysyqdzhs =", value, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsNotEqualTo(String value) {
            addCriterion("xykfsg90tysyqdzhs <>", value, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsGreaterThan(String value) {
            addCriterion("xykfsg90tysyqdzhs >", value, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsGreaterThanOrEqualTo(String value) {
            addCriterion("xykfsg90tysyqdzhs >=", value, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsLessThan(String value) {
            addCriterion("xykfsg90tysyqdzhs <", value, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsLessThanOrEqualTo(String value) {
            addCriterion("xykfsg90tysyqdzhs <=", value, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsLike(String value) {
            addCriterion("xykfsg90tysyqdzhs like", value, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsNotLike(String value) {
            addCriterion("xykfsg90tysyqdzhs not like", value, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsIn(List<String> values) {
            addCriterion("xykfsg90tysyqdzhs in", values, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsNotIn(List<String> values) {
            addCriterion("xykfsg90tysyqdzhs not in", values, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsBetween(String value1, String value2) {
            addCriterion("xykfsg90tysyqdzhs between", value1, value2, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andXykfsg90tysyqdzhsNotBetween(String value1, String value2) {
            addCriterion("xykfsg90tysyqdzhs not between", value1, value2, "xykfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsIsNull() {
            addCriterion("fdzhs is null");
            return (Criteria) this;
        }

        public Criteria andFdzhsIsNotNull() {
            addCriterion("fdzhs is not null");
            return (Criteria) this;
        }

        public Criteria andFdzhsEqualTo(String value) {
            addCriterion("fdzhs =", value, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsNotEqualTo(String value) {
            addCriterion("fdzhs <>", value, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsGreaterThan(String value) {
            addCriterion("fdzhs >", value, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsGreaterThanOrEqualTo(String value) {
            addCriterion("fdzhs >=", value, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsLessThan(String value) {
            addCriterion("fdzhs <", value, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsLessThanOrEqualTo(String value) {
            addCriterion("fdzhs <=", value, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsLike(String value) {
            addCriterion("fdzhs like", value, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsNotLike(String value) {
            addCriterion("fdzhs not like", value, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsIn(List<String> values) {
            addCriterion("fdzhs in", values, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsNotIn(List<String> values) {
            addCriterion("fdzhs not in", values, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsBetween(String value1, String value2) {
            addCriterion("fdzhs between", value1, value2, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdzhsNotBetween(String value1, String value2) {
            addCriterion("fdzhs not between", value1, value2, "fdzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsIsNull() {
            addCriterion("fdwjqwxhzhs is null");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsIsNotNull() {
            addCriterion("fdwjqwxhzhs is not null");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsEqualTo(String value) {
            addCriterion("fdwjqwxhzhs =", value, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsNotEqualTo(String value) {
            addCriterion("fdwjqwxhzhs <>", value, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsGreaterThan(String value) {
            addCriterion("fdwjqwxhzhs >", value, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsGreaterThanOrEqualTo(String value) {
            addCriterion("fdwjqwxhzhs >=", value, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsLessThan(String value) {
            addCriterion("fdwjqwxhzhs <", value, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsLessThanOrEqualTo(String value) {
            addCriterion("fdwjqwxhzhs <=", value, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsLike(String value) {
            addCriterion("fdwjqwxhzhs like", value, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsNotLike(String value) {
            addCriterion("fdwjqwxhzhs not like", value, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsIn(List<String> values) {
            addCriterion("fdwjqwxhzhs in", values, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsNotIn(List<String> values) {
            addCriterion("fdwjqwxhzhs not in", values, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsBetween(String value1, String value2) {
            addCriterion("fdwjqwxhzhs between", value1, value2, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdwjqwxhzhsNotBetween(String value1, String value2) {
            addCriterion("fdwjqwxhzhs not between", value1, value2, "fdwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsIsNull() {
            addCriterion("fdfsgyqzhs is null");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsIsNotNull() {
            addCriterion("fdfsgyqzhs is not null");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsEqualTo(String value) {
            addCriterion("fdfsgyqzhs =", value, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsNotEqualTo(String value) {
            addCriterion("fdfsgyqzhs <>", value, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsGreaterThan(String value) {
            addCriterion("fdfsgyqzhs >", value, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsGreaterThanOrEqualTo(String value) {
            addCriterion("fdfsgyqzhs >=", value, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsLessThan(String value) {
            addCriterion("fdfsgyqzhs <", value, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsLessThanOrEqualTo(String value) {
            addCriterion("fdfsgyqzhs <=", value, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsLike(String value) {
            addCriterion("fdfsgyqzhs like", value, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsNotLike(String value) {
            addCriterion("fdfsgyqzhs not like", value, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsIn(List<String> values) {
            addCriterion("fdfsgyqzhs in", values, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsNotIn(List<String> values) {
            addCriterion("fdfsgyqzhs not in", values, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsBetween(String value1, String value2) {
            addCriterion("fdfsgyqzhs between", value1, value2, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsgyqzhsNotBetween(String value1, String value2) {
            addCriterion("fdfsgyqzhs not between", value1, value2, "fdfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsIsNull() {
            addCriterion("fdfsg90tysyqdzhs is null");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsIsNotNull() {
            addCriterion("fdfsg90tysyqdzhs is not null");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsEqualTo(String value) {
            addCriterion("fdfsg90tysyqdzhs =", value, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsNotEqualTo(String value) {
            addCriterion("fdfsg90tysyqdzhs <>", value, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsGreaterThan(String value) {
            addCriterion("fdfsg90tysyqdzhs >", value, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsGreaterThanOrEqualTo(String value) {
            addCriterion("fdfsg90tysyqdzhs >=", value, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsLessThan(String value) {
            addCriterion("fdfsg90tysyqdzhs <", value, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsLessThanOrEqualTo(String value) {
            addCriterion("fdfsg90tysyqdzhs <=", value, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsLike(String value) {
            addCriterion("fdfsg90tysyqdzhs like", value, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsNotLike(String value) {
            addCriterion("fdfsg90tysyqdzhs not like", value, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsIn(List<String> values) {
            addCriterion("fdfsg90tysyqdzhs in", values, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsNotIn(List<String> values) {
            addCriterion("fdfsg90tysyqdzhs not in", values, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsBetween(String value1, String value2) {
            addCriterion("fdfsg90tysyqdzhs between", value1, value2, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andFdfsg90tysyqdzhsNotBetween(String value1, String value2) {
            addCriterion("fdfsg90tysyqdzhs not between", value1, value2, "fdfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsIsNull() {
            addCriterion("qtdkzhs is null");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsIsNotNull() {
            addCriterion("qtdkzhs is not null");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsEqualTo(String value) {
            addCriterion("qtdkzhs =", value, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsNotEqualTo(String value) {
            addCriterion("qtdkzhs <>", value, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsGreaterThan(String value) {
            addCriterion("qtdkzhs >", value, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsGreaterThanOrEqualTo(String value) {
            addCriterion("qtdkzhs >=", value, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsLessThan(String value) {
            addCriterion("qtdkzhs <", value, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsLessThanOrEqualTo(String value) {
            addCriterion("qtdkzhs <=", value, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsLike(String value) {
            addCriterion("qtdkzhs like", value, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsNotLike(String value) {
            addCriterion("qtdkzhs not like", value, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsIn(List<String> values) {
            addCriterion("qtdkzhs in", values, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsNotIn(List<String> values) {
            addCriterion("qtdkzhs not in", values, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsBetween(String value1, String value2) {
            addCriterion("qtdkzhs between", value1, value2, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkzhsNotBetween(String value1, String value2) {
            addCriterion("qtdkzhs not between", value1, value2, "qtdkzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsIsNull() {
            addCriterion("qtdkwjqwxhzhs is null");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsIsNotNull() {
            addCriterion("qtdkwjqwxhzhs is not null");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsEqualTo(String value) {
            addCriterion("qtdkwjqwxhzhs =", value, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsNotEqualTo(String value) {
            addCriterion("qtdkwjqwxhzhs <>", value, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsGreaterThan(String value) {
            addCriterion("qtdkwjqwxhzhs >", value, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsGreaterThanOrEqualTo(String value) {
            addCriterion("qtdkwjqwxhzhs >=", value, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsLessThan(String value) {
            addCriterion("qtdkwjqwxhzhs <", value, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsLessThanOrEqualTo(String value) {
            addCriterion("qtdkwjqwxhzhs <=", value, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsLike(String value) {
            addCriterion("qtdkwjqwxhzhs like", value, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsNotLike(String value) {
            addCriterion("qtdkwjqwxhzhs not like", value, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsIn(List<String> values) {
            addCriterion("qtdkwjqwxhzhs in", values, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsNotIn(List<String> values) {
            addCriterion("qtdkwjqwxhzhs not in", values, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsBetween(String value1, String value2) {
            addCriterion("qtdkwjqwxhzhs between", value1, value2, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkwjqwxhzhsNotBetween(String value1, String value2) {
            addCriterion("qtdkwjqwxhzhs not between", value1, value2, "qtdkwjqwxhzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsIsNull() {
            addCriterion("qtdkfsgyqzhs is null");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsIsNotNull() {
            addCriterion("qtdkfsgyqzhs is not null");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsEqualTo(String value) {
            addCriterion("qtdkfsgyqzhs =", value, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsNotEqualTo(String value) {
            addCriterion("qtdkfsgyqzhs <>", value, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsGreaterThan(String value) {
            addCriterion("qtdkfsgyqzhs >", value, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsGreaterThanOrEqualTo(String value) {
            addCriterion("qtdkfsgyqzhs >=", value, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsLessThan(String value) {
            addCriterion("qtdkfsgyqzhs <", value, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsLessThanOrEqualTo(String value) {
            addCriterion("qtdkfsgyqzhs <=", value, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsLike(String value) {
            addCriterion("qtdkfsgyqzhs like", value, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsNotLike(String value) {
            addCriterion("qtdkfsgyqzhs not like", value, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsIn(List<String> values) {
            addCriterion("qtdkfsgyqzhs in", values, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsNotIn(List<String> values) {
            addCriterion("qtdkfsgyqzhs not in", values, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsBetween(String value1, String value2) {
            addCriterion("qtdkfsgyqzhs between", value1, value2, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsgyqzhsNotBetween(String value1, String value2) {
            addCriterion("qtdkfsgyqzhs not between", value1, value2, "qtdkfsgyqzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsIsNull() {
            addCriterion("qtdkfsg90tysyqdzhs is null");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsIsNotNull() {
            addCriterion("qtdkfsg90tysyqdzhs is not null");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsEqualTo(String value) {
            addCriterion("qtdkfsg90tysyqdzhs =", value, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsNotEqualTo(String value) {
            addCriterion("qtdkfsg90tysyqdzhs <>", value, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsGreaterThan(String value) {
            addCriterion("qtdkfsg90tysyqdzhs >", value, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsGreaterThanOrEqualTo(String value) {
            addCriterion("qtdkfsg90tysyqdzhs >=", value, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsLessThan(String value) {
            addCriterion("qtdkfsg90tysyqdzhs <", value, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsLessThanOrEqualTo(String value) {
            addCriterion("qtdkfsg90tysyqdzhs <=", value, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsLike(String value) {
            addCriterion("qtdkfsg90tysyqdzhs like", value, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsNotLike(String value) {
            addCriterion("qtdkfsg90tysyqdzhs not like", value, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsIn(List<String> values) {
            addCriterion("qtdkfsg90tysyqdzhs in", values, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsNotIn(List<String> values) {
            addCriterion("qtdkfsg90tysyqdzhs not in", values, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsBetween(String value1, String value2) {
            addCriterion("qtdkfsg90tysyqdzhs between", value1, value2, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andQtdkfsg90tysyqdzhsNotBetween(String value1, String value2) {
            addCriterion("qtdkfsg90tysyqdzhs not between", value1, value2, "qtdkfsg90tysyqdzhs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsIsNull() {
            addCriterion("j3gygrcxcs is null");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsIsNotNull() {
            addCriterion("j3gygrcxcs is not null");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsEqualTo(String value) {
            addCriterion("j3gygrcxcs =", value, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsNotEqualTo(String value) {
            addCriterion("j3gygrcxcs <>", value, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsGreaterThan(String value) {
            addCriterion("j3gygrcxcs >", value, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsGreaterThanOrEqualTo(String value) {
            addCriterion("j3gygrcxcs >=", value, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsLessThan(String value) {
            addCriterion("j3gygrcxcs <", value, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsLessThanOrEqualTo(String value) {
            addCriterion("j3gygrcxcs <=", value, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsLike(String value) {
            addCriterion("j3gygrcxcs like", value, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsNotLike(String value) {
            addCriterion("j3gygrcxcs not like", value, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsIn(List<String> values) {
            addCriterion("j3gygrcxcs in", values, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsNotIn(List<String> values) {
            addCriterion("j3gygrcxcs not in", values, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsBetween(String value1, String value2) {
            addCriterion("j3gygrcxcs between", value1, value2, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gygrcxcsNotBetween(String value1, String value2) {
            addCriterion("j3gygrcxcs not between", value1, value2, "j3gygrcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsIsNull() {
            addCriterion("j3gyjgcxcs is null");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsIsNotNull() {
            addCriterion("j3gyjgcxcs is not null");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsEqualTo(String value) {
            addCriterion("j3gyjgcxcs =", value, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsNotEqualTo(String value) {
            addCriterion("j3gyjgcxcs <>", value, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsGreaterThan(String value) {
            addCriterion("j3gyjgcxcs >", value, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsGreaterThanOrEqualTo(String value) {
            addCriterion("j3gyjgcxcs >=", value, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsLessThan(String value) {
            addCriterion("j3gyjgcxcs <", value, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsLessThanOrEqualTo(String value) {
            addCriterion("j3gyjgcxcs <=", value, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsLike(String value) {
            addCriterion("j3gyjgcxcs like", value, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsNotLike(String value) {
            addCriterion("j3gyjgcxcs not like", value, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsIn(List<String> values) {
            addCriterion("j3gyjgcxcs in", values, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsNotIn(List<String> values) {
            addCriterion("j3gyjgcxcs not in", values, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsBetween(String value1, String value2) {
            addCriterion("j3gyjgcxcs between", value1, value2, "j3gyjgcxcs");
            return (Criteria) this;
        }

        public Criteria andJ3gyjgcxcsNotBetween(String value1, String value2) {
            addCriterion("j3gyjgcxcs not between", value1, value2, "j3gyjgcxcs");
            return (Criteria) this;
        }
    }

    /**
     * nj_naturaler_credit_company
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_naturaler_credit_company 2019-06-19
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