package com.nj.service.esign;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.StringUtils;
import com.nj.dao.NjAppUserMapper;
import com.nj.dao.esign.mapper.base.EsignAccountSealMapper;
import com.nj.model.esign.base.EsignAccountSeal;
import com.nj.model.esign.base.EsignAccountSealExample;
import com.nj.model.esign.bean.CreatePerAcctInfo;
import com.nj.model.esign.bean.ECPerAcctInfo;
import com.nj.model.esign.constants.EsignCoporateAccountConstant;
import com.nj.model.generate.NjAppUser;

@Service("apiEsignService")
public class ApiEsignService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Resource(name = "accountService")
	private AccountService accountService;
	
	private static Logger logger = LoggerFactory.getLogger(ApiEsignService.class);
	
	/**
	 * 验证个人用户是否注册e签宝账户ID，若没有注册则注册
	 * @return
	 */
	public String valPerUserIsCreateAccountId(String userId){
		
		String accountId = "";
		try {
			accountId = accountService.getAccountId(userId, null, null);	//没有在e签宝上注册账户
			if (StringUtils.isEmpty(accountId)) {
				NjAppUserMapper auMapper = dao.getMapper(NjAppUserMapper.class);
				NjAppUser user = auMapper.selectByPrimaryKey(userId);
				
				CreatePerAcctInfo cpaInfo = new CreatePerAcctInfo();
				cpaInfo.setUserId(userId);
				ECPerAcctInfo personAcctInfo = new  ECPerAcctInfo();
				personAcctInfo.setMobile(user.getMobile());
				personAcctInfo.setEmail(user.getMial());
				personAcctInfo.setName(user.getTrueName());
				personAcctInfo.setIdNo(user.getIdentifyId());		
				cpaInfo.setPersonAcctInfo(personAcctInfo);
				
				accountId = accountService.producePersonAccount(cpaInfo);
			}
		} catch (Exception e) {
			logger.error("个人用户在e签宝注册账户时valPerUserIsCreateAccountId失败：",e);
		}
		
		return accountId;
	}
	
	/**
	 * 验证企业是否在微贷平台上创建企业印章
	 */
	public Boolean valCopoIsCreateAccountId(String coporateId){
		try {
			String accountId = accountService.getAccountId(null, coporateId, EsignCoporateAccountConstant.ACCOUNTTYPE_COPORATE);
			if(StringUtils.isEmpty(accountId)){
				return false;
			}
			EsignAccountSealMapper easMapper = dao.getMapper(EsignAccountSealMapper.class);
			EsignAccountSealExample ex = new EsignAccountSealExample();
			ex.createCriteria().andAccountIdEqualTo(accountId);
			List<EsignAccountSeal> list = easMapper.selectByExample(ex);
			if(CollectionUtils.isEmpty(list)){
				return false;
			}
		} catch (Exception e) {
			logger.error("企业ID为"+coporateId+"的企业未在微贷系统上创建企业印章.");
		}
		return true;
	}
}
