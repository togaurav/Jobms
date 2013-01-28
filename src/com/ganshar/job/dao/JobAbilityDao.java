package com.ganshar.job.dao;

import java.util.List;

import com.ganshar.job.model.JobAbility;

public interface JobAbilityDao {

	public List<JobAbility> findJobAbilityList(Long jobId);
	
}
