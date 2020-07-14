package com.nj.core.base.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.nj.core.base.enums.ESysDictType;

@Configuration
@Component
public class Constants {

	public final static String CHANNEL_CODE = "nj_server";
	public final static String CHANNEL_CKEY = "ed7d597ef32c0319fec0536eb017c314";
	
	public final static Integer[] ManualCheckProcess= {5,6,7,61,62,8,10,11,21,22,23,31,32,33,38,34,35,36,37};

	public class FACEID {
		// 附件表，附件类型为Faceid
		public final static int FILE_FACEID = 9000;
		// 附件表，附件类型为faceid，身份证头像照片
		public final static int FILE_HEAD = FILE_FACEID + 1;
		// 附件表，附件类型为faceid,身份证国徽照片
		public final static int FILE_EMBLEM = FILE_FACEID + 2;
		// 附件表，附件类型为faceid,活体识别最好的照片image_best
		public final static int FILE_IMAGE_BEST = FILE_FACEID + 3;
		// 附件表，附件类型为faceid,活体识别中用于假体识别的图片image_env
		public final static int FILE_IMAGE_ENV = FILE_FACEID + 4;
		// 附件表，附件类型为faceid，活体识别中，image1
		public final static int FILE_IMAGE1 = FILE_FACEID + 5;
		// 附件表，附件类型为faceid,活体识别中，image2
		public final static int FILE_IMAGE2 = FILE_FACEID + 6;
		
		
	}
	
	public class FILE_TYPE{
		// 附件表，附件类型为身份相关
		public final static int FILE_CERT = 9000;
		//附件表，附件类型为第三方订单身份证正面照
		public final static int FILE_CERT_FRONT_OUT = FILE_CERT+1;
		//附件表，附件类型为第三方订单身份证背面照
		public final static int FILE_CERT_BACK_OUT = FILE_CERT+2;
		//附件表，附件类型为手持身份证照片
		public final static int FILE_CERT_HAND_OUT = FILE_CERT+7;
		//附件表，附件类型为活体识别照片
		public final static int FILE_CERT_LIVING_OUT = FILE_CERT+4;
		//驾驶证正面照片
		public final static int JSZ=8100;
		public final static int JSZ_FRONT =JSZ+1;
		public final static int JSZ_BACK=JSZ+2;
		public final static int JSZ_XSZ=JSZ+3;
		//房屋图片类型
		public final static int HOUSE=8200;
		public final static int HOUSE_FCZ_FRONT=HOUSE+1;
		public final static int HOUSE_FCZ_BACK=HOUSE+2;
		public final static int HOUSE_OTHER = HOUSE+99;
		//工作信息图片
		public final static int WORK=8300;
		public final static int WORK_OTHER =WORK+99;
		//活体图片
		public final static int HUOTI = 9100;
		public final static int HUOTI_OTHER = HUOTI+99;
		public final static int COMMON_FILE=2001;
		//承诺函
		public final static int AssureFile=7100;
		// 合同
		public final static int ContractFile=6100;
		
	}

	/**
	 * 
	 *@see ESysDictType
	 *
	 */
	@Deprecated
	public class SYS_DICT {
		// 数据字典中 type字段标识 产品类型
		public final static String TYPE_PRODUCT = "CPFBSXFL";
		// 数据字典中 type字段标识 亲戚朋友关系
		public final static String TYPE_RELATIVE = "QPGXLX";
		// 数据字典中type字段标识 婚姻状态
		public final static String TYPE_MARRIAGE = "HYZT";

		public final static String TYPE_WORK = "GZZT";

		public final static String TYPE_MAX_EDU = "ZGXL";

		public final static String TYPE_PERIOD = "CPDKKXQX";

		public final static String TYPE_REPAY = "REPAYTYPE";

		public final static String TYPE_RECU_TYPE = "RECUTYPE";

