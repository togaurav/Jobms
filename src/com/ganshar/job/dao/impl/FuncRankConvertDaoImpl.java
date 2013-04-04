package com.ganshar.job.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.FuncRankConvertDao;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.FuncRankConvert;
import com.ganshar.job.model.FuncRankGrowth;

public class FuncRankConvertDaoImpl  extends GenericDaoImpl<FuncRankConvert,Integer> implements FuncRankConvertDao {

	@Override
	public void updateFuncRankConvert(FuncRankConvert funcRankConvert) {
		this.updateEntity(funcRankConvert);
	}

	@Override
	public FuncRankConvert findFuncRankConvert(Integer curId, Integer tarId) {
		FuncRankConvert result=null;
		String hql="from FuncRankConvert where curFuncRankId=? and tarFuncRankId=?";
		List<FuncRankConvert> list=this.findByHql(hql, new Integer[]{curId,tarId});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public void addFuncRankConvert(FuncRankConvert funcRankConvert) {
		this.saveEntity(funcRankConvert);
	}


}
