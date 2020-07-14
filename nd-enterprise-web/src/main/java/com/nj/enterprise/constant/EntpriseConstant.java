package com.nj.enterprise.constant;

public class EntpriseConstant {
	public interface Pages {
		String HOME_PAGE = "/home/admin/index";
		String WELCOME_PAGE = "/module/welcome";
	    String CREATE_ACCOUNT = "/auth/account";
	    String UNREGISTE_ENTRANCE = "/auth/entrance";
	    String UNSIGNED_USER = "/auth/unsignedUser";
	    String JOIN_ENTER = "/auth/join";
	    String CREATE_ENTER = "/auth/create";
	    String WHITE_PAGE ="product/product_whitelist";
	    String CHOICE_COMPANY = "auth/choice_company";
	    String APPLY_REASON = "auth/application_reasons";
	    String APPLY_RESULT = "auth/application_results";
	    String MY_COMPANY = "/module/my_company";
	    String USER_LOGIN = "/user/login";
	    
	}
	
	public interface Datas {
		String COUNT = "count";
		String RESULT = "result"; 
		String MSG = "msg";
		String RESULT_CODE ="resultCode";
		String START = "start";
		String LENGTH = "length";
		String DRAW = "draw";
		String RECORDSTOTAL = "recordsTotal";
		String RECORDSFILTERED = "recordsFiltered";
		String NDATA = "data";
		String STATUS="status";
	}
	
	public interface SessionKey {
		String TOKEN_ID = "web_token_id";
		String TOKEN_NAME ="web_token_name";
		String USER_ID ="userID";
		String USER ="user";
		String COPORATE_ID = "coporateId";
		String COPORATE_NAME ="companName";
		String USER_COPORATE ="userCoporate";
		String IS_COPORATE_ADMIN ="userAdmin";
		String USER_SYS_ADMIN ="userSysAdmin";
		String IS_BUSINESS_EXECUTIVE = "isBusinessExecutive";
		String PROCESS_ID = "processId";
		String ROLE_TYPE = "roleType";//多个角色，逗号分割
	}
	
	public interface RestData {
		String SUCCESS = "1";
		String FAILURE = "0";
	}
	
	public interface DataKey {
		String PRODUCT_ID = "productId";
		String IDGENERATOR = "PRODUCT_CODE";
		String ADMIN_ROLE_TYPE ="cadmin";
	}
	
	public interface UserState {
		//待提交
		int UNSUBMIT = 0;
		//审核通过
		int APPROVED = 1;
		//审核不通过
		int DECLINE = 2;
		
	}
	
	public interface CacheKey {
		String CACHE_NAME = "com.nj.cache";
	}
	
	public interface OrderKeyPoint{
		int GENERATE_CONTRACT = 7;
		int ORDER_PRE_PROCESS = 1;
	}
	
	public interface SpotNumber{
		String SPOT_NUMBER = "creditInfo.spot.number";
	}
}
