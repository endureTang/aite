package com.nj.admin.controller;

public class ExportFormatConstant
{
  public static abstract interface Align
  {
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final String CENTER = "center";
  }
  
  public static abstract interface FormatTypeValue
  {
    public static final String NOTHING = "nothing";
    public static final String INT = "int";
    public static final String NUMBER_2 = "number_2";
    public static final String NUMBER_4 = "number_4";
    public static final String DATE = "date";
    public static final String TIME = "time";
    public static final String DATETIME = "datetime";
    public static final String TIMESTAMP = "timestamp";
  }
  
  public static abstract interface FormatType
  {
    public static final String STRING = "String";
    public static final String TIME = "time";
    public static final String NUMBER = "number";
  }
}
