package com.nj.service.enterprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.nj.core.base.enums.ELoanOrderStatus;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjAppUserBusicommUpdateMapper;
import com.nj.dao.NjAppUserMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjProcessOrderFlowsMapper;
import com.nj.dao.NjUserBasicInfoMapper;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.extend.NjAppUserMapperExtend;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjAppUserBusicommUpdate;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjLoanOrderExample;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.model.generate.NjProcessOrderFlowsExample;
import com.nj.model.generate.NjUserBasicInfo;
import com.nj.model.generate.NjUserBasicInfoExample;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.vo.CustomerRelationListVo;

@Service("njAppUserService")
@Transactional(readOnly=true)
public class NjAppUserService {
	
	private static Logger logger = LoggerFactory.getLogger(NjAppUserService.class);

	@Autowired
	private NjAppUserMapperExtend njAppUserMapperExtend;
	@Autowired
	private NjAppUserMapper njAppUserMapper;
	@Autowired
	private NjProcessOrderFlowsMapper njProcessOrderFlowsMapper;
	@Autowired
	private NjLoanOrderMapper njLoanOrderMapper;
	@Autowired
	private NjUserInfoMapper njUserInfoMapper;
	@Autowired
	private NjAppUserBusicommUpdateMapper njAppUserBusicommUpdateMapper;
	@Autowired
	private NjUserBasicInfoMapper njUserBasicInfoMapper;
	
	/**
	 * 通过id获取NjAppUser
	 */
	public NjAppUser getById(String id){
		return njAppUserMapper.selectByPrimaryKey(id);
	}
	
	/**
	 * 获取NjAppUser的最新的NjUserBasicInfo信息
	 */
	public NjUserBasicInfo getbyUserId(String userId){
		NjUserBasicInfoExample ex = new NjUserBasicInfoExample();
		ex.createCriteria().andDelFlagEqualTo(false).andUserIdEqualTo(userId);
		ex.setOrderByClause("version desc");
		List<NjUserBasicInfo> list = njUserBasicInfoMapper.selectByExample(ex);
		if(CollectionUtils.isEmpty(list)){
			return null;
		}else{
			return list.get(0);
		}
	}
	
	/**
	 * 客户-关系管理的列表数据获取
	 */
	public List<CustomerRelationListVo> getCustomerRelationListVo(PageData param){
		return njAppUserMapperExtend.getCustomerRelationListVo(param);
	}
	
	/**
	 * 更换客户经理
	 * @param customerId 客户id
	 * @param busiCommId 客户经理id
	 */
	@Transactional(rollbackFor={Throwable.class})
	public PageData replaceBusiComm(String customerId,String busiCommId){
		
		PageData result = new PageData();
		Map<String, String> msgResult = new HashMap<String, String>();
		
		NjAppUser appUser = njAppUserMapper.selectByPrimaryKey(customerId);
		if(null == appUser){
			msgResult.put("result", "更换失败");
			msgResult.put("resultInfo", "客户id为"+customerId+"的客户不存在");
			result.put(Constants.Datas.NDATA, msgResult);
			return result;
		}
		NjUserInfo userInfo = njUserInfoMapper.selectByPrimaryKey(busiCommId);
		if(null == userInfo){
			msgResult.put("result", "更换失败");
			msgResult.put("resultInfo", "客户经理id为"+busiCommId+"的客户经理不存在");
			result.put(Constants.Datas.NDATA, msgResult);
			return result;
		}
		
		String oldBusiCommId = appUser.getChannelUserId();
		NjUserInfo oldUserInfo = njUserInfoMapper.selectByPrimaryKey(oldBusiCommId);
		
		try {
			replaceBusiComm(appUser, userInfo);
		} catch (Exception e) {
			logger.error("更新客户经理时发生异常：",e);
			msgResult.put("result", "更换失败");
			msgResult.put("resultInfo", "客户:"+appUser.getTrueName()+"、"+appUser.getMobile()+"、" + appUser.getIdentifyId()+",更新时发生异常");
			result.put(Constants.Datas.NDATA, msgResult);
			return result;
		}
		
		msgResult.put("result", "更换成功");
		msgResult.put("resultInfo", "客户:"+appUser.getTrueName()+"、"+appUser.getMobile()+"、" + appUser.getIdentifyId()+",客户经理由"+oldUserInfo.getUserName()+"替换为" + userInfo.getUserName());
		result.put(Constants.Datas.NDATA, msgResult);
		return result;
	}
	
