package com.ganshar.job.service;

import java.util.List;

import com.ganshar.job.model.FuncRankGrowth;

public interface FuncRankGrowthService {
	
	public Double getGrowthValueByJob(Integer funcRankId , Double servicelen);
	
	public List<FuncRankGrowth> findFuncRankGrowthListByFuncRankId(Integer funcRankId);
	
	public Double getGrowthValueByCompanyType(Integer funcRankId , Integer companyType);
	
	public Double getGrowthValueByEducation(Integer education);
}
