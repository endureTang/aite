package com.nj.admin.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nj.core.base.common.Constants;
import com.nj.core.base.controller.BaseController;
import com.nj.core.base.entity.ResourcesAnnotion;
import com.nj.core.base.util.Const;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjProductCycleMapper;
import com.nj.model.generate.NjProductCycle;
import com.nj.model.generate.NjProductCycleExample;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysUser;
import com.nj.service.base.system.DictService;
import com.nj.service.base.system.RoleService;

/**
 * @FileName RoleController.java
 * @Description: 
 *
 * @Date 2015年5月9日 
 * @author dzk
 * @version 1.0
 * 
 */
@Controller
@RequestMapping(value = "/dict")
public class DictController extends BaseController {

	private static Logger logger = LoggerFactory.getLogger(DictController.class);
	
	@Resource(name = "dictService")
	private DictService dictService;
	
	@ResourcesAnnotion(uri="/dict/page",name="字典列表",resourceType=1,parentId="3")
	@RequestMapping(value="/page")
	public ModelAndView page(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/dict/dict_list");
		return mv;
	}
	@RequestMapping(value="/list")
	@ResponseBody
	public DataTableResult list(HttpServletRequest request){
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			List<SysDict> list = dictService.list(pd);
			int allCount = dictService.listAllCount(pd);
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(allCount);	
				
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, allCount);
				result.put(Const.RECORDSFILTERED, allCount);
			}
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return result;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView toAdd(){
		ModelAndView mv = super.getModelAndView();
		mv.setViewName("sys/dict/dict_add");
		return mv;
	}
	
	@RequestMapping(value="/addCustom", method=RequestMethod.GET)
	@ResponseBody
	public PageData addCustom(){
		PageData result = new PageData();
		try {
			for(int i = 37; i < 61; i++){
				SysDict dict = new SysDict();
				dict.setType("CPDKKXQX");
				dict.setLabelText(i+"期");
				dict.setValue(i+"");
				dict.setSort(BigDecimal.valueOf(i));
				dict.setDescription("");
				dictService.add(dict);
			}
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add role error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	@RequestMapping(value="/addCustom1", method=RequestMethod.GET)
	@ResponseBody
	public PageData addCustom1(){
		PageData result = new PageData();
		try {
			String str = "7680be42813941a69d2f581db2e09c1a";
			List<NjProductCycle> list1 = new ArrayList<>();
			List<SysDict> list4 = dictService.getListByType(Constants.SYS_DICT.TYPE_CPDKKXQX);
			for (SysDict string : list4) {
				NjProductCycle npc = new NjProductCycle();
				npc.setId(UuidUtil.get32UUID());
				npc.setProductId(str);
				npc.setSysId(string.getId());
				npc.setThreType(0);
				list1.add(npc);
			}
			
			dictService.gets(str, list1);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("add role error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	@ResponseBody
	public PageData add(SysDict dict){
		PageData result = new PageData();
		try {
			long count = dictService.getCount(dict);
			if(count == 0){
				dictService.add(dict);
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "新增失败,已经有重复的值");
			}
		} catch (Exception e) {
			logger.error("add role error", e);
			result.put("status", 0);
			result.put("msg", "新增失败");
		}
		return result;
	}
	
	
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView toEdit(@RequestParam String id){
		SysDict pd = null;
		try {
			pd = dictService.getById(id);
		} catch (Exception e) {
			logger.error("get role error", e);
		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/dict/dict_edit");
		return mv;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	@ResponseBody
	public PageData edit(SysDict dict){
		PageData result = new PageData();
		try {
			dictService.edit(dict);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit role error", e);
			result.put("status", 0);
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	@RequestMapping(value="/delete")
	@ResponseBody
	public PageData delete(@RequestParam String id){
		PageData result = new PageData();
		try {
			Integer line = dictService.delete(id);
			if(line>0){
				result.put("status", 1);
			}else{
				result.put("status", 0);
				result.put("msg", "删除失败或者为不可删除状态");
			}
		} catch (Exception e) {
			logger.error("delete role error", e);
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
			Integer line =dictService.batchDelete(pd);
			if(line<length){
				result.put("status", 0);
				result.put("msg", "成功【"+line+"】条,失败【"+(length-line)+"】条");
			}else{
			result.put("status", 1);
			}
		} catch (Exception e) {
			logger.error("batch delete role error", e);
			result.put("status", 0);
			result.put("msg", "批量删除失败");
		}
		return result;
	}
	
	@RequestMapping(value="/editRight", method=RequestMethod.GET)
	public ModelAndView toEditRight(@RequestParam String id){
		PageData pd = null;
//		try {
//			pd = dictService.getById(id);
//		} catch (Exception e) {
//			logger.error("to edit right error", e);
//		}
		ModelAndView mv = super.getModelAndView();
		mv.addObject("pd", pd);
		mv.setViewName("sys/dict/dict_right_edit");
		return mv;
	}
	
	@RequestMapping(value="/resNodes")
	@ResponseBody
	public List<PageData> resNodes(@RequestParam Integer id){
		List<PageData> treeData = null;
		try {
			treeData = dictService.listTreeData(id);
		} catch (Exception e) {
			logger.error("get res nodes error", e);
			treeData = new ArrayList<PageData>();
		}
		return treeData;
	}
	
	@RequestMapping(value="/editRight", method=RequestMethod.POST)
	@ResponseBody
	public PageData editRight(){
		PageData result = new PageData();
		try {
			PageData pd = super.getPageData();
			dictService.editRight(pd);
			result.put("status", 1);
		} catch (Exception e) {
			logger.error("edit right error", e);
			result.put("status", 0);
			result.put("msg", "编辑权限失败");
		}
		return result;
	}

	@RequestMapping(value="/getYTPZ")
	@ResponseBody
	public List getYTPZ(HttpServletRequest request){
		List<SysDict> list = null;
		DataTableResult result = new DataTableResult(request);
		try {
			PageData pd = super.getPageData();
			list = dictService.getListByType("YTPZ");
			if(list != null && list.size() > 0){
				result.insertDataList(list);
				result.setTotalCount(list.size());
				
				result.put(Const.DRAW, pd.getString(Const.DRAW));
				result.put(Const.RECORDSTOTAL, list.size());
				result.put(Const.RECORDSFILTERED, list.size());
			}
		} catch (Exception e) {
			logger.error("list role error", e);
//			result = new PageData();
		}
		return list;
	}
}
