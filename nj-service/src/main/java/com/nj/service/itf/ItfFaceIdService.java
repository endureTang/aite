package com.nj.service.itf;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nj.core.base.common.Constants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjFaceidRequireLogMapper;
import com.nj.dao.NjFaceidRequireMapper;
import com.nj.dao.NjUserAttachmentMapper;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjUserAttachmentMapperExtend;
import com.nj.dao.extend.NjUserCertMapperExtend;
import com.nj.model.generate.NjAppUser;
import com.nj.model.generate.NjFaceidRequire;
import com.nj.model.generate.NjFaceidRequireExample;
import com.nj.model.generate.NjFaceidRequireLog;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjOrderAttachment;
import com.nj.model.generate.NjUserAttachment;
import com.nj.model.generate.NjUserAttachmentExample;
import com.nj.model.generate.NjUserCert;
import com.nj.service.common.AppConfigService;

@Transactional(readOnly = true)
@Service("itfFaceIdService")
public class ItfFaceIdService {
	
	private static String RANDOM_STRING="abcdefg0123456789";
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	@Resource(name = "appConfigService")
	private AppConfigService appConfigService;
	
	@Resource(name="appUserServiceInner")
	private AppUserServiceInner appUserServiceInner;
	
	@Resource
	private  NjLoanOrderMapperExtend   njLoanOrderMapperExtend;
	
	private static Logger logger = LoggerFactory.getLogger(ItfFaceIdService.class);
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public Map<String,Object> ocridcard(NjAppUser user, MultipartFile imageHead, MultipartFile imageEmblem
			,MultipartFile imageHandCert) throws Exception{
		if(user ==null){
			throw new Exception("身份证上传时，用户不能为空");
		}
		
		Map<String,Object> result = new HashMap<String,Object>();
		//与服务器绑定
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		String dir =createTodayDir(appConfigService.get("nj_api.attachment_dir"));
		if(imageHead !=null){
			String originalHeadName = imageHead.getOriginalFilename();
			//生成新名字
			String newHeadName ="";
			newHeadName = createNewName(originalHeadName);
			//String webHeadUrl =Constants.FILE_DIR.ITF_ATTACHMENT_WEB_DIR+newHeadName;
			//String fileHeaUrl =Constants.FILE_DIR.ITF_ATTACHMENT_DIR+webHeadUrl;
			
			String webHeadUrl =appConfigService.get("nj_api.attachment_web_dir")+dir+"/"+newHeadName;
			String fileHeaUrl =appConfigService.get("nj_api.attachment_dir")+dir+"/"+newHeadName;
			//保存图片到服务器
			logger.debug("the file path is:"+fileHeaUrl);
			File headFile = new File(fileHeaUrl);
			headFile.createNewFile();
			FileOutputStream headIo = new FileOutputStream(headFile);
			headIo.write(imageHead.getBytes());
			headIo.flush();
			headIo.close();
			
			NjUserAttachment faceIdHead = new NjUserAttachment();
			faceIdHead.setId(UuidUtil.get32UUID());
			faceIdHead.setFilePath(webHeadUrl);
			faceIdHead.setDelFlag(false);
			faceIdHead.setCreateDate(new Date());
			faceIdHead.setFileSize(Long.toString((imageHead.getSize())));
			faceIdHead.setIsTemp(false);
			faceIdHead.setBusinessType(Constants.FACEID.FILE_HEAD);
			//faceIdHead.setBussnessId(user.getId());
			mapper.insert(faceIdHead);
			
			result.put("imageHeadId", faceIdHead.getId());
		}
		if (imageEmblem != null) {
			String originalEmbName = imageEmblem.getOriginalFilename();
			// 获取国徽面原始名字的后缀
			String newEmbName ="";
			newEmbName = createNewName(originalEmbName);
			//String webEmbUrl =Constants.FILE_DIR.ITF_ATTACHMENT_WEB_DIR+newEmbName;
			String webEmbUrl =appConfigService.get("nj_api.attachment_web_dir")+dir+"/"+newEmbName;
			//String fileEmbUrl =Constants.FILE_DIR.ITF_ATTACHMENT_DIR+webEmbUrl;
			String fileEmbUrl =appConfigService.get("nj_api.attachment_dir")+dir+"/"+newEmbName;
			//保存图片到服务器
			logger.debug("the file path is:"+fileEmbUrl);
			File embFile = new File(fileEmbUrl);
			embFile.createNewFile();
			FileOutputStream embIo = new FileOutputStream(embFile);
			embIo.write(imageEmblem.getBytes());
			embIo.flush();
			embIo.close();

			NjUserAttachment faceIdEmblem = new NjUserAttachment();
			faceIdEmblem.setId(UuidUtil.get32UUID());
			faceIdEmblem.setFilePath(webEmbUrl);
			faceIdEmblem.setDelFlag(false);
			faceIdEmblem.setCreateDate(new Date());
			faceIdEmblem.setFileSize(Long.toString((imageEmblem.getSize())));
			faceIdEmblem.setIsTemp(false);
			faceIdEmblem.setBusinessType(Constants.FACEID.FILE_EMBLEM);
			//faceIdEmblem.setBussnessId(user.getId());
			mapper.insert(faceIdEmblem);			
			result.put("imageEmblemId", faceIdEmblem.getId());
		}
		//保存手持身份证照片
		if (imageHandCert != null) {
			String originalHandCert = imageHandCert.getOriginalFilename();
			// 获取手持身份证原始名字的后缀
			String newHandCertName ="";
			newHandCertName = createNewName(originalHandCert);
			String webHandCertUrl =appConfigService.get("nj_api.attachment_web_dir")+dir+"/"+newHandCertName;
			String fileHandCertUrl =appConfigService.get("nj_api.attachment_dir")+dir+"/"+newHandCertName;
			//保存图片到服务器
			logger.debug("the file path is:"+fileHandCertUrl);
			File handCertFile = new File(fileHandCertUrl);
			handCertFile.createNewFile();
			FileOutputStream handCertIo = new FileOutputStream(handCertFile);
			handCertIo.write(imageHandCert.getBytes());
			handCertIo.flush();
			handCertIo.close();

			NjUserAttachment faceIdHandCert = new NjUserAttachment();
			faceIdHandCert.setId(UuidUtil.get32UUID());
			faceIdHandCert.setFilePath(webHandCertUrl);
			faceIdHandCert.setDelFlag(false);
			faceIdHandCert.setCreateDate(new Date());
			faceIdHandCert.setFileSize(Long.toString((imageHandCert.getSize())));
			faceIdHandCert.setIsTemp(false);
			faceIdHandCert.setBusinessType(Constants.FILE_TYPE.FILE_CERT_HAND_OUT);
			//faceIdHandCert.setBussnessId(user.getId());
			mapper.insert(faceIdHandCert);			
			result.put("imageHandCertId", faceIdHandCert.getId());
		}
		//创建身份证记录
		NjUserCert userCert =new NjUserCert();
		userCert.setFrontId((String)result.get("imageHeadId"));
		userCert.setBackId((String)result.get("imageEmblemId"));
		userCert.setHandCertId((String)result.get("imageHandCertId"));
		userCert.setUserId(user.getId());
		appUserServiceInner.addAppUserCert(userCert);		
		return result;
	}
	
