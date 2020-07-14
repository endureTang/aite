/*
 * COPYRIGHT. ShenZhen GreatVision Network Technology Co., Ltd. 2015.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen GreatVision Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * Apr 17, 2015    YangShengJun         Create the class
 */

package com.nj.core.base.util;

/**
 * @FileName Constants.java
 * @Description: 
 *
 * @Date Apr 19, 2015 
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class Constants {
	
	public static String PICTURE_VISIT_FILE_PATH = "";//图片访问的路径
	
	public static String PICTURE_SAVE_FILE_PATH = "";//图片存放的路径
	
	public final static int PAGE_SIZE=10; //分页大小

	
	public static String getPICTURE_VISIT_FILE_PATH() {
		return PICTURE_VISIT_FILE_PATH;
	}

	public static void setPICTURE_VISIT_FILE_PATH(String pICTURE_VISIT_FILE_PATH) {
		PICTURE_VISIT_FILE_PATH = pICTURE_VISIT_FILE_PATH;
	}

	public static String getPICTURE_SAVE_FILE_PATH() {
		return PICTURE_SAVE_FILE_PATH;
	}

	public static void setPICTURE_SAVE_FILE_PATH(String pICTURE_SAVE_FILE_PATH) {
		PICTURE_SAVE_FILE_PATH = pICTURE_SAVE_FILE_PATH;
	}

	public static void main(String[] args) {
		Constants.setPICTURE_SAVE_FILE_PATH("D:/Tomcat 6.0/webapps/ysj/topic/");
		Constants.setPICTURE_VISIT_FILE_PATH("http://192.168.1.225:8888/ysj/topic/");
	}
	
	public interface Datas {
		String COUNT = "count";
		String RESULT = "result";
		String MSG = "msg";
		String RESULT_CODE ="resultCode";
		String START = "start";//当前条数
		String LENGTH = "length";//每页size
		String DRAW = "draw";
		String RECORDSTOTAL = "recordsTotal";//总条数
		String RECORDSFILTERED = "recordsFiltered";
		String RECORDSAMOUNT ="recordsAmount";//总金额
		String NDATA = "data";
		String STATUS="status";
	}

	public static String DEL_KEY = "delFlag";
	public static String ID_KEY = "id";
	public static String CREATE_KEY = "createBy";
	public static String CREATE_DATE_KEY = "createDate";
	public static String UPDATE_KEY = "updateBy";
	public static String UPDATE_DATE_KEY = "updateDate";
	public static String USER_SESSION_KEY = "user_key";
	public static String USER_SESSION_RESOURCE = "user_resource";
	
	public interface ProductState {
		// 产品设置未完成
		int UNSUBMIT = 0;
		// 已提交-产品配置已完成
		int SUBMITTED = 1;
		// 已发布-待审核
		int PUBLISHED = 2;
		// 审核通过
		int APPROVED = 3;
		// 审核拒绝
		int DECLINE = 4;
		// 产品上线
		int ONLINE = 5;
		// 产品下线
		int OFFLINE = 6;
	}
	
	/**
	 * 上传附件对应数据字典ID：身份证相关、其他资料附件
	 * @author TangRenjian
	 *
	 */
	public class ATTACHFILETYPE{
		public final static String IDCARD_FILE="8,86,270,277,276";
		public final static String MATERIA_FILE="5,6,7,84,179,185,186,291";
	}
	
	/**
	 * 企业进件-不在业务受理配置里的附件的filetag
	 */
	public interface CompanyAttchment{
		public final static String FILETAG_CREDIT_BORROWSUBJECT = "company_creditInfo_borrowSubject";			//企业进件-信用信息页面-征信情况-借款主体附件的filetag
		public final static String FILETAG_CREDIT_GUARANTEE = "company_creditinfo_guarantee";				//企业进件-信用信息页面-征信情况-担保人（法人）附件的filetag
	}
}
