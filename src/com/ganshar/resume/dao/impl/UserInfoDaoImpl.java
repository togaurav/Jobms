package com.ganshar.resume.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.resume.dao.UserInfoDao;
import com.ganshar.resume.model.UserInfo;

public class UserInfoDaoImpl extends GenericDaoImpl<UserInfo,Long> implements UserInfoDao {

	@Override
	public void add(UserInfo userInfo) {
		this.saveEntity(userInfo);
	}

	@Override
	public void update(UserInfo userInfo) {
		this.updateEntity(userInfo);
	}

	@Override
	public UserInfo findUserInfoByUserId(Long userId) {
		String hql="from UserInfo ur where ur.userId=?";
		List<UserInfo> result=this.findByHql(hql, new Long[]{userId});
		UserInfo userInfo=null;
		if(result!=null&&result.size()>0){
			userInfo=(UserInfo)result.get(0);
		}
		return userInfo;
	}
	
	
}
