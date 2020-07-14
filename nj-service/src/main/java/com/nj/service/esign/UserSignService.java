package com.nj.service.esign;

import java.util.Date;
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
import com.nj.dao.esign.mapper.base.EsignSignRecordMapper;
import com.nj.model.esign.base.EsignAccountSeal;
import com.nj.model.esign.base.EsignAccountSealExample;
import com.nj.model.esign.base.EsignCoporateAccount;
import com.nj.model.esign.base.EsignCoporateAccountExample;
import com.nj.model.esign.base.EsignPersonAccount;
import com.nj.model.esign.base.EsignPersonAccountExample;
import com.nj.model.esign.base.EsignSignRecord;
import com.nj.model.esign.constants.EsignCoporateAccountConstant;
import com.timevale.esign.sdk.tech.bean.PosBean;
import com.timevale.esign.sdk.tech.bean.SignPDFFileBean;
import com.timevale.esign.sdk.tech.bean.SignPDFStreamBean;
import com.timevale.esign.sdk.tech.bean.result.FileDigestSignResult;
import com.timevale.esign.sdk.tech.bean.result.Result;
import com.timevale.esign.sdk.tech.impl.constants.SignType;
import com.timevale.esign.sdk.tech.service.EsignsdkService;
import com.timevale.esign.sdk.tech.service.SelfSignService;
import com.timevale.esign.sdk.tech.service.factory.EsignsdkServiceFactory;
import com.timevale.esign.sdk.tech.service.factory.SelfSignServiceFactory;
import com.timevale.esign.sdk.tech.service.factory.UserSignServiceFactory;
import com.timevale.tech.sdk.bean.ProjectConfig;

/**
 * 用户签署服务
 * 
 * @author wkh
 *
 */
@Service("userSignService")
public class UserSignService extends BaseEsignService {

	@Resource(name = "BaseDao")
	private BaseDao dao;

