package com.nj.admin.controller;

import com.nj.core.base.controller.BaseController;
import com.nj.core.base.util.DataTableResult;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class PriceController
  extends BaseController
{
  @RequestMapping(value={"/goStock"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView goStockIndex()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("stock/list");
    return mv;
  }
  
  @RequestMapping(value={"/getPriceData"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public DataTableResult getPriceData(HttpServletRequest request)
  {
    DataTableResult result = new DataTableResult(request);
    try
    {
      HttpSession session = request.getSession();
      List<PriceModel> list = (List)session.getAttribute("priceList");
      if ((list != null) && (list.size() > 0)){
        Collections.sort(list);
        result.insertDataList(list);
        result.setTotalCount(10);
        result.put("draw", "draw");
        result.put("recordsTotal", Integer.valueOf(10));
        result.put("recordsFiltered", Integer.valueOf(10));
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return result;
  }
  
  @RequestMapping({"savePrice"})
  public String savePrice(HttpServletRequest request, String type, String stockNo, String price)
  {
    HttpSession session = request.getSession();
    List<PriceModel> mapList = (List)session.getAttribute("priceList");
    if (mapList == null) {
      mapList = new ArrayList();
    }
    List<String> list = generateSpec(type);
    for (int i = 0; i < list.size(); i++)
    {
      PriceModel map2 = new PriceModel();
      map2.setId(UuidUtil.get32UUID());
      map2.setStockNo(stockNo);
      map2.setPrice(price);
      map2.setSpec((String)list.get(i));
      mapList.add(map2);
    }
    session.setAttribute("priceList", mapList);
    return "200";
  }
  
  private List<String> generateSpec(String type)
  {
    List<String> specList = new ArrayList();
    if (type.equals("1"))
    {
      specList.add("39");
      specList.add("40");
      specList.add("41");
      specList.add("42");
      specList.add("43");
      specList.add("44");
      specList.add("45");
    }
    else if (type.equals("2"))
    {
      specList.add("36");
      specList.add("37");
      specList.add("38");
      specList.add("39");
      specList.add("40");
    }
    else if (type.equals("3"))
    {
      specList.add("36");
      specList.add("37");
      specList.add("38");
      specList.add("39");
      specList.add("40");
      specList.add("41");
      specList.add("42");
      specList.add("43");
      specList.add("44");
      specList.add("45");
    }
    else if (type.equals("4"))
    {
      specList.add("XS");
      specList.add("S");
      specList.add("M");
      specList.add("L");
      specList.add("XL");
      specList.add("2XL");
    }
    else if (type.equals("5"))
    {
      specList.add("XS");
      specList.add("S");
      specList.add("M");
      specList.add("L");
      specList.add("XL");
    }
    else if (type.equals("6"))
    {
      specList.add("30");
      specList.add("31");
      specList.add("32");
      specList.add("33");
      specList.add("34");
      specList.add("35");
      specList.add("36");
      specList.add("37");
      specList.add("38");
      specList.add("39");
      specList.add("40");
    }
    return specList;
  }
  
  @RequestMapping({"clearData"})
  public String clearData(HttpServletRequest request)
  {
    request.getSession().removeAttribute("priceList");
    return "200";
  }
  
  @RequestMapping(value={"/exportPriceData"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public String exportPriceData(HttpServletRequest reqst, HttpServletResponse response)
  {
    try
    {
      HttpSession session = reqst.getSession();
      List<PriceModel> retList = (List)session.getAttribute("priceList");
      Collections.sort(retList);
      List<PriceModel> priceModels = new ArrayList();
      for (PriceModel priceModel : retList) {
        priceModels.add(priceModel);
      }
      StringBuilder tempfilename = new StringBuilder();
      tempfilename.append("改价表格.xlsx");
      ExportUtil.baseExport(priceModels, PriceModel.class, tempfilename.toString(), "改价表格", "改价表格", response);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return "导出成功";
  }
  
  @RequestMapping({"/deletePrice"})
  @ResponseBody
  public PageData deletePrice(HttpServletRequest request, @RequestParam String id)
  {
    PageData result = new PageData();
    try
    {
      HttpSession session = request.getSession();
      List<PriceModel> mapList = (List)session.getAttribute("priceList");
      PriceModel pd = null;
      for (PriceModel priceModel : mapList) {
        if (priceModel.getId().equals(id)) {
          pd = priceModel;
        }
      }
      if (pd != null)
      {
        mapList.remove(pd);
        result.put("status", Integer.valueOf(1));
      }
      else
      {
        result.put("status", Integer.valueOf(0));
      }
    }
    catch (Exception e)
    {
      result.put("status", Integer.valueOf(0));
      result.put("msg", "删除失败");
    }
    return result;
  }
  
  @RequestMapping(value={"/editPrice"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView toEdit(HttpServletRequest request, @RequestParam String id)
    throws Exception
  {
    PriceModel priceModelTemp = null;
    try
    {
      HttpSession session = request.getSession();
      List<PriceModel> mapList = (List)session.getAttribute("priceList");
      for (PriceModel priceModel : mapList) {
        if (priceModel.getId().equals(id)) {
          priceModelTemp = priceModel;
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    ModelAndView mv = new ModelAndView();
    mv.addObject("priceModel", priceModelTemp);
    mv.setViewName("price/edit");
    return mv;
  }
  
  @RequestMapping(value={"/addPrice"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView toEdit()
    throws Exception
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("price/add");
    return mv;
  }
  
  @RequestMapping(value={"/addPrice"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public PageData addPrice(HttpServletRequest request, String spec, String stockNo, String price)
  {
    PageData result = super.getPageData();
    try
    {
      HttpSession session = request.getSession();
      List<PriceModel> mapList = (List)session.getAttribute("priceList");
      if (mapList == null) {
        mapList = new ArrayList();
      }
      PriceModel priceModel = new PriceModel();
      priceModel.setId(UuidUtil.get32UUID());
      priceModel.setStockNo(stockNo);
      priceModel.setSpec(spec);
      priceModel.setPrice(price);
      mapList.add(priceModel);
      session.setAttribute("priceList", mapList);
      result.put("status", Integer.valueOf(1));
    }
    catch (Exception e)
    {
      e.printStackTrace();
      result.put("status", Integer.valueOf(0));
      result.put("msg", "更新失败");
    }
    return result;
  }
  
  @RequestMapping(value={"/editPrice"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public PageData edit(HttpServletRequest request, String id, String spec, String stockNo, String price)
  {
    PageData result = super.getPageData();
    try
    {
      HttpSession session = request.getSession();
      List<PriceModel> mapList = (List)session.getAttribute("priceList");
      for (PriceModel priceModel : mapList) {
        if (priceModel.getId().equals(id))
        {
          priceModel.setStockNo(stockNo);
          priceModel.setSpec(spec);
          priceModel.setPrice(price);
        }
      }
      result.put("status", Integer.valueOf(1));
    }
    catch (Exception e)
    {
      e.printStackTrace();
      result.put("status", Integer.valueOf(0));
      result.put("msg", "更新失败");
    }
    return result;
  }
}
