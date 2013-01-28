package com.ganshar.resume.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.resume.dao.UserWorkExpDao;
import com.ganshar.resume.model.UserWorkExp;

public class UserWorkExpDaoImpl extends GenericDaoImpl<UserWorkExp,Long> implements UserWorkExpDao {

	@Override
	public void add(UserWorkExp userWorkExp) {
		this.saveEntity(userWorkExp);
	}

	@Override
	public void update(UserWorkExp userWorkExp) {
		this.updateEntity(userWorkExp);
	}

	@Override
	public void addAll(List<UserWorkExp> userWorkExpList) {
		if(userWorkExpList!=null&&userWorkExpList.size()>0){
			for(UserWorkExp userWorkExp:userWorkExpList){
				this.add(userWorkExp);
			}
		}
		
	}

	@Override
	public void delete(Long id) {
		UserWorkExp userWorkExp=this.findById(id);
		this.delete(userWorkExp);
	}

	@Override
	public List<UserWorkExp> findUserWorkExpListByUserId(Long userId) {
		List<UserWorkExp> result=new ArrayList<UserWorkExp>();
		String hql="from UserWorkExp where userId=? order by ondutyDate desc";
		result=this.findByHql(hql, new Long[]{userId});
		return result;
	}

	@Override
	public void updateAll(List<UserWorkExp> userWorkExpList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserWorkExp getUserWorkExpById(Long id) {
		return this.findById(id);
	}
	
	
}
