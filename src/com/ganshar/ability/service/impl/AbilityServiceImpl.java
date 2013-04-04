package com.ganshar.ability.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ganshar.ability.dao.AbilityDao;
import com.ganshar.ability.model.Ability;
import com.ganshar.ability.service.AbilityService;

public class AbilityServiceImpl implements AbilityService {

	private AbilityDao abilityDao;
	
	@Override
	public Ability getAbilityById(Long abilityId) {
		return this.abilityDao.getAbilityById(abilityId);
	}
	
	@Override
	public List<Ability> findAbilityList() {
		return this.abilityDao.findAbilityList();
	}

	@Override
	public Ability getAbilityByName(String abilityName) {
		return this.abilityDao.getAbilityByName(abilityName);
	}

	@Override
	public List<String> findAbilityListByName(String abilityName) {
		List<String> result=new ArrayList<String>();
		List<Ability> list=this.abilityDao.findAbilityListByName(abilityName);
		if(list!=null&&list.size()>0){
			for(Ability a:list){
				result.add(a.getName());
			}
		}
		return result;
	}

	@Override
	public List<Ability> findFirstLevelAbilitys() {
		return this.abilityDao.findFirstLevelAbilitys();
	}

	@Override
	public List<Ability> findSecondLevelAbilitys(String path) {
		return this.abilityDao.findSecondLevelAbilitys(path);
	}

	@Override
	public List<Ability> findThirdLevelAbilitys(String path) {
		return this.abilityDao.findThirdLevelAbilitys(path);
	}

	@Override
	public List<Ability> findForthLevelAbilitys(String path) {
		return this.abilityDao.findForthLevelAbilitys(path);
	}

	@Override
	public void addAbility(String abilityname, String parentPath, Integer level) {
		this.abilityDao.addAbility(abilityname, parentPath, level);
	}

	@Override
	public void deleteAbility(String path) {
		this.abilityDao.deleteAbility(path);
	}

	public AbilityDao getAbilityDao() {
		return abilityDao;
	}

	public void setAbilityDao(AbilityDao abilityDao) {
		this.abilityDao = abilityDao;
	}

}
