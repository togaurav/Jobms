package com.ganshar.resume.dao;

import com.ganshar.resume.model.UserInfo;

public interface UserInfoDao {
	
	public void add(UserInfo userInfo);
	
	public void update(UserInfo userInfo);
	
	public UserInfo findUserInfoByUserId(Long userId);
	
}
