package com.nj.service.esign;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.esign.mapper.base.EsignAccountSealMapper;
import com.nj.dao.esign.mapper.base.EsignCoporateAccountMapper;
import com.nj.dao.esign.mapper.base.EsignPersonAccountMapper;
import com.nj.dao.esign.mapper.extend.EsignAccountSealMapperExtend;
import com.nj.model.esign.base.EsignAccountSeal;
import com.nj.model.esign.base.EsignAccountSealExample;
import com.nj.model.esign.base.EsignCoporateAccount;
import com.nj.model.esign.base.EsignCoporateAccountExample;
import com.nj.model.esign.base.EsignPersonAccount;
import com.nj.model.esign.base.EsignPersonAccountExample;
import com.nj.model.esign.constants.EsignCoporateAccountConstant;
import com.timevale.esign.sdk.tech.bean.result.AddSealResult;
import com.timevale.esign.sdk.tech.bean.seal.OrganizeTemplateType;
import com.timevale.esign.sdk.tech.bean.seal.PersonTemplateType;
import com.timevale.esign.sdk.tech.bean.seal.SealColor;
import com.timevale.esign.sdk.tech.service.factory.SealServiceFactory;

/**
 * 模板印章服务
 * 
 * @author wkh
 *
 */
@Service("sealService")
public class SealService extends BaseEsignService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Resource(name = "accountService")
	private AccountService accountService;

	/**
	 * 创建个人模板印章并入库
	 * 
	 * @param userId
	 *            用户id
	 * @param paramPersonTemplateType
	 *            枚举，模板印章的类型.枚举值对应的效果参考《e签宝快捷签SDK接口说明-JAVA_v2.0.9》40页
	 * @param paramSealColor
	 *            枚举，模板印章的颜色
	 * @param isSave 是否入库：是否建立用户与印章的关联关系
	 * @throws Exception
	 */
	@Transactional(rollbackFor={Throwable.class})
	public String producePersonSeal(String userId, PersonTemplateType paramPersonTemplateType, SealColor paramSealColor,Boolean isSave)
			throws Exception {

		sdkInit();
		
		EsignPersonAccountMapper eam = dao.getMapper(EsignPersonAccountMapper.class);
		EsignPersonAccountExample example = new EsignPersonAccountExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<EsignPersonAccount> eaList = eam.selectByExample(example);
		if (CollectionUtils.isEmpty(eaList)) {
			throw new Exception("该用户还未在e签宝中注册账户");
		}
		String accountId = eaList.get(0).getAccountId();
		
		com.timevale.esign.sdk.tech.service.SealService sealSrv = SealServiceFactory.instance();
		AddSealResult asResult = sealSrv.addTemplateSeal(accountId, paramPersonTemplateType, paramSealColor);
		if (asResult.getErrCode() != 0) {
			throw new Exception(asResult.getMsg());
		}
		String sealData = asResult.getSealData(); // 电子印章图片的base64数据

		if(isSave){
			saveSeal(accountId, sealData , null);
		}
		
		return sealData;
	}
	
	/**
	 * 创建企业的企业印章并入库
	 * @param coporateId 企业id
	 * @param templateType	模板类型，请参考《e签宝快捷签SDK接口说明-JAVA_v2.0.9》41页
	 * @param color	印章颜色，使用枚举SealColor
	 * @param hText	横向文
	 * @param qText	下弦文
	 * @param isSave 是否入库：是否建立用户与印章的关联关系
	 * @throws Exception 
	 */
	@Transactional(rollbackFor={Throwable.class})
	public String produceCopoCopoSeal(String coporateId,OrganizeTemplateType templateType,SealColor color,String hText,String qText,Boolean isSave) throws Exception{
		
		sdkInit();
		
		EsignCoporateAccountMapper ecaMapper = dao.getMapper(EsignCoporateAccountMapper.class);
		EsignCoporateAccountExample ex = new EsignCoporateAccountExample();
		ex.createCriteria().andCoporateIdEqualTo(coporateId).andAccountTypeEqualTo(EsignCoporateAccountConstant.ACCOUNTTYPE_COPORATE);
		List<EsignCoporateAccount> ecaList = ecaMapper.selectByExample(ex);
		if(CollectionUtils.isEmpty(ecaList)){
			throw new Exception("该企业还未在e签宝中注册企业账户");
		}
		
		String accountId = ecaList.get(0).getAccountId();
		com.timevale.esign.sdk.tech.service.SealService sealSrv = SealServiceFactory.instance();
		AddSealResult asResult = sealSrv.addTemplateSeal(accountId, templateType, color, hText, qText);
		if (asResult.getErrCode() != 0) {
			throw new Exception(asResult.getMsg());
		}
		
		String sealData = asResult.getSealData(); // 电子印章图片的base64数据

		if(isSave){
			saveSeal(accountId, sealData ,null);
		}
		
		return sealData;
	}
	
	/**
	 * 创建企业的法人印章
	 * @param coporateId 企业ID
	 * @param paramPersonTemplateType 枚举，模板印章的类型.枚举值对应的效果参考《e签宝快捷签SDK接口说明-JAVA_v2.0.9》40页
	 * @param paramSealColor 枚举，模板印章的颜色
	 * @param isSave 是否入库：是否建立用户与印章的关联关系
	 */
	@Transactional(rollbackFor={Throwable.class})
	public String produceCopoLegalSeal(String coporateId, PersonTemplateType paramPersonTemplateType, SealColor paramSealColor,Boolean isSave) throws Exception{
		
		sdkInit();
		
		EsignCoporateAccountMapper eam = dao.getMapper(EsignCoporateAccountMapper.class);
		EsignCoporateAccountExample example = new EsignCoporateAccountExample();
		example.createCriteria().andCoporateIdEqualTo(coporateId).andAccountTypeEqualTo(EsignCoporateAccountConstant.ACCOUNTTYPE_LEGAL);
		List<EsignCoporateAccount> eaList = eam.selectByExample(example);
		if (CollectionUtils.isEmpty(eaList)) {
			throw new Exception("该企业还未在e签宝中注册法人账户");
		}
		String accountId = eaList.get(0).getAccountId();
		
		com.timevale.esign.sdk.tech.service.SealService sealSrv = SealServiceFactory.instance();
		AddSealResult asResult = sealSrv.addTemplateSeal(accountId, paramPersonTemplateType, paramSealColor);
		if (asResult.getErrCode() != 0) {
			throw new Exception(asResult.getMsg());
		}
		String sealData = asResult.getSealData(); // 电子印章图片的base64数据

		if(isSave){
			saveSeal(accountId, sealData, null);
		}
		
		return sealData;
	}

	/**
	 * 印章入库
	 * @param userId 查询平台个人用户的e签宝账户id时，该参数不能为空,其他参数为空
	 * @param coporateId 查询平台企业账户和企业法人账户时，该参数不能为空，userId为空
	 * @param acctType 查询平台企业账户和企业法人账户时，该参数不能为空,userId为空。使用常量EsignCoporateAccountConstant
	 * @param sealData 印章的base64数据
	 */
	@Transactional(rollbackFor={Throwable.class})
	public void saveSeal(String userId,String coporateId,int acctType, String sealData,String fileName) throws Exception {
		
		String accountId = accountService.getAccountId(userId, coporateId, acctType);
		if(StringUtils.isEmpty(accountId)){
			throw new Exception("该用户还未在e签宝中注册账户");
		}
		
		saveSeal(accountId, sealData, fileName);
	}
	
	private void saveSeal(String accountId,String sealData,String fileName) throws Exception{
		EsignAccountSealMapper easm = dao.getMapper(EsignAccountSealMapper.class);
		EsignAccountSealExample ex = new EsignAccountSealExample();
		ex.createCriteria().andAccountIdEqualTo(accountId);
		List<EsignAccountSeal> easList = easm.selectByExample(ex);
		
		EsignAccountSeal eas = new EsignAccountSeal();
		eas.setId(UuidUtil.get32UUID());
		eas.setAccountId(accountId);
		eas.setSealData(sealData);
		eas.setIsDefault(CollectionUtils.isEmpty(easList)?1:0);
		eas.setFileName(fileName);
		easm.insert(eas);
	}
	
	/**
	 * 获取个人印章
	 */
	public List<EsignAccountSeal> getPerSeal(String userId) throws Exception{
		EsignAccountSealMapperExtend easm = dao.getMapper(EsignAccountSealMapperExtend.class);
		return easm.getPerSeal(userId);
	}
	
	/**
	 * 获取企业印章，包括企业模板印章和企业法人印章
	 * @param coporateId 企业ID
	 * @param acctType 使用常量EsignCoporateAccountConstant
	 * @throws Exception 
	 */
	public List<EsignAccountSeal> getCopoSeal(String coporateId,int acctType) throws Exception{
		EsignAccountSealMapperExtend easm = dao.getMapper(EsignAccountSealMapperExtend.class);
		return easm.getCopoSeal(coporateId, acctType);
	}
	
	/**
	 * 更新EsignAccountSeal
	 * @param record
	 * @param example
	 * @throws Exception
	 */
	@Transactional(rollbackFor={Throwable.class})
	public void uptSeal(EsignAccountSeal record,EsignAccountSealExample example) throws Exception{
		EsignAccountSealMapper easm = dao.getMapper(EsignAccountSealMapper.class);
		easm.updateByExampleSelective(record, example);
	}
	
	/**
	 * 默认印章切换
	 */
	@Transactional(rollbackFor={Throwable.class})
	public void switchDefaultSeal(String sealId) throws Exception{
		EsignAccountSealMapper easm = dao.getMapper(EsignAccountSealMapper.class);
		
		// 查询该印章的accountId
		EsignAccountSealExample ex1 = new EsignAccountSealExample();
		ex1.createCriteria().andIdEqualTo(sealId);
		List<EsignAccountSeal> exList = easm.selectByExample(ex1);
		String accountId = exList.get(0).getAccountId();
		
		// 将accountId的所有印章的默认字段设置为0
		EsignAccountSeal record2 = new EsignAccountSeal();
		record2.setIsDefault(0);
		EsignAccountSealExample ex2 = new EsignAccountSealExample();
		ex2.createCriteria().andAccountIdEqualTo(accountId);
		easm.updateByExampleSelective(record2, ex2);
		
		// 将sealId的印章默认字段设置为1
		EsignAccountSeal record3 = new EsignAccountSeal();
		record3.setIsDefault(1);
		easm.updateByExampleSelective(record3, ex1);
	}
}
