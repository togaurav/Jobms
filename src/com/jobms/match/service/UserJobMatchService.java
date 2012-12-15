package com.jobms.match.service;

import java.math.BigDecimal;

public interface UserJobMatchService {
	/**
	 * 计算人职匹配度
	 * @param userId
	 * @param jobName
	 * @return BigDecimal
	 */
	public BigDecimal match(Integer userId, String jobName);
}
