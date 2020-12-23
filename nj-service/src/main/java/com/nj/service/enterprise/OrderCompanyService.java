package com.nj.service.enterprise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjControllerCreditCompanyMapper;
import com.nj.dao.NjCreditCompanyMapper;
import com.nj.dao.NjExtdataCompanyMapper;
import com.nj.dao.NjLegalerCreditCompanyMapper;
import com.nj.dao.NjNaturalerCreditCompanyMapper;
import com.nj.model.generate.NjControllerCreditCompany;
import com.nj.model.generate.NjControllerCreditCompanyExample;
import com.nj.model.generate.NjCreditCompany;
import com.nj.model.generate.NjCreditCompanyExample;
import com.nj.model.generate.NjExtdataCompany;
import com.nj.model.generate.NjExtdataCompanyExample;
import com.nj.model.generate.NjLegalerCreditCompany;
import com.nj.model.generate.NjLegalerCreditCompanyExample;
import com.nj.model.generate.NjNaturalerCreditCompany;
import com.nj.model.generate.NjNaturalerCreditCompanyExample;

import javax.annotation.Resource;

/**
 * 企业进件时，企业订单相关的service
 */
@Transactional(readOnly=true)
@Service("orderCompanyService")
public class OrderCompanyService extends BaseCachesService{
	
	@Resource
	private NjCreditCompanyMapper njCreditCompanyMapper;
	@Resource
	private NjLegalerCreditCompanyMapper njLegalerCreditCompanyMapper;
	@Resource
	private NjControllerCreditCompanyMapper njControllerCreditCompanyMapper;
	@Resource
	private NjNaturalerCreditCompanyMapper njNaturalerCreditCompanyMapper;
	@Resource
	private NjExtdataCompanyMapper njExtdataCompanyMapper;
	
	/**
	 * 保存和更新creditCompany
	 */
	@Transactional(noRollbackFor={Throwable.class})
	public void saveUpdateNjCreditCompany(NjCreditCompany creditCompany){
		if(null != creditCompany){
			if(creditCompany.getId() == null){
				creditCompany.setId(UuidUtil.get32UUID());
				njCreditCompanyMapper.insert(creditCompany);
			}else{
				njCreditCompanyMapper.updateByPrimaryKey(creditCompany);
			}
		}
	}
	
