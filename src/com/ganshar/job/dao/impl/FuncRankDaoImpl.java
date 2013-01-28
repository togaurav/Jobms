package com.ganshar.job.dao.impl;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.FuncRankDao;
import com.ganshar.job.model.FuncRank;

public class FuncRankDaoImpl  extends GenericDaoImpl<FuncRank,Integer> implements FuncRankDao {

	@Override
	public FuncRank getFuncRankById(Integer funcRankId) {
		return this.findById(funcRankId);
	}

}
