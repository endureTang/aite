package com.nj.enterprise.interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.nj.model.generate.NjAcceptThresholds;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductScope;

public class TemplateXMLInfo extends ITemplate{

	private final String KEY_BASICCONFIGURATION = "prodBasicInfo";
	private final String KEY_CHANNELCONFIGURATION = "channelConf";
	private final String KEY_BUSINESSCONFIGURATION = "businessConf";
	private final String KEY_ORDERCONFIGURATION = "orderConf";
	private final String KEY_RELEASECONFIGURATION = "publishConf";
	
	public static final int BASICCONFIGURATION_ZLSZ = 1;
	
	
	
	Map<String,Object> mMap;
	
	public TemplateXMLInfo(Map<String,Object> mMap) {
		// TODO Auto-generated method stub
		this.mMap = mMap;
	}

	@Override
	public Object getBasicConfiguration() {
		// TODO Auto-generated method stub
		NjProduct pro = new NjProduct();
		Map map = (Map<String, Object>) mMap.get(KEY_BASICCONFIGURATION);
		if(map != null){
			pro.setProductName(map.get("productName").toString());
			pro.setProductDescription(map.get("productDescription").toString());
		}
		return pro;
	}

	@Override
	public Object getChannelConfiguration() {
		// TODO Auto-generated method stub
		List<NjProductScope> list = new ArrayList<>();
		
//		Map map = (Map<String, Object>) mMap.get(KEY_CHANNELCONFIGURATION);
//		if(map != null){
//			NjProduct pro = new NjProduct();
//			pro.setProductName(map.get("productName").toString());
//			pro.setProductDescription(map.get("productDescription").toString());
//			
//			return pro;
//		}
		
		return "";
	}

	@Override
	public Object getBusinessConfiguration(int type) {
		// TODO Auto-generated method stub
		
		Map map = (Map<String, Object>) mMap.get(KEY_BUSINESSCONFIGURATION);
		if(map != null){
			if(type == 0){
				List<Object> list = new ArrayList<>();
				if(map.containsKey("dataConfiguration") && map.get("dataConfiguration") != null){
					Map<String, Object> map1 = (Map<String, Object>) map.get("dataConfiguration");
					list.add(map1.get("identityAuthentication"));
					list.add(map1.get("personalData"));
					list.add(map1.get("jobInformation"));
					list.add(map1.get("contacts"));
					list.add(map1.get("carInfo"));
				}
				return list;
			} else if(type == 1){
				List<Object> list = new ArrayList<>();
				if(map.containsKey("creditSetting") && map.get("creditSetting") != null){
					Map<String, Object> map1 = (Map<String, Object>) map.get("creditSetting");
					list.add(map1.get("identityVerification"));
					list.add(map1.get("sesameCredit"));
					list.add(map1.get("mailList"));
				}
				return list;
			} else if(type == 2){
				List<Object> list = new ArrayList<>();
				if(map.containsKey("loanAllocation") && map.get("loanAllocation") != null){
					Map<String, Object> map1 = (Map<String, Object>) map.get("loanAllocation");
					list.add(map1.get("minimumLimit"));
					list.add(map1.get("maximumAmount"));
					list.add(map1.get("incrementalIncrease"));
					
					if(map1.containsKey("optionalPeriod") && map1.get("optionalPeriod") != null){
						list.add(map1.get("optionalPeriod"));
					}
				}
				return list;
			} 
		}
		return "";
	}

	@Override
	public Object getOrderConfiguration() {
		// TODO Auto-generated method stub
		Map map = (Map<String, Object>) mMap.get(KEY_ORDERCONFIGURATION);
		if(map != null){
			if(map.containsKey("roleList") && map.get("roleList") != null){
				Map map1 = (Map) map.get("roleList");
				if(map1 != null){
					return map1.get("item");
				}
			}
		}
		return null;
	}

	@Override
	public Object getReleaseConfiguration(int type) {
		// TODO Auto-generated method stub
		Map map = (Map<String, Object>) mMap.get(KEY_RELEASECONFIGURATION);
		if(map != null){
			if(type == 0){
				List<Object> list = new ArrayList<>();
				if(map.containsKey("applicationArea") && map.get("applicationArea") != null){
					return map.get("applicationArea");
				}
				return null;
			} else if(type == 1){
				if(map.containsKey("applicationUserSettings") && map.get("applicationUserSettings") != null){
					return map.get("applicationUserSettings");
				}
				return "";
			} else if(type == 2){
				List<Object> list = new ArrayList<>();
				if(map.containsKey("onlineClassification") && map.get("onlineClassification") != null){
					return map.get("onlineClassification");
				}
				return null;
			} 
		}
		return null;
	}
	
	
	

}
