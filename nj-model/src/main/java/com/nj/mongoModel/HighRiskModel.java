package com.nj.mongoModel;

/**
 * 高风险信息model
 *
 * @author Lizy
 * @version 2018/8/29.
 */
public class HighRiskModel extends MongoEntity {
    // 身份证命中法院失信名单
    private String id_hit_court_credit_list;
    // 身份证命中犯罪通缉名单
    private String id_hit_court_crime_list;
    // 身份证命中法院执行名单
    private String id_hit_court_excute_list;
    // 身份证命中信贷逾期名单
    private String id_hit_loan_overdue_list;
    // 身份证命中车辆租赁违约名单
    private String id_hit_carrent_default_list;
    // 身份证命中欠款公司法人代表名单
    private String id_hit_busi_default_list;
    // 身份证命中欠税名单
    private String id_hit_tax_default_list;
    // 身份证命中欠税公司法人代表名单
    private String id_hit_busi_tax_default_list;
    // 手机号命中虚假号码库
    private String cell_hit_false_number_db;
    // 手机号命中通信小号库
    private String cell_hit_communication_db;
    // 手机号命中诈骗骚扰库
    private String cell_hit_fraud_crankcall_db;
    // 手机号命中信贷逾期名单
    private String cell_hit_loan_overdue_list;
    // 手机号命中汽车租赁违约名单
    private String cell_hit_carrent_default_list;
    // 手机号命中欠款公司法人代表名单
    private String cell_hit_busi_default_list;
    // 身份证_姓名命中法院结案模糊名单
    private String id_name_hit_court_case_list;
    // 身份证_姓名命中法院执行模糊名单
    private String id_name_hit_court_excute_list;
    // 身份证_姓名命中法院失信模糊名单
    private String id_name_hit_court_credit_list;
    // 身份证_姓名命中信贷逾期模糊名单
    private String id_name_hit_loan_overdue_list;
    // 身份证命中法院结案名单等级
    private String id_hit_court_case_list_level;
    // 身份证命中法院失信名单等级
    private String id_hit_court_credit_list_level;
    // 3个月内身份证关联姓名数量
    private Integer id_relate_name_cnt_m3;
    // 3个月内身份证关联父亲身份证数量
    private Integer id_relate_fatherid_cnt_m3;
    // 3个月内身份证关联母亲身份证数量
    private Integer id_relate_motherid_cnt_m3;
    // 3个月内身份证关联配偶身份证数量
    private Integer id_relate_spouseid_cnt_m3;
    // 身份证命中高风险关注名单
    private String id_hit_high_risk_list;


    public String getId_hit_court_credit_list() {
        return id_hit_court_credit_list;
    }

    public void setId_hit_court_credit_list(String id_hit_court_credit_list) {
        this.id_hit_court_credit_list = id_hit_court_credit_list;
    }

    public String getId_hit_court_crime_list() {
        return id_hit_court_crime_list;
    }

    public void setId_hit_court_crime_list(String id_hit_court_crime_list) {
        this.id_hit_court_crime_list = id_hit_court_crime_list;
    }

    public String getId_hit_court_excute_list() {
        return id_hit_court_excute_list;
    }

    public void setId_hit_court_excute_list(String id_hit_court_excute_list) {
        this.id_hit_court_excute_list = id_hit_court_excute_list;
    }

    public String getId_hit_loan_overdue_list() {
        return id_hit_loan_overdue_list;
    }

    public void setId_hit_loan_overdue_list(String id_hit_loan_overdue_list) {
        this.id_hit_loan_overdue_list = id_hit_loan_overdue_list;
    }

    public String getId_hit_carrent_default_list() {
        return id_hit_carrent_default_list;
    }

    public void setId_hit_carrent_default_list(String id_hit_carrent_default_list) {
        this.id_hit_carrent_default_list = id_hit_carrent_default_list;
    }

    public String getId_hit_busi_default_list() {
        return id_hit_busi_default_list;
    }

    public void setId_hit_busi_default_list(String id_hit_busi_default_list) {
        this.id_hit_busi_default_list = id_hit_busi_default_list;
    }

    public String getId_hit_tax_default_list() {
        return id_hit_tax_default_list;
    }

    public void setId_hit_tax_default_list(String id_hit_tax_default_list) {
        this.id_hit_tax_default_list = id_hit_tax_default_list;
    }

    public String getId_hit_busi_tax_default_list() {
        return id_hit_busi_tax_default_list;
    }

    public void setId_hit_busi_tax_default_list(String id_hit_busi_tax_default_list) {
        this.id_hit_busi_tax_default_list = id_hit_busi_tax_default_list;
    }

    public String getCell_hit_false_number_db() {
        return cell_hit_false_number_db;
    }

