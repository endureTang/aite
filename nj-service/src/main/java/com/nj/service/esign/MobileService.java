package com.nj.service.esign;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.esign.mapper.base.EsignPersonAccountMapper;
import com.nj.model.esign.base.EsignPersonAccount;
import com.nj.model.esign.base.EsignPersonAccountExample;
import com.timevale.esign.sdk.tech.service.factory.MobileServiceFactory;

/**
 * 签署时进行身份认证的服务。如发送验证码、语音认证
 * 进行验证码签署时，需先调用下面某些接口进行验证码发送
 * @author wkh
 *
 */
@Service("mobileService")
public class MobileService extends BaseEsignService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	/**
	 * 为指定账号基本信息中的手机号码发送短信
	 * 
	 * @param userId
	 *            用户id
	 * @throws Exception
	 */
	public void sendSignCode(String userId) throws Exception {
		
		sdkInit();
		
		EsignPersonAccountMapper eam = dao.getMapper(EsignPersonAccountMapper.class);
		EsignPersonAccountExample example = new EsignPersonAccountExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<EsignPersonAccount> eaList = eam.selectByExample(example);
		if (CollectionUtils.isEmpty(eaList)) {
			throw new Exception("该用户还未在e签宝中注册账户");
		}
		String accountId = eaList.get(0).getAccountId();
		
		com.timevale.esign.sdk.tech.service.MobileService mSrv = MobileServiceFactory.instance();
		com.timevale.esign.sdk.tech.bean.result.Result result = mSrv.sendSignMobileCode(accountId);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}
	}

	/**
	 * 为指定账号指定的手机号码发送短信
	 * 
	 * @param userId
	 *            用户id
	 * @param mobileNumber
	 *            指定的电话号码
	 * @throws Exception
	 */
	public void sendSignCode_specifiedNumber(String userId, String mobileNumber) throws Exception {
		
		sdkInit();
		
		EsignPersonAccountMapper eam = dao.getMapper(EsignPersonAccountMapper.class);
		EsignPersonAccountExample example = new EsignPersonAccountExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<EsignPersonAccount> eaList = eam.selectByExample(example);
		if (CollectionUtils.isEmpty(eaList)) {
			throw new Exception("该用户还未在e签宝中注册账户");
		}
		String accountId = eaList.get(0).getAccountId();
		
		com.timevale.esign.sdk.tech.service.MobileService mSrv = MobileServiceFactory.instance();
		com.timevale.esign.sdk.tech.bean.result.Result result = mSrv.sendSignMobileCode3rd(accountId, mobileNumber);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}
	}

	/**
	 * 为指定账号发送语音验证码
	 * 
	 * @param userId
	 *          	用户id
	 * @throws Exception
	 */
	public void sendSignVoice(String userId) throws Exception {
		
		sdkInit();
		
		EsignPersonAccountMapper eam = dao.getMapper(EsignPersonAccountMapper.class);
		EsignPersonAccountExample example = new EsignPersonAccountExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<EsignPersonAccount> eaList = eam.selectByExample(example);
		if (CollectionUtils.isEmpty(eaList)) {
			throw new Exception("该用户还未在e签宝中注册账户");
		}
		String accountId = eaList.get(0).getAccountId();
		
		com.timevale.esign.sdk.tech.service.MobileService mSrv = MobileServiceFactory.instance();
		com.timevale.esign.sdk.tech.bean.result.Result result = mSrv.sendSignMobileVoice(accountId);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}
	}
}
