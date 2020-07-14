package com.nj.service.enterprise;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nj.core.base.util.FileOperationUtil;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjOrderContractMapper;
import com.nj.dao.NjProductContractTemplateMapper;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjOrderContractMapperExtend;
import com.nj.model.generate.NjOrderContract;
import com.nj.model.generate.NjOrderContractExample;
import com.nj.model.generate.NjProductContractTemplate;

@Service("orderContractService")
public class OrderContractService {

	@Autowired
	private NjOrderContractMapper NjOrderContractMapper;
	
	@Autowired
	private NjProductContractTemplateMapper njProductContractTemplateMapper;

	@Autowired
	private NjOrderContractMapperExtend NjOrderContractMapperExtend;
	
	@Autowired
	private NjLoanOrderMapperExtend njLoanOrderMapperExtend;

	/**
	 * 根据订单编号获取合同模板
	 */
	public List<Map> getContractTemplateByOrderNo(String orderNo) {
		return NjOrderContractMapperExtend.getContractTemplateByOrderNo(orderNo);
	}
	
	/**
	 * 根据订单id获取合同模板
	 */
	public List<Map> getContractTemplateByOrderId(String orderId) {
		return NjOrderContractMapperExtend.getContractTemplateByOrderId(orderId);
	}
	
	/**
	 * 根据合同模板id获取合同
	 */
	public NjProductContractTemplate getContractTemplateById(String id){
		return njProductContractTemplateMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据订单编号获取合同
	 */
	public List<NjOrderContract> getContractByOrderNo(String orderNo) {
		NjOrderContractExample example = new NjOrderContractExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		return NjOrderContractMapper.selectByExample(example);
	}
	
	/**
	 * 根据订单编号获取合同Map,合同管理获取合同列表用
	 */
	public List<Map> getContractMapByOrderNo(String orderNo) {
		return NjOrderContractMapperExtend.getContractMapByOrderNo(orderNo);
	}
	
	/**
	 * 根据id获取合同
	 */
	public NjOrderContract getContractById(String contractId){
		return NjOrderContractMapper.selectByPrimaryKey(contractId);
	}
	
	/**
	 * 删除合同
	 */
	@Transactional(rollbackFor={Throwable.class},readOnly=false)
	public void deleteContractById(String contractId,String orderContractRootDir){
		
		NjOrderContract contract = NjOrderContractMapper.selectByPrimaryKey(contractId);
		if(null != contract){
			String filePath = orderContractRootDir + contract.getUrl();
			File file = new File(filePath);
			if(file.exists()){
				file.delete();
			}
		}
		NjOrderContractMapper.deleteByPrimaryKey(contractId);
	}

	/**
	 * 上传订单合同
	 * 
	 * @param file
	 * @param path
	 *            文件存放的根目录
	 * @throws IOException
	 */
	public void uploadContract(MultipartFile file, String contractTemplateId, String orderNo, String rootPath,
			String operUserId) throws IOException {
		
		NjOrderContractExample example = new NjOrderContractExample();
		example.createCriteria().andOrderNoEqualTo(orderNo).andContractTemplateIdEqualTo(contractTemplateId);
		List<NjOrderContract> conList = NjOrderContractMapper.selectByExample(example);
		
		String originalName = file.getOriginalFilename();
		String filePath = FileOperationUtil.uploadFile2(rootPath, file.getInputStream(), originalName.split("\\.")[1]);
		
		if(CollectionUtils.isEmpty(conList)){
			NjOrderContract oc = new NjOrderContract();
			oc.setId(UuidUtil.get32UUID());
			oc.setOrderNo(orderNo);
			oc.setUrl(filePath);
			oc.setContractTemplateId(contractTemplateId);
			oc.setContractName(originalName);
			oc.setCreateBy(operUserId);
			oc.setCreateDate(new Date());
			oc.setUpdateBy(operUserId);
			oc.setUpdateDate(new Date());
			NjOrderContractMapper.insert(oc);
		}else{
			NjOrderContract oc = conList.get(0);
			
			//删除原文件
			File oldFile = new File(rootPath + oc.getUrl());
			oldFile.delete();
			
			oc.setUrl(filePath);
			oc.setContractName(originalName);
			oc.setUpdateBy(operUserId);
			oc.setUpdateDate(new Date());
			NjOrderContractMapper.updateByPrimaryKey(oc);
		}
	}
	
	/**
	 * 根据订单编号获取生成合同所需的信息            *********
	 */
	public Map<String, Object> getContractTempInfo(String orderId){
		Map<String, Object> map = njLoanOrderMapperExtend.getOrderInfo(orderId);
		String monthRate = "";
		for (Entry<String, Object> entry : map.entrySet()) {
			if(entry.getKey().equals("yearRate")){
				Object yearRate = entry.getValue();
				if(null == yearRate){
					entry.setValue("");
				}else{
					monthRate = new BigDecimal(yearRate.toString()).divide(new BigDecimal(12)).setScale(6, RoundingMode.UP).toString();
				}
			}else{
				if(null == entry.getValue()){
					entry.setValue("");
				}else{
					entry.setValue(String.valueOf(entry.getValue()));
				}
			}
		}
		map.put("monthRate", monthRate);
		return map;
	}
}
