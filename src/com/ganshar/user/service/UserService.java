package com.ganshar.user.service;

import com.ganshar.user.model.User;

public interface UserService {
	
	public void addUser(User user);
	
	public User findUserById(Long userId);
	
	public User findUserByEmailPass(String email,String password);
	
}
