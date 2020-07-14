package com.nj.model.generate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class NjUserCreditExample {
    /**
     * nj_user_credit
     */
    protected String orderByClause;

    /**
     * nj_user_credit
     */
    protected boolean distinct;

    /**
     * nj_user_credit
     */
    protected List<Criteria> oredCriteria;

    public NjUserCreditExample() {
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
     * nj_user_credit 2018-03-21
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

        public Criteria andAgentCountIsNull() {
            addCriterion("agent_count is null");
            return (Criteria) this;
        }

        public Criteria andAgentCountIsNotNull() {
            addCriterion("agent_count is not null");
            return (Criteria) this;
        }

        public Criteria andAgentCountEqualTo(Integer value) {
            addCriterion("agent_count =", value, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountNotEqualTo(Integer value) {
            addCriterion("agent_count <>", value, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountGreaterThan(Integer value) {
            addCriterion("agent_count >", value, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("agent_count >=", value, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountLessThan(Integer value) {
            addCriterion("agent_count <", value, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountLessThanOrEqualTo(Integer value) {
            addCriterion("agent_count <=", value, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountIn(List<Integer> values) {
            addCriterion("agent_count in", values, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountNotIn(List<Integer> values) {
            addCriterion("agent_count not in", values, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountBetween(Integer value1, Integer value2) {
            addCriterion("agent_count between", value1, value2, "agentCount");
            return (Criteria) this;
        }

        public Criteria andAgentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("agent_count not between", value1, value2, "agentCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountIsNull() {
            addCriterion("person_count is null");
            return (Criteria) this;
        }

        public Criteria andPersonCountIsNotNull() {
            addCriterion("person_count is not null");
            return (Criteria) this;
        }

        public Criteria andPersonCountEqualTo(Integer value) {
            addCriterion("person_count =", value, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountNotEqualTo(Integer value) {
            addCriterion("person_count <>", value, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountGreaterThan(Integer value) {
            addCriterion("person_count >", value, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("person_count >=", value, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountLessThan(Integer value) {
            addCriterion("person_count <", value, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountLessThanOrEqualTo(Integer value) {
            addCriterion("person_count <=", value, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountIn(List<Integer> values) {
            addCriterion("person_count in", values, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountNotIn(List<Integer> values) {
            addCriterion("person_count not in", values, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountBetween(Integer value1, Integer value2) {
            addCriterion("person_count between", value1, value2, "personCount");
            return (Criteria) this;
        }

        public Criteria andPersonCountNotBetween(Integer value1, Integer value2) {
            addCriterion("person_count not between", value1, value2, "personCount");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6IsNull() {
            addCriterion("overdue_month6 is null");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6IsNotNull() {
            addCriterion("overdue_month6 is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6EqualTo(Integer value) {
            addCriterion("overdue_month6 =", value, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6NotEqualTo(Integer value) {
            addCriterion("overdue_month6 <>", value, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6GreaterThan(Integer value) {
            addCriterion("overdue_month6 >", value, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6GreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue_month6 >=", value, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6LessThan(Integer value) {
            addCriterion("overdue_month6 <", value, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6LessThanOrEqualTo(Integer value) {
            addCriterion("overdue_month6 <=", value, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6In(List<Integer> values) {
            addCriterion("overdue_month6 in", values, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6NotIn(List<Integer> values) {
            addCriterion("overdue_month6 not in", values, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6Between(Integer value1, Integer value2) {
            addCriterion("overdue_month6 between", value1, value2, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth6NotBetween(Integer value1, Integer value2) {
            addCriterion("overdue_month6 not between", value1, value2, "overdueMonth6");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12IsNull() {
            addCriterion("overdue_month12 is null");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12IsNotNull() {
            addCriterion("overdue_month12 is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12EqualTo(Integer value) {
            addCriterion("overdue_month12 =", value, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12NotEqualTo(Integer value) {
            addCriterion("overdue_month12 <>", value, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12GreaterThan(Integer value) {
            addCriterion("overdue_month12 >", value, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12GreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue_month12 >=", value, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12LessThan(Integer value) {
            addCriterion("overdue_month12 <", value, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12LessThanOrEqualTo(Integer value) {
            addCriterion("overdue_month12 <=", value, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12In(List<Integer> values) {
            addCriterion("overdue_month12 in", values, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12NotIn(List<Integer> values) {
            addCriterion("overdue_month12 not in", values, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12Between(Integer value1, Integer value2) {
            addCriterion("overdue_month12 between", value1, value2, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth12NotBetween(Integer value1, Integer value2) {
            addCriterion("overdue_month12 not between", value1, value2, "overdueMonth12");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtIsNull() {
            addCriterion("credit_card_amt is null");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtIsNotNull() {
            addCriterion("credit_card_amt is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtEqualTo(Integer value) {
            addCriterion("credit_card_amt =", value, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtNotEqualTo(Integer value) {
            addCriterion("credit_card_amt <>", value, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtGreaterThan(Integer value) {
            addCriterion("credit_card_amt >", value, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtGreaterThanOrEqualTo(Integer value) {
            addCriterion("credit_card_amt >=", value, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtLessThan(Integer value) {
            addCriterion("credit_card_amt <", value, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtLessThanOrEqualTo(Integer value) {
            addCriterion("credit_card_amt <=", value, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtIn(List<Integer> values) {
            addCriterion("credit_card_amt in", values, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtNotIn(List<Integer> values) {
            addCriterion("credit_card_amt not in", values, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtBetween(Integer value1, Integer value2) {
            addCriterion("credit_card_amt between", value1, value2, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andCreditCardAmtNotBetween(Integer value1, Integer value2) {
            addCriterion("credit_card_amt not between", value1, value2, "creditCardAmt");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceIsNull() {
            addCriterion("mortage_balance is null");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceIsNotNull() {
            addCriterion("mortage_balance is not null");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceEqualTo(BigDecimal value) {
            addCriterion("mortage_balance =", value, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceNotEqualTo(BigDecimal value) {
            addCriterion("mortage_balance <>", value, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceGreaterThan(BigDecimal value) {
            addCriterion("mortage_balance >", value, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mortage_balance >=", value, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceLessThan(BigDecimal value) {
            addCriterion("mortage_balance <", value, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mortage_balance <=", value, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceIn(List<BigDecimal> values) {
            addCriterion("mortage_balance in", values, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceNotIn(List<BigDecimal> values) {
            addCriterion("mortage_balance not in", values, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mortage_balance between", value1, value2, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andMortageBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mortage_balance not between", value1, value2, "mortageBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceIsNull() {
            addCriterion("credit_balance is null");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceIsNotNull() {
            addCriterion("credit_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceEqualTo(BigDecimal value) {
            addCriterion("credit_balance =", value, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceNotEqualTo(BigDecimal value) {
            addCriterion("credit_balance <>", value, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceGreaterThan(BigDecimal value) {
            addCriterion("credit_balance >", value, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_balance >=", value, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceLessThan(BigDecimal value) {
            addCriterion("credit_balance <", value, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("credit_balance <=", value, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceIn(List<BigDecimal> values) {
            addCriterion("credit_balance in", values, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceNotIn(List<BigDecimal> values) {
            addCriterion("credit_balance not in", values, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_balance between", value1, value2, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andCreditBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("credit_balance not between", value1, value2, "creditBalance");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrIsNull() {
            addCriterion("balance_avr is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrIsNotNull() {
            addCriterion("balance_avr is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrEqualTo(BigDecimal value) {
            addCriterion("balance_avr =", value, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrNotEqualTo(BigDecimal value) {
            addCriterion("balance_avr <>", value, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrGreaterThan(BigDecimal value) {
            addCriterion("balance_avr >", value, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_avr >=", value, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrLessThan(BigDecimal value) {
            addCriterion("balance_avr <", value, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_avr <=", value, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrIn(List<BigDecimal> values) {
            addCriterion("balance_avr in", values, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrNotIn(List<BigDecimal> values) {
            addCriterion("balance_avr not in", values, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_avr between", value1, value2, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andBalanceAvrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_avr not between", value1, value2, "balanceAvr");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIsNull() {
            addCriterion("overdue_status is null");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIsNotNull() {
            addCriterion("overdue_status is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusEqualTo(String value) {
            addCriterion("overdue_status =", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotEqualTo(String value) {
            addCriterion("overdue_status <>", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusGreaterThan(String value) {
            addCriterion("overdue_status >", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusGreaterThanOrEqualTo(String value) {
            addCriterion("overdue_status >=", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLessThan(String value) {
            addCriterion("overdue_status <", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLessThanOrEqualTo(String value) {
            addCriterion("overdue_status <=", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusLike(String value) {
            addCriterion("overdue_status like", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotLike(String value) {
            addCriterion("overdue_status not like", value, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusIn(List<String> values) {
            addCriterion("overdue_status in", values, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotIn(List<String> values) {
            addCriterion("overdue_status not in", values, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusBetween(String value1, String value2) {
            addCriterion("overdue_status between", value1, value2, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueStatusNotBetween(String value1, String value2) {
            addCriterion("overdue_status not between", value1, value2, "overdueStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNull() {
            addCriterion("account_status is null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNotNull() {
            addCriterion("account_status is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusEqualTo(String value) {
            addCriterion("account_status =", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotEqualTo(String value) {
            addCriterion("account_status <>", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThan(String value) {
            addCriterion("account_status >", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThanOrEqualTo(String value) {
            addCriterion("account_status >=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThan(String value) {
            addCriterion("account_status <", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThanOrEqualTo(String value) {
            addCriterion("account_status <=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLike(String value) {
            addCriterion("account_status like", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotLike(String value) {
            addCriterion("account_status not like", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIn(List<String> values) {
            addCriterion("account_status in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotIn(List<String> values) {
            addCriterion("account_status not in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusBetween(String value1, String value2) {
            addCriterion("account_status between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotBetween(String value1, String value2) {
            addCriterion("account_status not between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24IsNull() {
            addCriterion("overdue_month24 is null");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24IsNotNull() {
            addCriterion("overdue_month24 is not null");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24EqualTo(Integer value) {
            addCriterion("overdue_month24 =", value, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24NotEqualTo(Integer value) {
            addCriterion("overdue_month24 <>", value, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24GreaterThan(Integer value) {
            addCriterion("overdue_month24 >", value, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24GreaterThanOrEqualTo(Integer value) {
            addCriterion("overdue_month24 >=", value, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24LessThan(Integer value) {
            addCriterion("overdue_month24 <", value, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24LessThanOrEqualTo(Integer value) {
            addCriterion("overdue_month24 <=", value, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24In(List<Integer> values) {
            addCriterion("overdue_month24 in", values, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24NotIn(List<Integer> values) {
            addCriterion("overdue_month24 not in", values, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24Between(Integer value1, Integer value2) {
            addCriterion("overdue_month24 between", value1, value2, "overdueMonth24");
            return (Criteria) this;
        }

        public Criteria andOverdueMonth24NotBetween(Integer value1, Integer value2) {
            addCriterion("overdue_month24 not between", value1, value2, "overdueMonth24");
            return (Criteria) this;
        }
    }

    /**
     * nj_user_credit
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_user_credit 2018-03-21
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