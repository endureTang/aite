package com.nj.mongoModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

/**
 * 策略引擎model
 *
 * @author Lizy
 * @version 2018/5/29.
 */
public class BrRiskStrategyData extends MongoEntity {
    private String userId;
    private String orderId;
    private String flag_riskstrategy;
    private String flag_ruleapplyloan_autofin;
    private String flag_ruleinforelation_autofin;
    private String flag_score;
    private String Rule_final_decision;
    private String Rule_final_weight;
    private String rs_final_decision;
    private String rs_strategy_id;
    private String rs_strategy_version;
    private String rs_platform;
    private String rs_product_name;
    private String rs_product_type;
    private String rs_scene;
    private String rs_Rule_decision;
    private String rs_Rule_weight;
    private String rs_ScoreAf_decision;
    private String rs_ScoreAf_scoreafautofin;
    private String rs_Score_decision;
    private String rs_Score_scorecarfin;
    private String code;
    private String swift_number;

    private String Rule_name_CBC001;
    private String Rule_weight_CBC001;
    private String Rule_name_CBC002;
    private String Rule_weight_CBC002;
    private String Rule_name_CBC003;
    private String Rule_weight_CBC003;
    private String Rule_name_CBC004;
    private String Rule_weight_CBC004;
    private String Rule_name_CAC001;
    private String Rule_weight_CAC001;
    private String Rule_name_CAC002;
    private String Rule_weight_CAC002;
    private String Rule_name_CAC003;
    private String Rule_weight_CAC003;
    private String Rule_name_CAC004;
    private String Rule_weight_CAC004;
    private String Rule_name_CAC005;
    private String Rule_weight_CAC005;
    private String Rule_name_CAC006;
    private String Rule_weight_CAC006;
    private String Rule_name_CAC007;
    private String Rule_weight_CAC007;
    private String Rule_name_CAC008;
    private String Rule_weight_CAC008;
    private String Rule_name_CAC009;
    private String Rule_weight_CAC009;
    private String Rule_name_CAC010;
    private String Rule_weight_CAC010;
    private String Rule_name_CAC011;
    private String Rule_weight_CAC011;
    private String Rule_name_CAC012;
    private String Rule_weight_CAC012;
    private String Rule_name_CAC013;
    private String Rule_weight_CAC013;
    private String Rule_name_CAC014;
    private String Rule_weight_CAC014;
    private String Rule_name_CAC015;
    private String Rule_weight_CAC015;
    private String Rule_name_CAC016;
    private String Rule_weight_CAC016;
    private String Rule_name_CAC017;
    private String Rule_weight_CAC017;
    private String Rule_name_CAC018;
    private String Rule_weight_CAC018;
    private String Rule_name_CAC019;
    private String Rule_weight_CAC019;
    private String Rule_name_CAC020;
    private String Rule_weight_CAC020;
    private String Rule_name_CAC021;
    private String Rule_weight_CAC021;
    private String Rule_name_CAC022;
    private String Rule_weight_CAC022;
    private String Rule_name_CAC023;
    private String Rule_weight_CAC023;
    private String Rule_name_CAC024;
    private String Rule_weight_CAC024;
    private String Rule_name_CAC025;
    private String Rule_weight_CAC025;
    private String Rule_name_CAC026;
    private String Rule_weight_CAC026;
    private String Rule_name_CAC027;
    private String Rule_weight_CAC027;
    private String Rule_name_CAC028;
    private String Rule_weight_CAC028;
    private String Rule_name_CAC029;
    private String Rule_weight_CAC029;
    private String Rule_name_CAC030;
    private String Rule_weight_CAC030;
    private String Rule_name_CAC031;
    private String Rule_weight_CAC031;
    private String Rule_name_CAC032;
    private String Rule_weight_CAC032;
    private String Rule_name_CAC033;
    private String Rule_weight_CAC033;
    private String Rule_name_CAC034;
    private String Rule_weight_CAC034;
    private String Rule_name_CAC035;
    private String Rule_weight_CAC035;
    private String Rule_name_CAC036;
    private String Rule_weight_CAC036;
    private String Rule_name_CAC037;
    private String Rule_weight_CAC037;
    private String Rule_name_CAC038;
    private String Rule_weight_CAC038;
    private String Rule_name_CAC039;
    private String Rule_weight_CAC039;
    private String Rule_name_CAC040;
    private String Rule_weight_CAC040;
    private String Rule_name_CAC041;
    private String Rule_weight_CAC041;
    private String Rule_name_CAC042;
    private String Rule_weight_CAC042;
    private String Rule_name_CAC043;
    private String Rule_weight_CAC043;
    private String Rule_name_CAC044;
    private String Rule_weight_CAC044;
    private String Rule_name_CAC045;
    private String Rule_weight_CAC045;
    private String Rule_name_CAC046;
    private String Rule_weight_CAC046;
    private String Rule_name_CAC047;
    private String Rule_weight_CAC047;
    private String Rule_name_CAC048;
    private String Rule_weight_CAC048;
    private String Rule_name_CAC049;
    private String Rule_weight_CAC049;
    private String Rule_name_CAC050;
    private String Rule_weight_CAC050;
    private String Rule_name_CAC051;
    private String Rule_weight_CAC051;
    private String Rule_name_CAC052;
    private String Rule_weight_CAC052;
    private String Rule_name_CAC053;
    private String Rule_weight_CAC053;
    private String Rule_name_CAC054;
    private String Rule_weight_CAC054;
    private String Rule_name_CAC055;
    private String Rule_weight_CAC055;
    private String Rule_name_CAC056;
    private String Rule_weight_CAC056;
    private String Rule_name_CAC057;
    private String Rule_weight_CAC057;
    private String Rule_name_CAC058;
    private String Rule_weight_CAC058;
    private String Rule_name_CAC059;
    private String Rule_weight_CAC059;
    private String Rule_name_CAC060;
    private String Rule_weight_CAC060;
    private String Rule_name_CAC061;
    private String Rule_weight_CAC061;
    private String Rule_name_CAC062;
    private String Rule_weight_CAC062;
    private String Rule_name_CAC063;
    private String Rule_weight_CAC063;
    private String Rule_name_CAC064;
    private String Rule_weight_CAC064;
    private String Rule_name_CAC065;
    private String Rule_weight_CAC065;
    private String Rule_name_CAC066;
    private String Rule_weight_CAC066;
    private String Rule_name_CAC067;
    private String Rule_weight_CAC067;
    private String Rule_name_CAC068;
    private String Rule_weight_CAC068;
    private String Rule_name_CAC069;
    private String Rule_weight_CAC069;
    private String Rule_name_CAC070;
    private String Rule_weight_CAC070;
    private String Rule_name_CAC071;
    private String Rule_weight_CAC071;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getFlag_riskstrategy() {
        return flag_riskstrategy;
    }

