package com.nj.service.esign;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.StringUtils;
import com.nj.dao.esign.mapper.base.EsignCoporateAccountMapper;
import com.nj.dao.esign.mapper.base.EsignPersonAccountMapper;
import com.nj.model.esign.base.EsignCoporateAccount;
import com.nj.model.esign.base.EsignCoporateAccountExample;
import com.nj.model.esign.base.EsignPersonAccount;
import com.nj.model.esign.base.EsignPersonAccountExample;
import com.nj.model.esign.bean.CreateCopoAcctInfo;
import com.nj.model.esign.bean.CreatePerAcctInfo;
import com.nj.model.esign.bean.UptCopoAcctInfo;
import com.nj.model.esign.bean.UptPerAcctInfo;
import com.nj.model.esign.constants.EsignCoporateAccountConstant;
import com.timevale.esign.sdk.tech.bean.result.AddAccountResult;
import com.timevale.esign.sdk.tech.bean.result.Result;
import com.timevale.esign.sdk.tech.service.factory.AccountServiceFactory;

/**
 * 证书生成服务 管理账户信息的服务
 * 
 * @author wkh
 */
@Service("accountService")
public class AccountService extends BaseEsignService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	/**
	 * 创建个人用户账户
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public String producePersonAccount(CreatePerAcctInfo cpaInfo) throws Exception {

		String userId = cpaInfo.getUserId();
		if (StringUtils.isEmpty(userId)) {
			throw new Exception("用户id不能为空");
		}

		sdkInit();

		com.timevale.esign.sdk.tech.service.AccountService accountSrv = AccountServiceFactory.instance();
		AddAccountResult result = accountSrv.addAccount(cpaInfo.convertPersonBean());

		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String accountId = result.getAccountId();
		EsignPersonAccount epa = new EsignPersonAccount();
		epa.setUserId(userId);
		epa.setAccountId(accountId);

		EsignPersonAccountMapper epam = dao.getMapper(EsignPersonAccountMapper.class);
		epam.insert(epa);
		
		return accountId;
	}

	/**
	 * 更新个人用户账户信息
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void replacePersonAccount(UptPerAcctInfo upaInfo) throws Exception {

		if (null == upaInfo) {
			throw new Exception("paInfo不能为空");
		}
		String userId = upaInfo.getUserId();
		if (StringUtils.isEmpty(userId)) {
			throw new Exception("userId不能为空");
		}

		sdkInit();

		EsignPersonAccountMapper epam = dao.getMapper(EsignPersonAccountMapper.class);
		EsignPersonAccountExample example = new EsignPersonAccountExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<EsignPersonAccount> eaList = epam.selectByExample(example);
		if (CollectionUtils.isEmpty(eaList)) {
			throw new Exception("该用户还未在e签宝中注册账户");
		}

		com.timevale.esign.sdk.tech.service.AccountService accountSrv = AccountServiceFactory.instance();
		Result rs = accountSrv.updateAccount(eaList.get(0).getAccountId(), upaInfo.convertPersonBean(), null);
		if (rs.getErrCode() != 0) {
			throw new Exception(rs.getMsg());
		}
	}

	/**
	 * 创建企业账户
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public String produceCoporateAccount(CreateCopoAcctInfo copoAccount) throws Exception {

		String coporateId = copoAccount.getCoporateId();
		if (StringUtils.isEmpty(coporateId)) {
			throw new Exception("企业id不能为空");
		}
		int acctType = copoAccount.getAcctType();
		if (acctType == 0) {
			throw new Exception("账户类型不能为空");
		}

		sdkInit();

		return saveCopoAcct(copoAccount, coporateId, acctType);
	}

	private String saveCopoAcct(CreateCopoAcctInfo copoAccount, String coporateId, int acctType) throws Exception {
		com.timevale.esign.sdk.tech.service.AccountService accountSrv = AccountServiceFactory.instance();
		AddAccountResult result = null;
		if (acctType == EsignCoporateAccountConstant.ACCOUNTTYPE_LEGAL) {
			result = accountSrv.addAccount(copoAccount.convertPersonBean());
		} else if (acctType == EsignCoporateAccountConstant.ACCOUNTTYPE_COPORATE) {
			result = accountSrv.addAccount(copoAccount.convertOrganizeBean());
		}

		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String accountId = result.getAccountId();
		EsignCoporateAccount eca = new EsignCoporateAccount();
		eca.setCoporateId(coporateId);
		eca.setAccountId(accountId);
		if (acctType == EsignCoporateAccountConstant.ACCOUNTTYPE_LEGAL) {
			eca.setAccountType(EsignCoporateAccountConstant.ACCOUNTTYPE_LEGAL);
		} else if (acctType == EsignCoporateAccountConstant.ACCOUNTTYPE_COPORATE) {
			eca.setAccountType(EsignCoporateAccountConstant.ACCOUNTTYPE_COPORATE);
		}

		EsignCoporateAccountMapper ecam = dao.getMapper(EsignCoporateAccountMapper.class);
		ecam.insert(eca);
		
		return accountId;
	}

	/**
	 * 更新企业账户
	 */
	@Transactional(rollbackFor={Throwable.class})
	public void replaceCoporateAccount(UptCopoAcctInfo copoAccount) throws Exception {

		String coporateId = copoAccount.getCoporateId();
		if (StringUtils.isEmpty(coporateId)) {
			throw new Exception("企业id不能为空");
		}
		int acctType = copoAccount.getAcctType();
		if (acctType == 0) {
			throw new Exception("账户类型不能为空");
		}

		sdkInit();

		EsignCoporateAccountMapper ecaMapper = dao.getMapper(EsignCoporateAccountMapper.class);
		EsignCoporateAccountExample ex = new EsignCoporateAccountExample();
		com.nj.model.esign.base.EsignCoporateAccountExample.Criteria c = ex.createCriteria();
		c.andCoporateIdEqualTo(coporateId);
		c.andAccountTypeEqualTo(acctType);
		List<EsignCoporateAccount> list = ecaMapper.selectByExample(ex);
		if (CollectionUtils.isEmpty(list)) {
			throw new Exception(
					"企业ID为:" + coporateId + "的企业还未在e签宝中注册" + EsignCoporateAccountConstant.getAcctTypeStr(acctType));
		}
		String accountId = list.get(0).getAccountId();
		com.timevale.esign.sdk.tech.service.AccountService accountSrv = AccountServiceFactory.instance();
		Result rs = null;
		if (acctType == EsignCoporateAccountConstant.ACCOUNTTYPE_COPORATE) {
			rs = accountSrv.updateAccount(accountId, copoAccount.convertCopoBean(), null);
		}
		if (acctType == EsignCoporateAccountConstant.ACCOUNTTYPE_LEGAL) {
			rs = accountSrv.updateAccount(accountId, copoAccount.convertPersonBean(), null);
		}
		if (rs.getErrCode() != 0) {
			throw new Exception(rs.getMsg());
		}
	}
	
	/**
	 * 获取e签宝账户id
	 * @param userId 查询平台个人用户的e签宝账户id时，该参数不能为空,其他参数为空
	 * @param coporateId 查询平台企业账户和企业法人账户时，该参数不能为空，userId为空
	 * @param acctType 查询平台企业账户和企业法人账户时，该参数不能为空,userId为空。使用常量EsignCoporateAccountConstant
	 */
	public String getAccountId(String userId,String coporateId,Integer acctType) throws Exception{
		if(StringUtils.isNotEmpty(userId)){
			EsignPersonAccountMapper mapper = dao.getMapper(EsignPersonAccountMapper.class);
			EsignPersonAccountExample ex = new EsignPersonAccountExample();
			ex.createCriteria().andUserIdEqualTo(userId);
			List<EsignPersonAccount> list = mapper.selectByExample(ex);
			if(CollectionUtils.isEmpty(list)){
				return null;
			}else{
				return list.get(0).getAccountId();
			}
		}
		
		if(acctType != 0 && StringUtils.isNotEmpty(coporateId)){
			EsignCoporateAccountMapper mapper = dao.getMapper(EsignCoporateAccountMapper.class);
			EsignCoporateAccountExample ex = new EsignCoporateAccountExample();
			ex.createCriteria().andCoporateIdEqualTo(coporateId).andAccountTypeEqualTo(acctType);
			List<EsignCoporateAccount> list = mapper.selectByExample(ex);
			if(CollectionUtils.isEmpty(list)){
				return null;
			}else{
				return list.get(0).getAccountId();
			}
		}
		
		return null;
	}
}
