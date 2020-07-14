package com.nj.service.itf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.codec.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nj.core.base.common.Constants;
import com.nj.core.base.common.api.ResponseMsg;
import com.nj.core.base.common.api.TFCFResponseMsg;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.exception.HttpRequestException;
import com.nj.core.base.util.Map2Bean;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.core.ehcache.EhCacheConstant;
import com.nj.core.ehcache.EhCacheUtil;
import com.nj.dao.AppUserLoginMapper;
import com.nj.dao.NjAppUserMapper;
import com.nj.dao.NjBaseInfoCompanyMapper;
import com.nj.dao.NjContactCompanyMapper;
import com.nj.dao.NjCoporateMapper;
import com.nj.dao.NjCoporateUserMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjOrderPawnHouseMapper;
import com.nj.dao.NjScenesCompanyMapper;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.dao.NjUserBasicAttachmentMapper;
import com.nj.dao.NjUserBasicInfoMapper;
import com.nj.dao.NjUserCarAttachmentMapper;
import com.nj.dao.NjUserCarMapper;
import com.nj.dao.NjUserCertMapper;
import com.nj.dao.NjUserContactMapper;
import com.nj.dao.NjUserDebtInfoMapper;
import com.nj.dao.NjUserHouseMapper;
import com.nj.dao.NjUserRelativesMapper;
import com.nj.dao.NjUserSpotMapper;
import com.nj.dao.NjUserWorkAttachmentMapper;
import com.nj.dao.NjUserWorkInfoMapper;
import com.nj.dao.extend.NjAppUserBasicInfoMapperExtend;
import com.nj.dao.extend.NjAppUserCarMapperExtend;
import com.nj.dao.extend.NjAppUserMapperExtend;
import com.nj.dao.extend.NjAppUserRelativesMapperExtend;
import com.nj.dao.extend.NjAppUserWorkMapperExtend;
import com.nj.dao.extend.NjUserAttachmentMapperExtend;
import com.nj.dao.extend.NjUserCertMapperExtend;
import com.nj.dao.extend.NjUserContactMapperExtend;
import com.nj.model.datamodel.NjUserContactModel;
import com.nj.model.generate.AppUserLogin;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjAppUserExample;
import com.nj.model.generate.NjBaseInfoCompany;
import com.nj.model.generate.NjContactCompany;
import com.nj.model.generate.NjCoporate;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjCoporateUserExample;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjOrderPawnHouse;
import com.nj.model.generate.NjScenesCompany;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserBankCard;
import com.nj.model.generate.NjUserBasicInfo;
import com.nj.model.generate.NjUserCar;
import com.nj.model.generate.NjUserCarAttachment;
import com.nj.model.generate.NjUserCarExample;
import com.nj.model.generate.NjUserCert;
import com.nj.model.generate.NjUserContact;
import com.nj.model.generate.NjUserContactExample;
import com.nj.model.generate.NjUserDebtInfo;
import com.nj.model.generate.NjUserHouse;
import com.nj.model.generate.NjUserRelatives;
import com.nj.model.generate.NjUserRelativesExample;
import com.nj.model.generate.NjUserSpot;
import com.nj.model.generate.NjUserWorkInfo;
import com.nj.service.common.AppConfigService;

@Transactional(readOnly = true)
@Service("itfAppUserService")
public class AppUserService {
	
    @Resource(name = "BaseDao")
    private BaseDao dao;

    @Resource(name = "tfcfHttpService")
    private TfcfHttpService tfcfHttpService;

    @Resource(name = "appConfigService")
    private AppConfigService appConfigService;

    @Resource(name = "appUserServiceInner")
    private AppUserServiceInner appUserServiceInner;
    
    @Resource 
    private  NjAppUserMapper  njAppUserMapper;
    
    @Resource
    private NjAppUserMapperExtend njAppUserMapperExtend;
    
    @Resource
    private UserBankCardService userBankCardService;

    private static Logger logger = LoggerFactory.getLogger(AppUserService.class);

    public NjAppUser saveAppUser(PageData pd) throws Exception {
        //创建公司
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        NjAppUser appUser = new NjAppUser();
        Map2Bean.transMapToNewBean(pd, appUser);
        mapper.insert(appUser);
        return appUser;
    }

