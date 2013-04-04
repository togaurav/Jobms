package com.ganshar.job.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.EducateGrowthDao;
import com.ganshar.job.model.EducateGrowth;
import com.ganshar.job.model.FuncRankGrowth;

public class EducateGrowthDaoImpl extends GenericDaoImpl<EducateGrowth,Integer> implements EducateGrowthDao {

	@Override
	public EducateGrowth getEducateGrowthByEducation(Integer education) {
		EducateGrowth result=null;
		String hql="from EducateGrowth where id=?";
		List<EducateGrowth> list=this.findByHql(hql, new Integer[]{education});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

}
