/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.nj.service.base.system;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjTemplateMapper;
import com.nj.model.generate.NjTemplate;
import com.nj.model.generate.NjTemplateExample;
import com.nj.model.generate.NjTemplateExample.Criteria;

/**
 * 模板管理
 * 
 * @author gongj
 * @version 2017-02-16
 */
@Transactional(readOnly = true)
@Service("templateService")
public class TemplateService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	public List<NjTemplate> getTemplateList(Map<?, ?> parames) throws Exception {
		NjTemplateMapper sm = dao.getMapper(NjTemplateMapper.class);
		
		NjTemplateExample example = new NjTemplateExample();
		Criteria criteria = example.createCriteria();    
		
		if(parames.get("templateName") != null){
			criteria.andTemplateNameEqualTo(parames.get("templateName").toString());
		}
		
		return sm.selectByExample(example);
	}


}