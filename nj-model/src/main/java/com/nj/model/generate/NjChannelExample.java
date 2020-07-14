package com.nj.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjChannelExample {
    /**
     * nj_channel
     */
    protected String orderByClause;

    /**
     * nj_channel
     */
    protected boolean distinct;

    /**
     * nj_channel
     */
    protected List<Criteria> oredCriteria;

    public NjChannelExample() {
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
     * nj_channel 2019-09-02
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andRepayAccountIdIsNull() {
            addCriterion("repay_account_id is null");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdIsNotNull() {
            addCriterion("repay_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdEqualTo(String value) {
            addCriterion("repay_account_id =", value, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdNotEqualTo(String value) {
            addCriterion("repay_account_id <>", value, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdGreaterThan(String value) {
            addCriterion("repay_account_id >", value, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("repay_account_id >=", value, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdLessThan(String value) {
            addCriterion("repay_account_id <", value, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdLessThanOrEqualTo(String value) {
            addCriterion("repay_account_id <=", value, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdLike(String value) {
            addCriterion("repay_account_id like", value, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdNotLike(String value) {
            addCriterion("repay_account_id not like", value, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdIn(List<String> values) {
            addCriterion("repay_account_id in", values, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdNotIn(List<String> values) {
            addCriterion("repay_account_id not in", values, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdBetween(String value1, String value2) {
            addCriterion("repay_account_id between", value1, value2, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepayAccountIdNotBetween(String value1, String value2) {
            addCriterion("repay_account_id not between", value1, value2, "repayAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdIsNull() {
            addCriterion("repee_account_id is null");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdIsNotNull() {
            addCriterion("repee_account_id is not null");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdEqualTo(String value) {
            addCriterion("repee_account_id =", value, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdNotEqualTo(String value) {
            addCriterion("repee_account_id <>", value, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdGreaterThan(String value) {
            addCriterion("repee_account_id >", value, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("repee_account_id >=", value, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdLessThan(String value) {
            addCriterion("repee_account_id <", value, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdLessThanOrEqualTo(String value) {
            addCriterion("repee_account_id <=", value, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdLike(String value) {
            addCriterion("repee_account_id like", value, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdNotLike(String value) {
            addCriterion("repee_account_id not like", value, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdIn(List<String> values) {
            addCriterion("repee_account_id in", values, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdNotIn(List<String> values) {
            addCriterion("repee_account_id not in", values, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdBetween(String value1, String value2) {
            addCriterion("repee_account_id between", value1, value2, "repeeAccountId");
            return (Criteria) this;
        }

        public Criteria andRepeeAccountIdNotBetween(String value1, String value2) {
            addCriterion("repee_account_id not between", value1, value2, "repeeAccountId");
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

        public Criteria andFundsLimitIsNull() {
            addCriterion("funds_limit is null");
            return (Criteria) this;
        }

        public Criteria andFundsLimitIsNotNull() {
            addCriterion("funds_limit is not null");
            return (Criteria) this;
        }

        public Criteria andFundsLimitEqualTo(Double value) {
            addCriterion("funds_limit =", value, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitNotEqualTo(Double value) {
            addCriterion("funds_limit <>", value, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitGreaterThan(Double value) {
            addCriterion("funds_limit >", value, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitGreaterThanOrEqualTo(Double value) {
            addCriterion("funds_limit >=", value, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitLessThan(Double value) {
            addCriterion("funds_limit <", value, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitLessThanOrEqualTo(Double value) {
            addCriterion("funds_limit <=", value, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitIn(List<Double> values) {
            addCriterion("funds_limit in", values, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitNotIn(List<Double> values) {
            addCriterion("funds_limit not in", values, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitBetween(Double value1, Double value2) {
            addCriterion("funds_limit between", value1, value2, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andFundsLimitNotBetween(Double value1, Double value2) {
            addCriterion("funds_limit not between", value1, value2, "fundsLimit");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdIsNull() {
            addCriterion("user_info_id is null");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdIsNotNull() {
            addCriterion("user_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdEqualTo(String value) {
            addCriterion("user_info_id =", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotEqualTo(String value) {
            addCriterion("user_info_id <>", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdGreaterThan(String value) {
            addCriterion("user_info_id >", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_info_id >=", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdLessThan(String value) {
            addCriterion("user_info_id <", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdLessThanOrEqualTo(String value) {
            addCriterion("user_info_id <=", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdLike(String value) {
            addCriterion("user_info_id like", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotLike(String value) {
            addCriterion("user_info_id not like", value, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdIn(List<String> values) {
            addCriterion("user_info_id in", values, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotIn(List<String> values) {
            addCriterion("user_info_id not in", values, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdBetween(String value1, String value2) {
            addCriterion("user_info_id between", value1, value2, "userInfoId");
            return (Criteria) this;
        }

        public Criteria andUserInfoIdNotBetween(String value1, String value2) {
            addCriterion("user_info_id not between", value1, value2, "userInfoId");
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

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlIsNull() {
            addCriterion("common_callback_url is null");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlIsNotNull() {
            addCriterion("common_callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlEqualTo(String value) {
            addCriterion("common_callback_url =", value, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlNotEqualTo(String value) {
            addCriterion("common_callback_url <>", value, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlGreaterThan(String value) {
            addCriterion("common_callback_url >", value, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("common_callback_url >=", value, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlLessThan(String value) {
            addCriterion("common_callback_url <", value, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("common_callback_url <=", value, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlLike(String value) {
            addCriterion("common_callback_url like", value, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlNotLike(String value) {
            addCriterion("common_callback_url not like", value, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlIn(List<String> values) {
            addCriterion("common_callback_url in", values, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlNotIn(List<String> values) {
            addCriterion("common_callback_url not in", values, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlBetween(String value1, String value2) {
            addCriterion("common_callback_url between", value1, value2, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andCommonCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("common_callback_url not between", value1, value2, "commonCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlIsNull() {
            addCriterion("activate_callback_url is null");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlIsNotNull() {
            addCriterion("activate_callback_url is not null");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlEqualTo(String value) {
            addCriterion("activate_callback_url =", value, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlNotEqualTo(String value) {
            addCriterion("activate_callback_url <>", value, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlGreaterThan(String value) {
            addCriterion("activate_callback_url >", value, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlGreaterThanOrEqualTo(String value) {
            addCriterion("activate_callback_url >=", value, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlLessThan(String value) {
            addCriterion("activate_callback_url <", value, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlLessThanOrEqualTo(String value) {
            addCriterion("activate_callback_url <=", value, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlLike(String value) {
            addCriterion("activate_callback_url like", value, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlNotLike(String value) {
            addCriterion("activate_callback_url not like", value, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlIn(List<String> values) {
            addCriterion("activate_callback_url in", values, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlNotIn(List<String> values) {
            addCriterion("activate_callback_url not in", values, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlBetween(String value1, String value2) {
            addCriterion("activate_callback_url between", value1, value2, "activateCallbackUrl");
            return (Criteria) this;
        }

        public Criteria andActivateCallbackUrlNotBetween(String value1, String value2) {
            addCriterion("activate_callback_url not between", value1, value2, "activateCallbackUrl");
            return (Criteria) this;
        }
    }

    /**
     * nj_channel
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_channel 2019-09-02
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