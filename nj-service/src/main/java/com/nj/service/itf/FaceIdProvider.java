package com.nj.service.itf;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.util.faceId.FaceidUtil;
import com.nj.model.generate.NjFaceidRequire;
import com.nj.service.common.AppConfigService;

@Service("faceIdProvider")
public class FaceIdProvider {
	
	private static Logger logger = LoggerFactory.getLogger(FaceIdProvider.class);
	
	@Resource(name="itfFaceIdService")
	private ItfFaceIdService itfFaceIdService;
	
	@Resource(name="appConfigService")
	private AppConfigService appConfigService;
	
	/**
	 * { "time_used": 320, "request_id":
	 * "1457432550,b70ab3a8-ee37-4f90-a2bd-007e23a970e2", "address":
	 * "北京市海淀区XXXX", "birthday": "1987/01/01" "gender": "男", "id_card_number":
	 * "xxxxxx19910602xxxx", "name": "陈XX", "race": "汉", "side": "front",
	 * "legality": { "ID Photo": 0.855, "Temporary ID Photo ": 0, "Photocopy":
	 * 0.049, "Screen": 0.096, "Edited": 0 } }
	 * 
	 * @param userId
	 * @return
	 */
	public String verifyCertHeadImage(String userId) throws Exception{
		String headImageUrl = itfFaceIdService.getCertHeadImage(userId);
		String imagePath=getImagePathFromUrl(headImageUrl);
		String imageName = getImageNameFromUrl(headImageUrl);
		if(StringUtils.isEmpty(imagePath)){
			logger.info("找不到用户id="+userId+" 的身份证正面照片");
		}
		
		NjFaceidRequire require = itfFaceIdService.getRequireByImageId(imageName);
		//本地数据库有该请求
		if(require!=null &&(!StringUtils.isEmpty(require.getResult()))){
			return require.getResult();
		}
		//本地数据库没有该请求，请求faceid服务器
		String faceIdRes = FaceidUtil.ocridCard(imagePath);
		//返回数据为空
		if(StringUtils.isEmpty(faceIdRes)){
			return null;
		}
		//faceid服务器返回数据非空
		JSONObject faceIdJs = JSONObject.parseObject(faceIdRes);
		//保存结果到日志数据库
		itfFaceIdService.saveRequireLog(imageName, faceIdJs.getString("request_id"),faceIdRes);
		//处理返回结果
		faceIdJs.remove("request_id");
		faceIdJs.remove("time_used");
		faceIdJs.remove("head_rect");
		String birthday =null;
		//修改birthday格式
		if(faceIdJs.containsKey("birthday")){
			JSONObject birth= faceIdJs.getJSONObject("birthday");
			if(birth.containsKey("day")&& birth.containsKey("month")&&birth.containsKey("year")){
				birthday=birth.getString("year")+"/"+birth.getString("month")+"/"+birth.getString("day");
			}
		}
		faceIdJs.remove("birthday");
		faceIdJs.put("birthday",birthday);
		String faceIdRes2=faceIdJs.toJSONString();
		itfFaceIdService.saveRequire(imageName, faceIdRes2);
		return faceIdRes2;		
	}
	
	
	/**
	 * { "issued_by":
	 * "北京市公安局海淀分局", "side": "back", "valid_date": "2010.11.13-2020.11.13",
	 * "legality": { "ID Photo": 0.855, "Temporary ID Photo": 0, "Photocopy":
	 * 0.049, "Screen": 0.096, "Edited": 0 } }
	 * 
	 * @param userId
	 * @return
	 */
	public String verifyCertEmblemImage(String userId) throws Exception{
		String headImageUrl = itfFaceIdService.getCertEmblemImage(userId);
		String imagePath=getImagePathFromUrl(headImageUrl);
		String imageName = getImageNameFromUrl(headImageUrl);
		if(StringUtils.isEmpty(imagePath)){
			logger.info("找不到用户id="+userId+" 的身份证正面照片");
		}
		
		NjFaceidRequire require = itfFaceIdService.getRequireByImageId(imageName);
		//本地数据库有该请求
		if(require!=null &&(!StringUtils.isEmpty(require.getResult()))){
			return require.getResult();
		}
		//本地数据库没有该请求，请求faceid服务器
		String faceIdRes = FaceidUtil.ocridCard(imagePath);
		//返回数据为空
		if(StringUtils.isEmpty(faceIdRes)){
			return null;
		}
		//faceid服务器返回数据非空
		JSONObject faceIdJs = JSONObject.parseObject(faceIdRes);
		//保存结果到日志数据库
		itfFaceIdService.saveRequireLog(imageName, faceIdJs.getString("request_id"),faceIdRes);
		//处理返回结果
		faceIdJs.remove("request_id");
		faceIdJs.remove("time_used");
		faceIdJs.remove("head_rect");
		String birthday =null;
		//修改birthday格式
		if(faceIdJs.containsKey("birthday")){
			JSONObject birth= faceIdJs.getJSONObject("birthday");
			if(birth.containsKey("day")&& birth.containsKey("month")&&birth.containsKey("year")){
				birthday=birth.getString("year")+"/"+birth.getString("month")+"/"+birth.getString("day");
			}
		}
		faceIdJs.remove("birthday");
		faceIdJs.put("birthday",birthday);
		String faceIdRes2=faceIdJs.toJSONString();
		itfFaceIdService.saveRequire(imageName, faceIdRes2);
		return faceIdRes2;		
	}
	
