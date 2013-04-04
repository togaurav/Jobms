package com.ganshar.job.service.impl;

import java.util.Date;
import java.util.List;

import com.ganshar.job.dao.FuncRankConvertDao;
import com.ganshar.job.dao.FuncRankDao;
import com.ganshar.job.dao.FuncRankGrowthDao;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.FuncRankConvert;
import com.ganshar.job.model.FuncRankGrowth;
import com.ganshar.job.service.FuncRankService;

public class FuncRankServiceImpl implements FuncRankService {

	private FuncRankDao funcRankDao;
	private FuncRankGrowthDao funcRankGrowthDao;
	private FuncRankConvertDao funcRankConvertDao;
	
	@Override
	public FuncRank getFuncRankById(Integer funcRankId) {
		return this.funcRankDao.getFuncRankById(funcRankId);
	}

	@Override
	public List<FuncRank> loadFuncRankList() {
		return this.funcRankDao.loadFuncRankList();
	}

	@Override
	public Double findConvertValue(Integer curId, Integer tarId) {
		return this.funcRankDao.findConvertValue(curId, tarId);
	}

	@Override
	public FuncRankGrowth findFuncRankGrowth(Integer funcRankId,
			Integer servicelen) {
		return this.funcRankGrowthDao.findFuncRankGrowth(funcRankId, servicelen);
	}

	@Override
	public void updateFuncRankGrowth(FuncRankGrowth funcRankGrowth) {
		this.funcRankGrowthDao.updateFuncRankGrowth(funcRankGrowth);
	}

	@Override
	public void updateFuncRankConvert(FuncRankConvert funcRankConvert) {
		this.funcRankConvertDao.updateFuncRankConvert(funcRankConvert);
	}

	@Override
	public FuncRankConvert findFuncRankConvert(Integer curId, Integer tarId) {
		return this.funcRankConvertDao.findFuncRankConvert(curId, tarId);
	}

	@Override
	public void addFuncRankConvert(FuncRankConvert funcRankConvert) {
		funcRankConvert.setAddTime(new Date());
		this.funcRankConvertDao.addFuncRankConvert(funcRankConvert);
	}

	public FuncRankDao getFuncRankDao() {
		return funcRankDao;
	}

	public void setFuncRankDao(FuncRankDao funcRankDao) {
		this.funcRankDao = funcRankDao;
	}

	public FuncRankGrowthDao getFuncRankGrowthDao() {
		return funcRankGrowthDao;
	}

	public void setFuncRankGrowthDao(FuncRankGrowthDao funcRankGrowthDao) {
		this.funcRankGrowthDao = funcRankGrowthDao;
	}

	public FuncRankConvertDao getFuncRankConvertDao() {
		return funcRankConvertDao;
	}

	public void setFuncRankConvertDao(FuncRankConvertDao funcRankConvertDao) {
		this.funcRankConvertDao = funcRankConvertDao;
	}

}