		/** 产品创建-交易配置：平台手续费 */
		public final static String TYPE_CPPTSXF = "CPPTSXF";
		/** 产品创建-交易配置：还款方设置 */
		public final static String TYPE_CPJYHKJS = "CPJYHKJS";
		/** 产品创建-交易配置：收款方设置 */
		public final static String TYPE_CPJYSKJS = "CPJYSKJS";
		/** 产品创建-交易配置：还款方式 */
		public final static String TYPE_CPHKFS = "CPHKFS";

		/** 产品创建-业务受理配置：资料设置 */
		public final static String TYPE_CPZLSZ = "CPZLSZ";
		/** 产品创建-业务受理配置：征信设置 */
		public final static String TYPE_CPZXSZ = "CPZXSZ";
		/** 产品创建-业务受理配置：递增增幅 */
		public final static String TYPE_CPDKDZZF = "CPDKDZZF";
		/** 产品创建-业务受理配置：可选期限 */
		public final static String TYPE_CPDKKXQX = "CPDKKXQX";
		/** 产品创建-业务受理配置：实名认证 */
		public final static String TYPE_CPSMRZ = "CPSMRZ";

		/** 产品创建-申请渠道配置：用途配置 */
		public final static String TYPE_CPYTPZ = "CPYTPZ";

		/** 产品创建-交易配置：交易模式 */
		public final static String TYPE_CPJYMS = "CPJYMS";
		
		/** 产品创建-交易配置：交易流程配置条件 */
		public final static String TYPE_CPLCTJ = "CPLCTJ";
		
		

		/** 产品创建-发布设置：申请适用区域 */
		public final static String TYPE_SYSCITY = "SYSCITY";
		/** 产品创建-发布设置：申请用户范围设置 */
		public final static String TYPE_CPFBSQFW = "CPFBSQFW";
		/** 产品创建-发布设置：上线分类设置 */
		public final static String TYPE_CPFBSXFL = "CPFBSXFL";

		/** 贷后管理-列表管理：还款状态 */
		public final static String TYPE_DHHKZT = "DHHKZT";
		/** 贷后管理-列表管理：是否逾期 */
		public final static String TYPE_DHYQZT = "DHYQZT";
		/** 贷后管理-列表管理：还款期限 */
		public final static String TYPE_DHHKQX = "DHHKQX";
		/**车辆型号**/
		public final static String TYPE_CLLX = "CLLX";
		/**车辆价格区间类型*/
		public final static String TYPE_CLJG ="CLJG";
		/**车辆年龄区间*/
		public final static String TYPE_CLNL ="CLNL";
		/*产品标签*/
		public final static String TYPE_CPBQ="CPBQ";
		/*数据加密密码*/
		public final static String TYPE_JMKEY="JMKEY";
	}
	@Component
	public static class TFCF {
		
		
		// 天府财富测试或者正式标志
		public static boolean PLATFORM_FLAG = true; // false:测试环境;true:正式环境
		// 天府财富测试url

		// public final static String
		// TEST_URL="http://10.248.140.244:8080/p2pfront/i";
		public final static String TEST_URL = "http://121.40.28.132:9000/p2pfront/i";
		// public final static String
		// TEST_URL="http://10.248.140.243:9000/p2pfront/i";

		// 天府财富正式url
		public final static String URL = "http://server.52tfd.com:8091/TFCF_BackPlatform/itfandroid";
		// 天府财富测试AES
		public final static String TEST_AES = "e080de81bcef11e6";
		public final static String TEST_TFCF_AES = "Tkdc6uIC424Z0571";
		// 天府财富正式URL
		public final static String AES = "bae51da7342311e5";
		
		public final static String UPDATE_KEY = "Mr43165J4yzu2BC6";
		public final static String UPDATE_KEY_TEST="Tkdc6uIC424Z0571";
		
