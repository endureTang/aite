/*package com.nj.enterprise.filter;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.filter.OncePerRequestFilter;
import com.jdjf.util.DateTimeHelper;
import com.jdjf.util.StringUtil;
import com.jdjf.util.account.AccountCenterUtil;
import com.nj.core.base.common.Constants;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UserSessions;
import com.nj.enterprise.constant.EntpriseConstant;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserSessionFilter extends OncePerRequestFilter {
	
	*//**更新的token临近时间，这里是还有5分钟到期就进行更新*//*
	private static final int UPDATE_TOKEN_SECONDS = 5 * 60;


//	private String authLoginUrl;
//	public String getAuthLoginUrl() {
//		return authLoginUrl;
//	}
//	public void setAuthLoginUrl(String authLoginUrl) {
//		this.authLoginUrl = authLoginUrl;
//	}
	@Override
	protected void doFilterInternal(HttpServletRequest request,  
            HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		*//**请求参数*//*
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session=req.getSession();
		
		*//**URL过滤*//*
		String requestURL = req.getRequestURI();
		int index=requestURL.lastIndexOf(".");
		String postfix=requestURL.substring(index+1);
		String exceptUrlList = "outApi/";
		if(requestURL.contains(exceptUrlList) || requestURL.contains("processMgr")
				|| "jsp".equals(postfix)||"css".equals(postfix)||"png".equals(postfix)||"js".equals(postfix)
				||"jpg".equals(postfix)||"gif".equals(postfix)||"ico".equals(postfix)||"map".equals(postfix)
				||postfix.contains("/user/login")||postfix.contains("/loanOrder/")||postfix.contains("/code")){
			//System.out.println(postfix);
			filterChain.doFilter(req, response);
			return ;
		}
		
		String tokenId = req.getParameter("token_id");
		String tokenName = req.getParameter("token_name");
		
		*//**获取一个cookie数组*//*
		Cookie[] cookies = req.getCookies();
		if(cookies!=null){
			for(Cookie cookie : cookies){
			    String name=cookie.getName();
			    String value=cookie.getValue();
			    if("token_id".equals(name)){
			    	tokenId=value;
			    }
			    if("token_name".equals(name)){
			    	tokenName=value;
			    }
			   // System.out.println("CookieName="+cookie.getName()+"****CookieValue="+cookie.getValue());
			}
		}
		if(StringUtils.isNotEmptyAndNull(tokenId)){
			request.getSession().setAttribute(EntpriseConstant.SessionKey.TOKEN_ID, tokenId);
		}
		if(StringUtils.isNotEmptyAndNull(tokenName)){
			request.getSession().setAttribute(EntpriseConstant.SessionKey.TOKEN_NAME, tokenName);
		}
		tokenId = String.valueOf(request.getSession().getAttribute(EntpriseConstant.SessionKey.TOKEN_ID));  
		tokenName = String.valueOf(request.getSession().getAttribute(EntpriseConstant.SessionKey.TOKEN_NAME));  
		//定时检查token值，不正确则清空session中的值
		checkToken(session, req, res, tokenId, tokenName);
		Logger logger = LoggerFactory.getLogger(UserSessionFilter.class);
		String webTokenId = String.valueOf(request.getSession().getAttribute(EntpriseConstant.SessionKey.TOKEN_ID));  
		String webTokenName = String.valueOf(request.getSession().getAttribute(EntpriseConstant.SessionKey.TOKEN_NAME));  
		UserSessions.set(com.nj.core.base.util.Constants.USER_SESSION_KEY, webTokenName);
		
		logger.debug(this.getClass() +":" + webTokenId);
//		filterChain.doFilter(request, response); 
		
		String webTokenId = String.valueOf(request.getSession().getAttribute(EntpriseConstant.SessionKey.USER_ID));  
		if(StringUtils.isNotEmptyAndNull(webTokenId)){
			 filterChain.doFilter(req, res);
			 return;
		}else{
			response.sendRedirect(request.getContextPath()+"/user/login");
			return;
		}
	}
	
	private void checkToken(HttpSession session,HttpServletRequest req,HttpServletResponse res,String tokenId,String tokenName){
		*//**如果有值，则进行token认证,没有值则退出过滤器*//*
		if(!"".equals(tokenId)&&!"".equals(tokenName)){
			
			*//**从Session中取值*//*
			*//**查看session中是否有token_id*//*
			Object sessionTokenIdObj=session.getAttribute("web_token_id");
			String sessionTokenId="";
			if(sessionTokenIdObj!=null){
				sessionTokenId=sessionTokenIdObj.toString();
			}
			
			*//**查看Session中是否有token_name*//*
			Object sessionTokenNameObj=session.getAttribute("web_token_name");
			String sessionTokenName="";
			if(sessionTokenNameObj!=null){
				sessionTokenName=sessionTokenNameObj.toString();
			}
			
			*//**超时时间*//*
			Object expiresInObj=session.getAttribute("web_expires_in");
			String expiresIn="";
			if(expiresInObj!=null){
				expiresIn=expiresInObj.toString();
			}
			
			*//**token当前时间*//*
			Object tokenTimeObj=session.getAttribute("web_token_time");
			String tokenTime="";
			if(tokenTimeObj!=null){
				tokenTime=tokenTimeObj.toString();
			}
			
	
			*//**非空验证Session中的值,判断session中是否有这些值，有的就进行比较，没有则去统一用户中心对token验证*//*
			if(!StringUtil.isBlank(sessionTokenId)&&!StringUtil.isBlank(sessionTokenName)
					&&!StringUtil.isBlank(expiresIn)&&!StringUtil.isBlank(tokenTime)){
				
				*//**当前时间*//*
				long currnetTimeLong=System.currentTimeMillis();
				
				*//**token时间*//*
				long tokenTimeLong=new Long(tokenTime);
				
				*//**超时时间，超过该时间则为超时了,该时间是tokenTineLong+expiresIn*//*
				long tokenTimeExpiresInLong=DateTimeHelper.addSeconds(new Timestamp(tokenTimeLong), new Integer(expiresIn)).getTime();
				
				*//**更新时间,若当前时间大于该时间，则表示需要更新token*//*
				int updateTime=UPDATE_TOKEN_SECONDS;
				long tokenTimeUpdateLong=DateTimeHelper.addSeconds(new Timestamp(tokenTimeLong),updateTime).getTime();
				
				*//**Session中的值都存在的时候，则进行tokenid和tokenName的验证*//*
				if(tokenId.equals(sessionTokenId)&&tokenName.equals(sessionTokenName)){
					
					*//**验证成功，判断超时时间*//*
					if(currnetTimeLong<tokenTimeExpiresInLong){
						
						*//**当前时间小于超时时间,没有超时，需要验证是否快到更新时间了，这里默认为10分钟*//*
						if(currnetTimeLong>tokenTimeUpdateLong){
							//若当前时间大于更新时间，则表示需要更新token
							updateOrCheckToken(tokenId,tokenName,session,res);
						}
						
					}else{
						*//**当前时间大于超时时间，已经超时了,需要去统一用户中心验证*//*
						updateOrCheckToken(tokenId,tokenName,session,res);
					}						
					
				}else{
					*//**当tokenId和tokenName验证不一直的时候，不一定就是登录不成功的，因为有可能在另外的客户端登录过，所以需要在统一用户中心验证*//*
					updateOrCheckToken(tokenId,tokenName,session,res);
				}
				
			}else{
				*//**Session中的值不完整或不存在，需要去统一用户中心去验证，因为有可能是第一次登录*//*
				updateOrCheckToken(tokenId,tokenName,session,res);
			}				
			
		}
	}
	
	*//**
	 * 验证或者更新token
	 * @param tokenId	 
	 * @param tokenName
	 * @param session
	 *//*
	public void updateOrCheckToken(String tokenId,String tokenName,HttpSession session,HttpServletResponse response){
		
		*//**秘钥和渠道码*//*
		String channelCode="nj_server";
		String channelKey="ed7d597ef32c0319fec0536eb017c314";
		AccountCenterUtil.setCenterKey(channelKey);
		AccountCenterUtil.setChannelCode(channelCode);
		
		*//**服务器端验证Tokenid和tokenName*//*
		String msg=AccountCenterUtil.tokenWeb(tokenId, tokenName);	
		*//***//*
		
		//System.out.println("ms="+msg);
		*//**进行JSON解析和结果验证*//*
		JSONObject jsonObject=JSONObject.fromObject(msg);
		*//**验证是否通信正常*//*
		Object returnCodeObj=jsonObject.get("return_code");
		if(returnCodeObj!=null){
			if("SUCCESS".equals(returnCodeObj.toString())){
				*//**通信正常*//*
				JSONObject resultJsonObject=jsonObject.getJSONObject("result");
				*//**验证token是否成功*//*
				String resultCode=resultJsonObject.getString("result_code");			
				if("SUCCESS".equals(resultCode)){
					
					*//**成功后将服务最新的信息存入session中*//*
					String cTokenId=resultJsonObject.getString("token_id");
					String cTokenName=resultJsonObject.getString("token_name");
					String tokenTime=resultJsonObject.getString("token_time");
					String expiresIn=resultJsonObject.getString("expires_in");
//					String mobile=resultJsonObject.getString("mobile");
//					String openId=resultJsonObject.getString("open_id");
					session.setAttribute("web_token_id", cTokenId);
					session.setAttribute("web_token_name", cTokenName);
					session.setAttribute("web_token_time", tokenTime);
					session.setAttribute("web_expires_in", expiresIn);
					
				}else{
					
					*//**失败则清空session里面的值*//*
					session.removeAttribute("web_token_id");
					session.removeAttribute("web_token_name");
					session.removeAttribute("web_token_time");
					session.removeAttribute("web_expires_in");
					deleteCookie(response,"token_id");
					deleteCookie(response,"token_name");					
				}
				
			}else{
				*//**通信失败*//*
				session.removeAttribute("web_token_id");
				session.removeAttribute("web_token_name");
				session.removeAttribute("web_token_time");
				session.removeAttribute("web_expires_in");
				deleteCookie(response,"token_id");
				deleteCookie(response,"token_name");
			}
		}
	
	}
	
	*//**
	 * 删除Cookie
	 * @param response
	 * @param name
	 *//*
	public static  void deleteCookie(HttpServletResponse response,String name){
		Cookie cookie = new Cookie(name, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

}
*/