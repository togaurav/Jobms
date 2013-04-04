package com.ganshar.job.dao.impl;

import java.util.List;
import java.util.Map;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.MajorAbilityDao;
import com.ganshar.job.model.MajorAbility;

public class MajorAbilityDaoImpl extends GenericDaoImpl<MajorAbility,Long> implements MajorAbilityDao {

	@Override
	public List<MajorAbility> getMajorAbilityList(Integer majorId) {
		String hql="from MajorAbility where majorId=?";
		return this.findByHql(hql, new Integer[]{majorId});
	}

	@Override
	public List<Map> findMajorAbilityMapList(Integer majorId) {
		String hql="select a.name as abilityname,ma.abilityRatio as abilityratio,a.path from MajorAbility ma,Ability a where ma.abilityId=a.id and ma.majorId=?";
		return this.findByHql(hql, new Integer[]{majorId});
	}

}
