package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjScenesCompanyExample {
    /**
     * nj_scenes_company
     */
    protected String orderByClause;

    /**
     * nj_scenes_company
     */
    protected boolean distinct;

    /**
     * nj_scenes_company
     */
    protected List<Criteria> oredCriteria;

    public NjScenesCompanyExample() {
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
     * nj_scenes_company 2019-07-05
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

        public Criteria andBidValueIsNull() {
            addCriterion("bid_value is null");
            return (Criteria) this;
        }

        public Criteria andBidValueIsNotNull() {
            addCriterion("bid_value is not null");
            return (Criteria) this;
        }

        public Criteria andBidValueEqualTo(String value) {
            addCriterion("bid_value =", value, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueNotEqualTo(String value) {
            addCriterion("bid_value <>", value, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueGreaterThan(String value) {
            addCriterion("bid_value >", value, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueGreaterThanOrEqualTo(String value) {
            addCriterion("bid_value >=", value, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueLessThan(String value) {
            addCriterion("bid_value <", value, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueLessThanOrEqualTo(String value) {
            addCriterion("bid_value <=", value, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueLike(String value) {
            addCriterion("bid_value like", value, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueNotLike(String value) {
            addCriterion("bid_value not like", value, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueIn(List<String> values) {
            addCriterion("bid_value in", values, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueNotIn(List<String> values) {
            addCriterion("bid_value not in", values, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueBetween(String value1, String value2) {
            addCriterion("bid_value between", value1, value2, "bidValue");
            return (Criteria) this;
        }

        public Criteria andBidValueNotBetween(String value1, String value2) {
            addCriterion("bid_value not between", value1, value2, "bidValue");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayIsNull() {
            addCriterion("supply_chain_financial_pay is null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayIsNotNull() {
            addCriterion("supply_chain_financial_pay is not null");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayEqualTo(String value) {
            addCriterion("supply_chain_financial_pay =", value, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayNotEqualTo(String value) {
            addCriterion("supply_chain_financial_pay <>", value, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayGreaterThan(String value) {
            addCriterion("supply_chain_financial_pay >", value, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayGreaterThanOrEqualTo(String value) {
            addCriterion("supply_chain_financial_pay >=", value, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayLessThan(String value) {
            addCriterion("supply_chain_financial_pay <", value, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayLessThanOrEqualTo(String value) {
            addCriterion("supply_chain_financial_pay <=", value, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayLike(String value) {
            addCriterion("supply_chain_financial_pay like", value, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayNotLike(String value) {
            addCriterion("supply_chain_financial_pay not like", value, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayIn(List<String> values) {
            addCriterion("supply_chain_financial_pay in", values, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayNotIn(List<String> values) {
            addCriterion("supply_chain_financial_pay not in", values, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayBetween(String value1, String value2) {
            addCriterion("supply_chain_financial_pay between", value1, value2, "supplyChainFinancialPay");
            return (Criteria) this;
        }

        public Criteria andSupplyChainFinancialPayNotBetween(String value1, String value2) {
            addCriterion("supply_chain_financial_pay not between", value1, value2, "supplyChainFinancialPay");
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

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("create_date like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("create_date not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
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
    }

    /**
     * nj_scenes_company
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_scenes_company 2019-07-05
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