		// 天府财富验证码绑定银行卡资源路径
		public final static String AUTH_USER_CARD = "/xyyh/AuthUserCard";
		public final static String BIND_USER_CARD = "/xyyh/ValidSmsCode";
		// 天府财富 获取userId路径
		public final static String GET_TFCFUSERID = "/userOperate/registerByMobile";
		// 天府财富 获取企业用户userId路径
		public final static String GET_TFCF_COMPANY_USERID = "/userOperate/userCompanyMessage";
		// 天府财富获取页面权限
		public final static String GET_TFCF_AUTH = "/userOperate/auth";
		// 天府财富获取四要素
		public final static String GET_TFCF_FOUR="/userOperate/fourElementInfo";
		// 天府财富合同签章
		public final static String CONTRACT_ESIGN= "/userOperate/contractEsign";
		// 天府财富合同签章（无签名）
		public final static String CONTRACT_ESIGN_NO_SEAL= "/userOperate/contractEsignNoSeal";
		// 天府财富合同地址
		public final static String GET_CONTRACT_URL = "/userOperate/getContract";
		// 天府财富账户是否激活(开户)
		public final static String GET_ACCOUNT_INFO = "/userOperate/accountInfo" ;	
		// 天府财富获得用户激活二维码code
		public final static String GET_QR_CODE = "/userOperate/getQrcode";
		// 天府财富账户是否需要贷款提醒
		public final static String REMIND_USER_SIGN = "/protocolSign/remindUserSign" ;	
		// 天赋财富根据userId获取accountId
		public final static String GET_USER_ACCOUNT_BY_USERID = "/userOperate/getAccountByUserId" ;	
		// 天府财富充值 resource uri
		public final static String RECHARGE = "/xyyh/easyPayCash";
		// 天府财富提现获取验证码
		public final static String PRE_CASHOUT = "/xyyh/applyRandCodeForCashOut";
		// 天府财富提现
		public final static String CASHOUT = "/xyyh/cashOut";
		// 天府财富获取个人账户信息
		public final static String GET_USER_ACCOUNT_INFO = "/uac/getMyUserAccount";
		// 天府财富获取个人用户信息
		public final static String GET_USER_INFO = "/xqb/getUserInfoNew";
		// 天府财富下载合同
		public final static String GET_CONTRACT = "/common/util/donwloadconsumercontract";
		// 天府财富获取银行信息
		public final static String GET_BANK_INFO = "/bic/getBankInfo";
		// 天府财富获取银行信息新街口
		public final static String GET_BANK_INFO_NEW="/bic/getBankInfoForConsumer";
		// 天府财富注册用户
		public final static String REGISTER_USER = "/member/reg";
		// 获取天府财富借款用户信息
		public final static String GET_USER_OPERATION_INFO = "/userOperate/getUserOperateInfo";
		// 获取天府财富借款列表
		public final static String GET_REPAY_LIST = "/UserOperate/getBorrowRepayList";
		public final static String GET_REPAY_LIST_NEW = "/UserOperate/getBorrowRepayListNew";

		// 天府财富生成合同 resource uri
		public final static String CONTRACT_GENERATE = "/userOperate/genContract";

		public final static String SEND_SMS_VALIDATE_CODE = "/member/sendSmsValidateCode";

		public final static String ORDER_CONFIRM = "/UserOperate/newSaveUserProject";

		// 还款详情
		public final static String GET_REPAY_DETAIL = "/UserOperate/getBorrowRepayDetail";
		//还款详情
//		public final static String GET_REPAY_DETAIL_NEW = "/UserOperate/getBorrowRepayDetailNew";
		public final static String GET_REPAY_DETAIL_NEW = "/userOperate/repayPlan";
		// 逾期列表
		public final static String GET_OVERDUE_RECORDS = "/userOperate/overdueRecords";
		// 代扣deductMoney
		public final static String GET_DEDUCT_MONEY = "/userOperate/repay";
		// 代扣升级版
		public final static String GET_DEDUCT_MONEY_REPAY = "/userOperate/deductRepay";
		
		// 业务查询结果
		public final static String GET_BUSSINESS_STATUS = "/userOperate/queryBizzOrder";
		
