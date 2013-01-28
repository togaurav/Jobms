package com.ganshar.match.dao;

import java.util.List;

import com.ganshar.match.model.UserCompetency;

public interface UserCompetencyDao {
	
	public List<UserCompetency> findUserCompetencyListByUserId(Long userId);
	
	public boolean isUserCompetencyExist(Long userId,Long measureId);
	
	public void addUserCompetencyList(List<UserCompetency> userCompetencyList);
	
	public void delAllUserCompetencyByUserId(Long userId);
	
	
}
