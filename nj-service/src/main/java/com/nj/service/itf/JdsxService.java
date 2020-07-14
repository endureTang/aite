package com.nj.service.itf;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;

import com.nj.core.base.entity.ResponseDto;
import com.nj.mongoModel.BrIdTwoData;
import com.nj.service.remoteing.BrDataListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.common.Constants;
import com.nj.core.base.util.HttpUtil;
import com.nj.core.base.util.SignCommonUtil;
import com.nj.service.common.AppConfigService;

@Service("jdsxService")
public class JdsxService {

    private static Logger logger = LoggerFactory.getLogger(JdsxService.class);

    @Resource(name = "appConfigService")
    private AppConfigService appConfigService;
    @Resource
    private BrDataListService brDataListService;

    public boolean SMRZ(String name, String certNo, String userId, String companyId) {
//		String mchId=Constants.JDSX.mch_id;
//		String appId = Constants.JDSX.app_id;
//		String appKey = Constants.JDSX.app_key;
//		SortedMap<String, Object> packageParams = new TreeMap<String, Object>();
//		packageParams.put("mch_id", mchId);//商户号
//		packageParams.put("app_id", appId);//应用号
//		packageParams.put("nonce_str",SignCommonUtil.CreateNoncestr(32));//32位随机字符串
//		packageParams.put("name", name);
//		packageParams.put("cert_no", certNo);
//		String sign=SignCommonUtil.createSign("UTF-8",packageParams,appKey);//签名
//		packageParams.put("sign", sign);
//		try{
//			String msg= HttpUtil.doPost(Constants.JDSX.smrz_url, packageParams);
//			logger.info("smrz msg:"+msg);
//			JSONObject result = handleResult(msg);
//			return result.getInteger("verify")==0 ? true : false;
//		}catch(Exception e){
//			logger.info("smrz fail",e);
//			return false;
//		}

        logger.debug("百融二要素feign调用，userId：" + userId);
        // 百融二要素
        ResponseDto<BrIdTwoData> brIdTwoResponseDto = brDataListService.findIdTowData(name, certNo, userId, "", companyId);
        if (null != brIdTwoResponseDto && brIdTwoResponseDto.getReturnCode() == 0) {
            return "1".equals(brIdTwoResponseDto.getResult().getRESULT());
        }
        return false;
    }

    private JSONObject handleResult(String msg) {
        JSONObject result = JSONObject.parseObject(msg);
        if (!Constants.JDSX.SUCCESS.equals(result.getString("error_code"))) {
            return null;
        }

        return result.getJSONObject("result");
    }

	/*public static void main(String[] args){
        JdsxService s= new JdsxService();
		s.SMRZ("张海", "421022198704260630");
	}*/
}
