package com.nj.dao.extend;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nj.model.datamodel.NjUserContactModel;
import com.nj.model.generate.NjUserContact;

public interface NjUserContactMapperExtend {
	public Integer getContactMaxVersion(@Param("userId") String userId);
	
	public void insertContact(List<NjUserContact> contacts);
	
	public List<NjUserContactModel> getUserContact(@Param("userId") String userId);
	
	public Date getLastUploadTime(@Param("userId") String userId);
}
