package com.nj.service.itf;

import java.util.*;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjVersionMapper;
import com.nj.model.generate.NjVersion;
import com.nj.model.generate.NjVersionExample;

@Service("itfNjVersionService")
public class ItfNjVersionService {
	
	private static Logger logger = LoggerFactory.getLogger(ItfNjVersionService.class);
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public Map<String, Object> detectUpdate(Integer versionCode, Integer type,Integer tokenType) throws Exception{
		Map<String,Object> result = new HashMap<String, Object>();
		NjVersionMapper mapper = dao.getMapper(NjVersionMapper.class);
		NjVersionExample ex= new NjVersionExample();
		ex.setOrderByClause("create_date desc");
		ex.createCriteria().andTypeEqualTo(type).andAppTypeEqualTo(tokenType);
		List<NjVersion> lists = mapper.selectByExample(ex);
		if((lists==null) || lists.isEmpty()){
			logger.debug("版本表为空");
			result.put("need_update", 0);
			return result;
		}
		else{
			NjVersion version = lists.get(0);
			if(type == 0){ //android版本
				if(versionCode < version.getUpdateAndroidVersionCode()){//升级
					result.put("version", version.getUpdateAndroidVersion());
					result.put("need_update", 1);
					result.put("force_update", version.getIsForceUpdate());
					result.put("url", version.getAndroidDownloadUrl());
					result.put("notice",version.getUpdateNotice());
					return result;
				}
				else{
					result.put("need_update", 0);
					return result;
				}
			}
			else if(type ==1){//ios版本
				if(versionCode < version.getUpdateIosVersionCode()){//升级
					result.put("version", version.getUpdateIosVersion());
					result.put("need_update", 1);
					result.put("force_update", version.getIsForceUpdate());
					result.put("url", version.getIosDownloadUrl());
					result.put("notice",version.getUpdateNotice());
					return result;
				}
				else{
					result.put("need_update", 0);
					return result;
				}
			}
			else{
				throw  new Exception("非法参数");
			}
		}
	}
}
