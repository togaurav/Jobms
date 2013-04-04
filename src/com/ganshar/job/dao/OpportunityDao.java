package com.ganshar.job.dao;

import java.util.List;

import com.ganshar.job.model.Opportunity;

public interface OpportunityDao {
	
public Opportunity findOpportunityByName(String companyName,String jobName);
	
	public List<Opportunity> findOpportunityListByCompany(String companyName);
	
	public Opportunity getOpportunityById(Long oppId);
}
