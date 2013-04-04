package com.ganshar.job.service;

import java.util.List;

import com.ganshar.job.model.EducateGrowth;
import com.ganshar.job.model.FuncRankGrowth;

public interface GrowthService {
	
	public List<FuncRankGrowth> getFuncRankGrowthList(Integer funcRankId);
	
	public List<FuncRankGrowth> loadAllFuncRankGrowth();
	
	public void updateFuncRankGrowth(List<FuncRankGrowth> funcRankGrowthList);
	
	public EducateGrowth getEducateGrowthByEducation(Integer education);
}
