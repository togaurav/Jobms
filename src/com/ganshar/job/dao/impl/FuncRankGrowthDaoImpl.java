package com.ganshar.job.dao.impl;

import java.util.Date;
import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.FuncRankGrowthDao;
import com.ganshar.job.model.FuncRankGrowth;

public class FuncRankGrowthDaoImpl extends GenericDaoImpl<FuncRankGrowth,Integer> implements FuncRankGrowthDao {

	@Override
	public  List<FuncRankGrowth> getFuncRankGrowthList(Integer funcRankId) {
		String hql="from FuncRankGrowth where funcRankId=?";
		List<FuncRankGrowth> list=this.findByHql(hql, new Integer[]{funcRankId});
		return list;
	}

	@Override
	public List<FuncRankGrowth> loadAllFuncRankGrowth() {
		String hql="from FuncRankGrowth";
		return this.findByHql(hql, new Integer[]{});
	}

	@Override
	public void updateFuncRankGrowth(List<FuncRankGrowth> funcRankGrowthList) {
		if(funcRankGrowthList!=null&&funcRankGrowthList.size()>0){
			for(FuncRankGrowth funcg:funcRankGrowthList){
				funcg.setUpdateTime(new Date());
				this.updateEntity(funcg);
			}
		}
	}

	@Override
	public FuncRankGrowth findFuncRankGrowth(Integer funcRankId,
			Integer servicelen) {
		FuncRankGrowth result=null;
		String hql="from FuncRankGrowth where funcRankId=? and servicelen=?";
		List<FuncRankGrowth> list=this.findByHql(hql, new Integer[]{funcRankId,servicelen});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public void updateFuncRankGrowth(FuncRankGrowth funcRankGrowth) {
		this.updateEntity(funcRankGrowth);
	}

}
