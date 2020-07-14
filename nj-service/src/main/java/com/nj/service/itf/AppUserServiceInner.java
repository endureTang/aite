package com.nj.service.itf;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjUserCertMapper;
import com.nj.dao.extend.NjUserCertMapperExtend;
import com.nj.model.generate.NjUserCert;

@Transactional(readOnly = true)
@Service("appUserServiceInner")
public class AppUserServiceInner {
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	private Logger logger = LoggerFactory.getLogger(AppUserServiceInner.class);
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public String  addAppUserCert(NjUserCert userCert)throws Exception{
		//获取最新的身份证信息
		NjUserCertMapperExtend certMapperExt = dao.getMapper(NjUserCertMapperExtend.class);
		NjUserCertMapper certMapper = dao.getMapper(NjUserCertMapper.class);
		NjUserCert recentCert = certMapperExt.getRecentUserCertByUserId(userCert.getUserId());
		
		if(recentCert==null){//当前没有身份证信息
			userCert.setId(UuidUtil.get32UUID());
			userCert.setDelFlag(false);
			userCert.setCheckStatus(0x0);
			userCert.setCheckResult("");
			userCert.setVersion(1);
			userCert.setCreateDate(new Date());
			certMapper.insert(userCert);			
			return userCert.getId();
		}
		else{
			if(recentCert.getCheckStatus() ==1){
				//审核通过，不允许修改
				throw new Exception("照片已经审核通过，不允许修改");
			}
			recentCert.setCheckStatus(0x0);
			recentCert.setVersion(recentCert.getVersion()+1);
			recentCert.setDelFlag(false);
			recentCert.setCheckResult(null);
			if(!StringUtils.isEmpty(userCert.getFrontId())){
				if(!userCert.getFrontId().equals(recentCert.getFrontId())){
					recentCert.setFrontId(userCert.getFrontId());
				}
			}
			if(!StringUtils.isEmpty(userCert.getBackId())){
				if(!userCert.getBackId().equals(recentCert.getBackId())){
					recentCert.setBackId(userCert.getBackId());
				}
			}
			if(!StringUtils.isEmpty(userCert.getHandCertId())){
				if(!userCert.getHandCertId().equals(recentCert.getHandCertId())){
					recentCert.setHandCertId(userCert.getHandCertId());
				}
			}
			recentCert.setId(UuidUtil.get32UUID());
			certMapper.insert(recentCert);
			return recentCert.getId();
		}		
	}
}
