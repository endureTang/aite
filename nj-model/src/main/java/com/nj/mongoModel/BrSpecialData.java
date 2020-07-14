/**
 * Copyright 2018 bejson.com
 */
package com.nj.mongoModel;

/**
 * Auto-generated: 2018-04-26 15:50:18
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BrSpecialData extends MongoEntity {
    /**
     * 订单id
     */
    private String orderId;
    /**
     * 用户id
     */
    private String userId;

    // br返回字段
    private String code;
    private String swift_number;
    private String sl_lm_cell_nbank_ca_refuse;
    private String sl_lm_cell_nbank_com_fraud;
    private String sl_lm_cell_nbank_ca_bad;
    private String sl_lm_cell_bank_overdue;
    private String sl_lm_cell_nbank_other_refuse;
    private String sl_lm_cell_nbank_mc_fraud;
    private String sl_lm_cell_nbank_mc_lost;
    private String sl_lm_cell_nbank_other_bad;
    private String sl_lm_cell_nbank_mc_overdue;
    private String sl_lm_cell_nbank_com_refuse;
    private String sl_lm_cell_nbank_ca_overdue;
    private String sl_lm_cell_nbank_p2p_bad;
    private String sl_lm_cell_nbank_other_overdue;
    private String sl_lm_cell_bank_fraud;
    private String sl_lm_cell_nbank_ca_fraud;
    private String sl_lm_cell_nbank_cf_lost;
    private String sl_lm_cell_nbank_mc_bad;
    private String sl_lm_cell_nbank_cf_fraud;
    private String sl_lm_cell_nbank_other_fraud;
    private String sl_lm_cell_nbank_p2p_refuse;
    private String sl_lm_cell_nbank_com_lost;
    private String sl_lm_cell_nbank_p2p_lost;
    private String sl_lm_cell_nbank_other_lost;
    private String sl_lm_cell_nbank_com_overdue;
    private String sl_lm_cell_bank_refuse;
    private String sl_lm_cell_nbank_p2p_fraud;
    private String sl_lm_cell_bank_lost;
    private String sl_lm_cell_abnormal;
    private String sl_lm_cell_nbank_p2p_overdue;
    private String sl_lm_cell_phone_overdue;
    private String sl_lm_cell_nbank_cf_overdue;
    private String sl_lm_cell_bank_bad;
    private String sl_lm_cell_nbank_mc_refuse;
    private String sl_lm_cell_nbank_ca_lost;
    private String sl_lm_cell_nbank_cf_bad;
    private String sl_lm_cell_nbank_com_bad;
    private String sl_lm_cell_nbank_cf_refuse;
    private String sl_id_nbank_ca_refuse;
    private String sl_id_nbank_com_fraud;
    private String sl_id_p2p_fraud;
    private String sl_id_nbank_ca_bad;
    private String sl_id_bank_overdue;
    private String sl_id_nbank_other_refuse;
    private String sl_id_nbank_mc_fraud;
    private String sl_id_nbank_mc_lost;
    private String sl_id_nbank_other_bad;
    private String sl_id_court_executed;
    private String sl_id_nbank_mc_overdue;
    private String sl_id_nbank_com_refuse;
    private String sl_id_nbank_ca_overdue;
    private String sl_id_nbank_p2p_bad;
    private String sl_id_p2p_lost;
    private String sl_id_p2p_overdue;
    private String sl_id_nbank_other_overdue;
    private String sl_id_bank_fraud;
    private String sl_id_p2p_bad;
    private String sl_id_nbank_ca_fraud;
    private String sl_id_nbank_cf_lost;
    private String sl_id_nbank_mc_bad;
    private String sl_id_nbank_cf_fraud;
    private String sl_id_nbank_other_fraud;
    private String sl_id_nbank_p2p_refuse;
    private String sl_id_nbank_com_lost;
    private String sl_id_nbank_p2p_lost;
    private String sl_id_nbank_other_lost;
    private String sl_id_nbank_com_overdue;
    private String sl_id_bank_refuse;
    private String sl_id_nbank_p2p_fraud;
    private String sl_id_bank_lost;
    private String sl_id_abnormal;
    private String sl_id_nbank_p2p_overdue;
    private String sl_id_phone_overdue;
    private String sl_id_nbank_cf_overdue;
    private String sl_id_bank_bad;
    private String sl_id_nbank_mc_refuse;
    private String sl_id_nbank_ca_lost;
    private String sl_id_nbank_cf_bad;
    private String sl_id_court_bad;
    private String sl_id_nbank_com_bad;
    private String sl_id_nbank_cf_refuse;
    private String sl_id_p2p_refuse;
    private String sl_cell_nbank_ca_refuse;
    private String sl_cell_nbank_com_fraud;
    private String sl_cell_p2p_fraud;
    private String sl_cell_nbank_ca_bad;
    private String sl_cell_bank_overdue;
    private String sl_cell_nbank_other_refuse;
    private String sl_cell_nbank_mc_fraud;
    private String sl_cell_nbank_mc_lost;
    private String sl_cell_nbank_other_bad;
    private String sl_cell_nbank_mc_overdue;
    private String sl_cell_nbank_com_refuse;
    private String sl_cell_nbank_ca_overdue;
    private String sl_cell_nbank_p2p_bad;
    private String sl_cell_p2p_lost;
    private String sl_cell_p2p_overdue;
    private String sl_cell_nbank_other_overdue;
    private String sl_cell_bank_fraud;
    private String sl_cell_p2p_bad;
    private String sl_cell_nbank_ca_fraud;
    private String sl_cell_nbank_cf_lost;
    private String sl_cell_nbank_mc_bad;
    private String sl_cell_nbank_cf_fraud;
    private String sl_cell_nbank_other_fraud;
    private String sl_cell_nbank_p2p_refuse;
    private String sl_cell_nbank_com_lost;
    private String sl_cell_nbank_p2p_lost;
    private String sl_cell_nbank_other_lost;
    private String sl_cell_nbank_com_overdue;
    private String sl_cell_bank_refuse;
    private String sl_cell_nbank_p2p_fraud;
    private String sl_cell_bank_lost;
    private String sl_cell_abnormal;
    private String sl_cell_nbank_p2p_overdue;
    private String sl_cell_phone_overdue;
    private String sl_cell_nbank_cf_overdue;
    private String sl_cell_bank_bad;
    private String sl_cell_nbank_mc_refuse;
    private String sl_cell_nbank_ca_lost;
    private String sl_cell_nbank_cf_bad;
    private String sl_cell_nbank_com_bad;
    private String sl_cell_nbank_cf_refuse;
    private String sl_cell_p2p_refuse;
    private String flag_specialList_c;

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setSwift_number(String swift_number) {
        this.swift_number = swift_number;
    }

    public String getSwift_number() {
        return swift_number;
    }

    public void setSl_lm_cell_nbank_ca_refuse(String sl_lm_cell_nbank_ca_refuse) {
        this.sl_lm_cell_nbank_ca_refuse = sl_lm_cell_nbank_ca_refuse;
    }

    public String getSl_lm_cell_nbank_ca_refuse() {
        return sl_lm_cell_nbank_ca_refuse;
    }

    public void setSl_lm_cell_nbank_com_fraud(String sl_lm_cell_nbank_com_fraud) {
        this.sl_lm_cell_nbank_com_fraud = sl_lm_cell_nbank_com_fraud;
    }

    public String getSl_lm_cell_nbank_com_fraud() {
        return sl_lm_cell_nbank_com_fraud;
    }

    public void setSl_lm_cell_nbank_ca_bad(String sl_lm_cell_nbank_ca_bad) {
        this.sl_lm_cell_nbank_ca_bad = sl_lm_cell_nbank_ca_bad;
    }

    public String getSl_lm_cell_nbank_ca_bad() {
        return sl_lm_cell_nbank_ca_bad;
    }

    public void setSl_lm_cell_bank_overdue(String sl_lm_cell_bank_overdue) {
        this.sl_lm_cell_bank_overdue = sl_lm_cell_bank_overdue;
    }

    public String getSl_lm_cell_bank_overdue() {
        return sl_lm_cell_bank_overdue;
    }

    public void setSl_lm_cell_nbank_other_refuse(String sl_lm_cell_nbank_other_refuse) {
        this.sl_lm_cell_nbank_other_refuse = sl_lm_cell_nbank_other_refuse;
    }

    public String getSl_lm_cell_nbank_other_refuse() {
        return sl_lm_cell_nbank_other_refuse;
    }

    public void setSl_lm_cell_nbank_mc_fraud(String sl_lm_cell_nbank_mc_fraud) {
        this.sl_lm_cell_nbank_mc_fraud = sl_lm_cell_nbank_mc_fraud;
    }

    public String getSl_lm_cell_nbank_mc_fraud() {
        return sl_lm_cell_nbank_mc_fraud;
    }

    public void setSl_lm_cell_nbank_mc_lost(String sl_lm_cell_nbank_mc_lost) {
        this.sl_lm_cell_nbank_mc_lost = sl_lm_cell_nbank_mc_lost;
    }

    public String getSl_lm_cell_nbank_mc_lost() {
        return sl_lm_cell_nbank_mc_lost;
    }

    public void setSl_lm_cell_nbank_other_bad(String sl_lm_cell_nbank_other_bad) {
        this.sl_lm_cell_nbank_other_bad = sl_lm_cell_nbank_other_bad;
    }

    public String getSl_lm_cell_nbank_other_bad() {
        return sl_lm_cell_nbank_other_bad;
    }

    public void setSl_lm_cell_nbank_mc_overdue(String sl_lm_cell_nbank_mc_overdue) {
        this.sl_lm_cell_nbank_mc_overdue = sl_lm_cell_nbank_mc_overdue;
    }

    public String getSl_lm_cell_nbank_mc_overdue() {
        return sl_lm_cell_nbank_mc_overdue;
    }

    public void setSl_lm_cell_nbank_com_refuse(String sl_lm_cell_nbank_com_refuse) {
        this.sl_lm_cell_nbank_com_refuse = sl_lm_cell_nbank_com_refuse;
    }

    public String getSl_lm_cell_nbank_com_refuse() {
        return sl_lm_cell_nbank_com_refuse;
    }

    public void setSl_lm_cell_nbank_ca_overdue(String sl_lm_cell_nbank_ca_overdue) {
        this.sl_lm_cell_nbank_ca_overdue = sl_lm_cell_nbank_ca_overdue;
    }

    public String getSl_lm_cell_nbank_ca_overdue() {
        return sl_lm_cell_nbank_ca_overdue;
    }

    public void setSl_lm_cell_nbank_p2p_bad(String sl_lm_cell_nbank_p2p_bad) {
        this.sl_lm_cell_nbank_p2p_bad = sl_lm_cell_nbank_p2p_bad;
    }

    public String getSl_lm_cell_nbank_p2p_bad() {
        return sl_lm_cell_nbank_p2p_bad;
    }

    public void setSl_lm_cell_nbank_other_overdue(String sl_lm_cell_nbank_other_overdue) {
        this.sl_lm_cell_nbank_other_overdue = sl_lm_cell_nbank_other_overdue;
    }

    public String getSl_lm_cell_nbank_other_overdue() {
        return sl_lm_cell_nbank_other_overdue;
    }

    public void setSl_lm_cell_bank_fraud(String sl_lm_cell_bank_fraud) {
        this.sl_lm_cell_bank_fraud = sl_lm_cell_bank_fraud;
    }

    public String getSl_lm_cell_bank_fraud() {
        return sl_lm_cell_bank_fraud;
    }

    public void setSl_lm_cell_nbank_ca_fraud(String sl_lm_cell_nbank_ca_fraud) {
        this.sl_lm_cell_nbank_ca_fraud = sl_lm_cell_nbank_ca_fraud;
    }

    public String getSl_lm_cell_nbank_ca_fraud() {
        return sl_lm_cell_nbank_ca_fraud;
    }

    public void setSl_lm_cell_nbank_cf_lost(String sl_lm_cell_nbank_cf_lost) {
        this.sl_lm_cell_nbank_cf_lost = sl_lm_cell_nbank_cf_lost;
    }

    public String getSl_lm_cell_nbank_cf_lost() {
        return sl_lm_cell_nbank_cf_lost;
    }

    public void setSl_lm_cell_nbank_mc_bad(String sl_lm_cell_nbank_mc_bad) {
        this.sl_lm_cell_nbank_mc_bad = sl_lm_cell_nbank_mc_bad;
    }

    public String getSl_lm_cell_nbank_mc_bad() {
        return sl_lm_cell_nbank_mc_bad;
    }

    public void setSl_lm_cell_nbank_cf_fraud(String sl_lm_cell_nbank_cf_fraud) {
        this.sl_lm_cell_nbank_cf_fraud = sl_lm_cell_nbank_cf_fraud;
    }

    public String getSl_lm_cell_nbank_cf_fraud() {
        return sl_lm_cell_nbank_cf_fraud;
    }

    public void setSl_lm_cell_nbank_other_fraud(String sl_lm_cell_nbank_other_fraud) {
        this.sl_lm_cell_nbank_other_fraud = sl_lm_cell_nbank_other_fraud;
    }

    public String getSl_lm_cell_nbank_other_fraud() {
        return sl_lm_cell_nbank_other_fraud;
    }

    public void setSl_lm_cell_nbank_p2p_refuse(String sl_lm_cell_nbank_p2p_refuse) {
        this.sl_lm_cell_nbank_p2p_refuse = sl_lm_cell_nbank_p2p_refuse;
    }

    public String getSl_lm_cell_nbank_p2p_refuse() {
        return sl_lm_cell_nbank_p2p_refuse;
    }

    public void setSl_lm_cell_nbank_com_lost(String sl_lm_cell_nbank_com_lost) {
        this.sl_lm_cell_nbank_com_lost = sl_lm_cell_nbank_com_lost;
    }

    public String getSl_lm_cell_nbank_com_lost() {
        return sl_lm_cell_nbank_com_lost;
    }

    public void setSl_lm_cell_nbank_p2p_lost(String sl_lm_cell_nbank_p2p_lost) {
        this.sl_lm_cell_nbank_p2p_lost = sl_lm_cell_nbank_p2p_lost;
    }

    public String getSl_lm_cell_nbank_p2p_lost() {
        return sl_lm_cell_nbank_p2p_lost;
    }

    public void setSl_lm_cell_nbank_other_lost(String sl_lm_cell_nbank_other_lost) {
        this.sl_lm_cell_nbank_other_lost = sl_lm_cell_nbank_other_lost;
    }

    public String getSl_lm_cell_nbank_other_lost() {
        return sl_lm_cell_nbank_other_lost;
    }

    public void setSl_lm_cell_nbank_com_overdue(String sl_lm_cell_nbank_com_overdue) {
        this.sl_lm_cell_nbank_com_overdue = sl_lm_cell_nbank_com_overdue;
    }

    public String getSl_lm_cell_nbank_com_overdue() {
        return sl_lm_cell_nbank_com_overdue;
    }

    public void setSl_lm_cell_bank_refuse(String sl_lm_cell_bank_refuse) {
        this.sl_lm_cell_bank_refuse = sl_lm_cell_bank_refuse;
    }

    public String getSl_lm_cell_bank_refuse() {
        return sl_lm_cell_bank_refuse;
    }

    public void setSl_lm_cell_nbank_p2p_fraud(String sl_lm_cell_nbank_p2p_fraud) {
        this.sl_lm_cell_nbank_p2p_fraud = sl_lm_cell_nbank_p2p_fraud;
    }

    public String getSl_lm_cell_nbank_p2p_fraud() {
        return sl_lm_cell_nbank_p2p_fraud;
    }

    public void setSl_lm_cell_bank_lost(String sl_lm_cell_bank_lost) {
        this.sl_lm_cell_bank_lost = sl_lm_cell_bank_lost;
    }

    public String getSl_lm_cell_bank_lost() {
        return sl_lm_cell_bank_lost;
    }

    public void setSl_lm_cell_abnormal(String sl_lm_cell_abnormal) {
        this.sl_lm_cell_abnormal = sl_lm_cell_abnormal;
    }

    public String getSl_lm_cell_abnormal() {
        return sl_lm_cell_abnormal;
    }

    public void setSl_lm_cell_nbank_p2p_overdue(String sl_lm_cell_nbank_p2p_overdue) {
        this.sl_lm_cell_nbank_p2p_overdue = sl_lm_cell_nbank_p2p_overdue;
    }

    public String getSl_lm_cell_nbank_p2p_overdue() {
        return sl_lm_cell_nbank_p2p_overdue;
    }

    public void setSl_lm_cell_phone_overdue(String sl_lm_cell_phone_overdue) {
        this.sl_lm_cell_phone_overdue = sl_lm_cell_phone_overdue;
    }

    public String getSl_lm_cell_phone_overdue() {
        return sl_lm_cell_phone_overdue;
    }

    public void setSl_lm_cell_nbank_cf_overdue(String sl_lm_cell_nbank_cf_overdue) {
        this.sl_lm_cell_nbank_cf_overdue = sl_lm_cell_nbank_cf_overdue;
    }

    public String getSl_lm_cell_nbank_cf_overdue() {
        return sl_lm_cell_nbank_cf_overdue;
    }

    public void setSl_lm_cell_bank_bad(String sl_lm_cell_bank_bad) {
        this.sl_lm_cell_bank_bad = sl_lm_cell_bank_bad;
    }

    public String getSl_lm_cell_bank_bad() {
        return sl_lm_cell_bank_bad;
    }

    public void setSl_lm_cell_nbank_mc_refuse(String sl_lm_cell_nbank_mc_refuse) {
        this.sl_lm_cell_nbank_mc_refuse = sl_lm_cell_nbank_mc_refuse;
    }

    public String getSl_lm_cell_nbank_mc_refuse() {
        return sl_lm_cell_nbank_mc_refuse;
    }

    public void setSl_lm_cell_nbank_ca_lost(String sl_lm_cell_nbank_ca_lost) {
        this.sl_lm_cell_nbank_ca_lost = sl_lm_cell_nbank_ca_lost;
    }

    public String getSl_lm_cell_nbank_ca_lost() {
        return sl_lm_cell_nbank_ca_lost;
    }

    public void setSl_lm_cell_nbank_cf_bad(String sl_lm_cell_nbank_cf_bad) {
        this.sl_lm_cell_nbank_cf_bad = sl_lm_cell_nbank_cf_bad;
    }

    public String getSl_lm_cell_nbank_cf_bad() {
        return sl_lm_cell_nbank_cf_bad;
    }

    public void setSl_lm_cell_nbank_com_bad(String sl_lm_cell_nbank_com_bad) {
        this.sl_lm_cell_nbank_com_bad = sl_lm_cell_nbank_com_bad;
    }

    public String getSl_lm_cell_nbank_com_bad() {
        return sl_lm_cell_nbank_com_bad;
    }

    public void setSl_lm_cell_nbank_cf_refuse(String sl_lm_cell_nbank_cf_refuse) {
        this.sl_lm_cell_nbank_cf_refuse = sl_lm_cell_nbank_cf_refuse;
    }

    public String getSl_lm_cell_nbank_cf_refuse() {
        return sl_lm_cell_nbank_cf_refuse;
    }

    public void setSl_id_nbank_ca_refuse(String sl_id_nbank_ca_refuse) {
        this.sl_id_nbank_ca_refuse = sl_id_nbank_ca_refuse;
    }

    public String getSl_id_nbank_ca_refuse() {
        return sl_id_nbank_ca_refuse;
    }

    public void setSl_id_nbank_com_fraud(String sl_id_nbank_com_fraud) {
        this.sl_id_nbank_com_fraud = sl_id_nbank_com_fraud;
    }

    public String getSl_id_nbank_com_fraud() {
        return sl_id_nbank_com_fraud;
    }

    public void setSl_id_p2p_fraud(String sl_id_p2p_fraud) {
        this.sl_id_p2p_fraud = sl_id_p2p_fraud;
    }

    public String getSl_id_p2p_fraud() {
        return sl_id_p2p_fraud;
    }

    public void setSl_id_nbank_ca_bad(String sl_id_nbank_ca_bad) {
        this.sl_id_nbank_ca_bad = sl_id_nbank_ca_bad;
    }

    public String getSl_id_nbank_ca_bad() {
        return sl_id_nbank_ca_bad;
    }

    public void setSl_id_bank_overdue(String sl_id_bank_overdue) {
        this.sl_id_bank_overdue = sl_id_bank_overdue;
    }

    public String getSl_id_bank_overdue() {
        return sl_id_bank_overdue;
    }

    public void setSl_id_nbank_other_refuse(String sl_id_nbank_other_refuse) {
        this.sl_id_nbank_other_refuse = sl_id_nbank_other_refuse;
    }

    public String getSl_id_nbank_other_refuse() {
        return sl_id_nbank_other_refuse;
    }

    public void setSl_id_nbank_mc_fraud(String sl_id_nbank_mc_fraud) {
        this.sl_id_nbank_mc_fraud = sl_id_nbank_mc_fraud;
    }

    public String getSl_id_nbank_mc_fraud() {
        return sl_id_nbank_mc_fraud;
    }

    public void setSl_id_nbank_mc_lost(String sl_id_nbank_mc_lost) {
        this.sl_id_nbank_mc_lost = sl_id_nbank_mc_lost;
    }

    public String getSl_id_nbank_mc_lost() {
        return sl_id_nbank_mc_lost;
    }

    public void setSl_id_nbank_other_bad(String sl_id_nbank_other_bad) {
        this.sl_id_nbank_other_bad = sl_id_nbank_other_bad;
    }

    public String getSl_id_nbank_other_bad() {
        return sl_id_nbank_other_bad;
    }

    public void setSl_id_court_executed(String sl_id_court_executed) {
        this.sl_id_court_executed = sl_id_court_executed;
    }

    public String getSl_id_court_executed() {
        return sl_id_court_executed;
    }

    public void setSl_id_nbank_mc_overdue(String sl_id_nbank_mc_overdue) {
        this.sl_id_nbank_mc_overdue = sl_id_nbank_mc_overdue;
    }

    public String getSl_id_nbank_mc_overdue() {
        return sl_id_nbank_mc_overdue;
    }

    public void setSl_id_nbank_com_refuse(String sl_id_nbank_com_refuse) {
        this.sl_id_nbank_com_refuse = sl_id_nbank_com_refuse;
    }

    public String getSl_id_nbank_com_refuse() {
        return sl_id_nbank_com_refuse;
    }

    public void setSl_id_nbank_ca_overdue(String sl_id_nbank_ca_overdue) {
        this.sl_id_nbank_ca_overdue = sl_id_nbank_ca_overdue;
    }

    public String getSl_id_nbank_ca_overdue() {
        return sl_id_nbank_ca_overdue;
    }

    public void setSl_id_nbank_p2p_bad(String sl_id_nbank_p2p_bad) {
        this.sl_id_nbank_p2p_bad = sl_id_nbank_p2p_bad;
    }

    public String getSl_id_nbank_p2p_bad() {
        return sl_id_nbank_p2p_bad;
    }

    public void setSl_id_p2p_lost(String sl_id_p2p_lost) {
        this.sl_id_p2p_lost = sl_id_p2p_lost;
    }

    public String getSl_id_p2p_lost() {
        return sl_id_p2p_lost;
    }

    public void setSl_id_p2p_overdue(String sl_id_p2p_overdue) {
        this.sl_id_p2p_overdue = sl_id_p2p_overdue;
    }

    public String getSl_id_p2p_overdue() {
        return sl_id_p2p_overdue;
    }

    public void setSl_id_nbank_other_overdue(String sl_id_nbank_other_overdue) {
        this.sl_id_nbank_other_overdue = sl_id_nbank_other_overdue;
    }

    public String getSl_id_nbank_other_overdue() {
        return sl_id_nbank_other_overdue;
    }

    public void setSl_id_bank_fraud(String sl_id_bank_fraud) {
        this.sl_id_bank_fraud = sl_id_bank_fraud;
    }

    public String getSl_id_bank_fraud() {
        return sl_id_bank_fraud;
    }

    public void setSl_id_p2p_bad(String sl_id_p2p_bad) {
        this.sl_id_p2p_bad = sl_id_p2p_bad;
    }

    public String getSl_id_p2p_bad() {
        return sl_id_p2p_bad;
    }

    public void setSl_id_nbank_ca_fraud(String sl_id_nbank_ca_fraud) {
        this.sl_id_nbank_ca_fraud = sl_id_nbank_ca_fraud;
    }

    public String getSl_id_nbank_ca_fraud() {
        return sl_id_nbank_ca_fraud;
    }

    public void setSl_id_nbank_cf_lost(String sl_id_nbank_cf_lost) {
        this.sl_id_nbank_cf_lost = sl_id_nbank_cf_lost;
    }

    public String getSl_id_nbank_cf_lost() {
        return sl_id_nbank_cf_lost;
    }

    public void setSl_id_nbank_mc_bad(String sl_id_nbank_mc_bad) {
        this.sl_id_nbank_mc_bad = sl_id_nbank_mc_bad;
    }

    public String getSl_id_nbank_mc_bad() {
        return sl_id_nbank_mc_bad;
    }

    public void setSl_id_nbank_cf_fraud(String sl_id_nbank_cf_fraud) {
        this.sl_id_nbank_cf_fraud = sl_id_nbank_cf_fraud;
    }

    public String getSl_id_nbank_cf_fraud() {
        return sl_id_nbank_cf_fraud;
    }

    public void setSl_id_nbank_other_fraud(String sl_id_nbank_other_fraud) {
        this.sl_id_nbank_other_fraud = sl_id_nbank_other_fraud;
    }

    public String getSl_id_nbank_other_fraud() {
        return sl_id_nbank_other_fraud;
    }

    public void setSl_id_nbank_p2p_refuse(String sl_id_nbank_p2p_refuse) {
        this.sl_id_nbank_p2p_refuse = sl_id_nbank_p2p_refuse;
    }

    public String getSl_id_nbank_p2p_refuse() {
        return sl_id_nbank_p2p_refuse;
    }

    public void setSl_id_nbank_com_lost(String sl_id_nbank_com_lost) {
        this.sl_id_nbank_com_lost = sl_id_nbank_com_lost;
    }

    public String getSl_id_nbank_com_lost() {
        return sl_id_nbank_com_lost;
    }

    public void setSl_id_nbank_p2p_lost(String sl_id_nbank_p2p_lost) {
        this.sl_id_nbank_p2p_lost = sl_id_nbank_p2p_lost;
    }

    public String getSl_id_nbank_p2p_lost() {
        return sl_id_nbank_p2p_lost;
    }

    public void setSl_id_nbank_other_lost(String sl_id_nbank_other_lost) {
        this.sl_id_nbank_other_lost = sl_id_nbank_other_lost;
    }

    public String getSl_id_nbank_other_lost() {
        return sl_id_nbank_other_lost;
    }

    public void setSl_id_nbank_com_overdue(String sl_id_nbank_com_overdue) {
        this.sl_id_nbank_com_overdue = sl_id_nbank_com_overdue;
    }

    public String getSl_id_nbank_com_overdue() {
        return sl_id_nbank_com_overdue;
    }

    public void setSl_id_bank_refuse(String sl_id_bank_refuse) {
        this.sl_id_bank_refuse = sl_id_bank_refuse;
    }

    public String getSl_id_bank_refuse() {
        return sl_id_bank_refuse;
    }

    public void setSl_id_nbank_p2p_fraud(String sl_id_nbank_p2p_fraud) {
        this.sl_id_nbank_p2p_fraud = sl_id_nbank_p2p_fraud;
    }

    public String getSl_id_nbank_p2p_fraud() {
        return sl_id_nbank_p2p_fraud;
    }

    public void setSl_id_bank_lost(String sl_id_bank_lost) {
        this.sl_id_bank_lost = sl_id_bank_lost;
    }

    public String getSl_id_bank_lost() {
        return sl_id_bank_lost;
    }

    public void setSl_id_abnormal(String sl_id_abnormal) {
        this.sl_id_abnormal = sl_id_abnormal;
    }

    public String getSl_id_abnormal() {
        return sl_id_abnormal;
    }

    public void setSl_id_nbank_p2p_overdue(String sl_id_nbank_p2p_overdue) {
        this.sl_id_nbank_p2p_overdue = sl_id_nbank_p2p_overdue;
    }

    public String getSl_id_nbank_p2p_overdue() {
        return sl_id_nbank_p2p_overdue;
    }

    public void setSl_id_phone_overdue(String sl_id_phone_overdue) {
        this.sl_id_phone_overdue = sl_id_phone_overdue;
    }

    public String getSl_id_phone_overdue() {
        return sl_id_phone_overdue;
    }

    public void setSl_id_nbank_cf_overdue(String sl_id_nbank_cf_overdue) {
        this.sl_id_nbank_cf_overdue = sl_id_nbank_cf_overdue;
    }

    public String getSl_id_nbank_cf_overdue() {
        return sl_id_nbank_cf_overdue;
    }

    public void setSl_id_bank_bad(String sl_id_bank_bad) {
        this.sl_id_bank_bad = sl_id_bank_bad;
    }

    public String getSl_id_bank_bad() {
        return sl_id_bank_bad;
    }

    public void setSl_id_nbank_mc_refuse(String sl_id_nbank_mc_refuse) {
        this.sl_id_nbank_mc_refuse = sl_id_nbank_mc_refuse;
    }

    public String getSl_id_nbank_mc_refuse() {
        return sl_id_nbank_mc_refuse;
    }

    public void setSl_id_nbank_ca_lost(String sl_id_nbank_ca_lost) {
        this.sl_id_nbank_ca_lost = sl_id_nbank_ca_lost;
    }

    public String getSl_id_nbank_ca_lost() {
        return sl_id_nbank_ca_lost;
    }

    public void setSl_id_nbank_cf_bad(String sl_id_nbank_cf_bad) {
        this.sl_id_nbank_cf_bad = sl_id_nbank_cf_bad;
    }

    public String getSl_id_nbank_cf_bad() {
        return sl_id_nbank_cf_bad;
    }

    public void setSl_id_court_bad(String sl_id_court_bad) {
        this.sl_id_court_bad = sl_id_court_bad;
    }

    public String getSl_id_court_bad() {
        return sl_id_court_bad;
    }

    public void setSl_id_nbank_com_bad(String sl_id_nbank_com_bad) {
        this.sl_id_nbank_com_bad = sl_id_nbank_com_bad;
    }

    public String getSl_id_nbank_com_bad() {
        return sl_id_nbank_com_bad;
    }

    public void setSl_id_nbank_cf_refuse(String sl_id_nbank_cf_refuse) {
        this.sl_id_nbank_cf_refuse = sl_id_nbank_cf_refuse;
    }

    public String getSl_id_nbank_cf_refuse() {
        return sl_id_nbank_cf_refuse;
    }

    public void setSl_id_p2p_refuse(String sl_id_p2p_refuse) {
        this.sl_id_p2p_refuse = sl_id_p2p_refuse;
    }

    public String getSl_id_p2p_refuse() {
        return sl_id_p2p_refuse;
    }

    public void setSl_cell_nbank_ca_refuse(String sl_cell_nbank_ca_refuse) {
        this.sl_cell_nbank_ca_refuse = sl_cell_nbank_ca_refuse;
    }

    public String getSl_cell_nbank_ca_refuse() {
        return sl_cell_nbank_ca_refuse;
    }

    public void setSl_cell_nbank_com_fraud(String sl_cell_nbank_com_fraud) {
        this.sl_cell_nbank_com_fraud = sl_cell_nbank_com_fraud;
    }

    public String getSl_cell_nbank_com_fraud() {
        return sl_cell_nbank_com_fraud;
    }

    public void setSl_cell_p2p_fraud(String sl_cell_p2p_fraud) {
        this.sl_cell_p2p_fraud = sl_cell_p2p_fraud;
    }

    public String getSl_cell_p2p_fraud() {
        return sl_cell_p2p_fraud;
    }

    public void setSl_cell_nbank_ca_bad(String sl_cell_nbank_ca_bad) {
        this.sl_cell_nbank_ca_bad = sl_cell_nbank_ca_bad;
    }

    public String getSl_cell_nbank_ca_bad() {
        return sl_cell_nbank_ca_bad;
    }

    public void setSl_cell_bank_overdue(String sl_cell_bank_overdue) {
        this.sl_cell_bank_overdue = sl_cell_bank_overdue;
    }

    public String getSl_cell_bank_overdue() {
        return sl_cell_bank_overdue;
    }

    public void setSl_cell_nbank_other_refuse(String sl_cell_nbank_other_refuse) {
        this.sl_cell_nbank_other_refuse = sl_cell_nbank_other_refuse;
    }

    public String getSl_cell_nbank_other_refuse() {
        return sl_cell_nbank_other_refuse;
    }

    public void setSl_cell_nbank_mc_fraud(String sl_cell_nbank_mc_fraud) {
        this.sl_cell_nbank_mc_fraud = sl_cell_nbank_mc_fraud;
    }

    public String getSl_cell_nbank_mc_fraud() {
        return sl_cell_nbank_mc_fraud;
    }

    public void setSl_cell_nbank_mc_lost(String sl_cell_nbank_mc_lost) {
        this.sl_cell_nbank_mc_lost = sl_cell_nbank_mc_lost;
    }

    public String getSl_cell_nbank_mc_lost() {
        return sl_cell_nbank_mc_lost;
    }

    public void setSl_cell_nbank_other_bad(String sl_cell_nbank_other_bad) {
        this.sl_cell_nbank_other_bad = sl_cell_nbank_other_bad;
    }

    public String getSl_cell_nbank_other_bad() {
        return sl_cell_nbank_other_bad;
    }

    public void setSl_cell_nbank_mc_overdue(String sl_cell_nbank_mc_overdue) {
        this.sl_cell_nbank_mc_overdue = sl_cell_nbank_mc_overdue;
    }

    public String getSl_cell_nbank_mc_overdue() {
        return sl_cell_nbank_mc_overdue;
    }

    public void setSl_cell_nbank_com_refuse(String sl_cell_nbank_com_refuse) {
        this.sl_cell_nbank_com_refuse = sl_cell_nbank_com_refuse;
    }

    public String getSl_cell_nbank_com_refuse() {
        return sl_cell_nbank_com_refuse;
    }

    public void setSl_cell_nbank_ca_overdue(String sl_cell_nbank_ca_overdue) {
        this.sl_cell_nbank_ca_overdue = sl_cell_nbank_ca_overdue;
    }

    public String getSl_cell_nbank_ca_overdue() {
        return sl_cell_nbank_ca_overdue;
    }

    public void setSl_cell_nbank_p2p_bad(String sl_cell_nbank_p2p_bad) {
        this.sl_cell_nbank_p2p_bad = sl_cell_nbank_p2p_bad;
    }

    public String getSl_cell_nbank_p2p_bad() {
        return sl_cell_nbank_p2p_bad;
    }

    public void setSl_cell_p2p_lost(String sl_cell_p2p_lost) {
        this.sl_cell_p2p_lost = sl_cell_p2p_lost;
    }

    public String getSl_cell_p2p_lost() {
        return sl_cell_p2p_lost;
    }

    public void setSl_cell_p2p_overdue(String sl_cell_p2p_overdue) {
        this.sl_cell_p2p_overdue = sl_cell_p2p_overdue;
    }

    public String getSl_cell_p2p_overdue() {
        return sl_cell_p2p_overdue;
    }

    public void setSl_cell_nbank_other_overdue(String sl_cell_nbank_other_overdue) {
        this.sl_cell_nbank_other_overdue = sl_cell_nbank_other_overdue;
    }

    public String getSl_cell_nbank_other_overdue() {
        return sl_cell_nbank_other_overdue;
    }

    public void setSl_cell_bank_fraud(String sl_cell_bank_fraud) {
        this.sl_cell_bank_fraud = sl_cell_bank_fraud;
    }

    public String getSl_cell_bank_fraud() {
        return sl_cell_bank_fraud;
    }

    public void setSl_cell_p2p_bad(String sl_cell_p2p_bad) {
        this.sl_cell_p2p_bad = sl_cell_p2p_bad;
    }

    public String getSl_cell_p2p_bad() {
        return sl_cell_p2p_bad;
    }

    public void setSl_cell_nbank_ca_fraud(String sl_cell_nbank_ca_fraud) {
        this.sl_cell_nbank_ca_fraud = sl_cell_nbank_ca_fraud;
    }

    public String getSl_cell_nbank_ca_fraud() {
        return sl_cell_nbank_ca_fraud;
    }

    public void setSl_cell_nbank_cf_lost(String sl_cell_nbank_cf_lost) {
        this.sl_cell_nbank_cf_lost = sl_cell_nbank_cf_lost;
    }

    public String getSl_cell_nbank_cf_lost() {
        return sl_cell_nbank_cf_lost;
    }

    public void setSl_cell_nbank_mc_bad(String sl_cell_nbank_mc_bad) {
        this.sl_cell_nbank_mc_bad = sl_cell_nbank_mc_bad;
    }

    public String getSl_cell_nbank_mc_bad() {
        return sl_cell_nbank_mc_bad;
    }

    public void setSl_cell_nbank_cf_fraud(String sl_cell_nbank_cf_fraud) {
        this.sl_cell_nbank_cf_fraud = sl_cell_nbank_cf_fraud;
    }

    public String getSl_cell_nbank_cf_fraud() {
        return sl_cell_nbank_cf_fraud;
    }

    public void setSl_cell_nbank_other_fraud(String sl_cell_nbank_other_fraud) {
        this.sl_cell_nbank_other_fraud = sl_cell_nbank_other_fraud;
    }

    public String getSl_cell_nbank_other_fraud() {
        return sl_cell_nbank_other_fraud;
    }

    public void setSl_cell_nbank_p2p_refuse(String sl_cell_nbank_p2p_refuse) {
        this.sl_cell_nbank_p2p_refuse = sl_cell_nbank_p2p_refuse;
    }

    public String getSl_cell_nbank_p2p_refuse() {
        return sl_cell_nbank_p2p_refuse;
    }

    public void setSl_cell_nbank_com_lost(String sl_cell_nbank_com_lost) {
        this.sl_cell_nbank_com_lost = sl_cell_nbank_com_lost;
    }

    public String getSl_cell_nbank_com_lost() {
        return sl_cell_nbank_com_lost;
    }

    public void setSl_cell_nbank_p2p_lost(String sl_cell_nbank_p2p_lost) {
        this.sl_cell_nbank_p2p_lost = sl_cell_nbank_p2p_lost;
    }

    public String getSl_cell_nbank_p2p_lost() {
        return sl_cell_nbank_p2p_lost;
    }

    public void setSl_cell_nbank_other_lost(String sl_cell_nbank_other_lost) {
        this.sl_cell_nbank_other_lost = sl_cell_nbank_other_lost;
    }

    public String getSl_cell_nbank_other_lost() {
        return sl_cell_nbank_other_lost;
    }

    public void setSl_cell_nbank_com_overdue(String sl_cell_nbank_com_overdue) {
        this.sl_cell_nbank_com_overdue = sl_cell_nbank_com_overdue;
    }

    public String getSl_cell_nbank_com_overdue() {
        return sl_cell_nbank_com_overdue;
    }

    public void setSl_cell_bank_refuse(String sl_cell_bank_refuse) {
        this.sl_cell_bank_refuse = sl_cell_bank_refuse;
    }

    public String getSl_cell_bank_refuse() {
        return sl_cell_bank_refuse;
    }

    public void setSl_cell_nbank_p2p_fraud(String sl_cell_nbank_p2p_fraud) {
        this.sl_cell_nbank_p2p_fraud = sl_cell_nbank_p2p_fraud;
    }

    public String getSl_cell_nbank_p2p_fraud() {
        return sl_cell_nbank_p2p_fraud;
    }

    public void setSl_cell_bank_lost(String sl_cell_bank_lost) {
        this.sl_cell_bank_lost = sl_cell_bank_lost;
    }

    public String getSl_cell_bank_lost() {
        return sl_cell_bank_lost;
    }

    public void setSl_cell_abnormal(String sl_cell_abnormal) {
        this.sl_cell_abnormal = sl_cell_abnormal;
    }

    public String getSl_cell_abnormal() {
        return sl_cell_abnormal;
    }

    public void setSl_cell_nbank_p2p_overdue(String sl_cell_nbank_p2p_overdue) {
        this.sl_cell_nbank_p2p_overdue = sl_cell_nbank_p2p_overdue;
    }

    public String getSl_cell_nbank_p2p_overdue() {
        return sl_cell_nbank_p2p_overdue;
    }

    public void setSl_cell_phone_overdue(String sl_cell_phone_overdue) {
        this.sl_cell_phone_overdue = sl_cell_phone_overdue;
    }

    public String getSl_cell_phone_overdue() {
        return sl_cell_phone_overdue;
    }

    public void setSl_cell_nbank_cf_overdue(String sl_cell_nbank_cf_overdue) {
        this.sl_cell_nbank_cf_overdue = sl_cell_nbank_cf_overdue;
    }

    public String getSl_cell_nbank_cf_overdue() {
        return sl_cell_nbank_cf_overdue;
    }

    public void setSl_cell_bank_bad(String sl_cell_bank_bad) {
        this.sl_cell_bank_bad = sl_cell_bank_bad;
    }

    public String getSl_cell_bank_bad() {
        return sl_cell_bank_bad;
    }

    public void setSl_cell_nbank_mc_refuse(String sl_cell_nbank_mc_refuse) {
        this.sl_cell_nbank_mc_refuse = sl_cell_nbank_mc_refuse;
    }

    public String getSl_cell_nbank_mc_refuse() {
        return sl_cell_nbank_mc_refuse;
    }

    public void setSl_cell_nbank_ca_lost(String sl_cell_nbank_ca_lost) {
        this.sl_cell_nbank_ca_lost = sl_cell_nbank_ca_lost;
    }

    public String getSl_cell_nbank_ca_lost() {
        return sl_cell_nbank_ca_lost;
    }

    public void setSl_cell_nbank_cf_bad(String sl_cell_nbank_cf_bad) {
        this.sl_cell_nbank_cf_bad = sl_cell_nbank_cf_bad;
    }

    public String getSl_cell_nbank_cf_bad() {
        return sl_cell_nbank_cf_bad;
    }

    public void setSl_cell_nbank_com_bad(String sl_cell_nbank_com_bad) {
        this.sl_cell_nbank_com_bad = sl_cell_nbank_com_bad;
    }

    public String getSl_cell_nbank_com_bad() {
        return sl_cell_nbank_com_bad;
    }

    public void setSl_cell_nbank_cf_refuse(String sl_cell_nbank_cf_refuse) {
        this.sl_cell_nbank_cf_refuse = sl_cell_nbank_cf_refuse;
    }

    public String getSl_cell_nbank_cf_refuse() {
        return sl_cell_nbank_cf_refuse;
    }

    public void setSl_cell_p2p_refuse(String sl_cell_p2p_refuse) {
        this.sl_cell_p2p_refuse = sl_cell_p2p_refuse;
    }

    public String getSl_cell_p2p_refuse() {
        return sl_cell_p2p_refuse;
    }

    public void setFlag_specialList_c(String flag_specialList_c) {
        this.flag_specialList_c = flag_specialList_c;
    }

    public String getFlag_specialList_c() {
        return flag_specialList_c;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}