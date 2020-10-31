package com.nj.admin.controller;

public class PriceModel
{
  private String id;
  @ExportFormat(name="货号", align="center", sort=1)
  private String stockNo;
  @ExportFormat(name="规格", align="center", sort=2)
  private String spec;
  @ExportFormat(name="价格", align="center", sort=3)
  private String price;
  
  public String getStockNo()
  {
    return this.stockNo;
  }
  
  public void setStockNo(String stockNo)
  {
    this.stockNo = stockNo;
  }
  
  public String getPrice()
  {
    return this.price;
  }
  
  public void setPrice(String price)
  {
    this.price = price;
  }
  
  public String getSpec()
  {
    return this.spec;
  }
  
  public void setSpec(String spec)
  {
    this.spec = spec;
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
