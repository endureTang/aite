package com.nj.model.datamodel;

import com.nj.core.utils.excel.ExportFormat;
import com.nj.core.utils.excel.ExportFormatConstant;

public class ErrorErpModel {

    @ExportFormat(name = "行数",align = ExportFormatConstant.Align.CENTER,sort = 1)
    private Integer rowNumber;


    @ExportFormat(name = "错误原因",align = ExportFormatConstant.Align.CENTER,sort = 2)
    private String message;

    public Integer getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}