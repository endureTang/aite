package com.nj.service.enterprise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.nj.core.base.dao.BaseDao;
import com.nj.dao.extend.NjOrderHouseMapperExtend;

@Service("orderHouseService")
public class OrderHouseService {

	@Resource(name="BaseDao")
	private BaseDao dao;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map<String,Object>> getOrderHousesByOrderId(String orderId) throws Exception{
		
		NjOrderHouseMapperExtend ohm = dao.getMapper(NjOrderHouseMapperExtend.class);
		List<Map> map = ohm.getOrderHousesByOrderId(orderId);
		
		Map<String,Map<String,Object>> resultMap = new HashMap<String,Map<String,Object>>();
		
		for (Map temp : map) {
			String houseId = (String) temp.get("houseId");
			Map<String,Object> houseMap = resultMap.get(houseId);
			if(null == houseMap){
				houseMap = new HashMap<String,Object>();
				resultMap.put(houseId, houseMap);
				
				houseMap.put("houseId", houseId);
				houseMap.put("name", temp.get("name"));
				houseMap.put("price", temp.get("price"));
				houseMap.put("address", temp.get("address"));
			}
			
			Object filePathList = houseMap.get("filePath");
			if(null == filePathList){
				filePathList = new ArrayList<String>();
				houseMap.put("filePath", filePathList);
			}
			List<String> filePathList2 = (List<String>) filePathList;
			if(null != temp.get("filePath")){
				filePathList2.add(temp.get("filePath").toString());
			}
		}
		
		return new ArrayList(resultMap.values());
	}
}
