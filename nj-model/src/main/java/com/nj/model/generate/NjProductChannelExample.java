package com.nj.model.generate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NjProductChannelExample {
    /**
     * nj_product_channel
     */
    protected String orderByClause;

    /**
     * nj_product_channel
     */
    protected boolean distinct;

    /**
     * nj_product_channel
     */
    protected List<Criteria> oredCriteria;

    public NjProductChannelExample() {
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
     * nj_product_channel 2019-03-28
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

        public Criteria andChannelOpenIdIsNull() {
            addCriterion("channel_open_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdIsNotNull() {
            addCriterion("channel_open_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdEqualTo(String value) {
            addCriterion("channel_open_id =", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdNotEqualTo(String value) {
            addCriterion("channel_open_id <>", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdGreaterThan(String value) {
            addCriterion("channel_open_id >", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_open_id >=", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdLessThan(String value) {
            addCriterion("channel_open_id <", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdLessThanOrEqualTo(String value) {
            addCriterion("channel_open_id <=", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdLike(String value) {
            addCriterion("channel_open_id like", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdNotLike(String value) {
            addCriterion("channel_open_id not like", value, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdIn(List<String> values) {
            addCriterion("channel_open_id in", values, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdNotIn(List<String> values) {
            addCriterion("channel_open_id not in", values, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdBetween(String value1, String value2) {
            addCriterion("channel_open_id between", value1, value2, "channelOpenId");
            return (Criteria) this;
        }

        public Criteria andChannelOpenIdNotBetween(String value1, String value2) {
            addCriterion("channel_open_id not between", value1, value2, "channelOpenId");
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

        public Criteria andChannelCodeIsNull() {
            addCriterion("channel_code is null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIsNotNull() {
            addCriterion("channel_code is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCodeEqualTo(String value) {
            addCriterion("channel_code =", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotEqualTo(String value) {
            addCriterion("channel_code <>", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThan(String value) {
            addCriterion("channel_code >", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeGreaterThanOrEqualTo(String value) {
            addCriterion("channel_code >=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThan(String value) {
            addCriterion("channel_code <", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLessThanOrEqualTo(String value) {
            addCriterion("channel_code <=", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeLike(String value) {
            addCriterion("channel_code like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotLike(String value) {
            addCriterion("channel_code not like", value, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeIn(List<String> values) {
            addCriterion("channel_code in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotIn(List<String> values) {
            addCriterion("channel_code not in", values, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeBetween(String value1, String value2) {
            addCriterion("channel_code between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelCodeNotBetween(String value1, String value2) {
            addCriterion("channel_code not between", value1, value2, "channelCode");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNull() {
            addCriterion("channel_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNotNull() {
            addCriterion("channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNameEqualTo(String value) {
            addCriterion("channel_name =", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotEqualTo(String value) {
            addCriterion("channel_name <>", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThan(String value) {
            addCriterion("channel_name >", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_name >=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThan(String value) {
            addCriterion("channel_name <", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThanOrEqualTo(String value) {
            addCriterion("channel_name <=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLike(String value) {
            addCriterion("channel_name like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotLike(String value) {
            addCriterion("channel_name not like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameIn(List<String> values) {
            addCriterion("channel_name in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotIn(List<String> values) {
            addCriterion("channel_name not in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameBetween(String value1, String value2) {
            addCriterion("channel_name between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotBetween(String value1, String value2) {
            addCriterion("channel_name not between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelMobileIsNull() {
            addCriterion("channel_mobile is null");
            return (Criteria) this;
        }

        public Criteria andChannelMobileIsNotNull() {
            addCriterion("channel_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMobileEqualTo(String value) {
            addCriterion("channel_mobile =", value, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileNotEqualTo(String value) {
            addCriterion("channel_mobile <>", value, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileGreaterThan(String value) {
            addCriterion("channel_mobile >", value, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileGreaterThanOrEqualTo(String value) {
            addCriterion("channel_mobile >=", value, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileLessThan(String value) {
            addCriterion("channel_mobile <", value, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileLessThanOrEqualTo(String value) {
            addCriterion("channel_mobile <=", value, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileLike(String value) {
            addCriterion("channel_mobile like", value, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileNotLike(String value) {
            addCriterion("channel_mobile not like", value, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileIn(List<String> values) {
            addCriterion("channel_mobile in", values, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileNotIn(List<String> values) {
            addCriterion("channel_mobile not in", values, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileBetween(String value1, String value2) {
            addCriterion("channel_mobile between", value1, value2, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelMobileNotBetween(String value1, String value2) {
            addCriterion("channel_mobile not between", value1, value2, "channelMobile");
            return (Criteria) this;
        }

        public Criteria andChannelAcctIsNull() {
            addCriterion("channel_acct is null");
            return (Criteria) this;
        }

        public Criteria andChannelAcctIsNotNull() {
            addCriterion("channel_acct is not null");
            return (Criteria) this;
        }

        public Criteria andChannelAcctEqualTo(String value) {
            addCriterion("channel_acct =", value, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctNotEqualTo(String value) {
            addCriterion("channel_acct <>", value, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctGreaterThan(String value) {
            addCriterion("channel_acct >", value, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctGreaterThanOrEqualTo(String value) {
            addCriterion("channel_acct >=", value, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctLessThan(String value) {
            addCriterion("channel_acct <", value, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctLessThanOrEqualTo(String value) {
            addCriterion("channel_acct <=", value, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctLike(String value) {
            addCriterion("channel_acct like", value, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctNotLike(String value) {
            addCriterion("channel_acct not like", value, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctIn(List<String> values) {
            addCriterion("channel_acct in", values, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctNotIn(List<String> values) {
            addCriterion("channel_acct not in", values, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctBetween(String value1, String value2) {
            addCriterion("channel_acct between", value1, value2, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelAcctNotBetween(String value1, String value2) {
            addCriterion("channel_acct not between", value1, value2, "channelAcct");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIsNull() {
            addCriterion("channel_type is null");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIsNotNull() {
            addCriterion("channel_type is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTypeEqualTo(Integer value) {
            addCriterion("channel_type =", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotEqualTo(Integer value) {
            addCriterion("channel_type <>", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThan(Integer value) {
            addCriterion("channel_type >", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_type >=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThan(Integer value) {
            addCriterion("channel_type <", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThanOrEqualTo(Integer value) {
            addCriterion("channel_type <=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIn(List<Integer> values) {
            addCriterion("channel_type in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotIn(List<Integer> values) {
            addCriterion("channel_type not in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeBetween(Integer value1, Integer value2) {
            addCriterion("channel_type between", value1, value2, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_type not between", value1, value2, "channelType");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateIsNull() {
            addCriterion("monthly_rate is null");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateIsNotNull() {
            addCriterion("monthly_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateEqualTo(Double value) {
            addCriterion("monthly_rate =", value, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateNotEqualTo(Double value) {
            addCriterion("monthly_rate <>", value, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateGreaterThan(Double value) {
            addCriterion("monthly_rate >", value, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateGreaterThanOrEqualTo(Double value) {
            addCriterion("monthly_rate >=", value, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateLessThan(Double value) {
            addCriterion("monthly_rate <", value, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateLessThanOrEqualTo(Double value) {
            addCriterion("monthly_rate <=", value, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateIn(List<Double> values) {
            addCriterion("monthly_rate in", values, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateNotIn(List<Double> values) {
            addCriterion("monthly_rate not in", values, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateBetween(Double value1, Double value2) {
            addCriterion("monthly_rate between", value1, value2, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andMonthlyRateNotBetween(Double value1, Double value2) {
            addCriterion("monthly_rate not between", value1, value2, "monthlyRate");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNull() {
            addCriterion("account_type is null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIsNotNull() {
            addCriterion("account_type is not null");
            return (Criteria) this;
        }

        public Criteria andAccountTypeEqualTo(Integer value) {
            addCriterion("account_type =", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotEqualTo(Integer value) {
            addCriterion("account_type <>", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThan(Integer value) {
            addCriterion("account_type >", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_type >=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThan(Integer value) {
            addCriterion("account_type <", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeLessThanOrEqualTo(Integer value) {
            addCriterion("account_type <=", value, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeIn(List<Integer> values) {
            addCriterion("account_type in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotIn(List<Integer> values) {
            addCriterion("account_type not in", values, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeBetween(Integer value1, Integer value2) {
            addCriterion("account_type between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andAccountTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("account_type not between", value1, value2, "accountType");
            return (Criteria) this;
        }

        public Criteria andRevenueRateIsNull() {
            addCriterion("revenue_rate is null");
            return (Criteria) this;
        }

        public Criteria andRevenueRateIsNotNull() {
            addCriterion("revenue_rate is not null");
            return (Criteria) this;
        }

        public Criteria andRevenueRateEqualTo(Double value) {
            addCriterion("revenue_rate =", value, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateNotEqualTo(Double value) {
            addCriterion("revenue_rate <>", value, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateGreaterThan(Double value) {
            addCriterion("revenue_rate >", value, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateGreaterThanOrEqualTo(Double value) {
            addCriterion("revenue_rate >=", value, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateLessThan(Double value) {
            addCriterion("revenue_rate <", value, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateLessThanOrEqualTo(Double value) {
            addCriterion("revenue_rate <=", value, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateIn(List<Double> values) {
            addCriterion("revenue_rate in", values, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateNotIn(List<Double> values) {
            addCriterion("revenue_rate not in", values, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateBetween(Double value1, Double value2) {
            addCriterion("revenue_rate between", value1, value2, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andRevenueRateNotBetween(Double value1, Double value2) {
            addCriterion("revenue_rate not between", value1, value2, "revenueRate");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeIsNull() {
            addCriterion("operate_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeIsNotNull() {
            addCriterion("operate_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeEqualTo(Integer value) {
            addCriterion("operate_fee_type =", value, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeNotEqualTo(Integer value) {
            addCriterion("operate_fee_type <>", value, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeGreaterThan(Integer value) {
            addCriterion("operate_fee_type >", value, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("operate_fee_type >=", value, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeLessThan(Integer value) {
            addCriterion("operate_fee_type <", value, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("operate_fee_type <=", value, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeIn(List<Integer> values) {
            addCriterion("operate_fee_type in", values, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeNotIn(List<Integer> values) {
            addCriterion("operate_fee_type not in", values, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("operate_fee_type between", value1, value2, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("operate_fee_type not between", value1, value2, "operateFeeType");
            return (Criteria) this;
        }

        public Criteria andOperateFeeIsNull() {
            addCriterion("operate_fee is null");
            return (Criteria) this;
        }

        public Criteria andOperateFeeIsNotNull() {
            addCriterion("operate_fee is not null");
            return (Criteria) this;
        }

        public Criteria andOperateFeeEqualTo(Float value) {
            addCriterion("operate_fee =", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeNotEqualTo(Float value) {
            addCriterion("operate_fee <>", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeGreaterThan(Float value) {
            addCriterion("operate_fee >", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeGreaterThanOrEqualTo(Float value) {
            addCriterion("operate_fee >=", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeLessThan(Float value) {
            addCriterion("operate_fee <", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeLessThanOrEqualTo(Float value) {
            addCriterion("operate_fee <=", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeIn(List<Float> values) {
            addCriterion("operate_fee in", values, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeNotIn(List<Float> values) {
            addCriterion("operate_fee not in", values, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeBetween(Float value1, Float value2) {
            addCriterion("operate_fee between", value1, value2, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeNotBetween(Float value1, Float value2) {
            addCriterion("operate_fee not between", value1, value2, "operateFee");
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

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(String value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(String value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(String value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(String value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(String value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLike(String value) {
            addCriterion("channel_id like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotLike(String value) {
            addCriterion("channel_id not like", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<String> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<String> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(String value1, String value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(String value1, String value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdIsNull() {
            addCriterion("nj_channel_id is null");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdIsNotNull() {
            addCriterion("nj_channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdEqualTo(String value) {
            addCriterion("nj_channel_id =", value, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdNotEqualTo(String value) {
            addCriterion("nj_channel_id <>", value, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdGreaterThan(String value) {
            addCriterion("nj_channel_id >", value, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdGreaterThanOrEqualTo(String value) {
            addCriterion("nj_channel_id >=", value, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdLessThan(String value) {
            addCriterion("nj_channel_id <", value, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdLessThanOrEqualTo(String value) {
            addCriterion("nj_channel_id <=", value, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdLike(String value) {
            addCriterion("nj_channel_id like", value, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdNotLike(String value) {
            addCriterion("nj_channel_id not like", value, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdIn(List<String> values) {
            addCriterion("nj_channel_id in", values, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdNotIn(List<String> values) {
            addCriterion("nj_channel_id not in", values, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdBetween(String value1, String value2) {
            addCriterion("nj_channel_id between", value1, value2, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andNjChannelIdNotBetween(String value1, String value2) {
            addCriterion("nj_channel_id not between", value1, value2, "njChannelId");
            return (Criteria) this;
        }

        public Criteria andBondTypeIsNull() {
            addCriterion("bond_type is null");
            return (Criteria) this;
        }

        public Criteria andBondTypeIsNotNull() {
            addCriterion("bond_type is not null");
            return (Criteria) this;
        }

        public Criteria andBondTypeEqualTo(Byte value) {
            addCriterion("bond_type =", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeNotEqualTo(Byte value) {
            addCriterion("bond_type <>", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeGreaterThan(Byte value) {
            addCriterion("bond_type >", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("bond_type >=", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeLessThan(Byte value) {
            addCriterion("bond_type <", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeLessThanOrEqualTo(Byte value) {
            addCriterion("bond_type <=", value, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeIn(List<Byte> values) {
            addCriterion("bond_type in", values, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeNotIn(List<Byte> values) {
            addCriterion("bond_type not in", values, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeBetween(Byte value1, Byte value2) {
            addCriterion("bond_type between", value1, value2, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("bond_type not between", value1, value2, "bondType");
            return (Criteria) this;
        }

        public Criteria andBondValueIsNull() {
            addCriterion("bond_value is null");
            return (Criteria) this;
        }

        public Criteria andBondValueIsNotNull() {
            addCriterion("bond_value is not null");
            return (Criteria) this;
        }

        public Criteria andBondValueEqualTo(String value) {
            addCriterion("bond_value =", value, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueNotEqualTo(String value) {
            addCriterion("bond_value <>", value, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueGreaterThan(String value) {
            addCriterion("bond_value >", value, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueGreaterThanOrEqualTo(String value) {
            addCriterion("bond_value >=", value, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueLessThan(String value) {
            addCriterion("bond_value <", value, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueLessThanOrEqualTo(String value) {
            addCriterion("bond_value <=", value, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueLike(String value) {
            addCriterion("bond_value like", value, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueNotLike(String value) {
            addCriterion("bond_value not like", value, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueIn(List<String> values) {
            addCriterion("bond_value in", values, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueNotIn(List<String> values) {
            addCriterion("bond_value not in", values, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueBetween(String value1, String value2) {
            addCriterion("bond_value between", value1, value2, "bondValue");
            return (Criteria) this;
        }

        public Criteria andBondValueNotBetween(String value1, String value2) {
            addCriterion("bond_value not between", value1, value2, "bondValue");
            return (Criteria) this;
        }

        public Criteria andIsRateContractIsNull() {
            addCriterion("is_rate_contract is null");
            return (Criteria) this;
        }

        public Criteria andIsRateContractIsNotNull() {
            addCriterion("is_rate_contract is not null");
            return (Criteria) this;
        }

        public Criteria andIsRateContractEqualTo(Boolean value) {
            addCriterion("is_rate_contract =", value, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractNotEqualTo(Boolean value) {
            addCriterion("is_rate_contract <>", value, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractGreaterThan(Boolean value) {
            addCriterion("is_rate_contract >", value, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_rate_contract >=", value, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractLessThan(Boolean value) {
            addCriterion("is_rate_contract <", value, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractLessThanOrEqualTo(Boolean value) {
            addCriterion("is_rate_contract <=", value, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractIn(List<Boolean> values) {
            addCriterion("is_rate_contract in", values, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractNotIn(List<Boolean> values) {
            addCriterion("is_rate_contract not in", values, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractBetween(Boolean value1, Boolean value2) {
            addCriterion("is_rate_contract between", value1, value2, "isRateContract");
            return (Criteria) this;
        }

        public Criteria andIsRateContractNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_rate_contract not between", value1, value2, "isRateContract");
            return (Criteria) this;
        }
    }

    /**
     * nj_product_channel
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_product_channel 2019-03-28
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