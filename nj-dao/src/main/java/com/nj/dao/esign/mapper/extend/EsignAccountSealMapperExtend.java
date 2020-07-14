package com.nj.dao.esign.mapper.extend;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.esign.base.EsignAccountSeal;

public interface EsignAccountSealMapperExtend {
   
	public List<EsignAccountSeal> getPerSeal(@Param("userId")String userId);
	
	public List<EsignAccountSeal> getCopoSeal(@Param("coporateId")String coporateId,@Param("acctType")int acctType);
}