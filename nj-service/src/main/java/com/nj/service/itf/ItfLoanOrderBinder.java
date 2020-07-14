package com.nj.service.itf;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.StringUtils;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjOrderAttachmentMapper;
import com.nj.dao.NjOrderBaseInfoCompanyMapper;
import com.nj.dao.NjOrderCertMapper;
import com.nj.dao.NjOrderContactCompanyMapper;
import com.nj.dao.NjOrderDebtMapper;
import com.nj.dao.NjOrderHouseMapper;
import com.nj.dao.NjOrderHuotiMapper;
import com.nj.dao.NjOrderPawnHouseLinkMapper;
import com.nj.dao.NjOrderPawnHouseMapper;
import com.nj.dao.NjOrderRelativeMapper;
import com.nj.dao.NjOrderScenesCompanyMapper;
import com.nj.dao.NjOrderUserCarMapper;
import com.nj.dao.NjOrderUserinfoMapper;
import com.nj.dao.NjOrderWorkMapper;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.dao.NjUserDebtInfoMapper;
import com.nj.dao.NjUserHouseMapper;
import com.nj.dao.extend.NjAppUserBasicInfoMapperExtend;
import com.nj.dao.extend.NjAppUserCarMapperExtend;
import com.nj.dao.extend.NjAppUserRelativesMapperExtend;
import com.nj.dao.extend.NjAppUserWorkMapperExtend;
import com.nj.dao.extend.NjUserAttachmentMapperExtend;
import com.nj.dao.extend.NjUserCertMapperExtend;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjOrderAttachment;
import com.nj.model.generate.NjOrderBaseInfoCompany;
import com.nj.model.generate.NjOrderBaseInfoCompanyExample;
import com.nj.model.generate.NjOrderCert;
import com.nj.model.generate.NjOrderContactCompany;
import com.nj.model.generate.NjOrderContactCompanyExample;
import com.nj.model.generate.NjOrderDebt;
import com.nj.model.generate.NjOrderHouse;
import com.nj.model.generate.NjOrderHuoti;
import com.nj.model.generate.NjOrderPawnHouse;
import com.nj.model.generate.NjOrderPawnHouseExample;
import com.nj.model.generate.NjOrderPawnHouseLink;
import com.nj.model.generate.NjOrderRelative;
import com.nj.model.generate.NjOrderScenesCompany;
import com.nj.model.generate.NjOrderScenesCompanyExample;
import com.nj.model.generate.NjOrderUserCar;
import com.nj.model.generate.NjOrderUserinfo;
import com.nj.model.generate.NjOrderWork;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserBasicInfo;
import com.nj.model.generate.NjUserCar;
import com.nj.model.generate.NjUserCert;
import com.nj.model.generate.NjUserDebtInfo;
import com.nj.model.generate.NjUserDebtInfoExample;
import com.nj.model.generate.NjUserHouse;
import com.nj.model.generate.NjUserHouseExample;
import com.nj.model.generate.NjUserRelatives;
import com.nj.model.generate.NjUserWorkInfo;
import com.nj.model.generate.UserZhimaScore;

@Transactional(readOnly = true)
@Service("itfLoanOrderBinder")
public class ItfLoanOrderBinder {
	
	@Resource(name="BaseDao")
	private BaseDao dao;
		
	@Resource(name= "njZhimaService")
	private NjZhimaService njZhimaService;
	
