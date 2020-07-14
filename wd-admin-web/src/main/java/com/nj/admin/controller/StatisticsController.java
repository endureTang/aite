package com.nj.admin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.ObjectExcelRead;
import com.nj.core.base.util.PageData;
import com.nj.service.enterprise.EnterStatisticsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 统计controller
 *
 * @author Lizy
 * @version 2018/6/26.
 */
@Controller
@RequestMapping(value = "/statistics")
public class StatisticsController extends BaseController {
    /**
     * 日志
     */
    private static Logger logger = LoggerFactory.getLogger(StatisticsController.class);

    @Resource
    private EnterStatisticsService enterStatisticsService;

    /**
     * 进件统计
     */
    @GetMapping(value = "input")
    @ResourcesAnnotion(uri = "/statistics/input", name = "进件统计", resourceType = 1, parentId = "4")
    public ModelAndView inputPage() {
        ModelAndView mv = super.getModelAndView();
        String endTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        String startTime = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        mv.addObject("endTime",endTime);
        mv.addObject("startTime",startTime);
        mv.setViewName("sys/statistics/input");
        return mv;
    }

    /**
     * 进件统计
     */
    @PostMapping(value = "/input")
    @ResponseBody
    public PageData inputData() {
        PageData result = new PageData();
        try {
            PageData pd = super.getPageData();
            PageHelper.startPage(pd.getInteger("start"), pd.getInteger("length"));
            PageInfo<?> info = new PageInfo<>(enterStatisticsService.getInput(pd));
            result.put("status", 0);
            result.put(Constants.Datas.RECORDSFILTERED, info.getTotal());
            result.put(Constants.Datas.NDATA, info.getList());
        } catch (Exception e) {
            logger.error("get input data error", e);
            result = new PageData();
        }
        return result;
    }

    /**
     * 进件统计明细
     */
    @GetMapping(value = "inputByCompany")
    public ModelAndView inputByCompanyPage(String startTime, String endTime, String companyId) {
        ModelAndView mv = super.getModelAndView();
        mv.addObject("startTime", startTime);
        mv.addObject("endTime", endTime);
        mv.addObject("companyId", companyId);
        mv.setViewName("sys/statistics/inputByCompany");
        return mv;
    }


    /**
     * 进件统计明细
     */
    @PostMapping(value = "/inputByCompany")
    @ResponseBody
    public PageData inputByCompanyData() {
        PageData result = new PageData();
        try {
            PageData pd = super.getPageData();
            PageHelper.startPage(pd.getInteger("start"), pd.getInteger("length"));
            PageInfo<?> info = new PageInfo<>(enterStatisticsService.getInputByCompany(pd));
            result.put("status", 0);
            result.put(Constants.Datas.RECORDSFILTERED, info.getTotal());
            result.put(Constants.Datas.NDATA, info.getList());
        } catch (Exception e) {
            logger.error("get input by company data error", e);
            result = new PageData();
        }
        return result;
    }

    /**
     * 三方接口调用
     */
    @GetMapping(value = "thirdPart")
    @ResourcesAnnotion(uri = "/statistics/thirdPart", name = "三方接口调用", resourceType = 1, parentId = "4")
    public ModelAndView thirdPartPage() {
        ModelAndView mv = super.getModelAndView();
        String endTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -7);
        String startTime = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        mv.addObject("endTime",endTime);
        mv.addObject("startTime",startTime);
        mv.setViewName("sys/statistics/thirdPart");
        return mv;
    }

    /**
     * 三方接口调用
     */
    @PostMapping(value = "/thirdPart")
    @ResponseBody
    public PageData thirdPartData() {
        PageData result = new PageData();
        try {
            PageData pd = super.getPageData();
            PageHelper.startPage(pd.getInteger("start"), pd.getInteger("length"));
            PageInfo<?> info = new PageInfo<>(enterStatisticsService.getThirdPart(pd));
            result.put("status", 0);
            result.put(Constants.Datas.RECORDSFILTERED, info.getTotal());
            result.put(Constants.Datas.NDATA, info.getList());
        } catch (Exception e) {
            logger.error("get third part data error", e);
            result = new PageData();
        }
        return result;
    }

    /**
     * 三方接口调用明细
     */
    @GetMapping(value = "thirdPartByCompany")
    public ModelAndView thirdPartByCompanyPage(String startTime, String endTime, String companyId) {
        ModelAndView mv = super.getModelAndView();
        mv.addObject("startTime", startTime);
        mv.addObject("endTime", endTime);
        mv.addObject("companyId", companyId);
        mv.setViewName("sys/statistics/thirdPartByCompany");
        return mv;
    }

    /**
     * 三方接口调用明细
     */
    @PostMapping(value = "/thirdPartByCompany")
    @ResponseBody
    public PageData thirdPartByCompanyData() {
        PageData result = new PageData();
        try {
            PageData pd = super.getPageData();
            PageHelper.startPage(pd.getInteger("start"), pd.getInteger("length"));
            PageInfo<?> info = new PageInfo<>(enterStatisticsService.getThirdPartByCompany(pd));
            result.put("status", 0);
            result.put(Constants.Datas.RECORDSFILTERED, info.getTotal());
            result.put(Constants.Datas.NDATA, info.getList());
        } catch (Exception e) {
            logger.error("get third part by company data error", e);
            result = new PageData();
        }
        return result;
    }

    /**
     * 三方接口初始化数据
     */
    @PostMapping(value = "/thirdPartInit")
    @ResponseBody
    public PageData thirdPartInit() {
        PageData result = new PageData();
        try {
            result.put("company", enterStatisticsService.initCompany());
            result.put("thirdPart", enterStatisticsService.initThirdPart());
        } catch (Exception e) {
            logger.error("int third part data error", e);
            result = new PageData();
        }
        return result;
    }

    /**
     * 三方接口初始化数据
     */
    @PostMapping(value = "/thirdPartApi")
    @ResponseBody
    public PageData thirdPartApiByName() {
        PageData result = new PageData();
        try {
            PageData pd = super.getPageData();
            result.put("description", enterStatisticsService.getApiByName(pd));
        } catch (Exception e) {
            logger.error("int third part data error", e);
            result = new PageData();
        }
        return result;
    }
}
