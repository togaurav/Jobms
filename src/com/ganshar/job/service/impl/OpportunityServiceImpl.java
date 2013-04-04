package com.ganshar.job.service.impl;

import java.util.List;

import com.ganshar.job.dao.OpportunityDao;
import com.ganshar.job.model.Opportunity;
import com.ganshar.job.service.OpportunityService;

public class OpportunityServiceImpl implements OpportunityService {

	private OpportunityDao opportunityDao;
	
	@Override
	public Opportunity findOpportunityByName(String companyName, String jobName) {
		return this.opportunityDao.findOpportunityByName(companyName, jobName);
	}

	@Override
	public List<Opportunity> findOpportunityListByCompany(String companyName) {
		return this.opportunityDao.findOpportunityListByCompany(companyName);
	}

	@Override
	public Opportunity getOpportunityById(Long oppId) {
		return this.opportunityDao.getOpportunityById(oppId);
	}

	public OpportunityDao getOpportunityDao() {
		return opportunityDao;
	}

	public void setOpportunityDao(OpportunityDao opportunityDao) {
		this.opportunityDao = opportunityDao;
	}

}