	private Logger logger = LoggerFactory.getLogger(ItfLoanOrderBinder.class);
	
	
	/**
	 * 订单绑定联系人信息
	 * @param order
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToUserRel(NjLoanOrder order) throws Exception{
		NjAppUserRelativesMapperExtend appUserRelExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		NjOrderRelativeMapper ordRelMapper = dao.getMapper(NjOrderRelativeMapper.class);
		List<NjUserRelatives> rels = appUserRelExtend.getRecentRelatives(order.getUserId());
		// 清除之前关联信息
		Map<String,String> mapRe =new HashMap<String,String>();
		mapRe.put("orderId", order.getId());
		appUserRelExtend.deleteByOrderIdAndRelativeId(mapRe);
		for(NjUserRelatives m:rels){
			NjOrderRelative ordRel = new 	NjOrderRelative();
			ordRel.setOrderId(order.getId());
			ordRel.setRelativeId(m.getId());
			ordRel.setId(UuidUtil.get32UUID());
			ordRelMapper.insert(ordRel);
		}
	}
	
	/**
	 * 订单绑定配偶信息
	 * @param order
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToUserSpause(NjLoanOrder order) throws Exception{
		NjAppUserBasicInfoMapperExtend appUserBasicInfoExtend = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
		NjOrderUserinfoMapper ordUserMapper =dao.getMapper(NjOrderUserinfoMapper.class);
		List<NjUserBasicInfo> userBasicInfos=appUserBasicInfoExtend.getRecentBasicInfo(order.getUserId());
		NjUserBasicInfo njUserBasicInfo  = null;
		if(userBasicInfos != null){
			njUserBasicInfo = userBasicInfos.get(0);
			if(njUserBasicInfo.getMarrStatus()!=null){
				if(njUserBasicInfo.getMarrStatus()==1||njUserBasicInfo.getMarrStatus()==5){
					
					NjAppUserRelativesMapperExtend appUserRelExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
					NjOrderRelativeMapper ordRelMapper = dao.getMapper(NjOrderRelativeMapper.class);
					// 查询配偶信息
					Map<String,String> map = new HashMap<String,String>();
			        map.put("userId", order.getUserId());
			        map.put("type","1");
					List<NjUserRelatives> rels = appUserRelExtend.getUserRelativesByUserId(map);
					// 清除之前关联信息
//					for(NjUserRelatives relative:rels){
//						Map<String,String> mapRe =new HashMap<String,String>();
//						mapRe.put("relativeId", relative.getId());
//						mapRe.put("orderId", order.getId());
//						appUserRelExtend.deleteByOrderIdAndRelativeId(mapRe);
//					}
					for(NjUserRelatives m:rels){
						NjOrderRelative ordRel = new 	NjOrderRelative();
						ordRel.setOrderId(order.getId());
						ordRel.setRelativeId(m.getId());
						ordRel.setId(UuidUtil.get32UUID());
						ordRelMapper.insert(ordRel);
					}
					
				}
			}
		}
	}
	
	/**
	 * 订单绑定房产信息
	 * @param order
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToUserHouse(NjLoanOrder order) throws Exception{
		NjAppUserRelativesMapperExtend appUserRelExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		NjUserHouseMapper njUserHouseMapper = dao.getMapper(NjUserHouseMapper.class);
		NjOrderHouseMapper njOrderHouseMapper = dao.getMapper(NjOrderHouseMapper.class);
		// 清除之前关联信息
		appUserRelExtend.deleteOrderHouseByOrderId(order.getId());
		// 查询最大的version
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		int version = sm.getUserHouseOfMaxVersion(order.getUserId());
		NjUserHouseExample example = new NjUserHouseExample();
		example.createCriteria().andUserIdEqualTo(order.getUserId()).andVersionEqualTo(version);
		List<NjUserHouse> listNjUserHouse=njUserHouseMapper.selectByExample(example);
		for(NjUserHouse userHouse:listNjUserHouse){
			NjOrderHouse  njOrderHouse =new NjOrderHouse();
			njOrderHouse.setHouseId(userHouse.getId());
			njOrderHouse.setOrderId(order.getId());
			njOrderHouse.setId(UuidUtil.get32UUID());
			njOrderHouseMapper.insert(njOrderHouse);
		}
	}
	
	
	/**
	 * 订单绑定抵押房信息
	 * @param order
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToPawnHouse(NjLoanOrder order) throws Exception{
		NjAppUserRelativesMapperExtend appUserRelExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		NjOrderPawnHouseMapper pawn = dao.getMapper(NjOrderPawnHouseMapper.class);
		NjOrderPawnHouseLinkMapper pawnLink = dao.getMapper(NjOrderPawnHouseLinkMapper.class);
		// 清除之前关联信息
		appUserRelExtend.deleteOrderPawnHouseLinkByOrderId(order.getId());
		// 查询最大的version
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		int version = sm.getOrderPawnHouseOfMaxVersion(order.getUserId());
		NjOrderPawnHouseExample example = new NjOrderPawnHouseExample();
		example.createCriteria().andUserIdEqualTo(order.getUserId()).andVersionEqualTo(version);
		List<NjOrderPawnHouse> listNjUserHouse=pawn.selectByExample(example);
		for(NjOrderPawnHouse pawnHouse:listNjUserHouse){
			NjOrderPawnHouseLink linke =new NjOrderPawnHouseLink();
			linke.setPawnId(pawnHouse.getId());
			linke.setOrderId(order.getId());
			linke.setId(UuidUtil.get32UUID());
			pawnLink.insert(linke);
		}
	}
	
	/**
	 * 订单绑定负债信息
	 * @param order
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void  bindOrderToUserDebt(NjLoanOrder order) throws Exception{
		NjAppUserRelativesMapperExtend appUserRelExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		NjUserDebtInfoMapper njUserDebtInfoMapper = dao.getMapper(NjUserDebtInfoMapper.class);
		NjOrderDebtMapper njOrderDebtMapper = dao.getMapper(NjOrderDebtMapper.class);
		// 清除之前关联信息
		appUserRelExtend.deleteOrderDebtByOrderId(order.getId());
		// 查询最大的 version
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	int version = sm.getUserDebtInfoOfMaxVersion(order.getUserId());
		NjUserDebtInfoExample example = new NjUserDebtInfoExample();
		example.createCriteria().andUserIdEqualTo(order.getUserId()).andVersionEqualTo(version);
		List<NjUserDebtInfo> listNjUserDebtInfo=njUserDebtInfoMapper.selectByExample(example);
		for(NjUserDebtInfo userDebtInfo : listNjUserDebtInfo){
			NjOrderDebt debt =new NjOrderDebt();
			debt.setDebtId(userDebtInfo.getId());
			debt.setId(UuidUtil.get32UUID());
			debt.setOrderId(order.getId());
			njOrderDebtMapper.insert(debt);
		}
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindCertImage(NjLoanOrder order) throws Exception{
		NjUserCertMapperExtend uceMapper =dao.getMapper(NjUserCertMapperExtend.class);
		NjOrderCertMapper lcMapper = dao.getMapper(NjOrderCertMapper.class);
		NjUserCert cert =uceMapper.getRecentUserCertByUserId(order.getUserId());
		NjUserAttachmentMapperExtend uaMapper = dao.getMapper(NjUserAttachmentMapperExtend.class);
		if(cert !=null){
			NjOrderCert m = new NjOrderCert();
			m.setId(UuidUtil.get32UUID());
			m.setOrderId(order.getId());
			m.setCertId(cert.getId());
			lcMapper.insert(m);
			//兼容老版本
			if(StringUtils.isEmpty(cert.getHandCertId())){
				NjUserAttachment hand = uaMapper.getHandCertImage(order.getUserId());
				if(hand !=null)
					bindOrderToAttachement(order, hand.getId());
			}
			if(StringUtils.isEmpty(cert.getFrontId())){
				NjUserAttachment head =uaMapper.getHeadImage(order.getUserId());
				if(head !=null)
					bindOrderToAttachement(order,head.getId());
			}
			if(StringUtils.isEmpty(cert.getBackId())){
				NjUserAttachment back =uaMapper.getEmblemImage(order.getUserId());
				if(back !=null)
					bindOrderToAttachement(order,back.getId());
			}
			return;
		}
		else{//兼容老版本
			//绑定身份证正面
			NjUserAttachment head =uaMapper.getHeadImage(order.getUserId());
			bindOrderToAttachement(order,head.getId());
			//绑定身份背面
			NjUserAttachment back =uaMapper.getEmblemImage(order.getUserId());
			bindOrderToAttachement(order,back.getId());
			//绑定手持身份证
			try{
				NjUserAttachment hand = uaMapper.getHandCertImage(order.getUserId());
				bindOrderToAttachement(order, hand.getId());
			}catch(Exception e){
				logger.error("error",e);
			}
			
		}
	}
	
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToUserBasic(NjLoanOrder order) throws Exception{
		// 清除之前关联信息
		NjAppUserRelativesMapperExtend extend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		extend.deleteBaseInfoByOrderId(order.getId());
		NjAppUserBasicInfoMapperExtend appUserBasicInfoExtend = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
		NjOrderUserinfoMapper ordUserMapper =dao.getMapper(NjOrderUserinfoMapper.class);
		List<NjUserBasicInfo> userBasicInfos=appUserBasicInfoExtend.getRecentBasicInfo(order.getUserId());
		for(NjUserBasicInfo m:userBasicInfos){
			NjOrderUserinfo ordUser= new NjOrderUserinfo();
			ordUser.setBasicInfoId(m.getId());
			ordUser.setOrderId(order.getId());
			ordUser.setId(UuidUtil.get32UUID());
			ordUserMapper.insert(ordUser);
			
		}
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToUserWork(NjLoanOrder order) throws Exception{
		// 清除之前关联信息
		NjAppUserRelativesMapperExtend extend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		extend.deleteUserWorkByOrderId(order.getId());
		NjAppUserWorkMapperExtend appUserWorkExtend = dao.getMapper(NjAppUserWorkMapperExtend.class);
		NjOrderWorkMapper ordWorkMapper = dao.getMapper(NjOrderWorkMapper.class);
		List<NjUserWorkInfo> workInfos = appUserWorkExtend.getRecentWork(order.getUserId());
		for(NjUserWorkInfo m:workInfos){
			NjOrderWork ordWork = new NjOrderWork();
			ordWork.setOrderId(order.getId());
			ordWork.setWorkId(m.getId());
			ordWork.setId(UuidUtil.get32UUID());
			ordWorkMapper.insert(ordWork);
			break;
		}
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToAttachement(NjLoanOrder order, String attachmentId)throws Exception {
		NjOrderAttachmentMapper mapper = dao.getMapper(NjOrderAttachmentMapper.class);
		NjOrderAttachment ordAtt = new NjOrderAttachment();
		ordAtt.setId(UuidUtil.get32UUID());
		ordAtt.setOrderId(order.getId());
		ordAtt.setAttachId(attachmentId);
		mapper.insert(ordAtt);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToZhimaScore(NjLoanOrder order, double score)throws Exception{
		UserZhimaScore orderScore = new UserZhimaScore();
		orderScore.setOrderId(order.getId());
		orderScore.setScore(score);
		orderScore.setUserId(order.getUserId());
		orderScore.setCreateDate(new Date());
		njZhimaService.insertScore(orderScore);
		return;
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderToUserCar(NjLoanOrder order) throws Exception{
		// 清除之前关联信息
		NjAppUserRelativesMapperExtend extend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		extend.deleteUserCarByOrderId(order.getId());
		NjAppUserCarMapperExtend appUserCarExtend = dao.getMapper(NjAppUserCarMapperExtend.class);
		NjOrderUserCarMapper ordCarMapper = dao.getMapper(NjOrderUserCarMapper.class);
		List<NjUserCar> cars = appUserCarExtend.getRecentCarByUserId(order.getUserId());
		for(NjUserCar m:cars){
			NjOrderUserCar ordCar = new NjOrderUserCar();
			ordCar.setOrderId(order.getId());
			ordCar.setUserCarId(m.getId());
			ordCar.setId(UuidUtil.get32UUID());
			ordCarMapper.insert(ordCar);
		}
	}
	
    @Transactional(rollbackFor = { Throwable.class }, readOnly = false)
    public void bindOrderToHuoti(NjLoanOrder order, String attId) throws Exception{
    	NjUserAttachmentMapper m= dao.getMapper(NjUserAttachmentMapper.class);
    	NjOrderHuotiMapper l = dao.getMapper(NjOrderHuotiMapper.class);
    	NjUserAttachment a =m.selectByPrimaryKey(attId);
    	if(a==null)
    		return;
    	NjOrderHuoti huoti = new NjOrderHuoti();
    	huoti.setId(UuidUtil.get32UUID());
    	huoti.setAttachmentId(attId);
    	huoti.setOrderId(order.getId());
    	huoti.setRemark(a.getRemarks());
    	huoti.setCreateDate(new Date());
    	huoti.setDelFlag(false);
    	l.insert(huoti);
    	
    }

    @Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderBaseInfoCompany(String orderId, String baseInfoCompanyId) throws Exception {
    	// 清除之前关联信息
    	NjOrderBaseInfoCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjOrderBaseInfoCompanyMapper.class);
    	NjOrderBaseInfoCompanyExample example = new NjOrderBaseInfoCompanyExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		baseInfoCompanyMapper.deleteByExample(example);
		//保存
		NjOrderBaseInfoCompany baseInfoCompany = new NjOrderBaseInfoCompany();
		baseInfoCompany.setId(UuidUtil.get32UUID());
		baseInfoCompany.setOrderId(orderId);
		baseInfoCompany.setBaseInfoCompanyId(baseInfoCompanyId);
		baseInfoCompanyMapper.insertSelective(baseInfoCompany);
	}

    @Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderContactCompany(String orderId, String id) throws Exception {
		// 清除之前关联信息
    	NjOrderContactCompanyMapper contactCompanyMapper = dao.getMapper(NjOrderContactCompanyMapper.class);
    	NjOrderContactCompanyExample example = new NjOrderContactCompanyExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		contactCompanyMapper.deleteByExample(example);
		//保存
		NjOrderContactCompany contactCompany = new NjOrderContactCompany();
		contactCompany.setId(UuidUtil.get32UUID());
		contactCompany.setOrderId(orderId);
		contactCompany.setNjContactCompanyId(id);
		contactCompanyMapper.insertSelective(contactCompany);
	}

    @Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOrderScenesCompany(String orderId, String id) throws Exception {
		// 清除之前关联信息
    	NjOrderScenesCompanyMapper contactCompanyMapper = dao.getMapper(NjOrderScenesCompanyMapper.class);
    	NjOrderScenesCompanyExample example = new NjOrderScenesCompanyExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		contactCompanyMapper.deleteByExample(example);
		//保存
		NjOrderScenesCompany scenesCompany = new NjOrderScenesCompany();
		scenesCompany.setId(UuidUtil.get32UUID());
		scenesCompany.setOrderId(orderId);
		scenesCompany.setNjScenesCompanyId(id);
		contactCompanyMapper.insertSelective(scenesCompany);
		
	}
}