	/**
	 * 平台对pdf文件的签署 --- (文件方式。即参数传待签署文件在本地的路径和文件签署后要存放的路径)
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param pdfFile
	 *            pdf文件信息，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param sealId
	 *            使用哪个章签署。平台（微贷平台）的章是在e签宝官网上创建，可以有多个，其中一个是默认章。若使用默认章，该参数传0，
	 *            若使用其他章，需问e签宝人员提供其他章的id。 传参时使用PlatformSeal枚举。
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void platformPdfSign_file(String orderNo,String fileCate, SignPDFFileBean pdfFile, PosBean signPos, int sealId,
			SignType signType) throws Exception {

		sdkInit();

		SelfSignService selfSignSrv = SelfSignServiceFactory.instance();
		FileDigestSignResult result = selfSignSrv.localSignPdf(pdfFile, signPos, sealId, signType);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		saveEsignSignRecord(orderNo, "平台", fileCate, result.getSignServiceId());
	}

	/**
	 * 平台对pdf文件的签署 --- (文件流方式。即参数传二进制流，e签宝返回二进制流。需手动保存返回流文件)
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param pdfStream
	 *            待签署pdf文档信息，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param sealId
	 *            使用哪个章签署。平台（微贷平台）的章是在e签宝官网上创建，可以有多个，其中一个是默认章。若使用默认章，该参数传0，
	 *            若使用其他章，需问e签宝人员提供其他章的id。传参时使用PlatformSeal枚举。
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @return byte[] 签署后的pdf文件二进制
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public byte[] platformPdfSign_fileStream(String orderNo,String fileCate, SignPDFStreamBean pdfStream, PosBean signPos, int sealId,
			SignType signType) throws Exception {

		sdkInit();

		SelfSignService selfSignSrv = SelfSignServiceFactory.instance();
		FileDigestSignResult result = selfSignSrv.localSignPdf(pdfStream, signPos, sealId, signType);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		byte[] signedStream = result.getStream();
		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, "平台", fileCate,singRecordId);

		return signedStream;
	}

	/**
	 * 平台个人用户对pdf文件的签署
	 * 應用場景---(1)传待签署文件本地文件路径和签署后文件存放在本地的路径，不采用流的方式时
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param userId
	 *            用户id
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章
	 * @param pdfFile
	 *            pdf文件信息，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void userPdfSign_file(String orderNo, String userId,String fileCate, String sealData, SignPDFFileBean pdfFile,
			PosBean signPos, SignType signType) throws Exception {

		sdkInit();

		String accountId = getAccountIdByUserId(userId);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSignPDF(accountId, sealData, pdfFile, signPos, signType);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId, fileCate, singRecordId);
	}

	/**
	 * 平台个人用户对pdf文件的签署 --- 平台指微贷平台。平台用户分微贷平台的用户，即手机端的个人和企业用户。
	 * 應用場景---(1)传待签署文件本地文件路径和签署后文件存放在本地的路径，不采用流的方式时
	 * (2)做短信验证，且短信是发送到用户在e签宝中注册时填写的电话号码上,而不是任意指定号码时
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param userId
	 *            用户id
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章。
	 * @param pdfFile
	 *            pdf文件信息，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param verificationCode
	 *            验证码
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void userPdfSign_file_shortMessage(String orderNo, String userId, String fileCate,String sealData, SignPDFFileBean pdfFile,
			PosBean signPos, SignType signType, String verificationCode) throws Exception {

		sdkInit();

		String accountId = getAccountIdByUserId(userId);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSafeSignPDF(accountId, sealData, pdfFile, signPos, signType,
				verificationCode);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId, fileCate, singRecordId);
	}

	/**
	 * 平台个人用户对pdf文件的签署 --- 平台指微贷平台。平台用户指微贷平台的用户，即手机端的个人和企业用户。
	 * 应用场景----(1)传待签署文件本地文件路径和签署后文件存放在本地的路径，不采用流的方式时 (2)做短信验证，且短信是发送到任意指定的电话号码上
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param userId
	 *            用户id
	 * @param sealData
	 *            印章数据,印章图片的base64值。传入null时取默认印章，有值时为指定印章。
	 * @param pdfFile
	 *            pdf文件信息，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param mobile
	 *            接收短信的电话号码
	 * @param verificationCode
	 *            验证码
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void userPdfSign_file_shortMessageSpecifiedNumber(String orderNo, String userId, String fileCate,String sealData,
			SignPDFFileBean pdfFile, PosBean signPos, SignType signType, String mobile, String verificationCode)
			throws Exception {

		sdkInit();

		String accountId = getAccountIdByUserId(userId);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSafeSignPDF3rd(accountId, sealData, pdfFile, signPos, signType, mobile,
				verificationCode);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId, fileCate,singRecordId);
	}

	/**
	 * 平台个人用户对pdf文件的签署
	 * 應用場景---(1)传二进制流，e签宝返回二进制流。需手动保存返回流文件
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param userId
	 *            用户id
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章
	 * @param pdfStream
	 *            pdf文件流对象，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void userPdfSign_stream(String orderNo, String userId, String fileCate,String sealData, SignPDFStreamBean pdfStream,
			PosBean signPos, SignType signType) throws Exception {

		sdkInit();

		String accountId = getAccountIdByUserId(userId);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSignPDF(accountId, sealData, pdfStream, signPos, signType);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId,fileCate, singRecordId);
	}
	
	/**
	 * 平台个人用户对pdf文件的签署 --- 平台指微贷平台。平台用户指微贷平台的用户，即手机端的个人和企业用户。
	 * 應用場景---(1)传二进制流，e签宝返回二进制流。需手动保存返回流文件
	 * (2)做短信验证，且短信是发送到用户在e签宝中注册时填写的电话号码上,而不是任意指定号码时
	 * 
	 * 特别注意：此接口要求企业注册时，必须要传入电话号码，否则报错
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param userId
	 *            用户id
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章。
	 * @param pdfStream
	 *            pdf文件流对象，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param verificationCode
	 *            验证码
	 * @return byte[] 签署后的pdf文件的二进制流
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public byte[] userPdfSign_stream_shortMessage(String orderNo, String userId,String fileCate, String sealData,
			SignPDFStreamBean pdfStream, PosBean signPos, SignType signType, String verificationCode) throws Exception {

		sdkInit();

		String accountId = getAccountIdByUserId(userId);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSafeSignPDF(accountId, sealData, pdfStream, signPos, signType,
				verificationCode);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId,fileCate, singRecordId);

		return result.getStream();
	}

	/**
	 * 平台个人用户对pdf文件的签署 --- 平台指微贷平台。平台用户指微贷平台的用户，即手机端的个人和企业用户。
	 * 應用場景---(1)传二进制流，e签宝返回二进制流。需手动保存返回流文件 (2)做短信验证，且短信是发送到任意指定的电话号码上
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param userId
	 *            用户id
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章。
	 * @param pdfStream
	 *            pdf文件流对象，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param mobile
	 *            接收短信的电话号码
	 * @param verificationCode
	 *            验证码
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void userPdfSign_Stream_shortMessageSpecifiedNumber(String orderNo, String userId, String fileCate,String sealData,
			SignPDFStreamBean pdfStream, PosBean signPos, SignType signType, String mobile, String verificationCode)
			throws Exception {

		sdkInit();

		String accountId = getAccountIdByUserId(userId);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSafeSignPDF3rd(accountId, sealData, pdfStream, signPos, signType,
				mobile, verificationCode);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId, fileCate,singRecordId);
	}

	/**
	 * 企业用户对pdf文件的签署
	 * 應用場景---(1)传待签署文件本地文件路径和签署后文件存放在本地的路径，不采用流的方式时
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param coporateId
	 *            企业id
	 * @param acctType
	 *            账户类型，使用EsignCoporateAccountConstant常量
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章
	 * @param pdfFile
	 *            pdf文件信息，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void coporatePdfSign_file(String orderNo, String coporateId, String fileCate,int acctType, String sealData,
			SignPDFFileBean pdfFile, PosBean signPos, SignType signType) throws Exception {

		sdkInit();

		String accountId = getAccountIdByCoporateId(coporateId, acctType);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSignPDF(accountId, sealData, pdfFile, signPos, signType);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId, fileCate,singRecordId);
	}
	
	/**
	 * 平台企业用户对pdf文件的签署 --- 平台指微贷平台。平台用户分微贷平台的用户，即手机端的个人和企业用户。
	 * 應用場景---(1)传待签署文件本地文件路径和签署后文件存放在本地的路径，不采用流的方式时
	 * (2)做短信验证，且短信是发送到用户在e签宝中注册时填写的电话号码上,而不是任意指定号码时
	 * 
	 * 特别注意：此接口要求企业注册时，必须要传入电话号码，否则报错
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param coporateId
	 *            企业id
	 * @param acctType
	 *            账户类型，使用EsignCoporateAccountConstant常量
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章。
	 * @param pdfFile
	 *            pdf文件信息，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param verificationCode
	 *            验证码
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void coporatePdfSign_file_shortMessage(String orderNo, String coporateId, String fileCate,int acctType, String sealData,
			SignPDFFileBean pdfFile, PosBean signPos, SignType signType, String verificationCode) throws Exception {

		sdkInit();

		String accountId = getAccountIdByCoporateId(coporateId, acctType);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSafeSignPDF(accountId, sealData, pdfFile, signPos, signType,
				verificationCode);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId, fileCate,singRecordId);
	}

	/**
	 * 平台企业用户对pdf文件的签署 --- 平台指微贷平台。平台用户指微贷平台的用户，即手机端的个人和企业用户。
	 * 应用场景----(1)传待签署文件本地文件路径和签署后文件存放在本地的路径，不采用流的方式时 (2)做短信验证，且短信是发送到任意指定的电话号码上
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param coporateId
	 *            企业id
	 * @param acctType
	 *            账户类型，使用EsignCoporateAccountConstant常量
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章。
	 * @param pdfFile
	 *            pdf文件信息，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param mobile
	 *            接收短信的电话号码
	 * @param verificationCode
	 *            验证码
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void coporatePdfSign_file_shortMessageSpecifiedNumber(String orderNo, String coporateId,String fileCate, int acctType,
			String sealData, SignPDFFileBean pdfFile, PosBean signPos, SignType signType, String mobile,
			String verificationCode) throws Exception {

		sdkInit();

		String accountId = getAccountIdByCoporateId(coporateId, acctType);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSafeSignPDF3rd(accountId, sealData, pdfFile, signPos, signType, mobile,
				verificationCode);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId,fileCate, singRecordId);
	}

	/**
	 * 企业用户对pdf文件的签署
	 * 應用場景---(1)传二进制流，e签宝返回二进制流。需手动保存返回流文件
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param coporateId
	 *            企业id
	 * @param acctType
	 *            账户类型，使用EsignCoporateAccountConstant常量
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章
	 * @param pdfStream
	 *            pdf文件流对象，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void coporatePdfSign_stream(String orderNo, String coporateId,String fileCate, int acctType, String sealData, SignPDFStreamBean pdfStream,
			PosBean signPos, SignType signType) throws Exception {

		sdkInit();

		String accountId = getAccountIdByCoporateId(coporateId, acctType);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSignPDF(accountId, sealData, pdfStream, signPos, signType);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId,fileCate, singRecordId);
	}
	
	/**
	 * 平台企业用户对pdf文件的签署 --- 平台指微贷平台。平台用户指微贷平台的用户，即手机端的个人和企业用户。
	 * 應用場景---(1)传二进制流，e签宝返回二进制流。需手动保存返回流文件
	 * (2)做短信验证，且短信是发送到用户在e签宝中注册时填写的电话号码上,而不是任意指定号码时
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param coporateId
	 *            企业id
	 * @param acctType
	 *            账户类型，使用EsignCoporateAccountConstant常量
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章。
	 * @param pdfStream
	 *            pdf文件流对象，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param verificationCode
	 *            验证码
	 * @return byte[] 签署后的pdf文件的二进制流
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public byte[] coporatePdfSign_stream_shortMessage(String orderNo, String coporateId,String fileCate, int acctType, String sealData,
			SignPDFStreamBean pdfStream, PosBean signPos, SignType signType, String verificationCode) throws Exception {

		sdkInit();

		String accountId = getAccountIdByCoporateId(coporateId, acctType);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSafeSignPDF(accountId, sealData, pdfStream, signPos, signType,
				verificationCode);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId, fileCate,singRecordId);

		return result.getStream();
	}

	/**
	 * 平台企业用户对pdf文件的签署 --- 平台指微贷平台。平台用户指微贷平台的用户，即手机端的个人和企业用户。
	 * 應用場景---(1)传二进制流，e签宝返回二进制流。需手动保存返回流文件 (2)做短信验证，且短信是发送到任意指定的电话号码上
	 * 
	 * @param orderNo
	 *            订单编号
	 * @param coporateId
	 *            企业id
	 * @param acctType
	 *            账户类型，使用EsignCoporateAccountConstant常量
	 * @param sealData
	 *            印章数据。传入null时取默认印章，有值时为指定印章。
	 * @param pdfStream
	 *            pdf文件流对象，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signPos
	 *            平台签章在pdf文档上的位置，对象说明参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param signType
	 *            签署类型。 是枚举类，枚举值参考文档《e签宝快捷签SDK接口说明-JAVA_v2.0.9》
	 * @param mobile
	 *            接收短信的电话号码
	 * @param verificationCode
	 *            验证码
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	public void coporatePdfSign_Stream_shortMessageSpecifiedNumber(String orderNo, String coporateId,String fileCate, int acctType,
			String sealData, SignPDFStreamBean pdfStream, PosBean signPos, SignType signType, String mobile,
			String verificationCode) throws Exception {

		sdkInit();

		String accountId = getAccountIdByCoporateId(coporateId, acctType);
		if (StringUtils.isEmpty(sealData)) {
			sealData = getDefaultSealData(accountId);
			if (StringUtils.isEmpty(sealData)) {
				throw new Exception("该用户还没有创建印章");
			}
		}

		com.timevale.esign.sdk.tech.service.UserSignService usSrv = UserSignServiceFactory.instance();
		FileDigestSignResult result = usSrv.localSafeSignPDF3rd(accountId, sealData, pdfStream, signPos, signType,
				mobile, verificationCode);
		if (result.getErrCode() != 0) {
			throw new Exception(result.getMsg());
		}

		String singRecordId = result.getSignServiceId();
		saveEsignSignRecord(orderNo, accountId, fileCate,singRecordId);
	}
	//
	// public String platformTextSign(String srcData) throws Exception{
	//
	// SignService sSrv = SignServiceFactory.instance();
	// SignDataResult result = sSrv.localTextSign(srcData);
	// if(result.getErrCode() != 0){
	// throw new Exception(result.getMsg());
	// }
	//
	// String signResult = result.getSignResult();
	// String signRecordId = result.getSignId();
	//
	// return signResult;
	// }

	/**
	 * 保存签署记录
	 * 
	 * @param orderNo
	 * @param accountId
	 * @param singRecordId
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class })
	private void saveEsignSignRecord(String orderNo, String accountId, String fileCate, String singRecordId) throws Exception {
		EsignSignRecordMapper esrm = dao.getMapper(EsignSignRecordMapper.class);
		EsignSignRecord record = new EsignSignRecord();
		record.setId(UuidUtil.get32UUID());
		record.setOrderNo(orderNo);
		record.setAccountId(accountId);
		record.setFileCate(fileCate);
		record.setSignRecordId(singRecordId);
		record.setCreateTime(new Date());
		esrm.insert(record);
	}

	/**
	 * 通过userid获取用户在e签宝注册的账户id
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	private String getAccountIdByUserId(String userId) throws Exception {
		EsignPersonAccountMapper eam = dao.getMapper(EsignPersonAccountMapper.class);
		EsignPersonAccountExample example = new EsignPersonAccountExample();
		example.createCriteria().andUserIdEqualTo(userId);
		List<EsignPersonAccount> eaList = eam.selectByExample(example);
		if (CollectionUtils.isEmpty(eaList)) {
			throw new Exception("该用户还未在e签宝中注册账户");
		}
		String accountId = eaList.get(0).getAccountId();
		return accountId;
	}

	/**
	 * 通过coporateId、acctType获取企业用户在e签宝注册的账户id
	 */
	private String getAccountIdByCoporateId(String coporateId, int acctType) throws Exception {
		EsignCoporateAccountMapper ecm = dao.getMapper(EsignCoporateAccountMapper.class);
		EsignCoporateAccountExample example = new EsignCoporateAccountExample();
		example.createCriteria().andCoporateIdEqualTo(coporateId).andAccountTypeEqualTo(acctType);
		List<EsignCoporateAccount> ecaList = ecm.selectByExample(example);
		if (CollectionUtils.isEmpty(ecaList)) {
			throw new Exception("该企业还未在e签宝中注册" + EsignCoporateAccountConstant.getAcctTypeStr(acctType) + "类型的账户");
		}
		String accountId = ecaList.get(0).getAccountId();
		return accountId;
	}

