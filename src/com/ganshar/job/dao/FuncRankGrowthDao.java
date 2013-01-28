package com.ganshar.job.dao;

import java.util.List;

import com.ganshar.job.model.FuncRankGrowth;

public interface FuncRankGrowthDao {

	public Double getGrowthValueByJob(Integer funcRankId , Double servicelen);
	
	public List<FuncRankGrowth> findFuncRankGrowthListByFuncRankId(Integer funcRankId);
	
	public Double getGrowthValueByCompanyType(Integer funcRankId , Integer companyType);
	
	public Double getGrowthValueByEducation(Integer education);
}
