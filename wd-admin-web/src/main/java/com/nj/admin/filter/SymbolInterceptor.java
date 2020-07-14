package com.nj.admin.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SymbolInterceptor implements HandlerInterceptor {

    private static final String regEx = "[<>+%&()'\"]";


    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2) throws Exception {
        String ret = "{\"returnCode\":8002,\"status\":8002,\"returnMsg\":\"包含非法字符\",\"message\":\"包含非法字符\",\"msg\":\"包含非法字符\"}";
        Map<String, String[]> parameterMap = request.getParameterMap();
        Iterator entries = parameterMap.entrySet().iterator();
        String key;
        String value;
        while (entries.hasNext()) {
            Map.Entry entry = (Map.Entry) entries.next();
            key = (String) entry.getKey();
            value = request.getParameter(key);
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(value);
            if (m.find()) {
                arg1.setCharacterEncoding("utf-8");
                arg1.setContentType("application/json;charset=UTF-8");
                arg1.getWriter().write(ret);
                return false;
            }
        }
        return true;
    }
}
