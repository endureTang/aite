package com.nj.admin.controller;

import com.nj.core.utils.excel.ExportFormat;

public class StockModel
{
  private String id;
  @ExportFormat(name="编号", align="center", sort=1)
  private String stockNo;
  @ExportFormat(name="品名", align="center", sort=2)
  private String brandName;
  @ExportFormat(name="规格", align="center", sort=3)
  private String spec;
  @ExportFormat(name="单位", align="center", sort=4)
  private String unit;
  @ExportFormat(name="数量", align="center", sort=5)
  private String amount;
  @ExportFormat(name="单价", align="center", sort=6)
  private String price;
  @ExportFormat(name="优惠(折扣前加*)", align="center", sort=7)
  private String discountPrice;
  @ExportFormat(name="分摊成本", align="center", sort=8)
  private String basePrice;
  @ExportFormat(name="备注", align="center", sort=9)
  private String remark;

  public String getStockNo()
  {
    return this.stockNo;
  }

  public void setStockNo(String stockNo)
  {
    this.stockNo = stockNo;
  }

  public String getBrandName()
  {
    return this.brandName;
  }

  public void setBrandName(String brandName)
  {
    this.brandName = brandName;
  }

  public String getSpec()
  {
    return this.spec;
  }

  public void setSpec(String spec)
  {
    this.spec = spec;
  }

  public String getUnit()
  {
    return this.unit;
  }

  public void setUnit(String unit)
  {
    this.unit = unit;
  }

  public String getAmount()
  {
    return this.amount;
  }

  public void setAmount(String amount)
  {
    this.amount = amount;
  }

  public String getPrice()
  {
    return this.price;
  }

  public void setPrice(String price)
  {
    this.price = price;
  }

  public String getDiscountPrice()
  {
    return this.discountPrice;
  }

  public void setDiscountPrice(String discountPrice)
  {
    this.discountPrice = discountPrice;
  }

  public String getBasePrice()
  {
    return this.basePrice;
  }

  public void setBasePrice(String basePrice)
  {
    this.basePrice = basePrice;
  }

  public String getRemark()
  {
    return this.remark;
  }

  public void setRemark(String remark)
  {
    this.remark = remark;
  }

  public String getId()
  {
    return this.id;
  }

  public void setId(String id)
  {
    this.id = id;
  }
}
