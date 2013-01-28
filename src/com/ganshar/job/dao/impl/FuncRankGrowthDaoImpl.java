package com.ganshar.job.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.FuncRankGrowthDao;
import com.ganshar.job.model.FuncRankGrowth;

public class FuncRankGrowthDaoImpl extends GenericDaoImpl<FuncRankGrowth,Long> implements FuncRankGrowthDao {

	@Override
	public Double getGrowthValueByJob(Integer funcRankId, Double servicelen) {
		Double result=0.0;
		String hql="select growthValue from FuncRankGrowth where funcRankId=? and growthTypeValue=? and growthType="+FuncRankGrowth.TYPE_WORK_SERVICELEN;
		List<Double> list=this.findByHql(hql, new Object[]{funcRankId,servicelen.intValue()});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public List<FuncRankGrowth> findFuncRankGrowthListByFuncRankId(
			Integer funcRankId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getGrowthValueByCompanyType(Integer funcRankId,
			Integer companyType) {
		Double result=0.0;
		String hql="select growthValue from FuncRankGrowth where funcRankId=? and growthTypeValue=? and growthType="+FuncRankGrowth.TYPE_COMPANY_TYPE;
		List<Double> list=this.findByHql(hql, new Object[]{funcRankId,companyType});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public Double getGrowthValueByEducation(Integer education) {
		Double result=0.0;
		String hql="select growthValue from FuncRankGrowth where funcRankId=? and growthTypeValue=? and growthType="+FuncRankGrowth.TYPE_EDUCATION;
		List<Double> list=this.findByHql(hql, new Object[]{education,education});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}


	
}
