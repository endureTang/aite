package com.nj.admin.stockQueryApi.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.util.StreamUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpClientUtils {

    public static JSONObject doPost(String url, JSONObject json) {
        HttpClient httpClient = new HttpClient();
        PostMethod method = new PostMethod(url);

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        if (json != null) {
            for (Map.Entry<String, Object> entry : json.entrySet()) {
                nameValuePairs.add(new NameValuePair(entry.getKey(), entry.getValue().toString()));
            }
        }

        NameValuePair[] param = nameValuePairs.toArray(new NameValuePair[nameValuePairs.size()]);
        method.addParameters(param);
        try {
            int statusCode = httpClient.executeMethod(method);
            return JSONObject.parseObject(StreamUtils.copyToString(method.getResponseBodyAsStream(), Charset.forName("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return new JSONObject();
}

}