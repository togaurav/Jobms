package com.ganshar.job.service;

import java.util.List;

import com.ganshar.job.model.Opportunity;

public interface OpportunityService {

	public Opportunity findOpportunityByName(String companyName,String jobName);
	
	public List<Opportunity> findOpportunityListByCompany(String companyName);
	
	public Opportunity getOpportunityById(Long oppId);
	
}
