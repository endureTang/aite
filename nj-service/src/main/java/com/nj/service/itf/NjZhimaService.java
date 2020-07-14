package com.nj.service.itf;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjUserZhimaAuthMapper;
import com.nj.dao.UserZhimaIvsLogMapper;
import com.nj.dao.UserZhimaIvsScoreMapper;
import com.nj.dao.UserZhimaScoreMapper;
import com.nj.dao.ZhimaScoreLogMapper;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjUserZhimaAuth;
import com.nj.model.generate.NjUserZhimaAuthExample;
import com.nj.model.generate.UserZhimaIvsLog;
import com.nj.model.generate.UserZhimaIvsScore;
import com.nj.model.generate.UserZhimaIvsScoreExample;
import com.nj.model.generate.UserZhimaScore;
import com.nj.model.generate.ZhimaScoreLog;

@Transactional(readOnly = true)
@Service("njZhimaService")
public class NjZhimaService {
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public NjUserZhimaAuth getAuth(NjAppUser user) throws Exception{
		NjUserZhimaAuthMapper mapper = dao.getMapper(NjUserZhimaAuthMapper.class);
		NjUserZhimaAuthExample example = new NjUserZhimaAuthExample();
		example.createCriteria()
		.andUserIdEqualTo(user.getId())
		.andDelFlagEqualTo(false);
		example.setOrderByClause("create_date desc");
		List<NjUserZhimaAuth> auths =mapper.selectByExample(example);
		if(auths ==null || auths.isEmpty()){
			return null;
		}
		else{
			return auths.get(0);
		}
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserZhimaAuth updateAuth(NjUserZhimaAuth auth) throws Exception{
		auth.setUpdateDate(new Date());
		NjUserZhimaAuthMapper mapper = dao.getMapper(NjUserZhimaAuthMapper.class);
		mapper.updateByPrimaryKeySelective(auth);
		return auth;
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserZhimaAuth insertAuth(NjUserZhimaAuth auth) throws Exception{
		auth.setId(UuidUtil.get32UUID());
		NjUserZhimaAuthMapper mapper = dao.getMapper(NjUserZhimaAuthMapper.class);
		mapper.insert(auth);
		return auth;
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void deleteAuth(NjUserZhimaAuth auth) throws Exception{
		NjUserZhimaAuthMapper mapper = dao.getMapper(NjUserZhimaAuthMapper.class);
		auth.setDelFlag(true);
		mapper.updateByPrimaryKeySelective(auth);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public ZhimaScoreLog insertScoreLog(ZhimaScoreLog log) throws Exception{
		log.setId(UuidUtil.get32UUID());
		ZhimaScoreLogMapper mapper = dao.getMapper(ZhimaScoreLogMapper.class);
		mapper.insert(log);
		return log;
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public UserZhimaScore insertScore(UserZhimaScore score)throws Exception{
		score.setId(UuidUtil.get32UUID());
		UserZhimaScoreMapper mapper = dao.getMapper(UserZhimaScoreMapper.class);
		mapper.insert(score);
		return score;
	}
		
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjUserZhimaAuth saveAuth(NjAppUser user, String openId) throws Exception{
			//删除以前的记录
		NjUserZhimaAuthMapper mapper = dao.getMapper(NjUserZhimaAuthMapper.class);
			NjUserZhimaAuth oldAuth = getAuth(user);
			if(oldAuth ==null){
				NjUserZhimaAuth auth = new NjUserZhimaAuth();
				auth.setId(UuidUtil.get32UUID());
				auth.setToken(openId);
				auth.setDelFlag(false);
				auth.setUserId(user.getId());
				auth.setEndDate(new Date(2050,9,9));
				auth.setCreateDate(new Date());
				auth.setUpdateDate(new Date());
				mapper.insert(auth);
				return auth;
			}
			else{
				oldAuth.setToken(openId);
				oldAuth.setUpdateDate(new Date());
				mapper.updateByPrimaryKeySelective(oldAuth);
				return oldAuth;
			}
	
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public List<NjUserZhimaAuth> deleteAuth(NjAppUser user) throws Exception{
		NjUserZhimaAuthMapper mapper = dao.getMapper(NjUserZhimaAuthMapper.class);
		NjUserZhimaAuthExample example = new NjUserZhimaAuthExample();
		example.createCriteria()
		.andUserIdEqualTo(user.getId())
		.andDelFlagEqualTo(false);
		example.setOrderByClause("create_date desc");
		List<NjUserZhimaAuth> auths =mapper.selectByExample(example);
		if(auths !=null){
			for(NjUserZhimaAuth u:auths){
				u.setDelFlag(true);
				u.setUpdateDate(new Date());
				mapper.updateByPrimaryKey(u);
			}
		}
		return auths;
	}
	
	/**
	 * 获取ivs
	 * @param orderId
	 * @param inputMd5
	 * @return 
	 */
	public UserZhimaIvsScore getIvs(String orderId, String inputMd5) throws Exception{
		if(StringUtils.isEmpty(orderId) || StringUtils.isEmpty(inputMd5)){
			return null;
		}
		UserZhimaIvsScoreMapper mapper  = dao.getMapper(UserZhimaIvsScoreMapper.class);
		UserZhimaIvsScoreExample example = new UserZhimaIvsScoreExample();
		example.createCriteria().andOrderIdEqualTo(orderId).andInputMd5EqualTo(inputMd5);
		example.setOrderByClause("create_date desc");
		List<UserZhimaIvsScore> scores =mapper.selectByExample(example);
		
		if(scores ==null || scores.isEmpty()){
			return null;
		}
		return scores.get(0);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public UserZhimaIvsLog saveZhimaIvsLog(UserZhimaIvsLog log) throws Exception{
		log.setId(UuidUtil.get32UUID());
		log.setCreateDate(new Date());
		UserZhimaIvsLogMapper mapper = dao.getMapper(UserZhimaIvsLogMapper.class);
		mapper.insert(log);
		return log;
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public UserZhimaIvsScore saveZhimaIvs(UserZhimaIvsScore ivs) throws Exception{
		ivs.setId(UuidUtil.get32UUID());
		ivs.setCreateDate(new Date());
		UserZhimaIvsScoreMapper mapper = dao.getMapper(UserZhimaIvsScoreMapper.class);
		mapper.insert(ivs);
		return ivs;
	}
 }
