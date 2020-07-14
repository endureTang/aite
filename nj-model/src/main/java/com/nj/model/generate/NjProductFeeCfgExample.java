package com.nj.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjProductFeeCfgExample {
    /**
     * nj_product_fee_cfg
     */
    protected String orderByClause;

    /**
     * nj_product_fee_cfg
     */
    protected boolean distinct;

    /**
     * nj_product_fee_cfg
     */
    protected List<Criteria> oredCriteria;

    public NjProductFeeCfgExample() {
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
     * nj_product_fee_cfg 2019-03-07
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

        public Criteria andCfgObjIsNull() {
            addCriterion("cfg_obj is null");
            return (Criteria) this;
        }

        public Criteria andCfgObjIsNotNull() {
            addCriterion("cfg_obj is not null");
            return (Criteria) this;
        }

        public Criteria andCfgObjEqualTo(Short value) {
            addCriterion("cfg_obj =", value, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjNotEqualTo(Short value) {
            addCriterion("cfg_obj <>", value, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjGreaterThan(Short value) {
            addCriterion("cfg_obj >", value, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjGreaterThanOrEqualTo(Short value) {
            addCriterion("cfg_obj >=", value, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjLessThan(Short value) {
            addCriterion("cfg_obj <", value, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjLessThanOrEqualTo(Short value) {
            addCriterion("cfg_obj <=", value, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjIn(List<Short> values) {
            addCriterion("cfg_obj in", values, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjNotIn(List<Short> values) {
            addCriterion("cfg_obj not in", values, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjBetween(Short value1, Short value2) {
            addCriterion("cfg_obj between", value1, value2, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andCfgObjNotBetween(Short value1, Short value2) {
            addCriterion("cfg_obj not between", value1, value2, "cfgObj");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeIsNull() {
            addCriterion("business_fee_code is null");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeIsNotNull() {
            addCriterion("business_fee_code is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeEqualTo(String value) {
            addCriterion("business_fee_code =", value, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeNotEqualTo(String value) {
            addCriterion("business_fee_code <>", value, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeGreaterThan(String value) {
            addCriterion("business_fee_code >", value, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("business_fee_code >=", value, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeLessThan(String value) {
            addCriterion("business_fee_code <", value, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeLessThanOrEqualTo(String value) {
            addCriterion("business_fee_code <=", value, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeLike(String value) {
            addCriterion("business_fee_code like", value, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeNotLike(String value) {
            addCriterion("business_fee_code not like", value, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeIn(List<String> values) {
            addCriterion("business_fee_code in", values, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeNotIn(List<String> values) {
            addCriterion("business_fee_code not in", values, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeBetween(String value1, String value2) {
            addCriterion("business_fee_code between", value1, value2, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andBusinessFeeCodeNotBetween(String value1, String value2) {
            addCriterion("business_fee_code not between", value1, value2, "businessFeeCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeIsNull() {
            addCriterion("algorithm_code is null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeIsNotNull() {
            addCriterion("algorithm_code is not null");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeEqualTo(String value) {
            addCriterion("algorithm_code =", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeNotEqualTo(String value) {
            addCriterion("algorithm_code <>", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeGreaterThan(String value) {
            addCriterion("algorithm_code >", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeGreaterThanOrEqualTo(String value) {
            addCriterion("algorithm_code >=", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeLessThan(String value) {
            addCriterion("algorithm_code <", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeLessThanOrEqualTo(String value) {
            addCriterion("algorithm_code <=", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeLike(String value) {
            addCriterion("algorithm_code like", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeNotLike(String value) {
            addCriterion("algorithm_code not like", value, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeIn(List<String> values) {
            addCriterion("algorithm_code in", values, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeNotIn(List<String> values) {
            addCriterion("algorithm_code not in", values, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeBetween(String value1, String value2) {
            addCriterion("algorithm_code between", value1, value2, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andAlgorithmCodeNotBetween(String value1, String value2) {
            addCriterion("algorithm_code not between", value1, value2, "algorithmCode");
            return (Criteria) this;
        }

        public Criteria andShareIndexIsNull() {
            addCriterion("share_index is null");
            return (Criteria) this;
        }

        public Criteria andShareIndexIsNotNull() {
            addCriterion("share_index is not null");
            return (Criteria) this;
        }

        public Criteria andShareIndexEqualTo(Short value) {
            addCriterion("share_index =", value, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexNotEqualTo(Short value) {
            addCriterion("share_index <>", value, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexGreaterThan(Short value) {
            addCriterion("share_index >", value, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexGreaterThanOrEqualTo(Short value) {
            addCriterion("share_index >=", value, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexLessThan(Short value) {
            addCriterion("share_index <", value, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexLessThanOrEqualTo(Short value) {
            addCriterion("share_index <=", value, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexIn(List<Short> values) {
            addCriterion("share_index in", values, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexNotIn(List<Short> values) {
            addCriterion("share_index not in", values, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexBetween(Short value1, Short value2) {
            addCriterion("share_index between", value1, value2, "shareIndex");
            return (Criteria) this;
        }

        public Criteria andShareIndexNotBetween(Short value1, Short value2) {
            addCriterion("share_index not between", value1, value2, "shareIndex");
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
    }

    /**
     * nj_product_fee_cfg
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_product_fee_cfg 2019-03-07
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