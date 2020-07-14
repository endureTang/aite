package com.nj.mongoModel;

/**
 * 通用版评分卡
 *
 * @author Lizy
 * @version 2018/8/29.
 */
public class BalanceCardModel extends MongoEntity {

    // 年龄
    private Integer age;
    // 长期收入稳定性等级
    private String long_income_wd;
    // 行为分
    private String loan_score;
    // 贷款订单数和已结清订单数交互
    private String loan_count_finish;
    // 3个月内身份证关联多个申请信息等级
    private String ir_m3_id_x_apply_cnt;
    // 近一个月内手机号申请次数
    private Integer one_phone_countnew;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getLong_income_wd() {
        return long_income_wd;
    }

    public void setLong_income_wd(String long_income_wd) {
        this.long_income_wd = long_income_wd;
    }

    public String getLoan_score() {
        return loan_score;
    }

    public void setLoan_score(String loan_score) {
        this.loan_score = loan_score;
    }

    public String getLoan_count_finish() {
        return loan_count_finish;
    }

    public void setLoan_count_finish(String loan_count_finish) {
        this.loan_count_finish = loan_count_finish;
    }

    public String getIr_m3_id_x_apply_cnt() {
        return ir_m3_id_x_apply_cnt;
    }

    public void setIr_m3_id_x_apply_cnt(String ir_m3_id_x_apply_cnt) {
        this.ir_m3_id_x_apply_cnt = ir_m3_id_x_apply_cnt;
    }

    public Integer getOne_phone_countnew() {
        return one_phone_countnew;
    }

    public void setOne_phone_countnew(Integer one_phone_countnew) {
        this.one_phone_countnew = one_phone_countnew;
    }
}
