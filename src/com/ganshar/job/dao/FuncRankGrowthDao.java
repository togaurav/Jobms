package com.ganshar.job.dao;

import java.util.List;

import com.ganshar.job.model.FuncRankGrowth;

public interface FuncRankGrowthDao {

	public  List<FuncRankGrowth> getFuncRankGrowthList(Integer funcRankId);
	
	public List<FuncRankGrowth> loadAllFuncRankGrowth();
	
	public void updateFuncRankGrowth(List<FuncRankGrowth> funcRankGrowthList);
	
	public FuncRankGrowth findFuncRankGrowth(Integer funcRankId, Integer servicelen);
	
	public void updateFuncRankGrowth(FuncRankGrowth funcRankGrowth);
}
