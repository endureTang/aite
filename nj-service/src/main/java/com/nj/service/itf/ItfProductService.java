package com.nj.service.itf;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.common.Constants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.PageData;
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjProductMapper;
import com.nj.dao.NjProductTransactionRelativeMapper;
import com.nj.dao.SysDictMapper;
import com.nj.dao.extend.NjChannelRelativeMapperExtend;
import com.nj.dao.extend.NjProductChannelMapperExtend;
import com.nj.dao.extend.NjProductMapperExtend;
import com.nj.dao.extend.NjProductPurposeMapperExtend;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjLoanOrderExample;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductExample;
import com.nj.model.generate.NjProductTransactionRelative;
import com.nj.model.generate.NjProductTransactionRelativeExample;
import com.nj.model.generate.SysDict;
import com.nj.model.generate.SysDictExample;

@Transactional(readOnly = true)
@Service("itfProductService")
public class ItfProductService {
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	private static Logger logger = LoggerFactory.getLogger(ItfProductService.class);
	
	public List<NjProduct> getProductByCode( String value) throws Exception{
		NjProductMapper sm = dao.getMapper(NjProductMapper.class);
		NjProductExample example = new NjProductExample();
		example.createCriteria().andProductCodeEqualTo(value);
		return sm.selectByExample(example);
	}
	
	public Map<String,Object> getProductDetailById(String value) throws Exception{
		if(value == null || value.isEmpty())
			return null;
		NjProductMapperExtend sm=dao.getMapper(NjProductMapperExtend.class);
		PageData pd = new PageData();
		pd.put("id", value);

		Map<String,Object> ret= sm.getProductDetailById(pd);
		try{
			ret.put("applyNum", getProdApplyNum(value));
		}catch(Exception e){
			logger.error("获取申请次数失败",e);
		}
		return ret;
	}
	
	public List<Map> getProductPurposesById(String id) throws Exception{
		NjProductPurposeMapperExtend sm = dao.getMapper(NjProductPurposeMapperExtend.class);
		return sm.getProductPurposesById(id);
	}
	
	public List<Map> getProductPeriodsByProdId(@Param("productId") String productId) throws Exception{
		//List<Map> 
		//List<Map> periods =(List<Map>)EhCacheUtil.getInstance().get(EhCacheConstant.ITF.PRODUCT_PERIOD, productId);
//		if(periods!=null ){
//			return periods;
//		}
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		List<Map> periods= sm.getProductPeriodsByProdId(productId);
		//EhCacheUtil.getInstance().put(EhCacheConstant.ITF.PRODUCT_PERIOD, productId, periods);
		return periods;
	}
	
