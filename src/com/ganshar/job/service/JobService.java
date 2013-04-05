package com.ganshar.job.service;

import java.util.List;
import java.util.Map;

import com.ganshar.job.model.Job;
import com.ganshar.job.model.JobAbility;
import com.ganshar.job.model.MajorAbility;
import com.ganshar.job.model.Opportunity;
import com.ganshar.job.web.vo.JobVO;

public interface JobService {
			
	public Job getJobById(Long jobId);
	
	public void addJob(JobVO jobvo);
	
	public void updateJob(JobVO jobvo);
	
	public void deleteJob(Long jobId);
	
	public Job findJobByName(String jobName);
	
	public JobVO findJobVOByName(String jobName);
	
	public List<Job> findJobListByName(String jobName);
	
	public List<JobAbility> findJobAbilityList(Long jobId);
	
	public List<Map> findJobAbilityMapList(Long jobId);
	
	public void addJobAbility(List<JobAbility> jobAbilityList ,Long jobId);
	
	public List<MajorAbility> findMajorAbilityList(Integer majorId);
	
	public List<Map> findMajorAbilityMapList(Integer majorId);
	
	public  List<Opportunity> findRecommendOpps(Long userId);
}
