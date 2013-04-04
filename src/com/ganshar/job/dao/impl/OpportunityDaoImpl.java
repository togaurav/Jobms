package com.ganshar.job.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.OpportunityDao;
import com.ganshar.job.model.EducateGrowth;
import com.ganshar.job.model.FuncRank;
import com.ganshar.job.model.Opportunity;

public class OpportunityDaoImpl   extends GenericDaoImpl<Opportunity,Long>  implements OpportunityDao {

	@Override
	public Opportunity findOpportunityByName(String companyName, String jobName) {
		Opportunity result=null;
		String hql="from Opportunity where companyName =? and jobName=?";
		List<Opportunity> list=this.findByHql(hql, new String[]{companyName,jobName});
		if(list!=null&&list.size()>0){
			result=list.get(0);
		}
		return result;
	}

	@Override
	public List<Opportunity> findOpportunityListByCompany(String companyName) {
		String hql="from Opportunity where companyName =?";
		return this.findByHql(hql, new String[]{companyName});
	}

	@Override
	public Opportunity getOpportunityById(Long oppId) {
		return this.findById(oppId);
	}

}
