package com.ganshar.resume.dao;

import com.ganshar.resume.model.UserJobIntent;


public interface UserJobIntentDao {
	
	public void add(UserJobIntent userJobIntent);
		
	public void update(UserJobIntent userJobIntent);
	
	public void delete(Long id);
		
	public UserJobIntent findUserJobIntentByUserId(Long userId);
	
}
