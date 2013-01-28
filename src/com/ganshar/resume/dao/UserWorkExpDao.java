package com.ganshar.resume.dao;

import java.util.List;

import com.ganshar.resume.model.UserWorkExp;

public interface UserWorkExpDao {
	
	public void add(UserWorkExp userWorkExp);
	
	public void addAll(List<UserWorkExp> userWorkExpList);
	
	public void update(UserWorkExp userWorkExp);
	
	public void updateAll(List<UserWorkExp> userWorkExpList);
	
	public void delete(Long id);
		
	public UserWorkExp getUserWorkExpById(Long id);
	
	public List<UserWorkExp> findUserWorkExpListByUserId(Long userId);
	
}
