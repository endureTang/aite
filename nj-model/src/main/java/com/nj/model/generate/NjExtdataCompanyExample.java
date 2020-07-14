package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjExtdataCompanyExample {
    /**
     * nj_extdata_company
     */
    protected String orderByClause;

    /**
     * nj_extdata_company
     */
    protected boolean distinct;

    /**
     * nj_extdata_company
     */
    protected List<Criteria> oredCriteria;

    public NjExtdataCompanyExample() {
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
     * nj_extdata_company 2019-07-10
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

        public Criteria andSfmzzrrsbxxIsNull() {
            addCriterion("sfmzzrrsbxx is null");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxIsNotNull() {
            addCriterion("sfmzzrrsbxx is not null");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxEqualTo(String value) {
            addCriterion("sfmzzrrsbxx =", value, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxNotEqualTo(String value) {
            addCriterion("sfmzzrrsbxx <>", value, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxGreaterThan(String value) {
            addCriterion("sfmzzrrsbxx >", value, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxGreaterThanOrEqualTo(String value) {
            addCriterion("sfmzzrrsbxx >=", value, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxLessThan(String value) {
            addCriterion("sfmzzrrsbxx <", value, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxLessThanOrEqualTo(String value) {
            addCriterion("sfmzzrrsbxx <=", value, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxLike(String value) {
            addCriterion("sfmzzrrsbxx like", value, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxNotLike(String value) {
            addCriterion("sfmzzrrsbxx not like", value, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxIn(List<String> values) {
            addCriterion("sfmzzrrsbxx in", values, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxNotIn(List<String> values) {
            addCriterion("sfmzzrrsbxx not in", values, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxBetween(String value1, String value2) {
            addCriterion("sfmzzrrsbxx between", value1, value2, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzzrrsbxxNotBetween(String value1, String value2) {
            addCriterion("sfmzzrrsbxx not between", value1, value2, "sfmzzrrsbxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxIsNull() {
            addCriterion("sfmzfyxx is null");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxIsNotNull() {
            addCriterion("sfmzfyxx is not null");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxEqualTo(String value) {
            addCriterion("sfmzfyxx =", value, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxNotEqualTo(String value) {
            addCriterion("sfmzfyxx <>", value, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxGreaterThan(String value) {
            addCriterion("sfmzfyxx >", value, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxGreaterThanOrEqualTo(String value) {
            addCriterion("sfmzfyxx >=", value, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxLessThan(String value) {
            addCriterion("sfmzfyxx <", value, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxLessThanOrEqualTo(String value) {
            addCriterion("sfmzfyxx <=", value, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxLike(String value) {
            addCriterion("sfmzfyxx like", value, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxNotLike(String value) {
            addCriterion("sfmzfyxx not like", value, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxIn(List<String> values) {
            addCriterion("sfmzfyxx in", values, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxNotIn(List<String> values) {
            addCriterion("sfmzfyxx not in", values, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxBetween(String value1, String value2) {
            addCriterion("sfmzfyxx between", value1, value2, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmzfyxxNotBetween(String value1, String value2) {
            addCriterion("sfmzfyxx not between", value1, value2, "sfmzfyxx");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdIsNull() {
            addCriterion("sfmztsmd is null");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdIsNotNull() {
            addCriterion("sfmztsmd is not null");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdEqualTo(String value) {
            addCriterion("sfmztsmd =", value, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdNotEqualTo(String value) {
            addCriterion("sfmztsmd <>", value, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdGreaterThan(String value) {
            addCriterion("sfmztsmd >", value, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdGreaterThanOrEqualTo(String value) {
            addCriterion("sfmztsmd >=", value, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdLessThan(String value) {
            addCriterion("sfmztsmd <", value, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdLessThanOrEqualTo(String value) {
            addCriterion("sfmztsmd <=", value, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdLike(String value) {
            addCriterion("sfmztsmd like", value, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdNotLike(String value) {
            addCriterion("sfmztsmd not like", value, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdIn(List<String> values) {
            addCriterion("sfmztsmd in", values, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdNotIn(List<String> values) {
            addCriterion("sfmztsmd not in", values, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdBetween(String value1, String value2) {
            addCriterion("sfmztsmd between", value1, value2, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andSfmztsmdNotBetween(String value1, String value2) {
            addCriterion("sfmztsmd not between", value1, value2, "sfmztsmd");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsIsNull() {
            addCriterion("j3gysqcs is null");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsIsNotNull() {
            addCriterion("j3gysqcs is not null");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsEqualTo(String value) {
            addCriterion("j3gysqcs =", value, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsNotEqualTo(String value) {
            addCriterion("j3gysqcs <>", value, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsGreaterThan(String value) {
            addCriterion("j3gysqcs >", value, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsGreaterThanOrEqualTo(String value) {
            addCriterion("j3gysqcs >=", value, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsLessThan(String value) {
            addCriterion("j3gysqcs <", value, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsLessThanOrEqualTo(String value) {
            addCriterion("j3gysqcs <=", value, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsLike(String value) {
            addCriterion("j3gysqcs like", value, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsNotLike(String value) {
            addCriterion("j3gysqcs not like", value, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsIn(List<String> values) {
            addCriterion("j3gysqcs in", values, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsNotIn(List<String> values) {
            addCriterion("j3gysqcs not in", values, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsBetween(String value1, String value2) {
            addCriterion("j3gysqcs between", value1, value2, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ3gysqcsNotBetween(String value1, String value2) {
            addCriterion("j3gysqcs not between", value1, value2, "j3gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsIsNull() {
            addCriterion("j6gysqcs is null");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsIsNotNull() {
            addCriterion("j6gysqcs is not null");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsEqualTo(String value) {
            addCriterion("j6gysqcs =", value, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsNotEqualTo(String value) {
            addCriterion("j6gysqcs <>", value, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsGreaterThan(String value) {
            addCriterion("j6gysqcs >", value, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsGreaterThanOrEqualTo(String value) {
            addCriterion("j6gysqcs >=", value, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsLessThan(String value) {
            addCriterion("j6gysqcs <", value, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsLessThanOrEqualTo(String value) {
            addCriterion("j6gysqcs <=", value, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsLike(String value) {
            addCriterion("j6gysqcs like", value, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsNotLike(String value) {
            addCriterion("j6gysqcs not like", value, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsIn(List<String> values) {
            addCriterion("j6gysqcs in", values, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsNotIn(List<String> values) {
            addCriterion("j6gysqcs not in", values, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsBetween(String value1, String value2) {
            addCriterion("j6gysqcs between", value1, value2, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ6gysqcsNotBetween(String value1, String value2) {
            addCriterion("j6gysqcs not between", value1, value2, "j6gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsIsNull() {
            addCriterion("j12gysqcs is null");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsIsNotNull() {
            addCriterion("j12gysqcs is not null");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsEqualTo(String value) {
            addCriterion("j12gysqcs =", value, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsNotEqualTo(String value) {
            addCriterion("j12gysqcs <>", value, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsGreaterThan(String value) {
            addCriterion("j12gysqcs >", value, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsGreaterThanOrEqualTo(String value) {
            addCriterion("j12gysqcs >=", value, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsLessThan(String value) {
            addCriterion("j12gysqcs <", value, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsLessThanOrEqualTo(String value) {
            addCriterion("j12gysqcs <=", value, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsLike(String value) {
            addCriterion("j12gysqcs like", value, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsNotLike(String value) {
            addCriterion("j12gysqcs not like", value, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsIn(List<String> values) {
            addCriterion("j12gysqcs in", values, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsNotIn(List<String> values) {
            addCriterion("j12gysqcs not in", values, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsBetween(String value1, String value2) {
            addCriterion("j12gysqcs between", value1, value2, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andJ12gysqcsNotBetween(String value1, String value2) {
            addCriterion("j12gysqcs not between", value1, value2, "j12gysqcs");
            return (Criteria) this;
        }

        public Criteria andSjzwztIsNull() {
            addCriterion("sjzwzt is null");
            return (Criteria) this;
        }

        public Criteria andSjzwztIsNotNull() {
            addCriterion("sjzwzt is not null");
            return (Criteria) this;
        }

        public Criteria andSjzwztEqualTo(String value) {
            addCriterion("sjzwzt =", value, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztNotEqualTo(String value) {
            addCriterion("sjzwzt <>", value, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztGreaterThan(String value) {
            addCriterion("sjzwzt >", value, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztGreaterThanOrEqualTo(String value) {
            addCriterion("sjzwzt >=", value, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztLessThan(String value) {
            addCriterion("sjzwzt <", value, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztLessThanOrEqualTo(String value) {
            addCriterion("sjzwzt <=", value, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztLike(String value) {
            addCriterion("sjzwzt like", value, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztNotLike(String value) {
            addCriterion("sjzwzt not like", value, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztIn(List<String> values) {
            addCriterion("sjzwzt in", values, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztNotIn(List<String> values) {
            addCriterion("sjzwzt not in", values, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztBetween(String value1, String value2) {
            addCriterion("sjzwzt between", value1, value2, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwztNotBetween(String value1, String value2) {
            addCriterion("sjzwzt not between", value1, value2, "sjzwzt");
            return (Criteria) this;
        }

        public Criteria andSjzwscIsNull() {
            addCriterion("sjzwsc is null");
            return (Criteria) this;
        }

        public Criteria andSjzwscIsNotNull() {
            addCriterion("sjzwsc is not null");
            return (Criteria) this;
        }

        public Criteria andSjzwscEqualTo(String value) {
            addCriterion("sjzwsc =", value, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscNotEqualTo(String value) {
            addCriterion("sjzwsc <>", value, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscGreaterThan(String value) {
            addCriterion("sjzwsc >", value, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscGreaterThanOrEqualTo(String value) {
            addCriterion("sjzwsc >=", value, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscLessThan(String value) {
            addCriterion("sjzwsc <", value, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscLessThanOrEqualTo(String value) {
            addCriterion("sjzwsc <=", value, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscLike(String value) {
            addCriterion("sjzwsc like", value, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscNotLike(String value) {
            addCriterion("sjzwsc not like", value, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscIn(List<String> values) {
            addCriterion("sjzwsc in", values, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscNotIn(List<String> values) {
            addCriterion("sjzwsc not in", values, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscBetween(String value1, String value2) {
            addCriterion("sjzwsc between", value1, value2, "sjzwsc");
            return (Criteria) this;
        }

        public Criteria andSjzwscNotBetween(String value1, String value2) {
            addCriterion("sjzwsc not between", value1, value2, "sjzwsc");
            return (Criteria) this;
        }
    }

    /**
     * nj_extdata_company
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_extdata_company 2019-07-10
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