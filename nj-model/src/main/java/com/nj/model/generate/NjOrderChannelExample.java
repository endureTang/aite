package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjOrderChannelExample {
    /**
     * nj_order_channel
     */
    protected String orderByClause;

    /**
     * nj_order_channel
     */
    protected boolean distinct;

    /**
     * nj_order_channel
     */
    protected List<Criteria> oredCriteria;

    public NjOrderChannelExample() {
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
     * nj_order_channel 2019-03-28
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

        public Criteria andChannelProductIdIsNull() {
            addCriterion("channel_product_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdIsNotNull() {
            addCriterion("channel_product_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdEqualTo(String value) {
            addCriterion("channel_product_id =", value, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdNotEqualTo(String value) {
            addCriterion("channel_product_id <>", value, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdGreaterThan(String value) {
            addCriterion("channel_product_id >", value, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("channel_product_id >=", value, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdLessThan(String value) {
            addCriterion("channel_product_id <", value, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdLessThanOrEqualTo(String value) {
            addCriterion("channel_product_id <=", value, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdLike(String value) {
            addCriterion("channel_product_id like", value, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdNotLike(String value) {
            addCriterion("channel_product_id not like", value, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdIn(List<String> values) {
            addCriterion("channel_product_id in", values, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdNotIn(List<String> values) {
            addCriterion("channel_product_id not in", values, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdBetween(String value1, String value2) {
            addCriterion("channel_product_id between", value1, value2, "channelProductId");
            return (Criteria) this;
        }

        public Criteria andChannelProductIdNotBetween(String value1, String value2) {
            addCriterion("channel_product_id not between", value1, value2, "channelProductId");
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

        public Criteria andChannelTypeEqualTo(Short value) {
            addCriterion("channel_type =", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotEqualTo(Short value) {
            addCriterion("channel_type <>", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThan(Short value) {
            addCriterion("channel_type >", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("channel_type >=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThan(Short value) {
            addCriterion("channel_type <", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeLessThanOrEqualTo(Short value) {
            addCriterion("channel_type <=", value, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeIn(List<Short> values) {
            addCriterion("channel_type in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotIn(List<Short> values) {
            addCriterion("channel_type not in", values, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeBetween(Short value1, Short value2) {
            addCriterion("channel_type between", value1, value2, "channelType");
            return (Criteria) this;
        }

        public Criteria andChannelTypeNotBetween(Short value1, Short value2) {
            addCriterion("channel_type not between", value1, value2, "channelType");
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

        public Criteria andBondFeeIsNull() {
            addCriterion("bond_fee is null");
            return (Criteria) this;
        }

        public Criteria andBondFeeIsNotNull() {
            addCriterion("bond_fee is not null");
            return (Criteria) this;
        }

        public Criteria andBondFeeEqualTo(String value) {
            addCriterion("bond_fee =", value, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeNotEqualTo(String value) {
            addCriterion("bond_fee <>", value, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeGreaterThan(String value) {
            addCriterion("bond_fee >", value, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeGreaterThanOrEqualTo(String value) {
            addCriterion("bond_fee >=", value, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeLessThan(String value) {
            addCriterion("bond_fee <", value, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeLessThanOrEqualTo(String value) {
            addCriterion("bond_fee <=", value, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeLike(String value) {
            addCriterion("bond_fee like", value, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeNotLike(String value) {
            addCriterion("bond_fee not like", value, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeIn(List<String> values) {
            addCriterion("bond_fee in", values, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeNotIn(List<String> values) {
            addCriterion("bond_fee not in", values, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeBetween(String value1, String value2) {
            addCriterion("bond_fee between", value1, value2, "bondFee");
            return (Criteria) this;
        }

        public Criteria andBondFeeNotBetween(String value1, String value2) {
            addCriterion("bond_fee not between", value1, value2, "bondFee");
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

        public Criteria andOperateFeeEqualTo(String value) {
            addCriterion("operate_fee =", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeNotEqualTo(String value) {
            addCriterion("operate_fee <>", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeGreaterThan(String value) {
            addCriterion("operate_fee >", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeGreaterThanOrEqualTo(String value) {
            addCriterion("operate_fee >=", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeLessThan(String value) {
            addCriterion("operate_fee <", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeLessThanOrEqualTo(String value) {
            addCriterion("operate_fee <=", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeLike(String value) {
            addCriterion("operate_fee like", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeNotLike(String value) {
            addCriterion("operate_fee not like", value, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeIn(List<String> values) {
            addCriterion("operate_fee in", values, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeNotIn(List<String> values) {
            addCriterion("operate_fee not in", values, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeBetween(String value1, String value2) {
            addCriterion("operate_fee between", value1, value2, "operateFee");
            return (Criteria) this;
        }

        public Criteria andOperateFeeNotBetween(String value1, String value2) {
            addCriterion("operate_fee not between", value1, value2, "operateFee");
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
     * nj_order_channel
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_order_channel 2019-03-28
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