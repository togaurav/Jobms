package com.ganshar.job.service;

import java.util.List;

import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.FuncRankConvert;
import com.ganshar.job.model.FuncRankGrowth;

public interface FuncRankService {
	
	public FuncRank getFuncRankById(Integer funcRankId);
	
	public List<FuncRank> loadFuncRankList();
	
	public Double findConvertValue(Integer curId,Integer tarId);
	
	public FuncRankGrowth findFuncRankGrowth(Integer funcRankId, Integer servicelen);
	
	public void updateFuncRankGrowth(FuncRankGrowth funcRankGrowth);
	
	public FuncRankConvert findFuncRankConvert(Integer curId,Integer tarId);
	
	public void updateFuncRankConvert(FuncRankConvert funcRankConvert);
	
	public void addFuncRankConvert(FuncRankConvert funcRankConvert);
}