	private String getImageNameFromUrl(String url){
		if(StringUtils.isEmpty(url)){
			return null;
		}
		int index = url.lastIndexOf('/');
		return url.substring(index+1);
	}
	private String getImagePathFromUrl(String url){
		if(StringUtils.isEmpty(url)){
			return null;
		}
		int index = url.lastIndexOf('/');
		return appConfigService.get("nj_api.attachment_dir")+url.substring(index+1);
	}
	/**
	 * @param orderId:订单id
	 * @param name:姓名，如果为空，则去用户表查
	 * @param certNo：身份证：如果为空则去用户表查
	 * @return：返回结果： {
	 *            "result_faceid":{ "confidence":68.918, "thresholds":{
	 *            "1e-3":64, "1e-4":69, "1e-5":74, "1e-6":79.9 } },
	 *            "result_ref1":{ "confidence":68.918, "thresholds":{ "1e-3":64,
	 *            "1e-4":69, "1e-5":74, "1e-6":79.9 } }, "id_exceptions":{
	 *            "id_attacked":0, "id_photo_monochrome":0 }, "faces":[ {
	 *            "quality":38.221, "quality_threshold":30.1, "rect":{
	 *            "left":0.18, "top":0.18, "width":0.596, "height":0.596 },
	 *            "orientation":90 } ], "face_genuineness":{
	 *            "synthetic_face_confidence":0.88,
	 *            "synthetic_face_threshold":0.5, "mask_confidence":0.32,
	 *            "mask_threshold":0.5, "screen_replay_confidence":0.0,
	 *            "screen_replay_threshold":0.5, "face_replaced":0 },
	 *            "data_source_image_update_status":"updated"
	 *            }
	 * @throws Exception
	 */
/*	
	public String faceIdVerify(String orderId, String name, String certNo) throws Exception{
		if(StringUtils.isEmpty(orderId)){
			logger.error("orderId is empty");
			throw new Exception("orderId is empty");
		}
		String serviceResp =itfFaceIdService.getVerifyResult(orderId);
		if(!StringUtils.isEmpty(serviceResp)){
			return serviceResp;
		}
		certNo = getCertNo(orderId, certNo);
		name = getName(orderId, name);
		if(StringUtils.isEmpty(certNo) || StringUtils.isEmpty(name)){
			logger.error("身份证或姓名为空");
			throw new Exception("身份证或姓名为空");
		}
		Map<String,Object> result = itfFaceIdService.getVerifyImageParams(orderId); //返回的是照片名
		String delta =(String)result.get("delta");
		String imageBestUrl = StringUtils.isEmpty((String)result.get("imageBestName"))? ""
				: Constants.FILE_DIR.ITF_ATTACHMENT_DIR+(String)result.get("imageBestName");
		
		String imageEnvUrl = StringUtils.isEmpty((String)result.get("imageEnvName"))? ""
				: Constants.FILE_DIR.ITF_ATTACHMENT_DIR+(String)result.get("imageEnvName");
		
		String image1Url = StringUtils.isEmpty((String)result.get("image1Name"))? ""
				: Constants.FILE_DIR.ITF_ATTACHMENT_DIR+(String)result.get("image1Name");
		
		String image2Url = StringUtils.isEmpty((String)result.get("image2Name"))? ""
				: Constants.FILE_DIR.ITF_ATTACHMENT_DIR+(String)result.get("image2Name");
		
		Map<String, String> params = new HashMap<String, String>();
		Map<String, byte[]> files = new HashMap<String, byte[]>();
		//设置比对参数
		params.put("comparison_type", "1");
		params.put("face_image_type", "meglive");
		params.put("idcard_name", name);
		params.put("idcard_number", certNo);
		params.put("delta", delta);
		
		// imageBest
		byte[] imageBestByte = null;
		if (!StringUtils.isEmpty(imageBestUrl)) {
			if (!StringUtils.isEmpty(imageBestUrl)) {
				File imageBestFile = new File(imageBestUrl);
				InputStream imageBestIn = new FileInputStream(imageBestFile);
				try {
					imageBestByte = IOUtils.toByteArray(imageBestIn);
				} finally {
					imageBestIn.close();
				}
			}
			if (imageBestByte == null) {
				logger.error("orderId:" + orderId + " imageBest 读取为空");
				throw new Exception("imageBest为空");
			}
			files.put("image_best", imageBestByte);
		} else {
			logger.error("orderId:" + orderId + " imageBest url 为空");
			throw new Exception("imageBest为空");
		}
		// imageEnv
		byte[] imageEnvByte = null;
		if (!StringUtils.isEmpty(imageEnvUrl)) {
			if (!StringUtils.isEmpty(imageEnvUrl)) {
				File imageEnvFile = new File(imageEnvUrl);
				InputStream imageEnvIn = new FileInputStream(imageEnvFile);
				try {
					imageEnvByte = IOUtils.toByteArray(imageEnvIn);
				} finally {
					imageEnvIn.close();
				}
			}
			if (imageEnvByte != null) {
				files.put("image_env", imageEnvByte);
			}
		}
		// image1
		byte[] image1Byte = null;
		if (!StringUtils.isEmpty(image1Url)) {
			if (!StringUtils.isEmpty(image1Url)) {
				File image1File = new File(image1Url);
				InputStream image1In = new FileInputStream(image1File);
				try {
					image1Byte = IOUtils.toByteArray(image1In);
				} finally {
					image1In.close();
				}
			}
			if (image1Byte != null) {
				files.put("image_action[1]", image1Byte);
			}
		}
		// image2
		byte[] image2Byte = null;
		if (!StringUtils.isEmpty(image2Url)) {
			if (!StringUtils.isEmpty(image2Url)) {
				File image2File = new File(image2Url);
				InputStream image2In = new FileInputStream(image2File);
				try {
					image2Byte = IOUtils.toByteArray(image2In);
				} finally {
					image2In.close();
				}
			}
			if (image2Byte != null) {
				files.put("image_action[1]", image2Byte);
			}
		}
		String resp =FaceidUtil.verify(params, files);
		JSONObject respJo = JSONObject.parseObject(resp);
		//生成日志
		if(respJo ==null){
			logger.error("faceid verify 失败");
			throw new Exception("faceid verify 失败");
		}
		saveRequireLog(respJo, (String)result.get("imageBestAttachmentId"));
		saveRequire(respJo,(String)result.get("imageBestAttachmentId"));
		if(!StringUtils.isEmpty(respJo.getString("error_message"))){
			logger.error("faceid verify 失败");
			throw new Exception("faceid verify 失败");
		}
		else{
			respJo.remove("request_id");
			respJo.remove("time_used");
			respJo.remove("data_source_image_update_status");
			return respJo.toJSONString();
		}
	}
	
	private NjFaceidRequireLog saveRequireLog(JSONObject jo, String attachId)throws Exception{
		NjFaceidRequireLog log = new NjFaceidRequireLog();
		log.setCreateTime(new Date());
		log.setImageId(attachId);
		log.setRequestId(jo.getString("request_id"));
		log.setResult(jo.toJSONString());
		itfFaceIdService.saveRequireLog(log);
		return log;
	}
	
	private NjFaceidRequire saveRequire(JSONObject jo, String attachId)throws Exception{
		NjFaceidRequire req = new NjFaceidRequire();
		req.setImageId(attachId);
		req.setResult(jo.toJSONString());
		req.setCreateTime(new Date());
		itfFaceIdService.saveRequire(req);
		return req;
	}
	
	public String faceIdCheckHead( String userId){
		return null;
	}
	
	public String faceIdCheckEmblem(String userId){
		return null;
	}
	*/
/*	public FaceidHeadBean checkHeadImage(String userId) throws Exception{
		if(StringUtils.isEmpty(userId)){
			throw new Exception("用户id不能为空");
		}
		FaceidHeadBean resBean =new FaceidHeadBean();
		NjUserAttachment att =itfFaceIdService.getFaceIdHeadImage(userId);
		Map<String, Object> res=itfFaceIdService.checkHeadImage(userId);
		if(res==null){
			throw new Exception("没找到该用户的身份证图片");
		}
		if(isValid((FaceidHeadBean)res.get("result"))){
			return (FaceidHeadBean)res.get("result");
		}
		String picName = (String)res.get("imageName");
		String fileUrl = Constants.FILE_DIR.ITF_ATTACHMENT_DIR+picName;

		String resStr = FaceidUtil.ocridCard(fileUrl);
		itfFaceIdService.insertFaceidRequireLog(resStr);
		if(StringUtils.isEmpty(resStr)){
			logger.debug("faceid 返回错误，返回内容为空");
			throw new Exception("返回错误，返回内容为空");
		}
		JSONObject jo = JSONObject.parseObject("resStr");
		resBean.setAddress(jo.getString("address"));
		resBean.setGender(jo.getString("gender"));
		resBean.setCertNo(jo.getString("id_card_number"));
		resBean.setName(jo.getString("name"));
		resBean.setRace(jo.getString("race"));
		if(jo.containsKey("birthday")){
			resBean.setBirthday(jo.getJSONObject("birthday").getString("year")+"/"
					+jo.getJSONObject("birthday").getString("month")+"/"
					+jo.getJSONObject("birthday").getString("day"));
		}
		if(jo.containsKey("legality")){
			Map<String,Object> r1 = JSONObject.toJavaObject(jo.getJSONObject("legality"), new HashMap<String, Object>().getClass());
			resBean.setLegality(r1);
		}
		itfFaceIdService.insertFaceidRequir(resStr);
		return null;
	}*/
	
}
