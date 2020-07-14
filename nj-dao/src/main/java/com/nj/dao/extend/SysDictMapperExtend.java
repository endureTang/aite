package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysBusinessDict;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysDictExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SysDictMapperExtend {
    
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
    
    public List<Map> getSysDictMapByType(@Param("type") String type);
    /**
     * 根据ID字符串（逗号分隔）获取字典列表
     * @param pd
     */
	List<SysDict> selectByIds(PageData pd);
	/**
	 * 根据区域类型以及上级id获取区域列表
	 * @param pd
	 * @return
	 */
	List<SysDict> getDictAreaByParent(PageData pd);
	
	SysDict selectByDictValue(@Param("areaCode") String areaCode);
	
	SysBusinessDict getRelativeTypeByKeyword(@Param("keyword") String keyword);
	
	SysDict getByValue(@Param("value") String value);
    
}