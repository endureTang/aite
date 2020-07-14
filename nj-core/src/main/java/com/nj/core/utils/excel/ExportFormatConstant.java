package com.nj.core.utils.excel;

/**
 * 导出格式化用到的枚举
 */
public class ExportFormatConstant {

	//格式化类型
	public interface FormatType{
		
		public static final String STRING = "String";
		public static final String TIME = "time";
		public static final String NUMBER = "number";
	}
	
	//格式化类型值
	public interface FormatTypeValue{
		
		//FormatType为NUMBER
		public static final String NOTHING = "nothing";
		public static final String INT = "int";
		public static final String NUMBER_2 = "number_2";
		public static final String NUMBER_4 = "number_4";
		
		//FormatType为TIME
		public static final String DATE = "date";				//yyyy-MM-dd
		public static final String TIME = "time";				//hh:mm:ss
		public static final String DATETIME = "datetime";		//yyyy-MM-dd hh:mm:ss
		public static final String TIMESTAMP = "timestamp";		//yyyy-MM-dd hh:mm:ss sss
	}
	
	//对齐方式
	public interface Align{
		public static final String LEFT = "left";
		public static final String RIGHT = "right";
		public static final String CENTER = "center";
	}
}