    public boolean isExist(String mobileNo) throws Exception {
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        NjAppUserExample example = new NjAppUserExample();
        example.createCriteria().andMobileEqualTo(mobileNo);
        if (mapper.countByExample(example) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isExistId(String id) throws Exception {
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        NjAppUserExample example = new NjAppUserExample();
        example.createCriteria().andIdEqualTo(id);
        if (mapper.countByExample(example) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public NjAppUser getAppUserByMobileNo(String mobileNo) throws Exception {
        NjAppUser cacheValue = (NjAppUser) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.APP_USER, mobileNo);
        logger.debug("retrive key: " + mobileNo);
        if (cacheValue != null) {
            logger.debug("cache is working");
            return cacheValue;
        }
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        NjAppUserExample example = new NjAppUserExample();
        example.createCriteria().andMobileEqualTo(mobileNo);
        List<NjAppUser> users = mapper.selectByExample(example);

        if (users == null || users.isEmpty()) {
            return null;
        } else {
            NjAppUser user = users.get(0);
            EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER, mobileNo, user);
            return users.get(0);
        }
    }
    
    public NjAppUser getAppUserByMobileNoCache(String mobileNo)throws Exception {
    	
    	   NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
           NjAppUserExample example = new NjAppUserExample();
           example.createCriteria().andMobileEqualTo(mobileNo);
           List<NjAppUser> users = mapper.selectByExample(example);
           if (users == null || users.isEmpty()) {
               return null;
           } else {         
               return users.get(0);
           }
    }
    
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addRelativesForSpause(String mobileNo, NjUserRelatives relation)throws Exception{
    	
    	 NjAppUser user = getAppUserByMobileNo(mobileNo);
    	 NjUserRelativesMapper relMapper = dao.getMapper(NjUserRelativesMapper.class);
         NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
         Map<String,String> map = new HashMap<String,String>();
         map.put("userId", user.getId());
         map.put("type","1");
         int version = sm.getUserRelativesOfMaxVersion(map);
         relation.setVersion(version+1);
         relation.setCreateDate(new Date());
         relation.setUserId(user.getId());
         relMapper.insert(relation);
         
    }
    
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addRelatives(String mobileNo, List<NjUserRelatives> relations) throws Exception {
        if (relations == null || relations.isEmpty())
            return;
        NjAppUser user = getAppUserByMobileNo(mobileNo);
        NjUserRelativesMapper relMapper = dao.getMapper(NjUserRelativesMapper.class);
        NjUserRelativesExample relExample = new NjUserRelativesExample();
        NjAppUserRelativesMapperExtend relExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
        relExample.createCriteria().andUserIdEqualTo(user.getId());
        List<NjUserRelatives> oldRels = getRecentRelativeInfoByMobile(mobileNo);
        Date nowTime = new Date();
        if (oldRels == null || oldRels.isEmpty()) {//以前没有联系人数据
            Integer maxVersion = relExtend.getMaxVersionByUserId(user.getId());
            maxVersion = maxVersion == null ? 0 : maxVersion + 1;
            for (NjUserRelatives m : relations) {
                m.setId(UuidUtil.get32UUID());
                m.setVersion(maxVersion);
                m.setCreateDate(nowTime);
                m.setDelFlag((byte) 0);
                m.setUserId(user.getId());
                relMapper.insert(m);
            }

        } else {
            for (NjUserRelatives m : relations) {
                m.setId(UuidUtil.get32UUID());
                m.setVersion(oldRels.get(0).getVersion() + 1);
                m.setCreateDate(nowTime);
                m.setUserId(user.getId());
                m.setDelFlag((byte) 0);
                relMapper.insert(m);
            }
        }
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_RELATION, relations.get(0).getUserId());
    }

    public List<NjUserRelatives> getRelativesByMobile(String mobileNo) throws Exception {
        NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
        return sm.getRelativeMapByMobile(mobileNo);
    }
    
    public List<NjOrderPawnHouse> getNjOrderPawnHouseByMobile(String mobileNo) throws Exception {
    	
    	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	return sm.getOrderPawnHouseByMobile(mobileNo);
    	
    }
    
    /**
     * 通过订单ID查询抵押物信息
     * @param orderId
     * @return
     * @throws Exception
     */
    public List<NjOrderPawnHouse> getNjOrderPawnHouseModelByOrderId(String orderId) throws Exception{
    	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	return sm.getOrderPawnHouseModelByOrderId(orderId);   
    }
    
    /**
     * 通过手机号码查询负债信息
     * @param mobile
     * @return
     * @throws Exception
     */
    public List<NjUserDebtInfo> getNjUserDebtInfoByMobile(String mobile) throws Exception {
    	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	return sm.getUserDebtInfoByMobile(mobile);
    }
    
    public List<NjUserHouse> getNjUserHouseByMobile(String mobile) throws Exception {
    	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	return sm.getUserHouseByMobile(mobile);
    }
    
    public List<NjUserRelatives> getNjUserRelativesByMobileAndType(String mobile,String relativeType) throws Exception {
    	
    	Map<String,String>  map = new HashMap<String,String>();
    	map.put("mobile", mobile);
    	map.put("type", relativeType);
    	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	
    	return sm.getUserRelatives(map);
    } 

    public List<NjUserRelatives> getRecentRelativeInfoByMobile(String mobileNo) throws Exception {
        NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
        return sm.getRecentRelsByMobile(mobileNo);
    }

    public List<NjUserRelatives> getRecentRelativeInfo(String userId) throws Exception {
        List<NjUserRelatives> l = (List<NjUserRelatives>) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.APP_USER_RELATION, userId);
        if (l != null)
            return l;
        NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
        List<NjUserRelatives> rels = sm.getRecentRelatives(userId);
        EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER_RELATION, userId, rels);
        return rels;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjUserBasicInfo addBasicInfo(NjUserBasicInfo basic, NjAppUser user, JSONArray attachment) throws Exception {

        //根据手机号检索
        NjAppUser tmpUser = getAppUserByMobileNo(user.getMobile());
        if (null == tmpUser) {// 用户表中没有该用户，则新建用户
            user.setId(UuidUtil.get32UUID());
            saveAppUser(user);
        } else {
            user.setId(tmpUser.getId());
            updateUser(user);
        }
        basic.setUserId(user.getId());
        //获取最高版本的用户basic信息实体
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_BASIC, basic.getUserId());
        NjAppUserBasicInfoMapperExtend smBasicExt = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
        NjUserBasicInfoMapper smBasic = dao.getMapper(NjUserBasicInfoMapper.class);
        NjUserBasicAttachmentMapper basicAttMap = dao.getMapper(NjUserBasicAttachmentMapper.class);
        List<NjUserBasicInfo> recentBasics = smBasicExt.getRecentBasicInfo(basic.getUserId());
        if (recentBasics == null || recentBasics.isEmpty()) {//最近的basic信息不存在
            basic.setVersion(1);
            smBasic.insert(basic);
        } else {
            basic.setVersion(recentBasics.get(0).getVersion() == null ? 1 : recentBasics.get(0).getVersion() + 1);
            smBasic.insert(basic);
        }
        //插入附件信息
//		if(attachment !=null){
//			for(int i=0;i<attachment.size(); i++){
//				NjUserBasicAttachment att = new NjUserBasicAttachment();
//				att.setId(UuidUtil.get32UUID());
//				att.setBasicInfoId(basic.getId());
//				att.setAttachmentId(attachment.getJSONObject(i).getString("attachmentId"));
//				att.setType(attachment.getJSONObject(i).getInteger("type"));
//				basicAttMap.insert(att);
//			}
//		}
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_BASIC, basic.getUserId());
        EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER_BASIC, basic.getUserId(), basic);
        return basic;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String addOutBasicInfo(NjUserBasicInfo basic) throws Exception {
        basic.setVersion(-99);
        NjUserBasicInfoMapper mapper = dao.getMapper(NjUserBasicInfoMapper.class);
        mapper.insert(basic);
        return basic.getId();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String addOutRelInfo(NjUserRelatives rel) throws Exception {
        rel.setVersion(-99);
        NjUserRelativesMapper mapper = dao.getMapper(NjUserRelativesMapper.class);
        mapper.insert(rel);
        return rel.getId();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String addOutWorkInfo(NjUserWorkInfo work) throws Exception {
        work.setVersion(-99);
        NjUserWorkInfoMapper mapper = dao.getMapper(NjUserWorkInfoMapper.class);
        mapper.insert(work);
        return work.getId();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String saveAppUser(NjAppUser user) throws Exception {
        if (user == null)
            return null;
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER, user.getMobile());
        user.setId(UuidUtil.get32UUID());
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        mapper.insert(user);
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER, user.getMobile());
        EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER, user.getMobile(), user);
        return user.getId();
    }


    public NjUserBasicInfo getRecentBasicInfoByMobile(String mobileNo) throws Exception {
        NjAppUserBasicInfoMapperExtend smBasicExt = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
        List<NjUserBasicInfo> basics = smBasicExt.getRecentBasicInfo(getAppUserByMobileNo(mobileNo).getId());
        if (basics == null || basics.isEmpty())
            return null;
        return basics.get(0);
    }

    public NjUserBasicInfo getRecentBasicInfo(String userId) throws Exception {
        NjUserBasicInfo l = (NjUserBasicInfo) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.APP_USER_BASIC, userId);
        if (l != null)
            return l;
        NjAppUserBasicInfoMapperExtend smBasicExt = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
        List<NjUserBasicInfo> basics = smBasicExt.getRecentBasicInfo(userId);
        if (basics == null || basics.isEmpty())
            return null;
        EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER_BASIC, userId, basics.get(0));
        return basics.get(0);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void deleteRelative(String mobileNo, List<String> relIds) throws Exception {
        //先获取用户信息
        NjAppUser user = getAppUserByMobileNo(mobileNo);
        String userId = user.getId();
        if (StringUtils.isEmpty(userId)) {
            logger.info(mobileNo + "该手机号没有联系人");
            return;
        }
        //删除缓存
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_RELATION, userId);
        //获取该userId下的所有最近的用户联系人数据
        NjUserRelativesMapper userRelMap = dao.getMapper(NjUserRelativesMapper.class);
        NjAppUserRelativesMapperExtend smRelExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
        List<NjUserRelatives> oldRels = smRelExtend.getRecentRelatives(userId);
        if (oldRels == null || oldRels.isEmpty()) {
            logger.info(mobileNo + "该手机号没有联系人");
            return;
        }

        for (String relId : relIds) {
            NjUserRelatives rel = userRelMap.selectByPrimaryKey(relId);
            rel.setDelFlag((byte) 1);
            userRelMap.updateByPrimaryKeySelective(rel);
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void modifyRelative(String mobileNo, List<NjUserRelatives> rels) throws Exception {
        //先获取用户
        NjAppUser user = getAppUserByMobileNo(mobileNo);
        if (user == null) {
            throw new Exception("该手机号没有在能借平台开户");
        }
        if (rels == null || rels.isEmpty()) {
            logger.info("修改联系人为空");
            return;
        }
        String userId = user.getId();
        NjUserRelativesMapper userRelMap = dao.getMapper(NjUserRelativesMapper.class);
        NjAppUserRelativesMapperExtend smRelExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
        List<NjUserRelatives> oldRels = smRelExtend.getRecentRelatives(userId);
        for (NjUserRelatives m : oldRels) {//遍历所有老联系人
            NjUserRelatives toModify = null;
            for (NjUserRelatives n : rels) {
                if (m.getId().equals(n.getId())) {//找到该联系人是否要修改
                    toModify = n;
                    break;
                }
            }
            if (toModify == null) {//不需要修改的联系人，只是把版本号加一
                m.setVersion(m.getVersion() + 1);
                //userRelMap.updateByPrimaryKey(m);
                userRelMap.updateByPrimaryKeySelective(m);
            } else {//需要修改的记录，版本号+1,同时uuid也需要变化
                //将该联系人设置为删除
                m.setDelFlag((byte) 1);
                userRelMap.updateByPrimaryKeySelective(m);
                //添加新联系人
                toModify.setId(UuidUtil.get32UUID());
                toModify.setVersion(m.getVersion() + 1);
                toModify.setUserId(m.getUserId());
                toModify.setCreateDate(new Date());
                toModify.setDelFlag((byte) 0);
                userRelMap.insert(toModify);
            }
        }
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_RELATION, userId);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjUserWorkInfo addWorkInfoByMobileNo(String mobileNo, NjUserWorkInfo work) throws Exception {
        //先获取用户
        NjAppUser user = getAppUserByMobileNo(mobileNo);
        if (user == null) {//该用户不存在，通过手机号创建该用户
            user = addNjAppUser(mobileNo);
        }
        work.setUserId(user.getId());
        if (StringUtils.isEmpty(work.getId())) {
            work.setId(UuidUtil.get32UUID());
        }
        NjUserWorkInfoMapper workMap = dao.getMapper(NjUserWorkInfoMapper.class);
        NjAppUserWorkMapperExtend workMapExt = dao.getMapper(NjAppUserWorkMapperExtend.class);
        List<NjUserWorkInfo> recentWorks = workMapExt.getRecentWork(user.getId());
        if (recentWorks == null || recentWorks.isEmpty()) {//如果不存在工作信息了，则保存
            work.setVersion(0);
            workMap.insert(work);
        } else {//如果存在工作信息，则增加版本号，然后插入工作记录,目前默认只有一条工作记录信息，如果有多条，需要修改代码，同时要修改客户端
            work.setVersion(recentWorks.get(0).getVersion() + 1);
            work.setCreateDate(new Date());
            workMap.insert(work);
        }
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_WORK, work.getUserId());
        return work;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjUserWorkInfo addWorkInfo(String userId, NjUserWorkInfo work, JSONArray attachment) throws Exception {
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_WORK, userId);
        NjUserWorkInfoMapper workMap = dao.getMapper(NjUserWorkInfoMapper.class);
        NjUserWorkAttachmentMapper workAttMap = dao.getMapper(NjUserWorkAttachmentMapper.class);
        NjAppUserWorkMapperExtend workMapExt = dao.getMapper(NjAppUserWorkMapperExtend.class);
        List<NjUserWorkInfo> recentWorks = workMapExt.getRecentWork(userId);
        if (recentWorks == null || recentWorks.isEmpty()) {//如果不存在工作信息了，则保存
            work.setVersion(0);
            workMap.insert(work);
        } else {//如果存在工作信息，则增加版本号，然后插入工作记录,目前默认只有一条工作记录信息，如果有多条，需要修改代码，同时要修改客户端
            work.setVersion(recentWorks.get(0).getVersion() + 1);
            work.setCreateDate(new Date());
            workMap.insert(work);
        }
        //插入附件信息
//		if(attachment !=null){
//			for(int i=0;i<attachment.size(); i++){
//				NjUserWorkAttachment att = new NjUserWorkAttachment();
//				att.setId(UuidUtil.get32UUID());
//				att.setWorkId(work.getId());
//				att.setAttachmentId(attachment.getJSONObject(i).getString("attachmentId"));
//				att.setType(attachment.getJSONObject(i).getInteger("type"));
//				workAttMap.insert(att);
//			}
//		}
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_WORK, userId);
        EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER_WORK, userId, work);
        return work;
    }

    public NjUserWorkInfo getRecentWorInfoByMobile(String mobileNo) throws Exception {
        NjAppUser user = getAppUserByMobileNo(mobileNo);
        String userId = user.getId();
        NjAppUserWorkMapperExtend workMapExt = dao.getMapper(NjAppUserWorkMapperExtend.class);
        List<NjUserWorkInfo> works = workMapExt.getRecentWork(user.getId());
        if (works == null || works.isEmpty()) {
            return null;
        } else {
            return works.get(0);
        }
    }

    public NjUserWorkInfo getRecentWorInfo(String userId) throws Exception {
        NjUserWorkInfo l = (NjUserWorkInfo) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.APP_USER_WORK, userId);
        if (l != null) {
            logger.info("get work from cache");
            return l;
        }
        NjAppUserWorkMapperExtend workMapExt = dao.getMapper(NjAppUserWorkMapperExtend.class);
        List<NjUserWorkInfo> works = workMapExt.getRecentWork(userId);
        if (works == null || works.isEmpty()) {
            return null;
        } else {
            EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER_WORK, userId, works.get(0));
            logger.info("put work to cache");
            return works.get(0);
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjAppUser addNjAppUser(String mobileNo) throws Exception {
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER, mobileNo);
        NjAppUser cs = new NjAppUser();
        cs.setId(UuidUtil.get32UUID());
        cs.setUserType(0);
        cs.setMobile(mobileNo);
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        mapper.insert(cs);
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER, mobileNo);
        EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER, mobileNo, cs);
        return cs;
    }

    public NjAppUser getAppUser(String id) throws Exception {
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        return mapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjAppUser updateUser(NjAppUser user) throws Exception {
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER, user.getMobile());
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        mapper.updateByPrimaryKeySelective(user);
        return user;
    }
    
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public NjAppUser updateUserNoCache(NjAppUser user) throws Exception {
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        mapper.updateByPrimaryKeySelective(user);
        return user;
    }
    
    /**
     * 查询天府财富账户是否激活
     * @param userId	天府财富用户ID
     * @return  
     * @throws Exception
     */
    public boolean getTfcfAccountActivate(String userId) throws Exception {
    	
    	// 构造查询条件
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		
		// 调用天府财富的
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_ACCOUNT_INFO);
		logger.info("天府财富账户是否激活(开户)查询"+tfcfResp);
		
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("查询天府财富账户是否激活(开户)失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			int resultStatus = tfcfResp1.getResultStatus();			
			if (resultStatus == 0 ) {
				Object accountStatusObj =  tfcfResp1.getOptional().get("accountStatus");
				boolean accountStatus = accountStatusObj != null ? Boolean.parseBoolean(accountStatusObj.toString()) : false;
				return accountStatus;		
			} else {
				throw new HttpRequestException("查询天府财富账户是否激活(开户)失败");
			}			
		}     	
    }    
    
    /**
     * 通过天府财富ID查询四要素信息
     * @param userId
     * @return
     * @throws Exception 
     */
    public Map<String,Object> getTfcfAccountInfo(String userId) throws Exception{
    	
    	// 返回值
    	Map<String,Object> result = new HashMap<String,Object>();    	
    	
    	// 构造查询条件
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		
		// 调用天府财富的获取权限
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_TFCF_FOUR);
		logger.info("天府财富四要素查询userId="+userId +"----返回内容"+tfcfResp);
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("获取天府财富四要素失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));		
			int resultStatus = tfcfResp1.getResultStatus();
			if (resultStatus==0) {
				Object truenameObj =  tfcfResp1.getOptional().get("truename");// 真实姓名
				Object mobileObj =  tfcfResp1.getOptional().get("mobile");// 手机号码
				Object cardnoObj =  tfcfResp1.getOptional().get("cardno");// 银行卡号
				Object idcardObj =  tfcfResp1.getOptional().get("idcard");// 身份证号码
				Object bankCodeObj = tfcfResp1.getOptional().get("bankCode");// 银行编码
				Object bankNameObj = tfcfResp1.getOptional().get("bankName");// 银行名称
				Object bankCardStatusObj = tfcfResp1.getOptional().get("bankCardStatus");// 是否绑卡 0否1是
				Object userBalanceObj = tfcfResp1.getOptional().get("userBalance");// 账户余额
				
				result.put("truename",truenameObj !=null ? truenameObj.toString() : "" );
				result.put("mobile", mobileObj !=null ? mobileObj.toString() : "");
				result.put("cardno", cardnoObj !=null ? cardnoObj.toString() : "");
				result.put("idcard", idcardObj !=null ? idcardObj.toString() : "");
				result.put("bankCode",bankCodeObj !=null ? bankCodeObj.toString() : "" );
				result.put("bankName", bankNameObj !=null ?bankNameObj.toString() : "");
				result.put("bankCardStatus", bankCardStatusObj !=null ? bankCardStatusObj.toString() : "");
				result.put("userBalance", userBalanceObj != null ? new BigDecimal(userBalanceObj.toString()):0);
				return result;
			} else {
				throw new HttpRequestException("获取天府财富四要素失败");
			}	
		}
    }
    
    /**
     * 通过产品ID查询逾期列表
     * @param productId
     * @return
     * @throws Exception
     */
    public List<Map> getTfcfOverdueList(String productId)throws Exception {
    	
     	// 构造查询条件
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("productId", productId);    	
    	
    	// 调用天府财富的获取权限
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_OVERDUE_RECORDS);
		logger.info("天府财富查询逾期列表，productId="+productId +"----返回内容"+tfcfResp);
		
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("天府财富查询逾期列表失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			int resultStatus = tfcfResp1.getResultStatus();
			if (resultStatus == 0) {
				
				return (List<Map>)tfcfResp1.getRows();
			} else {
				throw new HttpRequestException("天府财富查询逾期列表失败");
			}			
		}
    }
    
    /**
     * 第三方代扣
     * @param orderNo		订单编号
     * @param period		期数
     * @param channelId		渠道ID
     * @throws Exception
     */
    public Integer deductMoney(String orderNo,Integer period,String channelId) throws Exception{
    	
       	// 构造查询条件
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("tfdRequestId", orderNo);   
    	params.put("period", period);   
    	params.put("channel", channelId);
    	
    	// 调用天府财富的获取权限
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_DEDUCT_MONEY);
    	logger.info("天府财富第三方代扣返回数据"+tfcfResp);
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("天府财富第三方代扣失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			int resultStatus = tfcfResp1.getResultStatus();
						
			return resultStatus ;
		}
    }
    
    
    /**
     * 第三方代扣 - 升级版
     * @param orderNo		订单编号
     * @param period		期数
     * @param channelId		渠道ID
     * @param deductAccount	
     * @param deductType
     * @param deductMsg
     * @throws Exception
     */
    public Map<String,Object> deductMoneyMore(String orderNo,Integer period,String channelId,String deductAccount,String  deductType,String deductMsg,String deductNo,BigDecimal deductAmount,BigDecimal channelAccDeductAmount) throws Exception{
    	
       	// 构造查询条件
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("tfdRequestId", orderNo);   
    	params.put("period", period);   
    	params.put("channel", channelId);
    	params.put("deductAccount", deductAccount);
    	params.put("deductType", deductType);
    	params.put("deductMsg", deductMsg != null ? deductMsg : "");
    	params.put("deductNo", deductNo);
    	params.put("deductAmount", deductAmount);
    	params.put("channelAccDeductAmount", channelAccDeductAmount);
    	
    	// 调用天府财富的获取权限
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_DEDUCT_MONEY_REPAY);
    	logger.info("天府财富第三方代扣升级返回数据"+tfcfResp);
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("天府财富第三方代扣升级版失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			int resultStatus = tfcfResp1.getResultStatus();
			String msg =tfcfResp1.getMsg();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("resultStatus", resultStatus);
			map.put("msg", msg);
			return map ;
		}
    }
    
    /**
     * 业务订单查询
     * @param businessNo
     * @param channelId
     * @param bizzType
     * @return
     * @throws Exception
     */
    public Map<String,Object> queryBusinessStatus(String businessNo,String channelId,String bizzType) throws Exception {
    	
     	// 构造查询条件
    	Map<String,Object> params = new HashMap<String,Object>();
    	params.put("orderNo", businessNo);
      	params.put("channelId", channelId);
      	params.put("bizzType", bizzType);
      	 
 		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_BUSSINESS_STATUS);
 		logger.info("天府财富业务订单执行结果查询返回数据"+tfcfResp);
 		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("天府财富业务订单执行结果查询失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			return tfcfResp1.getOptional();
		}
    }
    
    /**
     * 获取还款计划
     * @param userId
     * @return
     */
    public Map<String,Object> getTfcfRepayPlan(String orderNo) throws Exception{

    	// 返回值
    	Map<String,Object> result = new HashMap<String,Object>();    	
    	
    	// 构造查询条件
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("tfdRequestId", orderNo);
		
		// 调用天府财富的还款计划
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_REPAY_DETAIL_NEW);
		logger.info("天府财富的还款计划"+tfcfResp);
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("天府财富的还款计划失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			int resultStatus = tfcfResp1.getResultStatus();
			if (resultStatus==0) {
				Object periodObj =  tfcfResp1.getOptional().get("period");// 期数
				Object repayPlanCapitalObj =  tfcfResp1.getOptional().get("repayPlanCapital");// 本期还款金额
				Object repayPlanDateObj =  tfcfResp1.getOptional().get("repayPlanDate");// 还款日
				Object repayPlanInterestObj =  tfcfResp1.getOptional().get("repayPlanInterest");// 本期还款利息
				Object repayPlanTotalObj = tfcfResp1.getOptional().get("repayPlanTotal");// 本期还款总额
				
				result.put("period",periodObj !=null ? new Integer(periodObj.toString()) : 0 );
				result.put("repayPlanCapital", repayPlanCapitalObj !=null ? new BigDecimal(repayPlanCapitalObj.toString()) : 0);
				result.put("repayPlanDate", repayPlanDateObj !=null ? repayPlanDateObj.toString() : "");
				result.put("repayPlanInterest", repayPlanInterestObj !=null ? new BigDecimal(repayPlanInterestObj.toString()) : 0);
				result.put("repayPlanTotal",repayPlanTotalObj !=null ? new BigDecimal(repayPlanTotalObj.toString()) : 0 );
				
				return result;
			} else {
				throw new HttpRequestException("天府财富的还款计划失败");
			}	
		}    	
    }
    
    /**
     * 获取还款计划列表
     * @param userId
     * @return
     */
    public List<Map> getTfcfRepayPlanList(String orderNo) throws Exception{

    	// 返回值
    	Map<String,Object> result = new HashMap<String,Object>();    	
    	
    	// 构造查询条件
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("tfdRequestId", orderNo);
		
		// 调用天府财富的还款计划
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_REPAY_DETAIL_NEW);
		logger.info("天府财富的还款计划"+tfcfResp);
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("天府财富的还款计划失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			int resultStatus = tfcfResp1.getResultStatus();
			if (resultStatus==0) {
				
				return (List<Map>)tfcfResp1.getRows();
//				Object periodObj =  tfcfResp1.getOptional().get("period");// 期数
//				Object repayPlanCapitalObj =  tfcfResp1.getOptional().get("repayPlanCapital");// 本期还款金额
//				Object repayPlanDateObj =  tfcfResp1.getOptional().get("repayPlanDate");// 还款日
//				Object repayPlanInterestObj =  tfcfResp1.getOptional().get("repayPlanInterest");// 本期还款利息
//				Object repayPlanTotalObj = tfcfResp1.getOptional().get("repayPlanTotal");// 本期还款joinpoint 总额
//				
//				result.put("period",periodObj !=null ? new Integer(periodObj.toString()) : 0 );
//				result.put("repayPlanCapital", repayPlanCapitalObj !=null ? new BigDecimal(repayPlanCapitalObj.toString()) : 0);
//				result.put("repayPlanDate", repayPlanDateObj !=null ? repayPlanDateObj.toString() : "");
//				result.put("repayPlanInterest", repayPlanInterestObj !=null ? new BigDecimal(repayPlanInterestObj.toString()) : 0);
//				result.put("repayPlanTotal",repayPlanTotalObj !=null ? new BigDecimal(repayPlanTotalObj.toString()) : 0 );
//				
//				return result;
			} else {
				throw new HttpRequestException("天府财富的还款计划失败");
			}	
		}    	
    }
	/**
	 * 通过手机号码获取天府财富UserId
	 * @param mobile
	 * @return
	 * @throws Exception
	 */
	public String getTfctUserId(String mobile)throws Exception{
		
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("mobile", mobile);
		params.put("channel", "jindingweidai");
		
		// 调用天府财富的获取openId接口
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_TFCFUSERID);
		
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new Exception("获取天府财富user_id失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			String tfcfUserId = (String) tfcfResp1.getOptional().get("userId");
			logger.info("获取天府财富ID成功");
			return tfcfUserId;
		}
		
	}
	
	/**
	 * 获得用户激活二维码图片
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public ResponseMsg  getQrCode(String userId) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("userId", userId);
		// 调用天府财富的获取openId接口
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_QR_CODE);
		logger.info("天府财富获得用户激活二维码图片"+tfcfResp);
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new Exception("获得用户激活二维码图片失败");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			String filePath = (String) tfcfResp1.getOptional().get("filePath");
			String activatePath = (String) tfcfResp1.getOptional().get("activatePath");
			logger.info("获得用户激活二维码图片成功");
			return tfcfResp1;
		}
	} 

    @Transactional(propagation = Propagation.SUPPORTS)
    public String getTfcfUserId(NjAppUser user, String tokenName, String tokenId) throws Exception {
        if (!StringUtils.isEmpty(user.getUserId()))
            return user.getUserId();
        // 天府财富userId为空
        // 根据openId,mobileNo, tokenName, tokenId来获取用户的tfcf id
        String mobileNo = user.getMobile();
        String openId = user.getOpenId();
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("mobile", mobileNo);
        params.put("openId", openId);

        // 调用天府财富的获取openId接口
        String tfcfResp = tfcfHttpService.doHttpPostForTfcf(tokenName, tokenId, params, Constants.TFCF.GET_TFCFUSERID);
        if (StringUtils.isEmpty(tfcfResp)) {
            logger.error("获取天府财富user_id失败");
            throw new Exception("获取天府财富user_id失败");
        } else {//接口调用成功
            JSONObject tfcfResp1 = JSONObject.parseObject(tfcfResp);
            logger.debug("tfcfResp1:" + tfcfResp1.toString());
            if (tfcfResp1.getInteger("resultStatus") == 0) {// 获取userId成功
                String tfcfUserId = tfcfResp1.getString("userId");
                logger.info("获取天府财富user_id成功");
                user.setUserId(tfcfUserId);
                updateUser(user);
                return tfcfUserId;
            }
            // userId获取失败，天府财富端没有该用户，创建一个用户
            logger.info("天府财富中没有该openid对应的userid");
            // 创建一个天府财富的账户
            Map<String, Object> newTfcfUser = new HashMap<String, Object>();
            newTfcfUser.put("username", mobileNo);
            newTfcfUser.put("mobile", mobileNo);
            if (StringUtils.isEmpty(user.getChannel())) {
                newTfcfUser.put("channel", "jindingweidai");
            } else {
                newTfcfUser.put("channel", user.getChannel());
            }
            // 随机生成用户密码，大小写+数字+字符@
            String password = RandomStringUtils.random(6,
                    "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789")
                    + RandomStringUtils.random(1, "ABCDEFGHIGKLMNOPQRSTUVWXYZ") + "@";
            if ((password.charAt(0) >= '0') && (password.charAt(0) <= '9')) {
                password = RandomStringUtils.random(1, "abcdefghigklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ")
                        + password;
            }
            //passowrd 做base64处理
            password = Base64.encodeToString(password.getBytes());
            newTfcfUser.put("password", password);
            //向天府财富注册
            logger.debug("向天府财富注册新用户");
            String regTfcfResp = tfcfHttpService.doHttpPostForTfcf(tokenName, tokenId, newTfcfUser,
                    Constants.TFCF.REGISTER_USER);

            if (StringUtils.isEmpty(regTfcfResp)) {// 注册失败
                logger.error("天府财富注册失败");
                throw new Exception("获取天府财富user_id失败");
            }

            ResponseMsg regTfcfResp1 = JSONObject.parseObject(regTfcfResp, ResponseMsg.class);
            if (regTfcfResp1.getResultStatus() != 0) {// 天府财富注册失败
                logger.error("天府财富注册失败");
                logger.error("天府财富注册错误：" + regTfcfResp1.getMsg() + " errorcode:" + regTfcfResp1.getResultStatus());
                throw new Exception("获取天府财富user_id失败");
            }
            //重新请求userid
            String tfcfRespAgain = tfcfHttpService.doHttpPostForTfcf(tokenName, tokenId, params,
                    Constants.TFCF.GET_TFCFUSERID);
            if (StringUtils.isEmpty(tfcfRespAgain)) {
                logger.error("获取天府财富user_id失败");
                throw new Exception("获取天府财富user_id失败");
            }
            JSONObject tfcfRespAgain1 = JSONObject.parseObject(tfcfRespAgain);
            if (tfcfRespAgain1.getInteger("resultStatus") != 0) {
                logger.error("获取天府财富userId失败");
                throw new Exception("获取天府财富user_id失败");
            } else {
                String tfcfUserAgainId = (String) tfcfRespAgain1.getString("userId");
                logger.info("获取天府财富user_id成功");
                user.setUserId(tfcfUserAgainId);
                updateUser(user);
                return tfcfUserAgainId;
            }
        }
    }

    public String encryptString(NjAppUser user, String src) {
        return src;
    }

    public String decryptString(NjAppUser user, String src) {
        return src;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void modifyUser(NjAppUser user) throws Exception {
        user.setAddress("天府财富");
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        mapper.updateByPrimaryKeySelective(user);
        //throw new Exception();
    }

    public String getBankCard(NjAppUser user) {
        return null;
    }

    public String getIp(NjAppUser user) {
        return null;
    }

    public String getMac(NjAppUser user) {
        return null;
    }

    public String getWifiMac(NjAppUser user) {
        return null;
    }

    public String createDefiIdentifyId(String certNo) {
        if (StringUtils.isEmpty(certNo)) {
            return null;
        }
        StringBuffer sb = new StringBuffer(certNo);
        sb.replace(4, sb.length() - 5, "****");
        return sb.toString();
    }

    public String createDefiTrueName(String name) {
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        StringBuffer sb = new StringBuffer(name);
        if (name.length() <= 2) {
            sb.replace(1, name.length(), "*");
        }
        if (name.length() > 2) {
            sb.replace(1, name.length() - 1, "*");
        }
        return sb.toString();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void saveContact(String userId, List<Map> contact) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            throw new Exception("用户id为空");
        }
        Date now = new Date();
        
        NjUserContactMapper userContactMapper = dao.getMapper(NjUserContactMapper.class);
        for (Map<String, Object> item : contact) {
            try {
				NjUserContact con = new NjUserContact();
				con.setContent((String) item.get("content"));
				con.setPhoneNo((String) item.get("phoneNo"));
				con.setName((String) item.get("name"));
				con.setUserId(userId);
				con.setCreateTime(now);
				con.setId(UuidUtil.get32UUID());
				con.setIsDeleted(false);
				con.setVersion(1);
				userContactMapper.insert(con);
			} catch (Exception e) {
				logger.error("上传单个通讯录发生异常,phoneNo="+item.get("phoneNo").toString()+":",e);
			}
        }
     
        return;
    }
    
    public List<NjUserContact> getContactByUserId(String userId) throws Exception {
    	
        NjUserContactMapper mapper = dao.getMapper(NjUserContactMapper.class);
        NjUserContactExample  example = new NjUserContactExample();
        example.createCriteria().andUserIdEqualTo(userId);
        
        return  mapper.selectByExample(example);
    }

    public List<NjUserContactModel> getContact(Map<String, String> paramMap) throws Exception {
        String orderId = paramMap.get("orderId");
        if (StringUtils.isEmpty(orderId)) {
            throw new Exception("订单id为空");
        }
        NjLoanOrderMapper loanOrderMapper = dao.getMapper(NjLoanOrderMapper.class);
        NjLoanOrder loanOrder = loanOrderMapper.selectByPrimaryKey(orderId);
        if (null == loanOrder) {
            throw new Exception("没有检索到订单id为" + orderId + "的订单");
        }
        NjAppUserMapper appUserMapper = dao.getMapper(NjAppUserMapper.class);
        NjAppUser appUser = appUserMapper.selectByPrimaryKey(loanOrder.getUserId());
        paramMap.put("trueName", appUser.getTrueName());
        NjUserContactMapperExtend mapper = dao.getMapper(NjUserContactMapperExtend.class);
        return mapper.getUserContact(loanOrder.getUserId());
    }

    public Date getContactLastUploadTime(String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            throw new Exception("用户id为空");
        }
        NjUserContactMapperExtend mapper = dao.getMapper(NjUserContactMapperExtend.class);
        return mapper.getLastUploadTime(userId);
    }

    public List<Map> getWorkAttMapByWorkId(String workId) throws Exception {
        if (StringUtils.isEmpty(workId)) {
            return null;
        }
        NjAppUserWorkMapperExtend mapper = dao.getMapper(NjAppUserWorkMapperExtend.class);
        return mapper.getWorkAttMapByWorkId(workId);
    }

    public List<Map> getBasicAttByBasicId(String basicInfoId) throws Exception {
        if (StringUtils.isEmpty(basicInfoId)) {
            return null;
        }
        NjAppUserBasicInfoMapperExtend mapper = dao.getMapper(NjAppUserBasicInfoMapperExtend.class);
        return mapper.getBasicAttMapByWorkId(basicInfoId);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String addOutCarInfo(NjUserCar car) throws Exception {
        NjUserCarMapper carMapper = dao.getMapper(NjUserCarMapper.class);
        carMapper.insert(car);
        return car.getId();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String addOutHouseInfo(NjUserHouse house) throws Exception {
        NjUserHouseMapper houseMapper = dao.getMapper(NjUserHouseMapper.class);
        houseMapper.insert(house);
        return house.getId();
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addUserCars(String userId, NjUserCar car) throws Exception {
        if (car == null)
            return;
        NjUserCarMapper carMapper = dao.getMapper(NjUserCarMapper.class);
        NjUserCarAttachmentMapper carAttMapper = dao.getMapper(NjUserCarAttachmentMapper.class);
        NjUserCarExample carExample = new NjUserCarExample();
        NjAppUserCarMapperExtend carExtend = dao.getMapper(NjAppUserCarMapperExtend.class);
        carExample.createCriteria().andUserIdEqualTo(userId);
        List<NjUserCar> oldCars = carExtend.getRecentCarByUserId(userId);
        Date nowTime = new Date();
        if (oldCars == null || oldCars.isEmpty()) {//没有数据
            car.setId(UuidUtil.get32UUID());
            car.setVersion(0);
            car.setDelFlag(false);
            car.setUserId(userId);
            car.setCreateDate(nowTime);
            carMapper.insert(car);
//			for(int i=0; i<cars.size();i++){
//				JSONObject m = cars.getJSONObject(i);
//				NjUserCar l= new NjUserCar();
//				l.setId(UuidUtil.get32UUID());
//				l.setCarNumber(m.getString("carNumber"));
//				l.setCarType(m.getString("carType"));
//				l.setBuyPrice(m.getString("buyPrice"));
//				l.setCarAge(m.getString("carAge"));
//				l.setRemark(m.getString("remark")==null?"":m.getString("remark"));
//				l.setUserId(userId);
//				l.setCreateDate(nowTime);
//				l.setDelFlag(false);
//				l.setVersion(currentVersion);
//				carMapper.insert(l);
//				l.setCarNumber(m.getString("carNumber"));
//				l.setCarType(m.getString("carType"));
//				l.setBuyPrice(m.getString("buyPrice"));
//				l.setCarAge(m.getString("carAge"));
//				l.setRemark(m.getString("remark")==null?"":m.getString("remark"));
//				l.setUserId(userId);
//				l.setCreateDate(nowTime);
//				l.setDelFlag(false);
//				l.setVersion(currentVersion);
//				carMapper.insert(l);
            //获取附件信息
//				JSONArray attJos = m.getJSONArray("attachment");
//				if(attJos!=null){
//					for(int j=0; i<attJos.size(); i++){
//						JSONObject att = attJos.getJSONObject(i);
//						NjUserCarAttachment carAtt = new NjUserCarAttachment();	
//						carAtt.setId(UuidUtil.get32UUID());
//						carAtt.setType(att.getInteger("type")==null ?0:att.getInteger("type"));
//						carAtt.setAttachmentId(att.getString("attachmentId"));
//						carAtt.setUserCarId(l.getId());
//						carAttMapper.insert(carAtt);
//					}
//				}
//			}
        } else {//有数据
            Integer oldVersion = carExtend.getMaxVersion(userId);
            int currentVersion = oldVersion == null ? 0 : oldVersion + 1;
            car.setId(UuidUtil.get32UUID());
            car.setVersion(currentVersion);
            car.setDelFlag(false);
            car.setUserId(userId);
            car.setCreateDate(nowTime);
            carMapper.insert(car);
//			for(int i=0; i<cars.size();i++){
//				JSONObject m = cars.getJSONObject(i);
//				NjUserCar l= new NjUserCar();
//				l.setId(UuidUtil.get32UUID());
//				l.setCarNumber(m.getString("carNumber"));
//				l.setCarType(m.getString("carType"));
//				l.setBuyPrice(m.getString("buyPrice"));
//				l.setCarAge(m.getString("carAge"));
//				l.setRemark(m.getString("remark")==null?"":m.getString("remark"));
//				l.setUserId(userId);
//				l.setCreateDate(nowTime);
//				l.setDelFlag(false);
//				l.setVersion(oldCars.get(0).getVersion());
//				carMapper.insert(l);
//				//获取附件信息
//				JSONArray attJos = m.getJSONArray("attachment");
//				if(attJos!=null){
//					for(int j=0; i<attJos.size(); i++){
//						JSONObject att = attJos.getJSONObject(i);
//						NjUserCarAttachment carAtt = new NjUserCarAttachment();	
//						carAtt.setId(UuidUtil.get32UUID());
//						carAtt.setType(att.getInteger("type")==null ?0:att.getInteger("type"));
//						carAtt.setAttachmentId(att.getString("attachmentId"));
//						carAtt.setUserCarId(l.getId());
//						carAttMapper.insert(carAtt);
//					}
//				}
//			}
        }
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_CAR, userId);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void deleteCar(String userId, List<String> carIds) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            logger.info("userid为空");
            return;
        }
        //删除缓存
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_CAR, userId);
        //获取该userId下的所有最近的车辆信息
        NjUserCarMapper carMapper = dao.getMapper(NjUserCarMapper.class);
        NjUserCarAttachmentMapper carAttMapper = dao.getMapper(NjUserCarAttachmentMapper.class);
        NjUserCarExample carExample = new NjUserCarExample();
        NjAppUserCarMapperExtend carExtend = dao.getMapper(NjAppUserCarMapperExtend.class);
        carExample.createCriteria().andUserIdEqualTo(userId);
        List<NjUserCar> oldCars = carExtend.getRecentCarByUserId(userId);
        if (oldCars == null || oldCars.isEmpty()) {
            logger.info("车辆为空");
            return;
        }

        for (String carId : carIds) {
            NjUserCar car = carMapper.selectByPrimaryKey(carId);
            car.setDelFlag(true);
            carMapper.updateByPrimaryKeySelective(car);
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public JSONArray modifyUserCars(String userId, JSONArray cars) throws Exception {
        if (cars == null || cars.isEmpty()) {
            throw new Exception("车辆信息为空");
        }
        //删除缓存
        EhCacheUtil.getInstance().remove(EhCacheConstant.ITF.APP_USER_CAR, userId);

        NjUserCarMapper carMapper = dao.getMapper(NjUserCarMapper.class);
        NjUserCarAttachmentMapper carAttMapper = dao.getMapper(NjUserCarAttachmentMapper.class);
        NjUserCarExample carExample = new NjUserCarExample();
        NjAppUserCarMapperExtend carExtend = dao.getMapper(NjAppUserCarMapperExtend.class);
        carExample.createCriteria().andUserIdEqualTo(userId);
        List<NjUserCar> oldCars = carExtend.getRecentCarByUserId(userId);
        Date nowTime = new Date();
        for (NjUserCar car : oldCars) {
            int index = -1;
            for (int i = 0; i < cars.size(); i++) {
                if (car.getId().equals(cars.getJSONObject(i).getString("id"))) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {//没有找到
                car.setVersion(car.getVersion() + 1);
                carMapper.updateByPrimaryKeySelective(car);
            } else {//找到要更新的数据
                car.setDelFlag(true);
                carMapper.updateByPrimaryKeySelective(car);
                NjUserCar modifyCar = new NjUserCar();
                JSONObject joMod = cars.getJSONObject(index);
                modifyCar.setBuyPrice(joMod.getString("buyPrice"));
                modifyCar.setCarNumber(joMod.getString("carNumber"));
                modifyCar.setCarType(joMod.getString("carType"));
                modifyCar.setCarAge(joMod.getString("carAge"));
                modifyCar.setCreateDate(nowTime);
                modifyCar.setVersion(car.getVersion() + 1);
                modifyCar.setRemark(joMod.getString("remark"));
                modifyCar.setId(UuidUtil.get32UUID());
                modifyCar.setDelFlag(false);
                modifyCar.setUserId(userId);
                carMapper.insert(modifyCar);
                joMod.put("id", modifyCar.getId());
                addCarAtt(modifyCar.getId(), joMod.getJSONArray("attachment"));
            }
        }
        return cars;
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addCarAtt(String carId, JSONArray atts) throws Exception {
        if (atts == null || atts.isEmpty())
            return;
        NjUserCarAttachmentMapper mapper = dao.getMapper(NjUserCarAttachmentMapper.class);

        for (int i = 0; i < atts.size(); i++) {
            NjUserCarAttachment att = new NjUserCarAttachment();
            att.setAttachmentId(atts.getJSONObject(i).getString("attachmentId"));
            att.setUserCarId(carId);
            att.setId(UuidUtil.get32UUID());
            att.setType(atts.getJSONObject(i).getInteger("type"));
            mapper.insert(att);
        }
    }

    public List<Map> getUserCars(String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        List<Map> l = (List<Map>) EhCacheUtil.getInstance().get(EhCacheConstant.ITF.APP_USER_CAR, userId);
        if (l != null)
            return l;
        NjAppUserCarMapperExtend carExtend = dao.getMapper(NjAppUserCarMapperExtend.class);
        l = carExtend.getRecentCarMapByUserId(userId);

        EhCacheUtil.getInstance().put(EhCacheConstant.ITF.APP_USER_CAR, userId, l);
        return l;
    }

    public List<Map> getUserCarAttachment(String carId) throws Exception {
        if (StringUtils.isEmpty(carId)) {
            return null;
        }
        NjAppUserCarMapperExtend carExtend = dao.getMapper(NjAppUserCarMapperExtend.class);
        return carExtend.getUserCarAttachByCarId(carId);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void saveUserSpot(NjAppUser user, String longtitude, String latitude) throws Exception {
        if (user == null)
            return;
        NjUserSpot spot = new NjUserSpot();
        spot.setId(UuidUtil.get32UUID());
        spot.setDelFlag(false);
        spot.setCreateDate(new Date());
        spot.setUserId(user.getId());
        spot.setLongitude(longtitude);
        spot.setLatitude(latitude);
        NjUserSpotMapper mapper = dao.getMapper(NjUserSpotMapper.class);
        mapper.insert(spot);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void modifyCertAndName(NjAppUser user, String certNo, String name) throws Exception {
        if (StringUtils.isEmpty(certNo) || StringUtils.isEmpty(name))
            return;
        user.setDefiIdentifyId(createDefiIdentifyId(certNo));
        user.setDefiTrueName(createDefiTrueName(name));
        user.setTrueName(name);
        user.setIdentifyId(certNo);
        this.updateUser(user);
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void saveLoginLog(AppUserLogin loginLog) throws Exception {
        AppUserLoginMapper mapper = dao.getMapper(AppUserLoginMapper.class);
        mapper.insert(loginLog);
    }

    public String getCertNo(NjAppUser user) {
        return user.getIdentifyId();
    }

    public String getTrueName(NjAppUser user) {
        return user.getTrueName();
    }
    
    /**
     * 保存用户房产信息
     * @param njUserHouse
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String addAppUserHouse(NjUserHouse njUserHouse,String userId) throws Exception{
    	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	NjUserHouseMapper njUserHouseMapper = dao.getMapper(NjUserHouseMapper.class);
    	int version =sm.getUserHouseOfMaxVersion(userId);
    	njUserHouse.setVersion(version+1);
    	njUserHouseMapper.insert(njUserHouse);
    	return  njUserHouse.getId();
    	
    }
    
    /**
     * 保存用户抵押房信息
     * @param njOrderPawnHouse
     * @param userId
     * @return
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String addOrderPawnHouse(NjOrderPawnHouse njOrderPawnHouse,String userId) throws Exception{
       	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
       	int version = sm.getOrderPawnHouseOfMaxVersion(userId);
    	NjOrderPawnHouseMapper mapper = dao.getMapper(NjOrderPawnHouseMapper.class);
    	njOrderPawnHouse.setVersion(version+1);
    	mapper.insert(njOrderPawnHouse);
    	return njOrderPawnHouse.getId();
    }
    
    /**
     * 更新抵押房信息
     * @param njOrderPawnHouse
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void updateOrderPawnHouse(NjOrderPawnHouse njOrderPawnHouse) throws Exception{
    	NjOrderPawnHouseMapper mapper = dao.getMapper(NjOrderPawnHouseMapper.class);
    	mapper.updateByPrimaryKey(njOrderPawnHouse);
    }
    
    /**
     * 保存用户负债信息
     * @param list
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void addAppUserDebt(List<NjUserDebtInfo> list,String userId) throws Exception{
    	
    	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	int version = sm.getUserDebtInfoOfMaxVersion(userId);
    	List<String> listId = new ArrayList<String>();
    	NjUserDebtInfoMapper mapper = dao.getMapper(NjUserDebtInfoMapper.class);
    	for(NjUserDebtInfo info :list){
    		info.setVersion(version+1);
    		mapper.insert(info);
    	}   	
    }

    /**
     * 保存用户的身份认证信息
     * @param userCert
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public String addAppUserCert(NjUserCert userCert) throws Exception {
        //获取最新的身份证信息
        NjUserCertMapperExtend certMapperExt = dao.getMapper(NjUserCertMapperExtend.class);
        NjUserCertMapper certMapper = dao.getMapper(NjUserCertMapper.class);
        NjUserCert recentCert = certMapperExt.getRecentUserCertByUserId(userCert.getUserId());

        if (recentCert == null) {//当前没有身份证信息
            userCert.setId(UuidUtil.get32UUID());
            userCert.setDelFlag(false);
            userCert.setCheckStatus(0x0);
            userCert.setCheckResult("");
            userCert.setVersion(1);
            userCert.setCreateDate(new Date());
            certMapper.insert(userCert);
            return userCert.getId();
        } else {
            if (recentCert.getCheckStatus() == 1) {
                //审核通过，不允许修改
                throw new Exception("照片已经审核通过，不允许修改");
            }
            recentCert.setCheckStatus(0x0);
            recentCert.setVersion(recentCert.getVersion() + 1);
            recentCert.setDelFlag(false);
            recentCert.setCheckResult(null);
            if (!StringUtils.isEmpty(userCert.getFrontId())) {
                if (!userCert.getFrontId().equals(recentCert.getFrontId())) {
                    recentCert.setFrontId(userCert.getFrontId());
                }
            }
            if (!StringUtils.isEmpty(userCert.getBackId())) {
                if (!userCert.getBackId().equals(recentCert.getBackId())) {
                    recentCert.setBackId(userCert.getBackId());
                }
            }
            if (!StringUtils.isEmpty(userCert.getHandCertId())) {
                if (!userCert.getHandCertId().equals(recentCert.getHandCertId())) {
                    recentCert.setHandCertId(userCert.getHandCertId());
                }
            }
            recentCert.setId(UuidUtil.get32UUID());
            certMapper.insert(recentCert);
            return recentCert.getId();
        }
    }

    public NjUserCert getRecentCert(String userId) throws Exception {
        NjUserCertMapperExtend certMapperExt = dao.getMapper(NjUserCertMapperExtend.class);
        NjUserCertMapper certMapper = dao.getMapper(NjUserCertMapper.class);
        NjUserCert recentCert = certMapperExt.getRecentUserCertByUserId(userId);
        return recentCert;
    }

    public String getHandCertImage(String userId) throws Exception {
        if (StringUtils.isEmpty(userId)) {
            return null;
        }
        //修改，先从nj_user_cert中获取，然后再从代码中获取
        NjUserCertMapperExtend uceMapper = dao.getMapper(NjUserCertMapperExtend.class);
        NjUserCert cert = uceMapper.getRecentUserCertByUserId(userId);
        if ((cert != null) && (!StringUtils.isEmpty(cert.getHandCertId()))) {
            NjUserAttachmentMapper uaMapper = dao.getMapper(NjUserAttachmentMapper.class);
            NjUserAttachment a = uaMapper.selectByPrimaryKey(cert.getHandCertId());
            if (a != null) {
                return a.getFilePath();
            } else {
                return null;
            }
        } else {
            NjUserAttachmentMapperExtend mapper = dao.getMapper(NjUserAttachmentMapperExtend.class);
            return mapper.getHandCertImageUrl(userId);
        }
    }

    public Map<String, Object> getCertCheckResult(String userId) throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("checkStatus", 0);
        result.put("checkResult", "");
        if (StringUtils.isEmpty(userId)) {
            return result;
        }
        NjUserCertMapperExtend uceMapper = dao.getMapper(NjUserCertMapperExtend.class);
        NjUserCert cert = uceMapper.getRecentUserCertByUserId(userId);
        if (cert == null) {
            return result;
        } else {
            result.put("checkStatus", cert.getCheckStatus());
            result.put("checkResult", cert.getCheckResult());
            return result;
        }
    }

    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public Map<String, Object> modifyCert(NjAppUser user, String imageHead
            , String imageEmblem, String imageHandCert) throws Exception {
        if (user == null) {
            throw new Exception("修改身份证图片时，用户不能为空");
        }
        Map<String, Object> result = new HashMap<String, Object>();
        //NjUserCert recentCert = this.getRecentCert(user.getId());
        String headId = null;
        String backId = null;
        String handCertId = null;
        //与服务器绑定
//		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
        if (imageHead != null) {
            headId = imageHead;
//			NjUserAttachmentMapper attachmentMapper = dao.getMapper(NjUserAttachmentMapper.class);
//			NjUserAttachment attachment = attachmentMapper.selectByPrimaryKey(imageHead);
//			if(null != attachment) {
//				//保存图片到服务器
//				NjUserAttachment faceIdHead = new NjUserAttachment();
//				faceIdHead.setId(UuidUtil.get32UUID());
//				faceIdHead.setFilePath(attachment.getFilePath());
//				faceIdHead.setDelFlag(false);
//				faceIdHead.setCreateDate(new Date());
////				faceIdHead.setFileSize(Long.toString((imageHead.getSize())));
//				faceIdHead.setIsTemp(false);
//				faceIdHead.setBusinessType(Constants.FACEID.FILE_HEAD);
//				//faceIdHead.setBussnessId(user.getId());
//				mapper.insert(faceIdHead);
//				headId= faceIdHead.getId();
//			}
        }
        if (imageEmblem != null) {
            backId = imageEmblem;
//			NjUserAttachmentMapper attachmentMapper = dao.getMapper(NjUserAttachmentMapper.class);
//			NjUserAttachment attachment = attachmentMapper.selectByPrimaryKey(imageEmblem);
//			if(null != attachment) {
//				NjUserAttachment faceIdEmblem = new NjUserAttachment();
//				faceIdEmblem.setId(UuidUtil.get32UUID());
//				faceIdEmblem.setFilePath(imageEmblem);
//				faceIdEmblem.setDelFlag(false);
//				faceIdEmblem.setCreateDate(new Date());
////				faceIdEmblem.setFileSize(Long.toString((imageEmblem.getSize())));
//				faceIdEmblem.setIsTemp(false);
//				faceIdEmblem.setBusinessType(Constants.FACEID.FILE_EMBLEM);
//				//faceIdEmblem.setBussnessId(user.getId());
//				mapper.insert(faceIdEmblem);			
//				backId=faceIdEmblem.getId();
//			}
        }
        //保存手持身份证照片
        if (imageHandCert != null) {
            handCertId = imageHandCert;
//			NjUserAttachmentMapper attachmentMapper = dao.getMapper(NjUserAttachmentMapper.class);
//			NjUserAttachment attachment = attachmentMapper.selectByPrimaryKey(imageEmblem);
//			if(null != attachment) {
//				NjUserAttachment faceIdHandCert = new NjUserAttachment();
//				faceIdHandCert.setId(UuidUtil.get32UUID());
//				faceIdHandCert.setFilePath(imageHandCert);
//				faceIdHandCert.setDelFlag(false);
//				faceIdHandCert.setCreateDate(new Date());
////				faceIdHandCert.setFileSize(Long.toString((imageHandCert.getSize())));
//				faceIdHandCert.setIsTemp(false);
//				faceIdHandCert.setBusinessType(Constants.FILE_TYPE.FILE_CERT_HAND_OUT);
//				//faceIdHandCert.setBussnessId(user.getId());
//				mapper.insert(faceIdHandCert);			
//				handCertId =faceIdHandCert.getId();
//			}
        }
        //创建身份证记录

        NjUserCert userCert = new NjUserCert();
        userCert.setFrontId(headId);
        userCert.setBackId(backId);
        userCert.setHandCertId(handCertId);
        userCert.setUserId(user.getId());
        appUserServiceInner.addAppUserCert(userCert);
        result.put("imageHeadId", userCert.getFrontId());
        result.put("imageEmblemId", userCert.getBackId());
        result.put("imageHandCertId", userCert.getHandCertId());

        return result;
    }

    public String getMobileTail(NjAppUser user) {
        return user.getMobile().substring(user.getMobile().length() - 4, user.getMobile().length());
    }


    /**
     * 到财富端开户
     *
     * @param user
     * @param userName
     * @param certNo
     * @throws Exception
     */
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
    public void openAccount(NjAppUser user, String userName, String certNo) throws Exception {
        // TODO Auto-generated method stub
        Map<String, Object> tfcfParams = new HashMap<String, Object>();
        String tfcfUserId = getTfcfUserId(user, user.getMobile(), "");
        tfcfParams.put("userId", tfcfUserId);
        tfcfParams.put("name", user.getTrueName());
        tfcfParams.put("identityCard", user.getIdentifyId());
        tfcfParams.put("cellphone", user.getMobile());
        String tfcfResp = tfcfHttpService.doHttpPostForTfcf(user.getMobile(), "", tfcfParams, Constants.TFCF.OPEN_ACCOUNT);
        TFCFResponseMsg response = JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class);
        if (response.getResultStatus() == 0 || response.getResultStatus() == 10) {
            Map<String, Object> result = response.getOptional();
            String newTfcfUserId = (String) result.get("userId");
            if (!user.getUserId().equals(newTfcfUserId)) {
                user.setUserId(newTfcfUserId);
                updateUser(user);
            }
        } else {
            logger.error("开户返回数据" + tfcfResp);
            throw new Exception("开户失败");
        }
    }

    public Map<String, Object> getRecentWorInfoNew(String userId) throws Exception {
        NjAppUserWorkMapperExtend workMapExt = dao.getMapper(NjAppUserWorkMapperExtend.class);
        Map<String, Object> works = workMapExt.getRecentWorkNew(userId);
        if (works == null || works.isEmpty()) {
            return null;
        } else {
            return works;
        }
    }

    public NjAppUser getAppUserByCertNo(String certNo) throws Exception {
        NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
        NjAppUserExample example = new NjAppUserExample();
        example.createCriteria().andIdentifyIdEqualTo(certNo);
        List<NjAppUser> users = mapper.selectByExample(example);
        if (null != users && !users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

	public List<NjUserRelatives> getRelativesByOrder(String orderId) throws Exception {
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
        return sm.getRelativesByOrder(orderId);
	}
	
	public  List<NjAppUser>  selectByExample(NjAppUserExample example){
		
		List<NjAppUser> list = njAppUserMapper.selectByExample(example);
		return   list;
	}

	public PageInfo<NjAppUser> selectByExample(NjAppUserExample example, String page, String limit) {
		if(!StringUtils.isBlank(page)){
			PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(limit));
		}
		List<NjAppUser> list = njAppUserMapper.selectByExample(example);
		PageInfo<NjAppUser> pageInfo = new PageInfo<>(list);
		return   pageInfo;
	}
	
	/**
	 * 贷前反欺诈页面列表数据
	 */
	public List<Map> getLoanBeforeAntiFraidData(PageData param){
		return njAppUserMapperExtend.getLoanBeforeAntiFraidData(param);
	}

	
	/**
	 * 通过企业用户ID查询企业ID
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	public List<NjCoporateUser> getNjCoporateUserByUserId(String userId) throws Exception{
		
		NjCoporateUserMapper mapper = dao.getMapper(NjCoporateUserMapper.class);
		NjCoporateUserExample example = new NjCoporateUserExample();
		example.createCriteria().andUserIdEqualTo(userId);
	
		return mapper.selectByExample(example);
	} 


	public Map<String, Object> getNjUserRelativesByMobileAndTypeMap(String orderId, String sysDictValue) throws Exception {
		Map<String,String>  map = new HashMap<String,String>();
    	map.put("orderId", orderId);
    	map.put("type", sysDictValue);
    	NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	return sm.getUserRelativesMap(map);
	}

	/**
	 * 根据订单id获取用户抵押物信息
	 * @return
	 * @throws Exception 
	 */
	public Map<String, Object> getOrderPawnHouseByOrderId(String orderId) throws Exception {
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	return sm.getOrderPawnHouseByOrderId(orderId);
	}

	/**
	 * 根据订单id获取用户负债信息
	 * @param orderId
	 * @return
	 * @throws Exception 
	 */
	public List<NjUserDebtInfo> getOrderDeptByOrderId(String orderId) throws Exception {
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	return sm.getOrderDeptByOrderId(orderId);
	}

	/**
	 * 查询用户所属企业
	 * @param companyId
	 * @throws Exception 
	 */
	public NjCoporate selectUserCompany(String companyId) throws Exception {
		NjCoporateMapper coporateMapper = dao.getMapper(NjCoporateMapper.class);
		return coporateMapper.selectByPrimaryKey(companyId);
		
	}

	/**
	 * 查询紧急联系人列表
	 * @param orderId
	 * @param sysDictValue
	 * @return
	 * @throws Exception 
	 */
	public List<NjUserRelatives> getRelativesByOrderAndType(String userId,String orderId, String sysDictValue) throws Exception {
		NjAppUserRelativesMapperExtend relExtend = dao.getMapper(NjAppUserRelativesMapperExtend.class);
		Integer maxVersion = relExtend.getMaxVersionByUserId(userId);
		NjAppUserRelativesMapperExtend sm = dao.getMapper(NjAppUserRelativesMapperExtend.class);
    	return sm.getUserRelativesList(orderId,sysDictValue,maxVersion);
	}

	/**
	 * 通过客户经理ID查询用户
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<NjAppUser> getAppUserByChannelUserId(String userId) throws Exception{
		
		NjAppUserMapper mapper = dao.getMapper(NjAppUserMapper.class);
		NjAppUserExample example = new NjAppUserExample();
		example.createCriteria().andChannelUserIdEqualTo(userId);
		return mapper.selectByExample(example);
	}

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	public boolean getTfcfAccountRemind(String userId,String sceneTypeCode) throws Exception {
    	// 构造查询条件
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("accountId", userId);
		params.put("sceneTypeCode", sceneTypeCode);
		
		// 调用天府财富的
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.REMIND_USER_SIGN);
		logger.info("天府财富账户是否需要借签约款提醒查询"+tfcfResp);
		
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("天府财富账户是否需要借签约款提醒查询");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			int resultStatus = tfcfResp1.getResultStatus();			
			if (resultStatus == 0 ) {
				//0:未签约非0：已签约
				Long total =  tfcfResp1.getTotal();
				boolean accountStatus = total == 0?true:false;
				return accountStatus;		
			} else {
				throw new HttpRequestException("天府财富账户是否需要借签约款提醒查询");
			}			
		}     	
    
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 * @throws Exception 
	 */
	public String getTfcfAccountByUserId(String userId) throws Exception {
		Map<String,Object> params = new HashMap<String,Object>();
		//根据userId获取accountId
		// 构造查询条件
		params.put("userId", userId);
		String tfcfResp = tfcfHttpService.doHttpPostForTfcf( params,Constants.TFCF.GET_USER_ACCOUNT_BY_USERID);
		logger.info("天府财富账户accountId"+tfcfResp);
		
		if (StringUtils.isEmpty(tfcfResp)) {
			throw new HttpRequestException("天府财富账户accountId");
		} else {
			ResponseMsg tfcfResp1 = new ResponseMsg(JSONObject.parseObject(tfcfResp, TFCFResponseMsg.class));
			int resultStatus = tfcfResp1.getResultStatus();			
			if (resultStatus == 0 ) {
				//0:未签约非0：已签约
				Map<String, Object> retMap =  tfcfResp1.getOptional();
				String accountId = (String) retMap.get("id");
				return accountId;		
			} else {
				throw new HttpRequestException("天府财富账户accountId");
			}			
		}     	
    
	}
	

	public boolean getXdRemind(String userId) throws Exception {
		NjUserBankCard bankCard = userBankCardService.selectUserBindCard(userId, Constants.BANKTYPE.XDTYPE);
		return bankCard == null ? false:true;
	}
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
	public void addCompanyBaseInfo(NjBaseInfoCompany baseInfoCompany) throws Exception {
		baseInfoCompany.setId(UuidUtil.get32UUID());
		NjBaseInfoCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjBaseInfoCompanyMapper.class);
		baseInfoCompanyMapper.insertSelective(baseInfoCompany);
	}
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
	public void addContactCompany(NjContactCompany contactCompany) throws Exception {
    	contactCompany.setId(UuidUtil.get32UUID());
		NjContactCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjContactCompanyMapper.class);
		baseInfoCompanyMapper.insertSelective(contactCompany);
	}
    @Transactional(rollbackFor = {Throwable.class}, readOnly = false)
	public void addScenesCompany(NjScenesCompany scenesCompany) throws Exception {
		scenesCompany.setId(UuidUtil.get32UUID());
		NjScenesCompanyMapper baseInfoCompanyMapper = dao.getMapper(NjScenesCompanyMapper.class);
		baseInfoCompanyMapper.insertSelective(scenesCompany);
		
	}
}
