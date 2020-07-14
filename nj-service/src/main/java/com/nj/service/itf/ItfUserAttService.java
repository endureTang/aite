package com.nj.service.itf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.aspectj.apache.bcel.classfile.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.common.Constants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjHouseAttachmentMapper;
import com.nj.dao.NjOrderAttachmentMapper;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.dao.NjUserBasicAttachmentMapper;
import com.nj.dao.NjUserCarAttachmentMapper;
import com.nj.dao.NjUserWorkAttachmentMapper;
import com.nj.model.generate.NjHouseAttachment;
import com.nj.model.generate.NjOrderAttachment;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserBasicAttachment;
import com.nj.model.generate.NjUserCarAttachment;
import com.nj.model.generate.NjUserWorkAttachment;

@Transactional(readOnly = true)
@Service("itfUserAttService")
public class ItfUserAttService {
	private Logger logger = LoggerFactory.getLogger(ItfUserAttService.class);
	
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	/**
	 * 基本信息附件
	 * @param basicId
	 * @param atts
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindBasicInfoUrls(String orderId, List<String> atts) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjOrderAttachmentMapper bwMapper =dao.getMapper(NjOrderAttachmentMapper.class);
			if(atts!=null && !atts.isEmpty()){
			for(String att: atts){
				NjUserAttachment i = new NjUserAttachment();
				i.setId(UuidUtil.get32UUID());
				i.setDelFlag(false);
				i.setCreateDate(new Date());
				i.setSource(att);
				i.setFilePath(att);
				i.setFileTag("others");
				attMapper.insert(i);
				
				NjOrderAttachment j =new NjOrderAttachment();
				j.setAttachId(i.getId());
				j.setId(UuidUtil.get32UUID());
				j.setOrderId(orderId);
				bwMapper.insert(j);
			}
		}
	}
	
	
	/**
	 * 工作信息附件
	 * @param orderId	 订单ID
	 * @param atts		 附件
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOutWorkUrls(String orderId, List<String> atts) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjOrderAttachmentMapper bwMapper =dao.getMapper(NjOrderAttachmentMapper.class);
			if(atts!=null && !atts.isEmpty()){
			for(String att: atts){
				NjUserAttachment i = new NjUserAttachment();
				i.setId(UuidUtil.get32UUID());
				i.setDelFlag(false);
				i.setCreateDate(new Date());
				i.setSource(att);
				i.setFilePath(att);
				i.setBusinessType(Constants.FILE_TYPE.WORK_OTHER);
				i.setFileTag("others");
				attMapper.insert(i);
				
				NjOrderAttachment j =new NjOrderAttachment();
				j.setAttachId(i.getId());
				j.setId(UuidUtil.get32UUID());
				j.setOrderId(orderId);
				bwMapper.insert(j);
			}
		}
	}
	
	/**
	 * 身份证正面
	 * @param userId
	 * @param certFrontImg
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public String saveOutCertFrontImg(String userId, String certFrontImg) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setBussnessId(userId);
		att.setBusinessType(Constants.FILE_TYPE.FILE_CERT_FRONT_OUT);
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(certFrontImg);
		att.setFilePath(certFrontImg);
		att.setFileTag("id_card_front_img");
		attMapper.insert(att);
		return att.getId();
	}
	
	/**
	 * 身份证背面
	 * @param userId
	 * @param certBackImg
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public String saveOutCertBackImg(String userId, String certBackImg) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setBussnessId(userId);
		att.setBusinessType(Constants.FILE_TYPE.FILE_CERT_BACK_OUT);
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(certBackImg);
		att.setFilePath(certBackImg);
		att.setFileTag("id_card_back_img");
		attMapper.insert(att);
		return att.getId();
	}
	
	/**
	 * 身份证手持照片
	 * @param userId
	 * @param certHandImg
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public String saveOutCertHandImg(String userId, String certHandImg) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setBussnessId(userId);
		att.setBusinessType(Constants.FILE_TYPE.FILE_CERT_HAND_OUT);
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(certHandImg);
		att.setFilePath(certHandImg);
		att.setFileTag("id_card_on_hand");
		attMapper.insert(att);
		return att.getId();
	}
	
	/**
	 * 活体认证照片
	 * @param userId
	 * @param livingImg
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public String saveOutLivingImg(String userId, String livingImg) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setBussnessId(userId);
		att.setBusinessType(Constants.FILE_TYPE.FILE_CERT_LIVING_OUT);
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(livingImg);
		att.setFilePath(livingImg);
		att.setFileTag("living_assure");
		attMapper.insert(att);
		return att.getId();
	}
	
	
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOutCarInfoJSZFrontImg(String carId, String url) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(url);
		att.setFileTag("drive_license");
		att.setBusinessType(Constants.FILE_TYPE.JSZ_FRONT);
		attMapper.insert(att);
		//绑定id
		NjUserCarAttachmentMapper attcarMapper = dao.getMapper(NjUserCarAttachmentMapper.class);
		NjUserCarAttachment carAtt = new NjUserCarAttachment();
		carAtt.setId(UuidUtil.get32UUID());
		carAtt.setAttachmentId(att.getId());
		carAtt.setUserCarId(carId);
		carAtt.setType(Constants.FILE_TYPE.JSZ_FRONT);
		attcarMapper.insert(carAtt);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOutCarInfoJSZFBackImg(String carId, String url) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(url);
		att.setFileTag("drive_license");
		att.setBusinessType(Constants.FILE_TYPE.JSZ_BACK);
		attMapper.insert(att);
		//绑定id
		NjUserCarAttachmentMapper attcarMapper = dao.getMapper(NjUserCarAttachmentMapper.class);
		NjUserCarAttachment carAtt = new NjUserCarAttachment();
		carAtt.setId(UuidUtil.get32UUID());
		carAtt.setAttachmentId(att.getId());
		carAtt.setUserCarId(carId);
		//carAtt.setType(Constants.FILE_TYPE.JSZ_BACK);
		attcarMapper.insert(carAtt);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOutCarInfoXSZImg(String carId, String url) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(url);
		att.setFileTag("driving_license");
		att.setBusinessType(Constants.FILE_TYPE.JSZ_XSZ);
		attMapper.insert(att);
		//绑定id
		NjUserCarAttachmentMapper attcarMapper = dao.getMapper(NjUserCarAttachmentMapper.class);
		NjUserCarAttachment carAtt = new NjUserCarAttachment();
		carAtt.setId(UuidUtil.get32UUID());
		carAtt.setAttachmentId(att.getId());
		carAtt.setUserCarId(carId);
		attcarMapper.insert(carAtt);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOutHouseFCZFrontImg(String houseId, String url) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(url);
		att.setFileTag("estate");
		att.setBusinessType(Constants.FILE_TYPE.HOUSE_FCZ_FRONT);
		attMapper.insert(att);
		//绑定id
		NjHouseAttachmentMapper attcarMapper = dao.getMapper(NjHouseAttachmentMapper.class);
		NjHouseAttachment houseAtt = new NjHouseAttachment();
		houseAtt.setId(UuidUtil.get32UUID());
		houseAtt.setAttachmentId(att.getId());
		houseAtt.setHouseId(houseId);
		attcarMapper.insert(houseAtt);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOutHouseFCZBackImg(String houseId, String url) throws Exception{
		NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachment att = new NjUserAttachment();
		att.setId(UuidUtil.get32UUID());
		att.setDelFlag(false);
		att.setCreateDate(new Date());
		att.setSource(url);
		att.setFileTag("estate");
		att.setBusinessType(Constants.FILE_TYPE.HOUSE_FCZ_BACK);
		attMapper.insert(att);
		//绑定id
		NjHouseAttachmentMapper attcarMapper = dao.getMapper(NjHouseAttachmentMapper.class);
		NjHouseAttachment houseAtt = new NjHouseAttachment();
		houseAtt.setId(UuidUtil.get32UUID());
		houseAtt.setAttachmentId(att.getId());
		houseAtt.setHouseId(houseId);
		attcarMapper.insert(houseAtt);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void bindOutHouseImg(String houseId, List<String> urls) throws Exception{
		if(urls==null || urls.isEmpty()){
			return ;
		}
		for (String url : urls) {
			NjUserAttachmentMapper attMapper = dao.getMapper(NjUserAttachmentMapper.class);
			NjUserAttachment att = new NjUserAttachment();
			att.setId(UuidUtil.get32UUID());
			att.setDelFlag(false);
			att.setCreateDate(new Date());
			att.setSource(url);
			att.setFileTag("estate_summary");
			att.setBusinessType(Constants.FILE_TYPE.HOUSE_OTHER);
			attMapper.insert(att);
			// 绑定id
			NjHouseAttachmentMapper attcarMapper = dao.getMapper(NjHouseAttachmentMapper.class);
			NjHouseAttachment houseAtt = new NjHouseAttachment();
			houseAtt.setId(UuidUtil.get32UUID());
			houseAtt.setAttachmentId(att.getId());
			houseAtt.setHouseId(houseId);
			attcarMapper.insert(houseAtt);
		}
	}

}