    public void setFlag_riskstrategy(String flag_riskstrategy) {
        this.flag_riskstrategy = flag_riskstrategy;
    }

    public String getFlag_ruleapplyloan_autofin() {
        return flag_ruleapplyloan_autofin;
    }

    public void setFlag_ruleapplyloan_autofin(String flag_ruleapplyloan_autofin) {
        this.flag_ruleapplyloan_autofin = flag_ruleapplyloan_autofin;
    }

    public String getFlag_ruleinforelation_autofin() {
        return flag_ruleinforelation_autofin;
    }

    public void setFlag_ruleinforelation_autofin(String flag_ruleinforelation_autofin) {
        this.flag_ruleinforelation_autofin = flag_ruleinforelation_autofin;
    }

    public String getFlag_score() {
        return flag_score;
    }

    public void setFlag_score(String flag_score) {
        this.flag_score = flag_score;
    }

    public String getRule_final_decision() {
        return Rule_final_decision;
    }

    public void setRule_final_decision(String rule_final_decision) {
        Rule_final_decision = rule_final_decision;
    }

    public String getRule_final_weight() {
        return Rule_final_weight;
    }

    public void setRule_final_weight(String rule_final_weight) {
        Rule_final_weight = rule_final_weight;
    }

    public String getRule_name_CBC001() {
        return Rule_name_CBC001;
    }

    public void setRule_name_CBC001(String rule_name_CBC001) {
        Rule_name_CBC001 = rule_name_CBC001;
    }

    public String getRule_name_CAC001() {
        return Rule_name_CAC001;
    }

    public void setRule_name_CAC001(String rule_name_CAC001) {
        Rule_name_CAC001 = rule_name_CAC001;
    }

    public String getRule_weight_CBC001() {
        return Rule_weight_CBC001;
    }

    public void setRule_weight_CBC001(String rule_weight_CBC001) {
        Rule_weight_CBC001 = rule_weight_CBC001;
    }

    public String getRule_weight_CAC001() {
        return Rule_weight_CAC001;
    }

    public void setRule_weight_CAC001(String rule_weight_CAC001) {
        Rule_weight_CAC001 = rule_weight_CAC001;
    }

    public String getRs_final_decision() {
        return rs_final_decision;
    }

    public void setRs_final_decision(String rs_final_decision) {
        this.rs_final_decision = rs_final_decision;
    }

    public String getRs_strategy_id() {
        return rs_strategy_id;
    }

    public void setRs_strategy_id(String rs_strategy_id) {
        this.rs_strategy_id = rs_strategy_id;
    }

    public String getRs_strategy_version() {
        return rs_strategy_version;
    }

    public void setRs_strategy_version(String rs_strategy_version) {
        this.rs_strategy_version = rs_strategy_version;
    }

    public String getRs_platform() {
        return rs_platform;
    }

    public void setRs_platform(String rs_platform) {
        this.rs_platform = rs_platform;
    }

    public String getRs_product_name() {
        return rs_product_name;
    }

    public void setRs_product_name(String rs_product_name) {
        this.rs_product_name = rs_product_name;
    }

    public String getRs_product_type() {
        return rs_product_type;
    }

    public void setRs_product_type(String rs_product_type) {
        this.rs_product_type = rs_product_type;
    }

    public String getRs_scene() {
        return rs_scene;
    }

    public void setRs_scene(String rs_scene) {
        this.rs_scene = rs_scene;
    }

    public String getRs_Rule_decision() {
        return rs_Rule_decision;
    }

    public void setRs_Rule_decision(String rs_Rule_decision) {
        this.rs_Rule_decision = rs_Rule_decision;
    }

    public String getRs_Rule_weight() {
        return rs_Rule_weight;
    }

    public void setRs_Rule_weight(String rs_Rule_weight) {
        this.rs_Rule_weight = rs_Rule_weight;
    }

    public String getRs_ScoreAf_decision() {
        return rs_ScoreAf_decision;
    }

    public void setRs_ScoreAf_decision(String rs_ScoreAf_decision) {
        this.rs_ScoreAf_decision = rs_ScoreAf_decision;
    }

    public String getRs_ScoreAf_scoreafautofin() {
        return rs_ScoreAf_scoreafautofin;
    }

    public void setRs_ScoreAf_scoreafautofin(String rs_ScoreAf_scoreafautofin) {
        this.rs_ScoreAf_scoreafautofin = rs_ScoreAf_scoreafautofin;
    }

