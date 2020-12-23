package com.nj.service.process;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.nj.core.base.common.AddressConstants;
import com.nj.core.base.common.Constants;
import com.nj.core.base.dao.BaseDao;
import com.nj.core.base.enums.EProcessInfo;
import com.nj.core.base.enums.EProcessResult;
import com.nj.core.base.enums.EProductTemplate;
import com.nj.core.base.enums.ERoleType;
import com.nj.core.base.util.UuidUtil;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjProcessOrderFlowsMapper;
import com.nj.dao.NjProcessTemplateFlowsMapper;
import com.nj.dao.NjProductTempMapper;
import com.nj.dao.extend.NjOrderProcessMapperExtend;
import com.nj.dao.extend.NjProcessMapperExtend;
import com.nj.dao.extend.NjProcessTemplateFlowsMapperExtend;
import com.nj.dao.extend.NjProductTempMapperExtend;
import com.nj.dao.extend.NjUserInfoMapperExtend;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjProcessOrderFlows;
import com.nj.model.generate.NjProcessOrderFlowsExample;
import com.nj.model.generate.NjProcessTemplateFlows;
import com.nj.model.generate.NjProcessTemplateFlowsExample;
import com.nj.model.generate.NjProductTemp;
import com.nj.model.generate.NjProductTempExample;
import com.nj.model.generate.NjUserInfo;

/**
 * 
 * @Name com.nj.service.process.ProcessFlowsService
 * @Description 工作流程服务类
 * 
 * @Author bruce
 * @Version 2018年2月8日 下午3:35:44
 * @Copyright 金鼎财富
 *
 */
@Service("njProcessFlowsService")
public class ProcessFlowsService {

	private final static Logger logger = LoggerFactory.getLogger(ProcessFlowsService.class);

	@Resource(name = "BaseDao")
	private BaseDao dao;
	@Resource
	private NjProcessOrderFlowsMapper njProcessOrderFlowsMapper;
	@Resource
	private NjUserInfoMapperExtend njUserInfoMapperExtend;

	/**
	 * 启动订单流程
	 * 
	 * @param orderId
	 * @throws Exception
	 */
	public NjProcessTemplateFlows startProcess(String orderId, String templateId) throws Exception {
		NjProcessTemplateFlows nextProcess = null;

		NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);
		NjLoanOrder order = orderMapper.selectByPrimaryKey(orderId);
		if (order == null) {
			logger.info("没有找到订单：{}", orderId);
			return null;
		}

