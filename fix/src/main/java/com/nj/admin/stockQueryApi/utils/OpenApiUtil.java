package com.nj.admin.stockQueryApi.utils;
import com.nj.admin.stockQueryApi.pojo.OpenApi;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class OpenApiUtil {
	/**
	 * ����HTTP����
	 * @param openApi
	 * @return
	 */
	public static String HttpPostString(OpenApi openApi) {
		try {
			openApi.requestparas.put("method", openApi.method);
			openApi.requestparas.put("accesstoken", openApi.accesstoken);
			openApi.requestparas.put("appkey", openApi.appkey);
			openApi.requestparas.put("timestamp", openApi.timestamp);
			openApi.requestparas.put("format", openApi.format);
			openApi.requestparas.put("versions", openApi.versions);
			//����sign
			openApi.sign = GetSign(openApi.requestparas,openApi.appsecret,openApi.versions);
			openApi.requestparas.put("sign", openApi.sign);
			//���㷢�Ͳ���
			String param = getParam(openApi.requestparas);
			//��¼���Ͳ���
			openApi.setPostparas(param);
			return doPost(openApi.url, param);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	/**
	 * �����������
	 * @param requestparas
	 * @return
	 * @throws Exception
	 */
	public static String getParam(Map<String, String> requestparas) throws Exception{
		String param = "";
		for (Map.Entry<String, String> entry : requestparas.entrySet()) {
			param += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(),"UTF-8") + "&";
		}
		param = param.substring(0, param.length() - 1);
		return param;
	}
	/**
	 * ����sign
	 * @param requestparas
	 * @param appsecret
	 * @return
	 * @throws Exception
	 */
	public static String GetSign(Map<String, String> requestparas,String appsecret,String versions) throws Exception {
		//��map�����ֵȡ��������list
		List<String> list = new ArrayList<String>();
		for (Map.Entry<String, String> entry : requestparas.entrySet()) {
			list.add(entry.getValue());
		}
		if(versions == "1.0") {//�ֵ�����
			//�Ȼ�ȡcontent����
			String content = getContentValue(list);
			if(content == null) {//û��content���� ��ֱ��ASCII����
				list = list.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(toList());
			} else {
				//��list����ɾ��content����
				Iterator<String> sListIterator = list.iterator();  
				while(sListIterator.hasNext()){  
				    String e = sListIterator.next();  
				    if(e.equals(content)){  
				    	sListIterator.remove();  
				    	break;
				    }  
				} 
				//ʣ�µ�ASCII����
				list = list.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(toList());
				//���content������λ
				list.add(0, content);
			}
		} else {//ASCII����
			list = list.stream().sorted((s1,s2)->s1.compareTo(s2)).collect(toList());
		}
		
		// ����ƴ��
		StringBuilder builder = new StringBuilder();
		builder.append(appsecret);
		for (String value : list) {
			builder.append(value);
		}
		builder.append(appsecret);
		return getMd5Value(builder.toString());
	}
	
	/**
	 * ��ȡcontent����
	 * @param list
	 * @return
	 */
	public static String getContentValue(List<String> list) {
		for (String one : list) {
			if(one.indexOf("<") != -1 || one.indexOf("{") != -1) {
				return one;
			}
		}
		return null;
	}
	/**
	 * ����MD5
	 * @return
	 * @throws Exception
	 */
	public static String getMd5Value(String str) throws Exception {
		MessageDigest bmd5 = MessageDigest.getInstance("MD5");
		bmd5.update(str.getBytes("UTF-8"));
		int i;
		StringBuffer buf = new StringBuffer();
		byte[] b = bmd5.digest();
		for (int offset = 0; offset < b.length; offset++) {
			i = b[offset];
			if (i < 0)
				i += 256;
			if (i < 16)
				buf.append("0");
			buf.append(Integer.toHexString(i));
		}
		return buf.toString();
	}
	
	/**
	 * ����post����
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String doPost(String url, String params) throws Exception {  
		String result = new String();
		URL urlPath=new URL(url);
		HttpURLConnection connection = (HttpURLConnection)urlPath.openConnection();
        try {  
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.connect();
            
            DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
            dos.writeBytes(params);
            dos.flush();
            dos.close();
            
            int resultCode=connection.getResponseCode();
            
            if(HttpURLConnection.HTTP_OK==resultCode){
                StringBuffer sb=new StringBuffer();
                String readLine=new String();
                BufferedReader responseReader=new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
                while((readLine=responseReader.readLine())!=null){
                  sb.append(readLine).append("\n");
                }
                responseReader.close();
                result = sb.toString();
            } 
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return result;
    }
}
