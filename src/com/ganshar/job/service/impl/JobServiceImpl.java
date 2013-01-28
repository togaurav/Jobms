package com.ganshar.job.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.ganshar.job.dao.JobAbilityDao;
import com.ganshar.job.dao.JobDao;
import com.ganshar.job.model.Job;
import com.ganshar.job.model.JobAbility;
import com.ganshar.job.service.JobService;
import com.ganshar.job.web.vo.JobVO;

public class JobServiceImpl implements JobService {
	
	private JobDao jobDao;
	private JobAbilityDao jobAbilityDao;
	
	public JobDao getJobDao() {
		return jobDao;
	}


	public void setJobDao(JobDao jobDao) {
		this.jobDao = jobDao;
	}


	@Override
	public Job getJobById(Long jobId) {
		return this.jobDao.findJobById(jobId);
	}


	@Override
	public void addJob(JobVO jobvo) {
		Job job=new Job();
		BeanUtils.copyProperties(jobvo, job);
		this.jobDao.add(job);
	}


	@Override
	public void updateJob(JobVO jobvo) {
		Job job=new Job();
		BeanUtils.copyProperties(jobvo, job);
		this.jobDao.update(job);
	}


	@Override
	public void deleteJob(Long jobId) {
		this.jobDao.delete(jobId);
	}


	@Override
	public List<JobAbility> findJobAbilityList(Long jobId) {
		return this.jobAbilityDao.findJobAbilityList(jobId);
	}


	@Override
	public void addJobAbility(List<JobAbility> jobAbilityList) {
		
	}


	@Override
	public Job findJobByName(String jobName) {
		return this.jobDao.findJobByName(jobName);
	}


	@Override
	public List<Job> findJobListByName(String jobName) {
		return this.jobDao.findJobListByName(jobName);
	}


	public JobAbilityDao getJobAbilityDao() {
		return jobAbilityDao;
	}


	public void setJobAbilityDao(JobAbilityDao jobAbilityDao) {
		this.jobAbilityDao = jobAbilityDao;
	}

	
}
