package com.ganshar.job.service.impl;

import java.util.List;

import com.ganshar.job.dao.FuncRankGrowthDao;
import com.ganshar.job.model.FuncRankGrowth;
import com.ganshar.job.service.FuncRankGrowthService;

public class FuncRankGrowthServiceImpl implements FuncRankGrowthService {

	private FuncRankGrowthDao funcRankGrowthDao;
	
	@Override
	public Double getGrowthValueByJob(Integer funcRankId, 
			Double servicelen) {
		return funcRankGrowthDao.getGrowthValueByJob(funcRankId, servicelen);
	}

	@Override
	public List<FuncRankGrowth> findFuncRankGrowthListByFuncRankId(
			Integer funcRankId) {
		return null;
	}

	@Override
	public Double getGrowthValueByCompanyType(Integer funcRankId,
			Integer companyType) {
		return this.funcRankGrowthDao.getGrowthValueByCompanyType(funcRankId, companyType);
	}

	@Override
	public Double getGrowthValueByEducation(Integer education) {
		return this.funcRankGrowthDao.getGrowthValueByEducation(education);
	}

	public FuncRankGrowthDao getFuncRankGrowthDao() {
		return funcRankGrowthDao;
	}

	public void setFuncRankGrowthDao(FuncRankGrowthDao funcRankGrowthDao) {
		this.funcRankGrowthDao = funcRankGrowthDao;
	}

}
