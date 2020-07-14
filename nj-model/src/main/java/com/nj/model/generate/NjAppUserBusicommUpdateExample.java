package com.nj.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjAppUserBusicommUpdateExample {
    /**
     * nj_app_user_busicomm_update
     */
    protected String orderByClause;

    /**
     * nj_app_user_busicomm_update
     */
    protected boolean distinct;

    /**
     * nj_app_user_busicomm_update
     */
    protected List<Criteria> oredCriteria;

    public NjAppUserBusicommUpdateExample() {
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
     * nj_app_user_busicomm_update 2019-04-29
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

        public Criteria andAppUserIdIsNull() {
            addCriterion("app_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAppUserIdIsNotNull() {
            addCriterion("app_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppUserIdEqualTo(String value) {
            addCriterion("app_user_id =", value, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdNotEqualTo(String value) {
            addCriterion("app_user_id <>", value, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdGreaterThan(String value) {
            addCriterion("app_user_id >", value, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_user_id >=", value, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdLessThan(String value) {
            addCriterion("app_user_id <", value, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdLessThanOrEqualTo(String value) {
            addCriterion("app_user_id <=", value, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdLike(String value) {
            addCriterion("app_user_id like", value, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdNotLike(String value) {
            addCriterion("app_user_id not like", value, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdIn(List<String> values) {
            addCriterion("app_user_id in", values, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdNotIn(List<String> values) {
            addCriterion("app_user_id not in", values, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdBetween(String value1, String value2) {
            addCriterion("app_user_id between", value1, value2, "appUserId");
            return (Criteria) this;
        }

        public Criteria andAppUserIdNotBetween(String value1, String value2) {
            addCriterion("app_user_id not between", value1, value2, "appUserId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdIsNull() {
            addCriterion("old_busicomm_id is null");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdIsNotNull() {
            addCriterion("old_busicomm_id is not null");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdEqualTo(String value) {
            addCriterion("old_busicomm_id =", value, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdNotEqualTo(String value) {
            addCriterion("old_busicomm_id <>", value, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdGreaterThan(String value) {
            addCriterion("old_busicomm_id >", value, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdGreaterThanOrEqualTo(String value) {
            addCriterion("old_busicomm_id >=", value, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdLessThan(String value) {
            addCriterion("old_busicomm_id <", value, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdLessThanOrEqualTo(String value) {
            addCriterion("old_busicomm_id <=", value, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdLike(String value) {
            addCriterion("old_busicomm_id like", value, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdNotLike(String value) {
            addCriterion("old_busicomm_id not like", value, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdIn(List<String> values) {
            addCriterion("old_busicomm_id in", values, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdNotIn(List<String> values) {
            addCriterion("old_busicomm_id not in", values, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdBetween(String value1, String value2) {
            addCriterion("old_busicomm_id between", value1, value2, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andOldBusicommIdNotBetween(String value1, String value2) {
            addCriterion("old_busicomm_id not between", value1, value2, "oldBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdIsNull() {
            addCriterion("new_busicomm_id is null");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdIsNotNull() {
            addCriterion("new_busicomm_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdEqualTo(String value) {
            addCriterion("new_busicomm_id =", value, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdNotEqualTo(String value) {
            addCriterion("new_busicomm_id <>", value, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdGreaterThan(String value) {
            addCriterion("new_busicomm_id >", value, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdGreaterThanOrEqualTo(String value) {
            addCriterion("new_busicomm_id >=", value, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdLessThan(String value) {
            addCriterion("new_busicomm_id <", value, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdLessThanOrEqualTo(String value) {
            addCriterion("new_busicomm_id <=", value, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdLike(String value) {
            addCriterion("new_busicomm_id like", value, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdNotLike(String value) {
            addCriterion("new_busicomm_id not like", value, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdIn(List<String> values) {
            addCriterion("new_busicomm_id in", values, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdNotIn(List<String> values) {
            addCriterion("new_busicomm_id not in", values, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdBetween(String value1, String value2) {
            addCriterion("new_busicomm_id between", value1, value2, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andNewBusicommIdNotBetween(String value1, String value2) {
            addCriterion("new_busicomm_id not between", value1, value2, "newBusicommId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }
    }

    /**
     * nj_app_user_busicomm_update
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_app_user_busicomm_update 2019-04-29
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