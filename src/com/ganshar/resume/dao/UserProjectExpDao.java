package com.ganshar.resume.dao;

import java.util.List;

import com.ganshar.resume.model.UserProjectExp;

public interface UserProjectExpDao {
	
	public void add(UserProjectExp userProjectExp);
	
	public void addAll(List<UserProjectExp> userProjectExpList);
	
	public void update(UserProjectExp userProjectExp);
	
	public void delete(Long id);
		
	public List<UserProjectExp> findUserProjectExpListByUserId(Long userId);
	
}