		//还款详情
		public final static String GET_REPAY_DETAIL_NEW_NO_PROJ_ID = "/UserOperate/getBorrowRepayDetailNew";
		// 消息列表
		public final static String GET_SMS_LIST = "/mic/getSmsList";
		// 资金端数据统计，累计收益、累计投资、运行天数
		public final static String GET_SUMMARY_DATA = "/userOperate/getPlatSummary";

		// 企業豬豬獲取短信
		public final static String MEMBER_SMS = "/member/sendSmsValidateCode";
		public final static String MEMBER_REG = "/member/reg";
		public final static String MEMBER_OPEN_SMS = "/xyyh/applyRandCodeForEnterpriseOpenAccount";
		public final static String MEMBER_OPEN = "xyyh/enterpriseOpneAccount";

		// 企业绑定 
		public final static String GET_MEMBER_SMS = "/UserRepay/sendSmsValidateCode";
		public final static String VERIFY_MEMBER_SMS = "/UserRepay/checkMobileCode";
		public final static String VERIFY_MEMBER = "/userOperate/getUserByUserName";

		// 天府财贷后列表
		public final static String GET_USERLOAN_RREQUESTLIST = "/UserRepay/getUserLoanRrequestList";
		// 天府财贷后还款计划列表
		public final static String GET_BORROW_REPAYLIST = "/UserRepay/newGetBorrowRepayDetail";
		// 天府财贷后详情信息
		public final static String GET_USERLOAN_RREQUESTDETAIL = "/UserRepay/getUserLoanRrequestDetail";
		// 天府财贷后详情附件信息
		public final static String GET_ATTACHMENT_LIST = "/UserRepay/getAttachmentList";
		// 天府财贷后下载附件信息
		public final static String DONWLOAD_CONSUMER_CONTRACT = "/common/util/donwloadconsumercontract";
		// 天府财贷后还款信息信息
		public final static String GET_USERREPAY_DETAIL = "/UserRepay/getUserRepayDetail";		
		//天府财富根据订单id获取还款列表
		public final static String GE_USERREPAY_DETAIL_BY_ORDER_NO = "/UserOperate/getBorrowRepayListByReqId";
		//天府财富生成项目
//		public final static String PROJECT_GENERATE_NEW ="/UserOperate/newSaveUserProjectNoCode";
		public final static String PROJECT_GENERATE_NEW ="/userOperate/recieveAssets";
		//天府财富开户
		public final static String OPEN_ACCOUNT="/xyyh/P003";
		//天府财富解绑银行卡获取验证码
		public final static String GET_UNBINDCARD_SMS="/member/sendSmsValidateCode";
		//天府财富解绑银行卡
		public final static String UNBINDCARD="/xyyh/unbindBankCardCode";
		//天府财富获取弹窗消息
		public static String GET_POPUPWINDOWS ="/goldFinancial/popupInfo";
		//天府财富解绑银行卡获取短信验证码module
		public final static Integer GET_UNBINDCARD_SMS_MODULE=19;
		//天赋财富项目借款协议
		public final static String BORROW_CONTRACTS="/userOperate/borrowContracts";
		
		/**天府财富统计项目*/
		// 统计30日的回款合计
		public final static String QUERY_INCOME_TOTAL = "/report/queryIncomeTotal";
		// 查询指定时间区间每日多少项目还款
		public final static String QUERY_PROJECT_COUNT = "/report/queryProjectCount";
		// 查询指定时间区间每日所有借款用户的在贷余额
		public final static String QUERY_LEFT_CAPITAL = "/report/queryLeftCapital";
		// 查询指定时间区间每日平台交易金额
		public final static String QUERY_PLATFORM_TOTAL = "/report/queryPlatformTotal";		

		
		
		public static String createUrl(String resourceUri) {
			/*if (PLATFORM_FLAG) {
				return URL + resourceUri;
			} else {
				return TEST_URL + resourceUri;
			}*/
			return AddressConstants.JdcfUrl+resourceUri;
		}
		