	/**
	 * 通过accountId获取默认印章数据
	 * 
	 * @param accountId
	 * @throws Exception
	 */
	private String getDefaultSealData(String accountId) throws Exception {
		EsignAccountSealMapper easm = dao.getMapper(EsignAccountSealMapper.class);
		EsignAccountSealExample ex = new EsignAccountSealExample();
		com.nj.model.esign.base.EsignAccountSealExample.Criteria c = ex.createCriteria();
		c.andAccountIdEqualTo(accountId);
		c.andIsDefaultEqualTo(1);
		List<EsignAccountSeal> easList = easm.selectByExampleWithBLOBs(ex);
		if (CollectionUtils.isEmpty(easList)) {
			return null;
		} else {
			return easList.get(0).getSealData();
		}
	}
	
	public static void main(String[] args) {

		// 生产环境参数
		ProjectConfig pcCfg = new ProjectConfig();
		pcCfg.setProjectId("1111564752");
		pcCfg.setProjectSecret("19a793b6cd152eef7ca117f66eb94ce1");
		pcCfg.setItsmApiUrl("http://itsm.tsign.cn/tgmonitor/rest/app!getAPIInfo2");
		
		EsignsdkService sdkService = EsignsdkServiceFactory.instance();
		Result rs = sdkService.init(pcCfg, null, null);
		
		SignPDFFileBean pdfFile = new SignPDFFileBean();
		String srcFilePath = "d:\\a.pdf";
		pdfFile.setSrcPdfFile(srcFilePath);
		pdfFile.setDstPdfFile(srcFilePath);

		PosBean signPos = new PosBean();
		signPos.setPosType(1); // 定位类型，0-坐标定位，1-关键字定位，默认0
		signPos.setKey("甲方签署"); // 关键字 TODO 做成产品或批复订单里配置
//		signPos.setWidth(159); // 为空，则以宽度159，不为空，则以传入为准 TODO 做成产品或批复订单里配置
		signPos.setPosX(160);
		signPos.setPosPage("1");
		
		SelfSignService selfSignSrv = SelfSignServiceFactory.instance();
		FileDigestSignResult result = selfSignSrv.localSignPdf(pdfFile, signPos, 0, SignType.Key);
	}
}
