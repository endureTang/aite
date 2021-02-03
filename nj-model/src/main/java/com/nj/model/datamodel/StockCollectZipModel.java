package com.nj.model.datamodel;


import com.nj.core.utils.excel.ExportFormat;

public class StockCollectZipModel implements Comparable<StockCollectZipModel>{

  @ExportFormat(name="部门", align="center", sort=1)
  private String department;
  @ExportFormat(name="物料编号", align="center", sort=2)
  private String meterialNo;
  @ExportFormat(name="是否参加活动", align="center", sort=3)
  private String isActivity;
  @ExportFormat(name="描述", align="center", sort=4)
  private String description;
  @ExportFormat(name="品牌代码", align="center", sort=5)
  private String bradCode;
  @ExportFormat(name="品牌", align="center", sort=6)
  private String brand;
  @ExportFormat(name="发布日期", align="center", sort=7)
  private String pubDate;
  @ExportFormat(name="性别", align="center", sort=8)
  private String sexType;
  @ExportFormat(name="运动品类", align="center", sort=9)
  private String sportType;
  @ExportFormat(name="季度代码", align="center", sort=10)
  private String seasonCode;
  @ExportFormat(name="颜色合并", align="center", sort=11)
  private String colorAll;
  @ExportFormat(name="尺寸", align="center", sort=12)
  private String size;
  @ExportFormat(name="首次收获日期", align="center", sort=13)
  private String firstReceiveDate;
  @ExportFormat(name="成本均价", align="center", sort=14)
  private String costPrice;
  @ExportFormat(name="RRP", align="center", sort=15)
  private String rrp;
  @ExportFormat(name="CPR", align="center", sort=16)
  private String crp;
  @ExportFormat(name="EPR%", align="center", sort=17)
  private String erp;
  @ExportFormat(name="库存", align="center", sort=18)
  private String amount;
  @ExportFormat(name="在途总数", align="center", sort=19)
  private String onWayAmount;
  @ExportFormat(name="仓库", align="center", sort=20)
  private String storage;
  @ExportFormat(name="店铺", align="center", sort=21)
  private String storeName;

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getMeterialNo() {
    return meterialNo;
  }

  public void setMeterialNo(String meterialNo) {
    this.meterialNo = meterialNo;
  }

  public String getIsActivity() {
    return isActivity;
  }

  public void setIsActivity(String isActivity) {
    this.isActivity = isActivity;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getBradCode() {
    return bradCode;
  }

  public void setBradCode(String bradCode) {
    this.bradCode = bradCode;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getPubDate() {
    return pubDate;
  }

  public void setPubDate(String pubDate) {
    this.pubDate = pubDate;
  }

  public String getSexType() {
    return sexType;
  }

  public void setSexType(String sexType) {
    this.sexType = sexType;
  }

  public String getSportType() {
    return sportType;
  }

  public void setSportType(String sportType) {
    this.sportType = sportType;
  }

  public String getSeasonCode() {
    return seasonCode;
  }

  public void setSeasonCode(String seasonCode) {
    this.seasonCode = seasonCode;
  }

  public String getColorAll() {
    return colorAll;
  }

  public void setColorAll(String colorAll) {
    this.colorAll = colorAll;
  }

  public String getFirstReceiveDate() {
    return firstReceiveDate;
  }

  public void setFirstReceiveDate(String firstReceiveDate) {
    this.firstReceiveDate = firstReceiveDate;
  }

  public String getCostPrice() {
    return costPrice;
  }

  public void setCostPrice(String costPrice) {
    this.costPrice = costPrice;
  }

  public String getRrp() {
    return rrp;
  }

  public void setRrp(String rrp) {
    this.rrp = rrp;
  }

  public String getCrp() {
    return crp;
  }

  public void setCrp(String crp) {
    this.crp = crp;
  }

  public String getErp() {
    return erp;
  }

  public void setErp(String erp) {
    this.erp = erp;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getOnWayAmount() {
    return onWayAmount;
  }

  public void setOnWayAmount(String onWayAmount) {
    this.onWayAmount = onWayAmount;
  }

  public String getStorage() {
    return storage;
  }

  public void setStorage(String storage) {
    this.storage = storage;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  @Override
  public int compareTo(StockCollectZipModel o) {
    return storeName.compareTo(o.getStoreName());
  }
}
