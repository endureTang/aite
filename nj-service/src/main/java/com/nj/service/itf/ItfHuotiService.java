package com.nj.service.itf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.dao.extend.NjOrderHuotiMapperExtend;
import com.nj.dao.extend.NjUserAttachmentMapperExtend;
import com.nj.dao.extend.NjUserCertMapperExtend;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserCert;

public class ItfHuotiService {
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	private static Logger logger = LoggerFactory.getLogger(ItfHuotiService.class);
	
	
	public Map<String, Object> getHuotiImageUrlByOrder(NjLoanOrder order)throws Exception{
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("headImage", getHeadCertImagUrlByOrder(order));
		ret.put("emblemImage", getEmblemCertImagUrlByOrder(order));
		ret.put("handCertImage", getHandCertImagUrlByOrder(order));
		ret.put("faceIdImage", getHuotiImageUrlByOrder2(order));
		return ret;
	}
	
	//faceid图片应该是list
	public List<String> getHuotiImageUrlByOrder2(NjLoanOrder order) throws Exception{
		NjOrderHuotiMapperExtend huotiMapper = dao.getMapper(NjOrderHuotiMapperExtend.class);
		List<Map> huotiImg = huotiMapper.getHuotiByOrderId(order.getId());
		List<String> ret = new ArrayList();
		if(huotiImg==null || huotiImg.isEmpty()){
			//兼容老版本,从faceid中获取
			NjUserAttachmentMapperExtend m = dao.getMapper(NjUserAttachmentMapperExtend.class);
			ret.add(m.getFaceIdImageUrl(order.getId()));						
		}else{
			for(Map e:huotiImg){
				ret.add((String)e.get("url"));
			}
		}
		return ret;
	}
	
	public String getHeadCertImagUrlByOrder(NjLoanOrder order) throws Exception{
		if(order ==null){
			return null;
		}
		//修改，先从nj_user_cert中获取，然后再从代码中获取
		NjUserCertMapperExtend uceMapper = dao.getMapper(NjUserCertMapperExtend.class);
		NjUserCert cert = uceMapper.getUserCertByOrderId(order.getId());
		if((cert!=null) &&(!StringUtils.isEmpty(cert.getFrontId()))){
			NjUserAttachmentMapper uaMapper = dao.getMapper(NjUserAttachmentMapper.class);
			NjUserAttachment a= uaMapper.selectByPrimaryKey(cert.getFrontId());
			if(a!=null){
				return a.getFilePath();
			}
			else{
				return null;
			}
		}else{
			NjUserAttachmentMapperExtend mapper = dao.getMapper(NjUserAttachmentMapperExtend.class);
			return mapper.getHeadImageUrl(order.getUserId());
		}
	}
	
	public String getEmblemCertImagUrlByOrder(NjLoanOrder order) throws Exception{
		if(order ==null){
			return null;
		}
		//修改，先从nj_user_cert中获取，然后再从代码中获取
		NjUserCertMapperExtend uceMapper = dao.getMapper(NjUserCertMapperExtend.class);
		NjUserCert cert = uceMapper.getUserCertByOrderId(order.getId());
		if((cert!=null) &&(!StringUtils.isEmpty(cert.getBackId()))){
			NjUserAttachmentMapper uaMapper = dao.getMapper(NjUserAttachmentMapper.class);
			NjUserAttachment a= uaMapper.selectByPrimaryKey(cert.getBackId());
			if(a!=null){
				return a.getFilePath();
			}
			else{
				return null;
			}
		}else{
			NjUserAttachmentMapperExtend mapper = dao.getMapper(NjUserAttachmentMapperExtend.class);
			return mapper.getEmblemImageUrl(order.getUserId());
		}
	}
	
	public String getHandCertImagUrlByOrder(NjLoanOrder order) throws Exception{
		if(order ==null){
			return null;
		}
		//修改，先从nj_user_cert中获取，然后再从代码中获取
		NjUserCertMapperExtend uceMapper = dao.getMapper(NjUserCertMapperExtend.class);
		NjUserCert cert = uceMapper.getUserCertByOrderId(order.getId());
		if((cert!=null) &&(!StringUtils.isEmpty(cert.getHandCertId()))){
			NjUserAttachmentMapper uaMapper = dao.getMapper(NjUserAttachmentMapper.class);
			NjUserAttachment a= uaMapper.selectByPrimaryKey(cert.getHandCertId());
			if(a!=null){
				return a.getFilePath();
			}
			else{
				return null;
			}
		}else{
			return null;
		}
	}
}
