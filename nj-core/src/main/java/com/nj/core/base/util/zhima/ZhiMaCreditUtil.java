package com.nj.core.base.util.zhima;


import java.util.Map;
import java.util.UUID;




import com.alibaba.fastjson.JSON;
import com.antgroup.zmxy.openplatform.api.DefaultZhimaClient;
import com.antgroup.zmxy.openplatform.api.ZhimaApiException;
import com.antgroup.zmxy.openplatform.api.internal.util.RSACoderUtil;
import com.antgroup.zmxy.openplatform.api.request.ZhimaAuthEngineSmsauthRequest;
import com.antgroup.zmxy.openplatform.api.request.ZhimaAuthInfoAuthorizeRequest;
import com.antgroup.zmxy.openplatform.api.request.ZhimaAuthInfoAuthqueryRequest;
import com.antgroup.zmxy.openplatform.api.request.ZhimaCreditIvsDetailGetRequest;
import com.antgroup.zmxy.openplatform.api.request.ZhimaCreditScoreGetRequest;
import com.antgroup.zmxy.openplatform.api.request.ZhimaCreditWatchlistiiGetRequest;
import com.antgroup.zmxy.openplatform.api.response.ZhimaAuthEngineSmsauthResponse;
import com.antgroup.zmxy.openplatform.api.response.ZhimaAuthInfoAuthqueryResponse;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditIvsDetailGetResponse;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditScoreGetResponse;
import com.antgroup.zmxy.openplatform.api.response.ZhimaCreditWatchlistiiGetResponse;
import com.nj.core.base.util.RandomUtil;

/**
 * 芝麻信用工具类
 * @author MaSong
 */
public class ZhiMaCreditUtil {
	
    /**芝麻开放平台地址*/
    private static String gatewayUrl     = "https://zmopenapi.zmxy.com.cn/openapi.do";
    /**商户应用 Id*/
    private static String appId          = "1000952";
    /**商户 RSA 私钥*/
    private static String privateKey     = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMgOzDALaWMcwQkbJ4sjopAtlEhi/g90IVHtppJpWjss7GysAwWp5HhYE6HrGKZDUy9Tl0gnRWekC63XE1OsXja7fs9dDXZLaNuOBB7R1vDjwdkGvwl6HQuVpRkek2/X7oL8fIucpyOSlw6ndF7UbNQkvzgVrnjPbIw23pvRNpb5AgMBAAECgYEAihZMskzuLU9HnrVzkgLCzqnnVB+gJaKO7TIQa7b0ZSwY9Nm2LE6cOMTyqCzSEtEdtekI3vDcYzFELnXqDTNIw140P7O8vlVNmI6aSCl1ff1ZuI/YjyzAhPVJ2OeOpJbL3Om3KgSKuZnjLkdl+CJnH7aPEJzkE9wpOSuMhMrTJlECQQDjhEjJ54dCLsdzauJ2txy4+YkTzRn7jGIEqZy6sjd6wqvt4y6tuQe6ZMuCt4mXaJzwuuBhsUw1DFZ6MKB/cN/7AkEA4Rp6ZXEfILOguQpWHj6YaZQlbZuU3yiAJ0ChB//Y1A6veplXhlf95HvUwG6xeFRFKRzogtz1L8ujBffYAnnOmwJAGE30XKVAHMDUi67aXGY5SkVV8GiTovyfJ/JajNMm/BU5uqLvRJ2khrPnzaH/r838HfdIqwb+phgYUNtK+fI76wJBAJij88tF4e2y4JGZSLxJheBR7O9eSJzqQbxcPtXFz6o8KxHfWVJn6Go+7g1vAjiuLBes2p2iZ0B5vZoWbgt/vXECQFvjlCRx2doathfh9RT0/IwQyhlf36mWqTOz9Dg8ulqvuf5ZqzXkHAZdmOnscDPyuC+vEec4kM9gZGOmme8bO9k=";
    /**芝麻 RSA 公钥*/
    private static String zhimaPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCC+SngZ2nkiVMixhBgJVwR/yx2Nr4jn0JkLgmhBTh8MGLjY23cqWhIt9cx93NAmARdiNMIFJru3USpi6ZZxgDWcx0AhCvVHNgr3WefUIf31OK1xwN5J1BaqmgiZy8vpCQgH067G6QI85aKS33vWDBM4PDHgifQkuObd+eW6UA77wIDAQAB";
    /**编码*/
    private static String charset     = "UTF-8";
    