		NjProcessOrderFlowsMapper orderFlowsMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
		List<NjProcessTemplateFlows> ptflowsList = listTemplateFlowsByTemplateId(templateId);
		if (ptflowsList.size() == 0) {
			logger.error("订单:{},没有绑定流程模板", orderId);
			return null;
		}
		int i = 0;
		int startStatus = 1;
		for (NjProcessTemplateFlows process : ptflowsList) {
			NjProcessOrderFlows orderProcess = new NjProcessOrderFlows();
			orderProcess.setId(UuidUtil.get32UUID());
			orderProcess.setOrderId(orderId);
			orderProcess.setProcessId(process.getProcessId());
			orderProcess.setCreateTime(new Date());
			orderProcess.setStatus((short) 0);
			orderProcess.setExecOrders(process.getExecOrders());
			if (process.getProcessId() == EProcessInfo.START.getId()) {
				orderProcess.setUserId("SYSTEM");
				orderProcess.setStatus((short) 2);
				orderProcess.setBeginTime(new Date());
				orderProcess.setFinishTime(new Date());
				orderProcess.setExecTime(1L);
				if (i + 1 >= ptflowsList.size()) {
					logger.error("流程定义出现错误:缺少结束流程!");
					return null;
				} else {
					nextProcess = ptflowsList.get(i + 1);
				}
				startStatus = process.getExecAgreeStatus();
			}
			orderFlowsMapper.insertSelective(orderProcess);
			i++;
		}
		order.setStatus(startStatus);
		orderMapper.updateByPrimaryKeySelective(order);
		logger.info("订单:{},审批流程启动!", orderId);
		return nextProcess;
	}

	/**
	 * 查询订单的过程信息
	 * 
	 * @param orderId
	 * @param processId
	 * @return
	 * @throws Exception
	 */
	public NjProcessOrderFlows selectOrderProcess(String orderId, int processId) {
		try {
			NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
			example.createCriteria().andOrderIdEqualTo(orderId).andProcessIdEqualTo(processId);
			NjProcessOrderFlowsMapper processOrderMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
			return processOrderMapper.selectByExample(example).get(0);
		} catch (Exception ex) {
			logger.error("selectOrderProcess:{}", ex.getMessage());
			return null;
		}
	}

	/**
	 * 查询流程模板中过程基本信息
	 * 
	 * @param templateId
	 * @param processId
	 * @param orderId
	 * @return
	 */
	public NjProcessTemplateFlows selectProcessByTemplateId(String templateId, int processId,String orderId,Integer status) {
		try {
			NjProcessTemplateFlowsMapperExtend extend = dao.getMapper(NjProcessTemplateFlowsMapperExtend.class);
			return extend.selectCurrentTemplateFlows(templateId,processId,orderId,status);
		} catch (Exception ex) {
			logger.error("selectProcessByTemplateId:{}", ex.getMessage());
			return null;
		}
	}

	/**
	 * 查询下一个过程
	 * 
	 * @param currentProcess
	 * @return
	 * @throws Exception
	 */
	public NjProcessTemplateFlows selectNextProcess(NjProcessTemplateFlows currentProcess, EProcessResult result)
			throws Exception {
		NjProcessTemplateFlows processTemplateFlows = null;
		NjProcessTemplateFlowsExample example = new NjProcessTemplateFlowsExample();
		example.createCriteria().andTemplateIdEqualTo(currentProcess.getTemplateId())
				.andExecOrdersGreaterThan(currentProcess.getExecOrders())
				.andPreconditionEqualTo(currentProcess.getPrecondition());
		example.setOrderByClause(" exec_orders");
		NjProcessTemplateFlowsMapper processTemplateOrderMapper = dao.getMapper(NjProcessTemplateFlowsMapper.class);
		List<NjProcessTemplateFlows> ptList = processTemplateOrderMapper.selectByExample(example);
		if (ptList != null && ptList.size() > 0) {
			if (result.equals(EProcessResult.AGREE)) {
				processTemplateFlows = ptList.get(0);
			} else if (result.equals(EProcessResult.SKIPCHECK)) {
				for (NjProcessTemplateFlows ptf : ptList) {
					if (ptf.getType() == 1) {
						continue;
					} else {
						if (ptf.getProcessId() > EProcessInfo.LAST_CHECK.getId()) {
							processTemplateFlows = ptf;
							break;
						}
					}
				}
			}
		}
		return processTemplateFlows;
	}

	/**
	 * 查询订单当前过程
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public NjProcessTemplateFlows selectCurrentProcess(String orderId, String templateId) throws Exception {
		NjProcessMapperExtend njProcessMapperExtend = dao.getMapper(NjProcessMapperExtend.class);
		return njProcessMapperExtend.selectCurrentProcess(orderId, templateId);
	}
	
	/**
	 * 查询订单当前过程
	 */
	public NjProcessOrderFlows selectCurrentProcessByOrderId(String orderId) throws Exception {
		NjProcessMapperExtend processMapper = dao.getMapper(NjProcessMapperExtend.class);
		return processMapper.selectCurrentProcessByOrderId(orderId);
	}
	

	/**
	 * 查询前一个流程
	 * 
	 * @param currentProcess
	 * @return
	 * @throws Exception
	 */
	public NjProcessTemplateFlows selectPreviousProcess(NjProcessTemplateFlows currentProcess) throws Exception {
		NjProcessTemplateFlowsExample example = new NjProcessTemplateFlowsExample();
		example.createCriteria().andTemplateIdEqualTo(currentProcess.getTemplateId())
				.andExecOrdersLessThan(currentProcess.getExecOrders()).andPreconditionEqualTo((short) 1).andTypeNotEqualTo((short) 3);
		example.setOrderByClause(" exec_orders desc");
		NjProcessTemplateFlowsMapper processTemplateOrderMapper = dao.getMapper(NjProcessTemplateFlowsMapper.class);
		return processTemplateOrderMapper.selectByExample(example).get(0);
	}

	public List<Map<String, Object>> selectOrderProcessByOrderId(String orderId,String productId) throws Exception {
		//根据产品id，获取产品模板id
		NjProductTempMapper njProductTempMapper = dao.getMapper(NjProductTempMapper.class);
		NjProductTempExample tempExample = new NjProductTempExample();
		tempExample.createCriteria().andProductIdEqualTo(productId);
		List<NjProductTemp> njProductTempList = njProductTempMapper.selectByExample(tempExample);
		if(njProductTempList != null && njProductTempList.size() > 0) {
			NjProductTemp njProductTemp = njProductTempList.get(0);
			String templateId = njProductTemp.getProcessTemplateId();
			
			NjOrderProcessMapperExtend extend = dao.getMapper(NjOrderProcessMapperExtend.class);
			return extend.selectOrderProcess(orderId,templateId);
		}else {
			throw new Exception("订单："+orderId+"所属产品："+productId+"模板为空");
		}
	}

	/**
	 * 保存手动分单信息
	 * 
	 * @param orderId
	 * @param users
	 * @throws Exception
	 */
	public void saveManualShunt(String orderId, List<String> users) throws Exception {

		NjLoanOrderMapper orderMapper = dao.getMapper(NjLoanOrderMapper.class);

		NjLoanOrder order = orderMapper.selectByPrimaryKey(orderId);
		//根据订单id获取产品模板信息
		NjProductTempMapperExtend productTempMapperExtend = dao.getMapper(NjProductTempMapperExtend.class);
		NjProductTemp temp = productTempMapperExtend.selectByProductId(order.getProductId());
		
		if(temp.getTemplateId()==EProductTemplate.Housing.getId()) {
			//如果是房屋类产品
			manualShuntHouse(order, users);
		}else {
			//如果是信用类产品
			manualShuntCredit(order, users);
		}
		
	}
	/**
	 * 信用类产品手动分单信息
	 * 
	 * @param order
	 * @param users
	 * @throws Exception
	 */
	private void manualShuntCredit(NjLoanOrder order,List<String> users) throws Exception {
		StringBuilder processIdList = new StringBuilder();
		processIdList.append(EProcessInfo.FIRST_CHECK.getId()+",");
		processIdList.append(EProcessInfo.REVIEW_CHECK.getId()+",");
		processIdList.append(EProcessInfo.LAST_CHECK.getId());
		List<Integer> processIds = selectCheckProcessByProductId(order.getProductId(),processIdList.toString());
		int i = 0;
		NjProcessOrderFlowsMapper processOrderMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
		for (String userId : users) {
			NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
			example.createCriteria().andOrderIdEqualTo(order.getId()).andProcessIdEqualTo(processIds.get(i));
			List<NjProcessOrderFlows> flowsList = processOrderMapper.selectByExample(example);
			if (flowsList.size() != 1) {
				// 订单没有发现该过程
				logger.error("订单:{},没有发现过程：{}", order.getId(), processIds.get(i));
				continue;
				// throw new Exception("订单没有发现审核过程,请检查订单流程.");
			}
			NjProcessOrderFlows processOrder = flowsList.get(0);
			processOrder.setUserId(userId);
			processOrderMapper.updateByExampleSelective(processOrder, example);
			i++;
		}
	}

	/**
	 * 房屋类产品手动分单信息
	 * 
	 * @param order
	 * @param users
	 * @throws Exception
	 */
	public void manualShuntHouse(NjLoanOrder order, List<String> users) throws Exception {
		// 查询订单手动分单后续流程列表
		StringBuilder processIdList = new StringBuilder();
		processIdList.append(EProcessInfo.REVIEW_CHECK.getId()+",");
		processIdList.append(EProcessInfo.LAST_CHECK.getId()+",");
		processIdList.append(EProcessInfo.CONTRACT_Create.getId()+",");
		processIdList.append(EProcessInfo.BEGIN_MAKE_LOANS.getId()+",");
		processIdList.append(EProcessInfo.MAKE_LOANS_FIRST_CHECK.getId()+",");
		processIdList.append(EProcessInfo.MAKE_LOANS_SECOND_CHECK.getId()+",");
		processIdList.append(EProcessInfo.MAKE_LOANS_THIRD_CHECK.getId()+",");
		//如果同一个用户同一个产品贷款金额大于100万，则需更多复审流程:风控经理审核->风控总监审核->董事长审核
		NjProcessOrderFlowsExample processExample = new NjProcessOrderFlowsExample();
		processExample.createCriteria().andOrderIdEqualTo(order.getId());
		Long processCount = njProcessOrderFlowsMapper.countByExample(processExample);
		//如果流程数量等于默认数量，则走大于100w流程
		if(processCount.intValue() == AddressConstants.CdjkProcessNumber.intValue()) {
			processIdList.append(EProcessInfo.MANAGER_REVIEW_CHECK.getId()+",");
			processIdList.append(EProcessInfo.DIRECTOR_REVIEW_CHECK.getId()+",");
			processIdList.append(EProcessInfo.MAKE_LOANS_FOURTH_CHECK.getId()+",");
		}
		processIdList.append(EProcessInfo.MAKE_LOANS_FIFTH_CHECK.getId());
		
		List<Integer> processIds = selectCheckProcessByProductId(order.getProductId(), processIdList.toString());
		NjProcessOrderFlowsMapper processOrderMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
		for (Integer processId : processIds) {
			NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
			example.createCriteria().andOrderIdEqualTo(order.getId()).andProcessIdEqualTo(processId);
			List<NjProcessOrderFlows> flowsList = processOrderMapper.selectByExample(example);
			if (flowsList.size() != 1) {
				// 订单没有发现该过程
				logger.error("订单:{},没有发现过程：{}", order.getId(), processId);
				continue;
			}
			NjProcessOrderFlows processOrder = flowsList.get(0);
			bindOrderProcessToUser(processId, processOrder,users.get(0),order,processCount);
			processOrderMapper.updateByExampleSelective(processOrder, example);
		}
	}

	/**
	 * 绑定用户到相关订单流程
	 * @param processId
	 * @param processOrder
	 * @param userId
	 * @param order
	 * @throws Exception
	 */
	private void bindOrderProcessToUser(Integer processId, NjProcessOrderFlows processOrder,String userId,NjLoanOrder order,Long processCount) throws Exception {
		// 如果是分控专员复审，则为页面选择分控专员
		if (processId == EProcessInfo.REVIEW_CHECK.getId()) {
			processOrder.setUserId(userId);
			// 如果是风控经理复审
		}else if(processId == EProcessInfo.MANAGER_REVIEW_CHECK.getId()) {
			// 查询风控经理
			List<Map> users = njUserInfoMapperExtend.selectUserByRoleType(ERoleType.RISKCONTROLMANAGER.getValue(),order.getCompanyId());
			if (users != null && users.size() > 0) {
				processOrder.setUserId(users.get(0).get("id") + "");
			} else {
				logger.error("没有检索到分控经理用户");
				throw new Exception("没有检索到分控经理用户");
			}
			// 如果是总监复审
		}else if(processId == EProcessInfo.DIRECTOR_REVIEW_CHECK.getId()) {
			List<Map> users = njUserInfoMapperExtend.selectUserByRoleType(ERoleType.RISKDIRECTOR.getValue(),order.getCompanyId());
			if (users != null && users.size() > 0) {
				processOrder.setUserId(users.get(0).get("id") + "");
			} else {
				logger.error("没有检索到分控总监用户");
				throw new Exception("没有检索到分控总监用户");
			}
			// 如果是合同制作流程或者开始放款流程，则为客户经理
		}else if (processId == EProcessInfo.CONTRACT_Create.getId() || processId == EProcessInfo.BEGIN_MAKE_LOANS.getId()) {
			NjUserInfo njUserInfo = njUserInfoMapperExtend.selectUserByOrderId(order.getId());
			processOrder.setUserId(njUserInfo.getId());
		// 如果是放款预审，由业务经理处理相关订单
		} else if (processId == EProcessInfo.MAKE_LOANS_FIRST_CHECK.getId()) {
			NjUserInfo njUserInfo = njUserInfoMapperExtend.selectUserByOrderId(order.getId());
			processOrder.setUserId(njUserInfo.getParentId());
		// 如果是风控经理放款复审，由风控经理处理
		} else if (processId == EProcessInfo.MAKE_LOANS_THIRD_CHECK.getId()) {
			// 查询风控经理
			List<Map> users = njUserInfoMapperExtend.selectUserByRoleType(ERoleType.RISKCONTROLMANAGER.getValue(),order.getCompanyId());
			if (users != null && users.size() > 0) {
				processOrder.setUserId(users.get(0).get("id") + "");
			} else {
				logger.error("没有检索到分控经理用户");
				throw new Exception("没有检索到分控经理用户");
			}
			// 如果是风控总监放款复审
		}else if(processId == EProcessInfo.MAKE_LOANS_FOURTH_CHECK.getId()) {
			List<Map> users = njUserInfoMapperExtend.selectUserByRoleType(ERoleType.RISKDIRECTOR.getValue(),order.getCompanyId());
			if (users != null && users.size() > 0) {
				processOrder.setUserId(users.get(0).get("id") + "");
			} else {
				logger.error("没有检索到分控总监用户");
				throw new Exception("没有检索到分控总监用户");
			}
			// 如果是终审流程或者放款终审流程，由有权审批人处理
		} else if (processId == EProcessInfo.LAST_CHECK.getId() || processId == EProcessInfo.MAKE_LOANS_FIFTH_CHECK.getId()) {
			//如果流程数量等于默认数量，则走大于100w流程
			if(processCount.intValue() == AddressConstants.CdjkProcessNumber.intValue()) {
				// 查询董事长
				List<Map> users = njUserInfoMapperExtend.selectUserByRoleType(ERoleType.CHAIRMAN.getValue(),order.getCompanyId());
				if (users != null && users.size() > 0) {
					logger.error("流程"+processId+":绑定董事长用户"+users.get(0).get("id"));
					processOrder.setUserId(users.get(0).get("id") + "");
				} else {
					logger.error("没有检索到董事长用户");
					throw new Exception("没有检索到董事长用户");
				}
			}else {
				// 查询风控经理, 如果金额小于100w，则为风控总监处理
				List<Map> users = njUserInfoMapperExtend.selectUserByRoleType(ERoleType.RISKDIRECTOR.getValue(),order.getCompanyId());
				if (users != null && users.size() > 0) {
					logger.error("流程"+processId+":绑定风控经理用户"+users.get(0).get("id"));
					processOrder.setUserId(users.get(0).get("id") + "");
				} else {
					logger.error("没有检索到分控总监用户");
					throw new Exception("没有检索到分控总监用户");
				}
			}
		}
	}

	/**
	 * 开始手动审核
	 * 
	 * @param orderId
	 * @throws Exception
	 */
	@SuppressWarnings("unlikely-arg-type")
	public void beginManualCheck(String orderId, String userId,String roleTypes) {
		try {
			Integer[] processIds = Constants.ManualCheckProcess;
			NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
			example.createCriteria().andOrderIdEqualTo(orderId).andStatusLessThan((short) 2);
			example.setOrderByClause(" exec_orders");
			NjProcessOrderFlowsMapper processOrderMapper = dao.getMapper(NjProcessOrderFlowsMapper.class);
			List<NjProcessOrderFlows> list = processOrderMapper.selectByExample(example);
			if (list.size() > 0) {
				NjProcessOrderFlows orderProcess = list.get(0);
				//如果是放款专员、财务专员、财务经理，法务执行流程，特殊处理，因为订单分单时，没有指定
				if(roleTypes.contains(ERoleType.LENDINGPERSON.getValue()) || roleTypes.contains(ERoleType.FINANCEPERSON.getValue()) 
						|| roleTypes.contains(ERoleType.FINANCEMANAGER.getValue()) || roleTypes.contains(ERoleType.LEGALAFFAIRS.getValue())) {
					if(orderProcess.getBeginTime() == null && Arrays.asList(processIds).contains(orderProcess.getProcessId())) {
						orderProcess.setBeginTime(new Date());
						orderProcess.setStatus((short) 1);
						processOrderMapper.updateByPrimaryKey(orderProcess);
					}
				}else {
					if (null != orderProcess.getUserId() && orderProcess.getUserId().equals(userId)
							&& Arrays.asList(processIds).contains(orderProcess.getProcessId())) {
						if (orderProcess.getBeginTime() == null) {
							orderProcess.setBeginTime(new Date());
							orderProcess.setStatus((short) 1);
							processOrderMapper.updateByPrimaryKey(orderProcess);
						}
					}
				}
			}
		} catch (Exception ex) {
			logger.error("更新订单状态出现错误：{}", ex);
		}
	}

	/**
	 * 查询产品手动审核过程
	 * 
	 * @param productId
	 * @return
	 * @throws Exception
	 */
	public List<Integer> selectCheckProcessByProductId(String productId, String processIds) throws Exception {
		List<Integer> result = new ArrayList<Integer>();
		NjProcessMapperExtend processMapper = dao.getMapper(NjProcessMapperExtend.class);
		Map<String, Object> param = new HashMap<>();
		param.put("productId", productId);
		param.put("processIds", processIds);
		List<NjProcessTemplateFlows> ptFlowsList = processMapper.selectCheckProcessByProductId(param);
		for (NjProcessTemplateFlows ptFlows : ptFlowsList) {
			result.add(ptFlows.getProcessId());
		}
		return result;
	}

	/**
	 * 查询第一个手动过程之前的过程
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	public NjProcessTemplateFlows selectBeforManualProcess(String orderId) throws Exception {
		int i = 0;
		NjProcessTemplateFlows beforProcess = null;
		NjProcessMapperExtend processMapper = dao.getMapper(NjProcessMapperExtend.class);
		List<NjProcessTemplateFlows> ptflowsList = processMapper.selectProcessFlowsByOrderId(orderId);
		for (NjProcessTemplateFlows pof : ptflowsList) {
			i++;
			if (Arrays.asList(Constants.ManualCheckProcess).contains(pof.getProcessId())) {
				break;
			}
		}
		i = i - 2;
		if (i >= 0) {
			beforProcess = ptflowsList.get(i);
		}
		return beforProcess;
	}

	public List<NjProcessTemplateFlows> listTemplateFlowsByTemplateId(String templateId) throws Exception {
		NjProcessTemplateFlowsMapper ptfMapper = dao.getMapper(NjProcessTemplateFlowsMapper.class);
		NjProcessTemplateFlowsExample example = new NjProcessTemplateFlowsExample();
		example.createCriteria().andTemplateIdEqualTo(templateId);
		example.setOrderByClause("exec_orders");
		List<NjProcessTemplateFlows> ptflowsList = ptfMapper.selectByExample(example);
		return ptflowsList;
	}

	public List<NjProcessOrderFlows> selectByExample(NjProcessOrderFlowsExample example) {

		List<NjProcessOrderFlows> list = njProcessOrderFlowsMapper.selectByExample(example);
		return list;

	}

	public Long selectProcessCountByOrderId(String orderId) {
		NjProcessOrderFlowsExample example = new NjProcessOrderFlowsExample();
		example.createCriteria().andOrderIdEqualTo(orderId);
		return njProcessOrderFlowsMapper.countByExample(example);
	}
}
