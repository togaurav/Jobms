package com.ganshar.ability.dao.impl;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;

public class AbilityDaoImpl extends GenericDaoImpl<Ability,Long> implements AbilityDao {

	@Override
	public Ability getAbilityById(Long abilityId) {
		return this.findById(abilityId);
	}

}
