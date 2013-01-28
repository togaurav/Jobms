package com.ganshar.user.service.impl;

import com.ganshar.user.dao.UserDao;
import com.ganshar.user.model.User;
import com.ganshar.user.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	
	@Override
	public void addUser(User user) {
		this.userDao.addUser(user);
	}

	@Override
	public User findUserById(Long userId) {
		return this.userDao.findUserById(userId);
	}

	@Override
	public User findUserByEmailPass(String email, String password) {
		return this.userDao.findUserByEmailPass(email, password);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