		public static String getAESKey() {
			if (PLATFORM_FLAG) {
				return AES;
			} else {
				return TEST_AES;
			}
		}

		/*public static String getTFCFAESKey() {
			if (PLATFORM_FLAG) {
				return TEST_TFCF_AES;
			} else {
				return TEST_TFCF_AES;
			}
		}*/
		
		public static String getTFCFUpdateAESKey(){
			if(PLATFORM_FLAG){
				return UPDATE_KEY;
			}
			else{
				return UPDATE_KEY_TEST;
			}
		}
	}
	
	public static class SNDK {
		// 天府财富测试或者正式标志
		public final static boolean PLATFORM_FLAG = true; // false:测试环境;true:正式环境
		// 天府财富测试url

		// public final static String
		// TEST_URL="http://10.248.140.244:8080/p2pfront/i";
		public final static String TEST_URL = "http://10.248.140.227:8080/jd_payment_web";
		// public final static String
		// TEST_URL="http://10.248.140.243:9000/p2pfront/i";

		// 天府财富正式url
		public final static String URL = "http://10.248.140.227:8080/jd_payment_web";
		// 天府财富测试AES
		public final static String TEST_AES = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDhZJZw/HqKTUuw8PIXECBvzuRF0ehQTq2vJzb+QUwgx9YUKft7Jjoj6elstirDP35pa/vtYwi73cdRTfa7GTYE412MHcRoP0di3x9JpgG4NSQ2eotWDN9YtftJZ6HbAjCwQsRabOZGhjKeQoF2GiP72a0Vg7QQLbBKD/yUc3BiUwIDAQAB";
		// 天府财富正式URL
		public final static String AES = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDhZJZw/HqKTUuw8PIXECBvzuRF0ehQTq2vJzb+QUwgx9YUKft7Jjoj6elstirDP35pa/vtYwi73cdRTfa7GTYE412MHcRoP0di3x9JpgG4NSQ2eotWDN9YtftJZ6HbAjCwQsRabOZGhjKeQoF2GiP72a0Vg7QQLbBKD/yUc3BiUwIDAQAB";
		
		// 天府财贷后还款信息信息
		public final static String BIND_BANK_CARD = "/pay/v1/contract/bindBankCard";	
		// 苏宁四要素扣款
		public final static String SN_NOT_CONTRACT_PAY = "/pay/v1/contract/notContractPay";	
		// 苏宁查询订单
		public final static String SN_QUERY_ORDER = "/pay/v1/contract/queryOrder";	
		
		
		// 签名key
		public final static String SIGN_KEY = "ed7d597ef32c0319fec0536eb017c314";
		
		public static String createUrl(String resourceUri) {
			if (PLATFORM_FLAG) {
				return URL + resourceUri;
			} else {
				return TEST_URL + resourceUri;
			}
		}

		public static String getAESKey() {
			if (PLATFORM_FLAG) {
				return AES;
			} else {
				return TEST_AES;
			}
		}

	}

	public interface ProductState {
		// 产品设置未完成
		int UNSUBMIT = 0;
		// 已提交-产品配置已完成
		int SUBMITTED = 1;
		// 已发布-待审核
		int PUBLISHED = 2;
		// 审核通过
		int APPROVED = 3;
		// 审核拒绝
		int DECLINE = 4;
		// 产品上线
		int ONLINE = 5;
		// 产品下线
		int OFFLINE = 6;
	}

	public interface OrderCodeConstructor {
		public final String TFCF = "0001";
	}

