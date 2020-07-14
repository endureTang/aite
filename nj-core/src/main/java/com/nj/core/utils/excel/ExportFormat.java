package com.nj.core.utils.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 导出时，在实体类的属性上使用该注解，来配置显示数据的格式
 */
@Target(value=ElementType.FIELD)
@Retention(value=RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExportFormat {
	
	//导出的列标题的名称
	public String name();
	
	//对齐方式
	public String align() default ExportFormatConstant.Align.LEFT;
	
	//导出的列要进行的格式化类型
	public String formatType() default ExportFormatConstant.FormatType.STRING;
	
	//格式化类型值
	public String formatTypeValue() default "";
	
	//排序	值为整数，没有具体数字限制，有大小顺序即可
	public int sort();		
}
