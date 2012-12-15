package com.jobms.match.dao.impl;

import java.math.BigDecimal;

import com.framework.core.dao.GenericDaoImpl;
import com.jobms.match.dao.JobPriceDao;
import com.jobms.match.proc.JobPriceProc;

public class JobPriceDaoImpl extends GenericDaoImpl<BigDecimal, String> implements JobPriceDao  {

	@Override
	public BigDecimal compute(String jobName) {
		JobPriceProc jobSP=new JobPriceProc(super.getJdbcTemplate());
		BigDecimal jobPrice=jobSP.exec(jobName);
		return jobPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