	/** 开发环境*/
	/*
	public interface URL {
	
		public final static String backServerHost = "http://120.77.1.119/nj-enterprise-web";
		public final String NJ_ENTERPRISE_PIC = backServerHost + "/attachment/";
		// 后台配置服务提供的http服务
		public final String NJ_ENTERPRISE_ADVERTISEMENT = backServerHost + "/static/productImage/";

		// api 服务配置 start
		public final static String NJ_API = "https://wd.52jdjf.com/";
		//API服务器广告位置
		public final static String NJ_API_ADV =NJ_API+"/adv/";
		//api 服务配置 end
		// 统一用户中心接入配置
		public final static String AUTH_CENTER_HOST = "https://user.52jdjf.com";
		public final static String AUTH_URL = AUTH_CENTER_HOST
				+ "/Account_Center/user/v1/login?target=" + backServerHost;
		// 后台服务对外接口订单统计
		public final static String TFCF_CALLBACK_URL = backServerHost + "/outApi/updateOrder";
		// 统一用户中心登出
		public final static String AUTH_CENTER_LOGOUT = AUTH_CENTER_HOST + "/channel/v1/login/out/web";
	}
*/
	
	/** 测试环境*/	
	/*
	public interface URL {
		
		// 后台服务提供的http服务
		public final static String backServerHost = "http://120.77.1.119/nj-enterprise-web/";
		public final String NJ_ENTERPRISE_PIC = backServerHost + "/attachment/";
		// 后台配置服务提供的http服务
		public final String NJ_ENTERPRISE_ADVERTISEMENT = backServerHost + "/static/productImage/";

		// api 服务配置 start-配置为域名
		public final static String NJ_API = "http://120.77.1.119/nj-api/";
				//API服务器广告位置
		public final static String NJ_API_ADV =NJ_API+"/adv/";
		//api 服务配置 end
		
	    //统一用户中心接入配置
	    public final static String AUTH_URL = "https://user.52jdjf.com/Account_Center/user/v1/login?target=http://120.77.1.119";
	    
	    //后台服务对外接口订单统计
	    public final static String TFCF_CALLBACK_URL = backServerHost + "/outApi/updateOrder";
	}
*/
	/** prod env */	
	
	public interface URL {
		
		// 后台服务提供的http服务
		public final static String backServerHost = "http://admin.52jdjf.com/";
	   // public final static String backServerHost = "http://39.108.195.181/nj-enterprise-web/"; /*测试环境*/
		public final String NJ_ENTERPRISE_PIC = backServerHost + "/attachment/";
		// 后台配置服务提供的http服务
		public final String NJ_ENTERPRISE_ADVERTISEMENT = backServerHost + "/static/productImage/";

		// api 服务配置 start
		public final static String NJ_API = "https://wd.52jdjf.com/";/*正式环境*/
		//public final static String NJ_API = "https://39.108.195.181/nj-api/";/*测试环境*/
		//API服务器广告位置
		public final static String NJ_API_ADV =NJ_API+"/adv/";
		//api 服务配置 end
		// 统一用户中心接入配置
		public final static String AUTH_CENTER_HOST = "https://user.52jdjf.com";
		public final static String AUTH_URL = AUTH_CENTER_HOST
				+ "/user/v1/login?target=" + backServerHost;
		// 后台服务对外接口订单回调函数
		public final static String TFCF_CALLBACK_URL = /*backServerHost + */"http://120.77.1.119/outApi/updateOrder"; /*正式环境*/
		//public final static String TFCF_CALLBACK_URL = /*backServerHost + */"http://39.108.195.181/nj-enterprise-web/outApi/updateOrder"; /*测试环境*/
		// 统一用户中心登出
		public final static String AUTH_CENTER_LOGOUT = AUTH_CENTER_HOST + "/channel/v1/login/out/web";
		
	}	
	
	public interface ITF {
		// 短信验证码超时时间
		public final Integer SMS_EXPIRE_TIME = 120;
		// 订单：待用户确认状态
		public final Integer USER_CONFIRM = 8;
		// 芝麻反欺诈信息有效期,
		// public final Integer ZHIMA_IVS_EXPIRE =30;
		// 订单初始状态
//		public final Integer ORDER_INIT = 0;
		// 芝麻授权分的有效期
		public final Integer ZHIMA_SCORE_EXPIRE = 30;
		//订单业务审核拒绝
		public final Integer ORDER_BUSSINESS_REJECT =4;
		//订单系统审核拒绝
		public final Integer ORDER_SYSTEM_REJECT=2;
		
