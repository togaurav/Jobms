package com.ganshar.match.service;

import java.util.List;

import com.ganshar.match.model.UserCompetency;
import com.ganshar.match.web.vo.CompetencyChartVO;

public interface UserCompetencyService {

	public List<UserCompetency> findUserCompetencyListByUserId(Long userId);
	
	public void addUserCompetencyList(List<UserCompetency> userCompetencyList, Long userid);
	
	public List<CompetencyChartVO> findUserCompetencyChartVOList(Long userId) ;
	
	public void updateUserCompetency(Long userId);
}
