package com.ganshar.job.dao;

import java.util.List;

import com.ganshar.job.model.Job;
import com.ganshar.job.model.Opportunity;

public interface JobDao {
	
	public Job findJobById(Long jobId);
	
	public Job add(Job job);
	
	public void update(Job job);
	
	public void delete(Long jobId);
	
	public Job findJobByName(String jobName);
	
	public List<Job> findJobListByName(String jobName);

	public  List<Opportunity> findRecommendOpps(String jobname);
}