	public List<Map> getRecommandProducts(String areaCode, String companyCode, String mobileNo, Integer num) throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		PageData pd = new PageData();
		if(!StringUtils.isBlank(areaCode)){
			pd.put("areaCode", areaCode);
		}
		if(!StringUtils.isBlank(companyCode)){
			pd.put("companyCode", companyCode);
		}
		if(!StringUtils.isBlank(mobileNo)){
			pd.put("mobileNo", mobileNo);
		}
		if((num!=null) && num>0){
			pd.put("topnum", num);
		}
		else{
			pd.put("topnum", 99999);
		}
		pd.put("state", Constants.ProductState.ONLINE);
		List<Map> result= sm.getRecommandProducts(pd);
		if(result!=null && !result.isEmpty()){
			for(Map<Object,Object> item: result){
				String productId = (String)item.get("productId");
				item.put("companyName", getProductCompanyName(productId));
				//获取产品期限
				List<Map> periods = getProductPeriodsByProdId(productId);
				int minPeriod=0;
				int maxPeriod=0;
				if(periods!=null && !periods.isEmpty()){
					for(Map<Object,Object> m:periods){
						int pe = new Integer((String)m.get("period"));
						if(minPeriod >pe){
							minPeriod=pe;
						}
						if(maxPeriod<pe){
							maxPeriod=pe;
						}
					}
					item.put("minPeriod", minPeriod);
					item.put("maxPeriod", maxPeriod);
				}
			}
		}
		return result;
	}
	
	public List<Map> getRecommandProductsNew(String areaCode, String companyCode, String mobileNo, Integer num) throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		PageData pd = new PageData();
		if(!StringUtils.isBlank(areaCode)){
			pd.put("areaCode", areaCode);
		}
		if(!StringUtils.isBlank(companyCode)){
			pd.put("companyCode", companyCode);
		}
		if(!StringUtils.isBlank(mobileNo)){
			pd.put("mobileNo", mobileNo);
		}
		if((num!=null) && num>0){
			pd.put("topnum", num);
		}
		else{
			pd.put("topnum", 99999);
		}
		pd.put("state", Constants.ProductState.ONLINE);
		List<Map> result= sm.getRecommandProducts(pd);
		if(result!=null && !result.isEmpty()){
			for(Map<Object,Object> item: result){
				String productId = (String)item.get("productId");
				item.put("companyName", getProductCompanyName(productId));
				//获取产品期限
				List<Map> periods = getProductPeriodsByProdId(productId);
				int minPeriod=0;
				int maxPeriod=0;
				if(periods!=null && !periods.isEmpty()){
					for(Map<Object,Object> m:periods){
						int pe = new Integer((String)m.get("period"));
						if(minPeriod >pe){
							minPeriod=pe;
						}
						if(maxPeriod<pe){
							maxPeriod=pe;
						}
					}
					item.put("minPeriod", minPeriod);
					item.put("maxPeriod", maxPeriod);
				}
			}
		}
		return result;
	}
	
	public NjProduct getProductById(String productId) throws Exception{
		NjProductMapper sm = dao.getMapper(NjProductMapper.class);
		return sm.selectByPrimaryKey(productId);
	}
	
	public List<SysDict> getProductType() throws Exception{
		SysDictMapper  mapper = dao.getMapper(SysDictMapper.class);
		SysDictExample example = new SysDictExample();
		example.createCriteria().andTypeEqualTo(Constants.SYS_DICT.TYPE_PRODUCT)
		.andDelFlagEqualTo(false);
		return mapper.selectByExample(example);
	}
	
	public Integer getProductCount(NjAppUser user, String positionCode, Integer positionType,
					String productTypeCode) throws Exception{
		if(positionType==1){
			return getProductCountWithCompanyCode(user,positionCode, productTypeCode);
		}
		else{
			return getProductCountWithAreaCode(user,positionCode, productTypeCode);
		}
	}
		
	public List<Map> getProductList(NjAppUser user, String positionCode, Integer positionType,
					String productTypeCode, Integer page, Integer pageNum) throws Exception{
		List<Map> result;
		if(positionType==1){
			result= getProductListWithCompanyCode(user,positionCode, productTypeCode, page, pageNum);
		}
		else{
			result= getProductListWithAreaCode(user,positionCode, productTypeCode, page, pageNum);
		}
	
		if(result!=null && !result.isEmpty()){
			for(Map<Object,Object> item: result){
				String productId = (String)item.get("productId");
				item.put("companyName", getProductCompanyName(productId));
				item.put("companyCode", getProductCompanyCode(productId));
				//获取申请人数
				try{
					item.put("applyNum", getProdApplyNum(productId));
				}catch(Exception e){
					logger.error("获取申请次数失败",e);
				}
				//获取产品标签
				try{
					item.put("tags", getProductTags(productId));
				}
				catch(Exception e){
					logger.error("获取产品标签失败",e);
				}
				//获取产品期限
				List<Map> periods = getProductPeriodsByProdId(productId);
				int minPeriod=-1;
				int maxPeriod=-1;
				if(periods!=null && !periods.isEmpty()){
					for(Map<Object,Object> m:periods){
						int pe = new Integer((String)m.get("period"));
						if(minPeriod == -1 || minPeriod>pe){
							minPeriod=pe;
						}
						if(maxPeriod<pe){
							maxPeriod=pe;
						}
					}
					item.put("minPeriod", minPeriod);
					item.put("maxPeriod", maxPeriod);
				}
			}
		}
		return result;
	}
	
	public Integer getProductCountWithCompanyCode(NjAppUser user, String companyCode,
			String productTypeCode) throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		if(user ==null){
			return sm.getProductCount(null,StringUtils.isEmpty(companyCode)?null:companyCode ,null, productTypeCode, 
					Constants.ProductState.ONLINE);
		}
		else{
			return sm.getProductCount(user.getMobile(),StringUtils.isEmpty(companyCode)?null:companyCode,null,productTypeCode,
					 Constants.ProductState.ONLINE);
		}
	}
	
	public Integer getProductCountWithAreaCode(NjAppUser user, String areaCode,
			String productTypeCode) throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		if(user ==null){
			return sm.getProductCount(null,null,StringUtils.isEmpty(areaCode)?null:areaCode, productTypeCode,
					Constants.ProductState.ONLINE);
		}
		else{
			return sm.getProductCount(user.getMobile(),null,StringUtils.isEmpty(areaCode)?null:areaCode, productTypeCode, 
					Constants.ProductState.ONLINE);
		}
	}
	
	public List<Map> getProductListWithCompanyCode(NjAppUser user, String companyCode,
			String productTypeCode, Integer page, Integer pageNum) throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		if(user ==null){
			return sm.getProductList(null,StringUtils.isEmpty(companyCode)?null:companyCode ,null, productTypeCode, 
					page, pageNum, Constants.ProductState.ONLINE);
		}
		else{
			return sm.getProductList(user.getMobile(),StringUtils.isEmpty(companyCode)?null:companyCode,null,productTypeCode,
					page, pageNum, Constants.ProductState.ONLINE);
		}
	}
	
	public List<Map> getProductListWithAreaCode(NjAppUser user, String areaCode,
			String productTypeCode, Integer page, Integer pageNum)throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		if(user ==null){
			return sm.getProductList(null,null,StringUtils.isEmpty(areaCode)?null:areaCode, productTypeCode,
					page, pageNum,Constants.ProductState.ONLINE);
		}
		else{
			return sm.getProductList(user.getMobile(),null,StringUtils.isEmpty(areaCode)?null:areaCode, productTypeCode, 
					page, pageNum, Constants.ProductState.ONLINE);
		}
	}
	
	public List<Map> getProductCompanyMap(String productId) throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		return  sm.getProductCompanyMap( productId);

	}
	
	public String getProductCompanyName(String productId) throws Exception{
		List<Map> result = getProductCompanyMap(productId);
		if(result == null || result.isEmpty())
			return null;
		return (String) result.get(0).get("companyName");
	}
	
	public String getProductCompanyCode(String productId) throws Exception{
		List<Map> result = getProductCompanyMap(productId);
		if(result == null || result.isEmpty())
			return null;
		return (String) result.get(0).get("companyCode");
	}
	
	public List<Map> getProductAcceptStepsById(String productId) throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		return sm.getAcceptStepsById(productId);
	}
	
	public List<Map> getAdvertisement() throws Exception{
		NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
		List<Map> result= sm.getAdvertisement();
		if((result!= null) && (!result.isEmpty())){
			for(int i=0; i<result.size(); i++){
				Map<?, ?>item= result.get(i);
				if(1==(Integer)(item.get("type"))){
					String prodId =(String) item.get("businessId");
					NjProduct prod = getProductById(prodId);
					if(prod!=null ){
						if(prod.getDelFlag()==true
								|| prod.getState() !=Constants.ProductState.ONLINE){
							result.remove(i);
						}
					}
				}
			}
		}
		return result;
	}
	
	public Long getProdApplyNum(String prodId) throws Exception{
		if(StringUtils.isEmpty(prodId)){
			return null;
		}
		NjLoanOrderMapper mapper = dao.getMapper(NjLoanOrderMapper.class) ;
		NjLoanOrderExample example = new NjLoanOrderExample();
		example.createCriteria().andProductIdEqualTo(prodId);
		return Long.valueOf(mapper.countByExample(example));
	}
	
	public List<Map> getProductChannelsById(String prodId) throws Exception{
		if(StringUtils.isEmpty(prodId)){
			return null;
		}
		
		List<Map> l= (List<Map>)EhCacheUtil.getInstance().get(EhCacheConstant.ITF.PRODUCT_CHANNEL, prodId);
		if(l != null)
			return l;
		NjProductChannelMapperExtend sm = dao.getMapper(NjProductChannelMapperExtend.class);
		NjChannelRelativeMapperExtend sm2 = dao.getMapper(NjChannelRelativeMapperExtend.class);
		List<Map> prodChannels =  (List<Map>)sm.getAllChannelsByProdId(prodId);
		if(prodChannels!=null && !prodChannels.isEmpty()){
			for(Map<String,Object>item:prodChannels){
				List<Map> relChannels =sm2.getLByChannelId(item.get("id").toString());
				List<Map> subChannels = new ArrayList<Map>(0);
				List<Map> channelOperators = new ArrayList<Map>(0);
				
				for(Map<String,Object>relItem:relChannels){
					if(((Integer)relItem.get("account_type")).equals(1)){//专员
						Map<String,Object> m = new HashMap<String,Object>();
						m.put("id", relItem.get("id"));
						m.put("commissionerName", relItem.get("name"));
						m.put("commissionerPhone", relItem.get("channel_acct"));
						channelOperators.add(m);
					}
					else{//关联渠道
						Map<String,Object> m =new HashMap<String,Object>();
						m.put("id", relItem.get("id"));
						m.put("channelCode", relItem.get("channel_acct"));
						m.put("channelName", relItem.get("name"));
						//获取subChannelId后需要获取他的用户名
						//m.put("c", value)
						subChannels.add(m);
					}
				}
				item.put("channelCommissionerList", channelOperators);
				item.put("subChannelList", subChannels);
			}
			EhCacheUtil.getInstance().put(EhCacheConstant.ITF.PRODUCT_CHANNEL, prodId,prodChannels);
		}
		return prodChannels;
		
	}
	
	public List<String> getProductTags(String prodId) throws Exception{
		if(StringUtils.isEmpty(prodId)){
			return null;
		}
		
		List<String> l= (List<String>)EhCacheUtil.getInstance().get(EhCacheConstant.ITF.PRODUCT_TAG, prodId);
		if(l==null){
			//获取产品标签
			NjProductMapperExtend sm = dao.getMapper(NjProductMapperExtend.class);
			l=sm.getProductTag(prodId);
			if(l!=null)
				EhCacheUtil.getInstance().put(EhCacheConstant.ITF.PRODUCT_TAG, prodId, l);
		}
		return l;
	}
	
	public Integer getSupportLoanMode(String prodId) throws Exception{
		if(StringUtils.isEmpty(prodId)){
			return null;
		}
		NjProductTransactionRelativeMapper mapper = dao.getMapper(NjProductTransactionRelativeMapper.class);
		NjProductTransactionRelativeExample exp = new NjProductTransactionRelativeExample();
		exp.createCriteria().andProductIdEqualTo(prodId);
		List<NjProductTransactionRelative> items = mapper.selectByExample(exp);
		int result = 0;
		if(items == null){
			return result;
		}
		for(NjProductTransactionRelative i:items){
			if(i.getTransactionType().equals("1")//支持天府财富账号模式
					|| i.getTransactionType().equals("2")){
				result = result  | 0x0001;
			}
			if(i.getTransactionType().equals("0")){//支持线下放款账号模式
				result = result  | 0x0002;
			}
		}
		return result;
		
	}
	
	
}
