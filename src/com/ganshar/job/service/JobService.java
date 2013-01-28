package com.ganshar.job.service;

import java.util.List;

import com.ganshar.job.model.Job;
import com.ganshar.job.model.JobAbility;
import com.ganshar.job.web.vo.JobVO;

public interface JobService {
			
	public Job getJobById(Long jobId);
	
	public void addJob(JobVO jobvo);
	
	public void updateJob(JobVO jobvo);
	
	public void deleteJob(Long jobId);
	
	public Job findJobByName(String jobName);
	
	public List<Job> findJobListByName(String jobName);
	
	public List<JobAbility> findJobAbilityList(Long jobId);
	
	public void addJobAbility(List<JobAbility> jobAbilityList );
	
}
