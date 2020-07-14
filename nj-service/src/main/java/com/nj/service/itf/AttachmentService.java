package com.nj.service.itf;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserAttachmentExample;

@Transactional(readOnly = true)
@Service("attachmentService")
public class AttachmentService {
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public NjUserAttachment getAttachment(String attachId) throws Exception{
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		return mapper.selectByPrimaryKey(attachId);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserAttachment save(NjUserAttachment att) throws Exception{
		if(StringUtils.isEmpty(att.getId()))
			att.setId(UuidUtil.get32UUID());
		NjUserAttachmentMapper map =dao.getMapper(NjUserAttachmentMapper.class);
		map.insert(att);
		return att;
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserAttachment update(NjUserAttachment att) throws Exception{
		if(StringUtils.isEmpty(att.getId()))
			att.setId(UuidUtil.get32UUID());
		NjUserAttachmentMapper map =dao.getMapper(NjUserAttachmentMapper.class);
		map.updateByPrimaryKeySelective(att);
		return att;
	}
	
	public List<NjUserAttachment> getNotDownloadOutFile() throws Exception{
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachmentExample example = new NjUserAttachmentExample();
		example.createCriteria().andSourceIsNotNull().andFilePathIsNull();
		return mapper.selectByExample(example);
	}
}
