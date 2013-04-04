package com.ganshar.job.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.FuncRankDao;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.FuncRankConvert;

public class FuncRankDaoImpl  extends GenericDaoImpl<FuncRank,Integer> implements FuncRankDao {

	@Override
	public FuncRank getFuncRankById(Integer funcRankId) {
		return this.findById(funcRankId);
	}

	@Override
	public List<FuncRank> loadFuncRankList() {
		String hql="from FuncRank ";
		return this.findByHql(hql, new Object[]{});
	}

	@Override
	public Double findConvertValue(Integer curId, Integer tarId) {
		Double result=null;
		String hql="from FuncRankConvert where curFuncRankId=? and tarFuncRankId=?";
		List<FuncRankConvert> list=this.findByHql(hql, new Integer[]{curId,tarId});
		if(list!=null&&list.size()>0){
			FuncRankConvert fc=list.get(0);
			result=fc.getConvertRatio();
		}
		return result;
	}

}
