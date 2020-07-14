package com.nj.dao.extend;

import java.util.List;
import java.util.Map;

import com.nj.model.generate.NjAssetGrade;

public interface NjAssetGradeMapperExtend {
	
	List<Map<?, ?>> selectDistinctGrade();

	NjAssetGrade getDefaultGrade();
}