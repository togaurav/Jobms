package com.ganshar.resume.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.resume.dao.UserEducateExpDao;
import com.ganshar.resume.model.UserEducateExp;
import com.ganshar.resume.model.UserProjectExp;
import com.ganshar.resume.model.UserWorkExp;

public class UserEducateExpDaoImpl extends GenericDaoImpl<UserEducateExp,Long> implements UserEducateExpDao {

	@Override
	public void add(UserEducateExp userEducateExp) {
		this.saveEntity(userEducateExp);
	}

	@Override
	public void addAll(List<UserEducateExp> userEducateExpList) {
		if(userEducateExpList!=null&&userEducateExpList.size()>0){
			for(UserEducateExp userEducateExp:userEducateExpList){
				this.add(userEducateExp);
			}
		}
	}

	@Override
	public void update(UserEducateExp userEducateExp) {
		this.updateEntity(userEducateExp);
	}

	@Override
	public void delete(Long id) {
		UserEducateExp exp=this.findById(id);
		this.delete(exp);
	}

	@Override
	public List<UserEducateExp> findUserEducateExpListByUserId(Long userId) {
		List<UserEducateExp> result=new ArrayList<UserEducateExp>();
		String hql="from UserEducateExp where userId=? order by endDate desc";
		result=this.findByHql(hql, new Long[]{userId});
		return result;
	}

	@Override
	public UserEducateExp getUserEducateExpById(Long id) {
		return this.findById(id);
	}

	@Override
	public UserEducateExp findUserTopEducateExpByUserId(Long userId) {
		UserEducateExp  result=null;
		String hql="from UserEducateExp where userId=? order by endDate desc limit 1";
		List<UserEducateExp> list=this.findByHql(hql, new Long[]{userId});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	
}
