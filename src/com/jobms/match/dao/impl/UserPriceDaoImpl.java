package com.jobms.match.dao.impl;

import java.math.BigDecimal;

import com.framework.core.dao.GenericDaoImpl;
import com.jobms.match.dao.UserPriceDao;
import com.jobms.match.proc.UserPriceProc;

public class UserPriceDaoImpl extends GenericDaoImpl<BigDecimal, Integer> implements UserPriceDao  {

	@Override
	public BigDecimal compute(Integer userid,String careerAreaName) {
		UserPriceProc userSP=new UserPriceProc(super.getJdbcTemplate());
		BigDecimal jobPrice=userSP.exec(userid, careerAreaName);
		return jobPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
