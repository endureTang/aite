package com.nj.service.itf;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.MD5Util;
import com.nj.dao.NjChannelDevAccountMapper;
import com.nj.model.generate.NjChannelDevAccount;
import com.nj.model.generate.NjChannelDevAccountExample;

@Service("signService")
public class SignService {
	
	private static Logger logger = LoggerFactory.getLogger(SignService.class);
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	public boolean checkSign(HttpServletRequest request){
		String appId = request.getParameter("appId");
		String sign = request.getParameter("sign");
		String nonceStr = request.getParameter("nonceStr");
		logger.info("签名验证传入参数：sign="+sign+"，appId="+appId+",nonceStr="+nonceStr);
		if(StringUtils.isEmpty(appId)||StringUtils.isEmpty(sign)
				||StringUtils.isEmpty(nonceStr)){
			return false;
		}
		SortedMap<String,String> params = getParams(request);
		try{
			if(sign.equals(createSign(params, appId))){
				return true;
			}
			else{
				logger.error("签名校验错误");
				return false;
			}
		}catch(Exception e){
			logger.error("签名校验错误 ",e);
			return false;
		}
	}
	
	public String createSign(SortedMap<String, String> params, String appId) throws Exception{
		try{
			NjChannelDevAccountMapper mapper = dao.getMapper(NjChannelDevAccountMapper.class);
			NjChannelDevAccountExample exp = new NjChannelDevAccountExample();
			exp.createCriteria().andAppIdEqualTo(appId);
			String appKey = mapper.selectByExample(exp).get(0).getAppKey();
			StringBuffer sb = new StringBuffer();
			Set es = params.entrySet();
			Iterator it = es.iterator();
			while(it.hasNext()) {
				Map.Entry entry = (Map.Entry)it.next();
				String k = (String)entry.getKey();
				Object v = entry.getValue();
				if(null != v && !"".equals(v) 
						&& !"sign".equals(k) && !"appKey".equals(k)) {
					sb.append(k + "=" + v + "&");
				}
			}
			sb.append("appKey=" + appKey);
			String sign = MD5Util.MD5Encode(sb.toString(), "utf-8").toUpperCase();
			logger.info("签名验证生产参数：sign:"+sign+" pa:"+sb.toString());
			return sign;
		}catch(Exception e){
			logger.error("create sign error:",e);
			throw e;
		}
	}
	
	/**
	 * 创建签名
	 * @Description：sign签名
	 * @param characterEncoding 编码格式
	 * @param parameters 请求参数
	 * @param key  秘钥
	 * @return
	 */
	public static String createSign(String characterEncoding,SortedMap<String,Object> parameters,String key){
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			Object v = entry.getValue();
			if(null != v && !"".equals(v) 
					&& !"sign".equals(k) && !"appKey".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("appKey=" + key);
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		return sign;
	}
	
	private SortedMap<String, String> getParams(HttpServletRequest req){
		Enumeration<String> keys = req.getParameterNames();
		SortedMap<String, String> params = new TreeMap<String, String>();
		while(keys.hasMoreElements()){
			String key = keys.nextElement();
			if(!StringUtils.isEmpty(req.getParameter(key))){
				params.put(key, req.getParameter(key));
			}
		}
		return params;
	}
}
