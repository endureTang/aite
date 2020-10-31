package com.nj.admin.controller;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface ExportFormat
{
  String name();
  
  String align() default "left";
  
  String formatType() default "String";
  
  String formatTypeValue() default "";
  
  int sort();
}
