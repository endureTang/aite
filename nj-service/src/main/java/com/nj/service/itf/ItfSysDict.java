package com.nj.service.itf;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.nj.core.base.common.Constants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.SysDictMapper;
import com.nj.dao.extend.SysDictMapperExtend;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysDictExample;


@Transactional(readOnly = true)
@Service("itfSysDict")
public class ItfSysDict {
	@Resource(name = "BaseDao")
	private BaseDao dao;
	private static Logger logger = LoggerFactory.getLogger(ItfSysDict.class);
	
	public Map<String, Object> getCarDict() throws Exception{
		Map<String, Object> result = new HashMap<String, Object>();
		result.put(Constants.SYS_DICT.TYPE_CLNL, getDict(Constants.SYS_DICT.TYPE_CLNL));
		result.put(Constants.SYS_DICT.TYPE_CLJG, getDict(Constants.SYS_DICT.TYPE_CLJG));
		result.put(Constants.SYS_DICT.TYPE_CLLX, getDict(Constants.SYS_DICT.TYPE_CLLX));
		return result;
	}
	
	public List<Map> getDict(String type)throws Exception{
		List<Map> cacheValue =(List<Map>)EhCacheUtil.getInstance().get(EhCacheConstant.ITF.SYS_DICT, type);
		if(cacheValue ==null){
			SysDictMapperExtend sdMapper = dao.getMapper(SysDictMapperExtend.class);
			List<Map> result = sdMapper.getSysDictMapByType(type);
			if(result!=null && !result.isEmpty()){
				EhCacheUtil.getInstance().put(EhCacheConstant.ITF.SYS_DICT, type, result);
			}
			return result;
		}
		else{
			logger.debug("get "+type+" value from cache");
			return cacheValue;
		}
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insertCity(SortedMap<String,Object> prov)throws Exception{
		//int i=0;
		if(prov==null)
			return;
		SysDictMapper mapper =dao.getMapper(SysDictMapper.class);
		int j=0;
		for(String key: prov.keySet()){
			//i++;
			List<Map> cities = (List<Map>)prov.get(key);
			j=0;
			if(cities !=null && !cities.isEmpty()){
				j++;
				for(Map<String, Object> item: cities){
					String id = (String)item.get("id");
					String city = (String)item.get("city");
					String parId = (String) item.get("parId");
					SysDict sd = new SysDict();
					sd.setCreateBy("1");
					sd.setCreateDate(new Date());
					sd.setDelFlag(false);
					sd.setDescription("");
					sd.setLabelText(city);
					sd.setParentId(parId);
					sd.setUpdateBy("1");
					sd.setUpdateDate(new Date());
					sd.setValue(id);
					sd.setRemarks("");
					sd.setSort(new BigDecimal(StringUtils.stringToInteger(id)));
					sd.setType("SYSCITY");
					sd.setId(UuidUtil.get32UUID());
					mapper.insert(sd);
					//sd.setSort(new BigDecimal(new Integer(id)));
					//mapper.updateByPrimaryKey(sd);
					
				}
			}
		}
	}
	
	public List<SysDict> getSysDictByType(String type) throws Exception{
		SysDictMapper mapper =dao.getMapper(SysDictMapper.class);
		SysDictExample exp = new SysDictExample();
		exp.createCriteria().andTypeEqualTo(type).andDelFlagEqualTo(false);
		return mapper.selectByExample(exp);
	}
	
}
