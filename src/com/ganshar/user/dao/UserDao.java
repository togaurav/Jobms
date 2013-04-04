package com.ganshar.user.dao;

import com.ganshar.user.model.User;

public interface UserDao {

	public void addUser(User user);
	
	public User findUserById(Long userId);
	
	public User findUserByEmailPass(String email,String password);
	
	public User findUserByEmail(String email);
}
