package com.nj.service.enterprise;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.util.Constants;
import com.nj.core.base.util.PageData;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjCoporateUserMapper;
import com.nj.dao.NjProductUserMapper;
import com.nj.dao.NjUserInfoMapper;
import com.nj.dao.SysUserMapper;
import com.nj.dao.extend.NjLoanOrderMapperExtend;
import com.nj.dao.extend.NjProductUserMapperExtend;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.model.generate.NjCoporateUser;
import com.nj.model.generate.NjCoporateUserExample;
import com.nj.model.generate.NjCoporateUserExample.Criteria;
import com.nj.model.generate.NjProductUser;
import com.nj.model.generate.NjUserInfo;
import com.nj.model.generate.NjUserInfoExample;
import com.nj.model.generate.SysUser;
import com.nj.model.generate.SysUserRole;

@Transactional(readOnly = true)
@Service("njUserExdService")
public class NjUserExdService {

	@Resource(name = "BaseDao")
	private BaseDao dao;
	@Resource
	private  NjUserInfoMapper  njUserInfoMapper;


	private static Logger logger = LoggerFactory.getLogger(NjUserExdService.class);
	
	
	public List<NjUserInfo> selectByExample(NjUserInfoExample example){
		
		List<NjUserInfo> list = njUserInfoMapper.selectByExample(example );
		return  list;
	}
	
	public int updateByPrimaryKey(NjUserInfo record){
		
		
		int updateByPrimaryKey = njUserInfoMapper.updateByPrimaryKey(record);
		return  updateByPrimaryKey;
	}

	/*
	 * 获取用户信息
	 */
	public PageData getUserInfo(PageData pd) throws Exception {

		// 创建公司
		NjUserInfoMapperExtend njUserInfoDaoExd = dao.getMapper(NjUserInfoMapperExtend.class);
		long countList = njUserInfoDaoExd.selectUserAccountCount(pd);
		List<Map> results = njUserInfoDaoExd.selectUserAccount(pd);
		PageData pd1 = new PageData();

		pd1.put(Constants.Datas.RECORDSFILTERED, countList);
		pd1.put(Constants.Datas.RECORDSTOTAL, countList);
		pd1.put(Constants.Datas.NDATA, results);
		return pd1;
	}

	/*
	 * 获取用户密码
	 */
	public String getPwdByUserId(String userId) throws Exception {

		NjUserInfoMapperExtend njUserInfoDaoExd = dao.getMapper(NjUserInfoMapperExtend.class);

		return njUserInfoDaoExd.selectPwdByUserId(userId);
	}

