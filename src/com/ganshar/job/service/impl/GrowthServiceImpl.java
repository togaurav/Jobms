package com.ganshar.job.service.impl;

import java.util.List;

import com.ganshar.job.dao.EducateGrowthDao;
import com.ganshar.job.dao.FuncRankGrowthDao;
import com.ganshar.job.model.EducateGrowth;
import com.ganshar.job.model.FuncRankGrowth;
import com.ganshar.job.service.GrowthService;

public class GrowthServiceImpl implements GrowthService {

	private FuncRankGrowthDao funcRankGrowthDao;
	private EducateGrowthDao educateGrowthDao;
	

	@Override
	public List<FuncRankGrowth> getFuncRankGrowthList(Integer funcRankId) {
		return this.funcRankGrowthDao.getFuncRankGrowthList(funcRankId);
	}

	@Override
	public List<FuncRankGrowth> loadAllFuncRankGrowth() {
		return this.funcRankGrowthDao.loadAllFuncRankGrowth();
	}

	@Override
	public void updateFuncRankGrowth(List<FuncRankGrowth> funcRankGrowthList) {
		this.funcRankGrowthDao.updateFuncRankGrowth(funcRankGrowthList);
	}

	@Override
	public EducateGrowth getEducateGrowthByEducation(Integer education) {
		return this.educateGrowthDao.getEducateGrowthByEducation(education);
	}

	public FuncRankGrowthDao getFuncRankGrowthDao() {
		return funcRankGrowthDao;
	}

	public void setFuncRankGrowthDao(FuncRankGrowthDao funcRankGrowthDao) {
		this.funcRankGrowthDao = funcRankGrowthDao;
	}

	public EducateGrowthDao getEducateGrowthDao() {
		return educateGrowthDao;
	}

	public void setEducateGrowthDao(EducateGrowthDao educateGrowthDao) {
		this.educateGrowthDao = educateGrowthDao;
	}

}
