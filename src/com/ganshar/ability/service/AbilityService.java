package com.ganshar.ability.service;

import java.util.List;

import com.ganshar.ability.model.Ability;

public interface AbilityService {

	public Ability getAbilityById(Long abilityId);
	
	public Ability getAbilityByName(String abilityName);
	
	public List<Ability> findAbilityList();
	
	public List<String> findAbilityListByName(String abilityName);
	
	public List<Ability> findFirstLevelAbilitys();
	
	public List<Ability> findSecondLevelAbilitys(String path);
	
	public List<Ability> findThirdLevelAbilitys(String path);
	
	public List<Ability> findForthLevelAbilitys(String path);
	
	public void addAbility(String abilityname,String parentPath,Integer level);
	
	public void deleteAbility(String path);
	
}
