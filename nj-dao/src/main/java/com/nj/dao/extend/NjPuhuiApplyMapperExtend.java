package com.nj.dao.extend;

import com.nj.model.decision.PuhuiModel;

/**
 * @author Lizy
 * @version 2018/4/24.
 */
public interface NjPuhuiApplyMapperExtend {
    /**
     * 根据贷款编号查询
     *
     * @param loanNo 贷款编号
     * @return 普惠model
     */
    PuhuiModel selectModelByLoanNo(String loanNo);
}
