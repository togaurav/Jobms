package com.ganshar.job.dao;

import java.util.List;

import com.ganshar.job.model.Job;

public interface JobDao {
	
	public Job findJobById(Long jobId);
	
	public void add(Job job);
	
	public void update(Job job);
	
	public void delete(Long jobId);
	
	public Job findJobByName(String jobName);
	
	public List<Job> findJobListByName(String jobName);

}
