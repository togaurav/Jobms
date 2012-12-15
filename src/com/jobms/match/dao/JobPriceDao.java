package com.jobms.match.dao;

import java.math.BigDecimal;

public interface JobPriceDao  {
	/**
	 * 计算职位价值层级
	 * @param jobName
	 * @return
	 */
	public   BigDecimal  compute(String jobName);
}
