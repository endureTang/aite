package com.nj.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjOrderMerchantExample {
    /**
     * nj_order_merchant
     */
    protected String orderByClause;

    /**
     * nj_order_merchant
     */
    protected boolean distinct;

    /**
     * nj_order_merchant
     */
    protected List<Criteria> oredCriteria;

    public NjOrderMerchantExample() {
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
     * nj_order_merchant 2019-05-16
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

        public Criteria andMerchantNoIsNull() {
            addCriterion("merchant_no is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIsNotNull() {
            addCriterion("merchant_no is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNoEqualTo(String value) {
            addCriterion("merchant_no =", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotEqualTo(String value) {
            addCriterion("merchant_no <>", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThan(String value) {
            addCriterion("merchant_no >", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_no >=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThan(String value) {
            addCriterion("merchant_no <", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLessThanOrEqualTo(String value) {
            addCriterion("merchant_no <=", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoLike(String value) {
            addCriterion("merchant_no like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotLike(String value) {
            addCriterion("merchant_no not like", value, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoIn(List<String> values) {
            addCriterion("merchant_no in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotIn(List<String> values) {
            addCriterion("merchant_no not in", values, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoBetween(String value1, String value2) {
            addCriterion("merchant_no between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNoNotBetween(String value1, String value2) {
            addCriterion("merchant_no not between", value1, value2, "merchantNo");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNull() {
            addCriterion("merchant_name is null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIsNotNull() {
            addCriterion("merchant_name is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantNameEqualTo(String value) {
            addCriterion("merchant_name =", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotEqualTo(String value) {
            addCriterion("merchant_name <>", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThan(String value) {
            addCriterion("merchant_name >", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_name >=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThan(String value) {
            addCriterion("merchant_name <", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLessThanOrEqualTo(String value) {
            addCriterion("merchant_name <=", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameLike(String value) {
            addCriterion("merchant_name like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotLike(String value) {
            addCriterion("merchant_name not like", value, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameIn(List<String> values) {
            addCriterion("merchant_name in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotIn(List<String> values) {
            addCriterion("merchant_name not in", values, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameBetween(String value1, String value2) {
            addCriterion("merchant_name between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantNameNotBetween(String value1, String value2) {
            addCriterion("merchant_name not between", value1, value2, "merchantName");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceIsNull() {
            addCriterion("merchant_province is null");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceIsNotNull() {
            addCriterion("merchant_province is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceEqualTo(String value) {
            addCriterion("merchant_province =", value, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceNotEqualTo(String value) {
            addCriterion("merchant_province <>", value, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceGreaterThan(String value) {
            addCriterion("merchant_province >", value, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_province >=", value, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceLessThan(String value) {
            addCriterion("merchant_province <", value, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceLessThanOrEqualTo(String value) {
            addCriterion("merchant_province <=", value, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceLike(String value) {
            addCriterion("merchant_province like", value, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceNotLike(String value) {
            addCriterion("merchant_province not like", value, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceIn(List<String> values) {
            addCriterion("merchant_province in", values, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceNotIn(List<String> values) {
            addCriterion("merchant_province not in", values, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceBetween(String value1, String value2) {
            addCriterion("merchant_province between", value1, value2, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantProvinceNotBetween(String value1, String value2) {
            addCriterion("merchant_province not between", value1, value2, "merchantProvince");
            return (Criteria) this;
        }

        public Criteria andMerchantCityIsNull() {
            addCriterion("merchant_city is null");
            return (Criteria) this;
        }

        public Criteria andMerchantCityIsNotNull() {
            addCriterion("merchant_city is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantCityEqualTo(String value) {
            addCriterion("merchant_city =", value, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityNotEqualTo(String value) {
            addCriterion("merchant_city <>", value, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityGreaterThan(String value) {
            addCriterion("merchant_city >", value, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_city >=", value, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityLessThan(String value) {
            addCriterion("merchant_city <", value, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityLessThanOrEqualTo(String value) {
            addCriterion("merchant_city <=", value, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityLike(String value) {
            addCriterion("merchant_city like", value, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityNotLike(String value) {
            addCriterion("merchant_city not like", value, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityIn(List<String> values) {
            addCriterion("merchant_city in", values, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityNotIn(List<String> values) {
            addCriterion("merchant_city not in", values, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityBetween(String value1, String value2) {
            addCriterion("merchant_city between", value1, value2, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCityNotBetween(String value1, String value2) {
            addCriterion("merchant_city not between", value1, value2, "merchantCity");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyIsNull() {
            addCriterion("merchant_county is null");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyIsNotNull() {
            addCriterion("merchant_county is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyEqualTo(String value) {
            addCriterion("merchant_county =", value, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyNotEqualTo(String value) {
            addCriterion("merchant_county <>", value, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyGreaterThan(String value) {
            addCriterion("merchant_county >", value, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_county >=", value, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyLessThan(String value) {
            addCriterion("merchant_county <", value, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyLessThanOrEqualTo(String value) {
            addCriterion("merchant_county <=", value, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyLike(String value) {
            addCriterion("merchant_county like", value, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyNotLike(String value) {
            addCriterion("merchant_county not like", value, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyIn(List<String> values) {
            addCriterion("merchant_county in", values, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyNotIn(List<String> values) {
            addCriterion("merchant_county not in", values, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyBetween(String value1, String value2) {
            addCriterion("merchant_county between", value1, value2, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantCountyNotBetween(String value1, String value2) {
            addCriterion("merchant_county not between", value1, value2, "merchantCounty");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressIsNull() {
            addCriterion("merchant_address is null");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressIsNotNull() {
            addCriterion("merchant_address is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressEqualTo(String value) {
            addCriterion("merchant_address =", value, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressNotEqualTo(String value) {
            addCriterion("merchant_address <>", value, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressGreaterThan(String value) {
            addCriterion("merchant_address >", value, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressGreaterThanOrEqualTo(String value) {
            addCriterion("merchant_address >=", value, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressLessThan(String value) {
            addCriterion("merchant_address <", value, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressLessThanOrEqualTo(String value) {
            addCriterion("merchant_address <=", value, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressLike(String value) {
            addCriterion("merchant_address like", value, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressNotLike(String value) {
            addCriterion("merchant_address not like", value, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressIn(List<String> values) {
            addCriterion("merchant_address in", values, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressNotIn(List<String> values) {
            addCriterion("merchant_address not in", values, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressBetween(String value1, String value2) {
            addCriterion("merchant_address between", value1, value2, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andMerchantAddressNotBetween(String value1, String value2) {
            addCriterion("merchant_address not between", value1, value2, "merchantAddress");
            return (Criteria) this;
        }

        public Criteria andConsociationDateIsNull() {
            addCriterion("consociation_date is null");
            return (Criteria) this;
        }

        public Criteria andConsociationDateIsNotNull() {
            addCriterion("consociation_date is not null");
            return (Criteria) this;
        }

        public Criteria andConsociationDateEqualTo(Date value) {
            addCriterion("consociation_date =", value, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateNotEqualTo(Date value) {
            addCriterion("consociation_date <>", value, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateGreaterThan(Date value) {
            addCriterion("consociation_date >", value, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("consociation_date >=", value, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateLessThan(Date value) {
            addCriterion("consociation_date <", value, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateLessThanOrEqualTo(Date value) {
            addCriterion("consociation_date <=", value, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateIn(List<Date> values) {
            addCriterion("consociation_date in", values, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateNotIn(List<Date> values) {
            addCriterion("consociation_date not in", values, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateBetween(Date value1, Date value2) {
            addCriterion("consociation_date between", value1, value2, "consociationDate");
            return (Criteria) this;
        }

        public Criteria andConsociationDateNotBetween(Date value1, Date value2) {
            addCriterion("consociation_date not between", value1, value2, "consociationDate");
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
    }

    /**
     * nj_order_merchant
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_order_merchant 2019-05-16
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