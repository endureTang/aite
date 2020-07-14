package com.nj.service.esign;

import org.springframework.stereotype.Service;

import com.nj.model.esign.bean.SignDetail;
import com.timevale.esign.sdk.tech.bean.result.GetSignDetailResult;
import com.timevale.esign.sdk.tech.service.SignService;
import com.timevale.esign.sdk.tech.service.factory.SignServiceFactory;

/**
 * 签署查询服务
 * @author wkh
 *
 */
@Service("signQueryService")
public class SignQueryService extends BaseEsignService{

	/**
	 * 得到签署详情信息
	 * @param singRecordId 签署时返回的签署记录id
	 */
	public SignDetail getSignDetail(String singRecordId) throws Exception{
		
		sdkInit();
		
		SignService sSrv = SignServiceFactory.instance();
		GetSignDetailResult result = sSrv.getSignDetail(singRecordId);
		if(result.getErrCode() != 0){
			throw new Exception(result.getMsg());
		}
		
		SignDetail sd = new SignDetail();
		sd.setComment(result.getComment());
		sd.setSignature(result.getSignature());
		sd.setSignCert(result.getSignCert());
		sd.setSigners(result.getSigners());
		
		return sd;
	}
}
