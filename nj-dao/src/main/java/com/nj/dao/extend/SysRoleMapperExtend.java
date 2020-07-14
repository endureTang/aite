package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysResource;
import com.nj.model.generate.SysRole;

public interface SysRoleMapperExtend {

	List<String> findRolesIdByUserId(String userId);
    /**
     * 逻辑删除
     * @param id
     * @return
     */
    int delete(String id);
    /**
     * 批量逻辑删除
     * @param idList
     * @return
     */
    int batchDelete(PageData idList);
    
    /*
     * 获取后台用户的角色
     */
    List<Map> findNjUserRolesByUserId(Map<?, ?> condition);
    
    /*
     * 获取后台用户归属的产品
     */
    List<Map> findNjUserProdRolesByUserId(Map<?, ?> condition);
    
    /*
     * 获取后台用户归属的产品
     */
    List<SysRole> findAssignableRolesByUserId(Map<?, ?> condition);

    /*
     * 获取后台用户归属产品的流程角色
     */
    List<Map> findNjUserFlowsRolesByUserId(Map<?, ?> condition);
    /**
     * 根据角色查询资源
     * @param roleId
     * @return
     */
    List<SysResource> selectResourceByRoleId(String roleId);
    /**
     * 获取所有角色列表
     * @param pd
     * @return
     */
	List<SysRole> selectAllRoleList(PageData pd);
	/**
	 * 获取用户拥有角色列表
	 * @param pd
	 * @return
	 */
	List<SysRole> selectUserHasRoleList(PageData pd);
	
	/**
	 * 查询指定企业内指定角色类型的用户
	 */
	public List<Map> getUserByRoleTypeCoporateId(@Param("roleType")String roleType,@Param("coporateId")String coporateId);
	/**
	 * 根据用户ID获取角色类型
	 * @param id
	 * @return
	 */
	String selectRoleByUserId(@Param("userId") String id);
	
	/**
	 * 根据用户企业ID获得该企业各角色拥有的权限
	 * @param coporateId
	 * @return
	 */
	List<Map<String,Object>> selectResourceByCoporateId(String coporateId);
	
	/**
	 * 根据用户userId 获取用户角色信息
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRoleByUserIdFresh(String  userId);
}