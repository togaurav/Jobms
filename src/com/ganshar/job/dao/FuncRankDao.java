package com.ganshar.job.dao;

import java.util.List;

import com.ganshar.job.model.FuncRank;

public interface FuncRankDao {

	public FuncRank getFuncRankById(Integer funcRankId);
	
	public List<FuncRank> loadFuncRankList();
	
	public Double findConvertValue(Integer curId, Integer tarId);
}