	/**
	 * 通过订单id获取企业征信
	 */
	public NjCreditCompany getNjCreditCompany(String orderId){
		NjCreditCompanyExample ex = new NjCreditCompanyExample();
		ex.createCriteria().andOrderIdEqualTo(orderId);
		List<NjCreditCompany> list = njCreditCompanyMapper.selectByExample(ex);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 保存和更新NjLegalerCreditCompany
	 */
	@Transactional(noRollbackFor={Throwable.class})
	public void saveUpdateNjLegalerCreditCompany(NjLegalerCreditCompany legalerCreditCompany){
		if(null != legalerCreditCompany){
			if(legalerCreditCompany.getId() == null){
				legalerCreditCompany.setId(UuidUtil.get32UUID());
				njLegalerCreditCompanyMapper.insert(legalerCreditCompany);
			}else{
				njLegalerCreditCompanyMapper.updateByPrimaryKey(legalerCreditCompany);
			}
		}
	}
	
	/**
	 * 通过订单id获取法人代表征信报告
	 */
	public NjLegalerCreditCompany getNjLegalerCreditCompany(String orderId){
		NjLegalerCreditCompanyExample ex = new NjLegalerCreditCompanyExample();
		ex.createCriteria().andOrderIdEqualTo(orderId);
		List<NjLegalerCreditCompany> list = njLegalerCreditCompanyMapper.selectByExample(ex);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 保存和更新controllerCreditCompany
	 */
	@Transactional(noRollbackFor={Throwable.class})
	public void saveUpdateNjControllerCreditCompany(NjControllerCreditCompany controllerCreditCompany){
		if(null != controllerCreditCompany){
			if(controllerCreditCompany.getId() == null){
				controllerCreditCompany.setId(UuidUtil.get32UUID());
				njControllerCreditCompanyMapper.insert(controllerCreditCompany);
			}else{
				njControllerCreditCompanyMapper.updateByPrimaryKey(controllerCreditCompany);
			}
		}
	}
	
	/**
	 * 通过订单id获取实际控制人征信报告
	 */
	public NjControllerCreditCompany getNjControllerCreditCompany(String orderId){
		NjControllerCreditCompanyExample ex = new NjControllerCreditCompanyExample();
		ex.createCriteria().andOrderIdEqualTo(orderId);
		List<NjControllerCreditCompany> list = njControllerCreditCompanyMapper.selectByExample(ex);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 保存和更新naturalerCreditCompany
	 */
	@Transactional(noRollbackFor={Throwable.class})
	public void saveUpdateNjNaturalerCreditCompany(NjNaturalerCreditCompany naturalerCreditCompany){
		if(null != naturalerCreditCompany){
			if(naturalerCreditCompany.getId() == null){
				naturalerCreditCompany.setId(UuidUtil.get32UUID());
				njNaturalerCreditCompanyMapper.insert(naturalerCreditCompany);
			}else{
				njNaturalerCreditCompanyMapper.updateByPrimaryKey(naturalerCreditCompany);
			}
		}
	}
	
	/**
	 * 通过订单id获取自然人大股东征信报告
	 */
	public NjNaturalerCreditCompany getNjNaturalerCreditCompany(String orderId){
		NjNaturalerCreditCompanyExample ex = new NjNaturalerCreditCompanyExample();
		ex.createCriteria().andOrderIdEqualTo(orderId);
		List<NjNaturalerCreditCompany> list = njNaturalerCreditCompanyMapper.selectByExample(ex);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * 保存和更新extdataCompany
	 */
	@Transactional(noRollbackFor={Throwable.class})
	public void saveUpdateNjExtdataCompany(NjExtdataCompany extdataCompany){
		if(null != extdataCompany){
			if(extdataCompany.getId() == null){
				extdataCompany.setId(UuidUtil.get32UUID());
				njExtdataCompanyMapper.insert(extdataCompany);
			}else{
				njExtdataCompanyMapper.updateByPrimaryKey(extdataCompany);
			}
		}
	}
	
	/**
	 * 通过订单id获取外部数据
	 */
	public NjExtdataCompany getNjExtdataCompany(String orderId){
		NjExtdataCompanyExample ex = new NjExtdataCompanyExample();
		ex.createCriteria().andOrderIdEqualTo(orderId);
		List<NjExtdataCompany> list = njExtdataCompanyMapper.selectByExample(ex);
		if(!CollectionUtils.isEmpty(list)){
			return list.get(0);
		}else{
			return null;
		}
	}
	
	/**
    * 保存信用信息
    */
	@Transactional(noRollbackFor={Throwable.class})
	public void saveCompanyOrderCreditInfo(String orderId,
										   String creditCompany,
										   String legalerCreditCompany,
										   String controllerCreditCompany,
										   String naturalerCreditCompany,
										   String extdataCompany){
	   NjCreditCompany cc = getNjCreditCompany(orderId);
	   if(cc == null){
		   cc = new NjCreditCompany();
	   }
	   JSONObject ccJb = JSONObject.parseObject(creditCompany);
	   cc.setDqbllxdywbs(ccJb.getString("dqbllxdywbs"));
	   cc.setDqbllxdywye(ccJb.getString("dqbllxdywye"));
	   cc.setDqgzlxdywbs(ccJb.getString("dqgzlxdywbs"));
	   cc.setDqgzlxdywye(ccJb.getString("dqgzlxdywye"));
	   cc.setDqwjqxdjgs(ccJb.getString("dqwjqxdjgs"));
	   cc.setDqxdywbs(ccJb.getString("dqxdywbs"));
	   cc.setDqxdywye(ccJb.getString("dqxdywye"));
	   cc.setDqyzwgsczdzwbs(ccJb.getString("dqyzwgsczdzwbs"));
	   cc.setDqyzwgsczdzwdk(ccJb.getString("dqyzwgsczdzwdk"));
	   cc.setDqyzwgsczdzwlx(ccJb.getString("dqyzwgsczdzwlx"));
	   cc.setDqyzwgsczdzwye(ccJb.getString("dqyzwgsczdzwye"));
	   cc.setLsxdjgs(ccJb.getString("lsxdjgs"));
	   cc.setMspdjls(ccJb.getString("mspdjls"));
	   cc.setOrderId(orderId);
	   cc.setQsjls(ccJb.getString("qsjls"));
	   cc.setQzzxjls(ccJb.getString("qzzxjls"));
	   cc.setXzcfjls(ccJb.getString("xzcfjls"));
	   saveUpdateNjCreditCompany(cc);
	   
	   NjLegalerCreditCompany lcc = getNjLegalerCreditCompany(orderId);
	   if(lcc == null){
		   lcc = new NjLegalerCreditCompany();
	   }
	   JSONObject lccJb = JSONObject.parseObject(legalerCreditCompany);
	   lcc.setFdfsg90tysyqdzhs(lccJb.getString("fdfsg90tysyqdzhs"));
	   lcc.setFdfsgyqzhs(lccJb.getString("fdfsgyqzhs"));
	   lcc.setFdwjqwxhzhs(lccJb.getString("fdwjqwxhzhs"));
	   lcc.setFdzhs(lccJb.getString("fdzhs"));
	   lcc.setJ3gygrcxcs(lccJb.getString("j3gygrcxcs"));
	   lcc.setJ3gyjgcxcs(lccJb.getString("j3gyjgcxcs"));
	   lcc.setOrderId(orderId);
	   lcc.setQtdkfsg90tysyqdzhs(lccJb.getString("qtdkfsg90tysyqdzhs"));
	   lcc.setQtdkfsgyqzhs(lccJb.getString("qtdkfsgyqzhs"));
	   lcc.setQtdkwjqwxhzhs(lccJb.getString("qtdkwjqwxhzhs"));
	   lcc.setQtdkzhs(lccJb.getString("qtdkzhs"));
	   lcc.setXykfsg90tysyqdzhs(lccJb.getString("xykfsg90tysyqdzhs"));
	   lcc.setXykfsgyqzhs(lccJb.getString("xykfsgyqzhs"));
	   lcc.setXykwjqwxhzhs(lccJb.getString("xykwjqwxhzhs"));
	   lcc.setXykzhs(lccJb.getString("xykzhs"));
	   saveUpdateNjLegalerCreditCompany(lcc);
	   
	   NjControllerCreditCompany ccc = getNjControllerCreditCompany(orderId);
	   if(ccc == null){
		   ccc = new NjControllerCreditCompany();
	   }
	   JSONObject cccJb = JSONObject.parseObject(controllerCreditCompany);
	   ccc.setFdfsg90tysyqdzhs(cccJb.getString("fdfsg90tysyqdzhs"));
	   ccc.setFdfsgyqzhs(cccJb.getString("fdfsgyqzhs"));
	   ccc.setFdwjqwxhzhs(cccJb.getString("fdwjqwxhzhs"));
	   ccc.setFdzhs(cccJb.getString("fdzhs"));
	   ccc.setJ3gygrcxcs(cccJb.getString("j3gygrcxcs"));
	   ccc.setJ3gyjgcxcs(cccJb.getString("j3gyjgcxcs"));
	   ccc.setOrderId(orderId);
	   ccc.setQtdkfsg90tysyqdzhs(cccJb.getString("qtdkfsg90tysyqdzhs"));
	   ccc.setQtdkfsgyqzhs(cccJb.getString("qtdkfsgyqzhs"));
	   ccc.setQtdkwjqwxhzhs(cccJb.getString("qtdkwjqwxhzhs"));
	   ccc.setQtdkzhs(cccJb.getString("qtdkzhs"));
	   ccc.setXykfsg90tysyqdzhs(cccJb.getString("xykfsg90tysyqdzhs"));
	   ccc.setXykfsgyqzhs(cccJb.getString("xykfsgyqzhs"));
	   ccc.setXykwjqwxhzhs(cccJb.getString("xykwjqwxhzhs"));
	   ccc.setXykzhs(cccJb.getString("xykzhs"));
	   saveUpdateNjControllerCreditCompany(ccc);
	   
	   NjNaturalerCreditCompany ncc = getNjNaturalerCreditCompany(orderId);
	   if(null == ncc){
		   ncc = new NjNaturalerCreditCompany();
	   }
	   JSONObject nccJb = JSONObject.parseObject(naturalerCreditCompany);
	   ncc.setFdfsg90tysyqdzhs(nccJb.getString("fdfsg90tysyqdzhs"));
	   ncc.setFdfsgyqzhs(nccJb.getString("fdfsgyqzhs"));
	   ncc.setFdwjqwxhzhs(nccJb.getString("fdwjqwxhzhs"));
	   ncc.setFdzhs(nccJb.getString("fdzhs"));
	   ncc.setJ3gygrcxcs(nccJb.getString("j3gygrcxcs"));
	   ncc.setJ3gyjgcxcs(nccJb.getString("j3gyjgcxcs"));
	   ncc.setOrderId(orderId);
	   ncc.setQtdkfsg90tysyqdzhs(nccJb.getString("qtdkfsg90tysyqdzhs"));
	   ncc.setQtdkfsgyqzhs(nccJb.getString("qtdkfsgyqzhs"));
	   ncc.setQtdkwjqwxhzhs(nccJb.getString("qtdkwjqwxhzhs"));
	   ncc.setQtdkzhs(nccJb.getString("qtdkzhs"));
	   ncc.setXykfsg90tysyqdzhs(nccJb.getString("xykfsg90tysyqdzhs"));
	   ncc.setXykfsgyqzhs(nccJb.getString("xykfsgyqzhs"));
	   ncc.setXykwjqwxhzhs(nccJb.getString("xykwjqwxhzhs"));
	   ncc.setXykzhs(nccJb.getString("xykzhs"));
	   saveUpdateNjNaturalerCreditCompany(ncc);
	   
	   NjExtdataCompany ec = getNjExtdataCompany(orderId);
	   if(null == ec){
		   ec = new NjExtdataCompany();
	   }
	   JSONObject ecJb = JSONObject.parseObject(extdataCompany);
	   ec.setJ12gysqcs(ecJb.getString("j12gysqcs"));
	   ec.setJ3gysqcs(ecJb.getString("j3gysqcs"));
	   ec.setJ6gysqcs(ecJb.getString("j6gysqcs"));
	   ec.setOrderId(orderId);
	   ec.setSfmzfyxx(ecJb.getString("sfmzfyxx"));
	   ec.setSfmztsmd(ecJb.getString("sfmztsmd"));
	   ec.setSfmzzrrsbxx(ecJb.getString("sfmzzrrsbxx"));
	   ec.setSjzwsc(ecJb.getString("sjzwsc"));
	   ec.setSjzwzt(ecJb.getString("sjzwzt"));
	   saveUpdateNjExtdataCompany(ec);
	}
}
