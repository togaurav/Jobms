package com.ganshar.resume.dao;

import java.util.List;

import com.ganshar.resume.model.UserAbility;

public interface UserAbilityDao {
	
	public void add(UserAbility userAbility);
	
	public void addAll(List<UserAbility> userAbility);
	
	public void update(UserAbility userAbility);
	
	public void delete(Long id);
		
	public List<UserAbility> findUserAbilityListByUserId(Long userId);
	
}
