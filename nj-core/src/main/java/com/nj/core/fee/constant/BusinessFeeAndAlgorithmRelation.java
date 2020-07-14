package com.nj.core.fee.constant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 业务费用及其支持的算法的对应关系
 */
public class BusinessFeeAndAlgorithmRelation {

	private static Map<EBusinessFee, List<EBusinessFeeAlgorithm>> relation;
	
	//本金和利息根据还款方式计算，这里没有算法
	static{
		relation = new HashMap<EBusinessFee, List<EBusinessFeeAlgorithm>>();
		
		//罚息 
		List<EBusinessFeeAlgorithm> penaltyInterestAlgorithmList = new ArrayList<EBusinessFeeAlgorithm>();
		penaltyInterestAlgorithmList.add(EBusinessFeeAlgorithm.PENALTYINTEREST_NOTCALC);
		penaltyInterestAlgorithmList.add(EBusinessFeeAlgorithm.PENALTYINTEREST_HALFOFDAYINTEREST);
		relation.put(EBusinessFee.PENALTYINTEREST, penaltyInterestAlgorithmList);
		
		//渠道费
		List<EBusinessFeeAlgorithm> channelFeeAlgorithmList = new ArrayList<EBusinessFeeAlgorithm>();
		channelFeeAlgorithmList.add(EBusinessFeeAlgorithm.CHANNELFEE_PERIODCOLLECT_1);
		channelFeeAlgorithmList.add(EBusinessFeeAlgorithm.CHANNELFEE_PERIODCOLLECT_2);
		channelFeeAlgorithmList.add(EBusinessFeeAlgorithm.CHANNELFEE_FIRSTPERIOD_1);
		channelFeeAlgorithmList.add(EBusinessFeeAlgorithm.CHANNELFEE_FIRSTPERIOD_2);
		relation.put(EBusinessFee.CHANNELFEE, channelFeeAlgorithmList);
		
		//居间费
		List<EBusinessFeeAlgorithm> mediacyFeeAlgorithmList = new ArrayList<EBusinessFeeAlgorithm>();
		mediacyFeeAlgorithmList.add(EBusinessFeeAlgorithm.MEDIACYFEE_AVGTOPERIOD);
		mediacyFeeAlgorithmList.add(EBusinessFeeAlgorithm.MEDIACYFEE_FIRSTPERIOD);
		relation.put(EBusinessFee.MEDIACYFEE, mediacyFeeAlgorithmList);
	}
	
	/**
	 * 根据费用类型支持的算法
	 * @param businessFee {@link EBusinessFee}
	 */
	public static List<EBusinessFeeAlgorithm> getAlgorithmForFee(EBusinessFee businessFee){
		return relation.get(businessFee);
	}
}
