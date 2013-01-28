package com.ganshar.job.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.JobAbilityDao;
import com.ganshar.job.model.JobAbility;

public class JobAbilityDaoImpl  extends GenericDaoImpl<JobAbility,Long> implements   JobAbilityDao{

	@Override
	public List<JobAbility> findJobAbilityList(Long jobId) {
		String hql="from JobAbility where jobId=?";
		return this.findByHql(hql, new Long[]{jobId});
	}

}
