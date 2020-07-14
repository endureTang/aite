package com.nj.mongoModel;

/**
 * 多头借贷
 *
 * @author Lizy
 * @version 2018/8/29.
 */
public class LoanApplyModel extends MongoEntity {

    // 7天内身份证申请次数
    private Integer id_apply_loan_cnt_d7;
    // 7天内手机号申请次数
    private Integer cell_apply_loan_cnt_d7;
    // 3个月内身份证申请次数
    private Integer id_apply_loan_cnt_m3;
    // 3个月内手机号申请次数
    private Integer cell_apply_loan_cnt_m3;
    // 7天内设备申请次数
    private Integer equip_apply_loan_cnt_d7;

    public Integer getId_apply_loan_cnt_d7() {
        return id_apply_loan_cnt_d7;
    }

    public void setId_apply_loan_cnt_d7(Integer id_apply_loan_cnt_d7) {
        this.id_apply_loan_cnt_d7 = id_apply_loan_cnt_d7;
    }

    public Integer getCell_apply_loan_cnt_d7() {
        return cell_apply_loan_cnt_d7;
    }

    public void setCell_apply_loan_cnt_d7(Integer cell_apply_loan_cnt_d7) {
        this.cell_apply_loan_cnt_d7 = cell_apply_loan_cnt_d7;
    }

    public Integer getId_apply_loan_cnt_m3() {
        return id_apply_loan_cnt_m3;
    }

    public void setId_apply_loan_cnt_m3(Integer id_apply_loan_cnt_m3) {
        this.id_apply_loan_cnt_m3 = id_apply_loan_cnt_m3;
    }

    public Integer getCell_apply_loan_cnt_m3() {
        return cell_apply_loan_cnt_m3;
    }

    public void setCell_apply_loan_cnt_m3(Integer cell_apply_loan_cnt_m3) {
        this.cell_apply_loan_cnt_m3 = cell_apply_loan_cnt_m3;
    }

    public Integer getEquip_apply_loan_cnt_d7() {
        return equip_apply_loan_cnt_d7;
    }

    public void setEquip_apply_loan_cnt_d7(Integer equip_apply_loan_cnt_d7) {
        this.equip_apply_loan_cnt_d7 = equip_apply_loan_cnt_d7;
    }
}
