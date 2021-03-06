package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.NjUserInfo;


public interface NjUserInfoMapperExtend {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table nj_user_info
     *
     * @mbg.generated Wed Feb 15 14:14:51 CST 2017
     */

	@SuppressWarnings("rawtypes")
	//获取用户加入的公司列表
	List<Map> selectJoinedCompany(Map<?, ?> condition);
	
	//获取公司列表
	List<Map> selectCompanys(Map<?, ?> condition);
	
	List<Map> selectJoinAbleCompany(Map<?, ?> condition);
	
    List<Map> selectByCondition(Map<?, ?> condition);

    List<Map> selectAllAccount(Map<?, ?> condition);
    int selectAllAccountCount(Map<?, ?> condition);

    List<Map> selectVerifiedAccount(Map<?, ?> condition);
    /**
     * 查询总条数
     * @param condition
     * @return
     */
    List<Map> selectVerifiedAccountCount(Map<?, ?> condition);
    
    List<Map> selectVerifiedAccountListPage(Map<?, ?> condition);
    List<Map> selectAllAccountListPage(Map<?, ?> condition);
    
    List<Map> selectCoporateAccount(Map<?, ?> condition);
    
    List<Map> selectUserByRole(Map<?, ?> condition);
    
    List<Map> selectUserAccount(Map<?, ?> condition);
    
    long selectUserAccountCount(Map<?, ?> condition);
    
    List<Map> selectUserRoles(String userId);
    
    String selectPwdByUserId(String userId);
   
    List<Map> getUserAttachments(Map<?, ?> condition);
   
    void decline(List<String> condition);
    
    void accept(List<String> condition);
    
    void updateDefaultLogin(Map<?, ?> condition);
  
    void updateByPrimaryKeySelective(Map<?, ?> condition);

	Integer getAuthority(Map<String, Object> paramMap);

	NjUserInfo getByMobile(@Param("userMobile") String userMobile);
	
	/**
	 * 获取企业的用户，为账号管理，所有账号页面查询列表用
	 */
	List<Map> getCopoUserForAcctManagePage(Map<?, ?> param);

	List<NjUserInfo> selectListByCompanyId(PageData pd);

	/**
	 * 查询订单的客户经理及业务经理
	 * @param orderId
	 * @return
	 */
	NjUserInfo selectUserByOrderId(String orderId);

	/**
	 * 获取用户及其角色信息
	 */
	Map getUserRoleInfo(String userId);
	
	
	/**
	 * 通过角色类型和企业id查询用户
	 * @param roleType
	 * @param coporateId
	 * @return
	 */
	List<Map> selectUserByRoleType(@Param("roleType") String roleType,@Param("coporateId") String coporateId);
	
	/**
	 * 获得所有用户信息,排除没有手机号的,并带角色名称
	 * @return
	 */
	List<Map> getUserInfoAll();

}