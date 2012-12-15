package com.jobms.match.dao;

import java.math.BigDecimal;

public interface UserJobMatchDao {
	/**
	 * 计算人职匹配度
	 * @param userId
	 * @param jobName
	 * @return BigDecimal
	 */
	public BigDecimal match(Integer userId, String jobName);
}
