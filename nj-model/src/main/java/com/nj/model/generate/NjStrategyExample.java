package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjStrategyExample {
    /**
     * nj_strategy
     */
    protected String orderByClause;

    /**
     * nj_strategy
     */
    protected boolean distinct;

    /**
     * nj_strategy
     */
    protected List<Criteria> oredCriteria;

    public NjStrategyExample() {
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
     * nj_strategy 2020-07-17
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("source is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("source is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("source =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("source <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("source >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("source >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("source <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("source <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("source like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("source not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("source in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("source not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("source between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("source not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNoIsNull() {
            addCriterion("source_no is null");
            return (Criteria) this;
        }

        public Criteria andSourceNoIsNotNull() {
            addCriterion("source_no is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNoEqualTo(String value) {
            addCriterion("source_no =", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoNotEqualTo(String value) {
            addCriterion("source_no <>", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoGreaterThan(String value) {
            addCriterion("source_no >", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoGreaterThanOrEqualTo(String value) {
            addCriterion("source_no >=", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoLessThan(String value) {
            addCriterion("source_no <", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoLessThanOrEqualTo(String value) {
            addCriterion("source_no <=", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoLike(String value) {
            addCriterion("source_no like", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoNotLike(String value) {
            addCriterion("source_no not like", value, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoIn(List<String> values) {
            addCriterion("source_no in", values, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoNotIn(List<String> values) {
            addCriterion("source_no not in", values, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoBetween(String value1, String value2) {
            addCriterion("source_no between", value1, value2, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andSourceNoNotBetween(String value1, String value2) {
            addCriterion("source_no not between", value1, value2, "sourceNo");
            return (Criteria) this;
        }

        public Criteria andTransWayIsNull() {
            addCriterion("trans_way is null");
            return (Criteria) this;
        }

        public Criteria andTransWayIsNotNull() {
            addCriterion("trans_way is not null");
            return (Criteria) this;
        }

        public Criteria andTransWayEqualTo(String value) {
            addCriterion("trans_way =", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayNotEqualTo(String value) {
            addCriterion("trans_way <>", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayGreaterThan(String value) {
            addCriterion("trans_way >", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayGreaterThanOrEqualTo(String value) {
            addCriterion("trans_way >=", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayLessThan(String value) {
            addCriterion("trans_way <", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayLessThanOrEqualTo(String value) {
            addCriterion("trans_way <=", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayLike(String value) {
            addCriterion("trans_way like", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayNotLike(String value) {
            addCriterion("trans_way not like", value, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayIn(List<String> values) {
            addCriterion("trans_way in", values, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayNotIn(List<String> values) {
            addCriterion("trans_way not in", values, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayBetween(String value1, String value2) {
            addCriterion("trans_way between", value1, value2, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransWayNotBetween(String value1, String value2) {
            addCriterion("trans_way not between", value1, value2, "transWay");
            return (Criteria) this;
        }

        public Criteria andTransNoIsNull() {
            addCriterion("trans_no is null");
            return (Criteria) this;
        }

        public Criteria andTransNoIsNotNull() {
            addCriterion("trans_no is not null");
            return (Criteria) this;
        }

        public Criteria andTransNoEqualTo(String value) {
            addCriterion("trans_no =", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoNotEqualTo(String value) {
            addCriterion("trans_no <>", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoGreaterThan(String value) {
            addCriterion("trans_no >", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoGreaterThanOrEqualTo(String value) {
            addCriterion("trans_no >=", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoLessThan(String value) {
            addCriterion("trans_no <", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoLessThanOrEqualTo(String value) {
            addCriterion("trans_no <=", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoLike(String value) {
            addCriterion("trans_no like", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoNotLike(String value) {
            addCriterion("trans_no not like", value, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoIn(List<String> values) {
            addCriterion("trans_no in", values, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoNotIn(List<String> values) {
            addCriterion("trans_no not in", values, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoBetween(String value1, String value2) {
            addCriterion("trans_no between", value1, value2, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransNoNotBetween(String value1, String value2) {
            addCriterion("trans_no not between", value1, value2, "transNo");
            return (Criteria) this;
        }

        public Criteria andTransMoneyIsNull() {
            addCriterion("trans_money is null");
            return (Criteria) this;
        }

        public Criteria andTransMoneyIsNotNull() {
            addCriterion("trans_money is not null");
            return (Criteria) this;
        }

        public Criteria andTransMoneyEqualTo(String value) {
            addCriterion("trans_money =", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyNotEqualTo(String value) {
            addCriterion("trans_money <>", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyGreaterThan(String value) {
            addCriterion("trans_money >", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("trans_money >=", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyLessThan(String value) {
            addCriterion("trans_money <", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyLessThanOrEqualTo(String value) {
            addCriterion("trans_money <=", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyLike(String value) {
            addCriterion("trans_money like", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyNotLike(String value) {
            addCriterion("trans_money not like", value, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyIn(List<String> values) {
            addCriterion("trans_money in", values, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyNotIn(List<String> values) {
            addCriterion("trans_money not in", values, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyBetween(String value1, String value2) {
            addCriterion("trans_money between", value1, value2, "transMoney");
            return (Criteria) this;
        }

        public Criteria andTransMoneyNotBetween(String value1, String value2) {
            addCriterion("trans_money not between", value1, value2, "transMoney");
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

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
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

        public Criteria andDelFlagEqualTo(Short value) {
            addCriterion("del_flag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(Short value) {
            addCriterion("del_flag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(Short value) {
            addCriterion("del_flag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(Short value) {
            addCriterion("del_flag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(Short value) {
            addCriterion("del_flag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(Short value) {
            addCriterion("del_flag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<Short> values) {
            addCriterion("del_flag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<Short> values) {
            addCriterion("del_flag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(Short value1, Short value2) {
            addCriterion("del_flag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(Short value1, Short value2) {
            addCriterion("del_flag not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusIsNull() {
            addCriterion("source_no_stus is null");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusIsNotNull() {
            addCriterion("source_no_stus is not null");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusEqualTo(Short value) {
            addCriterion("source_no_stus =", value, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusNotEqualTo(Short value) {
            addCriterion("source_no_stus <>", value, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusGreaterThan(Short value) {
            addCriterion("source_no_stus >", value, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusGreaterThanOrEqualTo(Short value) {
            addCriterion("source_no_stus >=", value, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusLessThan(Short value) {
            addCriterion("source_no_stus <", value, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusLessThanOrEqualTo(Short value) {
            addCriterion("source_no_stus <=", value, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusIn(List<Short> values) {
            addCriterion("source_no_stus in", values, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusNotIn(List<Short> values) {
            addCriterion("source_no_stus not in", values, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusBetween(Short value1, Short value2) {
            addCriterion("source_no_stus between", value1, value2, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andSourceNoStusNotBetween(Short value1, Short value2) {
            addCriterion("source_no_stus not between", value1, value2, "sourceNoStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusIsNull() {
            addCriterion("trans_way_stus is null");
            return (Criteria) this;
        }

        public Criteria andTransWayStusIsNotNull() {
            addCriterion("trans_way_stus is not null");
            return (Criteria) this;
        }

        public Criteria andTransWayStusEqualTo(Short value) {
            addCriterion("trans_way_stus =", value, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusNotEqualTo(Short value) {
            addCriterion("trans_way_stus <>", value, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusGreaterThan(Short value) {
            addCriterion("trans_way_stus >", value, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusGreaterThanOrEqualTo(Short value) {
            addCriterion("trans_way_stus >=", value, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusLessThan(Short value) {
            addCriterion("trans_way_stus <", value, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusLessThanOrEqualTo(Short value) {
            addCriterion("trans_way_stus <=", value, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusIn(List<Short> values) {
            addCriterion("trans_way_stus in", values, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusNotIn(List<Short> values) {
            addCriterion("trans_way_stus not in", values, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusBetween(Short value1, Short value2) {
            addCriterion("trans_way_stus between", value1, value2, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransWayStusNotBetween(Short value1, Short value2) {
            addCriterion("trans_way_stus not between", value1, value2, "transWayStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusIsNull() {
            addCriterion("trans_no_stus is null");
            return (Criteria) this;
        }

        public Criteria andTransNoStusIsNotNull() {
            addCriterion("trans_no_stus is not null");
            return (Criteria) this;
        }

        public Criteria andTransNoStusEqualTo(Short value) {
            addCriterion("trans_no_stus =", value, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusNotEqualTo(Short value) {
            addCriterion("trans_no_stus <>", value, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusGreaterThan(Short value) {
            addCriterion("trans_no_stus >", value, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusGreaterThanOrEqualTo(Short value) {
            addCriterion("trans_no_stus >=", value, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusLessThan(Short value) {
            addCriterion("trans_no_stus <", value, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusLessThanOrEqualTo(Short value) {
            addCriterion("trans_no_stus <=", value, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusIn(List<Short> values) {
            addCriterion("trans_no_stus in", values, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusNotIn(List<Short> values) {
            addCriterion("trans_no_stus not in", values, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusBetween(Short value1, Short value2) {
            addCriterion("trans_no_stus between", value1, value2, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransNoStusNotBetween(Short value1, Short value2) {
            addCriterion("trans_no_stus not between", value1, value2, "transNoStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusIsNull() {
            addCriterion("trans_money_stus is null");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusIsNotNull() {
            addCriterion("trans_money_stus is not null");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusEqualTo(Short value) {
            addCriterion("trans_money_stus =", value, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusNotEqualTo(Short value) {
            addCriterion("trans_money_stus <>", value, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusGreaterThan(Short value) {
            addCriterion("trans_money_stus >", value, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusGreaterThanOrEqualTo(Short value) {
            addCriterion("trans_money_stus >=", value, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusLessThan(Short value) {
            addCriterion("trans_money_stus <", value, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusLessThanOrEqualTo(Short value) {
            addCriterion("trans_money_stus <=", value, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusIn(List<Short> values) {
            addCriterion("trans_money_stus in", values, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusNotIn(List<Short> values) {
            addCriterion("trans_money_stus not in", values, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusBetween(Short value1, Short value2) {
            addCriterion("trans_money_stus between", value1, value2, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andTransMoneyStusNotBetween(Short value1, Short value2) {
            addCriterion("trans_money_stus not between", value1, value2, "transMoneyStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusIsNull() {
            addCriterion("amount_stus is null");
            return (Criteria) this;
        }

        public Criteria andAmountStusIsNotNull() {
            addCriterion("amount_stus is not null");
            return (Criteria) this;
        }

        public Criteria andAmountStusEqualTo(Short value) {
            addCriterion("amount_stus =", value, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusNotEqualTo(Short value) {
            addCriterion("amount_stus <>", value, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusGreaterThan(Short value) {
            addCriterion("amount_stus >", value, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusGreaterThanOrEqualTo(Short value) {
            addCriterion("amount_stus >=", value, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusLessThan(Short value) {
            addCriterion("amount_stus <", value, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusLessThanOrEqualTo(Short value) {
            addCriterion("amount_stus <=", value, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusIn(List<Short> values) {
            addCriterion("amount_stus in", values, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusNotIn(List<Short> values) {
            addCriterion("amount_stus not in", values, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusBetween(Short value1, Short value2) {
            addCriterion("amount_stus between", value1, value2, "amountStus");
            return (Criteria) this;
        }

        public Criteria andAmountStusNotBetween(Short value1, Short value2) {
            addCriterion("amount_stus not between", value1, value2, "amountStus");
            return (Criteria) this;
        }
    }

    /**
     * nj_strategy
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_strategy 2020-07-17
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