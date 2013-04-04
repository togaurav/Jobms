package com.ganshar.match.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.match.dao.JobCompetencyDao;
import com.ganshar.match.model.JobCompetency;

public class JobCompetencyDaoImpl extends GenericDaoImpl<JobCompetency,Long> implements JobCompetencyDao {

	@Override
	public List<JobCompetency> findJobCompetencyList(Long opportunityId) {
		String hql="from JobCompetency where opportunityId=?";
		return this.findByHql(hql, new Long[]{opportunityId});
	}

	@Override
	public boolean isJobCompetencyExist(Long opportunityId, Long measureId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addJobCompetencyList(List<JobCompetency> jobCompetencyList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delAllJobCompetency(Long opportunityId) {
		// TODO Auto-generated method stub

	}

}
