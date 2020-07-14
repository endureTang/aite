package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjAssetGradeExample {
    /**
     * nj_asset_grade
     */
    protected String orderByClause;

    /**
     * nj_asset_grade
     */
    protected boolean distinct;

    /**
     * nj_asset_grade
     */
    protected List<Criteria> oredCriteria;

    public NjAssetGradeExample() {
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
     * nj_asset_grade 2018-03-21
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

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(String value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(String value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(String value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(String value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(String value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(String value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLike(String value) {
            addCriterion("grade like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotLike(String value) {
            addCriterion("grade not like", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<String> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<String> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(String value1, String value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(String value1, String value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andDescptionIsNull() {
            addCriterion("descption is null");
            return (Criteria) this;
        }

        public Criteria andDescptionIsNotNull() {
            addCriterion("descption is not null");
            return (Criteria) this;
        }

        public Criteria andDescptionEqualTo(String value) {
            addCriterion("descption =", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionNotEqualTo(String value) {
            addCriterion("descption <>", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionGreaterThan(String value) {
            addCriterion("descption >", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionGreaterThanOrEqualTo(String value) {
            addCriterion("descption >=", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionLessThan(String value) {
            addCriterion("descption <", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionLessThanOrEqualTo(String value) {
            addCriterion("descption <=", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionLike(String value) {
            addCriterion("descption like", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionNotLike(String value) {
            addCriterion("descption not like", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionIn(List<String> values) {
            addCriterion("descption in", values, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionNotIn(List<String> values) {
            addCriterion("descption not in", values, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionBetween(String value1, String value2) {
            addCriterion("descption between", value1, value2, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionNotBetween(String value1, String value2) {
            addCriterion("descption not between", value1, value2, "descption");
            return (Criteria) this;
        }

        public Criteria andScreenRateIsNull() {
            addCriterion("screen_rate is null");
            return (Criteria) this;
        }

        public Criteria andScreenRateIsNotNull() {
            addCriterion("screen_rate is not null");
            return (Criteria) this;
        }

        public Criteria andScreenRateEqualTo(Integer value) {
            addCriterion("screen_rate =", value, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateNotEqualTo(Integer value) {
            addCriterion("screen_rate <>", value, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateGreaterThan(Integer value) {
            addCriterion("screen_rate >", value, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("screen_rate >=", value, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateLessThan(Integer value) {
            addCriterion("screen_rate <", value, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateLessThanOrEqualTo(Integer value) {
            addCriterion("screen_rate <=", value, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateIn(List<Integer> values) {
            addCriterion("screen_rate in", values, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateNotIn(List<Integer> values) {
            addCriterion("screen_rate not in", values, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateBetween(Integer value1, Integer value2) {
            addCriterion("screen_rate between", value1, value2, "screenRate");
            return (Criteria) this;
        }

        public Criteria andScreenRateNotBetween(Integer value1, Integer value2) {
            addCriterion("screen_rate not between", value1, value2, "screenRate");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNull() {
            addCriterion("is_default is null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIsNotNull() {
            addCriterion("is_default is not null");
            return (Criteria) this;
        }

        public Criteria andIsDefaultEqualTo(Boolean value) {
            addCriterion("is_default =", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotEqualTo(Boolean value) {
            addCriterion("is_default <>", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThan(Boolean value) {
            addCriterion("is_default >", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_default >=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThan(Boolean value) {
            addCriterion("is_default <", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultLessThanOrEqualTo(Boolean value) {
            addCriterion("is_default <=", value, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultIn(List<Boolean> values) {
            addCriterion("is_default in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotIn(List<Boolean> values) {
            addCriterion("is_default not in", values, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default between", value1, value2, "isDefault");
            return (Criteria) this;
        }

        public Criteria andIsDefaultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_default not between", value1, value2, "isDefault");
            return (Criteria) this;
        }
    }

    /**
     * nj_asset_grade
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_asset_grade 2018-03-21
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