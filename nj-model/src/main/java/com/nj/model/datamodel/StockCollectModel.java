package com.nj.model.datamodel;


import com.nj.core.utils.excel.ExportFormat;

public class StockCollectModel implements Comparable<StockCollectModel>{
//
//  @ExportFormat(name="编号", align="center", sort=1)
//  private String stockNo;
//  @ExportFormat(name="品名", align="center", sort=2)
//  private String brandName;
//  @ExportFormat(name="规格", align="center", sort=3)
//  private String spec;
//  @ExportFormat(name="单位", align="center", sort=4)
//  private String unit;
//  @ExportFormat(name="数量", align="center", sort=5)
//  private String amount;
//  @ExportFormat(name="单价", align="center", sort=6)
//  private String price;
//  @ExportFormat(name="优惠(折扣前加*)", align="center", sort=7)
//  private String discountPrice;
//  @ExportFormat(name="分摊成本", align="center", sort=8)
//  private String basePrice;
//  @ExportFormat(name="备注", align="center", sort=9)
//  private String remark;


  @Override
  public int compareTo(StockCollectModel o) {
   return 1;
  }
}