	/*
	 * 获取用户信息和角色信息
	 */
	public PageData getUserById(String userId) throws Exception {
		PageData pd = new PageData();
		NjUserInfo njUserInfo = dao.findForObject("com.nj.dao.NjUserInfoMapper.selectByPrimaryKey", userId);
		if (njUserInfo != null) {
			pd.put("userId", njUserInfo.getId());
			pd.put("userName", njUserInfo.getUserName());
			pd.put("password", njUserInfo.getPassword());
			pd.put("mobile", njUserInfo.getUserMobile());
			pd.put("email", njUserInfo.getEmail());
			pd.put("remarks", njUserInfo.getRemarks());
		}

		/*
		 * NjUserInfoMapperExtend njUserInfoDaoExd =
		 * dao.getMapper(NjUserInfoMapperExtend.class); List<Map> roleNames =
		 * njUserInfoDaoExd.selectUserRoles(userId); if (roleNames.size() > 0) { for
		 * (Map map : roleNames) {
		 * 
		 * pd.put(map.get("roleType").toString(), "1");
		 * 
		 * 
		 * switch (map.get("roleType").toString()) { case "assignment":
		 * pd.put("assignment", "1"); break; case "busiaudit": pd.put("busiAudit", "1");
		 * break; case "riskaudit": pd.put("riskAudit", "1"); break; case "cAdmin":
		 * pd.put("cAdmin", "1"); break; case "businessReception":
		 * pd.put("businessReception", "1"); break; case "backgroundManager":
		 * pd.put("backgroundManager", "1"); break; case "businessExecutive":
		 * pd.put("businessExecutive", "1"); break; case "loanofficer":
		 * pd.put("loanofficer", true); break; }
		 * 
		 * } }
		 */

		return pd;
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void add(PageData pd) throws Exception {
		dao.save("com.nj.dao.NjUserInfoMapper.insertSelective", pd);
		this.addCoporate(pd);
		this.addRole(pd);
		// 关联用户产品
		addProductUser(pd);
	}

	// 保存用户产品关联信息
	private void addProductUser(PageData pd) throws Exception {
		String productList = pd.getString("productList");
		String[] productIds = productList.split(",");
		NjProductUserMapper njProductUserMapper = dao.getMapper(NjProductUserMapper.class);
		for (String productId : productIds) {
			NjProductUser njProductUser = new NjProductUser();
			njProductUser.setId(UuidUtil.get32UUID());
			njProductUser.setProductId(productId);
			// 默认0
			njProductUser.setRoleId("0");
			njProductUser.setUserId(pd.getString("id"));
			njProductUserMapper.insertSelective(njProductUser);
		}

	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void addCoporate(PageData pd) throws Exception {
		NjCoporateUserMapper mapper = dao.getMapper(NjCoporateUserMapper.class);

		NjCoporateUser njCoporateUser = new NjCoporateUser();
		njCoporateUser.setId(UuidUtil.get32UUID());
		njCoporateUser.setUserId(pd.getString("id"));
		
		// 分公司编号
		String coporateId = pd.getString("coporateId").toLowerCase();
		if(StringUtils.isNotBlank(coporateId)){
			njCoporateUser.setCoporateId(coporateId);
		}
		
		njCoporateUser.setState(1);

		mapper.insertSelective(njCoporateUser);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void addRole(PageData pd) throws Exception {

		// 设置角色
		List<SysUserRole> sysUserRoles = new ArrayList<>();

		String roleIds = pd.getString("roleList");

		String[] roleIdList = roleIds.split(",");
		for (String roleId : roleIdList) {
			SysUserRole sysUserRole = new SysUserRole();
			sysUserRole.setRoleId(roleId);
			sysUserRoles.add(sysUserRole);
		}

		for (SysUserRole sysUserRole : sysUserRoles) {
			sysUserRole.setUserId(pd.getString("id"));

			String uuid = UUID.randomUUID().toString();
			sysUserRole.setId(uuid.replace("-", ""));
			String coporateId = pd.getString("coporateId").toLowerCase();
			// 默认全部是金鼎财富技术公司
			sysUserRole.setCoporateId(coporateId);
		}

		dao.batchSave("com.nj.dao.SysUserRoleMapper.insertBatch", sysUserRoles);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void edit(PageData pd) throws Exception {
		dao.findForObject("com.nj.dao.extend.NjUserInfoMapperExtend.updateByPrimaryKeySelective", pd);
		
		
		this.editCoporate(pd);

		// 修改用户角色(单角色)
		List<SysUserRole> sysUserRoles = new ArrayList<>();

		String roleIds = pd.getString("roleList");
		if (null != roleIds && !"".equals(roleIds)) {
			String[] roleIdList = roleIds.split(",");
			for (String roleId : roleIdList) {
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setRoleId(roleId);
				sysUserRoles.add(sysUserRole);
			}

			for (SysUserRole sysUserRole : sysUserRoles) {
				sysUserRole.setUserId(pd.getString("id"));

				String uuid = UUID.randomUUID().toString();
				sysUserRole.setId(uuid.replace("-", ""));
				String coporateId = pd.getString("coporateId").toLowerCase();

				sysUserRole.setCoporateId(coporateId);
			}

			this.editRole(pd, sysUserRoles);
		}
		this.editProductList(pd);// 保存用户产品关联信息
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	private void editCoporate(PageData pd) throws Exception {
		String userId = pd.getString("userId");
		
		NjCoporateUserMapper mapper = dao.getMapper(NjCoporateUserMapper.class);
		
		NjCoporateUserExample example  =  new NjCoporateUserExample() ;
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUserIdEqualTo(userId);
		List<NjCoporateUser> list = mapper.selectByExample(example  );
		if(list.size()!=1){
			logger.error("userId=="+userId+"|所属企业用户对应表数据异常");
			return ;
		}
		NjCoporateUser  njCoporateUser =  list.get(0);
		String coporateId = pd.getString("coporateId");
		njCoporateUser.setCoporateId(coporateId);
		mapper.updateByPrimaryKey2(njCoporateUser);

		
	}

	/**
	 * 保存用户产品关联信息
	 * 
	 * @param pd
	 * @throws Exception
	 */
	private void editProductList(PageData pd) throws Exception {
		String productList = pd.getString("productList");
		if (null != productList && !productList.trim().equals("")) {
			String[] productIds = productList.split(",");
			NjProductUserMapper njProductUserMapper = dao.getMapper(NjProductUserMapper.class);
			// 清空用户产品关联
			NjProductUserMapperExtend extend = dao.getMapper(NjProductUserMapperExtend.class);
			extend.deleteByUserId(pd.getString("userId"));

			for (String productId : productIds) {
				NjProductUser njProductUser = new NjProductUser();
				njProductUser.setId(UuidUtil.get32UUID());
				njProductUser.setProductId(productId);
				// 默认0
				njProductUser.setRoleId("0");
				njProductUser.setUserId(pd.getString("id"));
				njProductUserMapper.insertSelective(njProductUser);
			}
		}
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void editRole(PageData pd, List<SysUserRole> list) throws Exception {
		
		dao.findForObject("com.nj.dao.SysUserRoleMapper.deleteByUserId", pd);

		dao.batchSave("com.nj.dao.SysUserRoleMapper.insertBatch", list);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void delete(PageData pd) throws Exception {
		String userId  = String.valueOf( pd.get("id"));
		NjUserInfoExample example =  new  NjUserInfoExample();
		example.createCriteria().andIdEqualTo(userId);
		List<NjUserInfo> list = this.selectByExample(example );
		NjUserInfo njUserInfo = list.get(0);
		if(!Objects.isNull(njUserInfo)){
			njUserInfo.setDelFlag(true);
			this.updateByPrimaryKey(njUserInfo);
		}
		//dao.delete("com.nj.dao.NjUserInfoMapper.deleteByPrimaryKey", pd);
		
		pd.put("userId", userId);
		dao.delete("com.nj.dao.SysUserRoleMapper.deleteByUserId", pd);
	}

	public NjUserInfo getByMobile(String userMobile) throws Exception {
		NjUserInfoMapperExtend extend = dao.getMapper(NjUserInfoMapperExtend.class);
		return extend.getByMobile(userMobile);
		
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void addSysUser(PageData pd) throws Exception {
		String coporateId = pd.getString("coporateId").toLowerCase();
		SysUser record = new SysUser();
		record.setId(pd.getString("id"));
		record.setLoginName(pd.getString("loginName"));
		record.setName(pd.getString("name"));
		record.setPhone(pd.getString("phone"));
		record.setPassword(pd.getString("password"));
		record.setRemarks(pd.getString("remarks"));
		record.setCompanyId(coporateId);
		record.setOfficeId("");
		record.setCreateDate(new Date());
		record.setUpdateDate(new Date());
		record.setCreateBy(pd.getString("createBy"));
		record.setUpdateBy(pd.getString("createBy"));
		SysUserMapper mapper = dao.getMapper(SysUserMapper.class);
		mapper.insertSelective(record);
//		this.addCoporate(pd);
		this.addRole(pd);
		
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void editSysUser(PageData pd) throws Exception {
		SysUser record = new SysUser();
		record.setId(pd.getString("id"));
		record.setLoginName(pd.getString("loginName"));
		record.setName(pd.getString("name"));
		record.setPhone(pd.getString("phone"));
		record.setPassword(pd.getString("password"));
		record.setRemarks(pd.getString("remarks"));
		
		SysUserMapper mapper = dao.getMapper(SysUserMapper.class);
		mapper.updateByPrimaryKeySelective(record);

		// 修改用户角色(单角色)
		List<SysUserRole> sysUserRoles = new ArrayList<>();

		String roleIds = pd.getString("roleList");
		if (null != roleIds && !"".equals(roleIds)) {
			String[] roleIdList = roleIds.split(",");
			for (String roleId : roleIdList) {
				SysUserRole sysUserRole = new SysUserRole();
				sysUserRole.setRoleId(roleId);
				sysUserRoles.add(sysUserRole);
			}

			for (SysUserRole sysUserRole : sysUserRoles) {
				sysUserRole.setUserId(pd.getString("id"));

				String uuid = UUID.randomUUID().toString();
				sysUserRole.setId(uuid.replace("-", ""));
				String coporateId = pd.getString("coporateId").toLowerCase();
				sysUserRole.setCoporateId(coporateId);
			}

			this.editRole(pd, sysUserRoles);
		}
			
	}
	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void deleteSysUser(PageData pd) throws Exception {
		SysUserMapper mapper = dao.getMapper(SysUserMapper.class);
		mapper.deleteByPrimaryKey(pd.getString("id"));
		pd.put("userId", pd.get("id"));
		dao.delete("com.nj.dao.SysUserRoleMapper.deleteByUserId", pd);
	}

}
