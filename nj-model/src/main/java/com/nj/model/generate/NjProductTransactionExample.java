package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NjProductTransactionExample {
    /**
     * nj_product_transaction
     */
    protected String orderByClause;

    /**
     * nj_product_transaction
     */
    protected boolean distinct;

    /**
     * nj_product_transaction
     */
    protected List<Criteria> oredCriteria;

    public NjProductTransactionExample() {
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
     * nj_product_transaction 2019-08-21
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

        public Criteria andRepaymentPlanWayIsNull() {
            addCriterion("repayment_plan_way is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayIsNotNull() {
            addCriterion("repayment_plan_way is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayEqualTo(Byte value) {
            addCriterion("repayment_plan_way =", value, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayNotEqualTo(Byte value) {
            addCriterion("repayment_plan_way <>", value, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayGreaterThan(Byte value) {
            addCriterion("repayment_plan_way >", value, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayGreaterThanOrEqualTo(Byte value) {
            addCriterion("repayment_plan_way >=", value, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayLessThan(Byte value) {
            addCriterion("repayment_plan_way <", value, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayLessThanOrEqualTo(Byte value) {
            addCriterion("repayment_plan_way <=", value, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayIn(List<Byte> values) {
            addCriterion("repayment_plan_way in", values, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayNotIn(List<Byte> values) {
            addCriterion("repayment_plan_way not in", values, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayBetween(Byte value1, Byte value2) {
            addCriterion("repayment_plan_way between", value1, value2, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanWayNotBetween(Byte value1, Byte value2) {
            addCriterion("repayment_plan_way not between", value1, value2, "repaymentPlanWay");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetIsNull() {
            addCriterion("repayment_plan_day_offset is null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetIsNotNull() {
            addCriterion("repayment_plan_day_offset is not null");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetEqualTo(Integer value) {
            addCriterion("repayment_plan_day_offset =", value, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetNotEqualTo(Integer value) {
            addCriterion("repayment_plan_day_offset <>", value, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetGreaterThan(Integer value) {
            addCriterion("repayment_plan_day_offset >", value, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetGreaterThanOrEqualTo(Integer value) {
            addCriterion("repayment_plan_day_offset >=", value, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetLessThan(Integer value) {
            addCriterion("repayment_plan_day_offset <", value, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetLessThanOrEqualTo(Integer value) {
            addCriterion("repayment_plan_day_offset <=", value, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetIn(List<Integer> values) {
            addCriterion("repayment_plan_day_offset in", values, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetNotIn(List<Integer> values) {
            addCriterion("repayment_plan_day_offset not in", values, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetBetween(Integer value1, Integer value2) {
            addCriterion("repayment_plan_day_offset between", value1, value2, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andRepaymentPlanDayOffsetNotBetween(Integer value1, Integer value2) {
            addCriterion("repayment_plan_day_offset not between", value1, value2, "repaymentPlanDayOffset");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateIsNull() {
            addCriterion("fixed_interest_rate is null");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateIsNotNull() {
            addCriterion("fixed_interest_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateEqualTo(BigDecimal value) {
            addCriterion("fixed_interest_rate =", value, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateNotEqualTo(BigDecimal value) {
            addCriterion("fixed_interest_rate <>", value, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateGreaterThan(BigDecimal value) {
            addCriterion("fixed_interest_rate >", value, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fixed_interest_rate >=", value, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateLessThan(BigDecimal value) {
            addCriterion("fixed_interest_rate <", value, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fixed_interest_rate <=", value, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateIn(List<BigDecimal> values) {
            addCriterion("fixed_interest_rate in", values, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateNotIn(List<BigDecimal> values) {
            addCriterion("fixed_interest_rate not in", values, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fixed_interest_rate between", value1, value2, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andFixedInterestRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fixed_interest_rate not between", value1, value2, "fixedInterestRate");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNull() {
            addCriterion("service_charge is null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIsNotNull() {
            addCriterion("service_charge is not null");
            return (Criteria) this;
        }

        public Criteria andServiceChargeEqualTo(BigDecimal value) {
            addCriterion("service_charge =", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotEqualTo(BigDecimal value) {
            addCriterion("service_charge <>", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThan(BigDecimal value) {
            addCriterion("service_charge >", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_charge >=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThan(BigDecimal value) {
            addCriterion("service_charge <", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_charge <=", value, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeIn(List<BigDecimal> values) {
            addCriterion("service_charge in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotIn(List<BigDecimal> values) {
            addCriterion("service_charge not in", values, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_charge between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andServiceChargeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_charge not between", value1, value2, "serviceCharge");
            return (Criteria) this;
        }

        public Criteria andDrawingControlIsNull() {
            addCriterion("drawing_control is null");
            return (Criteria) this;
        }

        public Criteria andDrawingControlIsNotNull() {
            addCriterion("drawing_control is not null");
            return (Criteria) this;
        }

        public Criteria andDrawingControlEqualTo(Boolean value) {
            addCriterion("drawing_control =", value, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlNotEqualTo(Boolean value) {
            addCriterion("drawing_control <>", value, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlGreaterThan(Boolean value) {
            addCriterion("drawing_control >", value, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlGreaterThanOrEqualTo(Boolean value) {
            addCriterion("drawing_control >=", value, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlLessThan(Boolean value) {
            addCriterion("drawing_control <", value, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlLessThanOrEqualTo(Boolean value) {
            addCriterion("drawing_control <=", value, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlIn(List<Boolean> values) {
            addCriterion("drawing_control in", values, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlNotIn(List<Boolean> values) {
            addCriterion("drawing_control not in", values, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlBetween(Boolean value1, Boolean value2) {
            addCriterion("drawing_control between", value1, value2, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andDrawingControlNotBetween(Boolean value1, Boolean value2) {
            addCriterion("drawing_control not between", value1, value2, "drawingControl");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignIsNull() {
            addCriterion("is_online_sign is null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignIsNotNull() {
            addCriterion("is_online_sign is not null");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignEqualTo(Boolean value) {
            addCriterion("is_online_sign =", value, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignNotEqualTo(Boolean value) {
            addCriterion("is_online_sign <>", value, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignGreaterThan(Boolean value) {
            addCriterion("is_online_sign >", value, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_online_sign >=", value, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignLessThan(Boolean value) {
            addCriterion("is_online_sign <", value, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignLessThanOrEqualTo(Boolean value) {
            addCriterion("is_online_sign <=", value, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignIn(List<Boolean> values) {
            addCriterion("is_online_sign in", values, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignNotIn(List<Boolean> values) {
            addCriterion("is_online_sign not in", values, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignBetween(Boolean value1, Boolean value2) {
            addCriterion("is_online_sign between", value1, value2, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsOnlineSignNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_online_sign not between", value1, value2, "isOnlineSign");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupIsNull() {
            addCriterion("is_prepay_sup is null");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupIsNotNull() {
            addCriterion("is_prepay_sup is not null");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupEqualTo(Boolean value) {
            addCriterion("is_prepay_sup =", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupNotEqualTo(Boolean value) {
            addCriterion("is_prepay_sup <>", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupGreaterThan(Boolean value) {
            addCriterion("is_prepay_sup >", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_prepay_sup >=", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupLessThan(Boolean value) {
            addCriterion("is_prepay_sup <", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupLessThanOrEqualTo(Boolean value) {
            addCriterion("is_prepay_sup <=", value, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupIn(List<Boolean> values) {
            addCriterion("is_prepay_sup in", values, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupNotIn(List<Boolean> values) {
            addCriterion("is_prepay_sup not in", values, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prepay_sup between", value1, value2, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPrepaySupNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_prepay_sup not between", value1, value2, "isPrepaySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupIsNull() {
            addCriterion("is_penalty_sup is null");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupIsNotNull() {
            addCriterion("is_penalty_sup is not null");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupEqualTo(Boolean value) {
            addCriterion("is_penalty_sup =", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupNotEqualTo(Boolean value) {
            addCriterion("is_penalty_sup <>", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupGreaterThan(Boolean value) {
            addCriterion("is_penalty_sup >", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_penalty_sup >=", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupLessThan(Boolean value) {
            addCriterion("is_penalty_sup <", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupLessThanOrEqualTo(Boolean value) {
            addCriterion("is_penalty_sup <=", value, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupIn(List<Boolean> values) {
            addCriterion("is_penalty_sup in", values, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupNotIn(List<Boolean> values) {
            addCriterion("is_penalty_sup not in", values, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupBetween(Boolean value1, Boolean value2) {
            addCriterion("is_penalty_sup between", value1, value2, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andIsPenaltySupNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_penalty_sup not between", value1, value2, "isPenaltySup");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeIsNull() {
            addCriterion("contract_generation_type is null");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeIsNotNull() {
            addCriterion("contract_generation_type is not null");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeEqualTo(Byte value) {
            addCriterion("contract_generation_type =", value, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeNotEqualTo(Byte value) {
            addCriterion("contract_generation_type <>", value, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeGreaterThan(Byte value) {
            addCriterion("contract_generation_type >", value, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("contract_generation_type >=", value, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeLessThan(Byte value) {
            addCriterion("contract_generation_type <", value, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeLessThanOrEqualTo(Byte value) {
            addCriterion("contract_generation_type <=", value, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeIn(List<Byte> values) {
            addCriterion("contract_generation_type in", values, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeNotIn(List<Byte> values) {
            addCriterion("contract_generation_type not in", values, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeBetween(Byte value1, Byte value2) {
            addCriterion("contract_generation_type between", value1, value2, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andContractGenerationTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("contract_generation_type not between", value1, value2, "contractGenerationType");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermIsNull() {
            addCriterion("service_rate_term is null");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermIsNotNull() {
            addCriterion("service_rate_term is not null");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermEqualTo(BigDecimal value) {
            addCriterion("service_rate_term =", value, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermNotEqualTo(BigDecimal value) {
            addCriterion("service_rate_term <>", value, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermGreaterThan(BigDecimal value) {
            addCriterion("service_rate_term >", value, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_rate_term >=", value, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermLessThan(BigDecimal value) {
            addCriterion("service_rate_term <", value, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_rate_term <=", value, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermIn(List<BigDecimal> values) {
            addCriterion("service_rate_term in", values, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermNotIn(List<BigDecimal> values) {
            addCriterion("service_rate_term not in", values, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_rate_term between", value1, value2, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andServiceRateTermNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_rate_term not between", value1, value2, "serviceRateTerm");
            return (Criteria) this;
        }

        public Criteria andTermMoneyIsNull() {
            addCriterion("term_money is null");
            return (Criteria) this;
        }

        public Criteria andTermMoneyIsNotNull() {
            addCriterion("term_money is not null");
            return (Criteria) this;
        }

        public Criteria andTermMoneyEqualTo(BigDecimal value) {
            addCriterion("term_money =", value, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyNotEqualTo(BigDecimal value) {
            addCriterion("term_money <>", value, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyGreaterThan(BigDecimal value) {
            addCriterion("term_money >", value, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("term_money >=", value, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyLessThan(BigDecimal value) {
            addCriterion("term_money <", value, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("term_money <=", value, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyIn(List<BigDecimal> values) {
            addCriterion("term_money in", values, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyNotIn(List<BigDecimal> values) {
            addCriterion("term_money not in", values, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("term_money between", value1, value2, "termMoney");
            return (Criteria) this;
        }

        public Criteria andTermMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("term_money not between", value1, value2, "termMoney");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeIsNull() {
            addCriterion("own_loan_type is null");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeIsNotNull() {
            addCriterion("own_loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeEqualTo(Short value) {
            addCriterion("own_loan_type =", value, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeNotEqualTo(Short value) {
            addCriterion("own_loan_type <>", value, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeGreaterThan(Short value) {
            addCriterion("own_loan_type >", value, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("own_loan_type >=", value, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeLessThan(Short value) {
            addCriterion("own_loan_type <", value, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeLessThanOrEqualTo(Short value) {
            addCriterion("own_loan_type <=", value, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeIn(List<Short> values) {
            addCriterion("own_loan_type in", values, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeNotIn(List<Short> values) {
            addCriterion("own_loan_type not in", values, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeBetween(Short value1, Short value2) {
            addCriterion("own_loan_type between", value1, value2, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnLoanTypeNotBetween(Short value1, Short value2) {
            addCriterion("own_loan_type not between", value1, value2, "ownLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeIsNull() {
            addCriterion("channel_loan_type is null");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeIsNotNull() {
            addCriterion("channel_loan_type is not null");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeEqualTo(Short value) {
            addCriterion("channel_loan_type =", value, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeNotEqualTo(Short value) {
            addCriterion("channel_loan_type <>", value, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeGreaterThan(Short value) {
            addCriterion("channel_loan_type >", value, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("channel_loan_type >=", value, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeLessThan(Short value) {
            addCriterion("channel_loan_type <", value, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeLessThanOrEqualTo(Short value) {
            addCriterion("channel_loan_type <=", value, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeIn(List<Short> values) {
            addCriterion("channel_loan_type in", values, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeNotIn(List<Short> values) {
            addCriterion("channel_loan_type not in", values, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeBetween(Short value1, Short value2) {
            addCriterion("channel_loan_type between", value1, value2, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andChannelLoanTypeNotBetween(Short value1, Short value2) {
            addCriterion("channel_loan_type not between", value1, value2, "channelLoanType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeIsNull() {
            addCriterion("own_payback_type is null");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeIsNotNull() {
            addCriterion("own_payback_type is not null");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeEqualTo(Short value) {
            addCriterion("own_payback_type =", value, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeNotEqualTo(Short value) {
            addCriterion("own_payback_type <>", value, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeGreaterThan(Short value) {
            addCriterion("own_payback_type >", value, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("own_payback_type >=", value, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeLessThan(Short value) {
            addCriterion("own_payback_type <", value, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeLessThanOrEqualTo(Short value) {
            addCriterion("own_payback_type <=", value, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeIn(List<Short> values) {
            addCriterion("own_payback_type in", values, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeNotIn(List<Short> values) {
            addCriterion("own_payback_type not in", values, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeBetween(Short value1, Short value2) {
            addCriterion("own_payback_type between", value1, value2, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andOwnPaybackTypeNotBetween(Short value1, Short value2) {
            addCriterion("own_payback_type not between", value1, value2, "ownPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeIsNull() {
            addCriterion("channel_payback_type is null");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeIsNotNull() {
            addCriterion("channel_payback_type is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeEqualTo(Short value) {
            addCriterion("channel_payback_type =", value, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeNotEqualTo(Short value) {
            addCriterion("channel_payback_type <>", value, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeGreaterThan(Short value) {
            addCriterion("channel_payback_type >", value, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("channel_payback_type >=", value, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeLessThan(Short value) {
            addCriterion("channel_payback_type <", value, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeLessThanOrEqualTo(Short value) {
            addCriterion("channel_payback_type <=", value, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeIn(List<Short> values) {
            addCriterion("channel_payback_type in", values, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeNotIn(List<Short> values) {
            addCriterion("channel_payback_type not in", values, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeBetween(Short value1, Short value2) {
            addCriterion("channel_payback_type between", value1, value2, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andChannelPaybackTypeNotBetween(Short value1, Short value2) {
            addCriterion("channel_payback_type not between", value1, value2, "channelPaybackType");
            return (Criteria) this;
        }

        public Criteria andFeeFloatIsNull() {
            addCriterion("fee_float is null");
            return (Criteria) this;
        }

        public Criteria andFeeFloatIsNotNull() {
            addCriterion("fee_float is not null");
            return (Criteria) this;
        }

        public Criteria andFeeFloatEqualTo(Byte value) {
            addCriterion("fee_float =", value, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatNotEqualTo(Byte value) {
            addCriterion("fee_float <>", value, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatGreaterThan(Byte value) {
            addCriterion("fee_float >", value, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatGreaterThanOrEqualTo(Byte value) {
            addCriterion("fee_float >=", value, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatLessThan(Byte value) {
            addCriterion("fee_float <", value, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatLessThanOrEqualTo(Byte value) {
            addCriterion("fee_float <=", value, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatIn(List<Byte> values) {
            addCriterion("fee_float in", values, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatNotIn(List<Byte> values) {
            addCriterion("fee_float not in", values, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatBetween(Byte value1, Byte value2) {
            addCriterion("fee_float between", value1, value2, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andFeeFloatNotBetween(Byte value1, Byte value2) {
            addCriterion("fee_float not between", value1, value2, "feeFloat");
            return (Criteria) this;
        }

        public Criteria andIsDeductIsNull() {
            addCriterion("is_deduct is null");
            return (Criteria) this;
        }

        public Criteria andIsDeductIsNotNull() {
            addCriterion("is_deduct is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeductEqualTo(Boolean value) {
            addCriterion("is_deduct =", value, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductNotEqualTo(Boolean value) {
            addCriterion("is_deduct <>", value, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductGreaterThan(Boolean value) {
            addCriterion("is_deduct >", value, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deduct >=", value, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductLessThan(Boolean value) {
            addCriterion("is_deduct <", value, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deduct <=", value, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductIn(List<Boolean> values) {
            addCriterion("is_deduct in", values, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductNotIn(List<Boolean> values) {
            addCriterion("is_deduct not in", values, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deduct between", value1, value2, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andIsDeductNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deduct not between", value1, value2, "isDeduct");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNull() {
            addCriterion("max_amount is null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIsNotNull() {
            addCriterion("max_amount is not null");
            return (Criteria) this;
        }

        public Criteria andMaxAmountEqualTo(BigDecimal value) {
            addCriterion("max_amount =", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotEqualTo(BigDecimal value) {
            addCriterion("max_amount <>", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThan(BigDecimal value) {
            addCriterion("max_amount >", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_amount >=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThan(BigDecimal value) {
            addCriterion("max_amount <", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_amount <=", value, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountIn(List<BigDecimal> values) {
            addCriterion("max_amount in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotIn(List<BigDecimal> values) {
            addCriterion("max_amount not in", values, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_amount between", value1, value2, "maxAmount");
            return (Criteria) this;
        }

        public Criteria andMaxAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_amount not between", value1, value2, "maxAmount");
            return (Criteria) this;
        }
    }

    /**
     * nj_product_transaction
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_product_transaction 2019-08-21
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