    public String getRs_Score_decision() {
        return rs_Score_decision;
    }

    public void setRs_Score_decision(String rs_Score_decision) {
        this.rs_Score_decision = rs_Score_decision;
    }

    public String getRs_Score_scorecarfin() {
        return rs_Score_scorecarfin;
    }

    public void setRs_Score_scorecarfin(String rs_Score_scorecarfin) {
        this.rs_Score_scorecarfin = rs_Score_scorecarfin;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSwift_number() {
        return swift_number;
    }

    public void setSwift_number(String swift_number) {
        this.swift_number = swift_number;
    }

    public String getRule_name_CBC002() {
        return Rule_name_CBC002;
    }

    public void setRule_name_CBC002(String rule_name_CBC002) {
        Rule_name_CBC002 = rule_name_CBC002;
    }

    public String getRule_weight_CBC002() {
        return Rule_weight_CBC002;
    }

    public void setRule_weight_CBC002(String rule_weight_CBC002) {
        Rule_weight_CBC002 = rule_weight_CBC002;
    }

    public String getRule_name_CBC003() {
        return Rule_name_CBC003;
    }

    public void setRule_name_CBC003(String rule_name_CBC003) {
        Rule_name_CBC003 = rule_name_CBC003;
    }

    public String getRule_weight_CBC003() {
        return Rule_weight_CBC003;
    }

    public void setRule_weight_CBC003(String rule_weight_CBC003) {
        Rule_weight_CBC003 = rule_weight_CBC003;
    }

    public String getRule_name_CBC004() {
        return Rule_name_CBC004;
    }

    public void setRule_name_CBC004(String rule_name_CBC004) {
        Rule_name_CBC004 = rule_name_CBC004;
    }

    public String getRule_weight_CBC004() {
        return Rule_weight_CBC004;
    }

    public void setRule_weight_CBC004(String rule_weight_CBC004) {
        Rule_weight_CBC004 = rule_weight_CBC004;
    }

    public String getRule_name_CAC002() {
        return Rule_name_CAC002;
    }

    public void setRule_name_CAC002(String rule_name_CAC002) {
        Rule_name_CAC002 = rule_name_CAC002;
    }

    public String getRule_weight_CAC002() {
        return Rule_weight_CAC002;
    }

    public void setRule_weight_CAC002(String rule_weight_CAC002) {
        Rule_weight_CAC002 = rule_weight_CAC002;
    }

    public String getRule_name_CAC003() {
        return Rule_name_CAC003;
    }

    public void setRule_name_CAC003(String rule_name_CAC003) {
        Rule_name_CAC003 = rule_name_CAC003;
    }

    public String getRule_weight_CAC003() {
        return Rule_weight_CAC003;
    }

    public void setRule_weight_CAC003(String rule_weight_CAC003) {
        Rule_weight_CAC003 = rule_weight_CAC003;
    }

    public String getRule_name_CAC004() {
        return Rule_name_CAC004;
    }

    public void setRule_name_CAC004(String rule_name_CAC004) {
        Rule_name_CAC004 = rule_name_CAC004;
    }

    public String getRule_weight_CAC004() {
        return Rule_weight_CAC004;
    }

    public void setRule_weight_CAC004(String rule_weight_CAC004) {
        Rule_weight_CAC004 = rule_weight_CAC004;
    }

    public String getRule_name_CAC005() {
        return Rule_name_CAC005;
    }

    public void setRule_name_CAC005(String rule_name_CAC005) {
        Rule_name_CAC005 = rule_name_CAC005;
    }

    public String getRule_weight_CAC005() {
        return Rule_weight_CAC005;
    }

    public void setRule_weight_CAC005(String rule_weight_CAC005) {
        Rule_weight_CAC005 = rule_weight_CAC005;
    }

    public String getRule_name_CAC006() {
        return Rule_name_CAC006;
    }

    public void setRule_name_CAC006(String rule_name_CAC006) {
        Rule_name_CAC006 = rule_name_CAC006;
    }

    public String getRule_weight_CAC006() {
        return Rule_weight_CAC006;
    }

    public void setRule_weight_CAC006(String rule_weight_CAC006) {
        Rule_weight_CAC006 = rule_weight_CAC006;
    }

    public String getRule_name_CAC007() {
        return Rule_name_CAC007;
    }

    public void setRule_name_CAC007(String rule_name_CAC007) {
        Rule_name_CAC007 = rule_name_CAC007;
    }

    public String getRule_weight_CAC007() {
        return Rule_weight_CAC007;
    }

    public void setRule_weight_CAC007(String rule_weight_CAC007) {
        Rule_weight_CAC007 = rule_weight_CAC007;
    }

    public String getRule_name_CAC008() {
        return Rule_name_CAC008;
    }

    public void setRule_name_CAC008(String rule_name_CAC008) {
        Rule_name_CAC008 = rule_name_CAC008;
    }

    public String getRule_weight_CAC008() {
        return Rule_weight_CAC008;
    }

    public void setRule_weight_CAC008(String rule_weight_CAC008) {
        Rule_weight_CAC008 = rule_weight_CAC008;
    }

    public String getRule_name_CAC009() {
        return Rule_name_CAC009;
    }

    public void setRule_name_CAC009(String rule_name_CAC009) {
        Rule_name_CAC009 = rule_name_CAC009;
    }

    public String getRule_weight_CAC009() {
        return Rule_weight_CAC009;
    }

    public void setRule_weight_CAC009(String rule_weight_CAC009) {
        Rule_weight_CAC009 = rule_weight_CAC009;
    }

    public String getRule_name_CAC010() {
        return Rule_name_CAC010;
    }

    public void setRule_name_CAC010(String rule_name_CAC010) {
        Rule_name_CAC010 = rule_name_CAC010;
    }

    public String getRule_weight_CAC010() {
        return Rule_weight_CAC010;
    }

    public void setRule_weight_CAC010(String rule_weight_CAC010) {
        Rule_weight_CAC010 = rule_weight_CAC010;
    }

    public String getRule_name_CAC011() {
        return Rule_name_CAC011;
    }

    public void setRule_name_CAC011(String rule_name_CAC011) {
        Rule_name_CAC011 = rule_name_CAC011;
    }

    public String getRule_weight_CAC011() {
        return Rule_weight_CAC011;
    }

    public void setRule_weight_CAC011(String rule_weight_CAC011) {
        Rule_weight_CAC011 = rule_weight_CAC011;
    }

    public String getRule_name_CAC012() {
        return Rule_name_CAC012;
    }

    public void setRule_name_CAC012(String rule_name_CAC012) {
        Rule_name_CAC012 = rule_name_CAC012;
    }

    public String getRule_weight_CAC012() {
        return Rule_weight_CAC012;
    }

    public void setRule_weight_CAC012(String rule_weight_CAC012) {
        Rule_weight_CAC012 = rule_weight_CAC012;
    }

    public String getRule_name_CAC013() {
        return Rule_name_CAC013;
    }

    public void setRule_name_CAC013(String rule_name_CAC013) {
        Rule_name_CAC013 = rule_name_CAC013;
    }

    public String getRule_weight_CAC013() {
        return Rule_weight_CAC013;
    }

    public void setRule_weight_CAC013(String rule_weight_CAC013) {
        Rule_weight_CAC013 = rule_weight_CAC013;
    }

    public String getRule_name_CAC014() {
        return Rule_name_CAC014;
    }

    public void setRule_name_CAC014(String rule_name_CAC014) {
        Rule_name_CAC014 = rule_name_CAC014;
    }

    public String getRule_weight_CAC014() {
        return Rule_weight_CAC014;
    }

    public void setRule_weight_CAC014(String rule_weight_CAC014) {
        Rule_weight_CAC014 = rule_weight_CAC014;
    }

    public String getRule_name_CAC015() {
        return Rule_name_CAC015;
    }

    public void setRule_name_CAC015(String rule_name_CAC015) {
        Rule_name_CAC015 = rule_name_CAC015;
    }

    public String getRule_weight_CAC015() {
        return Rule_weight_CAC015;
    }

    public void setRule_weight_CAC015(String rule_weight_CAC015) {
        Rule_weight_CAC015 = rule_weight_CAC015;
    }

    public String getRule_name_CAC016() {
        return Rule_name_CAC016;
    }

    public void setRule_name_CAC016(String rule_name_CAC016) {
        Rule_name_CAC016 = rule_name_CAC016;
    }

    public String getRule_weight_CAC016() {
        return Rule_weight_CAC016;
    }

    public void setRule_weight_CAC016(String rule_weight_CAC016) {
        Rule_weight_CAC016 = rule_weight_CAC016;
    }

    public String getRule_name_CAC017() {
        return Rule_name_CAC017;
    }

    public void setRule_name_CAC017(String rule_name_CAC017) {
        Rule_name_CAC017 = rule_name_CAC017;
    }

    public String getRule_weight_CAC017() {
        return Rule_weight_CAC017;
    }

    public void setRule_weight_CAC017(String rule_weight_CAC017) {
        Rule_weight_CAC017 = rule_weight_CAC017;
    }

    public String getRule_name_CAC018() {
        return Rule_name_CAC018;
    }

    public void setRule_name_CAC018(String rule_name_CAC018) {
        Rule_name_CAC018 = rule_name_CAC018;
    }

    public String getRule_weight_CAC018() {
        return Rule_weight_CAC018;
    }

    public void setRule_weight_CAC018(String rule_weight_CAC018) {
        Rule_weight_CAC018 = rule_weight_CAC018;
    }

    public String getRule_name_CAC019() {
        return Rule_name_CAC019;
    }

    public void setRule_name_CAC019(String rule_name_CAC019) {
        Rule_name_CAC019 = rule_name_CAC019;
    }

    public String getRule_weight_CAC019() {
        return Rule_weight_CAC019;
    }

    public void setRule_weight_CAC019(String rule_weight_CAC019) {
        Rule_weight_CAC019 = rule_weight_CAC019;
    }

    public String getRule_name_CAC020() {
        return Rule_name_CAC020;
    }

    public void setRule_name_CAC020(String rule_name_CAC020) {
        Rule_name_CAC020 = rule_name_CAC020;
    }

    public String getRule_weight_CAC020() {
        return Rule_weight_CAC020;
    }

    public void setRule_weight_CAC020(String rule_weight_CAC020) {
        Rule_weight_CAC020 = rule_weight_CAC020;
    }

    public String getRule_name_CAC021() {
        return Rule_name_CAC021;
    }

    public void setRule_name_CAC021(String rule_name_CAC021) {
        Rule_name_CAC021 = rule_name_CAC021;
    }

    public String getRule_weight_CAC021() {
        return Rule_weight_CAC021;
    }

    public void setRule_weight_CAC021(String rule_weight_CAC021) {
        Rule_weight_CAC021 = rule_weight_CAC021;
    }

    public String getRule_name_CAC022() {
        return Rule_name_CAC022;
    }

    public void setRule_name_CAC022(String rule_name_CAC022) {
        Rule_name_CAC022 = rule_name_CAC022;
    }

    public String getRule_weight_CAC022() {
        return Rule_weight_CAC022;
    }

    public void setRule_weight_CAC022(String rule_weight_CAC022) {
        Rule_weight_CAC022 = rule_weight_CAC022;
    }

    public String getRule_name_CAC023() {
        return Rule_name_CAC023;
    }

    public void setRule_name_CAC023(String rule_name_CAC023) {
        Rule_name_CAC023 = rule_name_CAC023;
    }

    public String getRule_weight_CAC023() {
        return Rule_weight_CAC023;
    }

    public void setRule_weight_CAC023(String rule_weight_CAC023) {
        Rule_weight_CAC023 = rule_weight_CAC023;
    }

    public String getRule_name_CAC024() {
        return Rule_name_CAC024;
    }

    public void setRule_name_CAC024(String rule_name_CAC024) {
        Rule_name_CAC024 = rule_name_CAC024;
    }

    public String getRule_weight_CAC024() {
        return Rule_weight_CAC024;
    }

    public void setRule_weight_CAC024(String rule_weight_CAC024) {
        Rule_weight_CAC024 = rule_weight_CAC024;
    }

    public String getRule_name_CAC025() {
        return Rule_name_CAC025;
    }

    public void setRule_name_CAC025(String rule_name_CAC025) {
        Rule_name_CAC025 = rule_name_CAC025;
    }

    public String getRule_weight_CAC025() {
        return Rule_weight_CAC025;
    }

    public void setRule_weight_CAC025(String rule_weight_CAC025) {
        Rule_weight_CAC025 = rule_weight_CAC025;
    }

    public String getRule_name_CAC026() {
        return Rule_name_CAC026;
    }

    public void setRule_name_CAC026(String rule_name_CAC026) {
        Rule_name_CAC026 = rule_name_CAC026;
    }

    public String getRule_weight_CAC026() {
        return Rule_weight_CAC026;
    }

    public void setRule_weight_CAC026(String rule_weight_CAC026) {
        Rule_weight_CAC026 = rule_weight_CAC026;
    }

    public String getRule_name_CAC027() {
        return Rule_name_CAC027;
    }

    public void setRule_name_CAC027(String rule_name_CAC027) {
        Rule_name_CAC027 = rule_name_CAC027;
    }

    public String getRule_weight_CAC027() {
        return Rule_weight_CAC027;
    }

    public void setRule_weight_CAC027(String rule_weight_CAC027) {
        Rule_weight_CAC027 = rule_weight_CAC027;
    }

    public String getRule_name_CAC028() {
        return Rule_name_CAC028;
    }

    public void setRule_name_CAC028(String rule_name_CAC028) {
        Rule_name_CAC028 = rule_name_CAC028;
    }

    public String getRule_weight_CAC028() {
        return Rule_weight_CAC028;
    }

    public void setRule_weight_CAC028(String rule_weight_CAC028) {
        Rule_weight_CAC028 = rule_weight_CAC028;
    }

    public String getRule_name_CAC029() {
        return Rule_name_CAC029;
    }

    public void setRule_name_CAC029(String rule_name_CAC029) {
        Rule_name_CAC029 = rule_name_CAC029;
    }

    public String getRule_weight_CAC029() {
        return Rule_weight_CAC029;
    }

    public void setRule_weight_CAC029(String rule_weight_CAC029) {
        Rule_weight_CAC029 = rule_weight_CAC029;
    }

    public String getRule_name_CAC030() {
        return Rule_name_CAC030;
    }

    public void setRule_name_CAC030(String rule_name_CAC030) {
        Rule_name_CAC030 = rule_name_CAC030;
    }

    public String getRule_weight_CAC030() {
        return Rule_weight_CAC030;
    }

    public void setRule_weight_CAC030(String rule_weight_CAC030) {
        Rule_weight_CAC030 = rule_weight_CAC030;
    }

    public String getRule_name_CAC031() {
        return Rule_name_CAC031;
    }

    public void setRule_name_CAC031(String rule_name_CAC031) {
        Rule_name_CAC031 = rule_name_CAC031;
    }

    public String getRule_weight_CAC031() {
        return Rule_weight_CAC031;
    }

    public void setRule_weight_CAC031(String rule_weight_CAC031) {
        Rule_weight_CAC031 = rule_weight_CAC031;
    }

    public String getRule_name_CAC032() {
        return Rule_name_CAC032;
    }

    public void setRule_name_CAC032(String rule_name_CAC032) {
        Rule_name_CAC032 = rule_name_CAC032;
    }

    public String getRule_weight_CAC032() {
        return Rule_weight_CAC032;
    }

    public void setRule_weight_CAC032(String rule_weight_CAC032) {
        Rule_weight_CAC032 = rule_weight_CAC032;
    }

    public String getRule_name_CAC033() {
        return Rule_name_CAC033;
    }

    public void setRule_name_CAC033(String rule_name_CAC033) {
        Rule_name_CAC033 = rule_name_CAC033;
    }

    public String getRule_weight_CAC033() {
        return Rule_weight_CAC033;
    }

    public void setRule_weight_CAC033(String rule_weight_CAC033) {
        Rule_weight_CAC033 = rule_weight_CAC033;
    }

    public String getRule_name_CAC034() {
        return Rule_name_CAC034;
    }

    public void setRule_name_CAC034(String rule_name_CAC034) {
        Rule_name_CAC034 = rule_name_CAC034;
    }

    public String getRule_weight_CAC034() {
        return Rule_weight_CAC034;
    }

    public void setRule_weight_CAC034(String rule_weight_CAC034) {
        Rule_weight_CAC034 = rule_weight_CAC034;
    }

    public String getRule_name_CAC035() {
        return Rule_name_CAC035;
    }

    public void setRule_name_CAC035(String rule_name_CAC035) {
        Rule_name_CAC035 = rule_name_CAC035;
    }

    public String getRule_weight_CAC035() {
        return Rule_weight_CAC035;
    }

    public void setRule_weight_CAC035(String rule_weight_CAC035) {
        Rule_weight_CAC035 = rule_weight_CAC035;
    }

    public String getRule_name_CAC036() {
        return Rule_name_CAC036;
    }

    public void setRule_name_CAC036(String rule_name_CAC036) {
        Rule_name_CAC036 = rule_name_CAC036;
    }

    public String getRule_weight_CAC036() {
        return Rule_weight_CAC036;
    }

    public void setRule_weight_CAC036(String rule_weight_CAC036) {
        Rule_weight_CAC036 = rule_weight_CAC036;
    }

    public String getRule_name_CAC037() {
        return Rule_name_CAC037;
    }

    public void setRule_name_CAC037(String rule_name_CAC037) {
        Rule_name_CAC037 = rule_name_CAC037;
    }

    public String getRule_weight_CAC037() {
        return Rule_weight_CAC037;
    }

    public void setRule_weight_CAC037(String rule_weight_CAC037) {
        Rule_weight_CAC037 = rule_weight_CAC037;
    }

    public String getRule_name_CAC038() {
        return Rule_name_CAC038;
    }

    public void setRule_name_CAC038(String rule_name_CAC038) {
        Rule_name_CAC038 = rule_name_CAC038;
    }

    public String getRule_weight_CAC038() {
        return Rule_weight_CAC038;
    }

    public void setRule_weight_CAC038(String rule_weight_CAC038) {
        Rule_weight_CAC038 = rule_weight_CAC038;
    }

    public String getRule_name_CAC039() {
        return Rule_name_CAC039;
    }

    public void setRule_name_CAC039(String rule_name_CAC039) {
        Rule_name_CAC039 = rule_name_CAC039;
    }

    public String getRule_weight_CAC039() {
        return Rule_weight_CAC039;
    }

    public void setRule_weight_CAC039(String rule_weight_CAC039) {
        Rule_weight_CAC039 = rule_weight_CAC039;
    }

    public String getRule_name_CAC040() {
        return Rule_name_CAC040;
    }

    public void setRule_name_CAC040(String rule_name_CAC040) {
        Rule_name_CAC040 = rule_name_CAC040;
    }

    public String getRule_weight_CAC040() {
        return Rule_weight_CAC040;
    }

    public void setRule_weight_CAC040(String rule_weight_CAC040) {
        Rule_weight_CAC040 = rule_weight_CAC040;
    }

    public String getRule_name_CAC041() {
        return Rule_name_CAC041;
    }

    public void setRule_name_CAC041(String rule_name_CAC041) {
        Rule_name_CAC041 = rule_name_CAC041;
    }

    public String getRule_weight_CAC041() {
        return Rule_weight_CAC041;
    }

    public void setRule_weight_CAC041(String rule_weight_CAC041) {
        Rule_weight_CAC041 = rule_weight_CAC041;
    }

    public String getRule_name_CAC042() {
        return Rule_name_CAC042;
    }

    public void setRule_name_CAC042(String rule_name_CAC042) {
        Rule_name_CAC042 = rule_name_CAC042;
    }

    public String getRule_weight_CAC042() {
        return Rule_weight_CAC042;
    }

    public void setRule_weight_CAC042(String rule_weight_CAC042) {
        Rule_weight_CAC042 = rule_weight_CAC042;
    }

    public String getRule_name_CAC043() {
        return Rule_name_CAC043;
    }

    public void setRule_name_CAC043(String rule_name_CAC043) {
        Rule_name_CAC043 = rule_name_CAC043;
    }

    public String getRule_weight_CAC043() {
        return Rule_weight_CAC043;
    }

    public void setRule_weight_CAC043(String rule_weight_CAC043) {
        Rule_weight_CAC043 = rule_weight_CAC043;
    }

    public String getRule_name_CAC044() {
        return Rule_name_CAC044;
    }

    public void setRule_name_CAC044(String rule_name_CAC044) {
        Rule_name_CAC044 = rule_name_CAC044;
    }

    public String getRule_weight_CAC044() {
        return Rule_weight_CAC044;
    }

    public void setRule_weight_CAC044(String rule_weight_CAC044) {
        Rule_weight_CAC044 = rule_weight_CAC044;
    }

    public String getRule_name_CAC045() {
        return Rule_name_CAC045;
    }

    public void setRule_name_CAC045(String rule_name_CAC045) {
        Rule_name_CAC045 = rule_name_CAC045;
    }

    public String getRule_weight_CAC045() {
        return Rule_weight_CAC045;
    }

    public void setRule_weight_CAC045(String rule_weight_CAC045) {
        Rule_weight_CAC045 = rule_weight_CAC045;
    }

    public String getRule_name_CAC046() {
        return Rule_name_CAC046;
    }

    public void setRule_name_CAC046(String rule_name_CAC046) {
        Rule_name_CAC046 = rule_name_CAC046;
    }

    public String getRule_weight_CAC046() {
        return Rule_weight_CAC046;
    }

    public void setRule_weight_CAC046(String rule_weight_CAC046) {
        Rule_weight_CAC046 = rule_weight_CAC046;
    }

    public String getRule_name_CAC047() {
        return Rule_name_CAC047;
    }

    public void setRule_name_CAC047(String rule_name_CAC047) {
        Rule_name_CAC047 = rule_name_CAC047;
    }

    public String getRule_weight_CAC047() {
        return Rule_weight_CAC047;
    }

    public void setRule_weight_CAC047(String rule_weight_CAC047) {
        Rule_weight_CAC047 = rule_weight_CAC047;
    }

    public String getRule_name_CAC048() {
        return Rule_name_CAC048;
    }

    public void setRule_name_CAC048(String rule_name_CAC048) {
        Rule_name_CAC048 = rule_name_CAC048;
    }

    public String getRule_weight_CAC048() {
        return Rule_weight_CAC048;
    }

    public void setRule_weight_CAC048(String rule_weight_CAC048) {
        Rule_weight_CAC048 = rule_weight_CAC048;
    }

    public String getRule_name_CAC049() {
        return Rule_name_CAC049;
    }

    public void setRule_name_CAC049(String rule_name_CAC049) {
        Rule_name_CAC049 = rule_name_CAC049;
    }

    public String getRule_weight_CAC049() {
        return Rule_weight_CAC049;
    }

    public void setRule_weight_CAC049(String rule_weight_CAC049) {
        Rule_weight_CAC049 = rule_weight_CAC049;
    }

    public String getRule_name_CAC050() {
        return Rule_name_CAC050;
    }

    public void setRule_name_CAC050(String rule_name_CAC050) {
        Rule_name_CAC050 = rule_name_CAC050;
    }

    public String getRule_weight_CAC050() {
        return Rule_weight_CAC050;
    }

    public void setRule_weight_CAC050(String rule_weight_CAC050) {
        Rule_weight_CAC050 = rule_weight_CAC050;
    }

    public String getRule_name_CAC051() {
        return Rule_name_CAC051;
    }

    public void setRule_name_CAC051(String rule_name_CAC051) {
        Rule_name_CAC051 = rule_name_CAC051;
    }

    public String getRule_weight_CAC051() {
        return Rule_weight_CAC051;
    }

    public void setRule_weight_CAC051(String rule_weight_CAC051) {
        Rule_weight_CAC051 = rule_weight_CAC051;
    }

    public String getRule_name_CAC052() {
        return Rule_name_CAC052;
    }

    public void setRule_name_CAC052(String rule_name_CAC052) {
        Rule_name_CAC052 = rule_name_CAC052;
    }

    public String getRule_weight_CAC052() {
        return Rule_weight_CAC052;
    }

    public void setRule_weight_CAC052(String rule_weight_CAC052) {
        Rule_weight_CAC052 = rule_weight_CAC052;
    }

    public String getRule_name_CAC053() {
        return Rule_name_CAC053;
    }

    public void setRule_name_CAC053(String rule_name_CAC053) {
        Rule_name_CAC053 = rule_name_CAC053;
    }

    public String getRule_weight_CAC053() {
        return Rule_weight_CAC053;
    }

    public void setRule_weight_CAC053(String rule_weight_CAC053) {
        Rule_weight_CAC053 = rule_weight_CAC053;
    }

    public String getRule_name_CAC054() {
        return Rule_name_CAC054;
    }

    public void setRule_name_CAC054(String rule_name_CAC054) {
        Rule_name_CAC054 = rule_name_CAC054;
    }

    public String getRule_weight_CAC054() {
        return Rule_weight_CAC054;
    }

    public void setRule_weight_CAC054(String rule_weight_CAC054) {
        Rule_weight_CAC054 = rule_weight_CAC054;
    }

    public String getRule_name_CAC055() {
        return Rule_name_CAC055;
    }

    public void setRule_name_CAC055(String rule_name_CAC055) {
        Rule_name_CAC055 = rule_name_CAC055;
    }

    public String getRule_weight_CAC055() {
        return Rule_weight_CAC055;
    }

    public void setRule_weight_CAC055(String rule_weight_CAC055) {
        Rule_weight_CAC055 = rule_weight_CAC055;
    }

    public String getRule_name_CAC056() {
        return Rule_name_CAC056;
    }

    public void setRule_name_CAC056(String rule_name_CAC056) {
        Rule_name_CAC056 = rule_name_CAC056;
    }

    public String getRule_weight_CAC056() {
        return Rule_weight_CAC056;
    }

    public void setRule_weight_CAC056(String rule_weight_CAC056) {
        Rule_weight_CAC056 = rule_weight_CAC056;
    }

    public String getRule_name_CAC057() {
        return Rule_name_CAC057;
    }

    public void setRule_name_CAC057(String rule_name_CAC057) {
        Rule_name_CAC057 = rule_name_CAC057;
    }

    public String getRule_weight_CAC057() {
        return Rule_weight_CAC057;
    }

    public void setRule_weight_CAC057(String rule_weight_CAC057) {
        Rule_weight_CAC057 = rule_weight_CAC057;
    }

    public String getRule_name_CAC058() {
        return Rule_name_CAC058;
    }

    public void setRule_name_CAC058(String rule_name_CAC058) {
        Rule_name_CAC058 = rule_name_CAC058;
    }

    public String getRule_weight_CAC058() {
        return Rule_weight_CAC058;
    }

    public void setRule_weight_CAC058(String rule_weight_CAC058) {
        Rule_weight_CAC058 = rule_weight_CAC058;
    }

    public String getRule_name_CAC059() {
        return Rule_name_CAC059;
    }

    public void setRule_name_CAC059(String rule_name_CAC059) {
        Rule_name_CAC059 = rule_name_CAC059;
    }

    public String getRule_weight_CAC059() {
        return Rule_weight_CAC059;
    }

    public void setRule_weight_CAC059(String rule_weight_CAC059) {
        Rule_weight_CAC059 = rule_weight_CAC059;
    }

    public String getRule_name_CAC060() {
        return Rule_name_CAC060;
    }

    public void setRule_name_CAC060(String rule_name_CAC060) {
        Rule_name_CAC060 = rule_name_CAC060;
    }

    public String getRule_weight_CAC060() {
        return Rule_weight_CAC060;
    }

    public void setRule_weight_CAC060(String rule_weight_CAC060) {
        Rule_weight_CAC060 = rule_weight_CAC060;
    }

    public String getRule_name_CAC061() {
        return Rule_name_CAC061;
    }

    public void setRule_name_CAC061(String rule_name_CAC061) {
        Rule_name_CAC061 = rule_name_CAC061;
    }

    public String getRule_weight_CAC061() {
        return Rule_weight_CAC061;
    }

    public void setRule_weight_CAC061(String rule_weight_CAC061) {
        Rule_weight_CAC061 = rule_weight_CAC061;
    }

    public String getRule_name_CAC062() {
        return Rule_name_CAC062;
    }

    public void setRule_name_CAC062(String rule_name_CAC062) {
        Rule_name_CAC062 = rule_name_CAC062;
    }

    public String getRule_weight_CAC062() {
        return Rule_weight_CAC062;
    }

    public void setRule_weight_CAC062(String rule_weight_CAC062) {
        Rule_weight_CAC062 = rule_weight_CAC062;
    }

    public String getRule_name_CAC063() {
        return Rule_name_CAC063;
    }

    public void setRule_name_CAC063(String rule_name_CAC063) {
        Rule_name_CAC063 = rule_name_CAC063;
    }

    public String getRule_weight_CAC063() {
        return Rule_weight_CAC063;
    }

    public void setRule_weight_CAC063(String rule_weight_CAC063) {
        Rule_weight_CAC063 = rule_weight_CAC063;
    }

    public String getRule_name_CAC064() {
        return Rule_name_CAC064;
    }

    public void setRule_name_CAC064(String rule_name_CAC064) {
        Rule_name_CAC064 = rule_name_CAC064;
    }

    public String getRule_weight_CAC064() {
        return Rule_weight_CAC064;
    }

    public void setRule_weight_CAC064(String rule_weight_CAC064) {
        Rule_weight_CAC064 = rule_weight_CAC064;
    }

    public String getRule_name_CAC065() {
        return Rule_name_CAC065;
    }

    public void setRule_name_CAC065(String rule_name_CAC065) {
        Rule_name_CAC065 = rule_name_CAC065;
    }

    public String getRule_weight_CAC065() {
        return Rule_weight_CAC065;
    }

    public void setRule_weight_CAC065(String rule_weight_CAC065) {
        Rule_weight_CAC065 = rule_weight_CAC065;
    }

    public String getRule_name_CAC066() {
        return Rule_name_CAC066;
    }

    public void setRule_name_CAC066(String rule_name_CAC066) {
        Rule_name_CAC066 = rule_name_CAC066;
    }

    public String getRule_weight_CAC066() {
        return Rule_weight_CAC066;
    }

    public void setRule_weight_CAC066(String rule_weight_CAC066) {
        Rule_weight_CAC066 = rule_weight_CAC066;
    }

    public String getRule_name_CAC067() {
        return Rule_name_CAC067;
    }

    public void setRule_name_CAC067(String rule_name_CAC067) {
        Rule_name_CAC067 = rule_name_CAC067;
    }

    public String getRule_weight_CAC067() {
        return Rule_weight_CAC067;
    }

    public void setRule_weight_CAC067(String rule_weight_CAC067) {
        Rule_weight_CAC067 = rule_weight_CAC067;
    }

    public String getRule_name_CAC068() {
        return Rule_name_CAC068;
    }

    public void setRule_name_CAC068(String rule_name_CAC068) {
        Rule_name_CAC068 = rule_name_CAC068;
    }

    public String getRule_weight_CAC068() {
        return Rule_weight_CAC068;
    }

    public void setRule_weight_CAC068(String rule_weight_CAC068) {
        Rule_weight_CAC068 = rule_weight_CAC068;
    }

    public String getRule_name_CAC069() {
        return Rule_name_CAC069;
    }

    public void setRule_name_CAC069(String rule_name_CAC069) {
        Rule_name_CAC069 = rule_name_CAC069;
    }

    public String getRule_weight_CAC069() {
        return Rule_weight_CAC069;
    }

    public void setRule_weight_CAC069(String rule_weight_CAC069) {
        Rule_weight_CAC069 = rule_weight_CAC069;
    }

    public String getRule_name_CAC070() {
        return Rule_name_CAC070;
    }

    public void setRule_name_CAC070(String rule_name_CAC070) {
        Rule_name_CAC070 = rule_name_CAC070;
    }

    public String getRule_weight_CAC070() {
        return Rule_weight_CAC070;
    }

    public void setRule_weight_CAC070(String rule_weight_CAC070) {
        Rule_weight_CAC070 = rule_weight_CAC070;
    }

    public String getRule_name_CAC071() {
        return Rule_name_CAC071;
    }

    public void setRule_name_CAC071(String rule_name_CAC071) {
        Rule_name_CAC071 = rule_name_CAC071;
    }

    public String getRule_weight_CAC071() {
        return Rule_weight_CAC071;
    }

    public void setRule_weight_CAC071(String rule_weight_CAC071) {
        Rule_weight_CAC071 = rule_weight_CAC071;
    }
}
