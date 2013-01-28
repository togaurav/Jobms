package com.ganshar.job.service.impl;

import com.ganshar.job.dao.FuncRankDao;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.service.FuncRankService;

public class FuncRankServiceImpl implements FuncRankService {

	private FuncRankDao funcRankDao;
	
	@Override
	public FuncRank getFuncRankById(Integer funcRankId) {
		return this.funcRankDao.getFuncRankById(funcRankId);
	}

	public FuncRankDao getFuncRankDao() {
		return funcRankDao;
	}

	public void setFuncRankDao(FuncRankDao funcRankDao) {
		this.funcRankDao = funcRankDao;
	}

}
