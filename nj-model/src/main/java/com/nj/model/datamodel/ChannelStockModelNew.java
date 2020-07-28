package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ChannelStockModelNew {

    @ExportFormat(name = "货号",align = ExportFormatConstant.Align.CENTER,sort = 1)
    private String stockNo;

    @ExportFormat(name = "尺码",align = ExportFormatConstant.Align.CENTER,sort = 2)
    private String specification;

    @ExportFormat(name = "数量",align = ExportFormatConstant.Align.CENTER,sort = 3)
    private String amount;

    @ExportFormat(name = "折扣",align = ExportFormatConstant.Align.CENTER,sort = 4)
    private String discount;

    @ExportFormat(name = "吊牌价",align = ExportFormatConstant.Align.CENTER,sort = 5)
    private String basePrice;

    @ExportFormat(name = "渠道价",align = ExportFormatConstant.Align.CENTER,sort = 6)
    private String channelPrice;

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

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getChannelPrice() {
        return channelPrice;
    }

    public void setChannelPrice(String channelPrice) {
        this.channelPrice = channelPrice;
    }
}