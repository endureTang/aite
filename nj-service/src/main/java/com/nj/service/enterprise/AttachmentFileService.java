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

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.model.generate.NjUserAttachment;

@Transactional(readOnly = true)
@Service("attachmentFileService")
public class AttachmentFileService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	private static Logger logger = LoggerFactory.getLogger(AttachmentFileService.class);
	
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public String add(NjUserAttachment product) throws Exception {
		product.setId(UuidUtil.get32UUID());
		NjUserAttachmentMapper sm = dao.getMapper(NjUserAttachmentMapper.class);
		sm.insert(product);
		return product.getId();
	}
	
	@Transactional(rollbackFor={Throwable.class}, readOnly=false)
	public String getAttachmentById(String id) throws Exception {
		NjUserAttachmentMapper sm = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = sm.selectByPrimaryKey(id);
		if(att != null){
			return att.getFileName();
		}
		return null;
	}
	
	public NjUserAttachment getAttachmentByFileId(String id) throws Exception {
		NjUserAttachmentMapper sm = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = sm.selectByPrimaryKey(id);
		return att;
	}
}