    public void setCell_hit_false_number_db(String cell_hit_false_number_db) {
        this.cell_hit_false_number_db = cell_hit_false_number_db;
    }

    public String getCell_hit_communication_db() {
        return cell_hit_communication_db;
    }

    public void setCell_hit_communication_db(String cell_hit_communication_db) {
        this.cell_hit_communication_db = cell_hit_communication_db;
    }

    public String getCell_hit_fraud_crankcall_db() {
        return cell_hit_fraud_crankcall_db;
    }

    public void setCell_hit_fraud_crankcall_db(String cell_hit_fraud_crankcall_db) {
        this.cell_hit_fraud_crankcall_db = cell_hit_fraud_crankcall_db;
    }

    public String getCell_hit_loan_overdue_list() {
        return cell_hit_loan_overdue_list;
    }

    public void setCell_hit_loan_overdue_list(String cell_hit_loan_overdue_list) {
        this.cell_hit_loan_overdue_list = cell_hit_loan_overdue_list;
    }

    public String getCell_hit_carrent_default_list() {
        return cell_hit_carrent_default_list;
    }

    public void setCell_hit_carrent_default_list(String cell_hit_carrent_default_list) {
        this.cell_hit_carrent_default_list = cell_hit_carrent_default_list;
    }

    public String getCell_hit_busi_default_list() {
        return cell_hit_busi_default_list;
    }

    public void setCell_hit_busi_default_list(String cell_hit_busi_default_list) {
        this.cell_hit_busi_default_list = cell_hit_busi_default_list;
    }

    public String getId_name_hit_court_case_list() {
        return id_name_hit_court_case_list;
    }

    public void setId_name_hit_court_case_list(String id_name_hit_court_case_list) {
        this.id_name_hit_court_case_list = id_name_hit_court_case_list;
    }

    public String getId_name_hit_court_excute_list() {
        return id_name_hit_court_excute_list;
    }

    public void setId_name_hit_court_excute_list(String id_name_hit_court_excute_list) {
        this.id_name_hit_court_excute_list = id_name_hit_court_excute_list;
    }

    public String getId_name_hit_court_credit_list() {
        return id_name_hit_court_credit_list;
    }

    public void setId_name_hit_court_credit_list(String id_name_hit_court_credit_list) {
        this.id_name_hit_court_credit_list = id_name_hit_court_credit_list;
    }

    public String getId_name_hit_loan_overdue_list() {
        return id_name_hit_loan_overdue_list;
    }

    public void setId_name_hit_loan_overdue_list(String id_name_hit_loan_overdue_list) {
        this.id_name_hit_loan_overdue_list = id_name_hit_loan_overdue_list;
    }

    public String getId_hit_court_case_list_level() {
        return id_hit_court_case_list_level;
    }

    public void setId_hit_court_case_list_level(String id_hit_court_case_list_level) {
        this.id_hit_court_case_list_level = id_hit_court_case_list_level;
    }

    public String getId_hit_court_credit_list_level() {
        return id_hit_court_credit_list_level;
    }

    public void setId_hit_court_credit_list_level(String id_hit_court_credit_list_level) {
        this.id_hit_court_credit_list_level = id_hit_court_credit_list_level;
    }

    public Integer getId_relate_name_cnt_m3() {
        return id_relate_name_cnt_m3;
    }

    public void setId_relate_name_cnt_m3(Integer id_relate_name_cnt_m3) {
        this.id_relate_name_cnt_m3 = id_relate_name_cnt_m3;
    }

    public Integer getId_relate_fatherid_cnt_m3() {
        return id_relate_fatherid_cnt_m3;
    }

    public void setId_relate_fatherid_cnt_m3(Integer id_relate_fatherid_cnt_m3) {
        this.id_relate_fatherid_cnt_m3 = id_relate_fatherid_cnt_m3;
    }

    public Integer getId_relate_motherid_cnt_m3() {
        return id_relate_motherid_cnt_m3;
    }

    public void setId_relate_motherid_cnt_m3(Integer id_relate_motherid_cnt_m3) {
        this.id_relate_motherid_cnt_m3 = id_relate_motherid_cnt_m3;
    }

    public Integer getId_relate_spouseid_cnt_m3() {
        return id_relate_spouseid_cnt_m3;
    }

    public void setId_relate_spouseid_cnt_m3(Integer id_relate_spouseid_cnt_m3) {
        this.id_relate_spouseid_cnt_m3 = id_relate_spouseid_cnt_m3;
    }

    public String getId_hit_high_risk_list() {
        return id_hit_high_risk_list;
    }

    public void setId_hit_high_risk_list(String id_hit_high_risk_list) {
        this.id_hit_high_risk_list = id_hit_high_risk_list;
    }
}
