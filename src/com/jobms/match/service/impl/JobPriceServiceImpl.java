package com.jobms.match.service.impl;

import java.math.BigDecimal;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jobms.match.dao.JobPriceDao;
import com.jobms.match.service.JobPriceService;

public class JobPriceServiceImpl implements JobPriceService {
	private final static Logger log = LogManager.getLogger(JobPriceServiceImpl.class);
	
	private JobPriceDao jobPriceDao;
	
	@Override
	public BigDecimal compute(String jobName) {
		return this.jobPriceDao.compute(jobName);
	}

	public JobPriceDao getJobPriceDao() {
		return jobPriceDao;
	}

	public void setJobPriceDao(JobPriceDao jobPriceDao) {
		this.jobPriceDao = jobPriceDao;
	}

}
