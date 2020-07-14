package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysResource;

public interface SysResourceMapperExtend {
    
    
    List<SysResource> findParentMenusByUserId(String userId);
    List<SysResource> findParentMenusByCondition(PageData pd);
    List<SysResource> findParentMenusById(String userId);
    List<SysResource> findMenusByUserIdAndParent(Map<?, ?> map);
    /**
     * 获取所有菜单
     * @return
     */
    List<SysResource> findAllParentMenus();
    

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
}