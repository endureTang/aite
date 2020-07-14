package com.nj.service.itf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.common.AddressConstants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.exception.BaseException;
import com.nj.core.base.util.HttpUtil;
import com.nj.dao.NjBankInfoMapper;
import com.nj.dao.NjUserBankCardMapper;
import com.nj.dao.extend.NjUserBankCardMapperExtend;
import com.nj.model.generate.NjBankInfo;
import com.nj.model.generate.NjBankInfoExample;
import com.nj.model.generate.NjUserBankCard;

/**
 * 用户绑卡信息service
 * @author Tangrenjian
 *
 */
@Transactional(readOnly = true)
@Service("userBankCardService")
public class UserBankCardService {
	private static Logger logger = LoggerFactory.getLogger(UserBankCardService.class);
	@Resource(name = "BaseDao")
	private BaseDao dao;
	
	/**
	 * 根据用户id,绑卡类型获取用户绑卡信息
	 * @param userId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public NjUserBankCard selectByUserId(String userId,int type) throws Exception {
		NjUserBankCardMapperExtend extend = dao.getMapper(NjUserBankCardMapperExtend.class);
		return extend.selectByUserId(userId,type);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void insert(NjUserBankCard njUserBankCard) throws Exception {
		//插入前，先清除之前的银行卡信息
		NjUserBankCardMapperExtend bankCardMapperExtend = dao.getMapper(NjUserBankCardMapperExtend.class);
		bankCardMapperExtend.deletebyUserId(njUserBankCard.getUserId());
		
		NjUserBankCardMapper cardMapper = dao.getMapper(NjUserBankCardMapper.class);
		cardMapper.insertSelective(njUserBankCard);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void update(NjUserBankCard bankCard) throws Exception {
		NjUserBankCardMapper cardMapper = dao.getMapper(NjUserBankCardMapper.class);
		cardMapper.updateByPrimaryKeySelective(bankCard);
	}
	
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void delete(String id) throws Exception {
		NjUserBankCardMapperExtend extend = dao.getMapper(NjUserBankCardMapperExtend.class);
		extend.deleteById(id);
	}

	public NjBankInfo selectByName(String bankName) throws Exception {
		NjBankInfoMapper mapper = dao.getMapper(NjBankInfoMapper.class);
		NjBankInfoExample example = new NjBankInfoExample();
		example.createCriteria().andBankNameLike(bankName);
		List<NjBankInfo> bankInfos = mapper.selectByExample(example);
		if(bankInfos!=null && bankInfos.size()>0) {
			return bankInfos.get(0);
		}
		return null;
	}

	public NjBankInfo selectByCode(String bankCode) throws Exception {
		NjBankInfoMapper mapper = dao.getMapper(NjBankInfoMapper.class);
		NjBankInfoExample example = new NjBankInfoExample();
		example.createCriteria().andBankCodeEqualTo(bankCode);
		List<NjBankInfo> bankInfos = mapper.selectByExample(example);
		if(bankInfos!=null && bankInfos.size()>0) {
			return bankInfos.get(0);
		}
		return null;
	}

	public NjUserBankCard selectUserBindCard(String userId, int type) throws Exception {
		NjUserBankCardMapperExtend bankCardMapperExtend = dao.getMapper(NjUserBankCardMapperExtend.class);
		return bankCardMapperExtend.selectUserBindCard(userId,type);
	}

	public NjBankInfo selectByNumber(String bankNumber,String type) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("_input_charset", "utf-8");
		params.put("cardBinCheck", true);
		params.put("cardNo", bankNumber);
		String url = AddressConstants.AliBankInfoUrl;
		logger.info("从支付宝查询账号所属银行，所传参数为：url="+url+";params=" + JSONObject.toJSONString(params));
		String retJson = HttpUtil.doPost(url, params); 
		if(retJson != null) {
			JSONObject jb = JSONObject.parseObject(retJson);
			String stat = jb.getString("stat");
			boolean validated = jb.getBooleanValue("validated");
			if(stat != null && stat.equals("ok") && validated) {
				String bank = jb.getString("bank");
				NjBankInfoMapper mapper = dao.getMapper(NjBankInfoMapper.class);
				NjBankInfoExample example = new NjBankInfoExample();
				example.createCriteria().andBankAbbreviationEqualTo(bank).andChannelTypeEqualTo(type);
				List<NjBankInfo> bankInfos = mapper.selectByExample(example);
				if(bankInfos!=null && bankInfos.size()>0) {
					return bankInfos.get(0);
				}else {
					return null;
				}
			}else {
				logger.error("阿里银行【"+bankNumber+"】查询返回："+retJson);
				return null;
			}
			
		}
		return null;
	}
	
}
