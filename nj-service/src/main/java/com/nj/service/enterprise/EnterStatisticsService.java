package com.nj.service.enterprise;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjStatisticsOrderMapperExtend;
import com.nj.dao.extend.NjStatisticsThreePartyCallMapperExtend;
import com.nj.dao.extend.SysOutsideApiMapperExtend;
import com.nj.model.generate.NjCoporate;

/**
 * @author Lizy
 * @version 2018/6/26.
 */
@Transactional(readOnly = true)
@Service("enterStatisticsService")
public class EnterStatisticsService {


    @Resource(name = "BaseDao")
    private BaseDao dao;
    @Resource
    private CoporateService coporateService;

    private static Logger logger = LoggerFactory.getLogger(EnterStatisticsService.class);

    /**
     * 获取订单统计
     */
    public List<Map> getInput(PageData pd) throws Exception {
        NjStatisticsOrderMapperExtend njStatisticsOrderMapperExtend = dao.getMapper(NjStatisticsOrderMapperExtend.class);
        String startTime = pd.getString("startTime");
        String endTime = pd.getString("endTime");
        return njStatisticsOrderMapperExtend.getOrder(startTime, endTime);
    }

    /**
     * 根据公司查询订单统计
     */
    public List<Map> getInputByCompany(PageData pd) throws Exception {
        NjStatisticsOrderMapperExtend njStatisticsOrderMapperExtend = dao.getMapper(NjStatisticsOrderMapperExtend.class);
        String startTime = pd.getString("startTime");
        String endTime = pd.getString("endTime");
        String companyId = pd.getString("companyId");
        return njStatisticsOrderMapperExtend.getOrderByCompany(startTime,endTime,companyId);
    }
    /**
     * 三方接口调用
     */
    public List<Map> getThirdPart(PageData pd) throws Exception {
        String startTime = pd.getString("startTime");
        String endTime = pd.getString("endTime");
        NjStatisticsThreePartyCallMapperExtend njStatisticsThreePartyCallMapperExtend = dao.getMapper(NjStatisticsThreePartyCallMapperExtend.class);
        return njStatisticsThreePartyCallMapperExtend.getThirdPart(startTime, endTime);
    }

    /**
     * 根据公司查询接口调用情况
     */
    public List<Map> getThirdPartByCompany(PageData pd) throws Exception {
        String startTime = pd.getString("startTime");
        String endTime = pd.getString("endTime");
        String companyId = pd.getString("companyId");
        String thirdPart = pd.getString("thirdPart");
        String description = pd.getString("description");
        NjStatisticsThreePartyCallMapperExtend njStatisticsThreePartyCallMapperExtend = dao.getMapper(NjStatisticsThreePartyCallMapperExtend.class);
        return njStatisticsThreePartyCallMapperExtend.getThirdPartByCompany(companyId, startTime, endTime, thirdPart, description);
    }

    /**
     * 初始化企业
     */
    public List<NjCoporate> initCompany() throws Exception {
        return coporateService.getAllCompany();
    }

    /**
     * 初始化第三方
     */
    public List<Map> initThirdPart() throws Exception {
        SysOutsideApiMapperExtend sysOutsideApiMapperExtend = dao.getMapper(SysOutsideApiMapperExtend.class);
        return sysOutsideApiMapperExtend.getAllThirdPartByGroup();
    }

    /**
     * 获取第三方接口
     */
    public List<Map> getApiByName(PageData pd) throws Exception {
        String thirdPart = pd.getString("thirdPart");
        SysOutsideApiMapperExtend sysOutsideApiMapperExtend = dao.getMapper(SysOutsideApiMapperExtend.class);
        return sysOutsideApiMapperExtend.getAPiBySupplierName(thirdPart);
    }
    
    /**
     * 查询客户经理销售排行
     * @param startTime
     * @param endTime
     * @param companyId
     * @return
     * @throws Exception
     */
    public List<Map> getNjStatisticsSell(Date startTime,Date endTime,String companyId) throws Exception{
    	
    	NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
    	return mapper.getStatisticsSell(startTime, endTime, companyId);
    	
    }
    
    /**
     * 查询客户经理回款排行
     * @param startTime
     * @param endTime
     * @param companyId
     * @return
     * @throws Exception
     */
    public List<Map> getNjStatisticsManagerReturn(Date startTime,Date endTime,String companyId) throws Exception{
    	
    	NjLoanOrderMapperExtend mapper = dao.getMapper(NjLoanOrderMapperExtend.class);
    	return mapper.getStatisticsManagerReturn(startTime, endTime, companyId);
    }

}
