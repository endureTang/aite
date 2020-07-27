package com.nj.model.datamodel;

import com.nj.model.generate.StockFormatDict;

import java.util.List;

/**
 * @description:
 * @author: endure
 * @create: 2020-07-27 13:59
 **/
public class StockFormatForm {

    private String id;
    private String name;
    private Integer status;
    List<StockFormatDictForm> stockFormatDictList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<StockFormatDictForm> getStockFormatDictList() {
        return stockFormatDictList;
    }

    public void setStockFormatDictList(List<StockFormatDictForm> stockFormatDictList) {
        this.stockFormatDictList = stockFormatDictList;
    }
}