	@Transactional(rollbackFor={Throwable.class},propagation=Propagation.REQUIRES_NEW)
	private void replaceBusiComm (NjAppUser appUser,NjUserInfo userInfo){
		
		NjAppUserBusicommUpdate record = new NjAppUserBusicommUpdate();
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(new Date());
		record.setAppUserId(appUser.getId());
		record.setOldBusicommId(appUser.getChannelUserId());
		record.setNewBusicommId(userInfo.getId());
		njAppUserBusicommUpdateMapper.insert(record);
		
		// 查找该客户是否有订单，若有，则需修改流程表：该客户经理而未处理的，需替换成新的客户经理，已处理的不管
		NjLoanOrderExample ex1 = new NjLoanOrderExample();
		ex1.createCriteria().andUserIdEqualTo(appUser.getId()).andDelFlagEqualTo(false);
		List<NjLoanOrder> orderList = njLoanOrderMapper.selectByExample(ex1);
		
		if(!CollectionUtils.isEmpty(orderList)){
			for (NjLoanOrder order : orderList) {
				String oldBusiCommId = appUser.getChannelUserId();
				if(StringUtils.isNotEmpty(oldBusiCommId)){
					NjProcessOrderFlowsExample ex2 = new  NjProcessOrderFlowsExample();
					List<Short> StatusList = new ArrayList<Short>();
					StatusList.add((short)0);
					StatusList.add((short)1);
					ex2.createCriteria().andOrderIdEqualTo(order.getId()).andUserIdEqualTo(oldBusiCommId).andStatusIn(StatusList);
					List<NjProcessOrderFlows> orderFlowsList = njProcessOrderFlowsMapper.selectByExample(ex2);
					if(!CollectionUtils.isEmpty(orderFlowsList)){
						for (NjProcessOrderFlows njProcessOrderFlows : orderFlowsList) {
							njProcessOrderFlows.setUserId(userInfo.getId());
							njProcessOrderFlowsMapper.updateByPrimaryKey(njProcessOrderFlows);
						}
					}
				}
			}
		}
		
		// 更换njappuser里的客户经理
		appUser.setChannelUserId(userInfo.getId());
		njAppUserMapper.updateByPrimaryKey(appUser);
	}
	
	/**
	 * 移除客户
	 * @param customerId 客户id
	 */
	@Transactional(rollbackFor={Throwable.class})
	public PageData removeAppuser(String customerId){
		PageData result = new PageData();
		Map<String, String> msgResult = new HashMap<String, String>();
		
		NjAppUser appUser = njAppUserMapper.selectByPrimaryKey(customerId);
		if(null == appUser){
			msgResult.put("result", "移除失败");
			msgResult.put("resultInfo", "客户id为"+customerId+"的客户不存在");
			result.put(Constants.Datas.NDATA, msgResult);
			return result;
		}
		
		String oldBusiCommId = appUser.getChannelUserId();
		NjUserInfo oldUserInfo = njUserInfoMapper.selectByPrimaryKey(oldBusiCommId);
		msgResult.put("result", "移除成功");
		msgResult.put("resultInfo", "客户:"+appUser.getTrueName()+"、"+appUser.getMobile()+"、" + appUser.getIdentifyId()+"的客户经理"+oldUserInfo.getUserName()+"被移除");
		
		// 查找该客户是否有在途订单，若有，则拒绝后方可移除
		NjLoanOrderExample ex1 = new NjLoanOrderExample();
		List<Integer> rejectStatus = new ArrayList<Integer>();
		rejectStatus.add(ELoanOrderStatus.PLATFORM_REFUSE.getValue());
		rejectStatus.add(ELoanOrderStatus.USER_REFUSE.getValue());
		rejectStatus.add(ELoanOrderStatus.REPAYMENT.getValue());
		ex1.createCriteria().andUserIdEqualTo(appUser.getId()).andDelFlagEqualTo(false).andStatusNotIn(rejectStatus);
		List<NjLoanOrder> orderList = njLoanOrderMapper.selectByExample(ex1);
		if(!CollectionUtils.isEmpty(orderList)){
			msgResult.put("result", "移除失败");
			msgResult.put("resultInfo", "客户:"+appUser.getTrueName()+"、"+appUser.getMobile()+"、" + appUser.getIdentifyId()+"存在在途订单，需拒绝后方可移除");
			result.put(Constants.Datas.NDATA, msgResult);
			return result;
		}
		
		try {
			removeAppuser(appUser);
		} catch (Exception e) {
			logger.error("移除客户经理时发生异常：",e);
			msgResult.put("result", "移除失败");
			msgResult.put("resultInfo", "客户:"+appUser.getTrueName()+"、"+appUser.getMobile()+"、" + appUser.getIdentifyId()+",移除时发生异常");
			result.put(Constants.Datas.NDATA, msgResult);
			return result;
		}
		
		result.put(Constants.Datas.NDATA, msgResult);
		return result;
	}
	
	@Transactional(rollbackFor={Throwable.class},propagation=Propagation.REQUIRES_NEW)
	public void removeAppuser(NjAppUser appUser){
		
		NjAppUserBusicommUpdate record = new NjAppUserBusicommUpdate();
		record.setId(UuidUtil.get32UUID());
		record.setCreateTime(new Date());
		record.setAppUserId(appUser.getId());
		record.setOldBusicommId(appUser.getChannelUserId());
		record.setNewBusicommId("--");
		njAppUserBusicommUpdateMapper.insert(record);
		
		// 更换njappuser里的客户经理
		appUser.setChannelUserId("");
		appUser.setChannel("");
		appUser.setCompanyId("");
		appUser.setFraudType(0);		//置为未审核0
		njAppUserMapper.updateByPrimaryKey(appUser);
	}
}

