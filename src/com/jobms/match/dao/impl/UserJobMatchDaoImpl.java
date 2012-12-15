package com.jobms.match.dao.impl;

import java.math.BigDecimal;

import com.framework.core.dao.GenericDaoImpl;
import com.jobms.match.dao.UserJobMatchDao;
import com.jobms.match.proc.UserJobMatchProc;

public class UserJobMatchDaoImpl extends GenericDaoImpl<BigDecimal, Integer> implements UserJobMatchDao  {

	@Override
	public BigDecimal match(Integer userid,String jobName) {
		UserJobMatchProc SP=new UserJobMatchProc(super.getJdbcTemplate());
		BigDecimal jobPrice=SP.exec(userid, jobName);
		if(jobPrice!=null){
			return jobPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}else{
			return new BigDecimal(0.0) ;
		}
	}

}
