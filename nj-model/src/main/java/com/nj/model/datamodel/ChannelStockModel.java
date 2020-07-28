package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ChannelStockModel {

    @ExportFormat(name = "货号",align = ExportFormatConstant.Align.CENTER,sort = 1)
    private String stockNo;


    @ExportFormat(name = "尺码",align = ExportFormatConstant.Align.CENTER,sort = 2)
    private String specification;


    @ExportFormat(name = "数量",align = ExportFormatConstant.Align.CENTER,sort = 3)
    private String amount;


    @ExportFormat(name = "渠道价",align = ExportFormatConstant.Align.CENTER,sort = 4)
    private String channelPrice;


    @ExportFormat(name = "品牌",align = ExportFormatConstant.Align.CENTER,sort = 5)
    private String brand;


    @ExportFormat(name = "问题原因",align = ExportFormatConstant.Align.CENTER,sort = 6)
    private String remark;

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getChannelPrice() {
        return channelPrice;
    }

    public void setChannelPrice(String channelPrice) {
        this.channelPrice = channelPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}