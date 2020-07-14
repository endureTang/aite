package com.nj.dao.extend;

import com.nj.core.base.util.PageData;
import com.nj.model.datamodel.NjProductModel;
import com.nj.model.generate.NjProduct;
import com.nj.model.generate.NjProductBusinessDict;
import com.nj.model.generate.NjProductChannel;
import com.nj.model.generate.NjProductChannelExample;
import com.nj.model.generate.SysOutsideApi;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface NjProductMapperExtend {
	
	List<Map> selectAllProductListPage(Map<?, ?> condition);

	List<Map> getProductsByCoporateId(PageData pd);
	
	List<Map> getProductsByUserId(PageData pd);

	int getProductsByCoporateIdCount(PageData pd);

	List<Map> getProductsByAdmin(PageData pd);
	
	List<Map> getProductsByCorpAdmin(PageData pd);

    int updateVisiableScope(NjProduct npp);
    
    Map<String,Object> getProductDetailById(PageData pd);
    
    List<Map> getProductPeriodsByProdId(@Param("productId") String productId);
    
    List<Map> getRecommandProducts(PageData pd);
    
    String getTemplateName(String productId);

    String getTemplateNameByTempId(String tempId);
    
    List<String> getProductTag(String prodId);
    
    List<Map> getProductListWithCompanyCode(@Param("mobileNo") String mobileNo, @Param("companyCode") String companyCode, 
    		@Param("productTypeCode") String productTypeCode, @Param("page")Integer page, @Param("pageNum") Integer pageNum);
    
    List<Map> getProductListWithAreaCode(@Param("mobileNo") String mobileNo, @Param("areaCode") String areaCode, @Param("productTypeCode") String productTypeCode, 
    		@Param("page") Integer page, @Param("pageNum") Integer pageNum);

    
    List<Map> getProductList(@Param("mobileNo") String mobileNo, @Param("companyCode")String companyCode, @Param("areaCode") String areaCode, @Param("productTypeCode") String productTypeCode, 
    		@Param("page") Integer page, @Param("pageNum") Integer pageNum, @Param("state") Integer state);
    
    List<Map> getProductCompanyMap(@Param("productId") String productId);
    
    //张海添加
    List<Map> getAcceptStepsById(@Param("productId") String productId);
    //张海添加
    List<Map> getAdvertisement();
    
    Integer getProductCount(@Param("mobileNo") String mobileNo, @Param("companyCode")String companyCode, @Param("areaCode") String areaCode, @Param("productTypeCode") String productTypeCode, 
    		@Param("state") Integer state);
    
    List<Map> getProductAuditParameters(PageData pd);
    
    int getProductState(@Param("id") String id);

    /**
     * 根据ID获取产品信息
     * @return
     */
	NjProduct getProductsById(@Param("id") String id);

	/**
	 * 获取app推荐产品
	 * @param paramMap
	 * @return
	 */
	List<NjProduct> selectProductList(Map<String, Object> paramMap);
	/**
	 * 根据产品id获取产品所需材料
	 * @param id
	 * @return
	 */
	String selectProductMaterial(@Param("productId") String productId ,@Param("materialParentIds") String materialParentIds);

	/**
	 * 清空产品模板中间表
	 * @param productId
	 */
	void deleteProductTemp(@Param("productId") String productId );
	
	Map<String, Object> getProductByOrderNo(@Param("orderNo") String orderNo );

	Map<String, Object> getChannelType(@Param("productId") String productId);

	List<Map<String, Object>> selectProductOutApiList(PageData pd);
	/**
	 * 获取产品拥有接口
	 * @param pd
	 * @return
	 */
	List<Map<String, Object>> selectProductApi(PageData pd);
	/**
	 * 获取所有接口列表
	 * @param pd
	 * @return
	 */
	List<Map<String, Object>> selectAllApi(PageData pd);
	/**
	 * 清除之前的数据
	 * @param productId
	 */
	void deleteProductApiByProductId(@Param("productId") String productId);

	/**
	 * 根据产品ID获取产品接口列表
	 * @param orderId
	 * @return
	 */
	List<SysOutsideApi> selectApiByOrderId(@Param("productId") String productId);

	long selectProductOutApiListCount(PageData pd);

	/**
	 * 获取产品当前最大编号
	 * @return
	 */
	String getMaxProductCode();
	
	List<Map<String,Object>> getProductBussinessDictByProductId(@Param("productId") String productId);
}