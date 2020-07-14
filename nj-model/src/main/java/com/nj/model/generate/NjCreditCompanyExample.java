package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjCreditCompanyExample {
    /**
     * nj_credit_company
     */
    protected String orderByClause;

    /**
     * nj_credit_company
     */
    protected boolean distinct;

    /**
     * nj_credit_company
     */
    protected List<Criteria> oredCriteria;

    public NjCreditCompanyExample() {
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
     * nj_credit_company 2019-06-19
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

        public Criteria andLsxdjgsIsNull() {
            addCriterion("lsxdjgs is null");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsIsNotNull() {
            addCriterion("lsxdjgs is not null");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsEqualTo(String value) {
            addCriterion("lsxdjgs =", value, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsNotEqualTo(String value) {
            addCriterion("lsxdjgs <>", value, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsGreaterThan(String value) {
            addCriterion("lsxdjgs >", value, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsGreaterThanOrEqualTo(String value) {
            addCriterion("lsxdjgs >=", value, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsLessThan(String value) {
            addCriterion("lsxdjgs <", value, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsLessThanOrEqualTo(String value) {
            addCriterion("lsxdjgs <=", value, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsLike(String value) {
            addCriterion("lsxdjgs like", value, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsNotLike(String value) {
            addCriterion("lsxdjgs not like", value, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsIn(List<String> values) {
            addCriterion("lsxdjgs in", values, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsNotIn(List<String> values) {
            addCriterion("lsxdjgs not in", values, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsBetween(String value1, String value2) {
            addCriterion("lsxdjgs between", value1, value2, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andLsxdjgsNotBetween(String value1, String value2) {
            addCriterion("lsxdjgs not between", value1, value2, "lsxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsIsNull() {
            addCriterion("dqwjqxdjgs is null");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsIsNotNull() {
            addCriterion("dqwjqxdjgs is not null");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsEqualTo(String value) {
            addCriterion("dqwjqxdjgs =", value, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsNotEqualTo(String value) {
            addCriterion("dqwjqxdjgs <>", value, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsGreaterThan(String value) {
            addCriterion("dqwjqxdjgs >", value, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsGreaterThanOrEqualTo(String value) {
            addCriterion("dqwjqxdjgs >=", value, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsLessThan(String value) {
            addCriterion("dqwjqxdjgs <", value, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsLessThanOrEqualTo(String value) {
            addCriterion("dqwjqxdjgs <=", value, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsLike(String value) {
            addCriterion("dqwjqxdjgs like", value, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsNotLike(String value) {
            addCriterion("dqwjqxdjgs not like", value, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsIn(List<String> values) {
            addCriterion("dqwjqxdjgs in", values, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsNotIn(List<String> values) {
            addCriterion("dqwjqxdjgs not in", values, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsBetween(String value1, String value2) {
            addCriterion("dqwjqxdjgs between", value1, value2, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andDqwjqxdjgsNotBetween(String value1, String value2) {
            addCriterion("dqwjqxdjgs not between", value1, value2, "dqwjqxdjgs");
            return (Criteria) this;
        }

        public Criteria andQsjlsIsNull() {
            addCriterion("qsjls is null");
            return (Criteria) this;
        }

        public Criteria andQsjlsIsNotNull() {
            addCriterion("qsjls is not null");
            return (Criteria) this;
        }

        public Criteria andQsjlsEqualTo(String value) {
            addCriterion("qsjls =", value, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsNotEqualTo(String value) {
            addCriterion("qsjls <>", value, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsGreaterThan(String value) {
            addCriterion("qsjls >", value, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsGreaterThanOrEqualTo(String value) {
            addCriterion("qsjls >=", value, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsLessThan(String value) {
            addCriterion("qsjls <", value, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsLessThanOrEqualTo(String value) {
            addCriterion("qsjls <=", value, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsLike(String value) {
            addCriterion("qsjls like", value, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsNotLike(String value) {
            addCriterion("qsjls not like", value, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsIn(List<String> values) {
            addCriterion("qsjls in", values, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsNotIn(List<String> values) {
            addCriterion("qsjls not in", values, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsBetween(String value1, String value2) {
            addCriterion("qsjls between", value1, value2, "qsjls");
            return (Criteria) this;
        }

        public Criteria andQsjlsNotBetween(String value1, String value2) {
            addCriterion("qsjls not between", value1, value2, "qsjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsIsNull() {
            addCriterion("mspdjls is null");
            return (Criteria) this;
        }

        public Criteria andMspdjlsIsNotNull() {
            addCriterion("mspdjls is not null");
            return (Criteria) this;
        }

        public Criteria andMspdjlsEqualTo(String value) {
            addCriterion("mspdjls =", value, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsNotEqualTo(String value) {
            addCriterion("mspdjls <>", value, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsGreaterThan(String value) {
            addCriterion("mspdjls >", value, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsGreaterThanOrEqualTo(String value) {
            addCriterion("mspdjls >=", value, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsLessThan(String value) {
            addCriterion("mspdjls <", value, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsLessThanOrEqualTo(String value) {
            addCriterion("mspdjls <=", value, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsLike(String value) {
            addCriterion("mspdjls like", value, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsNotLike(String value) {
            addCriterion("mspdjls not like", value, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsIn(List<String> values) {
            addCriterion("mspdjls in", values, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsNotIn(List<String> values) {
            addCriterion("mspdjls not in", values, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsBetween(String value1, String value2) {
            addCriterion("mspdjls between", value1, value2, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andMspdjlsNotBetween(String value1, String value2) {
            addCriterion("mspdjls not between", value1, value2, "mspdjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsIsNull() {
            addCriterion("qzzxjls is null");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsIsNotNull() {
            addCriterion("qzzxjls is not null");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsEqualTo(String value) {
            addCriterion("qzzxjls =", value, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsNotEqualTo(String value) {
            addCriterion("qzzxjls <>", value, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsGreaterThan(String value) {
            addCriterion("qzzxjls >", value, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsGreaterThanOrEqualTo(String value) {
            addCriterion("qzzxjls >=", value, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsLessThan(String value) {
            addCriterion("qzzxjls <", value, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsLessThanOrEqualTo(String value) {
            addCriterion("qzzxjls <=", value, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsLike(String value) {
            addCriterion("qzzxjls like", value, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsNotLike(String value) {
            addCriterion("qzzxjls not like", value, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsIn(List<String> values) {
            addCriterion("qzzxjls in", values, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsNotIn(List<String> values) {
            addCriterion("qzzxjls not in", values, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsBetween(String value1, String value2) {
            addCriterion("qzzxjls between", value1, value2, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andQzzxjlsNotBetween(String value1, String value2) {
            addCriterion("qzzxjls not between", value1, value2, "qzzxjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsIsNull() {
            addCriterion("xzcfjls is null");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsIsNotNull() {
            addCriterion("xzcfjls is not null");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsEqualTo(String value) {
            addCriterion("xzcfjls =", value, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsNotEqualTo(String value) {
            addCriterion("xzcfjls <>", value, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsGreaterThan(String value) {
            addCriterion("xzcfjls >", value, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsGreaterThanOrEqualTo(String value) {
            addCriterion("xzcfjls >=", value, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsLessThan(String value) {
            addCriterion("xzcfjls <", value, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsLessThanOrEqualTo(String value) {
            addCriterion("xzcfjls <=", value, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsLike(String value) {
            addCriterion("xzcfjls like", value, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsNotLike(String value) {
            addCriterion("xzcfjls not like", value, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsIn(List<String> values) {
            addCriterion("xzcfjls in", values, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsNotIn(List<String> values) {
            addCriterion("xzcfjls not in", values, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsBetween(String value1, String value2) {
            addCriterion("xzcfjls between", value1, value2, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andXzcfjlsNotBetween(String value1, String value2) {
            addCriterion("xzcfjls not between", value1, value2, "xzcfjls");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsIsNull() {
            addCriterion("dqyzwgsczdzwbs is null");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsIsNotNull() {
            addCriterion("dqyzwgsczdzwbs is not null");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsEqualTo(String value) {
            addCriterion("dqyzwgsczdzwbs =", value, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsNotEqualTo(String value) {
            addCriterion("dqyzwgsczdzwbs <>", value, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsGreaterThan(String value) {
            addCriterion("dqyzwgsczdzwbs >", value, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsGreaterThanOrEqualTo(String value) {
            addCriterion("dqyzwgsczdzwbs >=", value, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsLessThan(String value) {
            addCriterion("dqyzwgsczdzwbs <", value, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsLessThanOrEqualTo(String value) {
            addCriterion("dqyzwgsczdzwbs <=", value, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsLike(String value) {
            addCriterion("dqyzwgsczdzwbs like", value, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsNotLike(String value) {
            addCriterion("dqyzwgsczdzwbs not like", value, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsIn(List<String> values) {
            addCriterion("dqyzwgsczdzwbs in", values, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsNotIn(List<String> values) {
            addCriterion("dqyzwgsczdzwbs not in", values, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsBetween(String value1, String value2) {
            addCriterion("dqyzwgsczdzwbs between", value1, value2, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwbsNotBetween(String value1, String value2) {
            addCriterion("dqyzwgsczdzwbs not between", value1, value2, "dqyzwgsczdzwbs");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeIsNull() {
            addCriterion("dqyzwgsczdzwye is null");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeIsNotNull() {
            addCriterion("dqyzwgsczdzwye is not null");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeEqualTo(String value) {
            addCriterion("dqyzwgsczdzwye =", value, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeNotEqualTo(String value) {
            addCriterion("dqyzwgsczdzwye <>", value, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeGreaterThan(String value) {
            addCriterion("dqyzwgsczdzwye >", value, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeGreaterThanOrEqualTo(String value) {
            addCriterion("dqyzwgsczdzwye >=", value, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeLessThan(String value) {
            addCriterion("dqyzwgsczdzwye <", value, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeLessThanOrEqualTo(String value) {
            addCriterion("dqyzwgsczdzwye <=", value, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeLike(String value) {
            addCriterion("dqyzwgsczdzwye like", value, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeNotLike(String value) {
            addCriterion("dqyzwgsczdzwye not like", value, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeIn(List<String> values) {
            addCriterion("dqyzwgsczdzwye in", values, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeNotIn(List<String> values) {
            addCriterion("dqyzwgsczdzwye not in", values, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeBetween(String value1, String value2) {
            addCriterion("dqyzwgsczdzwye between", value1, value2, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwyeNotBetween(String value1, String value2) {
            addCriterion("dqyzwgsczdzwye not between", value1, value2, "dqyzwgsczdzwye");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxIsNull() {
            addCriterion("dqyzwgsczdzwlx is null");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxIsNotNull() {
            addCriterion("dqyzwgsczdzwlx is not null");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxEqualTo(String value) {
            addCriterion("dqyzwgsczdzwlx =", value, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxNotEqualTo(String value) {
            addCriterion("dqyzwgsczdzwlx <>", value, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxGreaterThan(String value) {
            addCriterion("dqyzwgsczdzwlx >", value, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxGreaterThanOrEqualTo(String value) {
            addCriterion("dqyzwgsczdzwlx >=", value, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxLessThan(String value) {
            addCriterion("dqyzwgsczdzwlx <", value, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxLessThanOrEqualTo(String value) {
            addCriterion("dqyzwgsczdzwlx <=", value, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxLike(String value) {
            addCriterion("dqyzwgsczdzwlx like", value, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxNotLike(String value) {
            addCriterion("dqyzwgsczdzwlx not like", value, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxIn(List<String> values) {
            addCriterion("dqyzwgsczdzwlx in", values, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxNotIn(List<String> values) {
            addCriterion("dqyzwgsczdzwlx not in", values, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxBetween(String value1, String value2) {
            addCriterion("dqyzwgsczdzwlx between", value1, value2, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwlxNotBetween(String value1, String value2) {
            addCriterion("dqyzwgsczdzwlx not between", value1, value2, "dqyzwgsczdzwlx");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkIsNull() {
            addCriterion("dqyzwgsczdzwdk is null");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkIsNotNull() {
            addCriterion("dqyzwgsczdzwdk is not null");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkEqualTo(String value) {
            addCriterion("dqyzwgsczdzwdk =", value, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkNotEqualTo(String value) {
            addCriterion("dqyzwgsczdzwdk <>", value, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkGreaterThan(String value) {
            addCriterion("dqyzwgsczdzwdk >", value, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkGreaterThanOrEqualTo(String value) {
            addCriterion("dqyzwgsczdzwdk >=", value, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkLessThan(String value) {
            addCriterion("dqyzwgsczdzwdk <", value, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkLessThanOrEqualTo(String value) {
            addCriterion("dqyzwgsczdzwdk <=", value, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkLike(String value) {
            addCriterion("dqyzwgsczdzwdk like", value, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkNotLike(String value) {
            addCriterion("dqyzwgsczdzwdk not like", value, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkIn(List<String> values) {
            addCriterion("dqyzwgsczdzwdk in", values, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkNotIn(List<String> values) {
            addCriterion("dqyzwgsczdzwdk not in", values, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkBetween(String value1, String value2) {
            addCriterion("dqyzwgsczdzwdk between", value1, value2, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqyzwgsczdzwdkNotBetween(String value1, String value2) {
            addCriterion("dqyzwgsczdzwdk not between", value1, value2, "dqyzwgsczdzwdk");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsIsNull() {
            addCriterion("dqxdywbs is null");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsIsNotNull() {
            addCriterion("dqxdywbs is not null");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsEqualTo(String value) {
            addCriterion("dqxdywbs =", value, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsNotEqualTo(String value) {
            addCriterion("dqxdywbs <>", value, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsGreaterThan(String value) {
            addCriterion("dqxdywbs >", value, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsGreaterThanOrEqualTo(String value) {
            addCriterion("dqxdywbs >=", value, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsLessThan(String value) {
            addCriterion("dqxdywbs <", value, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsLessThanOrEqualTo(String value) {
            addCriterion("dqxdywbs <=", value, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsLike(String value) {
            addCriterion("dqxdywbs like", value, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsNotLike(String value) {
            addCriterion("dqxdywbs not like", value, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsIn(List<String> values) {
            addCriterion("dqxdywbs in", values, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsNotIn(List<String> values) {
            addCriterion("dqxdywbs not in", values, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsBetween(String value1, String value2) {
            addCriterion("dqxdywbs between", value1, value2, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywbsNotBetween(String value1, String value2) {
            addCriterion("dqxdywbs not between", value1, value2, "dqxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeIsNull() {
            addCriterion("dqxdywye is null");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeIsNotNull() {
            addCriterion("dqxdywye is not null");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeEqualTo(String value) {
            addCriterion("dqxdywye =", value, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeNotEqualTo(String value) {
            addCriterion("dqxdywye <>", value, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeGreaterThan(String value) {
            addCriterion("dqxdywye >", value, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeGreaterThanOrEqualTo(String value) {
            addCriterion("dqxdywye >=", value, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeLessThan(String value) {
            addCriterion("dqxdywye <", value, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeLessThanOrEqualTo(String value) {
            addCriterion("dqxdywye <=", value, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeLike(String value) {
            addCriterion("dqxdywye like", value, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeNotLike(String value) {
            addCriterion("dqxdywye not like", value, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeIn(List<String> values) {
            addCriterion("dqxdywye in", values, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeNotIn(List<String> values) {
            addCriterion("dqxdywye not in", values, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeBetween(String value1, String value2) {
            addCriterion("dqxdywye between", value1, value2, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqxdywyeNotBetween(String value1, String value2) {
            addCriterion("dqxdywye not between", value1, value2, "dqxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsIsNull() {
            addCriterion("dqgzlxdywbs is null");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsIsNotNull() {
            addCriterion("dqgzlxdywbs is not null");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsEqualTo(String value) {
            addCriterion("dqgzlxdywbs =", value, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsNotEqualTo(String value) {
            addCriterion("dqgzlxdywbs <>", value, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsGreaterThan(String value) {
            addCriterion("dqgzlxdywbs >", value, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsGreaterThanOrEqualTo(String value) {
            addCriterion("dqgzlxdywbs >=", value, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsLessThan(String value) {
            addCriterion("dqgzlxdywbs <", value, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsLessThanOrEqualTo(String value) {
            addCriterion("dqgzlxdywbs <=", value, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsLike(String value) {
            addCriterion("dqgzlxdywbs like", value, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsNotLike(String value) {
            addCriterion("dqgzlxdywbs not like", value, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsIn(List<String> values) {
            addCriterion("dqgzlxdywbs in", values, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsNotIn(List<String> values) {
            addCriterion("dqgzlxdywbs not in", values, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsBetween(String value1, String value2) {
            addCriterion("dqgzlxdywbs between", value1, value2, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywbsNotBetween(String value1, String value2) {
            addCriterion("dqgzlxdywbs not between", value1, value2, "dqgzlxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeIsNull() {
            addCriterion("dqgzlxdywye is null");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeIsNotNull() {
            addCriterion("dqgzlxdywye is not null");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeEqualTo(String value) {
            addCriterion("dqgzlxdywye =", value, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeNotEqualTo(String value) {
            addCriterion("dqgzlxdywye <>", value, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeGreaterThan(String value) {
            addCriterion("dqgzlxdywye >", value, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeGreaterThanOrEqualTo(String value) {
            addCriterion("dqgzlxdywye >=", value, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeLessThan(String value) {
            addCriterion("dqgzlxdywye <", value, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeLessThanOrEqualTo(String value) {
            addCriterion("dqgzlxdywye <=", value, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeLike(String value) {
            addCriterion("dqgzlxdywye like", value, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeNotLike(String value) {
            addCriterion("dqgzlxdywye not like", value, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeIn(List<String> values) {
            addCriterion("dqgzlxdywye in", values, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeNotIn(List<String> values) {
            addCriterion("dqgzlxdywye not in", values, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeBetween(String value1, String value2) {
            addCriterion("dqgzlxdywye between", value1, value2, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqgzlxdywyeNotBetween(String value1, String value2) {
            addCriterion("dqgzlxdywye not between", value1, value2, "dqgzlxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsIsNull() {
            addCriterion("dqbllxdywbs is null");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsIsNotNull() {
            addCriterion("dqbllxdywbs is not null");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsEqualTo(String value) {
            addCriterion("dqbllxdywbs =", value, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsNotEqualTo(String value) {
            addCriterion("dqbllxdywbs <>", value, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsGreaterThan(String value) {
            addCriterion("dqbllxdywbs >", value, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsGreaterThanOrEqualTo(String value) {
            addCriterion("dqbllxdywbs >=", value, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsLessThan(String value) {
            addCriterion("dqbllxdywbs <", value, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsLessThanOrEqualTo(String value) {
            addCriterion("dqbllxdywbs <=", value, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsLike(String value) {
            addCriterion("dqbllxdywbs like", value, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsNotLike(String value) {
            addCriterion("dqbllxdywbs not like", value, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsIn(List<String> values) {
            addCriterion("dqbllxdywbs in", values, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsNotIn(List<String> values) {
            addCriterion("dqbllxdywbs not in", values, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsBetween(String value1, String value2) {
            addCriterion("dqbllxdywbs between", value1, value2, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywbsNotBetween(String value1, String value2) {
            addCriterion("dqbllxdywbs not between", value1, value2, "dqbllxdywbs");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeIsNull() {
            addCriterion("dqbllxdywye is null");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeIsNotNull() {
            addCriterion("dqbllxdywye is not null");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeEqualTo(String value) {
            addCriterion("dqbllxdywye =", value, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeNotEqualTo(String value) {
            addCriterion("dqbllxdywye <>", value, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeGreaterThan(String value) {
            addCriterion("dqbllxdywye >", value, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeGreaterThanOrEqualTo(String value) {
            addCriterion("dqbllxdywye >=", value, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeLessThan(String value) {
            addCriterion("dqbllxdywye <", value, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeLessThanOrEqualTo(String value) {
            addCriterion("dqbllxdywye <=", value, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeLike(String value) {
            addCriterion("dqbllxdywye like", value, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeNotLike(String value) {
            addCriterion("dqbllxdywye not like", value, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeIn(List<String> values) {
            addCriterion("dqbllxdywye in", values, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeNotIn(List<String> values) {
            addCriterion("dqbllxdywye not in", values, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeBetween(String value1, String value2) {
            addCriterion("dqbllxdywye between", value1, value2, "dqbllxdywye");
            return (Criteria) this;
        }

        public Criteria andDqbllxdywyeNotBetween(String value1, String value2) {
            addCriterion("dqbllxdywye not between", value1, value2, "dqbllxdywye");
            return (Criteria) this;
        }
    }

    /**
     * nj_credit_company
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_credit_company 2019-06-19
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