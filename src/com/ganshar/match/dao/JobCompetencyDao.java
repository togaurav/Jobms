package com.ganshar.match.dao;

import java.util.List;

import com.ganshar.match.model.JobCompetency;

public interface JobCompetencyDao {
	
	public List<JobCompetency> findJobCompetencyList(Long opportunityId);
	
	public boolean isJobCompetencyExist(Long opportunityId,Long measureId);
	
	public void addJobCompetencyList(List<JobCompetency> jobCompetencyList);
	
	public void delAllJobCompetency(Long opportunityId);
	
}
