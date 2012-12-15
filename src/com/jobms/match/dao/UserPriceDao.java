package com.jobms.match.dao;

import java.math.BigDecimal;

public interface UserPriceDao {
	/**
	 * 计算人员价值层级
	 * @param userId
	 * @param careerAreaName
	 * @return BigDecimal
	 */
	public BigDecimal compute(Integer userId, String careerAreaName);
}
