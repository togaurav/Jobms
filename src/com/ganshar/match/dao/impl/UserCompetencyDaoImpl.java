package com.ganshar.match.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.match.dao.UserCompetencyDao;
import com.ganshar.match.model.UserCompetency;

public class UserCompetencyDaoImpl extends GenericDaoImpl<UserCompetency,Long> implements UserCompetencyDao {

	@Override
	public List<UserCompetency> findUserCompetencyListByUserId(Long userId) {
		String hql="from UserCompetency where userId=?";
		return this.findByHql(hql, new Long[]{userId});
	}

	@Override
	public boolean isUserCompetencyExist(Long userId, Long measureId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addUserCompetencyList(List<UserCompetency> userCompetencyList) {
		if(userCompetencyList!=null&&userCompetencyList.size()>0){
			for(UserCompetency uc:userCompetencyList){
				this.saveEntity(uc);
			}
		}
	}

	@Override
	public void delAllUserCompetencyByUserId(Long userId) {
		String hql="delete from UserCompetency where userId=?";
		this.execute(hql, new Long[]{userId});
	}

}
