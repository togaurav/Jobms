package com.ganshar.job.dao;

import java.util.List;
import java.util.Map;

import com.ganshar.job.model.MajorAbility;

public interface MajorAbilityDao {

	public List<MajorAbility> getMajorAbilityList(Integer majorId);
	
	public List<Map> findMajorAbilityMapList(Integer majorId);
}
