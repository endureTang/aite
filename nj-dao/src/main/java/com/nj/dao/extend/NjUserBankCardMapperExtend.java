package com.nj.dao.extend;

import org.apache.ibatis.annotations.Param;

import com.nj.model.generate.NjUserBankCard;

public interface NjUserBankCardMapperExtend {

	NjUserBankCard selectByUserId(@Param("userId") String userId,@Param("type") int type);

	void deleteById(@Param("id") String id);

	NjUserBankCard selectUserBindCard(@Param("userId") String userId,@Param("type") int type);

	void deletebyUserId(@Param("userId") String userId);
   
}