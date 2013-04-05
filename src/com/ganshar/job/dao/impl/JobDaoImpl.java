package com.ganshar.job.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.framework.core.vo.PagineBean;
import com.ganshar.job.dao.JobDao;
import com.ganshar.job.model.Job;
import com.ganshar.job.model.Opportunity;

public class JobDaoImpl extends GenericDaoImpl<Job,Long> implements JobDao {

	@Override
	public Job findJobById(Long jobId) {
		return this.findById(jobId);
	}

	@Override
	public Job add(Job job) {
		this.saveEntity(job);
		return job;
	}

	@Override
	public void update(Job job) {
		this.updateEntity(job);
	}

	@Override
	public void delete(Long jobId) {
		Job job=this.findById(jobId);
		if(job!=null){
			this.delete(job);
		}
	}

	@Override
	public Job findJobByName(String jobName) {
		Job job=null;
		String hql="from Job where jobName= ?";
		List<Job> result=this.findByHql(hql, new String[]{jobName});
		if(result!=null&&result.size()>0){
			job=result.get(0);
		}
		
		return job;
	}

	@Override
	public List<Job> findJobListByName(String jobName) {
		String hql="from Job where jobName like ?";
		List<Job> result=this.findByHql(hql, new String[]{jobName+"%"});
		return result;
	}

	@Override
	public List<Opportunity> findRecommendOpps(String jobname) {
		List<Opportunity> result=new ArrayList<Opportunity>();
		String hql="from Opportunity where jobName like ? ";
		PagineBean resobj=this.pagineByHQL(hql, new String[]{jobname+"%"},1L,5L);
		if(resobj!=null){
			List list=resobj.getDataList();
			if(list!=null&&list.size()>0){
				for(Object obj:list){
					result.add((Opportunity)obj);
				}
			}
		}
		return result;
	}
	
}
