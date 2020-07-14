package com.nj.service.enterprise;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.nj.dao.NjDebitRecordMapper;
import com.nj.dao.NjLoanOrderMapper;
import com.nj.dao.NjRepayOfflineHistoryMapper;
import com.nj.dao.NjRepayOfflineLineHistoryMapper;
import com.nj.dao.NjRepayOfflineLineMapper;
import com.nj.dao.NjRepayOfflineMapper;
import com.nj.model.generate.NjDebitRecord;
import com.nj.model.generate.NjDebitRecordExample;
import com.nj.model.generate.NjLoanOrder;
import com.nj.model.generate.NjRepayOffline;
import com.nj.model.generate.NjRepayOfflineExample;
import com.nj.model.generate.NjRepayOfflineHistory;
import com.nj.model.generate.NjRepayOfflineLine;
import com.nj.model.generate.NjRepayOfflineLineExample;
import com.nj.model.generate.NjRepayOfflineLineHistory;

@Transactional(readOnly = true)
@Service("repayPlanService")
public class RepayPlanService extends BaseCachesService {

	public List<NjRepayOffline> getByOrderNo(String orderNo) throws Exception {
		NjRepayOfflineMapper rom = dao.getMapper(NjRepayOfflineMapper.class);
		NjRepayOfflineExample example = new NjRepayOfflineExample();
		example.createCriteria().andOrderNoEqualTo(orderNo);
		return rom.selectByExample(example);
	}

	@Transactional(rollbackFor = { Throwable.class }, readOnly = false)
	public void saveRepayPlan(NjLoanOrder lo,
							  NjRepayOffline repay, 
							  List<NjRepayOfflineLine> lineData,
							  NjRepayOfflineHistory repayHistory, 
							  List<NjRepayOfflineLineHistory> repayLineHistoryList) throws Exception {
		
		NjRepayOfflineMapper rom = dao.getMapper(NjRepayOfflineMapper.class);
		rom.insert(repay);

		NjRepayOfflineLineMapper rolm = dao.getMapper(NjRepayOfflineLineMapper.class);
		for (NjRepayOfflineLine njRepayOfflineLine : lineData) {
			rolm.insert(njRepayOfflineLine);
		}
		
		NjRepayOfflineHistoryMapper rphm = dao.getMapper(NjRepayOfflineHistoryMapper.class);
		rphm.insert(repayHistory);
		
		NjRepayOfflineLineHistoryMapper rolhm = dao.getMapper(NjRepayOfflineLineHistoryMapper.class);
		for (NjRepayOfflineLineHistory temp : repayLineHistoryList) {
			rolhm.insert(temp);
		}
		
		NjLoanOrderMapper lom = dao.getMapper(NjLoanOrderMapper.class);
		lom.updateByPrimaryKey(lo);
	}
	
	public List<NjRepayOffline> selectByExample(NjRepayOfflineExample example) throws Exception{
		NjRepayOfflineMapper rom = dao.getMapper(NjRepayOfflineMapper.class);
		return rom.selectByExample(example);
	}
	
	public List<NjRepayOfflineLine> selectByExample(NjRepayOfflineLineExample example) throws Exception{
		NjRepayOfflineLineMapper rolm = dao.getMapper(NjRepayOfflineLineMapper.class);
		return rolm.selectByExample(example);
	}
	
	public void update(NjRepayOffline ro,List<NjRepayOfflineLine> updateList) throws Exception{
		if(null != ro){
			NjRepayOfflineMapper rom = dao.getMapper(NjRepayOfflineMapper.class);
			rom.updateByPrimaryKey(ro);
		}
		if(!CollectionUtils.isEmpty(updateList)){
			NjRepayOfflineLineMapper rolm = dao.getMapper(NjRepayOfflineLineMapper.class);
			for (NjRepayOfflineLine rol : updateList) {
				rolm.updateByPrimaryKey(rol);
			}
		}
	}

}
