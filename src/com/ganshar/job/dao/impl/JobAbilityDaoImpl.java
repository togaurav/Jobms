package com.ganshar.job.dao.impl;

import java.util.List;
import java.util.Map;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.JobAbilityDao;
import com.ganshar.job.model.JobAbility;

public class JobAbilityDaoImpl  extends GenericDaoImpl<JobAbility,Long> implements   JobAbilityDao{

	@Override
	public List<JobAbility> findJobAbilityList(Long jobId) {
		String hql="from JobAbility where jobId=?";
		return this.findByHql(hql, new Long[]{jobId});
	}

	@Override
	public List<Map> findJobAbilityMapList(Long jobId) {
		String hql="select a.name as abilityname,ja.abilityRatio as abilityratio,a.path from JobAbility ja,Ability a where ja.abilityId=a.id and  ja.jobId=?";
		return this.findByHql(hql, new Long[]{jobId});
	}

	@Override
	public void addJobAbility(JobAbility jobAbility) {
		this.saveEntity(jobAbility);
	}

	@Override
	public void deleteJobAbilitys(Long jobId) {
		String hql="delete from JobAbility where jobId=?";
		this.execute(hql, new Long[]{jobId});
	}

}
