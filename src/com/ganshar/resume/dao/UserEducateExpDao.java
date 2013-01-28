package com.ganshar.resume.dao;

import java.util.List;

import com.ganshar.resume.model.UserEducateExp;

public interface UserEducateExpDao {
	
	public void add(UserEducateExp userEducateExp);
	
	public void addAll(List<UserEducateExp> userEducateExpList);
		
	public void update(UserEducateExp userEducateExp);
	
	public void delete(Long id);
	
	public UserEducateExp getUserEducateExpById(Long id);
		
	public List<UserEducateExp> findUserEducateExpListByUserId(Long userId);

	public UserEducateExp findUserTopEducateExpByUserId(Long userId);
}
