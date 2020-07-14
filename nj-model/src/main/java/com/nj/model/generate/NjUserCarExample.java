package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjUserCarExample {
    /**
     * nj_user_car
     */
    protected String orderByClause;

    /**
     * nj_user_car
     */
    protected boolean distinct;

    /**
     * nj_user_car
     */
    protected List<Criteria> oredCriteria;

    public NjUserCarExample() {
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
     * nj_user_car 2019-01-25
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

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Integer value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Integer value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Integer value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Integer value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Integer value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Integer> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Integer> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Integer value1, Integer value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (Criteria) this;
        }

        public Criteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (Criteria) this;
        }

        public Criteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNull() {
            addCriterion("car_type is null");
            return (Criteria) this;
        }

        public Criteria andCarTypeIsNotNull() {
            addCriterion("car_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarTypeEqualTo(String value) {
            addCriterion("car_type =", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotEqualTo(String value) {
            addCriterion("car_type <>", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThan(String value) {
            addCriterion("car_type >", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeGreaterThanOrEqualTo(String value) {
            addCriterion("car_type >=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThan(String value) {
            addCriterion("car_type <", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLessThanOrEqualTo(String value) {
            addCriterion("car_type <=", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeLike(String value) {
            addCriterion("car_type like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotLike(String value) {
            addCriterion("car_type not like", value, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeIn(List<String> values) {
            addCriterion("car_type in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotIn(List<String> values) {
            addCriterion("car_type not in", values, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeBetween(String value1, String value2) {
            addCriterion("car_type between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andCarTypeNotBetween(String value1, String value2) {
            addCriterion("car_type not between", value1, value2, "carType");
            return (Criteria) this;
        }

        public Criteria andBrandIsNull() {
            addCriterion("brand is null");
            return (Criteria) this;
        }

        public Criteria andBrandIsNotNull() {
            addCriterion("brand is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEqualTo(String value) {
            addCriterion("brand =", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotEqualTo(String value) {
            addCriterion("brand <>", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThan(String value) {
            addCriterion("brand >", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandGreaterThanOrEqualTo(String value) {
            addCriterion("brand >=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThan(String value) {
            addCriterion("brand <", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLessThanOrEqualTo(String value) {
            addCriterion("brand <=", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandLike(String value) {
            addCriterion("brand like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotLike(String value) {
            addCriterion("brand not like", value, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandIn(List<String> values) {
            addCriterion("brand in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotIn(List<String> values) {
            addCriterion("brand not in", values, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandBetween(String value1, String value2) {
            addCriterion("brand between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andBrandNotBetween(String value1, String value2) {
            addCriterion("brand not between", value1, value2, "brand");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentIsNull() {
            addCriterion("first_payment is null");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentIsNotNull() {
            addCriterion("first_payment is not null");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentEqualTo(BigDecimal value) {
            addCriterion("first_payment =", value, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentNotEqualTo(BigDecimal value) {
            addCriterion("first_payment <>", value, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentGreaterThan(BigDecimal value) {
            addCriterion("first_payment >", value, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("first_payment >=", value, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentLessThan(BigDecimal value) {
            addCriterion("first_payment <", value, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentLessThanOrEqualTo(BigDecimal value) {
            addCriterion("first_payment <=", value, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentIn(List<BigDecimal> values) {
            addCriterion("first_payment in", values, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentNotIn(List<BigDecimal> values) {
            addCriterion("first_payment not in", values, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_payment between", value1, value2, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andFirstPaymentNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("first_payment not between", value1, value2, "firstPayment");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNull() {
            addCriterion("buy_price is null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIsNotNull() {
            addCriterion("buy_price is not null");
            return (Criteria) this;
        }

        public Criteria andBuyPriceEqualTo(String value) {
            addCriterion("buy_price =", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotEqualTo(String value) {
            addCriterion("buy_price <>", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThan(String value) {
            addCriterion("buy_price >", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceGreaterThanOrEqualTo(String value) {
            addCriterion("buy_price >=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThan(String value) {
            addCriterion("buy_price <", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLessThanOrEqualTo(String value) {
            addCriterion("buy_price <=", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceLike(String value) {
            addCriterion("buy_price like", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotLike(String value) {
            addCriterion("buy_price not like", value, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceIn(List<String> values) {
            addCriterion("buy_price in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotIn(List<String> values) {
            addCriterion("buy_price not in", values, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceBetween(String value1, String value2) {
            addCriterion("buy_price between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andBuyPriceNotBetween(String value1, String value2) {
            addCriterion("buy_price not between", value1, value2, "buyPrice");
            return (Criteria) this;
        }

        public Criteria andCarAgeIsNull() {
            addCriterion("car_age is null");
            return (Criteria) this;
        }

        public Criteria andCarAgeIsNotNull() {
            addCriterion("car_age is not null");
            return (Criteria) this;
        }

        public Criteria andCarAgeEqualTo(String value) {
            addCriterion("car_age =", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotEqualTo(String value) {
            addCriterion("car_age <>", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeGreaterThan(String value) {
            addCriterion("car_age >", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeGreaterThanOrEqualTo(String value) {
            addCriterion("car_age >=", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeLessThan(String value) {
            addCriterion("car_age <", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeLessThanOrEqualTo(String value) {
            addCriterion("car_age <=", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeLike(String value) {
            addCriterion("car_age like", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotLike(String value) {
            addCriterion("car_age not like", value, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeIn(List<String> values) {
            addCriterion("car_age in", values, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotIn(List<String> values) {
            addCriterion("car_age not in", values, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeBetween(String value1, String value2) {
            addCriterion("car_age between", value1, value2, "carAge");
            return (Criteria) this;
        }

        public Criteria andCarAgeNotBetween(String value1, String value2) {
            addCriterion("car_age not between", value1, value2, "carAge");
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

        public Criteria andXjcdIsNull() {
            addCriterion("xjcd is null");
            return (Criteria) this;
        }

        public Criteria andXjcdIsNotNull() {
            addCriterion("xjcd is not null");
            return (Criteria) this;
        }

        public Criteria andXjcdEqualTo(String value) {
            addCriterion("xjcd =", value, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdNotEqualTo(String value) {
            addCriterion("xjcd <>", value, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdGreaterThan(String value) {
            addCriterion("xjcd >", value, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdGreaterThanOrEqualTo(String value) {
            addCriterion("xjcd >=", value, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdLessThan(String value) {
            addCriterion("xjcd <", value, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdLessThanOrEqualTo(String value) {
            addCriterion("xjcd <=", value, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdLike(String value) {
            addCriterion("xjcd like", value, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdNotLike(String value) {
            addCriterion("xjcd not like", value, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdIn(List<String> values) {
            addCriterion("xjcd in", values, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdNotIn(List<String> values) {
            addCriterion("xjcd not in", values, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdBetween(String value1, String value2) {
            addCriterion("xjcd between", value1, value2, "xjcd");
            return (Criteria) this;
        }

        public Criteria andXjcdNotBetween(String value1, String value2) {
            addCriterion("xjcd not between", value1, value2, "xjcd");
            return (Criteria) this;
        }

        public Criteria andShdqIsNull() {
            addCriterion("shdq is null");
            return (Criteria) this;
        }

        public Criteria andShdqIsNotNull() {
            addCriterion("shdq is not null");
            return (Criteria) this;
        }

        public Criteria andShdqEqualTo(String value) {
            addCriterion("shdq =", value, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqNotEqualTo(String value) {
            addCriterion("shdq <>", value, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqGreaterThan(String value) {
            addCriterion("shdq >", value, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqGreaterThanOrEqualTo(String value) {
            addCriterion("shdq >=", value, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqLessThan(String value) {
            addCriterion("shdq <", value, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqLessThanOrEqualTo(String value) {
            addCriterion("shdq <=", value, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqLike(String value) {
            addCriterion("shdq like", value, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqNotLike(String value) {
            addCriterion("shdq not like", value, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqIn(List<String> values) {
            addCriterion("shdq in", values, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqNotIn(List<String> values) {
            addCriterion("shdq not in", values, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqBetween(String value1, String value2) {
            addCriterion("shdq between", value1, value2, "shdq");
            return (Criteria) this;
        }

        public Criteria andShdqNotBetween(String value1, String value2) {
            addCriterion("shdq not between", value1, value2, "shdq");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNull() {
            addCriterion("buy_date is null");
            return (Criteria) this;
        }

        public Criteria andBuyDateIsNotNull() {
            addCriterion("buy_date is not null");
            return (Criteria) this;
        }

        public Criteria andBuyDateEqualTo(Date value) {
            addCriterion("buy_date =", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotEqualTo(Date value) {
            addCriterion("buy_date <>", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThan(Date value) {
            addCriterion("buy_date >", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("buy_date >=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThan(Date value) {
            addCriterion("buy_date <", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateLessThanOrEqualTo(Date value) {
            addCriterion("buy_date <=", value, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateIn(List<Date> values) {
            addCriterion("buy_date in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotIn(List<Date> values) {
            addCriterion("buy_date not in", values, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateBetween(Date value1, Date value2) {
            addCriterion("buy_date between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andBuyDateNotBetween(Date value1, Date value2) {
            addCriterion("buy_date not between", value1, value2, "buyDate");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoIsNull() {
            addCriterion("insurance_no is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoIsNotNull() {
            addCriterion("insurance_no is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoEqualTo(String value) {
            addCriterion("insurance_no =", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotEqualTo(String value) {
            addCriterion("insurance_no <>", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoGreaterThan(String value) {
            addCriterion("insurance_no >", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoGreaterThanOrEqualTo(String value) {
            addCriterion("insurance_no >=", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoLessThan(String value) {
            addCriterion("insurance_no <", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoLessThanOrEqualTo(String value) {
            addCriterion("insurance_no <=", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoLike(String value) {
            addCriterion("insurance_no like", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotLike(String value) {
            addCriterion("insurance_no not like", value, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoIn(List<String> values) {
            addCriterion("insurance_no in", values, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotIn(List<String> values) {
            addCriterion("insurance_no not in", values, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoBetween(String value1, String value2) {
            addCriterion("insurance_no between", value1, value2, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andInsuranceNoNotBetween(String value1, String value2) {
            addCriterion("insurance_no not between", value1, value2, "insuranceNo");
            return (Criteria) this;
        }

        public Criteria andVinIsNull() {
            addCriterion("vin is null");
            return (Criteria) this;
        }

        public Criteria andVinIsNotNull() {
            addCriterion("vin is not null");
            return (Criteria) this;
        }

        public Criteria andVinEqualTo(String value) {
            addCriterion("vin =", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotEqualTo(String value) {
            addCriterion("vin <>", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThan(String value) {
            addCriterion("vin >", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThanOrEqualTo(String value) {
            addCriterion("vin >=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThan(String value) {
            addCriterion("vin <", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThanOrEqualTo(String value) {
            addCriterion("vin <=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLike(String value) {
            addCriterion("vin like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotLike(String value) {
            addCriterion("vin not like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinIn(List<String> values) {
            addCriterion("vin in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotIn(List<String> values) {
            addCriterion("vin not in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinBetween(String value1, String value2) {
            addCriterion("vin between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotBetween(String value1, String value2) {
            addCriterion("vin not between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoIsNull() {
            addCriterion("last_project_no is null");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoIsNotNull() {
            addCriterion("last_project_no is not null");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoEqualTo(String value) {
            addCriterion("last_project_no =", value, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoNotEqualTo(String value) {
            addCriterion("last_project_no <>", value, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoGreaterThan(String value) {
            addCriterion("last_project_no >", value, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("last_project_no >=", value, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoLessThan(String value) {
            addCriterion("last_project_no <", value, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoLessThanOrEqualTo(String value) {
            addCriterion("last_project_no <=", value, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoLike(String value) {
            addCriterion("last_project_no like", value, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoNotLike(String value) {
            addCriterion("last_project_no not like", value, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoIn(List<String> values) {
            addCriterion("last_project_no in", values, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoNotIn(List<String> values) {
            addCriterion("last_project_no not in", values, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoBetween(String value1, String value2) {
            addCriterion("last_project_no between", value1, value2, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andLastProjectNoNotBetween(String value1, String value2) {
            addCriterion("last_project_no not between", value1, value2, "lastProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoIsNull() {
            addCriterion("first_project_no is null");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoIsNotNull() {
            addCriterion("first_project_no is not null");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoEqualTo(String value) {
            addCriterion("first_project_no =", value, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoNotEqualTo(String value) {
            addCriterion("first_project_no <>", value, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoGreaterThan(String value) {
            addCriterion("first_project_no >", value, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoGreaterThanOrEqualTo(String value) {
            addCriterion("first_project_no >=", value, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoLessThan(String value) {
            addCriterion("first_project_no <", value, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoLessThanOrEqualTo(String value) {
            addCriterion("first_project_no <=", value, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoLike(String value) {
            addCriterion("first_project_no like", value, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoNotLike(String value) {
            addCriterion("first_project_no not like", value, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoIn(List<String> values) {
            addCriterion("first_project_no in", values, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoNotIn(List<String> values) {
            addCriterion("first_project_no not in", values, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoBetween(String value1, String value2) {
            addCriterion("first_project_no between", value1, value2, "firstProjectNo");
            return (Criteria) this;
        }

        public Criteria andFirstProjectNoNotBetween(String value1, String value2) {
            addCriterion("first_project_no not between", value1, value2, "firstProjectNo");
            return (Criteria) this;
        }
    }

    /**
     * nj_user_car
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_user_car 2019-01-25
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