	public List<NjUserAttachment> getFaceIdHeadImage(NjAppUser user) throws Exception{
		if(user ==null){
			return null;
		}
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachmentExample example = new NjUserAttachmentExample();
		example.createCriteria().andBusinessTypeEqualTo(Constants.FACEID.FILE_HEAD)
			.andDelFlagEqualTo(false)
			.andBussnessIdEqualTo(user.getId());
		return  mapper.selectByExample(example);	
				
	}
	
	public List<NjUserAttachment> getFaceIdEmblemImage(NjAppUser user) throws Exception{
		if(user ==null){
			return null;
		}
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		NjUserAttachmentExample example = new NjUserAttachmentExample();
		example.createCriteria().andBusinessTypeEqualTo(Constants.FACEID.FILE_EMBLEM)
			.andDelFlagEqualTo(false)
			.andBussnessIdEqualTo(user.getId());
		return  mapper.selectByExample(example);	
	}
	
	/**
	 * @param order
	 * @return 订单对应的faceid 图片信息：faceIdImage, headImage, emblemImage
	 * 
	 * @throws Exception
	 */
	public Map<String, Object> getFaceIdImageUrls(NjLoanOrder order) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		if(order ==null){
			return result;
		}
		String faceIdImage=null;
		String headImage =null;
		String emblemImage =null;
		logger.debug("start to get faceidUrls");
		NjUserAttachmentMapperExtend mapper = dao.getMapper(NjUserAttachmentMapperExtend.class);
		//获取faceIdImage		
		faceIdImage = mapper.getFaceIdImageUrl(order.getId());
		if(!StringUtils.isEmpty(faceIdImage)){
			//result.put("faceIdImage", Constants.URL.NJ_API+faceIdImage);
			result.put("faceIdImage", faceIdImage);
		}
		logger.debug("faceIdImage Url is :"+faceIdImage);
		//获取headImage
		if(!StringUtils.isEmpty(order.getUserId())){
			headImage = getCertHeadImage(order.getUserId());
			emblemImage = getCertEmblemImage(order.getUserId());
		}
		if(!StringUtils.isEmpty(headImage)){
			//result.put("headImage", Constants.URL.NJ_API+headImage);
			result.put("headImage", headImage);
		}
		if(!StringUtils.isEmpty(emblemImage)){
			//result.put("emblemImage", Constants.URL.NJ_API+emblemImage);
			result.put("emblemImage", emblemImage);
		}
		logger.debug("emblemImage Url is :"+emblemImage);
		return result;
	}
	
	public String getCertHeadImage(String userId) throws Exception{
		if(StringUtils.isEmpty(userId)){
			return null;
		}
		//修改，先从nj_user_cert中获取，然后再从代码中获取
		NjUserCertMapperExtend uceMapper = dao.getMapper(NjUserCertMapperExtend.class);
		NjUserCert cert = uceMapper.getRecentUserCertByUserId(userId);
		if((cert!=null) &&(!StringUtils.isEmpty(cert.getFrontId()))){
			NjUserAttachmentMapper uaMapper = dao.getMapper(NjUserAttachmentMapper.class);
			NjUserAttachment a= uaMapper.selectByPrimaryKey(cert.getFrontId());
			if(a!=null){
				return a.getFilePath();
			}
			else{
				return null;
			}
		}else{
			NjUserAttachmentMapperExtend mapper = dao.getMapper(NjUserAttachmentMapperExtend.class);
			return mapper.getHeadImageUrl(userId);
		}
	}
	
	public String getCertEmblemImage(String userId) throws Exception{
		if(StringUtils.isEmpty(userId)){
			return null;
		}
		NjUserCertMapperExtend uceMapper = dao.getMapper(NjUserCertMapperExtend.class);
		NjUserCert cert = uceMapper.getRecentUserCertByUserId(userId);
		if((cert!=null) &&(!StringUtils.isEmpty(cert.getBackId()))){
			NjUserAttachmentMapper uaMapper = dao.getMapper(NjUserAttachmentMapper.class);
			NjUserAttachment a= uaMapper.selectByPrimaryKey(cert.getBackId());
			if(a!=null){
				return a.getFilePath();
			}
			else{
				return null;
			}
		}else{
			NjUserAttachmentMapperExtend mapper = dao.getMapper(NjUserAttachmentMapperExtend.class);
			return mapper.getEmblemImageUrl(userId);
		}
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public Map<String,Object> verify(NjAppUser user, MultipartFile imageBest , MultipartFile imageEnv,
			MultipartFile image1, MultipartFile image2 , String delta)throws Exception{
		if(user ==null){
			throw new Exception("活体识别时，用户不能为空");
		}
		
		Map<String,Object> result = new HashMap<String,Object>();
		NjUserAttachmentMapper mapper = dao.getMapper(NjUserAttachmentMapper.class);
		String dir =createTodayDir(appConfigService.get("nj_api.attachment_dir"));
		if(imageBest == null){
			logger.error("image_best 不能为空");
			throw new Exception("image_best不能为空");
		}
		else{
			String originalBestName = imageBest.getOriginalFilename();
			logger.info("originalBestName="+originalBestName);
			String bestApp=null;
			// 获取国徽面原始名字的后缀
			String newBestName ="";
			newBestName = createNewName(originalBestName);
			//String webBestUrl =Constants.FILE_DIR.ITF_ATTACHMENT_WEB_DIR+newBestName;
			String webBestUrl =appConfigService.get("nj_api.attachment_web_dir")+dir+"/"+newBestName;
			//String fileBestUrl =Constants.FILE_DIR.ITF_ATTACHMENT_DIR+webBestUrl;
			String fileBestUrl =appConfigService.get("nj_api.attachment_dir")+dir+"/"+newBestName;
			//保存图片到服务器
			File bestFile = new File(fileBestUrl);
			bestFile.createNewFile();
			FileOutputStream bestIo = new FileOutputStream(bestFile);
			bestIo.write(imageBest.getBytes());
			bestIo.flush();
			bestIo.close();
			
			NjUserAttachment bestAtt = new NjUserAttachment();
			bestAtt.setId(UuidUtil.get32UUID());
			bestAtt.setFilePath(webBestUrl);
			bestAtt.setDelFlag(false);
			bestAtt.setCreateDate(new Date());
			bestAtt.setFileSize(Long.toString((imageBest.getSize())));
			bestAtt.setIsTemp(false);
			bestAtt.setBusinessType(Constants.FACEID.FILE_IMAGE_BEST);
			bestAtt.setRemarks(delta);
			mapper.insert(bestAtt);
			
			result.put("imageBestId", bestAtt.getId());
		}
		
		if(imageEnv !=null){
			
			String originalEnvName = imageEnv.getOriginalFilename();
			String envApp = null;
			// 获取国徽面原始名字的后缀
			String newEnvName ="";
			newEnvName = createNewName(originalEnvName);
			//String webEnvUrl =Constants.FILE_DIR.ITF_ATTACHMENT_WEB_DIR+newEnvName;
			String webEnvUrl =appConfigService.get("nj_api.attachment_web_dir")+dir+"/"+newEnvName;
			//String fileEnvUrl =Constants.FILE_DIR.ITF_ATTACHMENT_DIR+webEnvUrl;
			String fileEnvUrl =appConfigService.get("nj_api.attachment_dir")+dir+"/"+newEnvName;
			//保存图片到服务器
			File envFile = new File(fileEnvUrl);
			envFile.createNewFile();
			FileOutputStream envIo = new FileOutputStream(envFile);
			envIo.write(imageEnv.getBytes());
			envIo.flush();
			envIo.close();
			
			NjUserAttachment envAtt = new NjUserAttachment();
			envAtt.setId(UuidUtil.get32UUID());
			envAtt.setFilePath(webEnvUrl);
			envAtt.setDelFlag(false);
			envAtt.setCreateDate(new Date());
			envAtt.setFileSize(Long.toString((imageEnv.getSize())));
			envAtt.setIsTemp(false);
			envAtt.setBusinessType(Constants.FACEID.FILE_IMAGE_ENV);
			mapper.insert(envAtt);
			
			result.put("imageEnvId", envAtt.getId());		
		}
		
		if(image1 !=null){
			String original1Name = image1.getOriginalFilename();
			String oneApp =null;
			String new1Name ="";
			new1Name = createNewName(original1Name);
			//String web1Url =Constants.FILE_DIR.ITF_ATTACHMENT_WEB_DIR+new1Name;
			String web1Url =appConfigService.get("nj_api.attachment_web_dir")+dir+"/"+new1Name;
			//String file1Url =Constants.FILE_DIR.ITF_ATTACHMENT_DIR+web1Url;
			String file1Url =appConfigService.get("nj_api.attachment_dir")+dir+"/"+new1Name;
			//保存图片到服务器
			File oneFile = new File(file1Url);
			oneFile.createNewFile();
			FileOutputStream oneIo = new FileOutputStream(oneFile);
			oneIo.write(image1.getBytes());
			oneIo.flush();
			oneIo.close();
			
			NjUserAttachment oneAtt = new NjUserAttachment();
			oneAtt.setId(UuidUtil.get32UUID());
			oneAtt.setFilePath(web1Url);
			oneAtt.setDelFlag(false);
			oneAtt.setCreateDate(new Date());
			oneAtt.setFileSize(Long.toString((image1.getSize())));
			oneAtt.setIsTemp(false);
			oneAtt.setBusinessType(Constants.FACEID.FILE_IMAGE1);
			mapper.insert(oneAtt);
			
			result.put("image1Id", oneAtt.getId());				
			
		}
		if (image2 != null) {
			String original2Name = image2.getOriginalFilename();

			String twoApp = null;

			String new2Name ="";
			new2Name = createNewName(original2Name);
			//String web2Url =Constants.FILE_DIR.ITF_ATTACHMENT_WEB_DIR+new2Name;
			String web2Url =appConfigService.get("nj_api.attachment_web_dir")+dir+"/"+new2Name;
			//String file2Url =Constants.FILE_DIR.ITF_ATTACHMENT_DIR+web2Url;
			String file2Url =appConfigService.get("nj_api.attachment_dir")+dir+"/"+new2Name;
			//保存图片到服务器
			File twoFile = new File(file2Url);
			twoFile.createNewFile();
			FileOutputStream twoIo = new FileOutputStream(twoFile);
			twoIo.write(image2.getBytes());
			twoIo.flush();
			twoIo.close();
			
			NjUserAttachment twoAtt = new NjUserAttachment();
			twoAtt.setId(UuidUtil.get32UUID());
			twoAtt.setFilePath(web2Url);
			twoAtt.setDelFlag(false);
			twoAtt.setCreateDate(new Date());
			twoAtt.setFileSize(Long.toString((image2.getSize())));
			twoAtt.setIsTemp(false);
			twoAtt.setBusinessType(Constants.FACEID.FILE_IMAGE2);
			mapper.insert(twoAtt);
			
			result.put("image2Id", twoAtt.getId());	
		}
		return result;
	}
	
	public static String createNewName(String originalName){
		//生成文件名
		String newName;
		int dotPlace =originalName.lastIndexOf(".");
		String postPix = "";
		if(dotPlace>0){
			postPix = originalName.substring(dotPlace+1);
		}
		
		String randomName = RandomStringUtils.random(32,"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		if(StringUtils.isEmpty(postPix)){
			newName = randomName;
		}
		else{
			newName =  randomName+"."+postPix;
		}
		return newName;
	}
	
	public NjFaceidRequireLog saveRequireLog(NjFaceidRequireLog log) throws Exception {
		log.setId(UuidUtil.get32UUID());
		NjFaceidRequireLogMapper mapper = dao.getMapper(NjFaceidRequireLogMapper.class);
		mapper.insert(log);
		return log;
	}
	
	public NjFaceidRequire saveRequire(NjFaceidRequire req) throws Exception {
		req.setId(UuidUtil.get32UUID());
		NjFaceidRequireMapper mapper = dao.getMapper(NjFaceidRequireMapper.class);
		mapper.insert(req);
		return req;
	}
	
	public NjFaceidRequire getRequireByImageId(String imagePath) throws Exception{
		NjFaceidRequireMapper mapper = dao.getMapper(NjFaceidRequireMapper.class);
		NjFaceidRequireExample example = new NjFaceidRequireExample();
		example.createCriteria().andImageIdEqualTo(imagePath);
		example.setOrderByClause("create_time desc");
		List<NjFaceidRequire> l= mapper.selectByExample(example);
		return (l==null)||(l.isEmpty()) ? null : l.get(0);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjFaceidRequire saveRequire(String imageName ,String result) throws Exception{
		NjFaceidRequireMapper mapper = dao.getMapper(NjFaceidRequireMapper.class);
		NjFaceidRequire req = new NjFaceidRequire();
		req.setCreateTime(new Date());
		req.setId(UuidUtil.get32UUID());
		req.setImageId(imageName);
		req.setResult(result);
		mapper.insert(req);
		return req;
		
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public NjFaceidRequireLog saveRequireLog(String imageName ,String requestId,String result) throws Exception{
		NjFaceidRequireLogMapper mapper = dao.getMapper(NjFaceidRequireLogMapper.class);
		
		NjFaceidRequireLog req = new NjFaceidRequireLog();
		req.setCreateTime(new Date());
		req.setId(UuidUtil.get32UUID());
		req.setImageId(imageName);
		req.setResult(result);
		req.setRequestId(requestId);
		mapper.insert(req);
		return req;
	}
	
	/**
	 * 在prefix下创建一个以日命名的目录
	 * @param prefix
	 * @return
	 * 返回当前日期目录相对路径
	 */
	public static String createTodayDir(String prefix){
		if(StringUtils.isEmpty(prefix)){
			return null;
		}
		Date now = new Date();
		String today= new SimpleDateFormat("YYYYMMdd").format(now);
		String dirStr=prefix+"/"+today;
		File dir = new File(dirStr);
		if(dir.exists()){
			return today;
		}
		else{
			dir.mkdirs();
			return today;
		}		
	}
	
	
	public String getOrderHeadImageOldByOrderId(String orderId)throws Exception{
		String headUrl =null;
		NjLoanOrderMapperExtend omeMapper = dao.getMapper(NjLoanOrderMapperExtend.class);	
		headUrl= omeMapper.getOrderAttByIdAndType(orderId, Constants.FILE_TYPE.FILE_CERT_FRONT_OUT);
		if(StringUtils.isEmpty(headUrl)){
			Map<String, Object> result =omeMapper.getOldCertHeadImgInner(orderId);
			if(result !=null && !result.isEmpty()){
				return (String)result.get("url");
			}
			else{
				return null;
			}
		}
		return headUrl;
	}
	
	public String getOrderEmblemImageOldByOrderId(String orderId)throws Exception{
		String backUrl =null;
		NjLoanOrderMapperExtend omeMapper = dao.getMapper(NjLoanOrderMapperExtend.class);	
		backUrl= omeMapper.getOrderAttByIdAndType(orderId,Constants.FILE_TYPE.FILE_CERT_BACK_OUT);
		if(StringUtils.isEmpty(backUrl)){
			Map<String, Object> result =omeMapper.getOldCertBackImgInner(orderId);
			if(result !=null && !result.isEmpty()){
				return (String)result.get("url");
			}
			else{
				return null;
			}
		}
		return backUrl;
	}
	
	public String getOrderHandCertImageOldByOrderId(String orderId)throws Exception{
		String handUrl =null;
		NjLoanOrderMapperExtend omeMapper = dao.getMapper(NjLoanOrderMapperExtend.class);	
		handUrl= omeMapper.getOrderAttByIdAndType(orderId,Constants.FILE_TYPE.FILE_CERT_HAND_OUT);
		if(StringUtils.isEmpty(handUrl)){
			Map<String, Object> result =omeMapper.getOldCertHandImgInner(orderId);
			if(result !=null && !result.isEmpty()){
				return (String)result.get("url");
			}
			else{
				return null;
			}
		}
		return handUrl;
	}
	/**
	 * @param order
	 * @return headImage:身份证前面照片url,emblemImage:身份证后面照片，handCertImage:手持身份证照片
	 * @throws Exception
	 * 
	 */
	public Map<String, Object> getCertImageByOrder(NjLoanOrder order) throws Exception{
		NjLoanOrderMapperExtend omeMapper = dao.getMapper(NjLoanOrderMapperExtend.class);		
		List<Map> rets =omeMapper.getCertImageByOrderIdNew(order.getId());
		Map<String, Object> ret = ((rets==null||rets.size()==0)?new HashMap<String,Object>():rets.get(0));
		if((ret==null) || StringUtils.isEmpty((String)ret.get("headImage"))){//就是指在cert表没有身份证正面照片
			ret.put("headImage", getOrderHeadImageOldByOrderId(order.getId()));
		}
		if((ret==null) || StringUtils.isEmpty((String)ret.get("emblemImage"))){//就是指在cert表没有身份证正面照片
			ret.put("emblemImage", getOrderEmblemImageOldByOrderId(order.getId()));
		}
		if((ret==null) || StringUtils.isEmpty((String)ret.get("handCertImage"))){//就是指在cert表没有身份证正面照片
			ret.put("handCertImage", getOrderHandCertImageOldByOrderId(order.getId()));
		}
		return ret;
	}
	
	public String getOrderHuotiImageOldByOrderId(String orderId) throws Exception{
		NjLoanOrderMapperExtend omeMapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		return omeMapper.getOrderAttByIdAndType(orderId,Constants.FACEID.FILE_IMAGE_BEST);
	}
	
	public List<String> getHuotiImageByOrder(NjLoanOrder order) throws Exception{
		List<String> ret =new ArrayList<String>();
		NjLoanOrderMapperExtend omeMapper = dao.getMapper(NjLoanOrderMapperExtend.class);
		ret =omeMapper.getHuotiImageByOrderIdNew(order.getId());
		if(ret==null || ret.isEmpty()){//查不到数据，表明是老版本的订单
			ret.add(getOrderHuotiImageOldByOrderId(order.getId()));
		}
		return ret;
	}
	
	public List<Map<String,Object>>  getOrderAttById(Map  map){
		List<Map<String, Object>> list = njLoanOrderMapperExtend.getOrderAttById(map);
		return list;
	}
	
	public List<NjOrderAttachment>  getOrderAttByIdAndFileTag(Map  map){
		List<NjOrderAttachment> list = njLoanOrderMapperExtend.getOrderAttByIdAndFileTag(map);
		return list;
	}
	
}
