/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.nj.service.enterprise;

import java.io.File;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.XMLFileUtil;
import com.nj.dao.NjProductTagMapper;
import com.nj.dao.NjProductTempMapper;
import com.nj.dao.extend.NjProductMapperExtend;
import com.nj.model.generate.NjProductTag;
import com.nj.model.generate.NjProductTagExample;
import com.nj.model.generate.NjProductTagExample.Criteria;
import com.nj.model.generate.NjProductTemp;
import com.nj.model.generate.NjProductTempExample;

@Transactional(readOnly = true)
@Service("productTemplateService")
public class ProductTemplateService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	
	public Map<String,Object> getTemplateDataByTempId(HttpServletRequest request, String tempId) throws Exception {
		
		String path = request.getSession().getServletContext().getRealPath("static"+File.separator +"upload");

		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		String fileName = sm.getTemplateNameByTempId(tempId);
		File targetFile = new File(path, fileName);
		
		return XMLFileUtil.getXmlFileData(targetFile);
	}
	
	
	public Map<String,Object> getTemplateData(HttpServletRequest request, String productId) throws Exception {
		
		String path = request.getSession().getServletContext().getRealPath("static"+File.separator +"upload");

		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		String fileName = sm.getTemplateName(productId);
		File targetFile = new File(path, fileName);
		
		return XMLFileUtil.getXmlFileData(targetFile);
	}
	
	/**
	 * 获取产品TAG列表
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<NjProductTag> getTagList(String productId) throws Exception {
		
		NjProductTagMapper sm = dao.getMapper(NjProductTagMapper.class);
		NjProductTagExample example = new NjProductTagExample();
		Criteria criteria = example.createCriteria();
		criteria.andProductIdEqualTo(productId);
		return sm.selectByExample(example);
	}


	public NjProductTemp getByProductId(String productId) throws Exception {
		NjProductTempMapper sm = dao.getMapper(NjProductTempMapper.class);
		NjProductTempExample example = new NjProductTempExample();
		example.createCriteria().andProductIdEqualTo(productId);
		List<NjProductTemp> list = sm.selectByExample(example);
		if(list != null && list.size() >0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}
	
	
}
