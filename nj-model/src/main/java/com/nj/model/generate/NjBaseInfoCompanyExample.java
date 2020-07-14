package com.nj.model.generate;

import java.util.ArrayList;
import java.util.List;

public class NjBaseInfoCompanyExample {
    /**
     * nj_base_info_company
     */
    protected String orderByClause;

    /**
     * nj_base_info_company
     */
    protected boolean distinct;

    /**
     * nj_base_info_company
     */
    protected List<Criteria> oredCriteria;

    public NjBaseInfoCompanyExample() {
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
     * nj_base_info_company 2019-08-13
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andTyshCodeIsNull() {
            addCriterion("tysh_code is null");
            return (Criteria) this;
        }

        public Criteria andTyshCodeIsNotNull() {
            addCriterion("tysh_code is not null");
            return (Criteria) this;
        }

        public Criteria andTyshCodeEqualTo(String value) {
            addCriterion("tysh_code =", value, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeNotEqualTo(String value) {
            addCriterion("tysh_code <>", value, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeGreaterThan(String value) {
            addCriterion("tysh_code >", value, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeGreaterThanOrEqualTo(String value) {
            addCriterion("tysh_code >=", value, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeLessThan(String value) {
            addCriterion("tysh_code <", value, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeLessThanOrEqualTo(String value) {
            addCriterion("tysh_code <=", value, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeLike(String value) {
            addCriterion("tysh_code like", value, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeNotLike(String value) {
            addCriterion("tysh_code not like", value, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeIn(List<String> values) {
            addCriterion("tysh_code in", values, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeNotIn(List<String> values) {
            addCriterion("tysh_code not in", values, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeBetween(String value1, String value2) {
            addCriterion("tysh_code between", value1, value2, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andTyshCodeNotBetween(String value1, String value2) {
            addCriterion("tysh_code not between", value1, value2, "tyshCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeIsNull() {
            addCriterion("yezz_code is null");
            return (Criteria) this;
        }

        public Criteria andYezzCodeIsNotNull() {
            addCriterion("yezz_code is not null");
            return (Criteria) this;
        }

        public Criteria andYezzCodeEqualTo(String value) {
            addCriterion("yezz_code =", value, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeNotEqualTo(String value) {
            addCriterion("yezz_code <>", value, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeGreaterThan(String value) {
            addCriterion("yezz_code >", value, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeGreaterThanOrEqualTo(String value) {
            addCriterion("yezz_code >=", value, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeLessThan(String value) {
            addCriterion("yezz_code <", value, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeLessThanOrEqualTo(String value) {
            addCriterion("yezz_code <=", value, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeLike(String value) {
            addCriterion("yezz_code like", value, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeNotLike(String value) {
            addCriterion("yezz_code not like", value, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeIn(List<String> values) {
            addCriterion("yezz_code in", values, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeNotIn(List<String> values) {
            addCriterion("yezz_code not in", values, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeBetween(String value1, String value2) {
            addCriterion("yezz_code between", value1, value2, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andYezzCodeNotBetween(String value1, String value2) {
            addCriterion("yezz_code not between", value1, value2, "yezzCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeIsNull() {
            addCriterion("swdj_code is null");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeIsNotNull() {
            addCriterion("swdj_code is not null");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeEqualTo(String value) {
            addCriterion("swdj_code =", value, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeNotEqualTo(String value) {
            addCriterion("swdj_code <>", value, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeGreaterThan(String value) {
            addCriterion("swdj_code >", value, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeGreaterThanOrEqualTo(String value) {
            addCriterion("swdj_code >=", value, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeLessThan(String value) {
            addCriterion("swdj_code <", value, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeLessThanOrEqualTo(String value) {
            addCriterion("swdj_code <=", value, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeLike(String value) {
            addCriterion("swdj_code like", value, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeNotLike(String value) {
            addCriterion("swdj_code not like", value, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeIn(List<String> values) {
            addCriterion("swdj_code in", values, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeNotIn(List<String> values) {
            addCriterion("swdj_code not in", values, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeBetween(String value1, String value2) {
            addCriterion("swdj_code between", value1, value2, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andSwdjCodeNotBetween(String value1, String value2) {
            addCriterion("swdj_code not between", value1, value2, "swdjCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeIsNull() {
            addCriterion("zzjg_code is null");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeIsNotNull() {
            addCriterion("zzjg_code is not null");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeEqualTo(String value) {
            addCriterion("zzjg_code =", value, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeNotEqualTo(String value) {
            addCriterion("zzjg_code <>", value, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeGreaterThan(String value) {
            addCriterion("zzjg_code >", value, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("zzjg_code >=", value, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeLessThan(String value) {
            addCriterion("zzjg_code <", value, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeLessThanOrEqualTo(String value) {
            addCriterion("zzjg_code <=", value, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeLike(String value) {
            addCriterion("zzjg_code like", value, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeNotLike(String value) {
            addCriterion("zzjg_code not like", value, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeIn(List<String> values) {
            addCriterion("zzjg_code in", values, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeNotIn(List<String> values) {
            addCriterion("zzjg_code not in", values, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeBetween(String value1, String value2) {
            addCriterion("zzjg_code between", value1, value2, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andZzjgCodeNotBetween(String value1, String value2) {
            addCriterion("zzjg_code not between", value1, value2, "zzjgCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeIsNull() {
            addCriterion("jgxy_code is null");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeIsNotNull() {
            addCriterion("jgxy_code is not null");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeEqualTo(String value) {
            addCriterion("jgxy_code =", value, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeNotEqualTo(String value) {
            addCriterion("jgxy_code <>", value, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeGreaterThan(String value) {
            addCriterion("jgxy_code >", value, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("jgxy_code >=", value, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeLessThan(String value) {
            addCriterion("jgxy_code <", value, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeLessThanOrEqualTo(String value) {
            addCriterion("jgxy_code <=", value, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeLike(String value) {
            addCriterion("jgxy_code like", value, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeNotLike(String value) {
            addCriterion("jgxy_code not like", value, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeIn(List<String> values) {
            addCriterion("jgxy_code in", values, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeNotIn(List<String> values) {
            addCriterion("jgxy_code not in", values, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeBetween(String value1, String value2) {
            addCriterion("jgxy_code between", value1, value2, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andJgxyCodeNotBetween(String value1, String value2) {
            addCriterion("jgxy_code not between", value1, value2, "jgxyCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeIsNull() {
            addCriterion("bank_xkz_code is null");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeIsNotNull() {
            addCriterion("bank_xkz_code is not null");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeEqualTo(String value) {
            addCriterion("bank_xkz_code =", value, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeNotEqualTo(String value) {
            addCriterion("bank_xkz_code <>", value, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeGreaterThan(String value) {
            addCriterion("bank_xkz_code >", value, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeGreaterThanOrEqualTo(String value) {
            addCriterion("bank_xkz_code >=", value, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeLessThan(String value) {
            addCriterion("bank_xkz_code <", value, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeLessThanOrEqualTo(String value) {
            addCriterion("bank_xkz_code <=", value, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeLike(String value) {
            addCriterion("bank_xkz_code like", value, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeNotLike(String value) {
            addCriterion("bank_xkz_code not like", value, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeIn(List<String> values) {
            addCriterion("bank_xkz_code in", values, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeNotIn(List<String> values) {
            addCriterion("bank_xkz_code not in", values, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeBetween(String value1, String value2) {
            addCriterion("bank_xkz_code between", value1, value2, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankXkzCodeNotBetween(String value1, String value2) {
            addCriterion("bank_xkz_code not between", value1, value2, "bankXkzCode");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountIsNull() {
            addCriterion("bank_out_account is null");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountIsNotNull() {
            addCriterion("bank_out_account is not null");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountEqualTo(String value) {
            addCriterion("bank_out_account =", value, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountNotEqualTo(String value) {
            addCriterion("bank_out_account <>", value, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountGreaterThan(String value) {
            addCriterion("bank_out_account >", value, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_out_account >=", value, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountLessThan(String value) {
            addCriterion("bank_out_account <", value, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_out_account <=", value, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountLike(String value) {
            addCriterion("bank_out_account like", value, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountNotLike(String value) {
            addCriterion("bank_out_account not like", value, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountIn(List<String> values) {
            addCriterion("bank_out_account in", values, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountNotIn(List<String> values) {
            addCriterion("bank_out_account not in", values, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountBetween(String value1, String value2) {
            addCriterion("bank_out_account between", value1, value2, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andBankOutAccountNotBetween(String value1, String value2) {
            addCriterion("bank_out_account not between", value1, value2, "bankOutAccount");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNull() {
            addCriterion("company_nature is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIsNotNull() {
            addCriterion("company_nature is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureEqualTo(String value) {
            addCriterion("company_nature =", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotEqualTo(String value) {
            addCriterion("company_nature <>", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThan(String value) {
            addCriterion("company_nature >", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureGreaterThanOrEqualTo(String value) {
            addCriterion("company_nature >=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThan(String value) {
            addCriterion("company_nature <", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLessThanOrEqualTo(String value) {
            addCriterion("company_nature <=", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureLike(String value) {
            addCriterion("company_nature like", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotLike(String value) {
            addCriterion("company_nature not like", value, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureIn(List<String> values) {
            addCriterion("company_nature in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotIn(List<String> values) {
            addCriterion("company_nature not in", values, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureBetween(String value1, String value2) {
            addCriterion("company_nature between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andCompanyNatureNotBetween(String value1, String value2) {
            addCriterion("company_nature not between", value1, value2, "companyNature");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryIsNull() {
            addCriterion("own_industry is null");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryIsNotNull() {
            addCriterion("own_industry is not null");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryEqualTo(String value) {
            addCriterion("own_industry =", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryNotEqualTo(String value) {
            addCriterion("own_industry <>", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryGreaterThan(String value) {
            addCriterion("own_industry >", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryGreaterThanOrEqualTo(String value) {
            addCriterion("own_industry >=", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryLessThan(String value) {
            addCriterion("own_industry <", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryLessThanOrEqualTo(String value) {
            addCriterion("own_industry <=", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryLike(String value) {
            addCriterion("own_industry like", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryNotLike(String value) {
            addCriterion("own_industry not like", value, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryIn(List<String> values) {
            addCriterion("own_industry in", values, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryNotIn(List<String> values) {
            addCriterion("own_industry not in", values, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryBetween(String value1, String value2) {
            addCriterion("own_industry between", value1, value2, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andOwnIndustryNotBetween(String value1, String value2) {
            addCriterion("own_industry not between", value1, value2, "ownIndustry");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyIsNull() {
            addCriterion("regist_money is null");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyIsNotNull() {
            addCriterion("regist_money is not null");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyEqualTo(String value) {
            addCriterion("regist_money =", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyNotEqualTo(String value) {
            addCriterion("regist_money <>", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyGreaterThan(String value) {
            addCriterion("regist_money >", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyGreaterThanOrEqualTo(String value) {
            addCriterion("regist_money >=", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyLessThan(String value) {
            addCriterion("regist_money <", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyLessThanOrEqualTo(String value) {
            addCriterion("regist_money <=", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyLike(String value) {
            addCriterion("regist_money like", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyNotLike(String value) {
            addCriterion("regist_money not like", value, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyIn(List<String> values) {
            addCriterion("regist_money in", values, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyNotIn(List<String> values) {
            addCriterion("regist_money not in", values, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyBetween(String value1, String value2) {
            addCriterion("regist_money between", value1, value2, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistMoneyNotBetween(String value1, String value2) {
            addCriterion("regist_money not between", value1, value2, "registMoney");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIsNull() {
            addCriterion("regist_address is null");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIsNotNull() {
            addCriterion("regist_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegistAddressEqualTo(String value) {
            addCriterion("regist_address =", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotEqualTo(String value) {
            addCriterion("regist_address <>", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressGreaterThan(String value) {
            addCriterion("regist_address >", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressGreaterThanOrEqualTo(String value) {
            addCriterion("regist_address >=", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLessThan(String value) {
            addCriterion("regist_address <", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLessThanOrEqualTo(String value) {
            addCriterion("regist_address <=", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressLike(String value) {
            addCriterion("regist_address like", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotLike(String value) {
            addCriterion("regist_address not like", value, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressIn(List<String> values) {
            addCriterion("regist_address in", values, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotIn(List<String> values) {
            addCriterion("regist_address not in", values, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressBetween(String value1, String value2) {
            addCriterion("regist_address between", value1, value2, "registAddress");
            return (Criteria) this;
        }

        public Criteria andRegistAddressNotBetween(String value1, String value2) {
            addCriterion("regist_address not between", value1, value2, "registAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNull() {
            addCriterion("company_address is null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIsNotNull() {
            addCriterion("company_address is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressEqualTo(String value) {
            addCriterion("company_address =", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotEqualTo(String value) {
            addCriterion("company_address <>", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThan(String value) {
            addCriterion("company_address >", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressGreaterThanOrEqualTo(String value) {
            addCriterion("company_address >=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThan(String value) {
            addCriterion("company_address <", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLessThanOrEqualTo(String value) {
            addCriterion("company_address <=", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressLike(String value) {
            addCriterion("company_address like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotLike(String value) {
            addCriterion("company_address not like", value, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressIn(List<String> values) {
            addCriterion("company_address in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotIn(List<String> values) {
            addCriterion("company_address not in", values, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressBetween(String value1, String value2) {
            addCriterion("company_address between", value1, value2, "companyAddress");
            return (Criteria) this;
        }

        public Criteria andCompanyAddressNotBetween(String value1, String value2) {
            addCriterion("company_address not between", value1, value2, "companyAddress");
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

        public Criteria andCompanyCreateDateIsNull() {
            addCriterion("company_create_date is null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateIsNotNull() {
            addCriterion("company_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateEqualTo(String value) {
            addCriterion("company_create_date =", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateNotEqualTo(String value) {
            addCriterion("company_create_date <>", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateGreaterThan(String value) {
            addCriterion("company_create_date >", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("company_create_date >=", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateLessThan(String value) {
            addCriterion("company_create_date <", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateLessThanOrEqualTo(String value) {
            addCriterion("company_create_date <=", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateLike(String value) {
            addCriterion("company_create_date like", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateNotLike(String value) {
            addCriterion("company_create_date not like", value, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateIn(List<String> values) {
            addCriterion("company_create_date in", values, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateNotIn(List<String> values) {
            addCriterion("company_create_date not in", values, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateBetween(String value1, String value2) {
            addCriterion("company_create_date between", value1, value2, "companyCreateDate");
            return (Criteria) this;
        }

        public Criteria andCompanyCreateDateNotBetween(String value1, String value2) {
            addCriterion("company_create_date not between", value1, value2, "companyCreateDate");
            return (Criteria) this;
        }
    }

    /**
     * nj_base_info_company
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * nj_base_info_company 2019-08-13
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