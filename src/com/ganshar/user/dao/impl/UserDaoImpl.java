package com.ganshar.user.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.user.dao.UserDao;
import com.ganshar.user.model.User;

public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	@Override
	public void addUser(User user) {
		this.saveEntity(user);
	}

	@Override
	public User findUserById(Long userId) {
		return this.findById(userId);
	}

	@Override
	public User findUserByEmailPass(String email, String password) {
		User user=null;
		String hql="from User user where user.email=? and user.password=? ";
		String[] values=new String[]{email,password};
		List result=this.findByHql(hql, values);
		if(result!=null&&result.size()>0){
			user=(User)result.get(0);
		}
		return user;
	}

	@Override
	public User findUserByEmail(String email) {
		User user=null;
		String hql="from User user where user.email=?  ";
		String[] values=new String[]{email};
		List result=this.findByHql(hql, values);
		if(result!=null&&result.size()>0){
			user=(User)result.get(0);
		}
		return user;
	}

	@Override
	public void update(User user) {
		this.update(user);
	}

}
