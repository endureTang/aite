package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjOrderPawnHouse;
import com.nj.model.generate.NjUserDebtInfo;
import com.nj.model.generate.NjUserHouse;
import com.nj.model.generate.NjUserRelatives;

public interface NjAppUserRelativesMapperExtend {
	public List<NjUserRelatives> getRecentRelatives(String userId);
	List<NjUserRelatives> getRelativeMapByMobile(@Param("mobileNo") String mobileNo);
	List<NjUserRelatives> getRecentRelsByMobile(@Param("mobileNo") String mobileNo);
	Integer getMaxVersionByUserId(@Param("userId") String mobileNo);
	/**
	 * 通过手机号码查询版本号最大的负债信息
	 * @param mobileNo
	 * @return
	 */
	public List<NjUserDebtInfo> getUserDebtInfoByMobile(@Param("mobile") String mobileNo);
	/**
	 * 通过手机号码查询负债信息最大的version号
	 * @param mobileNo
	 * @return
	 */
	public int getUserDebtInfoOfMaxVersion(@Param("userId") String userId);
	/**
	 * 通过手机号码查询用户房产信息
	 * @param mobile
	 * @return
	 */
	public List<NjUserHouse> getUserHouseByMobile(@Param("mobile") String mobile);
	
	/**
	 * 通过用户ID查询房产信息最大的version号
	 * @param mobile
	 * @return
	 */
	public int getUserHouseOfMaxVersion(@Param("userId") String userId);
	
	/**
	 * 通过手机号码查询配偶信息
	 * @param params
	 * @return
	 */
	public List<NjUserRelatives> getUserRelatives(Map<String,String> params);
	
	
	/**
	 * 通过用户ID查询配偶信息
	 * @param params
	 * @return
	 */
	public List<NjUserRelatives> getUserRelativesByUserId(Map<String,String> params);
	
	/**
	 * 通过用户ID查询配偶信息的最大的Version号
	 * @param params
	 * @return
	 */
	public int getUserRelativesOfMaxVersion(Map<String,String> params);
	
	
	/**
	 * 通过手机号码查询抵押物信息
	 * @param orderId
	 * @return
	 */
	public List<NjOrderPawnHouse> getOrderPawnHouseByMobile(@Param("mobile") String mobile);
	
	
	/**
	 * 通过订单号码查询抵押物信息
	 * @param orderId
	 * @return
	 */
	public List<NjOrderPawnHouse> getOrderPawnHouseModelByOrderId(@Param("orderId") String orderId);
	
	
	/**
	 * 通过用户ID查询查询抵押物最大的 Version号
	 * @param mobile
	 * @return
	 */		   
	public int getOrderPawnHouseOfMaxVersion(@Param("userId") String userId);
	
	/*
	 * backend begin
	 */
	/*;
	 * 获取订单对应的联系人信息
	 */
	List<NjUserRelatives> getRelativesByOrderId(@Param("orderId") String orderId);
	

	/*
	 * backend begin
	 */
	/*
	 * 获取订单对应的联系人信息
	 */
	List<NjUserRelatives> getContactsByOrderNo(@Param("orderNo") String orderNo);
	
	/*
	 * backend end
	 */
	
	List<Map> getRelativesListByOrderId(@Param("orderId") String orderId);
	
	
	/**
	 * 通过订单ID 查询配偶信息
	 * @param orderId
	 * @return
	 */
	public List<Map> getRelativesSpouseByOrderId(@Param("orderId") String orderId);
	
	
	/**
	 * 通过订单ID查询房抵押信息
	 * @param orderId
	 * @return
	 */
	public List<Map> getHousePawnByOrderId(@Param("orderId") String orderId);
	
	
	/**
	 * 通过订单ID查询房产信息
	 * @param orderId
	 * @return
	 */
	public List<Map> getHouseByOrderId(@Param("orderId") String orderId);
	
	
	/**
	 * 通过订单ID查询负债信息
	 * @param orderId
	 * @return
	 */
	public List<Map> getDebtByOrderId(@Param("orderId") String orderId);
	
	
	/**
	 * 更新用户联系人
	 * @param userRelatives
	 */
	void updateUserRelativeById(NjUserRelatives userRelatives);
	
	/**
	 * 更新抵押物信息
	 * @param njOrderPawnHouse
	 */
	public void updatePawnHouse(NjOrderPawnHouse njOrderPawnHouse);
	
	/**
	 * 更新房产信息
	 * @param njUserHouse
	 */
	public void updateHouseInfo(NjUserHouse njUserHouse);
	
	/**
	 * 更新负债信息
	 * @param njUserDebtInfo
	 */
	public void updateDebtInfo(NjUserDebtInfo njUserDebtInfo);
	/**
	 * 根据订单ID删除绑定关系
	 * @param id
	 */
	public void deleteByOrderId(@Param("orderId") String orderId);
	
	/**
	 * 根据订单ID和联系人ID删除
	 * @param map
	 */
	public void deleteByOrderIdAndRelativeId(Map<String,String> map);
	/**
	 * 根据订单ID删除基本信息绑定关系
	 * @param id
	 */
	public void deleteBaseInfoByOrderId(@Param("orderId") String orderId);
	/**
	 * 根据订单ID删除工作信息绑定关系
	 * @param id
	 */
	public void deleteUserWorkByOrderId(@Param("orderId") String orderId);
	/**
	 * 根据订单ID删除车辆信息绑定关系
	 * @param id
	 */
	public void deleteUserCarByOrderId(@Param("orderId") String orderId);
	
	/**
	 *  根据订单ID删除住房关系
	 * @param orderId
	 */
	public void deleteOrderHouseByOrderId(@Param("orderId") String orderId);
	
	/**
	 *  根据订单ID删除负债关系
	 * @param orderId
	 */
	public void deleteOrderDebtByOrderId(@Param("orderId") String orderId);
	
	/**
	 * 根据订单删除抵押房产关系
	 * @param orderId
	 */
	public void deleteOrderPawnHouseLinkByOrderId(@Param("orderId") String orderId);

	
	public List<NjUserRelatives> getRelativesByOrder(String orderId);
	/**
	 * 通过手机号码查询配偶信息，返回数据字典关键字
	 * @param map
	 * @return
	 */
	public Map<String, Object> getUserRelativesMap(Map<String, String> map);
	/**
	 * 根据订单id获取用户抵押物信息
	 * @param orderId
	 * @return
	 */
	public Map<String, Object> getOrderPawnHouseByOrderId(@Param("orderId") String orderId);
	/**
	 * 根据订单id获取用户负债信息
	 * @param orderId
	 * @return
	 */
	public List<NjUserDebtInfo> getOrderDeptByOrderId(String orderId);
	
	public List<NjUserRelatives> getUserRelativesList(@Param("orderId") String orderId,@Param("dictValue") String dictValue,@Param("maxVersion") Integer maxVersion);
}
