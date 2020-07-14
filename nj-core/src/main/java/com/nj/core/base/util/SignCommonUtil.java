package  com.nj.core.base.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import com.nj.core.base.common.Constants;


/**
 * 签名工具类
 * @author MaSong
 */
public class SignCommonUtil {
	

	/**
	 * 创建指定长度的随机串
	 * @param length  长度
	 * @return
	 */
	public static String CreateNoncestr(int length) {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String res = "";
		for (int i = 0; i < length; i++) {
			Random rd = new Random();
			res += chars.charAt(rd.nextInt(chars.length() - 1));
		}
		return res;
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
					&& !"sign".equals(k) && !"app_key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + key);
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		return sign;
	}
	
	public static String createSign(Map<String,Object> params){
		Set<String> set = params.keySet();
		String[] strs = new String[set.size()];  
		int i = 0;
		for (String string : set) {
			strs[i] = string;
			i++;
		}
		Arrays.sort(strs);
		
		StringBuffer sb = new StringBuffer();
		
		for (String key : strs) {
			sb.append(key+"="+params.get(key)+"&");
		}
		sb.append("key="+Constants.SNDK.SIGN_KEY);
		return MD5Util.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
	}
	
	public static void main(String []args){
		
		
		/**签名测试*/
		SortedMap<String, Object> packageParams = new TreeMap<String, Object>();
		packageParams.put("mch_id", "100000001");//
		packageParams.put("app_id", "100000001");
		packageParams.put("nonce_str",CreateNoncestr(32));
		packageParams.put("name", "小明");
		packageParams.put("mobile_no", "13888888888");
		packageParams.put("cert_no", "510802198708101220");
		String sign=createSign("UTF-8",packageParams,"123456");
		System.out.println(sign);
		
	}

}
