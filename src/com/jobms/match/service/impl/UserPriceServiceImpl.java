package com.jobms.match.service.impl;

import java.math.BigDecimal;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jobms.match.dao.UserPriceDao;
import com.jobms.match.service.UserPriceService;

public class UserPriceServiceImpl implements UserPriceService {
	private final static Logger log = LogManager.getLogger(UserPriceServiceImpl.class);

	private UserPriceDao userPriceDao;
	
	@Override
	public BigDecimal compute(Integer userId, String careerAreaName) {
		return this.userPriceDao.compute(userId, careerAreaName);
	}

	public UserPriceDao getUserPriceDao() {
		return userPriceDao;
	}

	public void setUserPriceDao(UserPriceDao userPriceDao) {
		this.userPriceDao = userPriceDao;
	}

}
