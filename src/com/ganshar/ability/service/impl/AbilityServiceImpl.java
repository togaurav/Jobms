package com.ganshar.ability.service.impl;

import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;
import com.ganshar.ability.service.AbilityService;

public class AbilityServiceImpl implements AbilityService {

	private AbilityDao abilityDao;
	
	@Override
	public Ability getAbilityById(Long abilityId) {
		// TODO Auto-generated method stub
		return null;
	}

	public AbilityDao getAbilityDao() {
		return abilityDao;
	}

	public void setAbilityDao(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}

}