    /**
     * 查询用户的授权信息，里面包含了OpenId（通过身份证和姓名）     * 
     * 查询授权信息
     * 正确信息{"openId":"268818665371299099797841694","success":true,"authorized":true,"body":"{\"success\":true,\"authorized\":true,\"open_id\":\"268818665371299099797841694\"}","params":{"params":"WT5beHTTiimFIHR2cfqm2TxM1FmWpKNE+Yus3EE5kEIG+G36wF7Wcb5Tx8Ib5zmQHejjJOwrHCpi648PTewLf+24K/G/P14H7t8VW/2SWgJ56fVkX70Z+Q9fuJ/+aj92W/57zAT7ZqbA3/XRvvsY4Wde13eaaFpe4PZKTN1RlCUWUsVWdmA18U+n7IZRfzb3QY+U1gcoObgv2LnCDL0SHOc73qTZrUGwB6DWZ1TkNwsqFKpzASxP86i7ABvVp7AC36USxXf+fxxmY6IuXTDfcQ4kY8wzBKnq7tu5xsnrsixFI3hJeSxp0/0hyx8wP9u9+WmUCbSQxXNoKMx72eGRJQ=="}}
     * openId:用户唯一标示，用户查询芝麻分，success:通信是否成功，authorized:授权是否成功
     * 错误信息
     * 账户不存在{"success":false,"errorMessage":"芝麻账户不存在","errorCode":"ZMCSP.zm_account_not_existed","body":"{\"success\":false,\"error_code\":\"ZMCSP.zm_account_not_existed\",\"error_message\":\"芝麻账户不存在\"}","params":{"params":"L3hChGlCLDYWsLFRzpwVnwPWSuxtSKf7BqtK8UTIkJXJWU8BdI5DZHTK+OPgGmavopwhBSqehRt6l52F4S8GpOF8GFeHz26cYAPDvK8oEXCaNid8gLSZZeeSdmKTmvkzZd0sXPPNrBMFszmdAXHQUZTJNuwltoM7FHINHD4QP6Evs6Cuk7QLHA0Lc5gizIWRlU8bzgB9gA7dHG5XWcp9VmKHbZ9PjtjrXihmvq7xyfc8qUlOBOUd3vVCDXnLe8UQTLdP2ht0Oykbg42yiE93NZcDsdQfo9Z3ZEZR8HURe2KRF68+nf89im0nYeV8k5t3Q7D+9M3ZoXBS1uYWQSXWjA=="}}     
     * 账户存在，但是没有授权{"success":true,"authorized":false,"body":"{\"success\":true,\"authorized\":false}","params":{"params":"bCP2Gtm/Ou7G7ue1oD0jR3MHN0jBKBjgbxSv8JxAQcjgf+vyxJ9rkMbJSsYWkw2GjP87Luko85vlkos1i2Fv5RHBbbJ524jEEmAmyea5vNIuFTQ3sDlwRdH3UQxlpIH4ckUY/ZOX2zN8sa4nJJGUeC3wVoEQ8HuUGk1jtUBQ6bNxz6nQpgnaCaqrx1+xO7SR8KklB0GoRj2jYEORreZ1HQGy7YmlGC/K7i2VFRmcWuacJeLhJAnNw9dX5/7zwCfAdPUWhhPCjyUk+D82OzYqKYNlC11ZKoUqspKh+2QlVmdL+pzF2dqO5EdJoAOXzs4w1CxizBNV5uVumAW92hiMpw=="}}
     * @param certNo	证件号码
     * @param name		姓名
     * @return 			返回的信息中可以获得相应的参数，如openId
     */
    public static ZhimaAuthInfoAuthqueryResponse queryZhimaAuthInfo(String certNo,String name) {
    	
    	
    	/**实例化授权查询*/
        ZhimaAuthInfoAuthqueryRequest req = new ZhimaAuthInfoAuthqueryRequest();
        /**设置查询类型，0:按照openId查询2:按照身份证+姓名查询*/
        req.setIdentityType("2");
        /**查询参数有两种，就是上面的两种方式，如果有openid,则 {"openId":"268801234567890123456"}查询*/
        req.setIdentityParam("{\"certNo\":\""+certNo+"\",\"certType\":\"IDENTITY_CARD\",\"name\":\""+name+"\"}");
        /**授权查询*/
        DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey,
            zhimaPublicKey);
        
