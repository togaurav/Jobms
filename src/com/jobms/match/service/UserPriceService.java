package com.jobms.match.service;

import java.math.BigDecimal;

public interface UserPriceService {
	/**
	 * 计算人员价值层级
	 * @param userId
	 * @param careerAreaName
	 * @return BigDecimal
	 */
	public BigDecimal compute(Integer userId, String careerAreaName);
}
