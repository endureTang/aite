package com.nj.admin.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysOperateLog;
import com.nj.service.base.system.LogService;


/**
 * @FileName LogController.java
 * @Description:
 *
 * @Date 2018年2月9日
 * @author Alan
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/log")
public class LogController extends BaseController {
	private static Logger logger = LoggerFactory.getLogger(LogController.class);
	
	@Resource(name = "logService")
	private LogService logService;
	
	@ResourcesAnnotion(uri="/log/page",name="日志管理",resourceType=1,parentId="3")
	@RequestMapping(value="/page")
	public ModelAndView page() {
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/log/log_list");
		return mv;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			Integer start = pd.getInteger("start");
			Integer length = pd.getInteger("length");
			pd.put("start", start);
			pd.put("length", length);
			List<SysOperateLog> list = logService.selectList(pd);
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(pd.getInteger("count"));	
				
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, pd.getInteger("count"));
				result.put(Const.RECORDSFILTERED, pd.getInteger("count"));
			}
		} catch (Exception e) {
			logger.error("list log error", e);
		}
		return result;
	}
	
	@RequestMapping(value="/view")
	@ResponseBody
	public ModelAndView view(){
		SysOperateLog log = new SysOperateLog();
		try {
			PageData pd = super.getPageData();
			log = logService.view(pd);
		} catch (Exception e) {
			logger.error("add log error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("log", log);
		mv.setViewName("sys/log/log_view");
		return mv;
	}
	
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam long logId){
		PageData result = new PageData();
		try {
			Integer line = logService.delete(logId);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
		} catch (Exception e) {
			logger.error("delete log error", e);
			result.put("status", 0);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/batchDelete")
	@ResponseBody
	public PageData batchDelete(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			int length = pd.getString("ids").split(",").length;
			Integer line = logService.batchDelete(pd);
			if(line<length){
				result.put("status", 0);
				result.put("msg", "成功【"+line+"】条,失败【"+(length-line)+"】条");
			}else{
			result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("batch delete log error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	
}



