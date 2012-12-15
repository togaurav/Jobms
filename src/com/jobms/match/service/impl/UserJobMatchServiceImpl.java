package com.jobms.match.service.impl;

import java.math.BigDecimal;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.jobms.match.dao.UserJobMatchDao;
import com.jobms.match.service.UserJobMatchService;

public class UserJobMatchServiceImpl implements UserJobMatchService {
	private final static Logger log = LogManager.getLogger(UserJobMatchServiceImpl.class);

	private UserJobMatchDao userJobMatchDao;
	
	@Override
	public BigDecimal match(Integer userId, String jobName) {
		return this.userJobMatchDao.match(userId, jobName);
	}

	public UserJobMatchDao getUserJobMatchDao() {
		return userJobMatchDao;
	}

	public void setUserJobMatchDao(UserJobMatchDao userJobMatchDao) {
		this.userJobMatchDao = userJobMatchDao;
	}
	

}
