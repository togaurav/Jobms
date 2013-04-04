package com.ganshar.match.service;

import java.util.List;

import com.ganshar.match.model.JobCompetency;
import com.ganshar.match.web.vo.CompetencyChartVO;

public interface JobCompetencyService {

	public List<JobCompetency> findJobCompetencyList(Long opportunityId);
	
	public void addJobCompetencyList( List<JobCompetency> jobCompetencyList);
	
	public List<CompetencyChartVO> findCompetencyChartVOList(Long opportunityId) ;
	
}
