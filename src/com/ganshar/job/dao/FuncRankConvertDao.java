package com.ganshar.job.dao;

import com.ganshar.job.model.FuncRankConvert;

public interface FuncRankConvertDao {

	public FuncRankConvert findFuncRankConvert(Integer curId,Integer tarId);
	
	public void updateFuncRankConvert(FuncRankConvert funcRankConvert);
	
	public void addFuncRankConvert(FuncRankConvert funcRankConvert);
}
