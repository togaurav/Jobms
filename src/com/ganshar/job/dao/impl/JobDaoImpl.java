package com.ganshar.job.dao.impl;

import java.util.List;

import com.framework.core.dao.GenericDaoImpl;
import com.ganshar.job.dao.JobDao;
import com.ganshar.job.model.Job;

public class JobDaoImpl extends GenericDaoImpl<Job,Long> implements JobDao {

	@Override
	public Job findJobById(Long jobId) {
		return this.findById(jobId);
	}

	@Override
	public void add(Job job) {
		this.saveEntity(job);
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
		String hql="from Job where jobName like ?";
		List<Job> result=this.findByHql(hql, new String[]{jobName+"%"});
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
	
}