		//公司
		public final String COMPANY_JDCF="1000";
		public final String COMPANY_CDJK="1001";
		//车易贷产品code
		public final String TFCYD_PRODUCT_CODE="264";
		public final String TFXCD_PRODUCT_CODE="283";
		//天府新车贷code
		//public final String TFXCD_PRODUCT_CODE="276";	
		
		//session过期时间
		public final Integer SESSION_EXPIRED=240;
		
		public final String ORDER_CONTRACT_URI="outApi/getContract";
		}
	
	public class SMSTYPE{
		public final static String APP_CONFIRM_ORDER="162684";
		public final static String ADDRESS_BOOK_AUTHORIZATION="162684";
		public final static String TEMPLATE_SMS_LOGIN="162524";
	}
	
	public class JDSX{
		public final static String SUCCESS= "0000";
		public final static String mch_id="100001";
		public final static String app_id="100001";
		public final static String app_key="ee283a2d44124555914b3a7b570cbb54";
		public final static String base_url="http://www.jdopenapi.com";
		public final static String smrz_url=base_url+"/jdrest/jdsx/v1/cert/verify";
	}
	
	public interface ORDERKEYSTATUS{
		public final int GENERATE_CONTRACT = 7;
		public final int ORDER_PRE_PROCESS = 1;
		public final int ORDER_CONFIRM=8;
		public final int ORDER_NEW = 0;
	}
	/**
	 * 银行类型1：微鼎，2：小贷
	 * @author Administrator
	 *
	 */
	public interface BANKTYPE{
		public final int WDTYPE = 1;
		public final int XDTYPE = 2;
	}
	
	
	
	
	/**
	 * 通讯录授权
	 * @author Administrator
	 */
	public class AUTHORIZATION{
		/** 是否启用 **/
		public final static boolean IS_OPEN = false;
		/** 接受短信手机号 **/
		public final static String RECEIVE_PHONE = "18116623375";
	}
	
	public class BUSINESSTYPE{
		/** 上传审批附件 **/
		public final static int APPROVAL_ANNEX = 1001;
		/** 上传合同 **/
		public final static int CONTRACT = 2001;
	}
	
	public final static String  SMS_SEQUENCE = "sequence";
	public final static String  SESSION_USER_INFO = "sessionUserInfo";
	// APP版本 1 微鼎金融  2 金鼎能贷
	public final static String  APP_SYSTEM_TYPE="appSystemType";
	/**
	 * 默认企业id，微鼎金融
	 */
	public final static String DEFAULT_COMPANY_ID = "de48a37349524bfba310582397364d3f";
	
	/**
	 * 默认企业资金端用户id，微鼎金融
	 */
	public final static String DEFAULT_COMPANY_USER_ID = "8a2872934b013540014b0135bdb40000";
	//public final static String DEFAULT_COMPANY_USER_ID = "2";
	
	/**
	 * 默认短信
	 */
	public final static String DEFAULT_SMS_CODE = "147258";
	
	
	
	/**
	 * 推送、债转消息
	 * @author Administrator
	 *
	 */
	public interface PUSHMESSAGE{
		//债转标题
		public final String transTitle = "债权转让通知";
		//债转内容
		public final String transContentPartOne = "受出借人委托，天赋财富网络借贷信息中介平台（域名为“www.52tfd.com”,以下简称“天赋财富”）通知你，根据你与出借人";
		public final String transContentPartTwo = "签署生效的《借款协议》的约定出借人已将其对你的债权，依法转让给平台其他出借人";
		//贷款标题
		public final String loanTitle = "贷款通知";
		//还款标题
		public final String repayTitle = "还款通知";
	}
	/**
	 * 银行卡渠道类型
	 * @author Administrator
	 *
	 */
	public interface BANKCHANNELTYPE{
		public final String ZHONGJIN = "zj";
		public final String WD = "wd";
	}
	
}