        try {
        	/**请求芝麻信用*/
            ZhimaAuthInfoAuthqueryResponse response = client.execute(req);
            /**获得返回的json*/
            String json=JSON.toJSON(response).toString();            
            System.out.println(json);
            return response;
            
        } catch (ZhimaApiException e) {
            e.printStackTrace();
            return null;
        }
        
    }
   
    /**
     * 短信唤起支付宝客户端授权 
     * 成功的json:{"success":true,"bizSuccess":"true","body":"{\"success\":true,\"biz_success\":true}","params":{"params":"RXhVH48b1UaPMfAezEPV+wt9x7lthRKzkKXpyFIKTIjh1wQxa7YV+E8OI9s5qaB3t0bbRJlty57tl7k35CHl6LsPy10t9gN9ShwW8Qd94wYy0cayCQdSPmLqAXTuqWZB6Gz7vm4yzIrF6k5ywA3f8Sr+T/Zs4+eMHjOnk/zFkFh5/Ep1J6dpU9Q8Qg8SFrRCdJyazNouVWQTiDkVp56mQnkJCmZUWmCTMYwANFWLAOmzn2VRaJB9k6gLwpuaWv/yTZ/SKm9eQvqnRR+Qn2ZJo2FDKDVAkMosX70husmkL/ERzXuIVsego12efCZfC8/XB3zEuzNevR8hAYqGS33N2BAkhS+Fq/eAaQQDF5skXKsqiFbwz9cd9K9PsOxqzNf5HbqM0/rsBHCCsDiUfaNHKpZcWdLNWdkU0bMDx5+mn4ki+v6mq/3rezlcGlL2v8RF2uBEbYSCdYyopaRex/n3eTG9++Vb+1xekvaOsGez9PsIztCR9iw1EGjaVKQ4jsTL"}}
     * success:通信是否成功，bizSuccess:业务是否成功。
     * 失败的json:{"success":false,"errorMessage":"支付宝账号不存在","errorCode":"ZMCSP.alipay_account_notexisted","body":"{\"success\":false,\"error_code\":\"ZMCSP.alipay_account_notexisted\",\"error_message\":\"支付宝账号不存在\"}","params":{"params":"Dbvx18FuuFIRv3QabT4sQlYPSOJHxlyIJg/L6x0P/bq8fUl5doI7zzEC4bmiJcV5ZFdZplnUsKLLTokDU/rVMoLtSZidsoPaMYln/1n/U7XMTCwhQhc26YwAar8EtKe6B+bwnNf3GYrCs7QptlxMkl8ToXsq5m0Zg+iImbf2k7gOsR74emZMyJbqmwHIDVIqod9480WZ48H4WmmjgJmgzUWs+Z+FI1bmamXE+aUBRtE8+LrQewzH12BExiRHTo1IDw5kqnJmIH5mBM2sKnMXn6xrZN/xbnNwPLqLT7I25WAl1Z6E88nYfJRs8JpeZhXvwV0v3jp6XtzOUkliUFT+vSf8RocvoEcvGeGS0KSEHEErFo4roO9abZHYSb/aho+T83enMFMgwFjNjP6CjlLhFNLpcwTPR5feKa31szygyRlAlXwKghSG9G8N+D1uo1qE/fPz8NIPEmDH6X5S3bCP1qu6X9RjJRKUNOgkQniyeHo562QXMzn9GFkrDxowk41D"}}
     * @param name		 姓名
     * @param certNo	身份证号码
     * @param mobileNo  手机号码
     * @return
     */
    public static ZhimaAuthEngineSmsauthResponse  queryZhimaAuthEngineSmsauth(String name,String certNo,String mobileNo) {
    	
    	/**支付宝唤醒配置类*/
        ZhimaAuthEngineSmsauthRequest req = new ZhimaAuthEngineSmsauthRequest();
        /**渠道，不知道为什么是windows，但是只有写了windows才成功*/
        req.setChannel("windows");
        /**来源平台，默认为zmop*/
        req.setPlatform("zmop");
        /**设置查询类型，0:按照openId查询2:按照身份证+姓名查询*/
        req.setIdentityType("2");// 必要参数        
        /**查询参数有两种，就是上面的两种方式，如果有openid,则 {"openId":"268801234567890123456"}查询*/
        req.setIdentityParam("{\"name\":\""+name+"\",\"certType\":\"IDENTITY_CARD\",\"certNo\":\""+certNo+"\",\"mobileNo\":\""+mobileNo+"\"}");// 必要参数        
        /**业务扩展字段，state可以后面回回传给商户的*/
        req.setBizParams("{\"auth_code\":\"M_SMS\",\"channelType\":\"app\",\"state\":\"jd_state\"}");
        /**访问地址实例化*/
        DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey,
    zhimaPublicKey);
        
        try {
        	/**进行支付宝唤醒，支付宝会给该用户发送短信*/
            ZhimaAuthEngineSmsauthResponse response = client.execute(req);
            //System.out.println(response.getOpenId());
            //System.out.println(response.isSuccess());
            //System.out.println(response.getErrorCode());
            //System.out.println(response.getErrorMessage());
            //System.out.println(JSON.toJSON(response));            
            return response;
        } catch (ZhimaApiException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    /**
     * 查询芝麻分
     * 查询成功：{"bizNo":"ZM201610113000000626900253694189","success":true,"zmScore":"730","body":"{\"success\":true,\"biz_no\":\"ZM201610113000000626900253694189\",\"result_code\":\"ZMSCORE0001\",\"zm_score\":\"730\"}","params":{"params":"QnvsPl5JTfg/7f2JOxEOFjHsGqFAg1KAl8Szncpdk2AVC9DogHd+FQgvBBFtknq7nZXP5E6U2zRHzRDLYxcXj1h+4Q4bn3UekEvSer6vWxxLIKVhqrXJrYHBH+TwCTvJ25XMPXhJIfMV27JqBvpLiaeZ0pwQtkKeT4ZEzdMmGq0RNf5kizwiZRaJq+DKD73uxu38b0VqTJkvHnpbJXfzUWnAUecv+H75BebhQ13FV6RhnkpSt//HAzZi5oLnMkl9jJHGGTYTgnjcM2REV6XW6n3Fv8t6BzSuGEmpCC7tAj7CI5ToMjhmYcR9/dyc4ylhefj4eer5+xUgDzGzwRHenQ=="}}
     * 查询失败：  
     * @param openId 用户的唯一标识
     * @return
     */
    public static ZhimaCreditScoreGetResponse queryZhimaCreditGet(String openId,String transactionId) {
    	
    	/**芝麻信用分查询*/
        ZhimaCreditScoreGetRequest req = new ZhimaCreditScoreGetRequest();
        /**来源平台，默认为zmop*/
        req.setPlatform("zmop");
        /**渠道*/
        req.setChannel("api");
        /**transactionId，该标记是商户每次请求的唯一标识。建议使用uuid进行传递，*/
        req.setTransactionId(transactionId);
        /**产品码，该值是默认值，不知道是什么意思*/
        req.setProductCode("w1010100100000000001");
        /**用户的OpenId*/
        req.setOpenId(openId);
        /**查询参数配置*/
        DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey,
            zhimaPublicKey);
        
        try {	
        	/**查询芝麻分*/
            ZhimaCreditScoreGetResponse response = client.execute(req);      
            //System.out.println(JSON.toJSON(response));
            return  response;
        } catch (ZhimaApiException e) {
            e.printStackTrace();
            return null;
        }
    }
    
   
    /**
     * 反欺诈信息查询
     * 成功：{"ivsDetail":[{"description":"身份证号与其他信息匹配，匹配后的信息被一个用户使用","code":"CERTNO_Match_Trust_Self_Sharing_Good"},{"description":"电话号码与其他信息匹配，匹配后的信息近期较活跃","code":"PHONE_Match_Trust_Self_Recency_Good"},{"description":"姓名与其他信息匹配，匹配后的信息被一个用户使用","code":"NAME_Match_Sharing_Good"},{"description":"电子邮箱与其他信息匹配, 匹配后的信息经过认证","code":"EMAIL_Match_Reliability_Good"}],"bizNo":"ZM201610143000000575700261694774","ivsScore":95,"success":true,"body":"{\"success\":true,\"biz_no\":\"ZM201610143000000575700261694774\",\"ivs_detail\":[{\"code\":\"CERTNO_Match_Trust_Self_Sharing_Good\",\"description\":\"身份证号与其他信息匹配，匹配后的信息被一个用户使用\"},{\"code\":\"PHONE_Match_Trust_Self_Recency_Good\",\"description\":\"电话号码与其他信息匹配，匹配后的信息近期较活跃\"},{\"code\":\"NAME_Match_Sharing_Good\",\"description\":\"姓名与其他信息匹配，匹配后的信息被一个用户使用\"},{\"code\":\"EMAIL_Match_Reliability_Good\",\"description\":\"电子邮箱与其他信息匹配, 匹配后的信息经过认证\"}],\"ivs_score\":95}","params":{"params":"BlvbHG2qYe1o7e1K/qVqDKXf5/gN/zWMkirpV8wtffWVID4rbM7UnUdAiNdB6EEPMlxyNgl7ao8zgnm4s9RRiEuaNaQi9AENkytsL6uwPJ9WxyFLrke82ez81rUBfsMk9seTHmdRYZVcyRRQlAjxBNMozCPmbEB8iILyvq/F5wAujxLkxU2JkWatVF2uyo3qK2+Dd/AQnS1oCkApuBcEvLJuu1cYtwqMYSTsrjDEUSXmxTbaq310+8EWwy3f2EZ/myrZHVG+DMf0eoc45RPgCVbtIHrm0s6kwWoSTX16+uOe5dI2gzAQEcJtfBMQ0MPKy2LwqF9TWEshJbs/e8vrNA=="}}
     * @param map
     * @return
     */
    public static ZhimaCreditIvsDetailGetResponse  queryZhimaCreditIvsDetailGet(Map<String,String> map,String transactionId) {
    	
    	/**构建查询配置*/
        ZhimaCreditIvsDetailGetRequest req = new ZhimaCreditIvsDetailGetRequest();
        /**渠道,api表示后台调用*/
        req.setChannel("api");
        /**来源平台，默认为zmop*/
        req.setPlatform("zmop");
        /**产品码，该值是默认值，不知道是什么意思*/
	    req.setProductCode("w1010100000000000103");
	    /**代表该次请求的唯一标志，以后用于对账*/
	    req.setTransactionId(transactionId);
	    /**身份证号码*/
	    Object certNoObj=map.get("cert_no");
	    if(certNoObj!=null){
	    	req.setCertNo(certNoObj.toString());//身份证        
	 	    req.setCertType("100");//身份证类型，默认值无需修改
	    }
	    /**姓名*/
	    Object nameObj=map.get("name");
	    if(nameObj!=null){
	    	req.setName(nameObj.toString());
	    }
	    /**手机号码*/
	    Object mobileObj=map.get("mobile");    
	    if(mobileObj!=null){
	    	 req.setMobile(mobileObj.toString());
	    }
	    /**邮箱*/
	    Object emailObj=map.get("email");
	    if(emailObj!=null){
	    	 req.setEmail(emailObj.toString());
	    }
	    /**银行卡*/
	    Object bankCardObj=map.get("bank_card");
	    if(bankCardObj!=null){
	        req.setBankCard(bankCardObj.toString());
	    }
	    /**地址*/
	    Object addressObj=map.get("address");
	    if(addressObj!=null){
	        req.setAddress(addressObj.toString());
	    }
	    /**IP*/
	    Object ipObj=map.get("ip");
	    if(ipObj!=null){
	    	req.setIp(ipObj.toString());
	    }
	    /**Mac地址*/
	    Object macObj=map.get("mac");
	    if(macObj!=null){
	    	req.setMac(macObj.toString());  
	    }
	    /**wifi的物理地址*/
	    Object wifimacObj=map.get("wifimac");
	    if(wifimacObj!=null){
	    	req.setWifimac(wifimacObj.toString());   
	    }
	    /**国际移动设备标志*/
	    Object imeiObj=map.get("imei");
	    if(imeiObj!=null){
	    	req.setImei(imeiObj.toString());
	    }
	    /**国际移动用户识别码*/
	    Object imsiObj=map.get("imsi");
	    if(imsiObj!=null){
	    	 req.setImsi(imsiObj.toString());
	    }     
	    
	    /**查询*/
	    DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey,
            zhimaPublicKey);
	    
        try {
        	
            ZhimaCreditIvsDetailGetResponse response = client.execute(req);
//            System.out.println(JSON.toJSON(response));
//            System.out.println(response.isSuccess());
//            System.out.println(response.getErrorCode());
//            System.out.println(response.getErrorMessage());
            
            return response;
        } catch (ZhimaApiException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * 行业关注名单查询
     * @param openId			用户授权id
     * @param transactionId		业务id
     * @return
     */
/*    public static ZhimaCreditWatchlistGetResponse  queryZhimaCreditWatchlistiiGet(String openId,String transactionId) { 
    	
    	*//**构建查询配置*//*
    	ZhimaCreditWatchlistGetRequest req = new ZhimaCreditWatchlistGetRequest();
    	*//**渠道,api表示后台调用*//*
        req.setChannel("api");
        *//**来源平台，默认为zmop*//*
        req.setPlatform("zmop");
        *//**产品码，该值是默认值，不知道是什么意思*//*
        req.setProductCode("w1010100100000000022");// 必要参数
        *//**transactionId，该标记是商户每次请求的唯一标识。建议使用uuid进行传递，*//*
        req.setTransactionId(RandomUtil.getRandomNumberOfThirty());// 必要参数        
        *//**用户授权的openId*//*
        req.setOpenId(openId);// 必要参数
        *//**查询参数配置*//*
        DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey,zhimaPublicKey);
        
        try {
        	执行
            ZhimaCreditWatchlistGetResponse response = client.execute(req);            
            System.out.println(JSON.toJSON(response));
            System.out.println(response.isSuccess());
            System.out.println(response.getErrorCode());
            System.out.println(response.getErrorMessage());
            return response;
        } catch (ZhimaApiException e) {
            e.printStackTrace();
            return null;
        }
    }*/
    
    
	    /**
	     * 生成加密后的参数并进行UrlEncode
		 * identityType =0 identityParam ={“openId”:”268801234567890123456”}； 如：identityType =1 identityParam ={“mobileNo”:”13588888888”} identityType=2 identityParam={“certNo ”:”652701197705103720”,”certType”:”IDEN TITY_CARD”,”name”:”eynppv”}; 
		 * @param identityType		类型为0：直接使用openId、1：手机号码、2：身份证和姓名
		 * @param identityParam		参数为json
	     * @return
	     * @throws ZhimaApiException
	     */
	  public static String generateParams(String identityType,String identityParam) throws ZhimaApiException {
		  
			ZhimaAuthInfoAuthorizeRequest req = new ZhimaAuthInfoAuthorizeRequest();
			// 授权来源渠道设置为appsdk
			req.setChannel("appsdk");
			req.setScene("");
			// 授权类型设置为2标识为证件号授权见“章节4中的业务入参说明identity_type”
			req.setIdentityType(identityType);
			// 构造授权业务入参证件号，姓名，证件类型;“章节4中的业务入参说明identity_param”
			req.setIdentityParam(identityParam);
			// 构造业务入参扩展参数“章节4中的业务入参说明biz_params”
			req.setBizParams("{\"auth_code\":\"M_APPSDK\",\"state\":\"xxx\"}");
			DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey,
			zhimaPublicKey);
			return client.generateEncryptedParamWithUrlEncode(req);
	    
	       
	  }
	  //
	/**
	 * 生成移动端SDK 集成需要的sign 参数，并进行urlEncode
	 * identityType =0 identityParam ={“openId”:”268801234567890123456”}； 如：identityType =1 identityParam ={“mobileNo”:”13588888888”} identityType=2 identityParam={“certNo ”:”652701197705103720”,”certType”:”IDEN TITY_CARD”,”name”:”eynppv”}; 
	 * @param identityType		类型为0：直接使用openId、1：手机号码、2：身份证和姓名
	 * @param identityParam		参数为json
	 * @return
	 * @throws ZhimaApiException
	 */
	public static String generateSign(String identityType,String identityParam) throws ZhimaApiException {
	      ZhimaAuthInfoAuthorizeRequest req = new ZhimaAuthInfoAuthorizeRequest();
	      // 授权来源渠道设置为appsdk
	      req.setChannel("appsdk");
	      req.setScene("");
	      // 授权类型设置为2标识为证件号授权见“章节4中的业务入参说明identity_type”
	      req.setIdentityType(identityType);
	        // 构造授权业务入参证件号，姓名，证件类型;“章节4中的业务入参说明identity_param”
	        req.setIdentityParam(identityParam);
	      // 构造业务入参扩展参数“章节4中的业务入参说明biz_params”
	      req.setBizParams("{\"auth_code\":\"M_APPSDK\",\"state\":\"xxx\"}");
	      DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey, zhimaPublicKey);
	      return client.generateSignWithUrlEncode(req);	
	  } 	
    

	/**
	 * 解析芝麻信用加密后的参数
	 * 解析后的参数open_id=268818665371299099797841694&error_message=%E6%93%8D%E4%BD%9C%E6%88%90%E5%8A%9F&state=xxx&error_code=SUCCESS&app_id=1000952&success=true
	 */
	public static String decryptParams(String params){
		
		//String params="Hb1RsbsmTm1fItlSgberk6QWFmGL/FwmPIXRQR3D0RfRlEyPR+ERNKdVh2oYU1JHhMdiee0DmEsh3h0j1aeKNQJeUm5m52Awdpbwl2yMWqCfGnURwAmrYwV0xhIQeXLI/fIpxjf+dwSCd3sr8ePaUmA5nmwTMRxGFiOt6DmDDD1sX44fzRiSF7Q3B4XSJxONkDKGPA2AmSQz6UGC7uj9bzuWPVw3xtj7eZ4oIU6QqGkdiTqLMljg/fVnPoda3z0M1Tw7WDZHCv4CdgFRryzKXxO3R/r7MceA2SVCVtDc9TdoVXYYOzZCTsbUZhdUcsTiNwiyC93pZ3XvMl0Ma7QD1w==";
		//String sign="GQl7nL/Q84fzIdIPr6dBGZv+8mK1pNwxvLzpigypYclkX4AbMx62IWmV6IIHXxjEQkiBcHOawKR9P0bSecHSp8vpWFdKybyVXy9i5oACU9/UEkImdb8uoQIUS1QpGJgskJEU0ephz5OwTBn1b+03B+1dd/FZ8hX4QkVFiF5nqA0=";
		try {
			String msg=RSACoderUtil.decrypt(params, privateKey, "UTF-8");
			//System.out.println(msg);
			return msg;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}		
	}
	
	public static String decryptParams(String params, String sign){
		try{
			DefaultZhimaClient client = new DefaultZhimaClient(gatewayUrl, appId, privateKey, zhimaPublicKey);
			return client.decryptAndVerifySign(params, sign);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	

    
    public static void main(String[] args){
    	System.out.println(UUID.randomUUID().toString().length());
    }

}
