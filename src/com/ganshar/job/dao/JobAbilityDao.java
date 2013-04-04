package com.ganshar.job.dao;

import java.util.List;
import java.util.Map;

import com.ganshar.job.model.JobAbility;

public interface JobAbilityDao {

	public List<JobAbility> findJobAbilityList(Long jobId);
	
	public List<Map> findJobAbilityMapList(Long jobId);
	
	public void addJobAbility(JobAbility jobAbility);
	
	public void deleteJobAbilitys(Long jobId);
}
